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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys
            .DefaultQosPolicy;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qospolicys.QosPolicy;

/**
 * Represents the implementation of qosPolicys.
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
public class DefaultQosPolicys implements QosPolicys {
    protected OnosYangOpType yangQosPolicysOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<QosPolicy> qosPolicy;

    @Override
    public OnosYangOpType yangQosPolicysOpType() {
        return yangQosPolicysOpType;
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
    public List<QosPolicy> qosPolicy() {
        return qosPolicy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosPolicysOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosPolicy);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosPolicys) {
            DefaultQosPolicys other = (DefaultQosPolicys) obj;
            return
                Objects.equals(yangQosPolicysOpType, other.yangQosPolicysOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosPolicy, other.qosPolicy);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosPolicysOpType", yangQosPolicysOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosPolicy", qosPolicy)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosPolicys.
     *
     * @param builderObject value of builder object of qosPolicys
     */
    protected DefaultQosPolicys(QosPolicysBuilder builderObject) {
        yangQosPolicysOpType = builderObject.yangQosPolicysOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosPolicy = builderObject.qosPolicy();
    }

    /**
     * Checks if the passed QosPolicys maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosPolicys processSubtreeFiltering(QosPolicys appInstance, boolean isSelectAllSchemaChild) {
        QosPolicysBuilder subTreeFilteringResultBuilder = new QosPolicysBuilder();
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
        return (DefaultQosPolicys) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosPolicys appInstance, QosPolicysBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.qosPolicy() != null) {
                for (QosPolicy qosPolicy : appInstance.qosPolicy()) {
                    QosPolicy result;
                    result = ((DefaultQosPolicy) DefaultQosPolicy.builder()
                            .buildForFilter()).processSubtreeFiltering(qosPolicy, true);
                    subTreeFilteringResultBuilder.addToQosPolicy(result);
                }
            } else {
                if (isSubTreeFiltered && qosPolicy() != null) {
                    subTreeFilteringResultBuilder.qosPolicy(qosPolicy);
                }
            }
        } else if (qosPolicy() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!qosPolicy().isEmpty()) {
                if (appInstance.qosPolicy() != null && !appInstance.qosPolicy().isEmpty()) {
                for (QosPolicy qosPolicy : qosPolicy()) {
                    for (QosPolicy qosPolicy2 : appInstance.qosPolicy()) {
                            QosPolicy result = ((DefaultQosPolicy) qosPolicy)
                            .processSubtreeFiltering(qosPolicy2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToQosPolicy(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && qosPolicy() != null) {
                    subTreeFilteringResultBuilder.qosPolicy(qosPolicy);
                }
            }
            } else {
                if (appInstance.qosPolicy() != null && !appInstance.qosPolicy().isEmpty()) {
                for (QosPolicy qosPolicy : appInstance.qosPolicy()) {
                        subTreeFilteringResultBuilder.addToQosPolicy(qosPolicy);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosPolicys.
     */
    protected DefaultQosPolicys() {
    }

    /**
     * Returns the attribute qosPolicysBuilder.
     *
     * @return qosPolicysBuilder
     */
    public static QosPolicysBuilder builder() {
        return new QosPolicysBuilder();
    }

    /**
     * Represents the builder implementation of qosPolicys.
     */
    public static class QosPolicysBuilder implements QosPolicys.QosPolicysBuilder {
        protected OnosYangOpType yangQosPolicysOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<QosPolicy> qosPolicy;


        @Override
        public OnosYangOpType yangQosPolicysOpType() {
            return yangQosPolicysOpType;
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
        public List<QosPolicy> qosPolicy() {
            return qosPolicy;
        }

        @Override
        public QosPolicysBuilder yangQosPolicysOpType(OnosYangOpType yangQosPolicysOpType) {
            this.yangQosPolicysOpType = yangQosPolicysOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosPolicysBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosPolicysBuilder qosPolicy(List<QosPolicy> qosPolicy) {
            this.qosPolicy = qosPolicy;
            return this;
        }

        @Override
        public QosPolicysBuilder addToQosPolicy(QosPolicy addTo) {
            if (qosPolicy == null) {
                qosPolicy = new ArrayList<>();
            }
            qosPolicy.add(addTo);
            return this;
        }


        @Override
        public QosPolicysBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosPolicys build() {
            return new DefaultQosPolicys(this);
        }

        /**
         * Builds object of qosPolicys.
         *
         * @return qosPolicys
         */
        public QosPolicys buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosPolicys(this);
        }
        /**
         * Creates an instance of qosPolicysBuilder.
         */
        public QosPolicysBuilder() {
        }

    }
}
