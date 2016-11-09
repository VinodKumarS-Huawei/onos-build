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
            .qospolicyapplys;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys
            .qospolicyapply.DirectionEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qosifqoss.qosifqos.qospolicyapplys
            .qospolicyapply.LayerEnum;

/**
 * Abstraction of an entity which represents the functionality of qosPolicyApply.
 */
public interface QosPolicyApply {

    /**
     * Identify the leaf of QosPolicyApply.
     */
    public enum LeafIdentifier {
        /**
         * Represents direction.
         */
        DIRECTION(1),
        /**
         * Represents layer.
         */
        LAYER(2),
        /**
         * Represents policyName.
         */
        POLICYNAME(3),
        /**
         * Represents vlanMode.
         */
        VLANMODE(4),
        /**
         * Represents groupId.
         */
        GROUPID(5);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute direction.
     *
     * @return direction value of direction
     */
    DirectionEnum direction();

    /**
     * Returns the attribute layer.
     *
     * @return layer value of layer
     */
    LayerEnum layer();

    /**
     * Returns the attribute policyName.
     *
     * @return policyName value of policyName
     */
    String policyName();

    /**
     * Returns the attribute vlanMode.
     *
     * @return vlanMode value of vlanMode
     */
    boolean vlanMode();

    /**
     * Returns the attribute groupId.
     *
     * @return groupId value of groupId
     */
    long groupId();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangQosPolicyApplyOpType.
     *
     * @return yangQosPolicyApplyOpType value of yangQosPolicyApplyOpType
     */
    OnosYangOpType yangQosPolicyApplyOpType();

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
     * Builder for qosPolicyApply.
     */
    interface QosPolicyApplyBuilder {
        /**
         * Returns the attribute direction.
         *
         * @return direction value of direction
         */
        DirectionEnum direction();

        /**
         * Returns the attribute layer.
         *
         * @return layer value of layer
         */
        LayerEnum layer();

        /**
         * Returns the attribute policyName.
         *
         * @return policyName value of policyName
         */
        String policyName();

        /**
         * Returns the attribute vlanMode.
         *
         * @return vlanMode value of vlanMode
         */
        boolean vlanMode();

        /**
         * Returns the attribute groupId.
         *
         * @return groupId value of groupId
         */
        long groupId();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangQosPolicyApplyOpType.
         *
         * @return yangQosPolicyApplyOpType value of yangQosPolicyApplyOpType
         */
        OnosYangOpType yangQosPolicyApplyOpType();

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
         * Returns the builder object of direction.
         *
         * @param direction value of direction
         * @return direction
         */
        QosPolicyApplyBuilder direction(DirectionEnum direction);

        /**
         * Returns the builder object of layer.
         *
         * @param layer value of layer
         * @return layer
         */
        QosPolicyApplyBuilder layer(LayerEnum layer);

        /**
         * Returns the builder object of policyName.
         *
         * @param policyName value of policyName
         * @return policyName
         */
        QosPolicyApplyBuilder policyName(String policyName);

        /**
         * Returns the builder object of vlanMode.
         *
         * @param vlanMode value of vlanMode
         * @return vlanMode
         */
        QosPolicyApplyBuilder vlanMode(boolean vlanMode);

        /**
         * Returns the builder object of groupId.
         *
         * @param groupId value of groupId
         * @return groupId
         */
        QosPolicyApplyBuilder groupId(long groupId);

        /**
         * Returns the builder object of yangQosPolicyApplyOpType.
         *
         * @param yangQosPolicyApplyOpType value of yangQosPolicyApplyOpType
         * @return yangQosPolicyApplyOpType
         */
        QosPolicyApplyBuilder yangQosPolicyApplyOpType(OnosYangOpType yangQosPolicyApplyOpType);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosPolicyApplyBuilder addYangAugmentedInfo(Object value, Class classObject);

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
        QosPolicyApplyBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of qosPolicyApply.
         *
         * @return qosPolicyApply
         */
        QosPolicyApply build();
    }
}
