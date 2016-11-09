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

import com.google.common.base.MoreObjects;
import java.util.BitSet;
import java.util.Objects;
import org.onosproject.yang.gen.v1.test.test.Test.OnosYangOpType;

/**
 * Represents the implementation of augmentedList1.
 *
 * <p>
 * valueLeafFlags identify the leafs whose value are explicitly set
 * Applicable in protocol edit and query operation.
 * </p>
 *
 * <p>
 * selectLeafFlags identify the leafs to be selected, in a query operation.
 * </p>
 *
 * <p>
 * Operation type specify the node specific operation in protocols like NETCONF.
 * Applicable in protocol edit operation, not applicable in query operation.
 * </p>
 */
public class DefaultAugmentedList1 implements AugmentedList1 {
    protected long leaf2;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangAugmentedList1OpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();

    @Override
    public long leaf2() {
        return leaf2;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangAugmentedList1OpType() {
        return yangAugmentedList1OpType;
    }
    /**
     * Returns the attribute isSubTreeFiltered.
     *
     * @return isSubTreeFiltered value of isSubTreeFiltered
     */
    public boolean isSubTreeFiltered() {
        return isSubTreeFiltered;
    }

    @Override
    public BitSet selectLeafFlags() {
        return selectLeafFlags;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaf2, valueLeafFlags, yangAugmentedList1OpType, isSubTreeFiltered, selectLeafFlags);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultAugmentedList1) {
            DefaultAugmentedList1 other = (DefaultAugmentedList1) obj;
            return
                Objects.equals(leaf2, other.leaf2) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangAugmentedList1OpType, other.yangAugmentedList1OpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("leaf2", leaf2)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangAugmentedList1OpType", yangAugmentedList1OpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .toString();
    }
    /**
     * Creates an instance of augmentedList1.
     *
     * @param builderObject value of builder object of augmentedList1
     */
    protected DefaultAugmentedList1(AugmentedList1Builder builderObject) {
        leaf2 = builderObject.leaf2();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangAugmentedList1OpType = builderObject.yangAugmentedList1OpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
    }

    /**
     * Checks if the passed AugmentedList1 maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultAugmentedList1 processSubtreeFiltering(AugmentedList1 appInstance, boolean
                isSelectAllSchemaChild) {
        AugmentedList1Builder subTreeFilteringResultBuilder = new AugmentedList1Builder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
        if (!processLeafSubtreeFiltering(appInstance, subTreeFilteringResultBuilder, isAnySelectOrContainmentNode,
                    isSelectAllSchemaChild)) {
            return null;
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (DefaultAugmentedList1) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(AugmentedList1 appInstance, AugmentedList1Builder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.LEAF2.getLeafIndex())) {
            if (appInstance.leaf2() != leaf2()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.LEAF2)) {
                    subTreeFilteringResultBuilder.leaf2(leaf2());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.leaf2(appInstance.leaf2());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.LEAF2.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.leaf2(appInstance.leaf2());
        }

        return true;
    }


    /**
     * Creates an instance of defaultAugmentedList1.
     */
    protected DefaultAugmentedList1() {
    }

    /**
     * Returns the attribute augmentedList1Builder.
     *
     * @return augmentedList1Builder
     */
    public static AugmentedList1Builder builder() {
        return new AugmentedList1Builder();
    }

    @Override
    public boolean isLeafValueSet(LeafIdentifier leaf) {
        return valueLeafFlags.get(leaf.getLeafIndex());
    }

    @Override
    public boolean isSelectLeaf(LeafIdentifier leaf) {
        return selectLeafFlags.get(leaf.getLeafIndex());
    }

    /**
     * Represents the builder implementation of augmentedList1.
     */
    public static class AugmentedList1Builder implements AugmentedList1.AugmentedList1Builder {
        protected long leaf2;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangAugmentedList1OpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();



        @Override
        public long leaf2() {
            return leaf2;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangAugmentedList1OpType() {
            return yangAugmentedList1OpType;
        }
        /**
         * Returns the attribute isSubTreeFiltered.
         *
         * @return isSubTreeFiltered value of isSubTreeFiltered
         */
        public boolean isSubTreeFiltered() {
            return isSubTreeFiltered;
        }

        @Override
        public BitSet selectLeafFlags() {
            return selectLeafFlags;
        }

        @Override
        public AugmentedList1Builder leaf2(long leaf2) {
            valueLeafFlags.set(LeafIdentifier.LEAF2.getLeafIndex());
            this.leaf2 = leaf2;
            return this;
        }

        @Override
        public AugmentedList1Builder yangAugmentedList1OpType(OnosYangOpType yangAugmentedList1OpType) {
            this.yangAugmentedList1OpType = yangAugmentedList1OpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public AugmentedList1Builder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public AugmentedList1Builder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }
        @Override
        public AugmentedList1 build() {
            return new DefaultAugmentedList1(this);
        }

        /**
         * Builds object of augmentedList1.
         *
         * @return augmentedList1
         */
        public AugmentedList1 buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultAugmentedList1(this);
        }
        /**
         * Creates an instance of augmentedList1Builder.
         */
        public AugmentedList1Builder() {
        }

    }
}
