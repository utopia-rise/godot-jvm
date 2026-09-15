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
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedFloat32Array
import godot.core.RID
import godot.core.Rect2
import godot.core.VariantArray
import godot.core.Vector2
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RECT2
import godot.readReturnValue_RID
import godot.readReturnValue_STRING
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_ANY
import godot.writeMethodArguments_ANY_VECTOR2_LONG_DOUBLE
import godot.writeMethodArguments_ANY_VECTOR2_LONG_LONG_DOUBLE
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_PACKED_FLOAT_32_ARRAY
import godot.writeMethodArguments_RID_VECTOR2_COLOR_DOUBLE
import godot.writeMethodArguments_RID_VECTOR2_LONG_COLOR_DOUBLE
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_OBJECT_LONG_STRING_ANY
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
 * Abstraction over [TextServer] for handling a single line of text.
 */
@GodotBaseType
public open class TextLine : RefCounted() {
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
   * Text line width.
   */
  public final inline var width: Float
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * Sets text alignment within the line as if the line was horizontal.
   */
  public final inline var alignment: HorizontalAlignment
    @JvmName("alignmentProperty")
    get() = getHorizontalAlignment()
    @JvmName("alignmentProperty")
    set(`value`) {
      setHorizontalAlignment(value)
    }

  /**
   * Line alignment rules. For more info see [TextServer].
   */
  public final inline var flags: TextServer.JustificationFlag
    @JvmName("flagsProperty")
    get() = getFlags()
    @JvmName("flagsProperty")
    set(`value`) {
      setFlags(value)
    }

