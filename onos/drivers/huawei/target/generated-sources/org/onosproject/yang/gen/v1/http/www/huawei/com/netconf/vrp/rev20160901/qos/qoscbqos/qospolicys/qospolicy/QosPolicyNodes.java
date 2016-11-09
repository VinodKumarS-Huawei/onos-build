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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy;

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy
            .qospolicynodes.QosPolicyNode;

/**
 * Abstraction of an entity which represents the functionality of qosPolicyNodes.
 */
public interface QosPolicyNodes {

    /**
     * Returns the attribute yangQosPolicyNodesOpType.
     *
     * @return yangQosPolicyNodesOpType value of yangQosPolicyNodesOpType
     */
    OnosYangOpType yangQosPolicyNodesOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosPolicyNode.
     *
     * @return qosPolicyNode list of qosPolicyNode
     */
    List<QosPolicyNode> qosPolicyNode();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for qosPolicyNodes.
     */
    interface QosPolicyNodesBuilder {
        /**
         * Adds to the list of qosPolicyNode.
         *
         * @param addTo value of qosPolicyNode
         * @return builder object of qosPolicyNode
         */
         QosPolicyNodesBuilder addToQosPolicyNode(QosPolicyNode addTo);

        /**
         * Returns the attribute yangQosPolicyNodesOpType.
         *
         * @return yangQosPolicyNodesOpType value of yangQosPolicyNodesOpType
         */
        OnosYangOpType yangQosPolicyNodesOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosPolicyNode.
         *
         * @return qosPolicyNode list of qosPolicyNode
         */
        List<QosPolicyNode> qosPolicyNode();

        /**
         * Returns the builder object of yangQosPolicyNodesOpType.
         *
         * @param yangQosPolicyNodesOpType value of yangQosPolicyNodesOpType
         * @return yangQosPolicyNodesOpType
         */
        QosPolicyNodesBuilder yangQosPolicyNodesOpType(OnosYangOpType yangQosPolicyNodesOpType);

        /**
         * Returns the builder object of qosPolicyNode.
         *
         * @param qosPolicyNode list of qosPolicyNode
         * @return qosPolicyNode
         */
        QosPolicyNodesBuilder qosPolicyNode(List<QosPolicyNode> qosPolicyNode);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosPolicyNodesBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of qosPolicyNodes.
         *
         * @return qosPolicyNodes
         */
        QosPolicyNodes build();
    }
}
