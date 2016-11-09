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

import java.util.BitSet;
import java.util.Map;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Acl.OnosYangOpType;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .aclruleadv4.AclActionEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s
            .aclruleadv4.AclActiveStatusEnum;

/**
 * Abstraction of an entity which represents the functionality of aclRuleAdv4.
 */
public interface AclRuleAdv4 {

    /**
     * Identify the leaf of AclRuleAdv4.
     */
    public enum LeafIdentifier {
        /**
         * Represents aclRuleName.
         */
        ACLRULENAME(1),
        /**
         * Represents aclRuleId.
         */
        ACLRULEID(2),
        /**
         * Represents aclAction.
         */
        ACLACTION(3),
        /**
         * Represents aclProtocol.
         */
        ACLPROTOCOL(4),
        /**
         * Represents aclSourceIp.
         */
        ACLSOURCEIP(5),
        /**
         * Represents aclSrcWild.
         */
        ACLSRCWILD(6),
        /**
         * Represents aclDestIp.
         */
        ACLDESTIP(7),
        /**
         * Represents aclDestWild.
         */
        ACLDESTWILD(8),
        /**
         * Represents vrfName.
         */
        VRFNAME(9),
        /**
         * Represents aclActiveStatus.
         */
        ACLACTIVESTATUS(10);

        private int leafIndex;

        public int getLeafIndex() {
            return leafIndex;
        }

        LeafIdentifier(int value) {
            this.leafIndex = value;
        }
    }

    /**
     * Returns the attribute aclRuleName.
     *
     * @return aclRuleName value of aclRuleName
     */
    String aclRuleName();

    /**
     * Returns the attribute aclRuleId.
     *
     * @return aclRuleId value of aclRuleId
     */
    long aclRuleId();

    /**
     * Returns the attribute aclAction.
     *
     * @return aclAction value of aclAction
     */
    AclActionEnum aclAction();

    /**
     * Returns the attribute aclProtocol.
     *
     * @return aclProtocol value of aclProtocol
     */
    short aclProtocol();

    /**
     * Returns the attribute aclSourceIp.
     *
     * @return aclSourceIp value of aclSourceIp
     */
    String aclSourceIp();

    /**
     * Returns the attribute aclSrcWild.
     *
     * @return aclSrcWild value of aclSrcWild
     */
    String aclSrcWild();

    /**
     * Returns the attribute aclDestIp.
     *
     * @return aclDestIp value of aclDestIp
     */
    String aclDestIp();

    /**
     * Returns the attribute aclDestWild.
     *
     * @return aclDestWild value of aclDestWild
     */
    String aclDestWild();

    /**
     * Returns the attribute vrfName.
     *
     * @return vrfName value of vrfName
     */
    String vrfName();

    /**
     * Returns the attribute aclActiveStatus.
     *
     * @return aclActiveStatus value of aclActiveStatus
     */
    AclActiveStatusEnum aclActiveStatus();

    /**
     * Returns the attribute valueLeafFlags.
     *
     * @return valueLeafFlags value of valueLeafFlags
     */
    BitSet valueLeafFlags();

    /**
     * Returns the attribute yangAclRuleAdv4OpType.
     *
     * @return yangAclRuleAdv4OpType value of yangAclRuleAdv4OpType
     */
    OnosYangOpType yangAclRuleAdv4OpType();

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
     * Builder for aclRuleAdv4.
     */
    interface AclRuleAdv4Builder {
        /**
         * Returns the attribute aclRuleName.
         *
         * @return aclRuleName value of aclRuleName
         */
        String aclRuleName();

        /**
         * Returns the attribute aclRuleId.
         *
         * @return aclRuleId value of aclRuleId
         */
        long aclRuleId();

        /**
         * Returns the attribute aclAction.
         *
         * @return aclAction value of aclAction
         */
        AclActionEnum aclAction();

        /**
         * Returns the attribute aclProtocol.
         *
         * @return aclProtocol value of aclProtocol
         */
        short aclProtocol();

        /**
         * Returns the attribute aclSourceIp.
         *
         * @return aclSourceIp value of aclSourceIp
         */
        String aclSourceIp();

