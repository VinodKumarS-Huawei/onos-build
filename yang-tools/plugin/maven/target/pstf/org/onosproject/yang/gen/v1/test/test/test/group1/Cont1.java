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

package org.onosproject.yang.gen.v1.test.test.test.group1;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.test.test.Test.OnosYangOpType;
import org.onosproject.yang.gen.v1.test.test.test.group1.cont1.Cont2;
import org.onosproject.yang.gen.v1.test.test.test.group1.cont1.List1;

/**
 * Abstraction of an entity which represents the functionality of cont1.
 */
public interface Cont1 {

    /**
     * Identify the leaf of Cont1.
     */
    public enum LeafIdentifier {
        /**
         * Represents leaf1.
         */
        LEAF1(1);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute leaf1.
     *
     * @return leaf1 value of leaf1
     */
    int leaf1();

    /**
     * Returns the attribute leafList1.
     *
     * @return leafList1 list of leafList1
     */
    List<Integer> leafList1();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangCont1OpType.
     *
     * @return yangCont1OpType value of yangCont1OpType
     */
    OnosYangOpType yangCont1OpType();

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
     * Returns the attribute list1.
     *
     * @return list1 list of list1
     */
    List<List1> list1();

    /**
     * Returns the attribute cont2.
     *
     * @return cont2 value of cont2
     */
    Cont2 cont2();


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
     * Builder for cont1.
     */
    interface Cont1Builder {
        /**
         * Adds to the list of leafList1.
         *
         * @param addTo value of leafList1
         * @return builder object of leafList1
         */
         Cont1Builder addToLeafList1(Integer addTo);

        /**
         * Adds to the list of list1.
         *
         * @param addTo value of list1
         * @return builder object of list1
         */
         Cont1Builder addToList1(List1 addTo);

        /**
         * Returns the attribute leaf1.
         *
         * @return leaf1 value of leaf1
         */
        int leaf1();

        /**
         * Returns the attribute leafList1.
         *
         * @return leafList1 list of leafList1
         */
        List<Integer> leafList1();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangCont1OpType.
         *
         * @return yangCont1OpType value of yangCont1OpType
         */
        OnosYangOpType yangCont1OpType();

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
         * Returns the attribute list1.
         *
         * @return list1 list of list1
         */
        List<List1> list1();

        /**
         * Returns the attribute cont2.
         *
         * @return cont2 value of cont2
         */
        Cont2 cont2();

        /**
         * Returns the builder object of leaf1.
         *
         * @param leaf1 value of leaf1
         * @return leaf1
         */
        Cont1Builder leaf1(int leaf1);

        /**
         * Returns the builder object of leafList1.
         *
         * @param leafList1 list of leafList1
         * @return leafList1
         */
        Cont1Builder leafList1(List<Integer> leafList1);

        /**
         * Returns the builder object of yangCont1OpType.
         *
         * @param yangCont1OpType value of yangCont1OpType
         * @return yangCont1OpType
         */
        Cont1Builder yangCont1OpType(OnosYangOpType yangCont1OpType);

        /**
         * Returns the builder object of list1.
         *
         * @param list1 list of list1
         * @return list1
         */
        Cont1Builder list1(List<List1> list1);

        /**
         * Returns the builder object of cont2.
         *
         * @param cont2 value of cont2
         * @return cont2
         */
        Cont1Builder cont2(Cont2 cont2);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         Cont1Builder addYangAugmentedInfo(Object value, Class classObject);

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
        Cont1Builder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of cont1.
         *
         * @return cont1
         */
        Cont1 build();
    }
}
