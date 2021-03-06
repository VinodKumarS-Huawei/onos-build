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

import org.onosproject.net.flow.FlowRule;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.QosOpParam;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.DefaultQosCbQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.DefaultQosPolicys;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.DefaultQosPolicy;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.QosPolicy;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy.DefaultQosPolicyNodes;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy.qospolicynodes.DefaultQosPolicyNode;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy.qospolicynodes.QosPolicyNode;
import org.onosproject.yms.ych.YangProtocolEncodingFormat;
import org.onosproject.yms.ydt.YmsOperationType;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.onosproject.drivers.huawei.FlowConfigHuawei.yangCodecHandler;
import static org.onosproject.drivers.huawei.Utils.editConfig;
import static org.onosproject.drivers.huawei.Utils.getConfig;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Represents policy generator, which generates ACL object for a given flow rule
 * and call YMS to obtain policy string.
 */
public final class PolicyGenerator {

    private static final Logger log = getLogger(AclGenerator.class);

    // Creates an instance of policy generator.
    private PolicyGenerator() {
    }

    /**
     * Returns policy, by building policy object corresponding to a flow rule
     * and then build xml using YMS.
     *
     * @param rule               input flow rule
     * @param classifierID       classifier ID
     * @param flowClassifierName flow classifier name
     * @param flowBehaviorName   flow behavior name
     * @return policy xml string
     */
    protected static String getPolicyStringForSetOp(FlowRule rule,
                                                    int classifierID,
                                                    String flowClassifierName,
                                                    String flowBehaviorName) {

        DefaultQosCbQos.QosCbQosBuilder qosCbQosBuilder
                = new DefaultQosCbQos.QosCbQosBuilder();
        DefaultQosPolicys.QosPolicysBuilder qosPolicysBuilder
                = new DefaultQosPolicys.QosPolicysBuilder();

        DefaultQosPolicy.QosPolicyBuilder qosPolicyBuilder
                = new DefaultQosPolicy.QosPolicyBuilder();
        List<QosPolicy> lsQosPolicy = new ArrayList<QosPolicy>();

        qosPolicyBuilder.policyName(rule.id().toString());

        DefaultQosPolicyNodes.QosPolicyNodesBuilder qosPolicyNodesBuilder
                = new DefaultQosPolicyNodes.QosPolicyNodesBuilder();

        DefaultQosPolicyNode.QosPolicyNodeBuilder qosPolicyNodeBuilder
                = new DefaultQosPolicyNode.QosPolicyNodeBuilder();

        List<QosPolicyNode> lsQosPolicyNode = new ArrayList<QosPolicyNode>();

        qosPolicyNodeBuilder.priority(rule.priority());
        qosPolicyNodeBuilder.classifierName(flowClassifierName);
        qosPolicyNodeBuilder.behaviorName(flowBehaviorName);

        lsQosPolicyNode.add(qosPolicyNodeBuilder.build());

        qosPolicyNodesBuilder.qosPolicyNode(lsQosPolicyNode);

        qosPolicyBuilder.qosPolicyNodes(qosPolicyNodesBuilder.build());

        qosPolicyBuilder.yangQosPolicyOpType(Qos.OnosYangOpType.CREATE);

//        qosPolicyBuilder.onosYangNodeOperationType(
//                DefaultQosPolicy.OnosYangNodeOperationType.CREATE);

        lsQosPolicy.add(qosPolicyBuilder.build());

        qosPolicysBuilder.qosPolicy(lsQosPolicy);

        qosCbQosBuilder.qosPolicys(qosPolicysBuilder.build());

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

        log.info("getPolicyStringForSetOp send dataschema : {} ", config);
        return config;
    }


    /**
     * Returns policy, by building policy object corresponding to a flow rule
     * and then build xml using YMS.
     *
     * @return policy xml string
     */
    protected static String getPolicyStringForGetOp() {

        DefaultQosCbQos.QosCbQosBuilder qosCbQosBuilder
                = new DefaultQosCbQos.QosCbQosBuilder();

        DefaultQosPolicys.QosPolicysBuilder qosPolicysBuilder
                = new DefaultQosPolicys.QosPolicysBuilder();

        DefaultQosPolicy.QosPolicyBuilder qosPolicyBuilder
                = new DefaultQosPolicy.QosPolicyBuilder();
        List<QosPolicy> lsQosPolicy = new ArrayList<QosPolicy>();

        qosPolicyBuilder.selectLeaf(QosPolicy.LeafIdentifier.POLICYNAME);

        lsQosPolicy.add(qosPolicyBuilder.build());

        qosPolicysBuilder.qosPolicy(lsQosPolicy);

        qosCbQosBuilder.qosPolicys(qosPolicysBuilder.build());

        QosOpParam.QosBuilder qosBuilder = QosOpParam.builder();

        qosBuilder.qosCbQos(qosCbQosBuilder.build());

        List<Object> objectList = new LinkedList<>();

        objectList.add(qosBuilder.build());

        Map<String, String> tagAttributeLinkedMap = new HashMap<>();

        tagAttributeLinkedMap.put("type", "subtree");

        // Use YMS to encode the built object to XML string
        String config = yangCodecHandler
                .encodeOperation("filter", null, tagAttributeLinkedMap,
                                 objectList,
                                 YangProtocolEncodingFormat.XML,
                                 YmsOperationType.QUERY_CONFIG_REQUEST);

        config = getConfig(config);
        log.info("getPolicyStringForSetOp send dataschema : {} ", config);
        return config;
    }
}
