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

import org.apache.commons.lang3.tuple.Pair;

/**
 * Simple interface to cache flow ID and priority of cross connect flows.
 */
interface FlowIdCache {
    /**
     * Returns the flow ID and trafficID corresponding to the flow hash.
     *
     * @param flowId FlowId
     * @return flow ID and trafficID, null if not in cache
     */
    Pair<Integer, Integer> get(String flowId);

    /**
     * Stores the flow ID and trafficID corresponding to the flow hash.
     *
     * @param port flow port
     * @param flowId flow ID
     * @param trafficID Traffic ID
     */
    void set(String flowId, int port, int trafficID);

    /**
     * Removes the given hash from the cache.
     *
     * @param flowId flow id
     */
    void remove(String flowId);
}
