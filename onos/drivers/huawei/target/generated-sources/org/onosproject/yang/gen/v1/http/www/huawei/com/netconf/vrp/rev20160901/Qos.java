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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901;

import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.QosCbQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.QosIfQoss;

/**
 * Abstraction of an entity which represents the functionality of qos.
 */
public interface Qos {
    /**
     * Specify the node specific operation in protocols like NETCONF.
     * Applicable in protocol edit operation, not applicable in query operation
     */
    public static enum OnosYangOpType {
        MERGE,
        REPLACE,
        CREATE,
        DELETE,
        REMOVE,
        NONE
    }

    /**
     * Returns the attribute yangQosOpType.
     *
     * @return yangQosOpType value of yangQosOpType
     */
    OnosYangOpType yangQosOpType();

    /**
     * Returns the attribute qosCbQos.
     *
     * @return qosCbQos value of qosCbQos
     */
    QosCbQos qosCbQos();

    /**
     * Returns the attribute qosIfQoss.
     *
     * @return qosIfQoss value of qosIfQoss
     */
    QosIfQoss qosIfQoss();


    /**
     * Builder for qos.
     */
    interface QosBuilder {
        /**
         * Returns the attribute yangQosOpType.
         *
         * @return yangQosOpType value of yangQosOpType
         */
        OnosYangOpType yangQosOpType();

        /**
         * Returns the attribute qosCbQos.
         *
         * @return qosCbQos value of qosCbQos
         */
        QosCbQos qosCbQos();

        /**
         * Returns the attribute qosIfQoss.
         *
         * @return qosIfQoss value of qosIfQoss
         */
        QosIfQoss qosIfQoss();

        /**
         * Returns the builder object of yangQosOpType.
         *
         * @param yangQosOpType value of yangQosOpType
         * @return yangQosOpType
         */
        QosBuilder yangQosOpType(OnosYangOpType yangQosOpType);

        /**
         * Returns the builder object of qosCbQos.
         *
         * @param qosCbQos value of qosCbQos
         * @return qosCbQos
         */
        QosBuilder qosCbQos(QosCbQos qosCbQos);

        /**
         * Returns the builder object of qosIfQoss.
         *
         * @param qosIfQoss value of qosIfQoss
         * @return qosIfQoss
         */
        QosBuilder qosIfQoss(QosIfQoss qosIfQoss);

        /**
         * Builds object of qos.
         *
         * @return qos
         */
        Qos build();
    }
}
