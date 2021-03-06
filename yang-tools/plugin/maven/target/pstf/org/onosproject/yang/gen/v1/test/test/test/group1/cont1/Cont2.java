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

package org.onosproject.yang.gen.v1.test.test.test.group1.cont1;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.test.test.Test.OnosYangOpType;

/**
 * Abstraction of an entity which represents the functionality of cont2.
 */
public interface Cont2 {

    /**
     * Identify the leaf of Cont2.
     */
    public enum LeafIdentifier {
        /**
         * Represents leaf2.
         */
        LEAF2(1);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute leaf2.
     *
     * @return leaf2 value of leaf2
     */
    int leaf2();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangCont2OpType.
     *
     * @return yangCont2OpType value of yangCont2OpType
     */
    OnosYangOpType yangCont2OpType();

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
     * Builder for cont2.
     */
    interface Cont2Builder {
        /**
         * Returns the attribute leaf2.
         *
         * @return leaf2 value of leaf2
         */
        int leaf2();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangCont2OpType.
         *
         * @return yangCont2OpType value of yangCont2OpType
         */
        OnosYangOpType yangCont2OpType();

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
         * Returns the builder object of leaf2.
         *
         * @param leaf2 value of leaf2
         * @return leaf2
         */
        Cont2Builder leaf2(int leaf2);

        /**
         * Returns the builder object of yangCont2OpType.
         *
         * @param yangCont2OpType value of yangCont2OpType
         * @return yangCont2OpType
         */
        Cont2Builder yangCont2OpType(OnosYangOpType yangCont2OpType);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         Cont2Builder addYangAugmentedInfo(Object value, Class classObject);

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
        Cont2Builder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of cont2.
         *
         * @return cont2
         */
        Cont2 build();
    }
}
