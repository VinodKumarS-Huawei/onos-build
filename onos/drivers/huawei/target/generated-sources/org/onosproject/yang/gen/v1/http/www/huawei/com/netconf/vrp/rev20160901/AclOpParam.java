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
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.AclGroups;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.DefaultAclGroups;

/**
 * Represents the implementation of acl.
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
public class AclOpParam implements Acl {
    protected OnosYangOpType yangAclOpType;
    protected boolean isSubTreeFiltered;
    protected AclGroups aclGroups;

    @Override
    public OnosYangOpType yangAclOpType() {
        return yangAclOpType;
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
    public AclGroups aclGroups() {
        return aclGroups;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangAclOpType, isSubTreeFiltered, aclGroups);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AclOpParam) {
            AclOpParam other = (AclOpParam) obj;
            return
                Objects.equals(yangAclOpType, other.yangAclOpType) &&
                Objects.equals(isSubTreeFiltered, other.isSubTreeFiltered) &&
                Objects.equals(aclGroups, other.aclGroups);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangAclOpType", yangAclOpType)
            .add("isSubTreeFiltered", isSubTreeFiltered)
            .add("aclGroups", aclGroups)
            .toString();
    }
    /**
     * Creates an instance of acl.
     *
     * @param builderObject value of builder object of acl
     */
    protected AclOpParam(AclBuilder builderObject) {
        yangAclOpType = builderObject.yangAclOpType();
        isSubTreeFiltered = builderObject.isSubTreeFiltered();
        aclGroups = builderObject.aclGroups();
    }

    /**
     * Checks if the passed Acl maps the content match query condition.
     *
     * @param appInstance appInstance being passed to check for content match
     * @param isSelectAllSchemaChild is select all schema child
     * @return match result
     */
    public AclOpParam processSubtreeFiltering(Acl appInstance, boolean isSelectAllSchemaChild) {
        AclBuilder subTreeFilteringResultBuilder = new AclBuilder();
        BitSet isAnySelectOrContainmentNode = new BitSet();
         if (!processChildNodesSubTreeFiltering(appInstance, subTreeFilteringResultBuilder,
                    isAnySelectOrContainmentNode, isSelectAllSchemaChild)) {
            return null;
        }
        if (!isSelectAllSchemaChild && !isAnySelectOrContainmentNode.get(0)) {
            return processSubtreeFiltering(appInstance, true);
        }
        return (AclOpParam) subTreeFilteringResultBuilder.buildForFilter();
    }

     private boolean processChildNodesSubTreeFiltering(Acl appInstance, AclBuilder subTreeFilteringResultBuilder,
                BitSet isAnySelectOrContainmentNode, boolean isSelectAllSchemaChild) {
        if (aclGroups() != null || isSelectAllSchemaChild) {
            isAnySelectOrContainmentNode.set(0);
            if (appInstance.aclGroups() != null) {
                AclGroups result = null;
                if (isSelectAllSchemaChild) {
                    result = ((DefaultAclGroups) DefaultAclGroups.builder()
                            .buildForFilter()).processSubtreeFiltering(appInstance.aclGroups(), true);
                } else {
                    result = ((DefaultAclGroups) aclGroups)
                            .processSubtreeFiltering(appInstance.aclGroups(), false);
                }
                if (result != null) {
                    subTreeFilteringResultBuilder.aclGroups(result);
                }
            } else {
                if (isSubTreeFiltered && aclGroups() != null) {
                    subTreeFilteringResultBuilder.aclGroups(aclGroups);
                }
            }
        }

        return true;
    }

    /**
     * Creates an instance of aclOpParam.
     */
    protected AclOpParam() {
    }

    /**
     * Returns the attribute aclBuilder.
     *
     * @return aclBuilder
     */
    public static AclBuilder builder() {
        return new AclBuilder();
    }

    /**
     * Represents the builder implementation of acl.
     */
    public static class AclBuilder implements Acl.AclBuilder {
        protected OnosYangOpType yangAclOpType;
        protected boolean isSubTreeFiltered;
        protected AclGroups aclGroups;


        @Override
        public OnosYangOpType yangAclOpType() {
            return yangAclOpType;
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
        public AclGroups aclGroups() {
            return aclGroups;
        }

        @Override
        public AclBuilder yangAclOpType(OnosYangOpType yangAclOpType) {
            this.yangAclOpType = yangAclOpType;
            return this;
        }
        /**
         * Returns the builder object of isSubTreeFiltered.
         *
         * @param isSubTreeFiltered value of isSubTreeFiltered
         * @return isSubTreeFiltered
         */
        public AclBuilder isSubTreeFiltered(boolean isSubTreeFiltered) {
            this.isSubTreeFiltered = isSubTreeFiltered;
            return this;
        }

        @Override
        public AclBuilder aclGroups(AclGroups aclGroups) {
            this.aclGroups = aclGroups;
            return this;
        }
        @Override
        public Acl build() {
            return new AclOpParam(this);
        }

        /**
         * Builds object of acl.
         *
         * @return acl
         */
        public Acl buildForFilter() {
            isSubTreeFiltered = true;
            return new AclOpParam(this);
        }
        /**
         * Creates an instance of aclBuilder.
         */
        public AclBuilder() {
        }

    }
}
