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

package org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s;

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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .aclruleadv4.AclActionEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .aclruleadv4.AclActiveStatusEnum;

/**
 * Represents the implementation of aclRuleAdv4.
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
public class DefaultAclRuleAdv4 implements AclRuleAdv4 {
    protected String aclRuleName;
    protected long aclRuleId;
    protected AclActionEnum aclAction;
    protected short aclProtocol;
    protected String aclSourceIp;
    protected String aclSrcWild;
    protected String aclDestIp;
    protected String aclDestWild;
    protected String vrfName;
    protected AclActiveStatusEnum aclActiveStatus;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangAclRuleAdv4OpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public String aclRuleName() {
        return aclRuleName;
    }

    @Override
    public long aclRuleId() {
        return aclRuleId;
    }

    @Override
    public AclActionEnum aclAction() {
        return aclAction;
    }

    @Override
    public short aclProtocol() {
        return aclProtocol;
    }

    @Override
    public String aclSourceIp() {
        return aclSourceIp;
    }

    @Override
    public String aclSrcWild() {
        return aclSrcWild;
    }

    @Override
    public String aclDestIp() {
        return aclDestIp;
    }

    @Override
    public String aclDestWild() {
        return aclDestWild;
    }

    @Override
    public String vrfName() {
        return vrfName;
    }

    @Override
    public AclActiveStatusEnum aclActiveStatus() {
        return aclActiveStatus;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangAclRuleAdv4OpType() {
        return yangAclRuleAdv4OpType;
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
    public int hashCode() {
         return Objects.hash(aclRuleName, aclRuleId, aclAction, aclProtocol, aclSourceIp, aclSrcWild, aclDestIp,
                    aclDestWild, vrfName, aclActiveStatus, valueLeafFlags, yangAclRuleAdv4OpType, isSubTreeFiltered,
                    selectLeafFlags, yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultAclRuleAdv4) {
            DefaultAclRuleAdv4 other = (DefaultAclRuleAdv4) obj;
            return
                Objects.equals(aclRuleName, other.aclRuleName) &&
                Objects.equals(aclRuleId, other.aclRuleId) &&
                Objects.equals(aclAction, other.aclAction) &&
                Objects.equals(aclProtocol, other.aclProtocol) &&
                Objects.equals(aclSourceIp, other.aclSourceIp) &&
                Objects.equals(aclSrcWild, other.aclSrcWild) &&
                Objects.equals(aclDestIp, other.aclDestIp) &&
                Objects.equals(aclDestWild, other.aclDestWild) &&
                Objects.equals(vrfName, other.vrfName) &&
                Objects.equals(aclActiveStatus, other.aclActiveStatus) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangAclRuleAdv4OpType, other.yangAclRuleAdv4OpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(selectLeafFlags, other.selectLeafFlags) &&
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("aclRuleName", aclRuleName)
            .add("aclRuleId", aclRuleId)
            .add("aclAction", aclAction)
            .add("aclProtocol", aclProtocol)
            .add("aclSourceIp", aclSourceIp)
            .add("aclSrcWild", aclSrcWild)
            .add("aclDestIp", aclDestIp)
            .add("aclDestWild", aclDestWild)
            .add("vrfName", vrfName)
            .add("aclActiveStatus", aclActiveStatus)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangAclRuleAdv4OpType", yangAclRuleAdv4OpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("selectLeafFlags", selectLeafFlags)
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of aclRuleAdv4.
     *
     * @param builderObject value of builder object of aclRuleAdv4
     */
    protected DefaultAclRuleAdv4(AclRuleAdv4Builder builderObject) {
        aclRuleName = builderObject.aclRuleName();
        aclRuleId = builderObject.aclRuleId();
        aclAction = builderObject.aclAction();
        aclProtocol = builderObject.aclProtocol();
        aclSourceIp = builderObject.aclSourceIp();
        aclSrcWild = builderObject.aclSrcWild();
        aclDestIp = builderObject.aclDestIp();
        aclDestWild = builderObject.aclDestWild();
        vrfName = builderObject.vrfName();
        aclActiveStatus = builderObject.aclActiveStatus();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangAclRuleAdv4OpType = builderObject.yangAclRuleAdv4OpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed AclRuleAdv4 maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultAclRuleAdv4 processSubtreeFiltering(AclRuleAdv4 appInstance, boolean isSelectAllSchemaChild) {
        AclRuleAdv4Builder subTreeFilteringResultBuilder = new AclRuleAdv4Builder();
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
        return (DefaultAclRuleAdv4) subTreeFilteringResultBuilder.buildForFilter();
    }

    private boolean processLeafSubtreeFiltering(AclRuleAdv4 appInstance, AclRuleAdv4Builder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.ACLRULENAME.getLeafIndex())) {
            if (appInstance.aclRuleName() == null || !(aclRuleName().equals(appInstance.aclRuleName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLRULENAME)) {
                    subTreeFilteringResultBuilder.aclRuleName(aclRuleName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclRuleName(appInstance.aclRuleName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLRULENAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclRuleName(appInstance.aclRuleName());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLRULEID.getLeafIndex())) {
            if (appInstance.aclRuleId() != aclRuleId()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLRULEID)) {
                    subTreeFilteringResultBuilder.aclRuleId(aclRuleId());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclRuleId(appInstance.aclRuleId());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLRULEID.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclRuleId(appInstance.aclRuleId());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLACTION.getLeafIndex())) {
            if (appInstance.aclAction() == null || !(aclAction().equals(appInstance.aclAction()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLACTION)) {
                    subTreeFilteringResultBuilder.aclAction(aclAction());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclAction(appInstance.aclAction());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLACTION.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclAction(appInstance.aclAction());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLPROTOCOL.getLeafIndex())) {
            if (appInstance.aclProtocol() != aclProtocol()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLPROTOCOL)) {
                    subTreeFilteringResultBuilder.aclProtocol(aclProtocol());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclProtocol(appInstance.aclProtocol());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLPROTOCOL.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclProtocol(appInstance.aclProtocol());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLSOURCEIP.getLeafIndex())) {
            if (appInstance.aclSourceIp() == null || !(aclSourceIp().equals(appInstance.aclSourceIp()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLSOURCEIP)) {
                    subTreeFilteringResultBuilder.aclSourceIp(aclSourceIp());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclSourceIp(appInstance.aclSourceIp());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLSOURCEIP.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclSourceIp(appInstance.aclSourceIp());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLSRCWILD.getLeafIndex())) {
            if (appInstance.aclSrcWild() == null || !(aclSrcWild().equals(appInstance.aclSrcWild()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLSRCWILD)) {
                    subTreeFilteringResultBuilder.aclSrcWild(aclSrcWild());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclSrcWild(appInstance.aclSrcWild());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLSRCWILD.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclSrcWild(appInstance.aclSrcWild());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLDESTIP.getLeafIndex())) {
            if (appInstance.aclDestIp() == null || !(aclDestIp().equals(appInstance.aclDestIp()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLDESTIP)) {
                    subTreeFilteringResultBuilder.aclDestIp(aclDestIp());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclDestIp(appInstance.aclDestIp());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLDESTIP.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclDestIp(appInstance.aclDestIp());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLDESTWILD.getLeafIndex())) {
            if (appInstance.aclDestWild() == null || !(aclDestWild().equals(appInstance.aclDestWild()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLDESTWILD)) {
                    subTreeFilteringResultBuilder.aclDestWild(aclDestWild());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclDestWild(appInstance.aclDestWild());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLDESTWILD.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclDestWild(appInstance.aclDestWild());
        }

        if (valueLeafFlags.get(LeafIdentifier.VRFNAME.getLeafIndex())) {
            if (appInstance.vrfName() == null || !(vrfName().equals(appInstance.vrfName()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.VRFNAME)) {
                    subTreeFilteringResultBuilder.vrfName(vrfName());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.vrfName(appInstance.vrfName());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.VRFNAME.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.vrfName(appInstance.vrfName());
        }

        if (valueLeafFlags.get(LeafIdentifier.ACLACTIVESTATUS.getLeafIndex())) {
             if (appInstance.aclActiveStatus() == null
                        || !(aclActiveStatus()
            .equals(appInstance.aclActiveStatus()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ACLACTIVESTATUS)) {
                    subTreeFilteringResultBuilder.aclActiveStatus(aclActiveStatus());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.aclActiveStatus(appInstance.aclActiveStatus());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ACLACTIVESTATUS.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.aclActiveStatus(appInstance.aclActiveStatus());
        }

        return true;
    }

    private boolean processChildNodesSubTreeFiltering(AclRuleAdv4 appInstance, AclRuleAdv4Builder
                subTreeFilteringResultBuilder, BitSet isAnySelectOrContainmentNode, boolean
                isSelectAllSchemaChild) {
        return true;
    }


    /**
     * Creates an instance of defaultAclRuleAdv4.
     */
    protected DefaultAclRuleAdv4() {
    }

    /**
     * Returns the attribute aclRuleAdv4Builder.
     *
     * @return aclRuleAdv4Builder
     */
    public static AclRuleAdv4Builder builder() {
        return new AclRuleAdv4Builder();
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
     * Represents the builder implementation of aclRuleAdv4.
     */
    public static class AclRuleAdv4Builder implements AclRuleAdv4.AclRuleAdv4Builder {
        protected String aclRuleName;
        protected long aclRuleId;
        protected AclActionEnum aclAction;
        protected short aclProtocol;
        protected String aclSourceIp;
        protected String aclSrcWild;
        protected String aclDestIp;
        protected String aclDestWild;
        protected String vrfName;
        protected AclActiveStatusEnum aclActiveStatus;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangAclRuleAdv4OpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public String aclRuleName() {
            return aclRuleName;
        }

        @Override
        public long aclRuleId() {
            return aclRuleId;
        }

        @Override
        public AclActionEnum aclAction() {
            return aclAction;
        }

        @Override
        public short aclProtocol() {
            return aclProtocol;
        }

        @Override
        public String aclSourceIp() {
            return aclSourceIp;
        }

        @Override
        public String aclSrcWild() {
            return aclSrcWild;
        }

        @Override
        public String aclDestIp() {
            return aclDestIp;
        }

        @Override
        public String aclDestWild() {
            return aclDestWild;
        }

        @Override
        public String vrfName() {
            return vrfName;
        }

        @Override
        public AclActiveStatusEnum aclActiveStatus() {
            return aclActiveStatus;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangAclRuleAdv4OpType() {
            return yangAclRuleAdv4OpType;
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
        public AclRuleAdv4Builder aclRuleName(String aclRuleName) {
            valueLeafFlags.set(LeafIdentifier.ACLRULENAME.getLeafIndex());
            this.aclRuleName = aclRuleName;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclRuleId(long aclRuleId) {
            valueLeafFlags.set(LeafIdentifier.ACLRULEID.getLeafIndex());
            this.aclRuleId = aclRuleId;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclAction(AclActionEnum aclAction) {
            valueLeafFlags.set(LeafIdentifier.ACLACTION.getLeafIndex());
            this.aclAction = aclAction;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclProtocol(short aclProtocol) {
            valueLeafFlags.set(LeafIdentifier.ACLPROTOCOL.getLeafIndex());
            this.aclProtocol = aclProtocol;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclSourceIp(String aclSourceIp) {
            valueLeafFlags.set(LeafIdentifier.ACLSOURCEIP.getLeafIndex());
            this.aclSourceIp = aclSourceIp;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclSrcWild(String aclSrcWild) {
            valueLeafFlags.set(LeafIdentifier.ACLSRCWILD.getLeafIndex());
            this.aclSrcWild = aclSrcWild;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclDestIp(String aclDestIp) {
            valueLeafFlags.set(LeafIdentifier.ACLDESTIP.getLeafIndex());
            this.aclDestIp = aclDestIp;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclDestWild(String aclDestWild) {
            valueLeafFlags.set(LeafIdentifier.ACLDESTWILD.getLeafIndex());
            this.aclDestWild = aclDestWild;
            return this;
        }

        @Override
        public AclRuleAdv4Builder vrfName(String vrfName) {
            valueLeafFlags.set(LeafIdentifier.VRFNAME.getLeafIndex());
            this.vrfName = vrfName;
            return this;
        }

        @Override
        public AclRuleAdv4Builder aclActiveStatus(AclActiveStatusEnum aclActiveStatus) {
            valueLeafFlags.set(LeafIdentifier.ACLACTIVESTATUS.getLeafIndex());
            this.aclActiveStatus = aclActiveStatus;
            return this;
        }

        @Override
        public AclRuleAdv4Builder yangAclRuleAdv4OpType(OnosYangOpType yangAclRuleAdv4OpType) {
            this.yangAclRuleAdv4OpType = yangAclRuleAdv4OpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public AclRuleAdv4Builder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public AclRuleAdv4Builder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public AclRuleAdv4Builder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public AclRuleAdv4 build() {
            return new DefaultAclRuleAdv4(this);
        }

        /**
         * Builds object of aclRuleAdv4.
         *
         * @return aclRuleAdv4
         */
        public AclRuleAdv4 buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultAclRuleAdv4(this);
        }
        /**
         * Creates an instance of aclRuleAdv4Builder.
         */
        public AclRuleAdv4Builder() {
        }

    }
}