  /**
   * The clipping behavior when the text exceeds the text line's set width.
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

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(731, scriptPtr)
  }

  /**
   * Clears text line (removes text and inline objects).
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Duplicates this [TextLine].
   */
  public final fun duplicate(): TextLine? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.duplicatePtr)
    return (TransferContext.readReturnValue_OBJECT() as TextLine?)
  }

  public final fun setDirection(direction: TextServer.Direction): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, direction.value)
    TransferContext.callMethod(MethodBindings.setDirectionPtr)
  }

  public final fun getDirection(): TextServer.Direction {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDirectionPtr)
    return TextServer.Direction.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the text writing direction inferred by the BiDi algorithm.
   */
  public final fun getInferredDirection(): TextServer.Direction {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInferredDirectionPtr)
    return TextServer.Direction.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setOrientation(orientation: TextServer.Orientation): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, orientation.value)
    TransferContext.callMethod(MethodBindings.setOrientationPtr)
  }

  public final fun getOrientation(): TextServer.Orientation {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOrientationPtr)
    return TextServer.Orientation.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPreserveInvalid(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setPreserveInvalidPtr)
  }

  public final fun getPreserveInvalid(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPreserveInvalidPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPreserveControl(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setPreserveControlPtr)
  }

  public final fun getPreserveControl(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPreserveControlPtr)
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
    TransferContext.callMethod(MethodBindings.setBidiOverridePtr)
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
   * Returns `true` if an object with [key] is embedded in this line.
   */
  public final fun hasObject(key: Any?): Boolean {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, key)
    TransferContext.callMethod(MethodBindings.hasObjectPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setWidth(width: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, width.toDouble())
    TransferContext.callMethod(MethodBindings.setWidthPtr)
  }

  public final fun getWidth(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWidthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callMethod(MethodBindings.setHorizontalAlignmentPtr)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHorizontalAlignmentPtr)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Aligns text to the given tab-stops.
   */
  public final fun tabAlign(tabStops: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, tabStops)
    TransferContext.callMethod(MethodBindings.tabAlignPtr)
  }

  public final fun setFlags(flags: TextServer.JustificationFlag): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, flags.flag)
    TransferContext.callMethod(MethodBindings.setFlagsPtr)
  }

  public final fun getFlags(): TextServer.JustificationFlag {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFlagsPtr)
    return TextServer.JustificationFlag(TransferContext.readReturnValue_LONG())
  }

  public final fun setTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, overrunBehavior.value)
    TransferContext.callMethod(MethodBindings.setTextOverrunBehaviorPtr)
  }

  public final fun getTextOverrunBehavior(): TextServer.OverrunBehavior {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextOverrunBehaviorPtr)
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

  /**
   * Returns array of inline objects.
   */
  public final fun getObjects(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getObjectsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Returns bounding rectangle of the inline object.
   */
  public final fun getObjectRect(key: Any?): Rect2 {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, key)
    TransferContext.callMethod(MethodBindings.getObjectRectPtr)
    return TransferContext.readReturnValue_RECT2()
  }

  /**
   * Returns size of the bounding box of the text.
   */
  public final fun getSize(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns TextServer buffer RID.
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRidPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the text ascent (number of pixels above the baseline for horizontal layout or to the
   * left of baseline for vertical).
   */
  public final fun getLineAscent(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineAscentPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the text descent (number of pixels below the baseline for horizontal layout or to the
   * right of baseline for vertical).
   */
  public final fun getLineDescent(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineDescentPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns width (for horizontal layout) or height (for vertical) of the text.
   */
  public final fun getLineWidth(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineWidthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public final fun getLineUnderlinePosition(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineUnderlinePositionPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns thickness of the underline.
   */
  public final fun getLineUnderlineThickness(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineUnderlineThicknessPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Draw text into a canvas item at a given position, with [color]. [pos] specifies the top left
   * corner of the bounding box. If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   */
  @JvmOverloads
  public final fun draw(
    canvas: RID,
    pos: Vector2,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, color, oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawPtr)
  }

  /**
   * Draw text into a canvas item at a given position, with [color]. [pos] specifies the top left
   * corner of the bounding box. If [oversampling] is greater than zero, it is used as font
   * oversampling factor, otherwise viewport oversampling settings are used.
   */
  @JvmOverloads
  public final fun drawOutline(
    canvas: RID,
    pos: Vector2,
    outlineSize: Int = 1,
    color: Color = Color(Color(1, 1, 1, 1)),
    oversampling: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2_LONG_COLOR_DOUBLE(ptr, objectID.id, canvas, pos, outlineSize.toLong(), color, oversampling.toDouble())
    TransferContext.callMethod(MethodBindings.drawOutlinePtr)
  }

  /**
   * Returns caret character offset at the specified pixel offset at the baseline. This function
   * always returns a valid position.
   */
  public final fun hitTest(coords: Float): Int {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, coords.toDouble())
    TransferContext.callMethod(MethodBindings.hitTestPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val clearName: MethodStringName0<TextLine, Unit> =
        MethodStringName0<TextLine, Unit>("clear")

    @JvmField
    public val duplicateName: MethodStringName0<TextLine, TextLine?> =
        MethodStringName0<TextLine, TextLine?>("duplicate")

    @JvmField
    public val setDirectionName: MethodStringName1<TextLine, Unit, TextServer.Direction> =
        MethodStringName1<TextLine, Unit, TextServer.Direction>("set_direction")

    @JvmField
    public val getDirectionName: MethodStringName0<TextLine, TextServer.Direction> =
        MethodStringName0<TextLine, TextServer.Direction>("get_direction")

    @JvmField
    public val getInferredDirectionName: MethodStringName0<TextLine, TextServer.Direction> =
        MethodStringName0<TextLine, TextServer.Direction>("get_inferred_direction")

    @JvmField
    public val setOrientationName: MethodStringName1<TextLine, Unit, TextServer.Orientation> =
        MethodStringName1<TextLine, Unit, TextServer.Orientation>("set_orientation")

    @JvmField
    public val getOrientationName: MethodStringName0<TextLine, TextServer.Orientation> =
        MethodStringName0<TextLine, TextServer.Orientation>("get_orientation")

    @JvmField
    public val setPreserveInvalidName: MethodStringName1<TextLine, Unit, Boolean> =
        MethodStringName1<TextLine, Unit, Boolean>("set_preserve_invalid")

    @JvmField
    public val getPreserveInvalidName: MethodStringName0<TextLine, Boolean> =
        MethodStringName0<TextLine, Boolean>("get_preserve_invalid")

    @JvmField
    public val setPreserveControlName: MethodStringName1<TextLine, Unit, Boolean> =
        MethodStringName1<TextLine, Unit, Boolean>("set_preserve_control")

    @JvmField
    public val getPreserveControlName: MethodStringName0<TextLine, Boolean> =
        MethodStringName0<TextLine, Boolean>("get_preserve_control")

    @JvmField
    public val setBidiOverrideName: MethodStringName1<TextLine, Unit, VariantArray<Any?>> =
        MethodStringName1<TextLine, Unit, VariantArray<Any?>>("set_bidi_override")

    @JvmField
    public val addStringName: MethodStringName5<TextLine, Boolean, String, Font?, Int, String, Any?>
        = MethodStringName5<TextLine, Boolean, String, Font?, Int, String, Any?>("add_string")

    @JvmField
    public val addObjectName:
        MethodStringName5<TextLine, Boolean, Any?, Vector2, InlineAlignment, Int, Float> =
        MethodStringName5<TextLine, Boolean, Any?, Vector2, InlineAlignment, Int, Float>("add_object")

    @JvmField
    public val resizeObjectName:
        MethodStringName4<TextLine, Boolean, Any?, Vector2, InlineAlignment, Float> =
        MethodStringName4<TextLine, Boolean, Any?, Vector2, InlineAlignment, Float>("resize_object")

    @JvmField
    public val hasObjectName: MethodStringName1<TextLine, Boolean, Any?> =
        MethodStringName1<TextLine, Boolean, Any?>("has_object")

    @JvmField
    public val setWidthName: MethodStringName1<TextLine, Unit, Float> =
        MethodStringName1<TextLine, Unit, Float>("set_width")

    @JvmField
    public val getWidthName: MethodStringName0<TextLine, Float> =
        MethodStringName0<TextLine, Float>("get_width")

    @JvmField
    public val setHorizontalAlignmentName: MethodStringName1<TextLine, Unit, HorizontalAlignment> =
        MethodStringName1<TextLine, Unit, HorizontalAlignment>("set_horizontal_alignment")

    @JvmField
    public val getHorizontalAlignmentName: MethodStringName0<TextLine, HorizontalAlignment> =
        MethodStringName0<TextLine, HorizontalAlignment>("get_horizontal_alignment")

    @JvmField
    public val tabAlignName: MethodStringName1<TextLine, Unit, PackedFloat32Array> =
        MethodStringName1<TextLine, Unit, PackedFloat32Array>("tab_align")

    @JvmField
    public val setFlagsName: MethodStringName1<TextLine, Unit, TextServer.JustificationFlag> =
        MethodStringName1<TextLine, Unit, TextServer.JustificationFlag>("set_flags")

    @JvmField
    public val getFlagsName: MethodStringName0<TextLine, TextServer.JustificationFlag> =
        MethodStringName0<TextLine, TextServer.JustificationFlag>("get_flags")

    @JvmField
    public val setTextOverrunBehaviorName:
        MethodStringName1<TextLine, Unit, TextServer.OverrunBehavior> =
        MethodStringName1<TextLine, Unit, TextServer.OverrunBehavior>("set_text_overrun_behavior")

    @JvmField
    public val getTextOverrunBehaviorName: MethodStringName0<TextLine, TextServer.OverrunBehavior> =
        MethodStringName0<TextLine, TextServer.OverrunBehavior>("get_text_overrun_behavior")

    @JvmField
    public val setEllipsisCharName: MethodStringName1<TextLine, Unit, String> =
        MethodStringName1<TextLine, Unit, String>("set_ellipsis_char")

    @JvmField
    public val getEllipsisCharName: MethodStringName0<TextLine, String> =
        MethodStringName0<TextLine, String>("get_ellipsis_char")

    @JvmField
    public val getObjectsName: MethodStringName0<TextLine, VariantArray<Any?>> =
        MethodStringName0<TextLine, VariantArray<Any?>>("get_objects")

    @JvmField
    public val getObjectRectName: MethodStringName1<TextLine, Rect2, Any?> =
        MethodStringName1<TextLine, Rect2, Any?>("get_object_rect")

    @JvmField
    public val getSizeName: MethodStringName0<TextLine, Vector2> =
        MethodStringName0<TextLine, Vector2>("get_size")

    @JvmField
    public val getRidName: MethodStringName0<TextLine, RID> =
        MethodStringName0<TextLine, RID>("get_rid")

    @JvmField
    public val getLineAscentName: MethodStringName0<TextLine, Float> =
        MethodStringName0<TextLine, Float>("get_line_ascent")

    @JvmField
    public val getLineDescentName: MethodStringName0<TextLine, Float> =
        MethodStringName0<TextLine, Float>("get_line_descent")

    @JvmField
    public val getLineWidthName: MethodStringName0<TextLine, Float> =
        MethodStringName0<TextLine, Float>("get_line_width")

    @JvmField
    public val getLineUnderlinePositionName: MethodStringName0<TextLine, Float> =
        MethodStringName0<TextLine, Float>("get_line_underline_position")

    @JvmField
    public val getLineUnderlineThicknessName: MethodStringName0<TextLine, Float> =
        MethodStringName0<TextLine, Float>("get_line_underline_thickness")

    @JvmField
    public val drawName: MethodStringName4<TextLine, Unit, RID, Vector2, Color, Float> =
        MethodStringName4<TextLine, Unit, RID, Vector2, Color, Float>("draw")

    @JvmField
    public val drawOutlineName: MethodStringName5<TextLine, Unit, RID, Vector2, Int, Color, Float> =
        MethodStringName5<TextLine, Unit, RID, Vector2, Int, Color, Float>("draw_outline")

    @JvmField
    public val hitTestName: MethodStringName1<TextLine, Int, Float> =
        MethodStringName1<TextLine, Int, Float>("hit_test")
  }

  public object MethodBindings {
    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("TextLine", "clear", 3218959716)

    internal val duplicatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "duplicate", 1912703884)

    internal val setDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_direction", 1418190634)

    internal val getDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_direction", 2516697328)

    internal val getInferredDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_inferred_direction", 2516697328)

    internal val setOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_orientation", 42823726)

    internal val getOrientationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_orientation", 175768116)

    internal val setPreserveInvalidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_preserve_invalid", 2586408642)

    internal val getPreserveInvalidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_preserve_invalid", 36873697)

    internal val setPreserveControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_preserve_control", 2586408642)

    internal val getPreserveControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_preserve_control", 36873697)

    internal val setBidiOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_bidi_override", 381264803)

    internal val addStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "add_string", 621426851)

    internal val addObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "add_object", 1316529304)

    internal val resizeObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "resize_object", 2095776372)

    internal val hasObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "has_object", 77467830)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_width", 373806689)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_width", 1740695150)

    internal val setHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_horizontal_alignment", 2312603777)

    internal val getHorizontalAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_horizontal_alignment", 341400642)

    internal val tabAlignPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "tab_align", 2899603908)

    internal val setFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_flags", 2877345813)

    internal val getFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_flags", 1583363614)

    internal val setTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_text_overrun_behavior", 1008890932)

    internal val getTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_text_overrun_behavior", 3779142101)

    internal val setEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "set_ellipsis_char", 83702148)

    internal val getEllipsisCharPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_ellipsis_char", 201670096)

    internal val getObjectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_objects", 3995934104)

    internal val getObjectRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_object_rect", 1742700391)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_size", 3341600327)

    internal val getRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_rid", 2944877500)

    internal val getLineAscentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_line_ascent", 1740695150)

    internal val getLineDescentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_line_descent", 1740695150)

    internal val getLineWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_line_width", 1740695150)

    internal val getLineUnderlinePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_line_underline_position", 1740695150)

    internal val getLineUnderlineThicknessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "get_line_underline_thickness", 1740695150)

    internal val drawPtr: VoidPtr = TypeManager.getMethodBindPtr("TextLine", "draw", 3625105422)

    internal val drawOutlinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "draw_outline", 2592177763)

    internal val hitTestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextLine", "hit_test", 2401831903)
  }
}
