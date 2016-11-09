/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package org.onosproject.yangutils.tool;

import org.onosproject.yangutils.datamodel.YangNode;

import java.util.Objects;

/**
 * Represents YANG file information.
 */
public class YangFileInfo {

    /**
     * YANG file name.
     */
    private String yangFileName;

    /**
     * Data model node after parsing YANG file.
     */
    private YangNode rootNode;

    /**
     * Flag to know if the root node require to be translated.
     */
    private boolean isForTranslator = true;

    /**
     * Returns data model node for YANG file.
     *
     * @return data model node for YANG file
     */
    public YangNode getRootNode() {
        return rootNode;
    }

    /**
     * Sets data model node for YANG file.
     *
     * @param rootNode of the Yang file
     */
    public void setRootNode(YangNode rootNode) {
        this.rootNode = rootNode;
    }

    /**
     * Returns YANG file name.
     *
     * @return yangFileName YANG file name
     */
    public String getYangFileName() {
        return yangFileName;
    }

    /**
     * Sets YANG file name.
     *
     * @param yangFileName YANG file name
     */
    public void setYangFileName(String yangFileName) {
        this.yangFileName = yangFileName;
    }

    /**
     * Returns true if node need to be translated.
     *
     * @return isForTranslator true if node need to be translated
     */
    public boolean isForTranslator() {
        return isForTranslator;
    }

    /**
     * Sets true if node need to be translated.
     *
     * @param isForTranslator true if node need to be translated
     */
    public void setForTranslator(boolean isForTranslator) {
        this.isForTranslator = isForTranslator;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof YangFileInfo) {
            final YangFileInfo other = (YangFileInfo) obj;
            return Objects.equals(yangFileName, other.yangFileName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(yangFileName);
    }
}
