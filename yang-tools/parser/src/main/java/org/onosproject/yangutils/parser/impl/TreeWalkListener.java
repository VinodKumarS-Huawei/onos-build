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

package org.onosproject.yangutils.parser.impl;

import java.util.Stack;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.onosproject.yangutils.datamodel.YangNode;
import org.onosproject.yangutils.datamodel.utils.Parsable;
import org.onosproject.yangutils.datamodel.utils.YangConstructType;
import org.onosproject.yangutils.parser.antlrgencode.GeneratedYangListener;
import org.onosproject.yangutils.parser.antlrgencode.GeneratedYangParser;
import org.onosproject.yangutils.parser.impl.listeners.AppDataStructureListener;
import org.onosproject.yangutils.parser.impl.listeners.AppExtendedNameListener;
import org.onosproject.yangutils.parser.impl.listeners.ArgumentListener;
import org.onosproject.yangutils.parser.impl.listeners.AugmentListener;
import org.onosproject.yangutils.parser.impl.listeners.BaseFileListener;
import org.onosproject.yangutils.parser.impl.listeners.BaseListener;
import org.onosproject.yangutils.parser.impl.listeners.BelongsToListener;
import org.onosproject.yangutils.parser.impl.listeners.BitListener;
import org.onosproject.yangutils.parser.impl.listeners.BitsListener;
import org.onosproject.yangutils.parser.impl.listeners.CaseListener;
import org.onosproject.yangutils.parser.impl.listeners.ChoiceListener;
import org.onosproject.yangutils.parser.impl.listeners.CompilerAnnotationListener;
import org.onosproject.yangutils.parser.impl.listeners.ConfigListener;
import org.onosproject.yangutils.parser.impl.listeners.ContactListener;
import org.onosproject.yangutils.parser.impl.listeners.ContainerListener;
import org.onosproject.yangutils.parser.impl.listeners.DataStructureKeyListener;
import org.onosproject.yangutils.parser.impl.listeners.Decimal64Listener;
import org.onosproject.yangutils.parser.impl.listeners.DefaultListener;
import org.onosproject.yangutils.parser.impl.listeners.DescriptionListener;
import org.onosproject.yangutils.parser.impl.listeners.EnumListener;
import org.onosproject.yangutils.parser.impl.listeners.EnumerationListener;
import org.onosproject.yangutils.parser.impl.listeners.ErrorAppTagListener;
import org.onosproject.yangutils.parser.impl.listeners.ErrorMessageListener;
import org.onosproject.yangutils.parser.impl.listeners.ExtensionListener;
import org.onosproject.yangutils.parser.impl.listeners.FeatureListener;
import org.onosproject.yangutils.parser.impl.listeners.FractionDigitsListener;
import org.onosproject.yangutils.parser.impl.listeners.GroupingListener;
import org.onosproject.yangutils.parser.impl.listeners.IdentityListener;
import org.onosproject.yangutils.parser.impl.listeners.IdentityRefListener;
import org.onosproject.yangutils.parser.impl.listeners.IfFeatureListener;
import org.onosproject.yangutils.parser.impl.listeners.ImportListener;
import org.onosproject.yangutils.parser.impl.listeners.IncludeListener;
import org.onosproject.yangutils.parser.impl.listeners.InputListener;
import org.onosproject.yangutils.parser.impl.listeners.KeyListener;
import org.onosproject.yangutils.parser.impl.listeners.LeafListListener;
import org.onosproject.yangutils.parser.impl.listeners.LeafListener;
import org.onosproject.yangutils.parser.impl.listeners.LeafrefListener;
import org.onosproject.yangutils.parser.impl.listeners.LengthRestrictionListener;
import org.onosproject.yangutils.parser.impl.listeners.ListListener;
import org.onosproject.yangutils.parser.impl.listeners.MandatoryListener;
import org.onosproject.yangutils.parser.impl.listeners.MaxElementsListener;
import org.onosproject.yangutils.parser.impl.listeners.MinElementsListener;
import org.onosproject.yangutils.parser.impl.listeners.ModuleListener;
import org.onosproject.yangutils.parser.impl.listeners.MustListener;
import org.onosproject.yangutils.parser.impl.listeners.NamespaceListener;
import org.onosproject.yangutils.parser.impl.listeners.NotificationListener;
import org.onosproject.yangutils.parser.impl.listeners.OrganizationListener;
import org.onosproject.yangutils.parser.impl.listeners.OutputListener;
import org.onosproject.yangutils.parser.impl.listeners.PathListener;
import org.onosproject.yangutils.parser.impl.listeners.PatternRestrictionListener;
import org.onosproject.yangutils.parser.impl.listeners.PositionListener;
import org.onosproject.yangutils.parser.impl.listeners.PrefixListener;
import org.onosproject.yangutils.parser.impl.listeners.PresenceListener;
import org.onosproject.yangutils.parser.impl.listeners.RangeRestrictionListener;
import org.onosproject.yangutils.parser.impl.listeners.ReferenceListener;
import org.onosproject.yangutils.parser.impl.listeners.RequireInstanceListener;
import org.onosproject.yangutils.parser.impl.listeners.RevisionDateListener;
import org.onosproject.yangutils.parser.impl.listeners.RevisionListener;
import org.onosproject.yangutils.parser.impl.listeners.RpcListener;
import org.onosproject.yangutils.parser.impl.listeners.ShortCaseListener;
import org.onosproject.yangutils.parser.impl.listeners.StatusListener;
import org.onosproject.yangutils.parser.impl.listeners.SubModuleListener;
import org.onosproject.yangutils.parser.impl.listeners.TypeDefListener;
import org.onosproject.yangutils.parser.impl.listeners.TypeListener;
import org.onosproject.yangutils.parser.impl.listeners.UnionListener;
import org.onosproject.yangutils.parser.impl.listeners.UniqueListener;
import org.onosproject.yangutils.parser.impl.listeners.UnitsListener;
import org.onosproject.yangutils.parser.impl.listeners.UsesListener;
import org.onosproject.yangutils.parser.impl.listeners.ValueListener;
import org.onosproject.yangutils.parser.impl.listeners.VersionListener;
import org.onosproject.yangutils.parser.impl.listeners.WhenListener;

