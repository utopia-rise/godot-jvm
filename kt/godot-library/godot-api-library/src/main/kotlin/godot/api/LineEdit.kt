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
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Signal1
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [LineEdit] provides an input field for editing a single line of text.
 *
 * - When the [LineEdit] control is focused using the keyboard arrow keys, it will only gain focus
 * and not enter edit mode.
 *
 * - To enter edit mode, click on the control with the mouse, see also [keepEditingOnTextSubmit].
 *
 * - To exit edit mode, press `ui_text_submit` or `ui_cancel` (by default [kbd]Escape[/kbd])
 * actions.
 *
 * - Check [edit], [unedit], [isEditing], and [signal editing_toggled] for more information.
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
 * **Important:**
 *
 * - Focusing the [LineEdit] with `ui_focus_next` (by default [kbd]Tab[/kbd]) or `ui_focus_prev` (by
 * default [kbd]Shift + Tab[/kbd]) or [Control.grabFocus] still enters edit mode (for compatibility).
 *
 * [LineEdit] features many built-in shortcuts that are always available ([kbd]Ctrl[/kbd] here maps
 * to [kbd]Cmd[/kbd] on macOS):
 *
 * - [kbd]Ctrl + C[/kbd]: Copy
 *
 * - [kbd]Ctrl + X[/kbd]: Cut
 *
 * - [kbd]Ctrl + V[/kbd] or [kbd]Ctrl + Y[/kbd]: Paste/"yank"
 *
 * - [kbd]Ctrl + Z[/kbd]: Undo
 *
 * - [kbd]Ctrl + ~[/kbd]: Swap input direction.
 *
 * - [kbd]Ctrl + Shift + Z[/kbd]: Redo
 *
 * - [kbd]Ctrl + U[/kbd]: Delete text from the caret position to the beginning of the line
 *
 * - [kbd]Ctrl + K[/kbd]: Delete text from the caret position to the end of the line
 *
 * - [kbd]Ctrl + A[/kbd]: Select all text
 *
 * - [kbd]Up Arrow[/kbd]/[kbd]Down Arrow[/kbd]: Move the caret to the beginning/end of the line
 *
 * On macOS, some extra keyboard shortcuts are available:
 *
 * - [kbd]Cmd + F[/kbd]: Same as [kbd]Right Arrow[/kbd], move the caret one character right
 *
 * - [kbd]Cmd + B[/kbd]: Same as [kbd]Left Arrow[/kbd], move the caret one character left
 *
 * - [kbd]Cmd + P[/kbd]: Same as [kbd]Up Arrow[/kbd], move the caret to the previous line
 *
 * - [kbd]Cmd + N[/kbd]: Same as [kbd]Down Arrow[/kbd], move the caret to the next line
 *
 * - [kbd]Cmd + D[/kbd]: Same as [kbd]Delete[/kbd], delete the character on the right side of caret
 *
 * - [kbd]Cmd + H[/kbd]: Same as [kbd]Backspace[/kbd], delete the character on the left side of the
 * caret
 *
 * - [kbd]Cmd + A[/kbd]: Same as [kbd]Home[/kbd], move the caret to the beginning of the line
 *
 * - [kbd]Cmd + E[/kbd]: Same as [kbd]End[/kbd], move the caret to the end of the line
 *
 * - [kbd]Cmd + Left Arrow[/kbd]: Same as [kbd]Home[/kbd], move the caret to the beginning of the
 * line
 *
 * - [kbd]Cmd + Right Arrow[/kbd]: Same as [kbd]End[/kbd], move the caret to the end of the line
 *
 * **Note:** Caret movement shortcuts listed above are not affected by [shortcutKeysEnabled].
 */
@GodotBaseType
public open class LineEdit : Control() {
  /**
   * Emitted when the text changes.
   */
  public val textChanged: Signal1<String> by Signal1

  /**
   * Emitted when appending text that overflows the [maxLength]. The appended text is truncated to
   * fit [maxLength], and the part that couldn't fit is passed as the [rejectedSubstring] argument.
   */
  public val textChangeRejected: Signal1<String> by Signal1

  /**
   * Emitted when the user presses the `ui_text_submit` action (by default: [kbd]Enter[/kbd] or
   * [kbd]Kp Enter[/kbd]) while the [LineEdit] has focus.
   */
  public val textSubmitted: Signal1<String> by Signal1

  /**
   * Emitted when the [LineEdit] switches in or out of edit mode.
   */
  public val editingToggled: Signal1<Boolean> by Signal1

  /**
   * String value of the [LineEdit].
   *
   * **Note:** Changing text using this property won't emit the [signal text_changed] signal.
   */
  public final inline var text: String
    @JvmName("textProperty")
    get() = getText()
    @JvmName("textProperty")
    set(`value`) {
      setText(value)
    }

  /**
   * Text shown when the [LineEdit] is empty. It is **not** the [LineEdit]'s default value (see
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
   * The text's horizontal alignment.
   */
  public final inline var alignment: HorizontalAlignment
    @JvmName("alignmentProperty")
    get() = getHorizontalAlignment()
    @JvmName("alignmentProperty")
    set(`value`) {
      setHorizontalAlignment(value)
    }

