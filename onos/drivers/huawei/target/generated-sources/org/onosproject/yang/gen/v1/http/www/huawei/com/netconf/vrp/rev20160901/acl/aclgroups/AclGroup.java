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

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Acl.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.AclRuleAdv4s;

/**
 * Abstraction of an entity which represents the functionality of aclGroup.
 */
public interface AclGroup {

    /**
     * Identify the leaf of AclGroup.
     */
    public enum LeafIdentifier {
        /**
         * Represents aclNumOrName.
         */
        ACLNUMORNAME(1);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute aclNumOrName.
     *
     * @return aclNumOrName value of aclNumOrName
     */
    String aclNumOrName();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangAclGroupOpType.
     *
     * @return yangAclGroupOpType value of yangAclGroupOpType
     */
    OnosYangOpType yangAclGroupOpType();

    /**
     * Returns the attribute selectLeafFlags.
     *
     * @return selectLeafFlags value of selectLeafFlags
     */
    BitSet selectLeafFlags();

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute aclRuleAdv4s.
     *
     * @return aclRuleAdv4s value of aclRuleAdv4s
     */
    AclRuleAdv4s aclRuleAdv4s();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Checks if the leaf value is set.
     *
     * @param leaf leaf whose value status needs to checked
     * @return result of leaf value set in object
     */
    boolean isLeafValueSet(LeafIdentifier leaf);

    /**
     * Checks if the leaf is set to be a selected leaf.
     *
     * @param leaf if leaf needs to be selected
     * @return result of leaf value set in object
     */
    boolean isSelectLeaf(LeafIdentifier leaf);

    /**
     * Builder for aclGroup.
     */
    interface AclGroupBuilder {
        /**
         * Returns the attribute aclNumOrName.
         *
         * @return aclNumOrName value of aclNumOrName
         */
        String aclNumOrName();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangAclGroupOpType.
         *
         * @return yangAclGroupOpType value of yangAclGroupOpType
         */
        OnosYangOpType yangAclGroupOpType();

        /**
         * Returns the attribute selectLeafFlags.
         *
         * @return selectLeafFlags value of selectLeafFlags
         */
        BitSet selectLeafFlags();

        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute aclRuleAdv4s.
         *
         * @return aclRuleAdv4s value of aclRuleAdv4s
         */
        AclRuleAdv4s aclRuleAdv4s();

        /**
         * Returns the builder object of aclNumOrName.
         *
         * @param aclNumOrName value of aclNumOrName
         * @return aclNumOrName
         */
        AclGroupBuilder aclNumOrName(String aclNumOrName);

        /**
         * Returns the builder object of yangAclGroupOpType.
         *
         * @param yangAclGroupOpType value of yangAclGroupOpType
         * @return yangAclGroupOpType
         */
        AclGroupBuilder yangAclGroupOpType(OnosYangOpType yangAclGroupOpType);

        /**
         * Returns the builder object of aclRuleAdv4s.
         *
         * @param aclRuleAdv4s value of aclRuleAdv4s
         * @return aclRuleAdv4s
         */
        AclGroupBuilder aclRuleAdv4s(AclRuleAdv4s aclRuleAdv4s);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         AclGroupBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Set a leaf to be selected.
         *
         * @param leaf leaf needs to be selected
         * @return builder object for select leaf
         */
        AclGroupBuilder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of aclGroup.
         *
         * @return aclGroup
         */
        AclGroup build();
    }
}
