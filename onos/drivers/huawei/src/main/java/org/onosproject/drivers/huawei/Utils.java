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

/**
 * Represents utilities for huawei driver.
 */
public final class Utils {

    /**
     * Prevents creation of utils instance.
     */
    private Utils() {
    }

    private static final String XMLNS_STRING = "xmlns=\"http://www.huawei.com" +
            "/netconf/vrp\"";
    private static final String XMLNS_HUA_STRING = "xmlns=\"http://www.huawei" +
            ".com/netconf/vrp\" format-version=\"1.0\" content-version=\"1.0\"";

    /**
     * YMS encode the java object into a xml string with xml namespace equals to
     * the namespace defined in YANG file. Huawei driver overwriting this
     * default xml namespace in generated xml string with xml string for Huawei.
     * TODO why cant namespace itself be changed
     *
     * @param request xml string as an output of YMS encode operation
     * @return formatted string
     */
    protected static String formatMessage(String request) {
        if (request.contains(XMLNS_STRING)) {
            request = request.replaceFirst(XMLNS_STRING, XMLNS_HUA_STRING);
        }
        return request;
    }

    protected static String editConfig(String encodedString) {

        // Add opening protocol edit config tags.
        StringBuilder rpc =
                new StringBuilder(
                        "<rpc xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0" +
                                "\" " +
                                "message-id=\"1\">");
        rpc.append("<edit-config>");
        rpc.append("<target>");
        rpc.append("<running/>");
        rpc.append("</target>");

        // Get the formatted XML namespace string.
        encodedString = formatMessage(encodedString);

        // Add the closing protocol edit config tags.
        rpc.append(encodedString);
        rpc.append("</edit-config>");
        rpc.append("</rpc>");

        return rpc.toString();
    }

    protected static String getConfig(String encodedString) {

        // Add opening protocol edit config tags.
        StringBuilder rpc =
                new StringBuilder(
                        "<rpc xmlns=\"urn:ietf:params:xml:ns:netconf:base:1.0" +
                                "\" " +
                                "message-id=\"1\">");
        rpc.append("<get-config>");
        rpc.append("<source>");
        rpc.append("<running/>");
        rpc.append("</source>");

        // Get the formatted XML namespace string.
        encodedString = formatMessage(encodedString);

        // Add the closing protocol edit config tags.
        rpc.append(encodedString);
        rpc.append("</get-config>");
        rpc.append("</rpc>");

        return rpc.toString();
    }


}
