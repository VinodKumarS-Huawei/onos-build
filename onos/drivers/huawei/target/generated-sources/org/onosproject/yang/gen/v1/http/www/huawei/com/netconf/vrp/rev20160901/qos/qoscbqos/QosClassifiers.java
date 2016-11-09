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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .QosClassifier;

/**
 * Abstraction of an entity which represents the functionality of qosClassifiers.
 */
public interface QosClassifiers {

    /**
     * Returns the attribute yangQosClassifiersOpType.
     *
     * @return yangQosClassifiersOpType value of yangQosClassifiersOpType
     */
    OnosYangOpType yangQosClassifiersOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosClassifier.
     *
     * @return qosClassifier list of qosClassifier
     */
    List<QosClassifier> qosClassifier();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosClassifiers.
     */
    interface QosClassifiersBuilder {
        /**
         * Adds to the list of qosClassifier.
         *
         * @param addTo value of qosClassifier
         * @return builder object of qosClassifier
         */
         QosClassifiersBuilder addToQosClassifier(QosClassifier addTo);

        /**
         * Returns the attribute yangQosClassifiersOpType.
         *
         * @return yangQosClassifiersOpType value of yangQosClassifiersOpType
         */
        OnosYangOpType yangQosClassifiersOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosClassifier.
         *
         * @return qosClassifier list of qosClassifier
         */
        List<QosClassifier> qosClassifier();

        /**
         * Returns the builder object of yangQosClassifiersOpType.
         *
         * @param yangQosClassifiersOpType value of yangQosClassifiersOpType
         * @return yangQosClassifiersOpType
         */
        QosClassifiersBuilder yangQosClassifiersOpType(OnosYangOpType yangQosClassifiersOpType);

        /**
         * Returns the builder object of qosClassifier.
         *
         * @param qosClassifier list of qosClassifier
         * @return qosClassifier
         */
        QosClassifiersBuilder qosClassifier(List<QosClassifier> qosClassifier);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosClassifiersBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosClassifiers.
         *
         * @return qosClassifiers
         */
        QosClassifiers build();
    }
}
