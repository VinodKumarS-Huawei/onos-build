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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos
            .qospolicyapplys;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys
            .qospolicyapply.DirectionEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys
            .qospolicyapply.LayerEnum;

/**
 * Represents the implementation of qosPolicyApply.
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
public class DefaultQosPolicyApply implements QosPolicyApply {
    protected DirectionEnum direction;
    protected LayerEnum layer;
    protected String policyName;
    protected boolean vlanMode;
    protected long groupId;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangQosPolicyApplyOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public DirectionEnum direction() {
        return direction;
    }

    @Override
    public LayerEnum layer() {
        return layer;
    }

    @Override
    public String policyName() {
        return policyName;
    }

    @Override
    public boolean vlanMode() {
        return vlanMode;
    }

    @Override
    public long groupId() {
        return groupId;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangQosPolicyApplyOpType() {
        return yangQosPolicyApplyOpType;
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
         return Objects.hash(direction, layer, policyName, vlanMode, groupId, valueLeafFlags,
                    yangQosPolicyApplyOpType, isSubTreeFiltered, selectLeafFlags, yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosPolicyApply) {
            DefaultQosPolicyApply other = (DefaultQosPolicyApply) obj;
            return
                Objects.equals(direction, other.direction) &&
                Objects.equals(layer, other.layer) &&
                Objects.equals(policyName, other.policyName) &&
                Objects.equals(vlanMode, other.vlanMode) &&
                Objects.equals(groupId, other.groupId) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangQosPolicyApplyOpType, other.yangQosPolicyApplyOpType) &&
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
            .add("direction", direction)
            .add("layer", layer)
            .add("policyName", policyName)
            .add("vlanMode", vlanMode)
            .add("groupId", groupId)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangQosPolicyApplyOpType", yangQosPolicyApplyOpType)
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
     * Creates an instance of qosPolicyApply.
     *
     * @param builderObject value of builder object of qosPolicyApply
     */
    protected DefaultQosPolicyApply(QosPolicyApplyBuilder builderObject) {
        direction = builderObject.direction();
        layer = builderObject.layer();
        policyName = builderObject.policyName();
        vlanMode = builderObject.vlanMode();
        groupId = builderObject.groupId();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangQosPolicyApplyOpType = builderObject.yangQosPolicyApplyOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed QosPolicyApply maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosPolicyApply processSubtreeFiltering(QosPolicyApply appInstance, boolean
                isSelectAllSchemaChild) {
        QosPolicyApplyBuilder subTreeFilteringResultBuilder = new QosPolicyApplyBuilder();
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
        return (DefaultQosPolicyApply) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(QosPolicyApply appInstance, QosPolicyApplyBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.DIRECTION.getLeafIndex())) {
            if (appInstance.direction() == null || !(direction().equals(appInstance.direction()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.DIRECTION)) {
                    subTreeFilteringResultBuilder.direction(direction());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.direction(appInstance.direction());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.DIRECTION.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.direction(appInstance.direction());
        }

        if (valueLeafFlags.get(LeafIdentifier.LAYER.getLeafIndex())) {
            if (appInstance.layer() == null || !(layer().equals(appInstance.layer()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.LAYER)) {
                    subTreeFilteringResultBuilder.layer(layer());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.layer(appInstance.layer());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.LAYER.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.layer(appInstance.layer());
        }

        if (valueLeafFlags.get(LeafIdentifier.POLICYNAME.getLeafIndex())) {
            if (appInstance.policyName() == null || !(policyName().equals(appInstance.policyName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.POLICYNAME)) {
                    subTreeFilteringResultBuilder.policyName(policyName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.policyName(appInstance.policyName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.POLICYNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.policyName(appInstance.policyName());
        }

        if (valueLeafFlags.get(LeafIdentifier.VLANMODE.getLeafIndex())) {
            if (appInstance.vlanMode() != vlanMode()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.VLANMODE)) {
                    subTreeFilteringResultBuilder.vlanMode(vlanMode());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.vlanMode(appInstance.vlanMode());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.VLANMODE.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.vlanMode(appInstance.vlanMode());
        }

        if (valueLeafFlags.get(LeafIdentifier.GROUPID.getLeafIndex())) {
            if (appInstance.groupId() != groupId()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.GROUPID)) {
                    subTreeFilteringResultBuilder.groupId(groupId());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.groupId(appInstance.groupId());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.GROUPID.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.groupId(appInstance.groupId());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(QosPolicyApply appInstance, QosPolicyApplyBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        return true;
    }


    /**
     * Creates an instance of defaultQosPolicyApply.
     */
    protected DefaultQosPolicyApply() {
    }

    /**
     * Returns the attribute qosPolicyApplyBuilder.
     *
     * @return qosPolicyApplyBuilder
     */
    public static QosPolicyApplyBuilder builder() {
        return new QosPolicyApplyBuilder();
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
     * Represents the builder implementation of qosPolicyApply.
     */
    public static class QosPolicyApplyBuilder implements QosPolicyApply.QosPolicyApplyBuilder {
        protected DirectionEnum direction;
        protected LayerEnum layer;
        protected String policyName;
        protected boolean vlanMode;
        protected long groupId;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangQosPolicyApplyOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public DirectionEnum direction() {
            return direction;
        }

        @Override
        public LayerEnum layer() {
            return layer;
        }

        @Override
        public String policyName() {
            return policyName;
        }

        @Override
        public boolean vlanMode() {
            return vlanMode;
        }

        @Override
        public long groupId() {
            return groupId;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangQosPolicyApplyOpType() {
            return yangQosPolicyApplyOpType;
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
        public QosPolicyApplyBuilder direction(DirectionEnum direction) {
            valueLeafFlags.set(LeafIdentifier.DIRECTION.getLeafIndex());
            this.direction = direction;
            return this;
        }

        @Override
        public QosPolicyApplyBuilder layer(LayerEnum layer) {
            valueLeafFlags.set(LeafIdentifier.LAYER.getLeafIndex());
            this.layer = layer;
            return this;
        }

        @Override
        public QosPolicyApplyBuilder policyName(String policyName) {
            valueLeafFlags.set(LeafIdentifier.POLICYNAME.getLeafIndex());
            this.policyName = policyName;
            return this;
        }

        @Override
        public QosPolicyApplyBuilder vlanMode(boolean vlanMode) {
            valueLeafFlags.set(LeafIdentifier.VLANMODE.getLeafIndex());
            this.vlanMode = vlanMode;
            return this;
        }

        @Override
        public QosPolicyApplyBuilder groupId(long groupId) {
            valueLeafFlags.set(LeafIdentifier.GROUPID.getLeafIndex());
            this.groupId = groupId;
            return this;
        }

        @Override
        public QosPolicyApplyBuilder yangQosPolicyApplyOpType(OnosYangOpType yangQosPolicyApplyOpType) {
            this.yangQosPolicyApplyOpType = yangQosPolicyApplyOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosPolicyApplyBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosPolicyApplyBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public QosPolicyApplyBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosPolicyApply build() {
            return new DefaultQosPolicyApply(this);
        }

        /**
         * Builds object of qosPolicyApply.
         *
         * @return qosPolicyApply
         */
        public QosPolicyApply buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosPolicyApply(this);
        }
        /**
         * Creates an instance of qosPolicyApplyBuilder.
         */
        public QosPolicyApplyBuilder() {
        }

    }
}
