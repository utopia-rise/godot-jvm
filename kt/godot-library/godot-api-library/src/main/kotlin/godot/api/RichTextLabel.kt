// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_ANY
import godot.callMethod_ANY_LONG_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_BOOL_STRING_LONG_LONG
import godot.callMethod_ANY_LONG_STRING
import godot.callMethod_LONG_LONG_BOOL_STRING
import godot.callMethod_LONG_LONG_LONG_STRING
import godot.callMethod_LONG_LONG_STRING_LONG_LONG_PACKED_FLOAT_32_ARRAY
import godot.callMethod_LONG_STRING
import godot.callMethod_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_ANY_BOOL_STRING_LONG_LONG_STRING
import godot.callMethod_STRING
import godot.callMethod_STRING_OBJECT_LONG_RECT2_COLOR_LONG_COLOR
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT
import godot.callPtrMethod0_ret_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod0_ret_RECT2I
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_COLOR
import godot.callPtrMethod_COLOR_COLOR
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_BOOL_LONG_BOOL
import godot.callPtrMethod_LONG_BOOL_ret_BOOL
import godot.callPtrMethod_LONG_LONG_COLOR_LONG_BOOL_BOOL
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_VECTOR2I
import godot.callPtrMethod_OBJECT_DICTIONARY
import godot.callPtrMethod_OBJECT_LONG
import godot.callPtrMethod_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod_PACKED_STRING_ARRAY_ret_DICTIONARY
import godot.callPtrMethod_RECT2
import godot.callPtrMethod_VECTOR2_VECTOR2
import godot.common.interop.VoidPtr
import godot.core.BitFieldBase
import godot.core.Color
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.InlineAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName12
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName6
import godot.core.MethodStringName7
import godot.core.PackedFloat32Array
import godot.core.PackedStringArray
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.Signal0
import godot.core.Signal1
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.VerticalAlignment
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

public infix fun Long.or(other: RichTextLabel.ImageUpdateMask): Long = this.or(other.flag)

public infix fun Long.xor(other: RichTextLabel.ImageUpdateMask): Long = this.xor(other.flag)

public infix fun Long.and(other: RichTextLabel.ImageUpdateMask): Long = this.and(other.flag)

/**
 * A control for displaying text that can contain custom fonts, images, and basic formatting.
 * [RichTextLabel] manages these as an internal tag stack. It also adapts itself to given
 * width/heights.
 *
 * **Note:** [newline], [pushParagraph], `"\n"`, `"\r\n"`, `p` tag, and alignment tags start a new
 * paragraph. Each paragraph is processed independently, in its own BiDi context. If you want to force
 * line wrapping within paragraph, any other line breaking character can be used, for example, Form
 * Feed (U+000C), Next Line (U+0085), Line Separator (U+2028).
 *
 * **Note:** Assignments to [text] clear the tag stack and reconstruct it from the property's
 * contents. Any edits made to [text] will erase previous edits made from other manual sources such as
 * [appendText] and the `push_*` / [pop] methods.
 *
 * **Note:** RichTextLabel doesn't support entangled BBCode tags. For example, instead of using
 * [code skip-lint]**bold*bold italic**italic*[/code], use [code skip-lint]**bold*bold
 * italic****italic*[/code].
 *
 * **Note:** `push_*&#92;pop_*` functions won't affect BBCode.
 *
 * **Note:** While [bbcodeEnabled] is enabled, alignment tags such as [code
 * skip-lint][center][/code] will take priority over the [horizontalAlignment] setting which determines
 * the default text alignment.
 */
@GodotBaseType
public open class RichTextLabel : Control() {
  /**
   * Triggered when the user clicks on content between meta (URL) tags. If the meta is defined in
   * BBCode, e.g. [code skip-lint][url={"key": "value"}]Text[/url][/code], then the parameter for this
   * signal will always be a [String] type. If a particular type or an object is desired, the
   * [pushMeta] method must be used to manually insert the data into the tag stack. Alternatively, you
   * can convert the [String] input to the desired type based on its contents (such as calling
   * [JSON.parse] on it).
   *
   * For example, the following method can be connected to [signal meta_clicked] to open clicked
   * URLs using the user's default web browser:
   *
   * ```gdscript
   * //gdscript
   * # This assumes RichTextLabel's `meta_clicked` signal was connected to
   * # the function below using the signal connection dialog.
   * func _richtextlabel_on_meta_clicked(meta):
   * 	# `meta` is of Variant type, so convert it to a String to avoid script errors at run-time.
   * 	OS.shell_open(str(meta))
   * ```
   */
  public val metaClicked: Signal1<Any> by Signal1

  /**
   * Triggers when the mouse enters a meta tag.
   */
  public val metaHoverStarted: Signal1<Any> by Signal1

  /**
   * Triggers when the mouse exits a meta tag.
   */
  public val metaHoverEnded: Signal1<Any> by Signal1

  /**
   * Triggered when the document is fully loaded.
   *
   * **Note:** This can happen before the text is processed for drawing. Scrolling values may not be
   * valid until the document is drawn for the first time after this signal.
   */
  public val finished: Signal0 by Signal0

  /**
   * If `true`, the label uses BBCode formatting.
   *
   * **Note:** This only affects the contents of [text], not the tag stack.
   */
  public final inline var bbcodeEnabled: Boolean
    @JvmName("bbcodeEnabledProperty")
    get() = isUsingBbcode()
    @JvmName("bbcodeEnabledProperty")
    set(`value`) {
      setUseBbcode(value)
    }

  /**
   * The label's text in BBCode format. Is not representative of manual modifications to the
   * internal tag stack. Erases changes made by other methods when edited.
   *
   * **Note:** If [bbcodeEnabled] is `true`, it is unadvised to use the `+=` operator with [text]
   * (e.g. `text += "some string"`) as it replaces the whole text and can cause slowdowns. It will also
   * erase all BBCode that was added to stack using `push_*` methods. Use [appendText] for adding text
   * instead, unless you absolutely need to close a tag that was opened in an earlier method call.
   */
  public final inline var text: String
    @JvmName("textProperty")
    get() = getText()
    @JvmName("textProperty")
    set(`value`) {
      setText(value)
    }

  /**
   * If `true`, the label's minimum size will be automatically updated to fit its content, matching
   * the behavior of [Label].
   *
   * **Note:** RichTextLabels with autowrapping and [fitContent] enabled must have a custom maximum
   * width configured to work correctly, either through the RichTextLabel's own
   * [Control.customMaximumSize] or as a result of a propagated maximum size from a parent Control with
   * [Control.propagateMaximumSize] enabled.
   */
  public final inline var fitContent: Boolean
    @JvmName("fitContentProperty")
    get() = isFitContentEnabled()
    @JvmName("fitContentProperty")
    set(`value`) {
      setFitContent(value)
    }

  /**
   * If `true`, the scrollbar is visible. Setting this to `false` does not block scrolling
   * completely. See [scrollToLine].
   */
  public final inline var scrollActive: Boolean
    @JvmName("scrollActiveProperty")
    get() = isScrollActive()
    @JvmName("scrollActiveProperty")
    set(`value`) {
      setScrollActive(value)
    }

  /**
   * If `true`, the window scrolls down to display new content automatically.
   */
  public final inline var scrollFollowing: Boolean
    @JvmName("scrollFollowingProperty")
    get() = isScrollFollowing()
    @JvmName("scrollFollowingProperty")
    set(`value`) {
      setScrollFollow(value)
    }

  /**
   * If `true`, the window scrolls to display the last visible line when [visibleCharacters] or
   * [visibleRatio] is changed.
   */
  public final inline var scrollFollowingVisibleCharacters: Boolean
    @JvmName("scrollFollowingVisibleCharactersProperty")
    get() = isScrollFollowingVisibleCharacters()
    @JvmName("scrollFollowingVisibleCharactersProperty")
    set(`value`) {
      setScrollFollowVisibleCharacters(value)
    }

  /**
   * If set to something other than [TextServer.AUTOWRAP_OFF], the text gets wrapped inside the
   * node's bounding rectangle.
   *
   * **Note:** RichTextLabels with autowrapping and [fitContent] enabled must have a custom maximum
   * width configured to work correctly, either through the RichTextLabel's own
   * [Control.customMaximumSize] or as a result of a propagated maximum size from a parent Control with
   * [Control.propagateMaximumSize] enabled.
   */
  public final inline var autowrapMode: TextServer.AutowrapMode
    @JvmName("autowrapModeProperty")
    get() = getAutowrapMode()
    @JvmName("autowrapModeProperty")
    set(`value`) {
      setAutowrapMode(value)
    }

  /**
   * Autowrap space trimming flags. See [TextServer.BREAK_TRIM_START_EDGE_SPACES] and
   * [TextServer.BREAK_TRIM_END_EDGE_SPACES] for more info.
   */
  public final inline var autowrapTrimFlags: TextServer.LineBreakFlag
    @JvmName("autowrapTrimFlagsProperty")
    get() = getAutowrapTrimFlags()
    @JvmName("autowrapTrimFlagsProperty")
    set(`value`) {
      setAutowrapTrimFlags(value)
    }

  /**
   * The number of spaces associated with a single tab length. Does not affect `\t` in text tags,
   * only indent tags.
   */
  public final inline var tabSize: Int
    @JvmName("tabSizeProperty")
    get() = getTabSize()
    @JvmName("tabSizeProperty")
    set(`value`) {
      setTabSize(value)
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
   * Controls the text's horizontal alignment. Supports left, center, right, and fill (also known as
   * justify).
   */
  public final inline var horizontalAlignment: HorizontalAlignment
    @JvmName("horizontalAlignmentProperty")
    get() = getHorizontalAlignment()
    @JvmName("horizontalAlignmentProperty")
    set(`value`) {
      setHorizontalAlignment(value)
    }

  /**
   * Controls the text's vertical alignment. Supports top, center, bottom, and fill.
   */
  public final inline var verticalAlignment: VerticalAlignment
    @JvmName("verticalAlignmentProperty")
    get() = getVerticalAlignment()
    @JvmName("verticalAlignmentProperty")
    set(`value`) {
      setVerticalAlignment(value)
    }

