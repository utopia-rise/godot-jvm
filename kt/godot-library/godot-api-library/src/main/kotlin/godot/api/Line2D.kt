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
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedVector2Array
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This node draws a 2D polyline, i.e. a shape consisting of several points connected by segments.
 * [Line2D] is not a mathematical polyline, i.e. the segments are not infinitely thin. It is intended
 * for rendering and it can be colored and optionally textured.
 *
 * **Warning:** Certain configurations may be impossible to draw nicely, such as very sharp angles.
 * In these situations, the node uses fallback drawing logic to look decent.
 *
 * **Note:** [Line2D] is drawn using a 2D mesh.
 */
@GodotBaseType
public open class Line2D : Node2D() {
  /**
   * The points of the polyline, interpreted in local 2D coordinates. Segments are drawn between the
   * adjacent points in this array.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var points: PackedVector2Array
    @JvmName("pointsProperty")
    get() = getPoints()
    @JvmName("pointsProperty")
    set(`value`) {
      setPoints(value)
    }

  /**
   * If `true` and the polyline has more than 2 points, the last point and the first one will be
   * connected by a segment.
   *
   * **Note:** The shape of the closing segment is not guaranteed to be seamless if a [widthCurve]
   * is provided.
   *
   * **Note:** The joint between the closing segment and the first segment is drawn first and it
   * samples the [gradient] and the [widthCurve] at the beginning. This is an implementation detail
   * that might change in a future version.
   */
  public final inline var closed: Boolean
    @JvmName("closedProperty")
    get() = isClosed()
    @JvmName("closedProperty")
    set(`value`) {
      setClosed(value)
    }

  /**
   * The polyline's width.
   */
  public final inline var width: Float
    @JvmName("widthProperty")
    get() = getWidth()
    @JvmName("widthProperty")
    set(`value`) {
      setWidth(value)
    }

  /**
   * The polyline's width curve. The width of the polyline over its length will be equivalent to the
   * value of the width curve over its domain. The width curve should be a unit [Curve].
   */
  public final inline var widthCurve: Curve?
    @JvmName("widthCurveProperty")
    get() = getCurve()
    @JvmName("widthCurveProperty")
    set(`value`) {
      setCurve(value)
    }

  /**
   * The color of the polyline. Will not be used if a gradient is set.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var defaultColor: Color
    @JvmName("defaultColorProperty")
    get() = getDefaultColor()
    @JvmName("defaultColorProperty")
    set(`value`) {
      setDefaultColor(value)
    }

  /**
   * The gradient is drawn through the whole line from start to finish. The [defaultColor] will not
   * be used if this property is set.
   */
  public final inline var gradient: Gradient?
    @JvmName("gradientProperty")
    get() = getGradient()
    @JvmName("gradientProperty")
    set(`value`) {
      setGradient(value)
    }

  /**
   * The texture used for the polyline. Uses [textureMode] for drawing style.
   */
  public final inline var texture: Texture2D?
    @JvmName("textureProperty")
    get() = getTexture()
    @JvmName("textureProperty")
    set(`value`) {
      setTexture(value)
    }

  /**
   * The style to render the [texture] of the polyline.
   */
  public final inline var textureMode: LineTextureMode
    @JvmName("textureModeProperty")
    get() = getTextureMode()
    @JvmName("textureModeProperty")
    set(`value`) {
      setTextureMode(value)
    }

  /**
   * The style of the connections between segments of the polyline.
   */
  public final inline var jointMode: LineJointMode
    @JvmName("jointModeProperty")
    get() = getJointMode()
    @JvmName("jointModeProperty")
    set(`value`) {
      setJointMode(value)
    }

  /**
   * The style of the beginning of the polyline, if [closed] is `false`.
   */
  public final inline var beginCapMode: LineCapMode
    @JvmName("beginCapModeProperty")
    get() = getBeginCapMode()
    @JvmName("beginCapModeProperty")
    set(`value`) {
      setBeginCapMode(value)
    }

