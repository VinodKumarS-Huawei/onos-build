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

package org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology;

import com.google.common.base.MoreObjects;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopology.OnosYangOpType;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.link.LeafTypeEnum;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.link.StateEnum;

/**
 * Represents the implementation of link.
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
public class DefaultLink implements Link {
    protected DeviceId srcDeviceId;
    protected long srcPortNumber;
    protected DeviceId dstDeviceId;
    protected long dstPortNumber;
    protected LeafTypeEnum leafType;
    protected StateEnum state;
    protected boolean isDurable;
    protected boolean isExpected;
    protected BitSet valueLeafFlags = new BitSet();
    protected OnosYangOpType yangLinkOpType;
    protected boolean isSubTreeFiltered;
    protected BitSet selectLeafFlags = new BitSet();
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();

    @Override
    public DeviceId srcDeviceId() {
        return srcDeviceId;
    }

    @Override
    public long srcPortNumber() {
        return srcPortNumber;
    }

    @Override
    public DeviceId dstDeviceId() {
        return dstDeviceId;
    }

    @Override
    public long dstPortNumber() {
        return dstPortNumber;
    }

    @Override
    public LeafTypeEnum leafType() {
        return leafType;
    }

    @Override
    public StateEnum state() {
        return state;
    }

    @Override
    public boolean isDurable() {
        return isDurable;
    }

    @Override
    public boolean isExpected() {
        return isExpected;
    }

    @Override
    public BitSet valueLeafFlags() {
        return valueLeafFlags;
    }

    @Override
    public OnosYangOpType yangLinkOpType() {
        return yangLinkOpType;
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
        return Objects.hash(srcDeviceId, srcPortNumber, dstDeviceId, dstPortNumber, leafType, state, isDurable,
                    isExpected, valueLeafFlags, yangLinkOpType, isSubTreeFiltered, selectLeafFlags,
                    yangAugmentedInfoMap);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultLink) {
            DefaultLink other = (DefaultLink) obj;
            return
                Objects.equals(srcDeviceId, other.srcDeviceId) &&
                Objects.equals(srcPortNumber, other.srcPortNumber) &&
                Objects.equals(dstDeviceId, other.dstDeviceId) &&
                Objects.equals(dstPortNumber, other.dstPortNumber) &&
                Objects.equals(leafType, other.leafType) &&
                Objects.equals(state, other.state) &&
                Objects.equals(isDurable, other.isDurable) &&
                Objects.equals(isExpected, other.isExpected) &&
                Objects.equals(valueLeafFlags, other.valueLeafFlags) &&
                Objects.equals(yangLinkOpType, other.yangLinkOpType) &&
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
            .add("srcDeviceId", srcDeviceId)
            .add("srcPortNumber", srcPortNumber)
            .add("dstDeviceId", dstDeviceId)
            .add("dstPortNumber", dstPortNumber)
            .add("leafType", leafType)
            .add("state", state)
            .add("isDurable", isDurable)
            .add("isExpected", isExpected)
            .add("valueLeafFlags", valueLeafFlags)
            .add("yangLinkOpType", yangLinkOpType)
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
     * Creates an instance of link.
     *
     * @param builderObject value of builder object of link
     */
    protected DefaultLink(LinkBuilder builderObject) {
        srcDeviceId = builderObject.srcDeviceId();
        srcPortNumber = builderObject.srcPortNumber();
        dstDeviceId = builderObject.dstDeviceId();
        dstPortNumber = builderObject.dstPortNumber();
        leafType = builderObject.leafType();
        state = builderObject.state();
        isDurable = builderObject.isDurable();
        isExpected = builderObject.isExpected();
        valueLeafFlags = builderObject.valueLeafFlags();
        yangLinkOpType = builderObject.yangLinkOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        selectLeafFlags = builderObject.selectLeafFlags();
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
    }

    /**
     * Checks if the passed Link maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public DefaultLink processSubtreeFiltering(Link appInstance, boolean isSelectAllSchemaChild) {
        LinkBuilder subTreeFilteringResultBuilder = new LinkBuilder();
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
        return (DefaultLink) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processLeafSubtreeFiltering(Link appInstance, LinkBuilder subTreeFilteringResultBuilder, BitSet
                isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (valueLeafFlags.get(LeafIdentifier.SRCDEVICEID.getLeafIndex())) {
            if (appInstance.srcDeviceId() == null || !(srcDeviceId().equals(appInstance.srcDeviceId()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.SRCDEVICEID)) {
                    subTreeFilteringResultBuilder.srcDeviceId(srcDeviceId());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.srcDeviceId(appInstance.srcDeviceId());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.SRCDEVICEID.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.srcDeviceId(appInstance.srcDeviceId());
        }

        if (valueLeafFlags.get(LeafIdentifier.SRCPORTNUMBER.getLeafIndex())) {
            if (appInstance.srcPortNumber() != srcPortNumber()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.SRCPORTNUMBER)) {
                    subTreeFilteringResultBuilder.srcPortNumber(srcPortNumber());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.srcPortNumber(appInstance.srcPortNumber());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.SRCPORTNUMBER.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.srcPortNumber(appInstance.srcPortNumber());
        }

        if (valueLeafFlags.get(LeafIdentifier.DSTDEVICEID.getLeafIndex())) {
            if (appInstance.dstDeviceId() == null || !(dstDeviceId().equals(appInstance.dstDeviceId()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.DSTDEVICEID)) {
                    subTreeFilteringResultBuilder.dstDeviceId(dstDeviceId());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.dstDeviceId(appInstance.dstDeviceId());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.DSTDEVICEID.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.dstDeviceId(appInstance.dstDeviceId());
        }

        if (valueLeafFlags.get(LeafIdentifier.DSTPORTNUMBER.getLeafIndex())) {
            if (appInstance.dstPortNumber() != dstPortNumber()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.DSTPORTNUMBER)) {
                    subTreeFilteringResultBuilder.dstPortNumber(dstPortNumber());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.dstPortNumber(appInstance.dstPortNumber());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.DSTPORTNUMBER.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.dstPortNumber(appInstance.dstPortNumber());
        }

        if (valueLeafFlags.get(LeafIdentifier.LEAFTYPE.getLeafIndex())) {
            if (appInstance.leafType() == null || !(leafType().equals(appInstance.leafType()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.LEAFTYPE)) {
                    subTreeFilteringResultBuilder.leafType(leafType());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.leafType(appInstance.leafType());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.LEAFTYPE.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.leafType(appInstance.leafType());
        }

        if (valueLeafFlags.get(LeafIdentifier.STATE.getLeafIndex())) {
            if (appInstance.state() == null || !(state().equals(appInstance.state()))) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.STATE)) {
                    subTreeFilteringResultBuilder.state(state());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.state(appInstance.state());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.STATE.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.state(appInstance.state());
        }

        if (valueLeafFlags.get(LeafIdentifier.ISDURABLE.getLeafIndex())) {
            if (appInstance.isDurable() != isDurable()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ISDURABLE)) {
                    subTreeFilteringResultBuilder.isDurable(isDurable());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.isDurable(appInstance.isDurable());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ISDURABLE.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.isDurable(appInstance.isDurable());
        }

        if (valueLeafFlags.get(LeafIdentifier.ISEXPECTED.getLeafIndex())) {
            if (appInstance.isExpected() != isExpected()) {
                if (isSubTreeFiltered && !appInstance.isLeafValueSet(LeafIdentifier.ISEXPECTED)) {
                    subTreeFilteringResultBuilder.isExpected(isExpected());
                } else {
                    return false;
                }
            } else {
                subTreeFilteringResultBuilder.isExpected(appInstance.isExpected());
            }
        } else if (selectLeafFlags.get(LeafIdentifier.ISEXPECTED.getLeafIndex()) || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            subTreeFilteringResultBuilder.isExpected(appInstance.isExpected());
        }

        return true;
    }

     private boolean processChildNodesSubTreeFiltering(Link appInstance, LinkBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        return true;
    }


    /**
     * Creates an instance of defaultLink.
     */
    protected DefaultLink() {
    }

    /**
     * Returns the attribute linkBuilder.
     *
     * @return linkBuilder
     */
    public static LinkBuilder builder() {
        return new LinkBuilder();
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
     * Represents the builder implementation of link.
     */
    public static class LinkBuilder implements Link.LinkBuilder {
        protected DeviceId srcDeviceId;
        protected long srcPortNumber;
        protected DeviceId dstDeviceId;
        protected long dstPortNumber;
        protected LeafTypeEnum leafType;
        protected StateEnum state;
        protected boolean isDurable;
        protected boolean isExpected;
        protected BitSet valueLeafFlags = new BitSet();
        protected OnosYangOpType yangLinkOpType;
        protected boolean isSubTreeFiltered;
        protected BitSet selectLeafFlags = new BitSet();
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();



        @Override
        public DeviceId srcDeviceId() {
            return srcDeviceId;
        }

        @Override
        public long srcPortNumber() {
            return srcPortNumber;
        }

        @Override
        public DeviceId dstDeviceId() {
            return dstDeviceId;
        }

        @Override
        public long dstPortNumber() {
            return dstPortNumber;
        }

        @Override
        public LeafTypeEnum leafType() {
            return leafType;
        }

        @Override
        public StateEnum state() {
            return state;
        }

        @Override
        public boolean isDurable() {
            return isDurable;
        }

        @Override
        public boolean isExpected() {
            return isExpected;
        }

        @Override
        public BitSet valueLeafFlags() {
            return valueLeafFlags;
        }

        @Override
        public OnosYangOpType yangLinkOpType() {
            return yangLinkOpType;
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
        public LinkBuilder srcDeviceId(DeviceId srcDeviceId) {
            valueLeafFlags.set(LeafIdentifier.SRCDEVICEID.getLeafIndex());
            this.srcDeviceId = srcDeviceId;
            return this;
        }

        @Override
        public LinkBuilder srcPortNumber(long srcPortNumber) {
            valueLeafFlags.set(LeafIdentifier.SRCPORTNUMBER.getLeafIndex());
            this.srcPortNumber = srcPortNumber;
            return this;
        }

        @Override
        public LinkBuilder dstDeviceId(DeviceId dstDeviceId) {
            valueLeafFlags.set(LeafIdentifier.DSTDEVICEID.getLeafIndex());
            this.dstDeviceId = dstDeviceId;
            return this;
        }

        @Override
        public LinkBuilder dstPortNumber(long dstPortNumber) {
            valueLeafFlags.set(LeafIdentifier.DSTPORTNUMBER.getLeafIndex());
            this.dstPortNumber = dstPortNumber;
            return this;
        }

        @Override
        public LinkBuilder leafType(LeafTypeEnum leafType) {
            valueLeafFlags.set(LeafIdentifier.LEAFTYPE.getLeafIndex());
            this.leafType = leafType;
            return this;
        }

        @Override
        public LinkBuilder state(StateEnum state) {
            valueLeafFlags.set(LeafIdentifier.STATE.getLeafIndex());
            this.state = state;
            return this;
        }

        @Override
        public LinkBuilder isDurable(boolean isDurable) {
            valueLeafFlags.set(LeafIdentifier.ISDURABLE.getLeafIndex());
            this.isDurable = isDurable;
            return this;
        }

        @Override
        public LinkBuilder isExpected(boolean isExpected) {
            valueLeafFlags.set(LeafIdentifier.ISEXPECTED.getLeafIndex());
            this.isExpected = isExpected;
            return this;
        }

        @Override
        public LinkBuilder yangLinkOpType(OnosYangOpType yangLinkOpType) {
            this.yangLinkOpType = yangLinkOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public LinkBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public LinkBuilder selectLeaf(LeafIdentifier leaf) {
            selectLeafFlags.set(leaf.getLeafIndex());
            return this;
        }

        @Override
        public LinkBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public Link build() {
            return new DefaultLink(this);
        }

        /**
         * Builds object of link.
         *
         * @return link
         */
        public Link buildForFilter() {
            isSubTreeFiltered = true;
            return new DefaultLink(this);
        }
        /**
         * Creates an instance of linkBuilder.
         */
        public LinkBuilder() {
        }

    }
}
