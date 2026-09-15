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
import godot.core.PackedInt64Array
import godot.core.PackedVector3Array
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A* (A star) is a computer algorithm used in pathfinding and graph traversal, the process of
 * plotting short paths among vertices (points), passing through a given set of edges (segments). It
 * enjoys widespread use due to its performance and accuracy. Godot's A* implementation uses points in
 * 3D space and Euclidean distances by default.
 *
 * You must add points manually with [addPoint] and create segments manually with [connectPoints].
 * Once done, you can test if there is a path between two points with the [arePointsConnected]
 * function, get a path containing indices by [getIdPath], or one containing actual coordinates with
 * [getPointPath].
 *
 * It is also possible to use non-Euclidean distances. To do so, create a script that extends
 * [AStar3D] and override the methods [_computeCost] and [_estimateCost]. Both should take two point
 * IDs and return the distance between the corresponding points.
 *
 * **Example:** Use Manhattan distance instead of Euclidean distance:
 *
 * ```gdscript
 * //gdscript
 * class_name MyAStar3D
 * extends AStar3D
 *
 * func _compute_cost(u, v):
 * 	var u_pos = get_point_position(u)
 * 	var v_pos = get_point_position(v)
 * 	return abs(u_pos.x - v_pos.x) + abs(u_pos.y - v_pos.y) + abs(u_pos.z - v_pos.z)
 *
 * func _estimate_cost(u, v):
 * 	var u_pos = get_point_position(u)
 * 	var v_pos = get_point_position(v)
 * 	return abs(u_pos.x - v_pos.x) + abs(u_pos.y - v_pos.y) + abs(u_pos.z - v_pos.z)
 * ```
 *
 * ```csharp
 * //csharp
 * using Godot;
 *
 * [GlobalClass]
 * public partial class MyAStar3D : AStar3D
 * {
 * 	public override float _ComputeCost(long fromId, long toId)
 * 	{
 * 		Vector3 fromPoint = GetPointPosition(fromId);
 * 		Vector3 toPoint = GetPointPosition(toId);
 *
 * 		return Mathf.Abs(fromPoint.X - toPoint.X) + Mathf.Abs(fromPoint.Y - toPoint.Y) +
 * Mathf.Abs(fromPoint.Z - toPoint.Z);
 * 	}
 *
 * 	public override float _EstimateCost(long fromId, long toId)
 * 	{
 * 		Vector3 fromPoint = GetPointPosition(fromId);
 * 		Vector3 toPoint = GetPointPosition(toId);
 * 		return Mathf.Abs(fromPoint.X - toPoint.X) + Mathf.Abs(fromPoint.Y - toPoint.Y) +
 * Mathf.Abs(fromPoint.Z - toPoint.Z);
 * 	}
 * }
 * ```
 *
 * [_estimateCost] should return a lower bound of the distance, i.e. `_estimate_cost(u, v) <=
 * _compute_cost(u, v)`. This serves as a hint to the algorithm because the custom [_computeCost] might
 * be computation-heavy. If this is not the case, make [_estimateCost] return the same value as
 * [_computeCost] to provide the algorithm with the most accurate information.
 *
 * If the default [_estimateCost] and [_computeCost] methods are used, or if the supplied
 * [_estimateCost] method returns a lower bound of the cost, then the paths returned by A* will be the
 * lowest-cost paths. Here, the cost of a path equals the sum of the [_computeCost] results of all
 * segments in the path multiplied by the `weight_scale`s of the endpoints of the respective segments.
 * If the default methods are used and the `weight_scale`s of all points are set to `1.0`, then this
 * equals the sum of Euclidean distances of all segments in the path.
 */
@GodotBaseType
public open class AStar3D : RefCounted() {
  /**
   * If `true` enables the filtering of neighbors via [_filterNeighbor].
   */
  public final inline var neighborFilterEnabled: Boolean
    @JvmName("neighborFilterEnabledProperty")
    get() = isNeighborFilterEnabled()
    @JvmName("neighborFilterEnabledProperty")
    set(`value`) {
      setNeighborFilterEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(2, scriptPtr)
  }

