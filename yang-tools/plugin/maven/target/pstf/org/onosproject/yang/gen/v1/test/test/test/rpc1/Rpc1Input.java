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

package org.onosproject.yang.gen.v1.test.test.test.rpc1;

import java.util.Map;
import org.onosproject.yang.gen.v1.test.test.test.group1.Cont1;

/**
 * Abstraction of an entity which represents the functionality of rpc1Input.
 */
public interface Rpc1Input {

    /**
     * Returns the attribute yangAugmentedInfoMap.
     *
     * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
     */
    Map<Class<?>, Object> yangAugmentedInfoMap();

    /**
     * Returns the attribute cont1.
     *
     * @return cont1 value of cont1
     */
    Cont1 cont1();


    /**
     * Returns the attribute yangAugmentedInfo.
     *
     * @param classObject value of yangAugmentedInfo
     * @return yangAugmentedInfo
     */
    Object yangAugmentedInfo(Class classObject);

    /**
     * Builder for rpc1Input.
     */
    interface Rpc1InputBuilder {
        /**
         * Returns the attribute yangAugmentedInfoMap.
         *
         * @return yangAugmentedInfoMap value of yangAugmentedInfoMap
         */
        Map<Class<?>, Object> yangAugmentedInfoMap();

        /**
         * Returns the attribute cont1.
         *
         * @return cont1 value of cont1
         */
        Cont1 cont1();

        /**
         * Returns the builder object of cont1.
         *
         * @param cont1 value of cont1
         * @return cont1
         */
        Rpc1InputBuilder cont1(Cont1 cont1);

        /**
         * Sets the value of yangAugmentedInfo.
         *
         * @param value value of yangAugmentedInfo
         * @param classObject value of yangAugmentedInfo
         */
         Rpc1InputBuilder addYangAugmentedInfo(Object value, Class classObject);

        /**
         * Returns the attribute yangAugmentedInfo.
         *
         * @param classObject value of yangAugmentedInfo
         * @return yangAugmentedInfo
         */
        Object yangAugmentedInfo(Class classObject);
        /**
         * Builds object of rpc1Input.
         *
         * @return rpc1Input
         */
        Rpc1Input build();
    }
}
