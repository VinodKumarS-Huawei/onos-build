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

package org.onosproject.drivers.huawei;

import org.onlab.packet.IpAddress;
import org.onlab.packet.IpPrefix;
import org.onosproject.net.flow.FlowRule;
import org.onosproject.net.flow.criteria.Criterion;
import org.onosproject.net.flow.criteria.IPCriterion;
import org.onosproject.net.flow.criteria.IPProtocolCriterion;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.Acl;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.AclOpParam;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.DefaultAclGroups;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.DefaultAclGroups.AclGroupsBuilder;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.AclGroup;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.DefaultAclGroup;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.DefaultAclRuleAdv4s;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.DefaultAclRuleAdv4s.AclRuleAdv4sBuilder;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s.AclRuleAdv4;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s.DefaultAclRuleAdv4;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s.aclruleadv4.AclActionEnum;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.acl.aclgroups.aclgroup.aclruleadv4s.aclruleadv4.AclActiveStatusEnum;
import org.onosproject.yms.ych.YangCodecHandler;
import org.onosproject.yms.ych.YangProtocolEncodingFormat;
import org.onosproject.yms.ydt.YmsOperationType;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.onosproject.drivers.huawei.FlowConfigHuawei.yangCodecHandler;
import static org.onosproject.drivers.huawei.Utils.editConfig;
import static org.onosproject.drivers.huawei.Utils.getConfig;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Represents ACL generator, which generates ACL object for a given flow rule
 * and call YMS to obtain XML string.
 */
public final class AclGenerator {

    private static final Logger log = getLogger(AclGenerator.class);

    private static final String ruleName = "rule";
    private static final String aclGroup = "aclgroup";

    /**
     * Creates an instance of ACL generator.
     */
    private AclGenerator() {
    }

    /**
     * Returns acl, by building ACL object corresponding to a flow rule and then
     * build xml using YMS.
     *
     * @param rule             input flow rule
     * @param aclID            input ACL id
     * @param yangCodecHandler YANG codec handler
     * @return built XML string corresponding to flow rule
     */
    protected static String getAclStringForSetOp(FlowRule rule, int aclID,
                                                 YangCodecHandler
                                                         yangCodecHandler) {

        IpPrefix ip4PrefixSrc = null;
        IpPrefix ip4PrefixDst = null;

        // TODO check if toString is required for string
        String aclRuleName = ruleName.toString().concat(Long.toString(1));

        // Build instance of list aclRuleAdv4
        AclRuleAdv4.AclRuleAdv4Builder aclRuleAdv4Builder =
                DefaultAclRuleAdv4.builder();
        aclRuleAdv4Builder.yangAclRuleAdv4OpType(Acl.OnosYangOpType.CREATE);

//        aclRuleAdv4Builder.onosYangNodeOperationType(
//                DefaultAclRuleAdv4.OnosYangNodeOperationType.CREATE);
        aclRuleAdv4Builder.aclRuleName(aclRuleName);
        aclRuleAdv4Builder.aclRuleId(1);
        aclRuleAdv4Builder.aclAction(AclActionEnum.PERMIT);

        /*
         * Check for the set of criteria type of flow rule and accordingly add
         * the same.
         * TODO understand the same.
         */
        for (Criterion c : rule.selector().criteria()) {
            switch (c.type()) {

                case IP_PROTO:
                    IPProtocolCriterion ipProtocolCriterion =
                            (IPProtocolCriterion) c;

                    aclRuleAdv4Builder
                            .aclProtocol(ipProtocolCriterion.protocol());
                    break;

                case IPV4_SRC:
                    IPCriterion ipCriterion = (IPCriterion) c;
                    ip4PrefixSrc = ipCriterion.ip().getIp4Prefix();
                    aclRuleAdv4Builder
                            .aclSourceIp(ip4PrefixSrc.address().toString());

                    IpAddress ipAddress;

                    //TODO
                    ipAddress = IpAddress.makeMaskPrefix(IpAddress.Version.INET,
                                                         ip4PrefixSrc
                                                                 .prefixLength());
                    ipAddress = IpAddress.valueOf("0.0.0.0");
                    aclRuleAdv4Builder.aclSrcWild(ipAddress.toString());
                    break;

                case IPV4_DST:
                    ipCriterion = (IPCriterion) c;
                    ip4PrefixDst = ipCriterion.ip().getIp4Prefix();
                    aclRuleAdv4Builder
                            .aclDestIp(ip4PrefixDst.address().toString());

                    //TODO
                    ipAddress = IpAddress.makeMaskPrefix(IpAddress.Version.INET,
                                                         ip4PrefixDst
                                                                 .prefixLength());
                    ipAddress = IpAddress.valueOf("0.0.0.0");
                    aclRuleAdv4Builder.aclDestWild(ipAddress.toString());

                    break;
                default:
                    break;
            }
        }

        aclRuleAdv4Builder.vrfName("_public_");
        aclRuleAdv4Builder.aclActiveStatus(AclActiveStatusEnum.ACTIVE);

        // Create a list of ACL rule and add the built acl rule.
        List<AclRuleAdv4> lstAclRuleAdv4 = new ArrayList<AclRuleAdv4>();
        lstAclRuleAdv4.add(aclRuleAdv4Builder.build());

        // Build a container and add built ACL list to it
        AclRuleAdv4sBuilder aclRuleAdv4sBuilder = DefaultAclRuleAdv4s.builder();
        aclRuleAdv4sBuilder.aclRuleAdv4(lstAclRuleAdv4);

        // Build an instance of ACL group list
        DefaultAclGroup.AclGroupBuilder aclGroupBuilder = new DefaultAclGroup
                .AclGroupBuilder();
        aclGroupBuilder.aclNumOrName(String.valueOf(aclID));

        // Set build ACL rules to ACL group list
        aclGroupBuilder.aclRuleAdv4s(aclRuleAdv4sBuilder.build());

        // Create a list and ACL group and add the built acl group.
        List<AclGroup> lstAclGroup = new ArrayList<AclGroup>();
        lstAclGroup.add(aclGroupBuilder.build());

        // Build ACL groups container and add built acl group to it
        AclGroupsBuilder aclGroupsBuilder = DefaultAclGroups.builder();
        aclGroupsBuilder.aclGroup(lstAclGroup);

        // Build module ACL and add built ACL groups to it.
        AclOpParam.AclBuilder aclBuilder = AclOpParam.builder();
        aclBuilder.aclGroups(aclGroupsBuilder.build());

        /*
         * Creating object list for input to codec handler and add build ACL to
         * it.
         */
        List<Object> objectList = new LinkedList<>();
        objectList.add(aclBuilder.build());

        // Use YMS to encode the built object to XML string
        String config = yangCodecHandler
                .encodeOperation("config", null, null, objectList,
                                 YangProtocolEncodingFormat.XML,
                                 YmsOperationType.EDIT_CONFIG_REQUEST);

        config = editConfig(config);
        log.info("getAclStringForSetOp send dataschema : {} ", config);
        return config;
    }

