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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedVector3Array
import godot.core.Vector3
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_PACKED_VECTOR3_ARRAY
import godot.writeMethodArguments0
import godot.writeMethodArguments_PACKED_VECTOR3_ARRAY
import godot.writeMethodArguments_VECTOR3_VECTOR3
import kotlin.Any
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Creates a bounding volume hierarchy (BVH) tree structure around triangle geometry.
 *
 * The triangle BVH tree can be used for efficient intersection queries without involving a physics
 * engine.
 *
 * For example, this can be used in editor tools to select objects with complex shapes based on the
 * mouse cursor position.
 *
 * **Performance:** Creating the BVH tree for complex geometry is a slow process and best done in a
 * background thread.
 */
@GodotBaseType
public open class TriangleMesh : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(773, scriptPtr)
  }

  /**
   * Creates the BVH tree from an array of faces. Each 3 vertices of the input [faces] array
   * represent one triangle (face).
   *
   * Returns `true` if the tree is successfully built, `false` otherwise.
   */
  public final fun createFromFaces(faces: PackedVector3Array): Boolean {
    TransferContext.writeMethodArguments_PACKED_VECTOR3_ARRAY(ptr, objectID.id, faces)
    TransferContext.callMethod(MethodBindings.createFromFacesPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a copy of the geometry faces. Each 3 vertices of the array represent one triangle
   * (face).
   */
  public final fun getFaces(): PackedVector3Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFacesPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  /**
   * Tests for intersection with a segment going from [begin] to [end].
   *
   * If an intersection with a triangle happens returns a [Dictionary] with the following fields:
   *
   * `position`: The position on the intersected triangle.
   *
   * `normal`: The normal of the intersected triangle.
   *
   * `face_index`: The index of the intersected triangle.
   *
   * Returns an empty [Dictionary] if no intersection happens.
   *
   * See also [intersectRay], which is similar but uses an infinite-length ray.
   */
  public final fun intersectSegment(begin: Vector3, end: Vector3): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3(ptr, objectID.id, begin, end)
    TransferContext.callMethod(MethodBindings.intersectSegmentPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Tests for intersection with a ray starting at [begin] and facing [dir] and extending toward
   * infinity.
   *
   * If an intersection with a triangle happens, returns a [Dictionary] with the following fields:
   *
   * `position`: The position on the intersected triangle.
   *
   * `normal`: The normal of the intersected triangle.
   *
   * `face_index`: The index of the intersected triangle.
   *
   * Returns an empty [Dictionary] if no intersection happens.
   *
   * See also [intersectSegment], which is similar but uses a finite-length segment.
   */
  public final fun intersectRay(begin: Vector3, dir: Vector3): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments_VECTOR3_VECTOR3(ptr, objectID.id, begin, dir)
    TransferContext.callMethod(MethodBindings.intersectRayPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  public companion object {
    @JvmField
    public val createFromFacesName: MethodStringName1<TriangleMesh, Boolean, PackedVector3Array> =
        MethodStringName1<TriangleMesh, Boolean, PackedVector3Array>("create_from_faces")

    @JvmField
    public val getFacesName: MethodStringName0<TriangleMesh, PackedVector3Array> =
        MethodStringName0<TriangleMesh, PackedVector3Array>("get_faces")

    @JvmField
    public val intersectSegmentName:
        MethodStringName2<TriangleMesh, Dictionary<Any?, Any?>, Vector3, Vector3> =
        MethodStringName2<TriangleMesh, Dictionary<Any?, Any?>, Vector3, Vector3>("intersect_segment")

    @JvmField
    public val intersectRayName:
        MethodStringName2<TriangleMesh, Dictionary<Any?, Any?>, Vector3, Vector3> =
        MethodStringName2<TriangleMesh, Dictionary<Any?, Any?>, Vector3, Vector3>("intersect_ray")
  }

  public object MethodBindings {
    internal val createFromFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TriangleMesh", "create_from_faces", 2637816732)

    internal val getFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TriangleMesh", "get_faces", 497664490)

    internal val intersectSegmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TriangleMesh", "intersect_segment", 3648293151)

    internal val intersectRayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TriangleMesh", "intersect_ray", 3648293151)
  }
}
