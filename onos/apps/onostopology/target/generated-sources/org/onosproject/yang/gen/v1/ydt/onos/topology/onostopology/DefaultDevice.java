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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology;

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
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopology.OnosYangOpType;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.DefaultPorts;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.Ports;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.TypeEnum;

/**
 * Represents the implementation of device.
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
public class DefaultDevice implements Device {
    protected DeviceId id;
    protected TypeEnum type;
    protected String manufacturer;
    protected String hwVersion;
    protected String swVersion;
    protected String serialNumber;
    protected ChassisId chassisId;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangDeviceOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<Ports> ports;

    @Override
    public DeviceId id() {
        return id;
    }

    @Override
    public TypeEnum type() {
        return type;
    }

    @Override
    public String manufacturer() {
        return manufacturer;
    }

    @Override
    public String hwVersion() {
        return hwVersion;
    }

    @Override
    public String swVersion() {
        return swVersion;
    }

    @Override
    public String serialNumber() {
        return serialNumber;
    }

    @Override
    public ChassisId chassisId() {
        return chassisId;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangDeviceOpType() {
        return yangDeviceOpType;
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
    public List<Ports> ports() {
        return ports;
    }

    @Override
    public int hashCode() {
         return Objects.hash(id, type, manufacturer, hwVersion, swVersion, serialNumber, chassisId, valueLeafFlags,
                    yangDeviceOpType, isSubTreeFiltered, selectLeafFlags, yangAugmentedInfoMap, ports);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultDevice) {
            DefaultDevice other = (DefaultDevice) obj;
            return
                Objects.equals(id, other.id) &&
                Objects.equals(type, other.type) &&
                Objects.equals(manufacturer, other.manufacturer) &&
                Objects.equals(hwVersion, other.hwVersion) &&
                Objects.equals(swVersion, other.swVersion) &&
                Objects.equals(serialNumber, other.serialNumber) &&
                Objects.equals(chassisId, other.chassisId) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangDeviceOpType, other.yangDeviceOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(ports, other.ports);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("id", id)
            .add("type", type)
            .add("manufacturer", manufacturer)
            .add("hwVersion", hwVersion)
            .add("swVersion", swVersion)
            .add("serialNumber", serialNumber)
            .add("chassisId", chassisId)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangDeviceOpType", yangDeviceOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("ports", ports)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of device.
     *
     * @param builderObject value of builder object of device
     */
    protected DefaultDevice(DeviceBuilder builderObject) {
        id = builderObject.id();
        type = builderObject.type();
        manufacturer = builderObject.manufacturer();
        hwVersion = builderObject.hwVersion();
        swVersion = builderObject.swVersion();
        serialNumber = builderObject.serialNumber();
        chassisId = builderObject.chassisId();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangDeviceOpType = builderObject.yangDeviceOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        ports = builderObject.ports();
    }

    /**
     * Checks if the passed Device maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultDevice processSubtreeFiltering(Device appInstance, boolean isSelectAllSchemaChild) {
        DeviceBuilder subTreeFilteringResultBuilder = new DeviceBuilder();
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
        return (DefaultDevice) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Device appInstance, DeviceBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.ID.getLeafIndex())) {
            if (appInstance.id() == null || !(id().equals(appInstance.id()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ID)) {
                    subTreeFilteringResultBuilder.id(id());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.id(appInstance.id());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ID.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.id(appInstance.id());
        }

        if (valueLeafFlags.get(LeafIdentifier.TYPE.getLeafIndex())) {
            if (appInstance.type() == null || !(type().equals(appInstance.type()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.TYPE)) {
                    subTreeFilteringResultBuilder.type(type());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.type(appInstance.type());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.TYPE.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.type(appInstance.type());
        }

        if (valueLeafFlags.get(LeafIdentifier.MANUFACTURER.getLeafIndex())) {
            if (appInstance.manufacturer() == null || !(manufacturer().equals(appInstance.manufacturer()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.MANUFACTURER)) {
                    subTreeFilteringResultBuilder.manufacturer(manufacturer());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.manufacturer(appInstance.manufacturer());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.MANUFACTURER.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.manufacturer(appInstance.manufacturer());
        }

        if (valueLeafFlags.get(LeafIdentifier.HWVERSION.getLeafIndex())) {
            if (appInstance.hwVersion() == null || !(hwVersion().equals(appInstance.hwVersion()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.HWVERSION)) {
                    subTreeFilteringResultBuilder.hwVersion(hwVersion());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.hwVersion(appInstance.hwVersion());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.HWVERSION.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.hwVersion(appInstance.hwVersion());
        }

        if (valueLeafFlags.get(LeafIdentifier.SWVERSION.getLeafIndex())) {
            if (appInstance.swVersion() == null || !(swVersion().equals(appInstance.swVersion()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.SWVERSION)) {
                    subTreeFilteringResultBuilder.swVersion(swVersion());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.swVersion(appInstance.swVersion());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.SWVERSION.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.swVersion(appInstance.swVersion());
        }

        if (valueLeafFlags.get(LeafIdentifier.SERIALNUMBER.getLeafIndex())) {
            if (appInstance.serialNumber() == null || !(serialNumber().equals(appInstance.serialNumber()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.SERIALNUMBER)) {
                    subTreeFilteringResultBuilder.serialNumber(serialNumber());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.serialNumber(appInstance.serialNumber());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.SERIALNUMBER.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.serialNumber(appInstance.serialNumber());
        }

        if (valueLeafFlags.get(LeafIdentifier.CHASSISID.getLeafIndex())) {
            if (appInstance.chassisId() == null || !(chassisId().equals(appInstance.chassisId()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.CHASSISID)) {
                    subTreeFilteringResultBuilder.chassisId(chassisId());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.chassisId(appInstance.chassisId());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.CHASSISID.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.chassisId(appInstance.chassisId());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(Device appInstance, DeviceBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.ports() != null) {
                for (Ports ports : appInstance.ports()) {
                    Ports result;
                    result = ((DefaultPorts) DefaultPorts.builder()
                            .buildForFilter()).processSubtreeFiltering(ports, true);
                    subTreeFilteringResultBuilder.addToPorts(result);
                }
            } else {
                if (isSubTreeFiltered && ports() != null) {
                    subTreeFilteringResultBuilder.ports(ports);
                }
            }
        } else if (ports() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!ports().isEmpty()) {
                if (appInstance.ports() != null && !appInstance.ports().isEmpty()) {
                for (Ports ports : ports()) {
                    for (Ports ports2 : appInstance.ports()) {
                            Ports result = ((DefaultPorts) ports)
                            .processSubtreeFiltering(ports2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToPorts(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && ports() != null) {
                    subTreeFilteringResultBuilder.ports(ports);
                }
            }
            } else {
                if (appInstance.ports() != null && !appInstance.ports().isEmpty()) {
                for (Ports ports : appInstance.ports()) {
                        subTreeFilteringResultBuilder.addToPorts(ports);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultDevice.
     */
    protected DefaultDevice() {
    }

    /**
     * Returns the attribute deviceBuilder.
     *
     * @return deviceBuilder
     */
    public static DeviceBuilder builder() {
        return new DeviceBuilder();
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
     * Represents the builder implementation of device.
     */
    public static class DeviceBuilder implements Device.DeviceBuilder {
        protected DeviceId id;
        protected TypeEnum type;
        protected String manufacturer;
        protected String hwVersion;
        protected String swVersion;
        protected String serialNumber;
        protected ChassisId chassisId;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangDeviceOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<Ports> ports;



        @Override
        public DeviceId id() {
            return id;
        }

        @Override
        public TypeEnum type() {
            return type;
        }

        @Override
        public String manufacturer() {
            return manufacturer;
        }

        @Override
        public String hwVersion() {
            return hwVersion;
        }

        @Override
        public String swVersion() {
            return swVersion;
        }

        @Override
        public String serialNumber() {
            return serialNumber;
        }

        @Override
        public ChassisId chassisId() {
            return chassisId;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangDeviceOpType() {
            return yangDeviceOpType;
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
        public List<Ports> ports() {
            return ports;
        }

        @Override
        public DeviceBuilder id(DeviceId id) {
            valueLeafFlags.set(LeafIdentifier.ID.getLeafIndex());
            this.id = id;
            return this;
        }

        @Override
        public DeviceBuilder type(TypeEnum type) {
            valueLeafFlags.set(LeafIdentifier.TYPE.getLeafIndex());
            this.type = type;
            return this;
        }

        @Override
        public DeviceBuilder manufacturer(String manufacturer) {
            valueLeafFlags.set(LeafIdentifier.MANUFACTURER.getLeafIndex());
            this.manufacturer = manufacturer;
            return this;
        }

        @Override
        public DeviceBuilder hwVersion(String hwVersion) {
            valueLeafFlags.set(LeafIdentifier.HWVERSION.getLeafIndex());
            this.hwVersion = hwVersion;
            return this;
        }

        @Override
        public DeviceBuilder swVersion(String swVersion) {
            valueLeafFlags.set(LeafIdentifier.SWVERSION.getLeafIndex());
            this.swVersion = swVersion;
            return this;
        }

        @Override
        public DeviceBuilder serialNumber(String serialNumber) {
            valueLeafFlags.set(LeafIdentifier.SERIALNUMBER.getLeafIndex());
            this.serialNumber = serialNumber;
            return this;
        }

        @Override
        public DeviceBuilder chassisId(ChassisId chassisId) {
            valueLeafFlags.set(LeafIdentifier.CHASSISID.getLeafIndex());
            this.chassisId = chassisId;
            return this;
        }

        @Override
        public DeviceBuilder yangDeviceOpType(OnosYangOpType yangDeviceOpType) {
            this.yangDeviceOpType = yangDeviceOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public DeviceBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public DeviceBuilder ports(List<Ports> ports) {
            this.ports = ports;
            return this;
        }

        @Override
        public DeviceBuilder addToPorts(Ports addTo) {
            if (ports == null) {
                ports = new ArrayList<>();
            }
            ports.add(addTo);
            return this;
        }


        @Override
        public DeviceBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public DeviceBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public Device build() {
            return new DefaultDevice(this);
        }

        /**
         * Builds object of device.
         *
         * @return device
         */
        public Device buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultDevice(this);
        }
        /**
         * Creates an instance of deviceBuilder.
         */
        public DeviceBuilder() {
        }

    }
}
