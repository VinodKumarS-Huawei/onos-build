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

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopology.OnosYangOpType;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.Ports;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.TypeEnum;

/**
 * Abstraction of an entity which represents the functionality of device.
 */
public interface Device {

    /**
     * Identify the leaf of Device.
     */
    public enum LeafIdentifier {
        /**
         * Represents id.
         */
        ID(1),
        /**
         * Represents type.
         */
        TYPE(2),
        /**
         * Represents manufacturer.
         */
        MANUFACTURER(3),
        /**
         * Represents hwVersion.
         */
        HWVERSION(4),
        /**
         * Represents swVersion.
         */
        SWVERSION(5),
        /**
         * Represents serialNumber.
         */
        SERIALNUMBER(6),
        /**
         * Represents chassisId.
         */
        CHASSISID(7);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute id.
     *
     * @return id value of id
     */
    DeviceId id();

    /**
     * Returns the attribute type.
     *
     * @return type value of type
     */
    TypeEnum type();

    /**
     * Returns the attribute manufacturer.
     *
     * @return manufacturer value of manufacturer
     */
    String manufacturer();

    /**
     * Returns the attribute hwVersion.
     *
     * @return hwVersion value of hwVersion
     */
    String hwVersion();

    /**
     * Returns the attribute swVersion.
     *
     * @return swVersion value of swVersion
     */
    String swVersion();

    /**
     * Returns the attribute serialNumber.
     *
     * @return serialNumber value of serialNumber
     */
    String serialNumber();

    /**
     * Returns the attribute chassisId.
     *
     * @return chassisId value of chassisId
     */
    ChassisId chassisId();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangDeviceOpType.
     *
     * @return yangDeviceOpType value of yangDeviceOpType
     */
    OnosYangOpType yangDeviceOpType();

    /**
     * Returns the attribute selectLeafFlags.
     *
     * @return selectLeafFlags value of selectLeafFlags
     */
    BitSet selectLeafFlags();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute ports.
     *
     * @return ports list of ports
     */
    List<Ports> ports();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Checks if the leaf value is set.
     *
     * @param leaf leaf whose value status needs to checked
     * @return result of leaf value set in object
     */
    boolean isLeafValueSet(LeafIdentifier leaf);

    /**
     * Checks if the leaf is set to be a selected leaf.
     *
     * @param leaf if leaf needs to be selected
     * @return result of leaf value set in object
     */
    boolean isSelectLeaf(LeafIdentifier leaf);

    /**
     * Builder for device.
     */
    interface DeviceBuilder {
        /**
         * Adds to the list of ports.
         *
         * @param addTo value of ports
         * @return builder object of ports
         */
         DeviceBuilder addToPorts(Ports addTo);

        /**
         * Returns the attribute id.
         *
         * @return id value of id
         */
        DeviceId id();

        /**
         * Returns the attribute type.
         *
         * @return type value of type
         */
        TypeEnum type();

        /**
         * Returns the attribute manufacturer.
         *
         * @return manufacturer value of manufacturer
         */
        String manufacturer();

        /**
         * Returns the attribute hwVersion.
         *
         * @return hwVersion value of hwVersion
         */
        String hwVersion();

        /**
         * Returns the attribute swVersion.
         *
         * @return swVersion value of swVersion
         */
        String swVersion();

        /**
         * Returns the attribute serialNumber.
         *
         * @return serialNumber value of serialNumber
         */
        String serialNumber();

        /**
         * Returns the attribute chassisId.
         *
         * @return chassisId value of chassisId
         */
        ChassisId chassisId();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangDeviceOpType.
         *
         * @return yangDeviceOpType value of yangDeviceOpType
         */
        OnosYangOpType yangDeviceOpType();

        /**
         * Returns the attribute selectLeafFlags.
         *
         * @return selectLeafFlags value of selectLeafFlags
         */
        BitSet selectLeafFlags();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute ports.
         *
         * @return ports list of ports
         */
        List<Ports> ports();

        /**
         * Returns the builder object of id.
         *
         * @param id value of id
         * @return id
         */
        DeviceBuilder id(DeviceId id);

        /**
         * Returns the builder object of type.
         *
         * @param type value of type
         * @return type
         */
        DeviceBuilder type(TypeEnum type);

        /**
         * Returns the builder object of manufacturer.
         *
         * @param manufacturer value of manufacturer
         * @return manufacturer
         */
        DeviceBuilder manufacturer(String manufacturer);

        /**
         * Returns the builder object of hwVersion.
         *
         * @param hwVersion value of hwVersion
         * @return hwVersion
         */
        DeviceBuilder hwVersion(String hwVersion);

        /**
         * Returns the builder object of swVersion.
         *
         * @param swVersion value of swVersion
         * @return swVersion
         */
        DeviceBuilder swVersion(String swVersion);

        /**
         * Returns the builder object of serialNumber.
         *
         * @param serialNumber value of serialNumber
         * @return serialNumber
         */
        DeviceBuilder serialNumber(String serialNumber);

        /**
         * Returns the builder object of chassisId.
         *
         * @param chassisId value of chassisId
         * @return chassisId
         */
        DeviceBuilder chassisId(ChassisId chassisId);

        /**
         * Returns the builder object of yangDeviceOpType.
         *
         * @param yangDeviceOpType value of yangDeviceOpType
         * @return yangDeviceOpType
         */
        DeviceBuilder yangDeviceOpType(OnosYangOpType yangDeviceOpType);

        /**
         * Returns the builder object of ports.
         *
         * @param ports list of ports
         * @return ports
         */
        DeviceBuilder ports(List<Ports> ports);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         DeviceBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Set a leaf to be selected.
         *
         * @param leaf leaf needs to be selected
         * @return builder object for select leaf
         */
        DeviceBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of device.
         *
         * @return device
         */
        Device build();
    }
}