    /**
     * Returns acl, by building ACL object corresponding to a flow rule and then
     * build xml using YMS.
     *
     * @param aclId input ACL id
     * @return built XML string corresponding to flow rule
     */
    protected static String getAclStringForGetOp(int aclId) {
        AclRuleAdv4.AclRuleAdv4Builder aclRuleAdv4Builder =
                DefaultAclRuleAdv4.builder();
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLRULENAME);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLRULEID);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLACTION);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLPROTOCOL);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLSOURCEIP);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLSRCWILD);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLDESTIP);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.ACLDESTWILD);
        aclRuleAdv4Builder.selectLeaf(AclRuleAdv4.LeafIdentifier.VRFNAME);
        aclRuleAdv4Builder
                .selectLeaf(AclRuleAdv4.LeafIdentifier.ACLACTIVESTATUS);

        // Create a list of ACL rule and add the built acl rule.
        List<AclRuleAdv4> lstAclRuleAdv4 = new ArrayList<AclRuleAdv4>();
        lstAclRuleAdv4.add(aclRuleAdv4Builder.build());

        // Build a container and add built ACL list to it
        AclRuleAdv4sBuilder aclRuleAdv4sBuilder = DefaultAclRuleAdv4s.builder();
        aclRuleAdv4sBuilder.aclRuleAdv4(lstAclRuleAdv4);

        // Build an instance of ACL group list
        DefaultAclGroup.AclGroupBuilder aclGroupBuilder = new DefaultAclGroup
                .AclGroupBuilder();
        aclGroupBuilder.aclNumOrName(String.valueOf(aclId));

        // Set build ACL rules to ACL group list
        aclGroupBuilder.aclRuleAdv4s(aclRuleAdv4sBuilder.build());

        // Create a list and ACL group and add the built acl group.
        List<AclGroup> lstAclGroup = new ArrayList<AclGroup>();
        lstAclGroup.add(aclGroupBuilder.build());

        // Build ACL groups container and add built acl group to it
        AclGroupsBuilder aclGroupsBuilder = DefaultAclGroups.builder();
        aclGroupsBuilder.aclGroup(lstAclGroup);


        // Build module ACL and add built ACL groups to it.
        AclOpParam.AclBuilder aclBuilder = AclOpParam.builder();
        aclBuilder.aclGroups(aclGroupsBuilder.build());

        /*
         * Creating object list for input to codec handler and add build ACL to
         * it.
         */
        List<Object> objectList = new LinkedList<>();
        objectList.add(aclBuilder.build());

        Map<String, String> tagAttributeLinkedMap = new HashMap<>();

        tagAttributeLinkedMap.put("type", "subtree");

        // Use YMS to encode the built object to XML string
        String config = yangCodecHandler
                .encodeOperation("filter", null, tagAttributeLinkedMap,
                                 objectList,
                                 YangProtocolEncodingFormat.XML,
                                 YmsOperationType.QUERY_CONFIG_REQUEST);

        config = getConfig(config);
        log.info("getAclStringForSetOp send dataschema : {} ", config);
        return config;
    }

}
