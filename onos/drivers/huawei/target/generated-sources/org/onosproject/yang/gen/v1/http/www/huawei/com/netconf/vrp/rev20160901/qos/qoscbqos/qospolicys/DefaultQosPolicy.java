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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy
            .DefaultQosPolicyNodes;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy
            .QosPolicyNodes;

/**
 * Represents the implementation of qosPolicy.
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
public class DefaultQosPolicy implements QosPolicy {
    protected String policyName;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangQosPolicyOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected QosPolicyNodes qosPolicyNodes;

    @Override
    public String policyName() {
        return policyName;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangQosPolicyOpType() {
        return yangQosPolicyOpType;
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
    public QosPolicyNodes qosPolicyNodes() {
        return qosPolicyNodes;
    }

    @Override
    public int hashCode() {
         return Objects.hash(policyName, valueLeafFlags, yangQosPolicyOpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap, qosPolicyNodes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosPolicy) {
            DefaultQosPolicy other = (DefaultQosPolicy) obj;
            return
                Objects.equals(policyName, other.policyName) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangQosPolicyOpType, other.yangQosPolicyOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosPolicyNodes, other.qosPolicyNodes);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("policyName", policyName)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangQosPolicyOpType", yangQosPolicyOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosPolicyNodes", qosPolicyNodes)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosPolicy.
     *
     * @param builderObject value of builder object of qosPolicy
     */
    protected DefaultQosPolicy(QosPolicyBuilder builderObject) {
        policyName = builderObject.policyName();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangQosPolicyOpType = builderObject.yangQosPolicyOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosPolicyNodes = builderObject.qosPolicyNodes();
    }

    /**
     * Checks if the passed QosPolicy maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosPolicy processSubtreeFiltering(QosPolicy appInstance, boolean isSelectAllSchemaChild) {
        QosPolicyBuilder subTreeFilteringResultBuilder = new QosPolicyBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
        if (!processLeafSubtreeFiltering(appInstance, subTreeFilteringResultBuilder, isAnySelectOrContainmentNode,
                    isSelectAllSchemaChild)) {
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
        return (DefaultQosPolicy) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(QosPolicy appInstance, QosPolicyBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.POLICYNAME.getLeafIndex())) {
            if (appInstance.policyName() == null || !(policyName().equals(appInstance.policyName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.POLICYNAME)) {
                    subTreeFilteringResultBuilder.policyName(policyName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.policyName(appInstance.policyName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.POLICYNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.policyName(appInstance.policyName());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(QosPolicy appInstance, QosPolicyBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (qosPolicyNodes() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosPolicyNodes() != null) {
                QosPolicyNodes result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosPolicyNodes) DefaultQosPolicyNodes.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosPolicyNodes(), true);
                } else {
                    result = ((DefaultQosPolicyNodes) qosPolicyNodes)
                            .processSubtreeFiltering(appInstance.qosPolicyNodes(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosPolicyNodes(result);
                }
            } else {
                if (isSubTreeFiltered && qosPolicyNodes() != null) {
                    subTreeFilteringResultBuilder.qosPolicyNodes(qosPolicyNodes);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosPolicy.
     */
    protected DefaultQosPolicy() {
    }

    /**
     * Returns the attribute qosPolicyBuilder.
     *
     * @return qosPolicyBuilder
     */
    public static QosPolicyBuilder builder() {
        return new QosPolicyBuilder();
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
     * Represents the builder implementation of qosPolicy.
     */
    public static class QosPolicyBuilder implements QosPolicy.QosPolicyBuilder {
        protected String policyName;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangQosPolicyOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected QosPolicyNodes qosPolicyNodes;



        @Override
        public String policyName() {
            return policyName;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangQosPolicyOpType() {
            return yangQosPolicyOpType;
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
        public QosPolicyNodes qosPolicyNodes() {
            return qosPolicyNodes;
        }

        @Override
        public QosPolicyBuilder policyName(String policyName) {
            valueLeafFlags.set(LeafIdentifier.POLICYNAME.getLeafIndex());
            this.policyName = policyName;
            return this;
        }

        @Override
        public QosPolicyBuilder yangQosPolicyOpType(OnosYangOpType yangQosPolicyOpType) {
            this.yangQosPolicyOpType = yangQosPolicyOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosPolicyBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosPolicyBuilder qosPolicyNodes(QosPolicyNodes qosPolicyNodes) {
            this.qosPolicyNodes = qosPolicyNodes;
            return this;
        }

        @Override
        public QosPolicyBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public QosPolicyBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosPolicy build() {
            return new DefaultQosPolicy(this);
        }

        /**
         * Builds object of qosPolicy.
         *
         * @return qosPolicy
         */
        public QosPolicy buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosPolicy(this);
        }
        /**
         * Creates an instance of qosPolicyBuilder.
         */
        public QosPolicyBuilder() {
        }

    }
}
