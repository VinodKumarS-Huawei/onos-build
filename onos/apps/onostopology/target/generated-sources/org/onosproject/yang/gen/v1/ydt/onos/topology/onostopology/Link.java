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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopology.OnosYangOpType;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.link.LeafTypeEnum;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.link.StateEnum;

/**
 * Abstraction of an entity which represents the functionality of link.
 */
public interface Link {

    /**
     * Identify the leaf of Link.
     */
    public enum LeafIdentifier {
        /**
         * Represents srcDeviceId.
         */
        SRCDEVICEID(1),
        /**
         * Represents srcPortNumber.
         */
        SRCPORTNUMBER(2),
        /**
         * Represents dstDeviceId.
         */
        DSTDEVICEID(3),
        /**
         * Represents dstPortNumber.
         */
        DSTPORTNUMBER(4),
        /**
         * Represents leafType.
         */
        LEAFTYPE(5),
        /**
         * Represents state.
         */
        STATE(6),
        /**
         * Represents isDurable.
         */
        ISDURABLE(7),
        /**
         * Represents isExpected.
         */
        ISEXPECTED(8);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute srcDeviceId.
     *
     * @return srcDeviceId value of srcDeviceId
     */
    DeviceId srcDeviceId();

    /**
     * Returns the attribute srcPortNumber.
     *
     * @return srcPortNumber value of srcPortNumber
     */
    long srcPortNumber();

    /**
     * Returns the attribute dstDeviceId.
     *
     * @return dstDeviceId value of dstDeviceId
     */
    DeviceId dstDeviceId();

    /**
     * Returns the attribute dstPortNumber.
     *
     * @return dstPortNumber value of dstPortNumber
     */
    long dstPortNumber();

    /**
     * Returns the attribute leafType.
     *
     * @return leafType value of leafType
     */
    LeafTypeEnum leafType();

    /**
     * Returns the attribute state.
     *
     * @return state value of state
     */
    StateEnum state();

    /**
     * Returns the attribute isDurable.
     *
     * @return isDurable value of isDurable
     */
    boolean isDurable();

    /**
     * Returns the attribute isExpected.
     *
     * @return isExpected value of isExpected
     */
    boolean isExpected();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangLinkOpType.
     *
     * @return yangLinkOpType value of yangLinkOpType
     */
    OnosYangOpType yangLinkOpType();

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
     * Builder for link.
     */
    interface LinkBuilder {
        /**
         * Returns the attribute srcDeviceId.
         *
         * @return srcDeviceId value of srcDeviceId
         */
        DeviceId srcDeviceId();

        /**
         * Returns the attribute srcPortNumber.
         *
         * @return srcPortNumber value of srcPortNumber
         */
        long srcPortNumber();

        /**
         * Returns the attribute dstDeviceId.
         *
         * @return dstDeviceId value of dstDeviceId
         */
        DeviceId dstDeviceId();

        /**
         * Returns the attribute dstPortNumber.
         *
         * @return dstPortNumber value of dstPortNumber
         */
        long dstPortNumber();

        /**
         * Returns the attribute leafType.
         *
         * @return leafType value of leafType
         */
        LeafTypeEnum leafType();

        /**
         * Returns the attribute state.
         *
         * @return state value of state
         */
        StateEnum state();

        /**
         * Returns the attribute isDurable.
         *
         * @return isDurable value of isDurable
         */
        boolean isDurable();

        /**
         * Returns the attribute isExpected.
         *
         * @return isExpected value of isExpected
         */
        boolean isExpected();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangLinkOpType.
         *
         * @return yangLinkOpType value of yangLinkOpType
         */
        OnosYangOpType yangLinkOpType();

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
         * Returns the builder object of srcDeviceId.
         *
         * @param srcDeviceId value of srcDeviceId
         * @return srcDeviceId
         */
        LinkBuilder srcDeviceId(DeviceId srcDeviceId);

        /**
         * Returns the builder object of srcPortNumber.
         *
         * @param srcPortNumber value of srcPortNumber
         * @return srcPortNumber
         */
        LinkBuilder srcPortNumber(long srcPortNumber);

        /**
         * Returns the builder object of dstDeviceId.
         *
         * @param dstDeviceId value of dstDeviceId
         * @return dstDeviceId
         */
        LinkBuilder dstDeviceId(DeviceId dstDeviceId);

        /**
         * Returns the builder object of dstPortNumber.
         *
         * @param dstPortNumber value of dstPortNumber
         * @return dstPortNumber
         */
        LinkBuilder dstPortNumber(long dstPortNumber);

        /**
         * Returns the builder object of leafType.
         *
         * @param leafType value of leafType
         * @return leafType
         */
        LinkBuilder leafType(LeafTypeEnum leafType);

        /**
         * Returns the builder object of state.
         *
         * @param state value of state
         * @return state
         */
        LinkBuilder state(StateEnum state);

        /**
         * Returns the builder object of isDurable.
         *
         * @param isDurable value of isDurable
         * @return isDurable
         */
        LinkBuilder isDurable(boolean isDurable);

        /**
         * Returns the builder object of isExpected.
         *
         * @param isExpected value of isExpected
         * @return isExpected
         */
        LinkBuilder isExpected(boolean isExpected);

        /**
         * Returns the builder object of yangLinkOpType.
         *
         * @param yangLinkOpType value of yangLinkOpType
         * @return yangLinkOpType
         */
        LinkBuilder yangLinkOpType(OnosYangOpType yangLinkOpType);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         LinkBuilder addYangAugmentedInfo(Object value, Class classObject);

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
        LinkBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of link.
         *
         * @return link
         */
        Link build();
    }
}
