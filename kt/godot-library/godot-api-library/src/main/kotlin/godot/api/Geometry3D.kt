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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.PackedInt32Array
import godot.core.PackedVector3Array
import godot.core.Plane
import godot.core.VariantArray
import godot.core.Vector3
import godot.readReturnValue_ANY
import godot.readReturnValue_ARRAY
import godot.readReturnValue_PACKED_INT_32_ARRAY
import godot.readReturnValue_PACKED_VECTOR3_ARRAY
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_DOUBLE_DOUBLE_LONG_LONG
import godot.writeMethodArguments_DOUBLE_DOUBLE_LONG_LONG_LONG
import godot.writeMethodArguments_PACKED_VECTOR3_ARRAY
import godot.writeMethodArguments_PACKED_VECTOR3_ARRAY_PLANE
import godot.writeMethodArguments_VECTOR3
import godot.writeMethodArguments_VECTOR3_VECTOR3_ARRAY
import godot.writeMethodArguments_VECTOR3_VECTOR3_DOUBLE_DOUBLE
import godot.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3
import godot.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_DOUBLE
import godot.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3
import godot.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3_VECTOR3
import kotlin.Any
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Provides a set of helper functions to create geometric shapes, compute intersections between
 * shapes, and process various other geometric operations in 3D.
 */
@GodotBaseType
public object Geometry3D : Object() {
  @JvmField
  public val computeConvexMeshPointsName:
      MethodStringName1<Geometry3D, PackedVector3Array, VariantArray<Plane>> =
      MethodStringName1<Geometry3D, PackedVector3Array, VariantArray<Plane>>("compute_convex_mesh_points")

  @JvmField
  public val buildBoxPlanesName: MethodStringName1<Geometry3D, VariantArray<Plane>, Vector3> =
      MethodStringName1<Geometry3D, VariantArray<Plane>, Vector3>("build_box_planes")

  @JvmField
  public val buildCylinderPlanesName:
      MethodStringName4<Geometry3D, VariantArray<Plane>, Float, Float, Int, Vector3.Axis> =
      MethodStringName4<Geometry3D, VariantArray<Plane>, Float, Float, Int, Vector3.Axis>("build_cylinder_planes")

  @JvmField
  public val buildCapsulePlanesName:
      MethodStringName5<Geometry3D, VariantArray<Plane>, Float, Float, Int, Int, Vector3.Axis> =
      MethodStringName5<Geometry3D, VariantArray<Plane>, Float, Float, Int, Int, Vector3.Axis>("build_capsule_planes")

  @JvmField
  public val getClosestPointsBetweenSegmentsName:
      MethodStringName4<Geometry3D, PackedVector3Array, Vector3, Vector3, Vector3, Vector3> =
      MethodStringName4<Geometry3D, PackedVector3Array, Vector3, Vector3, Vector3, Vector3>("get_closest_points_between_segments")

  @JvmField
  public val getClosestPointToSegmentName:
      MethodStringName3<Geometry3D, Vector3, Vector3, Vector3, Vector3> =
      MethodStringName3<Geometry3D, Vector3, Vector3, Vector3, Vector3>("get_closest_point_to_segment")

  @JvmField
  public val getClosestPointToSegmentUncappedName:
      MethodStringName3<Geometry3D, Vector3, Vector3, Vector3, Vector3> =
      MethodStringName3<Geometry3D, Vector3, Vector3, Vector3, Vector3>("get_closest_point_to_segment_uncapped")

  @JvmField
  public val getTriangleBarycentricCoordsName:
      MethodStringName4<Geometry3D, Vector3, Vector3, Vector3, Vector3, Vector3> =
      MethodStringName4<Geometry3D, Vector3, Vector3, Vector3, Vector3, Vector3>("get_triangle_barycentric_coords")

  @JvmField
  public val rayIntersectsTriangleName:
      MethodStringName5<Geometry3D, Any?, Vector3, Vector3, Vector3, Vector3, Vector3> =
      MethodStringName5<Geometry3D, Any?, Vector3, Vector3, Vector3, Vector3, Vector3>("ray_intersects_triangle")

