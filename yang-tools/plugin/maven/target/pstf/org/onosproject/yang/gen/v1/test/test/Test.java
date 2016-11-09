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

package org.onosproject.yang.gen.v1.test.test;

import java.util.BitSet;
import java.util.List;
import org.onosproject.yang.gen.v1.test.test.test.Choice1;
import org.onosproject.yang.gen.v1.test.test.test.Cont1;
import org.onosproject.yang.gen.v1.test.test.test.List2;

/**
 * Abstraction of an entity which represents the functionality of test.
 */
public interface Test {
    /**
     * Specify the node specific operation in protocols like NETCONF.
     * Applicable in protocol edit operation, not applicable in query operation
     */
    public static enum OnosYangOpType {
        MERGE,
        REPLACE,
        CREATE,
        DELETE,
        REMOVE,
        NONE
    }

    /**
     * Identify the leaf of Test.
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
     * Returns the attribute leafList2.
     *
     * @return leafList2 list of leafList2
     */
    List<Integer> leafList2();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangTestOpType.
     *
     * @return yangTestOpType value of yangTestOpType
     */
    OnosYangOpType yangTestOpType();

    /**
     * Returns the attribute selectLeafFlags.
     *
     * @return selectLeafFlags value of selectLeafFlags
     */
    BitSet selectLeafFlags();

    /**
     * Returns the attribute cont1.
     *
     * @return cont1 value of cont1
     */
    Cont1 cont1();

    /**
     * Returns the attribute list2.
     *
     * @return list2 list of list2
     */
    List<List2> list2();

    /**
     * Returns the attribute choice1.
     *
     * @return choice1 value of choice1
     */
    Choice1 choice1();


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
     * Builder for test.
     */
    interface TestBuilder {
        /**
         * Adds to the list of leafList2.
         *
         * @param addTo value of leafList2
         * @return builder object of leafList2
         */
         TestBuilder addToLeafList2(Integer addTo);

        /**
         * Adds to the list of list2.
         *
         * @param addTo value of list2
         * @return builder object of list2
         */
         TestBuilder addToList2(List2 addTo);

        /**
         * Returns the attribute leaf2.
         *
         * @return leaf2 value of leaf2
         */
        int leaf2();

        /**
         * Returns the attribute leafList2.
         *
         * @return leafList2 list of leafList2
         */
        List<Integer> leafList2();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangTestOpType.
         *
         * @return yangTestOpType value of yangTestOpType
         */
        OnosYangOpType yangTestOpType();

        /**
         * Returns the attribute selectLeafFlags.
         *
         * @return selectLeafFlags value of selectLeafFlags
         */
        BitSet selectLeafFlags();

        /**
         * Returns the attribute cont1.
         *
         * @return cont1 value of cont1
         */
        Cont1 cont1();

        /**
         * Returns the attribute list2.
         *
         * @return list2 list of list2
         */
        List<List2> list2();

        /**
         * Returns the attribute choice1.
         *
         * @return choice1 value of choice1
         */
        Choice1 choice1();

        /**
         * Returns the builder object of leaf2.
         *
         * @param leaf2 value of leaf2
         * @return leaf2
         */
        TestBuilder leaf2(int leaf2);

        /**
         * Returns the builder object of leafList2.
         *
         * @param leafList2 list of leafList2
         * @return leafList2
         */
        TestBuilder leafList2(List<Integer> leafList2);

        /**
         * Returns the builder object of yangTestOpType.
         *
         * @param yangTestOpType value of yangTestOpType
         * @return yangTestOpType
         */
        TestBuilder yangTestOpType(OnosYangOpType yangTestOpType);

        /**
         * Returns the builder object of cont1.
         *
         * @param cont1 value of cont1
         * @return cont1
         */
        TestBuilder cont1(Cont1 cont1);

        /**
         * Returns the builder object of list2.
         *
         * @param list2 list of list2
         * @return list2
         */
        TestBuilder list2(List<List2> list2);

        /**
         * Returns the builder object of choice1.
         *
         * @param choice1 value of choice1
         * @return choice1
         */
        TestBuilder choice1(Choice1 choice1);

        /**
         * Set a leaf to be selected.
         *
         * @param leaf leaf needs to be selected
         * @return builder object for select leaf
         */
        TestBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of test.
         *
         * @return test
         */
        Test build();
    }
}
