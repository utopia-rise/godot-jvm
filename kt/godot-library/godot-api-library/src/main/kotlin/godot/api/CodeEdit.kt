// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName7
import godot.core.PackedInt32Array
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal3
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * CodeEdit is a specialized [TextEdit] designed for editing plain text code files. It has many
 * features commonly found in code editors such as line numbers, line folding, code completion, indent
 * management, and string/comment management.
 *
 * **Note:** Regardless of locale, [CodeEdit] will by default always use left-to-right text
 * direction to correctly display source code.
 */
@GodotBaseType
public open class CodeEdit : TextEdit() {
  /**
   * Emitted when a breakpoint is added or removed from a line. If the line is removed via
   * backspace, a signal is emitted at the old line.
   */
  public val breakpointToggled: Signal1<Long> by Signal1

  /**
   * Emitted when the user requests code completion. This signal will not be sent if
   * [_requestCodeCompletion] is overridden or [codeCompletionEnabled] is `false`.
   */
  public val codeCompletionRequested: Signal0 by Signal0

  /**
   * Emitted when the user has clicked on a valid symbol.
   */
  public val symbolLookup: Signal3<String, Long, Long> by Signal3

  /**
   * Emitted when the user hovers over a symbol. The symbol should be validated and responded to, by
   * calling [setSymbolLookupWordAsValid].
   *
   * **Note:** [symbolLookupOnClick] must be `true` for this signal to be emitted.
   */
  public val symbolValidate: Signal1<String> by Signal1

  /**
   * Emitted when the user hovers over a symbol. Unlike [signal Control.mouse_entered], this signal
   * is not emitted immediately, but when the cursor is over the symbol for
   * [ProjectSettings.gui/timers/tooltipDelaySec] seconds.
   *
   * **Note:** [symbolTooltipOnHover] must be `true` for this signal to be emitted.
   */
  public val symbolHovered: Signal3<String, Long, Long> by Signal3

  /**
   * Set when a validated word from [signal symbol_validate] is clicked, the [signal symbol_lookup]
   * should be emitted.
   */
  public final inline var symbolLookupOnClick: Boolean
    @JvmName("symbolLookupOnClickProperty")
    get() = isSymbolLookupOnClickEnabled()
    @JvmName("symbolLookupOnClickProperty")
    set(`value`) {
      setSymbolLookupOnClickEnabled(value)
    }

  /**
   * If `true`, the [signal symbol_hovered] signal is emitted when hovering over a word.
   */
  public final inline var symbolTooltipOnHover: Boolean
    @JvmName("symbolTooltipOnHoverProperty")
    get() = isSymbolTooltipOnHoverEnabled()
    @JvmName("symbolTooltipOnHoverProperty")
    set(`value`) {
      setSymbolTooltipOnHoverEnabled(value)
    }

  /**
   * If `true`, lines can be folded. Otherwise, line folding methods like [foldLine] will not work
   * and [canFoldLine] will always return `false`. See [guttersDrawFoldGutter].
   */
  public final inline var lineFolding: Boolean
    @JvmName("lineFoldingProperty")
    get() = isLineFoldingEnabled()
    @JvmName("lineFoldingProperty")
    set(`value`) {
      setLineFoldingEnabled(value)
    }

  /**
   * Draws vertical lines at the provided columns. The first entry is considered a main hard
   * guideline and is drawn more prominently.
   */
  public final inline var lineLengthGuidelines: VariantArray<Long>
    @JvmName("lineLengthGuidelinesProperty")
    get() = getLineLengthGuidelines()
    @JvmName("lineLengthGuidelinesProperty")
    set(`value`) {
      setLineLengthGuidelines(value)
    }

  /**
   * If `true`, breakpoints are drawn in the gutter. This gutter is shared with bookmarks and
   * executing lines. Clicking the gutter will toggle the breakpoint for the line, see
   * [setLineAsBreakpoint].
   */
  public final inline var guttersDrawBreakpointsGutter: Boolean
    @JvmName("guttersDrawBreakpointsGutterProperty")
    get() = isDrawingBreakpointsGutter()
    @JvmName("guttersDrawBreakpointsGutterProperty")
    set(`value`) {
      setDrawBreakpointsGutter(value)
    }

  /**
   * If `true`, bookmarks are drawn in the gutter. This gutter is shared with breakpoints and
   * executing lines. See [setLineAsBookmarked].
   */
  public final inline var guttersDrawBookmarks: Boolean
    @JvmName("guttersDrawBookmarksProperty")
    get() = isDrawingBookmarksGutter()
    @JvmName("guttersDrawBookmarksProperty")
    set(`value`) {
      setDrawBookmarksGutter(value)
    }

  /**
   * If `true`, executing lines are marked in the gutter. This gutter is shared with breakpoints and
   * bookmarks. See [setLineAsExecuting].
   */
  public final inline var guttersDrawExecutingLines: Boolean
    @JvmName("guttersDrawExecutingLinesProperty")
    get() = isDrawingExecutingLinesGutter()
    @JvmName("guttersDrawExecutingLinesProperty")
    set(`value`) {
      setDrawExecutingLinesGutter(value)
    }

  /**
   * If `true`, the line number gutter is drawn. Line numbers start at `1` and are incremented for
   * each line of text. Clicking and dragging in the line number gutter will select entire lines of
   * text.
   */
  public final inline var guttersDrawLineNumbers: Boolean
    @JvmName("guttersDrawLineNumbersProperty")
    get() = isDrawLineNumbersEnabled()
    @JvmName("guttersDrawLineNumbersProperty")
    set(`value`) {
      setDrawLineNumbers(value)
    }

  /**
   * If `true`, line numbers drawn in the gutter are zero padded based on the total line count.
   * Requires [guttersDrawLineNumbers] to be set to `true`.
   */
  public final inline var guttersZeroPadLineNumbers: Boolean
    @JvmName("guttersZeroPadLineNumbersProperty")
    get() = isLineNumbersZeroPadded()
    @JvmName("guttersZeroPadLineNumbersProperty")
    set(`value`) {
      setLineNumbersZeroPadded(value)
    }

  /**
   * The minimum width in digits reserved for the line number gutter.
   */
  public final inline var guttersLineNumbersMinDigits: Int
    @JvmName("guttersLineNumbersMinDigitsProperty")
    get() = getLineNumbersMinDigits()
    @JvmName("guttersLineNumbersMinDigitsProperty")
    set(`value`) {
      setLineNumbersMinDigits(value)
    }

  /**
   * If `true`, the fold gutter is drawn. In this gutter, the [theme_item can_fold_code_region] icon
   * is drawn for each foldable line (see [canFoldLine]) and the [theme_item folded_code_region] icon
   * is drawn for each folded line (see [isLineFolded]). These icons can be clicked to toggle the fold
   * state, see [toggleFoldableLine]. [lineFolding] must be `true` to show icons.
   */
  public final inline var guttersDrawFoldGutter: Boolean
    @JvmName("guttersDrawFoldGutterProperty")
    get() = isDrawingFoldGutter()
    @JvmName("guttersDrawFoldGutterProperty")
    set(`value`) {
      setDrawFoldGutter(value)
    }

  /**
   * Sets the string delimiters. All existing string delimiters will be removed.
   */
  public final inline var delimiterStrings: VariantArray<String>
    @JvmName("delimiterStringsProperty")
    get() = getStringDelimiters()
    @JvmName("delimiterStringsProperty")
    set(`value`) {
      setStringDelimiters(value)
    }

  /**
   * Sets the comment delimiters. All existing comment delimiters will be removed.
   */
  public final inline var delimiterComments: VariantArray<String>
    @JvmName("delimiterCommentsProperty")
    get() = getCommentDelimiters()
    @JvmName("delimiterCommentsProperty")
    set(`value`) {
      setCommentDelimiters(value)
    }

