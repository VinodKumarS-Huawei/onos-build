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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.port;

/**
 * Represents ENUM data of portTypeEnum.
 */
public enum PortTypeEnum {

    /**
     * Represents copper.
     */
    COPPER(0, "copper"),

    /**
     * Represents fiber.
     */
    FIBER(1, "fiber"),

    /**
     * Represents packet.
     */
    PACKET(2, "packet"),

    /**
     * Represents oduclt.
     */
    ODUCLT(3, "oduclt"),

    /**
     * Represents och.
     */
    OCH(4, "och"),

    /**
     * Represents oms.
     */
    OMS(5, "oms"),

    /**
     * Represents virtual.
     */
    VIRTUAL(6, "virtual"),

    /**
     * Represents otu.
     */
    OTU(7, "otu");

    private int portTypeEnum;
    private String schemaName;

    /**
     * Creates an instance of portTypeEnum.
     *
     * @param portTypeEnum value of portTypeEnum
     */
     PortTypeEnum(int portTypeEnum, String schemaName) {
        this.portTypeEnum = portTypeEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of portTypeEnum for.
     *
     * @param value value of portTypeEnum for
     * @return portTypeEnum for
     */
    public static PortTypeEnum of(int value) {
        switch (value) {
            case 0:
                return PortTypeEnum.COPPER;
            case 1:
                return PortTypeEnum.FIBER;
            case 2:
                return PortTypeEnum.PACKET;
            case 3:
                return PortTypeEnum.ODUCLT;
            case 4:
                return PortTypeEnum.OCH;
            case 5:
                return PortTypeEnum.OMS;
            case 6:
                return PortTypeEnum.VIRTUAL;
            case 7:
                return PortTypeEnum.OTU;
            default :
                return null;
        }
    }
    /**
     * Returns the object of portTypeEnum for.
     *
     * @param value value of portTypeEnum for
     * @return portTypeEnum for
     */
    public static PortTypeEnum of(String value) {
        switch (value) {
            case "copper":
                return PortTypeEnum.COPPER;
            case "fiber":
                return PortTypeEnum.FIBER;
            case "packet":
                return PortTypeEnum.PACKET;
            case "oduclt":
                return PortTypeEnum.ODUCLT;
            case "och":
                return PortTypeEnum.OCH;
            case "oms":
                return PortTypeEnum.OMS;
            case "virtual":
                return PortTypeEnum.VIRTUAL;
            case "otu":
                return PortTypeEnum.OTU;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute portTypeEnum.
     *
     * @return portTypeEnum value of portTypeEnum
     */
    public int portTypeEnum() {
        return portTypeEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
