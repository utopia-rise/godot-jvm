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
import godot.common.interop.VoidPtr
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedFloat32Array
import godot.core.Rect2
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VerticalAlignment
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
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
 * A control for displaying plain text. It gives you control over the horizontal and vertical
 * alignment and can wrap the text inside the node's bounding rectangle. It doesn't support bold,
 * italics, or other rich text formatting. For that, use [RichTextLabel] instead.
 *
 * **Note:** A single Label node is not designed to display huge amounts of text. To display large
 * amounts of text in a single node, consider using [RichTextLabel] instead as it supports features
 * like an integrated scroll bar and threading. [RichTextLabel] generally performs better when
 * displaying large amounts of text (several pages or more).
 */
@GodotBaseType
public open class Label : Control() {
  /**
   * The text to display on screen.
   */
  public final inline var text: String
    @JvmName("textProperty")
    get() = getText()
    @JvmName("textProperty")
    set(`value`) {
      setText(value)
    }

  /**
   * A [LabelSettings] resource that can be shared between multiple [Label] nodes. Takes priority
   * over theme properties.
   */
  public final inline var labelSettings: LabelSettings?
    @JvmName("labelSettingsProperty")
    get() = getLabelSettings()
    @JvmName("labelSettingsProperty")
    set(`value`) {
      setLabelSettings(value)
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
   * If set to something other than [TextServer.AUTOWRAP_OFF], the text gets wrapped inside the
   * node's bounding rectangle. If you resize the node, it will change its height automatically to show
   * all the text.
   *
   * **Note:** Labels with autowrapping enabled must have a custom maximum width configured to work
   * correctly, either through the Label's own [Control.customMaximumSize] or as a result of a
   * propagated maximum size from a parent Control with [Control.propagateMaximumSize] enabled.
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
   * String used as a paragraph separator. Each paragraph is processed independently, in its own
   * BiDi context.
   */
  public final inline var paragraphSeparator: String
    @JvmName("paragraphSeparatorProperty")
    get() = getParagraphSeparator()
    @JvmName("paragraphSeparatorProperty")
    set(`value`) {
      setParagraphSeparator(value)
    }

  /**
   * If `true`, the Label only shows the text that fits inside its bounding rectangle and will clip
   * text horizontally.
   */
  public final inline var clipText: Boolean
    @JvmName("clipTextProperty")
    get() = isClippingText()
    @JvmName("clipTextProperty")
    set(`value`) {
      setClipText(value)
    }

  /**
   * The clipping behavior when the text exceeds the node's bounding rectangle.
   */
  public final inline var textOverrunBehavior: TextServer.OverrunBehavior
    @JvmName("textOverrunBehaviorProperty")
    get() = getTextOverrunBehavior()
    @JvmName("textOverrunBehaviorProperty")
    set(`value`) {
      setTextOverrunBehavior(value)
    }

  /**
   * Ellipsis character used for text clipping.
   */
  public final inline var ellipsisChar: String
    @JvmName("ellipsisCharProperty")
    get() = getEllipsisChar()
    @JvmName("ellipsisCharProperty")
    set(`value`) {
      setEllipsisChar(value)
    }

  /**
   * If `true`, all the text displays as UPPERCASE.
   */
  public final inline var uppercase: Boolean
    @JvmName("uppercaseProperty")
    get() = isUppercase()
    @JvmName("uppercaseProperty")
    set(`value`) {
      setUppercase(value)
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
   * The number of the lines ignored and not displayed from the start of the [text] value.
   */
  public final inline var linesSkipped: Int
    @JvmName("linesSkippedProperty")
    get() = getLinesSkipped()
    @JvmName("linesSkippedProperty")
    set(`value`) {
      setLinesSkipped(value)
    }

  /**
   * Limits the lines of text the node shows on screen.
   */
  public final inline var maxLinesVisible: Int
    @JvmName("maxLinesVisibleProperty")
    get() = getMaxLinesVisible()
    @JvmName("maxLinesVisibleProperty")
    set(`value`) {
      setMaxLinesVisible(value)
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
    createNativeObject(350, scriptPtr)
  }

  /**
   * This is a helper function for [tabStops] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = label.tabStops
   * //Your changes
   * label.tabStops = myCoreType
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

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alignment.value)
    TransferContext.callMethod(MethodBindings.setHorizontalAlignmentPtr)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHorizontalAlignmentPtr)
    return HorizontalAlignment.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVerticalAlignment(alignment: VerticalAlignment): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to alignment.value)
    TransferContext.callMethod(MethodBindings.setVerticalAlignmentPtr)
  }

  public final fun getVerticalAlignment(): VerticalAlignment {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVerticalAlignmentPtr)
    return VerticalAlignment.from(TransferContext.readReturnValue(LONG) as Long)
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

  public final fun setLabelSettings(settings: LabelSettings?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to settings)
    TransferContext.callMethod(MethodBindings.setLabelSettingsPtr)
  }

  public final fun getLabelSettings(): LabelSettings? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLabelSettingsPtr)
    return (TransferContext.readReturnValue(OBJECT) as LabelSettings?)
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

  public final fun setParagraphSeparator(paragraphSeparator: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to paragraphSeparator)
    TransferContext.callMethod(MethodBindings.setParagraphSeparatorPtr)
  }

  public final fun getParagraphSeparator(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParagraphSeparatorPtr)
    return (TransferContext.readReturnValue(STRING) as String)
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

  public final fun setAutowrapTrimFlags(autowrapTrimFlags: TextServer.LineBreakFlag): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to autowrapTrimFlags.flag)
    TransferContext.callMethod(MethodBindings.setAutowrapTrimFlagsPtr)
  }

  public final fun getAutowrapTrimFlags(): TextServer.LineBreakFlag {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAutowrapTrimFlagsPtr)
    return TextServer.LineBreakFlag(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setJustificationFlags(justificationFlags: TextServer.JustificationFlag): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to justificationFlags.flag)
    TransferContext.callMethod(MethodBindings.setJustificationFlagsPtr)
  }

  public final fun getJustificationFlags(): TextServer.JustificationFlag {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJustificationFlagsPtr)
    return TextServer.JustificationFlag(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setClipText(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setClipTextPtr)
  }

  public final fun isClippingText(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isClippingTextPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTabStops(tabStops: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_32_ARRAY to tabStops)
    TransferContext.callMethod(MethodBindings.setTabStopsPtr)
  }

  public final fun getTabStops(): PackedFloat32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabStopsPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_32_ARRAY) as PackedFloat32Array)
  }

  public final fun setTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to overrunBehavior.value)
    TransferContext.callMethod(MethodBindings.setTextOverrunBehaviorPtr)
  }

  public final fun getTextOverrunBehavior(): TextServer.OverrunBehavior {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextOverrunBehaviorPtr)
    return TextServer.OverrunBehavior.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setEllipsisChar(char: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to char)
    TransferContext.callMethod(MethodBindings.setEllipsisCharPtr)
  }

  public final fun getEllipsisChar(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEllipsisCharPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setUppercase(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUppercasePtr)
  }

  public final fun isUppercase(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUppercasePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the height of the line [line].
   *
   * If [line] is set to `-1`, returns the biggest line height.
   *
   * If there are no lines, returns font size in pixels.
   */
  @JvmOverloads
  public final fun getLineHeight(line: Int = -1): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to line.toLong())
    TransferContext.callMethod(MethodBindings.getLineHeightPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of lines of text the Label has.
   */
  public final fun getLineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of lines shown. Useful if the [Label]'s height cannot currently display all
   * lines.
   */
  public final fun getVisibleLineCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibleLineCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the total number of printable characters in the text (excluding spaces and newlines).
   */
  public final fun getTotalCharacterCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTotalCharacterCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setVisibleCharacters(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setVisibleCharactersPtr)
  }

  public final fun getVisibleCharacters(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibleCharactersPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getVisibleCharactersBehavior(): TextServer.VisibleCharactersBehavior {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibleCharactersBehaviorPtr)
    return TextServer.VisibleCharactersBehavior.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setVisibleCharactersBehavior(behavior: TextServer.VisibleCharactersBehavior):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to behavior.value)
    TransferContext.callMethod(MethodBindings.setVisibleCharactersBehaviorPtr)
  }

