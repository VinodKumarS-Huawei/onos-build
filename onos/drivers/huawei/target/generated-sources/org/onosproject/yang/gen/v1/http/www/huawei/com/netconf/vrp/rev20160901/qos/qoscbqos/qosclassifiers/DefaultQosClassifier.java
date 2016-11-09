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

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.DefaultQosRuleAcls;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.OperatorEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.QosRuleAcls;

/**
 * Represents the implementation of qosClassifier.
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
public class DefaultQosClassifier implements QosClassifier {
    protected String classifierName;
    protected long classifierId;
    protected OperatorEnum operator;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangQosClassifierOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected QosRuleAcls qosRuleAcls;

    @Override
    public String classifierName() {
        return classifierName;
    }

    @Override
    public long classifierId() {
        return classifierId;
    }

    @Override
    public OperatorEnum operator() {
        return operator;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangQosClassifierOpType() {
        return yangQosClassifierOpType;
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
    public BitSet selectLeafFlags() {
        return selectLeafFlags;
    }

    @Override
    public Map<Class<?>, Object> yangAugmentedInfoMap() {
        return yangAugmentedInfoMap;
    }

    @Override
    public QosRuleAcls qosRuleAcls() {
        return qosRuleAcls;
    }

    @Override
    public int hashCode() {
         return Objects.hash(classifierName, classifierId, operator, valueLeafFlags, yangQosClassifierOpType,
                    isSubTreeFiltered, selectLeafFlags, yangAugmentedInfoMap, qosRuleAcls);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosClassifier) {
            DefaultQosClassifier other = (DefaultQosClassifier) obj;
            return
                Objects.equals(classifierName, other.classifierName) &&
                Objects.equals(classifierId, other.classifierId) &&
                Objects.equals(operator, other.operator) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangQosClassifierOpType, other.yangQosClassifierOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosRuleAcls, other.qosRuleAcls);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("classifierName", classifierName)
            .add("classifierId", classifierId)
            .add("operator", operator)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangQosClassifierOpType", yangQosClassifierOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosRuleAcls", qosRuleAcls)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosClassifier.
     *
     * @param builderObject value of builder object of qosClassifier
     */
    protected DefaultQosClassifier(QosClassifierBuilder builderObject) {
        classifierName = builderObject.classifierName();
        classifierId = builderObject.classifierId();
        operator = builderObject.operator();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangQosClassifierOpType = builderObject.yangQosClassifierOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosRuleAcls = builderObject.qosRuleAcls();
    }

    /**
     * Checks if the passed QosClassifier maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosClassifier processSubtreeFiltering(QosClassifier appInstance, boolean isSelectAllSchemaChild) {
        QosClassifierBuilder subTreeFilteringResultBuilder = new QosClassifierBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
        if (!processLeafSubtreeFiltering(appInstance, subTreeFilteringResultBuilder, isAnySelectOrContainmentNode,
                    isSelectAllSchemaChild)) {
            return null;
        }
         if (!processChildNodesSubTreeFiltering(appInstance, subTreeFilteringResultBuilder,
                    isAnySelectOrContainmentNode, isSelectAllSchemaChild)) {
            return null;
        }
        if (yangAugmentedInfoMap.isEmpty()) {
            Set<Map.Entry<Class<?>, Object>> augment = appInstance.yangAugmentedInfoMap().entrySet();
            if (augment != null && !augment.isEmpty()) {
                Iterator<Map.Entry<Class<?>, Object>> augItr = augment.iterator();
                while (augItr.hasNext()) {
                    Map.Entry<Class<?>, Object> aug = augItr.next();
                    Class<?> augClass = aug.getKey();
                    String augClassName = augClass.getName();
                    int index = augClassName.lastIndexOf('.');
                    String classPackage = augClassName.substring(0, index) +
                            "." + "Default" + augClass.getSimpleName() + "$"
                            + augClass.getSimpleName() + "Builder";
                    ClassLoader classLoader = augClass.getClassLoader();
                    try {
                        Class<?> builderClass;
                        builderClass = classLoader.loadClass(classPackage);
                        Object builderObj = builderClass.newInstance();
                        Method method = builderClass.getMethod("build");
                        Object defaultObj = method.invoke(builderObj);
                        Class<?> defaultClass = defaultObj.getClass();
                        method = defaultClass.getMethod
                                ("processSubtreeFiltering", augClass,
                                 boolean.class);
                        Object result = method.invoke(defaultObj, aug.getValue(),
                                                      true);
                        subTreeFilteringResultBuilder
                                .addYangAugmentedInfo(result, augClass);
                    } catch (ClassNotFoundException | InstantiationException
                            | NoSuchMethodException |
                            InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            Set<Map.Entry<Class<?>, Object>> augment = yangAugmentedInfoMap
                    .entrySet();
            Iterator<Map.Entry<Class<?>, Object>> augItr = augment.iterator();
            while (augItr.hasNext()) {
                Map.Entry<Class<?>, Object> aug = augItr.next();
                Class<?> augClass = aug.getKey();
                Object appInstanceInfo = appInstance.yangAugmentedInfo(augClass);
                if (appInstanceInfo == null) {
                    subTreeFilteringResultBuilder.addYangAugmentedInfo
                            (aug.getValue(), aug.getKey());
                } else {
                    Object processSubtreeFiltering;
                    try {
                        processSubtreeFiltering = aug.getValue().getClass()
                                .getMethod("processSubtreeFiltering",
                                           aug.getKey(), boolean.class)
                                .invoke(aug.getValue(),
                                        appInstanceInfo, true);
                        if (processSubtreeFiltering != null) {
                            subTreeFilteringResultBuilder
                                    .addYangAugmentedInfo(processSubtreeFiltering, aug.getKey());
                        }
                    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (DefaultQosClassifier) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(QosClassifier appInstance, QosClassifierBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.CLASSIFIERNAME.getLeafIndex())) {
            if (appInstance.classifierName() == null || !(classifierName().equals(appInstance.classifierName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.CLASSIFIERNAME)) {
                    subTreeFilteringResultBuilder.classifierName(classifierName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.classifierName(appInstance.classifierName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.CLASSIFIERNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.classifierName(appInstance.classifierName());
        }

        if (valueLeafFlags.get(LeafIdentifier.CLASSIFIERID.getLeafIndex())) {
            if (appInstance.classifierId() != classifierId()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.CLASSIFIERID)) {
                    subTreeFilteringResultBuilder.classifierId(classifierId());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.classifierId(appInstance.classifierId());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.CLASSIFIERID.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.classifierId(appInstance.classifierId());
        }

        if (valueLeafFlags.get(LeafIdentifier.OPERATOR.getLeafIndex())) {
            if (appInstance.operator() == null || !(operator().equals(appInstance.operator()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.OPERATOR)) {
                    subTreeFilteringResultBuilder.operator(operator());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.operator(appInstance.operator());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.OPERATOR.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.operator(appInstance.operator());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(QosClassifier appInstance, QosClassifierBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (qosRuleAcls() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.qosRuleAcls() != null) {
                QosRuleAcls result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultQosRuleAcls) DefaultQosRuleAcls.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.qosRuleAcls(), true);
                } else {
                    result = ((DefaultQosRuleAcls) qosRuleAcls)
                            .processSubtreeFiltering(appInstance.qosRuleAcls(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.qosRuleAcls(result);
                }
            } else {
                if (isSubTreeFiltered && qosRuleAcls() != null) {
                    subTreeFilteringResultBuilder.qosRuleAcls(qosRuleAcls);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosClassifier.
     */
    protected DefaultQosClassifier() {
    }

    /**
     * Returns the attribute qosClassifierBuilder.
     *
     * @return qosClassifierBuilder
     */
    public static QosClassifierBuilder builder() {
        return new QosClassifierBuilder();
    }

    @Override
    public boolean isLeafValueSet(LeafIdentifier leaf) {
        return valueLeafFlags.get(leaf.getLeafIndex());
    }

    @Override
    public boolean isSelectLeaf(LeafIdentifier leaf) {
        return selectLeafFlags.get(leaf.getLeafIndex());
    }

    /**
     * Represents the builder implementation of qosClassifier.
     */
    public static class QosClassifierBuilder implements QosClassifier.QosClassifierBuilder {
        protected String classifierName;
        protected long classifierId;
        protected OperatorEnum operator;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangQosClassifierOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected QosRuleAcls qosRuleAcls;



        @Override
        public String classifierName() {
            return classifierName;
        }

        @Override
        public long classifierId() {
            return classifierId;
        }

        @Override
        public OperatorEnum operator() {
            return operator;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangQosClassifierOpType() {
            return yangQosClassifierOpType;
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
        public BitSet selectLeafFlags() {
            return selectLeafFlags;
        }

        @Override
        public Map<Class<?>, Object> yangAugmentedInfoMap() {
            return yangAugmentedInfoMap;
        }

        @Override
        public QosRuleAcls qosRuleAcls() {
            return qosRuleAcls;
        }

        @Override
        public QosClassifierBuilder classifierName(String classifierName) {
            valueLeafFlags.set(LeafIdentifier.CLASSIFIERNAME.getLeafIndex());
            this.classifierName = classifierName;
            return this;
        }

        @Override
        public QosClassifierBuilder classifierId(long classifierId) {
            valueLeafFlags.set(LeafIdentifier.CLASSIFIERID.getLeafIndex());
            this.classifierId = classifierId;
            return this;
        }

        @Override
        public QosClassifierBuilder operator(OperatorEnum operator) {
            valueLeafFlags.set(LeafIdentifier.OPERATOR.getLeafIndex());
            this.operator = operator;
            return this;
        }

        @Override
        public QosClassifierBuilder yangQosClassifierOpType(OnosYangOpType yangQosClassifierOpType) {
            this.yangQosClassifierOpType = yangQosClassifierOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosClassifierBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosClassifierBuilder qosRuleAcls(QosRuleAcls qosRuleAcls) {
            this.qosRuleAcls = qosRuleAcls;
            return this;
        }

        @Override
        public QosClassifierBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public QosClassifierBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosClassifier build() {
            return new DefaultQosClassifier(this);
        }

        /**
         * Builds object of qosClassifier.
         *
         * @return qosClassifier
         */
        public QosClassifier buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosClassifier(this);
        }
        /**
         * Creates an instance of qosClassifierBuilder.
         */
        public QosClassifierBuilder() {
        }

    }
}
