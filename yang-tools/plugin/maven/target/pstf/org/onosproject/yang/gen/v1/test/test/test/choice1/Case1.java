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

package org.onosproject.yang.gen.v1.test.test.test.choice1;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.test.test.Test.OnosYangOpType;
import org.onosproject.yang.gen.v1.test.test.test.Choice1;
import org.onosproject.yang.gen.v1.test.test.test.choice1.case1.List3;

/**
 * Abstraction of an entity which represents the functionality of case1.
 */
public interface Case1 extends Choice1  {

    /**
     * Identify the leaf of Case1.
     */
    public enum LeafIdentifier {
        /**
         * Represents leaf3.
         */
        LEAF3(1);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute leaf3.
     *
     * @return leaf3 value of leaf3
     */
    int leaf3();

    /**
     * Returns the attribute leafList3.
     *
     * @return leafList3 list of leafList3
     */
    List<Integer> leafList3();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangCase1OpType.
     *
     * @return yangCase1OpType value of yangCase1OpType
     */
    OnosYangOpType yangCase1OpType();

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
     * Returns the attribute list3.
     *
     * @return list3 list of list3
     */
    List<List3> list3();


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
     * Builder for case1.
     */
    interface Case1Builder {
        /**
         * Adds to the list of leafList3.
         *
         * @param addTo value of leafList3
         * @return builder object of leafList3
         */
         Case1Builder addToLeafList3(Integer addTo);

        /**
         * Adds to the list of list3.
         *
         * @param addTo value of list3
         * @return builder object of list3
         */
         Case1Builder addToList3(List3 addTo);

        /**
         * Returns the attribute leaf3.
         *
         * @return leaf3 value of leaf3
         */
        int leaf3();

        /**
         * Returns the attribute leafList3.
         *
         * @return leafList3 list of leafList3
         */
        List<Integer> leafList3();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangCase1OpType.
         *
         * @return yangCase1OpType value of yangCase1OpType
         */
        OnosYangOpType yangCase1OpType();

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
         * Returns the attribute list3.
         *
         * @return list3 list of list3
         */
        List<List3> list3();

        /**
         * Returns the builder object of leaf3.
         *
         * @param leaf3 value of leaf3
         * @return leaf3
         */
        Case1Builder leaf3(int leaf3);

        /**
         * Returns the builder object of leafList3.
         *
         * @param leafList3 list of leafList3
         * @return leafList3
         */
        Case1Builder leafList3(List<Integer> leafList3);

        /**
         * Returns the builder object of yangCase1OpType.
         *
         * @param yangCase1OpType value of yangCase1OpType
         * @return yangCase1OpType
         */
        Case1Builder yangCase1OpType(OnosYangOpType yangCase1OpType);

        /**
         * Returns the builder object of list3.
         *
         * @param list3 list of list3
         * @return list3
         */
        Case1Builder list3(List<List3> list3);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         Case1Builder addYangAugmentedInfo(Object value, Class classObject);

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
        Case1Builder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of case1.
         *
         * @return case1
         */
        Case1 build();
    }
}
