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

package org.onosproject.yang.gen.v1.test.test.test.cont1;

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
 * Represents the implementation of cont2.
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
public class DefaultCont2 implements Cont2 {
    protected int leaf2;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangCont2OpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public int leaf2() {
        return leaf2;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangCont2OpType() {
        return yangCont2OpType;
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
        return Objects.hash(leaf2, valueLeafFlags, yangCont2OpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultCont2) {
            DefaultCont2 other = (DefaultCont2) obj;
            return
                Objects.equals(leaf2, other.leaf2) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangCont2OpType, other.yangCont2OpType) &&
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
            .add("leaf2", leaf2)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangCont2OpType", yangCont2OpType)
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
     * Creates an instance of cont2.
     *
     * @param builderObject value of builder object of cont2
     */
    protected DefaultCont2(Cont2Builder builderObject) {
        leaf2 = builderObject.leaf2();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangCont2OpType = builderObject.yangCont2OpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed Cont2 maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultCont2 processSubtreeFiltering(Cont2 appInstance, boolean isSelectAllSchemaChild) {
        Cont2Builder subTreeFilteringResultBuilder = new Cont2Builder();
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
        return (DefaultCont2) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Cont2 appInstance, Cont2Builder subTreeFilteringResultBuilder, BitSet
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


    /**
     * Creates an instance of defaultCont2.
     */
    protected DefaultCont2() {
    }

    /**
     * Returns the attribute cont2Builder.
     *
     * @return cont2Builder
     */
    public static Cont2Builder builder() {
        return new Cont2Builder();
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
     * Represents the builder implementation of cont2.
     */
    public static class Cont2Builder implements Cont2.Cont2Builder {
        protected int leaf2;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangCont2OpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public int leaf2() {
            return leaf2;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangCont2OpType() {
            return yangCont2OpType;
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
        public Cont2Builder leaf2(int leaf2) {
            valueLeafFlags.set(LeafIdentifier.LEAF2.getLeafIndex());
            this.leaf2 = leaf2;
            return this;
        }

        @Override
        public Cont2Builder yangCont2OpType(OnosYangOpType yangCont2OpType) {
            this.yangCont2OpType = yangCont2OpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public Cont2Builder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public Cont2Builder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public Cont2Builder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public Cont2 build() {
            return new DefaultCont2(this);
        }

        /**
         * Builds object of cont2.
         *
         * @return cont2
         */
        public Cont2 buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultCont2(this);
        }
        /**
         * Creates an instance of cont2Builder.
         */
        public Cont2Builder() {
        }

    }
}
