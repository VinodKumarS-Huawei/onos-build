/*
 * Copyright 2016 Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.onosproject.onostopology.management.impl;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.ReferenceCardinality;
import org.apache.felix.scr.annotations.Service;
import org.onosproject.core.ApplicationId;
import org.onosproject.core.CoreService;
import org.onosproject.net.Port;
import org.onosproject.net.device.DeviceService;
import org.onosproject.net.link.LinkService;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopology;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopologyOpParam;
import org.onosproject.yang.gen.v1.ydt.onos.topology.OnosTopologyService;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.ChassisId;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.DefaultDevice;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.DefaultLink;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.Device;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.DeviceId;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.Link;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.DefaultPorts;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.Ports;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.device.TypeEnum;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.link.LeafTypeEnum;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.link.StateEnum;
import org.onosproject.yang.gen.v1.ydt.onos.topology.onostopology.port.PortTypeEnum;
import org.onosproject.yms.ymsm.YmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the topology management service.
 */
@Component(immediate = true)
@Service
public class OnosTopologyManager implements OnosTopologyService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected CoreService coreService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected DeviceService deviceService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected LinkService linkService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY_UNARY)
    protected YmsService ymsService;

    private ApplicationId appId;

    public static final String ONOS_TOPOLOGY = "org.onosproject.onostopology";


    @Activate
    public void activate() {
        appId = coreService.registerApplication(ONOS_TOPOLOGY);
        ymsService.registerService(this, OnosTopologyService.class, null);
        log.info("Started");
    }

    @Deactivate
    public void deactivate() {
        ymsService.unRegisterService(this, OnosTopologyService.class);
        log.info("Stopped");
    }

    @Override
    public OnosTopology getOnosTopology(OnosTopologyOpParam onosTopology) {
        List<Device> ymsDeviceInfo = getDeviceList();
        List<Link> ymsLinkInfo = getLinkInformation();
        OnosTopology topology = OnosTopologyOpParam.builder()
                .device(ymsDeviceInfo)
                .link(ymsLinkInfo).build();
        return onosTopology.processSubtreeFiltering(topology, false);
    }

    @Override
    public void setOnosTopology(OnosTopologyOpParam onosTopology) {

    }

    private List<Device> getDeviceList() {
        List<Device> ymsDeviceList = new LinkedList<>();
        Iterable<org.onosproject.net.Device> deviceList = deviceService.getDevices();
        if (deviceList == null) {
            return null;
        }
        Iterator<org.onosproject.net.Device> deviceIterator = deviceList.iterator();
        while (deviceIterator.hasNext()) {
            org.onosproject.net.Device device = deviceIterator.next();
            Device ymsDevice = DefaultDevice
                    .builder()
                    .id(DeviceId.of(device.id().toString()))
                    .type(TypeEnum.of(device.type().toString().toLowerCase()))
                    .manufacturer(device.manufacturer())
                    .hwVersion(device.hwVersion())
                    .swVersion(device.swVersion())
                    .serialNumber(device.serialNumber())
                    .chassisId(ChassisId.of(device.chassisId().id()))
                    .ports(getPortInformation(device.id()))
                    .build();
            ymsDeviceList.add(ymsDevice);
        }
        return ymsDeviceList;
    }

    private List<Link> getLinkInformation() {
        List<Link> ymsLinkInfo = new LinkedList<>();
        Iterable<org.onosproject.net.Link> linkList = linkService.getLinks();
        if (linkList == null) {
            return null;
        }
        Iterator<org.onosproject.net.Link> linkIterator = linkList.iterator();
        while (linkIterator.hasNext()) {
            org.onosproject.net.Link link = linkIterator.next();
            Link ymsLink = DefaultLink.builder()
                    .isDurable(link.isDurable())
                    .isExpected(link.isExpected())
                    .leafType(LeafTypeEnum.of(link.type().toString().toLowerCase()))
                    .state(StateEnum.of(link.state().toString().toLowerCase()))
                    .srcDeviceId(DeviceId.of(link.src().deviceId().toString()))
                    .srcPortNumber(link.src().port().toLong())
                    .dstDeviceId(DeviceId.of(link.dst().deviceId().toString()))
                    .dstPortNumber(link.dst().port().toLong())
                    .build();
            ymsLinkInfo.add(ymsLink);
        }
        return ymsLinkInfo;
    }

    private List<Ports> getPortInformation(org.onosproject.net.DeviceId
                                                   deviceId) {
        List<Port> ports = deviceService.getPorts(deviceId);
        List<Ports> ymsPorts = new LinkedList<>();
        if (ports != null && !ports.isEmpty()) {
            Iterator<Port> portIterator = ports.iterator();
            while (portIterator.hasNext()) {
                Port port = portIterator.next();
                Ports ymsPort = DefaultPorts.builder()
                        .isEnabled(port.isEnabled())
                        .number(port.number().toLong())
                        .portSpeed(port.portSpeed())
                        .portType(PortTypeEnum.of(port.type().toString().toLowerCase()))
                        .build();
                ymsPorts.add(ymsPort);
            }
        }
        return ymsPorts;
    }
}
