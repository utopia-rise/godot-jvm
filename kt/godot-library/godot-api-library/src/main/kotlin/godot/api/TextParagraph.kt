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
import godot.core.HorizontalAlignment
import godot.core.InlineAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.core.PackedFloat32Array
import godot.core.RID
import godot.core.Rect2
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector2i
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RECT2
import godot.readReturnValue_RID
import godot.readReturnValue_STRING
import godot.readReturnValue_VECTOR2
import godot.readReturnValue_VECTOR2I
import godot.writeMethodArguments0
import godot.writeMethodArguments_ANY
import godot.writeMethodArguments_ANY_VECTOR2_LONG_DOUBLE
import godot.writeMethodArguments_ANY_VECTOR2_LONG_LONG_DOUBLE
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_ANY
import godot.writeMethodArguments_PACKED_FLOAT_32_ARRAY
import godot.writeMethodArguments_RID_VECTOR2_COLOR_COLOR_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_COLOR_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_LONG_COLOR_COLOR_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_LONG_COLOR_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_LONG_LONG_COLOR_DOUBLE
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_OBJECT_LONG_RECT2_STRING
import godot.writeMethodArguments_STRING_OBJECT_LONG_STRING_ANY
import godot.writeMethodArguments_VECTOR2
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Abstraction over [TextServer] for handling a single paragraph of text.
 */
@GodotBaseType
public open class TextParagraph : RefCounted() {
  /**
   * Text writing direction.
   */
  public final inline var direction: TextServer.Direction
    @JvmName("directionProperty")
    get() = getDirection()
    @JvmName("directionProperty")
    set(`value`) {
      setDirection(value)
    }

  /**
   * Custom punctuation character list, used for word breaking. If set to empty string, server
   * defaults are used.
   */
  public final inline var customPunctuation: String
    @JvmName("customPunctuationProperty")
    get() = getCustomPunctuation()
    @JvmName("customPunctuationProperty")
    set(`value`) {
      setCustomPunctuation(value)
    }

  /**
   * Text orientation.
   */
  public final inline var orientation: TextServer.Orientation
    @JvmName("orientationProperty")
    get() = getOrientation()
    @JvmName("orientationProperty")
    set(`value`) {
      setOrientation(value)
    }

  /**
   * If set to `true` text will display invalid characters.
   */
  public final inline var preserveInvalid: Boolean
    @JvmName("preserveInvalidProperty")
    get() = getPreserveInvalid()
    @JvmName("preserveInvalidProperty")
    set(`value`) {
      setPreserveInvalid(value)
    }

  /**
   * If set to `true` text will display control characters.
   */
  public final inline var preserveControl: Boolean
    @JvmName("preserveControlProperty")
    get() = getPreserveControl()
    @JvmName("preserveControlProperty")
    set(`value`) {
      setPreserveControl(value)
    }

  /**
   * Paragraph horizontal alignment.
   */
  public final inline var alignment: HorizontalAlignment
    @JvmName("alignmentProperty")
    get() = getAlignment()
    @JvmName("alignmentProperty")
    set(`value`) {
      setAlignment(value)
    }

  /**
   * Line breaking rules. For more info see [TextServer].
   */
  public final inline var breakFlags: TextServer.LineBreakFlag
    @JvmName("breakFlagsProperty")
    get() = getBreakFlags()
    @JvmName("breakFlagsProperty")
    set(`value`) {
      setBreakFlags(value)
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
   * The clipping behavior when the text exceeds the paragraph's set width.
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
   * Paragraph width.
   */
  public final inline var width: Float
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * Limits the lines of text shown.
   */
  public final inline var maxLinesVisible: Int
    @JvmName("maxLinesVisibleProperty")
    get() = getMaxLinesVisible()
    @JvmName("maxLinesVisibleProperty")
    set(`value`) {
      setMaxLinesVisible(value)
    }

  /**
   * Additional vertical spacing between lines (in pixels), spacing is added to line descent. This
   * value can be negative.
   */
  public final inline var lineSpacing: Float
    @JvmName("lineSpacingProperty")
    get() = getLineSpacing()
    @JvmName("lineSpacingProperty")
    set(`value`) {
      setLineSpacing(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(733, scriptPtr)
  }

  /**
   * Clears text paragraph (removes text and inline objects).
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearPtr, 0)
  }

  /**
   * Duplicates this [TextParagraph].
   */
  public final fun duplicate(): TextParagraph? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.duplicatePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as TextParagraph?)
  }

