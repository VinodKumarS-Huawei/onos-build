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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.DefaultQosBehaviors;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.DefaultQosClassifiers;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.DefaultQosPolicys;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.QosBehaviors;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.QosClassifiers;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.QosPolicys;

/**
 * Represents the implementation of qosCbQos.
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
public class DefaultQosCbQos implements QosCbQos {
    protected OnosYangOpType yangQosCbQosOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected QosClassifiers qosClassifiers;
    protected QosBehaviors qosBehaviors;
    protected QosPolicys qosPolicys;

    @Override
    public OnosYangOpType yangQosCbQosOpType() {
        return yangQosCbQosOpType;
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
    public QosClassifiers qosClassifiers() {
        return qosClassifiers;
    }

    @Override
    public QosBehaviors qosBehaviors() {
        return qosBehaviors;
    }

    @Override
    public QosPolicys qosPolicys() {
        return qosPolicys;
    }

    @Override
    public int hashCode() {
         return Objects.hash(yangQosCbQosOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosClassifiers,
                    qosBehaviors, qosPolicys);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosCbQos) {
            DefaultQosCbQos other = (DefaultQosCbQos) obj;
            return
                Objects.equals(yangQosCbQosOpType, other.yangQosCbQosOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosClassifiers, other.qosClassifiers) &&
                Objects.equals(qosBehaviors, other.qosBehaviors) &&
                Objects.equals(qosPolicys, other.qosPolicys);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosCbQosOpType", yangQosCbQosOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosClassifiers", qosClassifiers)
            .add("qosBehaviors", qosBehaviors)
            .add("qosPolicys", qosPolicys)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosCbQos.
     *
     * @param builderObject value of builder object of qosCbQos
     */
    protected DefaultQosCbQos(QosCbQosBuilder builderObject) {
        yangQosCbQosOpType = builderObject.yangQosCbQosOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosClassifiers = builderObject.qosClassifiers();
        qosBehaviors = builderObject.qosBehaviors();
        qosPolicys = builderObject.qosPolicys();
    }

    /**
     * Checks if the passed QosCbQos maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosCbQos processSubtreeFiltering(QosCbQos appInstance, boolean isSelectAllSchemaChild) {
        QosCbQosBuilder subTreeFilteringResultBuilder = new QosCbQosBuilder();
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
        return (DefaultQosCbQos) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosCbQos appInstance, QosCbQosBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (qosClassifiers() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosClassifiers() != null) {
                QosClassifiers result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosClassifiers) DefaultQosClassifiers.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosClassifiers(), true);
                } else {
                    result = ((DefaultQosClassifiers) qosClassifiers)
                            .processSubtreeFiltering(appInstance.qosClassifiers(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosClassifiers(result);
                }
            } else {
                if (isSubTreeFiltered && qosClassifiers() != null) {
                    subTreeFilteringResultBuilder.qosClassifiers(qosClassifiers);
                }
            }
        }

        if (qosBehaviors() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosBehaviors() != null) {
                QosBehaviors result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosBehaviors) DefaultQosBehaviors.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosBehaviors(), true);
                } else {
                    result = ((DefaultQosBehaviors) qosBehaviors)
                            .processSubtreeFiltering(appInstance.qosBehaviors(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosBehaviors(result);
                }
            } else {
                if (isSubTreeFiltered && qosBehaviors() != null) {
                    subTreeFilteringResultBuilder.qosBehaviors(qosBehaviors);
                }
            }
        }

        if (qosPolicys() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosPolicys() != null) {
                QosPolicys result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosPolicys) DefaultQosPolicys.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosPolicys(), true);
                } else {
                    result = ((DefaultQosPolicys) qosPolicys)
                            .processSubtreeFiltering(appInstance.qosPolicys(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosPolicys(result);
                }
            } else {
                if (isSubTreeFiltered && qosPolicys() != null) {
                    subTreeFilteringResultBuilder.qosPolicys(qosPolicys);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosCbQos.
     */
    protected DefaultQosCbQos() {
    }

    /**
     * Returns the attribute qosCbQosBuilder.
     *
     * @return qosCbQosBuilder
     */
    public static QosCbQosBuilder builder() {
        return new QosCbQosBuilder();
    }

    /**
     * Represents the builder implementation of qosCbQos.
     */
    public static class QosCbQosBuilder implements QosCbQos.QosCbQosBuilder {
        protected OnosYangOpType yangQosCbQosOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected QosClassifiers qosClassifiers;
        protected QosBehaviors qosBehaviors;
        protected QosPolicys qosPolicys;


        @Override
        public OnosYangOpType yangQosCbQosOpType() {
            return yangQosCbQosOpType;
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
        public QosClassifiers qosClassifiers() {
            return qosClassifiers;
        }

        @Override
        public QosBehaviors qosBehaviors() {
            return qosBehaviors;
        }

        @Override
        public QosPolicys qosPolicys() {
            return qosPolicys;
        }

        @Override
        public QosCbQosBuilder yangQosCbQosOpType(OnosYangOpType yangQosCbQosOpType) {
            this.yangQosCbQosOpType = yangQosCbQosOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosCbQosBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosCbQosBuilder qosClassifiers(QosClassifiers qosClassifiers) {
            this.qosClassifiers = qosClassifiers;
            return this;
        }

        @Override
        public QosCbQosBuilder qosBehaviors(QosBehaviors qosBehaviors) {
            this.qosBehaviors = qosBehaviors;
            return this;
        }

        @Override
        public QosCbQosBuilder qosPolicys(QosPolicys qosPolicys) {
            this.qosPolicys = qosPolicys;
            return this;
        }

        @Override
        public QosCbQosBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosCbQos build() {
            return new DefaultQosCbQos(this);
        }

        /**
         * Builds object of qosCbQos.
         *
         * @return qosCbQos
         */
        public QosCbQos buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosCbQos(this);
        }
        /**
         * Creates an instance of qosCbQosBuilder.
         */
        public QosCbQosBuilder() {
        }

    }
}
