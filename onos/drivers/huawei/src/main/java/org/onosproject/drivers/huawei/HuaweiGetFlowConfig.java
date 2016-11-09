/*
 * Copyright 2016-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.onosproject.drivers.huawei;

import org.apache.commons.lang3.tuple.Pair;
import org.onlab.packet.IpAddress;
import org.onlab.packet.IpPrefix;
import org.onosproject.net.DeviceId;
import org.onosproject.net.PortNumber;
import org.onosproject.net.driver.AbstractHandlerBehaviour;
import org.onosproject.net.flow.DefaultFlowRule;
import org.onosproject.net.flow.DefaultTrafficSelector;
import org.onosproject.net.flow.DefaultTrafficTreatment;
import org.onosproject.net.flow.FlowRule;
import org.onosproject.net.flow.TrafficSelector;
import org.onosproject.net.flow.TrafficTreatment;
import org.onosproject.net.flow.criteria.Criteria;
import org.onosproject.netconf.NetconfController;
import org.onosproject.netconf.NetconfException;
import org.onosproject.netconf.NetconfSession;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.AclOpParam;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.QosOpParam;
import org.onosproject.yms.ych.YangCodecHandler;
import org.onosproject.yms.ych.YangProtocolEncodingFormat;
import org.onosproject.yms.ydt.YmsOperationType;
import org.onosproject.yms.ymsm.YmsService;
import org.slf4j.Logger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.onosproject.drivers.huawei.AclGenerator.getAclStringForGetOp;
import static org.onosproject.drivers.huawei.PolicyGenerator.getPolicyStringForGetOp;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Implementation to get and set parameters available in vOLT
 * through the Netconf protocol.
 */
public class HuaweiGetFlowConfig extends AbstractHandlerBehaviour
        implements GetFlowConfig {

    private final Logger log = getLogger(HuaweiGetFlowConfig.class);


    @Override
    public List<FlowRule> getFlows(DeviceId deviceId) {

        List<FlowRule> rules = new LinkedList<>();
        FlowIdCache cache = handler().get(FlowIdCache.class);
        YmsService ymsService = handler().get(YmsService.class);

        YangCodecHandler yangCodecHandler = ymsService.getYangCodecHandler();

        yangCodecHandler.addDeviceSchema(AclOpParam.class);
        yangCodecHandler.addDeviceSchema(QosOpParam.class);

        NetconfController controller = checkNotNull(handler()
                                                            .get(NetconfController.class));

        NetconfSession session = controller.getDevicesMap().get(handler()
                                                                        .data()
                                                                        .deviceId())
                .getSession();
        String reply = null;


        try {
            reply = session.requestSync(getPolicyStringForGetOp());
        } catch (NetconfException e) {
            log.error("Failed to configure acl.", e);
        }

        String strPolicy = null;
        List<Object> objectList = null;
        objectList = yangCodecHandler.decode(reply, YangProtocolEncodingFormat
                                                     .XML,
                                             YmsOperationType.QUERY_CONFIG_REQUEST);


        Iterator<Object> iterator = objectList.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            if (object.getClass().getSimpleName().equals("QosOpParam")) {
                QosOpParam qosOpParam = (QosOpParam) object;
                //qosOpParam.qosCbQos().qosClassifiers().qosClassifier().get(0).classifierName();

                strPolicy =
                        qosOpParam.qosCbQos().qosPolicys().qosPolicy().get(0)
                                .policyName();

                Pair<Integer, Integer> lookup = cache.get(strPolicy);
                if (lookup == null) {
                    continue;
                }

                String replyAcl;

                try {
                    replyAcl = session.requestSync(
                            getAclStringForGetOp(lookup.getRight().intValue()));
                } catch (NetconfException e) {
                    log.error("Failed to configure acl.", e);
                    return null;
                }

                List<Object> objectAclList = null;
                objectAclList = yangCodecHandler
                        .decode(replyAcl, YangProtocolEncodingFormat
                                        .XML,
                                YmsOperationType.QUERY_CONFIG_REPLY);

                Iterator<Object> iteratorAcl = objectAclList.iterator();
                TrafficSelector selector = null;

                while (iteratorAcl.hasNext()) {
                    Object objectAcl = iteratorAcl.next();
                    if (objectAcl.getClass().getSimpleName()
                            .equals("AclOpParam")) {
                        AclOpParam aclOpParam = (AclOpParam) objectAcl;

                        IpPrefix ipv4PrefixSrc
                                = IpPrefix.valueOf(IpAddress.valueOf(
                                aclOpParam.aclGroups().aclGroup().get(0)
                                        .aclRuleAdv4s().aclRuleAdv4().get(0)
                                        .aclSourceIp()), 32);

                        IpPrefix ipv4PrefixDst
                                = IpPrefix.valueOf(IpAddress.valueOf(
                                aclOpParam.aclGroups().aclGroup().get(0)
                                        .aclRuleAdv4s().aclRuleAdv4().get(0)
                                        .aclDestIp()), 32);
                        selector = DefaultTrafficSelector.builder()
                                .add(Criteria.matchIPProtocol(
                                        aclOpParam.aclGroups().aclGroup().get(0)
                                                .aclRuleAdv4s().aclRuleAdv4()
                                                .get(0).aclProtocol()))
                                .add(Criteria.matchIPSrc(ipv4PrefixSrc))
                                .add(Criteria.matchIPDst(ipv4PrefixDst))
                                .build();
                    }
                }

                TrafficTreatment treatment = DefaultTrafficTreatment.builder()
                        .setOutput(PortNumber.portNumber(
                                lookup.getLeft().intValue()))
                        .build();

                FlowRule fr = DefaultFlowRule.builder()
                        .forDevice(data().deviceId())
                        .makePermanent()
                        .withSelector(selector)
                        .withTreatment(treatment)
                        .withCookie(1)
                        .withPriority(1)
                        .build();
                rules.add(fr);
            }
        }
        return rules;
    }
}