  public final fun setVisibleRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to ratio.toDouble())
    TransferContext.callMethod(MethodBindings.setVisibleRatioPtr)
  }

  public final fun getVisibleRatio(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibleRatioPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLinesSkipped(linesSkipped: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to linesSkipped.toLong())
    TransferContext.callMethod(MethodBindings.setLinesSkippedPtr)
  }

  public final fun getLinesSkipped(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinesSkippedPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMaxLinesVisible(linesVisible: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to linesVisible.toLong())
    TransferContext.callMethod(MethodBindings.setMaxLinesVisiblePtr)
  }

  public final fun getMaxLinesVisible(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxLinesVisiblePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
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
   * Returns the bounding rectangle of the character at position [pos] in the label's local
   * coordinate system. If the character is a non-visual character or [pos] is outside the valid range,
   * an empty [Rect2] is returned. If the character is a part of a composite grapheme, the bounding
   * rectangle of the whole grapheme is returned.
   */
  public final fun getCharacterBounds(pos: Int): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pos.toLong())
    TransferContext.callMethod(MethodBindings.getCharacterBoundsPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  public companion object {
    @JvmField
    public val setHorizontalAlignmentName: MethodStringName1<Label, Unit, HorizontalAlignment> =
        MethodStringName1<Label, Unit, HorizontalAlignment>("set_horizontal_alignment")

    @JvmField
    public val getHorizontalAlignmentName: MethodStringName0<Label, HorizontalAlignment> =
        MethodStringName0<Label, HorizontalAlignment>("get_horizontal_alignment")

    @JvmField
    public val setVerticalAlignmentName: MethodStringName1<Label, Unit, VerticalAlignment> =
        MethodStringName1<Label, Unit, VerticalAlignment>("set_vertical_alignment")

    @JvmField
    public val getVerticalAlignmentName: MethodStringName0<Label, VerticalAlignment> =
        MethodStringName0<Label, VerticalAlignment>("get_vertical_alignment")

    @JvmField
    public val setTextName: MethodStringName1<Label, Unit, String> =
        MethodStringName1<Label, Unit, String>("set_text")

    @JvmField
    public val getTextName: MethodStringName0<Label, String> =
        MethodStringName0<Label, String>("get_text")

    @JvmField
    public val setLabelSettingsName: MethodStringName1<Label, Unit, LabelSettings?> =
        MethodStringName1<Label, Unit, LabelSettings?>("set_label_settings")

    @JvmField
    public val getLabelSettingsName: MethodStringName0<Label, LabelSettings?> =
        MethodStringName0<Label, LabelSettings?>("get_label_settings")

    @JvmField
    public val setTextDirectionName: MethodStringName1<Label, Unit, Control.TextDirection> =
        MethodStringName1<Label, Unit, Control.TextDirection>("set_text_direction")

    @JvmField
    public val getTextDirectionName: MethodStringName0<Label, Control.TextDirection> =
        MethodStringName0<Label, Control.TextDirection>("get_text_direction")

    @JvmField
    public val setLanguageName: MethodStringName1<Label, Unit, String> =
        MethodStringName1<Label, Unit, String>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<Label, String> =
        MethodStringName0<Label, String>("get_language")

    @JvmField
    public val setParagraphSeparatorName: MethodStringName1<Label, Unit, String> =
        MethodStringName1<Label, Unit, String>("set_paragraph_separator")

    @JvmField
    public val getParagraphSeparatorName: MethodStringName0<Label, String> =
        MethodStringName0<Label, String>("get_paragraph_separator")

    @JvmField
    public val setAutowrapModeName: MethodStringName1<Label, Unit, TextServer.AutowrapMode> =
        MethodStringName1<Label, Unit, TextServer.AutowrapMode>("set_autowrap_mode")

    @JvmField
    public val getAutowrapModeName: MethodStringName0<Label, TextServer.AutowrapMode> =
        MethodStringName0<Label, TextServer.AutowrapMode>("get_autowrap_mode")

    @JvmField
    public val setAutowrapTrimFlagsName: MethodStringName1<Label, Unit, TextServer.LineBreakFlag> =
        MethodStringName1<Label, Unit, TextServer.LineBreakFlag>("set_autowrap_trim_flags")

    @JvmField
    public val getAutowrapTrimFlagsName: MethodStringName0<Label, TextServer.LineBreakFlag> =
        MethodStringName0<Label, TextServer.LineBreakFlag>("get_autowrap_trim_flags")

    @JvmField
    public val setJustificationFlagsName:
        MethodStringName1<Label, Unit, TextServer.JustificationFlag> =
        MethodStringName1<Label, Unit, TextServer.JustificationFlag>("set_justification_flags")

    @JvmField
    public val getJustificationFlagsName: MethodStringName0<Label, TextServer.JustificationFlag> =
        MethodStringName0<Label, TextServer.JustificationFlag>("get_justification_flags")

    @JvmField
    public val setClipTextName: MethodStringName1<Label, Unit, Boolean> =
        MethodStringName1<Label, Unit, Boolean>("set_clip_text")

    @JvmField
    public val isClippingTextName: MethodStringName0<Label, Boolean> =
        MethodStringName0<Label, Boolean>("is_clipping_text")

    @JvmField
    public val setTabStopsName: MethodStringName1<Label, Unit, PackedFloat32Array> =
        MethodStringName1<Label, Unit, PackedFloat32Array>("set_tab_stops")

    @JvmField
    public val getTabStopsName: MethodStringName0<Label, PackedFloat32Array> =
        MethodStringName0<Label, PackedFloat32Array>("get_tab_stops")

    @JvmField
    public val setTextOverrunBehaviorName:
        MethodStringName1<Label, Unit, TextServer.OverrunBehavior> =
        MethodStringName1<Label, Unit, TextServer.OverrunBehavior>("set_text_overrun_behavior")

    @JvmField
    public val getTextOverrunBehaviorName: MethodStringName0<Label, TextServer.OverrunBehavior> =
        MethodStringName0<Label, TextServer.OverrunBehavior>("get_text_overrun_behavior")

    @JvmField
    public val setEllipsisCharName: MethodStringName1<Label, Unit, String> =
        MethodStringName1<Label, Unit, String>("set_ellipsis_char")

    @JvmField
    public val getEllipsisCharName: MethodStringName0<Label, String> =
        MethodStringName0<Label, String>("get_ellipsis_char")

    @JvmField
    public val setUppercaseName: MethodStringName1<Label, Unit, Boolean> =
        MethodStringName1<Label, Unit, Boolean>("set_uppercase")

    @JvmField
    public val isUppercaseName: MethodStringName0<Label, Boolean> =
        MethodStringName0<Label, Boolean>("is_uppercase")

    @JvmField
    public val getLineHeightName: MethodStringName1<Label, Int, Int> =
        MethodStringName1<Label, Int, Int>("get_line_height")

    @JvmField
    public val getLineCountName: MethodStringName0<Label, Int> =
        MethodStringName0<Label, Int>("get_line_count")

    @JvmField
    public val getVisibleLineCountName: MethodStringName0<Label, Int> =
        MethodStringName0<Label, Int>("get_visible_line_count")

    @JvmField
    public val getTotalCharacterCountName: MethodStringName0<Label, Int> =
        MethodStringName0<Label, Int>("get_total_character_count")

    @JvmField
    public val setVisibleCharactersName: MethodStringName1<Label, Unit, Int> =
        MethodStringName1<Label, Unit, Int>("set_visible_characters")

    @JvmField
    public val getVisibleCharactersName: MethodStringName0<Label, Int> =
        MethodStringName0<Label, Int>("get_visible_characters")

    @JvmField
    public val getVisibleCharactersBehaviorName:
        MethodStringName0<Label, TextServer.VisibleCharactersBehavior> =
        MethodStringName0<Label, TextServer.VisibleCharactersBehavior>("get_visible_characters_behavior")

    @JvmField
    public val setVisibleCharactersBehaviorName:
        MethodStringName1<Label, Unit, TextServer.VisibleCharactersBehavior> =
        MethodStringName1<Label, Unit, TextServer.VisibleCharactersBehavior>("set_visible_characters_behavior")

    @JvmField
    public val setVisibleRatioName: MethodStringName1<Label, Unit, Float> =
        MethodStringName1<Label, Unit, Float>("set_visible_ratio")

    @JvmField
    public val getVisibleRatioName: MethodStringName0<Label, Float> =
        MethodStringName0<Label, Float>("get_visible_ratio")

    @JvmField
    public val setLinesSkippedName: MethodStringName1<Label, Unit, Int> =
        MethodStringName1<Label, Unit, Int>("set_lines_skipped")

    @JvmField
    public val getLinesSkippedName: MethodStringName0<Label, Int> =
        MethodStringName0<Label, Int>("get_lines_skipped")

    @JvmField
    public val setMaxLinesVisibleName: MethodStringName1<Label, Unit, Int> =
        MethodStringName1<Label, Unit, Int>("set_max_lines_visible")

    @JvmField
    public val getMaxLinesVisibleName: MethodStringName0<Label, Int> =
        MethodStringName0<Label, Int>("get_max_lines_visible")

    @JvmField
    public val setStructuredTextBidiOverrideName:
        MethodStringName1<Label, Unit, TextServer.StructuredTextParser> =
        MethodStringName1<Label, Unit, TextServer.StructuredTextParser>("set_structured_text_bidi_override")

    @JvmField
    public val getStructuredTextBidiOverrideName:
        MethodStringName0<Label, TextServer.StructuredTextParser> =
        MethodStringName0<Label, TextServer.StructuredTextParser>("get_structured_text_bidi_override")

    @JvmField
    public val setStructuredTextBidiOverrideOptionsName:
        MethodStringName1<Label, Unit, VariantArray<Any?>> =
        MethodStringName1<Label, Unit, VariantArray<Any?>>("set_structured_text_bidi_override_options")

    @JvmField
    public val getStructuredTextBidiOverrideOptionsName:
        MethodStringName0<Label, VariantArray<Any?>> =
        MethodStringName0<Label, VariantArray<Any?>>("get_structured_text_bidi_override_options")

    @JvmField
    public val getCharacterBoundsName: MethodStringName1<Label, Rect2, Int> =
        MethodStringName1<Label, Rect2, Int>("get_character_bounds")
  }

  public object MethodBindings {
    internal val setHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_horizontal_alignment", 2312603777)

    internal val getHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_horizontal_alignment", 341400642)

    internal val setVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_vertical_alignment", 1796458609)

    internal val getVerticalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_vertical_alignment", 3274884059)

    internal val setTextPtr: VoidPtr = TypeManager.getMethodBindPtr("Label", "set_text", 83702148)

    internal val getTextPtr: VoidPtr = TypeManager.getMethodBindPtr("Label", "get_text", 201670096)

    internal val setLabelSettingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_label_settings", 1030653839)

    internal val getLabelSettingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_label_settings", 826676056)

    internal val setTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_text_direction", 119160795)

    internal val getTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_text_direction", 797257663)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_language", 83702148)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_language", 201670096)

    internal val setParagraphSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_paragraph_separator", 83702148)

    internal val getParagraphSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_paragraph_separator", 201670096)

    internal val setAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_autowrap_mode", 3289138044)

    internal val getAutowrapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_autowrap_mode", 1549071663)

    internal val setAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_autowrap_trim_flags", 2809697122)

    internal val getAutowrapTrimFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_autowrap_trim_flags", 2340632602)

    internal val setJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_justification_flags", 2877345813)

    internal val getJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_justification_flags", 1583363614)

    internal val setClipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_clip_text", 2586408642)

    internal val isClippingTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "is_clipping_text", 36873697)

    internal val setTabStopsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_tab_stops", 2899603908)

    internal val getTabStopsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_tab_stops", 675695659)

    internal val setTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_text_overrun_behavior", 1008890932)

    internal val getTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_text_overrun_behavior", 3779142101)

    internal val setEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_ellipsis_char", 83702148)

    internal val getEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_ellipsis_char", 201670096)

    internal val setUppercasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_uppercase", 2586408642)

    internal val isUppercasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "is_uppercase", 36873697)

    internal val getLineHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_line_height", 181039630)

    internal val getLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_line_count", 3905245786)

    internal val getVisibleLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_visible_line_count", 3905245786)

    internal val getTotalCharacterCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_total_character_count", 3905245786)

    internal val setVisibleCharactersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_visible_characters", 1286410249)

    internal val getVisibleCharactersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_visible_characters", 3905245786)

    internal val getVisibleCharactersBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_visible_characters_behavior", 258789322)

    internal val setVisibleCharactersBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_visible_characters_behavior", 3383839701)

    internal val setVisibleRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_visible_ratio", 373806689)

    internal val getVisibleRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_visible_ratio", 1740695150)

    internal val setLinesSkippedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_lines_skipped", 1286410249)

    internal val getLinesSkippedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_lines_skipped", 3905245786)

    internal val setMaxLinesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_max_lines_visible", 1286410249)

    internal val getMaxLinesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_max_lines_visible", 3905245786)

    internal val setStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_structured_text_bidi_override", 55961453)

    internal val getStructuredTextBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_structured_text_bidi_override", 3385126229)

    internal val setStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "set_structured_text_bidi_override_options", 381264803)

    internal val getStructuredTextBidiOverrideOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_structured_text_bidi_override_options", 3995934104)

    internal val getCharacterBoundsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Label", "get_character_bounds", 3327874267)
  }
}
