/*
 *
 *  * Copyright 2016-present Open Networking Laboratory
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.onosproject.drivers.huawei;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.Service;
import org.onosproject.core.CoreService;
import org.onosproject.core.IdGenerator;
import org.onosproject.net.DeviceId;
import org.onosproject.net.device.DeviceService;
import org.onosproject.net.driver.AbstractHandlerBehaviour;
import org.onosproject.net.flow.FlowEntry;
import org.onosproject.net.flow.FlowRule;
import org.onosproject.net.flow.FlowRuleProgrammable;
import org.onosproject.net.flow.criteria.Criterion;
import org.onosproject.net.flow.instructions.Instruction;
import org.onosproject.net.flow.instructions.Instructions;
import org.onosproject.net.link.LinkService;
import org.onosproject.netconf.NetconfController;
import org.onosproject.netconf.NetconfException;
import org.onosproject.netconf.NetconfSession;
import org.onosproject.store.serializers.KryoNamespaces;
import org.onosproject.store.service.DistributedSet;
import org.onosproject.store.service.Serializer;
import org.onosproject.store.service.StorageService;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.AclOpParam;
import org.onosproject.yang.gen.v1.http.www.huawei.com.netconf.vrp.rev20160901.QosOpParam;
import org.onosproject.yms.ych.YangCodecHandler;
import org.onosproject.yms.ymsm.YmsService;
import org.slf4j.Logger;

import com.google.common.collect.Lists;

import static org.slf4j.LoggerFactory.getLogger;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents implementation of flow rules on huawei devices in form of PBR.
 * Flow config huawei driver converts the flow rule to PBR including the acl
 * number, classifier matching acl, behavior for action, policy matching
 * classifier and behavior. It apply the same to the desired interface.
 */

