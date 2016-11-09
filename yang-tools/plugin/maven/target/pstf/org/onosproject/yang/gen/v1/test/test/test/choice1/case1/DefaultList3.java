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

package org.onosproject.yang.gen.v1.test.test.test.choice1.case1;

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.test.test.Test.OnosYangOpType;

/**
 * Represents the implementation of list3.
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
public class DefaultList3 implements List3 {
    protected String name;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangList3OpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public String name() {
        return name;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangList3OpType() {
        return yangList3OpType;
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
    public int hashCode() {
        return Objects.hash(name, valueLeafFlags, yangList3OpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultList3) {
            DefaultList3 other = (DefaultList3) obj;
            return
                Objects.equals(name, other.name) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangList3OpType, other.yangList3OpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("name", name)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangList3OpType", yangList3OpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of list3.
     *
     * @param builderObject value of builder object of list3
     */
    protected DefaultList3(List3Builder builderObject) {
        name = builderObject.name();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangList3OpType = builderObject.yangList3OpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed List3 maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultList3 processSubtreeFiltering(List3 appInstance, boolean isSelectAllSchemaChild) {
        List3Builder subTreeFilteringResultBuilder = new List3Builder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
        if (!processLeafSubtreeFiltering(appInstance, subTreeFilteringResultBuilder, isAnySelectOrContainmentNode,
                    isSelectAllSchemaChild)) {
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
        return (DefaultList3) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(List3 appInstance, List3Builder subTreeFilteringResultBuilder, BitSet
                isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.NAME.getLeafIndex())) {
            if (appInstance.name() == null || !(name().equals(appInstance.name()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.NAME)) {
                    subTreeFilteringResultBuilder.name(name());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.name(appInstance.name());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.NAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.name(appInstance.name());
        }

        return true;
    }


    /**
     * Creates an instance of defaultList3.
     */
    protected DefaultList3() {
    }

    /**
     * Returns the attribute list3Builder.
     *
     * @return list3Builder
     */
    public static List3Builder builder() {
        return new List3Builder();
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
     * Represents the builder implementation of list3.
     */
    public static class List3Builder implements List3.List3Builder {
        protected String name;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangList3OpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public String name() {
            return name;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangList3OpType() {
            return yangList3OpType;
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
        public List3Builder name(String name) {
            valueLeafFlags.set(LeafIdentifier.NAME.getLeafIndex());
            this.name = name;
            return this;
        }

        @Override
        public List3Builder yangList3OpType(OnosYangOpType yangList3OpType) {
            this.yangList3OpType = yangList3OpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public List3Builder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public List3Builder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public List3Builder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public List3 build() {
            return new DefaultList3(this);
        }

        /**
         * Builds object of list3.
         *
         * @return list3
         */
        public List3 buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultList3(this);
        }
        /**
         * Creates an instance of list3Builder.
         */
        public List3Builder() {
        }

    }
}
