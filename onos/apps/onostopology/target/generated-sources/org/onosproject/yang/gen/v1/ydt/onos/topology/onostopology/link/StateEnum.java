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
 * Represents ENUM data of stateEnum.
 */
public enum StateEnum {

    /**
     * Represents active.
     */
    ACTIVE(0, "active"),

    /**
     * Represents inactive.
     */
    INACTIVE(1, "inactive");

    private int stateEnum;
    private String schemaName;

    /**
     * Creates an instance of stateEnum.
     *
     * @param stateEnum value of stateEnum
     */
     StateEnum(int stateEnum, String schemaName) {
        this.stateEnum = stateEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of stateEnum for.
     *
     * @param value value of stateEnum for
     * @return stateEnum for
     */
    public static StateEnum of(int value) {
        switch (value) {
            case 0:
                return StateEnum.ACTIVE;
            case 1:
                return StateEnum.INACTIVE;
            default :
                return null;
        }
    }
    /**
     * Returns the object of stateEnum for.
     *
     * @param value value of stateEnum for
     * @return stateEnum for
     */
    public static StateEnum of(String value) {
        switch (value) {
            case "active":
                return StateEnum.ACTIVE;
            case "inactive":
                return StateEnum.INACTIVE;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute stateEnum.
     *
     * @return stateEnum value of stateEnum
     */
    public int stateEnum() {
        return stateEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
