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

package org.onosproject.yang.gen.v1.ydt.onos.topology.rev20130715.ietfinettypes.ipversion;

/**
 * Represents ENUM data of ipVersionEnum.
 */
public enum IpVersionEnum {

    /**
     * Represents unknown.
     */
    UNKNOWN(0, "unknown"),

    /**
     * Represents ipv4.
     */
    IPV4(1, "ipv4"),

    /**
     * Represents ipv6.
     */
    IPV6(2, "ipv6");

    private int ipVersionEnum;
    private String schemaName;

    /**
     * Creates an instance of ipVersionEnum.
     *
     * @param ipVersionEnum value of ipVersionEnum
     */
     IpVersionEnum(int ipVersionEnum, String schemaName) {
        this.ipVersionEnum = ipVersionEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of ipVersionEnum for.
     *
     * @param value value of ipVersionEnum for
     * @return ipVersionEnum for
     */
    public static IpVersionEnum of(int value) {
        switch (value) {
            case 0:
                return IpVersionEnum.UNKNOWN;
            case 1:
                return IpVersionEnum.IPV4;
            case 2:
                return IpVersionEnum.IPV6;
            default :
                return null;
        }
    }
    /**
     * Returns the object of ipVersionEnum for.
     *
     * @param value value of ipVersionEnum for
     * @return ipVersionEnum for
     */
    public static IpVersionEnum of(String value) {
        switch (value) {
            case "unknown":
                return IpVersionEnum.UNKNOWN;
            case "ipv4":
                return IpVersionEnum.IPV4;
            case "ipv6":
                return IpVersionEnum.IPV6;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute ipVersionEnum.
     *
     * @return ipVersionEnum value of ipVersionEnum
     */
    public int ipVersionEnum() {
        return ipVersionEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