  /**
   * If `true`, the [ProjectSettings.input/uiTextCompletionQuery] action requests code completion.
   * To handle it, see [_requestCodeCompletion] or [signal code_completion_requested].
   */
  public final inline var codeCompletionEnabled: Boolean
    @JvmName("codeCompletionEnabledProperty")
    get() = isCodeCompletionEnabled()
    @JvmName("codeCompletionEnabledProperty")
    set(`value`) {
      setCodeCompletionEnabled(value)
    }

  /**
   * Sets prefixes that will trigger code completion.
   */
  public final inline var codeCompletionPrefixes: VariantArray<String>
    @JvmName("codeCompletionPrefixesProperty")
    get() = getCodeCompletionPrefixes()
    @JvmName("codeCompletionPrefixesProperty")
    set(`value`) {
      setCodeCompletionPrefixes(value)
    }

  /**
   * Size of the tabulation indent (one [kbd]Tab[/kbd] press) in characters. If [indentUseSpaces] is
   * enabled the number of spaces to use.
   */
  public final inline var indentSize: Int
    @JvmName("indentSizeProperty")
    get() = getIndentSize()
    @JvmName("indentSizeProperty")
    set(`value`) {
      setIndentSize(value)
    }

  /**
   * Use spaces instead of tabs for indentation.
   */
  public final inline var indentUseSpaces: Boolean
    @JvmName("indentUseSpacesProperty")
    get() = isIndentUsingSpaces()
    @JvmName("indentUseSpacesProperty")
    set(`value`) {
      setIndentUsingSpaces(value)
    }

  /**
   * If `true`, an extra indent is automatically inserted when a new line is added and a prefix in
   * [indentAutomaticPrefixes] is found. If a brace pair opening key is found, the matching closing
   * brace will be moved to another new line (see [autoBraceCompletionPairs]).
   */
  public final inline var indentAutomatic: Boolean
    @JvmName("indentAutomaticProperty")
    get() = isAutoIndentEnabled()
    @JvmName("indentAutomaticProperty")
    set(`value`) {
      setAutoIndentEnabled(value)
    }

  /**
   * Prefixes to trigger an automatic indent. Used when [indentAutomatic] is set to `true`.
   */
  public final inline var indentAutomaticPrefixes: VariantArray<String>
    @JvmName("indentAutomaticPrefixesProperty")
    get() = getAutoIndentPrefixes()
    @JvmName("indentAutomaticPrefixesProperty")
    set(`value`) {
      setAutoIndentPrefixes(value)
    }

  /**
   * If `true`, uses [autoBraceCompletionPairs] to automatically insert the closing brace when the
   * opening brace is inserted by typing or autocompletion. Also automatically removes the closing
   * brace when using backspace on the opening brace.
   */
  public final inline var autoBraceCompletionEnabled: Boolean
    @JvmName("autoBraceCompletionEnabledProperty")
    get() = isAutoBraceCompletionEnabled()
    @JvmName("autoBraceCompletionEnabledProperty")
    set(`value`) {
      setAutoBraceCompletionEnabled(value)
    }

  /**
   * If `true`, highlights brace pairs when the caret is on either one, using
   * [autoBraceCompletionPairs]. If matching, the pairs will be underlined. If a brace is unmatched, it
   * is colored with [theme_item brace_mismatch_color].
   */
  public final inline var autoBraceCompletionHighlightMatching: Boolean
    @JvmName("autoBraceCompletionHighlightMatchingProperty")
    get() = isHighlightMatchingBracesEnabled()
    @JvmName("autoBraceCompletionHighlightMatchingProperty")
    set(`value`) {
      setHighlightMatchingBracesEnabled(value)
    }

  /**
   * Sets the brace pairs to be autocompleted. For each entry in the dictionary, the key is the
   * opening brace and the value is the closing brace that matches it. A brace is a [String] made of
   * symbols. See [autoBraceCompletionEnabled] and [autoBraceCompletionHighlightMatching].
   */
  public final inline var autoBraceCompletionPairs: Dictionary<Any?, Any?>
    @JvmName("autoBraceCompletionPairsProperty")
    get() = getAutoBraceCompletionPairs()
    @JvmName("autoBraceCompletionPairsProperty")
    set(`value`) {
      setAutoBraceCompletionPairs(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(161, scriptPtr)
  }

  /**
   * Override this method to define how the selected entry should be inserted. If [replace] is
   * `true`, any existing text should be replaced.
   */
  public open fun _confirmCodeCompletion(replace: Boolean): Unit {
    throw NotImplementedError("CodeEdit::_confirmCodeCompletion is not implemented.")
  }

  /**
   * Override this method to define what happens when the user requests code completion. If [force]
   * is `true`, any checks should be bypassed.
   */
  public open fun _requestCodeCompletion(force: Boolean): Unit {
    throw NotImplementedError("CodeEdit::_requestCodeCompletion is not implemented.")
  }

  /**
   * Override this method to define what items in [candidates] should be displayed.
   *
   * Both [candidates] and the return is an [VariantArray] of [Dictionary], see
   * [getCodeCompletionOption] for [Dictionary] content.
   */
  public open fun _filterCodeCompletionCandidates(candidates: VariantArray<Dictionary<Any?, Any?>>):
      VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("CodeEdit::_filterCodeCompletionCandidates is not implemented.")
  }

