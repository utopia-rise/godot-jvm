// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_ANY_VECTOR2_LONG_DOUBLE_ret_BOOL
import godot.callMethod_ANY_VECTOR2_LONG_LONG_DOUBLE_ret_BOOL
import godot.callMethod_ANY_ret_BOOL
import godot.callMethod_ANY_ret_RECT2
import godot.callMethod_STRING
import godot.callMethod_STRING_OBJECT_LONG_STRING_ANY_ret_BOOL
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_RID
import godot.callPtrMethod0_ret_VECTOR2
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_DOUBLE_ret_LONG
import godot.callPtrMethod_LONG
import godot.callPtrMethod_PACKED_FLOAT_32_ARRAY
import godot.callPtrMethod_RID_VECTOR2_COLOR_DOUBLE
import godot.callPtrMethod_RID_VECTOR2_LONG_COLOR_DOUBLE
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
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  /**
   * Duplicates this [TextLine].
   */
  public final fun duplicate(): TextLine? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.duplicatePtr) as TextLine?)

  public final fun setDirection(direction: TextServer.Direction): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setDirectionPtr, direction.value)
  }

  public final fun getDirection(): TextServer.Direction =
      TextServer.Direction.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDirectionPtr))

  /**
   * Returns the text writing direction inferred by the BiDi algorithm.
   */
  public final fun getInferredDirection(): TextServer.Direction =
      TextServer.Direction.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInferredDirectionPtr))

  public final fun setOrientation(orientation: TextServer.Orientation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOrientationPtr, orientation.value)
  }

  public final fun getOrientation(): TextServer.Orientation =
      TextServer.Orientation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOrientationPtr))

  public final fun setPreserveInvalid(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setPreserveInvalidPtr, enabled)
  }

  public final fun getPreserveInvalid(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getPreserveInvalidPtr)

  public final fun setPreserveControl(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setPreserveControlPtr, enabled)
  }

  public final fun getPreserveControl(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getPreserveControlPtr)

  /**
   * Overrides BiDi for the structured text.
   *
   * Override ranges should cover full source text without overlaps. BiDi algorithm will be used on
   * each range separately.
   */
  public final fun setBidiOverride(`override`: VariantArray<Any?>): Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setBidiOverridePtr, override)
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
  ): Boolean =
      TransferContext.callMethod_STRING_OBJECT_LONG_STRING_ANY_ret_BOOL(ptr, objectID.id, MethodBindings.addStringPtr, text, font, fontSize.toLong(), language, meta)

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
  ): Boolean =
      TransferContext.callMethod_ANY_VECTOR2_LONG_LONG_DOUBLE_ret_BOOL(ptr, objectID.id, MethodBindings.addObjectPtr, key, size, inlineAlign.value, length.toLong(), baseline.toDouble())

  /**
   * Sets new size and alignment of embedded object.
   */
  @JvmOverloads
  public final fun resizeObject(
    key: Any?,
    size: Vector2,
    inlineAlign: InlineAlignment = InlineAlignment.CENTER,
    baseline: Float = 0.0f,
  ): Boolean =
      TransferContext.callMethod_ANY_VECTOR2_LONG_DOUBLE_ret_BOOL(ptr, objectID.id, MethodBindings.resizeObjectPtr, key, size, inlineAlign.value, baseline.toDouble())

  /**
   * Returns `true` if an object with [key] is embedded in this line.
   */
  public final fun hasObject(key: Any?): Boolean =
      TransferContext.callMethod_ANY_ret_BOOL(ptr, objectID.id, MethodBindings.hasObjectPtr, key)

  public final fun setWidth(width: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setWidthPtr, width.toDouble())
  }

  public final fun getWidth(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getWidthPtr).toFloat()

  public final fun setHorizontalAlignment(alignment: HorizontalAlignment): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setHorizontalAlignmentPtr, alignment.value)
  }

  public final fun getHorizontalAlignment(): HorizontalAlignment =
      HorizontalAlignment.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getHorizontalAlignmentPtr))

  /**
   * Aligns text to the given tab-stops.
   */
  public final fun tabAlign(tabStops: PackedFloat32Array): Unit {
    TransferContext.callPtrMethod_PACKED_FLOAT_32_ARRAY(ptr, objectID.id, MethodBindings.tabAlignPtr, tabStops)
  }

  public final fun setFlags(flags: TextServer.JustificationFlag): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setFlagsPtr, flags.flag)
  }

  public final fun getFlags(): TextServer.JustificationFlag =
      TextServer.JustificationFlag(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getFlagsPtr))

  public final fun setTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setTextOverrunBehaviorPtr, overrunBehavior.value)
  }

  public final fun getTextOverrunBehavior(): TextServer.OverrunBehavior =
      TextServer.OverrunBehavior.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getTextOverrunBehaviorPtr))

  public final fun setEllipsisChar(char: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setEllipsisCharPtr, char)
  }

  public final fun getEllipsisChar(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getEllipsisCharPtr)

  /**
   * Returns array of inline objects.
   */
  public final fun getObjects(): VariantArray<Any?> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getObjectsPtr) as VariantArray<Any?>)

  /**
   * Returns bounding rectangle of the inline object.
   */
  public final fun getObjectRect(key: Any?): Rect2 =
      TransferContext.callMethod_ANY_ret_RECT2(ptr, objectID.id, MethodBindings.getObjectRectPtr, key)

  /**
   * Returns size of the bounding box of the text.
   */
  public final fun getSize(): Vector2 =
      TransferContext.callPtrMethod0_ret_VECTOR2(ptr, objectID.id, MethodBindings.getSizePtr)

  /**
   * Returns TextServer buffer RID.
   */
  public final fun getRid(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getRidPtr)

  /**
   * Returns the text ascent (number of pixels above the baseline for horizontal layout or to the
   * left of baseline for vertical).
   */
  public final fun getLineAscent(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLineAscentPtr).toFloat()

  /**
   * Returns the text descent (number of pixels below the baseline for horizontal layout or to the
   * right of baseline for vertical).
   */
  public final fun getLineDescent(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLineDescentPtr).toFloat()

  /**
   * Returns width (for horizontal layout) or height (for vertical) of the text.
   */
  public final fun getLineWidth(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLineWidthPtr).toFloat()

  /**
   * Returns pixel offset of the underline below the baseline.
   */
  public final fun getLineUnderlinePosition(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLineUnderlinePositionPtr).toFloat()

  /**
   * Returns thickness of the underline.
   */
  public final fun getLineUnderlineThickness(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getLineUnderlineThicknessPtr).toFloat()

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
    TransferContext.callPtrMethod_RID_VECTOR2_COLOR_DOUBLE(ptr, objectID.id, MethodBindings.drawPtr, canvas, pos, color, oversampling.toDouble())
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
    TransferContext.callPtrMethod_RID_VECTOR2_LONG_COLOR_DOUBLE(ptr, objectID.id, MethodBindings.drawOutlinePtr, canvas, pos, outlineSize.toLong(), color, oversampling.toDouble())
  }

  /**
   * Returns caret character offset at the specified pixel offset at the baseline. This function
   * always returns a valid position.
   */
  public final fun hitTest(coords: Float): Int =
      TransferContext.callPtrMethod_DOUBLE_ret_LONG(ptr, objectID.id, MethodBindings.hitTestPtr, coords.toDouble()).toInt()

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
