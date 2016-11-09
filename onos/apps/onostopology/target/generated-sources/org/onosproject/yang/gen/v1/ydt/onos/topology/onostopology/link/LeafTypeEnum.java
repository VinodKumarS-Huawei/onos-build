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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.link;

/**
 * Represents ENUM data of leafTypeEnum.
 */
public enum LeafTypeEnum {

    /**
     * Represents direct.
     */
    DIRECT(0, "direct"),

    /**
     * Represents indirect.
     */
    INDIRECT(1, "indirect"),

    /**
     * Represents edge.
     */
    EDGE(2, "edge"),

    /**
     * Represents tunnel.
     */
    TUNNEL(3, "tunnel"),

    /**
     * Represents optical.
     */
    OPTICAL(4, "optical"),

    /**
     * Represents virtual.
     */
    VIRTUAL(5, "virtual");

    private int leafTypeEnum;
    private String schemaName;

    /**
     * Creates an instance of leafTypeEnum.
     *
     * @param leafTypeEnum value of leafTypeEnum
     */
     LeafTypeEnum(int leafTypeEnum, String schemaName) {
        this.leafTypeEnum = leafTypeEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of leafTypeEnum for.
     *
     * @param value value of leafTypeEnum for
     * @return leafTypeEnum for
     */
    public static LeafTypeEnum of(int value) {
        switch (value) {
            case 0:
                return LeafTypeEnum.DIRECT;
            case 1:
                return LeafTypeEnum.INDIRECT;
            case 2:
                return LeafTypeEnum.EDGE;
            case 3:
                return LeafTypeEnum.TUNNEL;
            case 4:
                return LeafTypeEnum.OPTICAL;
            case 5:
                return LeafTypeEnum.VIRTUAL;
            default :
                return null;
        }
    }
    /**
     * Returns the object of leafTypeEnum for.
     *
     * @param value value of leafTypeEnum for
     * @return leafTypeEnum for
     */
    public static LeafTypeEnum of(String value) {
        switch (value) {
            case "direct":
                return LeafTypeEnum.DIRECT;
            case "indirect":
                return LeafTypeEnum.INDIRECT;
            case "edge":
                return LeafTypeEnum.EDGE;
            case "tunnel":
                return LeafTypeEnum.TUNNEL;
            case "optical":
                return LeafTypeEnum.OPTICAL;
            case "virtual":
                return LeafTypeEnum.VIRTUAL;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute leafTypeEnum.
     *
     * @return leafTypeEnum value of leafTypeEnum
     */
    public int leafTypeEnum() {
        return leafTypeEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
