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
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedFloat32Array
import godot.core.PackedVector3Array
import godot.core.Transform3D
import godot.core.Vector3
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_FLOAT_32_ARRAY
import godot.readReturnValue_PACKED_VECTOR3_ARRAY
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_DOUBLE_BOOL
import godot.writeMethodArguments_DOUBLE_BOOL_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_VECTOR3
import godot.writeMethodArguments_VECTOR3
import godot.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This class describes a Bézier curve in 3D space. It is mainly used to give a shape to a [Path3D],
 * but can be manually sampled for other purposes.
 *
 * It keeps a cache of precalculated points along the curve, to speed up further calculations.
 */
@GodotBaseType
public open class Curve3D : Resource() {
  /**
   * If `true`, and the curve has more than 2 control points, the last point and the first one will
   * be connected in a loop.
   */
  public final inline var closed: Boolean
    @JvmName("closedProperty")
    get() = isClosed()
    @JvmName("closedProperty")
    set(`value`) {
      setClosed(value)
    }

  /**
   * The distance in meters between two adjacent cached points. Changing it forces the cache to be
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

  /**
   * If `true`, the curve will bake up vectors used for orientation. This is used when
   * [PathFollow3D.rotationMode] is set to [PathFollow3D.ROTATION_ORIENTED]. Changing it forces the
   * cache to be recomputed.
   */
  public final inline var upVectorEnabled: Boolean
    @JvmName("upVectorEnabledProperty")
    get() = isUpVectorEnabled()
    @JvmName("upVectorEnabledProperty")
    set(`value`) {
      setUpVectorEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(196, scriptPtr)
  }

