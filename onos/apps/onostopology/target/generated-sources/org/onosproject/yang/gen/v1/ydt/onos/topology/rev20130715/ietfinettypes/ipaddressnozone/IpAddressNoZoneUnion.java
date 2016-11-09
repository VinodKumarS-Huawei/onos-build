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

package org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.ipaddressnozone;

import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.Ipv4AddressNoZone;
import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.Ipv6AddressNoZone;
import java.util.Objects;
import java.util.BitSet;

/**
 * Represents the implementation of ipAddressNoZoneUnion.
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
public final class IpAddressNoZoneUnion {
    private Ipv4AddressNoZone ipv4AddressNoZone;
    private Ipv6AddressNoZone ipv6AddressNoZone;
    private BitSet setValue = new BitSet();

    /**
     * Creates an instance of ipAddressNoZoneUnion.
     */
    private IpAddressNoZoneUnion() {
    }

    /**
     * Creates an instance of ipv4AddressNoZone.
     *
     * @param ipv4AddressNoZone value of ipv4AddressNoZone
     */
    public IpAddressNoZoneUnion(Ipv4AddressNoZone ipv4AddressNoZone) {
        setValue.set(0);
        this.ipv4AddressNoZone = ipv4AddressNoZone;
    }

    /**
     * Creates an instance of ipv6AddressNoZone.
     *
     * @param ipv6AddressNoZone value of ipv6AddressNoZone
     */
    public IpAddressNoZoneUnion(Ipv6AddressNoZone ipv6AddressNoZone) {
        setValue.set(1);
        this.ipv6AddressNoZone = ipv6AddressNoZone;
    }

    /**
     * Returns the object of ipAddressNoZoneUnion for type ipv4AddressNoZone.
     *
     * @param value value of ipAddressNoZoneUnion for type ipv4AddressNoZone
     * @return ipAddressNoZoneUnion for type ipv4AddressNoZone
     */
    public static IpAddressNoZoneUnion of(Ipv4AddressNoZone value) {
        return new IpAddressNoZoneUnion(value);
    }

    /**
     * Returns the object of ipAddressNoZoneUnion for type ipv6AddressNoZone.
     *
     * @param value value of ipAddressNoZoneUnion for type ipv6AddressNoZone
     * @return ipAddressNoZoneUnion for type ipv6AddressNoZone
     */
    public static IpAddressNoZoneUnion of(Ipv6AddressNoZone value) {
        return new IpAddressNoZoneUnion(value);
    }

    /**
     * Returns the attribute ipv4AddressNoZone.
     *
     * @return ipv4AddressNoZone value of ipv4AddressNoZone
     */
    public Ipv4AddressNoZone ipv4AddressNoZone() {
        return ipv4AddressNoZone;
    }
    /**
     * Returns the attribute ipv6AddressNoZone.
     *
     * @return ipv6AddressNoZone value of ipv6AddressNoZone
     */
    public Ipv6AddressNoZone ipv6AddressNoZone() {
        return ipv6AddressNoZone;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipv4AddressNoZone, ipv6AddressNoZone);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpAddressNoZoneUnion) {
            IpAddressNoZoneUnion other = (IpAddressNoZoneUnion) obj;
            return
                Objects.equals(ipv4AddressNoZone, other.ipv4AddressNoZone) &&
                Objects.equals(ipv6AddressNoZone, other.ipv6AddressNoZone);
        }
        return false;
    }

    @Override
    public String toString() {
        if (setValue.get(0)) {
            return ipv4AddressNoZone.toString();
        }
        if (setValue.get(1)) {
            return ipv6AddressNoZone.toString();
        }
        return null;
    }
    /**
     * Returns the object of ipAddressNoZoneUnion fromString input StringipAddressNoZoneUnion.
     *
     * @param valInString value of input String
     * @return ipAddressNoZoneUnion
     */
    public static IpAddressNoZoneUnion fromString(String valInString) {
        try {
            Ipv4AddressNoZone tmpVal = Ipv4AddressNoZone.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        try {
            Ipv6AddressNoZone tmpVal = Ipv6AddressNoZone.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
