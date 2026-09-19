// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod_COLOR
import godot.callPtrMethod_LONG_OBJECT
import godot.callPtrMethod_PLANE
import godot.callPtrMethod_VECTOR2
import godot.callPtrMethod_VECTOR3
import godot.common.interop.VoidPtr
import godot.core.AABB
import godot.core.Color
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Plane
import godot.core.StringName
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector3
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A mesh type optimized for creating geometry manually, similar to OpenGL 1.x immediate mode.
 *
 * Here's a sample on how to generate a triangular face:
 *
 * ```gdscript
 * //gdscript
 * var mesh = ImmediateMesh.new()
 * mesh.surface_begin(Mesh.PRIMITIVE_TRIANGLES)
 * mesh.surface_add_vertex(Vector3.LEFT)
 * mesh.surface_add_vertex(Vector3.FORWARD)
 * mesh.surface_add_vertex(Vector3.ZERO)
 * mesh.surface_end()
 * ```
 *
 * ```csharp
 * //csharp
 * var mesh = new ImmediateMesh();
 * mesh.SurfaceBegin(Mesh.PrimitiveType.Triangles);
 * mesh.SurfaceAddVertex(Vector3.Left);
 * mesh.SurfaceAddVertex(Vector3.Forward);
 * mesh.SurfaceAddVertex(Vector3.Zero);
 * mesh.SurfaceEnd();
 * ```
 *
 * **Note:** Generating complex geometries with [ImmediateMesh] is highly inefficient. Instead, it
 * is designed to generate simple geometry that changes often.
 */
