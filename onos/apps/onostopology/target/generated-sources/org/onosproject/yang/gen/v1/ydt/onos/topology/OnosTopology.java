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

package org.onosproject.yang.gen.v1.ydt.onos.topology;

import java.util.List;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.Device;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.Link;

/**
 * Abstraction of an entity which represents the functionality of onosTopology.
 */
public interface OnosTopology {
    /**
     * Specify the node specific operation in protocols like NETCONF.
     * Applicable in protocol edit operation, not applicable in query operation
     */
    public static enum OnosYangOpType {
        MERGE,
        REPLACE,
        CREATE,
        DELETE,
        REMOVE,
        NONE
    }

    /**
     * Returns the attribute yangOnosTopologyOpType.
     *
     * @return yangOnosTopologyOpType value of yangOnosTopologyOpType
     */
    OnosYangOpType yangOnosTopologyOpType();

    /**
     * Returns the attribute device.
     *
     * @return device list of device
     */
    List<Device> device();

    /**
     * Returns the attribute link.
     *
     * @return link list of link
     */
    List<Link> link();


    /**
     * Builder for onosTopology.
     */
    interface OnosTopologyBuilder {
        /**
         * Adds to the list of device.
         *
         * @param addTo value of device
         * @return builder object of device
         */
         OnosTopologyBuilder addToDevice(Device addTo);

        /**
         * Adds to the list of link.
         *
         * @param addTo value of link
         * @return builder object of link
         */
         OnosTopologyBuilder addToLink(Link addTo);

        /**
         * Returns the attribute yangOnosTopologyOpType.
         *
         * @return yangOnosTopologyOpType value of yangOnosTopologyOpType
         */
        OnosYangOpType yangOnosTopologyOpType();

        /**
         * Returns the attribute device.
         *
         * @return device list of device
         */
        List<Device> device();

        /**
         * Returns the attribute link.
         *
         * @return link list of link
         */
        List<Link> link();

        /**
         * Returns the builder object of yangOnosTopologyOpType.
         *
         * @param yangOnosTopologyOpType value of yangOnosTopologyOpType
         * @return yangOnosTopologyOpType
         */
        OnosTopologyBuilder yangOnosTopologyOpType(OnosYangOpType yangOnosTopologyOpType);

        /**
         * Returns the builder object of device.
         *
         * @param device list of device
         * @return device
         */
        OnosTopologyBuilder device(List<Device> device);

        /**
         * Returns the builder object of link.
         *
         * @param link list of link
         * @return link
         */
        OnosTopologyBuilder link(List<Link> link);

        /**
         * Builds object of onosTopology.
         *
         * @return onosTopology
         */
        OnosTopology build();
    }
}