        /**
         * Returns the attribute aclSrcWild.
         *
         * @return aclSrcWild value of aclSrcWild
         */
        String aclSrcWild();

        /**
         * Returns the attribute aclDestIp.
         *
         * @return aclDestIp value of aclDestIp
         */
        String aclDestIp();

        /**
         * Returns the attribute aclDestWild.
         *
         * @return aclDestWild value of aclDestWild
         */
        String aclDestWild();

        /**
         * Returns the attribute vrfName.
         *
         * @return vrfName value of vrfName
         */
        String vrfName();

        /**
         * Returns the attribute aclActiveStatus.
         *
         * @return aclActiveStatus value of aclActiveStatus
         */
        AclActiveStatusEnum aclActiveStatus();

        /**
         * Returns the attribute valueLeafFlags.
         *
         * @return valueLeafFlags value of valueLeafFlags
         */
        BitSet valueLeafFlags();

        /**
         * Returns the attribute yangAclRuleAdv4OpType.
         *
         * @return yangAclRuleAdv4OpType value of yangAclRuleAdv4OpType
         */
        OnosYangOpType yangAclRuleAdv4OpType();

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
         * Returns the builder object of aclRuleName.
         *
         * @param aclRuleName value of aclRuleName
         * @return aclRuleName
         */
        AclRuleAdv4Builder aclRuleName(String aclRuleName);

        /**
         * Returns the builder object of aclRuleId.
         *
         * @param aclRuleId value of aclRuleId
         * @return aclRuleId
         */
        AclRuleAdv4Builder aclRuleId(long aclRuleId);

        /**
         * Returns the builder object of aclAction.
         *
         * @param aclAction value of aclAction
         * @return aclAction
         */
        AclRuleAdv4Builder aclAction(AclActionEnum aclAction);

        /**
         * Returns the builder object of aclProtocol.
         *
         * @param aclProtocol value of aclProtocol
         * @return aclProtocol
         */
        AclRuleAdv4Builder aclProtocol(short aclProtocol);

        /**
         * Returns the builder object of aclSourceIp.
         *
         * @param aclSourceIp value of aclSourceIp
         * @return aclSourceIp
         */
        AclRuleAdv4Builder aclSourceIp(String aclSourceIp);

        /**
         * Returns the builder object of aclSrcWild.
         *
         * @param aclSrcWild value of aclSrcWild
         * @return aclSrcWild
         */
        AclRuleAdv4Builder aclSrcWild(String aclSrcWild);

        /**
         * Returns the builder object of aclDestIp.
         *
         * @param aclDestIp value of aclDestIp
         * @return aclDestIp
         */
        AclRuleAdv4Builder aclDestIp(String aclDestIp);

        /**
         * Returns the builder object of aclDestWild.
         *
         * @param aclDestWild value of aclDestWild
         * @return aclDestWild
         */
        AclRuleAdv4Builder aclDestWild(String aclDestWild);

        /**
         * Returns the builder object of vrfName.
         *
         * @param vrfName value of vrfName
         * @return vrfName
         */
        AclRuleAdv4Builder vrfName(String vrfName);

        /**
         * Returns the builder object of aclActiveStatus.
         *
         * @param aclActiveStatus value of aclActiveStatus
         * @return aclActiveStatus
         */
        AclRuleAdv4Builder aclActiveStatus(AclActiveStatusEnum aclActiveStatus);

        /**
         * Returns the builder object of yangAclRuleAdv4OpType.
         *
         * @param yangAclRuleAdv4OpType value of yangAclRuleAdv4OpType
         * @return yangAclRuleAdv4OpType
         */
        AclRuleAdv4Builder yangAclRuleAdv4OpType(OnosYangOpType yangAclRuleAdv4OpType);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         AclRuleAdv4Builder addYangAugmentedInfo(Object value, Class classObject);

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
        AclRuleAdv4Builder selectLeaf(LeafIdentifier leaf);

        /**
         * Builds object of aclRuleAdv4.
         *
         * @return aclRuleAdv4
         */
        AclRuleAdv4 build();
    }
}
