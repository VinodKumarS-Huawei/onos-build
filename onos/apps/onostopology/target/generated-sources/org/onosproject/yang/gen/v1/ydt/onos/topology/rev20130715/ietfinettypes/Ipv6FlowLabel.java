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
 * Represents the implementation of ipv6FlowLabel.
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
public final class Ipv6FlowLabel {
    private long uint32;

    /**
     * Creates an instance of ipv6FlowLabel.
     */
    private Ipv6FlowLabel() {
    }

    /**
     * Creates an instance of uint32.
     *
     * @param uint32 value of uint32
     */
    public Ipv6FlowLabel(long uint32) {
        this.uint32 = uint32;
    }

    /**
     * Returns the object of ipv6FlowLabel for type uint32.
     *
     * @param value value of ipv6FlowLabel for type uint32
     * @return ipv6FlowLabel for type uint32
     */
    public static Ipv6FlowLabel of(long value) {
        return new Ipv6FlowLabel(value);
    }

    /**
     * Returns the attribute uint32.
     *
     * @return uint32 value of uint32
     */
    public long uint32() {
        return uint32;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uint32);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ipv6FlowLabel) {
            Ipv6FlowLabel other = (Ipv6FlowLabel) obj;
            return
                Objects.equals(uint32, other.uint32);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(uint32);
    }
    /**
     * Returns the object of ipv6FlowLabel fromString input Stringipv6FlowLabel.
     *
     * @param valInString value of input String
     * @return ipv6FlowLabel
     */
    public static Ipv6FlowLabel fromString(String valInString) {
        try {
            long tmpVal = Long.parseLong(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
