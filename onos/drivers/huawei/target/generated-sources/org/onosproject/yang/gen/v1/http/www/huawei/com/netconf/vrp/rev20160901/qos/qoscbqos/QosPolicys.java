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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos;

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.QosPolicy;

/**
 * Abstraction of an entity which represents the functionality of qosPolicys.
 */
public interface QosPolicys {

    /**
     * Returns the attribute yangQosPolicysOpType.
     *
     * @return yangQosPolicysOpType value of yangQosPolicysOpType
     */
    OnosYangOpType yangQosPolicysOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosPolicy.
     *
     * @return qosPolicy list of qosPolicy
     */
    List<QosPolicy> qosPolicy();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosPolicys.
     */
    interface QosPolicysBuilder {
        /**
         * Adds to the list of qosPolicy.
         *
         * @param addTo value of qosPolicy
         * @return builder object of qosPolicy
         */
         QosPolicysBuilder addToQosPolicy(QosPolicy addTo);

        /**
         * Returns the attribute yangQosPolicysOpType.
         *
         * @return yangQosPolicysOpType value of yangQosPolicysOpType
         */
        OnosYangOpType yangQosPolicysOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosPolicy.
         *
         * @return qosPolicy list of qosPolicy
         */
        List<QosPolicy> qosPolicy();

        /**
         * Returns the builder object of yangQosPolicysOpType.
         *
         * @param yangQosPolicysOpType value of yangQosPolicysOpType
         * @return yangQosPolicysOpType
         */
        QosPolicysBuilder yangQosPolicysOpType(OnosYangOpType yangQosPolicysOpType);

        /**
         * Returns the builder object of qosPolicy.
         *
         * @param qosPolicy list of qosPolicy
         * @return qosPolicy
         */
        QosPolicysBuilder qosPolicy(List<QosPolicy> qosPolicy);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosPolicysBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosPolicys.
         *
         * @return qosPolicys
         */
        QosPolicys build();
    }
}
