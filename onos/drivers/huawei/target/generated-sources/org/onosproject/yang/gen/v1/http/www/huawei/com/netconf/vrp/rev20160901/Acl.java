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

import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.AclGroups;

/**
 * Abstraction of an entity which represents the functionality of acl.
 */
public interface Acl {
    /**
     * Specify the node specific operation in protocols like NETCONF.
     * Applicable in protocol edit operation, not applicable in query operation
     */
    public static enum OnosYangOpType {
        MERGE,
        REPLACE,
        CREATE,
        DELETE,
        REMOVE,
        NONE
    }

    /**
     * Returns the attribute yangAclOpType.
     *
     * @return yangAclOpType value of yangAclOpType
     */
    OnosYangOpType yangAclOpType();

    /**
     * Returns the attribute aclGroups.
     *
     * @return aclGroups value of aclGroups
     */
    AclGroups aclGroups();


    /**
     * Builder for acl.
     */
    interface AclBuilder {
        /**
         * Returns the attribute yangAclOpType.
         *
         * @return yangAclOpType value of yangAclOpType
         */
        OnosYangOpType yangAclOpType();

        /**
         * Returns the attribute aclGroups.
         *
         * @return aclGroups value of aclGroups
         */
        AclGroups aclGroups();

        /**
         * Returns the builder object of yangAclOpType.
         *
         * @param yangAclOpType value of yangAclOpType
         * @return yangAclOpType
         */
        AclBuilder yangAclOpType(OnosYangOpType yangAclOpType);

        /**
         * Returns the builder object of aclGroups.
         *
         * @param aclGroups value of aclGroups
         * @return aclGroups
         */
        AclBuilder aclGroups(AclGroups aclGroups);

        /**
         * Builds object of acl.
         *
         * @return acl
         */
        Acl build();
    }
}
