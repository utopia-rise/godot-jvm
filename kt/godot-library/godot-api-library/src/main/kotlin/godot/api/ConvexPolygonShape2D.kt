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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.PackedVector2Array
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import godot.core.Vector2
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 2D convex polygon shape, intended for use in physics. Used internally in [CollisionPolygon2D]
 * when it's in [CollisionPolygon2D.BUILD_SOLIDS] mode.
 *
 * [ConvexPolygonShape2D] is *solid*, which means it detects collisions from objects that are fully
 * inside it, unlike [ConcavePolygonShape2D] which is hollow. This makes it more suitable for both
 * detection and physics.
 *
 * **Convex decomposition:** A concave polygon can be split up into several convex polygons. This
 * allows dynamic physics bodies to have complex concave collisions (at a performance cost) and can be
 * achieved by using several [ConvexPolygonShape2D] nodes or by using the [CollisionPolygon2D] node in
 * [CollisionPolygon2D.BUILD_SOLIDS] mode. To generate a collision polygon from a sprite, select the
 * [Sprite2D] node, go to the **Sprite2D** menu that appears above the viewport, and choose **Create
 * Polygon2D Sibling**.
 *
 * **Performance:** [ConvexPolygonShape2D] is faster to check collisions against compared to
 * [ConcavePolygonShape2D], but it is slower than primitive collision shapes such as [CircleShape2D]
 * and [RectangleShape2D]. Its use should generally be limited to medium-sized objects that cannot have
 * their collision accurately represented by primitive shapes.
 */
@GodotBaseType
public open class ConvexPolygonShape2D : Shape2D() {
  /**
   * The polygon's list of vertices that form a convex hull. Can be in either clockwise or
   * counterclockwise order.
   *
   * **Warning:** Only set this property to a list of points that actually form a convex hull. Use
   * [setPointCloud] to generate the convex hull of an arbitrary set of points.
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

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(189, scriptPtr)
  }

  /**
   * This is a helper function for [points] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = convexpolygonshape2d.points
   * //Your changes
   * convexpolygonshape2d.points = myCoreType
   * ``````
   *
   * The polygon's list of vertices that form a convex hull. Can be in either clockwise or
   * counterclockwise order.
   *
   * **Warning:** Only set this property to a list of points that actually form a convex hull. Use
   * [setPointCloud] to generate the convex hull of an arbitrary set of points.
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
   * The polygon's list of vertices that form a convex hull. Can be in either clockwise or
   * counterclockwise order.
   *
   * **Warning:** Only set this property to a list of points that actually form a convex hull. Use
   * [setPointCloud] to generate the convex hull of an arbitrary set of points.
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
   * Based on the set of points provided, this assigns the [points] property using the convex hull
   * algorithm, removing all unneeded points. See [Geometry2D.convexHull] for details.
   */
  public final fun setPointCloud(pointCloud: PackedVector2Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR2_ARRAY to pointCloud)
    TransferContext.callMethod(MethodBindings.setPointCloudPtr)
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

  public companion object {
    @JvmField
    public val setPointCloudName: MethodStringName1<ConvexPolygonShape2D, Unit, PackedVector2Array>
        = MethodStringName1<ConvexPolygonShape2D, Unit, PackedVector2Array>("set_point_cloud")

    @JvmField
    public val setPointsName: MethodStringName1<ConvexPolygonShape2D, Unit, PackedVector2Array> =
        MethodStringName1<ConvexPolygonShape2D, Unit, PackedVector2Array>("set_points")

    @JvmField
    public val getPointsName: MethodStringName0<ConvexPolygonShape2D, PackedVector2Array> =
        MethodStringName0<ConvexPolygonShape2D, PackedVector2Array>("get_points")
  }

  public object MethodBindings {
    internal val setPointCloudPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvexPolygonShape2D", "set_point_cloud", 1509147220)

    internal val setPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvexPolygonShape2D", "set_points", 1509147220)

    internal val getPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvexPolygonShape2D", "get_points", 2961356807)
  }
}
