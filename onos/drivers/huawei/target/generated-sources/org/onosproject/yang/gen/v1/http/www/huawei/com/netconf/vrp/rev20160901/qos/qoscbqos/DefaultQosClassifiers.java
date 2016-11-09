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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .DefaultQosClassifier;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .QosClassifier;

/**
 * Represents the implementation of qosClassifiers.
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
public class DefaultQosClassifiers implements QosClassifiers {
    protected OnosYangOpType yangQosClassifiersOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<QosClassifier> qosClassifier;

    @Override
    public OnosYangOpType yangQosClassifiersOpType() {
        return yangQosClassifiersOpType;
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
    public List<QosClassifier> qosClassifier() {
        return qosClassifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosClassifiersOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosClassifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosClassifiers) {
            DefaultQosClassifiers other = (DefaultQosClassifiers) obj;
            return
                Objects.equals(yangQosClassifiersOpType, other.yangQosClassifiersOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosClassifier, other.qosClassifier);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosClassifiersOpType", yangQosClassifiersOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosClassifier", qosClassifier)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosClassifiers.
     *
     * @param builderObject value of builder object of qosClassifiers
     */
    protected DefaultQosClassifiers(QosClassifiersBuilder builderObject) {
        yangQosClassifiersOpType = builderObject.yangQosClassifiersOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosClassifier = builderObject.qosClassifier();
    }

    /**
     * Checks if the passed QosClassifiers maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosClassifiers processSubtreeFiltering(QosClassifiers appInstance, boolean
                isSelectAllSchemaChild) {
        QosClassifiersBuilder subTreeFilteringResultBuilder = new QosClassifiersBuilder();
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
        return (DefaultQosClassifiers) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosClassifiers appInstance, QosClassifiersBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.qosClassifier() != null) {
                for (QosClassifier qosClassifier : appInstance.qosClassifier()) {
                    QosClassifier result;
                    result = ((DefaultQosClassifier) DefaultQosClassifier.builder()
                            .buildForFilter()).processSubtreeFiltering(qosClassifier, true);
                    subTreeFilteringResultBuilder.addToQosClassifier(result);
                }
            } else {
                if (isSubTreeFiltered && qosClassifier() != null) {
                    subTreeFilteringResultBuilder.qosClassifier(qosClassifier);
                }
            }
        } else if (qosClassifier() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!qosClassifier().isEmpty()) {
                if (appInstance.qosClassifier() != null && !appInstance.qosClassifier().isEmpty()) {
                for (QosClassifier qosClassifier : qosClassifier()) {
                    for (QosClassifier qosClassifier2 : appInstance.qosClassifier()) {
                            QosClassifier result = ((DefaultQosClassifier) qosClassifier)
                            .processSubtreeFiltering(qosClassifier2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToQosClassifier(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && qosClassifier() != null) {
                    subTreeFilteringResultBuilder.qosClassifier(qosClassifier);
                }
            }
            } else {
                if (appInstance.qosClassifier() != null && !appInstance.qosClassifier().isEmpty()) {
                for (QosClassifier qosClassifier : appInstance.qosClassifier()) {
                        subTreeFilteringResultBuilder.addToQosClassifier(qosClassifier);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosClassifiers.
     */
    protected DefaultQosClassifiers() {
    }

    /**
     * Returns the attribute qosClassifiersBuilder.
     *
     * @return qosClassifiersBuilder
     */
    public static QosClassifiersBuilder builder() {
        return new QosClassifiersBuilder();
    }

    /**
     * Represents the builder implementation of qosClassifiers.
     */
    public static class QosClassifiersBuilder implements QosClassifiers.QosClassifiersBuilder {
        protected OnosYangOpType yangQosClassifiersOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<QosClassifier> qosClassifier;


        @Override
        public OnosYangOpType yangQosClassifiersOpType() {
            return yangQosClassifiersOpType;
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
        public List<QosClassifier> qosClassifier() {
            return qosClassifier;
        }

        @Override
        public QosClassifiersBuilder yangQosClassifiersOpType(OnosYangOpType yangQosClassifiersOpType) {
            this.yangQosClassifiersOpType = yangQosClassifiersOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosClassifiersBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosClassifiersBuilder qosClassifier(List<QosClassifier> qosClassifier) {
            this.qosClassifier = qosClassifier;
            return this;
        }

        @Override
        public QosClassifiersBuilder addToQosClassifier(QosClassifier addTo) {
            if (qosClassifier == null) {
                qosClassifier = new ArrayList<>();
            }
            qosClassifier.add(addTo);
            return this;
        }


        @Override
        public QosClassifiersBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosClassifiers build() {
            return new DefaultQosClassifiers(this);
        }

        /**
         * Builds object of qosClassifiers.
         *
         * @return qosClassifiers
         */
        public QosClassifiers buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosClassifiers(this);
        }
        /**
         * Creates an instance of qosClassifiersBuilder.
         */
        public QosClassifiersBuilder() {
        }

    }
}