  /**
   * Called when neighboring point enters processing and if [neighborFilterEnabled] is `true`. If
   * `true` is returned the point will not be processed.
   *
   * Note that this function is hidden in the default [AStar3D] class.
   */
  public open fun _filterNeighbor(fromId: Long, neighborId: Long): Boolean {
    throw NotImplementedError("AStar3D::_filterNeighbor is not implemented.")
  }

  /**
   * Called when estimating the cost between a point and the path's ending point.
   *
   * Note that this function is hidden in the default [AStar3D] class.
   */
  public open fun _estimateCost(fromId: Long, endId: Long): Float {
    throw NotImplementedError("AStar3D::_estimateCost is not implemented.")
  }

  /**
   * Called when computing the cost between two connected points.
   *
   * Note that this function is hidden in the default [AStar3D] class.
   */
  public open fun _computeCost(fromId: Long, toId: Long): Float {
    throw NotImplementedError("AStar3D::_computeCost is not implemented.")
  }

  /**
   * Returns the next available point ID with no point associated to it.
   */
  public final fun getAvailablePointId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAvailablePointIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Adds a new point at the given position with the given identifier. The [id] must be 0 or larger,
   * and the [weightScale] must be 0.0 or greater.
   *
   * The [weightScale] is multiplied by the result of [_computeCost] when determining the overall
   * cost of traveling across a segment from a neighboring point to this point. Thus, all else being
   * equal, the algorithm prefers points with lower [weightScale]s to form a path.
   *
   * ```gdscript
   * //gdscript
   * var astar = AStar3D.new()
   * astar.add_point(1, Vector3(1, 0, 0), 4) # Adds the point (1, 0, 0) with weight_scale 4 and id 1
   * ```
   *
   * ```csharp
   * //csharp
   * var astar = new AStar3D();
   * astar.AddPoint(1, new Vector3(1, 0, 0), 4); // Adds the point (1, 0, 0) with weight_scale 4 and
   * id 1
   * ```
   *
   * If there already exists a point for the given [id], its position and weight scale are updated
   * to the given values.
   */
  @JvmOverloads
  public final fun addPoint(
    id: Long,
    position: Vector3,
    weightScale: Float = 1.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id, VECTOR3 to position, DOUBLE to weightScale.toDouble())
    TransferContext.callMethod(MethodBindings.addPointPtr)
  }

  /**
   * Returns the position of the point associated with the given [id].
   */
  public final fun getPointPosition(id: Long): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.getPointPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the [position] for the point with the given [id].
   */
  public final fun setPointPosition(id: Long, position: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id, VECTOR3 to position)
    TransferContext.callMethod(MethodBindings.setPointPositionPtr)
  }

  /**
   * Returns the weight scale of the point associated with the given [id].
   */
  public final fun getPointWeightScale(id: Long): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.getPointWeightScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the [weightScale] for the point with the given [id]. The [weightScale] is multiplied by
   * the result of [_computeCost] when determining the overall cost of traveling across a segment from
   * a neighboring point to this point.
   */
  public final fun setPointWeightScale(id: Long, weightScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id, DOUBLE to weightScale.toDouble())
    TransferContext.callMethod(MethodBindings.setPointWeightScalePtr)
  }

  /**
   * Removes the point associated with the given [id] from the points pool.
   */
  public final fun removePoint(id: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.removePointPtr)
  }

  /**
   * Returns whether a point associated with the given [id] exists.
   */
  public final fun hasPoint(id: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.hasPointPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns an array with the IDs of the points that form the connection with the given point.
   *
   * ```gdscript
   * //gdscript
   * var astar = AStar3D.new()
   * astar.add_point(1, Vector3(0, 0, 0))
   * astar.add_point(2, Vector3(0, 1, 0))
   * astar.add_point(3, Vector3(1, 1, 0))
   * astar.add_point(4, Vector3(2, 0, 0))
   *
   * astar.connect_points(1, 2, true)
   * astar.connect_points(1, 3, true)
   *
   * var neighbors = astar.get_point_connections(1) # Returns [2, 3]
   * ```
   *
   * ```csharp
   * //csharp
   * var astar = new AStar3D();
   * astar.AddPoint(1, new Vector3(0, 0, 0));
   * astar.AddPoint(2, new Vector3(0, 1, 0));
   * astar.AddPoint(3, new Vector3(1, 1, 0));
   * astar.AddPoint(4, new Vector3(2, 0, 0));
   * astar.ConnectPoints(1, 2, true);
   * astar.ConnectPoints(1, 3, true);
   *
   * long[] neighbors = astar.GetPointConnections(1); // Returns [2, 3]
   * ```
   */
  public final fun getPointConnections(id: Long): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.getPointConnectionsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Returns an array of all point IDs.
   */
  public final fun getPointIds(): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointIdsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Disables or enables the specified point for pathfinding. Useful for making a temporary
   * obstacle.
   */
  @JvmOverloads
  public final fun setPointDisabled(id: Long, disabled: Boolean = true): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setPointDisabledPtr)
  }

  /**
   * Returns whether a point is disabled or not for pathfinding. By default, all points are enabled.
   */
  public final fun isPointDisabled(id: Long): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id)
    TransferContext.callMethod(MethodBindings.isPointDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setNeighborFilterEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setNeighborFilterEnabledPtr)
  }

  public final fun isNeighborFilterEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isNeighborFilterEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Creates a segment between the given points. If [bidirectional] is `false`, only movement from
   * [id] to [toId] is allowed, not the reverse direction.
   *
   * ```gdscript
   * //gdscript
   * var astar = AStar3D.new()
   * astar.add_point(1, Vector3(1, 1, 0))
   * astar.add_point(2, Vector3(0, 5, 0))
   * astar.connect_points(1, 2, false)
   * ```
   *
   * ```csharp
   * //csharp
   * var astar = new AStar3D();
   * astar.AddPoint(1, new Vector3(1, 1, 0));
   * astar.AddPoint(2, new Vector3(0, 5, 0));
   * astar.ConnectPoints(1, 2, false);
   * ```
   */
  @JvmOverloads
  public final fun connectPoints(
    id: Long,
    toId: Long,
    bidirectional: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id, LONG to toId, BOOL to bidirectional)
    TransferContext.callMethod(MethodBindings.connectPointsPtr)
  }

  /**
   * Deletes the segment between the given points. If [bidirectional] is `false`, only movement from
   * [id] to [toId] is prevented, and a unidirectional segment possibly remains.
   */
  @JvmOverloads
  public final fun disconnectPoints(
    id: Long,
    toId: Long,
    bidirectional: Boolean = true,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id, LONG to toId, BOOL to bidirectional)
    TransferContext.callMethod(MethodBindings.disconnectPointsPtr)
  }

  /**
   * Returns whether the two given points are directly connected by a segment. If [bidirectional] is
   * `false`, returns whether movement from [id] to [toId] is possible through this segment.
   */
  @JvmOverloads
  public final fun arePointsConnected(
    id: Long,
    toId: Long,
    bidirectional: Boolean = true,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id, LONG to toId, BOOL to bidirectional)
    TransferContext.callMethod(MethodBindings.arePointsConnectedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the number of points currently in the points pool.
   */
  public final fun getPointCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the capacity of the structure backing the points, useful in conjunction with
   * [reserveSpace].
   */
  public final fun getPointCapacity(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointCapacityPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Reserves space internally for [numNodes] points. Useful if you're adding a known large number
   * of points at once, such as points on a grid.
   */
  public final fun reserveSpace(numNodes: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to numNodes)
    TransferContext.callMethod(MethodBindings.reserveSpacePtr)
  }

  /**
   * Clears all the points and segments.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Returns the ID of the closest point to [toPosition], optionally taking disabled points into
   * account. Returns `-1` if there are no points in the points pool.
   *
   * **Note:** If several points are the closest to [toPosition], the one with the smallest ID will
   * be returned, ensuring a deterministic result.
   */
  @JvmOverloads
  public final fun getClosestPoint(toPosition: Vector3, includeDisabled: Boolean = false): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to toPosition, BOOL to includeDisabled)
    TransferContext.callMethod(MethodBindings.getClosestPointPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the closest position to [toPosition] that resides inside a segment between two
   * connected points.
   *
   * ```gdscript
   * //gdscript
   * var astar = AStar3D.new()
   * astar.add_point(1, Vector3(0, 0, 0))
   * astar.add_point(2, Vector3(0, 5, 0))
   * astar.connect_points(1, 2)
   * var res = astar.get_closest_position_in_segment(Vector3(3, 3, 0)) # Returns (0, 3, 0)
   * ```
   *
   * ```csharp
   * //csharp
   * var astar = new AStar3D();
   * astar.AddPoint(1, new Vector3(0, 0, 0));
   * astar.AddPoint(2, new Vector3(0, 5, 0));
   * astar.ConnectPoints(1, 2);
   * Vector3 res = astar.GetClosestPositionInSegment(new Vector3(3, 3, 0)); // Returns (0, 3, 0)
   * ```
   *
   * The result is in the segment that goes from `y = 0` to `y = 5`. It's the closest position in
   * the segment to the given point.
   */
  public final fun getClosestPositionInSegment(toPosition: Vector3): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to toPosition)
    TransferContext.callMethod(MethodBindings.getClosestPositionInSegmentPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns an array with the points that are in the path found by AStar3D between the given
   * points. The array is ordered from the starting point to the ending point of the path.
   *
   * If [fromId] point is disabled, returns an empty array (even if `from_id == to_id`).
   *
   * If [fromId] point is not disabled, there is no valid path to the target, and [allowPartialPath]
   * is `true`, returns a path to the point closest to the target that can be reached.
   *
   * **Note:** This method is not thread-safe; it can only be used from a single [Thread] at a given
   * time. Consider using [Mutex] to ensure exclusive access to one thread to avoid race conditions.
   *
   * Additionally, when [allowPartialPath] is `true` and [toId] is disabled the search may take an
   * unusually long time to finish.
   */
  @JvmOverloads
  public final fun getPointPath(
    fromId: Long,
    toId: Long,
    allowPartialPath: Boolean = false,
  ): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromId, LONG to toId, BOOL to allowPartialPath)
    TransferContext.callMethod(MethodBindings.getPointPathPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  /**
   * Returns an array with the IDs of the points that form the path found by AStar3D between the
   * given points. The array is ordered from the starting point to the ending point of the path.
   *
   * If [fromId] point is disabled, returns an empty array (even if `from_id == to_id`).
   *
   * If [fromId] point is not disabled, there is no valid path to the target, and [allowPartialPath]
   * is `true`, returns a path to the point closest to the target that can be reached.
   *
   * **Note:** When [allowPartialPath] is `true` and [toId] is disabled the search may take an
   * unusually long time to finish.
   *
   * ```gdscript
   * //gdscript
   * var astar = AStar3D.new()
   * astar.add_point(1, Vector3(0, 0, 0))
   * astar.add_point(2, Vector3(0, 1, 0), 1) # Default weight is 1
   * astar.add_point(3, Vector3(1, 1, 0))
   * astar.add_point(4, Vector3(2, 0, 0))
   *
   * astar.connect_points(1, 2, false)
   * astar.connect_points(2, 3, false)
   * astar.connect_points(4, 3, false)
   * astar.connect_points(1, 4, false)
   *
   * var res = astar.get_id_path(1, 3) # Returns [1, 2, 3]
   * ```
   *
   * ```csharp
   * //csharp
   * var astar = new AStar3D();
   * astar.AddPoint(1, new Vector3(0, 0, 0));
   * astar.AddPoint(2, new Vector3(0, 1, 0), 1); // Default weight is 1
   * astar.AddPoint(3, new Vector3(1, 1, 0));
   * astar.AddPoint(4, new Vector3(2, 0, 0));
   * astar.ConnectPoints(1, 2, false);
   * astar.ConnectPoints(2, 3, false);
   * astar.ConnectPoints(4, 3, false);
   * astar.ConnectPoints(1, 4, false);
   * long[] res = astar.GetIdPath(1, 3); // Returns [1, 2, 3]
   * ```
   *
   * If you change the 2nd point's weight to 3, then the result will be `[1, 4, 3]` instead, because
   * now even though the distance is longer, it's "easier" to get through point 4 than through point 2.
   */
  @JvmOverloads
  public final fun getIdPath(
    fromId: Long,
    toId: Long,
    allowPartialPath: Boolean = false,
  ): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromId, LONG to toId, BOOL to allowPartialPath)
    TransferContext.callMethod(MethodBindings.getIdPathPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  public companion object {
    @JvmField
    public val getAvailablePointIdName: MethodStringName0<AStar3D, Long> =
        MethodStringName0<AStar3D, Long>("get_available_point_id")

    @JvmField
    public val addPointName: MethodStringName3<AStar3D, Unit, Long, Vector3, Float> =
        MethodStringName3<AStar3D, Unit, Long, Vector3, Float>("add_point")

    @JvmField
    public val getPointPositionName: MethodStringName1<AStar3D, Vector3, Long> =
        MethodStringName1<AStar3D, Vector3, Long>("get_point_position")

    @JvmField
    public val setPointPositionName: MethodStringName2<AStar3D, Unit, Long, Vector3> =
        MethodStringName2<AStar3D, Unit, Long, Vector3>("set_point_position")

    @JvmField
    public val getPointWeightScaleName: MethodStringName1<AStar3D, Float, Long> =
        MethodStringName1<AStar3D, Float, Long>("get_point_weight_scale")

    @JvmField
    public val setPointWeightScaleName: MethodStringName2<AStar3D, Unit, Long, Float> =
        MethodStringName2<AStar3D, Unit, Long, Float>("set_point_weight_scale")

    @JvmField
    public val removePointName: MethodStringName1<AStar3D, Unit, Long> =
        MethodStringName1<AStar3D, Unit, Long>("remove_point")

    @JvmField
    public val hasPointName: MethodStringName1<AStar3D, Boolean, Long> =
        MethodStringName1<AStar3D, Boolean, Long>("has_point")

    @JvmField
    public val getPointConnectionsName: MethodStringName1<AStar3D, PackedInt64Array, Long> =
        MethodStringName1<AStar3D, PackedInt64Array, Long>("get_point_connections")

    @JvmField
    public val getPointIdsName: MethodStringName0<AStar3D, PackedInt64Array> =
        MethodStringName0<AStar3D, PackedInt64Array>("get_point_ids")

    @JvmField
    public val setPointDisabledName: MethodStringName2<AStar3D, Unit, Long, Boolean> =
        MethodStringName2<AStar3D, Unit, Long, Boolean>("set_point_disabled")

    @JvmField
    public val isPointDisabledName: MethodStringName1<AStar3D, Boolean, Long> =
        MethodStringName1<AStar3D, Boolean, Long>("is_point_disabled")

    @JvmField
    public val setNeighborFilterEnabledName: MethodStringName1<AStar3D, Unit, Boolean> =
        MethodStringName1<AStar3D, Unit, Boolean>("set_neighbor_filter_enabled")

    @JvmField
    public val isNeighborFilterEnabledName: MethodStringName0<AStar3D, Boolean> =
        MethodStringName0<AStar3D, Boolean>("is_neighbor_filter_enabled")

    @JvmField
    public val connectPointsName: MethodStringName3<AStar3D, Unit, Long, Long, Boolean> =
        MethodStringName3<AStar3D, Unit, Long, Long, Boolean>("connect_points")

    @JvmField
    public val disconnectPointsName: MethodStringName3<AStar3D, Unit, Long, Long, Boolean> =
        MethodStringName3<AStar3D, Unit, Long, Long, Boolean>("disconnect_points")

    @JvmField
    public val arePointsConnectedName: MethodStringName3<AStar3D, Boolean, Long, Long, Boolean> =
        MethodStringName3<AStar3D, Boolean, Long, Long, Boolean>("are_points_connected")

    @JvmField
    public val getPointCountName: MethodStringName0<AStar3D, Long> =
        MethodStringName0<AStar3D, Long>("get_point_count")

    @JvmField
    public val getPointCapacityName: MethodStringName0<AStar3D, Long> =
        MethodStringName0<AStar3D, Long>("get_point_capacity")

    @JvmField
    public val reserveSpaceName: MethodStringName1<AStar3D, Unit, Long> =
        MethodStringName1<AStar3D, Unit, Long>("reserve_space")

    @JvmField
    public val clearName: MethodStringName0<AStar3D, Unit> =
        MethodStringName0<AStar3D, Unit>("clear")

    @JvmField
    public val getClosestPointName: MethodStringName2<AStar3D, Long, Vector3, Boolean> =
        MethodStringName2<AStar3D, Long, Vector3, Boolean>("get_closest_point")

    @JvmField
    public val getClosestPositionInSegmentName: MethodStringName1<AStar3D, Vector3, Vector3> =
        MethodStringName1<AStar3D, Vector3, Vector3>("get_closest_position_in_segment")

    @JvmField
    public val getPointPathName: MethodStringName3<AStar3D, PackedVector3Array, Long, Long, Boolean>
        = MethodStringName3<AStar3D, PackedVector3Array, Long, Long, Boolean>("get_point_path")

    @JvmField
    public val getIdPathName: MethodStringName3<AStar3D, PackedInt64Array, Long, Long, Boolean> =
        MethodStringName3<AStar3D, PackedInt64Array, Long, Long, Boolean>("get_id_path")
  }

  public object MethodBindings {
    internal val getAvailablePointIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_available_point_id", 3905245786)

    internal val addPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "add_point", 1038703438)

    internal val getPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_point_position", 711720468)

    internal val setPointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "set_point_position", 1530502735)

    internal val getPointWeightScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_point_weight_scale", 2339986948)

    internal val setPointWeightScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "set_point_weight_scale", 1602489585)

    internal val removePointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "remove_point", 1286410249)

    internal val hasPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "has_point", 1116898809)

    internal val getPointConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_point_connections", 2865087369)

    internal val getPointIdsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_point_ids", 3851388692)

    internal val setPointDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "set_point_disabled", 972357352)

    internal val isPointDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "is_point_disabled", 1116898809)

    internal val setNeighborFilterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "set_neighbor_filter_enabled", 2586408642)

    internal val isNeighborFilterEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "is_neighbor_filter_enabled", 36873697)

    internal val connectPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "connect_points", 3710494224)

    internal val disconnectPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "disconnect_points", 3710494224)

    internal val arePointsConnectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "are_points_connected", 2288175859)

    internal val getPointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_point_count", 3905245786)

    internal val getPointCapacityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_point_capacity", 3905245786)

    internal val reserveSpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "reserve_space", 1286410249)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("AStar3D", "clear", 3218959716)

    internal val getClosestPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_closest_point", 3241074317)

    internal val getClosestPositionInSegmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_closest_position_in_segment", 192990374)

    internal val getPointPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_point_path", 1562654675)

    internal val getIdPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AStar3D", "get_id_path", 3136199648)
  }
}
