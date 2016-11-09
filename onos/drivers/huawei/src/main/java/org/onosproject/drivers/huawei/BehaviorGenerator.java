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

import org.onlab.packet.IpAddress;
import org.onosproject.net.Device;
import org.onosproject.net.DeviceId;
import org.onosproject.net.Link;
import org.onosproject.net.device.DeviceService;
import org.onosproject.net.flow.FlowRule;
import org.onosproject.net.flow.instructions.Instruction;
import org.onosproject.net.flow.instructions.Instructions;
import org.onosproject.net.link.LinkService;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.QosOpParam;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.DefaultQosCbQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.DefaultQosBehaviors;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.DefaultQosBehavior;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.QosBehavior;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior.DefaultQosActRdrNhps;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior.qosactrdrnhps.DefaultQosActRdrNhp;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior.qosactrdrnhps.QosActRdrNhp;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior.qosactrdrnhps.qosactrdrnhp.RdrTypeEnum;
import org.onosproject.yms.ych.YangCodecHandler;
import org.onosproject.yms.ych.YangProtocolEncodingFormat;
import org.onosproject.yms.ydt.YmsOperationType;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.onosproject.drivers.huawei.FlowConfigHuawei.LSRID;
import static org.onosproject.drivers.huawei.Utils.editConfig;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Represents behavior generator, which generates ACL object for a given flow
 * rule and call YMS to obtain behavior string.
 */
public final class BehaviorGenerator {

    private static final Logger log = getLogger(AclGenerator.class);

    /**
     * Creates an instance of behavior generator.
     */
    private BehaviorGenerator() {
    }

    /**
     * Returns behavior, by building behavior object corresponding to a flow
     * rule and then build xml using YMS.
     *
     * @param flowBehaviorName input flow behavior name
     * @param rule             input flow rule
     * @param deviceService    input device service
     * @param linkService      input link service
     * @return built behavior xml corresponding to flow rule
     */
    protected static String getBehaviorStringForSetOp(String flowBehaviorName,
                                                      FlowRule rule,
                                                      DeviceService deviceService,
                                                      LinkService linkService,
                                                      YangCodecHandler yangCodecHandler) {

        DefaultQosCbQos.QosCbQosBuilder qosCbQosBuilder
                = new DefaultQosCbQos.QosCbQosBuilder();
        DefaultQosBehaviors.QosBehaviorsBuilder qosBehaviorsBuilder
                = new DefaultQosBehaviors.QosBehaviorsBuilder();

        DefaultQosBehavior.QosBehaviorBuilder qosBehaviorBuilder
                = new DefaultQosBehavior.QosBehaviorBuilder();
        List<QosBehavior> lsQosBehavior = new ArrayList<QosBehavior>();

        qosBehaviorBuilder.yangQosBehaviorOpType(Qos.OnosYangOpType.CREATE);
//
//        qosBehaviorBuilder.onosYangNodeOperationType(
//                DefaultQosBehavior.OnosYangNodeOperationType.CREATE);
        qosBehaviorBuilder.behaviorName(flowBehaviorName);


        DefaultQosActRdrNhps.QosActRdrNhpsBuilder qosActRdrNhpsBuilder
                = new DefaultQosActRdrNhps.QosActRdrNhpsBuilder();
        DefaultQosActRdrNhp.QosActRdrNhpBuilder qosActRdrNhpBuilder
                = new DefaultQosActRdrNhp.QosActRdrNhpBuilder();

        List<QosActRdrNhp> lsQosActRdrNhp = new ArrayList<QosActRdrNhp>();

        for (Instruction i : rule.treatment().immediate()) {
            switch (i.type()) {
                case OUTPUT:
                    DeviceId deviceId = rule.deviceId();
                    Instructions.OutputInstruction out =
                            (Instructions.OutputInstruction) i;
                    String ip;

                    String[] info = deviceId.toString().split(":");
                    ip = info[1];

                    for (Device device : deviceService.getDevices()) {
                        if ((device.annotations().value(LSRID) != null) &&
                                (device.annotations().value(LSRID)
                                        .equals(ip))) {
                            deviceId = device.id();
                        }
                    }

                    for (Link link : linkService.getDeviceEgressLinks(deviceId)) {
                        if (link.src().port().toLong() == out.port().toLong()) {
                            IpAddress ipAddress;
                            ipAddress = IpAddress
                                    .valueOf((int) link.dst().port().toLong());

                            qosActRdrNhpBuilder.nextHop(ipAddress.toString());
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        qosActRdrNhpBuilder.rdrType(RdrTypeEnum.BACKUP);
        lsQosActRdrNhp.add(qosActRdrNhpBuilder.build());
        qosActRdrNhpsBuilder.qosActRdrNhp(lsQosActRdrNhp);
        qosBehaviorBuilder.qosActRdrNhps(qosActRdrNhpsBuilder.build());
        lsQosBehavior.add(qosBehaviorBuilder.build());
        qosBehaviorsBuilder.qosBehavior(lsQosBehavior);

        qosCbQosBuilder.qosBehaviors(qosBehaviorsBuilder.build());

        QosOpParam.QosBuilder qosBuilder = QosOpParam.builder();

        qosBuilder.qosCbQos(qosCbQosBuilder.build());

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

        log.info("getBehaviorStringForSetOp send dataschema : {} ", config);
        return config;
    }
}
