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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Acl.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .AclRuleAdv4;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .DefaultAclRuleAdv4;

/**
 * Represents the implementation of aclRuleAdv4s.
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
public class DefaultAclRuleAdv4s implements AclRuleAdv4s {
    protected OnosYangOpType yangAclRuleAdv4sOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<AclRuleAdv4> aclRuleAdv4;

    @Override
    public OnosYangOpType yangAclRuleAdv4sOpType() {
        return yangAclRuleAdv4sOpType;
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
    public List<AclRuleAdv4> aclRuleAdv4() {
        return aclRuleAdv4;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangAclRuleAdv4sOpType, isSubTreeFiltered, yangAugmentedInfoMap, aclRuleAdv4);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultAclRuleAdv4s) {
            DefaultAclRuleAdv4s other = (DefaultAclRuleAdv4s) obj;
            return
                Objects.equals(yangAclRuleAdv4sOpType, other.yangAclRuleAdv4sOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(aclRuleAdv4, other.aclRuleAdv4);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangAclRuleAdv4sOpType", yangAclRuleAdv4sOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("aclRuleAdv4", aclRuleAdv4)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of aclRuleAdv4s.
     *
     * @param builderObject value of builder object of aclRuleAdv4s
     */
    protected DefaultAclRuleAdv4s(AclRuleAdv4sBuilder builderObject) {
        yangAclRuleAdv4sOpType = builderObject.yangAclRuleAdv4sOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        aclRuleAdv4 = builderObject.aclRuleAdv4();
    }

    /**
     * Checks if the passed AclRuleAdv4s maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultAclRuleAdv4s processSubtreeFiltering(AclRuleAdv4s appInstance, boolean isSelectAllSchemaChild) {
        AclRuleAdv4sBuilder subTreeFilteringResultBuilder = new AclRuleAdv4sBuilder();
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
        return (DefaultAclRuleAdv4s) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(AclRuleAdv4s appInstance, AclRuleAdv4sBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.aclRuleAdv4() != null) {
                for (AclRuleAdv4 aclRuleAdv4 : appInstance.aclRuleAdv4()) {
                    AclRuleAdv4 result;
                    result = ((DefaultAclRuleAdv4) DefaultAclRuleAdv4.builder()
                            .buildForFilter()).processSubtreeFiltering(aclRuleAdv4, true);
                    subTreeFilteringResultBuilder.addToAclRuleAdv4(result);
                }
            } else {
                if (isSubTreeFiltered && aclRuleAdv4() != null) {
                    subTreeFilteringResultBuilder.aclRuleAdv4(aclRuleAdv4);
                }
            }
        } else if (aclRuleAdv4() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!aclRuleAdv4().isEmpty()) {
                if (appInstance.aclRuleAdv4() != null && !appInstance.aclRuleAdv4().isEmpty()) {
                for (AclRuleAdv4 aclRuleAdv4 : aclRuleAdv4()) {
                    for (AclRuleAdv4 aclRuleAdv42 : appInstance.aclRuleAdv4()) {
                            AclRuleAdv4 result = ((DefaultAclRuleAdv4) aclRuleAdv4)
                            .processSubtreeFiltering(aclRuleAdv42, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToAclRuleAdv4(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && aclRuleAdv4() != null) {
                    subTreeFilteringResultBuilder.aclRuleAdv4(aclRuleAdv4);
                }
            }
            } else {
                if (appInstance.aclRuleAdv4() != null && !appInstance.aclRuleAdv4().isEmpty()) {
                for (AclRuleAdv4 aclRuleAdv4 : appInstance.aclRuleAdv4()) {
                        subTreeFilteringResultBuilder.addToAclRuleAdv4(aclRuleAdv4);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultAclRuleAdv4s.
     */
    protected DefaultAclRuleAdv4s() {
    }

    /**
     * Returns the attribute aclRuleAdv4sBuilder.
     *
     * @return aclRuleAdv4sBuilder
     */
    public static AclRuleAdv4sBuilder builder() {
        return new AclRuleAdv4sBuilder();
    }

    /**
     * Represents the builder implementation of aclRuleAdv4s.
     */
    public static class AclRuleAdv4sBuilder implements AclRuleAdv4s.AclRuleAdv4sBuilder {
        protected OnosYangOpType yangAclRuleAdv4sOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<AclRuleAdv4> aclRuleAdv4;


        @Override
        public OnosYangOpType yangAclRuleAdv4sOpType() {
            return yangAclRuleAdv4sOpType;
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
        public List<AclRuleAdv4> aclRuleAdv4() {
            return aclRuleAdv4;
        }

        @Override
        public AclRuleAdv4sBuilder yangAclRuleAdv4sOpType(OnosYangOpType yangAclRuleAdv4sOpType) {
            this.yangAclRuleAdv4sOpType = yangAclRuleAdv4sOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public AclRuleAdv4sBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public AclRuleAdv4sBuilder aclRuleAdv4(List<AclRuleAdv4> aclRuleAdv4) {
            this.aclRuleAdv4 = aclRuleAdv4;
            return this;
        }

        @Override
        public AclRuleAdv4sBuilder addToAclRuleAdv4(AclRuleAdv4 addTo) {
            if (aclRuleAdv4 == null) {
                aclRuleAdv4 = new ArrayList<>();
            }
            aclRuleAdv4.add(addTo);
            return this;
        }


        @Override
        public AclRuleAdv4sBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public AclRuleAdv4s build() {
            return new DefaultAclRuleAdv4s(this);
        }

        /**
         * Builds object of aclRuleAdv4s.
         *
         * @return aclRuleAdv4s
         */
        public AclRuleAdv4s buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultAclRuleAdv4s(this);
        }
        /**
         * Creates an instance of aclRuleAdv4sBuilder.
         */
        public AclRuleAdv4sBuilder() {
        }

    }
}
