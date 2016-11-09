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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps.qosactrdrnhp.RdrTypeEnum;

/**
 * Represents the implementation of qosActRdrNhp.
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
public class DefaultQosActRdrNhp implements QosActRdrNhp {
    protected String nextHop;
    protected RdrTypeEnum rdrType;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangQosActRdrNhpOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public String nextHop() {
        return nextHop;
    }

    @Override
    public RdrTypeEnum rdrType() {
        return rdrType;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangQosActRdrNhpOpType() {
        return yangQosActRdrNhpOpType;
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
         return Objects.hash(nextHop, rdrType, valueLeafFlags, yangQosActRdrNhpOpType, isSubTreeFiltered,
                    selectLeafFlags, yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosActRdrNhp) {
            DefaultQosActRdrNhp other = (DefaultQosActRdrNhp) obj;
            return
                Objects.equals(nextHop, other.nextHop) &&
                Objects.equals(rdrType, other.rdrType) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangQosActRdrNhpOpType, other.yangQosActRdrNhpOpType) &&
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
            .add("nextHop", nextHop)
            .add("rdrType", rdrType)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangQosActRdrNhpOpType", yangQosActRdrNhpOpType)
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
     * Creates an instance of qosActRdrNhp.
     *
     * @param builderObject value of builder object of qosActRdrNhp
     */
    protected DefaultQosActRdrNhp(QosActRdrNhpBuilder builderObject) {
        nextHop = builderObject.nextHop();
        rdrType = builderObject.rdrType();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangQosActRdrNhpOpType = builderObject.yangQosActRdrNhpOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed QosActRdrNhp maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosActRdrNhp processSubtreeFiltering(QosActRdrNhp appInstance, boolean isSelectAllSchemaChild) {
        QosActRdrNhpBuilder subTreeFilteringResultBuilder = new QosActRdrNhpBuilder();
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
        return (DefaultQosActRdrNhp) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(QosActRdrNhp appInstance, QosActRdrNhpBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.NEXTHOP.getLeafIndex())) {
            if (appInstance.nextHop() == null || !(nextHop().equals(appInstance.nextHop()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.NEXTHOP)) {
                    subTreeFilteringResultBuilder.nextHop(nextHop());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.nextHop(appInstance.nextHop());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.NEXTHOP.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.nextHop(appInstance.nextHop());
        }

        if (valueLeafFlags.get(LeafIdentifier.RDRTYPE.getLeafIndex())) {
            if (appInstance.rdrType() == null || !(rdrType().equals(appInstance.rdrType()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.RDRTYPE)) {
                    subTreeFilteringResultBuilder.rdrType(rdrType());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.rdrType(appInstance.rdrType());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.RDRTYPE.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.rdrType(appInstance.rdrType());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(QosActRdrNhp appInstance, QosActRdrNhpBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        return true;
    }


    /**
     * Creates an instance of defaultQosActRdrNhp.
     */
    protected DefaultQosActRdrNhp() {
    }

    /**
     * Returns the attribute qosActRdrNhpBuilder.
     *
     * @return qosActRdrNhpBuilder
     */
    public static QosActRdrNhpBuilder builder() {
        return new QosActRdrNhpBuilder();
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
     * Represents the builder implementation of qosActRdrNhp.
     */
    public static class QosActRdrNhpBuilder implements QosActRdrNhp.QosActRdrNhpBuilder {
        protected String nextHop;
        protected RdrTypeEnum rdrType;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangQosActRdrNhpOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public String nextHop() {
            return nextHop;
        }

        @Override
        public RdrTypeEnum rdrType() {
            return rdrType;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangQosActRdrNhpOpType() {
            return yangQosActRdrNhpOpType;
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
        public QosActRdrNhpBuilder nextHop(String nextHop) {
            valueLeafFlags.set(LeafIdentifier.NEXTHOP.getLeafIndex());
            this.nextHop = nextHop;
            return this;
        }

        @Override
        public QosActRdrNhpBuilder rdrType(RdrTypeEnum rdrType) {
            valueLeafFlags.set(LeafIdentifier.RDRTYPE.getLeafIndex());
            this.rdrType = rdrType;
            return this;
        }

        @Override
        public QosActRdrNhpBuilder yangQosActRdrNhpOpType(OnosYangOpType yangQosActRdrNhpOpType) {
            this.yangQosActRdrNhpOpType = yangQosActRdrNhpOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosActRdrNhpBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosActRdrNhpBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public QosActRdrNhpBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosActRdrNhp build() {
            return new DefaultQosActRdrNhp(this);
        }

        /**
         * Builds object of qosActRdrNhp.
         *
         * @return qosActRdrNhp
         */
        public QosActRdrNhp buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosActRdrNhp(this);
        }
        /**
         * Creates an instance of qosActRdrNhpBuilder.
         */
        public QosActRdrNhpBuilder() {
        }

    }
}