import static org.onosproject.yangutils.parser.impl.parserutils.ListenerUtil.handleUnsupportedYangConstruct;
import static org.onosproject.yangutils.utils.UtilConstants.CURRENTLY_UNSUPPORTED;
import static org.onosproject.yangutils.utils.UtilConstants.UNSUPPORTED_YANG_CONSTRUCT;

/**
 * Represents ANTLR generates parse-tree. ANTLR generates a parse-tree listener interface that responds to events
 * triggered by the built-in tree walker. The methods in listener are just
 * callbacks. This class implements listener interface and generates the
 * corresponding data model tree.
 */
public class TreeWalkListener implements GeneratedYangListener {

    // List of parsable node entries maintained in stack
    private Stack<Parsable> parsedDataStack = new Stack<>();

    // Parse tree root node
    private YangNode rootNode;

    // YANG file name.
    private String fileName;

    /**
     * Parent depth of grouping count for any node.
     */
    private int groupingDepth;

    /**
     * Parent depth of unsupported yang construct count for any node.
     */
    private int unsupportedYangConstructDepth;

    /**
     * Returns number of unsupported yang constructs parents, by a node, at any level.
     *
     * @return depth of unsupported yang constructs
     */
    public int getUnsupportedYangConstructDepth() {
        return unsupportedYangConstructDepth;
    }

    /**
     * Sets number of unsupported yang constructs by a node at any level.
     */
    private void increaseUnsupportedYangConstructDepth() {
        unsupportedYangConstructDepth++;
    }

    /**
     * Sets number of unsupported yang constructs by a node at any level.
     */
    private void decreaseUnsupportedYangConstructDepth() {
        unsupportedYangConstructDepth--;
    }

    /**
     * Returns number of grouping parents, by a node, at any level.
     *
     * @return depth of grouping
     */
    public int getGroupingDepth() {
        return groupingDepth;
    }

    /**
     * Sets number of grouping parents by a node at any level.
     */
    public void increaseGroupingDepth() {
        groupingDepth++;
    }

    /**
     * Sets number of grouping parents by a node at any level.
     */
    public void decreaseGroupingDepth() {
        groupingDepth--;
    }

    /**
     * Returns stack of parsable data.
     *
     * @return stack of parsable data
     */
    public Stack<Parsable> getParsedDataStack() {
        return parsedDataStack;
    }

    /**
     * Returns root node.
     *
     * @return rootNode of data model tree
     */
    public YangNode getRootNode() {
        return rootNode;
    }

    /**
     * Returns YANG file name.
     *
     * @return YANG file name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets YANG file name.
     *
     * @param fileName YANG file name
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Set parsed data stack.
     *
     * @param parsedDataStack stack of parsable data objects
     */
    public void setParsedDataStack(Stack<Parsable> parsedDataStack) {
        this.parsedDataStack = parsedDataStack;
    }

    /**
     * Set root node.
     *
     * @param rootNode root node of data model tree
     */
    public void setRootNode(YangNode rootNode) {
        this.rootNode = rootNode;
    }

    @Override
    public void enterYangfile(GeneratedYangParser.YangfileContext ctx) {
        BaseFileListener.processYangFileEntry(this, ctx);
    }

    @Override
    public void exitYangfile(GeneratedYangParser.YangfileContext ctx) {
        BaseFileListener.processYangFileExit(this, ctx);
    }

    @Override
    public void enterModuleStatement(GeneratedYangParser.ModuleStatementContext ctx) {
        ModuleListener.processModuleEntry(this, ctx);
    }

    @Override
    public void exitModuleStatement(GeneratedYangParser.ModuleStatementContext ctx) {
        ModuleListener.processModuleExit(this, ctx);
    }