  /**
   * Line fill alignment rules.
   */
  public final inline var justificationFlags: TextServer.JustificationFlag
    @JvmName("justificationFlagsProperty")
    get() = getJustificationFlags()
    @JvmName("justificationFlagsProperty")
    set(`value`) {
      setJustificationFlags(value)
    }

  /**
   * Aligns text to the given tab-stops.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var tabStops: PackedFloat32Array
    @JvmName("tabStopsProperty")
    get() = getTabStops()
    @JvmName("tabStopsProperty")
    set(`value`) {
      setTabStops(value)
    }

  /**
   * The currently installed custom effects. This is an array of [RichTextEffect]s.
   *
   * To add a custom effect, it's more convenient to use [installEffect].
   */
  public final inline var customEffects: VariantArray<Any?>
    @JvmName("customEffectsProperty")
    get() = getEffects()
    @JvmName("customEffectsProperty")
    set(`value`) {
      setEffects(value)
    }

  /**
   * If `true`, the label underlines meta tags such as [code skip-lint][url]{text}[/url][/code].
   * These tags can call a function when clicked if [signal meta_clicked] is connected to a function.
   */
  public final inline var metaUnderlined: Boolean
    @JvmName("metaUnderlinedProperty")
    get() = isMetaUnderlined()
    @JvmName("metaUnderlinedProperty")
    set(`value`) {
      setMetaUnderline(value)
    }

  /**
   * If `true`, the label underlines hint tags such as [code
   * skip-lint][hint=description]{text}[/hint][/code].
   */
  public final inline var hintUnderlined: Boolean
    @JvmName("hintUnderlinedProperty")
    get() = isHintUnderlined()
    @JvmName("hintUnderlinedProperty")
    set(`value`) {
      setHintUnderline(value)
    }

  /**
   * If `true`, text processing is done in a background thread.
   */
  public final inline var threaded: Boolean
    @JvmName("threadedProperty")
    get() = isThreaded()
    @JvmName("threadedProperty")
    set(`value`) {
      setThreaded(value)
    }

  /**
   * The delay after which the loading progress bar is displayed, in milliseconds. Set to `-1` to
   * disable progress bar entirely.
   *
   * **Note:** Progress bar is displayed only if [threaded] is enabled.
   */
  public final inline var progressBarDelay: Int
    @JvmName("progressBarDelayProperty")
    get() = getProgressBarDelay()
    @JvmName("progressBarDelayProperty")
    set(`value`) {
      setProgressBarDelay(value)
    }

  /**
   * If `true`, the label allows text selection.
   */
  public final inline var selectionEnabled: Boolean
    @JvmName("selectionEnabledProperty")
    get() = isSelectionEnabled()
    @JvmName("selectionEnabledProperty")
    set(`value`) {
      setSelectionEnabled(value)
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
   * The number of characters to display. If set to `-1`, all characters are displayed. This can be
   * useful when animating the text appearing in a dialog box.
   *
   * **Note:** Setting this property updates [visibleRatio] accordingly.
   *
   * **Note:** Characters are counted as Unicode codepoints. A single visible grapheme may contain
   * multiple codepoints (e.g. certain emoji use three codepoints). A single codepoint may contain two
   * UTF-16 characters, which are used in C# strings.
   */
  public final inline var visibleCharacters: Int
    @JvmName("visibleCharactersProperty")
    get() = getVisibleCharacters()
    @JvmName("visibleCharactersProperty")
    set(`value`) {
      setVisibleCharacters(value)
    }

  /**
   * The clipping behavior when [visibleCharacters] or [visibleRatio] is set.
   */
  public final inline var visibleCharactersBehavior: TextServer.VisibleCharactersBehavior
    @JvmName("visibleCharactersBehaviorProperty")
    get() = getVisibleCharactersBehavior()
    @JvmName("visibleCharactersBehaviorProperty")
    set(`value`) {
      setVisibleCharactersBehavior(value)
    }

  /**
   * The fraction of characters to display, relative to the total number of characters (see
   * [getTotalCharacterCount]). If set to `1.0`, all characters are displayed. If set to `0.5`, only
   * half of the characters will be displayed. This can be useful when animating the text appearing in
   * a dialog box.
   *
   * **Note:** Setting this property updates [visibleCharacters] accordingly.
   */
  public final inline var visibleRatio: Float
    @JvmName("visibleRatioProperty")
    get() = getVisibleRatio()
    @JvmName("visibleRatioProperty")
    set(`value`) {
      setVisibleRatio(value)
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
    createNativeObject(632, scriptPtr)
  }

  /**
   * This is a helper function for [tabStops] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = richtextlabel.tabStops
   * //Your changes
   * richtextlabel.tabStops = myCoreType
   * ``````
   *
   * Aligns text to the given tab-stops.
   */
  @CoreTypeHelper
  public final fun tabStopsMutate(block: PackedFloat32Array.() -> Unit): PackedFloat32Array =
      tabStops.apply {
     block(this)
     tabStops = this
  }

  /**
   * This is a helper function for [tabStops] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * Aligns text to the given tab-stops.
   */
  @CoreTypeHelper
  public final fun tabStopsMutateEach(block: (index: Int, `value`: Float) -> Unit):
      PackedFloat32Array = tabStops.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     tabStops = this
  }

