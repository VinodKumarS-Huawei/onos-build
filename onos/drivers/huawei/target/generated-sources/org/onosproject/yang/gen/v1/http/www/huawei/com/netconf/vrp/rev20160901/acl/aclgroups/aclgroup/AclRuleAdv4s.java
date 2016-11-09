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

import java.util.List;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Acl.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .AclRuleAdv4;

/**
 * Abstraction of an entity which represents the functionality of aclRuleAdv4s.
 */
public interface AclRuleAdv4s {

    /**
     * Returns the attribute yangAclRuleAdv4sOpType.
     *
     * @return yangAclRuleAdv4sOpType value of yangAclRuleAdv4sOpType
     */
    OnosYangOpType yangAclRuleAdv4sOpType();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute aclRuleAdv4.
     *
     * @return aclRuleAdv4 list of aclRuleAdv4
     */
    List<AclRuleAdv4> aclRuleAdv4();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for aclRuleAdv4s.
     */
    interface AclRuleAdv4sBuilder {
        /**
         * Adds to the list of aclRuleAdv4.
         *
         * @param addTo value of aclRuleAdv4
         * @return builder object of aclRuleAdv4
         */
         AclRuleAdv4sBuilder addToAclRuleAdv4(AclRuleAdv4 addTo);

        /**
         * Returns the attribute yangAclRuleAdv4sOpType.
         *
         * @return yangAclRuleAdv4sOpType value of yangAclRuleAdv4sOpType
         */
        OnosYangOpType yangAclRuleAdv4sOpType();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute aclRuleAdv4.
         *
         * @return aclRuleAdv4 list of aclRuleAdv4
         */
        List<AclRuleAdv4> aclRuleAdv4();

        /**
         * Returns the builder object of yangAclRuleAdv4sOpType.
         *
         * @param yangAclRuleAdv4sOpType value of yangAclRuleAdv4sOpType
         * @return yangAclRuleAdv4sOpType
         */
        AclRuleAdv4sBuilder yangAclRuleAdv4sOpType(OnosYangOpType yangAclRuleAdv4sOpType);

        /**
         * Returns the builder object of aclRuleAdv4.
         *
         * @param aclRuleAdv4 list of aclRuleAdv4
         * @return aclRuleAdv4
         */
        AclRuleAdv4sBuilder aclRuleAdv4(List<AclRuleAdv4> aclRuleAdv4);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         AclRuleAdv4sBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of aclRuleAdv4s.
         *
         * @return aclRuleAdv4s
         */
        AclRuleAdv4s build();
    }
}
