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

package org.onosproject.yang.gen.v1.ydt.onos.topology;

/**
 * Abstraction of an entity which represents the functionality of onosTopologyService.
 */
public interface OnosTopologyService {
    /**
     * Returns the attribute onosTopology.
     *
     * @param onosTopology value of onosTopology
     * @return onosTopology
     */
    OnosTopology getOnosTopology(OnosTopologyOpParam onosTopology);

    /**
     * Sets the value to attribute onosTopology.
     *
     * @param onosTopology value of onosTopology
     */
    void setOnosTopology(OnosTopologyOpParam onosTopology);

}
