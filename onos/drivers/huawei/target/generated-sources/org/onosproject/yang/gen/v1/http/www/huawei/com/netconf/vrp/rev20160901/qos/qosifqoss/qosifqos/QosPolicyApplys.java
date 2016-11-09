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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos;

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys
            .QosPolicyApply;

/**
 * Abstraction of an entity which represents the functionality of qosPolicyApplys.
 */
public interface QosPolicyApplys {

    /**
     * Returns the attribute yangQosPolicyApplysOpType.
     *
     * @return yangQosPolicyApplysOpType value of yangQosPolicyApplysOpType
     */
    OnosYangOpType yangQosPolicyApplysOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosPolicyApply.
     *
     * @return qosPolicyApply list of qosPolicyApply
     */
    List<QosPolicyApply> qosPolicyApply();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosPolicyApplys.
     */
    interface QosPolicyApplysBuilder {
        /**
         * Adds to the list of qosPolicyApply.
         *
         * @param addTo value of qosPolicyApply
         * @return builder object of qosPolicyApply
         */
         QosPolicyApplysBuilder addToQosPolicyApply(QosPolicyApply addTo);

        /**
         * Returns the attribute yangQosPolicyApplysOpType.
         *
         * @return yangQosPolicyApplysOpType value of yangQosPolicyApplysOpType
         */
        OnosYangOpType yangQosPolicyApplysOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosPolicyApply.
         *
         * @return qosPolicyApply list of qosPolicyApply
         */
        List<QosPolicyApply> qosPolicyApply();

        /**
         * Returns the builder object of yangQosPolicyApplysOpType.
         *
         * @param yangQosPolicyApplysOpType value of yangQosPolicyApplysOpType
         * @return yangQosPolicyApplysOpType
         */
        QosPolicyApplysBuilder yangQosPolicyApplysOpType(OnosYangOpType yangQosPolicyApplysOpType);

        /**
         * Returns the builder object of qosPolicyApply.
         *
         * @param qosPolicyApply list of qosPolicyApply
         * @return qosPolicyApply
         */
        QosPolicyApplysBuilder qosPolicyApply(List<QosPolicyApply> qosPolicyApply);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosPolicyApplysBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosPolicyApplys.
         *
         * @return qosPolicyApplys
         */
        QosPolicyApplys build();
    }
}
