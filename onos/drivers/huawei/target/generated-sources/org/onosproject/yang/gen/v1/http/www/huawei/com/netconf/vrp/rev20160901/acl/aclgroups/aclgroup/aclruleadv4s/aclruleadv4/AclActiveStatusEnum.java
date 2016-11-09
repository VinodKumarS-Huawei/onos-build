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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .aclruleadv4;

/**
 * Represents ENUM data of aclActiveStatusEnum.
 */
public enum AclActiveStatusEnum {

    /**
     * Represents active.
     */
    ACTIVE(0, "active"),

    /**
     * Represents notInService.
     */
    NOTINSERVICE(1, "notInService"),

    /**
     * Represents notReady.
     */
    NOTREADY(2, "notReady");

    private int aclActiveStatusEnum;
    private String schemaName;

    /**
     * Creates an instance of aclActiveStatusEnum.
     *
     * @param aclActiveStatusEnum value of aclActiveStatusEnum
     */
     AclActiveStatusEnum(int aclActiveStatusEnum, String schemaName) {
        this.aclActiveStatusEnum = aclActiveStatusEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of aclActiveStatusEnum for.
     *
     * @param value value of aclActiveStatusEnum for
     * @return aclActiveStatusEnum for
     */
    public static AclActiveStatusEnum of(int value) {
        switch (value) {
            case 0:
                return AclActiveStatusEnum.ACTIVE;
            case 1:
                return AclActiveStatusEnum.NOTINSERVICE;
            case 2:
                return AclActiveStatusEnum.NOTREADY;
            default :
                return null;
        }
    }
    /**
     * Returns the object of aclActiveStatusEnum for.
     *
     * @param value value of aclActiveStatusEnum for
     * @return aclActiveStatusEnum for
     */
    public static AclActiveStatusEnum of(String value) {
        switch (value) {
            case "active":
                return AclActiveStatusEnum.ACTIVE;
            case "notInService":
                return AclActiveStatusEnum.NOTINSERVICE;
            case "notReady":
                return AclActiveStatusEnum.NOTREADY;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute aclActiveStatusEnum.
     *
     * @return aclActiveStatusEnum value of aclActiveStatusEnum
     */
    public int aclActiveStatusEnum() {
        return aclActiveStatusEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
