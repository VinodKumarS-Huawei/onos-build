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
 * Represents the implementation of ipv4AddressNoZone.
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
public final class Ipv4AddressNoZone {
    private Ipv4Address ipv4Address;

    /**
     * Creates an instance of ipv4AddressNoZone.
     */
    private Ipv4AddressNoZone() {
    }

    /**
     * Creates an instance of ipv4Address.
     *
     * @param ipv4Address value of ipv4Address
     */
    public Ipv4AddressNoZone(Ipv4Address ipv4Address) {
        this.ipv4Address = ipv4Address;
    }

    /**
     * Returns the object of ipv4AddressNoZone for type ipv4Address.
     *
     * @param value value of ipv4AddressNoZone for type ipv4Address
     * @return ipv4AddressNoZone for type ipv4Address
     */
    public static Ipv4AddressNoZone of(Ipv4Address value) {
        return new Ipv4AddressNoZone(value);
    }

    /**
     * Returns the attribute ipv4Address.
     *
     * @return ipv4Address value of ipv4Address
     */
    public Ipv4Address ipv4Address() {
        return ipv4Address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipv4Address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ipv4AddressNoZone) {
            Ipv4AddressNoZone other = (Ipv4AddressNoZone) obj;
            return
                Objects.equals(ipv4Address, other.ipv4Address);
        }
        return false;
    }

    @Override
    public String toString() {
        return ipv4Address.toString();
    }
    /**
     * Returns the object of ipv4AddressNoZone fromString input Stringipv4AddressNoZone.
     *
     * @param valInString value of input String
     * @return ipv4AddressNoZone
     */
    public static Ipv4AddressNoZone fromString(String valInString) {
        try {
            Ipv4Address tmpVal = Ipv4Address.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