  public final fun setIndentSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setIndentSizePtr)
  }

  public final fun getIndentSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIndentSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setIndentUsingSpaces(useSpaces: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to useSpaces)
    TransferContext.callMethod(MethodBindings.setIndentUsingSpacesPtr)
  }

  public final fun isIndentUsingSpaces(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIndentUsingSpacesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoIndentEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoIndentEnabledPtr)
  }

  public final fun isAutoIndentEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoIndentEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoIndentPrefixes(prefixes: VariantArray<String>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to prefixes)
    TransferContext.callMethod(MethodBindings.setAutoIndentPrefixesPtr)
  }

  public final fun getAutoIndentPrefixes(): VariantArray<String> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutoIndentPrefixesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<String>)
  }

  /**
   * If there is no selection, indentation is inserted at the caret. Otherwise, the selected lines
   * are indented like [indentLines]. Equivalent to the [ProjectSettings.input/uiTextIndent] action.
   * The indentation characters used depend on [indentUseSpaces] and [indentSize].
   */
  public final fun doIndent(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.doIndentPtr)
  }

  /**
   * Indents all lines that are selected or have a caret on them. Uses spaces or a tab depending on
   * [indentUseSpaces]. See [unindentLines].
   */
  public final fun indentLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.indentLinesPtr)
  }

  /**
   * Unindents all lines that are selected or have a caret on them. Uses spaces or a tab depending
   * on [indentUseSpaces]. Equivalent to the [ProjectSettings.input/uiTextDedent] action. See
   * [indentLines].
   */
  public final fun unindentLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.unindentLinesPtr)
  }

  /**
   * Converts the indents of lines between [fromLine] and [toLine] to tabs or spaces as set by
   * [indentUseSpaces].
   *
   * Values of `-1` convert the entire text.
   */
  @JvmOverloads
  public final fun convertIndent(fromLine: Int = -1, toLine: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromLine.toLong(), LONG to toLine.toLong())
    TransferContext.callMethod(MethodBindings.convertIndentPtr)
  }

  public final fun setAutoBraceCompletionEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoBraceCompletionEnabledPtr)
  }

  public final fun isAutoBraceCompletionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoBraceCompletionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHighlightMatchingBracesEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHighlightMatchingBracesEnabledPtr)
  }

  public final fun isHighlightMatchingBracesEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHighlightMatchingBracesEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds a brace pair.
   *
   * Both the start and end keys must be symbols. Only the start key has to be unique.
   */
  public final fun addAutoBraceCompletionPair(startKey: String, endKey: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey, STRING to endKey)
    TransferContext.callMethod(MethodBindings.addAutoBraceCompletionPairPtr)
  }

  public final fun setAutoBraceCompletionPairs(pairs: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DICTIONARY to pairs)
    TransferContext.callMethod(MethodBindings.setAutoBraceCompletionPairsPtr)
  }

  public final fun getAutoBraceCompletionPairs(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutoBraceCompletionPairsPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns `true` if open key [openKey] exists.
   */
  public final fun hasAutoBraceCompletionOpenKey(openKey: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to openKey)
    TransferContext.callMethod(MethodBindings.hasAutoBraceCompletionOpenKeyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if close key [closeKey] exists.
   */
  public final fun hasAutoBraceCompletionCloseKey(closeKey: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to closeKey)
    TransferContext.callMethod(MethodBindings.hasAutoBraceCompletionCloseKeyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Gets the matching auto brace close key for [openKey].
   */
  public final fun getAutoBraceCompletionCloseKey(openKey: String): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to openKey)
    TransferContext.callMethod(MethodBindings.getAutoBraceCompletionCloseKeyPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setDrawBreakpointsGutter(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawBreakpointsGutterPtr)
  }

  public final fun isDrawingBreakpointsGutter(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingBreakpointsGutterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDrawBookmarksGutter(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawBookmarksGutterPtr)
  }

  public final fun isDrawingBookmarksGutter(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingBookmarksGutterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDrawExecutingLinesGutter(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawExecutingLinesGutterPtr)
  }

  public final fun isDrawingExecutingLinesGutter(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingExecutingLinesGutterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the given line as a breakpoint. If `true` and [guttersDrawBreakpointsGutter] is `true`,
   * draws the [theme_item breakpoint] icon in the gutter for this line. See [getBreakpointedLines] and
   * [isLineBreakpointed].
   */
  public final fun setLineAsBreakpoint(line: Int, breakpointed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), BOOL to breakpointed)
    TransferContext.callMethod(MethodBindings.setLineAsBreakpointPtr)
  }

  /**
   * Returns `true` if the given line is breakpointed. See [setLineAsBreakpoint].
   */
  public final fun isLineBreakpointed(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineBreakpointedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Clears all breakpointed lines.
   */
  public final fun clearBreakpointedLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearBreakpointedLinesPtr)
  }

  /**
   * Gets all breakpointed lines.
   */
  public final fun getBreakpointedLines(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBreakpointedLinesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Sets the given line as bookmarked. If `true` and [guttersDrawBookmarks] is `true`, draws the
   * [theme_item bookmark] icon in the gutter for this line. See [getBookmarkedLines] and
   * [isLineBookmarked].
   */
  public final fun setLineAsBookmarked(line: Int, bookmarked: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), BOOL to bookmarked)
    TransferContext.callMethod(MethodBindings.setLineAsBookmarkedPtr)
  }

  /**
   * Returns `true` if the given line is bookmarked. See [setLineAsBookmarked].
   */
  public final fun isLineBookmarked(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineBookmarkedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Clears all bookmarked lines.
   */
  public final fun clearBookmarkedLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearBookmarkedLinesPtr)
  }

  /**
   * Gets all bookmarked lines.
   */
  public final fun getBookmarkedLines(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBookmarkedLinesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Sets the given line as executing. If `true` and [guttersDrawExecutingLines] is `true`, draws
   * the [theme_item executing_line] icon in the gutter for this line. See [getExecutingLines] and
   * [isLineExecuting].
   */
  public final fun setLineAsExecuting(line: Int, executing: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), BOOL to executing)
    TransferContext.callMethod(MethodBindings.setLineAsExecutingPtr)
  }

  /**
   * Returns `true` if the given line is marked as executing. See [setLineAsExecuting].
   */
  public final fun isLineExecuting(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineExecutingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Clears all executed lines.
   */
  public final fun clearExecutingLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearExecutingLinesPtr)
  }

  /**
   * Gets all executing lines.
   */
  public final fun getExecutingLines(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExecutingLinesPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  public final fun setDrawLineNumbers(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawLineNumbersPtr)
  }

  public final fun isDrawLineNumbersEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawLineNumbersEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLineNumbersZeroPadded(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setLineNumbersZeroPaddedPtr)
  }

  public final fun isLineNumbersZeroPadded(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLineNumbersZeroPaddedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLineNumbersMinDigits(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setLineNumbersMinDigitsPtr)
  }

  public final fun getLineNumbersMinDigits(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineNumbersMinDigitsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setDrawFoldGutter(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawFoldGutterPtr)
  }

  public final fun isDrawingFoldGutter(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingFoldGutterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setLineFoldingEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setLineFoldingEnabledPtr)
  }

  public final fun isLineFoldingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isLineFoldingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given line is foldable. A line is foldable if it is the start of a valid
   * code region (see [getCodeRegionStartTag]), if it is the start of a comment or string block, or if
   * the next non-empty line is more indented (see [TextEdit.getIndentLevel]).
   */
  public final fun canFoldLine(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.canFoldLinePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Folds the given line, if possible (see [canFoldLine]).
   */
  public final fun foldLine(line: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.foldLinePtr)
  }

  /**
   * Unfolds the given line if it is folded or if it is hidden under a folded line.
   */
  public final fun unfoldLine(line: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.unfoldLinePtr)
  }

  /**
   * Folds all lines that are possible to be folded (see [canFoldLine]).
   */
  public final fun foldAllLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.foldAllLinesPtr)
  }

  /**
   * Unfolds all lines that are folded.
   */
  public final fun unfoldAllLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.unfoldAllLinesPtr)
  }

  /**
   * Toggle the folding of the code block at the given line.
   */
  public final fun toggleFoldableLine(line: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.toggleFoldableLinePtr)
  }

  /**
   * Toggle the folding of the code block on all lines with a caret on them.
   */
  public final fun toggleFoldableLinesAtCarets(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.toggleFoldableLinesAtCaretsPtr)
  }

  /**
   * Returns `true` if the given line is folded. See [foldLine].
   */
  public final fun isLineFolded(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineFoldedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns all lines that are currently folded.
   */
  public final fun getFoldedLines(): VariantArray<Long> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFoldedLinesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Long>)
  }

  /**
   * Creates a new code region with the selection. At least one single line comment delimiter have
   * to be defined (see [addCommentDelimiter]).
   *
   * A code region is a part of code that is highlighted when folded and can help organize your
   * script.
   *
   * Code region start and end tags can be customized (see [setCodeRegionTags]).
   *
   * Code regions are delimited using start and end tags (respectively `region` and `endregion` by
   * default) preceded by one line comment delimiter. (eg. `#region` and `#endregion`)
   */
  public final fun createCodeRegion(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createCodeRegionPtr)
  }

  /**
   * Returns the code region start tag (without comment delimiter).
   */
  public final fun getCodeRegionStartTag(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCodeRegionStartTagPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the code region end tag (without comment delimiter).
   */
  public final fun getCodeRegionEndTag(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCodeRegionEndTagPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the code region start and end tags (without comment delimiter).
   */
  @JvmOverloads
  public final fun setCodeRegionTags(start: String = "region", end: String = "endregion"): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to start, STRING to end)
    TransferContext.callMethod(MethodBindings.setCodeRegionTagsPtr)
  }

  /**
   * Returns `true` if the given line is a code region start. See [setCodeRegionTags].
   */
  public final fun isLineCodeRegionStart(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineCodeRegionStartPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given line is a code region end. See [setCodeRegionTags].
   */
  public final fun isLineCodeRegionEnd(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineCodeRegionEndPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Defines a string delimiter from [startKey] to [endKey]. Both keys should be symbols, and
   * [startKey] must not be shared with other delimiters.
   *
   * If [lineOnly] is `true` or [endKey] is an empty [String], the region does not carry over to the
   * next line.
   */
  @JvmOverloads
  public final fun addStringDelimiter(
    startKey: String,
    endKey: String,
    lineOnly: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey, STRING to endKey, BOOL to lineOnly)
    TransferContext.callMethod(MethodBindings.addStringDelimiterPtr)
  }

  /**
   * Removes the string delimiter with [startKey].
   */
  public final fun removeStringDelimiter(startKey: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey)
    TransferContext.callMethod(MethodBindings.removeStringDelimiterPtr)
  }

  /**
   * Returns `true` if string [startKey] exists.
   */
  public final fun hasStringDelimiter(startKey: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey)
    TransferContext.callMethod(MethodBindings.hasStringDelimiterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setStringDelimiters(stringDelimiters: VariantArray<String>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to stringDelimiters)
    TransferContext.callMethod(MethodBindings.setStringDelimitersPtr)
  }

  /**
   * Removes all string delimiters.
   */
  public final fun clearStringDelimiters(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearStringDelimitersPtr)
  }

  public final fun getStringDelimiters(): VariantArray<String> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStringDelimitersPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<String>)
  }

  /**
   * Returns the delimiter index if [line] [column] is in a string. If [column] is not provided,
   * will return the delimiter index if the entire [line] is a string. Otherwise `-1`.
   */
  @JvmOverloads
  public final fun isInString(line: Int, column: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.isInStringPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a comment delimiter from [startKey] to [endKey]. Both keys should be symbols, and
   * [startKey] must not be shared with other delimiters.
   *
   * If [lineOnly] is `true` or [endKey] is an empty [String], the region does not carry over to the
   * next line.
   */
  @JvmOverloads
  public final fun addCommentDelimiter(
    startKey: String,
    endKey: String,
    lineOnly: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey, STRING to endKey, BOOL to lineOnly)
    TransferContext.callMethod(MethodBindings.addCommentDelimiterPtr)
  }

  /**
   * Removes the comment delimiter with [startKey].
   */
  public final fun removeCommentDelimiter(startKey: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey)
    TransferContext.callMethod(MethodBindings.removeCommentDelimiterPtr)
  }

  /**
   * Returns `true` if comment [startKey] exists.
   */
  public final fun hasCommentDelimiter(startKey: String): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to startKey)
    TransferContext.callMethod(MethodBindings.hasCommentDelimiterPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCommentDelimiters(commentDelimiters: VariantArray<String>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to commentDelimiters)
    TransferContext.callMethod(MethodBindings.setCommentDelimitersPtr)
  }

  /**
   * Removes all comment delimiters.
   */
  public final fun clearCommentDelimiters(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearCommentDelimitersPtr)
  }

  public final fun getCommentDelimiters(): VariantArray<String> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCommentDelimitersPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<String>)
  }

  /**
   * Returns delimiter index if [line] [column] is in a comment. If [column] is not provided, will
   * return delimiter index if the entire [line] is a comment. Otherwise `-1`.
   */
  @JvmOverloads
  public final fun isInComment(line: Int, column: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.isInCommentPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets the start key for a string or comment region index.
   */
  public final fun getDelimiterStartKey(delimiterIndex: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to delimiterIndex.toLong())
    TransferContext.callMethod(MethodBindings.getDelimiterStartKeyPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Gets the end key for a string or comment region index.
   */
  public final fun getDelimiterEndKey(delimiterIndex: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to delimiterIndex.toLong())
    TransferContext.callMethod(MethodBindings.getDelimiterEndKeyPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * If [line] [column] is in a string or comment, returns the start position of the region. If not
   * or no start could be found, both [Vector2] values will be `-1`.
   */
  public final fun getDelimiterStartPosition(line: Int, column: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getDelimiterStartPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * If [line] [column] is in a string or comment, returns the end position of the region. If not or
   * no end could be found, both [Vector2] values will be `-1`.
   */
  public final fun getDelimiterEndPosition(line: Int, column: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getDelimiterEndPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Sets the code hint text. Pass an empty string to clear.
   */
  public final fun setCodeHint(codeHint: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to codeHint)
    TransferContext.callMethod(MethodBindings.setCodeHintPtr)
  }

  /**
   * If `true`, the code hint will draw below the main caret. If `false`, the code hint will draw
   * above the main caret. See [setCodeHint].
   */
  public final fun setCodeHintDrawBelow(drawBelow: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to drawBelow)
    TransferContext.callMethod(MethodBindings.setCodeHintDrawBelowPtr)
  }

  /**
   * Returns the full text with char `0xFFFF` at the caret location.
   */
  public final fun getTextForCodeCompletion(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextForCodeCompletionPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Emits [signal code_completion_requested], if [force] is `true` will bypass all checks.
   * Otherwise will check that the caret is in a word or in front of a prefix. Will ignore the request
   * if all current options are of type file path, node path, or signal.
   */
  @JvmOverloads
  public final fun requestCodeCompletion(force: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to force)
    TransferContext.callMethod(MethodBindings.requestCodeCompletionPtr)
  }

  /**
   * Submits an item to the queue of potential candidates for the autocomplete menu. Call
   * [updateCodeCompletionOptions] to update the list.
   *
   * [location] indicates location of the option relative to the location of the code completion
   * query. See [CodeEdit.CodeCompletionLocation] for how to set this value.
   *
   * **Note:** This list will replace all current candidates.
   */
  @JvmOverloads
  public final fun addCodeCompletionOption(
    type: CodeCompletionKind,
    displayText: String,
    insertText: String,
    textColor: Color = Color(Color(1, 1, 1, 1)),
    icon: Resource? = null,
    `value`: Any? = null,
    location: Int = 1024,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value, STRING to displayText, STRING to insertText, COLOR to textColor, OBJECT to icon, ANY to value, LONG to location.toLong())
    TransferContext.callMethod(MethodBindings.addCodeCompletionOptionPtr)
  }

  /**
   * Submits all completion options added with [addCodeCompletionOption]. Will try to force the
   * autocomplete menu to popup, if [force] is `true`.
   *
   * **Note:** This will replace all current candidates.
   */
  public final fun updateCodeCompletionOptions(force: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to force)
    TransferContext.callMethod(MethodBindings.updateCodeCompletionOptionsPtr)
  }

  /**
   * Gets all completion options, see [getCodeCompletionOption] for return content.
   */
  public final fun getCodeCompletionOptions(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCodeCompletionOptionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Gets the completion option at [index]. The return [Dictionary] has the following key-values:
   *
   * `kind`: [CodeCompletionKind]
   *
   * `display_text`: Text that is shown on the autocomplete menu.
   *
   * `insert_text`: Text that is to be inserted when this item is selected.
   *
   * `font_color`: Color of the text on the autocomplete menu.
   *
   * `icon`: Icon to draw on the autocomplete menu.
   *
   * `default_value`: Value of the symbol.
   */
  public final fun getCodeCompletionOption(index: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getCodeCompletionOptionPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Gets the index of the current selected completion option.
   */
  public final fun getCodeCompletionSelectedIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCodeCompletionSelectedIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the current selected completion option.
   */
  public final fun setCodeCompletionSelectedIndex(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.setCodeCompletionSelectedIndexPtr)
  }

  /**
   * Inserts the selected entry into the text. If [replace] is `true`, any existing text is replaced
   * rather than merged.
   */
  @JvmOverloads
  public final fun confirmCodeCompletion(replace: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to replace)
    TransferContext.callMethod(MethodBindings.confirmCodeCompletionPtr)
  }

  /**
   * Cancels the autocomplete menu.
   */
  public final fun cancelCodeCompletion(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cancelCodeCompletionPtr)
  }

  public final fun setCodeCompletionEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setCodeCompletionEnabledPtr)
  }

  public final fun isCodeCompletionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCodeCompletionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCodeCompletionPrefixes(prefixes: VariantArray<String>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to prefixes)
    TransferContext.callMethod(MethodBindings.setCodeCompletionPrefixesPtr)
  }

  public final fun getCodeCompletionPrefixes(): VariantArray<String> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCodeCompletionPrefixesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<String>)
  }

  public final fun setLineLengthGuidelines(guidelineColumns: VariantArray<Long>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to guidelineColumns)
    TransferContext.callMethod(MethodBindings.setLineLengthGuidelinesPtr)
  }

  public final fun getLineLengthGuidelines(): VariantArray<Long> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineLengthGuidelinesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Long>)
  }

  public final fun setSymbolLookupOnClickEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSymbolLookupOnClickEnabledPtr)
  }

  public final fun isSymbolLookupOnClickEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSymbolLookupOnClickEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the full text with char `0xFFFF` at the cursor location.
   */
  public final fun getTextForSymbolLookup(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextForSymbolLookupPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the full text with char `0xFFFF` at the specified location.
   */
  public final fun getTextWithCursorChar(line: Int, column: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getTextWithCursorCharPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the symbol emitted by [signal symbol_validate] as a valid lookup.
   */
  public final fun setSymbolLookupWordAsValid(valid: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to valid)
    TransferContext.callMethod(MethodBindings.setSymbolLookupWordAsValidPtr)
  }

  public final fun setSymbolTooltipOnHoverEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSymbolTooltipOnHoverEnabledPtr)
  }

  public final fun isSymbolTooltipOnHoverEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSymbolTooltipOnHoverEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Moves all lines up that are selected or have a caret on them.
   */
  public final fun moveLinesUp(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.moveLinesUpPtr)
  }

  /**
   * Moves all lines down that are selected or have a caret on them.
   */
  public final fun moveLinesDown(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.moveLinesDownPtr)
  }

  /**
   * Deletes all lines that are selected or have a caret on them.
   */
  public final fun deleteLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.deleteLinesPtr)
  }

  /**
   * Joins all selected lines or lines containing a caret with their next line. Whitespace in
   * between will be removed. If the next line has content, the [lineEnding] will be inserted in
   * between.
   */
  @JvmOverloads
  public final fun joinLines(lineEnding: String = " "): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to lineEnding)
    TransferContext.callMethod(MethodBindings.joinLinesPtr)
  }

  /**
   * Duplicates all selected text and duplicates all lines with a caret on them.
   */
  public final fun duplicateSelection(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.duplicateSelectionPtr)
  }

  /**
   * Duplicates all lines currently selected with any caret. Duplicates the entire line beneath the
   * current one no matter where the caret is within the line.
   */
  public final fun duplicateLines(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.duplicateLinesPtr)
  }

  public enum class CodeCompletionKind(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Marks the option as a class.
     */
    KIND_CLASS(0),
    /**
     * Marks the option as a function.
     */
    KIND_FUNCTION(1),
    /**
     * Marks the option as a Godot signal.
     */
    KIND_SIGNAL(2),
    /**
     * Marks the option as a variable.
     */
    KIND_VARIABLE(3),
    /**
     * Marks the option as a member.
     */
    KIND_MEMBER(4),
    /**
     * Marks the option as an enum entry.
     */
    KIND_ENUM(5),
    /**
     * Marks the option as a constant.
     */
    KIND_CONSTANT(6),
    /**
     * Marks the option as a Godot node path.
     */
    KIND_NODE_PATH(7),
    /**
     * Marks the option as a file path.
     */
    KIND_FILE_PATH(8),
    /**
     * Marks the option as unclassified or plain text.
     */
    KIND_PLAIN_TEXT(9),
    /**
     * Marks the option as a keyword.
     */
    KIND_KEYWORD(10),
    ;

    public companion object {
      public fun from(`value`: Long): CodeCompletionKind = entries.single { it.`value` == `value` }
    }
  }

  public enum class CodeCompletionLocation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The option is local to the location of the code completion query - e.g. a local variable.
     * Subsequent value of location represent options from the outer class, the exact value represent
     * how far they are (in terms of inner classes).
     */
    LOCATION_LOCAL(0),
    /**
     * The option is from the containing class or a parent class, relative to the location of the
     * code completion query. Perform a bitwise OR with the class depth (e.g. `0` for the local class,
     * `1` for the parent, `2` for the grandparent, etc.) to store the depth of an option in the class
     * or a parent class.
     */
    LOCATION_PARENT_MASK(256),
    /**
     * The option is from user code which is not local and not in a derived class (e.g. Autoload
     * Singletons).
     */
    LOCATION_OTHER_USER_CODE(512),
    /**
     * The option is from other engine code, not covered by the other enum constants - e.g. built-in
     * classes.
     */
    LOCATION_OTHER(1024),
    ;

    public companion object {
      public fun from(`value`: Long): CodeCompletionLocation =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setIndentSizeName: MethodStringName1<CodeEdit, Unit, Int> =
        MethodStringName1<CodeEdit, Unit, Int>("set_indent_size")

    @JvmField
    public val getIndentSizeName: MethodStringName0<CodeEdit, Int> =
        MethodStringName0<CodeEdit, Int>("get_indent_size")

    @JvmField
    public val setIndentUsingSpacesName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_indent_using_spaces")

    @JvmField
    public val isIndentUsingSpacesName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_indent_using_spaces")

    @JvmField
    public val setAutoIndentEnabledName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_auto_indent_enabled")

    @JvmField
    public val isAutoIndentEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_auto_indent_enabled")

    @JvmField
    public val setAutoIndentPrefixesName: MethodStringName1<CodeEdit, Unit, VariantArray<String>> =
        MethodStringName1<CodeEdit, Unit, VariantArray<String>>("set_auto_indent_prefixes")

    @JvmField
    public val getAutoIndentPrefixesName: MethodStringName0<CodeEdit, VariantArray<String>> =
        MethodStringName0<CodeEdit, VariantArray<String>>("get_auto_indent_prefixes")

    @JvmField
    public val doIndentName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("do_indent")

    @JvmField
    public val indentLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("indent_lines")

    @JvmField
    public val unindentLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("unindent_lines")

    @JvmField
    public val convertIndentName: MethodStringName2<CodeEdit, Unit, Int, Int> =
        MethodStringName2<CodeEdit, Unit, Int, Int>("convert_indent")

    @JvmField
    public val setAutoBraceCompletionEnabledName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_auto_brace_completion_enabled")

    @JvmField
    public val isAutoBraceCompletionEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_auto_brace_completion_enabled")

    @JvmField
    public val setHighlightMatchingBracesEnabledName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_highlight_matching_braces_enabled")

    @JvmField
    public val isHighlightMatchingBracesEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_highlight_matching_braces_enabled")

    @JvmField
    public val addAutoBraceCompletionPairName: MethodStringName2<CodeEdit, Unit, String, String> =
        MethodStringName2<CodeEdit, Unit, String, String>("add_auto_brace_completion_pair")

    @JvmField
    public val setAutoBraceCompletionPairsName:
        MethodStringName1<CodeEdit, Unit, Dictionary<Any?, Any?>> =
        MethodStringName1<CodeEdit, Unit, Dictionary<Any?, Any?>>("set_auto_brace_completion_pairs")

    @JvmField
    public val getAutoBraceCompletionPairsName: MethodStringName0<CodeEdit, Dictionary<Any?, Any?>>
        = MethodStringName0<CodeEdit, Dictionary<Any?, Any?>>("get_auto_brace_completion_pairs")

    @JvmField
    public val hasAutoBraceCompletionOpenKeyName: MethodStringName1<CodeEdit, Boolean, String> =
        MethodStringName1<CodeEdit, Boolean, String>("has_auto_brace_completion_open_key")

    @JvmField
    public val hasAutoBraceCompletionCloseKeyName: MethodStringName1<CodeEdit, Boolean, String> =
        MethodStringName1<CodeEdit, Boolean, String>("has_auto_brace_completion_close_key")

    @JvmField
    public val getAutoBraceCompletionCloseKeyName: MethodStringName1<CodeEdit, String, String> =
        MethodStringName1<CodeEdit, String, String>("get_auto_brace_completion_close_key")

    @JvmField
    public val setDrawBreakpointsGutterName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_draw_breakpoints_gutter")

    @JvmField
    public val isDrawingBreakpointsGutterName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_drawing_breakpoints_gutter")

    @JvmField
    public val setDrawBookmarksGutterName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_draw_bookmarks_gutter")

    @JvmField
    public val isDrawingBookmarksGutterName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_drawing_bookmarks_gutter")

    @JvmField
    public val setDrawExecutingLinesGutterName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_draw_executing_lines_gutter")

    @JvmField
    public val isDrawingExecutingLinesGutterName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_drawing_executing_lines_gutter")

    @JvmField
    public val setLineAsBreakpointName: MethodStringName2<CodeEdit, Unit, Int, Boolean> =
        MethodStringName2<CodeEdit, Unit, Int, Boolean>("set_line_as_breakpoint")

    @JvmField
    public val isLineBreakpointedName: MethodStringName1<CodeEdit, Boolean, Int> =
        MethodStringName1<CodeEdit, Boolean, Int>("is_line_breakpointed")

    @JvmField
    public val clearBreakpointedLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("clear_breakpointed_lines")

    @JvmField
    public val getBreakpointedLinesName: MethodStringName0<CodeEdit, PackedInt32Array> =
        MethodStringName0<CodeEdit, PackedInt32Array>("get_breakpointed_lines")

    @JvmField
    public val setLineAsBookmarkedName: MethodStringName2<CodeEdit, Unit, Int, Boolean> =
        MethodStringName2<CodeEdit, Unit, Int, Boolean>("set_line_as_bookmarked")

    @JvmField
    public val isLineBookmarkedName: MethodStringName1<CodeEdit, Boolean, Int> =
        MethodStringName1<CodeEdit, Boolean, Int>("is_line_bookmarked")

    @JvmField
    public val clearBookmarkedLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("clear_bookmarked_lines")

    @JvmField
    public val getBookmarkedLinesName: MethodStringName0<CodeEdit, PackedInt32Array> =
        MethodStringName0<CodeEdit, PackedInt32Array>("get_bookmarked_lines")

    @JvmField
    public val setLineAsExecutingName: MethodStringName2<CodeEdit, Unit, Int, Boolean> =
        MethodStringName2<CodeEdit, Unit, Int, Boolean>("set_line_as_executing")

    @JvmField
    public val isLineExecutingName: MethodStringName1<CodeEdit, Boolean, Int> =
        MethodStringName1<CodeEdit, Boolean, Int>("is_line_executing")

    @JvmField
    public val clearExecutingLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("clear_executing_lines")

    @JvmField
    public val getExecutingLinesName: MethodStringName0<CodeEdit, PackedInt32Array> =
        MethodStringName0<CodeEdit, PackedInt32Array>("get_executing_lines")

    @JvmField
    public val setDrawLineNumbersName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_draw_line_numbers")

    @JvmField
    public val isDrawLineNumbersEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_draw_line_numbers_enabled")

    @JvmField
    public val setLineNumbersZeroPaddedName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_line_numbers_zero_padded")

    @JvmField
    public val isLineNumbersZeroPaddedName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_line_numbers_zero_padded")

    @JvmField
    public val setLineNumbersMinDigitsName: MethodStringName1<CodeEdit, Unit, Int> =
        MethodStringName1<CodeEdit, Unit, Int>("set_line_numbers_min_digits")

    @JvmField
    public val getLineNumbersMinDigitsName: MethodStringName0<CodeEdit, Int> =
        MethodStringName0<CodeEdit, Int>("get_line_numbers_min_digits")

    @JvmField
    public val setDrawFoldGutterName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_draw_fold_gutter")

    @JvmField
    public val isDrawingFoldGutterName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_drawing_fold_gutter")

    @JvmField
    public val setLineFoldingEnabledName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_line_folding_enabled")

    @JvmField
    public val isLineFoldingEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_line_folding_enabled")

    @JvmField
    public val canFoldLineName: MethodStringName1<CodeEdit, Boolean, Int> =
        MethodStringName1<CodeEdit, Boolean, Int>("can_fold_line")

    @JvmField
    public val foldLineName: MethodStringName1<CodeEdit, Unit, Int> =
        MethodStringName1<CodeEdit, Unit, Int>("fold_line")

    @JvmField
    public val unfoldLineName: MethodStringName1<CodeEdit, Unit, Int> =
        MethodStringName1<CodeEdit, Unit, Int>("unfold_line")

    @JvmField
    public val foldAllLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("fold_all_lines")

    @JvmField
    public val unfoldAllLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("unfold_all_lines")

    @JvmField
    public val toggleFoldableLineName: MethodStringName1<CodeEdit, Unit, Int> =
        MethodStringName1<CodeEdit, Unit, Int>("toggle_foldable_line")

    @JvmField
    public val toggleFoldableLinesAtCaretsName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("toggle_foldable_lines_at_carets")

    @JvmField
    public val isLineFoldedName: MethodStringName1<CodeEdit, Boolean, Int> =
        MethodStringName1<CodeEdit, Boolean, Int>("is_line_folded")

    @JvmField
    public val getFoldedLinesName: MethodStringName0<CodeEdit, VariantArray<Long>> =
        MethodStringName0<CodeEdit, VariantArray<Long>>("get_folded_lines")

    @JvmField
    public val createCodeRegionName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("create_code_region")

    @JvmField
    public val getCodeRegionStartTagName: MethodStringName0<CodeEdit, String> =
        MethodStringName0<CodeEdit, String>("get_code_region_start_tag")

    @JvmField
    public val getCodeRegionEndTagName: MethodStringName0<CodeEdit, String> =
        MethodStringName0<CodeEdit, String>("get_code_region_end_tag")

    @JvmField
    public val setCodeRegionTagsName: MethodStringName2<CodeEdit, Unit, String, String> =
        MethodStringName2<CodeEdit, Unit, String, String>("set_code_region_tags")

    @JvmField
    public val isLineCodeRegionStartName: MethodStringName1<CodeEdit, Boolean, Int> =
        MethodStringName1<CodeEdit, Boolean, Int>("is_line_code_region_start")

    @JvmField
    public val isLineCodeRegionEndName: MethodStringName1<CodeEdit, Boolean, Int> =
        MethodStringName1<CodeEdit, Boolean, Int>("is_line_code_region_end")

    @JvmField
    public val addStringDelimiterName: MethodStringName3<CodeEdit, Unit, String, String, Boolean> =
        MethodStringName3<CodeEdit, Unit, String, String, Boolean>("add_string_delimiter")

    @JvmField
    public val removeStringDelimiterName: MethodStringName1<CodeEdit, Unit, String> =
        MethodStringName1<CodeEdit, Unit, String>("remove_string_delimiter")

    @JvmField
    public val hasStringDelimiterName: MethodStringName1<CodeEdit, Boolean, String> =
        MethodStringName1<CodeEdit, Boolean, String>("has_string_delimiter")

    @JvmField
    public val setStringDelimitersName: MethodStringName1<CodeEdit, Unit, VariantArray<String>> =
        MethodStringName1<CodeEdit, Unit, VariantArray<String>>("set_string_delimiters")

    @JvmField
    public val clearStringDelimitersName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("clear_string_delimiters")

    @JvmField
    public val getStringDelimitersName: MethodStringName0<CodeEdit, VariantArray<String>> =
        MethodStringName0<CodeEdit, VariantArray<String>>("get_string_delimiters")

    @JvmField
    public val isInStringName: MethodStringName2<CodeEdit, Int, Int, Int> =
        MethodStringName2<CodeEdit, Int, Int, Int>("is_in_string")

    @JvmField
    public val addCommentDelimiterName: MethodStringName3<CodeEdit, Unit, String, String, Boolean> =
        MethodStringName3<CodeEdit, Unit, String, String, Boolean>("add_comment_delimiter")

    @JvmField
    public val removeCommentDelimiterName: MethodStringName1<CodeEdit, Unit, String> =
        MethodStringName1<CodeEdit, Unit, String>("remove_comment_delimiter")

    @JvmField
    public val hasCommentDelimiterName: MethodStringName1<CodeEdit, Boolean, String> =
        MethodStringName1<CodeEdit, Boolean, String>("has_comment_delimiter")

    @JvmField
    public val setCommentDelimitersName: MethodStringName1<CodeEdit, Unit, VariantArray<String>> =
        MethodStringName1<CodeEdit, Unit, VariantArray<String>>("set_comment_delimiters")

    @JvmField
    public val clearCommentDelimitersName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("clear_comment_delimiters")

    @JvmField
    public val getCommentDelimitersName: MethodStringName0<CodeEdit, VariantArray<String>> =
        MethodStringName0<CodeEdit, VariantArray<String>>("get_comment_delimiters")

    @JvmField
    public val isInCommentName: MethodStringName2<CodeEdit, Int, Int, Int> =
        MethodStringName2<CodeEdit, Int, Int, Int>("is_in_comment")

    @JvmField
    public val getDelimiterStartKeyName: MethodStringName1<CodeEdit, String, Int> =
        MethodStringName1<CodeEdit, String, Int>("get_delimiter_start_key")

    @JvmField
    public val getDelimiterEndKeyName: MethodStringName1<CodeEdit, String, Int> =
        MethodStringName1<CodeEdit, String, Int>("get_delimiter_end_key")

    @JvmField
    public val getDelimiterStartPositionName: MethodStringName2<CodeEdit, Vector2, Int, Int> =
        MethodStringName2<CodeEdit, Vector2, Int, Int>("get_delimiter_start_position")

    @JvmField
    public val getDelimiterEndPositionName: MethodStringName2<CodeEdit, Vector2, Int, Int> =
        MethodStringName2<CodeEdit, Vector2, Int, Int>("get_delimiter_end_position")

    @JvmField
    public val setCodeHintName: MethodStringName1<CodeEdit, Unit, String> =
        MethodStringName1<CodeEdit, Unit, String>("set_code_hint")

    @JvmField
    public val setCodeHintDrawBelowName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_code_hint_draw_below")

    @JvmField
    public val getTextForCodeCompletionName: MethodStringName0<CodeEdit, String> =
        MethodStringName0<CodeEdit, String>("get_text_for_code_completion")

    @JvmField
    public val requestCodeCompletionName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("request_code_completion")

    @JvmField
    public val addCodeCompletionOptionName:
        MethodStringName7<CodeEdit, Unit, CodeCompletionKind, String, String, Color, Resource?, Any?, Int>
        =
        MethodStringName7<CodeEdit, Unit, CodeCompletionKind, String, String, Color, Resource?, Any?, Int>("add_code_completion_option")

    @JvmField
    public val updateCodeCompletionOptionsName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("update_code_completion_options")

    @JvmField
    public val getCodeCompletionOptionsName:
        MethodStringName0<CodeEdit, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<CodeEdit, VariantArray<Dictionary<Any?, Any?>>>("get_code_completion_options")

    @JvmField
    public val getCodeCompletionOptionName: MethodStringName1<CodeEdit, Dictionary<Any?, Any?>, Int>
        = MethodStringName1<CodeEdit, Dictionary<Any?, Any?>, Int>("get_code_completion_option")

    @JvmField
    public val getCodeCompletionSelectedIndexName: MethodStringName0<CodeEdit, Int> =
        MethodStringName0<CodeEdit, Int>("get_code_completion_selected_index")

    @JvmField
    public val setCodeCompletionSelectedIndexName: MethodStringName1<CodeEdit, Unit, Int> =
        MethodStringName1<CodeEdit, Unit, Int>("set_code_completion_selected_index")

    @JvmField
    public val confirmCodeCompletionName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("confirm_code_completion")

    @JvmField
    public val cancelCodeCompletionName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("cancel_code_completion")

    @JvmField
    public val setCodeCompletionEnabledName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_code_completion_enabled")

    @JvmField
    public val isCodeCompletionEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_code_completion_enabled")

    @JvmField
    public val setCodeCompletionPrefixesName:
        MethodStringName1<CodeEdit, Unit, VariantArray<String>> =
        MethodStringName1<CodeEdit, Unit, VariantArray<String>>("set_code_completion_prefixes")

    @JvmField
    public val getCodeCompletionPrefixesName: MethodStringName0<CodeEdit, VariantArray<String>> =
        MethodStringName0<CodeEdit, VariantArray<String>>("get_code_completion_prefixes")

    @JvmField
    public val setLineLengthGuidelinesName: MethodStringName1<CodeEdit, Unit, VariantArray<Long>> =
        MethodStringName1<CodeEdit, Unit, VariantArray<Long>>("set_line_length_guidelines")

    @JvmField
    public val getLineLengthGuidelinesName: MethodStringName0<CodeEdit, VariantArray<Long>> =
        MethodStringName0<CodeEdit, VariantArray<Long>>("get_line_length_guidelines")

    @JvmField
    public val setSymbolLookupOnClickEnabledName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_symbol_lookup_on_click_enabled")

    @JvmField
    public val isSymbolLookupOnClickEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_symbol_lookup_on_click_enabled")

    @JvmField
    public val getTextForSymbolLookupName: MethodStringName0<CodeEdit, String> =
        MethodStringName0<CodeEdit, String>("get_text_for_symbol_lookup")

    @JvmField
    public val getTextWithCursorCharName: MethodStringName2<CodeEdit, String, Int, Int> =
        MethodStringName2<CodeEdit, String, Int, Int>("get_text_with_cursor_char")

    @JvmField
    public val setSymbolLookupWordAsValidName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_symbol_lookup_word_as_valid")

    @JvmField
    public val setSymbolTooltipOnHoverEnabledName: MethodStringName1<CodeEdit, Unit, Boolean> =
        MethodStringName1<CodeEdit, Unit, Boolean>("set_symbol_tooltip_on_hover_enabled")

    @JvmField
    public val isSymbolTooltipOnHoverEnabledName: MethodStringName0<CodeEdit, Boolean> =
        MethodStringName0<CodeEdit, Boolean>("is_symbol_tooltip_on_hover_enabled")

    @JvmField
    public val moveLinesUpName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("move_lines_up")

    @JvmField
    public val moveLinesDownName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("move_lines_down")

    @JvmField
    public val deleteLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("delete_lines")

    @JvmField
    public val joinLinesName: MethodStringName1<CodeEdit, Unit, String> =
        MethodStringName1<CodeEdit, Unit, String>("join_lines")

    @JvmField
    public val duplicateSelectionName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("duplicate_selection")

    @JvmField
    public val duplicateLinesName: MethodStringName0<CodeEdit, Unit> =
        MethodStringName0<CodeEdit, Unit>("duplicate_lines")
  }

  public object MethodBindings {
    internal val setIndentSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_indent_size", 1286410249)

    internal val getIndentSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_indent_size", 3905245786)

    internal val setIndentUsingSpacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_indent_using_spaces", 2586408642)

    internal val isIndentUsingSpacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_indent_using_spaces", 36873697)

    internal val setAutoIndentEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_auto_indent_enabled", 2586408642)

    internal val isAutoIndentEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_auto_indent_enabled", 36873697)

    internal val setAutoIndentPrefixesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_auto_indent_prefixes", 381264803)

    internal val getAutoIndentPrefixesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_auto_indent_prefixes", 3995934104)

    internal val doIndentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "do_indent", 3218959716)

    internal val indentLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "indent_lines", 3218959716)

    internal val unindentLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "unindent_lines", 3218959716)

    internal val convertIndentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "convert_indent", 423910286)

    internal val setAutoBraceCompletionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_auto_brace_completion_enabled", 2586408642)

    internal val isAutoBraceCompletionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_auto_brace_completion_enabled", 36873697)

    internal val setHighlightMatchingBracesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_highlight_matching_braces_enabled", 2586408642)

    internal val isHighlightMatchingBracesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_highlight_matching_braces_enabled", 36873697)

    internal val addAutoBraceCompletionPairPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "add_auto_brace_completion_pair", 3186203200)

    internal val setAutoBraceCompletionPairsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_auto_brace_completion_pairs", 4155329257)

    internal val getAutoBraceCompletionPairsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_auto_brace_completion_pairs", 3102165223)

    internal val hasAutoBraceCompletionOpenKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "has_auto_brace_completion_open_key", 3927539163)

    internal val hasAutoBraceCompletionCloseKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "has_auto_brace_completion_close_key", 3927539163)

    internal val getAutoBraceCompletionCloseKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_auto_brace_completion_close_key", 3135753539)

    internal val setDrawBreakpointsGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_draw_breakpoints_gutter", 2586408642)

    internal val isDrawingBreakpointsGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_drawing_breakpoints_gutter", 36873697)

    internal val setDrawBookmarksGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_draw_bookmarks_gutter", 2586408642)

    internal val isDrawingBookmarksGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_drawing_bookmarks_gutter", 36873697)

    internal val setDrawExecutingLinesGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_draw_executing_lines_gutter", 2586408642)

    internal val isDrawingExecutingLinesGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_drawing_executing_lines_gutter", 36873697)

    internal val setLineAsBreakpointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_line_as_breakpoint", 300928843)

    internal val isLineBreakpointedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_breakpointed", 1116898809)

    internal val clearBreakpointedLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "clear_breakpointed_lines", 3218959716)

    internal val getBreakpointedLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_breakpointed_lines", 1930428628)

    internal val setLineAsBookmarkedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_line_as_bookmarked", 300928843)

    internal val isLineBookmarkedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_bookmarked", 1116898809)

    internal val clearBookmarkedLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "clear_bookmarked_lines", 3218959716)

    internal val getBookmarkedLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_bookmarked_lines", 1930428628)

    internal val setLineAsExecutingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_line_as_executing", 300928843)

    internal val isLineExecutingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_executing", 1116898809)

    internal val clearExecutingLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "clear_executing_lines", 3218959716)

    internal val getExecutingLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_executing_lines", 1930428628)

    internal val setDrawLineNumbersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_draw_line_numbers", 2586408642)

    internal val isDrawLineNumbersEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_draw_line_numbers_enabled", 36873697)

    internal val setLineNumbersZeroPaddedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_line_numbers_zero_padded", 2586408642)

    internal val isLineNumbersZeroPaddedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_numbers_zero_padded", 36873697)

    internal val setLineNumbersMinDigitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_line_numbers_min_digits", 1286410249)

    internal val getLineNumbersMinDigitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_line_numbers_min_digits", 3905245786)

    internal val setDrawFoldGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_draw_fold_gutter", 2586408642)

    internal val isDrawingFoldGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_drawing_fold_gutter", 36873697)

    internal val setLineFoldingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_line_folding_enabled", 2586408642)

    internal val isLineFoldingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_folding_enabled", 36873697)

    internal val canFoldLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "can_fold_line", 1116898809)

    internal val foldLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "fold_line", 1286410249)

    internal val unfoldLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "unfold_line", 1286410249)

    internal val foldAllLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "fold_all_lines", 3218959716)

    internal val unfoldAllLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "unfold_all_lines", 3218959716)

    internal val toggleFoldableLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "toggle_foldable_line", 1286410249)

    internal val toggleFoldableLinesAtCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "toggle_foldable_lines_at_carets", 3218959716)

    internal val isLineFoldedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_folded", 1116898809)

    internal val getFoldedLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_folded_lines", 3995934104)

    internal val createCodeRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "create_code_region", 3218959716)

    internal val getCodeRegionStartTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_code_region_start_tag", 201670096)

    internal val getCodeRegionEndTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_code_region_end_tag", 201670096)

    internal val setCodeRegionTagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_code_region_tags", 708800718)

    internal val isLineCodeRegionStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_code_region_start", 1116898809)

    internal val isLineCodeRegionEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_line_code_region_end", 1116898809)

    internal val addStringDelimiterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "add_string_delimiter", 3146098955)

    internal val removeStringDelimiterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "remove_string_delimiter", 83702148)

    internal val hasStringDelimiterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "has_string_delimiter", 3927539163)

    internal val setStringDelimitersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_string_delimiters", 381264803)

    internal val clearStringDelimitersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "clear_string_delimiters", 3218959716)

    internal val getStringDelimitersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_string_delimiters", 3995934104)

    internal val isInStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_in_string", 688195400)

    internal val addCommentDelimiterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "add_comment_delimiter", 3146098955)

    internal val removeCommentDelimiterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "remove_comment_delimiter", 83702148)

    internal val hasCommentDelimiterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "has_comment_delimiter", 3927539163)

    internal val setCommentDelimitersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_comment_delimiters", 381264803)

    internal val clearCommentDelimitersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "clear_comment_delimiters", 3218959716)

    internal val getCommentDelimitersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_comment_delimiters", 3995934104)

    internal val isInCommentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_in_comment", 688195400)

    internal val getDelimiterStartKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_delimiter_start_key", 844755477)

    internal val getDelimiterEndKeyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_delimiter_end_key", 844755477)

    internal val getDelimiterStartPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_delimiter_start_position", 3016396712)

    internal val getDelimiterEndPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_delimiter_end_position", 3016396712)

    internal val setCodeHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_code_hint", 83702148)

    internal val setCodeHintDrawBelowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_code_hint_draw_below", 2586408642)

    internal val getTextForCodeCompletionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_text_for_code_completion", 201670096)

    internal val requestCodeCompletionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "request_code_completion", 107499316)

    internal val addCodeCompletionOptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "add_code_completion_option", 3944379502)

    internal val updateCodeCompletionOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "update_code_completion_options", 2586408642)

    internal val getCodeCompletionOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_code_completion_options", 3995934104)

    internal val getCodeCompletionOptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_code_completion_option", 3485342025)

    internal val getCodeCompletionSelectedIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_code_completion_selected_index", 3905245786)

    internal val setCodeCompletionSelectedIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_code_completion_selected_index", 1286410249)

    internal val confirmCodeCompletionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "confirm_code_completion", 107499316)

    internal val cancelCodeCompletionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "cancel_code_completion", 3218959716)

    internal val setCodeCompletionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_code_completion_enabled", 2586408642)

    internal val isCodeCompletionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_code_completion_enabled", 36873697)

    internal val setCodeCompletionPrefixesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_code_completion_prefixes", 381264803)

    internal val getCodeCompletionPrefixesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_code_completion_prefixes", 3995934104)

    internal val setLineLengthGuidelinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_line_length_guidelines", 381264803)

    internal val getLineLengthGuidelinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_line_length_guidelines", 3995934104)

    internal val setSymbolLookupOnClickEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_symbol_lookup_on_click_enabled", 2586408642)

    internal val isSymbolLookupOnClickEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_symbol_lookup_on_click_enabled", 36873697)

    internal val getTextForSymbolLookupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_text_for_symbol_lookup", 201670096)

    internal val getTextWithCursorCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "get_text_with_cursor_char", 1391810591)

    internal val setSymbolLookupWordAsValidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_symbol_lookup_word_as_valid", 2586408642)

    internal val setSymbolTooltipOnHoverEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "set_symbol_tooltip_on_hover_enabled", 2586408642)

    internal val isSymbolTooltipOnHoverEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "is_symbol_tooltip_on_hover_enabled", 36873697)

    internal val moveLinesUpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "move_lines_up", 3218959716)

    internal val moveLinesDownPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "move_lines_down", 3218959716)

    internal val deleteLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "delete_lines", 3218959716)

    internal val joinLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "join_lines", 4063782979)

    internal val duplicateSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "duplicate_selection", 3218959716)

    internal val duplicateLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CodeEdit", "duplicate_lines", 3218959716)
  }
}
