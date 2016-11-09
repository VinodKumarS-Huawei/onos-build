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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.AclGroup;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.DefaultAclGroup;

/**
 * Represents the implementation of aclGroups.
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
public class DefaultAclGroups implements AclGroups {
    protected OnosYangOpType yangAclGroupsOpType;
    protected boolean isSubTreeFiltered;
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected List<AclGroup> aclGroup;

    @Override
    public OnosYangOpType yangAclGroupsOpType() {
        return yangAclGroupsOpType;
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
    public List<AclGroup> aclGroup() {
        return aclGroup;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangAclGroupsOpType, isSubTreeFiltered, yangAugmentedInfoMap, aclGroup);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultAclGroups) {
            DefaultAclGroups other = (DefaultAclGroups) obj;
            return
                Objects.equals(yangAclGroupsOpType, other.yangAclGroupsOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(aclGroup, other.aclGroup);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangAclGroupsOpType", yangAclGroupsOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("aclGroup", aclGroup)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of aclGroups.
     *
     * @param builderObject value of builder object of aclGroups
     */
    protected DefaultAclGroups(AclGroupsBuilder builderObject) {
        yangAclGroupsOpType = builderObject.yangAclGroupsOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        aclGroup = builderObject.aclGroup();
    }

    /**
     * Checks if the passed AclGroups maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultAclGroups processSubtreeFiltering(AclGroups appInstance, boolean isSelectAllSchemaChild) {
        AclGroupsBuilder subTreeFilteringResultBuilder = new AclGroupsBuilder();
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
        return (DefaultAclGroups) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processChildNodesSubTreeFiltering(AclGroups appInstance, AclGroupsBuilder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (isSelectAllSchemaChild) {
            if (appInstance.aclGroup() != null) {
                for (AclGroup aclGroup : appInstance.aclGroup()) {
                    AclGroup result;
                    result = ((DefaultAclGroup) DefaultAclGroup.builder()
                            .buildForFilter()).processSubtreeFiltering(aclGroup, true);
                    subTreeFilteringResultBuilder.addToAclGroup(result);
                }
            } else {
                if (isSubTreeFiltered && aclGroup() != null) {
                    subTreeFilteringResultBuilder.aclGroup(aclGroup);
                }
            }
        } else if (aclGroup() != null) {
            isAnySelectOrContainmentNode.set(0);
            if (!aclGroup().isEmpty()) {
                if (appInstance.aclGroup() != null && !appInstance.aclGroup().isEmpty()) {
                for (AclGroup aclGroup : aclGroup()) {
                    for (AclGroup aclGroup2 : appInstance.aclGroup()) {
                            AclGroup result = ((DefaultAclGroup) aclGroup)
                            .processSubtreeFiltering(aclGroup2, false);
                            if (result != null) {
                                subTreeFilteringResultBuilder.addToAclGroup(result);
                            }
                        }
                    }
                } else {
                if (isSubTreeFiltered && aclGroup() != null) {
                    subTreeFilteringResultBuilder.aclGroup(aclGroup);
                }
            }
            } else {
                if (appInstance.aclGroup() != null && !appInstance.aclGroup().isEmpty()) {
                for (AclGroup aclGroup : appInstance.aclGroup()) {
                        subTreeFilteringResultBuilder.addToAclGroup(aclGroup);
                    }
                }
            }
        }

        return true;
    }


    /**
     * Creates an instance of defaultAclGroups.
     */
    protected DefaultAclGroups() {
    }

    /**
     * Returns the attribute aclGroupsBuilder.
     *
     * @return aclGroupsBuilder
     */
    public static AclGroupsBuilder builder() {
        return new AclGroupsBuilder();
    }

    /**
     * Represents the builder implementation of aclGroups.
     */
    public static class AclGroupsBuilder implements AclGroups.AclGroupsBuilder {
        protected OnosYangOpType yangAclGroupsOpType;
        protected boolean isSubTreeFiltered;
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected List<AclGroup> aclGroup;


        @Override
        public OnosYangOpType yangAclGroupsOpType() {
            return yangAclGroupsOpType;
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
        public List<AclGroup> aclGroup() {
            return aclGroup;
        }

        @Override
        public AclGroupsBuilder yangAclGroupsOpType(OnosYangOpType yangAclGroupsOpType) {
            this.yangAclGroupsOpType = yangAclGroupsOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public AclGroupsBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public AclGroupsBuilder aclGroup(List<AclGroup> aclGroup) {
            this.aclGroup = aclGroup;
            return this;
        }

        @Override
        public AclGroupsBuilder addToAclGroup(AclGroup addTo) {
            if (aclGroup == null) {
                aclGroup = new ArrayList<>();
            }
            aclGroup.add(addTo);
            return this;
        }


        @Override
        public AclGroupsBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public AclGroups build() {
            return new DefaultAclGroups(this);
        }

        /**
         * Builds object of aclGroups.
         *
         * @return aclGroups
         */
        public AclGroups buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultAclGroups(this);
        }
        /**
         * Creates an instance of aclGroupsBuilder.
         */
        public AclGroupsBuilder() {
        }

    }
}