  /**
   * Returns the text without BBCode mark-up.
   */
  public final fun getParsedText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getParsedTextPtr)

  /**
   * Adds raw non-BBCode-parsed text to the tag stack.
   */
  public final fun addText(text: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.addTextPtr, text)
  }

  public final fun setText(text: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setTextPtr, text)
  }

  /**
   * Adds a horizontal rule that can be used to separate content.
   *
   * If [widthInPercent] is set, [width] values are percentages of the control width instead of
   * pixels.
   *
   * If [heightInPercent] is set, [height] values are percentages of the control width instead of
   * pixels.
   */
  @JvmOverloads
  public final fun addHr(
    width: Int = 90,
    height: Int = 2,
    color: Color = Color(Color(1, 1, 1, 1)),
    alignment: HorizontalAlignment = HorizontalAlignment.CENTER,
    widthInPercent: Boolean = true,
    heightInPercent: Boolean = false,
  ): Unit {
    TransferContext.callPtrMethod_LONG_LONG_COLOR_LONG_BOOL_BOOL(ptr, objectID.id, MethodBindings.addHrPtr, width.toLong(), height.toLong(), color, alignment.value, widthInPercent, heightInPercent)
  }

  /**
   * Adds an image's opening and closing tags to the tag stack, optionally providing a [width] and
   * [height] to resize the image, a [color] to tint the image and a [region] to only use parts of the
   * image.
   *
   * If [width] or [height] is set to 0, the image size will be adjusted in order to keep the
   * original aspect ratio.
   *
   * If [width] and [height] are not set, but [region] is, the region's rect will be used.
   *
   * [key] is an optional identifier, that can be used to modify the image via [updateImage].
   *
   * If [pad] is set, and the image is smaller than the size specified by [width] and [height], the
   * image padding is added to match the size instead of upscaling.
   *
   * Parameters [widthUnit] and [heightUnit] determine the units used to calculate the image width
   * and height, respectively.
   *
   * [altText] is used as the image description for assistive apps.
   */
  @JvmOverloads
  public final fun addImage(
    image: Texture2D?,
    width: Float = 0.0f,
    height: Float = 0.0f,
    color: Color = Color(Color(1, 1, 1, 1)),
    inlineAlign: InlineAlignment = InlineAlignment.CENTER,
    region: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    key: Any? = null,
    pad: Boolean = false,
    tooltip: String = "",
    widthUnit: ImageUnit = RichTextLabel.ImageUnit.PIXEL,
    heightUnit: ImageUnit = RichTextLabel.ImageUnit.PIXEL,
    altText: String = "",
  ): Unit {
    TransferContext.callMethod_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_ANY_BOOL_STRING_LONG_LONG_STRING(ptr, objectID.id, MethodBindings.addImagePtr, image, width.toDouble(), height.toDouble(), color, inlineAlign.value, region, key, pad, tooltip, widthUnit.value, heightUnit.value, altText)
  }

  /**
   * Updates the existing images with the key [key]. Only properties specified by [mask] bits are
   * updated. See [addImage].
   */
  @JvmOverloads
  public final fun updateImage(
    key: Any?,
    mask: ImageUpdateMask,
    image: Texture2D?,
    width: Float = 0.0f,
    height: Float = 0.0f,
    color: Color = Color(Color(1, 1, 1, 1)),
    inlineAlign: InlineAlignment = InlineAlignment.CENTER,
    region: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    pad: Boolean = false,
    tooltip: String = "",
    widthUnit: ImageUnit = RichTextLabel.ImageUnit.PIXEL,
    heightUnit: ImageUnit = RichTextLabel.ImageUnit.PIXEL,
  ): Unit {
    TransferContext.callMethod_ANY_LONG_OBJECT_DOUBLE_DOUBLE_COLOR_LONG_RECT2_BOOL_STRING_LONG_LONG(ptr, objectID.id, MethodBindings.updateImagePtr, key, mask.flag, image, width.toDouble(), height.toDouble(), color, inlineAlign.value, region, pad, tooltip, widthUnit.value, heightUnit.value)
  }

  /**
   * Adds a newline tag to the tag stack.
   */
  public final fun newline(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.newlinePtr)
  }

  /**
   * Removes a paragraph of content from the label. Returns `true` if the paragraph exists.
   *
   * The [paragraph] argument is the index of the paragraph to remove, it can take values in the
   * interval `[0, get_paragraph_count() - 1]`.
   *
   * If [noInvalidate] is set to `true`, cache for the subsequent paragraphs is not invalidated. Use
   * it for faster updates if deleted paragraph is fully self-contained (have no unclosed tags), or
   * this call is part of the complex edit operation and [invalidateParagraph] will be called at the
   * end of operation.
   */
  @JvmOverloads
  public final fun removeParagraph(paragraph: Int, noInvalidate: Boolean = false): Boolean =
      TransferContext.callPtrMethod_LONG_BOOL_ret_BOOL(ptr, objectID.id, MethodBindings.removeParagraphPtr, paragraph.toLong(), noInvalidate)

  /**
   * Invalidates [paragraph] and all subsequent paragraphs cache.
   */
  public final fun invalidateParagraph(paragraph: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.invalidateParagraphPtr, paragraph.toLong())

  /**
   * Adds a [code skip-lint][font][/code] tag to the tag stack. Overrides default fonts for its
   * duration.
   *
   * Passing `0` to [fontSize] will use the existing default font size.
   */
  @JvmOverloads
  public final fun pushFont(font: Font?, fontSize: Int = 0): Unit {
    TransferContext.callPtrMethod_OBJECT_LONG(ptr, objectID.id, MethodBindings.pushFontPtr, font, fontSize.toLong())
  }

  /**
   * Adds a [code skip-lint][font_size][/code] tag to the tag stack. Overrides default font size for
   * its duration.
   */
  public final fun pushFontSize(fontSize: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.pushFontSizePtr, fontSize.toLong())
  }

  /**
   * Adds a [code skip-lint][font][/code] tag with a normal font to the tag stack.
   */
  public final fun pushNormal(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pushNormalPtr)
  }

  /**
   * Adds a [code skip-lint][font][/code] tag with a bold font to the tag stack. This is the same as
   * adding a [code skip-lint][b][/code] tag if not currently in a [code skip-lint][i][/code] tag.
   */
  public final fun pushBold(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pushBoldPtr)
  }

  /**
   * Adds a [code skip-lint][font][/code] tag with a bold italics font to the tag stack.
   */
  public final fun pushBoldItalics(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pushBoldItalicsPtr)
  }

  /**
   * Adds a [code skip-lint][font][/code] tag with an italics font to the tag stack. This is the
   * same as adding an [code skip-lint][i][/code] tag if not currently in a [code skip-lint][b][/code]
   * tag.
   */
  public final fun pushItalics(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pushItalicsPtr)
  }

  /**
   * Adds a [code skip-lint][font][/code] tag with a monospace font to the tag stack.
   */
  public final fun pushMono(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pushMonoPtr)
  }

  /**
   * Adds a [code skip-lint][color][/code] tag to the tag stack.
   */
  public final fun pushColor(color: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.pushColorPtr, color)
  }

  /**
   * Adds a [code skip-lint][outline_size][/code] tag to the tag stack. Overrides default text
   * outline size for its duration.
   */
  public final fun pushOutlineSize(outlineSize: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.pushOutlineSizePtr, outlineSize.toLong())
  }

  /**
   * Adds a [code skip-lint][outline_color][/code] tag to the tag stack. Adds text outline for its
   * duration.
   */
  public final fun pushOutlineColor(color: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.pushOutlineColorPtr, color)
  }

  /**
   * Adds a [code skip-lint][p][/code] tag to the tag stack.
   */
  @JvmOverloads
  public final fun pushParagraph(
    alignment: HorizontalAlignment,
    baseDirection: Control.TextDirection = Control.TextDirection.AUTO,
    language: String = "",
    stParser: TextServer.StructuredTextParser = TextServer.StructuredTextParser.DEFAULT,
    justificationFlags: TextServer.JustificationFlag = TextServer.JustificationFlag(163),
    tabStops: PackedFloat32Array = PackedFloat32Array(),
  ): Unit {
    TransferContext.callMethod_LONG_LONG_STRING_LONG_LONG_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, MethodBindings.pushParagraphPtr, alignment.value, baseDirection.value, language, stParser.value, justificationFlags.flag, tabStops)
  }

  /**
   * Adds an [code skip-lint][indent][/code] tag to the tag stack. Multiplies [level] by current
   * [tabSize] to determine new margin length.
   */
  public final fun pushIndent(level: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.pushIndentPtr, level.toLong())
  }

  /**
   * Adds [code skip-lint][ol][/code] or [code skip-lint][ul][/code] tag to the tag stack.
   * Multiplies [level] by current [tabSize] to determine new margin length.
   */
  @JvmOverloads
  public final fun pushList(
    level: Int,
    type: ListType,
    capitalize: Boolean,
    bullet: String = "•",
  ): Unit {
    TransferContext.callMethod_LONG_LONG_BOOL_STRING(ptr, objectID.id, MethodBindings.pushListPtr, level.toLong(), type.value, capitalize, bullet)
  }

  /**
   * Adds a meta tag to the tag stack. Similar to the BBCode [code
   * skip-lint][url=something]{text}[/url][/code], but supports non-[String] metadata types.
   *
   * If [metaUnderlined] is `true`, meta tags display an underline. This behavior can be customized
   * with [underlineMode].
   *
   * **Note:** Meta tags do nothing by default when clicked. To assign behavior when clicked,
   * connect [signal meta_clicked] to a function that is called when the meta tag is clicked.
   */
  @JvmOverloads
  public final fun pushMeta(
    `data`: Any?,
    underlineMode: MetaUnderline = RichTextLabel.MetaUnderline.ALWAYS,
    tooltip: String = "",
  ): Unit {
    TransferContext.callMethod_ANY_LONG_STRING(ptr, objectID.id, MethodBindings.pushMetaPtr, data, underlineMode.value, tooltip)
  }

  /**
   * Adds a [code skip-lint][hint][/code] tag to the tag stack. Same as BBCode [code
   * skip-lint][hint=something]{text}[/hint][/code].
   */
  public final fun pushHint(description: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.pushHintPtr, description)
  }

  /**
   * Adds language code used for text shaping algorithm and Open-Type font features.
   */
  public final fun pushLanguage(language: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.pushLanguagePtr, language)
  }

  /**
   * Adds a [code skip-lint][u][/code] tag to the tag stack. If [color]'s alpha value is `0.0`, the
   * current font's color with its alpha multiplied by [theme_item underline_alpha] is used.
   */
  @JvmOverloads
  public final fun pushUnderline(color: Color = Color(Color(0, 0, 0, 0))): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.pushUnderlinePtr, color)
  }

  /**
   * Adds a [code skip-lint][s][/code] tag to the tag stack. If [color]'s alpha value is `0.0`, the
   * current font's color with its alpha multiplied by [theme_item strikethrough_alpha] is used.
   */
  @JvmOverloads
  public final fun pushStrikethrough(color: Color = Color(Color(0, 0, 0, 0))): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.pushStrikethroughPtr, color)
  }

  /**
   * Adds a [code skip-lint][table=columns,inline_align][/code] tag to the tag stack. Use
   * [setTableColumnExpand] to set column expansion ratio. Use [pushCell] to add cells. [name] is used
   * as the table name for assistive apps.
   */
  @JvmOverloads
  public final fun pushTable(
    columns: Int,
    inlineAlign: InlineAlignment = InlineAlignment.TOP_TO,
    alignToRow: Int = -1,
    name: String = "",
  ): Unit {
    TransferContext.callMethod_LONG_LONG_LONG_STRING(ptr, objectID.id, MethodBindings.pushTablePtr, columns.toLong(), inlineAlign.value, alignToRow.toLong(), name)
  }

  /**
   * Adds a [code skip-lint][dropcap][/code] tag to the tag stack. Drop cap (dropped capital) is a
   * decorative element at the beginning of a paragraph that is larger than the rest of the text.
   */
  @JvmOverloads
  public final fun pushDropcap(
    string: String,
    font: Font?,
    size: Int,
    dropcapMargins: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    color: Color = Color(Color(1, 1, 1, 1)),
    outlineSize: Int = 0,
    outlineColor: Color = Color(Color(0, 0, 0, 0)),
  ): Unit {
    TransferContext.callMethod_STRING_OBJECT_LONG_RECT2_COLOR_LONG_COLOR(ptr, objectID.id, MethodBindings.pushDropcapPtr, string, font, size.toLong(), dropcapMargins, color, outlineSize.toLong(), outlineColor)
  }

  /**
   * Edits the selected column's expansion options. If [expand] is `true`, the column expands in
   * proportion to its expansion ratio versus the other columns' ratios.
   *
   * For example, 2 columns with ratios 3 and 4 plus 70 pixels in available width would expand 30
   * and 40 pixels, respectively.
   *
   * If [expand] is `false`, the column will not contribute to the total ratio.
   */
  @JvmOverloads
  public final fun setTableColumnExpand(
    column: Int,
    expand: Boolean,
    ratio: Int = 1,
    shrink: Boolean = true,
  ): Unit {
    TransferContext.callPtrMethod_LONG_BOOL_LONG_BOOL(ptr, objectID.id, MethodBindings.setTableColumnExpandPtr, column.toLong(), expand, ratio.toLong(), shrink)
  }

  /**
   * Sets table column name for assistive apps.
   */
  public final fun setTableColumnName(column: Int, name: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setTableColumnNamePtr, column.toLong(), name)
  }

  /**
   * Sets color of a table cell. Separate colors for alternating rows can be specified.
   */
  public final fun setCellRowBackgroundColor(oddRowBg: Color, evenRowBg: Color): Unit {
    TransferContext.callPtrMethod_COLOR_COLOR(ptr, objectID.id, MethodBindings.setCellRowBackgroundColorPtr, oddRowBg, evenRowBg)
  }

  /**
   * Sets color of a table cell border.
   */
  public final fun setCellBorderColor(color: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.setCellBorderColorPtr, color)
  }

  /**
   * Sets minimum and maximum size overrides for a table cell.
   */
  public final fun setCellSizeOverride(minSize: Vector2, maxSize: Vector2): Unit {
    TransferContext.callPtrMethod_VECTOR2_VECTOR2(ptr, objectID.id, MethodBindings.setCellSizeOverridePtr, minSize, maxSize)
  }

  /**
   * Sets inner padding of a table cell.
   */
  public final fun setCellPadding(padding: Rect2): Unit {
    TransferContext.callPtrMethod_RECT2(ptr, objectID.id, MethodBindings.setCellPaddingPtr, padding)
  }

  /**
   * Adds a [code skip-lint][cell][/code] tag to the tag stack. Must be inside a [code
   * skip-lint][table][/code] tag. See [pushTable] for details. Use [setTableColumnExpand] to set
   * column expansion ratio, [setCellBorderColor] to set cell border, [setCellRowBackgroundColor] to
   * set cell background, [setCellSizeOverride] to override cell size, and [setCellPadding] to set
   * padding.
   */
  public final fun pushCell(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pushCellPtr)
  }

  /**
   * Adds a [code skip-lint][fgcolor][/code] tag to the tag stack.
   *
   * **Note:** The foreground color has padding applied by default, which is controlled using
   * [theme_item text_highlight_h_padding] and [theme_item text_highlight_v_padding]. This can lead to
   * overlapping highlights if foreground colors are placed on neighboring lines/columns, so consider
   * setting those theme items to `0` if you want to avoid this.
   */
  public final fun pushFgcolor(fgcolor: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.pushFgcolorPtr, fgcolor)
  }

  /**
   * Adds a [code skip-lint][bgcolor][/code] tag to the tag stack.
   *
   * **Note:** The background color has padding applied by default, which is controlled using
   * [theme_item text_highlight_h_padding] and [theme_item text_highlight_v_padding]. This can lead to
   * overlapping highlights if background colors are placed on neighboring lines/columns, so consider
   * setting those theme items to `0` if you want to avoid this.
   */
  public final fun pushBgcolor(bgcolor: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.pushBgcolorPtr, bgcolor)
  }

  /**
   * Adds a custom effect tag to the tag stack. The effect does not need to be in [customEffects].
   * The environment is directly passed to the effect.
   */
  public final fun pushCustomfx(effect: RichTextEffect?, env: Dictionary<Any?, Any?>): Unit {
    TransferContext.callPtrMethod_OBJECT_DICTIONARY(ptr, objectID.id, MethodBindings.pushCustomfxPtr, effect, env)
  }

  /**
   * Adds a context marker to the tag stack. See [popContext].
   */
  public final fun pushContext(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pushContextPtr)
  }

  /**
   * Terminates tags opened after the last [pushContext] call (including context marker), or all
   * tags if there's no context marker on the stack.
   */
  public final fun popContext(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.popContextPtr)
  }

  /**
   * Terminates the current tag. Use after `push_*` methods to close BBCodes manually. Does not need
   * to follow `add_*` methods.
   */
  public final fun pop(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.popPtr)
  }

  /**
   * Terminates all tags opened by `push_*` methods.
   */
  public final fun popAll(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.popAllPtr)
  }

  /**
   * Clears the tag stack, causing the label to display nothing.
   *
   * **Note:** This method does not affect [text], and its contents will show again if the label is
   * redrawn. However, setting [text] to an empty [String] also clears the stack.
   */
  public final fun clear(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  public final fun setStructuredTextBidiOverride(parser: TextServer.StructuredTextParser): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverridePtr, parser.value)
  }

  public final fun getStructuredTextBidiOverride(): TextServer.StructuredTextParser =
      TextServer.StructuredTextParser.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverridePtr))

  public final fun setStructuredTextBidiOverrideOptions(args: VariantArray<Any?>): Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setStructuredTextBidiOverrideOptionsPtr, args)
  }

  public final fun getStructuredTextBidiOverrideOptions(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getStructuredTextBidiOverrideOptionsPtr) as VariantArray<Any?>)

  public final fun setTextDirection(direction: Control.TextDirection): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextDirectionPtr, direction.value)
  }

  public final fun getTextDirection(): Control.TextDirection =
      Control.TextDirection.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextDirectionPtr))

  public final fun setLanguage(language: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setLanguagePtr, language)
  }

  public final fun getLanguage(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getLanguagePtr)

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setHorizontalAlignmentPtr, alignment.value)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment =
      HorizontalAlignment.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getHorizontalAlignmentPtr))

  public final fun setVerticalAlignment(alignment: VerticalAlignment): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVerticalAlignmentPtr, alignment.value)
  }

  public final fun getVerticalAlignment(): VerticalAlignment =
      VerticalAlignment.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVerticalAlignmentPtr))

  public final fun setJustificationFlags(justificationFlags: TextServer.JustificationFlag): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setJustificationFlagsPtr, justificationFlags.flag)
  }

  public final fun getJustificationFlags(): TextServer.JustificationFlag =
      TextServer.JustificationFlag(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getJustificationFlagsPtr))

  public final fun setTabStops(tabStops: PackedFloat32Array): Unit {
    TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, MethodBindings.setTabStopsPtr, tabStops)
  }

  public final fun getTabStops(): PackedFloat32Array =
      TransferContext.callPtrMethod0_ret_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, MethodBindings.getTabStopsPtr)

  public final fun setAutowrapMode(autowrapMode: TextServer.AutowrapMode): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAutowrapModePtr, autowrapMode.value)
  }

  public final fun getAutowrapMode(): TextServer.AutowrapMode =
      TextServer.AutowrapMode.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAutowrapModePtr))

  public final fun setAutowrapTrimFlags(autowrapTrimFlags: TextServer.LineBreakFlag): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAutowrapTrimFlagsPtr, autowrapTrimFlags.flag)
  }

  public final fun getAutowrapTrimFlags(): TextServer.LineBreakFlag =
      TextServer.LineBreakFlag(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAutowrapTrimFlagsPtr))

  public final fun setMetaUnderline(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setMetaUnderlinePtr, enable)
  }

  public final fun isMetaUnderlined(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isMetaUnderlinedPtr)

  public final fun setHintUnderline(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setHintUnderlinePtr, enable)
  }

  public final fun isHintUnderlined(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isHintUnderlinedPtr)

  public final fun setScrollActive(active: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setScrollActivePtr, active)
  }

  public final fun isScrollActive(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isScrollActivePtr)

  public final fun setScrollFollowVisibleCharacters(follow: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setScrollFollowVisibleCharactersPtr, follow)
  }

  public final fun isScrollFollowingVisibleCharacters(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isScrollFollowingVisibleCharactersPtr)

  public final fun setScrollFollow(follow: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setScrollFollowPtr, follow)
  }

  public final fun isScrollFollowing(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isScrollFollowingPtr)

  /**
   * Returns the vertical scrollbar.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getVScrollBar(): VScrollBar? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getVScrollBarPtr) as VScrollBar?)

  /**
   * Scrolls the window's top line to match [line].
   */
  public final fun scrollToLine(line: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.scrollToLinePtr, line.toLong())
  }

  /**
   * Scrolls the window's top line to match first line of the [paragraph].
   */
  public final fun scrollToParagraph(paragraph: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.scrollToParagraphPtr, paragraph.toLong())
  }

  /**
   * Scrolls to the beginning of the current selection.
   */
  public final fun scrollToSelection(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.scrollToSelectionPtr)
  }

  public final fun setTabSize(spaces: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTabSizePtr, spaces.toLong())
  }

  public final fun getTabSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTabSizePtr).toInt()

  public final fun setFitContent(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setFitContentPtr, enabled)
  }

  public final fun isFitContentEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isFitContentEnabledPtr)

  public final fun setSelectionEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setSelectionEnabledPtr, enabled)
  }

  public final fun isSelectionEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isSelectionEnabledPtr)

  public final fun setContextMenuEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setContextMenuEnabledPtr, enabled)
  }

  public final fun isContextMenuEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isContextMenuEnabledPtr)

  public final fun setShortcutKeysEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setShortcutKeysEnabledPtr, enabled)
  }

  public final fun isShortcutKeysEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isShortcutKeysEnabledPtr)

  public final fun setDeselectOnFocusLossEnabled(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setDeselectOnFocusLossEnabledPtr, enable)
  }

  public final fun isDeselectOnFocusLossEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isDeselectOnFocusLossEnabledPtr)

  public final fun setDragAndDropSelectionEnabled(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setDragAndDropSelectionEnabledPtr, enable)
  }

  public final fun isDragAndDropSelectionEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isDragAndDropSelectionEnabledPtr)

  /**
   * Returns the current selection first character index if a selection is active, `-1` otherwise.
   * Does not include BBCodes.
   */
  public final fun getSelectionFrom(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSelectionFromPtr).toInt()

  /**
   * Returns the current selection last character index if a selection is active, `-1` otherwise.
   * Does not include BBCodes.
   */
  public final fun getSelectionTo(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSelectionToPtr).toInt()

  /**
   * Returns the current selection vertical line offset if a selection is active, `-1.0` otherwise.
   */
  public final fun getSelectionLineOffset(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getSelectionLineOffsetPtr).toFloat()

  /**
   * Select all the text.
   *
   * If [selectionEnabled] is `false`, no selection will occur.
   */
  public final fun selectAll(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.selectAllPtr)
  }

  /**
   * Returns the current selection text. Does not include BBCodes.
   */
  public final fun getSelectedText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getSelectedTextPtr)

  /**
   * Clears the current selection.
   */
  public final fun deselect(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.deselectPtr)
  }

  /**
   * The assignment version of [appendText]. Clears the tag stack and inserts the new content.
   */
  public final fun parseBbcode(bbcode: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.parseBbcodePtr, bbcode)
  }

  /**
   * Parses [bbcode] and adds tags to the tag stack as needed.
   *
   * **Note:** Using this method, you can't close a tag that was opened in a previous [appendText]
   * call. This is done to improve performance, especially when updating large RichTextLabels since
   * rebuilding the whole BBCode every time would be slower. If you absolutely need to close a tag in a
   * future method call, append the [text] instead of using [appendText].
   */
  public final fun appendText(bbcode: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.appendTextPtr, bbcode)
  }

  public final fun getText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getTextPtr)

  /**
   * If [threaded] is enabled, returns `true` if the background thread has finished text processing,
   * otherwise always return `true`.
   */
  public final fun isReady(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isReadyPtr)

  /**
   * If [threaded] is enabled, returns `true` if the background thread has finished text processing,
   * otherwise always return `true`.
   */
  public final fun isFinished(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isFinishedPtr)

  public final fun setThreaded(threaded: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setThreadedPtr, threaded)
  }

  public final fun isThreaded(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isThreadedPtr)

  public final fun setProgressBarDelay(delayMs: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setProgressBarDelayPtr, delayMs.toLong())
  }

  public final fun getProgressBarDelay(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getProgressBarDelayPtr).toInt()

  public final fun setVisibleCharacters(amount: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVisibleCharactersPtr, amount.toLong())
  }

  public final fun getVisibleCharacters(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVisibleCharactersPtr).toInt()

  public final fun getVisibleCharactersBehavior(): TextServer.VisibleCharactersBehavior =
      TextServer.VisibleCharactersBehavior.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVisibleCharactersBehaviorPtr))

  public final fun setVisibleCharactersBehavior(behavior: TextServer.VisibleCharactersBehavior):
      Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setVisibleCharactersBehaviorPtr, behavior.value)
  }

  public final fun setVisibleRatio(ratio: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setVisibleRatioPtr, ratio.toDouble())
  }

  public final fun getVisibleRatio(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getVisibleRatioPtr).toFloat()

  /**
   * Returns the line number of the character position provided. Line and character numbers are both
   * zero-indexed.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getCharacterLine(character: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getCharacterLinePtr, character.toLong()).toInt()

  /**
   * Returns the paragraph number of the character position provided. Paragraph and character
   * numbers are both zero-indexed.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getCharacterParagraph(character: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getCharacterParagraphPtr, character.toLong()).toInt()

  /**
   * Returns the total number of characters from text tags. Does not include BBCodes.
   */
  public final fun getTotalCharacterCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTotalCharacterCountPtr).toInt()

  public final fun setUseBbcode(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setUseBbcodePtr, enable)
  }

  public final fun isUsingBbcode(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isUsingBbcodePtr)

  /**
   * Returns the total number of lines in the text. Wrapped text is counted as multiple lines.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getLineCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getLineCountPtr).toInt()

  /**
   * Returns the indexes of the first and last visible characters for the given [line], as a
   * [Vector2i].
   *
   * **Note:** If [visibleCharactersBehavior] is set to [TextServer.VC_CHARS_BEFORE_SHAPING] only
   * visible wrapped lines are counted.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getLineRange(line: Int): Vector2i =
      TransferContext.callPtrMethod_LONG_ret_VECTOR2I(ptr, objectID.id, MethodBindings.getLineRangePtr, line.toLong())

  /**
   * Returns the number of visible lines.
   *
   * **Note:** This method returns a correct value only after the label has been drawn.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getVisibleLineCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVisibleLineCountPtr).toInt()

  /**
   * Returns the total number of paragraphs (newlines or `p` tags in the tag stack's text tags).
   * Considers wrapped text as one paragraph.
   */
  public final fun getParagraphCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getParagraphCountPtr).toInt()

  /**
   * Returns the number of visible paragraphs. A paragraph is considered visible if at least one of
   * its lines is visible.
   *
   * **Note:** This method returns a correct value only after the label has been drawn.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getVisibleParagraphCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getVisibleParagraphCountPtr).toInt()

  /**
   * Returns the height of the content.
   *
   * **Note:** This method always returns the full content size, and is not affected by
   * [visibleRatio] and [visibleCharacters]. To get the visible content size, use
   * [getVisibleContentRect].
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getContentHeight(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getContentHeightPtr).toInt()

  /**
   * Returns the width of the content.
   *
   * **Note:** This method always returns the full content size, and is not affected by
   * [visibleRatio] and [visibleCharacters]. To get the visible content size, use
   * [getVisibleContentRect].
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getContentWidth(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getContentWidthPtr).toInt()

  /**
   * Returns the height of the line found at the provided index.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether the document is fully loaded.
   */
  public final fun getLineHeight(line: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getLineHeightPtr, line.toLong()).toInt()

  /**
   * Returns the width of the line found at the provided index.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether the document is fully loaded.
   */
  public final fun getLineWidth(line: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getLineWidthPtr, line.toLong()).toInt()

  /**
   * Returns the bounding rectangle of the visible content.
   *
   * **Note:** This method returns a correct value only after the label has been drawn.
   *
   * ```gdscript
   * //gdscript
   * extends RichTextLabel
   *
   * @export var background_panel: Panel
   *
   * func _ready():
   * 	await draw
   * 	background_panel.position = get_visible_content_rect().position
   * 	background_panel.size = get_visible_content_rect().size
   * ```
   *
   * ```csharp
   * //csharp
   * public partial class TestLabel : RichTextLabel
   * {
   * 	[Export]
   * 	public Panel BackgroundPanel { get; set; }
   *
   * 	public override async void _Ready()
   * 	{
   * 		await ToSignal(this, Control.SignalName.Draw);
   * 		BackgroundGPanel.Position = GetVisibleContentRect().Position;
   * 		BackgroundPanel.Size = GetVisibleContentRect().Size;
   * 	}
   * }
   * ```
   */
  public final fun getVisibleContentRect(): Rect2i =
      TransferContext.callPtrMethod0_ret_RECT2I(ptr, objectID.id, MethodBindings.getVisibleContentRectPtr)

  /**
   * Returns the vertical offset of the line found at the provided index.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getLineOffset(line: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLineOffsetPtr, line.toLong()).toFloat()

  /**
   * Returns the vertical offset of the paragraph found at the provided index.
   *
   * **Note:** If [threaded] is enabled, this method returns a value for the loaded part of the
   * document. Use [isFinished] or [signal finished] to determine whether document is fully loaded.
   */
  public final fun getParagraphOffset(paragraph: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getParagraphOffsetPtr, paragraph.toLong()).toFloat()

  /**
   * Parses BBCode parameter [expressions] into a dictionary.
   */
  public final fun parseExpressionsForValues(expressions: PackedStringArray): Dictionary<Any?, Any?>
      =
      (TransferContext.callPtrMethod_PACKED_STRING_ARRAY_ret_DICTIONARY(ptr, objectID.id, MethodBindings.parseExpressionsForValuesPtr, expressions) as Dictionary<Any?, Any?>)

  public final fun setEffects(effects: VariantArray<Any?>): Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setEffectsPtr, effects)
  }

  public final fun getEffects(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getEffectsPtr) as VariantArray<Any?>)

  /**
   * Installs a custom effect. This can also be done in the Inspector through the [customEffects]
   * property. [effect] should be a valid [RichTextEffect].
   *
   * **Example:** With the following script extending from [RichTextEffect]:
   *
   * ```
   * # effect.gd
   * class_name MyCustomEffect
   * extends RichTextEffect
   *
   * var bbcode = "my_custom_effect"
   *
   * # ...
   * ```
   *
   * The above effect can be installed in [RichTextLabel] from a script:
   *
   * ```
   * # rich_text_label.gd
   * extends RichTextLabel
   *
   * func _ready():
   * 	install_effect(MyCustomEffect.new())
   *
   * 	# Alternatively, if not using `class_name` in the script that extends RichTextEffect:
   * 	install_effect(preload("res://effect.gd").new())
   * ```
   */
  public final fun installEffect(effect: Any?): Unit {
    TransferContext.callMethod_ANY(ptr, objectID.id, MethodBindings.installEffectPtr, effect)
  }

  /**
   * Reloads custom effects. Useful when [customEffects] is modified manually.
   */
  public final fun reloadEffects(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.reloadEffectsPtr)
  }

  /**
   * Returns the [PopupMenu] of this [RichTextLabel]. By default, this menu is displayed when
   * right-clicking on the [RichTextLabel].
   *
   * You can add custom menu items or remove standard ones. Make sure your IDs don't conflict with
   * the standard ones (see [MenuItems]). For example:
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   * 	var menu = get_menu()
   * 	# Remove "Select All" item.
   * 	menu.remove_item(MENU_SELECT_ALL)
   * 	# Add custom items.
   * 	menu.add_separator()
   * 	menu.add_item("Duplicate Text", MENU_MAX + 1)
   * 	# Connect callback.
   * 	menu.id_pressed.connect(_on_item_pressed)
   *
   * func _on_item_pressed(id):
   * 	if id == MENU_MAX + 1:
   * 		add_text("\n" + get_parsed_text())
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Ready()
   * {
   * 	var menu = GetMenu();
   * 	// Remove "Select All" item.
   * 	menu.RemoveItem(RichTextLabel.MenuItems.SelectAll);
   * 	// Add custom items.
   * 	menu.AddSeparator();
   * 	menu.AddItem("Duplicate Text", RichTextLabel.MenuItems.Max + 1);
   * 	// Add event handler.
   * 	menu.IdPressed += OnItemPressed;
   * }
   *
   * public void OnItemPressed(int id)
   * {
   * 	if (id == TextEdit.MenuItems.Max + 1)
   * 	{
   * 		AddText("\n" + GetParsedText());
   * 	}
   * }
   * ```
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [Window.visible] property.
   */
  public final fun getMenu(): PopupMenu? =
      (TransferContext.callPtrMethod0_ret_OBJECT(ptr, objectID.id, MethodBindings.getMenuPtr) as PopupMenu?)

  /**
   * Returns whether the menu is visible. Use this instead of `get_menu().visible` to improve
   * performance (so the creation of the menu is avoided).
   */
  public final fun isMenuVisible(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isMenuVisiblePtr)

  /**
   * Executes a given action as defined in the [MenuItems] enum.
   */
  public final fun menuOption(option: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.menuOptionPtr, option.toLong())
  }

  public enum class ListType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Each list item has a number marker.
     */
    NUMBERS(0),
    /**
     * Each list item has a letter marker.
     */
    LETTERS(1),
    /**
     * Each list item has a roman number marker.
     */
    ROMAN(2),
    /**
     * Each list item has a filled circle marker.
     */
    DOTS(3),
    ;

    public companion object {
      public fun from(`value`: Long): ListType = entries.single { it.`value` == `value` }
    }
  }

  public enum class MenuItems(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Copies the selected text.
     */
    COPY(0),
    /**
     * Selects the whole [RichTextLabel] text.
     */
    SELECT_ALL(1),
    /**
     * Represents the size of the [MenuItems] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): MenuItems = entries.single { it.`value` == `value` }
    }
  }

  public enum class MetaUnderline(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Meta tag does not display an underline, even if [metaUnderlined] is `true`.
     */
    NEVER(0),
    /**
     * If [metaUnderlined] is `true`, meta tag always display an underline.
     */
    ALWAYS(1),
    /**
     * If [metaUnderlined] is `true`, meta tag display an underline when the mouse cursor is over
     * it.
     */
    ON_HOVER(2),
    ;

    public companion object {
      public fun from(`value`: Long): MetaUnderline = entries.single { it.`value` == `value` }
    }
  }

  public class ImageUpdateMask(
    flag: Long,
  ) : BitFieldBase<ImageUpdateMask>(flag) {
    protected override fun wrap(flag: Long): ImageUpdateMask = ImageUpdateMask(flag)

    public companion object {
      /**
       * If this bit is set, [updateImage] changes image texture.
       */
      @JvmField
      public val UPDATE_TEXTURE: ImageUpdateMask = ImageUpdateMask(1)

      /**
       * If this bit is set, [updateImage] changes image size.
       */
      @JvmField
      public val UPDATE_SIZE: ImageUpdateMask = ImageUpdateMask(2)

      /**
       * If this bit is set, [updateImage] changes image color.
       */
      @JvmField
      public val UPDATE_COLOR: ImageUpdateMask = ImageUpdateMask(4)

      /**
       * If this bit is set, [updateImage] changes image inline alignment.
       */
      @JvmField
      public val UPDATE_ALIGNMENT: ImageUpdateMask = ImageUpdateMask(8)

      /**
       * If this bit is set, [updateImage] changes image texture region.
       */
      @JvmField
      public val UPDATE_REGION: ImageUpdateMask = ImageUpdateMask(16)

      /**
       * If this bit is set, [updateImage] changes image padding.
       */
      @JvmField
      public val UPDATE_PAD: ImageUpdateMask = ImageUpdateMask(32)

      /**
       * If this bit is set, [updateImage] changes image tooltip.
       */
      @JvmField
      public val UPDATE_TOOLTIP: ImageUpdateMask = ImageUpdateMask(64)

      /**
       * If this bit is set, [updateImage] changes the units used to calculate image size.
       */
      @JvmField
      public val UPDATE_WIDTH_UNIT: ImageUpdateMask = ImageUpdateMask(128)
    }
  }

  public enum class ImageUnit(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Images drawn with this unit will be in pixels.
     */
    PIXEL(0),
    /**
     * Images drawn with this unit will be in percentages of the control width.
     */
    PERCENT(1),
    /**
     * Images drawn with this unit will be in percentages of the surrounding font size.
     */
    EM(2),
    ;

    public companion object {
      public fun from(`value`: Long): ImageUnit = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getParsedTextName: MethodStringName0<RichTextLabel, String> =
        MethodStringName0<RichTextLabel, String>("get_parsed_text")

    @JvmField
    public val addTextName: MethodStringName1<RichTextLabel, Unit, String> =
        MethodStringName1<RichTextLabel, Unit, String>("add_text")

    @JvmField
    public val setTextName: MethodStringName1<RichTextLabel, Unit, String> =
        MethodStringName1<RichTextLabel, Unit, String>("set_text")

    @JvmField
    public val addHrName:
        MethodStringName6<RichTextLabel, Unit, Int, Int, Color, HorizontalAlignment, Boolean, Boolean>
        =
        MethodStringName6<RichTextLabel, Unit, Int, Int, Color, HorizontalAlignment, Boolean, Boolean>("add_hr")

    @JvmField
    public val addImageName:
        MethodStringName12<RichTextLabel, Unit, Texture2D?, Float, Float, Color, InlineAlignment, Rect2, Any?, Boolean, String, ImageUnit, ImageUnit, String>
        =
        MethodStringName12<RichTextLabel, Unit, Texture2D?, Float, Float, Color, InlineAlignment, Rect2, Any?, Boolean, String, ImageUnit, ImageUnit, String>("add_image")

    @JvmField
    public val updateImageName:
        MethodStringName12<RichTextLabel, Unit, Any?, ImageUpdateMask, Texture2D?, Float, Float, Color, InlineAlignment, Rect2, Boolean, String, ImageUnit, ImageUnit>
        =
        MethodStringName12<RichTextLabel, Unit, Any?, ImageUpdateMask, Texture2D?, Float, Float, Color, InlineAlignment, Rect2, Boolean, String, ImageUnit, ImageUnit>("update_image")

    @JvmField
    public val newlineName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("newline")

    @JvmField
    public val removeParagraphName: MethodStringName2<RichTextLabel, Boolean, Int, Boolean> =
        MethodStringName2<RichTextLabel, Boolean, Int, Boolean>("remove_paragraph")

    @JvmField
    public val invalidateParagraphName: MethodStringName1<RichTextLabel, Boolean, Int> =
        MethodStringName1<RichTextLabel, Boolean, Int>("invalidate_paragraph")

    @JvmField
    public val pushFontName: MethodStringName2<RichTextLabel, Unit, Font?, Int> =
        MethodStringName2<RichTextLabel, Unit, Font?, Int>("push_font")

    @JvmField
    public val pushFontSizeName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("push_font_size")

    @JvmField
    public val pushNormalName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("push_normal")

    @JvmField
    public val pushBoldName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("push_bold")

    @JvmField
    public val pushBoldItalicsName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("push_bold_italics")

    @JvmField
    public val pushItalicsName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("push_italics")

    @JvmField
    public val pushMonoName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("push_mono")

    @JvmField
    public val pushColorName: MethodStringName1<RichTextLabel, Unit, Color> =
        MethodStringName1<RichTextLabel, Unit, Color>("push_color")

    @JvmField
    public val pushOutlineSizeName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("push_outline_size")

    @JvmField
    public val pushOutlineColorName: MethodStringName1<RichTextLabel, Unit, Color> =
        MethodStringName1<RichTextLabel, Unit, Color>("push_outline_color")

    @JvmField
    public val pushParagraphName:
        MethodStringName6<RichTextLabel, Unit, HorizontalAlignment, Control.TextDirection, String, TextServer.StructuredTextParser, TextServer.JustificationFlag, PackedFloat32Array>
        =
        MethodStringName6<RichTextLabel, Unit, HorizontalAlignment, Control.TextDirection, String, TextServer.StructuredTextParser, TextServer.JustificationFlag, PackedFloat32Array>("push_paragraph")

    @JvmField
    public val pushIndentName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("push_indent")

    @JvmField
    public val pushListName: MethodStringName4<RichTextLabel, Unit, Int, ListType, Boolean, String>
        = MethodStringName4<RichTextLabel, Unit, Int, ListType, Boolean, String>("push_list")

    @JvmField
    public val pushMetaName: MethodStringName3<RichTextLabel, Unit, Any?, MetaUnderline, String> =
        MethodStringName3<RichTextLabel, Unit, Any?, MetaUnderline, String>("push_meta")

    @JvmField
    public val pushHintName: MethodStringName1<RichTextLabel, Unit, String> =
        MethodStringName1<RichTextLabel, Unit, String>("push_hint")

    @JvmField
    public val pushLanguageName: MethodStringName1<RichTextLabel, Unit, String> =
        MethodStringName1<RichTextLabel, Unit, String>("push_language")

    @JvmField
    public val pushUnderlineName: MethodStringName1<RichTextLabel, Unit, Color> =
        MethodStringName1<RichTextLabel, Unit, Color>("push_underline")

    @JvmField
    public val pushStrikethroughName: MethodStringName1<RichTextLabel, Unit, Color> =
        MethodStringName1<RichTextLabel, Unit, Color>("push_strikethrough")

    @JvmField
    public val pushTableName:
        MethodStringName4<RichTextLabel, Unit, Int, InlineAlignment, Int, String> =
        MethodStringName4<RichTextLabel, Unit, Int, InlineAlignment, Int, String>("push_table")

    @JvmField
    public val pushDropcapName:
        MethodStringName7<RichTextLabel, Unit, String, Font?, Int, Rect2, Color, Int, Color> =
        MethodStringName7<RichTextLabel, Unit, String, Font?, Int, Rect2, Color, Int, Color>("push_dropcap")

    @JvmField
    public val setTableColumnExpandName:
        MethodStringName4<RichTextLabel, Unit, Int, Boolean, Int, Boolean> =
        MethodStringName4<RichTextLabel, Unit, Int, Boolean, Int, Boolean>("set_table_column_expand")

    @JvmField
    public val setTableColumnNameName: MethodStringName2<RichTextLabel, Unit, Int, String> =
        MethodStringName2<RichTextLabel, Unit, Int, String>("set_table_column_name")

    @JvmField
    public val setCellRowBackgroundColorName: MethodStringName2<RichTextLabel, Unit, Color, Color> =
        MethodStringName2<RichTextLabel, Unit, Color, Color>("set_cell_row_background_color")

    @JvmField
    public val setCellBorderColorName: MethodStringName1<RichTextLabel, Unit, Color> =
        MethodStringName1<RichTextLabel, Unit, Color>("set_cell_border_color")

    @JvmField
    public val setCellSizeOverrideName: MethodStringName2<RichTextLabel, Unit, Vector2, Vector2> =
        MethodStringName2<RichTextLabel, Unit, Vector2, Vector2>("set_cell_size_override")

    @JvmField
    public val setCellPaddingName: MethodStringName1<RichTextLabel, Unit, Rect2> =
        MethodStringName1<RichTextLabel, Unit, Rect2>("set_cell_padding")

    @JvmField
    public val pushCellName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("push_cell")

    @JvmField
    public val pushFgcolorName: MethodStringName1<RichTextLabel, Unit, Color> =
        MethodStringName1<RichTextLabel, Unit, Color>("push_fgcolor")

    @JvmField
    public val pushBgcolorName: MethodStringName1<RichTextLabel, Unit, Color> =
        MethodStringName1<RichTextLabel, Unit, Color>("push_bgcolor")

    @JvmField
    public val pushCustomfxName:
        MethodStringName2<RichTextLabel, Unit, RichTextEffect?, Dictionary<Any?, Any?>> =
        MethodStringName2<RichTextLabel, Unit, RichTextEffect?, Dictionary<Any?, Any?>>("push_customfx")

    @JvmField
    public val pushContextName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("push_context")

    @JvmField
    public val popContextName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("pop_context")

    @JvmField
    public val popName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("pop")

    @JvmField
    public val popAllName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("pop_all")

    @JvmField
    public val clearName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("clear")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName1<RichTextLabel, Unit, TextServer.StructuredTextParser> =
        MethodStringName1<RichTextLabel, Unit, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName0<RichTextLabel, TextServer.StructuredTextParser> =
        MethodStringName0<RichTextLabel, TextServer.StructuredTextParser>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName1<RichTextLabel, Unit, VariantArray<Any?>> =
        MethodStringName1<RichTextLabel, Unit, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName0<RichTextLabel, VariantArray<Any?>> =
        MethodStringName0<RichTextLabel, VariantArray<Any?>>("get_structured_text_bidi_override_options")

    @JvmField
    public val setTextDirectionName: MethodStringName1<RichTextLabel, Unit, Control.TextDirection> =
        MethodStringName1<RichTextLabel, Unit, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<RichTextLabel, Control.TextDirection> =
        MethodStringName0<RichTextLabel, Control.TextDirection>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<RichTextLabel, Unit, String> =
        MethodStringName1<RichTextLabel, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<RichTextLabel, String> =
        MethodStringName0<RichTextLabel, String>("get_language")

    @JvmField
    public val setHorizontalAlignmentName:
        MethodStringName1<RichTextLabel, Unit, HorizontalAlignment> =
        MethodStringName1<RichTextLabel, Unit, HorizontalAlignment>("set_horizontal_alignment")

    @JvmField
    public val getHorizontalAlignmentName: MethodStringName0<RichTextLabel, HorizontalAlignment> =
        MethodStringName0<RichTextLabel, HorizontalAlignment>("get_horizontal_alignment")

    @JvmField
    public val setVerticalAlignmentName: MethodStringName1<RichTextLabel, Unit, VerticalAlignment> =
        MethodStringName1<RichTextLabel, Unit, VerticalAlignment>("set_vertical_alignment")

    @JvmField
    public val getVerticalAlignmentName: MethodStringName0<RichTextLabel, VerticalAlignment> =
        MethodStringName0<RichTextLabel, VerticalAlignment>("get_vertical_alignment")

    @JvmField
    public val setJustificationFlagsName:
        MethodStringName1<RichTextLabel, Unit, TextServer.JustificationFlag> =
        MethodStringName1<RichTextLabel, Unit, TextServer.JustificationFlag>("set_justification_flags")

    @JvmField
    public val getJustificationFlagsName:
        MethodStringName0<RichTextLabel, TextServer.JustificationFlag> =
        MethodStringName0<RichTextLabel, TextServer.JustificationFlag>("get_justification_flags")

    @JvmField
    public val setTabStopsName: MethodStringName1<RichTextLabel, Unit, PackedFloat32Array> =
        MethodStringName1<RichTextLabel, Unit, PackedFloat32Array>("set_tab_stops")

    @JvmField
    public val getTabStopsName: MethodStringName0<RichTextLabel, PackedFloat32Array> =
        MethodStringName0<RichTextLabel, PackedFloat32Array>("get_tab_stops")

    @JvmField
    public val setAutowrapModeName: MethodStringName1<RichTextLabel, Unit, TextServer.AutowrapMode>
        = MethodStringName1<RichTextLabel, Unit, TextServer.AutowrapMode>("set_autowrap_mode")

    @JvmField
    public val getAutowrapModeName: MethodStringName0<RichTextLabel, TextServer.AutowrapMode> =
        MethodStringName0<RichTextLabel, TextServer.AutowrapMode>("get_autowrap_mode")

    @JvmField
    public val setAutowrapTrimFlagsName:
        MethodStringName1<RichTextLabel, Unit, TextServer.LineBreakFlag> =
        MethodStringName1<RichTextLabel, Unit, TextServer.LineBreakFlag>("set_autowrap_trim_flags")

    @JvmField
    public val getAutowrapTrimFlagsName: MethodStringName0<RichTextLabel, TextServer.LineBreakFlag>
        = MethodStringName0<RichTextLabel, TextServer.LineBreakFlag>("get_autowrap_trim_flags")

    @JvmField
    public val setMetaUnderlineName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_meta_underline")

    @JvmField
    public val isMetaUnderlinedName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_meta_underlined")

    @JvmField
    public val setHintUnderlineName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_hint_underline")

    @JvmField
    public val isHintUnderlinedName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_hint_underlined")

    @JvmField
    public val setScrollActiveName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_scroll_active")

    @JvmField
    public val isScrollActiveName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_scroll_active")

    @JvmField
    public val setScrollFollowVisibleCharactersName: MethodStringName1<RichTextLabel, Unit, Boolean>
        = MethodStringName1<RichTextLabel, Unit, Boolean>("set_scroll_follow_visible_characters")

    @JvmField
    public val isScrollFollowingVisibleCharactersName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_scroll_following_visible_characters")

    @JvmField
    public val setScrollFollowName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_scroll_follow")

    @JvmField
    public val isScrollFollowingName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_scroll_following")

    @JvmField
    public val getVScrollBarName: MethodStringName0<RichTextLabel, VScrollBar?> =
        MethodStringName0<RichTextLabel, VScrollBar?>("get_v_scroll_bar")

    @JvmField
    public val scrollToLineName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("scroll_to_line")

    @JvmField
    public val scrollToParagraphName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("scroll_to_paragraph")

    @JvmField
    public val scrollToSelectionName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("scroll_to_selection")

    @JvmField
    public val setTabSizeName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("set_tab_size")

    @JvmField
    public val getTabSizeName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_tab_size")

    @JvmField
    public val setFitContentName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_fit_content")

    @JvmField
    public val isFitContentEnabledName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_fit_content_enabled")

    @JvmField
    public val setSelectionEnabledName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_selection_enabled")

    @JvmField
    public val isSelectionEnabledName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_selection_enabled")

    @JvmField
    public val setContextMenuEnabledName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_context_menu_enabled")

    @JvmField
    public val isContextMenuEnabledName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_context_menu_enabled")

    @JvmField
    public val setShortcutKeysEnabledName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_shortcut_keys_enabled")

    @JvmField
    public val isShortcutKeysEnabledName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_shortcut_keys_enabled")

    @JvmField
    public val setDeselectOnFocusLossEnabledName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_deselect_on_focus_loss_enabled")

    @JvmField
    public val isDeselectOnFocusLossEnabledName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_deselect_on_focus_loss_enabled")

    @JvmField
    public val setDragAndDropSelectionEnabledName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_drag_and_drop_selection_enabled")

    @JvmField
    public val isDragAndDropSelectionEnabledName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_drag_and_drop_selection_enabled")

    @JvmField
    public val getSelectionFromName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_selection_from")

    @JvmField
    public val getSelectionToName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_selection_to")

    @JvmField
    public val getSelectionLineOffsetName: MethodStringName0<RichTextLabel, Float> =
        MethodStringName0<RichTextLabel, Float>("get_selection_line_offset")

    @JvmField
    public val selectAllName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("select_all")

    @JvmField
    public val getSelectedTextName: MethodStringName0<RichTextLabel, String> =
        MethodStringName0<RichTextLabel, String>("get_selected_text")

    @JvmField
    public val deselectName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("deselect")

    @JvmField
    public val parseBbcodeName: MethodStringName1<RichTextLabel, Unit, String> =
        MethodStringName1<RichTextLabel, Unit, String>("parse_bbcode")

    @JvmField
    public val appendTextName: MethodStringName1<RichTextLabel, Unit, String> =
        MethodStringName1<RichTextLabel, Unit, String>("append_text")

    @JvmField
    public val getTextName: MethodStringName0<RichTextLabel, String> =
        MethodStringName0<RichTextLabel, String>("get_text")

    @JvmField
    public val isReadyName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_ready")

    @JvmField
    public val isFinishedName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_finished")

    @JvmField
    public val setThreadedName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_threaded")

    @JvmField
    public val isThreadedName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_threaded")

    @JvmField
    public val setProgressBarDelayName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("set_progress_bar_delay")

    @JvmField
    public val getProgressBarDelayName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_progress_bar_delay")

    @JvmField
    public val setVisibleCharactersName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("set_visible_characters")

    @JvmField
    public val getVisibleCharactersName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_visible_characters")

    @JvmField
    public val getVisibleCharactersBehaviorName:
        MethodStringName0<RichTextLabel, TextServer.VisibleCharactersBehavior> =
        MethodStringName0<RichTextLabel, TextServer.VisibleCharactersBehavior>("get_visible_characters_behavior")

    @JvmField
    public val setVisibleCharactersBehaviorName:
        MethodStringName1<RichTextLabel, Unit, TextServer.VisibleCharactersBehavior> =
        MethodStringName1<RichTextLabel, Unit, TextServer.VisibleCharactersBehavior>("set_visible_characters_behavior")

    @JvmField
    public val setVisibleRatioName: MethodStringName1<RichTextLabel, Unit, Float> =
        MethodStringName1<RichTextLabel, Unit, Float>("set_visible_ratio")

    @JvmField
    public val getVisibleRatioName: MethodStringName0<RichTextLabel, Float> =
        MethodStringName0<RichTextLabel, Float>("get_visible_ratio")

    @JvmField
    public val getCharacterLineName: MethodStringName1<RichTextLabel, Int, Int> =
        MethodStringName1<RichTextLabel, Int, Int>("get_character_line")

    @JvmField
    public val getCharacterParagraphName: MethodStringName1<RichTextLabel, Int, Int> =
        MethodStringName1<RichTextLabel, Int, Int>("get_character_paragraph")

    @JvmField
    public val getTotalCharacterCountName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_total_character_count")

    @JvmField
    public val setUseBbcodeName: MethodStringName1<RichTextLabel, Unit, Boolean> =
        MethodStringName1<RichTextLabel, Unit, Boolean>("set_use_bbcode")

    @JvmField
    public val isUsingBbcodeName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_using_bbcode")

    @JvmField
    public val getLineCountName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_line_count")

    @JvmField
    public val getLineRangeName: MethodStringName1<RichTextLabel, Vector2i, Int> =
        MethodStringName1<RichTextLabel, Vector2i, Int>("get_line_range")

    @JvmField
    public val getVisibleLineCountName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_visible_line_count")

    @JvmField
    public val getParagraphCountName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_paragraph_count")

    @JvmField
    public val getVisibleParagraphCountName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_visible_paragraph_count")

    @JvmField
    public val getContentHeightName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_content_height")

    @JvmField
    public val getContentWidthName: MethodStringName0<RichTextLabel, Int> =
        MethodStringName0<RichTextLabel, Int>("get_content_width")

    @JvmField
    public val getLineHeightName: MethodStringName1<RichTextLabel, Int, Int> =
        MethodStringName1<RichTextLabel, Int, Int>("get_line_height")

    @JvmField
    public val getLineWidthName: MethodStringName1<RichTextLabel, Int, Int> =
        MethodStringName1<RichTextLabel, Int, Int>("get_line_width")

    @JvmField
    public val getVisibleContentRectName: MethodStringName0<RichTextLabel, Rect2i> =
        MethodStringName0<RichTextLabel, Rect2i>("get_visible_content_rect")

    @JvmField
    public val getLineOffsetName: MethodStringName1<RichTextLabel, Float, Int> =
        MethodStringName1<RichTextLabel, Float, Int>("get_line_offset")

    @JvmField
    public val getParagraphOffsetName: MethodStringName1<RichTextLabel, Float, Int> =
        MethodStringName1<RichTextLabel, Float, Int>("get_paragraph_offset")

    @JvmField
    public val parseExpressionsForValuesName:
        MethodStringName1<RichTextLabel, Dictionary<Any?, Any?>, PackedStringArray> =
        MethodStringName1<RichTextLabel, Dictionary<Any?, Any?>, PackedStringArray>("parse_expressions_for_values")

    @JvmField
    public val setEffectsName: MethodStringName1<RichTextLabel, Unit, VariantArray<Any?>> =
        MethodStringName1<RichTextLabel, Unit, VariantArray<Any?>>("set_effects")

    @JvmField
    public val getEffectsName: MethodStringName0<RichTextLabel, VariantArray<Any?>> =
        MethodStringName0<RichTextLabel, VariantArray<Any?>>("get_effects")

    @JvmField
    public val installEffectName: MethodStringName1<RichTextLabel, Unit, Any?> =
        MethodStringName1<RichTextLabel, Unit, Any?>("install_effect")

    @JvmField
    public val reloadEffectsName: MethodStringName0<RichTextLabel, Unit> =
        MethodStringName0<RichTextLabel, Unit>("reload_effects")

    @JvmField
    public val getMenuName: MethodStringName0<RichTextLabel, PopupMenu?> =
        MethodStringName0<RichTextLabel, PopupMenu?>("get_menu")

    @JvmField
    public val isMenuVisibleName: MethodStringName0<RichTextLabel, Boolean> =
        MethodStringName0<RichTextLabel, Boolean>("is_menu_visible")

    @JvmField
    public val menuOptionName: MethodStringName1<RichTextLabel, Unit, Int> =
        MethodStringName1<RichTextLabel, Unit, Int>("menu_option")
  }

  public object MethodBindings {
    internal val getParsedTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_parsed_text", 201670096)

    internal val addTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "add_text", 83702148)

    internal val setTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_text", 83702148)

    internal val addHrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "add_hr", 16816895)

    internal val addImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "add_image", 1980227702)

    internal val updateImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "update_image", 202998225)

    internal val newlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "newline", 3218959716)

    internal val removeParagraphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "remove_paragraph", 3262369265)

    internal val invalidateParagraphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "invalidate_paragraph", 3067735520)

    internal val pushFontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_font", 2347424842)

    internal val pushFontSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_font_size", 1286410249)

    internal val pushNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_normal", 3218959716)

    internal val pushBoldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_bold", 3218959716)

    internal val pushBoldItalicsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_bold_italics", 3218959716)

    internal val pushItalicsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_italics", 3218959716)

    internal val pushMonoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_mono", 3218959716)

    internal val pushColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_color", 2920490490)

    internal val pushOutlineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_outline_size", 1286410249)

    internal val pushOutlineColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_outline_color", 2920490490)

    internal val pushParagraphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_paragraph", 3089306873)

    internal val pushIndentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_indent", 1286410249)

    internal val pushListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_list", 3017143144)

    internal val pushMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_meta", 3765356747)

    internal val pushHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_hint", 83702148)

    internal val pushLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_language", 83702148)

    internal val pushUnderlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_underline", 1458098034)

    internal val pushStrikethroughPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_strikethrough", 1458098034)

    internal val pushTablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_table", 3426862026)

    internal val pushDropcapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_dropcap", 4061635501)

    internal val setTableColumnExpandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_table_column_expand", 117236061)

    internal val setTableColumnNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_table_column_name", 501894301)

    internal val setCellRowBackgroundColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_cell_row_background_color", 3465483165)

    internal val setCellBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_cell_border_color", 2920490490)

    internal val setCellSizeOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_cell_size_override", 3108078480)

    internal val setCellPaddingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_cell_padding", 2046264180)

    internal val pushCellPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_cell", 3218959716)

    internal val pushFgcolorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_fgcolor", 2920490490)

    internal val pushBgcolorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_bgcolor", 2920490490)

    internal val pushCustomfxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_customfx", 2337942958)

    internal val pushContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "push_context", 3218959716)

    internal val popContextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "pop_context", 3218959716)

    internal val popPtr: VoidPtr = TypeManager.getMethodBindPtr("RichTextLabel", "pop", 3218959716)

    internal val popAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "pop_all", 3218959716)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "clear", 3218959716)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_structured_text_bidi_override", 55961453)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_structured_text_bidi_override", 3385126229)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_structured_text_bidi_override_options", 381264803)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_structured_text_bidi_override_options", 3995934104)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_text_direction", 119160795)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_text_direction", 797257663)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_language", 201670096)

    internal val setHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_horizontal_alignment", 2312603777)

    internal val getHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_horizontal_alignment", 341400642)

    internal val setVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_vertical_alignment", 1796458609)

    internal val getVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_vertical_alignment", 3274884059)

    internal val setJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_justification_flags", 2877345813)

    internal val getJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_justification_flags", 1583363614)

    internal val setTabStopsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_tab_stops", 2899603908)

    internal val getTabStopsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_tab_stops", 675695659)

    internal val setAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_autowrap_mode", 3289138044)

    internal val getAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_autowrap_mode", 1549071663)

    internal val setAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_autowrap_trim_flags", 2809697122)

    internal val getAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_autowrap_trim_flags", 2340632602)

    internal val setMetaUnderlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_meta_underline", 2586408642)

    internal val isMetaUnderlinedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_meta_underlined", 36873697)

    internal val setHintUnderlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_hint_underline", 2586408642)

    internal val isHintUnderlinedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_hint_underlined", 36873697)

    internal val setScrollActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_scroll_active", 2586408642)

    internal val isScrollActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_scroll_active", 36873697)

    internal val setScrollFollowVisibleCharactersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_scroll_follow_visible_characters", 2586408642)

    internal val isScrollFollowingVisibleCharactersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_scroll_following_visible_characters", 36873697)

    internal val setScrollFollowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_scroll_follow", 2586408642)

    internal val isScrollFollowingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_scroll_following", 36873697)

    internal val getVScrollBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_v_scroll_bar", 2630340773)

    internal val scrollToLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "scroll_to_line", 1286410249)

    internal val scrollToParagraphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "scroll_to_paragraph", 1286410249)

    internal val scrollToSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "scroll_to_selection", 3218959716)

    internal val setTabSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_tab_size", 1286410249)

    internal val getTabSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_tab_size", 3905245786)

    internal val setFitContentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_fit_content", 2586408642)

    internal val isFitContentEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_fit_content_enabled", 36873697)

    internal val setSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_selection_enabled", 2586408642)

    internal val isSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_selection_enabled", 36873697)

    internal val setContextMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_context_menu_enabled", 2586408642)

    internal val isContextMenuEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_context_menu_enabled", 36873697)

    internal val setShortcutKeysEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_shortcut_keys_enabled", 2586408642)

    internal val isShortcutKeysEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_shortcut_keys_enabled", 36873697)

    internal val setDeselectOnFocusLossEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_deselect_on_focus_loss_enabled", 2586408642)

    internal val isDeselectOnFocusLossEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_deselect_on_focus_loss_enabled", 36873697)

    internal val setDragAndDropSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_drag_and_drop_selection_enabled", 2586408642)

    internal val isDragAndDropSelectionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_drag_and_drop_selection_enabled", 36873697)

    internal val getSelectionFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_selection_from", 3905245786)

    internal val getSelectionToPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_selection_to", 3905245786)

    internal val getSelectionLineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_selection_line_offset", 1740695150)

    internal val selectAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "select_all", 3218959716)

    internal val getSelectedTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_selected_text", 201670096)

    internal val deselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "deselect", 3218959716)

    internal val parseBbcodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "parse_bbcode", 83702148)

    internal val appendTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "append_text", 83702148)

    internal val getTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_text", 201670096)

    internal val isReadyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_ready", 36873697)

    internal val isFinishedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_finished", 36873697)

    internal val setThreadedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_threaded", 2586408642)

    internal val isThreadedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_threaded", 36873697)

    internal val setProgressBarDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_progress_bar_delay", 1286410249)

    internal val getProgressBarDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_progress_bar_delay", 3905245786)

    internal val setVisibleCharactersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_visible_characters", 1286410249)

    internal val getVisibleCharactersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_visible_characters", 3905245786)

    internal val getVisibleCharactersBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_visible_characters_behavior", 258789322)

    internal val setVisibleCharactersBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_visible_characters_behavior", 3383839701)

    internal val setVisibleRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_visible_ratio", 373806689)

    internal val getVisibleRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_visible_ratio", 1740695150)

    internal val getCharacterLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_character_line", 3744713108)

    internal val getCharacterParagraphPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_character_paragraph", 3744713108)

    internal val getTotalCharacterCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_total_character_count", 3905245786)

    internal val setUseBbcodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_use_bbcode", 2586408642)

    internal val isUsingBbcodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_using_bbcode", 36873697)

    internal val getLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_line_count", 3905245786)

    internal val getLineRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_line_range", 3665014314)

    internal val getVisibleLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_visible_line_count", 3905245786)

    internal val getParagraphCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_paragraph_count", 3905245786)

    internal val getVisibleParagraphCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_visible_paragraph_count", 3905245786)

    internal val getContentHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_content_height", 3905245786)

    internal val getContentWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_content_width", 3905245786)

    internal val getLineHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_line_height", 923996154)

    internal val getLineWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_line_width", 923996154)

    internal val getVisibleContentRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_visible_content_rect", 410525958)

    internal val getLineOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_line_offset", 4025615559)

    internal val getParagraphOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_paragraph_offset", 4025615559)

    internal val parseExpressionsForValuesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "parse_expressions_for_values", 1522900837)

    internal val setEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "set_effects", 381264803)

    internal val getEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_effects", 2915620761)

    internal val installEffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "install_effect", 1114965689)

    internal val reloadEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "reload_effects", 3218959716)

    internal val getMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "get_menu", 229722558)

    internal val isMenuVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "is_menu_visible", 36873697)

    internal val menuOptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RichTextLabel", "menu_option", 1286410249)
  }
}