  public final fun setDirection(direction: TextServer.Direction): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, direction.value)
    TransferContext.callPtrMethod(MethodBindings.setDirectionPtr, 0)
  }

  public final fun getDirection(): TextServer.Direction {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDirectionPtr, 2)
    return TextServer.Direction.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the text writing direction inferred by the BiDi algorithm.
   */
  public final fun getInferredDirection(): TextServer.Direction {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInferredDirectionPtr, 2)
    return TextServer.Direction.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setCustomPunctuation(customPunctuation: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, customPunctuation)
    TransferContext.callMethod(MethodBindings.setCustomPunctuationPtr)
  }

  public final fun getCustomPunctuation(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomPunctuationPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setOrientation(orientation: TextServer.Orientation): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, orientation.value)
    TransferContext.callPtrMethod(MethodBindings.setOrientationPtr, 0)
  }

  public final fun getOrientation(): TextServer.Orientation {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOrientationPtr, 2)
    return TextServer.Orientation.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPreserveInvalid(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPreserveInvalidPtr, 0)
  }

  public final fun getPreserveInvalid(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPreserveInvalidPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPreserveControl(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPreserveControlPtr, 0)
  }

  public final fun getPreserveControl(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPreserveControlPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Overrides BiDi for the structured text.
   *
   * Override ranges should cover full source text without overlaps. BiDi algorithm will be used on
   * each range separately.
   */
  public final fun setBidiOverride(`override`: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, override)
    TransferContext.callPtrMethod(MethodBindings.setBidiOverridePtr, 0)
  }

  /**
   * Sets drop cap, overrides previously set drop cap. Drop cap (dropped capital) is a decorative
   * element at the beginning of a paragraph that is larger than the rest of the text.
   */
  @JvmOverloads
  public final fun setDropcap(
    text: String,
    font: Font?,
    fontSize: Int,
    dropcapMargins: Rect2 = Rect2(0.0, 0.0, 0.0, 0.0),
    language: String = "",
  ): Boolean {
    TransferContext.writeMethodArguments_STRING_OBJECT_LONG_RECT2_STRING(ptr, objectID.id, text, font, fontSize.toLong(), dropcapMargins, language)
    TransferContext.callMethod(MethodBindings.setDropcapPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Removes dropcap.
   */
  public final fun clearDropcap(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearDropcapPtr, 0)
  }

  /**
   * Adds text span and font to draw it.
   */
  @JvmOverloads
  public final fun addString(
    text: String,
    font: Font?,
    fontSize: Int,
    language: String = "",
    meta: Any? = null,
  ): Boolean {
    TransferContext.writeMethodArguments_STRING_OBJECT_LONG_STRING_ANY(ptr, objectID.id, text, font, fontSize.toLong(), language, meta)
    TransferContext.callMethod(MethodBindings.addStringPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Adds inline object to the text buffer, [key] must be unique. In the text, object is represented
   * as [length] object replacement characters.
   */
  @JvmOverloads
  public final fun addObject(
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment = InlineAlignment.CENTER,
    length: Int = 1,
    baseline: Float = 0.0f,
  ): Boolean {
    TransferContext.writeMethodArguments_ANY_VECTOR2_LONG_LONG_DOUBLE(ptr, objectID.id, key, size, inlineAlign.value, length.toLong(), baseline.toDouble())
    TransferContext.callMethod(MethodBindings.addObjectPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets new size and alignment of embedded object.
   */
  @JvmOverloads
  public final fun resizeObject(
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment = InlineAlignment.CENTER,
    baseline: Float = 0.0f,
  ): Boolean {
    TransferContext.writeMethodArguments_ANY_VECTOR2_LONG_DOUBLE(ptr, objectID.id, key, size, inlineAlign.value, baseline.toDouble())
    TransferContext.callMethod(MethodBindings.resizeObjectPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if an object with [key] is embedded in this shaped text buffer.
   */
  public final fun hasObject(key: Any?): Boolean {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, key)
    TransferContext.callMethod(MethodBindings.hasObjectPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callPtrMethod(MethodBindings.setAlignmentPtr, 0)
  }

  public final fun getAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAlignmentPtr, 2)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Aligns paragraph to the given tab-stops.
   */
  public final fun tabAlign(tabStops: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, tabStops)
    TransferContext.callPtrMethod(MethodBindings.tabAlignPtr, 0)
  }

  public final fun setBreakFlags(flags: TextServer.LineBreakFlag): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, flags.flag)
    TransferContext.callPtrMethod(MethodBindings.setBreakFlagsPtr, 0)
  }

  public final fun getBreakFlags(): TextServer.LineBreakFlag {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBreakFlagsPtr, 2)
    return TextServer.LineBreakFlag(TransferContext.readReturnValue_LONG())
  }

  public final fun setJustificationFlags(flags: TextServer.JustificationFlag): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, flags.flag)
    TransferContext.callPtrMethod(MethodBindings.setJustificationFlagsPtr, 0)
  }

  public final fun getJustificationFlags(): TextServer.JustificationFlag {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getJustificationFlagsPtr, 2)
    return TextServer.JustificationFlag(TransferContext.readReturnValue_LONG())
  }

  public final fun setTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, overrunBehavior.value)
    TransferContext.callPtrMethod(MethodBindings.setTextOverrunBehaviorPtr, 0)
  }

  public final fun getTextOverrunBehavior(): TextServer.OverrunBehavior {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextOverrunBehaviorPtr, 2)
    return TextServer.OverrunBehavior.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setEllipsisChar(char: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, char)
    TransferContext.callMethod(MethodBindings.setEllipsisCharPtr)
  }

  public final fun getEllipsisChar(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEllipsisCharPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setWidth(width: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, width.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setWidthPtr, 0)
  }

  public final fun getWidth(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getWidthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the size of the bounding box of the paragraph, without line breaks.
   */
  public final fun getNonWrappedSize(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNonWrappedSizePtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the size of the bounding box of the paragraph.
   */
  public final fun getSize(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSizePtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns TextServer full string buffer RID.
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns TextServer line buffer RID.
   */
  public final fun getLineRid(line: Int): RID {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns drop cap text buffer RID.
   */
  public final fun getDropcapRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDropcapRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the character range of the paragraph.
   */
  public final fun getRange(): Vector2i {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRangePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  /**
   * Returns number of lines in the paragraph.
   */
  public final fun getLineCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLineCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setMaxLinesVisible(maxLinesVisible: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxLinesVisible.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMaxLinesVisiblePtr, 0)
  }

  public final fun getMaxLinesVisible(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxLinesVisiblePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setLineSpacing(lineSpacing: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, lineSpacing.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setLineSpacingPtr, 0)
  }

  public final fun getLineSpacing(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLineSpacingPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns array of inline objects in the line.
   */
  public final fun getLineObjects(line: Int): VariantArray<Any?> {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineObjectsPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Returns bounding rectangle of the inline object.
   */
  public final fun getLineObjectRect(line: Int, key: Any?): Rect2 {
    TransferContext.writeMethodArguments_LONG_ANY(ptr, objectID.id, line.toLong(), key)
    TransferContext.callMethod(MethodBindings.getLineObjectRectPtr)
    return TransferContext.readReturnValue_RECT2()
  }

  /**
   * Returns size of the bounding box of the line of text. Returned size is rounded up.
   */
  public final fun getLineSize(line: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineSizePtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns character range of the line.
   */
  public final fun getLineRange(line: Int): Vector2i {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineRangePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  /**
   * Returns the text line ascent (number of pixels above the baseline for horizontal layout or to
   * the left of baseline for vertical).
   */
  public final fun getLineAscent(line: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineAscentPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the text line descent (number of pixels below the baseline for horizontal layout or to
   * the right of baseline for vertical).
   */
  public final fun getLineDescent(line: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineDescentPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns width (for horizontal layout) or height (for vertical) of the line of text.
   */
  public final fun getLineWidth(line: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineWidthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public final fun getLineUnderlinePosition(line: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineUnderlinePositionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns thickness of the underline.
   */
  public final fun getLineUnderlineThickness(line: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, line.toLong())
    TransferContext.callPtrMethod(MethodBindings.getLineUnderlineThicknessPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns drop cap bounding box size.
   */
  public final fun getDropcapSize(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDropcapSizePtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns number of lines used by dropcap.
   */
  public final fun getDropcapLines(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDropcapLinesPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Draw all lines of the text and drop cap into a canvas item at a given position, with [color].
   * [pos] specifies the top left corner of the bounding box. If [oversampling] is greater than zero,
   * it is used as font oversampling factor, otherwise viewport oversampling settings are used.
   */
  @JvmOverloads
  public final fun draw(
    canvas: RID,
    pos: Vector2,
    color: Color = Color(Color(1, 1, 1, 1)),
    dcColor: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_COLOR_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, color, dcColor, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawPtr, 0)
  }

  /**
   * Draw outlines of all lines of the text and drop cap into a canvas item at a given position,
   * with [color]. [pos] specifies the top left corner of the bounding box. If [oversampling] is
   * greater than zero, it is used as font oversampling factor, otherwise viewport oversampling
   * settings are used.
   */
  @JvmOverloads
  public final fun drawOutline(
    canvas: RID,
    pos: Vector2,
    outlineSize: Int = 1,
    color: Color = Color(Color(1, 1, 1, 1)),
    dcColor: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_LONG_COLOR_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, outlineSize.toLong(), color, dcColor, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawOutlinePtr, 0)
  }

  /**
   * Draw single line of text into a canvas item at a given position, with [color]. [pos] specifies
   * the top left corner of the bounding box. If [oversampling] is greater than zero, it is used as
   * font oversampling factor, otherwise viewport oversampling settings are used.
   */
  @JvmOverloads
  public final fun drawLine(
    canvas: RID,
    pos: Vector2,
    line: Int,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_LONG_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, line.toLong(), color, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawLinePtr, 0)
  }

  /**
   * Draw outline of the single line of text into a canvas item at a given position, with [color].
   * [pos] specifies the top left corner of the bounding box. If [oversampling] is greater than zero,
   * it is used as font oversampling factor, otherwise viewport oversampling settings are used.
   */
  @JvmOverloads
  public final fun drawLineOutline(
    canvas: RID,
    pos: Vector2,
    line: Int,
    outlineSize: Int = 1,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_LONG_LONG_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, line.toLong(), outlineSize.toLong(), color, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawLineOutlinePtr, 0)
  }

  /**
   * Draw drop cap into a canvas item at a given position, with [color]. [pos] specifies the top
   * left corner of the bounding box. If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   */
  @JvmOverloads
  public final fun drawDropcap(
    canvas: RID,
    pos: Vector2,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, color, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawDropcapPtr, 0)
  }

  /**
   * Draw drop cap outline into a canvas item at a given position, with [color]. [pos] specifies the
   * top left corner of the bounding box. If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   */
  @JvmOverloads
  public final fun drawDropcapOutline(
    canvas: RID,
    pos: Vector2,
    outlineSize: Int = 1,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_LONG_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, outlineSize.toLong(), color, oversampling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.drawDropcapOutlinePtr, 0)
  }

  /**
   * Returns caret character offset at the specified coordinates. This function always returns a
   * valid position.
   */
  public final fun hitTest(coords: Vector2): Int {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, coords)
    TransferContext.callPtrMethod(MethodBindings.hitTestPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val clearName: MethodStringName0<TextParagraph, Unit> =
        MethodStringName0<TextParagraph, Unit>("clear")

    @JvmField
    public val duplicateName: MethodStringName0<TextParagraph, TextParagraph?> =
        MethodStringName0<TextParagraph, TextParagraph?>("duplicate")

    @JvmField
    public val setDirectionName: MethodStringName1<TextParagraph, Unit, TextServer.Direction> =
        MethodStringName1<TextParagraph, Unit, TextServer.Direction>("set_direction")

    @JvmField
    public val getDirectionName: MethodStringName0<TextParagraph, TextServer.Direction> =
        MethodStringName0<TextParagraph, TextServer.Direction>("get_direction")

    @JvmField
    public val getInferredDirectionName: MethodStringName0<TextParagraph, TextServer.Direction> =
        MethodStringName0<TextParagraph, TextServer.Direction>("get_inferred_direction")

    @JvmField
    public val setCustomPunctuationName: MethodStringName1<TextParagraph, Unit, String> =
        MethodStringName1<TextParagraph, Unit, String>("set_custom_punctuation")

    @JvmField
    public val getCustomPunctuationName: MethodStringName0<TextParagraph, String> =
        MethodStringName0<TextParagraph, String>("get_custom_punctuation")

    @JvmField
    public val setOrientationName: MethodStringName1<TextParagraph, Unit, TextServer.Orientation> =
        MethodStringName1<TextParagraph, Unit, TextServer.Orientation>("set_orientation")

    @JvmField
    public val getOrientationName: MethodStringName0<TextParagraph, TextServer.Orientation> =
        MethodStringName0<TextParagraph, TextServer.Orientation>("get_orientation")

    @JvmField
    public val setPreserveInvalidName: MethodStringName1<TextParagraph, Unit, Boolean> =
        MethodStringName1<TextParagraph, Unit, Boolean>("set_preserve_invalid")

    @JvmField
    public val getPreserveInvalidName: MethodStringName0<TextParagraph, Boolean> =
        MethodStringName0<TextParagraph, Boolean>("get_preserve_invalid")

    @JvmField
    public val setPreserveControlName: MethodStringName1<TextParagraph, Unit, Boolean> =
        MethodStringName1<TextParagraph, Unit, Boolean>("set_preserve_control")

    @JvmField
    public val getPreserveControlName: MethodStringName0<TextParagraph, Boolean> =
        MethodStringName0<TextParagraph, Boolean>("get_preserve_control")

    @JvmField
    public val setBidiOverrideName: MethodStringName1<TextParagraph, Unit, VariantArray<Any?>> =
        MethodStringName1<TextParagraph, Unit, VariantArray<Any?>>("set_bidi_override")

    @JvmField
    public val setDropcapName:
        MethodStringName5<TextParagraph, Boolean, String, Font?, Int, Rect2, String> =
        MethodStringName5<TextParagraph, Boolean, String, Font?, Int, Rect2, String>("set_dropcap")

    @JvmField
    public val clearDropcapName: MethodStringName0<TextParagraph, Unit> =
        MethodStringName0<TextParagraph, Unit>("clear_dropcap")

    @JvmField
    public val addStringName:
        MethodStringName5<TextParagraph, Boolean, String, Font?, Int, String, Any?> =
        MethodStringName5<TextParagraph, Boolean, String, Font?, Int, String, Any?>("add_string")

    @JvmField
    public val addObjectName:
        MethodStringName5<TextParagraph, Boolean, Any?, Vector2, InlineAlignment, Int, Float> =
        MethodStringName5<TextParagraph, Boolean, Any?, Vector2, InlineAlignment, Int, Float>("add_object")

    @JvmField
    public val resizeObjectName:
        MethodStringName4<TextParagraph, Boolean, Any?, Vector2, InlineAlignment, Float> =
        MethodStringName4<TextParagraph, Boolean, Any?, Vector2, InlineAlignment, Float>("resize_object")

    @JvmField
    public val hasObjectName: MethodStringName1<TextParagraph, Boolean, Any?> =
        MethodStringName1<TextParagraph, Boolean, Any?>("has_object")

    @JvmField
    public val setAlignmentName: MethodStringName1<TextParagraph, Unit, HorizontalAlignment> =
        MethodStringName1<TextParagraph, Unit, HorizontalAlignment>("set_alignment")

    @JvmField
    public val getAlignmentName: MethodStringName0<TextParagraph, HorizontalAlignment> =
        MethodStringName0<TextParagraph, HorizontalAlignment>("get_alignment")

    @JvmField
    public val tabAlignName: MethodStringName1<TextParagraph, Unit, PackedFloat32Array> =
        MethodStringName1<TextParagraph, Unit, PackedFloat32Array>("tab_align")

    @JvmField
    public val setBreakFlagsName: MethodStringName1<TextParagraph, Unit, TextServer.LineBreakFlag> =
        MethodStringName1<TextParagraph, Unit, TextServer.LineBreakFlag>("set_break_flags")

    @JvmField
    public val getBreakFlagsName: MethodStringName0<TextParagraph, TextServer.LineBreakFlag> =
        MethodStringName0<TextParagraph, TextServer.LineBreakFlag>("get_break_flags")

    @JvmField
    public val setJustificationFlagsName:
        MethodStringName1<TextParagraph, Unit, TextServer.JustificationFlag> =
        MethodStringName1<TextParagraph, Unit, TextServer.JustificationFlag>("set_justification_flags")

    @JvmField
    public val getJustificationFlagsName:
        MethodStringName0<TextParagraph, TextServer.JustificationFlag> =
        MethodStringName0<TextParagraph, TextServer.JustificationFlag>("get_justification_flags")

    @JvmField
    public val setTextOverrunBehaviorName:
        MethodStringName1<TextParagraph, Unit, TextServer.OverrunBehavior> =
        MethodStringName1<TextParagraph, Unit, TextServer.OverrunBehavior>("set_text_overrun_behavior")

    @JvmField
    public val getTextOverrunBehaviorName:
        MethodStringName0<TextParagraph, TextServer.OverrunBehavior> =
        MethodStringName0<TextParagraph, TextServer.OverrunBehavior>("get_text_overrun_behavior")

    @JvmField
    public val setEllipsisCharName: MethodStringName1<TextParagraph, Unit, String> =
        MethodStringName1<TextParagraph, Unit, String>("set_ellipsis_char")

    @JvmField
    public val getEllipsisCharName: MethodStringName0<TextParagraph, String> =
        MethodStringName0<TextParagraph, String>("get_ellipsis_char")

    @JvmField
    public val setWidthName: MethodStringName1<TextParagraph, Unit, Float> =
        MethodStringName1<TextParagraph, Unit, Float>("set_width")

    @JvmField
    public val getWidthName: MethodStringName0<TextParagraph, Float> =
        MethodStringName0<TextParagraph, Float>("get_width")

    @JvmField
    public val getNonWrappedSizeName: MethodStringName0<TextParagraph, Vector2> =
        MethodStringName0<TextParagraph, Vector2>("get_non_wrapped_size")

    @JvmField
    public val getSizeName: MethodStringName0<TextParagraph, Vector2> =
        MethodStringName0<TextParagraph, Vector2>("get_size")

    @JvmField
    public val getRidName: MethodStringName0<TextParagraph, RID> =
        MethodStringName0<TextParagraph, RID>("get_rid")

    @JvmField
    public val getLineRidName: MethodStringName1<TextParagraph, RID, Int> =
        MethodStringName1<TextParagraph, RID, Int>("get_line_rid")

    @JvmField
    public val getDropcapRidName: MethodStringName0<TextParagraph, RID> =
        MethodStringName0<TextParagraph, RID>("get_dropcap_rid")

    @JvmField
    public val getRangeName: MethodStringName0<TextParagraph, Vector2i> =
        MethodStringName0<TextParagraph, Vector2i>("get_range")

    @JvmField
    public val getLineCountName: MethodStringName0<TextParagraph, Int> =
        MethodStringName0<TextParagraph, Int>("get_line_count")

    @JvmField
    public val setMaxLinesVisibleName: MethodStringName1<TextParagraph, Unit, Int> =
        MethodStringName1<TextParagraph, Unit, Int>("set_max_lines_visible")

    @JvmField
    public val getMaxLinesVisibleName: MethodStringName0<TextParagraph, Int> =
        MethodStringName0<TextParagraph, Int>("get_max_lines_visible")

    @JvmField
    public val setLineSpacingName: MethodStringName1<TextParagraph, Unit, Float> =
        MethodStringName1<TextParagraph, Unit, Float>("set_line_spacing")

    @JvmField
    public val getLineSpacingName: MethodStringName0<TextParagraph, Float> =
        MethodStringName0<TextParagraph, Float>("get_line_spacing")

    @JvmField
    public val getLineObjectsName: MethodStringName1<TextParagraph, VariantArray<Any?>, Int> =
        MethodStringName1<TextParagraph, VariantArray<Any?>, Int>("get_line_objects")

    @JvmField
    public val getLineObjectRectName: MethodStringName2<TextParagraph, Rect2, Int, Any?> =
        MethodStringName2<TextParagraph, Rect2, Int, Any?>("get_line_object_rect")

    @JvmField
    public val getLineSizeName: MethodStringName1<TextParagraph, Vector2, Int> =
        MethodStringName1<TextParagraph, Vector2, Int>("get_line_size")

    @JvmField
    public val getLineRangeName: MethodStringName1<TextParagraph, Vector2i, Int> =
        MethodStringName1<TextParagraph, Vector2i, Int>("get_line_range")

    @JvmField
    public val getLineAscentName: MethodStringName1<TextParagraph, Float, Int> =
        MethodStringName1<TextParagraph, Float, Int>("get_line_ascent")

    @JvmField
    public val getLineDescentName: MethodStringName1<TextParagraph, Float, Int> =
        MethodStringName1<TextParagraph, Float, Int>("get_line_descent")

    @JvmField
    public val getLineWidthName: MethodStringName1<TextParagraph, Float, Int> =
        MethodStringName1<TextParagraph, Float, Int>("get_line_width")

    @JvmField
    public val getLineUnderlinePositionName: MethodStringName1<TextParagraph, Float, Int> =
        MethodStringName1<TextParagraph, Float, Int>("get_line_underline_position")

    @JvmField
    public val getLineUnderlineThicknessName: MethodStringName1<TextParagraph, Float, Int> =
        MethodStringName1<TextParagraph, Float, Int>("get_line_underline_thickness")

    @JvmField
    public val getDropcapSizeName: MethodStringName0<TextParagraph, Vector2> =
        MethodStringName0<TextParagraph, Vector2>("get_dropcap_size")

    @JvmField
    public val getDropcapLinesName: MethodStringName0<TextParagraph, Int> =
        MethodStringName0<TextParagraph, Int>("get_dropcap_lines")

    @JvmField
    public val drawName: MethodStringName5<TextParagraph, Unit, RID, Vector2, Color, Color, Float> =
        MethodStringName5<TextParagraph, Unit, RID, Vector2, Color, Color, Float>("draw")

    @JvmField
    public val drawOutlineName:
        MethodStringName6<TextParagraph, Unit, RID, Vector2, Int, Color, Color, Float> =
        MethodStringName6<TextParagraph, Unit, RID, Vector2, Int, Color, Color, Float>("draw_outline")

    @JvmField
    public val drawLineName: MethodStringName5<TextParagraph, Unit, RID, Vector2, Int, Color, Float>
        = MethodStringName5<TextParagraph, Unit, RID, Vector2, Int, Color, Float>("draw_line")

    @JvmField
    public val drawLineOutlineName:
        MethodStringName6<TextParagraph, Unit, RID, Vector2, Int, Int, Color, Float> =
        MethodStringName6<TextParagraph, Unit, RID, Vector2, Int, Int, Color, Float>("draw_line_outline")

    @JvmField
    public val drawDropcapName: MethodStringName4<TextParagraph, Unit, RID, Vector2, Color, Float> =
        MethodStringName4<TextParagraph, Unit, RID, Vector2, Color, Float>("draw_dropcap")

    @JvmField
    public val drawDropcapOutlineName:
        MethodStringName5<TextParagraph, Unit, RID, Vector2, Int, Color, Float> =
        MethodStringName5<TextParagraph, Unit, RID, Vector2, Int, Color, Float>("draw_dropcap_outline")

    @JvmField
    public val hitTestName: MethodStringName1<TextParagraph, Int, Vector2> =
        MethodStringName1<TextParagraph, Int, Vector2>("hit_test")
  }

  public object MethodBindings {
    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "clear", 3218959716)

    internal val duplicatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "duplicate", 3607706709)

    internal val setDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_direction", 1418190634)

    internal val getDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_direction", 2516697328)

    internal val getInferredDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_inferred_direction", 2516697328)

    internal val setCustomPunctuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_custom_punctuation", 83702148)

    internal val getCustomPunctuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_custom_punctuation", 201670096)

    internal val setOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_orientation", 42823726)

    internal val getOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_orientation", 175768116)

    internal val setPreserveInvalidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_preserve_invalid", 2586408642)

    internal val getPreserveInvalidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_preserve_invalid", 36873697)

    internal val setPreserveControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_preserve_control", 2586408642)

    internal val getPreserveControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_preserve_control", 36873697)

    internal val setBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_bidi_override", 381264803)

    internal val setDropcapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_dropcap", 2498990330)

    internal val clearDropcapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "clear_dropcap", 3218959716)

    internal val addStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "add_string", 621426851)

    internal val addObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "add_object", 1316529304)

    internal val resizeObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "resize_object", 2095776372)

    internal val hasObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "has_object", 77467830)

    internal val setAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_alignment", 2312603777)

    internal val getAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_alignment", 341400642)

    internal val tabAlignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "tab_align", 2899603908)

    internal val setBreakFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_break_flags", 2809697122)

    internal val getBreakFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_break_flags", 2340632602)

    internal val setJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_justification_flags", 2877345813)

    internal val getJustificationFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_justification_flags", 1583363614)

    internal val setTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_text_overrun_behavior", 1008890932)

    internal val getTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_text_overrun_behavior", 3779142101)

    internal val setEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_ellipsis_char", 83702148)

    internal val getEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_ellipsis_char", 201670096)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_width", 373806689)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_width", 1740695150)

    internal val getNonWrappedSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_non_wrapped_size", 3341600327)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_size", 3341600327)

    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_rid", 2944877500)

    internal val getLineRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_rid", 495598643)

    internal val getDropcapRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_dropcap_rid", 2944877500)

    internal val getRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_range", 3690982128)

    internal val getLineCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_count", 3905245786)

    internal val setMaxLinesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_max_lines_visible", 1286410249)

    internal val getMaxLinesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_max_lines_visible", 3905245786)

    internal val setLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "set_line_spacing", 373806689)

    internal val getLineSpacingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_spacing", 1740695150)

    internal val getLineObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_objects", 663333327)

    internal val getLineObjectRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_object_rect", 204315017)

    internal val getLineSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_size", 2299179447)

    internal val getLineRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_range", 880721226)

    internal val getLineAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_ascent", 2339986948)

    internal val getLineDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_descent", 2339986948)

    internal val getLineWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_width", 2339986948)

    internal val getLineUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_underline_position", 2339986948)

    internal val getLineUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_line_underline_thickness", 2339986948)

    internal val getDropcapSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_dropcap_size", 3341600327)

    internal val getDropcapLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "get_dropcap_lines", 3905245786)

    internal val drawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "draw", 1492808103)

    internal val drawOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "draw_outline", 3820500590)

    internal val drawLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "draw_line", 828033758)

    internal val drawLineOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "draw_line_outline", 2822696703)

    internal val drawDropcapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "draw_dropcap", 3625105422)

    internal val drawDropcapOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "draw_dropcap_outline", 2592177763)

    internal val hitTestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextParagraph", "hit_test", 3820158470)
  }
}