  /**
   * Maximum number of characters that can be entered inside the [LineEdit]. If `0`, there is no
   * limit.
   *
   * When a limit is defined, characters that would exceed [maxLength] are truncated. This happens
   * both for existing [text] contents when setting the max length, or for new text inserted in the
   * [LineEdit], including pasting.
   *
   * If any input text is truncated, the [signal text_change_rejected] signal is emitted with the
   * truncated substring as a parameter:
   *
   * ```gdscript
   * //gdscript
   * text = "Hello world"
   * max_length = 5
   * # `text` becomes "Hello".
   * max_length = 10
   * text += " goodbye"
   * # `text` becomes "Hello good".
   * # `text_change_rejected` is emitted with "bye" as a parameter.
   * ```
   *
   * ```csharp
   * //csharp
   * Text = "Hello world";
   * MaxLength = 5;
   * // `Text` becomes "Hello".
   * MaxLength = 10;
   * Text += " goodbye";
   * // `Text` becomes "Hello good".
   * // `text_change_rejected` is emitted with "bye" as a parameter.
   * ```
   */
  public final inline var maxLength: Int
    @JvmName("maxLengthProperty")
    get() = getMaxLength()
    @JvmName("maxLengthProperty")
    set(`value`) {
      setMaxLength(value)
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
   * If `true`, the [LineEdit] will not exit edit mode when text is submitted by pressing
   * `ui_text_submit` action (by default: [kbd]Enter[/kbd] or [kbd]Kp Enter[/kbd]).
   */
  public final inline var keepEditingOnTextSubmit: Boolean
    @JvmName("keepEditingOnTextSubmitProperty")
    get() = isEditingKeptOnTextSubmit()
    @JvmName("keepEditingOnTextSubmitProperty")
    set(`value`) {
      setKeepEditingOnTextSubmit(value)
    }

  /**
   * If `true`, the [LineEdit] width will increase to stay longer than the [text]. It will **not**
   * compress if the [text] is shortened.
   */
  public final inline var expandToTextLength: Boolean
    @JvmName("expandToTextLengthProperty")
    get() = isExpandToTextLengthEnabled()
    @JvmName("expandToTextLengthProperty")
    set(`value`) {
      setExpandToTextLengthEnabled(value)
    }

  /**
   * If `true`, the context menu will appear when right-clicked.
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
   * If `true`, the [LineEdit] will show a clear button if [text] is not empty, which can be used to
   * clear the text quickly.
   */
  public final inline var clearButtonEnabled: Boolean
    @JvmName("clearButtonEnabledProperty")
    get() = isClearButtonEnabled()
    @JvmName("clearButtonEnabledProperty")
    set(`value`) {
      setClearButtonEnabled(value)
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
   * If `false`, it's impossible to select the text using mouse nor keyboard.
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
   * If `true`, allow drag and drop of selected text.
   */
  public final inline var dragAndDropSelectionEnabled: Boolean
    @JvmName("dragAndDropSelectionEnabledProperty")
    get() = isDragAndDropSelectionEnabled()
    @JvmName("dragAndDropSelectionEnabledProperty")
    set(`value`) {
      setDragAndDropSelectionEnabled(value)
    }

  /**
   * If `true`, the [LineEdit] doesn't display decoration.
   */
  public final inline var flat: Boolean
    @JvmName("flatProperty")
    get() = isFlat()
    @JvmName("flatProperty")
    set(`value`) {
      setFlat(value)
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
   * If `true`, the [LineEdit] will select the whole text when it gains focus.
   */
  public final inline var selectAllOnFocus: Boolean
    @JvmName("selectAllOnFocusProperty")
    get() = isSelectAllOnFocus()
    @JvmName("selectAllOnFocusProperty")
    set(`value`) {
      setSelectAllOnFocus(value)
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
   * Specifies the type of virtual keyboard to show.
   */
  public final inline var virtualKeyboardType: VirtualKeyboardType
    @JvmName("virtualKeyboardTypeProperty")
    get() = getVirtualKeyboardType()
    @JvmName("virtualKeyboardTypeProperty")
    set(`value`) {
      setVirtualKeyboardType(value)
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
   * The caret's column position inside the [LineEdit]. When set, the text may scroll to accommodate
   * it.
   */
  public final inline var caretColumn: Int
    @JvmName("caretColumnProperty")
    get() = getCaretColumn()
    @JvmName("caretColumnProperty")
    set(`value`) {
      setCaretColumn(value)
    }

  /**
   * If `true`, the [LineEdit] will always show the caret, even if not editing or focus is lost.
   */
  public final inline var caretForceDisplayed: Boolean
    @JvmName("caretForceDisplayedProperty")
    get() = isCaretForceDisplayed()
    @JvmName("caretForceDisplayedProperty")
    set(`value`) {
      setCaretForceDisplayed(value)
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
   * If `true`, every character is replaced with the secret character (see [secretCharacter]).
   */
  public final inline var secret: Boolean
    @JvmName("secretProperty")
    get() = isSecret()
    @JvmName("secretProperty")
    set(`value`) {
      setSecret(value)
    }

  /**
   * The character to use to mask secret input. Only a single character can be used as the secret
   * character. If it is longer than one character, only the first one will be used. If it is empty, a
   * space will be used instead.
   */
  public final inline var secretCharacter: String
    @JvmName("secretCharacterProperty")
    get() = getSecretCharacter()
    @JvmName("secretCharacterProperty")
    set(`value`) {
      setSecretCharacter(value)
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

  /**
   * Sets the icon that will appear in the right end of the [LineEdit] if there's no [text], or
   * always, if [clearButtonEnabled] is set to `false`.
   */
  public final inline var rightIcon: Texture2D?
    @JvmName("rightIconProperty")
    get() = getRightIcon()
    @JvmName("rightIconProperty")
    set(`value`) {
      setRightIcon(value)
    }

  /**
   * Define the scaling behavior of the [rightIcon].
   */
  public final inline var iconExpandMode: ExpandMode
    @JvmName("iconExpandModeProperty")
    get() = getIconExpandMode()
    @JvmName("iconExpandModeProperty")
    set(`value`) {
      setIconExpandMode(value)
    }

  /**
   * Scale ratio of the icon when [iconExpandMode] is set to [EXPAND_MODE_FIT_TO_LINE_EDIT].
   */
  public final inline var rightIconScale: Float
    @JvmName("rightIconScaleProperty")
    get() = getRightIconScale()
    @JvmName("rightIconScaleProperty")
    set(`value`) {
      setRightIconScale(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(361, scriptPtr)
  }

  /**
   * Returns `true` if the user has text in the
   * [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url] (IME).
   */
  public final fun hasImeText(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasImeTextPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Closes the [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url] (IME) if
   * it is open. Any text in the IME will be lost.
   */
  public final fun cancelIme(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.cancelImePtr, 0)
  }

  /**
   * Applies text from the [url=https://en.wikipedia.org/wiki/Input_method]Input Method Editor[/url]
   * (IME) and closes the IME if it is open.
   */
  public final fun applyIme(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.applyImePtr, 0)
  }

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callPtrMethod(MethodBindings.setHorizontalAlignmentPtr, 0)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHorizontalAlignmentPtr, 2)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Allows entering edit mode whether the [LineEdit] is focused or not. If [hideFocus] is `true`,
   * the focused state will not be shown (see [Control.grabFocus]).
   *
   * See also [keepEditingOnTextSubmit].
   */
  @JvmOverloads
  public final fun edit(hideFocus: Boolean = false): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, hideFocus)
    TransferContext.callPtrMethod(MethodBindings.editPtr, 0)
  }

  /**
   * Allows exiting edit mode while preserving focus.
   */
  public final fun unedit(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.uneditPtr, 0)
  }

  /**
   * Returns whether the [LineEdit] is being edited.
   */
  public final fun isEditing(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEditingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setKeepEditingOnTextSubmit(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setKeepEditingOnTextSubmitPtr, 0)
  }

  public final fun isEditingKeptOnTextSubmit(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEditingKeptOnTextSubmitPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Erases the [LineEdit]'s [text].
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearPtr, 0)
  }

  /**
   * Selects characters inside [LineEdit] between [from] and [to]. By default, [from] is at the
   * beginning and [to] at the end.
   *
   * ```gdscript
   * //gdscript
   * text = "Welcome"
   * select() # Will select "Welcome".
   * select(4) # Will select "ome".
   * select(2, 5) # Will select "lco".
   * ```
   *
   * ```csharp
   * //csharp
   * Text = "Welcome";
   * Select(); // Will select "Welcome".
   * Select(4); // Will select "ome".
   * Select(2, 5); // Will select "lco".
   * ```
   */
  @JvmOverloads
  public final fun select(from: Int = 0, to: Int = -1): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, from.toLong(), to.toLong())
    TransferContext.callPtrMethod(MethodBindings.selectPtr, 0)
  }

