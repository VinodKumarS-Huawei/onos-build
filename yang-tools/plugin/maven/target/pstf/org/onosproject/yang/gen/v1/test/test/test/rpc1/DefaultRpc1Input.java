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

import com.google.common.base.MoreObjects;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.onosproject.yang.gen.v1.test.test.test.group1.Cont1;

/**
 * Represents the implementation of rpc1Input.
 *
 * <p>
 * valueLeafFlags identify the leafs whose value are explicitly set
 * Applicable in protocol edit and query operation.
 * </p>
 *
 * <p>
 * selectLeafFlags identify the leafs to be selected, in a query operation.
 * </p>
 *
 * <p>
 * Operation type specify the node specific operation in protocols like NETCONF.
 * Applicable in protocol edit operation, not applicable in query operation.
 * </p>
 */
public class DefaultRpc1Input implements Rpc1Input {
    protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
    protected Cont1 cont1;

    @Override
    public Map<Class<?>, Object> yangAugmentedInfoMap() {
        return yangAugmentedInfoMap;
    }

    @Override
    public Cont1 cont1() {
        return cont1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(yangAugmentedInfoMap, cont1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DefaultRpc1Input) {
            DefaultRpc1Input other = (DefaultRpc1Input) obj;
            return
                Objects.equals(yangAugmentedInfoMap, other.yangAugmentedInfoMap) &&
                Objects.equals(cont1, other.cont1);
        }
        return false;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(getClass())
            .omitNullValues()
            .add("yangAugmentedInfoMap", yangAugmentedInfoMap)
            .add("cont1", cont1)
            .toString();
    }

    @Override
    public Object yangAugmentedInfo(Class classObject) {
        return yangAugmentedInfoMap.get(classObject);
    }
    /**
     * Creates an instance of rpc1Input.
     *
     * @param builderObject value of builder object of rpc1Input
     */
    protected DefaultRpc1Input(Rpc1InputBuilder builderObject) {
        yangAugmentedInfoMap = builderObject.yangAugmentedInfoMap();
        cont1 = builderObject.cont1();
    }

    /**
     * Creates an instance of defaultRpc1Input.
     */
    protected DefaultRpc1Input() {
    }

    /**
     * Returns the attribute rpc1InputBuilder.
     *
     * @return rpc1InputBuilder
     */
    public static Rpc1InputBuilder builder() {
        return new Rpc1InputBuilder();
    }

    /**
     * Represents the builder implementation of rpc1Input.
     */
    public static class Rpc1InputBuilder implements Rpc1Input.Rpc1InputBuilder {
        protected Map<Class<?>, Object> yangAugmentedInfoMap = new HashMap<>();
        protected Cont1 cont1;


        @Override
        public Map<Class<?>, Object> yangAugmentedInfoMap() {
            return yangAugmentedInfoMap;
        }

        @Override
        public Cont1 cont1() {
            return cont1;
        }

        @Override
        public Rpc1InputBuilder cont1(Cont1 cont1) {
            this.cont1 = cont1;
            return this;
        }

        @Override
        public Rpc1InputBuilder addYangAugmentedInfo(Object value, Class classObject) {
            yangAugmentedInfoMap.put(classObject, value);
            return this;
        }


        @Override
        public Object yangAugmentedInfo(Class classObject) {
            return yangAugmentedInfoMap.get(classObject);
        }
        @Override
        public Rpc1Input build() {
            return new DefaultRpc1Input(this);
        }

        /**
         * Creates an instance of rpc1InputBuilder.
         */
        public Rpc1InputBuilder() {
        }

    }
}
