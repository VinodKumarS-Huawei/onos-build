/*
 * Copyright 2015-present Open Networking Laboratory
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

import java.util.List;

import org.apache.karaf.shell.commands.Argument;
import org.apache.karaf.shell.commands.Command;
import org.onosproject.cli.AbstractShellCommand;
import org.onosproject.core.CoreService;
import org.onosproject.net.DeviceId;
import org.onosproject.net.driver.DriverHandler;
import org.onosproject.net.driver.DriverService;
import org.onosproject.net.flow.FlowRule;

/**
 * Stops intent performance test run.
 */
@Command(scope = "onos", name = "get-policy",
        description = "Get policy")
public class GetPolicyCommand
        extends AbstractShellCommand {

    private static final String FORMAT =
            "selector=%s, treatment=%s";

    @Argument(index = 0, name = "uri", description = "Device ID",
            required = false, multiValued = false)
    String uri = null;

    private DeviceId deviceId;

    @Override
    protected void execute() {

        CoreService coreService = get(CoreService.class);

        DriverService service = get(DriverService.class);
        deviceId = DeviceId.deviceId(uri);
        DriverHandler h = service.createHandler(deviceId);
        GetFlowConfig flow = h.behaviour(GetFlowConfig.class);

        List<FlowRule> flows = flow.getFlows(DeviceId.deviceId(uri));

        printFlows(DeviceId.deviceId(uri), flows, coreService);
    }

    protected void printFlows(DeviceId d, List<FlowRule> flows,
                              CoreService coreService) {
        boolean empty = flows == null || flows.isEmpty();
        print("deviceId=%s", d);
        for (FlowRule f : flows) {
            print(FORMAT, f.selector().criteria(), f.treatment());
        }
    }
}
