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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors;

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
            .DefaultQosActRdrNhps;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .QosActRdrNhps;

/**
 * Represents the implementation of qosBehavior.
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
public class DefaultQosBehavior implements QosBehavior {
    protected String behaviorName;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangQosBehaviorOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected QosActRdrNhps qosActRdrNhps;

    @Override
    public String behaviorName() {
        return behaviorName;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangQosBehaviorOpType() {
        return yangQosBehaviorOpType;
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
    public QosActRdrNhps qosActRdrNhps() {
        return qosActRdrNhps;
    }

    @Override
    public int hashCode() {
         return Objects.hash(behaviorName, valueLeafFlags, yangQosBehaviorOpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap, qosActRdrNhps);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosBehavior) {
            DefaultQosBehavior other = (DefaultQosBehavior) obj;
            return
                Objects.equals(behaviorName, other.behaviorName) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangQosBehaviorOpType, other.yangQosBehaviorOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosActRdrNhps, other.qosActRdrNhps);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("behaviorName", behaviorName)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangQosBehaviorOpType", yangQosBehaviorOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosActRdrNhps", qosActRdrNhps)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosBehavior.
     *
     * @param builderObject value of builder object of qosBehavior
     */
    protected DefaultQosBehavior(QosBehaviorBuilder builderObject) {
        behaviorName = builderObject.behaviorName();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangQosBehaviorOpType = builderObject.yangQosBehaviorOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosActRdrNhps = builderObject.qosActRdrNhps();
    }

    /**
     * Checks if the passed QosBehavior maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosBehavior processSubtreeFiltering(QosBehavior appInstance, boolean isSelectAllSchemaChild) {
        QosBehaviorBuilder subTreeFilteringResultBuilder = new QosBehaviorBuilder();
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
        return (DefaultQosBehavior) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(QosBehavior appInstance, QosBehaviorBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.BEHAVIORNAME.getLeafIndex())) {
            if (appInstance.behaviorName() == null || !(behaviorName().equals(appInstance.behaviorName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.BEHAVIORNAME)) {
                    subTreeFilteringResultBuilder.behaviorName(behaviorName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.behaviorName(appInstance.behaviorName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.BEHAVIORNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.behaviorName(appInstance.behaviorName());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(QosBehavior appInstance, QosBehaviorBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (qosActRdrNhps() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosActRdrNhps() != null) {
                QosActRdrNhps result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosActRdrNhps) DefaultQosActRdrNhps.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosActRdrNhps(), true);
                } else {
                    result = ((DefaultQosActRdrNhps) qosActRdrNhps)
                            .processSubtreeFiltering(appInstance.qosActRdrNhps(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosActRdrNhps(result);
                }
            } else {
                if (isSubTreeFiltered && qosActRdrNhps() != null) {
                    subTreeFilteringResultBuilder.qosActRdrNhps(qosActRdrNhps);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosBehavior.
     */
    protected DefaultQosBehavior() {
    }

    /**
     * Returns the attribute qosBehaviorBuilder.
     *
     * @return qosBehaviorBuilder
     */
    public static QosBehaviorBuilder builder() {
        return new QosBehaviorBuilder();
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
     * Represents the builder implementation of qosBehavior.
     */
    public static class QosBehaviorBuilder implements QosBehavior.QosBehaviorBuilder {
        protected String behaviorName;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangQosBehaviorOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected QosActRdrNhps qosActRdrNhps;



        @Override
        public String behaviorName() {
            return behaviorName;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangQosBehaviorOpType() {
            return yangQosBehaviorOpType;
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
        public QosActRdrNhps qosActRdrNhps() {
            return qosActRdrNhps;
        }

        @Override
        public QosBehaviorBuilder behaviorName(String behaviorName) {
            valueLeafFlags.set(LeafIdentifier.BEHAVIORNAME.getLeafIndex());
            this.behaviorName = behaviorName;
            return this;
        }

        @Override
        public QosBehaviorBuilder yangQosBehaviorOpType(OnosYangOpType yangQosBehaviorOpType) {
            this.yangQosBehaviorOpType = yangQosBehaviorOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosBehaviorBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosBehaviorBuilder qosActRdrNhps(QosActRdrNhps qosActRdrNhps) {
            this.qosActRdrNhps = qosActRdrNhps;
            return this;
        }

        @Override
        public QosBehaviorBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public QosBehaviorBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosBehavior build() {
            return new DefaultQosBehavior(this);
        }

        /**
         * Builds object of qosBehavior.
         *
         * @return qosBehavior
         */
        public QosBehavior buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosBehavior(this);
        }
        /**
         * Creates an instance of qosBehaviorBuilder.
         */
        public QosBehaviorBuilder() {
        }

    }
}
