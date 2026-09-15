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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.PackedVector2Array
import godot.core.Transform2D
import godot.core.Vector2
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_VECTOR2_ARRAY
import godot.readReturnValue_TRANSFORM2D
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_DOUBLE_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_VECTOR2
import godot.writeMethodArguments_VECTOR2
import godot.writeMethodArguments_VECTOR2_VECTOR2_VECTOR2_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This class describes a Bézier curve in 2D space. It is mainly used to give a shape to a [Path2D],
 * but can be manually sampled for other purposes.
 *
 * It keeps a cache of precalculated points along the curve, to speed up further calculations.
 */
@GodotBaseType
public open class Curve2D : Resource() {
  /**
   * The distance in pixels between two adjacent cached points. Changing it forces the cache to be
   * recomputed the next time the [getBakedPoints] or [getBakedLength] function is called. The smaller
   * the distance, the more points in the cache and the more memory it will consume, so use with care.
   */
  public final inline var bakeInterval: Float
    @JvmName("bakeIntervalProperty")
    get() = getBakeInterval()
    @JvmName("bakeIntervalProperty")
    set(`value`) {
      setBakeInterval(value)
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
    createNativeObject(195, scriptPtr)
  }

  public final fun getPointCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPointCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setPointCount(count: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, count.toLong())
    TransferContext.callPtrMethod(MethodBindings.setPointCountPtr, 0)
  }

  /**
   * Adds a point with the specified [position] relative to the curve's own position, with control
   * points [in] and [out]. Appends the new point at the end of the point list.
   *
   * If [index] is given, the new point is inserted before the existing point identified by index
   * [index]. Every existing point starting from [index] is shifted further down the list of points.
   * The index must be greater than or equal to `0` and must not exceed the number of existing points
   * in the line. See [pointCount].
   */
  @JvmOverloads
  public final fun addPoint(
    position: Vector2,
    `in`: Vector2 = Vector2(0, 0),
    `out`: Vector2 = Vector2(0, 0),
    index: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments_VECTOR2_VECTOR2_VECTOR2_LONG(ptr, objectID.id, position, `in`, out, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.addPointPtr, 0)
  }

  /**
   * Sets the position for the vertex [idx]. If the index is out of bounds, the function sends an
   * error to the console.
   */
  public final fun setPointPosition(idx: Int, position: Vector2): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR2(ptr, objectID.id, idx.toLong(), position)
    TransferContext.callPtrMethod(MethodBindings.setPointPositionPtr, 0)
  }

  /**
   * Returns the position of the vertex [idx]. If the index is out of bounds, the function sends an
   * error to the console, and returns `(0, 0)`.
   */
  public final fun getPointPosition(idx: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPointPositionPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Sets the position of the control point leading to the vertex [idx]. If the index is out of
   * bounds, the function sends an error to the console. The position is relative to the vertex.
   */
  public final fun setPointIn(idx: Int, position: Vector2): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR2(ptr, objectID.id, idx.toLong(), position)
    TransferContext.callPtrMethod(MethodBindings.setPointInPtr, 0)
  }

  /**
   * Returns the position of the control point leading to the vertex [idx]. The returned position is
   * relative to the vertex [idx]. If the index is out of bounds, the function sends an error to the
   * console, and returns `(0, 0)`.
   */
  public final fun getPointIn(idx: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPointInPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Sets the position of the control point leading out of the vertex [idx]. If the index is out of
   * bounds, the function sends an error to the console. The position is relative to the vertex.
   */
  public final fun setPointOut(idx: Int, position: Vector2): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR2(ptr, objectID.id, idx.toLong(), position)
    TransferContext.callPtrMethod(MethodBindings.setPointOutPtr, 0)
  }

  /**
   * Returns the position of the control point leading out of the vertex [idx]. The returned
   * position is relative to the vertex [idx]. If the index is out of bounds, the function sends an
   * error to the console, and returns `(0, 0)`.
   */
  public final fun getPointOut(idx: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPointOutPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Deletes the point [idx] from the curve. Sends an error to the console if [idx] is out of
   * bounds.
   */
  public final fun removePoint(idx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callPtrMethod(MethodBindings.removePointPtr, 0)
  }

  /**
   * Removes all points from the curve.
   */
  public final fun clearPoints(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearPointsPtr, 0)
  }

  /**
   * Returns the position between the vertex [idx] and the vertex `idx + 1`, where [t] controls if
   * the point is the first vertex (`t = 0.0`), the last vertex (`t = 1.0`), or in between. Values of
   * [t] outside the range (`0.0 <= t <= 1.0`) give strange, but predictable results.
   *
   * If [idx] is out of bounds it is truncated to the first or last vertex, and [t] is ignored. If
   * the curve has no points, the function sends an error to the console, and returns `(0, 0)`.
   */
  public final fun sample(idx: Int, t: Float): Vector2 {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, idx.toLong(), t.toDouble())
    TransferContext.callPtrMethod(MethodBindings.samplePtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the position at the vertex [fofs]. It calls [sample] using the integer part of [fofs]
   * as `idx`, and its fractional part as `t`.
   */
  public final fun samplef(fofs: Float): Vector2 {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, fofs.toDouble())
    TransferContext.callPtrMethod(MethodBindings.samplefPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  public final fun setBakeInterval(distance: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, distance.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setBakeIntervalPtr, 0)
  }

  public final fun getBakeInterval(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBakeIntervalPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the total length of the curve, based on the cached points. Given enough density (see
   * [bakeInterval]), it should be approximate enough.
   */
  public final fun getBakedLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBakedLengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns a point within the curve at position [offset], where [offset] is measured as a pixel
   * distance along the curve.
   *
   * To do that, it finds the two cached points where the [offset] lies between, then interpolates
   * the values. This interpolation is cubic if [cubic] is set to `true`, or linear if set to `false`.
   *
   * Cubic interpolation tends to follow the curves better, but linear is faster (and often, precise
   * enough).
   */
  @JvmOverloads
  public final fun sampleBaked(offset: Float = 0.0f, cubic: Boolean = false): Vector2 {
    TransferContext.writeMethodArguments_DOUBLE_BOOL(ptr, objectID.id, offset.toDouble(), cubic)
    TransferContext.callPtrMethod(MethodBindings.sampleBakedPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Similar to [sampleBaked], but returns [Transform2D] that includes a rotation along the curve,
   * with [Transform2D.origin] as the point position and the [Transform2D.x] vector pointing in the
   * direction of the path at that point. Returns an empty transform if the length of the curve is `0`.
   *
   * ```
   * var baked = curve.sample_baked_with_rotation(offset)
   * # The returned Transform2D can be set directly.
   * transform = baked
   * # You can also read the origin and rotation separately from the returned Transform2D.
   * position = baked.get_origin()
   * rotation = baked.get_rotation()
   * ```
   */
  @JvmOverloads
  public final fun sampleBakedWithRotation(offset: Float = 0.0f, cubic: Boolean = false):
      Transform2D {
    TransferContext.writeMethodArguments_DOUBLE_BOOL(ptr, objectID.id, offset.toDouble(), cubic)
    TransferContext.callPtrMethod(MethodBindings.sampleBakedWithRotationPtr, 11)
    return TransferContext.readReturnValue_TRANSFORM2D()
  }

  /**
   * Returns the cache of points as a [PackedVector2Array].
   */
  public final fun getBakedPoints(): PackedVector2Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakedPointsPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR2_ARRAY()
  }

  /**
   * Returns the closest point on baked segments (in curve's local space) to [toPoint].
   *
   * [toPoint] must be in this curve's local space.
   */
  public final fun getClosestPoint(toPoint: Vector2): Vector2 {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, toPoint)
    TransferContext.callPtrMethod(MethodBindings.getClosestPointPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the closest offset to [toPoint]. This offset is meant to be used in [sampleBaked].
   *
   * [toPoint] must be in this curve's local space.
   */
  public final fun getClosestOffset(toPoint: Vector2): Float {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, toPoint)
    TransferContext.callPtrMethod(MethodBindings.getClosestOffsetPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns a list of points along the curve, with a curvature controlled point density. That is,
   * the curvier parts will have more points than the straighter parts.
   *
   * This approximation makes straight segments between each point, then subdivides those segments
   * until the resulting shape is similar enough.
   *
   * [maxStages] controls how many subdivisions a curve segment may face before it is considered
   * approximate enough. Each subdivision splits the segment in half, so the default 5 stages may mean
   * up to 32 subdivisions per curve segment. Increase with care!
   *
   * [toleranceDegrees] controls how many degrees the midpoint of a segment may deviate from the
   * real curve, before the segment has to be subdivided.
   */
  @JvmOverloads
  public final fun tessellate(maxStages: Int = 5, toleranceDegrees: Float = 4.0f):
      PackedVector2Array {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, maxStages.toLong(), toleranceDegrees.toDouble())
    TransferContext.callMethod(MethodBindings.tessellatePtr)
    return TransferContext.readReturnValue_PACKED_VECTOR2_ARRAY()
  }

  /**
   * Returns a list of points along the curve, with almost uniform density. [maxStages] controls how
   * many subdivisions a curve segment may face before it is considered approximate enough. Each
   * subdivision splits the segment in half, so the default 5 stages may mean up to 32 subdivisions per
   * curve segment. Increase with care!
   *
   * [toleranceLength] controls the maximal distance between two neighboring points, before the
   * segment has to be subdivided.
   */
  @JvmOverloads
  public final fun tessellateEvenLength(maxStages: Int = 5, toleranceLength: Float = 20.0f):
      PackedVector2Array {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, maxStages.toLong(), toleranceLength.toDouble())
    TransferContext.callMethod(MethodBindings.tessellateEvenLengthPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR2_ARRAY()
  }

  public companion object {
    @JvmField
    public val getPointCountName: MethodStringName0<Curve2D, Int> =
        MethodStringName0<Curve2D, Int>("get_point_count")

    @JvmField
    public val setPointCountName: MethodStringName1<Curve2D, Unit, Int> =
        MethodStringName1<Curve2D, Unit, Int>("set_point_count")

    @JvmField
    public val addPointName: MethodStringName4<Curve2D, Unit, Vector2, Vector2, Vector2, Int> =
        MethodStringName4<Curve2D, Unit, Vector2, Vector2, Vector2, Int>("add_point")

    @JvmField
    public val setPointPositionName: MethodStringName2<Curve2D, Unit, Int, Vector2> =
        MethodStringName2<Curve2D, Unit, Int, Vector2>("set_point_position")

    @JvmField
    public val getPointPositionName: MethodStringName1<Curve2D, Vector2, Int> =
        MethodStringName1<Curve2D, Vector2, Int>("get_point_position")

    @JvmField
    public val setPointInName: MethodStringName2<Curve2D, Unit, Int, Vector2> =
        MethodStringName2<Curve2D, Unit, Int, Vector2>("set_point_in")

    @JvmField
    public val getPointInName: MethodStringName1<Curve2D, Vector2, Int> =
        MethodStringName1<Curve2D, Vector2, Int>("get_point_in")

    @JvmField
    public val setPointOutName: MethodStringName2<Curve2D, Unit, Int, Vector2> =
        MethodStringName2<Curve2D, Unit, Int, Vector2>("set_point_out")

    @JvmField
    public val getPointOutName: MethodStringName1<Curve2D, Vector2, Int> =
        MethodStringName1<Curve2D, Vector2, Int>("get_point_out")

    @JvmField
    public val removePointName: MethodStringName1<Curve2D, Unit, Int> =
        MethodStringName1<Curve2D, Unit, Int>("remove_point")

    @JvmField
    public val clearPointsName: MethodStringName0<Curve2D, Unit> =
        MethodStringName0<Curve2D, Unit>("clear_points")

    @JvmField
    public val sampleName: MethodStringName2<Curve2D, Vector2, Int, Float> =
        MethodStringName2<Curve2D, Vector2, Int, Float>("sample")

    @JvmField
    public val samplefName: MethodStringName1<Curve2D, Vector2, Float> =
        MethodStringName1<Curve2D, Vector2, Float>("samplef")

    @JvmField
    public val setBakeIntervalName: MethodStringName1<Curve2D, Unit, Float> =
        MethodStringName1<Curve2D, Unit, Float>("set_bake_interval")

    @JvmField
    public val getBakeIntervalName: MethodStringName0<Curve2D, Float> =
        MethodStringName0<Curve2D, Float>("get_bake_interval")

    @JvmField
    public val getBakedLengthName: MethodStringName0<Curve2D, Float> =
        MethodStringName0<Curve2D, Float>("get_baked_length")

    @JvmField
    public val sampleBakedName: MethodStringName2<Curve2D, Vector2, Float, Boolean> =
        MethodStringName2<Curve2D, Vector2, Float, Boolean>("sample_baked")

    @JvmField
    public val sampleBakedWithRotationName: MethodStringName2<Curve2D, Transform2D, Float, Boolean>
        = MethodStringName2<Curve2D, Transform2D, Float, Boolean>("sample_baked_with_rotation")

    @JvmField
    public val getBakedPointsName: MethodStringName0<Curve2D, PackedVector2Array> =
        MethodStringName0<Curve2D, PackedVector2Array>("get_baked_points")

    @JvmField
    public val getClosestPointName: MethodStringName1<Curve2D, Vector2, Vector2> =
        MethodStringName1<Curve2D, Vector2, Vector2>("get_closest_point")

    @JvmField
    public val getClosestOffsetName: MethodStringName1<Curve2D, Float, Vector2> =
        MethodStringName1<Curve2D, Float, Vector2>("get_closest_offset")

    @JvmField
    public val tessellateName: MethodStringName2<Curve2D, PackedVector2Array, Int, Float> =
        MethodStringName2<Curve2D, PackedVector2Array, Int, Float>("tessellate")

    @JvmField
    public val tessellateEvenLengthName: MethodStringName2<Curve2D, PackedVector2Array, Int, Float>
        = MethodStringName2<Curve2D, PackedVector2Array, Int, Float>("tessellate_even_length")
  }

  public object MethodBindings {
    internal val getPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_point_count", 3905245786)

    internal val setPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "set_point_count", 1286410249)

    internal val addPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "add_point", 4175465202)

    internal val setPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "set_point_position", 163021252)

    internal val getPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_point_position", 2299179447)

    internal val setPointInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "set_point_in", 163021252)

    internal val getPointInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_point_in", 2299179447)

    internal val setPointOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "set_point_out", 163021252)

    internal val getPointOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_point_out", 2299179447)

    internal val removePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "remove_point", 1286410249)

    internal val clearPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "clear_points", 3218959716)

    internal val samplePtr: VoidPtr = TypeManager.getMethodBindPtr("Curve2D", "sample", 26514310)

    internal val samplefPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "samplef", 3588506812)

    internal val setBakeIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "set_bake_interval", 373806689)

    internal val getBakeIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_bake_interval", 1740695150)

    internal val getBakedLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_baked_length", 1740695150)

    internal val sampleBakedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "sample_baked", 3464257706)

    internal val sampleBakedWithRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "sample_baked_with_rotation", 3296056341)

    internal val getBakedPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_baked_points", 2961356807)

    internal val getClosestPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_closest_point", 2656412154)

    internal val getClosestOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "get_closest_offset", 2276447920)

    internal val tessellatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "tessellate", 958145977)

    internal val tessellateEvenLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve2D", "tessellate_even_length", 2319761637)
  }
}
