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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups;

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Acl.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.AclRuleAdv4s;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup
            .DefaultAclRuleAdv4s;

/**
 * Represents the implementation of aclGroup.
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
public class DefaultAclGroup implements AclGroup {
    protected String aclNumOrName;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangAclGroupOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected AclRuleAdv4s aclRuleAdv4s;

    @Override
    public String aclNumOrName() {
        return aclNumOrName;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangAclGroupOpType() {
        return yangAclGroupOpType;
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
    public AclRuleAdv4s aclRuleAdv4s() {
        return aclRuleAdv4s;
    }

    @Override
    public int hashCode() {
         return Objects.hash(aclNumOrName, valueLeafFlags, yangAclGroupOpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap, aclRuleAdv4s);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultAclGroup) {
            DefaultAclGroup other = (DefaultAclGroup) obj;
            return
                Objects.equals(aclNumOrName, other.aclNumOrName) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangAclGroupOpType, other.yangAclGroupOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(aclRuleAdv4s, other.aclRuleAdv4s);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("aclNumOrName", aclNumOrName)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangAclGroupOpType", yangAclGroupOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("aclRuleAdv4s", aclRuleAdv4s)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of aclGroup.
     *
     * @param builderObject value of builder object of aclGroup
     */
    protected DefaultAclGroup(AclGroupBuilder builderObject) {
        aclNumOrName = builderObject.aclNumOrName();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangAclGroupOpType = builderObject.yangAclGroupOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        aclRuleAdv4s = builderObject.aclRuleAdv4s();
    }

    /**
     * Checks if the passed AclGroup maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultAclGroup processSubtreeFiltering(AclGroup appInstance, boolean isSelectAllSchemaChild) {
        AclGroupBuilder subTreeFilteringResultBuilder = new AclGroupBuilder();
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
        return (DefaultAclGroup) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(AclGroup appInstance, AclGroupBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.ACLNUMORNAME.getLeafIndex())) {
            if (appInstance.aclNumOrName() == null || !(aclNumOrName().equals(appInstance.aclNumOrName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLNUMORNAME)) {
                    subTreeFilteringResultBuilder.aclNumOrName(aclNumOrName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclNumOrName(appInstance.aclNumOrName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLNUMORNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclNumOrName(appInstance.aclNumOrName());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(AclGroup appInstance, AclGroupBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (aclRuleAdv4s() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.aclRuleAdv4s() != null) {
                AclRuleAdv4s result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultAclRuleAdv4s) DefaultAclRuleAdv4s.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.aclRuleAdv4s(), true);
                } else {
                    result = ((DefaultAclRuleAdv4s) aclRuleAdv4s)
                            .processSubtreeFiltering(appInstance.aclRuleAdv4s(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.aclRuleAdv4s(result);
                }
            } else {
                if (isSubTreeFiltered && aclRuleAdv4s() != null) {
                    subTreeFilteringResultBuilder.aclRuleAdv4s(aclRuleAdv4s);
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultAclGroup.
     */
    protected DefaultAclGroup() {
    }

    /**
     * Returns the attribute aclGroupBuilder.
     *
     * @return aclGroupBuilder
     */
    public static AclGroupBuilder builder() {
        return new AclGroupBuilder();
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
     * Represents the builder implementation of aclGroup.
     */
    public static class AclGroupBuilder implements AclGroup.AclGroupBuilder {
        protected String aclNumOrName;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangAclGroupOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected AclRuleAdv4s aclRuleAdv4s;



        @Override
        public String aclNumOrName() {
            return aclNumOrName;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangAclGroupOpType() {
            return yangAclGroupOpType;
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
        public AclRuleAdv4s aclRuleAdv4s() {
            return aclRuleAdv4s;
        }

        @Override
        public AclGroupBuilder aclNumOrName(String aclNumOrName) {
            valueLeafFlags.set(LeafIdentifier.ACLNUMORNAME.getLeafIndex());
            this.aclNumOrName = aclNumOrName;
            return this;
        }

        @Override
        public AclGroupBuilder yangAclGroupOpType(OnosYangOpType yangAclGroupOpType) {
            this.yangAclGroupOpType = yangAclGroupOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public AclGroupBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public AclGroupBuilder aclRuleAdv4s(AclRuleAdv4s aclRuleAdv4s) {
            this.aclRuleAdv4s = aclRuleAdv4s;
            return this;
        }

        @Override
        public AclGroupBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public AclGroupBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public AclGroup build() {
            return new DefaultAclGroup(this);
        }

        /**
         * Builds object of aclGroup.
         *
         * @return aclGroup
         */
        public AclGroup buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultAclGroup(this);
        }
        /**
         * Creates an instance of aclGroupBuilder.
         */
        public AclGroupBuilder() {
        }

    }
}
