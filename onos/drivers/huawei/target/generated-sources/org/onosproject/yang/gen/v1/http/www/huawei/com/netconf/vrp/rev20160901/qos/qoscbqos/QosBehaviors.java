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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.QosBehavior;

/**
 * Abstraction of an entity which represents the functionality of qosBehaviors.
 */
public interface QosBehaviors {

    /**
     * Returns the attribute yangQosBehaviorsOpType.
     *
     * @return yangQosBehaviorsOpType value of yangQosBehaviorsOpType
     */
    OnosYangOpType yangQosBehaviorsOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosBehavior.
     *
     * @return qosBehavior list of qosBehavior
     */
    List<QosBehavior> qosBehavior();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosBehaviors.
     */
    interface QosBehaviorsBuilder {
        /**
         * Adds to the list of qosBehavior.
         *
         * @param addTo value of qosBehavior
         * @return builder object of qosBehavior
         */
         QosBehaviorsBuilder addToQosBehavior(QosBehavior addTo);

        /**
         * Returns the attribute yangQosBehaviorsOpType.
         *
         * @return yangQosBehaviorsOpType value of yangQosBehaviorsOpType
         */
        OnosYangOpType yangQosBehaviorsOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosBehavior.
         *
         * @return qosBehavior list of qosBehavior
         */
        List<QosBehavior> qosBehavior();

        /**
         * Returns the builder object of yangQosBehaviorsOpType.
         *
         * @param yangQosBehaviorsOpType value of yangQosBehaviorsOpType
         * @return yangQosBehaviorsOpType
         */
        QosBehaviorsBuilder yangQosBehaviorsOpType(OnosYangOpType yangQosBehaviorsOpType);

        /**
         * Returns the builder object of qosBehavior.
         *
         * @param qosBehavior list of qosBehavior
         * @return qosBehavior
         */
        QosBehaviorsBuilder qosBehavior(List<QosBehavior> qosBehavior);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosBehaviorsBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosBehaviors.
         *
         * @return qosBehaviors
         */
        QosBehaviors build();
    }
}