@Component(immediate = true)
@Service
public class FlowConfigHuawei
        extends AbstractHandlerBehaviour
        implements FlowRuleProgrammable {

    private final Logger log = getLogger(getClass());

    // Id generation attribute, auto generated acl id is fetched using this.
    private static IdGenerator aclIdGen;

    // Free list of ACL id.
    protected static DistributedSet<Short> aclIdFreeList;

    // Constants
    private static final String classifierName = "classifier";
    private static final String behaviorName = "behavior";
    private static final String ACL_ID_GEN = "acl-id";
    public static final String LSRID = "lsrId";

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected CoreService coreService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected StorageService storageService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected LinkService linkService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected DeviceService deviceService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected YmsService ymsService;

    static LinkService likSer;
    static DeviceService devSer;

    // YANG CODEC handler
    protected static YangCodecHandler yangCodecHandler;

    @Activate
    public void activate() {

        // ACL ID generator and free list initialization
        aclIdGen = coreService.getIdGenerator(ACL_ID_GEN);
        aclIdFreeList = storageService.<Short>setBuilder()
                .withName("huaweiPolicyIdDeletedList")
                .withSerializer(Serializer.using(KryoNamespaces.API))
                .build()
                .asDistributedSet();

        // Advanced acl addition to free list
        for (int i = 3001; i < 3040; i++) {
            aclIdFreeList.add((short) i);
        }

        likSer = linkService;
        devSer = deviceService;

        // Obtain YANG CODEC handler
        yangCodecHandler = ymsService.getYangCodecHandler();

        /* Registers device schema with YANG codec handler with input as the
         * YANG utils generated module class.
         */
        yangCodecHandler.addDeviceSchema(AclOpParam.class);
        yangCodecHandler.addDeviceSchema(QosOpParam.class);
    }

    @Deactivate
    public void deactivate() {
        log.info("Stopped");
    }

    /**
     * Returns the next available ACL ID.
     *
     * @return ACL ID
     */
    private short getNextaclId() {

        // If there is any free id use it. Otherwise generate new id.
        // TODO Looks like ACL ID free list is sufficient
        if (aclIdFreeList.isEmpty()) {
            return (short) aclIdGen.getNewId();
        }
        Iterator<Short> it = aclIdFreeList.iterator();
        Short value = it.next();
        aclIdFreeList.remove(value);
        return value;
    }

    @Override
    public Collection<FlowEntry> getFlowEntries() {

        Collection<FlowEntry> entries = Lists.newLinkedList();

        /* Need to go through all the devices and update the code TODO */
        DeviceId deviceId = handler().data().deviceId();

        NetconfController controller = checkNotNull(handler()
                                                            .get(NetconfController.class));

        NetconfSession session = controller.getDevicesMap().get(handler()
                                                                        .data()
                                                                        .deviceId())
                .getSession();
        return entries;
    }

    public Collection<FlowEntry> getFlowEntriesDevice(DeviceId deviceId) {

        Collection<FlowEntry> entries = Lists.newLinkedList();

        /* entries.addAll(
                getFlows(deviceId).stream()
                        .map(fr -> new DefaultFlowEntry(fr, FlowEntry.FlowEntryState.ADDED, 0, 0, 0))
                        .collect(Collectors.toList())
        );*/
        return entries;
    }

    /*
    /*
     * Apply flow rule invoked by flow rule manager to apply flow rules.
     * Huawei driver registers implements FlowRuleProgrammable, flow rule
     * manager calls it as a part of fallback provider.
     */

    @Override
    public Collection<FlowRule> applyFlowRules(Collection<FlowRule> rules) {

        /*
         * Get device id to which these flow rules are to be applied, apply
         * flow rule request is per device.
         */
        DeviceId deviceId = handler().data().deviceId();

        /*
         * List to maintain successful processed flow rule, this is a return
         * parameter of apply flow rules.
         */
        List<FlowRule> processedFlowRules = Lists.newArrayList();

        /*
         * Some default flows are send to NETCONF added devices, these flows
         * needn't be processed by huawei driver.
         */
        boolean isDefaultFlow = true;

        /*
         * Rul through the list of flows to be applied, it contains user
         * defined flows as well as flows sent by controller implicitly.
         */
        for (FlowRule rule : rules) {

            FlowIdCache cache2 = this.handler().get(FlowIdCache.class);
            Pair<Integer, Integer> lookup = cache2.get(rule.id().toString());
            if (lookup != null) {
                continue;
            }

            /*
             * Criteria for user defined flows is matching IPv4 address for
             * source/destination.
             */
            for (Criterion c : rule.selector().criteria()) {
                switch (c.type()) {
                    case IPV4_SRC:
                        isDefaultFlow = false;
                        break;
                    case IPV4_DST:
                        isDefaultFlow = false;
                        break;
                    default:
                        break;
                }
            }

            // If it's default flow, not required to be processed.
            if (isDefaultFlow) {
                continue;
            }

            // Get available ACL id.
            int aclID = getNextaclId();

            /*
             * Classifier name will be string classifier prepended to acl
             * number.
             */
            String flowClassifierName =
                    classifierName.toString().concat(Long.toString(aclID));

            /*
             * Behavior name will be string behavior prepended to acl
             * number.
             */
            String flowBehaviorName =
                    behaviorName.toString().concat(Long.toString(aclID));

            // Obtain NETCONF controller
            NetconfController controller = checkNotNull(handler()
                                                                .get(NetconfController.class));

            // Obtain NETCONF session for device
            NetconfSession session =
                    controller.getDevicesMap().get(deviceId).getSession();

            // Reply from device
            String reply;

            /*
             * Build ACL, classifier, behavior, policy corresponding to flow
             * rule and apply to the device.
             */
            try {
                reply = session.requestSync(
                        AclGenerator.getAclStringForSetOp(rule, aclID,
                                                          yangCodecHandler));
            } catch (NetconfException e) {
                log.error("Failed to configure acl.", e);
            }
            try {
                reply = session.requestSync(
                        BehaviorGenerator
                                .getBehaviorStringForSetOp(flowBehaviorName, rule,
                                                           devSer,
                                                           likSer,
                                                           yangCodecHandler));
            } catch (NetconfException e) {
                log.error("Failed to configure behavior.", e);
            }
            try {
                reply = session.requestSync(
                        ClassifierGenerator.getClassifierStringForSetOp(aclID,
                                                                        flowClassifierName));
            } catch (NetconfException e) {
                log.error("Failed to configure classifier.", e);
            }
            try {
                reply = session.requestSync(
                        PolicyGenerator.getPolicyStringForSetOp(rule, aclID,
                                                                flowClassifierName,
                                                                flowBehaviorName));
            } catch (NetconfException e) {
                log.error("Failed to configure policy.", e);
            }
            try {
                reply = session.requestSync(
                        InterfacePolicyConfigGenerator
                                .getInterfacePolicyForSetOp(rule, deviceId));
            } catch (NetconfException e) {
                log.error("Failed to apply policy.", e);
            }

            for (Instruction i : rule.treatment().immediate()) {
                switch (i.type()) {
                    case OUTPUT:
                        Instructions.OutputInstruction out =
                                (Instructions.OutputInstruction) i;

                        /*
                         * Add object to the flow ID cache.
                         */
                        FlowIdCache cache =
                                this.handler().get(FlowIdCache.class);
                        cache.set(rule.id().toString(),
                                  (int) out.port().toLong(),
                                  aclID);
                        break;

                    default:
                        break;
                }
            }


            processedFlowRules.add(rule);
        }

        return processedFlowRules;
    }

    @Override
    public Collection<FlowRule> removeFlowRules(Collection<FlowRule> rules) {


        DeviceId deviceId = handler().data().deviceId();
        List<FlowRule> removedRules = Lists.newArrayList();
        FlowIdCache cache = this.handler().get(FlowIdCache.class);

        for (FlowRule rule : rules) {

            int hash = Objects.hash(data().deviceId(),
                                    rule.selector(), rule.treatment());
            Pair<Integer, Integer> lookup = cache.get(rule.id().toString());
            if (lookup == null) {
                continue;
            }

            String flowClassifierName = classifierName.toString().concat(
                    Long.toString(lookup.getRight().intValue()));

            String flowBehaviorName = behaviorName.toString().concat(
                    Long.toString(lookup.getRight().intValue()));

            log.error("Rule details {} on device {}, policyname {} " +
                              "flowClassifierName {} flowBehaviorName {} ID {}",
                      rule.priority(), deviceId, rule.id(),
                      flowClassifierName, flowBehaviorName,
                      lookup.getRight().intValue());

            aclIdFreeList.add(lookup.getRight().shortValue());
            cache.remove(rule.id().toString());

            removedRules.add(rule);
        }

        return removedRules;
    }
}

