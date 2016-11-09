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

import org.onosproject.net.DeviceId;
import org.onosproject.net.flow.FlowRule;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.QosOpParam;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.DefaultQosIfQoss;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.DefaultQosIfQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.QosIfQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.DefaultQosPolicyApplys;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys.DefaultQosPolicyApply;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys.QosPolicyApply;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys.qospolicyapply.DirectionEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys.qospolicyapply.LayerEnum;
import org.onosproject.yms.ych.YangProtocolEncodingFormat;
import org.onosproject.yms.ydt.YmsOperationType;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.onosproject.drivers.huawei.FlowConfigHuawei.yangCodecHandler;
import static org.onosproject.drivers.huawei.Utils.editConfig;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Represents interface policy configuration generator, which generates
 * policy for interface object for a given flow rule and call YMS to obtain
 * policy string.
 */
public final class InterfacePolicyConfigGenerator {

    private static final Logger log = getLogger(AclGenerator.class);

    // Creates an instance of interface policy config generator.
    private InterfacePolicyConfigGenerator() {
    }

    /**
     * Returns interface policy configuration, by building interface policy
     * config object corresponding to a given flow rule.
     *
     * @param rule     flow rule
     * @param deviceId device ID
     * @return policy configuration for interface
     */
    protected static String getInterfacePolicyForSetOp(FlowRule rule,
                                                       DeviceId deviceId) {

        DefaultQosIfQoss.QosIfQossBuilder qosIfQossBuilder
                = new DefaultQosIfQoss.QosIfQossBuilder();
        DefaultQosIfQos.QosIfQosBuilder qosIfQosBuilder
                = new DefaultQosIfQos.QosIfQosBuilder();
        List<QosIfQos> lsQosIfQos = new ArrayList<QosIfQos>();

        qosIfQosBuilder.yangQosIfQosOpType(Qos.OnosYangOpType.MERGE);
//
//        qosIfQosBuilder.onosYangNodeOperationType(
//                DefaultQosIfQos.OnosYangNodeOperationType.MERGE);

        if (deviceId.toString().compareTo("netconf:9.9.9.9:22") == 0) {
            qosIfQosBuilder.ifName("GigabitEthernet0/3/2");
        } else if (deviceId.toString().compareTo("netconf:10.10.10.10:22") ==
                0) {
            qosIfQosBuilder.ifName("GigabitEthernet0/3/3");
        }

        DefaultQosPolicyApplys.QosPolicyApplysBuilder qosPolicyApplysBuilder
                = new DefaultQosPolicyApplys.QosPolicyApplysBuilder();

        DefaultQosPolicyApply.QosPolicyApplyBuilder qosPolicyApplyBuilder
                = new DefaultQosPolicyApply.QosPolicyApplyBuilder();
        List<QosPolicyApply> lsQosPolicyApply
                = new ArrayList<QosPolicyApply>();

        qosPolicyApplyBuilder.yangQosPolicyApplyOpType(Qos.OnosYangOpType
                                                               .MERGE);

//        qosPolicyApplyBuilder.onosYangNodeOperationType(
//                DefaultQosPolicyApply.OnosYangNodeOperationType.MERGE);
        qosPolicyApplyBuilder.direction(DirectionEnum.INBOUND);
        qosPolicyApplyBuilder.layer(LayerEnum.NONE);
        qosPolicyApplyBuilder.policyName(rule.id().toString());
        qosPolicyApplyBuilder.vlanMode(false);
        qosPolicyApplyBuilder.groupId(0);

        lsQosPolicyApply.add(qosPolicyApplyBuilder.build());
        qosPolicyApplysBuilder.qosPolicyApply(lsQosPolicyApply);

        qosIfQosBuilder.qosPolicyApplys(qosPolicyApplysBuilder.build());
        lsQosIfQos.add(qosIfQosBuilder.build());
        qosIfQossBuilder.qosIfQos(lsQosIfQos);

        QosOpParam.QosBuilder qosBuilder = QosOpParam.builder();

        qosBuilder.qosIfQoss(qosIfQossBuilder.build());

        List<Object> objectList = new LinkedList<>();

        objectList.add(qosBuilder.build());

        String config = yangCodecHandler.encodeOperation("config", null,
                                                         null,
                                                         objectList,
                                                         YangProtocolEncodingFormat
                                                                 .XML,
                                                         YmsOperationType
                                                                 .EDIT_CONFIG_REQUEST);

        config = editConfig(config);

        log.info("getInterfacePolicyForSetOp send dataschema : {} ", config);
        return config;
    }
}
