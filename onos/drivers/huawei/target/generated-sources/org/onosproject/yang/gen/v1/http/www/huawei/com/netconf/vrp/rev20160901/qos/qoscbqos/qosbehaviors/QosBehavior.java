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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .QosActRdrNhps;

/**
 * Abstraction of an entity which represents the functionality of qosBehavior.
 */
public interface QosBehavior {

    /**
     * Identify the leaf of QosBehavior.
     */
    public enum LeafIdentifier {
        /**
         * Represents behaviorName.
         */
        BEHAVIORNAME(1);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

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
     * Returns the attribute yangQosBehaviorOpType.
     *
     * @return yangQosBehaviorOpType value of yangQosBehaviorOpType
     */
    OnosYangOpType yangQosBehaviorOpType();

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
     * Returns the attribute qosActRdrNhps.
     *
     * @return qosActRdrNhps value of qosActRdrNhps
     */
    QosActRdrNhps qosActRdrNhps();


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
     * Builder for qosBehavior.
     */
    interface QosBehaviorBuilder {
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
         * Returns the attribute yangQosBehaviorOpType.
         *
         * @return yangQosBehaviorOpType value of yangQosBehaviorOpType
         */
        OnosYangOpType yangQosBehaviorOpType();

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
         * Returns the attribute qosActRdrNhps.
         *
         * @return qosActRdrNhps value of qosActRdrNhps
         */
        QosActRdrNhps qosActRdrNhps();

        /**
         * Returns the builder object of behaviorName.
         *
         * @param behaviorName value of behaviorName
         * @return behaviorName
         */
        QosBehaviorBuilder behaviorName(String behaviorName);

        /**
         * Returns the builder object of yangQosBehaviorOpType.
         *
         * @param yangQosBehaviorOpType value of yangQosBehaviorOpType
         * @return yangQosBehaviorOpType
         */
        QosBehaviorBuilder yangQosBehaviorOpType(OnosYangOpType yangQosBehaviorOpType);

        /**
         * Returns the builder object of qosActRdrNhps.
         *
         * @param qosActRdrNhps value of qosActRdrNhps
         * @return qosActRdrNhps
         */
        QosBehaviorBuilder qosActRdrNhps(QosActRdrNhps qosActRdrNhps);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosBehaviorBuilder addYangAugmentedInfo(Object value, Class classObject);

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
        QosBehaviorBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of qosBehavior.
         *
         * @return qosBehavior
         */
        QosBehavior build();
    }
}
