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
package org.onosproject.yangutils.translator.tojava.javamodel;

import org.onosproject.yangutils.datamodel.YangNode;
import org.onosproject.yangutils.datamodel.YangNotification;
import org.onosproject.yangutils.datamodel.javadatamodel.YangJavaModule;
import org.onosproject.yangutils.translator.exception.TranslatorException;
import org.onosproject.yangutils.translator.tojava.JavaCodeGenerator;
import org.onosproject.yangutils.translator.tojava.JavaCodeGeneratorInfo;
import org.onosproject.yangutils.translator.tojava.JavaFileInfoTranslator;
import org.onosproject.yangutils.translator.tojava.TempJavaCodeFragmentFiles;
import org.onosproject.yangutils.utils.io.YangPluginConfig;

import java.io.IOException;
import java.util.ArrayList;

import static org.onosproject.yangutils.translator.tojava.GeneratedJavaFileType.GENERATE_ALL_EVENT_CLASS_MASK;
import static org.onosproject.yangutils.translator.tojava.GeneratedJavaFileType.GENERATE_INTERFACE_WITH_BUILDER;
import static org.onosproject.yangutils.translator.tojava.GeneratedJavaFileType.GENERATE_SERVICE_AND_MANAGER;
import static org.onosproject.yangutils.translator.tojava.YangJavaModelUtils.generateCodeOfRootNode;
import static org.onosproject.yangutils.translator.tojava.YangJavaModelUtils.generateInterfaceFileForNonDataNodes;
import static org.onosproject.yangutils.translator.tojava.YangJavaModelUtils.isRootNodesCodeGenRequired;
import static org.onosproject.yangutils.translator.tojava.utils.JavaIdentifierSyntax.getRootPackage;
import static org.onosproject.yangutils.translator.tojava.utils.TranslatorErrorType.FAIL_AT_ENTRY;
import static org.onosproject.yangutils.translator.tojava.utils.TranslatorErrorType.FAIL_AT_EXIT;
import static org.onosproject.yangutils.translator.tojava.utils.TranslatorUtils.getErrorMsg;
import static org.onosproject.yangutils.utils.UtilConstants.SBI;
import static org.onosproject.yangutils.utils.io.impl.YangIoUtils.removeEmptyDirectory;
import static org.onosproject.yangutils.utils.io.impl.YangIoUtils.searchAndDeleteTempDir;

/**
 * Represents module information extended to support java code generation.
 */
