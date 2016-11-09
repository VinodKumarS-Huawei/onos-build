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

import java.io.IOException;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.maven.plugin.MojoExecutionException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.onosproject.yangutils.datamodel.YangContainer;
import org.onosproject.yangutils.datamodel.YangLeaf;
import org.onosproject.yangutils.datamodel.YangLeafList;
import org.onosproject.yangutils.datamodel.YangLeafRef;
import org.onosproject.yangutils.datamodel.YangList;
import org.onosproject.yangutils.datamodel.YangModule;
import org.onosproject.yangutils.datamodel.YangNode;
import org.onosproject.yangutils.datamodel.YangNodeType;
import org.onosproject.yangutils.datamodel.utils.ResolvableStatus;
import org.onosproject.yangutils.datamodel.utils.builtindatatype.YangDataTypes;
import org.onosproject.yangutils.linker.impl.YangLinkerManager;
import org.onosproject.yangutils.parser.exceptions.ParserException;
import org.onosproject.yangutils.utils.io.impl.YangFileScanner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.onosproject.yangutils.datamodel.YangNodeType.MODULE_NODE;
import static org.onosproject.yangutils.datamodel.utils.ResolvableStatus.RESOLVED;
import static org.onosproject.yangutils.datamodel.utils.builtindatatype.YangDataTypes.LEAFREF;
import static org.onosproject.yangutils.linker.impl.YangLinkerUtils.updateFilePriority;

/**
 * Test cases for testing leafref inter file linking.
 */
public class InterFileLeafrefLinkingTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final YangUtilManager utilManager = new YangUtilManager();
    private final YangLinkerManager yangLinkerManager = new YangLinkerManager();

    /**
     * Checks inter file leafref linking.
     */
    @Test
    public void processInterFileLeafrefLinking()
            throws IOException, ParserException, MojoExecutionException {

        String searchDir = "src/test/resources/leafreflinker/interfile/interfileleafrefwithimport";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        YangNode refNode = null;
        YangNode selfNode = null;

        // Create YANG node set
        yangLinkerManager.createYangNodeSet(utilManager.getYangNodeSet());

        // Add references to import list.
        yangLinkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        updateFilePriority(utilManager.getYangNodeSet());

        // Carry out inter-file linking.
        yangLinkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        Iterator<YangNode> yangNodeIterator = utilManager.getYangNodeSet().iterator();

        YangNode rootNode = yangNodeIterator.next();

        if (rootNode.getName().equals("module1")) {
            selfNode = rootNode;
            refNode = yangNodeIterator.next();
        } else {
            refNode = rootNode;
            selfNode = yangNodeIterator.next();
        }

        // Check whether the data model tree returned is of type module.
        assertThat(selfNode instanceof YangModule, is(true));

        // Check whether the node type is set properly to module.
        assertThat(selfNode.getNodeType(), is(MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) selfNode;
        assertThat(yangNode.getName(), is("module1"));

        ListIterator<YangLeaf> leafIterator = yangNode.getListOfLeaf().listIterator();
        YangLeaf leafInfo = leafIterator.next();

        assertThat(leafInfo.getName(), is("invalid-interval"));
        assertThat(leafInfo.getDataType().getDataTypeName(), is("leafref"));
        assertThat(leafInfo.getDataType().getDataType(), is(LEAFREF));

        // Check whether the data model tree returned is of type module.
        assertThat(refNode instanceof YangModule, is(true));

        // Check whether the node type is set properly to module.
        assertThat(refNode.getNodeType(), is(MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode1 = (YangModule) refNode;
        assertThat(yangNode1.getName(), is("module2"));
        YangLeaf leafInfo1 = yangNode1.getListOfLeaf().listIterator().next();

        YangLeafRef leafref = (YangLeafRef) leafInfo.getDataType().getDataTypeExtendedInfo();

        assertThat(leafref.getReferredLeafOrLeafList(), is(leafInfo1));
        assertThat(leafref.getResolvableStatus(), is(RESOLVED));

        assertThat(leafref.getEffectiveDataType().getDataType(),
                is(YangDataTypes.STRING));
    }

    /**
     * Checks inter file resolution when leafref from grouping refers to other file.
     */
    @Test
    public void processInterFileLeafrefFromGroupingRefersToOtherFile()
            throws IOException, ParserException {

        String searchDir = "src/test/resources/leafreflinker/interfile/interfileleafreffromgroupingreferstootherfile";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        YangNode selfNode = null;
        YangNode refNode = null;

        // Create YANG node set
        yangLinkerManager.createYangNodeSet(utilManager.getYangNodeSet());

        // Add references to import list.
        yangLinkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        updateFilePriority(utilManager.getYangNodeSet());

        // Carry out inter-file linking.
        yangLinkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        Iterator<YangNode> yangNodeIterator = utilManager.getYangNodeSet().iterator();

        YangNode rootNode = yangNodeIterator.next();

        if (rootNode.getName().equals("module1")) {
            selfNode = rootNode;
            refNode = yangNodeIterator.next();
        } else {
            refNode = rootNode;
            selfNode = yangNodeIterator.next();
        }

        // Check whether the data model tree returned is of type module.
        assertThat(selfNode instanceof YangModule, is(true));

        // Check whether the node type is set properly to module.
        assertThat(selfNode.getNodeType(), is(MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) selfNode;
        assertThat(yangNode.getName(), is("module1"));

        YangList list = (YangList) yangNode.getChild().getChild();
        ListIterator<YangLeaf> leafIterator = list.getListOfLeaf().listIterator();
        YangLeaf leafInfo = leafIterator.next();

        assertThat(leafInfo.getName(), is("link-tp"));
        assertThat(leafInfo.getDataType().getDataTypeName(), is("leafref"));
        assertThat(leafInfo.getDataType().getDataType(), is(LEAFREF));

        YangLeafRef leafref = (YangLeafRef) leafInfo.getDataType().getDataTypeExtendedInfo();

        YangLeaf leafInfo2 = (YangLeaf) leafref.getReferredLeafOrLeafList();
        assertThat(leafref.getReferredLeafOrLeafList(), is(leafInfo2));
        assertThat(leafref.getResolvableStatus(), is(RESOLVED));

        assertThat(leafref.getEffectiveDataType().getDataType(),
                is(YangDataTypes.STRING));
    }

    /**
     * Checks inter file resolution when leafref from grouping with prefix is changed properly during cloning.
     */
    @Test
    public void processInterFileLeafrefFromGroupingWithPrefixIsCloned()
            throws IOException, ParserException {

        String searchDir = "src/test/resources/leafreflinker/interfile/leafrefInGroupingWithPrefix";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        YangNode selfNode = null;
        YangNode refNode = null;

        // Create YANG node set
        yangLinkerManager.createYangNodeSet(utilManager.getYangNodeSet());

        // Add references to import list.
        yangLinkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        updateFilePriority(utilManager.getYangNodeSet());

        // Carry out inter-file linking.
        yangLinkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        Iterator<YangNode> yangNodeIterator = utilManager.getYangNodeSet().iterator();

        YangNode rootNode = yangNodeIterator.next();

        if (rootNode.getName().equals("LeafrefInGroupingOfModule1")) {
            selfNode = rootNode;
            refNode = yangNodeIterator.next();
        } else {
            refNode = rootNode;
            selfNode = yangNodeIterator.next();
        }

        // Check whether the data model tree returned is of type module.
        assertThat(selfNode instanceof YangModule, is(true));

        // Check whether the node type is set properly to module.
        assertThat(selfNode.getNodeType(), is(MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) selfNode;
        assertThat(yangNode.getName(), is("LeafrefInGroupingOfModule1"));

        // Check whether the module name is set correctly.
        YangModule yangNode1 = (YangModule) refNode;
        assertThat(yangNode1.getName(), is("GroupingCopiedInModule2"));

        YangContainer yangContainer = (YangContainer) yangNode1.getChild();

        ListIterator<YangLeaf> leafIterator = yangContainer.getListOfLeaf().listIterator();
        YangLeaf leafInfo = leafIterator.next();

        assertThat(leafInfo.getName(), is("network-ref"));
        assertThat(leafInfo.getDataType().getDataTypeName(), is("leafref"));
        assertThat(leafInfo.getDataType().getDataType(), is(LEAFREF));

        YangLeafRef leafref = (YangLeafRef) leafInfo.getDataType().getDataTypeExtendedInfo();

        YangLeaf leafInfo2 = (YangLeaf) leafref.getReferredLeafOrLeafList();
        assertThat(leafref.getReferredLeafOrLeafList(), is(leafInfo2));
        assertThat(leafref.getResolvableStatus(), is(RESOLVED));

        assertThat(leafref.getEffectiveDataType().getDataType(),
                is(YangDataTypes.STRING));
    }

    /**
     * Checks inter file resolution when leafref from grouping with prefix is changed properly during cloning with
     * multi reference.
     */
    @Test
    public void processInterFileLeafrefFromGroupingWithPrefixIsClonedMultiReference()
            throws IOException, ParserException {

        String searchDir = "src/test/resources/leafreflinker/interfile/leafrefInGroupingWithPrefixAndManyReference";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        YangNode selfNode = null;
        YangNode refNode = null;

        // Create YANG node set
        yangLinkerManager.createYangNodeSet(utilManager.getYangNodeSet());

        // Add references to import list.
        yangLinkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        updateFilePriority(utilManager.getYangNodeSet());

        // Carry out inter-file linking.
        yangLinkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        Iterator<YangNode> yangNodeIterator = utilManager.getYangNodeSet().iterator();

        YangNode rootNode = yangNodeIterator.next();

        if (rootNode.getName().equals("ietf-network")) {
            selfNode = rootNode;
            refNode = yangNodeIterator.next();
        } else {
            refNode = rootNode;
            selfNode = yangNodeIterator.next();
        }

        // Check whether the data model tree returned is of type module.
        assertThat(selfNode instanceof YangModule, is(true));

        // Check whether the node type is set properly to module.
        assertThat(selfNode.getNodeType(), is(MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) selfNode;
        assertThat(yangNode.getName(), is("ietf-network"));

        // Check whether the module name is set correctly.
        YangModule yangNode1 = (YangModule) refNode;
        assertThat(yangNode1.getName(), is("ietf-te-topology"));

        YangContainer yangContainer = (YangContainer) yangNode1.getChild().getNextSibling();
        ListIterator<YangLeaf> leafIterator;
        YangLeaf leafInfo;

        leafIterator = yangContainer.getListOfLeaf().listIterator();
        leafInfo = leafIterator.next();
        leafInfo = leafIterator.next();

        assertThat(leafInfo.getName(), is("node-ref"));
        assertThat(leafInfo.getDataType().getDataTypeName(), is("leafref"));
        assertThat(leafInfo.getDataType().getDataType(), is(LEAFREF));

        YangLeafRef leafref = (YangLeafRef) leafInfo.getDataType().getDataTypeExtendedInfo();

        YangLeaf leafInfo2 = (YangLeaf) leafref.getReferredLeafOrLeafList();
        assertThat(leafref.getReferredLeafOrLeafList(), is(leafInfo2));
        assertThat(leafref.getResolvableStatus(), is(RESOLVED));

        assertThat(leafref.getEffectiveDataType().getDataType(),
                is(YangDataTypes.DERIVED));

        leafInfo = leafIterator.next();

        assertThat(leafInfo.getName(), is("network-ref"));
        assertThat(leafInfo.getDataType().getDataTypeName(), is("leafref"));
        assertThat(leafInfo.getDataType().getDataType(), is(LEAFREF));

        YangLeafRef leafref1 = (YangLeafRef) leafInfo.getDataType().getDataTypeExtendedInfo();

        YangLeaf leafInfo4 = (YangLeaf) leafref1.getReferredLeafOrLeafList();
        assertThat(leafref1.getReferredLeafOrLeafList(), is(leafInfo4));
        assertThat(leafref1.getResolvableStatus(), is(RESOLVED));

        assertThat(leafref1.getEffectiveDataType().getDataType(),
                is(YangDataTypes.DERIVED));
    }

    /**
     * Checks self resolution when leafref under typedef been referred multiple times.
     */
    @Test
    public void processLeafrefWhenUsedMultipleTimes()
            throws IOException, ParserException {
        String searchDir = "src/test/resources/leafreflinker/interfile/typedefreferredmultipletimes";
        utilManager.createYangFileInfoSet(YangFileScanner.getYangFiles(searchDir));
        utilManager.parseYangFileInfoSet();
        utilManager.createYangNodeSet();
        YangNode selfNode = null;

        // Create YANG node set
        yangLinkerManager.createYangNodeSet(utilManager.getYangNodeSet());

        // Add references to import list.
        yangLinkerManager.addRefToYangFilesImportList(utilManager.getYangNodeSet());

        updateFilePriority(utilManager.getYangNodeSet());

        // Carry out inter-file linking.
        yangLinkerManager.processInterFileLinking(utilManager.getYangNodeSet());

        Iterator<YangNode> yangNodeIterator = utilManager.getYangNodeSet().iterator();

        YangNode rootNode = yangNodeIterator.next();

        if (rootNode.getName().equals("ietf-interfaces")) {
            selfNode = rootNode;
        }

        // Check whether the data model tree returned is of type module.
        assertThat((selfNode instanceof YangModule), is(true));

        // Check whether the node type is set properly to module.
        assertThat(selfNode.getNodeType(), is(YangNodeType.MODULE_NODE));

        // Check whether the module name is set correctly.
        YangModule yangNode = (YangModule) selfNode;
        assertThat(yangNode.getName(), is("ietf-interfaces"));

        YangContainer container = (YangContainer) yangNode.getChild().getNextSibling();

        YangList list = (YangList) container.getChild();

        ListIterator<YangLeafList> leafIterator;
        YangLeafList leafInfo;

        leafIterator = list.getListOfLeafList().listIterator();
        leafInfo = leafIterator.next();

        // Check whether the information in the leaf is correct.
        assertThat(leafInfo.getName(), is("higher-layer-if"));
        assertThat(leafInfo.getDataType().getDataTypeName(), is("leafref"));
        assertThat(leafInfo.getDataType().getDataType(), is(YangDataTypes.LEAFREF));
        YangLeafRef leafref = (YangLeafRef) (leafInfo.getDataType().getDataTypeExtendedInfo());

        // Check whether leafref type got resolved.
        assertThat(leafref.getResolvableStatus(),
                is(ResolvableStatus.RESOLVED));

        // Check the effective type for the leaf.
        assertThat(leafref.getEffectiveDataType().getDataType(),
                is(YangDataTypes.STRING));

        leafInfo = leafIterator.next();

        // Check whether the information in the leaf is correct.
        assertThat(leafInfo.getName(), is("lower-layer-if"));
        assertThat(leafInfo.getDataType().getDataTypeName(), is("leafref"));
        assertThat(leafInfo.getDataType().getDataType(), is(YangDataTypes.LEAFREF));
        YangLeafRef leafref1 = (YangLeafRef) (leafInfo.getDataType().getDataTypeExtendedInfo());

        // Check whether leafref type got resolved.
        assertThat(leafref1.getResolvableStatus(),
                is(ResolvableStatus.RESOLVED));

        // Check the effective type for the leaf.
        assertThat(leafref1.getEffectiveDataType().getDataType(),
                is(YangDataTypes.STRING));
    }
}
