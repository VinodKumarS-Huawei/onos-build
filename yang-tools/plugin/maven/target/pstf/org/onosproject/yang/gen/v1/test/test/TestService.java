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

package org.onosproject.yang.gen.v1.test.test;

import org.onosproject.yang.gen.v1.test.test.test.rpc1.Rpc1Input;

/**
 * Abstraction of an entity which represents the functionality of testService.
 */
public interface TestService {
    /**
     * Returns the attribute test.
     *
     * @param test value of test
     * @return test
     */
    Test getTest(TestOpParam test);

    /**
     * Sets the value to attribute test.
     *
     * @param test value of test
     */
    void setTest(TestOpParam test);

    /**
     * Returns the attribute test.
     *
     * @param test value of test
     * @return test
     */
    Test getAugmentedTestCont1(TestOpParam test);

    /**
     * Sets the value to attribute augmentedTestCont1.
     *
     * @param augmentedTestCont1 value of augmentedTestCont1
     */
    void setAugmentedTestCont1(TestOpParam augmentedTestCont1);

    /**
     * Service interface of rpc1.
     *
     * @param inputVar input of service interface rpc1
     */
    void rpc1(Rpc1Input inputVar);

}
