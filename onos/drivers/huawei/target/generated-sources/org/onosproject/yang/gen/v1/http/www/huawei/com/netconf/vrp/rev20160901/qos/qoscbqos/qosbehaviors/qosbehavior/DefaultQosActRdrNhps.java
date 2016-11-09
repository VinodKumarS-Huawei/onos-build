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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors
            .qosbehavior;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps.DefaultQosActRdrNhp;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps.QosActRdrNhp;

/**
 * Represents the implementation of qosActRdrNhps.
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
public class DefaultQosActRdrNhps implements QosActRdrNhps {
    protected OnosYangOpType yangQosActRdrNhpsOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<QosActRdrNhp> qosActRdrNhp;

    @Override
    public OnosYangOpType yangQosActRdrNhpsOpType() {
        return yangQosActRdrNhpsOpType;
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
    public List<QosActRdrNhp> qosActRdrNhp() {
        return qosActRdrNhp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosActRdrNhpsOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosActRdrNhp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosActRdrNhps) {
            DefaultQosActRdrNhps other = (DefaultQosActRdrNhps) obj;
            return
                Objects.equals(yangQosActRdrNhpsOpType, other.yangQosActRdrNhpsOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosActRdrNhp, other.qosActRdrNhp);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosActRdrNhpsOpType", yangQosActRdrNhpsOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosActRdrNhp", qosActRdrNhp)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosActRdrNhps.
     *
     * @param builderObject value of builder object of qosActRdrNhps
     */
    protected DefaultQosActRdrNhps(QosActRdrNhpsBuilder builderObject) {
        yangQosActRdrNhpsOpType = builderObject.yangQosActRdrNhpsOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosActRdrNhp = builderObject.qosActRdrNhp();
    }

    /**
     * Checks if the passed QosActRdrNhps maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosActRdrNhps processSubtreeFiltering(QosActRdrNhps appInstance, boolean isSelectAllSchemaChild) {
        QosActRdrNhpsBuilder subTreeFilteringResultBuilder = new QosActRdrNhpsBuilder();
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
        return (DefaultQosActRdrNhps) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosActRdrNhps appInstance, QosActRdrNhpsBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.qosActRdrNhp() != null) {
                for (QosActRdrNhp qosActRdrNhp : appInstance.qosActRdrNhp()) {
                    QosActRdrNhp result;
                    result = ((DefaultQosActRdrNhp) DefaultQosActRdrNhp.builder()
                            .buildForFilter()).processSubtreeFiltering(qosActRdrNhp, true);
                    subTreeFilteringResultBuilder.addToQosActRdrNhp(result);
                }
            } else {
                if (isSubTreeFiltered && qosActRdrNhp() != null) {
                    subTreeFilteringResultBuilder.qosActRdrNhp(qosActRdrNhp);
                }
            }
        } else if (qosActRdrNhp() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!qosActRdrNhp().isEmpty()) {
                if (appInstance.qosActRdrNhp() != null && !appInstance.qosActRdrNhp().isEmpty()) {
                for (QosActRdrNhp qosActRdrNhp : qosActRdrNhp()) {
                    for (QosActRdrNhp qosActRdrNhp2 : appInstance.qosActRdrNhp()) {
                            QosActRdrNhp result = ((DefaultQosActRdrNhp) qosActRdrNhp)
                            .processSubtreeFiltering(qosActRdrNhp2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToQosActRdrNhp(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && qosActRdrNhp() != null) {
                    subTreeFilteringResultBuilder.qosActRdrNhp(qosActRdrNhp);
                }
            }
            } else {
                if (appInstance.qosActRdrNhp() != null && !appInstance.qosActRdrNhp().isEmpty()) {
                for (QosActRdrNhp qosActRdrNhp : appInstance.qosActRdrNhp()) {
                        subTreeFilteringResultBuilder.addToQosActRdrNhp(qosActRdrNhp);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosActRdrNhps.
     */
    protected DefaultQosActRdrNhps() {
    }

    /**
     * Returns the attribute qosActRdrNhpsBuilder.
     *
     * @return qosActRdrNhpsBuilder
     */
    public static QosActRdrNhpsBuilder builder() {
        return new QosActRdrNhpsBuilder();
    }

    /**
     * Represents the builder implementation of qosActRdrNhps.
     */
    public static class QosActRdrNhpsBuilder implements QosActRdrNhps.QosActRdrNhpsBuilder {
        protected OnosYangOpType yangQosActRdrNhpsOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<QosActRdrNhp> qosActRdrNhp;


        @Override
        public OnosYangOpType yangQosActRdrNhpsOpType() {
            return yangQosActRdrNhpsOpType;
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
        public List<QosActRdrNhp> qosActRdrNhp() {
            return qosActRdrNhp;
        }

        @Override
        public QosActRdrNhpsBuilder yangQosActRdrNhpsOpType(OnosYangOpType yangQosActRdrNhpsOpType) {
            this.yangQosActRdrNhpsOpType = yangQosActRdrNhpsOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosActRdrNhpsBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosActRdrNhpsBuilder qosActRdrNhp(List<QosActRdrNhp> qosActRdrNhp) {
            this.qosActRdrNhp = qosActRdrNhp;
            return this;
        }

        @Override
        public QosActRdrNhpsBuilder addToQosActRdrNhp(QosActRdrNhp addTo) {
            if (qosActRdrNhp == null) {
                qosActRdrNhp = new ArrayList<>();
            }
            qosActRdrNhp.add(addTo);
            return this;
        }


        @Override
        public QosActRdrNhpsBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosActRdrNhps build() {
            return new DefaultQosActRdrNhps(this);
        }

        /**
         * Builds object of qosActRdrNhps.
         *
         * @return qosActRdrNhps
         */
        public QosActRdrNhps buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosActRdrNhps(this);
        }
        /**
         * Creates an instance of qosActRdrNhpsBuilder.
         */
        public QosActRdrNhpsBuilder() {
        }

    }
}
