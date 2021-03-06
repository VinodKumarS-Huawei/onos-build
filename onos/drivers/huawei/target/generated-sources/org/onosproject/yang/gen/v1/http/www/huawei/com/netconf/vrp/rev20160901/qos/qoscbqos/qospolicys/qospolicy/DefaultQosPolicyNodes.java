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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy
            .qospolicynodes.DefaultQosPolicyNode;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.qospolicy
            .qospolicynodes.QosPolicyNode;

/**
 * Represents the implementation of qosPolicyNodes.
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
public class DefaultQosPolicyNodes implements QosPolicyNodes {
    protected OnosYangOpType yangQosPolicyNodesOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<QosPolicyNode> qosPolicyNode;

    @Override
    public OnosYangOpType yangQosPolicyNodesOpType() {
        return yangQosPolicyNodesOpType;
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
    public Map<Class<?>, Object> yangAugmentedInfoMap() {
        return yangAugmentedInfoMap;
    }

    @Override
    public List<QosPolicyNode> qosPolicyNode() {
        return qosPolicyNode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosPolicyNodesOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosPolicyNode);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosPolicyNodes) {
            DefaultQosPolicyNodes other = (DefaultQosPolicyNodes) obj;
            return
                Objects.equals(yangQosPolicyNodesOpType, other.yangQosPolicyNodesOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosPolicyNode, other.qosPolicyNode);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosPolicyNodesOpType", yangQosPolicyNodesOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosPolicyNode", qosPolicyNode)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosPolicyNodes.
     *
     * @param builderObject value of builder object of qosPolicyNodes
     */
    protected DefaultQosPolicyNodes(QosPolicyNodesBuilder builderObject) {
        yangQosPolicyNodesOpType = builderObject.yangQosPolicyNodesOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosPolicyNode = builderObject.qosPolicyNode();
    }

    /**
     * Checks if the passed QosPolicyNodes maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosPolicyNodes processSubtreeFiltering(QosPolicyNodes appInstance, boolean
                isSelectAllSchemaChild) {
        QosPolicyNodesBuilder subTreeFilteringResultBuilder = new QosPolicyNodesBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
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
        return (DefaultQosPolicyNodes) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosPolicyNodes appInstance, QosPolicyNodesBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.qosPolicyNode() != null) {
                for (QosPolicyNode qosPolicyNode : appInstance.qosPolicyNode()) {
                    QosPolicyNode result;
                    result = ((DefaultQosPolicyNode) DefaultQosPolicyNode.builder()
                            .buildForFilter()).processSubtreeFiltering(qosPolicyNode, true);
                    subTreeFilteringResultBuilder.addToQosPolicyNode(result);
                }
            } else {
                if (isSubTreeFiltered && qosPolicyNode() != null) {
                    subTreeFilteringResultBuilder.qosPolicyNode(qosPolicyNode);
                }
            }
        } else if (qosPolicyNode() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!qosPolicyNode().isEmpty()) {
                if (appInstance.qosPolicyNode() != null && !appInstance.qosPolicyNode().isEmpty()) {
                for (QosPolicyNode qosPolicyNode : qosPolicyNode()) {
                    for (QosPolicyNode qosPolicyNode2 : appInstance.qosPolicyNode()) {
                            QosPolicyNode result = ((DefaultQosPolicyNode) qosPolicyNode)
                            .processSubtreeFiltering(qosPolicyNode2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToQosPolicyNode(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && qosPolicyNode() != null) {
                    subTreeFilteringResultBuilder.qosPolicyNode(qosPolicyNode);
                }
            }
            } else {
                if (appInstance.qosPolicyNode() != null && !appInstance.qosPolicyNode().isEmpty()) {
                for (QosPolicyNode qosPolicyNode : appInstance.qosPolicyNode()) {
                        subTreeFilteringResultBuilder.addToQosPolicyNode(qosPolicyNode);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosPolicyNodes.
     */
    protected DefaultQosPolicyNodes() {
    }

    /**
     * Returns the attribute qosPolicyNodesBuilder.
     *
     * @return qosPolicyNodesBuilder
     */
    public static QosPolicyNodesBuilder builder() {
        return new QosPolicyNodesBuilder();
    }

    /**
     * Represents the builder implementation of qosPolicyNodes.
     */
    public static class QosPolicyNodesBuilder implements QosPolicyNodes.QosPolicyNodesBuilder {
        protected OnosYangOpType yangQosPolicyNodesOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<QosPolicyNode> qosPolicyNode;


        @Override
        public OnosYangOpType yangQosPolicyNodesOpType() {
            return yangQosPolicyNodesOpType;
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
        public Map<Class<?>, Object> yangAugmentedInfoMap() {
            return yangAugmentedInfoMap;
        }

        @Override
        public List<QosPolicyNode> qosPolicyNode() {
            return qosPolicyNode;
        }

        @Override
        public QosPolicyNodesBuilder yangQosPolicyNodesOpType(OnosYangOpType yangQosPolicyNodesOpType) {
            this.yangQosPolicyNodesOpType = yangQosPolicyNodesOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosPolicyNodesBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosPolicyNodesBuilder qosPolicyNode(List<QosPolicyNode> qosPolicyNode) {
            this.qosPolicyNode = qosPolicyNode;
            return this;
        }

        @Override
        public QosPolicyNodesBuilder addToQosPolicyNode(QosPolicyNode addTo) {
            if (qosPolicyNode == null) {
                qosPolicyNode = new ArrayList<>();
            }
            qosPolicyNode.add(addTo);
            return this;
        }


        @Override
        public QosPolicyNodesBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosPolicyNodes build() {
            return new DefaultQosPolicyNodes(this);
        }

        /**
         * Builds object of qosPolicyNodes.
         *
         * @return qosPolicyNodes
         */
        public QosPolicyNodes buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosPolicyNodes(this);
        }
        /**
         * Creates an instance of qosPolicyNodesBuilder.
         */
        public QosPolicyNodesBuilder() {
        }

    }
}
