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
import org.onosproject.yang.gen.v1.test.test.test.Choice1;
import org.onosproject.yang.gen.v1.test.test.test.choice1.case1.DefaultList3;
import org.onosproject.yang.gen.v1.test.test.test.choice1.case1.List3;

/**
 * Represents the implementation of case1.
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
public class DefaultCase1 implements Case1 {
    protected int leaf3;
    protected List<Integer> leafList3;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangCase1OpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<List3> list3;

    @Override
    public int leaf3() {
        return leaf3;
    }

    @Override
    public List<Integer> leafList3() {
        return leafList3;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangCase1OpType() {
        return yangCase1OpType;
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
    public List<List3> list3() {
        return list3;
    }

    @Override
    public int hashCode() {
         return Objects.hash(leaf3, leafList3, valueLeafFlags, yangCase1OpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap, list3);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultCase1) {
            DefaultCase1 other = (DefaultCase1) obj;
            return
                Objects.equals(leaf3, other.leaf3) &&
                Objects.equals(leafList3, other.leafList3) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangCase1OpType, other.yangCase1OpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(list3, other.list3);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("leaf3", leaf3)
            .add("leafList3", leafList3)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangCase1OpType", yangCase1OpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("list3", list3)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of case1.
     *
     * @param builderObject value of builder object of case1
     */
    protected DefaultCase1(Case1Builder builderObject) {
        leaf3 = builderObject.leaf3();
        leafList3 = builderObject.leafList3();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangCase1OpType = builderObject.yangCase1OpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        list3 = builderObject.list3();
    }

    /**
     * Checks if the passed Choice1 maps the content match query condition.
     *
     * @param instance instance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultCase1 processSubtreeFiltering(Choice1 instance, boolean isSelectAllSchemaChild) {
        Case1Builder subTreeFilteringResultBuilder = new Case1Builder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
        DefaultCase1 appInstance = (DefaultCase1) instance;
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
        return (DefaultCase1) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Choice1 instance, Case1Builder subTreeFilteringResultBuilder, BitSet
                isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        DefaultCase1 appInstance = (DefaultCase1) instance;
        if (valueLeafFlags.get(LeafIdentifier.LEAF3.getLeafIndex())) {
            if (appInstance.leaf3() != leaf3()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.LEAF3)) {
                    subTreeFilteringResultBuilder.leaf3(leaf3());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.leaf3(appInstance.leaf3());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.LEAF3.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.leaf3(appInstance.leaf3());
        }

        return true;
    }

     private boolean processLeafListSubTreeFiltering(Choice1 instance, Case1Builder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        DefaultCase1 appInstance = (DefaultCase1) instance;
        if (isSelectAllSchemaChild) {
            if (appInstance.leafList3() != null) {
                for (Integer leafList3 : appInstance.leafList3()) {
                    subTreeFilteringResultBuilder.addToLeafList3(leafList3);
                }
            } else {
                if (isSubTreeFiltered && leafList3() != null) {
                    subTreeFilteringResultBuilder.leafList3(leafList3);
                }
            }
        } else if (leafList3() != null) {
            if (!leafList3().isEmpty()) {
                if (appInstance.leafList3() == null || appInstance.leafList3().isEmpty()) {
                    return false;
                }
                for (Integer leafList3 : leafList3()) {
                    boolean flag = false;
                    for (Integer leafList32 : appInstance.leafList3()) {
                        if (leafList3.equals(leafList32)) {
                            flag = true;
                            subTreeFilteringResultBuilder.addToLeafList3(leafList32);
                            break;
                        }
                    }
                    if (!flag) {
                        return false;
                    }
                }
            } else {
            isAnySelectOrContainmentNode.set(0);
                if (appInstance.leafList3() != null && !appInstance.leafList3().isEmpty()) {
                for (Integer leafList3 : appInstance.leafList3()) {
                        subTreeFilteringResultBuilder.addToLeafList3(leafList3);
                    }
                }
            }
        }

        return true;
    }

     private boolean processChildNodesSubTreeFiltering(Choice1 instance, Case1Builder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        DefaultCase1 appInstance = (DefaultCase1) instance;
        if (isSelectAllSchemaChild) {
            if (appInstance.list3() != null) {
                for (List3 list3 : appInstance.list3()) {
                    List3 result;
                    result = ((DefaultList3) DefaultList3.builder()
                            .buildForFilter()).processSubtreeFiltering(list3, true);
                    subTreeFilteringResultBuilder.addToList3(result);
                }
            } else {
                if (isSubTreeFiltered && list3() != null) {
                    subTreeFilteringResultBuilder.list3(list3);
                }
            }
        } else if (list3() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!list3().isEmpty()) {
                if (appInstance.list3() != null && !appInstance.list3().isEmpty()) {
                for (List3 list3 : list3()) {
                    for (List3 list32 : appInstance.list3()) {
                            List3 result = ((DefaultList3) list3)
                            .processSubtreeFiltering(list32, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToList3(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && list3() != null) {
                    subTreeFilteringResultBuilder.list3(list3);
                }
            }
            } else {
                if (appInstance.list3() != null && !appInstance.list3().isEmpty()) {
                for (List3 list3 : appInstance.list3()) {
                        subTreeFilteringResultBuilder.addToList3(list3);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultCase1.
     */
    protected DefaultCase1() {
    }

    /**
     * Returns the attribute case1Builder.
     *
     * @return case1Builder
     */
    public static Case1Builder builder() {
        return new Case1Builder();
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
     * Represents the builder implementation of case1.
     */
    public static class Case1Builder implements Case1.Case1Builder {
        protected int leaf3;
        protected List<Integer> leafList3;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangCase1OpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<List3> list3;



        @Override
        public int leaf3() {
            return leaf3;
        }

        @Override
        public List<Integer> leafList3() {
            return leafList3;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangCase1OpType() {
            return yangCase1OpType;
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
        public List<List3> list3() {
            return list3;
        }

        @Override
        public Case1Builder leaf3(int leaf3) {
            valueLeafFlags.set(LeafIdentifier.LEAF3.getLeafIndex());
            this.leaf3 = leaf3;
            return this;
        }

        @Override
        public Case1Builder leafList3(List<Integer> leafList3) {
            this.leafList3 = leafList3;
            return this;
        }

        @Override
        public Case1Builder yangCase1OpType(OnosYangOpType yangCase1OpType) {
            this.yangCase1OpType = yangCase1OpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public Case1Builder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public Case1Builder list3(List<List3> list3) {
            this.list3 = list3;
            return this;
        }

        @Override
        public Case1Builder addToLeafList3(Integer addTo) {
            if (leafList3 == null) {
                leafList3 = new ArrayList<>();
            }
            leafList3.add(addTo);
            return this;
        }


        @Override
        public Case1Builder addToList3(List3 addTo) {
            if (list3 == null) {
                list3 = new ArrayList<>();
            }
            list3.add(addTo);
            return this;
        }


        @Override
        public Case1Builder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public Case1Builder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public Case1 build() {
            return new DefaultCase1(this);
        }

        /**
         * Builds object of case1.
         *
         * @return case1
         */
        public Case1 buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultCase1(this);
        }
        /**
         * Creates an instance of case1Builder.
         */
        public Case1Builder() {
        }

    }
}
