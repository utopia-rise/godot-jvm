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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName5
import godot.core.Signal0
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
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
 * This resource describes a mathematical curve by defining a set of points and tangents at each
 * point. By default, it ranges between `0` and `1` on the X and Y axes, but these ranges can be
 * changed.
 *
 * Please note that many resources and nodes assume they are given *unit curves*. A unit curve is a
 * curve whose domain (the X axis) is between `0` and `1`. Some examples of unit curve usage are
 * [CPUParticles2D.angleCurve] and [Line2D.widthCurve].
 */
@GodotBaseType
public open class Curve : Resource() {
  /**
   * Emitted when [maxValue] or [minValue] is changed.
   */
  public val rangeChanged: Signal0 by Signal0

  /**
   * Emitted when [maxDomain] or [minDomain] is changed.
   */
  public val domainChanged: Signal0 by Signal0

  /**
   * The minimum domain (x-coordinate) that points can have.
   */
  public final inline var minDomain: Float
    @JvmName("minDomainProperty")
    get() = getMinDomain()
    @JvmName("minDomainProperty")
    set(`value`) {
      setMinDomain(value)
    }

  /**
   * The maximum domain (x-coordinate) that points can have.
   */
  public final inline var maxDomain: Float
    @JvmName("maxDomainProperty")
    get() = getMaxDomain()
    @JvmName("maxDomainProperty")
    set(`value`) {
      setMaxDomain(value)
    }

  /**
   * The minimum value (y-coordinate) that points can have. Tangents can cause lower values between
   * points.
   */
  public final inline var minValue: Float
    @JvmName("minValueProperty")
    get() = getMinValue()
    @JvmName("minValueProperty")
    set(`value`) {
      setMinValue(value)
    }

  /**
   * The maximum value (y-coordinate) that points can have. Tangents can cause higher values between
   * points.
   */
  public final inline var maxValue: Float
    @JvmName("maxValueProperty")
    get() = getMaxValue()
    @JvmName("maxValueProperty")
    set(`value`) {
      setMaxValue(value)
    }

  /**
   * The number of points to include in the baked (i.e. cached) curve data.
   */
  public final inline var bakeResolution: Int
    @JvmName("bakeResolutionProperty")
    get() = getBakeResolution()
    @JvmName("bakeResolutionProperty")
    set(`value`) {
      setBakeResolution(value)
    }

  /**
   * The number of points describing the curve.
   */
  public final inline var pointCount: Int
    @JvmName("pointCountProperty")
    get() = getPointCount()
    @JvmName("pointCountProperty")
    set(`value`) {
      setPointCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(194, scriptPtr)
  }

