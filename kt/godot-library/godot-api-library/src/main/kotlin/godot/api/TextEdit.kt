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
import godot.core.Callable
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.Signal0
import godot.core.Signal2
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.CALLABLE
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
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
 * A multiline text editor. It also has limited facilities for editing code, such as syntax
 * highlighting support. For more advanced facilities for editing code, see [CodeEdit].
 *
 * While entering text, it is possible to insert special characters using Unicode, OEM or Windows
 * alt codes:
 *
 * - To enter Unicode codepoints, hold [kbd]Alt[/kbd] and type the codepoint on the numpad. For
 * example, to enter the character `á` (U+00E1), hold [kbd]Alt[/kbd] and type [kbd]+E1[/kbd] on the
 * numpad (the leading zeroes can be omitted).
 *
 * - To enter OEM codepoints, hold [kbd]Alt[/kbd] and type the code on the numpad. For example, to
 * enter the character `á` (OEM 160), hold [kbd]Alt[/kbd] and type `160` on the numpad.
 *
 * - To enter Windows codepoints, hold [kbd]Alt[/kbd] and type the code on the numpad. For example,
 * to enter the character `á` (Windows 0225), hold [kbd]Alt[/kbd] and type [kbd]0[/kbd], [kbd]2[/kbd],
 * [kbd]2[/kbd], [kbd]5[/kbd] on the numpad. The leading zero here must **not** be omitted, as this is
 * how Windows codepoints are distinguished from OEM codepoints.
 *
 * **Note:** Most viewport, caret, and edit methods contain a `caret_index` argument for
 * [caretMultiple] support. The argument should be one of the following: `-1` for all carets, `0` for
 * the main caret, or greater than `0` for secondary carets in the order they were created.
 *
 * **Note:** When holding down [kbd]Alt[/kbd], the vertical scroll wheel will scroll 5 times as fast
 * as it would normally do. This also works in the Godot script editor.
 */
@GodotBaseType
public open class TextEdit : Control() {
  /**
   * Emitted when [clear] is called or [text] is set.
   */
  public val textSet: Signal0 by Signal0

  /**
   * Emitted when the text changes.
   */
  public val textChanged: Signal0 by Signal0

  /**
   * Emitted immediately when the text changes.
   *
   * When text is added [fromLine] will be less than [toLine]. On a remove [toLine] will be less
   * than [fromLine].
   */
  public val linesEditedFrom: Signal2<Long, Long> by Signal2

  /**
   * Emitted when any caret changes position.
   */
  public val caretChanged: Signal0 by Signal0

  /**
   * Emitted when a gutter is clicked.
   */
  public val gutterClicked: Signal2<Long, Long> by Signal2

  /**
   * Emitted when a gutter is added.
   */
  public val gutterAdded: Signal0 by Signal0

  /**
   * Emitted when a gutter is removed.
   */
  public val gutterRemoved: Signal0 by Signal0

  /**
   * String value of the [TextEdit].
   */
  public final inline var text: String
    @JvmName("textProperty")
    get() = getText()
    @JvmName("textProperty")
    set(`value`) {
      setText(value)
    }

  /**
   * Text shown when the [TextEdit] is empty. It is **not** the [TextEdit]'s default value (see
   * [text]).
   */
  public final inline var placeholderText: String
    @JvmName("placeholderTextProperty")
    get() = getPlaceholder()
    @JvmName("placeholderTextProperty")
    set(`value`) {
      setPlaceholder(value)
    }

  /**
   * If `false`, existing text cannot be modified and new text cannot be added.
   */
  public final inline var editable: Boolean
    @JvmName("editableProperty")
    get() = isEditable()
    @JvmName("editableProperty")
    set(`value`) {
      setEditable(value)
    }

  /**
   * If `true`, a right-click displays the context menu.
   */
  public final inline var contextMenuEnabled: Boolean
    @JvmName("contextMenuEnabledProperty")
    get() = isContextMenuEnabled()
    @JvmName("contextMenuEnabledProperty")
    set(`value`) {
      setContextMenuEnabled(value)
    }

  /**
   * If `true`, "Emoji and Symbols" menu is enabled.
   */
  public final inline var emojiMenuEnabled: Boolean
    @JvmName("emojiMenuEnabledProperty")
    get() = isEmojiMenuEnabled()
    @JvmName("emojiMenuEnabledProperty")
    set(`value`) {
      setEmojiMenuEnabled(value)
    }

  /**
   * If `true` and [caretMidGrapheme] is `false`, backspace deletes an entire composite character
   * such as ❤️‍🩹, instead of deleting part of the composite character.
   */
  public final inline var backspaceDeletesCompositeCharacterEnabled: Boolean
    @JvmName("backspaceDeletesCompositeCharacterEnabledProperty")
    get() = isBackspaceDeletesCompositeCharacterEnabled()
    @JvmName("backspaceDeletesCompositeCharacterEnabledProperty")
    set(`value`) {
      setBackspaceDeletesCompositeCharacterEnabled(value)
    }

  /**
   * If `true`, shortcut keys for context menu items are enabled, even if the context menu is
   * disabled.
   */
  public final inline var shortcutKeysEnabled: Boolean
    @JvmName("shortcutKeysEnabledProperty")
    get() = isShortcutKeysEnabled()
    @JvmName("shortcutKeysEnabledProperty")
    set(`value`) {
      setShortcutKeysEnabled(value)
    }

  /**
   * If `true`, text can be selected.
   *
   * If `false`, text can not be selected by the user or by the [select] or [selectAll] methods.
   */
  public final inline var selectingEnabled: Boolean
    @JvmName("selectingEnabledProperty")
    get() = isSelectingEnabled()
    @JvmName("selectingEnabledProperty")
    set(`value`) {
      setSelectingEnabled(value)
    }

  /**
   * If `true`, the selected text will be deselected when focus is lost.
   */
  public final inline var deselectOnFocusLossEnabled: Boolean
    @JvmName("deselectOnFocusLossEnabledProperty")
    get() = isDeselectOnFocusLossEnabled()
    @JvmName("deselectOnFocusLossEnabledProperty")
    set(`value`) {
      setDeselectOnFocusLossEnabled(value)
    }

  /**
   * If `true`, allow drag and drop of selected text. Text can still be dropped from other sources.
   */
  public final inline var dragAndDropSelectionEnabled: Boolean
    @JvmName("dragAndDropSelectionEnabledProperty")
    get() = isDragAndDropSelectionEnabled()
    @JvmName("dragAndDropSelectionEnabledProperty")
    set(`value`) {
      setDragAndDropSelectionEnabled(value)
    }

  /**
   * If `false`, using middle mouse button to paste clipboard will be disabled.
   *
   * **Note:** This method is only implemented on Linux.
   */
  public final inline var middleMousePasteEnabled: Boolean
    @JvmName("middleMousePasteEnabledProperty")
    get() = isMiddleMousePasteEnabled()
    @JvmName("middleMousePasteEnabledProperty")
    set(`value`) {
      setMiddleMousePasteEnabled(value)
    }

  /**
   * If `true`, copying or cutting without a selection is performed on all lines with a caret.
   * Otherwise, copy and cut require a selection.
   */
  public final inline var emptySelectionClipboardEnabled: Boolean
    @JvmName("emptySelectionClipboardEnabledProperty")
    get() = isEmptySelectionClipboardEnabled()
    @JvmName("emptySelectionClipboardEnabledProperty")
    set(`value`) {
      setEmptySelectionClipboardEnabled(value)
    }

  /**
   * Sets the line wrapping mode to use.
   */
  public final inline var wrapMode: LineWrappingMode
    @JvmName("wrapModeProperty")
    get() = getLineWrappingMode()
    @JvmName("wrapModeProperty")
    set(`value`) {
      setLineWrappingMode(value)
    }

  /**
   * If [wrapMode] is set to [LINE_WRAPPING_BOUNDARY], sets text wrapping mode.
   */
  public final inline var autowrapMode: TextServer.AutowrapMode
    @JvmName("autowrapModeProperty")
    get() = getAutowrapMode()
    @JvmName("autowrapModeProperty")
    set(`value`) {
      setAutowrapMode(value)
    }

  /**
   * If `true`, all wrapped lines are indented to the same amount as the unwrapped line.
   */
  public final inline var indentWrappedLines: Boolean
    @JvmName("indentWrappedLinesProperty")
    get() = isIndentWrappedLines()
    @JvmName("indentWrappedLinesProperty")
    set(`value`) {
      setIndentWrappedLines(value)
    }

  /**
   * If `true`, [ProjectSettings.input/uiTextIndent] input `Tab` character, otherwise it moves
   * keyboard focus to the next [Control] in the scene.
   */
  public final inline var tabInputMode: Boolean
    @JvmName("tabInputModeProperty")
    get() = getTabInputMode()
    @JvmName("tabInputModeProperty")
    set(`value`) {
      setTabInputMode(value)
    }

  /**
   * If `true`, the native virtual keyboard is enabled on platforms that support it.
   */
  public final inline var virtualKeyboardEnabled: Boolean
    @JvmName("virtualKeyboardEnabledProperty")
    get() = isVirtualKeyboardEnabled()
    @JvmName("virtualKeyboardEnabledProperty")
    set(`value`) {
      setVirtualKeyboardEnabled(value)
    }

  /**
   * If `true`, the native virtual keyboard is shown on focus events on platforms that support it.
   */
  public final inline var virtualKeyboardShowOnFocus: Boolean
    @JvmName("virtualKeyboardShowOnFocusProperty")
    get() = getVirtualKeyboardShowOnFocus()
    @JvmName("virtualKeyboardShowOnFocusProperty")
    set(`value`) {
      setVirtualKeyboardShowOnFocus(value)
    }

  /**
   * Scroll smoothly over the text rather than jumping to the next location.
   */
  public final inline var scrollSmooth: Boolean
    @JvmName("scrollSmoothProperty")
    get() = isSmoothScrollEnabled()
    @JvmName("scrollSmoothProperty")
    set(`value`) {
      setSmoothScrollEnabled(value)
    }

  /**
   * Sets the scroll speed with the minimap or when [scrollSmooth] is enabled.
   */
  public final inline var scrollVScrollSpeed: Float
    @JvmName("scrollVScrollSpeedProperty")
    get() = getVScrollSpeed()
    @JvmName("scrollVScrollSpeedProperty")
    set(`value`) {
      setVScrollSpeed(value)
    }

  /**
   * Allow scrolling past the last line into "virtual" space.
   */
  public final inline var scrollPastEndOfFile: Boolean
    @JvmName("scrollPastEndOfFileProperty")
    get() = isScrollPastEndOfFileEnabled()
    @JvmName("scrollPastEndOfFileProperty")
    set(`value`) {
      setScrollPastEndOfFileEnabled(value)
    }

  /**
   * If there is a vertical scrollbar, this determines the current vertical scroll value in line
   * numbers, starting at 0 for the top line.
   */
  public final inline var scrollVertical: Double
    @JvmName("scrollVerticalProperty")
    get() = getVScroll()
    @JvmName("scrollVerticalProperty")
    set(`value`) {
      setVScroll(value)
    }

  /**
   * If there is a horizontal scrollbar, this determines the current horizontal scroll value in
   * pixels.
   */
  public final inline var scrollHorizontal: Int
    @JvmName("scrollHorizontalProperty")
    get() = getHScroll()
    @JvmName("scrollHorizontalProperty")
    set(`value`) {
      setHScroll(value)
    }

  /**
   * If `true`, [TextEdit] fits its minimum height to the number of visible lines instead of
   * scrolling vertically. If a maximum height is set (for example via [Control.customMaximumSize]) and
   * content exceeds it, a vertical scrollbar is shown.
   */
  public final inline var scrollFitContentHeight: Boolean
    @JvmName("scrollFitContentHeightProperty")
    get() = isFitContentHeightEnabled()
    @JvmName("scrollFitContentHeightProperty")
    set(`value`) {
      setFitContentHeightEnabled(value)
    }

  /**
   * If `true`, [TextEdit] fits its minimum width to the widest line instead of scrolling
   * horizontally. If a maximum width is set (for example via [Control.customMaximumSize]) and content
   * exceeds it, a horizontal scrollbar is shown.
   */
  public final inline var scrollFitContentWidth: Boolean
    @JvmName("scrollFitContentWidthProperty")
    get() = isFitContentWidthEnabled()
    @JvmName("scrollFitContentWidthProperty")
    set(`value`) {
      setFitContentWidthEnabled(value)
    }

  /**
   * If `true`, a minimap is shown, providing an outline of your source code. The minimap uses a
   * fixed-width text size.
   */
  public final inline var minimapDraw: Boolean
    @JvmName("minimapDrawProperty")
    get() = isDrawingMinimap()
    @JvmName("minimapDrawProperty")
    set(`value`) {
      setDrawMinimap(value)
    }

  /**
   * The width, in pixels, of the minimap.
   */
  public final inline var minimapWidth: Int
    @JvmName("minimapWidthProperty")
    get() = getMinimapWidth()
    @JvmName("minimapWidthProperty")
    set(`value`) {
      setMinimapWidth(value)
    }

  /**
   * Set the type of caret to draw.
   */
  public final inline var caretType: CaretType
    @JvmName("caretTypeProperty")
    get() = getCaretType()
    @JvmName("caretTypeProperty")
    set(`value`) {
      setCaretType(value)
    }

  /**
   * If `true`, makes the caret blink.
   */
  public final inline var caretBlink: Boolean
    @JvmName("caretBlinkProperty")
    get() = isCaretBlinkEnabled()
    @JvmName("caretBlinkProperty")
    set(`value`) {
      setCaretBlinkEnabled(value)
    }

  /**
   * The interval at which the caret blinks (in seconds).
   */
  public final inline var caretBlinkInterval: Float
    @JvmName("caretBlinkIntervalProperty")
    get() = getCaretBlinkInterval()
    @JvmName("caretBlinkIntervalProperty")
    set(`value`) {
      setCaretBlinkInterval(value)
    }

  /**
   * If `true`, caret will be visible when [editable] is disabled.
   */
  public final inline var caretDrawWhenEditableDisabled: Boolean
    @JvmName("caretDrawWhenEditableDisabledProperty")
    get() = isDrawingCaretWhenEditableDisabled()
    @JvmName("caretDrawWhenEditableDisabledProperty")
    set(`value`) {
      setDrawCaretWhenEditableDisabled(value)
    }

  /**
   * If `true`, a right-click moves the caret at the mouse position before displaying the context
   * menu.
   *
   * If `false`, the context menu ignores mouse location.
   */
  public final inline var caretMoveOnRightClick: Boolean
    @JvmName("caretMoveOnRightClickProperty")
    get() = isMoveCaretOnRightClickEnabled()
    @JvmName("caretMoveOnRightClickProperty")
    set(`value`) {
      setMoveCaretOnRightClickEnabled(value)
    }

  /**
   * Allow moving caret, selecting and removing the individual composite character components.
   *
   * **Note:** [kbd]Backspace[/kbd] is always removing individual composite character components.
   */
  public final inline var caretMidGrapheme: Boolean
    @JvmName("caretMidGraphemeProperty")
    get() = isCaretMidGraphemeEnabled()
    @JvmName("caretMidGraphemeProperty")
    set(`value`) {
      setCaretMidGraphemeEnabled(value)
    }

  /**
   * If `true`, multiple carets are allowed. Left-clicking with [kbd]Alt[/kbd] adds a new caret. See
   * [addCaret] and [getCaretCount].
   */
  public final inline var caretMultiple: Boolean
    @JvmName("caretMultipleProperty")
    get() = isMultipleCaretsEnabled()
    @JvmName("caretMultipleProperty")
    set(`value`) {
      setMultipleCaretsEnabled(value)
    }

