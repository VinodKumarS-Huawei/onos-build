/*
 * Copyright 2016-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.onosproject.yangutils.plugin.manager;

import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Test;
import org.onosproject.yangutils.datamodel.ResolvableType;
import org.onosproject.yangutils.datamodel.YangAugment;
import org.onosproject.yangutils.datamodel.YangNode;
import org.onosproject.yangutils.datamodel.YangReferenceResolver;
import org.onosproject.yangutils.datamodel.YangResolutionInfo;
import org.onosproject.yangutils.linker.impl.YangLinkerManager;
import org.onosproject.yangutils.linker.impl.YangXpathLinker;
import org.onosproject.yangutils.utils.io.YangPluginConfig;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.onosproject.yangutils.linker.impl.XpathLinkingTypes.AUGMENT_LINKING;
import static org.onosproject.yangutils.linker.impl.YangLinkerUtils.updateFilePriority;
import static org.onosproject.yangutils.utils.io.YangPluginConfig.compileCode;
import static org.onosproject.yangutils.utils.io.impl.YangFileScanner.getYangFiles;
import static org.onosproject.yangutils.utils.io.impl.YangIoUtils.deleteDirectory;

/**
 * Unit test cases for x-path linker.
 */
public class YangXpathLinkerTest {

    private static final String INTRA_FILE_PATH = "src/test/resources/xPathLinker/IntraFile/";
    private static final String INTER_FILE_PATH = "src/test/resources/xPathLinker/InterFile/";
    private static final String CASE_FILE_PATH = "src/test/resources/xPathLinker/Case/";
    private YangUtilManager utilManager = new YangUtilManager();
    private YangXpathLinker<?> linker = new YangXpathLinker();
    private YangLinkerManager linkerManager = new YangLinkerManager();

