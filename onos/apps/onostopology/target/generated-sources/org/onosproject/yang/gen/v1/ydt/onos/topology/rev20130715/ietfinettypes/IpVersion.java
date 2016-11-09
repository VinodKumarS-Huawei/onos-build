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

import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.ipversion.IpVersionEnum;
import java.util.Objects;

/**
 * Represents the implementation of ipVersion.
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
public final class IpVersion {
    private IpVersionEnum enumeration;

    /**
     * Creates an instance of ipVersion.
     */
    private IpVersion() {
    }

    /**
     * Creates an instance of enumeration.
     *
     * @param enumeration value of enumeration
     */
    public IpVersion(IpVersionEnum enumeration) {
        this.enumeration = enumeration;
    }

    /**
     * Returns the object of ipVersion for type enumeration.
     *
     * @param value value of ipVersion for type enumeration
     * @return ipVersion for type enumeration
     */
    public static IpVersion of(IpVersionEnum value) {
        return new IpVersion(value);
    }

    /**
     * Returns the attribute enumeration.
     *
     * @return enumeration value of enumeration
     */
    public IpVersionEnum enumeration() {
        return enumeration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enumeration);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IpVersion) {
            IpVersion other = (IpVersion) obj;
            return
                Objects.equals(enumeration, other.enumeration);
        }
        return false;
    }

    @Override
    public String toString() {
        return enumeration.toString();
    }
    /**
     * Returns the object of ipVersion fromString input StringipVersion.
     *
     * @param valInString value of input String
     * @return ipVersion
     */
    public static IpVersion fromString(String valInString) {
        try {
            IpVersionEnum tmpVal = IpVersionEnum.of(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
