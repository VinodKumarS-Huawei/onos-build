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
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.DefaultQosIfQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.QosIfQos;

/**
 * Represents the implementation of qosIfQoss.
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
public class DefaultQosIfQoss implements QosIfQoss {
    protected OnosYangOpType yangQosIfQossOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<QosIfQos> qosIfQos;

    @Override
    public OnosYangOpType yangQosIfQossOpType() {
        return yangQosIfQossOpType;
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
    public List<QosIfQos> qosIfQos() {
        return qosIfQos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosIfQossOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosIfQos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosIfQoss) {
            DefaultQosIfQoss other = (DefaultQosIfQoss) obj;
            return
                Objects.equals(yangQosIfQossOpType, other.yangQosIfQossOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosIfQos, other.qosIfQos);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosIfQossOpType", yangQosIfQossOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosIfQos", qosIfQos)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosIfQoss.
     *
     * @param builderObject value of builder object of qosIfQoss
     */
    protected DefaultQosIfQoss(QosIfQossBuilder builderObject) {
        yangQosIfQossOpType = builderObject.yangQosIfQossOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosIfQos = builderObject.qosIfQos();
    }

    /**
     * Checks if the passed QosIfQoss maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosIfQoss processSubtreeFiltering(QosIfQoss appInstance, boolean isSelectAllSchemaChild) {
        QosIfQossBuilder subTreeFilteringResultBuilder = new QosIfQossBuilder();
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
        return (DefaultQosIfQoss) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosIfQoss appInstance, QosIfQossBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.qosIfQos() != null) {
                for (QosIfQos qosIfQos : appInstance.qosIfQos()) {
                    QosIfQos result;
                    result = ((DefaultQosIfQos) DefaultQosIfQos.builder()
                            .buildForFilter()).processSubtreeFiltering(qosIfQos, true);
                    subTreeFilteringResultBuilder.addToQosIfQos(result);
                }
            } else {
                if (isSubTreeFiltered && qosIfQos() != null) {
                    subTreeFilteringResultBuilder.qosIfQos(qosIfQos);
                }
            }
        } else if (qosIfQos() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!qosIfQos().isEmpty()) {
                if (appInstance.qosIfQos() != null && !appInstance.qosIfQos().isEmpty()) {
                for (QosIfQos qosIfQos : qosIfQos()) {
                    for (QosIfQos qosIfQos2 : appInstance.qosIfQos()) {
                            QosIfQos result = ((DefaultQosIfQos) qosIfQos)
                            .processSubtreeFiltering(qosIfQos2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToQosIfQos(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && qosIfQos() != null) {
                    subTreeFilteringResultBuilder.qosIfQos(qosIfQos);
                }
            }
            } else {
                if (appInstance.qosIfQos() != null && !appInstance.qosIfQos().isEmpty()) {
                for (QosIfQos qosIfQos : appInstance.qosIfQos()) {
                        subTreeFilteringResultBuilder.addToQosIfQos(qosIfQos);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosIfQoss.
     */
    protected DefaultQosIfQoss() {
    }

    /**
     * Returns the attribute qosIfQossBuilder.
     *
     * @return qosIfQossBuilder
     */
    public static QosIfQossBuilder builder() {
        return new QosIfQossBuilder();
    }

    /**
     * Represents the builder implementation of qosIfQoss.
     */
    public static class QosIfQossBuilder implements QosIfQoss.QosIfQossBuilder {
        protected OnosYangOpType yangQosIfQossOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<QosIfQos> qosIfQos;


        @Override
        public OnosYangOpType yangQosIfQossOpType() {
            return yangQosIfQossOpType;
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
        public List<QosIfQos> qosIfQos() {
            return qosIfQos;
        }

        @Override
        public QosIfQossBuilder yangQosIfQossOpType(OnosYangOpType yangQosIfQossOpType) {
            this.yangQosIfQossOpType = yangQosIfQossOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosIfQossBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosIfQossBuilder qosIfQos(List<QosIfQos> qosIfQos) {
            this.qosIfQos = qosIfQos;
            return this;
        }

        @Override
        public QosIfQossBuilder addToQosIfQos(QosIfQos addTo) {
            if (qosIfQos == null) {
                qosIfQos = new ArrayList<>();
            }
            qosIfQos.add(addTo);
            return this;
        }


        @Override
        public QosIfQossBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosIfQoss build() {
            return new DefaultQosIfQoss(this);
        }

        /**
         * Builds object of qosIfQoss.
         *
         * @return qosIfQoss
         */
        public QosIfQoss buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosIfQoss(this);
        }
        /**
         * Creates an instance of qosIfQossBuilder.
         */
        public QosIfQossBuilder() {
        }

    }
}
