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
 * Represents ENUM data of aclActionEnum.
 */
public enum AclActionEnum {

    /**
     * Represents permit.
     */
    PERMIT(0, "permit"),

    /**
     * Represents deny.
     */
    DENY(1, "deny");

    private int aclActionEnum;
    private String schemaName;

    /**
     * Creates an instance of aclActionEnum.
     *
     * @param aclActionEnum value of aclActionEnum
     */
     AclActionEnum(int aclActionEnum, String schemaName) {
        this.aclActionEnum = aclActionEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of aclActionEnum for.
     *
     * @param value value of aclActionEnum for
     * @return aclActionEnum for
     */
    public static AclActionEnum of(int value) {
        switch (value) {
            case 0:
                return AclActionEnum.PERMIT;
            case 1:
                return AclActionEnum.DENY;
            default :
                return null;
        }
    }
    /**
     * Returns the object of aclActionEnum for.
     *
     * @param value value of aclActionEnum for
     * @return aclActionEnum for
     */
    public static AclActionEnum of(String value) {
        switch (value) {
            case "permit":
                return AclActionEnum.PERMIT;
            case "deny":
                return AclActionEnum.DENY;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute aclActionEnum.
     *
     * @return aclActionEnum value of aclActionEnum
     */
    public int aclActionEnum() {
        return aclActionEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
