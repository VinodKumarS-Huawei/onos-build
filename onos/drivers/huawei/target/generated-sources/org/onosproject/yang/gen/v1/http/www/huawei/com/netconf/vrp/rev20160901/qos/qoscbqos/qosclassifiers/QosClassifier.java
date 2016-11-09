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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers;

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.OperatorEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.QosRuleAcls;

/**
 * Abstraction of an entity which represents the functionality of qosClassifier.
 */
public interface QosClassifier {

    /**
     * Identify the leaf of QosClassifier.
     */
    public enum LeafIdentifier {
        /**
         * Represents classifierName.
         */
        CLASSIFIERNAME(1),
        /**
         * Represents classifierId.
         */
        CLASSIFIERID(2),
        /**
         * Represents operator.
         */
        OPERATOR(3);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute classifierName.
     *
     * @return classifierName value of classifierName
     */
    String classifierName();

    /**
     * Returns the attribute classifierId.
     *
     * @return classifierId value of classifierId
     */
    long classifierId();

    /**
     * Returns the attribute operator.
     *
     * @return operator value of operator
     */
    OperatorEnum operator();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangQosClassifierOpType.
     *
     * @return yangQosClassifierOpType value of yangQosClassifierOpType
     */
    OnosYangOpType yangQosClassifierOpType();

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
     * Returns the attribute qosRuleAcls.
     *
     * @return qosRuleAcls value of qosRuleAcls
     */
    QosRuleAcls qosRuleAcls();


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
     * Builder for qosClassifier.
     */
    interface QosClassifierBuilder {
        /**
         * Returns the attribute classifierName.
         *
         * @return classifierName value of classifierName
         */
        String classifierName();

        /**
         * Returns the attribute classifierId.
         *
         * @return classifierId value of classifierId
         */
        long classifierId();

        /**
         * Returns the attribute operator.
         *
         * @return operator value of operator
         */
        OperatorEnum operator();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangQosClassifierOpType.
         *
         * @return yangQosClassifierOpType value of yangQosClassifierOpType
         */
        OnosYangOpType yangQosClassifierOpType();

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
         * Returns the attribute qosRuleAcls.
         *
         * @return qosRuleAcls value of qosRuleAcls
         */
        QosRuleAcls qosRuleAcls();

        /**
         * Returns the builder object of classifierName.
         *
         * @param classifierName value of classifierName
         * @return classifierName
         */
        QosClassifierBuilder classifierName(String classifierName);

        /**
         * Returns the builder object of classifierId.
         *
         * @param classifierId value of classifierId
         * @return classifierId
         */
        QosClassifierBuilder classifierId(long classifierId);

        /**
         * Returns the builder object of operator.
         *
         * @param operator value of operator
         * @return operator
         */
        QosClassifierBuilder operator(OperatorEnum operator);

        /**
         * Returns the builder object of yangQosClassifierOpType.
         *
         * @param yangQosClassifierOpType value of yangQosClassifierOpType
         * @return yangQosClassifierOpType
         */
        QosClassifierBuilder yangQosClassifierOpType(OnosYangOpType yangQosClassifierOpType);

        /**
         * Returns the builder object of qosRuleAcls.
         *
         * @param qosRuleAcls value of qosRuleAcls
         * @return qosRuleAcls
         */
        QosClassifierBuilder qosRuleAcls(QosRuleAcls qosRuleAcls);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         QosClassifierBuilder addYangAugmentedInfo(Object value, Class classObject);

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
        QosClassifierBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of qosClassifier.
         *
         * @return qosClassifier
         */
        QosClassifier build();
    }
}
