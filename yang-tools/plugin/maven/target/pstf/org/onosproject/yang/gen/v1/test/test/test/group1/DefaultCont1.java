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

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.test.test.Test.OnosYangOpType;
import org.onosproject.yang.gen.v1.test.test.test.group1.cont1.Cont2;
import org.onosproject.yang.gen.v1.test.test.test.group1.cont1.DefaultCont2;
import org.onosproject.yang.gen.v1.test.test.test.group1.cont1.DefaultList1;
import org.onosproject.yang.gen.v1.test.test.test.group1.cont1.List1;

/**
 * Represents the implementation of cont1.
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
public class DefaultCont1 implements Cont1 {
    protected int leaf1;
    protected List<Integer> leafList1;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangCont1OpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<List1> list1;
    protected Cont2 cont2;

    @Override
    public int leaf1() {
        return leaf1;
    }

    @Override
    public List<Integer> leafList1() {
        return leafList1;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangCont1OpType() {
        return yangCont1OpType;
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
    public Map<Class<?>, Object> yangAugmentedInfoMap() {
        return yangAugmentedInfoMap;
    }

    @Override
    public List<List1> list1() {
        return list1;
    }

    @Override
    public Cont2 cont2() {
        return cont2;
    }

    @Override
    public int hashCode() {
         return Objects.hash(leaf1, leafList1, valueLeafFlags, yangCont1OpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap, list1, cont2);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultCont1) {
            DefaultCont1 other = (DefaultCont1) obj;
            return
                Objects.equals(leaf1, other.leaf1) &&
                Objects.equals(leafList1, other.leafList1) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangCont1OpType, other.yangCont1OpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(list1, other.list1) &&
                Objects.equals(cont2, other.cont2);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("leaf1", leaf1)
            .add("leafList1", leafList1)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangCont1OpType", yangCont1OpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("list1", list1)
            .add("cont2", cont2)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of cont1.
     *
     * @param builderObject value of builder object of cont1
     */
    protected DefaultCont1(Cont1Builder builderObject) {
        leaf1 = builderObject.leaf1();
        leafList1 = builderObject.leafList1();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangCont1OpType = builderObject.yangCont1OpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        list1 = builderObject.list1();
        cont2 = builderObject.cont2();
    }

    /**
     * Checks if the passed Cont1 maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultCont1 processSubtreeFiltering(Cont1 appInstance, boolean isSelectAllSchemaChild) {
        Cont1Builder subTreeFilteringResultBuilder = new Cont1Builder();
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
        if (yangAugmentedInfoMap.isEmpty()) {
            Set<Map.Entry<Class<?>, Object>> augment = appInstance.yangAugmentedInfoMap().entrySet();
            if (augment != null && !augment.isEmpty()) {
                Iterator<Map.Entry<Class<?>, Object>> augItr = augment.iterator();
                while (augItr.hasNext()) {
                    Map.Entry<Class<?>, Object> aug = augItr.next();
                    Class<?> augClass = aug.getKey();
                    String augClassName = augClass.getName();
                    int index = augClassName.lastIndexOf('.');
                    String classPackage = augClassName.substring(0, index) +
                            "." + "Default" + augClass.getSimpleName() + "$"
                            + augClass.getSimpleName() + "Builder";
                    ClassLoader classLoader = augClass.getClassLoader();
                    try {
                        Class<?> builderClass;
                        builderClass = classLoader.loadClass(classPackage);
                        Object builderObj = builderClass.newInstance();
                        Method method = builderClass.getMethod("build");
                        Object defaultObj = method.invoke(builderObj);
                        Class<?> defaultClass = defaultObj.getClass();
                        method = defaultClass.getMethod
                                ("processSubtreeFiltering", augClass,
                                 boolean.class);
                        Object result = method.invoke(defaultObj, aug.getValue(),
                                                      true);
                        subTreeFilteringResultBuilder
                                .addYangAugmentedInfo(result, augClass);
                    } catch (ClassNotFoundException | InstantiationException
                            | NoSuchMethodException |
                            InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Set<Map.Entry<Class<?>, Object>> augment = yangAugmentedInfoMap
                    .entrySet();
            Iterator<Map.Entry<Class<?>, Object>> augItr = augment.iterator();
            while (augItr.hasNext()) {
                Map.Entry<Class<?>, Object> aug = augItr.next();
                Class<?> augClass = aug.getKey();
                Object appInstanceInfo = appInstance.yangAugmentedInfo(augClass);
                if (appInstanceInfo == null) {
                    subTreeFilteringResultBuilder.addYangAugmentedInfo
                            (aug.getValue(), aug.getKey());
                } else {
                    Object processSubtreeFiltering;
                    try {
                        processSubtreeFiltering = aug.getValue().getClass()
                                .getMethod("processSubtreeFiltering",
                                           aug.getKey(), boolean.class)
                                .invoke(aug.getValue(),
                                        appInstanceInfo, true);
                        if (processSubtreeFiltering != null) {
                            subTreeFilteringResultBuilder
                                    .addYangAugmentedInfo(processSubtreeFiltering, aug.getKey());
                        }
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (DefaultCont1) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Cont1 appInstance, Cont1Builder subTreeFilteringResultBuilder, BitSet
                isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.LEAF1.getLeafIndex())) {
            if (appInstance.leaf1() != leaf1()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.LEAF1)) {
                    subTreeFilteringResultBuilder.leaf1(leaf1());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.leaf1(appInstance.leaf1());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.LEAF1.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.leaf1(appInstance.leaf1());
        }

        return true;
    }

     private boolean processLeafListSubTreeFiltering(Cont1 appInstance, Cont1Builder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.leafList1() != null) {
                for (Integer leafList1 : appInstance.leafList1()) {
                    subTreeFilteringResultBuilder.addToLeafList1(leafList1);
                }
            } else {
                if (isSubTreeFiltered && leafList1() != null) {
                    subTreeFilteringResultBuilder.leafList1(leafList1);
                }
            }
        } else if (leafList1() != null) {
            if (!leafList1().isEmpty()) {
                if (appInstance.leafList1() == null || appInstance.leafList1().isEmpty()) {
                    return false;
                }
                for (Integer leafList1 : leafList1()) {
                    boolean flag = false;
                    for (Integer leafList12 : appInstance.leafList1()) {
                        if (leafList1.equals(leafList12)) {
                            flag = true;
                            subTreeFilteringResultBuilder.addToLeafList1(leafList12);
                            break;
                        }
                    }
                    if (!flag) {
                        return false;
                    }
                }
            } else {
            isAnySelectOrContainmentNode.set(0);
                if (appInstance.leafList1() != null && !appInstance.leafList1().isEmpty()) {
                for (Integer leafList1 : appInstance.leafList1()) {
                        subTreeFilteringResultBuilder.addToLeafList1(leafList1);
                    }
                }
            }
        }

        return true;
    }

     private boolean processChildNodesSubTreeFiltering(Cont1 appInstance, Cont1Builder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.list1() != null) {
                for (List1 list1 : appInstance.list1()) {
                    List1 result;
                    result = ((DefaultList1) DefaultList1.builder()
                            .buildForFilter()).processSubtreeFiltering(list1, true);
                    subTreeFilteringResultBuilder.addToList1(result);
                }
            } else {
                if (isSubTreeFiltered && list1() != null) {
                    subTreeFilteringResultBuilder.list1(list1);
                }
            }
        } else if (list1() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!list1().isEmpty()) {
                if (appInstance.list1() != null && !appInstance.list1().isEmpty()) {
                for (List1 list1 : list1()) {
                    for (List1 list12 : appInstance.list1()) {
                            List1 result = ((DefaultList1) list1)
                            .processSubtreeFiltering(list12, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToList1(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && list1() != null) {
                    subTreeFilteringResultBuilder.list1(list1);
                }
            }
            } else {
                if (appInstance.list1() != null && !appInstance.list1().isEmpty()) {
                for (List1 list1 : appInstance.list1()) {
                        subTreeFilteringResultBuilder.addToList1(list1);
                    }
                }
            }
        }

        if (cont2() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.cont2() != null) {
                Cont2 result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultCont2) DefaultCont2.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.cont2(), true);
                } else {
                    result = ((DefaultCont2) cont2)
                            .processSubtreeFiltering(appInstance.cont2(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.cont2(result);
                }
            } else {
                if (isSubTreeFiltered && cont2() != null) {
                    subTreeFilteringResultBuilder.cont2(cont2);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultCont1.
     */
    protected DefaultCont1() {
    }

    /**
     * Returns the attribute cont1Builder.
     *
     * @return cont1Builder
     */
    public static Cont1Builder builder() {
        return new Cont1Builder();
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
     * Represents the builder implementation of cont1.
     */
    public static class Cont1Builder implements Cont1.Cont1Builder {
        protected int leaf1;
        protected List<Integer> leafList1;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangCont1OpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<List1> list1;
        protected Cont2 cont2;



        @Override
        public int leaf1() {
            return leaf1;
        }

        @Override
        public List<Integer> leafList1() {
            return leafList1;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangCont1OpType() {
            return yangCont1OpType;
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
        public Map<Class<?>, Object> yangAugmentedInfoMap() {
            return yangAugmentedInfoMap;
        }

        @Override
        public List<List1> list1() {
            return list1;
        }

        @Override
        public Cont2 cont2() {
            return cont2;
        }

        @Override
        public Cont1Builder leaf1(int leaf1) {
            valueLeafFlags.set(LeafIdentifier.LEAF1.getLeafIndex());
            this.leaf1 = leaf1;
            return this;
        }

        @Override
        public Cont1Builder leafList1(List<Integer> leafList1) {
            this.leafList1 = leafList1;
            return this;
        }

        @Override
        public Cont1Builder yangCont1OpType(OnosYangOpType yangCont1OpType) {
            this.yangCont1OpType = yangCont1OpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public Cont1Builder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public Cont1Builder list1(List<List1> list1) {
            this.list1 = list1;
            return this;
        }

        @Override
        public Cont1Builder cont2(Cont2 cont2) {
            this.cont2 = cont2;
            return this;
        }

        @Override
        public Cont1Builder addToLeafList1(Integer addTo) {
            if (leafList1 == null) {
                leafList1 = new ArrayList<>();
            }
            leafList1.add(addTo);
            return this;
        }


        @Override
        public Cont1Builder addToList1(List1 addTo) {
            if (list1 == null) {
                list1 = new ArrayList<>();
            }
            list1.add(addTo);
            return this;
        }


        @Override
        public Cont1Builder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public Cont1Builder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public Cont1 build() {
            return new DefaultCont1(this);
        }

        /**
         * Builds object of cont1.
         *
         * @return cont1
         */
        public Cont1 buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultCont1(this);
        }
        /**
         * Creates an instance of cont1Builder.
         */
        public Cont1Builder() {
        }

    }
}
