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

package org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes;

import java.util.Objects;

/**
 * Represents the implementation of ipv6AddressNoZone.
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
public final class Ipv6AddressNoZone {
    private Ipv6Address ipv6Address;

    /**
     * Creates an instance of ipv6AddressNoZone.
     */
    private Ipv6AddressNoZone() {
    }

    /**
     * Creates an instance of ipv6Address.
     *
     * @param ipv6Address value of ipv6Address
     */
    public Ipv6AddressNoZone(Ipv6Address ipv6Address) {
        this.ipv6Address = ipv6Address;
    }

    /**
     * Returns the object of ipv6AddressNoZone for type ipv6Address.
     *
     * @param value value of ipv6AddressNoZone for type ipv6Address
     * @return ipv6AddressNoZone for type ipv6Address
     */
    public static Ipv6AddressNoZone of(Ipv6Address value) {
        return new Ipv6AddressNoZone(value);
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
        return Objects.hash(ipv6Address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ipv6AddressNoZone) {
            Ipv6AddressNoZone other = (Ipv6AddressNoZone) obj;
            return
                Objects.equals(ipv6Address, other.ipv6Address);
        }
        return false;
    }

    @Override
    public String toString() {
        return ipv6Address.toString();
    }
    /**
     * Returns the object of ipv6AddressNoZone fromString input Stringipv6AddressNoZone.
     *
     * @param valInString value of input String
     * @return ipv6AddressNoZone
     */
    public static Ipv6AddressNoZone fromString(String valInString) {
        try {
            Ipv6Address tmpVal = Ipv6Address.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