  /**
   * Selects the whole [String].
   */
  public final fun selectAll(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.selectAllPtr, 0)
  }

  /**
   * Clears the current selection.
   */
  public final fun deselect(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.deselectPtr, 0)
  }

  /**
   * Returns `true` if an "undo" action is available.
   */
  public final fun hasUndo(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasUndoPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if a "redo" action is available.
   */
  public final fun hasRedo(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasRedoPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the user has selected text.
   */
  public final fun hasSelection(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasSelectionPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the text inside the selection.
   */
  public final fun getSelectedText(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the selection begin column.
   */
  public final fun getSelectionFromColumn(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSelectionFromColumnPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the selection end column.
   */
  public final fun getSelectionToColumn(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSelectionToColumnPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setText(text: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, text)
    TransferContext.callMethod(MethodBindings.setTextPtr)
  }

  public final fun getText(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun getDrawControlChars(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDrawControlCharsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDrawControlChars(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setDrawControlCharsPtr, 0)
  }

  public final fun setTextDirection(direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, direction.value)
    TransferContext.callPtrMethod(MethodBindings.setTextDirectionPtr, 0)
  }

  public final fun getTextDirection(): Control.TextDirection {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextDirectionPtr, 2)
    return Control.TextDirection.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setLanguage(language: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, language)
    TransferContext.callMethod(MethodBindings.setLanguagePtr)
  }

  public final fun getLanguage(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguagePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setStructuredTextBidiOverride(parser: TextServer.StructuredTextParser): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, parser.value)
    TransferContext.callPtrMethod(MethodBindings.setStructuredTextBidiOverridePtr, 0)
  }

  public final fun getStructuredTextBidiOverride(): TextServer.StructuredTextParser {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStructuredTextBidiOverridePtr, 2)
    return TextServer.StructuredTextParser.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setStructuredTextBidiOverrideOptions(args: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, args)
    TransferContext.callPtrMethod(MethodBindings.setStructuredTextBidiOverrideOptionsPtr, 0)
  }

  public final fun getStructuredTextBidiOverrideOptions(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStructuredTextBidiOverrideOptionsPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  public final fun setPlaceholder(text: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, text)
    TransferContext.callMethod(MethodBindings.setPlaceholderPtr)
  }

  public final fun getPlaceholder(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaceholderPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setCaretColumn(position: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, position.toLong())
    TransferContext.callPtrMethod(MethodBindings.setCaretColumnPtr, 0)
  }

  public final fun getCaretColumn(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCaretColumnPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the correct column at the end of a composite character like ❤️‍🩹 (mending heart;
   * Unicode: `U+2764 U+FE0F U+200D U+1FA79`) which is comprised of more than one Unicode code point,
   * if the caret is at the start of the composite character. Also returns the correct column with the
   * caret at mid grapheme and for non-composite characters.
   *
   * **Note:** To check at caret location use
   * `get_next_composite_character_column(get_caret_column())`
   */
  public final fun getNextCompositeCharacterColumn(column: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callPtrMethod(MethodBindings.getNextCompositeCharacterColumnPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the correct column at the start of a composite character like ❤️‍🩹 (mending heart;
   * Unicode: `U+2764 U+FE0F U+200D U+1FA79`) which is comprised of more than one Unicode code point,
   * if the caret is at the end of the composite character. Also returns the correct column with the
   * caret at mid grapheme and for non-composite characters.
   *
   * **Note:** To check at caret location use
   * `get_previous_composite_character_column(get_caret_column())`
   */
  public final fun getPreviousCompositeCharacterColumn(column: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPreviousCompositeCharacterColumnPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the scroll offset due to [caretColumn], as a number of characters.
   */
  public final fun getScrollOffset(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getScrollOffsetPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setExpandToTextLengthEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setExpandToTextLengthEnabledPtr, 0)
  }

  public final fun isExpandToTextLengthEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isExpandToTextLengthEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCaretBlinkEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setCaretBlinkEnabledPtr, 0)
  }

  public final fun isCaretBlinkEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCaretBlinkEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCaretMidGraphemeEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setCaretMidGraphemeEnabledPtr, 0)
  }

  public final fun isCaretMidGraphemeEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCaretMidGraphemeEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCaretForceDisplayed(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setCaretForceDisplayedPtr, 0)
  }

  public final fun isCaretForceDisplayed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isCaretForceDisplayedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setCaretBlinkInterval(interval: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, interval.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCaretBlinkIntervalPtr, 0)
  }

  public final fun getCaretBlinkInterval(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCaretBlinkIntervalPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMaxLength(chars: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, chars.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMaxLengthPtr, 0)
  }

  public final fun getMaxLength(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxLengthPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Inserts [text] at the caret. If the resulting value is longer than [maxLength], nothing
   * happens.
   */
  public final fun insertTextAtCaret(text: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, text)
    TransferContext.callMethod(MethodBindings.insertTextAtCaretPtr)
  }

  /**
   * Deletes one character at the caret's current position (equivalent to pressing
   * [kbd]Delete[/kbd]).
   */
  public final fun deleteCharAtCaret(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.deleteCharAtCaretPtr, 0)
  }

  /**
   * Deletes a section of the [text] going from position [fromColumn] to [toColumn]. Both parameters
   * should be within the text's length.
   */
  public final fun deleteText(fromColumn: Int, toColumn: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, fromColumn.toLong(), toColumn.toLong())
    TransferContext.callPtrMethod(MethodBindings.deleteTextPtr, 0)
  }

  public final fun setEditable(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setEditablePtr, 0)
  }

  public final fun isEditable(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEditablePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSecret(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setSecretPtr, 0)
  }

  public final fun isSecret(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isSecretPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSecretCharacter(character: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, character)
    TransferContext.callMethod(MethodBindings.setSecretCharacterPtr)
  }

  public final fun getSecretCharacter(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSecretCharacterPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Executes a given action as defined in the [MenuItems] enum.
   */
  public final fun menuOption(option: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, option.toLong())
    TransferContext.callPtrMethod(MethodBindings.menuOptionPtr, 0)
  }

  /**
   * Returns the [PopupMenu] of this [LineEdit]. By default, this menu is displayed when
   * right-clicking on the [LineEdit].
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
   * 	menu.ItemCount = menu.GetItemIndex(LineEdit.MenuItems.Redo) + 1;
   * 	// Add custom items.
   * 	menu.AddSeparator();
   * 	menu.AddItem("Insert Date", LineEdit.MenuItems.Max + 1);
   * 	// Add event handler.
   * 	menu.IdPressed += OnItemPressed;
   * }
   *
   * public void OnItemPressed(int id)
   * {
   * 	if (id == LineEdit.MenuItems.Max + 1)
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
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMenuPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as PopupMenu?)
  }

  /**
   * Returns whether the menu is visible. Use this instead of `get_menu().visible` to improve
   * performance (so the creation of the menu is avoided).
   */
  public final fun isMenuVisible(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isMenuVisiblePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setContextMenuEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setContextMenuEnabledPtr, 0)
  }

  public final fun isContextMenuEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isContextMenuEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEmojiMenuEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setEmojiMenuEnabledPtr, 0)
  }

  public final fun isEmojiMenuEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEmojiMenuEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setBackspaceDeletesCompositeCharacterEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setBackspaceDeletesCompositeCharacterEnabledPtr, 0)
  }

  public final fun isBackspaceDeletesCompositeCharacterEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isBackspaceDeletesCompositeCharacterEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setVirtualKeyboardEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setVirtualKeyboardEnabledPtr, 0)
  }

  public final fun isVirtualKeyboardEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isVirtualKeyboardEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setVirtualKeyboardShowOnFocus(showOnFocus: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, showOnFocus)
    TransferContext.callPtrMethod(MethodBindings.setVirtualKeyboardShowOnFocusPtr, 0)
  }

  public final fun getVirtualKeyboardShowOnFocus(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVirtualKeyboardShowOnFocusPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setVirtualKeyboardType(type: VirtualKeyboardType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, type.value)
    TransferContext.callPtrMethod(MethodBindings.setVirtualKeyboardTypePtr, 0)
  }

  public final fun getVirtualKeyboardType(): VirtualKeyboardType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVirtualKeyboardTypePtr, 2)
    return VirtualKeyboardType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setClearButtonEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setClearButtonEnabledPtr, 0)
  }

  public final fun isClearButtonEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isClearButtonEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setShortcutKeysEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setShortcutKeysEnabledPtr, 0)
  }

  public final fun isShortcutKeysEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isShortcutKeysEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setMiddleMousePasteEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setMiddleMousePasteEnabledPtr, 0)
  }

  public final fun isMiddleMousePasteEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isMiddleMousePasteEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSelectingEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setSelectingEnabledPtr, 0)
  }

  public final fun isSelectingEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isSelectingEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDeselectOnFocusLossEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setDeselectOnFocusLossEnabledPtr, 0)
  }

  public final fun isDeselectOnFocusLossEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isDeselectOnFocusLossEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDragAndDropSelectionEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setDragAndDropSelectionEnabledPtr, 0)
  }

  public final fun isDragAndDropSelectionEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isDragAndDropSelectionEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setRightIcon(icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, icon)
    TransferContext.callPtrMethod(MethodBindings.setRightIconPtr, 0)
  }

  public final fun getRightIcon(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRightIconPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun setIconExpandMode(mode: ExpandMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setIconExpandModePtr, 0)
  }

  public final fun getIconExpandMode(): ExpandMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIconExpandModePtr, 2)
    return ExpandMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setRightIconScale(scale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, scale.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRightIconScalePtr, 0)
  }

  public final fun getRightIconScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRightIconScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFlat(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setFlatPtr, 0)
  }

  public final fun isFlat(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isFlatPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSelectAllOnFocus(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setSelectAllOnFocusPtr, 0)
  }

  public final fun isSelectAllOnFocus(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isSelectAllOnFocusPtr, 1)
    return TransferContext.readReturnValue_BOOL()
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
     * Pastes the clipboard text over the selected text (or at the caret's position).
     *
     * Non-printable escape characters are automatically stripped from the OS clipboard via
     * [String.stripEscapes].
     */
    PASTE(2),
    /**
     * Erases the whole [LineEdit] text.
     */
    CLEAR(3),
    /**
     * Selects the whole [LineEdit] text.
     */
    SELECT_ALL(4),
    /**
     * Undoes the previous action.
     */
    UNDO(5),
    /**
     * Reverse the last undo action.
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

  public enum class VirtualKeyboardType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Default text virtual keyboard.
     */
    KEYBOARD_TYPE_DEFAULT(0),
    /**
     * Multiline virtual keyboard.
     */
    KEYBOARD_TYPE_MULTILINE(1),
    /**
     * Virtual number keypad, useful for PIN entry.
     */
    KEYBOARD_TYPE_NUMBER(2),
    /**
     * Virtual number keypad, useful for entering fractional numbers.
     */
    KEYBOARD_TYPE_NUMBER_DECIMAL(3),
    /**
     * Virtual phone number keypad.
     */
    KEYBOARD_TYPE_PHONE(4),
    /**
     * Virtual keyboard with additional keys to assist with typing email addresses.
     */
    KEYBOARD_TYPE_EMAIL_ADDRESS(5),
    /**
     * Virtual keyboard for entering a password. On most platforms, this should disable autocomplete
     * and autocapitalization.
     *
     * **Note:** This is not supported on Web. Instead, this behaves identically to
     * [KEYBOARD_TYPE_DEFAULT].
     */
    KEYBOARD_TYPE_PASSWORD(6),
    /**
     * Virtual keyboard with additional keys to assist with typing URLs.
     */
    KEYBOARD_TYPE_URL(7),
    ;

    public companion object {
      public fun from(`value`: Long): VirtualKeyboardType = entries.single { it.`value` == `value` }
    }
  }

  public enum class ExpandMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use the original size for the right icon.
     */
    ORIGINAL_SIZE(0),
    /**
     * Scale the right icon's size to match the size of the text.
     */
    FIT_TO_TEXT(1),
    /**
     * Scale the right icon to fit the LineEdit.
     */
    FIT_TO_LINE_EDIT(2),
    ;

    public companion object {
      public fun from(`value`: Long): ExpandMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val hasImeTextName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("has_ime_text")

    @JvmField
    public val cancelImeName: MethodStringName0<LineEdit, Unit> =
        MethodStringName0<LineEdit, Unit>("cancel_ime")

    @JvmField
    public val applyImeName: MethodStringName0<LineEdit, Unit> =
        MethodStringName0<LineEdit, Unit>("apply_ime")

    @JvmField
    public val setHorizontalAlignmentName: MethodStringName1<LineEdit, Unit, HorizontalAlignment> =
        MethodStringName1<LineEdit, Unit, HorizontalAlignment>("set_horizontal_alignment")

    @JvmField
    public val getHorizontalAlignmentName: MethodStringName0<LineEdit, HorizontalAlignment> =
        MethodStringName0<LineEdit, HorizontalAlignment>("get_horizontal_alignment")

    @JvmField
    public val editName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("edit")

    @JvmField
    public val uneditName: MethodStringName0<LineEdit, Unit> =
        MethodStringName0<LineEdit, Unit>("unedit")

    @JvmField
    public val isEditingName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_editing")

    @JvmField
    public val setKeepEditingOnTextSubmitName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_keep_editing_on_text_submit")

    @JvmField
    public val isEditingKeptOnTextSubmitName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_editing_kept_on_text_submit")

    @JvmField
    public val clearName: MethodStringName0<LineEdit, Unit> =
        MethodStringName0<LineEdit, Unit>("clear")

    @JvmField
    public val selectName: MethodStringName2<LineEdit, Unit, Int, Int> =
        MethodStringName2<LineEdit, Unit, Int, Int>("select")

    @JvmField
    public val selectAllName: MethodStringName0<LineEdit, Unit> =
        MethodStringName0<LineEdit, Unit>("select_all")

    @JvmField
    public val deselectName: MethodStringName0<LineEdit, Unit> =
        MethodStringName0<LineEdit, Unit>("deselect")

    @JvmField
    public val hasUndoName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("has_undo")

    @JvmField
    public val hasRedoName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("has_redo")

    @JvmField
    public val hasSelectionName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("has_selection")

    @JvmField
    public val getSelectedTextName: MethodStringName0<LineEdit, String> =
        MethodStringName0<LineEdit, String>("get_selected_text")

    @JvmField
    public val getSelectionFromColumnName: MethodStringName0<LineEdit, Int> =
        MethodStringName0<LineEdit, Int>("get_selection_from_column")

    @JvmField
    public val getSelectionToColumnName: MethodStringName0<LineEdit, Int> =
        MethodStringName0<LineEdit, Int>("get_selection_to_column")

    @JvmField
    public val setTextName: MethodStringName1<LineEdit, Unit, String> =
        MethodStringName1<LineEdit, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<LineEdit, String> =
        MethodStringName0<LineEdit, String>("get_text")

    @JvmField
    public val getDrawControlCharsName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("get_draw_control_chars")

    @JvmField
    public val setDrawControlCharsName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_draw_control_chars")

    @JvmField
    public val setTextDirectionName: MethodStringName1<LineEdit, Unit, Control.TextDirection> =
        MethodStringName1<LineEdit, Unit, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<LineEdit, Control.TextDirection> =
        MethodStringName0<LineEdit, Control.TextDirection>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<LineEdit, Unit, String> =
        MethodStringName1<LineEdit, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<LineEdit, String> =
        MethodStringName0<LineEdit, String>("get_language")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName1<LineEdit, Unit, TextServer.StructuredTextParser> =
        MethodStringName1<LineEdit, Unit, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName0<LineEdit, TextServer.StructuredTextParser> =
        MethodStringName0<LineEdit, TextServer.StructuredTextParser>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName1<LineEdit, Unit, VariantArray<Any?>> =
        MethodStringName1<LineEdit, Unit, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName0<LineEdit, VariantArray<Any?>> =
        MethodStringName0<LineEdit, VariantArray<Any?>>("get_structured_text_bidi_override_options")

    @JvmField
    public val setPlaceholderName: MethodStringName1<LineEdit, Unit, String> =
        MethodStringName1<LineEdit, Unit, String>("set_placeholder")

    @JvmField
    public val getPlaceholderName: MethodStringName0<LineEdit, String> =
        MethodStringName0<LineEdit, String>("get_placeholder")

    @JvmField
    public val setCaretColumnName: MethodStringName1<LineEdit, Unit, Int> =
        MethodStringName1<LineEdit, Unit, Int>("set_caret_column")

    @JvmField
    public val getCaretColumnName: MethodStringName0<LineEdit, Int> =
        MethodStringName0<LineEdit, Int>("get_caret_column")

    @JvmField
    public val getNextCompositeCharacterColumnName: MethodStringName1<LineEdit, Int, Int> =
        MethodStringName1<LineEdit, Int, Int>("get_next_composite_character_column")

    @JvmField
    public val getPreviousCompositeCharacterColumnName: MethodStringName1<LineEdit, Int, Int> =
        MethodStringName1<LineEdit, Int, Int>("get_previous_composite_character_column")

    @JvmField
    public val getScrollOffsetName: MethodStringName0<LineEdit, Float> =
        MethodStringName0<LineEdit, Float>("get_scroll_offset")

    @JvmField
    public val setExpandToTextLengthEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_expand_to_text_length_enabled")

    @JvmField
    public val isExpandToTextLengthEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_expand_to_text_length_enabled")

    @JvmField
    public val setCaretBlinkEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_caret_blink_enabled")

    @JvmField
    public val isCaretBlinkEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_caret_blink_enabled")

    @JvmField
    public val setCaretMidGraphemeEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_caret_mid_grapheme_enabled")

    @JvmField
    public val isCaretMidGraphemeEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_caret_mid_grapheme_enabled")

    @JvmField
    public val setCaretForceDisplayedName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_caret_force_displayed")

    @JvmField
    public val isCaretForceDisplayedName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_caret_force_displayed")

    @JvmField
    public val setCaretBlinkIntervalName: MethodStringName1<LineEdit, Unit, Float> =
        MethodStringName1<LineEdit, Unit, Float>("set_caret_blink_interval")

    @JvmField
    public val getCaretBlinkIntervalName: MethodStringName0<LineEdit, Float> =
        MethodStringName0<LineEdit, Float>("get_caret_blink_interval")

    @JvmField
    public val setMaxLengthName: MethodStringName1<LineEdit, Unit, Int> =
        MethodStringName1<LineEdit, Unit, Int>("set_max_length")

    @JvmField
    public val getMaxLengthName: MethodStringName0<LineEdit, Int> =
        MethodStringName0<LineEdit, Int>("get_max_length")

    @JvmField
    public val insertTextAtCaretName: MethodStringName1<LineEdit, Unit, String> =
        MethodStringName1<LineEdit, Unit, String>("insert_text_at_caret")

    @JvmField
    public val deleteCharAtCaretName: MethodStringName0<LineEdit, Unit> =
        MethodStringName0<LineEdit, Unit>("delete_char_at_caret")

    @JvmField
    public val deleteTextName: MethodStringName2<LineEdit, Unit, Int, Int> =
        MethodStringName2<LineEdit, Unit, Int, Int>("delete_text")

    @JvmField
    public val setEditableName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_editable")

    @JvmField
    public val isEditableName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_editable")

    @JvmField
    public val setSecretName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_secret")

    @JvmField
    public val isSecretName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_secret")

    @JvmField
    public val setSecretCharacterName: MethodStringName1<LineEdit, Unit, String> =
        MethodStringName1<LineEdit, Unit, String>("set_secret_character")

    @JvmField
    public val getSecretCharacterName: MethodStringName0<LineEdit, String> =
        MethodStringName0<LineEdit, String>("get_secret_character")

    @JvmField
    public val menuOptionName: MethodStringName1<LineEdit, Unit, Int> =
        MethodStringName1<LineEdit, Unit, Int>("menu_option")

    @JvmField
    public val getMenuName: MethodStringName0<LineEdit, PopupMenu?> =
        MethodStringName0<LineEdit, PopupMenu?>("get_menu")

    @JvmField
    public val isMenuVisibleName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_menu_visible")

    @JvmField
    public val setContextMenuEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_context_menu_enabled")

    @JvmField
    public val isContextMenuEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_context_menu_enabled")

    @JvmField
    public val setEmojiMenuEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_emoji_menu_enabled")

    @JvmField
    public val isEmojiMenuEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_emoji_menu_enabled")

    @JvmField
    public val setBackspaceDeletesCompositeCharacterEnabledName:
        MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_backspace_deletes_composite_character_enabled")

    @JvmField
    public val isBackspaceDeletesCompositeCharacterEnabledName: MethodStringName0<LineEdit, Boolean>
        = MethodStringName0<LineEdit, Boolean>("is_backspace_deletes_composite_character_enabled")

    @JvmField
    public val setVirtualKeyboardEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_virtual_keyboard_enabled")

    @JvmField
    public val isVirtualKeyboardEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_virtual_keyboard_enabled")

    @JvmField
    public val setVirtualKeyboardShowOnFocusName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_virtual_keyboard_show_on_focus")

    @JvmField
    public val getVirtualKeyboardShowOnFocusName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("get_virtual_keyboard_show_on_focus")

    @JvmField
    public val setVirtualKeyboardTypeName: MethodStringName1<LineEdit, Unit, VirtualKeyboardType> =
        MethodStringName1<LineEdit, Unit, VirtualKeyboardType>("set_virtual_keyboard_type")

    @JvmField
    public val getVirtualKeyboardTypeName: MethodStringName0<LineEdit, VirtualKeyboardType> =
        MethodStringName0<LineEdit, VirtualKeyboardType>("get_virtual_keyboard_type")

    @JvmField
    public val setClearButtonEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_clear_button_enabled")

    @JvmField
    public val isClearButtonEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_clear_button_enabled")

    @JvmField
    public val setShortcutKeysEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_shortcut_keys_enabled")

    @JvmField
    public val isShortcutKeysEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_shortcut_keys_enabled")

    @JvmField
    public val setMiddleMousePasteEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_middle_mouse_paste_enabled")

    @JvmField
    public val isMiddleMousePasteEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_middle_mouse_paste_enabled")

    @JvmField
    public val setSelectingEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_selecting_enabled")

    @JvmField
    public val isSelectingEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_selecting_enabled")

    @JvmField
    public val setDeselectOnFocusLossEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_deselect_on_focus_loss_enabled")

    @JvmField
    public val isDeselectOnFocusLossEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_deselect_on_focus_loss_enabled")

    @JvmField
    public val setDragAndDropSelectionEnabledName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_drag_and_drop_selection_enabled")

    @JvmField
    public val isDragAndDropSelectionEnabledName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_drag_and_drop_selection_enabled")

    @JvmField
    public val setRightIconName: MethodStringName1<LineEdit, Unit, Texture2D?> =
        MethodStringName1<LineEdit, Unit, Texture2D?>("set_right_icon")

    @JvmField
    public val getRightIconName: MethodStringName0<LineEdit, Texture2D?> =
        MethodStringName0<LineEdit, Texture2D?>("get_right_icon")

    @JvmField
    public val setIconExpandModeName: MethodStringName1<LineEdit, Unit, ExpandMode> =
        MethodStringName1<LineEdit, Unit, ExpandMode>("set_icon_expand_mode")

    @JvmField
    public val getIconExpandModeName: MethodStringName0<LineEdit, ExpandMode> =
        MethodStringName0<LineEdit, ExpandMode>("get_icon_expand_mode")

    @JvmField
    public val setRightIconScaleName: MethodStringName1<LineEdit, Unit, Float> =
        MethodStringName1<LineEdit, Unit, Float>("set_right_icon_scale")

    @JvmField
    public val getRightIconScaleName: MethodStringName0<LineEdit, Float> =
        MethodStringName0<LineEdit, Float>("get_right_icon_scale")

    @JvmField
    public val setFlatName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_flat")

    @JvmField
    public val isFlatName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_flat")

    @JvmField
    public val setSelectAllOnFocusName: MethodStringName1<LineEdit, Unit, Boolean> =
        MethodStringName1<LineEdit, Unit, Boolean>("set_select_all_on_focus")

    @JvmField
    public val isSelectAllOnFocusName: MethodStringName0<LineEdit, Boolean> =
        MethodStringName0<LineEdit, Boolean>("is_select_all_on_focus")
  }

  public object MethodBindings {
    internal val hasImeTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "has_ime_text", 36873697)

    internal val cancelImePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "cancel_ime", 3218959716)

    internal val applyImePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "apply_ime", 3218959716)

    internal val setHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_horizontal_alignment", 2312603777)

    internal val getHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_horizontal_alignment", 341400642)

    internal val editPtr: VoidPtr = TypeManager.getMethodBindPtr("LineEdit", "edit", 107499316)

    internal val uneditPtr: VoidPtr = TypeManager.getMethodBindPtr("LineEdit", "unedit", 3218959716)

    internal val isEditingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_editing", 36873697)

    internal val setKeepEditingOnTextSubmitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_keep_editing_on_text_submit", 2586408642)

    internal val isEditingKeptOnTextSubmitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_editing_kept_on_text_submit", 36873697)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("LineEdit", "clear", 3218959716)

    internal val selectPtr: VoidPtr = TypeManager.getMethodBindPtr("LineEdit", "select", 1328111411)

    internal val selectAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "select_all", 3218959716)

    internal val deselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "deselect", 3218959716)

    internal val hasUndoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "has_undo", 36873697)

    internal val hasRedoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "has_redo", 36873697)

    internal val hasSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "has_selection", 36873697)

    internal val getSelectedTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_selected_text", 2841200299)

    internal val getSelectionFromColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_selection_from_column", 3905245786)

    internal val getSelectionToColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_selection_to_column", 3905245786)

    internal val setTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_text", 83702148)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_text", 201670096)

    internal val getDrawControlCharsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_draw_control_chars", 36873697)

    internal val setDrawControlCharsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_draw_control_chars", 2586408642)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_text_direction", 119160795)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_text_direction", 797257663)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_language", 201670096)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_structured_text_bidi_override", 55961453)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_structured_text_bidi_override", 3385126229)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_structured_text_bidi_override_options", 381264803)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_structured_text_bidi_override_options", 3995934104)

    internal val setPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_placeholder", 83702148)

    internal val getPlaceholderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_placeholder", 201670096)

    internal val setCaretColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_caret_column", 1286410249)

    internal val getCaretColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_caret_column", 3905245786)

    internal val getNextCompositeCharacterColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_next_composite_character_column", 923996154)

    internal val getPreviousCompositeCharacterColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_previous_composite_character_column", 923996154)

    internal val getScrollOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_scroll_offset", 1740695150)

    internal val setExpandToTextLengthEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_expand_to_text_length_enabled", 2586408642)

    internal val isExpandToTextLengthEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_expand_to_text_length_enabled", 36873697)

    internal val setCaretBlinkEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_caret_blink_enabled", 2586408642)

    internal val isCaretBlinkEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_caret_blink_enabled", 36873697)

    internal val setCaretMidGraphemeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_caret_mid_grapheme_enabled", 2586408642)

    internal val isCaretMidGraphemeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_caret_mid_grapheme_enabled", 36873697)

    internal val setCaretForceDisplayedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_caret_force_displayed", 2586408642)

    internal val isCaretForceDisplayedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_caret_force_displayed", 36873697)

    internal val setCaretBlinkIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_caret_blink_interval", 373806689)

    internal val getCaretBlinkIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_caret_blink_interval", 1740695150)

    internal val setMaxLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_max_length", 1286410249)

    internal val getMaxLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_max_length", 3905245786)

    internal val insertTextAtCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "insert_text_at_caret", 83702148)

    internal val deleteCharAtCaretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "delete_char_at_caret", 3218959716)

    internal val deleteTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "delete_text", 3937882851)

    internal val setEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_editable", 2586408642)

    internal val isEditablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_editable", 36873697)

    internal val setSecretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_secret", 2586408642)

    internal val isSecretPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_secret", 36873697)

    internal val setSecretCharacterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_secret_character", 83702148)

    internal val getSecretCharacterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_secret_character", 201670096)

    internal val menuOptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "menu_option", 1286410249)

    internal val getMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_menu", 229722558)

    internal val isMenuVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_menu_visible", 36873697)

    internal val setContextMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_context_menu_enabled", 2586408642)

    internal val isContextMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_context_menu_enabled", 2240911060)

    internal val setEmojiMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_emoji_menu_enabled", 2586408642)

    internal val isEmojiMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_emoji_menu_enabled", 36873697)

    internal val setBackspaceDeletesCompositeCharacterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_backspace_deletes_composite_character_enabled", 2586408642)

    internal val isBackspaceDeletesCompositeCharacterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_backspace_deletes_composite_character_enabled", 36873697)

    internal val setVirtualKeyboardEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_virtual_keyboard_enabled", 2586408642)

    internal val isVirtualKeyboardEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_virtual_keyboard_enabled", 36873697)

    internal val setVirtualKeyboardShowOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_virtual_keyboard_show_on_focus", 2586408642)

    internal val getVirtualKeyboardShowOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_virtual_keyboard_show_on_focus", 36873697)

    internal val setVirtualKeyboardTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_virtual_keyboard_type", 2696893573)

    internal val getVirtualKeyboardTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_virtual_keyboard_type", 1928699316)

    internal val setClearButtonEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_clear_button_enabled", 2586408642)

    internal val isClearButtonEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_clear_button_enabled", 36873697)

    internal val setShortcutKeysEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_shortcut_keys_enabled", 2586408642)

    internal val isShortcutKeysEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_shortcut_keys_enabled", 36873697)

    internal val setMiddleMousePasteEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_middle_mouse_paste_enabled", 2586408642)

    internal val isMiddleMousePasteEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_middle_mouse_paste_enabled", 36873697)

    internal val setSelectingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_selecting_enabled", 2586408642)

    internal val isSelectingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_selecting_enabled", 36873697)

    internal val setDeselectOnFocusLossEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_deselect_on_focus_loss_enabled", 2586408642)

    internal val isDeselectOnFocusLossEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_deselect_on_focus_loss_enabled", 36873697)

    internal val setDragAndDropSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_drag_and_drop_selection_enabled", 2586408642)

    internal val isDragAndDropSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_drag_and_drop_selection_enabled", 36873697)

    internal val setRightIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_right_icon", 4051416890)

    internal val getRightIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_right_icon", 255860311)

    internal val setIconExpandModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_icon_expand_mode", 3019903192)

    internal val getIconExpandModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_icon_expand_mode", 3273584435)

    internal val setRightIconScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_right_icon_scale", 373806689)

    internal val getRightIconScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "get_right_icon_scale", 1740695150)

    internal val setFlatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_flat", 2586408642)

    internal val isFlatPtr: VoidPtr = TypeManager.getMethodBindPtr("LineEdit", "is_flat", 36873697)

    internal val setSelectAllOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "set_select_all_on_focus", 2586408642)

    internal val isSelectAllOnFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LineEdit", "is_select_all_on_focus", 36873697)
  }
}