  /**
   * If `false`, using [kbd]Ctrl + Left[/kbd] or [kbd]Ctrl + Right[/kbd] ([kbd]Cmd + Left[/kbd] or
   * [kbd]Cmd + Right[/kbd] on macOS) bindings will stop moving caret only if a space or punctuation is
   * detected. If `true`, it will also stop the caret if a character is part of
   * `!"#$&#37;&'()*+,-./:;<=>?@[\]^`{|}~`, the Unicode General Punctuation table, or the Unicode CJK
   * Punctuation table. Useful for subword moving. This behavior also will be applied to the behavior
   * of text selection.
   */
  public final inline var useDefaultWordSeparators: Boolean
    @JvmName("useDefaultWordSeparatorsProperty")
    get() = isDefaultWordSeparatorsEnabled()
    @JvmName("useDefaultWordSeparatorsProperty")
    set(`value`) {
      setUseDefaultWordSeparators(value)
    }

  /**
   * If `false`, using [kbd]Ctrl + Left[/kbd] or [kbd]Ctrl + Right[/kbd] ([kbd]Cmd + Left[/kbd] or
   * [kbd]Cmd + Right[/kbd] on macOS) bindings will use the behavior of [useDefaultWordSeparators]. If
   * `true`, it will also stop the caret if a character within [customWordSeparators] is detected.
   * Useful for subword moving. This behavior also will be applied to the behavior of text selection.
   */
  public final inline var useCustomWordSeparators: Boolean
    @JvmName("useCustomWordSeparatorsProperty")
    get() = isCustomWordSeparatorsEnabled()
    @JvmName("useCustomWordSeparatorsProperty")
    set(`value`) {
      setUseCustomWordSeparators(value)
    }

  /**
   * The characters to consider as word delimiters if [useCustomWordSeparators] is `true`. The
   * characters should be defined without separation, for example `#_!`.
   */
  public final inline var customWordSeparators: String
    @JvmName("customWordSeparatorsProperty")
    get() = getCustomWordSeparators()
    @JvmName("customWordSeparatorsProperty")
    set(`value`) {
      setCustomWordSeparators(value)
    }

  /**
   * The syntax highlighter to use.
   *
   * **Note:** A [SyntaxHighlighter] instance should not be used across multiple [TextEdit] nodes.
   */
  public final inline var syntaxHighlighter: SyntaxHighlighter?
    @JvmName("syntaxHighlighterProperty")
    get() = getSyntaxHighlighter()
    @JvmName("syntaxHighlighterProperty")
    set(`value`) {
      setSyntaxHighlighter(value)
    }

  /**
   * If `true`, all occurrences of the selected text will be highlighted.
   */
  public final inline var highlightAllOccurrences: Boolean
    @JvmName("highlightAllOccurrencesProperty")
    get() = isHighlightAllOccurrencesEnabled()
    @JvmName("highlightAllOccurrencesProperty")
    set(`value`) {
      setHighlightAllOccurrences(value)
    }

  /**
   * If `true`, the line containing the cursor is highlighted.
   */
  public final inline var highlightCurrentLine: Boolean
    @JvmName("highlightCurrentLineProperty")
    get() = isHighlightCurrentLineEnabled()
    @JvmName("highlightCurrentLineProperty")
    set(`value`) {
      setHighlightCurrentLine(value)
    }

  /**
   * If `true`, control characters are displayed.
   */
  public final inline var drawControlChars: Boolean
    @JvmName("drawControlCharsProperty")
    get() = getDrawControlChars()
    @JvmName("drawControlCharsProperty")
    set(`value`) {
      setDrawControlChars(value)
    }

  /**
   * If `true`, the "tab" character will have a visible representation.
   */
  public final inline var drawTabs: Boolean
    @JvmName("drawTabsProperty")
    get() = isDrawingTabs()
    @JvmName("drawTabsProperty")
    set(`value`) {
      setDrawTabs(value)
    }

  /**
   * If `true`, the "space" character will have a visible representation.
   */
  public final inline var drawSpaces: Boolean
    @JvmName("drawSpacesProperty")
    get() = isDrawingSpaces()
    @JvmName("drawSpacesProperty")
    set(`value`) {
      setDrawSpaces(value)
    }

  /**
   * Base text writing direction.
   */
  public final inline var textDirection: Control.TextDirection
    @JvmName("textDirectionProperty")
    get() = getTextDirection()
    @JvmName("textDirectionProperty")
    set(`value`) {
      setTextDirection(value)
    }

  /**
   * Language code used for line-breaking and text shaping algorithms. If left empty, the current
   * locale is used instead.
   */
  public final inline var language: String
    @JvmName("languageProperty")
    get() = getLanguage()
    @JvmName("languageProperty")
    set(`value`) {
      setLanguage(value)
    }

  /**
   * Set BiDi algorithm override for the structured text.
   */
  public final inline var structuredTextBidiOverride: TextServer.StructuredTextParser
    @JvmName("structuredTextBidiOverrideProperty")
    get() = getStructuredTextBidiOverride()
    @JvmName("structuredTextBidiOverrideProperty")
    set(`value`) {
      setStructuredTextBidiOverride(value)
    }

  /**
   * Set additional options for BiDi override.
   */
  public final inline var structuredTextBidiOverrideOptions: VariantArray<Any?>
    @JvmName("structuredTextBidiOverrideOptionsProperty")
    get() = getStructuredTextBidiOverrideOptions()
    @JvmName("structuredTextBidiOverrideOptionsProperty")
    set(`value`) {
      setStructuredTextBidiOverrideOptions(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(730, scriptPtr)
  }

  /**
   * Override this method to define what happens when the user types in the provided key
   * [unicodeChar].
   */
  public open fun _handleUnicodeInput(unicodeChar: Int, caretIndex: Int): Unit {
    throw NotImplementedError("TextEdit::_handleUnicodeInput is not implemented.")
  }

  /**
   * Override this method to define what happens when the user presses the backspace key.
   */
  public open fun _backspace(caretIndex: Int): Unit {
    throw NotImplementedError("TextEdit::_backspace is not implemented.")
  }

  /**
   * Override this method to define what happens when the user performs a cut operation.
   */
  public open fun _cut(caretIndex: Int): Unit {
    throw NotImplementedError("TextEdit::_cut is not implemented.")
  }

  /**
   * Override this method to define what happens when the user performs a copy operation.
   */
  public open fun _copy(caretIndex: Int): Unit {
    throw NotImplementedError("TextEdit::_copy is not implemented.")
  }

  /**
   * Override this method to define what happens when the user performs a paste operation.
   */
  public open fun _paste(caretIndex: Int): Unit {
    throw NotImplementedError("TextEdit::_paste is not implemented.")
  }

  /**
   * Override this method to define what happens when the user performs a paste operation with
   * middle mouse button.
   *
   * **Note:** This method is only implemented on Linux.
   */
  public open fun _pastePrimaryClipboard(caretIndex: Int): Unit {
    throw NotImplementedError("TextEdit::_pastePrimaryClipboard is not implemented.")
  }

  /**
   * Returns `true` if the user has text in the
   * [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url] (IME).
   */
  public final fun hasImeText(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasImeTextPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Closes the [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url] (IME) if
   * it is open. Any text in the IME will be lost.
   */
  public final fun cancelIme(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cancelImePtr)
  }

  /**
   * Applies text from the [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url]
   * (IME) to each caret and closes the IME if it is open.
   */
  public final fun applyIme(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.applyImePtr)
  }