    @Override
    public void enterModuleBody(GeneratedYangParser.ModuleBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitModuleBody(GeneratedYangParser.ModuleBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterModuleHeaderStatement(GeneratedYangParser.ModuleHeaderStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitModuleHeaderStatement(GeneratedYangParser.ModuleHeaderStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterLinkageStatements(GeneratedYangParser.LinkageStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitLinkageStatements(GeneratedYangParser.LinkageStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterMetaStatements(GeneratedYangParser.MetaStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitMetaStatements(GeneratedYangParser.MetaStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRevisionStatements(GeneratedYangParser.RevisionStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRevisionStatements(GeneratedYangParser.RevisionStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterBodyStatements(GeneratedYangParser.BodyStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitBodyStatements(GeneratedYangParser.BodyStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterYangVersionStatement(GeneratedYangParser.YangVersionStatementContext ctx) {
        VersionListener.processVersionEntry(this, ctx);
    }

    @Override
    public void exitYangVersionStatement(GeneratedYangParser.YangVersionStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterNamespaceStatement(GeneratedYangParser.NamespaceStatementContext ctx) {
        NamespaceListener.processNamespaceEntry(this, ctx);
    }

    @Override
    public void exitNamespaceStatement(GeneratedYangParser.NamespaceStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterPrefixStatement(GeneratedYangParser.PrefixStatementContext ctx) {
        PrefixListener.processPrefixEntry(this, ctx);
    }

    @Override
    public void exitPrefixStatement(GeneratedYangParser.PrefixStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterImportStatement(GeneratedYangParser.ImportStatementContext ctx) {
        ImportListener.processImportEntry(this, ctx);
    }

    @Override
    public void exitImportStatement(GeneratedYangParser.ImportStatementContext ctx) {
        ImportListener.processImportExit(this, ctx);
    }

    @Override
    public void enterImportStatementBody(GeneratedYangParser.ImportStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitImportStatementBody(GeneratedYangParser.ImportStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRevisionDateStatement(GeneratedYangParser.RevisionDateStatementContext ctx) {
        RevisionDateListener.processRevisionDateEntry(this, ctx);
    }

    @Override
    public void exitRevisionDateStatement(GeneratedYangParser.RevisionDateStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterIncludeStatement(GeneratedYangParser.IncludeStatementContext ctx) {
        IncludeListener.processIncludeEntry(this, ctx);
    }

    @Override
    public void exitIncludeStatement(GeneratedYangParser.IncludeStatementContext ctx) {
        IncludeListener.processIncludeExit(this, ctx);
    }

    @Override
    public void enterOrganizationStatement(GeneratedYangParser.OrganizationStatementContext ctx) {
        OrganizationListener.processOrganizationEntry(this, ctx);
    }

    @Override
    public void exitOrganizationStatement(GeneratedYangParser.OrganizationStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterContactStatement(GeneratedYangParser.ContactStatementContext ctx) {
        ContactListener.processContactEntry(this, ctx);
    }

    @Override
    public void exitContactStatement(GeneratedYangParser.ContactStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDescriptionStatement(GeneratedYangParser.DescriptionStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            DescriptionListener.processDescriptionEntry(this, ctx);
        }
    }

    @Override
    public void exitDescriptionStatement(GeneratedYangParser.DescriptionStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterReferenceStatement(GeneratedYangParser.ReferenceStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            ReferenceListener.processReferenceEntry(this, ctx);
        }
    }

    @Override
    public void exitReferenceStatement(GeneratedYangParser.ReferenceStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRevisionStatement(GeneratedYangParser.RevisionStatementContext ctx) {
        RevisionListener.processRevisionEntry(this, ctx);
    }

    @Override
    public void exitRevisionStatement(GeneratedYangParser.RevisionStatementContext ctx) {
        RevisionListener.processRevisionExit(this, ctx);
    }

    @Override
    public void enterRevisionStatementBody(GeneratedYangParser.RevisionStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRevisionStatementBody(GeneratedYangParser.RevisionStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterSubModuleStatement(GeneratedYangParser.SubModuleStatementContext ctx) {
        SubModuleListener.processSubModuleEntry(this, ctx);
    }

    @Override
    public void exitSubModuleStatement(GeneratedYangParser.SubModuleStatementContext ctx) {
        SubModuleListener.processSubModuleExit(this, ctx);
    }

    @Override
    public void enterSubmoduleBody(GeneratedYangParser.SubmoduleBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitSubmoduleBody(GeneratedYangParser.SubmoduleBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterSubmoduleHeaderStatement(GeneratedYangParser.SubmoduleHeaderStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitSubmoduleHeaderStatement(GeneratedYangParser.SubmoduleHeaderStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterBelongstoStatement(GeneratedYangParser.BelongstoStatementContext ctx) {
        BelongsToListener.processBelongsToEntry(this, ctx);
    }

    @Override
    public void exitBelongstoStatement(GeneratedYangParser.BelongstoStatementContext ctx) {
        BelongsToListener.processBelongsToExit(this, ctx);
    }

    @Override
    public void enterBelongstoStatementBody(GeneratedYangParser.BelongstoStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitBelongstoStatementBody(GeneratedYangParser.BelongstoStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterExtensionStatement(GeneratedYangParser.ExtensionStatementContext ctx) {
        ExtensionListener.processExtensionEntry(this, ctx);
    }

    @Override
    public void exitExtensionStatement(GeneratedYangParser.ExtensionStatementContext ctx) {
        ExtensionListener.processExtensionExit(this, ctx);
    }

    @Override
    public void enterExtensionBody(GeneratedYangParser.ExtensionBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitExtensionBody(GeneratedYangParser.ExtensionBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterArgumentStatement(GeneratedYangParser.ArgumentStatementContext ctx) {
        ArgumentListener.processArgumentEntry(this, ctx);
    }

    @Override
    public void exitArgumentStatement(GeneratedYangParser.ArgumentStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterArgumentBody(GeneratedYangParser.ArgumentBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitArgumentBody(GeneratedYangParser.ArgumentBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterYinElementStatement(GeneratedYangParser.YinElementStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitYinElementStatement(GeneratedYangParser.YinElementStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterIdentityStatement(GeneratedYangParser.IdentityStatementContext ctx) {
        IdentityListener.processIdentityEntry(this, ctx);
    }

    @Override
    public void exitIdentityStatement(GeneratedYangParser.IdentityStatementContext ctx) {
        IdentityListener.processIdentityExit(this, ctx);
    }

    @Override
    public void enterIdentityBody(GeneratedYangParser.IdentityBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitIdentityBody(GeneratedYangParser.IdentityBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterBaseStatement(GeneratedYangParser.BaseStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            BaseListener.processBaseEntry(this, ctx);
        }
    }

    @Override
    public void exitBaseStatement(GeneratedYangParser.BaseStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterFeatureStatement(GeneratedYangParser.FeatureStatementContext ctx) {
        FeatureListener.processFeatureEntry(this, ctx);
    }

    @Override
    public void exitFeatureStatement(GeneratedYangParser.FeatureStatementContext ctx) {
        FeatureListener.processFeatureExit(this, ctx);
    }

    @Override
    public void enterFeatureBody(GeneratedYangParser.FeatureBodyContext ctx) {
        // do nothing
    }

    @Override
    public void exitFeatureBody(GeneratedYangParser.FeatureBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDataDefStatement(GeneratedYangParser.DataDefStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitDataDefStatement(GeneratedYangParser.DataDefStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterIfFeatureStatement(GeneratedYangParser.IfFeatureStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            IfFeatureListener.processIfFeatureEntry(this, ctx);
        }
    }

    @Override
    public void exitIfFeatureStatement(GeneratedYangParser.IfFeatureStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterUnitsStatement(GeneratedYangParser.UnitsStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            UnitsListener.processUnitsEntry(this, ctx);
        }
    }

    @Override
    public void exitUnitsStatement(GeneratedYangParser.UnitsStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterTypedefStatement(GeneratedYangParser.TypedefStatementContext ctx) {
        TypeDefListener.processTypeDefEntry(this, ctx);
    }

    @Override
    public void exitTypedefStatement(GeneratedYangParser.TypedefStatementContext ctx) {
        TypeDefListener.processTypeDefExit(this, ctx);
    }

    @Override
    public void enterTypeStatement(GeneratedYangParser.TypeStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            TypeListener.processTypeEntry(this, ctx);
        }
    }

    @Override
    public void exitTypeStatement(GeneratedYangParser.TypeStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            TypeListener.processTypeExit(this, ctx);
        }
    }

    @Override
    public void enterTypeBodyStatements(GeneratedYangParser.TypeBodyStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitTypeBodyStatements(GeneratedYangParser.TypeBodyStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDecimal64Specification(GeneratedYangParser.Decimal64SpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            Decimal64Listener.processDecimal64Entry(this, ctx);
        }
    }

    @Override
    public void exitDecimal64Specification(GeneratedYangParser.Decimal64SpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            Decimal64Listener.processDecimal64Exit(this, ctx);
        }
    }

    @Override
    public void enterFractionDigitStatement(GeneratedYangParser.FractionDigitStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            FractionDigitsListener.processFractionDigitsEntry(this, ctx);
        }
    }

    @Override
    public void exitFractionDigitStatement(GeneratedYangParser.FractionDigitStatementContext currentContext) {
        // do nothing
    }

    @Override
    public void enterNumericalRestrictions(GeneratedYangParser.NumericalRestrictionsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitNumericalRestrictions(GeneratedYangParser.NumericalRestrictionsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRangeStatement(GeneratedYangParser.RangeStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            RangeRestrictionListener.processRangeRestrictionEntry(this, ctx);
        }
    }

    @Override
    public void exitRangeStatement(GeneratedYangParser.RangeStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            RangeRestrictionListener.processRangeRestrictionExit(this, ctx);
        }
    }

    @Override
    public void enterCommonStatements(GeneratedYangParser.CommonStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitCommonStatements(GeneratedYangParser.CommonStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterStringRestrictions(GeneratedYangParser.StringRestrictionsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitStringRestrictions(GeneratedYangParser.StringRestrictionsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterLengthStatement(GeneratedYangParser.LengthStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            LengthRestrictionListener.processLengthRestrictionEntry(this, ctx);
        }
    }

    @Override
    public void exitLengthStatement(GeneratedYangParser.LengthStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            LengthRestrictionListener.processLengthRestrictionExit(this, ctx);
        }
    }

    @Override
    public void enterPatternStatement(GeneratedYangParser.PatternStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            PatternRestrictionListener.processPatternRestrictionEntry(this, ctx);
        }
    }

    @Override
    public void exitPatternStatement(GeneratedYangParser.PatternStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            PatternRestrictionListener.processPatternRestrictionExit(this, ctx);
        }
    }

    @Override
    public void enterDefaultStatement(GeneratedYangParser.DefaultStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            DefaultListener.processDefaultEntry(this, ctx);
        }
    }

    @Override
    public void exitDefaultStatement(GeneratedYangParser.DefaultStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterEnumSpecification(GeneratedYangParser.EnumSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            EnumerationListener.processEnumerationEntry(this, ctx);
        }
    }

    @Override
    public void exitEnumSpecification(GeneratedYangParser.EnumSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            EnumerationListener.processEnumerationExit(this, ctx);
        }
    }

    @Override
    public void enterEnumStatement(GeneratedYangParser.EnumStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            EnumListener.processEnumEntry(this, ctx);
        }
    }

    @Override
    public void exitEnumStatement(GeneratedYangParser.EnumStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            EnumListener.processEnumExit(this, ctx);
        }
    }

    @Override
    public void enterEnumStatementBody(GeneratedYangParser.EnumStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitEnumStatementBody(GeneratedYangParser.EnumStatementBodyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterLeafrefSpecification(GeneratedYangParser.LeafrefSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            LeafrefListener.processLeafrefEntry(this, ctx);
        }
    }

    @Override
    public void exitLeafrefSpecification(GeneratedYangParser.LeafrefSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            LeafrefListener.processLeafrefExit(this, ctx);
        }
    }

    @Override
    public void enterPathStatement(GeneratedYangParser.PathStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            PathListener.processPathEntry(this, ctx);
        }
    }

    @Override
    public void exitPathStatement(GeneratedYangParser.PathStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRequireInstanceStatement(GeneratedYangParser.RequireInstanceStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            RequireInstanceListener.processRequireInstanceEntry(this, ctx);
        }
    }

    @Override
    public void exitRequireInstanceStatement(GeneratedYangParser.RequireInstanceStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterInstanceIdentifierSpecification(GeneratedYangParser.InstanceIdentifierSpecificationContext ctx) {
        // do nothing.
    }

    @Override
    public void exitInstanceIdentifierSpecification(GeneratedYangParser.InstanceIdentifierSpecificationContext ctx) {
        // do nothing.
    }

    @Override
    public void enterIdentityrefSpecification(GeneratedYangParser.IdentityrefSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            IdentityRefListener.processIdentityRefEntry(this, ctx);
        }
    }

    @Override
    public void exitIdentityrefSpecification(GeneratedYangParser.IdentityrefSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            IdentityRefListener.processIdentityRefExit(this, ctx);
        }
    }

    @Override
    public void enterUnionSpecification(GeneratedYangParser.UnionSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            UnionListener.processUnionEntry(this, ctx);
        }
    }

    @Override
    public void exitUnionSpecification(GeneratedYangParser.UnionSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            UnionListener.processUnionExit(this, ctx);
        }
    }

    @Override
    public void enterBitsSpecification(GeneratedYangParser.BitsSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            BitsListener.processBitsEntry(this, ctx);
        }
    }

    @Override
    public void exitBitsSpecification(GeneratedYangParser.BitsSpecificationContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            BitsListener.processBitsExit(this, ctx);
        }
    }

    @Override
    public void enterBitStatement(GeneratedYangParser.BitStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            BitListener.processBitEntry(this, ctx);
        }
    }

    @Override
    public void exitBitStatement(GeneratedYangParser.BitStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            BitListener.processBitExit(this, ctx);
        }
    }

    @Override
    public void enterBitBodyStatement(GeneratedYangParser.BitBodyStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitBitBodyStatement(GeneratedYangParser.BitBodyStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterPositionStatement(GeneratedYangParser.PositionStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            PositionListener.processPositionEntry(this, ctx);
        }
    }

    @Override
    public void exitPositionStatement(GeneratedYangParser.PositionStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterStatusStatement(GeneratedYangParser.StatusStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            StatusListener.processStatusEntry(this, ctx);
        }
    }

    @Override
    public void exitStatusStatement(GeneratedYangParser.StatusStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterConfigStatement(GeneratedYangParser.ConfigStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            ConfigListener.processConfigEntry(this, ctx);
        }
    }

    @Override
    public void exitConfigStatement(GeneratedYangParser.ConfigStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterMandatoryStatement(GeneratedYangParser.MandatoryStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            MandatoryListener.processMandatoryEntry(this, ctx);
        }
    }

    @Override
    public void exitMandatoryStatement(GeneratedYangParser.MandatoryStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterPresenceStatement(GeneratedYangParser.PresenceStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            PresenceListener.processPresenceEntry(this, ctx);
        }
    }

    @Override
    public void exitPresenceStatement(GeneratedYangParser.PresenceStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterOrderedByStatement(GeneratedYangParser.OrderedByStatementContext ctx) {
        handleUnsupportedYangConstruct(YangConstructType.ORDERED_BY_DATA, ctx, CURRENTLY_UNSUPPORTED, getFileName());
    }

    @Override
    public void exitOrderedByStatement(GeneratedYangParser.OrderedByStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterMustStatement(GeneratedYangParser.MustStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            MustListener.processMustEntry(this, ctx);
        }
    }

    @Override
    public void exitMustStatement(GeneratedYangParser.MustStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            MustListener.processMustExit(this, ctx);
        }
    }

    @Override
    public void enterErrorMessageStatement(GeneratedYangParser.ErrorMessageStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            ErrorMessageListener.processErrorMessageEntry(this, ctx);
        }
    }

    @Override
    public void exitErrorMessageStatement(GeneratedYangParser.ErrorMessageStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterErrorAppTagStatement(GeneratedYangParser.ErrorAppTagStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            ErrorAppTagListener.processErrorAppTagMessageEntry(this, ctx);
        }
    }

    @Override
    public void exitErrorAppTagStatement(GeneratedYangParser.ErrorAppTagStatementContext ctx) {
        //do nothing
    }

    @Override
    public void enterMinElementsStatement(GeneratedYangParser.MinElementsStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            MinElementsListener.processMinElementsEntry(this, ctx);
        }
    }

    @Override
    public void exitMinElementsStatement(GeneratedYangParser.MinElementsStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterMaxElementsStatement(GeneratedYangParser.MaxElementsStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            MaxElementsListener.processMaxElementsEntry(this, ctx);
        }
    }

    @Override
    public void exitMaxElementsStatement(GeneratedYangParser.MaxElementsStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterValueStatement(GeneratedYangParser.ValueStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            ValueListener.processValueEntry(this, ctx);
        }
    }

    @Override
    public void exitValueStatement(GeneratedYangParser.ValueStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterGroupingStatement(GeneratedYangParser.GroupingStatementContext ctx) {
        GroupingListener.processGroupingEntry(this, ctx);
    }

    @Override
    public void exitGroupingStatement(GeneratedYangParser.GroupingStatementContext ctx) {
        GroupingListener.processGroupingExit(this, ctx);
    }

    @Override
    public void enterContainerStatement(GeneratedYangParser.ContainerStatementContext ctx) {
        ContainerListener.processContainerEntry(this, ctx);
    }

    @Override
    public void exitContainerStatement(GeneratedYangParser.ContainerStatementContext ctx) {
        ContainerListener.processContainerExit(this, ctx);
    }

    @Override
    public void enterLeafStatement(GeneratedYangParser.LeafStatementContext ctx) {
        LeafListener.processLeafEntry(this, ctx);
    }

    @Override
    public void exitLeafStatement(GeneratedYangParser.LeafStatementContext ctx) {
        LeafListener.processLeafExit(this, ctx);
    }

    @Override
    public void enterLeafListStatement(GeneratedYangParser.LeafListStatementContext ctx) {
        LeafListListener.processLeafListEntry(this, ctx);
    }

    @Override
    public void exitLeafListStatement(GeneratedYangParser.LeafListStatementContext ctx) {
        LeafListListener.processLeafListExit(this, ctx);
    }

    @Override
    public void enterListStatement(GeneratedYangParser.ListStatementContext ctx) {
        ListListener.processListEntry(this, ctx);
    }

    @Override
    public void exitListStatement(GeneratedYangParser.ListStatementContext ctx) {
        ListListener.processListExit(this, ctx);
    }

    @Override
    public void enterKeyStatement(GeneratedYangParser.KeyStatementContext ctx) {
        KeyListener.processKeyEntry(this, ctx);
    }

    @Override
    public void exitKeyStatement(GeneratedYangParser.KeyStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterUniqueStatement(GeneratedYangParser.UniqueStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            UniqueListener.processUniqueEntry(this, ctx);
        }
    }

    @Override
    public void exitUniqueStatement(GeneratedYangParser.UniqueStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterChoiceStatement(GeneratedYangParser.ChoiceStatementContext ctx) {
        ChoiceListener.processChoiceEntry(this, ctx);
    }

    @Override
    public void exitChoiceStatement(GeneratedYangParser.ChoiceStatementContext ctx) {
        ChoiceListener.processChoiceExit(this, ctx);
    }

    @Override
    public void enterShortCaseStatement(GeneratedYangParser.ShortCaseStatementContext ctx) {
        ShortCaseListener.processShortCaseEntry(this, ctx);
    }

    @Override
    public void exitShortCaseStatement(GeneratedYangParser.ShortCaseStatementContext ctx) {
        ShortCaseListener.processShortCaseExit(this, ctx);
    }

    @Override
    public void enterCaseStatement(GeneratedYangParser.CaseStatementContext ctx) {
        CaseListener.processCaseEntry(this, ctx);
    }

    @Override
    public void exitCaseStatement(GeneratedYangParser.CaseStatementContext ctx) {
        CaseListener.processCaseExit(this, ctx);
    }

    @Override
    public void enterAnyxmlStatement(GeneratedYangParser.AnyxmlStatementContext ctx) {
        increaseUnsupportedYangConstructDepth();
        handleUnsupportedYangConstruct(YangConstructType.ANYXML_DATA, ctx, UNSUPPORTED_YANG_CONSTRUCT, getFileName());
    }

    @Override
    public void exitAnyxmlStatement(GeneratedYangParser.AnyxmlStatementContext ctx) {
        decreaseUnsupportedYangConstructDepth();
    }

    @Override
    public void enterUsesStatement(GeneratedYangParser.UsesStatementContext ctx) {
        UsesListener.processUsesEntry(this, ctx);
    }

    @Override
    public void exitUsesStatement(GeneratedYangParser.UsesStatementContext ctx) {
        UsesListener.processUsesExit(this, ctx);
    }

    @Override
    public void enterRefineStatement(GeneratedYangParser.RefineStatementContext ctx) {
        increaseUnsupportedYangConstructDepth();
        handleUnsupportedYangConstruct(YangConstructType.REFINE_DATA, ctx, UNSUPPORTED_YANG_CONSTRUCT, getFileName());
    }

    @Override
    public void exitRefineStatement(GeneratedYangParser.RefineStatementContext ctx) {
        decreaseUnsupportedYangConstructDepth();
    }

    @Override
    public void enterRefineContainerStatements(GeneratedYangParser.RefineContainerStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefineContainerStatements(GeneratedYangParser.RefineContainerStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRefineLeafStatements(GeneratedYangParser.RefineLeafStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefineLeafStatements(GeneratedYangParser.RefineLeafStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRefineLeafListStatements(GeneratedYangParser.RefineLeafListStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefineLeafListStatements(GeneratedYangParser.RefineLeafListStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRefineListStatements(GeneratedYangParser.RefineListStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefineListStatements(GeneratedYangParser.RefineListStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRefineChoiceStatements(GeneratedYangParser.RefineChoiceStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefineChoiceStatements(GeneratedYangParser.RefineChoiceStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRefineCaseStatements(GeneratedYangParser.RefineCaseStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefineCaseStatements(GeneratedYangParser.RefineCaseStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRefineAnyxmlStatements(GeneratedYangParser.RefineAnyxmlStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefineAnyxmlStatements(GeneratedYangParser.RefineAnyxmlStatementsContext ctx) {
        // do nothing.
    }

    @Override
    public void enterAugmentStatement(GeneratedYangParser.AugmentStatementContext ctx) {
        AugmentListener.processAugmentEntry(this, ctx);
    }

    @Override
    public void exitAugmentStatement(GeneratedYangParser.AugmentStatementContext ctx) {
        AugmentListener.processAugmentExit(this, ctx);
    }

    @Override
    public void enterWhenStatement(GeneratedYangParser.WhenStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            WhenListener.processWhenEntry(this, ctx);
        }
    }

    @Override
    public void exitWhenStatement(GeneratedYangParser.WhenStatementContext ctx) {
        if (getUnsupportedYangConstructDepth() == 0) {
            WhenListener.processWhenExit(this, ctx);
        }
    }

    @Override
    public void enterRpcStatement(GeneratedYangParser.RpcStatementContext ctx) {
        RpcListener.processRpcEntry(this, ctx);
    }

    @Override
    public void exitRpcStatement(GeneratedYangParser.RpcStatementContext ctx) {
        RpcListener.processRpcExit(this, ctx);
    }

    @Override
    public void enterInputStatement(GeneratedYangParser.InputStatementContext ctx) {
        InputListener.processInputEntry(this, ctx);
    }

    @Override
    public void exitInputStatement(GeneratedYangParser.InputStatementContext ctx) {
        InputListener.processInputExit(this, ctx);
    }

    @Override
    public void enterOutputStatement(GeneratedYangParser.OutputStatementContext ctx) {
        OutputListener.processOutputEntry(this, ctx);
    }

    @Override
    public void exitOutputStatement(GeneratedYangParser.OutputStatementContext ctx) {
        OutputListener.processOutputExit(this, ctx);
    }

    @Override
    public void enterNotificationStatement(GeneratedYangParser.NotificationStatementContext ctx) {
        NotificationListener.processNotificationEntry(this, ctx);
    }

    @Override
    public void exitNotificationStatement(GeneratedYangParser.NotificationStatementContext ctx) {
        NotificationListener.processNotificationExit(this, ctx);
    }

    @Override
    public void enterDeviationStatement(GeneratedYangParser.DeviationStatementContext ctx) {
        increaseUnsupportedYangConstructDepth();
        handleUnsupportedYangConstruct(YangConstructType.DEVIATION_DATA, ctx, UNSUPPORTED_YANG_CONSTRUCT,
                getFileName());
    }

    @Override
    public void exitDeviationStatement(GeneratedYangParser.DeviationStatementContext ctx) {
        decreaseUnsupportedYangConstructDepth();
    }

    @Override
    public void enterDeviateNotSupportedStatement(GeneratedYangParser.DeviateNotSupportedStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitDeviateNotSupportedStatement(GeneratedYangParser.DeviateNotSupportedStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDeviateAddStatement(GeneratedYangParser.DeviateAddStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitDeviateAddStatement(GeneratedYangParser.DeviateAddStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDeviateDeleteStatement(GeneratedYangParser.DeviateDeleteStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitDeviateDeleteStatement(GeneratedYangParser.DeviateDeleteStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDeviateReplaceStatement(GeneratedYangParser.DeviateReplaceStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void exitDeviateReplaceStatement(GeneratedYangParser.DeviateReplaceStatementContext ctx) {
        // do nothing.
    }

    @Override
    public void enterString(GeneratedYangParser.StringContext ctx) {
        // do nothing.
    }

    @Override
    public void exitString(GeneratedYangParser.StringContext ctx) {
        // do nothing.
    }

    @Override
    public void enterIdentifier(GeneratedYangParser.IdentifierContext ctx) {
        // do nothing.
    }

    @Override
    public void exitIdentifier(GeneratedYangParser.IdentifierContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDateArgumentString(GeneratedYangParser.DateArgumentStringContext ctx) {
        // do nothing.
    }

    @Override
    public void exitDateArgumentString(GeneratedYangParser.DateArgumentStringContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRange(GeneratedYangParser.RangeContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRange(GeneratedYangParser.RangeContext ctx) {
        // do nothing.
    }

    @Override
    public void enterLength(GeneratedYangParser.LengthContext ctx) {
        // do nothing.
    }

    @Override
    public void exitLength(GeneratedYangParser.LengthContext ctx) {
        // do nothing.
    }

    @Override
    public void enterPath(GeneratedYangParser.PathContext ctx) {
        // do nothing.
    }

    @Override
    public void exitPath(GeneratedYangParser.PathContext ctx) {
        // do nothing.
    }

    @Override
    public void enterPosition(GeneratedYangParser.PositionContext ctx) {
        // do nothing.
    }

    @Override
    public void exitPosition(GeneratedYangParser.PositionContext ctx) {
        // do nothing.
    }

    @Override
    public void enterStatus(GeneratedYangParser.StatusContext ctx) {
        // do nothing.
    }

    @Override
    public void exitStatus(GeneratedYangParser.StatusContext ctx) {
        // do nothing.
    }

    @Override
    public void enterConfig(GeneratedYangParser.ConfigContext ctx) {
        // do nothing.
    }

    @Override
    public void exitConfig(GeneratedYangParser.ConfigContext ctx) {
        // do nothing.
    }

    @Override
    public void enterMandatory(GeneratedYangParser.MandatoryContext ctx) {
        // do nothing.
    }

    @Override
    public void exitMandatory(GeneratedYangParser.MandatoryContext ctx) {
        // do nothing.
    }

    @Override
    public void enterOrderedBy(GeneratedYangParser.OrderedByContext ctx) {
        // do nothing.
    }

    @Override
    public void exitOrderedBy(GeneratedYangParser.OrderedByContext ctx) {
        // do nothing.
    }

    @Override
    public void enterMinValue(GeneratedYangParser.MinValueContext ctx) {
        // do nothing.
    }

    @Override
    public void exitMinValue(GeneratedYangParser.MinValueContext ctx) {
        // do nothing.
    }

    @Override
    public void enterMaxValue(GeneratedYangParser.MaxValueContext ctx) {
        // do nothing.
    }

    @Override
    public void exitMaxValue(GeneratedYangParser.MaxValueContext ctx) {
        // do nothing.
    }

    @Override
    public void enterKey(GeneratedYangParser.KeyContext ctx) {
        // do nothing.
    }

    @Override
    public void exitKey(GeneratedYangParser.KeyContext ctx) {
        // do nothing.
    }

    @Override
    public void enterUnique(GeneratedYangParser.UniqueContext ctx) {
        // do nothing.
    }

    @Override
    public void exitUnique(GeneratedYangParser.UniqueContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRefine(GeneratedYangParser.RefineContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRefine(GeneratedYangParser.RefineContext ctx) {
        // do nothing.
    }

    @Override
    public void enterAugment(GeneratedYangParser.AugmentContext ctx) {
        // do nothing.
    }

    @Override
    public void exitAugment(GeneratedYangParser.AugmentContext ctx) {
        // do nothing.
    }

    @Override
    public void enterDeviation(GeneratedYangParser.DeviationContext ctx) {
        // do nothing.
    }

    @Override
    public void exitDeviation(GeneratedYangParser.DeviationContext ctx) {
        // do nothing.
    }

    @Override
    public void enterYangConstruct(GeneratedYangParser.YangConstructContext ctx) {
        // do nothing.
    }

    @Override
    public void exitYangConstruct(GeneratedYangParser.YangConstructContext ctx) {
        // do nothing.
    }

    @Override
    public void enterCompilerAnnotationStatement(GeneratedYangParser.CompilerAnnotationStatementContext ctx) {
        CompilerAnnotationListener.processCompilerAnnotationEntry(this, ctx);
    }

    @Override
    public void exitCompilerAnnotationStatement(GeneratedYangParser.CompilerAnnotationStatementContext ctx) {
        CompilerAnnotationListener.processCompilerAnnotationExit(this, ctx);
    }

    @Override
    public void enterCompilerAnnotationBodyStatement(GeneratedYangParser.CompilerAnnotationBodyStatementContext ctx) {
        // do nothing
    }

    @Override
    public void exitCompilerAnnotationBodyStatement(GeneratedYangParser.CompilerAnnotationBodyStatementContext ctx) {
        // do nothing
    }

    @Override
    public void enterAppDataStructureStatement(GeneratedYangParser.AppDataStructureStatementContext ctx) {
        AppDataStructureListener.processAppDataStructureEntry(this, ctx);
    }

    @Override
    public void exitAppDataStructureStatement(GeneratedYangParser.AppDataStructureStatementContext ctx) {
        AppDataStructureListener.processAppDataStructureExit(this, ctx);
    }

    @Override
    public void enterAppDataStructure(GeneratedYangParser.AppDataStructureContext currentContext) {
        // do nothing
    }

    @Override
    public void exitAppDataStructure(GeneratedYangParser.AppDataStructureContext currentContext) {
        // do nothing
    }

    @Override
    public void enterAppExtendedStatement(GeneratedYangParser.AppExtendedStatementContext currentContext) {
        AppExtendedNameListener.processAppExtendedNameEntry(this, currentContext);
    }

    @Override
    public void exitAppExtendedStatement(GeneratedYangParser.AppExtendedStatementContext currentContext) {
        // TODO : to be implemented
    }

    @Override
    public void enterExtendedName(GeneratedYangParser.ExtendedNameContext currentContext) {
        // do nothing
    }

    @Override
    public void exitExtendedName(GeneratedYangParser.ExtendedNameContext currentContext) {
        // do nothing
    }

    @Override
    public void enterDataStructureKeyStatement(GeneratedYangParser.DataStructureKeyStatementContext ctx) {
        DataStructureKeyListener.processDataStructureKeyEntry(this, ctx);
    }

    @Override
    public void exitDataStructureKeyStatement(GeneratedYangParser.DataStructureKeyStatementContext ctx) {
        // do nothing
    }

    @Override
    public void enterVersion(GeneratedYangParser.VersionContext ctx) {
        // do nothing.
    }

    @Override
    public void exitVersion(GeneratedYangParser.VersionContext ctx) {
        // do nothing.
    }

    @Override
    public void enterValue(GeneratedYangParser.ValueContext ctx) {
        // do nothing.
    }

    @Override
    public void exitValue(GeneratedYangParser.ValueContext ctx) {
        // do nothing.
    }

    @Override
    public void enterRequireInstance(GeneratedYangParser.RequireInstanceContext ctx) {
        // do nothing.
    }

    @Override
    public void exitRequireInstance(GeneratedYangParser.RequireInstanceContext ctx) {
        // do nothing.
    }

    @Override
    public void enterFraction(GeneratedYangParser.FractionContext ctx) {
        // TODO: implement the method.
    }

    @Override
    public void exitFraction(GeneratedYangParser.FractionContext ctx) {
        // TODO: implement the method.
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {
        // do nothing.
    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {
        // do nothing.
    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        // do nothing.
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {
        // do nothing.
    }
}
