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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos
            .QosPolicyApplys;

/**
 * Abstraction of an entity which represents the functionality of qosIfQos.
 */
public interface QosIfQos {

    /**
     * Identify the leaf of QosIfQos.
     */
    public enum LeafIdentifier {
        /**
         * Represents ifName.
         */
        IFNAME(1);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute ifName.
     *
     * @return ifName value of ifName
     */
    String ifName();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangQosIfQosOpType.
     *
     * @return yangQosIfQosOpType value of yangQosIfQosOpType
     */
    OnosYangOpType yangQosIfQosOpType();

    /**
     * Returns the attribute selectLeafFlags.
     *
     * @return selectLeafFlags value of selectLeafFlags
     */
    BitSet selectLeafFlags();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute qosPolicyApplys.
     *
     * @return qosPolicyApplys value of qosPolicyApplys
     */
    QosPolicyApplys qosPolicyApplys();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Checks if the leaf value is set.
     *
     * @param leaf leaf whose value status needs to checked
     * @return result of leaf value set in object
     */
    boolean isLeafValueSet(LeafIdentifier leaf);

    /**
     * Checks if the leaf is set to be a selected leaf.
     *
     * @param leaf if leaf needs to be selected
     * @return result of leaf value set in object
     */
    boolean isSelectLeaf(LeafIdentifier leaf);

    /**
     * Builder for qosIfQos.
     */
    interface QosIfQosBuilder {
        /**
         * Returns the attribute ifName.
         *
         * @return ifName value of ifName
         */
        String ifName();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangQosIfQosOpType.
         *
         * @return yangQosIfQosOpType value of yangQosIfQosOpType
         */
        OnosYangOpType yangQosIfQosOpType();

        /**
         * Returns the attribute selectLeafFlags.
         *
         * @return selectLeafFlags value of selectLeafFlags
         */
        BitSet selectLeafFlags();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute qosPolicyApplys.
         *
         * @return qosPolicyApplys value of qosPolicyApplys
         */
        QosPolicyApplys qosPolicyApplys();

        /**
         * Returns the builder object of ifName.
         *
         * @param ifName value of ifName
         * @return ifName
         */
        QosIfQosBuilder ifName(String ifName);

        /**
         * Returns the builder object of yangQosIfQosOpType.
         *
         * @param yangQosIfQosOpType value of yangQosIfQosOpType
         * @return yangQosIfQosOpType
         */
        QosIfQosBuilder yangQosIfQosOpType(OnosYangOpType yangQosIfQosOpType);

        /**
         * Returns the builder object of qosPolicyApplys.
         *
         * @param qosPolicyApplys value of qosPolicyApplys
         * @return qosPolicyApplys
         */
        QosIfQosBuilder qosPolicyApplys(QosPolicyApplys qosPolicyApplys);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosIfQosBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Set a leaf to be selected.
         *
         * @param leaf leaf needs to be selected
         * @return builder object for select leaf
         */
        QosIfQosBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of qosIfQos.
         *
         * @return qosIfQos
         */
        QosIfQos build();
    }
}
