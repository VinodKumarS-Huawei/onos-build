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

import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.ipprefix.IpPrefixUnion;
import java.util.Objects;

/**
 * Represents the implementation of ipPrefix.
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
public final class IpPrefix {
    private IpPrefixUnion union;

    /**
     * Creates an instance of ipPrefix.
     */
    private IpPrefix() {
    }

    /**
     * Creates an instance of union.
     *
     * @param union value of union
     */
    public IpPrefix(IpPrefixUnion union) {
        this.union = union;
    }

    /**
     * Returns the object of ipPrefix for type union.
     *
     * @param value value of ipPrefix for type union
     * @return ipPrefix for type union
     */
    public static IpPrefix of(IpPrefixUnion value) {
        return new IpPrefix(value);
    }

    /**
     * Returns the attribute union.
     *
     * @return union value of union
     */
    public IpPrefixUnion union() {
        return union;
    }

    @Override
    public int hashCode() {
        return Objects.hash(union);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpPrefix) {
            IpPrefix other = (IpPrefix) obj;
            return
                Objects.equals(union, other.union);
        }
        return false;
    }

    @Override
    public String toString() {
        return union.toString();
    }
    /**
     * Returns the object of ipPrefix fromString input StringipPrefix.
     *
     * @param valInString value of input String
     * @return ipPrefix
     */
    public static IpPrefix fromString(String valInString) {
        try {
            IpPrefixUnion tmpVal = IpPrefixUnion.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
