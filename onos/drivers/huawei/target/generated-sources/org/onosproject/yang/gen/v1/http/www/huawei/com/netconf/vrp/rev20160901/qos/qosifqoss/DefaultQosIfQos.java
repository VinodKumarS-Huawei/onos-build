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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos
            .DefaultQosPolicyApplys;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos
            .QosPolicyApplys;

/**
 * Represents the implementation of qosIfQos.
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
public class DefaultQosIfQos implements QosIfQos {
    protected String ifName;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangQosIfQosOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected QosPolicyApplys qosPolicyApplys;

    @Override
    public String ifName() {
        return ifName;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangQosIfQosOpType() {
        return yangQosIfQosOpType;
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
    public QosPolicyApplys qosPolicyApplys() {
        return qosPolicyApplys;
    }

    @Override
    public int hashCode() {
         return Objects.hash(ifName, valueLeafFlags, yangQosIfQosOpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap, qosPolicyApplys);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosIfQos) {
            DefaultQosIfQos other = (DefaultQosIfQos) obj;
            return
                Objects.equals(ifName, other.ifName) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangQosIfQosOpType, other.yangQosIfQosOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosPolicyApplys, other.qosPolicyApplys);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("ifName", ifName)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangQosIfQosOpType", yangQosIfQosOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosPolicyApplys", qosPolicyApplys)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosIfQos.
     *
     * @param builderObject value of builder object of qosIfQos
     */
    protected DefaultQosIfQos(QosIfQosBuilder builderObject) {
        ifName = builderObject.ifName();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangQosIfQosOpType = builderObject.yangQosIfQosOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosPolicyApplys = builderObject.qosPolicyApplys();
    }

    /**
     * Checks if the passed QosIfQos maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosIfQos processSubtreeFiltering(QosIfQos appInstance, boolean isSelectAllSchemaChild) {
        QosIfQosBuilder subTreeFilteringResultBuilder = new QosIfQosBuilder();
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
        return (DefaultQosIfQos) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(QosIfQos appInstance, QosIfQosBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.IFNAME.getLeafIndex())) {
            if (appInstance.ifName() == null || !(ifName().equals(appInstance.ifName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.IFNAME)) {
                    subTreeFilteringResultBuilder.ifName(ifName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.ifName(appInstance.ifName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.IFNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.ifName(appInstance.ifName());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(QosIfQos appInstance, QosIfQosBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (qosPolicyApplys() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosPolicyApplys() != null) {
                QosPolicyApplys result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosPolicyApplys) DefaultQosPolicyApplys.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosPolicyApplys(), true);
                } else {
                    result = ((DefaultQosPolicyApplys) qosPolicyApplys)
                            .processSubtreeFiltering(appInstance.qosPolicyApplys(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosPolicyApplys(result);
                }
            } else {
                if (isSubTreeFiltered && qosPolicyApplys() != null) {
                    subTreeFilteringResultBuilder.qosPolicyApplys(qosPolicyApplys);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosIfQos.
     */
    protected DefaultQosIfQos() {
    }

    /**
     * Returns the attribute qosIfQosBuilder.
     *
     * @return qosIfQosBuilder
     */
    public static QosIfQosBuilder builder() {
        return new QosIfQosBuilder();
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
     * Represents the builder implementation of qosIfQos.
     */
    public static class QosIfQosBuilder implements QosIfQos.QosIfQosBuilder {
        protected String ifName;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangQosIfQosOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected QosPolicyApplys qosPolicyApplys;



        @Override
        public String ifName() {
            return ifName;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangQosIfQosOpType() {
            return yangQosIfQosOpType;
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
        public QosPolicyApplys qosPolicyApplys() {
            return qosPolicyApplys;
        }

        @Override
        public QosIfQosBuilder ifName(String ifName) {
            valueLeafFlags.set(LeafIdentifier.IFNAME.getLeafIndex());
            this.ifName = ifName;
            return this;
        }

        @Override
        public QosIfQosBuilder yangQosIfQosOpType(OnosYangOpType yangQosIfQosOpType) {
            this.yangQosIfQosOpType = yangQosIfQosOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosIfQosBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosIfQosBuilder qosPolicyApplys(QosPolicyApplys qosPolicyApplys) {
            this.qosPolicyApplys = qosPolicyApplys;
            return this;
        }

        @Override
        public QosIfQosBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public QosIfQosBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosIfQos build() {
            return new DefaultQosIfQos(this);
        }

        /**
         * Builds object of qosIfQos.
         *
         * @return qosIfQos
         */
        public QosIfQos buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosIfQos(this);
        }
        /**
         * Creates an instance of qosIfQosBuilder.
         */
        public QosIfQosBuilder() {
        }

    }
}