  @JvmField
  public val segmentIntersectsTriangleName:
      MethodStringName5<Geometry3D, Any?, Vector3, Vector3, Vector3, Vector3, Vector3> =
      MethodStringName5<Geometry3D, Any?, Vector3, Vector3, Vector3, Vector3, Vector3>("segment_intersects_triangle")

  @JvmField
  public val segmentIntersectsSphereName:
      MethodStringName4<Geometry3D, PackedVector3Array, Vector3, Vector3, Vector3, Float> =
      MethodStringName4<Geometry3D, PackedVector3Array, Vector3, Vector3, Vector3, Float>("segment_intersects_sphere")

  @JvmField
  public val segmentIntersectsCylinderName:
      MethodStringName4<Geometry3D, PackedVector3Array, Vector3, Vector3, Float, Float> =
      MethodStringName4<Geometry3D, PackedVector3Array, Vector3, Vector3, Float, Float>("segment_intersects_cylinder")

  @JvmField
  public val segmentIntersectsConvexName:
      MethodStringName3<Geometry3D, PackedVector3Array, Vector3, Vector3, VariantArray<Plane>> =
      MethodStringName3<Geometry3D, PackedVector3Array, Vector3, Vector3, VariantArray<Plane>>("segment_intersects_convex")

  @JvmField
  public val clipPolygonName:
      MethodStringName2<Geometry3D, PackedVector3Array, PackedVector3Array, Plane> =
      MethodStringName2<Geometry3D, PackedVector3Array, PackedVector3Array, Plane>("clip_polygon")

