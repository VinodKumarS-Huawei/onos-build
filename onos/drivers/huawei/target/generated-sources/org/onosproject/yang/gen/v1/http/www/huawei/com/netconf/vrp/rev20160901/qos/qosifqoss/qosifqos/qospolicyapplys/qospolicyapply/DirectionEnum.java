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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos
            .qospolicyapplys.qospolicyapply;

/**
 * Represents ENUM data of directionEnum.
 */
public enum DirectionEnum {

    /**
     * Represents inbound.
     */
    INBOUND(0, "inbound"),

    /**
     * Represents outbound.
     */
    OUTBOUND(1, "outbound");

    private int directionEnum;
    private String schemaName;

    /**
     * Creates an instance of directionEnum.
     *
     * @param directionEnum value of directionEnum
     */
     DirectionEnum(int directionEnum, String schemaName) {
        this.directionEnum = directionEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of directionEnum for.
     *
     * @param value value of directionEnum for
     * @return directionEnum for
     */
    public static DirectionEnum of(int value) {
        switch (value) {
            case 0:
                return DirectionEnum.INBOUND;
            case 1:
                return DirectionEnum.OUTBOUND;
            default :
                return null;
        }
    }
    /**
     * Returns the object of directionEnum for.
     *
     * @param value value of directionEnum for
     * @return directionEnum for
     */
    public static DirectionEnum of(String value) {
        switch (value) {
            case "inbound":
                return DirectionEnum.INBOUND;
            case "outbound":
                return DirectionEnum.OUTBOUND;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute directionEnum.
     *
     * @return directionEnum value of directionEnum
     */
    public int directionEnum() {
        return directionEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
