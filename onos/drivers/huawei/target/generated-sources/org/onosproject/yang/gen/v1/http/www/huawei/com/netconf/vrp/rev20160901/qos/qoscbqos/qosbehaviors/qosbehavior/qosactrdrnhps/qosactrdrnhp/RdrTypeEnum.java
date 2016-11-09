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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosbehaviors.qosbehavior
            .qosactrdrnhps.qosactrdrnhp;

/**
 * Represents ENUM data of rdrTypeEnum.
 */
public enum RdrTypeEnum {

    /**
     * Represents backup.
     */
    BACKUP(0, "backup");

    private int rdrTypeEnum;
    private String schemaName;

    /**
     * Creates an instance of rdrTypeEnum.
     *
     * @param rdrTypeEnum value of rdrTypeEnum
     */
     RdrTypeEnum(int rdrTypeEnum, String schemaName) {
        this.rdrTypeEnum = rdrTypeEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of rdrTypeEnum for.
     *
     * @param value value of rdrTypeEnum for
     * @return rdrTypeEnum for
     */
    public static RdrTypeEnum of(int value) {
        switch (value) {
            case 0:
                return RdrTypeEnum.BACKUP;
            default :
                return null;
        }
    }
    /**
     * Returns the object of rdrTypeEnum for.
     *
     * @param value value of rdrTypeEnum for
     * @return rdrTypeEnum for
     */
    public static RdrTypeEnum of(String value) {
        switch (value) {
            case "backup":
                return RdrTypeEnum.BACKUP;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute rdrTypeEnum.
     *
     * @return rdrTypeEnum value of rdrTypeEnum
     */
    public int rdrTypeEnum() {
        return rdrTypeEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
