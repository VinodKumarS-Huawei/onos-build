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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy
            .qospolicynodes;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;

/**
 * Abstraction of an entity which represents the functionality of qosPolicyNode.
 */
public interface QosPolicyNode {

    /**
     * Identify the leaf of QosPolicyNode.
     */
    public enum LeafIdentifier {
        /**
         * Represents priority.
         */
        PRIORITY(1),
        /**
         * Represents classifierName.
         */
        CLASSIFIERNAME(2),
        /**
         * Represents behaviorName.
         */
        BEHAVIORNAME(3);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute priority.
     *
     * @return priority value of priority
     */
    int priority();

    /**
     * Returns the attribute classifierName.
     *
     * @return classifierName value of classifierName
     */
    String classifierName();

    /**
     * Returns the attribute behaviorName.
     *
     * @return behaviorName value of behaviorName
     */
    String behaviorName();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangQosPolicyNodeOpType.
     *
     * @return yangQosPolicyNodeOpType value of yangQosPolicyNodeOpType
     */
    OnosYangOpType yangQosPolicyNodeOpType();

    /**
     * Returns the attribute selectLeafFlags.
     *
     * @return selectLeafFlags value of selectLeafFlags
     */
    BitSet selectLeafFlags();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Checks if the leaf value is set.
     *
     * @param leaf leaf whose value status needs to checked
     * @return result of leaf value set in object
     */
    boolean isLeafValueSet(LeafIdentifier leaf);

    /**
     * Checks if the leaf is set to be a selected leaf.
     *
     * @param leaf if leaf needs to be selected
     * @return result of leaf value set in object
     */
    boolean isSelectLeaf(LeafIdentifier leaf);

    /**
     * Builder for qosPolicyNode.
     */
    interface QosPolicyNodeBuilder {
        /**
         * Returns the attribute priority.
         *
         * @return priority value of priority
         */
        int priority();

        /**
         * Returns the attribute classifierName.
         *
         * @return classifierName value of classifierName
         */
        String classifierName();

        /**
         * Returns the attribute behaviorName.
         *
         * @return behaviorName value of behaviorName
         */
        String behaviorName();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangQosPolicyNodeOpType.
         *
         * @return yangQosPolicyNodeOpType value of yangQosPolicyNodeOpType
         */
        OnosYangOpType yangQosPolicyNodeOpType();

        /**
         * Returns the attribute selectLeafFlags.
         *
         * @return selectLeafFlags value of selectLeafFlags
         */
        BitSet selectLeafFlags();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the builder object of priority.
         *
         * @param priority value of priority
         * @return priority
         */
        QosPolicyNodeBuilder priority(int priority);

        /**
         * Returns the builder object of classifierName.
         *
         * @param classifierName value of classifierName
         * @return classifierName
         */
        QosPolicyNodeBuilder classifierName(String classifierName);

        /**
         * Returns the builder object of behaviorName.
         *
         * @param behaviorName value of behaviorName
         * @return behaviorName
         */
        QosPolicyNodeBuilder behaviorName(String behaviorName);

        /**
         * Returns the builder object of yangQosPolicyNodeOpType.
         *
         * @param yangQosPolicyNodeOpType value of yangQosPolicyNodeOpType
         * @return yangQosPolicyNodeOpType
         */
        QosPolicyNodeBuilder yangQosPolicyNodeOpType(OnosYangOpType yangQosPolicyNodeOpType);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosPolicyNodeBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Set a leaf to be selected.
         *
         * @param leaf leaf needs to be selected
         * @return builder object for select leaf
         */
        QosPolicyNodeBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of qosPolicyNode.
         *
         * @return qosPolicyNode
         */
        QosPolicyNode build();
    }
}