  public final fun getPointCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setPointCount(count: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, count.toLong())
    TransferContext.callMethod(MethodBindings.setPointCountPtr)
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
    position: Vector3,
    `in`: Vector3 = Vector3(0, 0, 0),
    `out`: Vector3 = Vector3(0, 0, 0),
    index: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_LONG(ptr, objectID.id, position, `in`, out, index.toLong())
    TransferContext.callMethod(MethodBindings.addPointPtr)
  }

  /**
   * Sets the position for the vertex [idx]. If the index is out of bounds, the function sends an
   * error to the console.
   */
  public final fun setPointPosition(idx: Int, position: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, idx.toLong(), position)
    TransferContext.callMethod(MethodBindings.setPointPositionPtr)
  }

  /**
   * Returns the position of the vertex [idx]. If the index is out of bounds, the function sends an
   * error to the console, and returns `(0, 0, 0)`.
   */
  public final fun getPointPosition(idx: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getPointPositionPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the tilt angle in radians for the point [idx]. If the index is out of bounds, the function
   * sends an error to the console.
   *
   * The tilt controls the rotation along the look-at axis an object traveling the path would have.
   * In the case of a curve controlling a [PathFollow3D], this tilt is an offset over the natural tilt
   * the [PathFollow3D] calculates.
   */
  public final fun setPointTilt(idx: Int, tilt: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, idx.toLong(), tilt.toDouble())
    TransferContext.callMethod(MethodBindings.setPointTiltPtr)
  }

  /**
   * Returns the tilt angle in radians for the point [idx]. If the index is out of bounds, the
   * function sends an error to the console, and returns `0`.
   */
  public final fun getPointTilt(idx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getPointTiltPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the position of the control point leading to the vertex [idx]. If the index is out of
   * bounds, the function sends an error to the console. The position is relative to the vertex.
   */
  public final fun setPointIn(idx: Int, position: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, idx.toLong(), position)
    TransferContext.callMethod(MethodBindings.setPointInPtr)
  }

  /**
   * Returns the position of the control point leading to the vertex [idx]. The returned position is
   * relative to the vertex [idx]. If the index is out of bounds, the function sends an error to the
   * console, and returns `(0, 0, 0)`.
   */
  public final fun getPointIn(idx: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getPointInPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the position of the control point leading out of the vertex [idx]. If the index is out of
   * bounds, the function sends an error to the console. The position is relative to the vertex.
   */
  public final fun setPointOut(idx: Int, position: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, idx.toLong(), position)
    TransferContext.callMethod(MethodBindings.setPointOutPtr)
  }

  /**
   * Returns the position of the control point leading out of the vertex [idx]. The returned
   * position is relative to the vertex [idx]. If the index is out of bounds, the function sends an
   * error to the console, and returns `(0, 0, 0)`.
   */
  public final fun getPointOut(idx: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.getPointOutPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Deletes the point [idx] from the curve. Sends an error to the console if [idx] is out of
   * bounds.
   */
  public final fun removePoint(idx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.removePointPtr)
  }

  /**
   * Removes all points from the curve.
   */
  public final fun clearPoints(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPointsPtr)
  }

  /**
   * Returns the position between the vertex [idx] and the vertex `idx + 1`, where [t] controls if
   * the point is the first vertex (`t = 0.0`), the last vertex (`t = 1.0`), or in between. Values of
   * [t] outside the range (`0.0 >= t <=1`) give strange, but predictable results.
   *
   * If [idx] is out of bounds it is truncated to the first or last vertex, and [t] is ignored. If
   * the curve has no points, the function sends an error to the console, and returns `(0, 0, 0)`.
   */
  public final fun sample(idx: Int, t: Float): Vector3 {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, idx.toLong(), t.toDouble())
    TransferContext.callMethod(MethodBindings.samplePtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the position at the vertex [fofs]. It calls [sample] using the integer part of [fofs]
   * as `idx`, and its fractional part as `t`.
   */
  public final fun samplef(fofs: Float): Vector3 {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, fofs.toDouble())
    TransferContext.callMethod(MethodBindings.samplefPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  public final fun setClosed(closed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, closed)
    TransferContext.callMethod(MethodBindings.setClosedPtr)
  }

  public final fun isClosed(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isClosedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setBakeInterval(distance: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, distance.toDouble())
    TransferContext.callMethod(MethodBindings.setBakeIntervalPtr)
  }

  public final fun getBakeInterval(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakeIntervalPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setUpVectorEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setUpVectorEnabledPtr)
  }

  public final fun isUpVectorEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUpVectorEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the total length of the curve, based on the cached points. Given enough density (see
   * [bakeInterval]), it should be approximate enough.
   */
  public final fun getBakedLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakedLengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns a point within the curve at position [offset], where [offset] is measured as a distance
   * in 3D units along the curve. To do that, it finds the two cached points where the [offset] lies
   * between, then interpolates the values. This interpolation is cubic if [cubic] is set to `true`, or
   * linear if set to `false`.
   *
   * Cubic interpolation tends to follow the curves better, but linear is faster (and often, precise
   * enough).
   */
  @JvmOverloads
  public final fun sampleBaked(offset: Float = 0.0f, cubic: Boolean = false): Vector3 {
    TransferContext.writeMethodArguments_DOUBLE_BOOL(ptr, objectID.id, offset.toDouble(), cubic)
    TransferContext.callMethod(MethodBindings.sampleBakedPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns a [Transform3D] with `origin` as point position, `basis.x` as sideway vector, `basis.y`
   * as up vector, `basis.z` as forward vector. When the curve length is 0, there is no reasonable way
   * to calculate the rotation, all vectors aligned with global space axes. See also [sampleBaked].
   */
  @JvmOverloads
  public final fun sampleBakedWithRotation(
    offset: Float = 0.0f,
    cubic: Boolean = false,
    applyTilt: Boolean = false,
  ): Transform3D {
    TransferContext.writeMethodArguments_DOUBLE_BOOL_BOOL(ptr, objectID.id, offset.toDouble(), cubic, applyTilt)
    TransferContext.callMethod(MethodBindings.sampleBakedWithRotationPtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Returns an up vector within the curve at position [offset], where [offset] is measured as a
   * distance in 3D units along the curve. To do that, it finds the two cached up vectors where the
   * [offset] lies between, then interpolates the values. If [applyTilt] is `true`, an interpolated
   * tilt is applied to the interpolated up vector.
   *
   * If the curve has no up vectors, the function sends an error to the console, and returns `(0, 1,
   * 0)`.
   */
  @JvmOverloads
  public final fun sampleBakedUpVector(offset: Float, applyTilt: Boolean = false): Vector3 {
    TransferContext.writeMethodArguments_DOUBLE_BOOL(ptr, objectID.id, offset.toDouble(), applyTilt)
    TransferContext.callMethod(MethodBindings.sampleBakedUpVectorPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the cache of points as a [PackedVector3Array].
   */
  public final fun getBakedPoints(): PackedVector3Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakedPointsPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Returns the cache of tilts as a [PackedFloat32Array].
   */
  public final fun getBakedTilts(): PackedFloat32Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakedTiltsPtr)
    return TransferContext.readReturnValue_PACKED_FLOAT_32_ARRAY()
  }

  /**
   * Returns the cache of up vectors as a [PackedVector3Array].
   *
   * If [upVectorEnabled] is `false`, the cache will be empty.
   */
  public final fun getBakedUpVectors(): PackedVector3Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBakedUpVectorsPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Returns the closest point on baked segments (in curve's local space) to [toPoint].
   *
   * [toPoint] must be in this curve's local space.
   */
  public final fun getClosestPoint(toPoint: Vector3): Vector3 {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, toPoint)
    TransferContext.callMethod(MethodBindings.getClosestPointPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the closest offset to [toPoint]. This offset is meant to be used in [sampleBaked] or
   * [sampleBakedUpVector].
   *
   * [toPoint] must be in this curve's local space.
   */
  public final fun getClosestOffset(toPoint: Vector3): Float {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, toPoint)
    TransferContext.callMethod(MethodBindings.getClosestOffsetPtr)
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
      PackedVector3Array {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, maxStages.toLong(), toleranceDegrees.toDouble())
    TransferContext.callMethod(MethodBindings.tessellatePtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
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
  public final fun tessellateEvenLength(maxStages: Int = 5, toleranceLength: Float = 0.2f):
      PackedVector3Array {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, maxStages.toLong(), toleranceLength.toDouble())
    TransferContext.callMethod(MethodBindings.tessellateEvenLengthPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  public companion object {
    @JvmField
    public val getPointCountName: MethodStringName0<Curve3D, Int> =
        MethodStringName0<Curve3D, Int>("get_point_count")

    @JvmField
    public val setPointCountName: MethodStringName1<Curve3D, Unit, Int> =
        MethodStringName1<Curve3D, Unit, Int>("set_point_count")

    @JvmField
    public val addPointName: MethodStringName4<Curve3D, Unit, Vector3, Vector3, Vector3, Int> =
        MethodStringName4<Curve3D, Unit, Vector3, Vector3, Vector3, Int>("add_point")

    @JvmField
    public val setPointPositionName: MethodStringName2<Curve3D, Unit, Int, Vector3> =
        MethodStringName2<Curve3D, Unit, Int, Vector3>("set_point_position")

    @JvmField
    public val getPointPositionName: MethodStringName1<Curve3D, Vector3, Int> =
        MethodStringName1<Curve3D, Vector3, Int>("get_point_position")

    @JvmField
    public val setPointTiltName: MethodStringName2<Curve3D, Unit, Int, Float> =
        MethodStringName2<Curve3D, Unit, Int, Float>("set_point_tilt")

    @JvmField
    public val getPointTiltName: MethodStringName1<Curve3D, Float, Int> =
        MethodStringName1<Curve3D, Float, Int>("get_point_tilt")

    @JvmField
    public val setPointInName: MethodStringName2<Curve3D, Unit, Int, Vector3> =
        MethodStringName2<Curve3D, Unit, Int, Vector3>("set_point_in")

    @JvmField
    public val getPointInName: MethodStringName1<Curve3D, Vector3, Int> =
        MethodStringName1<Curve3D, Vector3, Int>("get_point_in")

    @JvmField
    public val setPointOutName: MethodStringName2<Curve3D, Unit, Int, Vector3> =
        MethodStringName2<Curve3D, Unit, Int, Vector3>("set_point_out")

    @JvmField
    public val getPointOutName: MethodStringName1<Curve3D, Vector3, Int> =
        MethodStringName1<Curve3D, Vector3, Int>("get_point_out")

    @JvmField
    public val removePointName: MethodStringName1<Curve3D, Unit, Int> =
        MethodStringName1<Curve3D, Unit, Int>("remove_point")

    @JvmField
    public val clearPointsName: MethodStringName0<Curve3D, Unit> =
        MethodStringName0<Curve3D, Unit>("clear_points")

    @JvmField
    public val sampleName: MethodStringName2<Curve3D, Vector3, Int, Float> =
        MethodStringName2<Curve3D, Vector3, Int, Float>("sample")

    @JvmField
    public val samplefName: MethodStringName1<Curve3D, Vector3, Float> =
        MethodStringName1<Curve3D, Vector3, Float>("samplef")

    @JvmField
    public val setClosedName: MethodStringName1<Curve3D, Unit, Boolean> =
        MethodStringName1<Curve3D, Unit, Boolean>("set_closed")

    @JvmField
    public val isClosedName: MethodStringName0<Curve3D, Boolean> =
        MethodStringName0<Curve3D, Boolean>("is_closed")

    @JvmField
    public val setBakeIntervalName: MethodStringName1<Curve3D, Unit, Float> =
        MethodStringName1<Curve3D, Unit, Float>("set_bake_interval")

    @JvmField
    public val getBakeIntervalName: MethodStringName0<Curve3D, Float> =
        MethodStringName0<Curve3D, Float>("get_bake_interval")

    @JvmField
    public val setUpVectorEnabledName: MethodStringName1<Curve3D, Unit, Boolean> =
        MethodStringName1<Curve3D, Unit, Boolean>("set_up_vector_enabled")

    @JvmField
    public val isUpVectorEnabledName: MethodStringName0<Curve3D, Boolean> =
        MethodStringName0<Curve3D, Boolean>("is_up_vector_enabled")

    @JvmField
    public val getBakedLengthName: MethodStringName0<Curve3D, Float> =
        MethodStringName0<Curve3D, Float>("get_baked_length")

    @JvmField
    public val sampleBakedName: MethodStringName2<Curve3D, Vector3, Float, Boolean> =
        MethodStringName2<Curve3D, Vector3, Float, Boolean>("sample_baked")

    @JvmField
    public val sampleBakedWithRotationName:
        MethodStringName3<Curve3D, Transform3D, Float, Boolean, Boolean> =
        MethodStringName3<Curve3D, Transform3D, Float, Boolean, Boolean>("sample_baked_with_rotation")

    @JvmField
    public val sampleBakedUpVectorName: MethodStringName2<Curve3D, Vector3, Float, Boolean> =
        MethodStringName2<Curve3D, Vector3, Float, Boolean>("sample_baked_up_vector")

    @JvmField
    public val getBakedPointsName: MethodStringName0<Curve3D, PackedVector3Array> =
        MethodStringName0<Curve3D, PackedVector3Array>("get_baked_points")

    @JvmField
    public val getBakedTiltsName: MethodStringName0<Curve3D, PackedFloat32Array> =
        MethodStringName0<Curve3D, PackedFloat32Array>("get_baked_tilts")

    @JvmField
    public val getBakedUpVectorsName: MethodStringName0<Curve3D, PackedVector3Array> =
        MethodStringName0<Curve3D, PackedVector3Array>("get_baked_up_vectors")

    @JvmField
    public val getClosestPointName: MethodStringName1<Curve3D, Vector3, Vector3> =
        MethodStringName1<Curve3D, Vector3, Vector3>("get_closest_point")

    @JvmField
    public val getClosestOffsetName: MethodStringName1<Curve3D, Float, Vector3> =
        MethodStringName1<Curve3D, Float, Vector3>("get_closest_offset")

    @JvmField
    public val tessellateName: MethodStringName2<Curve3D, PackedVector3Array, Int, Float> =
        MethodStringName2<Curve3D, PackedVector3Array, Int, Float>("tessellate")

    @JvmField
    public val tessellateEvenLengthName: MethodStringName2<Curve3D, PackedVector3Array, Int, Float>
        = MethodStringName2<Curve3D, PackedVector3Array, Int, Float>("tessellate_even_length")
  }

  public object MethodBindings {
    internal val getPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_point_count", 3905245786)

    internal val setPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_point_count", 1286410249)

    internal val addPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "add_point", 2931053748)

    internal val setPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_point_position", 1530502735)

    internal val getPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_point_position", 711720468)

    internal val setPointTiltPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_point_tilt", 1602489585)

    internal val getPointTiltPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_point_tilt", 2339986948)

    internal val setPointInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_point_in", 1530502735)

    internal val getPointInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_point_in", 711720468)

    internal val setPointOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_point_out", 1530502735)

    internal val getPointOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_point_out", 711720468)

    internal val removePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "remove_point", 1286410249)

    internal val clearPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "clear_points", 3218959716)

    internal val samplePtr: VoidPtr = TypeManager.getMethodBindPtr("Curve3D", "sample", 3285246857)

    internal val samplefPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "samplef", 2553580215)

    internal val setClosedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_closed", 2586408642)

    internal val isClosedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "is_closed", 36873697)

    internal val setBakeIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_bake_interval", 373806689)

    internal val getBakeIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_bake_interval", 1740695150)

    internal val setUpVectorEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "set_up_vector_enabled", 2586408642)

    internal val isUpVectorEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "is_up_vector_enabled", 36873697)

    internal val getBakedLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_baked_length", 1740695150)

    internal val sampleBakedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "sample_baked", 1350085894)

    internal val sampleBakedWithRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "sample_baked_with_rotation", 1939359131)

    internal val sampleBakedUpVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "sample_baked_up_vector", 1362627031)

    internal val getBakedPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_baked_points", 497664490)

    internal val getBakedTiltsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_baked_tilts", 675695659)

    internal val getBakedUpVectorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_baked_up_vectors", 497664490)

    internal val getClosestPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_closest_point", 192990374)

    internal val getClosestOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "get_closest_offset", 1109078154)

    internal val tessellatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "tessellate", 1519759391)

    internal val tessellateEvenLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Curve3D", "tessellate_even_length", 133237049)
  }
}
