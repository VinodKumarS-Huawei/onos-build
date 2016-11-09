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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors
            .qosbehavior;

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps.QosActRdrNhp;

/**
 * Abstraction of an entity which represents the functionality of qosActRdrNhps.
 */
public interface QosActRdrNhps {

    /**
     * Returns the attribute yangQosActRdrNhpsOpType.
     *
     * @return yangQosActRdrNhpsOpType value of yangQosActRdrNhpsOpType
     */
    OnosYangOpType yangQosActRdrNhpsOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosActRdrNhp.
     *
     * @return qosActRdrNhp list of qosActRdrNhp
     */
    List<QosActRdrNhp> qosActRdrNhp();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosActRdrNhps.
     */
    interface QosActRdrNhpsBuilder {
        /**
         * Adds to the list of qosActRdrNhp.
         *
         * @param addTo value of qosActRdrNhp
         * @return builder object of qosActRdrNhp
         */
         QosActRdrNhpsBuilder addToQosActRdrNhp(QosActRdrNhp addTo);

        /**
         * Returns the attribute yangQosActRdrNhpsOpType.
         *
         * @return yangQosActRdrNhpsOpType value of yangQosActRdrNhpsOpType
         */
        OnosYangOpType yangQosActRdrNhpsOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosActRdrNhp.
         *
         * @return qosActRdrNhp list of qosActRdrNhp
         */
        List<QosActRdrNhp> qosActRdrNhp();

        /**
         * Returns the builder object of yangQosActRdrNhpsOpType.
         *
         * @param yangQosActRdrNhpsOpType value of yangQosActRdrNhpsOpType
         * @return yangQosActRdrNhpsOpType
         */
        QosActRdrNhpsBuilder yangQosActRdrNhpsOpType(OnosYangOpType yangQosActRdrNhpsOpType);

        /**
         * Returns the builder object of qosActRdrNhp.
         *
         * @param qosActRdrNhp list of qosActRdrNhp
         * @return qosActRdrNhp
         */
        QosActRdrNhpsBuilder qosActRdrNhp(List<QosActRdrNhp> qosActRdrNhp);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosActRdrNhpsBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosActRdrNhps.
         *
         * @return qosActRdrNhps
         */
        QosActRdrNhps build();
    }
}
