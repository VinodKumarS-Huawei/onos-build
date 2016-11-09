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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device;

/**
 * Represents ENUM data of typeEnum.
 */
public enum TypeEnum {

    /**
     * Represents switch.
     */
    SWITCH(0, "switch"),

    /**
     * Represents router.
     */
    ROUTER(1, "router"),

    /**
     * Represents roadm.
     */
    ROADM(2, "roadm"),

    /**
     * Represents otn.
     */
    OTN(3, "otn"),

    /**
     * Represents roadm_otn.
     */
    ROADM_OTN(4, "roadm_otn"),

    /**
     * Represents firewall.
     */
    FIREWALL(5, "firewall"),

    /**
     * Represents balancer.
     */
    BALANCER(6, "balancer"),

    /**
     * Represents ips.
     */
    IPS(7, "ips"),

    /**
     * Represents ids.
     */
    IDS(8, "ids"),

    /**
     * Represents controller.
     */
    CONTROLLER(9, "controller"),

    /**
     * Represents virtual.
     */
    VIRTUAL(10, "virtual"),

    /**
     * Represents fiber_switch.
     */
    FIBER_SWITCH(11, "fiber_switch"),

    /**
     * Represents microwave.
     */
    MICROWAVE(12, "microwave"),

    /**
     * Represents olt.
     */
    OLT(13, "olt"),

    /**
     * Represents onu.
     */
    ONU(14, "onu"),

    /**
     * Represents other.
     */
    OTHER(15, "other");

    private int typeEnum;
    private String schemaName;

    /**
     * Creates an instance of typeEnum.
     *
     * @param typeEnum value of typeEnum
     */
     TypeEnum(int typeEnum, String schemaName) {
        this.typeEnum = typeEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of typeEnum for.
     *
     * @param value value of typeEnum for
     * @return typeEnum for
     */
    public static TypeEnum of(int value) {
        switch (value) {
            case 0:
                return TypeEnum.SWITCH;
            case 1:
                return TypeEnum.ROUTER;
            case 2:
                return TypeEnum.ROADM;
            case 3:
                return TypeEnum.OTN;
            case 4:
                return TypeEnum.ROADM_OTN;
            case 5:
                return TypeEnum.FIREWALL;
            case 6:
                return TypeEnum.BALANCER;
            case 7:
                return TypeEnum.IPS;
            case 8:
                return TypeEnum.IDS;
            case 9:
                return TypeEnum.CONTROLLER;
            case 10:
                return TypeEnum.VIRTUAL;
            case 11:
                return TypeEnum.FIBER_SWITCH;
            case 12:
                return TypeEnum.MICROWAVE;
            case 13:
                return TypeEnum.OLT;
            case 14:
                return TypeEnum.ONU;
            case 15:
                return TypeEnum.OTHER;
            default :
                return null;
        }
    }
    /**
     * Returns the object of typeEnum for.
     *
     * @param value value of typeEnum for
     * @return typeEnum for
     */
    public static TypeEnum of(String value) {
        switch (value) {
            case "switch":
                return TypeEnum.SWITCH;
            case "router":
                return TypeEnum.ROUTER;
            case "roadm":
                return TypeEnum.ROADM;
            case "otn":
                return TypeEnum.OTN;
            case "roadm_otn":
                return TypeEnum.ROADM_OTN;
            case "firewall":
                return TypeEnum.FIREWALL;
            case "balancer":
                return TypeEnum.BALANCER;
            case "ips":
                return TypeEnum.IPS;
            case "ids":
                return TypeEnum.IDS;
            case "controller":
                return TypeEnum.CONTROLLER;
            case "virtual":
                return TypeEnum.VIRTUAL;
            case "fiber_switch":
                return TypeEnum.FIBER_SWITCH;
            case "microwave":
                return TypeEnum.MICROWAVE;
            case "olt":
                return TypeEnum.OLT;
            case "onu":
                return TypeEnum.ONU;
            case "other":
                return TypeEnum.OTHER;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute typeEnum.
     *
     * @return typeEnum value of typeEnum
     */
    public int typeEnum() {
        return typeEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