  public final fun getPointCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setPointCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setPointCountPtr)
  }

  /**
   * Adds a point to the curve. For each side, if the `*_mode` is [TANGENT_LINEAR], the `*_tangent`
   * angle (in degrees) uses the slope of the curve halfway to the adjacent point. Allows custom
   * assignments to the `*_tangent` angle if `*_mode` is set to [TANGENT_FREE].
   */
  @JvmOverloads
  public final fun addPoint(
    position: Vector2,
    leftTangent: Float = 0.0f,
    rightTangent: Float = 0.0f,
    leftMode: TangentMode = Curve.TangentMode.FREE,
    rightMode: TangentMode = Curve.TangentMode.FREE,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, DOUBLE to leftTangent.toDouble(), DOUBLE to rightTangent.toDouble(), LONG to leftMode.value, LONG to rightMode.value)
    TransferContext.callMethod(MethodBindings.addPointPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes the point at [index] from the curve.
   */
  public final fun removePoint(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removePointPtr)
  }

  /**
   * Removes all points from the curve.
   */
  public final fun clearPoints(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPointsPtr)
  }

  /**
   * Returns the curve coordinates for the point at [index].
   */
  public final fun getPointPosition(index: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getPointPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Assigns the vertical position [y] to the point at [index].
   */
  public final fun setPointValue(index: Int, y: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to y.toDouble())
    TransferContext.callMethod(MethodBindings.setPointValuePtr)
  }

  /**
   * Assigns the horizontal position [offset] to the point at [index].
   */
  public final fun setPointOffset(index: Int, offset: Float): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.setPointOffsetPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the Y value for the point that would exist at the X position [offset] along the curve.
   */
  public final fun sample(offset: Float): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.samplePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the Y value for the point that would exist at the X position [offset] along the curve
   * using the baked cache. Bakes the curve's points if not already baked.
   */
  public final fun sampleBaked(offset: Float): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to offset.toDouble())
    TransferContext.callMethod(MethodBindings.sampleBakedPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the left tangent angle (in degrees) for the point at [index].
   */
  public final fun getPointLeftTangent(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getPointLeftTangentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the right tangent angle (in degrees) for the point at [index].
   */
  public final fun getPointRightTangent(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getPointRightTangentPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the left [TangentMode] for the point at [index].
   */
  public final fun getPointLeftMode(index: Int): TangentMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getPointLeftModePtr)
    return TangentMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the right [TangentMode] for the point at [index].
   */
  public final fun getPointRightMode(index: Int): TangentMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getPointRightModePtr)
    return TangentMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the left tangent angle for the point at [index] to [tangent].
   */
  public final fun setPointLeftTangent(index: Int, tangent: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to tangent.toDouble())
    TransferContext.callMethod(MethodBindings.setPointLeftTangentPtr)
  }

  /**
   * Sets the right tangent angle for the point at [index] to [tangent].
   */
  public final fun setPointRightTangent(index: Int, tangent: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to tangent.toDouble())
    TransferContext.callMethod(MethodBindings.setPointRightTangentPtr)
  }

  /**
   * Sets the left [TangentMode] for the point at [index] to [mode].
   */
  public final fun setPointLeftMode(index: Int, mode: TangentMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setPointLeftModePtr)
  }

  /**
   * Sets the right [TangentMode] for the point at [index] to [mode].
   */
  public final fun setPointRightMode(index: Int, mode: TangentMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setPointRightModePtr)
  }

  public final fun getMinValue(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinValuePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMinValue(min: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to min.toDouble())
    TransferContext.callMethod(MethodBindings.setMinValuePtr)
  }

  public final fun getMaxValue(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxValuePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMaxValue(max: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to max.toDouble())
    TransferContext.callMethod(MethodBindings.setMaxValuePtr)
  }

  /**
   * Returns the difference between [minValue] and [maxValue].
   */
  public final fun getValueRange(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getValueRangePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun getMinDomain(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinDomainPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMinDomain(min: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to min.toDouble())
    TransferContext.callMethod(MethodBindings.setMinDomainPtr)
  }

  public final fun getMaxDomain(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxDomainPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMaxDomain(max: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to max.toDouble())
    TransferContext.callMethod(MethodBindings.setMaxDomainPtr)
  }

  /**
   * Returns the difference between [minDomain] and [maxDomain].
   */
  public final fun getDomainRange(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDomainRangePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Removes duplicate points, i.e. points that are less than 0.00001 units (engine epsilon value)
   * away from their neighbor on the curve.
   */
  public final fun cleanDupes(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.cleanDupesPtr)
  }

  /**
   * Recomputes the baked cache of points for the curve.
   */
  public final fun bake(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.bakePtr)
  }

  public final fun getBakeResolution(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakeResolutionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setBakeResolution(resolution: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to resolution.toLong())
    TransferContext.callMethod(MethodBindings.setBakeResolutionPtr)
  }

  public enum class TangentMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The tangent on this side of the point is user-defined.
     */
    FREE(0),
    /**
     * The curve calculates the tangent on this side of the point as the slope halfway towards the
     * adjacent point.
     */
    LINEAR(1),
    /**
     * The total number of available tangent modes.
     */
    COUNT(2),
    ;

    public companion object {
      public fun from(`value`: Long): TangentMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getPointCountName: MethodStringName0<Curve, Int> =
        MethodStringName0<Curve, Int>("get_point_count")

    @JvmField
    public val setPointCountName: MethodStringName1<Curve, Unit, Int> =
        MethodStringName1<Curve, Unit, Int>("set_point_count")

    @JvmField
    public val addPointName:
        MethodStringName5<Curve, Int, Vector2, Float, Float, TangentMode, TangentMode> =
        MethodStringName5<Curve, Int, Vector2, Float, Float, TangentMode, TangentMode>("add_point")

    @JvmField
    public val removePointName: MethodStringName1<Curve, Unit, Int> =
        MethodStringName1<Curve, Unit, Int>("remove_point")

    @JvmField
    public val clearPointsName: MethodStringName0<Curve, Unit> =
        MethodStringName0<Curve, Unit>("clear_points")

    @JvmField
    public val getPointPositionName: MethodStringName1<Curve, Vector2, Int> =
        MethodStringName1<Curve, Vector2, Int>("get_point_position")

    @JvmField
    public val setPointValueName: MethodStringName2<Curve, Unit, Int, Float> =
        MethodStringName2<Curve, Unit, Int, Float>("set_point_value")

    @JvmField
    public val setPointOffsetName: MethodStringName2<Curve, Int, Int, Float> =
        MethodStringName2<Curve, Int, Int, Float>("set_point_offset")

    @JvmField
    public val sampleName: MethodStringName1<Curve, Float, Float> =
        MethodStringName1<Curve, Float, Float>("sample")

    @JvmField
    public val sampleBakedName: MethodStringName1<Curve, Float, Float> =
        MethodStringName1<Curve, Float, Float>("sample_baked")

    @JvmField
    public val getPointLeftTangentName: MethodStringName1<Curve, Float, Int> =
        MethodStringName1<Curve, Float, Int>("get_point_left_tangent")

    @JvmField
    public val getPointRightTangentName: MethodStringName1<Curve, Float, Int> =
        MethodStringName1<Curve, Float, Int>("get_point_right_tangent")

    @JvmField
    public val getPointLeftModeName: MethodStringName1<Curve, TangentMode, Int> =
        MethodStringName1<Curve, TangentMode, Int>("get_point_left_mode")

    @JvmField
    public val getPointRightModeName: MethodStringName1<Curve, TangentMode, Int> =
        MethodStringName1<Curve, TangentMode, Int>("get_point_right_mode")

    @JvmField
    public val setPointLeftTangentName: MethodStringName2<Curve, Unit, Int, Float> =
        MethodStringName2<Curve, Unit, Int, Float>("set_point_left_tangent")

    @JvmField
    public val setPointRightTangentName: MethodStringName2<Curve, Unit, Int, Float> =
        MethodStringName2<Curve, Unit, Int, Float>("set_point_right_tangent")

    @JvmField
    public val setPointLeftModeName: MethodStringName2<Curve, Unit, Int, TangentMode> =
        MethodStringName2<Curve, Unit, Int, TangentMode>("set_point_left_mode")

    @JvmField
    public val setPointRightModeName: MethodStringName2<Curve, Unit, Int, TangentMode> =
        MethodStringName2<Curve, Unit, Int, TangentMode>("set_point_right_mode")

    @JvmField
    public val getMinValueName: MethodStringName0<Curve, Float> =
        MethodStringName0<Curve, Float>("get_min_value")

    @JvmField
    public val setMinValueName: MethodStringName1<Curve, Unit, Float> =
        MethodStringName1<Curve, Unit, Float>("set_min_value")

    @JvmField
    public val getMaxValueName: MethodStringName0<Curve, Float> =
        MethodStringName0<Curve, Float>("get_max_value")

    @JvmField
    public val setMaxValueName: MethodStringName1<Curve, Unit, Float> =
        MethodStringName1<Curve, Unit, Float>("set_max_value")

    @JvmField
    public val getValueRangeName: MethodStringName0<Curve, Float> =
        MethodStringName0<Curve, Float>("get_value_range")

    @JvmField
    public val getMinDomainName: MethodStringName0<Curve, Float> =
        MethodStringName0<Curve, Float>("get_min_domain")

    @JvmField
    public val setMinDomainName: MethodStringName1<Curve, Unit, Float> =
        MethodStringName1<Curve, Unit, Float>("set_min_domain")

    @JvmField
    public val getMaxDomainName: MethodStringName0<Curve, Float> =
        MethodStringName0<Curve, Float>("get_max_domain")

    @JvmField
    public val setMaxDomainName: MethodStringName1<Curve, Unit, Float> =
        MethodStringName1<Curve, Unit, Float>("set_max_domain")

    @JvmField
    public val getDomainRangeName: MethodStringName0<Curve, Float> =
        MethodStringName0<Curve, Float>("get_domain_range")

    @JvmField
    public val cleanDupesName: MethodStringName0<Curve, Unit> =
        MethodStringName0<Curve, Unit>("clean_dupes")

    @JvmField
    public val bakeName: MethodStringName0<Curve, Unit> = MethodStringName0<Curve, Unit>("bake")

    @JvmField
    public val getBakeResolutionName: MethodStringName0<Curve, Int> =
        MethodStringName0<Curve, Int>("get_bake_resolution")

    @JvmField
    public val setBakeResolutionName: MethodStringName1<Curve, Unit, Int> =
        MethodStringName1<Curve, Unit, Int>("set_bake_resolution")
  }

  public object MethodBindings {
    internal val getPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_point_count", 3905245786)

    internal val setPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_point_count", 1286410249)

    internal val addPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "add_point", 434072736)

    internal val removePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "remove_point", 1286410249)

    internal val clearPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "clear_points", 3218959716)

    internal val getPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_point_position", 2299179447)

    internal val setPointValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_point_value", 1602489585)

    internal val setPointOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_point_offset", 3780573764)

    internal val samplePtr: VoidPtr = TypeManager.getMethodBindPtr("Curve", "sample", 3919130443)

    internal val sampleBakedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "sample_baked", 3919130443)

    internal val getPointLeftTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_point_left_tangent", 2339986948)

    internal val getPointRightTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_point_right_tangent", 2339986948)

    internal val getPointLeftModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_point_left_mode", 426950354)

    internal val getPointRightModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_point_right_mode", 426950354)

    internal val setPointLeftTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_point_left_tangent", 1602489585)

    internal val setPointRightTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_point_right_tangent", 1602489585)

    internal val setPointLeftModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_point_left_mode", 1217242874)

    internal val setPointRightModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_point_right_mode", 1217242874)

    internal val getMinValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_min_value", 1740695150)

    internal val setMinValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_min_value", 373806689)

    internal val getMaxValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_max_value", 1740695150)

    internal val setMaxValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_max_value", 373806689)

    internal val getValueRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_value_range", 1740695150)

    internal val getMinDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_min_domain", 1740695150)

    internal val setMinDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_min_domain", 373806689)

    internal val getMaxDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_max_domain", 1740695150)

    internal val setMaxDomainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_max_domain", 373806689)

    internal val getDomainRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_domain_range", 1740695150)

    internal val cleanDupesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "clean_dupes", 3218959716)

    internal val bakePtr: VoidPtr = TypeManager.getMethodBindPtr("Curve", "bake", 3218959716)

    internal val getBakeResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "get_bake_resolution", 3905245786)

    internal val setBakeResolutionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve", "set_bake_resolution", 1286410249)
  }
}
