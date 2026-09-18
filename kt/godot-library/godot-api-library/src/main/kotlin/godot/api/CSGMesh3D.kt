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
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This CSG node allows you to use any mesh resource as a CSG shape, provided it is *manifold*. A
 * manifold shape is closed, does not self-intersect, does not contain internal faces and has no edges
 * that connect to more than two faces. See also [CSGPolygon3D] for drawing 2D extruded polygons to be
 * used as CSG nodes.
 *
 * **Note:** CSG nodes are intended to be used for level prototyping. Creating CSG nodes has a
 * significant CPU cost compared to creating a [MeshInstance3D] with a [PrimitiveMesh]. Moving a CSG
 * node within another CSG node also has a significant CPU cost, so it should be avoided during
 * gameplay.
 */
@GodotBaseType
public open class CSGMesh3D : CSGPrimitive3D() {
  /**
   * The [Mesh] resource to use as a CSG shape.
   *
   * **Note:** Some [Mesh] types such as [PlaneMesh], [PointMesh], [QuadMesh], and [RibbonTrailMesh]
   * are excluded from the type hint for this property, as these primitives are non-*manifold* and thus
   * not compatible with the CSG algorithm.
   *
   * **Note:** When using an [ArrayMesh], all vertex attributes except [Mesh.ARRAY_VERTEX],
   * [Mesh.ARRAY_NORMAL] and [Mesh.ARRAY_TEX_UV] are left unused. Only [Mesh.ARRAY_VERTEX] and
   * [Mesh.ARRAY_TEX_UV] will be passed to the GPU.
   *
   * [Mesh.ARRAY_NORMAL] is only used to determine which faces require the use of flat shading. By
   * default, CSGMesh will ignore the mesh's vertex normals, recalculate them for each vertex and use a
   * smooth shader. If a flat shader is required for a face, ensure that all vertex normals of the face
   * are approximately equal.
   */
  public final inline var mesh: Mesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
    }

  /**
   * The [Material] used in drawing the CSG shape.
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(126, scriptPtr)
  }

  public final fun setMesh(mesh: Mesh?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, mesh)
    TransferContext.callPtrMethod(MethodBindings.setMeshPtr, 0)
  }

  public final fun getMesh(): Mesh? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMeshPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Mesh?)
  }

  public final fun setMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, material)
    TransferContext.callPtrMethod(MethodBindings.setMaterialPtr, 0)
  }

  public final fun getMaterial(): Material? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaterialPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Material?)
  }

  public companion object {
    @JvmField
    public val setMeshName: MethodStringName1<CSGMesh3D, Unit, Mesh?> =
        MethodStringName1<CSGMesh3D, Unit, Mesh?>("set_mesh")

    @JvmField
    public val getMeshName: MethodStringName0<CSGMesh3D, Mesh?> =
        MethodStringName0<CSGMesh3D, Mesh?>("get_mesh")

    @JvmField
    public val setMaterialName: MethodStringName1<CSGMesh3D, Unit, Material?> =
        MethodStringName1<CSGMesh3D, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<CSGMesh3D, Material?> =
        MethodStringName0<CSGMesh3D, Material?>("get_material")
  }

  public object MethodBindings {
    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGMesh3D", "set_mesh", 194775623)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGMesh3D", "get_mesh", 4081188045)

    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGMesh3D", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CSGMesh3D", "get_material", 5934680)
  }
}
