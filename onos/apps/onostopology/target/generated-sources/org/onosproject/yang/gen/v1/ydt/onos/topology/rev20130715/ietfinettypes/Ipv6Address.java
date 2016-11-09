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
 * Represents the implementation of ipv6Address.
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
public final class Ipv6Address {
    private String string;

    /**
     * Creates an instance of ipv6Address.
     */
    private Ipv6Address() {
    }

    /**
     * Creates an instance of string.
     *
     * @param string value of string
     */
    public Ipv6Address(String string) {
        this.string = string;
    }

    /**
     * Returns the object of ipv6Address for type string.
     *
     * @param value value of ipv6Address for type string
     * @return ipv6Address for type string
     */
    public static Ipv6Address of(String value) {
        return new Ipv6Address(value);
    }

    /**
     * Returns the attribute string.
     *
     * @return string value of string
     */
    public String string() {
        return string;
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ipv6Address) {
            Ipv6Address other = (Ipv6Address) obj;
            return
                Objects.equals(string, other.string);
        }
        return false;
    }

    @Override
    public String toString() {
        return string;
    }
    /**
     * Returns the object of ipv6Address fromString input Stringipv6Address.
     *
     * @param valInString value of input String
     * @return ipv6Address
     */
    public static Ipv6Address fromString(String valInString) {
        try {
            String tmpVal = (valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
