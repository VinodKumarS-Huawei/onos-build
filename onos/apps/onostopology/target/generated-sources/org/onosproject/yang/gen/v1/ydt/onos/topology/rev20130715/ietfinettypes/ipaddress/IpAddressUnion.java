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

package org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.ipaddress;

import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.Ipv4Address;
import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.Ipv6Address;
import java.util.Objects;
import java.util.BitSet;

/**
 * Represents the implementation of ipAddressUnion.
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
public final class IpAddressUnion {
    private Ipv4Address ipv4Address;
    private Ipv6Address ipv6Address;
    private BitSet setValue = new BitSet();

    /**
     * Creates an instance of ipAddressUnion.
     */
    private IpAddressUnion() {
    }

    /**
     * Creates an instance of ipv4Address.
     *
     * @param ipv4Address value of ipv4Address
     */
    public IpAddressUnion(Ipv4Address ipv4Address) {
        setValue.set(0);
        this.ipv4Address = ipv4Address;
    }

    /**
     * Creates an instance of ipv6Address.
     *
     * @param ipv6Address value of ipv6Address
     */
    public IpAddressUnion(Ipv6Address ipv6Address) {
        setValue.set(1);
        this.ipv6Address = ipv6Address;
    }

    /**
     * Returns the object of ipAddressUnion for type ipv4Address.
     *
     * @param value value of ipAddressUnion for type ipv4Address
     * @return ipAddressUnion for type ipv4Address
     */
    public static IpAddressUnion of(Ipv4Address value) {
        return new IpAddressUnion(value);
    }

    /**
     * Returns the object of ipAddressUnion for type ipv6Address.
     *
     * @param value value of ipAddressUnion for type ipv6Address
     * @return ipAddressUnion for type ipv6Address
     */
    public static IpAddressUnion of(Ipv6Address value) {
        return new IpAddressUnion(value);
    }

    /**
     * Returns the attribute ipv4Address.
     *
     * @return ipv4Address value of ipv4Address
     */
    public Ipv4Address ipv4Address() {
        return ipv4Address;
    }
    /**
     * Returns the attribute ipv6Address.
     *
     * @return ipv6Address value of ipv6Address
     */
    public Ipv6Address ipv6Address() {
        return ipv6Address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipv4Address, ipv6Address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpAddressUnion) {
            IpAddressUnion other = (IpAddressUnion) obj;
            return
                Objects.equals(ipv4Address, other.ipv4Address) &&
                Objects.equals(ipv6Address, other.ipv6Address);
        }
        return false;
    }

    @Override
    public String toString() {
        if (setValue.get(0)) {
            return ipv4Address.toString();
        }
        if (setValue.get(1)) {
            return ipv6Address.toString();
        }
        return null;
    }
    /**
     * Returns the object of ipAddressUnion fromString input StringipAddressUnion.
     *
     * @param valInString value of input String
     * @return ipAddressUnion
     */
    public static IpAddressUnion fromString(String valInString) {
        try {
            Ipv4Address tmpVal = Ipv4Address.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        try {
            Ipv6Address tmpVal = Ipv6Address.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
