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

package org.onosproject.yangutils.plugin.manager;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;
import org.onosproject.yangutils.parser.exceptions.ParserException;
import org.onosproject.yangutils.utils.io.YangPluginConfig;
import org.onosproject.yangutils.utils.io.impl.YangFileScanner;

import java.io.File;
import java.io.IOException;

import static org.onosproject.yangutils.utils.io.YangPluginConfig.compileCode;
import static org.onosproject.yangutils.utils.io.impl.YangIoUtils.deleteDirectory;

/**
 * Unit test case for typedef translator.
 */
public class TypeDefTranslatorTest {

    private final YangUtilManager utilManager = new YangUtilManager();
    private static final String DIR = "target/typedefTranslator/";
    private static final String DIR1 = System.getProperty("user.dir") + File
            .separator + DIR;

    /**
     * Checks typedef translation should not result in any exception.
     *
     * @throws MojoExecutionException
     */
    @Test
    public void processTypeDefTranslator() throws IOException,
            ParserException, MojoExecutionException {

        deleteDirectory(DIR);
        String searchDir = "src/test/resources/typedefTranslator/without";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        utilManager.resolveDependenciesUsingLinker();

        YangPluginConfig yangPluginConfig = new YangPluginConfig();
        yangPluginConfig.setCodeGenDir(DIR);
        utilManager.translateToJava(yangPluginConfig);
        compileCode(DIR1);
        deleteDirectory(DIR);
    }

    /**
     * Checks typedef translation should not result in any exception.
     *
     * @throws MojoExecutionException
     */
    @Test
    public void processTypeDefWithRestrictionsTranslator() throws IOException,
            ParserException, MojoExecutionException {

        deleteDirectory(DIR);
        String searchDir = "src/test/resources/typedefTranslator/with";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        utilManager.resolveDependenciesUsingLinker();

        YangPluginConfig yangPluginConfig = new YangPluginConfig();
        yangPluginConfig.setCodeGenDir(DIR);
        utilManager.translateToJava(yangPluginConfig);
        compileCode(DIR1);
        deleteDirectory(DIR);

    }

    /**
     * Checks typedef translation should not result in any exception.
     *
     * @throws MojoExecutionException
     */
    @Test
    public void processTypeDefWithUnionAndBitsTranslator() throws IOException,
            ParserException, MojoExecutionException {

        deleteDirectory(DIR);
        String searchDir = "src/test/resources/typedefTranslator/union";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        utilManager.resolveDependenciesUsingLinker();

        YangPluginConfig yangPluginConfig = new YangPluginConfig();
        yangPluginConfig.setCodeGenDir(DIR);
        utilManager.translateToJava(yangPluginConfig);
        compileCode(DIR1);
        deleteDirectory(DIR);
    }
}
