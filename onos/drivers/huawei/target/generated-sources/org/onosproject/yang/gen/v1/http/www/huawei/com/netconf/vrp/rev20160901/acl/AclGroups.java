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

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Acl.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.AclGroup;

/**
 * Abstraction of an entity which represents the functionality of aclGroups.
 */
public interface AclGroups {

    /**
     * Returns the attribute yangAclGroupsOpType.
     *
     * @return yangAclGroupsOpType value of yangAclGroupsOpType
     */
    OnosYangOpType yangAclGroupsOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute aclGroup.
     *
     * @return aclGroup list of aclGroup
     */
    List<AclGroup> aclGroup();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for aclGroups.
     */
    interface AclGroupsBuilder {
        /**
         * Adds to the list of aclGroup.
         *
         * @param addTo value of aclGroup
         * @return builder object of aclGroup
         */
         AclGroupsBuilder addToAclGroup(AclGroup addTo);

        /**
         * Returns the attribute yangAclGroupsOpType.
         *
         * @return yangAclGroupsOpType value of yangAclGroupsOpType
         */
        OnosYangOpType yangAclGroupsOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute aclGroup.
         *
         * @return aclGroup list of aclGroup
         */
        List<AclGroup> aclGroup();

        /**
         * Returns the builder object of yangAclGroupsOpType.
         *
         * @param yangAclGroupsOpType value of yangAclGroupsOpType
         * @return yangAclGroupsOpType
         */
        AclGroupsBuilder yangAclGroupsOpType(OnosYangOpType yangAclGroupsOpType);

        /**
         * Returns the builder object of aclGroup.
         *
         * @param aclGroup list of aclGroup
         * @return aclGroup
         */
        AclGroupsBuilder aclGroup(List<AclGroup> aclGroup);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         AclGroupsBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of aclGroups.
         *
         * @return aclGroups
         */
        AclGroups build();
    }
}
