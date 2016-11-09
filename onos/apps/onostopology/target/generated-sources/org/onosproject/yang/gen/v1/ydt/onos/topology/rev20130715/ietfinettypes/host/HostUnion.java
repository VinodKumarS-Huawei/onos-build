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

package org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.host;

import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.DomainName;
import org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.IpAddress;
import java.util.Objects;
import java.util.BitSet;

/**
 * Represents the implementation of hostUnion.
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
public final class HostUnion {
    private IpAddress ipAddress;
    private DomainName domainName;
    private BitSet setValue = new BitSet();

    /**
     * Creates an instance of hostUnion.
     */
    private HostUnion() {
    }

    /**
     * Creates an instance of ipAddress.
     *
     * @param ipAddress value of ipAddress
     */
    public HostUnion(IpAddress ipAddress) {
        setValue.set(0);
        this.ipAddress = ipAddress;
    }

    /**
     * Creates an instance of domainName.
     *
     * @param domainName value of domainName
     */
    public HostUnion(DomainName domainName) {
        setValue.set(1);
        this.domainName = domainName;
    }

    /**
     * Returns the object of hostUnion for type ipAddress.
     *
     * @param value value of hostUnion for type ipAddress
     * @return hostUnion for type ipAddress
     */
    public static HostUnion of(IpAddress value) {
        return new HostUnion(value);
    }

    /**
     * Returns the object of hostUnion for type domainName.
     *
     * @param value value of hostUnion for type domainName
     * @return hostUnion for type domainName
     */
    public static HostUnion of(DomainName value) {
        return new HostUnion(value);
    }

    /**
     * Returns the attribute ipAddress.
     *
     * @return ipAddress value of ipAddress
     */
    public IpAddress ipAddress() {
        return ipAddress;
    }
    /**
     * Returns the attribute domainName.
     *
     * @return domainName value of domainName
     */
    public DomainName domainName() {
        return domainName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipAddress, domainName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostUnion) {
            HostUnion other = (HostUnion) obj;
            return
                Objects.equals(ipAddress, other.ipAddress) &&
                Objects.equals(domainName, other.domainName);
        }
        return false;
    }

    @Override
    public String toString() {
        if (setValue.get(0)) {
            return ipAddress.toString();
        }
        if (setValue.get(1)) {
            return domainName.toString();
        }
        return null;
    }
    /**
     * Returns the object of hostUnion fromString input StringhostUnion.
     *
     * @param valInString value of input String
     * @return hostUnion
     */
    public static HostUnion fromString(String valInString) {
        try {
            IpAddress tmpVal = IpAddress.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        try {
            DomainName tmpVal = DomainName.fromString(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
