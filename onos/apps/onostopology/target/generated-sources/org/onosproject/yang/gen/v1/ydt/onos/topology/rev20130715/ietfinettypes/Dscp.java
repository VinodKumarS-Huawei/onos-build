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
 * Represents the implementation of dscp.
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
public final class Dscp {
    private short uint8;

    /**
     * Creates an instance of dscp.
     */
    private Dscp() {
    }

    /**
     * Creates an instance of uint8.
     *
     * @param uint8 value of uint8
     */
    public Dscp(short uint8) {
        this.uint8 = uint8;
    }

    /**
     * Returns the object of dscp for type uint8.
     *
     * @param value value of dscp for type uint8
     * @return dscp for type uint8
     */
    public static Dscp of(short value) {
        return new Dscp(value);
    }

    /**
     * Returns the attribute uint8.
     *
     * @return uint8 value of uint8
     */
    public short uint8() {
        return uint8;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uint8);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Dscp) {
            Dscp other = (Dscp) obj;
            return
                Objects.equals(uint8, other.uint8);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(uint8);
    }
    /**
     * Returns the object of dscp fromString input Stringdscp.
     *
     * @param valInString value of input String
     * @return dscp
     */
    public static Dscp fromString(String valInString) {
        try {
            short tmpVal = Short.parseShort(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
