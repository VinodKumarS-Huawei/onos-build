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

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.QosIfQos;

/**
 * Abstraction of an entity which represents the functionality of qosIfQoss.
 */
public interface QosIfQoss {

    /**
     * Returns the attribute yangQosIfQossOpType.
     *
     * @return yangQosIfQossOpType value of yangQosIfQossOpType
     */
    OnosYangOpType yangQosIfQossOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosIfQos.
     *
     * @return qosIfQos list of qosIfQos
     */
    List<QosIfQos> qosIfQos();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosIfQoss.
     */
    interface QosIfQossBuilder {
        /**
         * Adds to the list of qosIfQos.
         *
         * @param addTo value of qosIfQos
         * @return builder object of qosIfQos
         */
         QosIfQossBuilder addToQosIfQos(QosIfQos addTo);

        /**
         * Returns the attribute yangQosIfQossOpType.
         *
         * @return yangQosIfQossOpType value of yangQosIfQossOpType
         */
        OnosYangOpType yangQosIfQossOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosIfQos.
         *
         * @return qosIfQos list of qosIfQos
         */
        List<QosIfQos> qosIfQos();

        /**
         * Returns the builder object of yangQosIfQossOpType.
         *
         * @param yangQosIfQossOpType value of yangQosIfQossOpType
         * @return yangQosIfQossOpType
         */
        QosIfQossBuilder yangQosIfQossOpType(OnosYangOpType yangQosIfQossOpType);

        /**
         * Returns the builder object of qosIfQos.
         *
         * @param qosIfQos list of qosIfQos
         * @return qosIfQos
         */
        QosIfQossBuilder qosIfQos(List<QosIfQos> qosIfQos);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosIfQossBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosIfQoss.
         *
         * @return qosIfQoss
         */
        QosIfQoss build();
    }
}
