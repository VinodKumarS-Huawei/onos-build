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

import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.QosOpParam;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.DefaultQosCbQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.DefaultQosClassifiers;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers.DefaultQosClassifier;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers.QosClassifier;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers.qosclassifier.DefaultQosRuleAcls;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers.qosclassifier.OperatorEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers.qosclassifier.qosruleacls.DefaultQosRuleAcl;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers.qosclassifier.qosruleacls.QosRuleAcl;
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
 * Represents classifier generator, which generates ACL object for a given flow
 * rule and call YMS to obtain classifier string.
 */
public final class ClassifierGenerator {

    private static final Logger log = getLogger(AclGenerator.class);

    // Creates an instance of classifier generator.
    private ClassifierGenerator() {
    }

    /**
     * Returns classifier, by building classifier object corresponding to a flow
     * rule and then build xml using YMS.
     *
     * @param aclGroupID         input ACL group id
     * @param flowClassifierName flow classifier name
     * @return built classifier xml string corresponding to flow rule
     */
    protected static String getClassifierStringForSetOp(int aclGroupID,
                                                        String flowClassifierName) {

        DefaultQosCbQos.QosCbQosBuilder qosCbQosBuilder
                = new DefaultQosCbQos.QosCbQosBuilder();
        DefaultQosClassifiers.QosClassifiersBuilder qosClassifiersBuilder
                = new DefaultQosClassifiers.QosClassifiersBuilder();

        DefaultQosClassifier.QosClassifierBuilder qosClassifierBuilder
                = new DefaultQosClassifier.QosClassifierBuilder();
        List<QosClassifier> lsQosClassifier = new ArrayList<QosClassifier>();

        qosClassifierBuilder.yangQosClassifierOpType(Qos.OnosYangOpType.CREATE);
//
//        qosClassifierBuilder.onosYangNodeOperationType(
//                DefaultQosClassifier.OnosYangNodeOperationType.CREATE);
        qosClassifierBuilder.classifierName(flowClassifierName);
        qosClassifierBuilder.operator(OperatorEnum.AND);

        DefaultQosRuleAcls.QosRuleAclsBuilder qosRuleAclsBuilder
                = new DefaultQosRuleAcls.QosRuleAclsBuilder();
        DefaultQosRuleAcl.QosRuleAclBuilder qosRuleAclBuilder
                = new DefaultQosRuleAcl.QosRuleAclBuilder();

        List<QosRuleAcl> lsQosRuleAcl = new ArrayList<QosRuleAcl>();

        qosRuleAclBuilder.aclName(String.valueOf(aclGroupID));
        lsQosRuleAcl.add(qosRuleAclBuilder.build());
        qosRuleAclsBuilder.qosRuleAcl(lsQosRuleAcl);
        qosClassifierBuilder.qosRuleAcls(qosRuleAclsBuilder.build());
        lsQosClassifier.add(qosClassifierBuilder.build());
        qosClassifiersBuilder.qosClassifier(lsQosClassifier);

        qosCbQosBuilder.qosClassifiers(qosClassifiersBuilder.build());

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

        log.info("getClassifierStringForSetOp send dataschema : {} ", config);
        return config;
    }

}
