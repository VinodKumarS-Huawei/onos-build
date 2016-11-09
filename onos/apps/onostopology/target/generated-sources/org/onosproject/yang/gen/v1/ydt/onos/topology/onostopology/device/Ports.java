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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopology.OnosYangOpType;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.port.PortTypeEnum;

/**
 * Abstraction of an entity which represents the functionality of ports.
 */
public interface Ports {

    /**
     * Identify the leaf of Ports.
     */
    public enum LeafIdentifier {
        /**
         * Represents number.
         */
        NUMBER(1),
        /**
         * Represents isEnabled.
         */
        ISENABLED(2),
        /**
         * Represents portType.
         */
        PORTTYPE(3),
        /**
         * Represents portSpeed.
         */
        PORTSPEED(4);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute number.
     *
     * @return number value of number
     */
    long number();

    /**
     * Returns the attribute isEnabled.
     *
     * @return isEnabled value of isEnabled
     */
    boolean isEnabled();

    /**
     * Returns the attribute portType.
     *
     * @return portType value of portType
     */
    PortTypeEnum portType();

    /**
     * Returns the attribute portSpeed.
     *
     * @return portSpeed value of portSpeed
     */
    long portSpeed();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangPortsOpType.
     *
     * @return yangPortsOpType value of yangPortsOpType
     */
    OnosYangOpType yangPortsOpType();

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
     * Builder for ports.
     */
    interface PortsBuilder {
        /**
         * Returns the attribute number.
         *
         * @return number value of number
         */
        long number();

        /**
         * Returns the attribute isEnabled.
         *
         * @return isEnabled value of isEnabled
         */
        boolean isEnabled();

        /**
         * Returns the attribute portType.
         *
         * @return portType value of portType
         */
        PortTypeEnum portType();

        /**
         * Returns the attribute portSpeed.
         *
         * @return portSpeed value of portSpeed
         */
        long portSpeed();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangPortsOpType.
         *
         * @return yangPortsOpType value of yangPortsOpType
         */
        OnosYangOpType yangPortsOpType();

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
         * Returns the builder object of number.
         *
         * @param number value of number
         * @return number
         */
        PortsBuilder number(long number);

        /**
         * Returns the builder object of isEnabled.
         *
         * @param isEnabled value of isEnabled
         * @return isEnabled
         */
        PortsBuilder isEnabled(boolean isEnabled);

        /**
         * Returns the builder object of portType.
         *
         * @param portType value of portType
         * @return portType
         */
        PortsBuilder portType(PortTypeEnum portType);

        /**
         * Returns the builder object of portSpeed.
         *
         * @param portSpeed value of portSpeed
         * @return portSpeed
         */
        PortsBuilder portSpeed(long portSpeed);

        /**
         * Returns the builder object of yangPortsOpType.
         *
         * @param yangPortsOpType value of yangPortsOpType
         * @return yangPortsOpType
         */
        PortsBuilder yangPortsOpType(OnosYangOpType yangPortsOpType);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         PortsBuilder addYangAugmentedInfo(Object value, Class classObject);

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
        PortsBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of ports.
         *
         * @return ports
         */
        Ports build();
    }
}
