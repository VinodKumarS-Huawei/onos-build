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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps.qosactrdrnhp.RdrTypeEnum;

/**
 * Abstraction of an entity which represents the functionality of qosActRdrNhp.
 */
public interface QosActRdrNhp {

    /**
     * Identify the leaf of QosActRdrNhp.
     */
    public enum LeafIdentifier {
        /**
         * Represents nextHop.
         */
        NEXTHOP(1),
        /**
         * Represents rdrType.
         */
        RDRTYPE(2);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute nextHop.
     *
     * @return nextHop value of nextHop
     */
    String nextHop();

    /**
     * Returns the attribute rdrType.
     *
     * @return rdrType value of rdrType
     */
    RdrTypeEnum rdrType();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangQosActRdrNhpOpType.
     *
     * @return yangQosActRdrNhpOpType value of yangQosActRdrNhpOpType
     */
    OnosYangOpType yangQosActRdrNhpOpType();

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
     * Builder for qosActRdrNhp.
     */
    interface QosActRdrNhpBuilder {
        /**
         * Returns the attribute nextHop.
         *
         * @return nextHop value of nextHop
         */
        String nextHop();

        /**
         * Returns the attribute rdrType.
         *
         * @return rdrType value of rdrType
         */
        RdrTypeEnum rdrType();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangQosActRdrNhpOpType.
         *
         * @return yangQosActRdrNhpOpType value of yangQosActRdrNhpOpType
         */
        OnosYangOpType yangQosActRdrNhpOpType();

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
         * Returns the builder object of nextHop.
         *
         * @param nextHop value of nextHop
         * @return nextHop
         */
        QosActRdrNhpBuilder nextHop(String nextHop);

        /**
         * Returns the builder object of rdrType.
         *
         * @param rdrType value of rdrType
         * @return rdrType
         */
        QosActRdrNhpBuilder rdrType(RdrTypeEnum rdrType);

        /**
         * Returns the builder object of yangQosActRdrNhpOpType.
         *
         * @param yangQosActRdrNhpOpType value of yangQosActRdrNhpOpType
         * @return yangQosActRdrNhpOpType
         */
        QosActRdrNhpBuilder yangQosActRdrNhpOpType(OnosYangOpType yangQosActRdrNhpOpType);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosActRdrNhpBuilder addYangAugmentedInfo(Object value, Class classObject);

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
        QosActRdrNhpBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of qosActRdrNhp.
         *
         * @return qosActRdrNhp
         */
        QosActRdrNhp build();
    }
}