@GodotBaseType
public open class ImmediateMesh : Mesh() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(304, scriptPtr)
  }

  /**
   * Begin a new surface.
   */
  @JvmOverloads
  public final fun surfaceBegin(primitive: Mesh.PrimitiveType, material: Material? = null): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.surfaceBeginPtr, primitive.value, material)
  }

  /**
   * Set the color attribute that will be pushed with the next vertex.
   */
  public final fun surfaceSetColor(color: Color): Unit {
    TransferContext.callPtrMethod_COLOR(ptr, objectID.id, MethodBindings.surfaceSetColorPtr, color)
  }

  /**
   * Set the normal attribute that will be pushed with the next vertex.
   */
  public final fun surfaceSetNormal(normal: Vector3): Unit {
    TransferContext.callPtrMethod_VECTOR3(ptr, objectID.id, MethodBindings.surfaceSetNormalPtr, normal)
  }

  /**
   * Set the tangent attribute that will be pushed with the next vertex.
   *
   * **Note:** Even though [tangent] is a [Plane], it does not directly represent the tangent plane.
   * Its [Plane.x], [Plane.y], and [Plane.z] represent the tangent vector and [Plane.d] should be
   * either `-1` or `1`. See also [Mesh.ARRAY_TANGENT].
   */
  public final fun surfaceSetTangent(tangent: Plane): Unit {
    TransferContext.callPtrMethod_PLANE(ptr, objectID.id, MethodBindings.surfaceSetTangentPtr, tangent)
  }

  /**
   * Set the UV attribute that will be pushed with the next vertex.
   */
  public final fun surfaceSetUv(uv: Vector2): Unit {
    TransferContext.callPtrMethod_VECTOR2(ptr, objectID.id, MethodBindings.surfaceSetUvPtr, uv)
  }

  /**
   * Set the UV2 attribute that will be pushed with the next vertex.
   */
  public final fun surfaceSetUv2(uv2: Vector2): Unit {
    TransferContext.callPtrMethod_VECTOR2(ptr, objectID.id, MethodBindings.surfaceSetUv2Ptr, uv2)
  }

  /**
   * Add a 3D vertex using the current attributes previously set.
   */
  public final fun surfaceAddVertex(vertex: Vector3): Unit {
    TransferContext.callPtrMethod_VECTOR3(ptr, objectID.id, MethodBindings.surfaceAddVertexPtr, vertex)
  }

  /**
   * Add a 2D vertex using the current attributes previously set.
   */
  public final fun surfaceAddVertex2d(vertex: Vector2): Unit {
    TransferContext.callPtrMethod_VECTOR2(ptr, objectID.id, MethodBindings.surfaceAddVertex2dPtr, vertex)
  }

  /**
   * End and commit current surface. Note that surface being created will not be visible until this
   * function is called.
   */
  public final fun surfaceEnd(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.surfaceEndPtr)
  }

  /**
   * Clear all surfaces.
   */
  public final fun clearSurfaces(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearSurfacesPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getSurfaceCount(): Int {
    throw NotImplementedError("ImmediateMesh::_getSurfaceCount can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetArrayLen(index: Int): Int {
    throw NotImplementedError("ImmediateMesh::_surfaceGetArrayLen can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetArrayIndexLen(index: Int): Int {
    throw NotImplementedError("ImmediateMesh::_surfaceGetArrayIndexLen can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetArrays(index: Int): VariantArray<Any?> {
    throw NotImplementedError("ImmediateMesh::_surfaceGetArrays can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetBlendShapeArrays(index: Int): VariantArray<VariantArray<Any?>> {
    throw NotImplementedError("ImmediateMesh::_surfaceGetBlendShapeArrays can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetLods(index: Int): Dictionary<Any?, Any?> {
    throw NotImplementedError("ImmediateMesh::_surfaceGetLods can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetFormat(index: Int): Long {
    throw NotImplementedError("ImmediateMesh::_surfaceGetFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetPrimitiveType(index: Int): Long {
    throw NotImplementedError("ImmediateMesh::_surfaceGetPrimitiveType can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceSetMaterial(index: Int, material: Material?): Unit {
    throw NotImplementedError("ImmediateMesh::_surfaceSetMaterial can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetMaterial(index: Int): Material? {
    throw NotImplementedError("ImmediateMesh::_surfaceGetMaterial can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getBlendShapeCount(): Int {
    throw NotImplementedError("ImmediateMesh::_getBlendShapeCount can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getBlendShapeName(index: Int): StringName {
    throw NotImplementedError("ImmediateMesh::_getBlendShapeName can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _setBlendShapeName(index: Int, name: StringName): Unit {
    throw NotImplementedError("ImmediateMesh::_setBlendShapeName can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getAabb(): AABB {
    throw NotImplementedError("ImmediateMesh::_getAabb can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val surfaceBeginName:
        MethodStringName2<ImmediateMesh, Unit, Mesh.PrimitiveType, Material?> =
        MethodStringName2<ImmediateMesh, Unit, Mesh.PrimitiveType, Material?>("surface_begin")

    @JvmField
    public val surfaceSetColorName: MethodStringName1<ImmediateMesh, Unit, Color> =
        MethodStringName1<ImmediateMesh, Unit, Color>("surface_set_color")

    @JvmField
    public val surfaceSetNormalName: MethodStringName1<ImmediateMesh, Unit, Vector3> =
        MethodStringName1<ImmediateMesh, Unit, Vector3>("surface_set_normal")

    @JvmField
    public val surfaceSetTangentName: MethodStringName1<ImmediateMesh, Unit, Plane> =
        MethodStringName1<ImmediateMesh, Unit, Plane>("surface_set_tangent")

    @JvmField
    public val surfaceSetUvName: MethodStringName1<ImmediateMesh, Unit, Vector2> =
        MethodStringName1<ImmediateMesh, Unit, Vector2>("surface_set_uv")

    @JvmField
    public val surfaceSetUv2Name: MethodStringName1<ImmediateMesh, Unit, Vector2> =
        MethodStringName1<ImmediateMesh, Unit, Vector2>("surface_set_uv2")

    @JvmField
    public val surfaceAddVertexName: MethodStringName1<ImmediateMesh, Unit, Vector3> =
        MethodStringName1<ImmediateMesh, Unit, Vector3>("surface_add_vertex")

    @JvmField
    public val surfaceAddVertex2dName: MethodStringName1<ImmediateMesh, Unit, Vector2> =
        MethodStringName1<ImmediateMesh, Unit, Vector2>("surface_add_vertex_2d")

    @JvmField
    public val surfaceEndName: MethodStringName0<ImmediateMesh, Unit> =
        MethodStringName0<ImmediateMesh, Unit>("surface_end")

    @JvmField
    public val clearSurfacesName: MethodStringName0<ImmediateMesh, Unit> =
        MethodStringName0<ImmediateMesh, Unit>("clear_surfaces")
  }

  public object MethodBindings {
    internal val surfaceBeginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_begin", 2794442543)

    internal val surfaceSetColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_set_color", 2920490490)

    internal val surfaceSetNormalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_set_normal", 3460891852)

    internal val surfaceSetTangentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_set_tangent", 3505987427)

    internal val surfaceSetUvPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_set_uv", 743155724)

    internal val surfaceSetUv2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_set_uv2", 743155724)

    internal val surfaceAddVertexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_add_vertex", 3460891852)

    internal val surfaceAddVertex2dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_add_vertex_2d", 743155724)

    internal val surfaceEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "surface_end", 3218959716)

    internal val clearSurfacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ImmediateMesh", "clear_surfaces", 3218959716)
  }
}
