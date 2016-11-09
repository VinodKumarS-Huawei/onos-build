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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device;

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopology.OnosYangOpType;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.port.PortTypeEnum;

/**
 * Represents the implementation of ports.
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
public class DefaultPorts implements Ports {
    protected long number;
    protected boolean isEnabled;
    protected PortTypeEnum portType;
    protected long portSpeed;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangPortsOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public long number() {
        return number;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public PortTypeEnum portType() {
        return portType;
    }

    @Override
    public long portSpeed() {
        return portSpeed;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangPortsOpType() {
        return yangPortsOpType;
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
         return Objects.hash(number, isEnabled, portType, portSpeed, valueLeafFlags, yangPortsOpType,
                    isSubTreeFiltered, selectLeafFlags, yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultPorts) {
            DefaultPorts other = (DefaultPorts) obj;
            return
                Objects.equals(number, other.number) &&
                Objects.equals(isEnabled, other.isEnabled) &&
                Objects.equals(portType, other.portType) &&
                Objects.equals(portSpeed, other.portSpeed) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangPortsOpType, other.yangPortsOpType) &&
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
            .add("number", number)
            .add("isEnabled", isEnabled)
            .add("portType", portType)
            .add("portSpeed", portSpeed)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangPortsOpType", yangPortsOpType)
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
     * Creates an instance of ports.
     *
     * @param builderObject value of builder object of ports
     */
    protected DefaultPorts(PortsBuilder builderObject) {
        number = builderObject.number();
        isEnabled = builderObject.isEnabled();
        portType = builderObject.portType();
        portSpeed = builderObject.portSpeed();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangPortsOpType = builderObject.yangPortsOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed Ports maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultPorts processSubtreeFiltering(Ports appInstance, boolean isSelectAllSchemaChild) {
        PortsBuilder subTreeFilteringResultBuilder = new PortsBuilder();
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
        return (DefaultPorts) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Ports appInstance, PortsBuilder subTreeFilteringResultBuilder, BitSet
                isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.NUMBER.getLeafIndex())) {
            if (appInstance.number() != number()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.NUMBER)) {
                    subTreeFilteringResultBuilder.number(number());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.number(appInstance.number());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.NUMBER.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.number(appInstance.number());
        }

        if (valueLeafFlags.get(LeafIdentifier.ISENABLED.getLeafIndex())) {
            if (appInstance.isEnabled() != isEnabled()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ISENABLED)) {
                    subTreeFilteringResultBuilder.isEnabled(isEnabled());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.isEnabled(appInstance.isEnabled());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ISENABLED.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.isEnabled(appInstance.isEnabled());
        }

        if (valueLeafFlags.get(LeafIdentifier.PORTTYPE.getLeafIndex())) {
            if (appInstance.portType() == null || !(portType().equals(appInstance.portType()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.PORTTYPE)) {
                    subTreeFilteringResultBuilder.portType(portType());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.portType(appInstance.portType());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.PORTTYPE.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.portType(appInstance.portType());
        }

        if (valueLeafFlags.get(LeafIdentifier.PORTSPEED.getLeafIndex())) {
            if (appInstance.portSpeed() != portSpeed()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.PORTSPEED)) {
                    subTreeFilteringResultBuilder.portSpeed(portSpeed());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.portSpeed(appInstance.portSpeed());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.PORTSPEED.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.portSpeed(appInstance.portSpeed());
        }

        return true;
    }

     private boolean processChildNodesSubTreeFiltering(Ports appInstance, PortsBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        return true;
    }


    /**
     * Creates an instance of defaultPorts.
     */
    protected DefaultPorts() {
    }

    /**
     * Returns the attribute portsBuilder.
     *
     * @return portsBuilder
     */
    public static PortsBuilder builder() {
        return new PortsBuilder();
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
     * Represents the builder implementation of ports.
     */
    public static class PortsBuilder implements Ports.PortsBuilder {
        protected long number;
        protected boolean isEnabled;
        protected PortTypeEnum portType;
        protected long portSpeed;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangPortsOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public long number() {
            return number;
        }

        @Override
        public boolean isEnabled() {
            return isEnabled;
        }

        @Override
        public PortTypeEnum portType() {
            return portType;
        }

        @Override
        public long portSpeed() {
            return portSpeed;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangPortsOpType() {
            return yangPortsOpType;
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
        public PortsBuilder number(long number) {
            valueLeafFlags.set(LeafIdentifier.NUMBER.getLeafIndex());
            this.number = number;
            return this;
        }

        @Override
        public PortsBuilder isEnabled(boolean isEnabled) {
            valueLeafFlags.set(LeafIdentifier.ISENABLED.getLeafIndex());
            this.isEnabled = isEnabled;
            return this;
        }

        @Override
        public PortsBuilder portType(PortTypeEnum portType) {
            valueLeafFlags.set(LeafIdentifier.PORTTYPE.getLeafIndex());
            this.portType = portType;
            return this;
        }

        @Override
        public PortsBuilder portSpeed(long portSpeed) {
            valueLeafFlags.set(LeafIdentifier.PORTSPEED.getLeafIndex());
            this.portSpeed = portSpeed;
            return this;
        }

        @Override
        public PortsBuilder yangPortsOpType(OnosYangOpType yangPortsOpType) {
            this.yangPortsOpType = yangPortsOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public PortsBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public PortsBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public PortsBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public Ports build() {
            return new DefaultPorts(this);
        }

        /**
         * Builds object of ports.
         *
         * @return ports
         */
        public Ports buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultPorts(this);
        }
        /**
         * Creates an instance of portsBuilder.
         */
        public PortsBuilder() {
        }

    }
}
