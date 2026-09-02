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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.PACKED_VECTOR3_ARRAY
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A 3D trimesh shape, intended for use in physics. Usually used to provide a shape for a
 * [CollisionShape3D].
 *
 * Being just a collection of interconnected triangles, [ConcavePolygonShape3D] is the most freely
 * configurable single 3D shape. It can be used to form polyhedra of any nature, or even shapes that
 * don't enclose a volume. However, [ConcavePolygonShape3D] is *hollow* even if the interconnected
 * triangles do enclose a volume, which often makes it unsuitable for physics or detection.
 *
 * **Note:** When used for collision, [ConcavePolygonShape3D] is intended to work with static
 * [CollisionShape3D] nodes like [StaticBody3D] and will likely not behave well for [CharacterBody3D]s
 * or [RigidBody3D]s in a mode other than Static.
 *
 * **Warning:** Physics bodies that are small have a chance to clip through this shape when moving
 * fast. This happens because on one frame, the physics body may be on the "outside" of the shape, and
 * on the next frame it may be "inside" it. [ConcavePolygonShape3D] is hollow, so it won't detect a
 * collision.
 *
 * **Performance:** Due to its complexity, [ConcavePolygonShape3D] is the slowest 3D collision shape
 * to check collisions against. Its use should generally be limited to level geometry. For convex
 * geometry, [ConvexPolygonShape3D] should be used. For dynamic physics bodies that need concave
 * collision, several [ConvexPolygonShape3D]s can be used to represent its collision by using convex
 * decomposition; see [ConvexPolygonShape3D]'s documentation for instructions.
 */
@GodotBaseType
public open class ConcavePolygonShape3D : Shape3D() {
  /**
   *
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var `data`: PackedVector3Array
    @JvmName("dataProperty")
    get() = getFaces()
    @JvmName("dataProperty")
    set(`value`) {
      setFaces(value)
    }

  /**
   * If set to `true`, collisions occur on both sides of the concave shape faces. Otherwise they
   * occur only along the face normals.
   */
  public final inline var backfaceCollision: Boolean
    @JvmName("backfaceCollisionProperty")
    get() = isBackfaceCollisionEnabled()
    @JvmName("backfaceCollisionProperty")
    set(`value`) {
      setBackfaceCollisionEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(182, scriptPtr)
  }

  /**
   * This is a helper function for [data] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = concavepolygonshape3d.data
   * //Your changes
   * concavepolygonshape3d.data = myCoreType
   * ``````
   */
  @CoreTypeHelper
  public final fun dataMutate(block: PackedVector3Array.() -> Unit): PackedVector3Array =
      data.apply {
     block(this)
     data = this
  }

  /**
   * This is a helper function for [data] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   */
  @CoreTypeHelper
  public final fun dataMutateEach(block: (index: Int, `value`: Vector3) -> Unit): PackedVector3Array
      = data.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     data = this
  }

  /**
   * Sets the faces of the trimesh shape from an array of vertices. The [faces] array should be
   * composed of triples such that each triple of vertices defines a triangle.
   */
  public final fun setFaces(faces: PackedVector3Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_VECTOR3_ARRAY to faces)
    TransferContext.callMethod(MethodBindings.setFacesPtr)
  }

  /**
   * Returns the faces of the trimesh shape as an array of vertices. The array (of length divisible
   * by three) is naturally divided into triples; each triple of vertices defines a triangle.
   */
  public final fun getFaces(): PackedVector3Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFacesPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR3_ARRAY) as PackedVector3Array)
  }

  public final fun setBackfaceCollisionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setBackfaceCollisionEnabledPtr)
  }

  public final fun isBackfaceCollisionEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isBackfaceCollisionEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setFacesName: MethodStringName1<ConcavePolygonShape3D, Unit, PackedVector3Array> =
        MethodStringName1<ConcavePolygonShape3D, Unit, PackedVector3Array>("set_faces")

    @JvmField
    public val getFacesName: MethodStringName0<ConcavePolygonShape3D, PackedVector3Array> =
        MethodStringName0<ConcavePolygonShape3D, PackedVector3Array>("get_faces")

    @JvmField
    public val setBackfaceCollisionEnabledName:
        MethodStringName1<ConcavePolygonShape3D, Unit, Boolean> =
        MethodStringName1<ConcavePolygonShape3D, Unit, Boolean>("set_backface_collision_enabled")

    @JvmField
    public val isBackfaceCollisionEnabledName: MethodStringName0<ConcavePolygonShape3D, Boolean> =
        MethodStringName0<ConcavePolygonShape3D, Boolean>("is_backface_collision_enabled")
  }

  public object MethodBindings {
    internal val setFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConcavePolygonShape3D", "set_faces", 334873810)

    internal val getFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConcavePolygonShape3D", "get_faces", 497664490)

    internal val setBackfaceCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConcavePolygonShape3D", "set_backface_collision_enabled", 2586408642)

    internal val isBackfaceCollisionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConcavePolygonShape3D", "is_backface_collision_enabled", 36873697)
  }
}
