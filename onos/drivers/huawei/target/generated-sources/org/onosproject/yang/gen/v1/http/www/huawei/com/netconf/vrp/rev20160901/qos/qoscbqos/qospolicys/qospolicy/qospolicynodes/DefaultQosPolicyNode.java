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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy
            .qospolicynodes;

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;

/**
 * Represents the implementation of qosPolicyNode.
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
public class DefaultQosPolicyNode implements QosPolicyNode {
    protected int priority;
    protected String classifierName;
    protected String behaviorName;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangQosPolicyNodeOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public String classifierName() {
        return classifierName;
    }

    @Override
    public String behaviorName() {
        return behaviorName;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangQosPolicyNodeOpType() {
        return yangQosPolicyNodeOpType;
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
         return Objects.hash(priority, classifierName, behaviorName, valueLeafFlags, yangQosPolicyNodeOpType,
                    isSubTreeFiltered, selectLeafFlags, yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosPolicyNode) {
            DefaultQosPolicyNode other = (DefaultQosPolicyNode) obj;
            return
                Objects.equals(priority, other.priority) &&
                Objects.equals(classifierName, other.classifierName) &&
                Objects.equals(behaviorName, other.behaviorName) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangQosPolicyNodeOpType, other.yangQosPolicyNodeOpType) &&
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
            .add("priority", priority)
            .add("classifierName", classifierName)
            .add("behaviorName", behaviorName)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangQosPolicyNodeOpType", yangQosPolicyNodeOpType)
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
     * Creates an instance of qosPolicyNode.
     *
     * @param builderObject value of builder object of qosPolicyNode
     */
    protected DefaultQosPolicyNode(QosPolicyNodeBuilder builderObject) {
        priority = builderObject.priority();
        classifierName = builderObject.classifierName();
        behaviorName = builderObject.behaviorName();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangQosPolicyNodeOpType = builderObject.yangQosPolicyNodeOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed QosPolicyNode maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosPolicyNode processSubtreeFiltering(QosPolicyNode appInstance, boolean isSelectAllSchemaChild) {
        QosPolicyNodeBuilder subTreeFilteringResultBuilder = new QosPolicyNodeBuilder();
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
        return (DefaultQosPolicyNode) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(QosPolicyNode appInstance, QosPolicyNodeBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.PRIORITY.getLeafIndex())) {
            if (appInstance.priority() != priority()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.PRIORITY)) {
                    subTreeFilteringResultBuilder.priority(priority());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.priority(appInstance.priority());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.PRIORITY.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.priority(appInstance.priority());
        }

        if (valueLeafFlags.get(LeafIdentifier.CLASSIFIERNAME.getLeafIndex())) {
            if (appInstance.classifierName() == null || !(classifierName().equals(appInstance.classifierName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.CLASSIFIERNAME)) {
                    subTreeFilteringResultBuilder.classifierName(classifierName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.classifierName(appInstance.classifierName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.CLASSIFIERNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.classifierName(appInstance.classifierName());
        }

        if (valueLeafFlags.get(LeafIdentifier.BEHAVIORNAME.getLeafIndex())) {
            if (appInstance.behaviorName() == null || !(behaviorName().equals(appInstance.behaviorName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.BEHAVIORNAME)) {
                    subTreeFilteringResultBuilder.behaviorName(behaviorName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.behaviorName(appInstance.behaviorName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.BEHAVIORNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.behaviorName(appInstance.behaviorName());
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosPolicyNode.
     */
    protected DefaultQosPolicyNode() {
    }

    /**
     * Returns the attribute qosPolicyNodeBuilder.
     *
     * @return qosPolicyNodeBuilder
     */
    public static QosPolicyNodeBuilder builder() {
        return new QosPolicyNodeBuilder();
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
     * Represents the builder implementation of qosPolicyNode.
     */
    public static class QosPolicyNodeBuilder implements QosPolicyNode.QosPolicyNodeBuilder {
        protected int priority;
        protected String classifierName;
        protected String behaviorName;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangQosPolicyNodeOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public int priority() {
            return priority;
        }

        @Override
        public String classifierName() {
            return classifierName;
        }

        @Override
        public String behaviorName() {
            return behaviorName;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangQosPolicyNodeOpType() {
            return yangQosPolicyNodeOpType;
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
        public QosPolicyNodeBuilder priority(int priority) {
            valueLeafFlags.set(LeafIdentifier.PRIORITY.getLeafIndex());
            this.priority = priority;
            return this;
        }

        @Override
        public QosPolicyNodeBuilder classifierName(String classifierName) {
            valueLeafFlags.set(LeafIdentifier.CLASSIFIERNAME.getLeafIndex());
            this.classifierName = classifierName;
            return this;
        }

        @Override
        public QosPolicyNodeBuilder behaviorName(String behaviorName) {
            valueLeafFlags.set(LeafIdentifier.BEHAVIORNAME.getLeafIndex());
            this.behaviorName = behaviorName;
            return this;
        }

        @Override
        public QosPolicyNodeBuilder yangQosPolicyNodeOpType(OnosYangOpType yangQosPolicyNodeOpType) {
            this.yangQosPolicyNodeOpType = yangQosPolicyNodeOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosPolicyNodeBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosPolicyNodeBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public QosPolicyNodeBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosPolicyNode build() {
            return new DefaultQosPolicyNode(this);
        }

        /**
         * Builds object of qosPolicyNode.
         *
         * @return qosPolicyNode
         */
        public QosPolicyNode buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosPolicyNode(this);
        }
        /**
         * Creates an instance of qosPolicyNodeBuilder.
         */
        public QosPolicyNodeBuilder() {
        }

    }
}
