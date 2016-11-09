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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos;

import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.QosBehaviors;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.QosClassifiers;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.QosPolicys;

/**
 * Abstraction of an entity which represents the functionality of qosCbQos.
 */
public interface QosCbQos {

    /**
     * Returns the attribute yangQosCbQosOpType.
     *
     * @return yangQosCbQosOpType value of yangQosCbQosOpType
     */
    OnosYangOpType yangQosCbQosOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosClassifiers.
     *
     * @return qosClassifiers value of qosClassifiers
     */
    QosClassifiers qosClassifiers();

    /**
     * Returns the attribute qosBehaviors.
     *
     * @return qosBehaviors value of qosBehaviors
     */
    QosBehaviors qosBehaviors();

    /**
     * Returns the attribute qosPolicys.
     *
     * @return qosPolicys value of qosPolicys
     */
    QosPolicys qosPolicys();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosCbQos.
     */
    interface QosCbQosBuilder {
        /**
         * Returns the attribute yangQosCbQosOpType.
         *
         * @return yangQosCbQosOpType value of yangQosCbQosOpType
         */
        OnosYangOpType yangQosCbQosOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosClassifiers.
         *
         * @return qosClassifiers value of qosClassifiers
         */
        QosClassifiers qosClassifiers();

        /**
         * Returns the attribute qosBehaviors.
         *
         * @return qosBehaviors value of qosBehaviors
         */
        QosBehaviors qosBehaviors();

        /**
         * Returns the attribute qosPolicys.
         *
         * @return qosPolicys value of qosPolicys
         */
        QosPolicys qosPolicys();

        /**
         * Returns the builder object of yangQosCbQosOpType.
         *
         * @param yangQosCbQosOpType value of yangQosCbQosOpType
         * @return yangQosCbQosOpType
         */
        QosCbQosBuilder yangQosCbQosOpType(OnosYangOpType yangQosCbQosOpType);

        /**
         * Returns the builder object of qosClassifiers.
         *
         * @param qosClassifiers value of qosClassifiers
         * @return qosClassifiers
         */
        QosCbQosBuilder qosClassifiers(QosClassifiers qosClassifiers);

        /**
         * Returns the builder object of qosBehaviors.
         *
         * @param qosBehaviors value of qosBehaviors
         * @return qosBehaviors
         */
        QosCbQosBuilder qosBehaviors(QosBehaviors qosBehaviors);

        /**
         * Returns the builder object of qosPolicys.
         *
         * @param qosPolicys value of qosPolicys
         * @return qosPolicys
         */
        QosCbQosBuilder qosPolicys(QosPolicys qosPolicys);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosCbQosBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosCbQos.
         *
         * @return qosCbQos
         */
        QosCbQos build();
    }
}
