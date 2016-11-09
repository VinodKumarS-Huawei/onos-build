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
 * Represents the implementation of portNumber.
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
public final class PortNumber {
    private int uint16;

    /**
     * Creates an instance of portNumber.
     */
    private PortNumber() {
    }

    /**
     * Creates an instance of uint16.
     *
     * @param uint16 value of uint16
     */
    public PortNumber(int uint16) {
        this.uint16 = uint16;
    }

    /**
     * Returns the object of portNumber for type uint16.
     *
     * @param value value of portNumber for type uint16
     * @return portNumber for type uint16
     */
    public static PortNumber of(int value) {
        return new PortNumber(value);
    }

    /**
     * Returns the attribute uint16.
     *
     * @return uint16 value of uint16
     */
    public int uint16() {
        return uint16;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uint16);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PortNumber) {
            PortNumber other = (PortNumber) obj;
            return
                Objects.equals(uint16, other.uint16);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(uint16);
    }
    /**
     * Returns the object of portNumber fromString input StringportNumber.
     *
     * @param valInString value of input String
     * @return portNumber
     */
    public static PortNumber fromString(String valInString) {
        try {
            int tmpVal = Integer.parseInt(valInString);
            return of(tmpVal);
        } catch (Exception e) {
        }
        return null;
    }
}
