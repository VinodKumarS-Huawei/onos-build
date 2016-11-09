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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier;

/**
 * Represents ENUM data of operatorEnum.
 */
public enum OperatorEnum {

    /**
     * Represents and.
     */
    AND(0, "and"),

    /**
     * Represents or.
     */
    OR(1, "or");

    private int operatorEnum;
    private String schemaName;

    /**
     * Creates an instance of operatorEnum.
     *
     * @param operatorEnum value of operatorEnum
     */
     OperatorEnum(int operatorEnum, String schemaName) {
        this.operatorEnum = operatorEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of operatorEnum for.
     *
     * @param value value of operatorEnum for
     * @return operatorEnum for
     */
    public static OperatorEnum of(int value) {
        switch (value) {
            case 0:
                return OperatorEnum.AND;
            case 1:
                return OperatorEnum.OR;
            default :
                return null;
        }
    }
    /**
     * Returns the object of operatorEnum for.
     *
     * @param value value of operatorEnum for
     * @return operatorEnum for
     */
    public static OperatorEnum of(String value) {
        switch (value) {
            case "and":
                return OperatorEnum.AND;
            case "or":
                return OperatorEnum.OR;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute operatorEnum.
     *
     * @return operatorEnum value of operatorEnum
     */
    public int operatorEnum() {
        return operatorEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
