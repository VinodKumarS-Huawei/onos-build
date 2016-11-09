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

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Qos.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.qosruleacls.DefaultQosRuleAcl;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.qos.qoscbqos.qosclassifiers
            .qosclassifier.qosruleacls.QosRuleAcl;

/**
 * Represents the implementation of qosRuleAcls.
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
public class DefaultQosRuleAcls implements QosRuleAcls {
    protected OnosYangOpType yangQosRuleAclsOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<QosRuleAcl> qosRuleAcl;

    @Override
    public OnosYangOpType yangQosRuleAclsOpType() {
        return yangQosRuleAclsOpType;
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
    public Map<Class<?>, Object> yangAugmentedInfoMap() {
        return yangAugmentedInfoMap;
    }

    @Override
    public List<QosRuleAcl> qosRuleAcl() {
        return qosRuleAcl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangQosRuleAclsOpType, isSubTreeFiltered, yangAugmentedInfoMap, qosRuleAcl);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultQosRuleAcls) {
            DefaultQosRuleAcls other = (DefaultQosRuleAcls) obj;
            return
                Objects.equals(yangQosRuleAclsOpType, other.yangQosRuleAclsOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(qosRuleAcl, other.qosRuleAcl);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangQosRuleAclsOpType", yangQosRuleAclsOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("qosRuleAcl", qosRuleAcl)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of qosRuleAcls.
     *
     * @param builderObject value of builder object of qosRuleAcls
     */
    protected DefaultQosRuleAcls(QosRuleAclsBuilder builderObject) {
        yangQosRuleAclsOpType = builderObject.yangQosRuleAclsOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        qosRuleAcl = builderObject.qosRuleAcl();
    }

    /**
     * Checks if the passed QosRuleAcls maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultQosRuleAcls processSubtreeFiltering(QosRuleAcls appInstance, boolean isSelectAllSchemaChild) {
        QosRuleAclsBuilder subTreeFilteringResultBuilder = new QosRuleAclsBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
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
        return (DefaultQosRuleAcls) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(QosRuleAcls appInstance, QosRuleAclsBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.qosRuleAcl() != null) {
                for (QosRuleAcl qosRuleAcl : appInstance.qosRuleAcl()) {
                    QosRuleAcl result;
                    result = ((DefaultQosRuleAcl) DefaultQosRuleAcl.builder()
                            .buildForFilter()).processSubtreeFiltering(qosRuleAcl, true);
                    subTreeFilteringResultBuilder.addToQosRuleAcl(result);
                }
            } else {
                if (isSubTreeFiltered && qosRuleAcl() != null) {
                    subTreeFilteringResultBuilder.qosRuleAcl(qosRuleAcl);
                }
            }
        } else if (qosRuleAcl() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!qosRuleAcl().isEmpty()) {
                if (appInstance.qosRuleAcl() != null && !appInstance.qosRuleAcl().isEmpty()) {
                for (QosRuleAcl qosRuleAcl : qosRuleAcl()) {
                    for (QosRuleAcl qosRuleAcl2 : appInstance.qosRuleAcl()) {
                            QosRuleAcl result = ((DefaultQosRuleAcl) qosRuleAcl)
                            .processSubtreeFiltering(qosRuleAcl2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToQosRuleAcl(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && qosRuleAcl() != null) {
                    subTreeFilteringResultBuilder.qosRuleAcl(qosRuleAcl);
                }
            }
            } else {
                if (appInstance.qosRuleAcl() != null && !appInstance.qosRuleAcl().isEmpty()) {
                for (QosRuleAcl qosRuleAcl : appInstance.qosRuleAcl()) {
                        subTreeFilteringResultBuilder.addToQosRuleAcl(qosRuleAcl);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultQosRuleAcls.
     */
    protected DefaultQosRuleAcls() {
    }

    /**
     * Returns the attribute qosRuleAclsBuilder.
     *
     * @return qosRuleAclsBuilder
     */
    public static QosRuleAclsBuilder builder() {
        return new QosRuleAclsBuilder();
    }

    /**
     * Represents the builder implementation of qosRuleAcls.
     */
    public static class QosRuleAclsBuilder implements QosRuleAcls.QosRuleAclsBuilder {
        protected OnosYangOpType yangQosRuleAclsOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<QosRuleAcl> qosRuleAcl;


        @Override
        public OnosYangOpType yangQosRuleAclsOpType() {
            return yangQosRuleAclsOpType;
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
        public Map<Class<?>, Object> yangAugmentedInfoMap() {
            return yangAugmentedInfoMap;
        }

        @Override
        public List<QosRuleAcl> qosRuleAcl() {
            return qosRuleAcl;
        }

        @Override
        public QosRuleAclsBuilder yangQosRuleAclsOpType(OnosYangOpType yangQosRuleAclsOpType) {
            this.yangQosRuleAclsOpType = yangQosRuleAclsOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public QosRuleAclsBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public QosRuleAclsBuilder qosRuleAcl(List<QosRuleAcl> qosRuleAcl) {
            this.qosRuleAcl = qosRuleAcl;
            return this;
        }

        @Override
        public QosRuleAclsBuilder addToQosRuleAcl(QosRuleAcl addTo) {
            if (qosRuleAcl == null) {
                qosRuleAcl = new ArrayList<>();
            }
            qosRuleAcl.add(addTo);
            return this;
        }


        @Override
        public QosRuleAclsBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public QosRuleAcls build() {
            return new DefaultQosRuleAcls(this);
        }

        /**
         * Builds object of qosRuleAcls.
         *
         * @return qosRuleAcls
         */
        public QosRuleAcls buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultQosRuleAcls(this);
        }
        /**
         * Creates an instance of qosRuleAclsBuilder.
         */
        public QosRuleAclsBuilder() {
        }

    }
}
