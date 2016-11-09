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

package org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.ipprefix;

import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.Ipv4Prefix;
import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.Ipv6Prefix;
import java.util.Objects;
import java.util.BitSet;

/**
 * Represents the implementation of ipPrefixUnion.
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
public final class IpPrefixUnion {
    private Ipv4Prefix ipv4Prefix;
    private Ipv6Prefix ipv6Prefix;
    private BitSet setValue = new BitSet();

    /**
     * Creates an instance of ipPrefixUnion.
     */
    private IpPrefixUnion() {
    }

    /**
     * Creates an instance of ipv4Prefix.
     *
     * @param ipv4Prefix value of ipv4Prefix
     */
    public IpPrefixUnion(Ipv4Prefix ipv4Prefix) {
        setValue.set(0);
        this.ipv4Prefix = ipv4Prefix;
    }

    /**
     * Creates an instance of ipv6Prefix.
     *
     * @param ipv6Prefix value of ipv6Prefix
     */
    public IpPrefixUnion(Ipv6Prefix ipv6Prefix) {
        setValue.set(1);
        this.ipv6Prefix = ipv6Prefix;
    }

    /**
     * Returns the object of ipPrefixUnion for type ipv4Prefix.
     *
     * @param value value of ipPrefixUnion for type ipv4Prefix
     * @return ipPrefixUnion for type ipv4Prefix
     */
    public static IpPrefixUnion of(Ipv4Prefix value) {
        return new IpPrefixUnion(value);
    }

    /**
     * Returns the object of ipPrefixUnion for type ipv6Prefix.
     *
     * @param value value of ipPrefixUnion for type ipv6Prefix
     * @return ipPrefixUnion for type ipv6Prefix
     */
    public static IpPrefixUnion of(Ipv6Prefix value) {
        return new IpPrefixUnion(value);
    }

    /**
     * Returns the attribute ipv4Prefix.
     *
     * @return ipv4Prefix value of ipv4Prefix
     */
    public Ipv4Prefix ipv4Prefix() {
        return ipv4Prefix;
    }
    /**
     * Returns the attribute ipv6Prefix.
     *
     * @return ipv6Prefix value of ipv6Prefix
     */
    public Ipv6Prefix ipv6Prefix() {
        return ipv6Prefix;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipv4Prefix, ipv6Prefix);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpPrefixUnion) {
            IpPrefixUnion other = (IpPrefixUnion) obj;
            return
                Objects.equals(ipv4Prefix, other.ipv4Prefix) &&
                Objects.equals(ipv6Prefix, other.ipv6Prefix);
        }
        return false;
    }

    @Override
    public String toString() {
        if (setValue.get(0)) {
            return ipv4Prefix.toString();
        }
        if (setValue.get(1)) {
            return ipv6Prefix.toString();
        }
        return null;
    }
    /**
     * Returns the object of ipPrefixUnion fromString input StringipPrefixUnion.
     *
     * @param valInString value of input String
     * @return ipPrefixUnion
     */
    public static IpPrefixUnion fromString(String valInString) {
        try {
            Ipv4Prefix tmpVal = Ipv4Prefix.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        try {
            Ipv6Prefix tmpVal = Ipv6Prefix.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
