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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier;

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.qosruleacls.QosRuleAcl;

/**
 * Abstraction of an entity which represents the functionality of qosRuleAcls.
 */
public interface QosRuleAcls {

    /**
     * Returns the attribute yangQosRuleAclsOpType.
     *
     * @return yangQosRuleAclsOpType value of yangQosRuleAclsOpType
     */
    OnosYangOpType yangQosRuleAclsOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosRuleAcl.
     *
     * @return qosRuleAcl list of qosRuleAcl
     */
    List<QosRuleAcl> qosRuleAcl();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosRuleAcls.
     */
    interface QosRuleAclsBuilder {
        /**
         * Adds to the list of qosRuleAcl.
         *
         * @param addTo value of qosRuleAcl
         * @return builder object of qosRuleAcl
         */
         QosRuleAclsBuilder addToQosRuleAcl(QosRuleAcl addTo);

        /**
         * Returns the attribute yangQosRuleAclsOpType.
         *
         * @return yangQosRuleAclsOpType value of yangQosRuleAclsOpType
         */
        OnosYangOpType yangQosRuleAclsOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosRuleAcl.
         *
         * @return qosRuleAcl list of qosRuleAcl
         */
        List<QosRuleAcl> qosRuleAcl();

        /**
         * Returns the builder object of yangQosRuleAclsOpType.
         *
         * @param yangQosRuleAclsOpType value of yangQosRuleAclsOpType
         * @return yangQosRuleAclsOpType
         */
        QosRuleAclsBuilder yangQosRuleAclsOpType(OnosYangOpType yangQosRuleAclsOpType);

        /**
         * Returns the builder object of qosRuleAcl.
         *
         * @param qosRuleAcl list of qosRuleAcl
         * @return qosRuleAcl
         */
        QosRuleAclsBuilder qosRuleAcl(List<QosRuleAcl> qosRuleAcl);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosRuleAclsBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosRuleAcls.
         *
         * @return qosRuleAcls
         */
        QosRuleAcls build();
    }
}