  public final fun setEditable(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEditablePtr)
  }

  public final fun isEditable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEditablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTextDirection(direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setTextDirectionPtr)
  }

  public final fun getTextDirection(): Control.TextDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextDirectionPtr)
    return Control.TextDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLanguage(language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to language)
    TransferContext.callMethod(MethodBindings.setLanguagePtr)
  }

  public final fun getLanguage(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setStructuredTextBidiOverride(parser: TextServer.StructuredTextParser): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to parser.value)
    TransferContext.callMethod(MethodBindings.setStructuredTextBidiOverridePtr)
  }

  public final fun getStructuredTextBidiOverride(): TextServer.StructuredTextParser {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStructuredTextBidiOverridePtr)
    return TextServer.StructuredTextParser.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStructuredTextBidiOverrideOptions(args: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to args)
    TransferContext.callMethod(MethodBindings.setStructuredTextBidiOverrideOptionsPtr)
  }

  public final fun getStructuredTextBidiOverrideOptions(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStructuredTextBidiOverrideOptionsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Sets the tab size for the [TextEdit] to use.
   */
  public final fun setTabSize(size: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to size.toLong())
    TransferContext.callMethod(MethodBindings.setTabSizePtr)
  }

  /**
   * Returns the [TextEdit]'s' tab size.
   */
  public final fun getTabSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setIndentWrappedLines(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setIndentWrappedLinesPtr)
  }

  public final fun isIndentWrappedLines(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIndentWrappedLinesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTabInputMode(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setTabInputModePtr)
  }

  public final fun getTabInputMode(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabInputModePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, enables overtype mode. In this mode, typing overrides existing text instead of
   * inserting text. The [ProjectSettings.input/uiTextToggleInsertMode] action toggles overtype mode.
   * See [isOvertypeModeEnabled].
   */
  public final fun setOvertypeModeEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setOvertypeModeEnabledPtr)
  }

  /**
   * Returns `true` if overtype mode is enabled. See [setOvertypeModeEnabled].
   */
  public final fun isOvertypeModeEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOvertypeModeEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setContextMenuEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setContextMenuEnabledPtr)
  }

  public final fun isContextMenuEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isContextMenuEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEmojiMenuEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEmojiMenuEnabledPtr)
  }

  public final fun isEmojiMenuEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmojiMenuEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setBackspaceDeletesCompositeCharacterEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setBackspaceDeletesCompositeCharacterEnabledPtr)
  }

  public final fun isBackspaceDeletesCompositeCharacterEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBackspaceDeletesCompositeCharacterEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShortcutKeysEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setShortcutKeysEnabledPtr)
  }

  public final fun isShortcutKeysEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShortcutKeysEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVirtualKeyboardEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setVirtualKeyboardEnabledPtr)
  }

  public final fun isVirtualKeyboardEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVirtualKeyboardEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVirtualKeyboardShowOnFocus(showOnFocus: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to showOnFocus)
    TransferContext.callMethod(MethodBindings.setVirtualKeyboardShowOnFocusPtr)
  }

  public final fun getVirtualKeyboardShowOnFocus(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVirtualKeyboardShowOnFocusPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMiddleMousePasteEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setMiddleMousePasteEnabledPtr)
  }

  public final fun isMiddleMousePasteEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMiddleMousePasteEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setEmptySelectionClipboardEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEmptySelectionClipboardEnabledPtr)
  }

  public final fun isEmptySelectionClipboardEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmptySelectionClipboardEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Performs a full reset of [TextEdit], including undo history.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  public final fun setText(text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text)
    TransferContext.callMethod(MethodBindings.setTextPtr)
  }

  public final fun getText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the number of lines in the text.
   */
  public final fun getLineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setPlaceholder(text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text)
    TransferContext.callMethod(MethodBindings.setPlaceholderPtr)
  }

  public final fun getPlaceholder(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaceholderPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the text for a specific [line].
   *
   * Carets on the line will attempt to keep their visual x position.
   */
  public final fun setLine(line: Int, newText: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), STRING to newText)
    TransferContext.callMethod(MethodBindings.setLinePtr)
  }

  /**
   * Returns the text of a specific line.
   */
  public final fun getLine(line: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getLinePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns line text as it is currently displayed, including IME composition string.
   */
  public final fun getLineWithIme(line: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getLineWithImePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the width in pixels of the [wrapIndex] on [line].
   */
  @JvmOverloads
  public final fun getLineWidth(line: Int, wrapIndex: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to wrapIndex.toLong())
    TransferContext.callMethod(MethodBindings.getLineWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the maximum value of the line height among all lines.
   *
   * **Note:** The return value is influenced by [theme_item line_spacing] and [theme_item
   * font_size]. And it will not be less than `1`.
   */
  public final fun getLineHeight(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineHeightPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the indent level of the given line. This is the number of spaces and tabs at the
   * beginning of the line, with the tabs taking the tab size into account (see [getTabSize]).
   */
  public final fun getIndentLevel(line: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getIndentLevelPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the first column containing a non-whitespace character on the given line. If there is
   * only whitespace, returns the number of characters.
   */
  public final fun getFirstNonWhitespaceColumn(line: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getFirstNonWhitespaceColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Swaps the two lines. Carets will be swapped with the lines.
   */
  public final fun swapLines(fromLine: Int, toLine: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromLine.toLong(), LONG to toLine.toLong())
    TransferContext.callMethod(MethodBindings.swapLinesPtr)
  }

  /**
   * Inserts a new line with [text] at [line].
   */
  public final fun insertLineAt(line: Int, text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), STRING to text)
    TransferContext.callMethod(MethodBindings.insertLineAtPtr)
  }

  /**
   * Removes the line of text at [line]. Carets on this line will attempt to match their previous
   * visual x position.
   *
   * If [moveCaretsDown] is `true` carets will move to the next line down, otherwise carets will
   * move up.
   */
  @JvmOverloads
  public final fun removeLineAt(line: Int, moveCaretsDown: Boolean = true): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), BOOL to moveCaretsDown)
    TransferContext.callMethod(MethodBindings.removeLineAtPtr)
  }

  /**
   * Insert the specified text at the caret position.
   */
  @JvmOverloads
  public final fun insertTextAtCaret(text: String, caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.insertTextAtCaretPtr)
  }

  /**
   * Inserts the [text] at [line] and [column].
   *
   * If [beforeSelectionBegin] is `true`, carets and selections that begin at [line] and [column]
   * will moved to the end of the inserted text, along with all carets after it.
   *
   * If [beforeSelectionEnd] is `true`, selections that end at [line] and [column] will be extended
   * to the end of the inserted text. These parameters can be used to insert text inside of or outside
   * of selections.
   */
  @JvmOverloads
  public final fun insertText(
    text: String,
    line: Int,
    column: Int,
    beforeSelectionBegin: Boolean = true,
    beforeSelectionEnd: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text, LONG to line.toLong(), LONG to column.toLong(), BOOL to beforeSelectionBegin, BOOL to beforeSelectionEnd)
    TransferContext.callMethod(MethodBindings.insertTextPtr)
  }

  /**
   * Removes text between the given positions.
   */
  public final fun removeText(
    fromLine: Int,
    fromColumn: Int,
    toLine: Int,
    toColumn: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromLine.toLong(), LONG to fromColumn.toLong(), LONG to toLine.toLong(), LONG to toColumn.toLong())
    TransferContext.callMethod(MethodBindings.removeTextPtr)
  }

  /**
   * Returns the last unhidden line in the entire [TextEdit].
   */
  public final fun getLastUnhiddenLine(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastUnhiddenLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the count to the next visible line from [line] to `line + visible_amount`. Can also
   * count backwards. For example if a [TextEdit] has 5 lines with lines 2 and 3 hidden, calling this
   * with `line = 1, visible_amount = 1` would return 3.
   */
  public final fun getNextVisibleLineOffsetFrom(line: Int, visibleAmount: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to visibleAmount.toLong())
    TransferContext.callMethod(MethodBindings.getNextVisibleLineOffsetFromPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Similar to [getNextVisibleLineOffsetFrom], but takes into account the line wrap indexes. In the
   * returned vector, `x` is the line, `y` is the wrap index.
   */
  public final fun getNextVisibleLineIndexOffsetFrom(
    line: Int,
    wrapIndex: Int,
    visibleAmount: Int,
  ): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to wrapIndex.toLong(), LONG to visibleAmount.toLong())
    TransferContext.callMethod(MethodBindings.getNextVisibleLineIndexOffsetFromPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Called when the user presses the backspace key. Can be overridden with [_backspace].
   */
  @JvmOverloads
  public final fun backspace(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.backspacePtr)
  }

  /**
   * Cut's the current selection. Can be overridden with [_cut].
   */
  @JvmOverloads
  public final fun cut(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.cutPtr)
  }

  /**
   * Copies the current text selection. Can be overridden with [_copy].
   */
  @JvmOverloads
  public final fun copy(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.copyPtr)
  }

  /**
   * Paste at the current location. Can be overridden with [_paste].
   */
  @JvmOverloads
  public final fun paste(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.pastePtr)
  }

  /**
   * Pastes the primary clipboard.
   */
  @JvmOverloads
  public final fun pastePrimaryClipboard(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.pastePrimaryClipboardPtr)
  }

  /**
   * Starts an action, will end the current action if [action] is different.
   *
   * An action will also end after a call to [endAction], after
   * [ProjectSettings.gui/timers/textEditIdleDetectSec] is triggered or a new undoable step outside the
   * [startAction] and [endAction] calls.
   */
  public final fun startAction(action: EditAction): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to action.value)
    TransferContext.callMethod(MethodBindings.startActionPtr)
  }

  /**
   * Marks the end of steps in the current action started with [startAction].
   */
  public final fun endAction(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.endActionPtr)
  }

  /**
   * Starts a multipart edit. All edits will be treated as one action until [endComplexOperation] is
   * called.
   */
  public final fun beginComplexOperation(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.beginComplexOperationPtr)
  }

  /**
   * Ends a multipart edit, started with [beginComplexOperation]. If called outside a complex
   * operation, the current operation is pushed onto the undo/redo stack.
   */
  public final fun endComplexOperation(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.endComplexOperationPtr)
  }

  /**
   * Returns `true` if an "undo" action is available.
   */
  public final fun hasUndo(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasUndoPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if a "redo" action is available.
   */
  public final fun hasRedo(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasRedoPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Perform undo operation.
   */
  public final fun undo(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.undoPtr)
  }

  /**
   * Perform redo operation.
   */
  public final fun redo(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.redoPtr)
  }

  /**
   * Clears the undo history.
   */
  public final fun clearUndoHistory(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearUndoHistoryPtr)
  }

  /**
   * Tag the current version as saved.
   */
  public final fun tagSavedVersion(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.tagSavedVersionPtr)
  }

  /**
   * Returns the current version of the [TextEdit]. The version is a count of recorded operations by
   * the undo/redo history.
   */
  public final fun getVersion(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVersionPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the last tagged saved version from [tagSavedVersion].
   */
  public final fun getSavedVersion(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSavedVersionPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the search text. See [setSearchFlags].
   */
  public final fun setSearchText(searchText: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to searchText)
    TransferContext.callMethod(MethodBindings.setSearchTextPtr)
  }

  /**
   * Sets the search [flags]. This is used with [setSearchText] to highlight occurrences of the
   * searched text. Search flags can be specified from the [SearchFlags] enum.
   */
  public final fun setSearchFlags(flags: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to flags)
    TransferContext.callMethod(MethodBindings.setSearchFlagsPtr)
  }

  /**
   * Perform a search inside the text. Search flags can be specified in the [SearchFlags] enum.
   *
   * In the returned vector, `x` is the column, `y` is the line. If no results are found, both are
   * equal to `-1`.
   *
   * ```gdscript
   * //gdscript
   * var result = search("print", SEARCH_WHOLE_WORDS, 0, 0)
   * if result.x != -1:
   * 	# Result found.
   * 	var line_number = result.y
   * 	var column_number = result.x
   * ```
   *
   * ```csharp
   * //csharp
   * Vector2I result = Search("print", (uint)TextEdit.SearchFlags.WholeWords, 0, 0);
   * if (result.X != -1)
   * {
   * 	// Result found.
   * 	int lineNumber = result.Y;
   * 	int columnNumber = result.X;
   * }
   * ```
   */
  public final fun search(
    text: String,
    flags: Long,
    fromLine: Int,
    fromColumn: Int,
  ): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text, LONG to flags, LONG to fromLine.toLong(), LONG to fromColumn.toLong())
    TransferContext.callMethod(MethodBindings.searchPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Provide custom tooltip text. The callback method must take the following args: `hovered_word:
   * String`.
   */
  public final fun setTooltipRequestFunc(callback: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, CALLABLE to callback)
    TransferContext.callMethod(MethodBindings.setTooltipRequestFuncPtr)
  }

  /**
   * Returns the local mouse position adjusted for the text direction.
   */
  public final fun getLocalMousePos(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalMousePosPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the word at [position].
   */
  public final fun getWordAtPos(position: Vector2): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.getWordAtPosPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the line and column at the given position. In the returned vector, `x` is the column
   * and `y` is the line.
   *
   * If [clampLine] is `false` and [position] is below the last line, `Vector2i(-1, -1)` is
   * returned.
   *
   * If [clampColumn] is `false` and [position] is outside the column range of the line,
   * `Vector2i(-1, -1)` is returned.
   */
  @JvmOverloads
  public final fun getLineColumnAtPos(
    position: Vector2i,
    clampLine: Boolean = true,
    clampColumn: Boolean = true,
  ): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position, BOOL to clampLine, BOOL to clampColumn)
    TransferContext.callMethod(MethodBindings.getLineColumnAtPosPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the local position for the given [line] and [column]. If `x` or `y` of the returned
   * vector equal `-1`, the position is outside of the viewable area of the control.
   *
   * **Note:** The Y position corresponds to the bottom side of the line. Use [getRectAtLineColumn]
   * to get the top side position.
   */
  public final fun getPosAtLineColumn(line: Int, column: Int): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getPosAtLineColumnPtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  /**
   * Returns the local position and size for the grapheme at the given [line] and [column]. If `x`
   * or `y` position of the returned rect equal `-1`, the position is outside of the viewable area of
   * the control.
   *
   * **Note:** The Y position of the returned rect corresponds to the top side of the line, unlike
   * [getPosAtLineColumn] which returns the bottom side.
   */
  public final fun getRectAtLineColumn(line: Int, column: Int): Rect2i {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getRectAtLineColumnPtr)
    return (TransferContext.readReturnValue(RECT2I) as Rect2i)
  }

  /**
   * Returns the equivalent minimap line at [position].
   */
  public final fun getMinimapLineAtPos(position: Vector2i): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to position)
    TransferContext.callMethod(MethodBindings.getMinimapLineAtPosPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if the user is dragging their mouse for scrolling, selecting, or text dragging.
   */
  public final fun isDraggingCursor(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDraggingCursorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the mouse is over a selection. If [edges] is `true`, the edges are considered
   * part of the selection.
   */
  @JvmOverloads
  public final fun isMouseOverSelection(edges: Boolean, caretIndex: Int = -1): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to edges, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.isMouseOverSelectionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCaretType(type: CaretType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to type.value)
    TransferContext.callMethod(MethodBindings.setCaretTypePtr)
  }

  public final fun getCaretType(): CaretType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCaretTypePtr)
    return CaretType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setCaretBlinkEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setCaretBlinkEnabledPtr)
  }

  public final fun isCaretBlinkEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCaretBlinkEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCaretBlinkInterval(interval: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to interval.toDouble())
    TransferContext.callMethod(MethodBindings.setCaretBlinkIntervalPtr)
  }

  public final fun getCaretBlinkInterval(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCaretBlinkIntervalPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDrawCaretWhenEditableDisabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDrawCaretWhenEditableDisabledPtr)
  }

  public final fun isDrawingCaretWhenEditableDisabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingCaretWhenEditableDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMoveCaretOnRightClickEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setMoveCaretOnRightClickEnabledPtr)
  }

  public final fun isMoveCaretOnRightClickEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMoveCaretOnRightClickEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCaretMidGraphemeEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCaretMidGraphemeEnabledPtr)
  }

  public final fun isCaretMidGraphemeEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCaretMidGraphemeEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMultipleCaretsEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setMultipleCaretsEnabledPtr)
  }

  public final fun isMultipleCaretsEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMultipleCaretsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds a new caret at the given location. Returns the index of the new caret, or `-1` if the
   * location is invalid.
   */
  public final fun addCaret(line: Int, column: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.addCaretPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes the given caret index.
   *
   * **Note:** This can result in adjustment of all other caret indices.
   */
  public final fun removeCaret(caret: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caret.toLong())
    TransferContext.callMethod(MethodBindings.removeCaretPtr)
  }

  /**
   * Removes all additional carets.
   */
  public final fun removeSecondaryCarets(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.removeSecondaryCaretsPtr)
  }

  /**
   * Returns the number of carets in this [TextEdit].
   */
  public final fun getCaretCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCaretCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds an additional caret above or below every caret. If [below] is `true` the new caret will be
   * added below and above otherwise.
   */
  public final fun addCaretAtCarets(below: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to below)
    TransferContext.callMethod(MethodBindings.addCaretAtCaretsPtr)
  }

  /**
   * Returns the carets sorted by selection beginning from lowest line and column to highest (from
   * top to bottom of text).
   *
   * If [includeIgnoredCarets] is `false`, carets from [multicaretEditIgnoreCaret] will be ignored.
   */
  @JvmOverloads
  public final fun getSortedCarets(includeIgnoredCarets: Boolean = false): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to includeIgnoredCarets)
    TransferContext.callMethod(MethodBindings.getSortedCaretsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Collapse all carets in the given range to the [fromLine] and [fromColumn] position.
   *
   * [inclusive] applies to both ends.
   *
   * If [isInMulitcaretEdit] is `true`, carets that are collapsed will be `true` for
   * [multicaretEditIgnoreCaret].
   *
   * [mergeOverlappingCarets] will be called if any carets were collapsed.
   */
  @JvmOverloads
  public final fun collapseCarets(
    fromLine: Int,
    fromColumn: Int,
    toLine: Int,
    toColumn: Int,
    inclusive: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromLine.toLong(), LONG to fromColumn.toLong(), LONG to toLine.toLong(), LONG to toColumn.toLong(), BOOL to inclusive)
    TransferContext.callMethod(MethodBindings.collapseCaretsPtr)
  }

  /**
   * Merges any overlapping carets. Will favor the newest caret, or the caret with a selection.
   *
   * If [isInMulitcaretEdit] is `true`, the merge will be queued to happen at the end of the
   * multicaret edit. See [beginMulticaretEdit] and [endMulticaretEdit].
   *
   * **Note:** This is not called when a caret changes position but after certain actions, so it is
   * possible to get into a state where carets overlap.
   */
  public final fun mergeOverlappingCarets(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.mergeOverlappingCaretsPtr)
  }

  /**
   * Starts an edit for multiple carets. The edit must be ended with [endMulticaretEdit]. Multicaret
   * edits can be used to edit text at multiple carets and delay merging the carets until the end, so
   * the caret indexes aren't affected immediately. [beginMulticaretEdit] and [endMulticaretEdit] can
   * be nested, and the merge will happen at the last [endMulticaretEdit].
   *
   * ```
   * begin_complex_operation()
   * begin_multicaret_edit()
   * for i in range(get_caret_count()):
   * 	if multicaret_edit_ignore_caret(i):
   * 		continue
   * 	# Logic here.
   * end_multicaret_edit()
   * end_complex_operation()
   * ```
   */
  public final fun beginMulticaretEdit(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.beginMulticaretEditPtr)
  }

  /**
   * Ends an edit for multiple carets, that was started with [beginMulticaretEdit]. If this was the
   * last [endMulticaretEdit] and [mergeOverlappingCarets] was called, carets will be merged.
   */
  public final fun endMulticaretEdit(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.endMulticaretEditPtr)
  }

  /**
   * Returns `true` if a [beginMulticaretEdit] has been called and [endMulticaretEdit] has not yet
   * been called.
   */
  public final fun isInMulitcaretEdit(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isInMulitcaretEditPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the given [caretIndex] should be ignored as part of a multicaret edit. See
   * [beginMulticaretEdit] and [endMulticaretEdit]. Carets that should be ignored are ones that were
   * part of removed text and will likely be merged at the end of the edit, or carets that were added
   * during the edit.
   *
   * It is recommended to `continue` within a loop iterating on multiple carets if a caret should be
   * ignored.
   */
  public final fun multicaretEditIgnoreCaret(caretIndex: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.multicaretEditIgnoreCaretPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the caret is visible, `false` otherwise. A caret will be considered hidden if
   * it is outside the scrollable area when scrolling is enabled.
   *
   * **Note:** [isCaretVisible] does not account for a caret being off-screen if it is still within
   * the scrollable area. It will return `true` even if the caret is off-screen as long as it meets
   * [TextEdit]'s own conditions for being visible. This includes uses of [scrollFitContentWidth] and
   * [scrollFitContentHeight] that cause the [TextEdit] to expand beyond the viewport's bounds.
   *
   * **Note:** This method does *not* guarantee an accurate visibility check immediately after
   * setting the caret position. The correct value may only be available in the next frame after the
   * [TextEdit] has finished drawing. This also applies to any operation that causes the [TextEdit] to
   * change in size.
   */
  @JvmOverloads
  public final fun isCaretVisible(caretIndex: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.isCaretVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the caret pixel draw position.
   */
  @JvmOverloads
  public final fun getCaretDrawPos(caretIndex: Int = 0): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCaretDrawPosPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Moves the caret to the specified [line] index. The caret column will be moved to the same
   * visual position it was at the last time [setCaretColumn] was called, or clamped to the end of the
   * line.
   *
   * If [adjustViewport] is `true`, the viewport will center at the caret position after the move
   * occurs.
   *
   * If [canBeHidden] is `true`, the specified [line] can be hidden.
   *
   * If [wrapIndex] is `-1`, the caret column will be clamped to the [line]'s length. If [wrapIndex]
   * is greater than `-1`, the column will be moved to attempt to match the visual x position on the
   * line's [wrapIndex] to the position from the last time [setCaretColumn] was called.
   *
   * **Note:** If supporting multiple carets this will not check for any overlap. See
   * [mergeOverlappingCarets].
   */
  @JvmOverloads
  public final fun setCaretLine(
    line: Int,
    adjustViewport: Boolean = true,
    canBeHidden: Boolean = true,
    wrapIndex: Int = 0,
    caretIndex: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), BOOL to adjustViewport, BOOL to canBeHidden, LONG to wrapIndex.toLong(), LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.setCaretLinePtr)
  }

  /**
   * Returns the line the editing caret is on.
   */
  @JvmOverloads
  public final fun getCaretLine(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCaretLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Moves the caret to the specified [column] index.
   *
   * If [adjustViewport] is `true`, the viewport will center at the caret position after the move
   * occurs.
   *
   * **Note:** If supporting multiple carets this will not check for any overlap. See
   * [mergeOverlappingCarets].
   */
  @JvmOverloads
  public final fun setCaretColumn(
    column: Int,
    adjustViewport: Boolean = true,
    caretIndex: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to column.toLong(), BOOL to adjustViewport, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.setCaretColumnPtr)
  }

  /**
   * Returns the column the editing caret is at.
   */
  @JvmOverloads
  public final fun getCaretColumn(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCaretColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the correct column at the end of a composite character like ❤️‍🩹 (mending heart;
   * Unicode: `U+2764 U+FE0F U+200D U+1FA79`) which is comprised of more than one Unicode code point,
   * if the caret is at the start of the composite character. Also returns the correct column with the
   * caret at mid grapheme and for non-composite characters.
   *
   * **Note:** To check at caret location use `get_next_composite_character_column(get_caret_line(),
   * get_caret_column())`
   */
  public final fun getNextCompositeCharacterColumn(line: Int, column: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getNextCompositeCharacterColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the correct column at the start of a composite character like ❤️‍🩹 (mending heart;
   * Unicode: `U+2764 U+FE0F U+200D U+1FA79`) which is comprised of more than one Unicode code point,
   * if the caret is at the end of the composite character. Also returns the correct column with the
   * caret at mid grapheme and for non-composite characters.
   *
   * **Note:** To check at caret location use
   * `get_previous_composite_character_column(get_caret_line(), get_caret_column())`
   */
  public final fun getPreviousCompositeCharacterColumn(line: Int, column: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getPreviousCompositeCharacterColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the wrap index the editing caret is on.
   */
  @JvmOverloads
  public final fun getCaretWrapIndex(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getCaretWrapIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a [String] text with the word under the caret's location.
   */
  @JvmOverloads
  public final fun getWordUnderCaret(caretIndex: Int = -1): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getWordUnderCaretPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setUseDefaultWordSeparators(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setUseDefaultWordSeparatorsPtr)
  }

  public final fun isDefaultWordSeparatorsEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDefaultWordSeparatorsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseCustomWordSeparators(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setUseCustomWordSeparatorsPtr)
  }

  public final fun isCustomWordSeparatorsEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCustomWordSeparatorsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCustomWordSeparators(customWordSeparators: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to customWordSeparators)
    TransferContext.callMethod(MethodBindings.setCustomWordSeparatorsPtr)
  }

  public final fun getCustomWordSeparators(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomWordSeparatorsPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setSelectingEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSelectingEnabledPtr)
  }

  public final fun isSelectingEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSelectingEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDeselectOnFocusLossEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDeselectOnFocusLossEnabledPtr)
  }

  public final fun isDeselectOnFocusLossEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDeselectOnFocusLossEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDragAndDropSelectionEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setDragAndDropSelectionEnabledPtr)
  }

  public final fun isDragAndDropSelectionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDragAndDropSelectionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the current selection mode.
   */
  public final fun setSelectionMode(mode: SelectionMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setSelectionModePtr)
  }

  /**
   * Returns the current selection mode.
   */
  public final fun getSelectionMode(): SelectionMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectionModePtr)
    return SelectionMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Select all the text.
   *
   * If [selectingEnabled] is `false`, no selection will occur.
   */
  public final fun selectAll(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.selectAllPtr)
  }

  /**
   * Selects the word under the caret.
   */
  @JvmOverloads
  public final fun selectWordUnderCaret(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.selectWordUnderCaretPtr)
  }

  /**
   * Adds a selection and a caret for the next occurrence of the current selection. If there is no
   * active selection, selects word under caret.
   */
  public final fun addSelectionForNextOccurrence(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.addSelectionForNextOccurrencePtr)
  }

  /**
   * Moves a selection and a caret for the next occurrence of the current selection. If there is no
   * active selection, moves to the next occurrence of the word under caret.
   */
  public final fun skipSelectionForNextOccurrence(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.skipSelectionForNextOccurrencePtr)
  }

  /**
   * Selects text from [originLine] and [originColumn] to [caretLine] and [caretColumn] for the
   * given [caretIndex]. This moves the selection origin and the caret. If the positions are the same,
   * the selection will be deselected.
   *
   * If [selectingEnabled] is `false`, no selection will occur.
   *
   * **Note:** If supporting multiple carets this will not check for any overlap. See
   * [mergeOverlappingCarets].
   */
  @JvmOverloads
  public final fun select(
    originLine: Int,
    originColumn: Int,
    caretLine: Int,
    caretColumn: Int,
    caretIndex: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to originLine.toLong(), LONG to originColumn.toLong(), LONG to caretLine.toLong(), LONG to caretColumn.toLong(), LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.selectPtr)
  }

  /**
   * Returns `true` if the user has selected text.
   */
  @JvmOverloads
  public final fun hasSelection(caretIndex: Int = -1): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.hasSelectionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the text inside the selection of a caret, or all the carets if [caretIndex] is its
   * default value `-1`.
   */
  @JvmOverloads
  public final fun getSelectedText(caretIndex: Int = -1): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectedTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the caret index of the selection at the given [line] and [column], or `-1` if there is
   * none.
   *
   * If [includeEdges] is `false`, the position must be inside the selection and not at either end.
   * If [onlySelections] is `false`, carets without a selection will also be considered.
   */
  @JvmOverloads
  public final fun getSelectionAtLineColumn(
    line: Int,
    column: Int,
    includeEdges: Boolean = true,
    onlySelections: Boolean = true,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong(), BOOL to includeEdges, BOOL to onlySelections)
    TransferContext.callMethod(MethodBindings.getSelectionAtLineColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns an [VariantArray] of line ranges where `x` is the first line and `y` is the last line.
   * All lines within these ranges will have a caret on them or be part of a selection. Each line will
   * only be part of one line range, even if it has multiple carets on it.
   *
   * If a selection's end column ([getSelectionToColumn]) is at column `0`, that line will not be
   * included. If a selection begins on the line after another selection ends and [mergeAdjacent] is
   * `true`, or they begin and end on the same line, one line range will include both selections.
   */
  @JvmOverloads
  public final fun getLineRangesFromCarets(onlySelections: Boolean = false, mergeAdjacent: Boolean =
      true): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to onlySelections, BOOL to mergeAdjacent)
    TransferContext.callMethod(MethodBindings.getLineRangesFromCaretsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  /**
   * Returns the origin line of the selection. This is the opposite end from the caret.
   */
  @JvmOverloads
  public final fun getSelectionOriginLine(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionOriginLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the origin column of the selection. This is the opposite end from the caret.
   */
  @JvmOverloads
  public final fun getSelectionOriginColumn(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionOriginColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the selection origin line to the [line] for the given [caretIndex]. If the selection
   * origin is moved to the caret position, the selection will deselect.
   *
   * If [canBeHidden] is `false`, The line will be set to the nearest unhidden line below or above.
   *
   * If [wrapIndex] is `-1`, the selection origin column will be clamped to the [line]'s length. If
   * [wrapIndex] is greater than `-1`, the column will be moved to attempt to match the visual x
   * position on the line's [wrapIndex] to the position from the last time [setSelectionOriginColumn]
   * or [select] was called.
   */
  @JvmOverloads
  public final fun setSelectionOriginLine(
    line: Int,
    canBeHidden: Boolean = true,
    wrapIndex: Int = -1,
    caretIndex: Int = 0,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), BOOL to canBeHidden, LONG to wrapIndex.toLong(), LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.setSelectionOriginLinePtr)
  }

  /**
   * Sets the selection origin column to the [column] for the given [caretIndex]. If the selection
   * origin is moved to the caret position, the selection will deselect.
   */
  @JvmOverloads
  public final fun setSelectionOriginColumn(column: Int, caretIndex: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to column.toLong(), LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.setSelectionOriginColumnPtr)
  }

  /**
   * Returns the selection begin line. Returns the caret line if there is no selection.
   */
  @JvmOverloads
  public final fun getSelectionFromLine(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionFromLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the selection begin column. Returns the caret column if there is no selection.
   */
  @JvmOverloads
  public final fun getSelectionFromColumn(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionFromColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the selection end line. Returns the caret line if there is no selection.
   */
  @JvmOverloads
  public final fun getSelectionToLine(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionToLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the selection end column. Returns the caret column if there is no selection.
   */
  @JvmOverloads
  public final fun getSelectionToColumn(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionToColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if the caret of the selection is after the selection origin. This can be used to
   * determine the direction of the selection.
   */
  @JvmOverloads
  public final fun isCaretAfterSelectionOrigin(caretIndex: Int = 0): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.isCaretAfterSelectionOriginPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Deselects the current selection.
   */
  @JvmOverloads
  public final fun deselect(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.deselectPtr)
  }

  /**
   * Deletes the selected text.
   */
  @JvmOverloads
  public final fun deleteSelection(caretIndex: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.deleteSelectionPtr)
  }

  public final fun setLineWrappingMode(mode: LineWrappingMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setLineWrappingModePtr)
  }

  public final fun getLineWrappingMode(): LineWrappingMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineWrappingModePtr)
    return LineWrappingMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setAutowrapMode(autowrapMode: TextServer.AutowrapMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to autowrapMode.value)
    TransferContext.callMethod(MethodBindings.setAutowrapModePtr)
  }

  public final fun getAutowrapMode(): TextServer.AutowrapMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutowrapModePtr)
    return TextServer.AutowrapMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns if the given line is wrapped.
   */
  public final fun isLineWrapped(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineWrappedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the number of times the given line is wrapped.
   */
  public final fun getLineWrapCount(line: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getLineWrapCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the wrap index of the given column on the given line. This ranges from `0` to
   * [getLineWrapCount].
   */
  public final fun getLineWrapIndexAtColumn(line: Int, column: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to column.toLong())
    TransferContext.callMethod(MethodBindings.getLineWrapIndexAtColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns an array of [String]s representing each wrapped index.
   */
  public final fun getLineWrappedText(line: Int): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getLineWrappedTextPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  public final fun setSmoothScrollEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSmoothScrollEnabledPtr)
  }

  public final fun isSmoothScrollEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSmoothScrollEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [VScrollBar] of the [TextEdit].
   */
  public final fun getVScrollBar(): VScrollBar? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVScrollBarPtr)
    return (TransferContext.readReturnValue(OBJECT) as VScrollBar?)
  }

  /**
   * Returns the [HScrollBar] used by [TextEdit].
   */
  public final fun getHScrollBar(): HScrollBar? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHScrollBarPtr)
    return (TransferContext.readReturnValue(OBJECT) as HScrollBar?)
  }

  public final fun setVScroll(`value`: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to value)
    TransferContext.callMethod(MethodBindings.setVScrollPtr)
  }

  public final fun getVScroll(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVScrollPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public final fun setHScroll(`value`: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to value.toLong())
    TransferContext.callMethod(MethodBindings.setHScrollPtr)
  }

  public final fun getHScroll(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHScrollPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setScrollPastEndOfFileEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setScrollPastEndOfFileEnabledPtr)
  }

  public final fun isScrollPastEndOfFileEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isScrollPastEndOfFileEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setVScrollSpeed(speed: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to speed.toDouble())
    TransferContext.callMethod(MethodBindings.setVScrollSpeedPtr)
  }

  public final fun getVScrollSpeed(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVScrollSpeedPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setFitContentHeightEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFitContentHeightEnabledPtr)
  }

  public final fun isFitContentHeightEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFitContentHeightEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFitContentWidthEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setFitContentWidthEnabledPtr)
  }

  public final fun isFitContentWidthEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFitContentWidthEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the scroll position for [wrapIndex] of [line].
   */
  @JvmOverloads
  public final fun getScrollPosForLine(line: Int, wrapIndex: Int = 0): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to wrapIndex.toLong())
    TransferContext.callMethod(MethodBindings.getScrollPosForLinePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Positions the [wrapIndex] of [line] at the top of the viewport.
   */
  @JvmOverloads
  public final fun setLineAsFirstVisible(line: Int, wrapIndex: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to wrapIndex.toLong())
    TransferContext.callMethod(MethodBindings.setLineAsFirstVisiblePtr)
  }

  /**
   * Returns the first visible line.
   */
  public final fun getFirstVisibleLine(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFirstVisibleLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if the given line is within the scope of the scrollable area of the viewport.
   */
  public final fun isLineInViewport(line: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.isLineInViewportPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Positions the [wrapIndex] of [line] at the center of the viewport.
   */
  @JvmOverloads
  public final fun setLineAsCenterVisible(line: Int, wrapIndex: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to wrapIndex.toLong())
    TransferContext.callMethod(MethodBindings.setLineAsCenterVisiblePtr)
  }

  /**
   * Positions the [wrapIndex] of [line] at the bottom of the viewport.
   */
  @JvmOverloads
  public final fun setLineAsLastVisible(line: Int, wrapIndex: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to wrapIndex.toLong())
    TransferContext.callMethod(MethodBindings.setLineAsLastVisiblePtr)
  }

  /**
   * Returns the last visible line. Use [getLastFullVisibleLineWrapIndex] for the wrap index.
   */
  public final fun getLastFullVisibleLine(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastFullVisibleLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the last visible wrap index of the last visible line.
   */
  public final fun getLastFullVisibleLineWrapIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastFullVisibleLineWrapIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of lines that can visually fit, rounded down, based on this control's
   * height.
   */
  public final fun getVisibleLineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibleLineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the total number of lines between [fromLine] and [toLine] (inclusive) in the text. This
   * includes wrapped lines and excludes folded lines. If the range covers all lines it is equivalent
   * to [getTotalVisibleLineCount].
   */
  public final fun getVisibleLineCountInRange(fromLine: Int, toLine: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromLine.toLong(), LONG to toLine.toLong())
    TransferContext.callMethod(MethodBindings.getVisibleLineCountInRangePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the total number of lines in the text. This includes wrapped lines and excludes folded
   * lines. If [wrapMode] is set to [LINE_WRAPPING_NONE] and no lines are folded (see
   * [CodeEdit.isLineFolded]) then this is equivalent to [getLineCount]. See
   * [getVisibleLineCountInRange] for a limited range of lines.
   */
  public final fun getTotalVisibleLineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTotalVisibleLineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adjust the viewport so the caret is visible.
   */
  @JvmOverloads
  public final fun adjustViewportToCaret(caretIndex: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.adjustViewportToCaretPtr)
  }

  /**
   * Centers the viewport on the line the editing caret is at. This also resets the
   * [scrollHorizontal] value to `0`.
   */
  @JvmOverloads
  public final fun centerViewportToCaret(caretIndex: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.centerViewportToCaretPtr)
  }

  public final fun setDrawMinimap(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDrawMinimapPtr)
  }

  public final fun isDrawingMinimap(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingMinimapPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMinimapWidth(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setMinimapWidthPtr)
  }

  public final fun getMinimapWidth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinimapWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of lines that may be drawn on the minimap.
   */
  public final fun getMinimapVisibleLines(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinimapVisibleLinesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Register a new gutter to this [TextEdit]. Use [at] to have a specific gutter order. A value of
   * `-1` appends the gutter to the right.
   */
  @JvmOverloads
  public final fun addGutter(at: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to at.toLong())
    TransferContext.callMethod(MethodBindings.addGutterPtr)
  }

  /**
   * Removes the gutter at the given index.
   */
  public final fun removeGutter(gutter: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.removeGutterPtr)
  }

  /**
   * Returns the number of gutters registered.
   */
  public final fun getGutterCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGutterCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the name of the gutter at the given index.
   */
  public final fun setGutterName(gutter: Int, name: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong(), STRING to name)
    TransferContext.callMethod(MethodBindings.setGutterNamePtr)
  }

  /**
   * Returns the name of the gutter at the given index.
   */
  public final fun getGutterName(gutter: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.getGutterNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the type of gutter at the given index. Gutters can contain icons, text, or custom visuals.
   */
  public final fun setGutterType(gutter: Int, type: GutterType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong(), LONG to type.value)
    TransferContext.callMethod(MethodBindings.setGutterTypePtr)
  }

  /**
   * Returns the type of the gutter at the given index. Gutters can contain icons, text, or custom
   * visuals.
   */
  public final fun getGutterType(gutter: Int): GutterType {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.getGutterTypePtr)
    return GutterType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Set the width of the gutter at the given index.
   */
  public final fun setGutterWidth(gutter: Int, width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong(), LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setGutterWidthPtr)
  }

  /**
   * Returns the width of the gutter at the given index.
   */
  public final fun getGutterWidth(gutter: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.getGutterWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * If `true`, the gutter at the given index is drawn. The gutter type ([setGutterType]) determines
   * how it is drawn. See [isGutterDrawn].
   */
  public final fun setGutterDraw(gutter: Int, draw: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong(), BOOL to draw)
    TransferContext.callMethod(MethodBindings.setGutterDrawPtr)
  }

  /**
   * Returns `true` if the gutter at the given index is currently drawn. See [setGutterDraw].
   */
  public final fun isGutterDrawn(gutter: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.isGutterDrawnPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, the mouse cursor will change to a pointing hand ([Control.CURSOR_POINTING_HAND])
   * when hovering over the gutter at the given index. See [isGutterClickable] and
   * [setLineGutterClickable].
   */
  public final fun setGutterClickable(gutter: Int, clickable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong(), BOOL to clickable)
    TransferContext.callMethod(MethodBindings.setGutterClickablePtr)
  }

  /**
   * Returns `true` if the gutter at the given index is clickable. See [setGutterClickable].
   */
  public final fun isGutterClickable(gutter: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.isGutterClickablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, the line data of the gutter at the given index can be overridden when using
   * [mergeGutters]. See [isGutterOverwritable].
   */
  public final fun setGutterOverwritable(gutter: Int, overwritable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong(), BOOL to overwritable)
    TransferContext.callMethod(MethodBindings.setGutterOverwritablePtr)
  }

  /**
   * Returns `true` if the gutter at the given index is overwritable. See [setGutterOverwritable].
   */
  public final fun isGutterOverwritable(gutter: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.isGutterOverwritablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Merge the gutters from [fromLine] into [toLine]. Only overwritable gutters will be copied. See
   * [setGutterOverwritable].
   */
  public final fun mergeGutters(fromLine: Int, toLine: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromLine.toLong(), LONG to toLine.toLong())
    TransferContext.callMethod(MethodBindings.mergeGuttersPtr)
  }

  /**
   * Set a custom draw callback for the gutter at the given index. [drawCallback] must take the
   * following arguments: A line index [Long], a gutter index [Long], and an area [Rect2]. This
   * callback only works when the gutter type is [GUTTER_TYPE_CUSTOM] (see [setGutterType]).
   */
  public final fun setGutterCustomDraw(column: Int, drawCallback: Callable): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to column.toLong(), CALLABLE to drawCallback)
    TransferContext.callMethod(MethodBindings.setGutterCustomDrawPtr)
  }

  /**
   * Returns the total width of all gutters and internal padding.
   */
  public final fun getTotalGutterWidth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTotalGutterWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the metadata for [gutter] on [line] to [metadata].
   */
  public final fun setLineGutterMetadata(
    line: Int,
    gutter: Int,
    metadata: Any?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong(), ANY to metadata)
    TransferContext.callMethod(MethodBindings.setLineGutterMetadataPtr)
  }

  /**
   * Returns the metadata currently in [gutter] at [line].
   */
  public final fun getLineGutterMetadata(line: Int, gutter: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.getLineGutterMetadataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets the text for [gutter] on [line] to [text]. This only works when the gutter type is
   * [GUTTER_TYPE_STRING] (see [setGutterType]).
   */
  public final fun setLineGutterText(
    line: Int,
    gutter: Int,
    text: String,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong(), STRING to text)
    TransferContext.callMethod(MethodBindings.setLineGutterTextPtr)
  }

  /**
   * Returns the text currently in [gutter] at [line]. This only works when the gutter type is
   * [GUTTER_TYPE_STRING] (see [setGutterType]).
   */
  public final fun getLineGutterText(line: Int, gutter: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.getLineGutterTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the icon for [gutter] on [line] to [icon]. This only works when the gutter type is
   * [GUTTER_TYPE_ICON] (see [setGutterType]).
   */
  public final fun setLineGutterIcon(
    line: Int,
    gutter: Int,
    icon: Texture2D?,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong(), OBJECT to icon)
    TransferContext.callMethod(MethodBindings.setLineGutterIconPtr)
  }

  /**
   * Returns the icon currently in [gutter] at [line]. This only works when the gutter type is
   * [GUTTER_TYPE_ICON] (see [setGutterType]).
   */
  public final fun getLineGutterIcon(line: Int, gutter: Int): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.getLineGutterIconPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Sets the color for [gutter] on [line] to [color].
   */
  public final fun setLineGutterItemColor(
    line: Int,
    gutter: Int,
    color: Color,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.setLineGutterItemColorPtr)
  }

  /**
   * Returns the color currently in [gutter] at [line].
   */
  public final fun getLineGutterItemColor(line: Int, gutter: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.getLineGutterItemColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * If [clickable] is `true`, makes the [gutter] on the given [line] clickable. This is like
   * [setGutterClickable], but for a single line. If [isGutterClickable] is `true`, this will not have
   * any effect. See [isLineGutterClickable] and [signal gutter_clicked].
   */
  public final fun setLineGutterClickable(
    line: Int,
    gutter: Int,
    clickable: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong(), BOOL to clickable)
    TransferContext.callMethod(MethodBindings.setLineGutterClickablePtr)
  }

  /**
   * Returns `true` if the gutter at the given index on the given line is clickable. See
   * [setLineGutterClickable].
   */
  public final fun isLineGutterClickable(line: Int, gutter: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), LONG to gutter.toLong())
    TransferContext.callMethod(MethodBindings.isLineGutterClickablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the custom background color of the given line. If transparent, this color is applied on
   * top of the default background color (See [theme_item background_color]). If set to `Color(0, 0, 0,
   * 0)`, no additional color is applied.
   */
  public final fun setLineBackgroundColor(line: Int, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.setLineBackgroundColorPtr)
  }

  /**
   * Returns the custom background color of the given line. If no color is set, returns `Color(0, 0,
   * 0, 0)`.
   */
  public final fun getLineBackgroundColor(line: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getLineBackgroundColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setSyntaxHighlighter(syntaxHighlighter: SyntaxHighlighter?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to syntaxHighlighter)
    TransferContext.callMethod(MethodBindings.setSyntaxHighlighterPtr)
  }

  public final fun getSyntaxHighlighter(): SyntaxHighlighter? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSyntaxHighlighterPtr)
    return (TransferContext.readReturnValue(OBJECT) as SyntaxHighlighter?)
  }

  public final fun setHighlightCurrentLine(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setHighlightCurrentLinePtr)
  }

  public final fun isHighlightCurrentLineEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHighlightCurrentLineEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHighlightAllOccurrences(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setHighlightAllOccurrencesPtr)
  }

  public final fun isHighlightAllOccurrencesEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHighlightAllOccurrencesEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getDrawControlChars(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDrawControlCharsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDrawControlChars(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDrawControlCharsPtr)
  }

  public final fun setDrawTabs(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDrawTabsPtr)
  }

  public final fun isDrawingTabs(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingTabsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDrawSpaces(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setDrawSpacesPtr)
  }

  public final fun isDrawingSpaces(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDrawingSpacesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [PopupMenu] of this [TextEdit]. By default, this menu is displayed when
   * right-clicking on the [TextEdit].
   *
   * You can add custom menu items or remove standard ones. Make sure your IDs don't conflict with
   * the standard ones (see [MenuItems]). For example:
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   * 	var menu = get_menu()
   * 	# Remove all items after "Redo".
   * 	menu.item_count = menu.get_item_index(MENU_REDO) + 1
   * 	# Add custom items.
   * 	menu.add_separator()
   * 	menu.add_item("Insert Date", MENU_MAX + 1)
   * 	# Connect callback.
   * 	menu.id_pressed.connect(_on_item_pressed)
   *
   * func _on_item_pressed(id):
   * 	if id == MENU_MAX + 1:
   * 		insert_text_at_caret(Time.get_date_string_from_system())
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Ready()
   * {
   * 	var menu = GetMenu();
   * 	// Remove all items after "Redo".
   * 	menu.ItemCount = menu.GetItemIndex(TextEdit.MenuItems.Redo) + 1;
   * 	// Add custom items.
   * 	menu.AddSeparator();
   * 	menu.AddItem("Insert Date", TextEdit.MenuItems.Max + 1);
   * 	// Add event handler.
   * 	menu.IdPressed += OnItemPressed;
   * }
   *
   * public void OnItemPressed(int id)
   * {
   * 	if (id == TextEdit.MenuItems.Max + 1)
   * 	{
   * 		InsertTextAtCaret(Time.GetDateStringFromSystem());
   * 	}
   * }
   * ```
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [Window.visible] property.
   */
  public final fun getMenu(): PopupMenu? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMenuPtr)
    return (TransferContext.readReturnValue(OBJECT) as PopupMenu?)
  }

  /**
   * Returns `true` if the menu is visible. Use this instead of `get_menu().visible` to improve
   * performance (so the creation of the menu is avoided). See [getMenu].
   */
  public final fun isMenuVisible(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isMenuVisiblePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Executes a given action as defined in the [MenuItems] enum.
   */
  public final fun menuOption(option: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to option.toLong())
    TransferContext.callMethod(MethodBindings.menuOptionPtr)
  }

  /**
   * This method does nothing.
   */
  public final fun adjustCaretsAfterEdit(
    caret: Int,
    fromLine: Int,
    fromCol: Int,
    toLine: Int,
    toCol: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caret.toLong(), LONG to fromLine.toLong(), LONG to fromCol.toLong(), LONG to toLine.toLong(), LONG to toCol.toLong())
    TransferContext.callMethod(MethodBindings.adjustCaretsAfterEditPtr)
  }

  /**
   * Returns a list of caret indexes in their edit order, this done from bottom to top. Edit order
   * refers to the way actions such as [insertTextAtCaret] are applied.
   */
  public final fun getCaretIndexEditOrder(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCaretIndexEditOrderPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Returns the original start line of the selection.
   */
  @JvmOverloads
  public final fun getSelectionLine(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the original start column of the selection.
   */
  @JvmOverloads
  public final fun getSelectionColumn(caretIndex: Int = 0): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to caretIndex.toLong())
    TransferContext.callMethod(MethodBindings.getSelectionColumnPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public enum class MenuItems(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Cuts (copies and clears) the selected text.
     */
    CUT(0),
    /**
     * Copies the selected text.
     */
    COPY(1),
    /**
     * Pastes the clipboard text over the selected text (or at the cursor's position).
     */
    PASTE(2),
    /**
     * Erases the whole [TextEdit] text.
     */
    CLEAR(3),
    /**
     * Selects the whole [TextEdit] text.
     */
    SELECT_ALL(4),
    /**
     * Undoes the previous action.
     */
    UNDO(5),
    /**
     * Redoes the previous action.
     */
    REDO(6),
    /**
     * ID of "Text Writing Direction" submenu.
     */
    SUBMENU_TEXT_DIR(7),
    /**
     * Sets text direction to inherited.
     */
    DIR_INHERITED(8),
    /**
     * Sets text direction to automatic.
     */
    DIR_AUTO(9),
    /**
     * Sets text direction to left-to-right.
     */
    DIR_LTR(10),
    /**
     * Sets text direction to right-to-left.
     */
    DIR_RTL(11),
    /**
     * Toggles control character display.
     */
    DISPLAY_UCC(12),
    /**
     * ID of "Insert Control Character" submenu.
     */
    SUBMENU_INSERT_UCC(13),
    /**
     * Inserts left-to-right mark (LRM) character.
     */
    INSERT_LRM(14),
    /**
     * Inserts right-to-left mark (RLM) character.
     */
    INSERT_RLM(15),
    /**
     * Inserts start of left-to-right embedding (LRE) character.
     */
    INSERT_LRE(16),
    /**
     * Inserts start of right-to-left embedding (RLE) character.
     */
    INSERT_RLE(17),
    /**
     * Inserts start of left-to-right override (LRO) character.
     */
    INSERT_LRO(18),
    /**
     * Inserts start of right-to-left override (RLO) character.
     */
    INSERT_RLO(19),
    /**
     * Inserts pop direction formatting (PDF) character.
     */
    INSERT_PDF(20),
    /**
     * Inserts Arabic letter mark (ALM) character.
     */
    INSERT_ALM(21),
    /**
     * Inserts left-to-right isolate (LRI) character.
     */
    INSERT_LRI(22),
    /**
     * Inserts right-to-left isolate (RLI) character.
     */
    INSERT_RLI(23),
    /**
     * Inserts first strong isolate (FSI) character.
     */
    INSERT_FSI(24),
    /**
     * Inserts pop direction isolate (PDI) character.
     */
    INSERT_PDI(25),
    /**
     * Inserts zero width joiner (ZWJ) character.
     */
    INSERT_ZWJ(26),
    /**
     * Inserts zero width non-joiner (ZWNJ) character.
     */
    INSERT_ZWNJ(27),
    /**
     * Inserts word joiner (WJ) character.
     */
    INSERT_WJ(28),
    /**
     * Inserts soft hyphen (SHY) character.
     */
    INSERT_SHY(29),
    /**
     * Opens system emoji and symbol picker.
     */
    EMOJI_AND_SYMBOL(30),
    /**
     * Represents the size of the [MenuItems] enum.
     */
    MAX(31),
    ;

    public companion object {
      public fun from(`value`: Long): MenuItems = entries.single { it.`value` == `value` }
    }
  }

  public enum class EditAction(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No current action.
     */
    ACTION_NONE(0),
    /**
     * A typing action.
     */
    ACTION_TYPING(1),
    /**
     * A backwards delete action.
     */
    ACTION_BACKSPACE(2),
    /**
     * A forward delete action.
     */
    ACTION_DELETE(3),
    ;

    public companion object {
      public fun from(`value`: Long): EditAction = entries.single { it.`value` == `value` }
    }
  }

  public enum class SearchFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Match case when searching.
     */
    MATCH_CASE(1),
    /**
     * Match whole words when searching.
     */
    WHOLE_WORDS(2),
    /**
     * Search from end to beginning.
     */
    BACKWARDS(4),
    ;

    public companion object {
      public fun from(`value`: Long): SearchFlags = entries.single { it.`value` == `value` }
    }
  }

  public enum class CaretType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Vertical line caret.
     */
    LINE(0),
    /**
     * Block caret.
     */
    BLOCK(1),
    ;

    public companion object {
      public fun from(`value`: Long): CaretType = entries.single { it.`value` == `value` }
    }
  }

  public enum class SelectionMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Not selecting.
     */
    NONE(0),
    /**
     * Select as if `shift` is pressed.
     */
    SHIFT(1),
    /**
     * Select single characters as if the user single clicked.
     */
    POINTER(2),
    /**
     * Select whole words as if the user double clicked.
     */
    WORD(3),
    /**
     * Select whole lines as if the user triple clicked.
     */
    LINE(4),
    ;

    public companion object {
      public fun from(`value`: Long): SelectionMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LineWrappingMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Line wrapping is disabled.
     */
    NONE(0),
    /**
     * Line wrapping occurs at the control boundary, beyond what would normally be visible.
     */
    BOUNDARY(1),
    ;

    public companion object {
      public fun from(`value`: Long): LineWrappingMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class GutterType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * When a gutter is set to string using [setGutterType], it is used to contain text set via the
     * [setLineGutterText] method.
     */
    STRING(0),
    /**
     * When a gutter is set to icon using [setGutterType], it is used to contain an icon set via the
     * [setLineGutterIcon] method.
     */
    ICON(1),
    /**
     * When a gutter is set to custom using [setGutterType], it is used to contain custom visuals
     * controlled by a callback method set via the [setGutterCustomDraw] method.
     */
    CUSTOM(2),
    ;

    public companion object {
      public fun from(`value`: Long): GutterType = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val hasImeTextName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("has_ime_text")

    @JvmField
    public val cancelImeName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("cancel_ime")

    @JvmField
    public val applyImeName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("apply_ime")

    @JvmField
    public val setEditableName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_editable")

    @JvmField
    public val isEditableName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_editable")

    @JvmField
    public val setTextDirectionName: MethodStringName1<TextEdit, Unit, Control.TextDirection> =
        MethodStringName1<TextEdit, Unit, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<TextEdit, Control.TextDirection> =
        MethodStringName0<TextEdit, Control.TextDirection>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<TextEdit, Unit, String> =
        MethodStringName1<TextEdit, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<TextEdit, String> =
        MethodStringName0<TextEdit, String>("get_language")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName1<TextEdit, Unit, TextServer.StructuredTextParser> =
        MethodStringName1<TextEdit, Unit, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName0<TextEdit, TextServer.StructuredTextParser> =
        MethodStringName0<TextEdit, TextServer.StructuredTextParser>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName1<TextEdit, Unit, VariantArray<Any?>> =
        MethodStringName1<TextEdit, Unit, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName0<TextEdit, VariantArray<Any?>> =
        MethodStringName0<TextEdit, VariantArray<Any?>>("get_structured_text_bidi_override_options")

    @JvmField
    public val setTabSizeName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("set_tab_size")

    @JvmField
    public val getTabSizeName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_tab_size")

    @JvmField
    public val setIndentWrappedLinesName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_indent_wrapped_lines")

    @JvmField
    public val isIndentWrappedLinesName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_indent_wrapped_lines")

    @JvmField
    public val setTabInputModeName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_tab_input_mode")

    @JvmField
    public val getTabInputModeName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("get_tab_input_mode")

    @JvmField
    public val setOvertypeModeEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_overtype_mode_enabled")

    @JvmField
    public val isOvertypeModeEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_overtype_mode_enabled")

    @JvmField
    public val setContextMenuEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_context_menu_enabled")

    @JvmField
    public val isContextMenuEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_context_menu_enabled")

    @JvmField
    public val setEmojiMenuEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_emoji_menu_enabled")

    @JvmField
    public val isEmojiMenuEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_emoji_menu_enabled")

    @JvmField
    public val setBackspaceDeletesCompositeCharacterEnabledName:
        MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_backspace_deletes_composite_character_enabled")

    @JvmField
    public val isBackspaceDeletesCompositeCharacterEnabledName: MethodStringName0<TextEdit, Boolean>
        = MethodStringName0<TextEdit, Boolean>("is_backspace_deletes_composite_character_enabled")

    @JvmField
    public val setShortcutKeysEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_shortcut_keys_enabled")

    @JvmField
    public val isShortcutKeysEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_shortcut_keys_enabled")

    @JvmField
    public val setVirtualKeyboardEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_virtual_keyboard_enabled")

    @JvmField
    public val isVirtualKeyboardEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_virtual_keyboard_enabled")

    @JvmField
    public val setVirtualKeyboardShowOnFocusName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_virtual_keyboard_show_on_focus")

    @JvmField
    public val getVirtualKeyboardShowOnFocusName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("get_virtual_keyboard_show_on_focus")

    @JvmField
    public val setMiddleMousePasteEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_middle_mouse_paste_enabled")

    @JvmField
    public val isMiddleMousePasteEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_middle_mouse_paste_enabled")

    @JvmField
    public val setEmptySelectionClipboardEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_empty_selection_clipboard_enabled")

    @JvmField
    public val isEmptySelectionClipboardEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_empty_selection_clipboard_enabled")

    @JvmField
    public val clearName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("clear")

    @JvmField
    public val setTextName: MethodStringName1<TextEdit, Unit, String> =
        MethodStringName1<TextEdit, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<TextEdit, String> =
        MethodStringName0<TextEdit, String>("get_text")

    @JvmField
    public val getLineCountName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_line_count")

    @JvmField
    public val setPlaceholderName: MethodStringName1<TextEdit, Unit, String> =
        MethodStringName1<TextEdit, Unit, String>("set_placeholder")

    @JvmField
    public val getPlaceholderName: MethodStringName0<TextEdit, String> =
        MethodStringName0<TextEdit, String>("get_placeholder")

    @JvmField
    public val setLineName: MethodStringName2<TextEdit, Unit, Int, String> =
        MethodStringName2<TextEdit, Unit, Int, String>("set_line")

    @JvmField
    public val getLineName: MethodStringName1<TextEdit, String, Int> =
        MethodStringName1<TextEdit, String, Int>("get_line")

    @JvmField
    public val getLineWithImeName: MethodStringName1<TextEdit, String, Int> =
        MethodStringName1<TextEdit, String, Int>("get_line_with_ime")

    @JvmField
    public val getLineWidthName: MethodStringName2<TextEdit, Int, Int, Int> =
        MethodStringName2<TextEdit, Int, Int, Int>("get_line_width")

    @JvmField
    public val getLineHeightName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_line_height")

    @JvmField
    public val getIndentLevelName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_indent_level")

    @JvmField
    public val getFirstNonWhitespaceColumnName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_first_non_whitespace_column")

    @JvmField
    public val swapLinesName: MethodStringName2<TextEdit, Unit, Int, Int> =
        MethodStringName2<TextEdit, Unit, Int, Int>("swap_lines")

    @JvmField
    public val insertLineAtName: MethodStringName2<TextEdit, Unit, Int, String> =
        MethodStringName2<TextEdit, Unit, Int, String>("insert_line_at")

    @JvmField
    public val removeLineAtName: MethodStringName2<TextEdit, Unit, Int, Boolean> =
        MethodStringName2<TextEdit, Unit, Int, Boolean>("remove_line_at")

    @JvmField
    public val insertTextAtCaretName: MethodStringName2<TextEdit, Unit, String, Int> =
        MethodStringName2<TextEdit, Unit, String, Int>("insert_text_at_caret")

    @JvmField
    public val insertTextName: MethodStringName5<TextEdit, Unit, String, Int, Int, Boolean, Boolean>
        = MethodStringName5<TextEdit, Unit, String, Int, Int, Boolean, Boolean>("insert_text")

    @JvmField
    public val removeTextName: MethodStringName4<TextEdit, Unit, Int, Int, Int, Int> =
        MethodStringName4<TextEdit, Unit, Int, Int, Int, Int>("remove_text")

    @JvmField
    public val getLastUnhiddenLineName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_last_unhidden_line")

    @JvmField
    public val getNextVisibleLineOffsetFromName: MethodStringName2<TextEdit, Int, Int, Int> =
        MethodStringName2<TextEdit, Int, Int, Int>("get_next_visible_line_offset_from")

    @JvmField
    public val getNextVisibleLineIndexOffsetFromName:
        MethodStringName3<TextEdit, Vector2i, Int, Int, Int> =
        MethodStringName3<TextEdit, Vector2i, Int, Int, Int>("get_next_visible_line_index_offset_from")

    @JvmField
    public val backspaceName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("backspace")

    @JvmField
    public val cutName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("cut")

    @JvmField
    public val copyName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("copy")

    @JvmField
    public val pasteName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("paste")

    @JvmField
    public val pastePrimaryClipboardName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("paste_primary_clipboard")

    @JvmField
    public val startActionName: MethodStringName1<TextEdit, Unit, EditAction> =
        MethodStringName1<TextEdit, Unit, EditAction>("start_action")

    @JvmField
    public val endActionName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("end_action")

    @JvmField
    public val beginComplexOperationName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("begin_complex_operation")

    @JvmField
    public val endComplexOperationName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("end_complex_operation")

    @JvmField
    public val hasUndoName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("has_undo")

    @JvmField
    public val hasRedoName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("has_redo")

    @JvmField
    public val undoName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("undo")

    @JvmField
    public val redoName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("redo")

    @JvmField
    public val clearUndoHistoryName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("clear_undo_history")

    @JvmField
    public val tagSavedVersionName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("tag_saved_version")

    @JvmField
    public val getVersionName: MethodStringName0<TextEdit, Long> =
        MethodStringName0<TextEdit, Long>("get_version")

    @JvmField
    public val getSavedVersionName: MethodStringName0<TextEdit, Long> =
        MethodStringName0<TextEdit, Long>("get_saved_version")

    @JvmField
    public val setSearchTextName: MethodStringName1<TextEdit, Unit, String> =
        MethodStringName1<TextEdit, Unit, String>("set_search_text")

    @JvmField
    public val setSearchFlagsName: MethodStringName1<TextEdit, Unit, Long> =
        MethodStringName1<TextEdit, Unit, Long>("set_search_flags")

    @JvmField
    public val searchName: MethodStringName4<TextEdit, Vector2i, String, Long, Int, Int> =
        MethodStringName4<TextEdit, Vector2i, String, Long, Int, Int>("search")

    @JvmField
    public val setTooltipRequestFuncName: MethodStringName1<TextEdit, Unit, Callable> =
        MethodStringName1<TextEdit, Unit, Callable>("set_tooltip_request_func")

    @JvmField
    public val getLocalMousePosName: MethodStringName0<TextEdit, Vector2> =
        MethodStringName0<TextEdit, Vector2>("get_local_mouse_pos")

    @JvmField
    public val getWordAtPosName: MethodStringName1<TextEdit, String, Vector2> =
        MethodStringName1<TextEdit, String, Vector2>("get_word_at_pos")

    @JvmField
    public val getLineColumnAtPosName:
        MethodStringName3<TextEdit, Vector2i, Vector2i, Boolean, Boolean> =
        MethodStringName3<TextEdit, Vector2i, Vector2i, Boolean, Boolean>("get_line_column_at_pos")

    @JvmField
    public val getPosAtLineColumnName: MethodStringName2<TextEdit, Vector2i, Int, Int> =
        MethodStringName2<TextEdit, Vector2i, Int, Int>("get_pos_at_line_column")

    @JvmField
    public val getRectAtLineColumnName: MethodStringName2<TextEdit, Rect2i, Int, Int> =
        MethodStringName2<TextEdit, Rect2i, Int, Int>("get_rect_at_line_column")

    @JvmField
    public val getMinimapLineAtPosName: MethodStringName1<TextEdit, Int, Vector2i> =
        MethodStringName1<TextEdit, Int, Vector2i>("get_minimap_line_at_pos")

    @JvmField
    public val isDraggingCursorName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_dragging_cursor")

    @JvmField
    public val isMouseOverSelectionName: MethodStringName2<TextEdit, Boolean, Boolean, Int> =
        MethodStringName2<TextEdit, Boolean, Boolean, Int>("is_mouse_over_selection")

    @JvmField
    public val setCaretTypeName: MethodStringName1<TextEdit, Unit, CaretType> =
        MethodStringName1<TextEdit, Unit, CaretType>("set_caret_type")

    @JvmField
    public val getCaretTypeName: MethodStringName0<TextEdit, CaretType> =
        MethodStringName0<TextEdit, CaretType>("get_caret_type")

    @JvmField
    public val setCaretBlinkEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_caret_blink_enabled")

    @JvmField
    public val isCaretBlinkEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_caret_blink_enabled")

    @JvmField
    public val setCaretBlinkIntervalName: MethodStringName1<TextEdit, Unit, Float> =
        MethodStringName1<TextEdit, Unit, Float>("set_caret_blink_interval")

    @JvmField
    public val getCaretBlinkIntervalName: MethodStringName0<TextEdit, Float> =
        MethodStringName0<TextEdit, Float>("get_caret_blink_interval")

    @JvmField
    public val setDrawCaretWhenEditableDisabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_draw_caret_when_editable_disabled")

    @JvmField
    public val isDrawingCaretWhenEditableDisabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_drawing_caret_when_editable_disabled")

    @JvmField
    public val setMoveCaretOnRightClickEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_move_caret_on_right_click_enabled")

    @JvmField
    public val isMoveCaretOnRightClickEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_move_caret_on_right_click_enabled")

    @JvmField
    public val setCaretMidGraphemeEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_caret_mid_grapheme_enabled")

    @JvmField
    public val isCaretMidGraphemeEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_caret_mid_grapheme_enabled")

    @JvmField
    public val setMultipleCaretsEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_multiple_carets_enabled")

    @JvmField
    public val isMultipleCaretsEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_multiple_carets_enabled")

    @JvmField
    public val addCaretName: MethodStringName2<TextEdit, Int, Int, Int> =
        MethodStringName2<TextEdit, Int, Int, Int>("add_caret")

    @JvmField
    public val removeCaretName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("remove_caret")

    @JvmField
    public val removeSecondaryCaretsName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("remove_secondary_carets")

    @JvmField
    public val getCaretCountName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_caret_count")

    @JvmField
    public val addCaretAtCaretsName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("add_caret_at_carets")

    @JvmField
    public val getSortedCaretsName: MethodStringName1<TextEdit, PackedInt32Array, Boolean> =
        MethodStringName1<TextEdit, PackedInt32Array, Boolean>("get_sorted_carets")

    @JvmField
    public val collapseCaretsName: MethodStringName5<TextEdit, Unit, Int, Int, Int, Int, Boolean> =
        MethodStringName5<TextEdit, Unit, Int, Int, Int, Int, Boolean>("collapse_carets")

    @JvmField
    public val mergeOverlappingCaretsName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("merge_overlapping_carets")

    @JvmField
    public val beginMulticaretEditName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("begin_multicaret_edit")

    @JvmField
    public val endMulticaretEditName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("end_multicaret_edit")

    @JvmField
    public val isInMulitcaretEditName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_in_mulitcaret_edit")

    @JvmField
    public val multicaretEditIgnoreCaretName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("multicaret_edit_ignore_caret")

    @JvmField
    public val isCaretVisibleName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("is_caret_visible")

    @JvmField
    public val getCaretDrawPosName: MethodStringName1<TextEdit, Vector2, Int> =
        MethodStringName1<TextEdit, Vector2, Int>("get_caret_draw_pos")

    @JvmField
    public val setCaretLineName: MethodStringName5<TextEdit, Unit, Int, Boolean, Boolean, Int, Int>
        = MethodStringName5<TextEdit, Unit, Int, Boolean, Boolean, Int, Int>("set_caret_line")

    @JvmField
    public val getCaretLineName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_caret_line")

    @JvmField
    public val setCaretColumnName: MethodStringName3<TextEdit, Unit, Int, Boolean, Int> =
        MethodStringName3<TextEdit, Unit, Int, Boolean, Int>("set_caret_column")

    @JvmField
    public val getCaretColumnName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_caret_column")

    @JvmField
    public val getNextCompositeCharacterColumnName: MethodStringName2<TextEdit, Int, Int, Int> =
        MethodStringName2<TextEdit, Int, Int, Int>("get_next_composite_character_column")

    @JvmField
    public val getPreviousCompositeCharacterColumnName: MethodStringName2<TextEdit, Int, Int, Int> =
        MethodStringName2<TextEdit, Int, Int, Int>("get_previous_composite_character_column")

    @JvmField
    public val getCaretWrapIndexName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_caret_wrap_index")

    @JvmField
    public val getWordUnderCaretName: MethodStringName1<TextEdit, String, Int> =
        MethodStringName1<TextEdit, String, Int>("get_word_under_caret")

    @JvmField
    public val setUseDefaultWordSeparatorsName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_use_default_word_separators")

    @JvmField
    public val isDefaultWordSeparatorsEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_default_word_separators_enabled")

    @JvmField
    public val setUseCustomWordSeparatorsName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_use_custom_word_separators")

    @JvmField
    public val isCustomWordSeparatorsEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_custom_word_separators_enabled")

    @JvmField
    public val setCustomWordSeparatorsName: MethodStringName1<TextEdit, Unit, String> =
        MethodStringName1<TextEdit, Unit, String>("set_custom_word_separators")

    @JvmField
    public val getCustomWordSeparatorsName: MethodStringName0<TextEdit, String> =
        MethodStringName0<TextEdit, String>("get_custom_word_separators")

    @JvmField
    public val setSelectingEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_selecting_enabled")

    @JvmField
    public val isSelectingEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_selecting_enabled")

    @JvmField
    public val setDeselectOnFocusLossEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_deselect_on_focus_loss_enabled")

    @JvmField
    public val isDeselectOnFocusLossEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_deselect_on_focus_loss_enabled")

    @JvmField
    public val setDragAndDropSelectionEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_drag_and_drop_selection_enabled")

    @JvmField
    public val isDragAndDropSelectionEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_drag_and_drop_selection_enabled")

    @JvmField
    public val setSelectionModeName: MethodStringName1<TextEdit, Unit, SelectionMode> =
        MethodStringName1<TextEdit, Unit, SelectionMode>("set_selection_mode")

    @JvmField
    public val getSelectionModeName: MethodStringName0<TextEdit, SelectionMode> =
        MethodStringName0<TextEdit, SelectionMode>("get_selection_mode")

    @JvmField
    public val selectAllName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("select_all")

    @JvmField
    public val selectWordUnderCaretName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("select_word_under_caret")

    @JvmField
    public val addSelectionForNextOccurrenceName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("add_selection_for_next_occurrence")

    @JvmField
    public val skipSelectionForNextOccurrenceName: MethodStringName0<TextEdit, Unit> =
        MethodStringName0<TextEdit, Unit>("skip_selection_for_next_occurrence")

    @JvmField
    public val selectName: MethodStringName5<TextEdit, Unit, Int, Int, Int, Int, Int> =
        MethodStringName5<TextEdit, Unit, Int, Int, Int, Int, Int>("select")

    @JvmField
    public val hasSelectionName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("has_selection")

    @JvmField
    public val getSelectedTextName: MethodStringName1<TextEdit, String, Int> =
        MethodStringName1<TextEdit, String, Int>("get_selected_text")

    @JvmField
    public val getSelectionAtLineColumnName:
        MethodStringName4<TextEdit, Int, Int, Int, Boolean, Boolean> =
        MethodStringName4<TextEdit, Int, Int, Int, Boolean, Boolean>("get_selection_at_line_column")

    @JvmField
    public val getLineRangesFromCaretsName:
        MethodStringName2<TextEdit, VariantArray<Vector2i>, Boolean, Boolean> =
        MethodStringName2<TextEdit, VariantArray<Vector2i>, Boolean, Boolean>("get_line_ranges_from_carets")

    @JvmField
    public val getSelectionOriginLineName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_origin_line")

    @JvmField
    public val getSelectionOriginColumnName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_origin_column")

    @JvmField
    public val setSelectionOriginLineName: MethodStringName4<TextEdit, Unit, Int, Boolean, Int, Int>
        = MethodStringName4<TextEdit, Unit, Int, Boolean, Int, Int>("set_selection_origin_line")

    @JvmField
    public val setSelectionOriginColumnName: MethodStringName2<TextEdit, Unit, Int, Int> =
        MethodStringName2<TextEdit, Unit, Int, Int>("set_selection_origin_column")

    @JvmField
    public val getSelectionFromLineName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_from_line")

    @JvmField
    public val getSelectionFromColumnName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_from_column")

    @JvmField
    public val getSelectionToLineName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_to_line")

    @JvmField
    public val getSelectionToColumnName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_to_column")

    @JvmField
    public val isCaretAfterSelectionOriginName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("is_caret_after_selection_origin")

    @JvmField
    public val deselectName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("deselect")

    @JvmField
    public val deleteSelectionName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("delete_selection")

    @JvmField
    public val setLineWrappingModeName: MethodStringName1<TextEdit, Unit, LineWrappingMode> =
        MethodStringName1<TextEdit, Unit, LineWrappingMode>("set_line_wrapping_mode")

    @JvmField
    public val getLineWrappingModeName: MethodStringName0<TextEdit, LineWrappingMode> =
        MethodStringName0<TextEdit, LineWrappingMode>("get_line_wrapping_mode")

    @JvmField
    public val setAutowrapModeName: MethodStringName1<TextEdit, Unit, TextServer.AutowrapMode> =
        MethodStringName1<TextEdit, Unit, TextServer.AutowrapMode>("set_autowrap_mode")

    @JvmField
    public val getAutowrapModeName: MethodStringName0<TextEdit, TextServer.AutowrapMode> =
        MethodStringName0<TextEdit, TextServer.AutowrapMode>("get_autowrap_mode")

    @JvmField
    public val isLineWrappedName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("is_line_wrapped")

    @JvmField
    public val getLineWrapCountName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_line_wrap_count")

    @JvmField
    public val getLineWrapIndexAtColumnName: MethodStringName2<TextEdit, Int, Int, Int> =
        MethodStringName2<TextEdit, Int, Int, Int>("get_line_wrap_index_at_column")

    @JvmField
    public val getLineWrappedTextName: MethodStringName1<TextEdit, PackedStringArray, Int> =
        MethodStringName1<TextEdit, PackedStringArray, Int>("get_line_wrapped_text")

    @JvmField
    public val setSmoothScrollEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_smooth_scroll_enabled")

    @JvmField
    public val isSmoothScrollEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_smooth_scroll_enabled")

    @JvmField
    public val getVScrollBarName: MethodStringName0<TextEdit, VScrollBar?> =
        MethodStringName0<TextEdit, VScrollBar?>("get_v_scroll_bar")

    @JvmField
    public val getHScrollBarName: MethodStringName0<TextEdit, HScrollBar?> =
        MethodStringName0<TextEdit, HScrollBar?>("get_h_scroll_bar")

    @JvmField
    public val setVScrollName: MethodStringName1<TextEdit, Unit, Double> =
        MethodStringName1<TextEdit, Unit, Double>("set_v_scroll")

    @JvmField
    public val getVScrollName: MethodStringName0<TextEdit, Double> =
        MethodStringName0<TextEdit, Double>("get_v_scroll")

    @JvmField
    public val setHScrollName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("set_h_scroll")

    @JvmField
    public val getHScrollName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_h_scroll")

    @JvmField
    public val setScrollPastEndOfFileEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_scroll_past_end_of_file_enabled")

    @JvmField
    public val isScrollPastEndOfFileEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_scroll_past_end_of_file_enabled")

    @JvmField
    public val setVScrollSpeedName: MethodStringName1<TextEdit, Unit, Float> =
        MethodStringName1<TextEdit, Unit, Float>("set_v_scroll_speed")

    @JvmField
    public val getVScrollSpeedName: MethodStringName0<TextEdit, Float> =
        MethodStringName0<TextEdit, Float>("get_v_scroll_speed")

    @JvmField
    public val setFitContentHeightEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_fit_content_height_enabled")

    @JvmField
    public val isFitContentHeightEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_fit_content_height_enabled")

    @JvmField
    public val setFitContentWidthEnabledName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_fit_content_width_enabled")

    @JvmField
    public val isFitContentWidthEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_fit_content_width_enabled")

    @JvmField
    public val getScrollPosForLineName: MethodStringName2<TextEdit, Double, Int, Int> =
        MethodStringName2<TextEdit, Double, Int, Int>("get_scroll_pos_for_line")

    @JvmField
    public val setLineAsFirstVisibleName: MethodStringName2<TextEdit, Unit, Int, Int> =
        MethodStringName2<TextEdit, Unit, Int, Int>("set_line_as_first_visible")

    @JvmField
    public val getFirstVisibleLineName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_first_visible_line")

    @JvmField
    public val isLineInViewportName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("is_line_in_viewport")

    @JvmField
    public val setLineAsCenterVisibleName: MethodStringName2<TextEdit, Unit, Int, Int> =
        MethodStringName2<TextEdit, Unit, Int, Int>("set_line_as_center_visible")

    @JvmField
    public val setLineAsLastVisibleName: MethodStringName2<TextEdit, Unit, Int, Int> =
        MethodStringName2<TextEdit, Unit, Int, Int>("set_line_as_last_visible")

    @JvmField
    public val getLastFullVisibleLineName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_last_full_visible_line")

    @JvmField
    public val getLastFullVisibleLineWrapIndexName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_last_full_visible_line_wrap_index")

    @JvmField
    public val getVisibleLineCountName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_visible_line_count")

    @JvmField
    public val getVisibleLineCountInRangeName: MethodStringName2<TextEdit, Int, Int, Int> =
        MethodStringName2<TextEdit, Int, Int, Int>("get_visible_line_count_in_range")

    @JvmField
    public val getTotalVisibleLineCountName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_total_visible_line_count")

    @JvmField
    public val adjustViewportToCaretName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("adjust_viewport_to_caret")

    @JvmField
    public val centerViewportToCaretName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("center_viewport_to_caret")

    @JvmField
    public val setDrawMinimapName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_draw_minimap")

    @JvmField
    public val isDrawingMinimapName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_drawing_minimap")

    @JvmField
    public val setMinimapWidthName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("set_minimap_width")

    @JvmField
    public val getMinimapWidthName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_minimap_width")

    @JvmField
    public val getMinimapVisibleLinesName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_minimap_visible_lines")

    @JvmField
    public val addGutterName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("add_gutter")

    @JvmField
    public val removeGutterName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("remove_gutter")

    @JvmField
    public val getGutterCountName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_gutter_count")

    @JvmField
    public val setGutterNameName: MethodStringName2<TextEdit, Unit, Int, String> =
        MethodStringName2<TextEdit, Unit, Int, String>("set_gutter_name")

    @JvmField
    public val getGutterNameName: MethodStringName1<TextEdit, String, Int> =
        MethodStringName1<TextEdit, String, Int>("get_gutter_name")

    @JvmField
    public val setGutterTypeName: MethodStringName2<TextEdit, Unit, Int, GutterType> =
        MethodStringName2<TextEdit, Unit, Int, GutterType>("set_gutter_type")

    @JvmField
    public val getGutterTypeName: MethodStringName1<TextEdit, GutterType, Int> =
        MethodStringName1<TextEdit, GutterType, Int>("get_gutter_type")

    @JvmField
    public val setGutterWidthName: MethodStringName2<TextEdit, Unit, Int, Int> =
        MethodStringName2<TextEdit, Unit, Int, Int>("set_gutter_width")

    @JvmField
    public val getGutterWidthName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_gutter_width")

    @JvmField
    public val setGutterDrawName: MethodStringName2<TextEdit, Unit, Int, Boolean> =
        MethodStringName2<TextEdit, Unit, Int, Boolean>("set_gutter_draw")

    @JvmField
    public val isGutterDrawnName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("is_gutter_drawn")

    @JvmField
    public val setGutterClickableName: MethodStringName2<TextEdit, Unit, Int, Boolean> =
        MethodStringName2<TextEdit, Unit, Int, Boolean>("set_gutter_clickable")

    @JvmField
    public val isGutterClickableName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("is_gutter_clickable")

    @JvmField
    public val setGutterOverwritableName: MethodStringName2<TextEdit, Unit, Int, Boolean> =
        MethodStringName2<TextEdit, Unit, Int, Boolean>("set_gutter_overwritable")

    @JvmField
    public val isGutterOverwritableName: MethodStringName1<TextEdit, Boolean, Int> =
        MethodStringName1<TextEdit, Boolean, Int>("is_gutter_overwritable")

    @JvmField
    public val mergeGuttersName: MethodStringName2<TextEdit, Unit, Int, Int> =
        MethodStringName2<TextEdit, Unit, Int, Int>("merge_gutters")

    @JvmField
    public val setGutterCustomDrawName: MethodStringName2<TextEdit, Unit, Int, Callable> =
        MethodStringName2<TextEdit, Unit, Int, Callable>("set_gutter_custom_draw")

    @JvmField
    public val getTotalGutterWidthName: MethodStringName0<TextEdit, Int> =
        MethodStringName0<TextEdit, Int>("get_total_gutter_width")

    @JvmField
    public val setLineGutterMetadataName: MethodStringName3<TextEdit, Unit, Int, Int, Any?> =
        MethodStringName3<TextEdit, Unit, Int, Int, Any?>("set_line_gutter_metadata")

    @JvmField
    public val getLineGutterMetadataName: MethodStringName2<TextEdit, Any?, Int, Int> =
        MethodStringName2<TextEdit, Any?, Int, Int>("get_line_gutter_metadata")

    @JvmField
    public val setLineGutterTextName: MethodStringName3<TextEdit, Unit, Int, Int, String> =
        MethodStringName3<TextEdit, Unit, Int, Int, String>("set_line_gutter_text")

    @JvmField
    public val getLineGutterTextName: MethodStringName2<TextEdit, String, Int, Int> =
        MethodStringName2<TextEdit, String, Int, Int>("get_line_gutter_text")

    @JvmField
    public val setLineGutterIconName: MethodStringName3<TextEdit, Unit, Int, Int, Texture2D?> =
        MethodStringName3<TextEdit, Unit, Int, Int, Texture2D?>("set_line_gutter_icon")

    @JvmField
    public val getLineGutterIconName: MethodStringName2<TextEdit, Texture2D?, Int, Int> =
        MethodStringName2<TextEdit, Texture2D?, Int, Int>("get_line_gutter_icon")

    @JvmField
    public val setLineGutterItemColorName: MethodStringName3<TextEdit, Unit, Int, Int, Color> =
        MethodStringName3<TextEdit, Unit, Int, Int, Color>("set_line_gutter_item_color")

    @JvmField
    public val getLineGutterItemColorName: MethodStringName2<TextEdit, Color, Int, Int> =
        MethodStringName2<TextEdit, Color, Int, Int>("get_line_gutter_item_color")

    @JvmField
    public val setLineGutterClickableName: MethodStringName3<TextEdit, Unit, Int, Int, Boolean> =
        MethodStringName3<TextEdit, Unit, Int, Int, Boolean>("set_line_gutter_clickable")

    @JvmField
    public val isLineGutterClickableName: MethodStringName2<TextEdit, Boolean, Int, Int> =
        MethodStringName2<TextEdit, Boolean, Int, Int>("is_line_gutter_clickable")

    @JvmField
    public val setLineBackgroundColorName: MethodStringName2<TextEdit, Unit, Int, Color> =
        MethodStringName2<TextEdit, Unit, Int, Color>("set_line_background_color")

    @JvmField
    public val getLineBackgroundColorName: MethodStringName1<TextEdit, Color, Int> =
        MethodStringName1<TextEdit, Color, Int>("get_line_background_color")

    @JvmField
    public val setSyntaxHighlighterName: MethodStringName1<TextEdit, Unit, SyntaxHighlighter?> =
        MethodStringName1<TextEdit, Unit, SyntaxHighlighter?>("set_syntax_highlighter")

    @JvmField
    public val getSyntaxHighlighterName: MethodStringName0<TextEdit, SyntaxHighlighter?> =
        MethodStringName0<TextEdit, SyntaxHighlighter?>("get_syntax_highlighter")

    @JvmField
    public val setHighlightCurrentLineName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_highlight_current_line")

    @JvmField
    public val isHighlightCurrentLineEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_highlight_current_line_enabled")

    @JvmField
    public val setHighlightAllOccurrencesName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_highlight_all_occurrences")

    @JvmField
    public val isHighlightAllOccurrencesEnabledName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_highlight_all_occurrences_enabled")

    @JvmField
    public val getDrawControlCharsName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("get_draw_control_chars")

    @JvmField
    public val setDrawControlCharsName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_draw_control_chars")

    @JvmField
    public val setDrawTabsName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_draw_tabs")

    @JvmField
    public val isDrawingTabsName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_drawing_tabs")

    @JvmField
    public val setDrawSpacesName: MethodStringName1<TextEdit, Unit, Boolean> =
        MethodStringName1<TextEdit, Unit, Boolean>("set_draw_spaces")

    @JvmField
    public val isDrawingSpacesName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_drawing_spaces")

    @JvmField
    public val getMenuName: MethodStringName0<TextEdit, PopupMenu?> =
        MethodStringName0<TextEdit, PopupMenu?>("get_menu")

    @JvmField
    public val isMenuVisibleName: MethodStringName0<TextEdit, Boolean> =
        MethodStringName0<TextEdit, Boolean>("is_menu_visible")

    @JvmField
    public val menuOptionName: MethodStringName1<TextEdit, Unit, Int> =
        MethodStringName1<TextEdit, Unit, Int>("menu_option")

    @JvmField
    public val adjustCaretsAfterEditName: MethodStringName5<TextEdit, Unit, Int, Int, Int, Int, Int>
        = MethodStringName5<TextEdit, Unit, Int, Int, Int, Int, Int>("adjust_carets_after_edit")

    @JvmField
    public val getCaretIndexEditOrderName: MethodStringName0<TextEdit, PackedInt32Array> =
        MethodStringName0<TextEdit, PackedInt32Array>("get_caret_index_edit_order")

    @JvmField
    public val getSelectionLineName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_line")

    @JvmField
    public val getSelectionColumnName: MethodStringName1<TextEdit, Int, Int> =
        MethodStringName1<TextEdit, Int, Int>("get_selection_column")
  }

  public object MethodBindings {
    internal val hasImeTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "has_ime_text", 36873697)

    internal val cancelImePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "cancel_ime", 3218959716)

    internal val applyImePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "apply_ime", 3218959716)

    internal val setEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_editable", 2586408642)

    internal val isEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_editable", 36873697)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_text_direction", 119160795)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_text_direction", 797257663)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_language", 201670096)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_structured_text_bidi_override", 55961453)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_structured_text_bidi_override", 3385126229)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_structured_text_bidi_override_options", 381264803)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_structured_text_bidi_override_options", 3995934104)

    internal val setTabSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_tab_size", 1286410249)

    internal val getTabSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_tab_size", 3905245786)

    internal val setIndentWrappedLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_indent_wrapped_lines", 2586408642)

    internal val isIndentWrappedLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_indent_wrapped_lines", 36873697)

    internal val setTabInputModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_tab_input_mode", 2586408642)

    internal val getTabInputModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_tab_input_mode", 36873697)

    internal val setOvertypeModeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_overtype_mode_enabled", 2586408642)

    internal val isOvertypeModeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_overtype_mode_enabled", 36873697)

    internal val setContextMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_context_menu_enabled", 2586408642)

    internal val isContextMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_context_menu_enabled", 36873697)

    internal val setEmojiMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_emoji_menu_enabled", 2586408642)

    internal val isEmojiMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_emoji_menu_enabled", 36873697)

    internal val setBackspaceDeletesCompositeCharacterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_backspace_deletes_composite_character_enabled", 2586408642)

    internal val isBackspaceDeletesCompositeCharacterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_backspace_deletes_composite_character_enabled", 36873697)

    internal val setShortcutKeysEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_shortcut_keys_enabled", 2586408642)

    internal val isShortcutKeysEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_shortcut_keys_enabled", 36873697)

    internal val setVirtualKeyboardEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_virtual_keyboard_enabled", 2586408642)

    internal val isVirtualKeyboardEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_virtual_keyboard_enabled", 36873697)

    internal val setVirtualKeyboardShowOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_virtual_keyboard_show_on_focus", 2586408642)

    internal val getVirtualKeyboardShowOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_virtual_keyboard_show_on_focus", 36873697)

    internal val setMiddleMousePasteEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_middle_mouse_paste_enabled", 2586408642)

    internal val isMiddleMousePasteEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_middle_mouse_paste_enabled", 36873697)

    internal val setEmptySelectionClipboardEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_empty_selection_clipboard_enabled", 2586408642)

    internal val isEmptySelectionClipboardEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_empty_selection_clipboard_enabled", 36873697)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "clear", 3218959716)

    internal val setTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_text", 83702148)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_text", 201670096)

    internal val getLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_count", 3905245786)

    internal val setPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_placeholder", 83702148)

    internal val getPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_placeholder", 201670096)

    internal val setLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line", 501894301)

    internal val getLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line", 844755477)

    internal val getLineWithImePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_with_ime", 844755477)

    internal val getLineWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_width", 688195400)

    internal val getLineHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_height", 3905245786)

    internal val getIndentLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_indent_level", 923996154)

    internal val getFirstNonWhitespaceColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_first_non_whitespace_column", 923996154)

    internal val swapLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "swap_lines", 3937882851)

    internal val insertLineAtPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "insert_line_at", 501894301)

    internal val removeLineAtPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "remove_line_at", 972357352)

    internal val insertTextAtCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "insert_text_at_caret", 2697778442)

    internal val insertTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "insert_text", 1881564334)

    internal val removeTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "remove_text", 4275841770)

    internal val getLastUnhiddenLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_last_unhidden_line", 3905245786)

    internal val getNextVisibleLineOffsetFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_next_visible_line_offset_from", 3175239445)

    internal val getNextVisibleLineIndexOffsetFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_next_visible_line_index_offset_from", 3386475622)

    internal val backspacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "backspace", 1025054187)

    internal val cutPtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "cut", 1025054187)

    internal val copyPtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "copy", 1025054187)

    internal val pastePtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "paste", 1025054187)

    internal val pastePrimaryClipboardPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "paste_primary_clipboard", 1025054187)

    internal val startActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "start_action", 2834827583)

    internal val endActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "end_action", 3218959716)

    internal val beginComplexOperationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "begin_complex_operation", 3218959716)

    internal val endComplexOperationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "end_complex_operation", 3218959716)

    internal val hasUndoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "has_undo", 36873697)

    internal val hasRedoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "has_redo", 36873697)

    internal val undoPtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "undo", 3218959716)

    internal val redoPtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "redo", 3218959716)

    internal val clearUndoHistoryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "clear_undo_history", 3218959716)

    internal val tagSavedVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "tag_saved_version", 3218959716)

    internal val getVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_version", 3905245786)

    internal val getSavedVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_saved_version", 3905245786)

    internal val setSearchTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_search_text", 83702148)

    internal val setSearchFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_search_flags", 1286410249)

    internal val searchPtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "search", 1203739136)

    internal val setTooltipRequestFuncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_tooltip_request_func", 1611583062)

    internal val getLocalMousePosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_local_mouse_pos", 3341600327)

    internal val getWordAtPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_word_at_pos", 3674420000)

    internal val getLineColumnAtPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_column_at_pos", 3472935744)

    internal val getPosAtLineColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_pos_at_line_column", 410388347)

    internal val getRectAtLineColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_rect_at_line_column", 3256618057)

    internal val getMinimapLineAtPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_minimap_line_at_pos", 2485466453)

    internal val isDraggingCursorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_dragging_cursor", 36873697)

    internal val isMouseOverSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_mouse_over_selection", 1840282309)

    internal val setCaretTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_caret_type", 1211596914)

    internal val getCaretTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_type", 2830252959)

    internal val setCaretBlinkEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_caret_blink_enabled", 2586408642)

    internal val isCaretBlinkEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_caret_blink_enabled", 36873697)

    internal val setCaretBlinkIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_caret_blink_interval", 373806689)

    internal val getCaretBlinkIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_blink_interval", 1740695150)

    internal val setDrawCaretWhenEditableDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_draw_caret_when_editable_disabled", 2586408642)

    internal val isDrawingCaretWhenEditableDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_drawing_caret_when_editable_disabled", 36873697)

    internal val setMoveCaretOnRightClickEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_move_caret_on_right_click_enabled", 2586408642)

    internal val isMoveCaretOnRightClickEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_move_caret_on_right_click_enabled", 36873697)

    internal val setCaretMidGraphemeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_caret_mid_grapheme_enabled", 2586408642)

    internal val isCaretMidGraphemeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_caret_mid_grapheme_enabled", 36873697)

    internal val setMultipleCaretsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_multiple_carets_enabled", 2586408642)

    internal val isMultipleCaretsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_multiple_carets_enabled", 36873697)

    internal val addCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "add_caret", 50157827)

    internal val removeCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "remove_caret", 1286410249)

    internal val removeSecondaryCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "remove_secondary_carets", 3218959716)

    internal val getCaretCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_count", 3905245786)

    internal val addCaretAtCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "add_caret_at_carets", 2586408642)

    internal val getSortedCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_sorted_carets", 2131714034)

    internal val collapseCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "collapse_carets", 228654177)

    internal val mergeOverlappingCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "merge_overlapping_carets", 3218959716)

    internal val beginMulticaretEditPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "begin_multicaret_edit", 3218959716)

    internal val endMulticaretEditPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "end_multicaret_edit", 3218959716)

    internal val isInMulitcaretEditPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_in_mulitcaret_edit", 36873697)

    internal val multicaretEditIgnoreCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "multicaret_edit_ignore_caret", 1116898809)

    internal val isCaretVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_caret_visible", 1051549951)

    internal val getCaretDrawPosPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_draw_pos", 478253731)

    internal val setCaretLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_caret_line", 1302582944)

    internal val getCaretLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_line", 1591665591)

    internal val setCaretColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_caret_column", 3796796178)

    internal val getCaretColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_column", 1591665591)

    internal val getNextCompositeCharacterColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_next_composite_character_column", 3175239445)

    internal val getPreviousCompositeCharacterColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_previous_composite_character_column", 3175239445)

    internal val getCaretWrapIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_wrap_index", 1591665591)

    internal val getWordUnderCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_word_under_caret", 3929349208)

    internal val setUseDefaultWordSeparatorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_use_default_word_separators", 2586408642)

    internal val isDefaultWordSeparatorsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_default_word_separators_enabled", 36873697)

    internal val setUseCustomWordSeparatorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_use_custom_word_separators", 2586408642)

    internal val isCustomWordSeparatorsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_custom_word_separators_enabled", 36873697)

    internal val setCustomWordSeparatorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_custom_word_separators", 83702148)

    internal val getCustomWordSeparatorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_custom_word_separators", 201670096)

    internal val setSelectingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_selecting_enabled", 2586408642)

    internal val isSelectingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_selecting_enabled", 36873697)

    internal val setDeselectOnFocusLossEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_deselect_on_focus_loss_enabled", 2586408642)

    internal val isDeselectOnFocusLossEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_deselect_on_focus_loss_enabled", 36873697)

    internal val setDragAndDropSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_drag_and_drop_selection_enabled", 2586408642)

    internal val isDragAndDropSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_drag_and_drop_selection_enabled", 36873697)

    internal val setSelectionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_selection_mode", 1658801786)

    internal val getSelectionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_mode", 3750106938)

    internal val selectAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "select_all", 3218959716)

    internal val selectWordUnderCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "select_word_under_caret", 1025054187)

    internal val addSelectionForNextOccurrencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "add_selection_for_next_occurrence", 3218959716)

    internal val skipSelectionForNextOccurrencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "skip_selection_for_next_occurrence", 3218959716)

    internal val selectPtr: VoidPtr = TypeManager.getMethodBindPtr("TextEdit", "select", 2560984452)

    internal val hasSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "has_selection", 2824505868)

    internal val getSelectedTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selected_text", 2309358862)

    internal val getSelectionAtLineColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_at_line_column", 1810224333)

    internal val getLineRangesFromCaretsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_ranges_from_carets", 2393089247)

    internal val getSelectionOriginLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_origin_line", 1591665591)

    internal val getSelectionOriginColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_origin_column", 1591665591)

    internal val setSelectionOriginLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_selection_origin_line", 195434140)

    internal val setSelectionOriginColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_selection_origin_column", 2230941749)

    internal val getSelectionFromLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_from_line", 1591665591)

    internal val getSelectionFromColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_from_column", 1591665591)

    internal val getSelectionToLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_to_line", 1591665591)

    internal val getSelectionToColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_to_column", 1591665591)

    internal val isCaretAfterSelectionOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_caret_after_selection_origin", 1051549951)

    internal val deselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "deselect", 1025054187)

    internal val deleteSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "delete_selection", 1025054187)

    internal val setLineWrappingModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_wrapping_mode", 2525115309)

    internal val getLineWrappingModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_wrapping_mode", 3562716114)

    internal val setAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_autowrap_mode", 3289138044)

    internal val getAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_autowrap_mode", 1549071663)

    internal val isLineWrappedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_line_wrapped", 1116898809)

    internal val getLineWrapCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_wrap_count", 923996154)

    internal val getLineWrapIndexAtColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_wrap_index_at_column", 3175239445)

    internal val getLineWrappedTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_wrapped_text", 647634434)

    internal val setSmoothScrollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_smooth_scroll_enabled", 2586408642)

    internal val isSmoothScrollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_smooth_scroll_enabled", 36873697)

    internal val getVScrollBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_v_scroll_bar", 3226026593)

    internal val getHScrollBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_h_scroll_bar", 3774687988)

    internal val setVScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_v_scroll", 373806689)

    internal val getVScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_v_scroll", 1740695150)

    internal val setHScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_h_scroll", 1286410249)

    internal val getHScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_h_scroll", 3905245786)

    internal val setScrollPastEndOfFileEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_scroll_past_end_of_file_enabled", 2586408642)

    internal val isScrollPastEndOfFileEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_scroll_past_end_of_file_enabled", 36873697)

    internal val setVScrollSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_v_scroll_speed", 373806689)

    internal val getVScrollSpeedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_v_scroll_speed", 1740695150)

    internal val setFitContentHeightEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_fit_content_height_enabled", 2586408642)

    internal val isFitContentHeightEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_fit_content_height_enabled", 36873697)

    internal val setFitContentWidthEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_fit_content_width_enabled", 2586408642)

    internal val isFitContentWidthEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_fit_content_width_enabled", 36873697)

    internal val getScrollPosForLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_scroll_pos_for_line", 3929084198)

    internal val setLineAsFirstVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_as_first_visible", 2230941749)

    internal val getFirstVisibleLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_first_visible_line", 3905245786)

    internal val isLineInViewportPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_line_in_viewport", 1116898809)

    internal val setLineAsCenterVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_as_center_visible", 2230941749)

    internal val setLineAsLastVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_as_last_visible", 2230941749)

    internal val getLastFullVisibleLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_last_full_visible_line", 3905245786)

    internal val getLastFullVisibleLineWrapIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_last_full_visible_line_wrap_index", 3905245786)

    internal val getVisibleLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_visible_line_count", 3905245786)

    internal val getVisibleLineCountInRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_visible_line_count_in_range", 3175239445)

    internal val getTotalVisibleLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_total_visible_line_count", 3905245786)

    internal val adjustViewportToCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "adjust_viewport_to_caret", 1995695955)

    internal val centerViewportToCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "center_viewport_to_caret", 1995695955)

    internal val setDrawMinimapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_draw_minimap", 2586408642)

    internal val isDrawingMinimapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_drawing_minimap", 36873697)

    internal val setMinimapWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_minimap_width", 1286410249)

    internal val getMinimapWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_minimap_width", 3905245786)

    internal val getMinimapVisibleLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_minimap_visible_lines", 3905245786)

    internal val addGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "add_gutter", 1025054187)

    internal val removeGutterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "remove_gutter", 1286410249)

    internal val getGutterCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_gutter_count", 3905245786)

    internal val setGutterNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_gutter_name", 501894301)

    internal val getGutterNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_gutter_name", 844755477)

    internal val setGutterTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_gutter_type", 1088959071)

    internal val getGutterTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_gutter_type", 1159699127)

    internal val setGutterWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_gutter_width", 3937882851)

    internal val getGutterWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_gutter_width", 923996154)

    internal val setGutterDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_gutter_draw", 300928843)

    internal val isGutterDrawnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_gutter_drawn", 1116898809)

    internal val setGutterClickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_gutter_clickable", 300928843)

    internal val isGutterClickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_gutter_clickable", 1116898809)

    internal val setGutterOverwritablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_gutter_overwritable", 300928843)

    internal val isGutterOverwritablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_gutter_overwritable", 1116898809)

    internal val mergeGuttersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "merge_gutters", 3937882851)

    internal val setGutterCustomDrawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_gutter_custom_draw", 957362965)

    internal val getTotalGutterWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_total_gutter_width", 3905245786)

    internal val setLineGutterMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_gutter_metadata", 2060538656)

    internal val getLineGutterMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_gutter_metadata", 678354945)

    internal val setLineGutterTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_gutter_text", 2285447957)

    internal val getLineGutterTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_gutter_text", 1391810591)

    internal val setLineGutterIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_gutter_icon", 176101966)

    internal val getLineGutterIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_gutter_icon", 2584904275)

    internal val setLineGutterItemColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_gutter_item_color", 3733378741)

    internal val getLineGutterItemColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_gutter_item_color", 2165839948)

    internal val setLineGutterClickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_gutter_clickable", 1383440665)

    internal val isLineGutterClickablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_line_gutter_clickable", 2522259332)

    internal val setLineBackgroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_line_background_color", 2878471219)

    internal val getLineBackgroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_line_background_color", 3457211756)

    internal val setSyntaxHighlighterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_syntax_highlighter", 2765644541)

    internal val getSyntaxHighlighterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_syntax_highlighter", 2721131626)

    internal val setHighlightCurrentLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_highlight_current_line", 2586408642)

    internal val isHighlightCurrentLineEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_highlight_current_line_enabled", 36873697)

    internal val setHighlightAllOccurrencesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_highlight_all_occurrences", 2586408642)

    internal val isHighlightAllOccurrencesEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_highlight_all_occurrences_enabled", 36873697)

    internal val getDrawControlCharsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_draw_control_chars", 36873697)

    internal val setDrawControlCharsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_draw_control_chars", 2586408642)

    internal val setDrawTabsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_draw_tabs", 2586408642)

    internal val isDrawingTabsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_drawing_tabs", 36873697)

    internal val setDrawSpacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "set_draw_spaces", 2586408642)

    internal val isDrawingSpacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_drawing_spaces", 36873697)

    internal val getMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_menu", 229722558)

    internal val isMenuVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "is_menu_visible", 36873697)

    internal val menuOptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "menu_option", 1286410249)

    internal val adjustCaretsAfterEditPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "adjust_carets_after_edit", 1770277138)

    internal val getCaretIndexEditOrderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_caret_index_edit_order", 969006518)

    internal val getSelectionLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_line", 1591665591)

    internal val getSelectionColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextEdit", "get_selection_column", 1591665591)
  }
}