public class YangJavaModuleTranslator
        extends YangJavaModule
        implements JavaCodeGeneratorInfo, JavaCodeGenerator {

    private static final long serialVersionUID = 806201625L;

    /**
     * File handle to maintain temporary java code fragments as per the code
     * snippet types.
     */
    private transient TempJavaCodeFragmentFiles tempFileHandle;

    /**
     * Creates a YANG node of module type.
     */
    public YangJavaModuleTranslator() {
        setJavaFileInfo(new JavaFileInfoTranslator());
        notificationNodes = new ArrayList<>();
        getJavaFileInfo().setGeneratedFileTypes(
                GENERATE_SERVICE_AND_MANAGER | GENERATE_INTERFACE_WITH_BUILDER);
    }

    /**
     * Returns the generated java file information.
     *
     * @return generated java file information
     */
    @Override
    public JavaFileInfoTranslator getJavaFileInfo() {
        if (javaFileInfo == null) {
            throw new TranslatorException(
                    "Missing java info in java datamodel node " + getName());
        }
        return (JavaFileInfoTranslator) javaFileInfo;
    }

    /**
     * Sets the java file info object.
     *
     * @param javaInfo java file info object
     */
    @Override
    public void setJavaFileInfo(JavaFileInfoTranslator javaInfo) {
        javaFileInfo = javaInfo;
    }

    /**
     * Returns the temporary file handle.
     *
     * @return temporary file handle
     */
    @Override
    public TempJavaCodeFragmentFiles getTempJavaCodeFragmentFiles() {
        return tempFileHandle;
    }

    /**
     * Sets temporary file handle.
     *
     * @param fileHandle temporary file handle
     */
    @Override
    public void setTempJavaCodeFragmentFiles(
            TempJavaCodeFragmentFiles fileHandle) {
        tempFileHandle = fileHandle;
    }

    /**
     * Generates java code for module.
     *
     * @param yangPlugin YANG plugin config
     * @throws TranslatorException when fails to generate the source files
     */
    @Override
    public void generateCodeEntry(YangPluginConfig yangPlugin)
            throws TranslatorException {
        String modulePkg = getRootPackage(getVersion(), getModuleNamespace(),
                                          getRevision(),
                                          yangPlugin.getConflictResolver());

        if (isNotificationChildNodePresent(this)) {
            getJavaFileInfo().setGeneratedFileTypes(
                    getJavaFileInfo().getGeneratedFileTypes()
                            | GENERATE_ALL_EVENT_CLASS_MASK);
        }
        try {
            generateCodeOfRootNode(this, yangPlugin, modulePkg);
            //Add augmented rpc name
            tempFileHandle.getServiceTempFiles().addAugmentedRpcMethod(this);
        } catch (IOException e) {
            throw new TranslatorException(getErrorMsg(FAIL_AT_ENTRY, this,
                                                      e.getLocalizedMessage()));
        }
    }

    /**
     * Creates a java file using the YANG module info.
     */
    @Override
    public void generateCodeExit()
            throws TranslatorException {
        /*
         * As part of the notification support the following files needs to be generated.
         * 1) Subject of the notification(event), this is simple interface with builder class.
         * 2) Event class extending "AbstractEvent" and defining event type enum.
         * 3) Event listener interface extending "EventListener".
         * 4) Event subject class.
         *
         * The manager class needs to extend the "ListenerRegistry".
         */
        try {
            if ((getJavaFileInfo().getGeneratedFileTypes() &
                    GENERATE_ALL_EVENT_CLASS_MASK) != 0) {
                getTempJavaCodeFragmentFiles().generateJavaFile(
                        GENERATE_ALL_EVENT_CLASS_MASK, this);
            }

            if (!isRootNodesCodeGenRequired(this)) {
                generateInterfaceFileForNonDataNodes(this);
            } else {
                getTempJavaCodeFragmentFiles()
                        .generateJavaFile(GENERATE_INTERFACE_WITH_BUILDER, this);
                if (getJavaFileInfo().getPluginConfig()
                        .getCodeGenerateForSbi() == null ||
                        !getJavaFileInfo().getPluginConfig()
                                .getCodeGenerateForSbi().equals(SBI)) {
                    getTempJavaCodeFragmentFiles()
                            .generateJavaFile(GENERATE_SERVICE_AND_MANAGER, this);
                }
            }

            searchAndDeleteTempDir(getJavaFileInfo().getBaseCodeGenPath() +
                                           getJavaFileInfo().getPackageFilePath());
            removeEmptyDirectory(getJavaFileInfo().getBaseCodeGenPath() +
                                         getJavaFileInfo().getPackageFilePath());
        } catch (IOException e) {
            throw new TranslatorException(getErrorMsg(FAIL_AT_EXIT, this,
                                                      e.getLocalizedMessage()));
        }
    }

    /**
     * Adds to notification node list.
     *
     * @param curNode notification node
     */
    private void addToNotificationList(YangNode curNode) {
        notificationNodes.add(curNode);
    }

    /**
     * Checks if there is any notification node present.
     *
     * @param rootNode root node of the data model
     * @return status of notification's existence
     */
    private boolean isNotificationChildNodePresent(YangNode rootNode) {
        YangNode childNode = rootNode.getChild();

        while (childNode != null) {
            if (childNode instanceof YangNotification) {
                addToNotificationList(childNode);
            }
            childNode = childNode.getNextSibling();
        }

        return !notificationNodes.isEmpty();
    }
}