  /**
   * The style of the end of the polyline, if [closed] is `false`.
   */
  public final inline var endCapMode: LineCapMode
    @JvmName("endCapModeProperty")
    get() = getEndCapMode()
    @JvmName("endCapModeProperty")
    set(`value`) {
      setEndCapMode(value)
    }

  /**
   * Determines the miter limit of the polyline. Normally, when [jointMode] is set to
   * [LINE_JOINT_SHARP], sharp angles fall back to using the logic of [LINE_JOINT_BEVEL] joints to
   * prevent very long miters. Higher values of this property mean that the fallback to a bevel joint
   * will happen at sharper angles.
   */
  public final inline var sharpLimit: Float
    @JvmName("sharpLimitProperty")
    get() = getSharpLimit()
    @JvmName("sharpLimitProperty")
    set(`value`) {
      setSharpLimit(value)
    }

  /**
   * The smoothness used for rounded joints and caps. Higher values result in smoother corners, but
   * are more demanding to render and update.
   */
  public final inline var roundPrecision: Int
    @JvmName("roundPrecisionProperty")
    get() = getRoundPrecision()
    @JvmName("roundPrecisionProperty")
    set(`value`) {
      setRoundPrecision(value)
    }

  /**
   * If `true`, the polyline's border will be anti-aliased.
   *
   * **Note:** [Line2D] is not accelerated by batching when being anti-aliased.
   */
  public final inline var antialiased: Boolean
    @JvmName("antialiasedProperty")
    get() = getAntialiased()
    @JvmName("antialiasedProperty")
    set(`value`) {
      setAntialiased(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(362, scriptPtr)
  }

  /**
   * This is a helper function for [points] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = line2d.points
   * //Your changes
   * line2d.points = myCoreType
   * ``````
   *
   * The points of the polyline, interpreted in local 2D coordinates. Segments are drawn between the
   * adjacent points in this array.
   */
  @CoreTypeHelper
  public final fun pointsMutate(block: PackedVector2Array.() -> Unit): PackedVector2Array =
      points.apply {
     block(this)
     points = this
  }

  /**
   * This is a helper function for [points] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The points of the polyline, interpreted in local 2D coordinates. Segments are drawn between the
   * adjacent points in this array.
   */
  @CoreTypeHelper
  public final fun pointsMutateEach(block: (index: Int, `value`: Vector2) -> Unit):
      PackedVector2Array = points.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     points = this
  }

  /**
   * This is a helper function for [defaultColor] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = line2d.defaultColor
   * //Your changes
   * line2d.defaultColor = myCoreType
   * ``````
   *
   * The color of the polyline. Will not be used if a gradient is set.
   */
  @CoreTypeHelper
  public final fun defaultColorMutate(block: Color.() -> Unit): Color = defaultColor.apply {
     block(this)
     defaultColor = this
  }