    /**
     * Unit test case for intra file linking for single level container.
     *
     * @throws IOException            when fails to do IO operations
     * @throws MojoExecutionException
     */
    @Test
    public void processIntraFileLinkingSingleLevel() throws IOException, MojoExecutionException {

        utilManager.createYangFileInfoSet(getYangFiles(INTRA_FILE_PATH + "IntraSingle/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        utilManager.resolveDependenciesUsingLinker();

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            YangReferenceResolver ref = (YangReferenceResolver) node;
            List<YangResolutionInfo> infos = ref.getUnresolvedResolutionList(ResolvableType.YANG_AUGMENT);
            YangResolutionInfo info = infos.get(0);

            YangAugment augment = (YangAugment) info.getEntityToResolveInfo().getEntityToResolve();
            targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                    .getName();
            targetNode = augment.getAugmentedNode();

        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for intra file linking for multiple level container.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processIntraFileLinkingMultipleLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTRA_FILE_PATH + "IntraMulti/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for intra file linking for single level augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processIntraFileLinkingInAugmentSingleLevel() throws IOException {
        utilManager.createYangFileInfoSet(getYangFiles(INTRA_FILE_PATH + "IntraSingleAugment/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for intra file linking for multiple level augment
     * without prefix.
     *
     * @throws IOException if fails to do IO operations
     */
    @Test
    public void processIntraFileMultiLevelWithoutPrefix() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(
                INTRA_FILE_PATH + "IntraMultiAugment/withoutprefix"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode target = null;
        String name = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);
            for (YangAugment augment : augments) {
                name = augment.getTargetNode()
                        .get(augment.getTargetNode().size() - 1)
                        .getNodeIdentifier().getName();
                target = linker.processXpathLinking(augment.getTargetNode(),
                                                    node, AUGMENT_LINKING);
            }
        }
        assertThat(true, is(target.getName().equals(name)));
    }

    /**
     * Unit test case for intra file linking for multiple level augment with
     * prefix.
     *
     * @throws IOException if fails to do IO operations
     */
    @Test
    public void processIntraFileWithPrefix() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(
                INTRA_FILE_PATH + "IntraMultiAugment/withprefix"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode target = null;
        String name = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);
            for (YangAugment augment : augments) {
                name = augment.getTargetNode()
                        .get(augment.getTargetNode().size() - 1)
                        .getNodeIdentifier().getName();
                target = linker.processXpathLinking(augment.getTargetNode(),
                                                    node, AUGMENT_LINKING);
            }
        }
        assertThat(true, is(target.getName().equals(name)));

    }

    /**
     * Unit test case for intra file linking for multiple level augment with
     * partial prefix.
     *
     * @throws IOException if fails to do IO operations
     */
    @Test
    public void processIntraFileWithPartialPrefix() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(
                INTRA_FILE_PATH + "IntraMultiAugment/withpartialprefix"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode target = null;
        String name = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);
            for (YangAugment augment : augments) {
                name = augment.getTargetNode()
                        .get(augment.getTargetNode().size() - 1)
                        .getNodeIdentifier().getName();
                target = linker.processXpathLinking(augment.getTargetNode(),
                                                    node, AUGMENT_LINKING);
            }
        }
        assertThat(true, is(target.getName().equals(name)));
    }

    /**
     * Unit test case for intra file linking for multiple level submodule.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processIntraFileLinkingInSubModuleSingleLevel() throws IOException {
        utilManager.createYangFileInfoSet(getYangFiles(INTRA_FILE_PATH + "IntraSingleSubModule/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for intra file linking for multiple level submodule.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processIntraFileLinkingInSubModuleMultiLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTRA_FILE_PATH + "IntraMultiSubModule/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for intra file linking for single level uses.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processIntraFileLinkingInUsesSingleLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTRA_FILE_PATH + "IntraSingleUses/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for intra file linking for multi level uses.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processIntraFileLinkingInUsesMultiLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTRA_FILE_PATH + "IntraMultiUses/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for single level container.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingSingleLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterSingle/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for multi level container.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingMultipleLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterMulti/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for single level augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInAugmentSingleLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterSingleAugment/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for multi level augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInAugmentMultiLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterMultiAugment/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for multipler inter file linking for single level augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processMultiInterFileLinkingInAugmentSingleLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterMultiFileAugment/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for multiple inter file linking for multi level augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processMultiInterFileLinkingInAugmentMultiLevel() throws IOException {

        utilManager
                .createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterMultiFileAugmentMulti/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = augment.getAugmentedNode();
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for single level submodule.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInSubModuleSingleLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterSingleSubModule/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());
        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = augment.getAugmentedNode();
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for multi level submodule.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInSubModuleMultiLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterMultiSubModule/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());
        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = augment.getAugmentedNode();
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for multi level uses inside augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInUsesInAugment() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterSingleUses/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1)
                        .getNodeIdentifier().getName();
                targetNode = augment.getAugmentedNode();
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));

    }

    /**
     * Unit test case for inter file linking for multi level uses.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInUsesMultiLevel() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(INTER_FILE_PATH + "InterMultiUses/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1).getNodeIdentifier()
                        .getName();
                targetNode = linker.processXpathLinking(augment.getTargetNode(), node, AUGMENT_LINKING);
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));
    }

    /**
     * Unit test case for inter file linking for multi level uses inside augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInMultipleSubmodules() throws IOException {

        utilManager.createYangFileInfoSet(getYangFiles(CASE_FILE_PATH + "submodule/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());

        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1)
                        .getNodeIdentifier().getName();
                targetNode = augment.getAugmentedNode();
            }
        }

        assertThat(true, is(targetNode.getName().equals(targetNodeName)));

    }

    /**
     * Unit test case for inter file linking for multi level uses inside augment.
     *
     * @throws IOException when fails to do IO operations
     */
    @Test
    public void processInterFileLinkingInMultipleUses() throws IOException {

        deleteDirectory("target/xpath/");
        utilManager.createYangFileInfoSet(getYangFiles(CASE_FILE_PATH + "uses/"));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        linkerManager.createYangNodeSet(utilManager.getYangNodeSet());
        linkerManager.linkSubModulesToParentModule(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());
        linkerManager.addRefToYangFilesIncludeList(utilManager.getYangNodeSet());
        updateFilePriority(utilManager.getYangNodeSet());
        linkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        YangNode targetNode = null;
        String targetNodeName = null;

        for (YangNode node : utilManager.getYangNodeSet()) {
            List<YangAugment> augments = linker.getListOfYangAugment(node);

            for (YangAugment augment : augments) {
                targetNodeName = augment.getTargetNode().get(augment.getTargetNode().size() - 1)
                        .getNodeIdentifier().getName();
                targetNode = augment.getAugmentedNode();
            }
        }

        YangPluginConfig yangPluginConfig = new YangPluginConfig();
        yangPluginConfig.setCodeGenDir("target/xpath/");
        utilManager.translateToJava(yangPluginConfig);
        String dir = System.getProperty("user.dir") + File.separator + "target/xpath/";
        compileCode(dir);
        deleteDirectory("target/xpath/");
        assertThat(true, is(targetNode.getName().equals(targetNodeName)));

        deleteDirectory("target/xpath/");
    }
}
