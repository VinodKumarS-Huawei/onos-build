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

import com.google.common.base.MoreObjects;
import java.util.BitSet;
import java.util.Objects;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.DefaultQosCbQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.DefaultQosIfQoss;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.QosCbQos;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.QosIfQoss;

/**
 * Represents the implementation of qos.
 *
 * <p>
 * valueLeafFlags identify the leafs whose value are explicitly set
 * Applicable in protocol edit and query operation.
 * </p>
 *
 * <p>
 * selectLeafFlags identify the leafs to be selected, in a query operation.
 * </p>
 *
 * <p>
 * Operation type specify the node specific operation in protocols like NETCONF.
 * Applicable in protocol edit operation, not applicable in query operation.
 * </p>
 */
public class QosOpParam implements Qos {
    protected OnosYangOpType yangQosOpType;
    protected boolean isSubTreeFiltered;
    protected QosCbQos qosCbQos;
    protected QosIfQoss qosIfQoss;

    @Override
    public OnosYangOpType yangQosOpType() {
        return yangQosOpType;
    }
    /**
     * Returns the attribute isSubTreeFiltered.
     *
     * @return isSubTreeFiltered value of isSubTreeFiltered
     */
    public boolean isSubTreeFiltered() {
        return isSubTreeFiltered;
    }

    @Override
    public QosCbQos qosCbQos() {
        return qosCbQos;
    }

    @Override
    public QosIfQoss qosIfQoss() {
        return qosIfQoss;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosOpType, isSubTreeFiltered, qosCbQos, qosIfQoss);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof QosOpParam) {
            QosOpParam other = (QosOpParam) obj;
            return
                Objects.equals(yangQosOpType, other.yangQosOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(qosCbQos, other.qosCbQos) &&
                Objects.equals(qosIfQoss, other.qosIfQoss);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosOpType", yangQosOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("qosCbQos", qosCbQos)
            .add("qosIfQoss", qosIfQoss)
            .toString();
    }
    /**
     * Creates an instance of qos.
     *
     * @param builderObject value of builder object of qos
     */
    protected QosOpParam(QosBuilder builderObject) {
        yangQosOpType = builderObject.yangQosOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        qosCbQos = builderObject.qosCbQos();
        qosIfQoss = builderObject.qosIfQoss();
    }

    /**
     * Checks if the passed Qos maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public QosOpParam processSubtreeFiltering(Qos appInstance, boolean isSelectAllSchemaChild) {
        QosBuilder subTreeFilteringResultBuilder = new QosBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
         if (!processChildNodesSubTreeFiltering(appInstance, subTreeFilteringResultBuilder,
                    isAnySelectOrContainmentNode, isSelectAllSchemaChild)) {
            return null;
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (QosOpParam) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processChildNodesSubTreeFiltering(Qos appInstance, QosBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (qosCbQos() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosCbQos() != null) {
                QosCbQos result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosCbQos) DefaultQosCbQos.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosCbQos(), true);
                } else {
                    result = ((DefaultQosCbQos) qosCbQos)
                            .processSubtreeFiltering(appInstance.qosCbQos(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosCbQos(result);
                }
            } else {
                if (isSubTreeFiltered && qosCbQos() != null) {
                    subTreeFilteringResultBuilder.qosCbQos(qosCbQos);
                }
            }
        }

        if (qosIfQoss() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosIfQoss() != null) {
                QosIfQoss result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosIfQoss) DefaultQosIfQoss.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosIfQoss(), true);
                } else {
                    result = ((DefaultQosIfQoss) qosIfQoss)
                            .processSubtreeFiltering(appInstance.qosIfQoss(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosIfQoss(result);
                }
            } else {
                if (isSubTreeFiltered && qosIfQoss() != null) {
                    subTreeFilteringResultBuilder.qosIfQoss(qosIfQoss);
                }
            }
        }

        return true;
    }

    /**
     * Creates an instance of qosOpParam.
     */
    protected QosOpParam() {
    }

    /**
     * Returns the attribute qosBuilder.
     *
     * @return qosBuilder
     */
    public static QosBuilder builder() {
        return new QosBuilder();
    }

    /**
     * Represents the builder implementation of qos.
     */
    public static class QosBuilder implements Qos.QosBuilder {
        protected OnosYangOpType yangQosOpType;
        protected boolean isSubTreeFiltered;
        protected QosCbQos qosCbQos;
        protected QosIfQoss qosIfQoss;


        @Override
        public OnosYangOpType yangQosOpType() {
            return yangQosOpType;
        }
        /**
         * Returns the attribute isSubTreeFiltered.
         *
         * @return isSubTreeFiltered value of isSubTreeFiltered
         */
        public boolean isSubTreeFiltered() {
            return isSubTreeFiltered;
        }

        @Override
        public QosCbQos qosCbQos() {
            return qosCbQos;
        }

        @Override
        public QosIfQoss qosIfQoss() {
            return qosIfQoss;
        }

        @Override
        public QosBuilder yangQosOpType(OnosYangOpType yangQosOpType) {
            this.yangQosOpType = yangQosOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosBuilder qosCbQos(QosCbQos qosCbQos) {
            this.qosCbQos = qosCbQos;
            return this;
        }

        @Override
        public QosBuilder qosIfQoss(QosIfQoss qosIfQoss) {
            this.qosIfQoss = qosIfQoss;
            return this;
        }
        @Override
        public Qos build() {
            return new QosOpParam(this);
        }

        /**
         * Builds object of qos.
         *
         * @return qos
         */
        public Qos buildForFilter() {
            isSubTreeFiltered = true;
            return new QosOpParam(this);
        }
        /**
         * Creates an instance of qosBuilder.
         */
        public QosBuilder() {
        }

    }
}