  @JvmField
  public val tetrahedralizeDelaunayName:
      MethodStringName1<Geometry3D, PackedInt32Array, PackedVector3Array> =
      MethodStringName1<Geometry3D, PackedInt32Array, PackedVector3Array>("tetrahedralize_delaunay")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(9)
  }

  /**
   * Calculates and returns all the vertex points of a convex shape defined by an array of [planes].
   */
  @JvmStatic
  public final fun computeConvexMeshPoints(planes: VariantArray<Plane>): PackedVector3Array {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, planes)
    TransferContext.callMethod(MethodBindings.computeConvexMeshPointsPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Returns an array with 6 [Plane]s that describe the sides of a box centered at the origin. The
   * box size is defined by [extents], which represents one (positive) corner of the box (i.e. half its
   * actual size).
   */
  @JvmStatic
  public final fun buildBoxPlanes(extents: Vector3): VariantArray<Plane> {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, extents)
    TransferContext.callMethod(MethodBindings.buildBoxPlanesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Plane>)
  }

  /**
   * Returns an array of [Plane]s closely bounding a faceted cylinder centered at the origin with
   * radius [radius] and height [height]. The parameter [sides] defines how many planes will be
   * generated for the round part of the cylinder. The parameter [axis] describes the axis along which
   * the cylinder is oriented (0 for X, 1 for Y, 2 for Z).
   */
  @JvmOverloads
  @JvmStatic
  public final fun buildCylinderPlanes(
    radius: Float,
    height: Float,
    sides: Int,
    axis: Vector3.Axis = Vector3.Axis.Z,
  ): VariantArray<Plane> {
    TransferContext.writeMethodArguments_DOUBLE_DOUBLE_LONG_LONG(ptr, objectID.id, radius.toDouble(), height.toDouble(), sides.toLong(), axis.value)
    TransferContext.callMethod(MethodBindings.buildCylinderPlanesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Plane>)
  }

  /**
   * Returns an array of [Plane]s closely bounding a faceted capsule centered at the origin with
   * radius [radius] and height [height]. The parameter [sides] defines how many planes will be
   * generated for the side part of the capsule, whereas [lats] gives the number of latitudinal steps
   * at the bottom and top of the capsule. The parameter [axis] describes the axis along which the
   * capsule is oriented (0 for X, 1 for Y, 2 for Z).
   */
  @JvmOverloads
  @JvmStatic
  public final fun buildCapsulePlanes(
    radius: Float,
    height: Float,
    sides: Int,
    lats: Int,
    axis: Vector3.Axis = Vector3.Axis.Z,
  ): VariantArray<Plane> {
    TransferContext.writeMethodArguments_DOUBLE_DOUBLE_LONG_LONG_LONG(ptr, objectID.id, radius.toDouble(), height.toDouble(), sides.toLong(), lats.toLong(), axis.value)
    TransferContext.callMethod(MethodBindings.buildCapsulePlanesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Plane>)
  }

  /**
   * Given the two 3D segments ([p1], [p2]) and ([q1], [q2]), finds those two points on the two
   * segments that are closest to each other. Returns a [PackedVector3Array] that contains this point
   * on ([p1], [p2]) as well the accompanying point on ([q1], [q2]).
   */
  @JvmStatic
  public final fun getClosestPointsBetweenSegments(
    p1: Vector3,
    p2: Vector3,
    q1: Vector3,
    q2: Vector3,
  ): PackedVector3Array {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3(ptr, objectID.id, p1, p2, q1, q2)
    TransferContext.callMethod(MethodBindings.getClosestPointsBetweenSegmentsPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Returns the 3D point on the 3D segment ([s1], [s2]) that is closest to [point]. The returned
   * point will always be inside the specified segment.
   */
  @JvmStatic
  public final fun getClosestPointToSegment(
    point: Vector3,
    s1: Vector3,
    s2: Vector3,
  ): Vector3 {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3(ptr, objectID.id, point, s1, s2)
    TransferContext.callMethod(MethodBindings.getClosestPointToSegmentPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the 3D point on the 3D line defined by ([s1], [s2]) that is closest to [point]. The
   * returned point can be inside the segment ([s1], [s2]) or outside of it, i.e. somewhere on the line
   * extending from the segment.
   */
  @JvmStatic
  public final fun getClosestPointToSegmentUncapped(
    point: Vector3,
    s1: Vector3,
    s2: Vector3,
  ): Vector3 {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3(ptr, objectID.id, point, s1, s2)
    TransferContext.callMethod(MethodBindings.getClosestPointToSegmentUncappedPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns a [Vector3] containing weights based on how close a 3D position ([point]) is to a
   * triangle's different vertices ([a], [b] and [c]). This is useful for interpolating between the
   * data of different vertices in a triangle. One example use case is using this to smoothly rotate
   * over a mesh instead of relying solely on face normals.
   *
   * [url=https://en.wikipedia.org/wiki/Barycentric_coordinate_system]Here is a more detailed
   * explanation of barycentric coordinates.[/url]
   */
  @JvmStatic
  public final fun getTriangleBarycentricCoords(
    point: Vector3,
    a: Vector3,
    b: Vector3,
    c: Vector3,
  ): Vector3 {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3(ptr, objectID.id, point, a, b, c)
    TransferContext.callMethod(MethodBindings.getTriangleBarycentricCoordsPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Tests if the 3D ray starting at [from] with the direction of [dir] intersects the triangle
   * specified by [a], [b] and [c]. If yes, returns the point of intersection as [Vector3]. If no
   * intersection takes place, returns `null`.
   */
  @JvmStatic
  public final fun rayIntersectsTriangle(
    from: Vector3,
    dir: Vector3,
    a: Vector3,
    b: Vector3,
    c: Vector3,
  ): Any? {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3_VECTOR3(ptr, objectID.id, from, dir, a, b, c)
    TransferContext.callMethod(MethodBindings.rayIntersectsTrianglePtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Tests if the segment ([from], [to]) intersects the triangle [a], [b], [c]. If yes, returns the
   * point of intersection as [Vector3]. If no intersection takes place, returns `null`.
   */
  @JvmStatic
  public final fun segmentIntersectsTriangle(
    from: Vector3,
    to: Vector3,
    a: Vector3,
    b: Vector3,
    c: Vector3,
  ): Any? {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_VECTOR3_VECTOR3(ptr, objectID.id, from, to, a, b, c)
    TransferContext.callMethod(MethodBindings.segmentIntersectsTrianglePtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Checks if the segment ([from], [to]) intersects the sphere that is located at [spherePosition]
   * and has radius [sphereRadius]. If no, returns an empty [PackedVector3Array]. If yes, returns a
   * [PackedVector3Array] containing the point of intersection and the sphere's normal at the point of
   * intersection.
   */
  @JvmStatic
  public final fun segmentIntersectsSphere(
    from: Vector3,
    to: Vector3,
    spherePosition: Vector3,
    sphereRadius: Float,
  ): PackedVector3Array {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_VECTOR3_DOUBLE(ptr, objectID.id, from, to, spherePosition, sphereRadius.toDouble())
    TransferContext.callMethod(MethodBindings.segmentIntersectsSpherePtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Checks if the segment ([from], [to]) intersects the cylinder with height [height] that is
   * centered at the origin and has radius [radius]. If no, returns an empty [PackedVector3Array]. If
   * an intersection takes place, the returned array contains the point of intersection and the
   * cylinder's normal at the point of intersection.
   */
  @JvmStatic
  public final fun segmentIntersectsCylinder(
    from: Vector3,
    to: Vector3,
    height: Float,
    radius: Float,
  ): PackedVector3Array {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_DOUBLE_DOUBLE(ptr, objectID.id, from, to, height.toDouble(), radius.toDouble())
    TransferContext.callMethod(MethodBindings.segmentIntersectsCylinderPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Given a convex hull defined though the [Plane]s in the array [planes], tests if the segment
   * ([from], [to]) intersects with that hull. If an intersection is found, returns a
   * [PackedVector3Array] containing the point the intersection and the hull's normal. Otherwise,
   * returns an empty array.
   */
  @JvmStatic
  public final fun segmentIntersectsConvex(
    from: Vector3,
    to: Vector3,
    planes: VariantArray<Plane>,
  ): PackedVector3Array {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3_ARRAY(ptr, objectID.id, from, to, planes)
    TransferContext.callMethod(MethodBindings.segmentIntersectsConvexPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Clips the polygon defined by the points in [points] against the [plane] and returns the points
   * of the clipped polygon.
   */
  @JvmStatic
  public final fun clipPolygon(points: PackedVector3Array, plane: Plane): PackedVector3Array {
    TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY_PLANE(ptr, objectID.id, points, plane)
    TransferContext.callMethod(MethodBindings.clipPolygonPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Tetrahedralizes the volume specified by a discrete set of [points] in 3D space, ensuring that
   * no point lies within the circumsphere of any resulting tetrahedron. The method returns a
   * [PackedInt32Array] where each tetrahedron consists of four consecutive point indices into the
   * [points] array (resulting in an array with `n * 4` elements, where `n` is the number of tetrahedra
   * found). If the tetrahedralization is unsuccessful, an empty [PackedInt32Array] is returned.
   */
  @JvmStatic
  public final fun tetrahedralizeDelaunay(points: PackedVector3Array): PackedInt32Array {
    TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY(ptr, objectID.id, points)
    TransferContext.callMethod(MethodBindings.tetrahedralizeDelaunayPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  public object MethodBindings {
    internal val computeConvexMeshPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "compute_convex_mesh_points", 1936902142)

    internal val buildBoxPlanesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "build_box_planes", 3622277145)

    internal val buildCylinderPlanesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "build_cylinder_planes", 449920067)

    internal val buildCapsulePlanesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "build_capsule_planes", 2113592876)

    internal val getClosestPointsBetweenSegmentsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "get_closest_points_between_segments", 1056373962)

    internal val getClosestPointToSegmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "get_closest_point_to_segment", 2168193209)

    internal val getClosestPointToSegmentUncappedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "get_closest_point_to_segment_uncapped", 2168193209)

    internal val getTriangleBarycentricCoordsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "get_triangle_barycentric_coords", 1362048029)

    internal val rayIntersectsTrianglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "ray_intersects_triangle", 1718655448)

    internal val segmentIntersectsTrianglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "segment_intersects_triangle", 1718655448)

    internal val segmentIntersectsSpherePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "segment_intersects_sphere", 4080141172)

    internal val segmentIntersectsCylinderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "segment_intersects_cylinder", 2361316491)

    internal val segmentIntersectsConvexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "segment_intersects_convex", 537425332)

    internal val clipPolygonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "clip_polygon", 2603188319)

    internal val tetrahedralizeDelaunayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Geometry3D", "tetrahedralize_delaunay", 1230191221)
  }
}
