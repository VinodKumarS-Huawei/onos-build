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

import com.google.common.base.MoreObjects;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.DefaultDevice;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.DefaultLink;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.Device;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.Link;

/**
 * Represents the implementation of onosTopology.
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
public class OnosTopologyOpParam implements OnosTopology {
    protected OnosYangOpType yangOnosTopologyOpType;
    protected boolean isSubTreeFiltered;
    protected List<Device> device;
    protected List<Link> link;

    @Override
    public OnosYangOpType yangOnosTopologyOpType() {
        return yangOnosTopologyOpType;
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
    public List<Device> device() {
        return device;
    }

    @Override
    public List<Link> link() {
        return link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangOnosTopologyOpType, isSubTreeFiltered, device, link);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OnosTopologyOpParam) {
            OnosTopologyOpParam other = (OnosTopologyOpParam) obj;
            return
                Objects.equals(yangOnosTopologyOpType, other.yangOnosTopologyOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(device, other.device) &&
                Objects.equals(link, other.link);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangOnosTopologyOpType", yangOnosTopologyOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("device", device)
            .add("link", link)
            .toString();
    }
    /**
     * Creates an instance of onosTopology.
     *
     * @param builderObject value of builder object of onosTopology
     */
    protected OnosTopologyOpParam(OnosTopologyBuilder builderObject) {
        yangOnosTopologyOpType = builderObject.yangOnosTopologyOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        device = builderObject.device();
        link = builderObject.link();
    }

    /**
     * Checks if the passed OnosTopology maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public OnosTopologyOpParam processSubtreeFiltering(OnosTopology appInstance, boolean isSelectAllSchemaChild) {
        OnosTopologyBuilder subTreeFilteringResultBuilder = new OnosTopologyBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
         if (!processChildNodesSubTreeFiltering(appInstance, subTreeFilteringResultBuilder,
                    isAnySelectOrContainmentNode, isSelectAllSchemaChild)) {
            return null;
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (OnosTopologyOpParam) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(OnosTopology appInstance, OnosTopologyBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.device() != null) {
                for (Device device : appInstance.device()) {
                    Device result;
                    result = ((DefaultDevice) DefaultDevice.builder()
                            .buildForFilter()).processSubtreeFiltering(device, true);
                    subTreeFilteringResultBuilder.addToDevice(result);
                }
            } else {
                if (isSubTreeFiltered && device() != null) {
                    subTreeFilteringResultBuilder.device(device);
                }
            }
        } else if (device() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!device().isEmpty()) {
                if (appInstance.device() != null && !appInstance.device().isEmpty()) {
                for (Device device : device()) {
                    for (Device device2 : appInstance.device()) {
                            Device result = ((DefaultDevice) device)
                            .processSubtreeFiltering(device2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToDevice(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && device() != null) {
                    subTreeFilteringResultBuilder.device(device);
                }
            }
            } else {
                if (appInstance.device() != null && !appInstance.device().isEmpty()) {
                for (Device device : appInstance.device()) {
                        subTreeFilteringResultBuilder.addToDevice(device);
                    }
                }
            }
        }

        if (isSelectAllSchemaChild) {
            if (appInstance.link() != null) {
                for (Link link : appInstance.link()) {
                    Link result;
                    result = ((DefaultLink) DefaultLink.builder()
                            .buildForFilter()).processSubtreeFiltering(link, true);
                    subTreeFilteringResultBuilder.addToLink(result);
                }
            } else {
                if (isSubTreeFiltered && link() != null) {
                    subTreeFilteringResultBuilder.link(link);
                }
            }
        } else if (link() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!link().isEmpty()) {
                if (appInstance.link() != null && !appInstance.link().isEmpty()) {
                for (Link link : link()) {
                    for (Link link2 : appInstance.link()) {
                            Link result = ((DefaultLink) link)
                            .processSubtreeFiltering(link2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToLink(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && link() != null) {
                    subTreeFilteringResultBuilder.link(link);
                }
            }
            } else {
                if (appInstance.link() != null && !appInstance.link().isEmpty()) {
                for (Link link : appInstance.link()) {
                        subTreeFilteringResultBuilder.addToLink(link);
                    }
                }
            }
        }

        return true;
    }

    /**
     * Creates an instance of onosTopologyOpParam.
     */
    protected OnosTopologyOpParam() {
    }

    /**
     * Returns the attribute onosTopologyBuilder.
     *
     * @return onosTopologyBuilder
     */
    public static OnosTopologyBuilder builder() {
        return new OnosTopologyBuilder();
    }

    /**
     * Represents the builder implementation of onosTopology.
     */
    public static class OnosTopologyBuilder implements OnosTopology.OnosTopologyBuilder {
        protected OnosYangOpType yangOnosTopologyOpType;
        protected boolean isSubTreeFiltered;
        protected List<Device> device;
        protected List<Link> link;


        @Override
        public OnosYangOpType yangOnosTopologyOpType() {
            return yangOnosTopologyOpType;
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
        public List<Device> device() {
            return device;
        }

        @Override
        public List<Link> link() {
            return link;
        }

        @Override
        public OnosTopologyBuilder yangOnosTopologyOpType(OnosYangOpType yangOnosTopologyOpType) {
            this.yangOnosTopologyOpType = yangOnosTopologyOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public OnosTopologyBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public OnosTopologyBuilder device(List<Device> device) {
            this.device = device;
            return this;
        }

        @Override
        public OnosTopologyBuilder link(List<Link> link) {
            this.link = link;
            return this;
        }

        @Override
        public OnosTopologyBuilder addToDevice(Device addTo) {
            if (device == null) {
                device = new ArrayList<>();
            }
            device.add(addTo);
            return this;
        }


        @Override
        public OnosTopologyBuilder addToLink(Link addTo) {
            if (link == null) {
                link = new ArrayList<>();
            }
            link.add(addTo);
            return this;
        }

        @Override
        public OnosTopology build() {
            return new OnosTopologyOpParam(this);
        }

        /**
         * Builds object of onosTopology.
         *
         * @return onosTopology
         */
        public OnosTopology buildForFilter() {
            isSubTreeFiltered = true;
            return new OnosTopologyOpParam(this);
        }
        /**
         * Creates an instance of onosTopologyBuilder.
         */
        public OnosTopologyBuilder() {
        }

    }
}
