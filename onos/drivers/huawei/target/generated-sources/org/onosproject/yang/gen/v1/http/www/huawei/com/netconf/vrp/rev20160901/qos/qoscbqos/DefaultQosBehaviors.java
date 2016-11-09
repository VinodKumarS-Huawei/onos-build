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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors
            .DefaultQosBehavior;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.QosBehavior;

/**
 * Represents the implementation of qosBehaviors.
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
public class DefaultQosBehaviors implements QosBehaviors {
    protected OnosYangOpType yangQosBehaviorsOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<QosBehavior> qosBehavior;

    @Override
    public OnosYangOpType yangQosBehaviorsOpType() {
        return yangQosBehaviorsOpType;
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
    public List<QosBehavior> qosBehavior() {
        return qosBehavior;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosBehaviorsOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosBehavior);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosBehaviors) {
            DefaultQosBehaviors other = (DefaultQosBehaviors) obj;
            return
                Objects.equals(yangQosBehaviorsOpType, other.yangQosBehaviorsOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosBehavior, other.qosBehavior);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosBehaviorsOpType", yangQosBehaviorsOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosBehavior", qosBehavior)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosBehaviors.
     *
     * @param builderObject value of builder object of qosBehaviors
     */
    protected DefaultQosBehaviors(QosBehaviorsBuilder builderObject) {
        yangQosBehaviorsOpType = builderObject.yangQosBehaviorsOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosBehavior = builderObject.qosBehavior();
    }

    /**
     * Checks if the passed QosBehaviors maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosBehaviors processSubtreeFiltering(QosBehaviors appInstance, boolean isSelectAllSchemaChild) {
        QosBehaviorsBuilder subTreeFilteringResultBuilder = new QosBehaviorsBuilder();
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
        return (DefaultQosBehaviors) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosBehaviors appInstance, QosBehaviorsBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.qosBehavior() != null) {
                for (QosBehavior qosBehavior : appInstance.qosBehavior()) {
                    QosBehavior result;
                    result = ((DefaultQosBehavior) DefaultQosBehavior.builder()
                            .buildForFilter()).processSubtreeFiltering(qosBehavior, true);
                    subTreeFilteringResultBuilder.addToQosBehavior(result);
                }
            } else {
                if (isSubTreeFiltered && qosBehavior() != null) {
                    subTreeFilteringResultBuilder.qosBehavior(qosBehavior);
                }
            }
        } else if (qosBehavior() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!qosBehavior().isEmpty()) {
                if (appInstance.qosBehavior() != null && !appInstance.qosBehavior().isEmpty()) {
                for (QosBehavior qosBehavior : qosBehavior()) {
                    for (QosBehavior qosBehavior2 : appInstance.qosBehavior()) {
                            QosBehavior result = ((DefaultQosBehavior) qosBehavior)
                            .processSubtreeFiltering(qosBehavior2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToQosBehavior(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && qosBehavior() != null) {
                    subTreeFilteringResultBuilder.qosBehavior(qosBehavior);
                }
            }
            } else {
                if (appInstance.qosBehavior() != null && !appInstance.qosBehavior().isEmpty()) {
                for (QosBehavior qosBehavior : appInstance.qosBehavior()) {
                        subTreeFilteringResultBuilder.addToQosBehavior(qosBehavior);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosBehaviors.
     */
    protected DefaultQosBehaviors() {
    }

    /**
     * Returns the attribute qosBehaviorsBuilder.
     *
     * @return qosBehaviorsBuilder
     */
    public static QosBehaviorsBuilder builder() {
        return new QosBehaviorsBuilder();
    }

    /**
     * Represents the builder implementation of qosBehaviors.
     */
    public static class QosBehaviorsBuilder implements QosBehaviors.QosBehaviorsBuilder {
        protected OnosYangOpType yangQosBehaviorsOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<QosBehavior> qosBehavior;


        @Override
        public OnosYangOpType yangQosBehaviorsOpType() {
            return yangQosBehaviorsOpType;
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
        public List<QosBehavior> qosBehavior() {
            return qosBehavior;
        }

        @Override
        public QosBehaviorsBuilder yangQosBehaviorsOpType(OnosYangOpType yangQosBehaviorsOpType) {
            this.yangQosBehaviorsOpType = yangQosBehaviorsOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosBehaviorsBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosBehaviorsBuilder qosBehavior(List<QosBehavior> qosBehavior) {
            this.qosBehavior = qosBehavior;
            return this;
        }

        @Override
        public QosBehaviorsBuilder addToQosBehavior(QosBehavior addTo) {
            if (qosBehavior == null) {
                qosBehavior = new ArrayList<>();
            }
            qosBehavior.add(addTo);
            return this;
        }


        @Override
        public QosBehaviorsBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosBehaviors build() {
            return new DefaultQosBehaviors(this);
        }

        /**
         * Builds object of qosBehaviors.
         *
         * @return qosBehaviors
         */
        public QosBehaviors buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosBehaviors(this);
        }
        /**
         * Creates an instance of qosBehaviorsBuilder.
         */
        public QosBehaviorsBuilder() {
        }

    }
}
