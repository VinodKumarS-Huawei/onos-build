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
 * Represents ENUM data of layerEnum.
 */
public enum LayerEnum {

    /**
     * Represents none.
     */
    NONE(0, "none");

    private int layerEnum;
    private String schemaName;

    /**
     * Creates an instance of layerEnum.
     *
     * @param layerEnum value of layerEnum
     */
     LayerEnum(int layerEnum, String schemaName) {
        this.layerEnum = layerEnum;
        this.schemaName = schemaName;
    }

    /**
     * Returns the object of layerEnum for.
     *
     * @param value value of layerEnum for
     * @return layerEnum for
     */
    public static LayerEnum of(int value) {
        switch (value) {
            case 0:
                return LayerEnum.NONE;
            default :
                return null;
        }
    }
    /**
     * Returns the object of layerEnum for.
     *
     * @param value value of layerEnum for
     * @return layerEnum for
     */
    public static LayerEnum of(String value) {
        switch (value) {
            case "none":
                return LayerEnum.NONE;
            default :
                return null;
        }
    }
    /**
     * Returns the attribute layerEnum.
     *
     * @return layerEnum value of layerEnum
     */
    public int layerEnum() {
        return layerEnum;
    }


    @Override
    public String toString() {
        return schemaName;
    }
}
