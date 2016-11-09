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

package org.onosproject.yang.gen.v1.test.test.test.cont1.list1;

import java.util.BitSet;
import org.onosproject.yang.gen.v1.test.test.Test.OnosYangOpType;

/**
 * Abstraction of an entity which represents the functionality of augmentedList1.
 */
public interface AugmentedList1 {

    /**
     * Identify the leaf of AugmentedList1.
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
    long leaf2();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangAugmentedList1OpType.
     *
     * @return yangAugmentedList1OpType value of yangAugmentedList1OpType
     */
    OnosYangOpType yangAugmentedList1OpType();

    /**
     * Returns the attribute selectLeafFlags.
     *
     * @return selectLeafFlags value of selectLeafFlags
     */
    BitSet selectLeafFlags();


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
     * Builder for augmentedList1.
     */
    interface AugmentedList1Builder {
        /**
         * Returns the attribute leaf2.
         *
         * @return leaf2 value of leaf2
         */
        long leaf2();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangAugmentedList1OpType.
         *
         * @return yangAugmentedList1OpType value of yangAugmentedList1OpType
         */
        OnosYangOpType yangAugmentedList1OpType();

        /**
         * Returns the attribute selectLeafFlags.
         *
         * @return selectLeafFlags value of selectLeafFlags
         */
        BitSet selectLeafFlags();

        /**
         * Returns the builder object of leaf2.
         *
         * @param leaf2 value of leaf2
         * @return leaf2
         */
        AugmentedList1Builder leaf2(long leaf2);

        /**
         * Returns the builder object of yangAugmentedList1OpType.
         *
         * @param yangAugmentedList1OpType value of yangAugmentedList1OpType
         * @return yangAugmentedList1OpType
         */
        AugmentedList1Builder yangAugmentedList1OpType(OnosYangOpType yangAugmentedList1OpType);

        /**
         * Set a leaf to be selected.
         *
         * @param leaf leaf needs to be selected
         * @return builder object for select leaf
         */
        AugmentedList1Builder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of augmentedList1.
         *
         * @return augmentedList1
         */
        AugmentedList1 build();
    }
}
