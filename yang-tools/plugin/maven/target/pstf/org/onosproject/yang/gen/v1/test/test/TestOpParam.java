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

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;
import org.onosproject.yang.gen.v1.test.test.test.Choice1;
import org.onosproject.yang.gen.v1.test.test.test.Cont1;
import org.onosproject.yang.gen.v1.test.test.test.DefaultCont1;
import org.onosproject.yang.gen.v1.test.test.test.DefaultList2;
import org.onosproject.yang.gen.v1.test.test.test.List2;

/**
 * Represents the implementation of test.
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
public class TestOpParam implements Test {
    protected int leaf2;
    protected List<Integer> leafList2;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangTestOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Cont1 cont1;
    protected List<List2> list2;
    protected Choice1 choice1;

    @Override
    public int leaf2() {
        return leaf2;
    }

    @Override
    public List<Integer> leafList2() {
        return leafList2;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangTestOpType() {
        return yangTestOpType;
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
    public Cont1 cont1() {
        return cont1;
    }

    @Override
    public List<List2> list2() {
        return list2;
    }

    @Override
    public Choice1 choice1() {
        return choice1;
    }

    @Override
    public int hashCode() {
         return Objects.hash(leaf2, leafList2, valueLeafFlags, yangTestOpType, isSubTreeFiltered, selectLeafFlags,
                    cont1, list2, choice1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TestOpParam) {
            TestOpParam other = (TestOpParam) obj;
            return
                Objects.equals(leaf2, other.leaf2) &&
                Objects.equals(leafList2, other.leafList2) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangTestOpType, other.yangTestOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(cont1, other.cont1) &&
                Objects.equals(list2, other.list2) &&
                Objects.equals(choice1, other.choice1);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("leaf2", leaf2)
            .add("leafList2", leafList2)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangTestOpType", yangTestOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("cont1", cont1)
            .add("list2", list2)
            .add("choice1", choice1)
            .toString();
    }
    /**
     * Creates an instance of test.
     *
     * @param builderObject value of builder object of test
     */
    protected TestOpParam(TestBuilder builderObject) {
        leaf2 = builderObject.leaf2();
        leafList2 = builderObject.leafList2();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangTestOpType = builderObject.yangTestOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        cont1 = builderObject.cont1();
        list2 = builderObject.list2();
        choice1 = builderObject.choice1();
    }

    /**
     * Checks if the passed Test maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public TestOpParam processSubtreeFiltering(Test appInstance, boolean isSelectAllSchemaChild) {
        TestBuilder subTreeFilteringResultBuilder = new TestBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
        if (!processLeafSubtreeFiltering(appInstance, subTreeFilteringResultBuilder, isAnySelectOrContainmentNode,
                    isSelectAllSchemaChild)) {
            return null;
        }
         if (!processLeafListSubTreeFiltering(appInstance, subTreeFilteringResultBuilder,
                    isAnySelectOrContainmentNode, isSelectAllSchemaChild)) {
            return null;
        }
         if (!processChildNodesSubTreeFiltering(appInstance, subTreeFilteringResultBuilder,
                    isAnySelectOrContainmentNode, isSelectAllSchemaChild)) {
            return null;
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (TestOpParam) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Test appInstance, TestBuilder subTreeFilteringResultBuilder, BitSet
                isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
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

     private boolean processLeafListSubTreeFiltering(Test appInstance, TestBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.leafList2() != null) {
                for (Integer leafList2 : appInstance.leafList2()) {
                    subTreeFilteringResultBuilder.addToLeafList2(leafList2);
                }
            } else {
                if (isSubTreeFiltered && leafList2() != null) {
                    subTreeFilteringResultBuilder.leafList2(leafList2);
                }
            }
        } else if (leafList2() != null) {
            if (!leafList2().isEmpty()) {
                if (appInstance.leafList2() == null || appInstance.leafList2().isEmpty()) {
                    return false;
                }
                for (Integer leafList2 : leafList2()) {
                    boolean flag = false;
                    for (Integer leafList22 : appInstance.leafList2()) {
                        if (leafList2.equals(leafList22)) {
                            flag = true;
                            subTreeFilteringResultBuilder.addToLeafList2(leafList22);
                            break;
                        }
                    }
                    if (!flag) {
                        return false;
                    }
                }
            } else {
            isAnySelectOrContainmentNode.set(0);
                if (appInstance.leafList2() != null && !appInstance.leafList2().isEmpty()) {
                for (Integer leafList2 : appInstance.leafList2()) {
                        subTreeFilteringResultBuilder.addToLeafList2(leafList2);
                    }
                }
            }
        }

        return true;
    }

     private boolean processChildNodesSubTreeFiltering(Test appInstance, TestBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (cont1() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.cont1() != null) {
                Cont1 result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultCont1) DefaultCont1.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.cont1(), true);
                } else {
                    result = ((DefaultCont1) cont1)
                            .processSubtreeFiltering(appInstance.cont1(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.cont1(result);
                }
            } else {
                if (isSubTreeFiltered && cont1() != null) {
                    subTreeFilteringResultBuilder.cont1(cont1);
                }
            }
        }

        if (isSelectAllSchemaChild) {
            if (appInstance.list2() != null) {
                for (List2 list2 : appInstance.list2()) {
                    List2 result;
                    result = ((DefaultList2) DefaultList2.builder()
                            .buildForFilter()).processSubtreeFiltering(list2, true);
                    subTreeFilteringResultBuilder.addToList2(result);
                }
            } else {
                if (isSubTreeFiltered && list2() != null) {
                    subTreeFilteringResultBuilder.list2(list2);
                }
            }
        } else if (list2() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!list2().isEmpty()) {
                if (appInstance.list2() != null && !appInstance.list2().isEmpty()) {
                for (List2 list2 : list2()) {
                    for (List2 list22 : appInstance.list2()) {
                            List2 result = ((DefaultList2) list2)
                            .processSubtreeFiltering(list22, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToList2(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && list2() != null) {
                    subTreeFilteringResultBuilder.list2(list2);
                }
            }
            } else {
                if (appInstance.list2() != null && !appInstance.list2().isEmpty()) {
                for (List2 list2 : appInstance.list2()) {
                        subTreeFilteringResultBuilder.addToList2(list2);
                    }
                }
            }
        }

        if (choice1() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.choice1() != null) {
                Choice1 result = null;
                if (isSelectAllSchemaChild) {
                    Class<?>[] classArray = appInstance.choice1().getClass().getInterfaces();
                    Class<?> caseClass = classArray[0];
                    try {
                        Object obj1 = caseClass.newInstance();
                        Method method = caseClass.getMethod("builder", caseClass);
                        Object obj = method.invoke(obj1, (Object) null);
                        method = caseClass.getMethod("build", caseClass);
                        Object obj2 = method.invoke(obj, (Object) null);
                        method = caseClass.getMethod("processSubtreeFiltering", caseClass);
                        result = (Choice1) method.invoke(obj2, appInstance.choice1(), true);
                    } catch (NoSuchMethodException | InstantiationException |
                            IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else {
                    result = choice1
                            .processSubtreeFiltering(appInstance.choice1(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.choice1(result);
                }
            } else {
                if (isSubTreeFiltered && choice1() != null) {
                    subTreeFilteringResultBuilder.choice1(choice1);
                }
            }
        }

        return true;
    }

    /**
     * Creates an instance of testOpParam.
     */
    protected TestOpParam() {
    }

    /**
     * Returns the attribute testBuilder.
     *
     * @return testBuilder
     */
    public static TestBuilder builder() {
        return new TestBuilder();
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
     * Represents the builder implementation of test.
     */
    public static class TestBuilder implements Test.TestBuilder {
        protected int leaf2;
        protected List<Integer> leafList2;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangTestOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Cont1 cont1;
        protected List<List2> list2;
        protected Choice1 choice1;



        @Override
        public int leaf2() {
            return leaf2;
        }

        @Override
        public List<Integer> leafList2() {
            return leafList2;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangTestOpType() {
            return yangTestOpType;
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
        public Cont1 cont1() {
            return cont1;
        }

        @Override
        public List<List2> list2() {
            return list2;
        }

        @Override
        public Choice1 choice1() {
            return choice1;
        }

        @Override
        public TestBuilder leaf2(int leaf2) {
            valueLeafFlags.set(LeafIdentifier.LEAF2.getLeafIndex());
            this.leaf2 = leaf2;
            return this;
        }

        @Override
        public TestBuilder leafList2(List<Integer> leafList2) {
            this.leafList2 = leafList2;
            return this;
        }

        @Override
        public TestBuilder yangTestOpType(OnosYangOpType yangTestOpType) {
            this.yangTestOpType = yangTestOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public TestBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public TestBuilder cont1(Cont1 cont1) {
            this.cont1 = cont1;
            return this;
        }

        @Override
        public TestBuilder list2(List<List2> list2) {
            this.list2 = list2;
            return this;
        }

        @Override
        public TestBuilder choice1(Choice1 choice1) {
            this.choice1 = choice1;
            return this;
        }

        @Override
        public TestBuilder addToLeafList2(Integer addTo) {
            if (leafList2 == null) {
                leafList2 = new ArrayList<>();
            }
            leafList2.add(addTo);
            return this;
        }


        @Override
        public TestBuilder addToList2(List2 addTo) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.add(addTo);
            return this;
        }


        @Override
        public TestBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }
        @Override
        public Test build() {
            return new TestOpParam(this);
        }

        /**
         * Builds object of test.
         *
         * @return test
         */
        public Test buildForFilter() {
            isSubTreeFiltered = true;
            return new TestOpParam(this);
        }
        /**
         * Creates an instance of testBuilder.
         */
        public TestBuilder() {
        }

    }
}
