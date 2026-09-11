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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedInt32Array
import godot.core.PackedVector2Array
import godot.core.Transform2D
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Provides a set of helper functions to create geometric shapes, compute intersections between
 * shapes, and process various other geometric operations in 2D.
 */
@GodotBaseType
public object Geometry2D : Object() {
  @JvmField
  public val isPointInCircleName: MethodStringName3<Geometry2D, Boolean, Vector2, Vector2, Float> =
      MethodStringName3<Geometry2D, Boolean, Vector2, Vector2, Float>("is_point_in_circle")

  @JvmField
  public val segmentIntersectsCircleName:
      MethodStringName4<Geometry2D, Float, Vector2, Vector2, Vector2, Float> =
      MethodStringName4<Geometry2D, Float, Vector2, Vector2, Vector2, Float>("segment_intersects_circle")

  @JvmField
  public val segmentIntersectsSegmentName:
      MethodStringName4<Geometry2D, Any?, Vector2, Vector2, Vector2, Vector2> =
      MethodStringName4<Geometry2D, Any?, Vector2, Vector2, Vector2, Vector2>("segment_intersects_segment")

  @JvmField
  public val lineIntersectsLineName:
      MethodStringName4<Geometry2D, Any?, Vector2, Vector2, Vector2, Vector2> =
      MethodStringName4<Geometry2D, Any?, Vector2, Vector2, Vector2, Vector2>("line_intersects_line")

  @JvmField
  public val getClosestPointsBetweenSegmentsName:
      MethodStringName4<Geometry2D, PackedVector2Array, Vector2, Vector2, Vector2, Vector2> =
      MethodStringName4<Geometry2D, PackedVector2Array, Vector2, Vector2, Vector2, Vector2>("get_closest_points_between_segments")

  @JvmField
  public val getClosestPointToSegmentName:
      MethodStringName3<Geometry2D, Vector2, Vector2, Vector2, Vector2> =
      MethodStringName3<Geometry2D, Vector2, Vector2, Vector2, Vector2>("get_closest_point_to_segment")

  @JvmField
  public val getClosestPointToSegmentUncappedName:
      MethodStringName3<Geometry2D, Vector2, Vector2, Vector2, Vector2> =
      MethodStringName3<Geometry2D, Vector2, Vector2, Vector2, Vector2>("get_closest_point_to_segment_uncapped")

  @JvmField
  public val pointIsInsideTriangleName:
      MethodStringName4<Geometry2D, Boolean, Vector2, Vector2, Vector2, Vector2> =
      MethodStringName4<Geometry2D, Boolean, Vector2, Vector2, Vector2, Vector2>("point_is_inside_triangle")

  @JvmField
  public val isPolygonClockwiseName: MethodStringName1<Geometry2D, Boolean, PackedVector2Array> =
      MethodStringName1<Geometry2D, Boolean, PackedVector2Array>("is_polygon_clockwise")

  @JvmField
  public val isPointInPolygonName:
      MethodStringName2<Geometry2D, Boolean, Vector2, PackedVector2Array> =
      MethodStringName2<Geometry2D, Boolean, Vector2, PackedVector2Array>("is_point_in_polygon")

  @JvmField
  public val triangulatePolygonName:
      MethodStringName1<Geometry2D, PackedInt32Array, PackedVector2Array> =
      MethodStringName1<Geometry2D, PackedInt32Array, PackedVector2Array>("triangulate_polygon")

  @JvmField
  public val triangulateDelaunayName:
      MethodStringName1<Geometry2D, PackedInt32Array, PackedVector2Array> =
      MethodStringName1<Geometry2D, PackedInt32Array, PackedVector2Array>("triangulate_delaunay")

  @JvmField
  public val convexHullName: MethodStringName1<Geometry2D, PackedVector2Array, PackedVector2Array> =
      MethodStringName1<Geometry2D, PackedVector2Array, PackedVector2Array>("convex_hull")

  @JvmField
  public val decomposePolygonInConvexName:
      MethodStringName1<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array> =
      MethodStringName1<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array>("decompose_polygon_in_convex")

  @JvmField
  public val mergePolygonsName:
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>
      =
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>("merge_polygons")

  @JvmField
  public val clipPolygonsName:
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>
      =
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>("clip_polygons")

  @JvmField
  public val intersectPolygonsName:
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>
      =
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>("intersect_polygons")