  public final fun setPoints(points: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points)
    TransferContext.callMethod(MethodBindings.setPointsPtr)
  }

  public final fun getPoints(): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Overwrites the position of the point at the given [index] with the supplied [position].
   */
  public final fun setPointPosition(index: Int, position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.setPointPositionPtr)
  }

  /**
   * Returns the position of the point at index [index].
   */
  public final fun getPointPosition(index: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getPointPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the number of points in the polyline.
   */
  public final fun getPointCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds a point with the specified [position] relative to the polyline's own position. If no
   * [index] is provided, the new point will be added to the end of the points array.
   *
   * If [index] is given, the new point is inserted before the existing point identified by index
   * [index]. The indices of the points after the new point get increased by 1. The provided [index]
   * must not exceed the number of existing points in the polyline. See [getPointCount].
   */
  @JvmOverloads
  public final fun addPoint(position: Vector2, index: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.addPointPtr)
  }

  /**
   * Removes the point at index [index] from the polyline.
   */
  public final fun removePoint(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removePointPtr)
  }

  /**
   * Removes all points from the polyline, making it empty.
   */
  public final fun clearPoints(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPointsPtr)
  }

  public final fun setClosed(closed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to closed)
    TransferContext.callMethod(MethodBindings.setClosedPtr)
  }

  public final fun isClosed(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isClosedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setWidth(width: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to width.toDouble())
    TransferContext.callMethod(MethodBindings.setWidthPtr)
  }

  public final fun getWidth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWidthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setCurve(curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setCurvePtr)
  }

  public final fun getCurve(): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  public final fun setDefaultColor(color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, COLOR to color)
    TransferContext.callMethod(MethodBindings.setDefaultColorPtr)
  }

  public final fun getDefaultColor(): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDefaultColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  public final fun setGradient(color: Gradient?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to color)
    TransferContext.callMethod(MethodBindings.setGradientPtr)
  }

  public final fun getGradient(): Gradient? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGradientPtr)
    return (TransferContext.readReturnValue(OBJECT) as Gradient?)
  }

  public final fun setTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setTexturePtr)
  }

  public final fun getTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  public final fun setTextureMode(mode: LineTextureMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setTextureModePtr)
  }

  public final fun getTextureMode(): LineTextureMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextureModePtr)
    return LineTextureMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setJointMode(mode: LineJointMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setJointModePtr)
  }

  public final fun getJointMode(): LineJointMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getJointModePtr)
    return LineJointMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setBeginCapMode(mode: LineCapMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setBeginCapModePtr)
  }

  public final fun getBeginCapMode(): LineCapMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBeginCapModePtr)
    return LineCapMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setEndCapMode(mode: LineCapMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setEndCapModePtr)
  }

  public final fun getEndCapMode(): LineCapMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEndCapModePtr)
    return LineCapMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSharpLimit(limit: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to limit.toDouble())
    TransferContext.callMethod(MethodBindings.setSharpLimitPtr)
  }

  public final fun getSharpLimit(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSharpLimitPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRoundPrecision(precision: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to precision.toLong())
    TransferContext.callMethod(MethodBindings.setRoundPrecisionPtr)
  }

  public final fun getRoundPrecision(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRoundPrecisionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setAntialiased(antialiased: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to antialiased)
    TransferContext.callMethod(MethodBindings.setAntialiasedPtr)
  }

  public final fun getAntialiased(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAntialiasedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public enum class LineJointMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Makes the polyline's joints pointy, connecting the sides of the two segments by extending
     * them until they intersect. If the rotation of a joint is too big (based on [sharpLimit]), the
     * joint falls back to [LINE_JOINT_BEVEL] to prevent very long miters.
     */
    SHARP(0),
    /**
     * Makes the polyline's joints bevelled/chamfered, connecting the sides of the two segments with
     * a simple line.
     */
    BEVEL(1),
    /**
     * Makes the polyline's joints rounded, connecting the sides of the two segments with an arc.
     * The detail of this arc depends on [roundPrecision].
     */
    ROUND(2),
    ;

    public companion object {
      public fun from(`value`: Long): LineJointMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LineCapMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Draws no line cap.
     */
    NONE(0),
    /**
     * Draws the line cap as a box, slightly extending the first/last segment.
     */
    BOX(1),
    /**
     * Draws the line cap as a semicircle attached to the first/last segment.
     */
    ROUND(2),
    ;

    public companion object {
      public fun from(`value`: Long): LineCapMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class LineTextureMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Takes the left pixels of the texture and renders them over the whole polyline.
     */
    NONE(0),
    /**
     * Tiles the texture over the polyline. [CanvasItem.textureRepeat] of the [Line2D] node must be
     * [CanvasItem.TEXTURE_REPEAT_ENABLED] or [CanvasItem.TEXTURE_REPEAT_MIRROR] for it to work
     * properly.
     */
    TILE(1),
    /**
     * Stretches the texture across the polyline. [CanvasItem.textureRepeat] of the [Line2D] node
     * must be [CanvasItem.TEXTURE_REPEAT_DISABLED] for best results.
     */
    STRETCH(2),
    ;

    public companion object {
      public fun from(`value`: Long): LineTextureMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setPointsName: MethodStringName1<Line2D, Unit, PackedVector2Array> =
        MethodStringName1<Line2D, Unit, PackedVector2Array>("set_points")

    @JvmField
    public val getPointsName: MethodStringName0<Line2D, PackedVector2Array> =
        MethodStringName0<Line2D, PackedVector2Array>("get_points")

    @JvmField
    public val setPointPositionName: MethodStringName2<Line2D, Unit, Int, Vector2> =
        MethodStringName2<Line2D, Unit, Int, Vector2>("set_point_position")

    @JvmField
    public val getPointPositionName: MethodStringName1<Line2D, Vector2, Int> =
        MethodStringName1<Line2D, Vector2, Int>("get_point_position")

    @JvmField
    public val getPointCountName: MethodStringName0<Line2D, Int> =
        MethodStringName0<Line2D, Int>("get_point_count")

    @JvmField
    public val addPointName: MethodStringName2<Line2D, Unit, Vector2, Int> =
        MethodStringName2<Line2D, Unit, Vector2, Int>("add_point")

    @JvmField
    public val removePointName: MethodStringName1<Line2D, Unit, Int> =
        MethodStringName1<Line2D, Unit, Int>("remove_point")

    @JvmField
    public val clearPointsName: MethodStringName0<Line2D, Unit> =
        MethodStringName0<Line2D, Unit>("clear_points")

    @JvmField
    public val setClosedName: MethodStringName1<Line2D, Unit, Boolean> =
        MethodStringName1<Line2D, Unit, Boolean>("set_closed")

    @JvmField
    public val isClosedName: MethodStringName0<Line2D, Boolean> =
        MethodStringName0<Line2D, Boolean>("is_closed")

    @JvmField
    public val setWidthName: MethodStringName1<Line2D, Unit, Float> =
        MethodStringName1<Line2D, Unit, Float>("set_width")

    @JvmField
    public val getWidthName: MethodStringName0<Line2D, Float> =
        MethodStringName0<Line2D, Float>("get_width")

    @JvmField
    public val setCurveName: MethodStringName1<Line2D, Unit, Curve?> =
        MethodStringName1<Line2D, Unit, Curve?>("set_curve")

    @JvmField
    public val getCurveName: MethodStringName0<Line2D, Curve?> =
        MethodStringName0<Line2D, Curve?>("get_curve")

    @JvmField
    public val setDefaultColorName: MethodStringName1<Line2D, Unit, Color> =
        MethodStringName1<Line2D, Unit, Color>("set_default_color")

    @JvmField
    public val getDefaultColorName: MethodStringName0<Line2D, Color> =
        MethodStringName0<Line2D, Color>("get_default_color")

    @JvmField
    public val setGradientName: MethodStringName1<Line2D, Unit, Gradient?> =
        MethodStringName1<Line2D, Unit, Gradient?>("set_gradient")

    @JvmField
    public val getGradientName: MethodStringName0<Line2D, Gradient?> =
        MethodStringName0<Line2D, Gradient?>("get_gradient")

    @JvmField
    public val setTextureName: MethodStringName1<Line2D, Unit, Texture2D?> =
        MethodStringName1<Line2D, Unit, Texture2D?>("set_texture")

    @JvmField
    public val getTextureName: MethodStringName0<Line2D, Texture2D?> =
        MethodStringName0<Line2D, Texture2D?>("get_texture")

    @JvmField
    public val setTextureModeName: MethodStringName1<Line2D, Unit, LineTextureMode> =
        MethodStringName1<Line2D, Unit, LineTextureMode>("set_texture_mode")

    @JvmField
    public val getTextureModeName: MethodStringName0<Line2D, LineTextureMode> =
        MethodStringName0<Line2D, LineTextureMode>("get_texture_mode")

    @JvmField
    public val setJointModeName: MethodStringName1<Line2D, Unit, LineJointMode> =
        MethodStringName1<Line2D, Unit, LineJointMode>("set_joint_mode")

    @JvmField
    public val getJointModeName: MethodStringName0<Line2D, LineJointMode> =
        MethodStringName0<Line2D, LineJointMode>("get_joint_mode")

    @JvmField
    public val setBeginCapModeName: MethodStringName1<Line2D, Unit, LineCapMode> =
        MethodStringName1<Line2D, Unit, LineCapMode>("set_begin_cap_mode")

    @JvmField
    public val getBeginCapModeName: MethodStringName0<Line2D, LineCapMode> =
        MethodStringName0<Line2D, LineCapMode>("get_begin_cap_mode")

    @JvmField
    public val setEndCapModeName: MethodStringName1<Line2D, Unit, LineCapMode> =
        MethodStringName1<Line2D, Unit, LineCapMode>("set_end_cap_mode")

    @JvmField
    public val getEndCapModeName: MethodStringName0<Line2D, LineCapMode> =
        MethodStringName0<Line2D, LineCapMode>("get_end_cap_mode")

    @JvmField
    public val setSharpLimitName: MethodStringName1<Line2D, Unit, Float> =
        MethodStringName1<Line2D, Unit, Float>("set_sharp_limit")

    @JvmField
    public val getSharpLimitName: MethodStringName0<Line2D, Float> =
        MethodStringName0<Line2D, Float>("get_sharp_limit")

    @JvmField
    public val setRoundPrecisionName: MethodStringName1<Line2D, Unit, Int> =
        MethodStringName1<Line2D, Unit, Int>("set_round_precision")

    @JvmField
    public val getRoundPrecisionName: MethodStringName0<Line2D, Int> =
        MethodStringName0<Line2D, Int>("get_round_precision")

    @JvmField
    public val setAntialiasedName: MethodStringName1<Line2D, Unit, Boolean> =
        MethodStringName1<Line2D, Unit, Boolean>("set_antialiased")

    @JvmField
    public val getAntialiasedName: MethodStringName0<Line2D, Boolean> =
        MethodStringName0<Line2D, Boolean>("get_antialiased")
  }

  public object MethodBindings {
    internal val setPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_points", 1509147220)

    internal val getPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_points", 2961356807)

    internal val setPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_point_position", 163021252)

    internal val getPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_point_position", 2299179447)

    internal val getPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_point_count", 3905245786)

    internal val addPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "add_point", 2654014372)

    internal val removePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "remove_point", 1286410249)

    internal val clearPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "clear_points", 3218959716)

    internal val setClosedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_closed", 2586408642)

    internal val isClosedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "is_closed", 36873697)

    internal val setWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_width", 373806689)

    internal val getWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_width", 1740695150)

    internal val setCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_curve", 270443179)

    internal val getCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_curve", 2460114913)

    internal val setDefaultColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_default_color", 2920490490)

    internal val getDefaultColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_default_color", 3444240500)

    internal val setGradientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_gradient", 2756054477)

    internal val getGradientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_gradient", 132272999)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_texture", 4051416890)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_texture", 3635182373)

    internal val setTextureModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_texture_mode", 1952559516)

    internal val getTextureModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_texture_mode", 2341040722)

    internal val setJointModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_joint_mode", 604292979)

    internal val getJointModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_joint_mode", 2546544037)

    internal val setBeginCapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_begin_cap_mode", 1669024546)

    internal val getBeginCapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_begin_cap_mode", 1107511441)

    internal val setEndCapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_end_cap_mode", 1669024546)

    internal val getEndCapModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_end_cap_mode", 1107511441)

    internal val setSharpLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_sharp_limit", 373806689)

    internal val getSharpLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_sharp_limit", 1740695150)

    internal val setRoundPrecisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_round_precision", 1286410249)

    internal val getRoundPrecisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_round_precision", 3905245786)

    internal val setAntialiasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "set_antialiased", 2586408642)

    internal val getAntialiasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Line2D", "get_antialiased", 36873697)
  }
}
