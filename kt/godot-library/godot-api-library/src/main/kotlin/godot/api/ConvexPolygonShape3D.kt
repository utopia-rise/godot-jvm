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
import godot.core.PackedVector3Array
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.Vector3
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 3D convex polyhedron shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape3D].
 *
 * [ConvexPolygonShape3D] is *solid*, which means it detects collisions from objects that are fully
 * inside it, unlike [ConcavePolygonShape3D] which is hollow. This makes it more suitable for both
 * detection and physics.
 *
 * **Convex decomposition:** A concave polyhedron can be split up into several convex polyhedra.
 * This allows dynamic physics bodies to have complex concave collisions (at a performance cost) and
 * can be achieved by using several [ConvexPolygonShape3D] nodes. To generate a convex decomposition
 * from a mesh, select the [MeshInstance3D] node, go to the **Mesh** menu that appears above the
 * viewport, and choose **Create Multiple Convex Collision Siblings**. Alternatively,
 * [MeshInstance3D.createMultipleConvexCollisions] can be called in a script to perform this
 * decomposition at run-time.
 *
 * **Performance:** [ConvexPolygonShape3D] is faster to check collisions against compared to
 * [ConcavePolygonShape3D], but it is slower than primitive collision shapes such as [SphereShape3D]
 * and [BoxShape3D]. Its use should generally be limited to medium-sized objects that cannot have their
 * collision accurately represented by primitive shapes.
 */
@GodotBaseType
public open class ConvexPolygonShape3D : Shape3D() {
  /**
   * The list of 3D points forming the convex polygon shape.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var points: PackedVector3Array
    @JvmName("pointsProperty")
    get() = getPoints()
    @JvmName("pointsProperty")
    set(`value`) {
      setPoints(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(190, scriptPtr)
  }

  /**
   * This is a helper function for [points] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = convexpolygonshape3d.points
   * //Your changes
   * convexpolygonshape3d.points = myCoreType
   * ``````
   *
   * The list of 3D points forming the convex polygon shape.
   */
  @CoreTypeHelper
  public final fun pointsMutate(block: PackedVector3Array.() -> Unit): PackedVector3Array =
      points.apply {
     block(this)
     points = this
  }

  /**
   * This is a helper function for [points] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The list of 3D points forming the convex polygon shape.
   */
  @CoreTypeHelper
  public final fun pointsMutateEach(block: (index: Int, `value`: Vector3) -> Unit):
      PackedVector3Array = points.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     points = this
  }

  public final fun setPoints(points: PackedVector3Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to points)
    TransferContext.callMethod(MethodBindings.setPointsPtr)
  }

  public final fun getPoints(): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPointsPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  public companion object {
    @JvmField
    public val setPointsName: MethodStringName1<ConvexPolygonShape3D, Unit, PackedVector3Array> =
        MethodStringName1<ConvexPolygonShape3D, Unit, PackedVector3Array>("set_points")

    @JvmField
    public val getPointsName: MethodStringName0<ConvexPolygonShape3D, PackedVector3Array> =
        MethodStringName0<ConvexPolygonShape3D, PackedVector3Array>("get_points")
  }

  public object MethodBindings {
    internal val setPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvexPolygonShape3D", "set_points", 334873810)

    internal val getPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvexPolygonShape3D", "get_points", 497664490)
  }
}