  @JvmField
  public val excludePolygonsName:
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>
      =
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>("exclude_polygons")

  @JvmField
  public val clipPolylineWithPolygonName:
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>
      =
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>("clip_polyline_with_polygon")

  @JvmField
  public val intersectPolylineWithPolygonName:
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>
      =
      MethodStringName2<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, PackedVector2Array>("intersect_polyline_with_polygon")

  @JvmField
  public val offsetPolygonName:
      MethodStringName3<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, Float, PolyJoinType>
      =
      MethodStringName3<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, Float, PolyJoinType>("offset_polygon")

  @JvmField
  public val offsetPolylineName:
      MethodStringName4<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, Float, PolyJoinType, PolyEndType>
      =
      MethodStringName4<Geometry2D, VariantArray<PackedVector2Array>, PackedVector2Array, Float, PolyJoinType, PolyEndType>("offset_polyline")

  @JvmField
  public val makeAtlasName:
      MethodStringName1<Geometry2D, Dictionary<Any?, Any?>, PackedVector2Array> =
      MethodStringName1<Geometry2D, Dictionary<Any?, Any?>, PackedVector2Array>("make_atlas")

  @JvmField
  public val bresenhamLineName:
      MethodStringName2<Geometry2D, VariantArray<Vector2i>, Vector2i, Vector2i> =
      MethodStringName2<Geometry2D, VariantArray<Vector2i>, Vector2i, Vector2i>("bresenham_line")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(8)
  }

  /**
   * Returns `true` if [point] is inside the circle or if it's located exactly *on* the circle's
   * boundary, otherwise returns `false`.
   */
  @JvmStatic
  public final fun isPointInCircle(
    point: Vector2,
    circlePosition: Vector2,
    circleRadius: Float,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point, VECTOR2 to circlePosition, DOUBLE to circleRadius.toDouble())
    TransferContext.callMethod(MethodBindings.isPointInCirclePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Given the 2D segment ([segmentFrom], [segmentTo]), returns the position on the segment (as a
   * number between 0 and 1) at which the segment hits the circle that is located at position
   * [circlePosition] and has radius [circleRadius]. If the segment does not intersect the circle, -1
   * is returned (this is also the case if the line extending the segment would intersect the circle,
   * but the segment does not).
   */
  @JvmStatic
  public final fun segmentIntersectsCircle(
    segmentFrom: Vector2,
    segmentTo: Vector2,
    circlePosition: Vector2,
    circleRadius: Float,
  ): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to segmentFrom, VECTOR2 to segmentTo, VECTOR2 to circlePosition, DOUBLE to circleRadius.toDouble())
    TransferContext.callMethod(MethodBindings.segmentIntersectsCirclePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Checks if two line segments intersect, with line `a` between [fromA] and [toA] and line `b`
   * between [fromB] and [toB]. If the line segments intersect, the point of intersection is returned
   * as a [Vector2]. If no intersection takes place, `null` is returned.
   */
  @JvmStatic
  public final fun segmentIntersectsSegment(
    fromA: Vector2,
    toA: Vector2,
    fromB: Vector2,
    toB: Vector2,
  ): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to fromA, VECTOR2 to toA, VECTOR2 to fromB, VECTOR2 to toB)
    TransferContext.callMethod(MethodBindings.segmentIntersectsSegmentPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the point of intersection between the two lines ([fromA], [dirA]) and ([fromB],
   * [dirB]). Returns a [Vector2], or `null` if the lines are parallel.
   *
   * `from` and `dir` are *not* endpoints of a line segment or ray but the slope (`dir`) and a known
   * point (`from`) on that line. To get the intersection between two line segments, use
   * [segmentIntersectsSegment].
   *
   * ```gdscript
   * //gdscript
   * var from_a = Vector2.ZERO
   * var dir_a = Vector2.RIGHT
   * var from_b = Vector2.DOWN
   *
   * # Returns Vector2(1, 0)
   * Geometry2D.line_intersects_line(from_a, dir_a, from_b, Vector2(1, -1))
   * # Returns Vector2(-1, 0)
   * Geometry2D.line_intersects_line(from_a, dir_a, from_b, Vector2(-1, -1))
   * # Returns null
   * Geometry2D.line_intersects_line(from_a, dir_a, from_b, Vector2.RIGHT)
   * ```
   *
   * ```csharp
   * //csharp
   * var fromA = Vector2.Zero;
   * var dirA = Vector2.Right;
   * var fromB = Vector2.Down;
   *
   * // Returns new Vector2(1, 0)
   * Geometry2D.LineIntersectsLine(fromA, dirA, fromB, new Vector2(1, -1));
   * // Returns new Vector2(-1, 0)
   * Geometry2D.LineIntersectsLine(fromA, dirA, fromB, new Vector2(-1, -1));
   * // Returns null
   * Geometry2D.LineIntersectsLine(fromA, dirA, fromB, Vector2.Right);
   * ```
   */
  @JvmStatic
  public final fun lineIntersectsLine(
    fromA: Vector2,
    dirA: Vector2,
    fromB: Vector2,
    dirB: Vector2,
  ): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to fromA, VECTOR2 to dirA, VECTOR2 to fromB, VECTOR2 to dirB)
    TransferContext.callMethod(MethodBindings.lineIntersectsLinePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Given the two 2D segments ([p1], [q1]) and ([p2], [q2]), finds those two points on the two
   * segments that are closest to each other. Returns a [PackedVector2Array] that contains this point
   * on ([p1], [q1]) as well the accompanying point on ([p2], [q2]).
   */
  @JvmStatic
  public final fun getClosestPointsBetweenSegments(
    p1: Vector2,
    q1: Vector2,
    p2: Vector2,
    q2: Vector2,
  ): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to p1, VECTOR2 to q1, VECTOR2 to p2, VECTOR2 to q2)
    TransferContext.callMethod(MethodBindings.getClosestPointsBetweenSegmentsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Returns the 2D point on the 2D segment ([s1], [s2]) that is closest to [point]. The returned
   * point will always be inside the specified segment.
   */
  @JvmStatic
  public final fun getClosestPointToSegment(
    point: Vector2,
    s1: Vector2,
    s2: Vector2,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point, VECTOR2 to s1, VECTOR2 to s2)
    TransferContext.callMethod(MethodBindings.getClosestPointToSegmentPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the 2D point on the 2D line defined by ([s1], [s2]) that is closest to [point]. The
   * returned point can be inside the segment ([s1], [s2]) or outside of it, i.e. somewhere on the line
   * extending from the segment.
   */
  @JvmStatic
  public final fun getClosestPointToSegmentUncapped(
    point: Vector2,
    s1: Vector2,
    s2: Vector2,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point, VECTOR2 to s1, VECTOR2 to s2)
    TransferContext.callMethod(MethodBindings.getClosestPointToSegmentUncappedPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns if [point] is inside the triangle specified by [a], [b] and [c].
   */
  @JvmStatic
  public final fun pointIsInsideTriangle(
    point: Vector2,
    a: Vector2,
    b: Vector2,
    c: Vector2,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point, VECTOR2 to a, VECTOR2 to b, VECTOR2 to c)
    TransferContext.callMethod(MethodBindings.pointIsInsideTrianglePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if [polygon]'s vertices are ordered in clockwise order, otherwise returns
   * `false`.
   *
   * **Note:** Assumes a Cartesian coordinate system where `+x` is right and `+y` is up. If using
   * screen coordinates (`+y` is down), the result will need to be flipped (i.e. a `true` result will
   * indicate counter-clockwise).
   */
  @JvmStatic
  public final fun isPolygonClockwise(polygon: PackedVector2Array): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.isPolygonClockwisePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if [point] is inside [polygon] or if it's located exactly *on* polygon's
   * boundary, otherwise returns `false`.
   */
  @JvmStatic
  public final fun isPointInPolygon(point: Vector2, polygon: PackedVector2Array): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to point, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.isPointInPolygonPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Triangulates the polygon specified by the points in [polygon]. Returns a [PackedInt32Array]
   * where each triangle consists of three consecutive point indices into [polygon] (i.e. the returned
   * array will have `n * 3` elements, with `n` being the number of found triangles). Output triangles
   * will always be counter clockwise, and the contour will be flipped if it's clockwise. If the
   * triangulation did not succeed, an empty [PackedInt32Array] is returned.
   */
  @JvmStatic
  public final fun triangulatePolygon(polygon: PackedVector2Array): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.triangulatePolygonPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Triangulates the area specified by discrete set of [points] such that no point is inside the
   * circumcircle of any resulting triangle. Returns a [PackedInt32Array] where each triangle consists
   * of three consecutive point indices into [points] (i.e. the returned array will have `n * 3`
   * elements, with `n` being the number of found triangles). If the triangulation did not succeed, an
   * empty [PackedInt32Array] is returned.
   */
  @JvmStatic
  public final fun triangulateDelaunay(points: PackedVector2Array): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points)
    TransferContext.callMethod(MethodBindings.triangulateDelaunayPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Given an array of [Vector2]s, returns the convex hull as a list of points in counterclockwise
   * order. The last point is the same as the first one.
   */
  @JvmStatic
  public final fun convexHull(points: PackedVector2Array): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to points)
    TransferContext.callMethod(MethodBindings.convexHullPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Decomposes the [polygon] into multiple convex hulls and returns an array of
   * [PackedVector2Array].
   */
  @JvmStatic
  public final fun decomposePolygonInConvex(polygon: PackedVector2Array):
      VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.decomposePolygonInConvexPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Merges (combines) [polygonA] and [polygonB] and returns an array of merged polygons. This
   * performs [OPERATION_UNION] between polygons.
   *
   * The operation may result in an outer polygon (boundary) and multiple inner polygons (holes)
   * produced which could be distinguished by calling [isPolygonClockwise].
   */
  @JvmStatic
  public final fun mergePolygons(polygonA: PackedVector2Array, polygonB: PackedVector2Array):
      VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygonA, PACKED_VECTOR2_ARRAY to polygonB)
    TransferContext.callMethod(MethodBindings.mergePolygonsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Clips [polygonA] against [polygonB] and returns an array of clipped polygons. This performs
   * [OPERATION_DIFFERENCE] between polygons. Returns an empty array if [polygonB] completely overlaps
   * [polygonA].
   *
   * If [polygonB] is enclosed by [polygonA], returns an outer polygon (boundary) and inner polygon
   * (hole) which could be distinguished by calling [isPolygonClockwise].
   */
  @JvmStatic
  public final fun clipPolygons(polygonA: PackedVector2Array, polygonB: PackedVector2Array):
      VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygonA, PACKED_VECTOR2_ARRAY to polygonB)
    TransferContext.callMethod(MethodBindings.clipPolygonsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Intersects [polygonA] with [polygonB] and returns an array of intersected polygons. This
   * performs [OPERATION_INTERSECTION] between polygons. In other words, returns common area shared by
   * polygons. Returns an empty array if no intersection occurs.
   *
   * The operation may result in an outer polygon (boundary) and inner polygon (hole) produced which
   * could be distinguished by calling [isPolygonClockwise].
   */
  @JvmStatic
  public final fun intersectPolygons(polygonA: PackedVector2Array, polygonB: PackedVector2Array):
      VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygonA, PACKED_VECTOR2_ARRAY to polygonB)
    TransferContext.callMethod(MethodBindings.intersectPolygonsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Mutually excludes common area defined by intersection of [polygonA] and [polygonB] (see
   * [intersectPolygons]) and returns an array of excluded polygons. This performs [OPERATION_XOR]
   * between polygons. In other words, returns all but common area between polygons.
   *
   * The operation may result in an outer polygon (boundary) and inner polygon (hole) produced which
   * could be distinguished by calling [isPolygonClockwise].
   */
  @JvmStatic
  public final fun excludePolygons(polygonA: PackedVector2Array, polygonB: PackedVector2Array):
      VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygonA, PACKED_VECTOR2_ARRAY to polygonB)
    TransferContext.callMethod(MethodBindings.excludePolygonsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Clips [polyline] against [polygon] and returns an array of clipped polylines. This performs
   * [OPERATION_DIFFERENCE] between the polyline and the polygon. This operation can be thought of as
   * cutting a line with a closed shape.
   */
  @JvmStatic
  public final fun clipPolylineWithPolygon(polyline: PackedVector2Array,
      polygon: PackedVector2Array): VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polyline, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.clipPolylineWithPolygonPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Intersects [polyline] with [polygon] and returns an array of intersected polylines. This
   * performs [OPERATION_INTERSECTION] between the polyline and the polygon. This operation can be
   * thought of as chopping a line with a closed shape.
   */
  @JvmStatic
  public final fun intersectPolylineWithPolygon(polyline: PackedVector2Array,
      polygon: PackedVector2Array): VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polyline, PACKED_VECTOR2_ARRAY to polygon)
    TransferContext.callMethod(MethodBindings.intersectPolylineWithPolygonPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Inflates or deflates [polygon] by [delta] units (pixels). If [delta] is positive, makes the
   * polygon grow outward. If [delta] is negative, shrinks the polygon inward. Returns an array of
   * polygons because inflating/deflating may result in multiple discrete polygons. Returns an empty
   * array if [delta] is negative and the absolute value of it approximately exceeds the minimum
   * bounding rectangle dimensions of the polygon.
   *
   * Each polygon's vertices will be rounded as determined by [joinType].
   *
   * The operation may result in an outer polygon (boundary) and inner polygon (hole) produced which
   * could be distinguished by calling [isPolygonClockwise].
   *
   * **Note:** To translate the polygon's vertices specifically, multiply them to a [Transform2D]:
   *
   * ```gdscript
   * //gdscript
   * var polygon = PackedVector2Array([Vector2(0, 0), Vector2(100, 0), Vector2(100, 100), Vector2(0,
   * 100)])
   * var offset = Vector2(50, 50)
   * polygon = Transform2D(0, offset) * polygon
   * print(polygon) # Prints [(50.0, 50.0), (150.0, 50.0), (150.0, 150.0), (50.0, 150.0)]
   * ```
   *
   * ```csharp
   * //csharp
   * Vector2[] polygon = [new Vector2(0, 0), new Vector2(100, 0), new Vector2(100, 100), new
   * Vector2(0, 100)];
   * var offset = new Vector2(50, 50);
   * polygon = new Transform2D(0, offset) * polygon;
   * GD.Print((Variant)polygon); // Prints [(50, 50), (150, 50), (150, 150), (50, 150)]
   * ```
   */
  @JvmOverloads
  @JvmStatic
  public final fun offsetPolygon(
    polygon: PackedVector2Array,
    delta: Float,
    joinType: PolyJoinType = Geometry2D.PolyJoinType.JOIN_SQUARE,
  ): VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polygon, DOUBLE to delta.toDouble(), LONG to joinType.value)
    TransferContext.callMethod(MethodBindings.offsetPolygonPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Inflates or deflates [polyline] by [delta] units (pixels), producing polygons. If [delta] is
   * positive, makes the polyline grow outward. Returns an array of polygons because
   * inflating/deflating may result in multiple discrete polygons. If [delta] is negative, returns an
   * empty array.
   *
   * Each polygon's vertices will be rounded as determined by [joinType].
   *
   * Each polygon's endpoints will be rounded as determined by [endType].
   *
   * The operation may result in an outer polygon (boundary) and inner polygon (hole) produced which
   * could be distinguished by calling [isPolygonClockwise].
   */
  @JvmOverloads
  @JvmStatic
  public final fun offsetPolyline(
    polyline: PackedVector2Array,
    delta: Float,
    joinType: PolyJoinType = Geometry2D.PolyJoinType.JOIN_SQUARE,
    endType: PolyEndType = Geometry2D.PolyEndType.END_SQUARE,
  ): VariantArray<PackedVector2Array> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to polyline, DOUBLE to delta.toDouble(), LONG to joinType.value, LONG to endType.value)
    TransferContext.callMethod(MethodBindings.offsetPolylinePtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<PackedVector2Array>)
  }

  /**
   * Given an array of [Vector2]s representing tiles, builds an atlas. The returned dictionary has
   * two keys: `points` is a [PackedVector2Array] that specifies the positions of each tile, `size`
   * contains the overall size of the whole atlas as [Vector2i].
   */
  @JvmStatic
  public final fun makeAtlas(sizes: PackedVector2Array): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to sizes)
    TransferContext.callMethod(MethodBindings.makeAtlasPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the [url=https://en.wikipedia.org/wiki/Bresenham&#37;27s_line_algorithm]Bresenham
   * line[/url] between the [from] and [to] points. A Bresenham line is a series of pixels that draws a
   * line and is always 1-pixel thick on every row and column of the drawing (never more, never less).
   *
   * Example code to draw a line between two [Marker2D] nodes using a series of
   * [CanvasItem.drawRect] calls:
   *
   * ```
   * func _draw():
   * 	for pixel in Geometry2D.bresenham_line($MarkerA.position, $MarkerB.position):
   * 		draw_rect(Rect2(pixel, Vector2.ONE), Color.WHITE)
   * ```
   */
  @JvmStatic
  public final fun bresenhamLine(from: Vector2i, to: Vector2i): VariantArray<Vector2i> {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to from, VECTOR2I to to)
    TransferContext.callMethod(MethodBindings.bresenhamLinePtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Vector2i>)
  }

  public enum class PolyBooleanOperation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Create regions where either subject or clip polygons (or both) are filled.
     */
    OPERATION_UNION(0),
    /**
     * Create regions where subject polygons are filled except where clip polygons are filled.
     */
    OPERATION_DIFFERENCE(1),
    /**
     * Create regions where both subject and clip polygons are filled.
     */
    OPERATION_INTERSECTION(2),
    /**
     * Create regions where either subject or clip polygons are filled but not where both are
     * filled.
     */
    OPERATION_XOR(3),
    ;

    public companion object {
      public fun from(`value`: Long): PolyBooleanOperation =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class PolyJoinType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Squaring is applied uniformally at all convex edge joins at `1 * delta`.
     */
    JOIN_SQUARE(0),
    /**
     * While flattened paths can never perfectly trace an arc, they are approximated by a series of
     * arc chords.
     */
    JOIN_ROUND(1),
    /**
     * There's a necessary limit to mitered joins since offsetting edges that join at very acute
     * angles will produce excessively long and narrow "spikes". For any given edge join, when miter
     * offsetting would exceed that maximum distance, "square" joining is applied.
     */
    JOIN_MITER(2),
    ;

    public companion object {
      public fun from(`value`: Long): PolyJoinType = entries.single { it.`value` == `value` }
    }
  }

  public enum class PolyEndType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Endpoints are joined using the [PolyJoinType] value and the path filled as a polygon.
     */
    END_POLYGON(0),
    /**
     * Endpoints are joined using the [PolyJoinType] value and the path filled as a polyline.
     */
    END_JOINED(1),
    /**
     * Endpoints are squared off with no extension.
     */
    END_BUTT(2),
    /**
     * Endpoints are squared off and extended by `delta` units.
     */
    END_SQUARE(3),
    /**
     * Endpoints are rounded off and extended by `delta` units.
     */
    END_ROUND(4),
    ;

    public companion object {
      public fun from(`value`: Long): PolyEndType = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val isPointInCirclePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "is_point_in_circle", 2929491703)

    internal val segmentIntersectsCirclePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "segment_intersects_circle", 1356928167)

    internal val segmentIntersectsSegmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "segment_intersects_segment", 2058025344)

    internal val lineIntersectsLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "line_intersects_line", 2058025344)

    internal val getClosestPointsBetweenSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "get_closest_points_between_segments", 3344690961)

    internal val getClosestPointToSegmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "get_closest_point_to_segment", 4172901909)

    internal val getClosestPointToSegmentUncappedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "get_closest_point_to_segment_uncapped", 4172901909)

    internal val pointIsInsideTrianglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "point_is_inside_triangle", 1025948137)

    internal val isPolygonClockwisePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "is_polygon_clockwise", 1361156557)

    internal val isPointInPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "is_point_in_polygon", 738277916)

    internal val triangulatePolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "triangulate_polygon", 1389921771)

    internal val triangulateDelaunayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "triangulate_delaunay", 1389921771)

    internal val convexHullPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "convex_hull", 2004331998)

    internal val decomposePolygonInConvexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "decompose_polygon_in_convex", 3982393695)

    internal val mergePolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "merge_polygons", 3637387053)

    internal val clipPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "clip_polygons", 3637387053)

    internal val intersectPolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "intersect_polygons", 3637387053)

    internal val excludePolygonsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "exclude_polygons", 3637387053)

    internal val clipPolylineWithPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "clip_polyline_with_polygon", 3637387053)

    internal val intersectPolylineWithPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "intersect_polyline_with_polygon", 3637387053)

    internal val offsetPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "offset_polygon", 1275354010)

    internal val offsetPolylinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "offset_polyline", 2328231778)

    internal val makeAtlasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "make_atlas", 1337682371)

    internal val bresenhamLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry2D", "bresenham_line", 1989391000)
  }
}
