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
import godot.core.AABB
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.OBJECT
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Base class for all primitive meshes. Handles applying a [Material] to a primitive mesh. Examples
 * include [BoxMesh], [CapsuleMesh], [CylinderMesh], [PlaneMesh], [PrismMesh], and [SphereMesh].
 */
@GodotBaseType
public open class PrimitiveMesh : Mesh() {
  /**
   * The current [Material] of the primitive mesh.
   */
  public final inline var material: Material?
    @JvmName("materialProperty")
    get() = getMaterial()
    @JvmName("materialProperty")
    set(`value`) {
      setMaterial(value)
    }

  /**
   * Overrides the [AABB] with one defined by user for use with frustum culling. Especially useful
   * to avoid unexpected culling when using a shader to offset vertices.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var customAabb: AABB
    @JvmName("customAabbProperty")
    get() = getCustomAabb()
    @JvmName("customAabbProperty")
    set(`value`) {
      setCustomAabb(value)
    }

  /**
   * If `true`, the order of the vertices in each triangle is reversed, resulting in the backside of
   * the mesh being drawn.
   *
   * This gives the same result as using [BaseMaterial3D.CULL_FRONT] in [BaseMaterial3D.cullMode].
   */
  public final inline var flipFaces: Boolean
    @JvmName("flipFacesProperty")
    get() = getFlipFaces()
    @JvmName("flipFacesProperty")
    set(`value`) {
      setFlipFaces(value)
    }

  /**
   * If set, generates UV2 UV coordinates applying a padding using the [uv2Padding] setting. UV2 is
   * needed for lightmapping.
   */
  public final inline var addUv2: Boolean
    @JvmName("addUv2Property")
    get() = getAddUv2()
    @JvmName("addUv2Property")
    set(`value`) {
      setAddUv2(value)
    }

  /**
   * If [addUv2] is set, specifies the padding in pixels applied along seams of the mesh. Lower
   * padding values allow making better use of the lightmap texture (resulting in higher texel
   * density), but may introduce visible lightmap bleeding along edges.
   *
   * If the size of the lightmap texture can't be determined when generating the mesh, UV2 is
   * calculated assuming a texture size of 1024x1024.
   */
  public final inline var uv2Padding: Float
    @JvmName("uv2PaddingProperty")
    get() = getUv2Padding()
    @JvmName("uv2PaddingProperty")
    set(`value`) {
      setUv2Padding(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(570, scriptPtr)
  }

  /**
   * This is a helper function for [customAabb] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = primitivemesh.customAabb
   * //Your changes
   * primitivemesh.customAabb = myCoreType
   * ``````
   *
   * Overrides the [AABB] with one defined by user for use with frustum culling. Especially useful
   * to avoid unexpected culling when using a shader to offset vertices.
   */
  @CoreTypeHelper
  public final fun customAabbMutate(block: AABB.() -> Unit): AABB = customAabb.apply {
     block(this)
     customAabb = this
  }

  /**
   * Override this method to customize how this primitive mesh should be generated. Should return an
   * [Array] where each element is another Array of values required for the mesh (see the
   * [Mesh.ArrayType] constants).
   */
  public open fun _createMeshArray(): VariantArray<Any?> {
    throw NotImplementedError("PrimitiveMesh::_createMeshArray is not implemented.")
  }

  public final fun setMaterial(material: Material?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to material)
    TransferContext.callMethod(MethodBindings.setMaterialPtr)
  }

  public final fun getMaterial(): Material? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaterialPtr)
    return (TransferContext.readReturnValue(OBJECT) as Material?)
  }

  /**
   * Returns the mesh arrays used to make up the surface of this primitive mesh.
   *
   * **Example:** Pass the result to [ArrayMesh.addSurfaceFromArrays] to create a new surface:
   *
   * ```gdscript
   * //gdscript
   * var c = CylinderMesh.new()
   * var arr_mesh = ArrayMesh.new()
   * arr_mesh.add_surface_from_arrays(Mesh.PRIMITIVE_TRIANGLES, c.get_mesh_arrays())
   * ```
   *
   * ```csharp
   * //csharp
   * var c = new CylinderMesh();
   * var arrMesh = new ArrayMesh();
   * arrMesh.AddSurfaceFromArrays(Mesh.PrimitiveType.Triangles, c.GetMeshArrays());
   * ```
   */
  public final fun getMeshArrays(): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshArraysPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  public final fun setCustomAabb(aabb: AABB): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, godot.core.VariantParser.AABB to aabb)
    TransferContext.callMethod(MethodBindings.setCustomAabbPtr)
  }

  public final fun getCustomAabb(): AABB {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomAabbPtr)
    return (TransferContext.readReturnValue(godot.core.VariantParser.AABB) as AABB)
  }

  public final fun setFlipFaces(flipFaces: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to flipFaces)
    TransferContext.callMethod(MethodBindings.setFlipFacesPtr)
  }

  public final fun getFlipFaces(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFlipFacesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAddUv2(addUv2: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to addUv2)
    TransferContext.callMethod(MethodBindings.setAddUv2Ptr)
  }

  public final fun getAddUv2(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAddUv2Ptr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUv2Padding(uv2Padding: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to uv2Padding.toDouble())
    TransferContext.callMethod(MethodBindings.setUv2PaddingPtr)
  }

  public final fun getUv2Padding(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUv2PaddingPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Request an update of this primitive mesh based on its properties.
   */
  public final fun requestUpdate(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.requestUpdatePtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getSurfaceCount(): Int {
    throw NotImplementedError("PrimitiveMesh::_getSurfaceCount can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetArrayLen(index: Int): Int {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetArrayLen can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetArrayIndexLen(index: Int): Int {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetArrayIndexLen can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetArrays(index: Int): VariantArray<Any?> {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetArrays can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetBlendShapeArrays(index: Int): VariantArray<VariantArray<Any?>> {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetBlendShapeArrays can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetLods(index: Int): Dictionary<Any?, Any?> {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetLods can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetFormat(index: Int): Long {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetPrimitiveType(index: Int): Long {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetPrimitiveType can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceSetMaterial(index: Int, material: Material?): Unit {
    throw NotImplementedError("PrimitiveMesh::_surfaceSetMaterial can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _surfaceGetMaterial(index: Int): Material? {
    throw NotImplementedError("PrimitiveMesh::_surfaceGetMaterial can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getBlendShapeCount(): Int {
    throw NotImplementedError("PrimitiveMesh::_getBlendShapeCount can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getBlendShapeName(index: Int): StringName {
    throw NotImplementedError("PrimitiveMesh::_getBlendShapeName can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _setBlendShapeName(index: Int, name: StringName): Unit {
    throw NotImplementedError("PrimitiveMesh::_setBlendShapeName can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getAabb(): AABB {
    throw NotImplementedError("PrimitiveMesh::_getAabb can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setMaterialName: MethodStringName1<PrimitiveMesh, Unit, Material?> =
        MethodStringName1<PrimitiveMesh, Unit, Material?>("set_material")

    @JvmField
    public val getMaterialName: MethodStringName0<PrimitiveMesh, Material?> =
        MethodStringName0<PrimitiveMesh, Material?>("get_material")

    @JvmField
    public val getMeshArraysName: MethodStringName0<PrimitiveMesh, VariantArray<Any?>> =
        MethodStringName0<PrimitiveMesh, VariantArray<Any?>>("get_mesh_arrays")

    @JvmField
    public val setCustomAabbName: MethodStringName1<PrimitiveMesh, Unit, AABB> =
        MethodStringName1<PrimitiveMesh, Unit, AABB>("set_custom_aabb")

    @JvmField
    public val getCustomAabbName: MethodStringName0<PrimitiveMesh, AABB> =
        MethodStringName0<PrimitiveMesh, AABB>("get_custom_aabb")

    @JvmField
    public val setFlipFacesName: MethodStringName1<PrimitiveMesh, Unit, Boolean> =
        MethodStringName1<PrimitiveMesh, Unit, Boolean>("set_flip_faces")

    @JvmField
    public val getFlipFacesName: MethodStringName0<PrimitiveMesh, Boolean> =
        MethodStringName0<PrimitiveMesh, Boolean>("get_flip_faces")

    @JvmField
    public val setAddUv2Name: MethodStringName1<PrimitiveMesh, Unit, Boolean> =
        MethodStringName1<PrimitiveMesh, Unit, Boolean>("set_add_uv2")

    @JvmField
    public val getAddUv2Name: MethodStringName0<PrimitiveMesh, Boolean> =
        MethodStringName0<PrimitiveMesh, Boolean>("get_add_uv2")

    @JvmField
    public val setUv2PaddingName: MethodStringName1<PrimitiveMesh, Unit, Float> =
        MethodStringName1<PrimitiveMesh, Unit, Float>("set_uv2_padding")

    @JvmField
    public val getUv2PaddingName: MethodStringName0<PrimitiveMesh, Float> =
        MethodStringName0<PrimitiveMesh, Float>("get_uv2_padding")

    @JvmField
    public val requestUpdateName: MethodStringName0<PrimitiveMesh, Unit> =
        MethodStringName0<PrimitiveMesh, Unit>("request_update")
  }

  public object MethodBindings {
    internal val setMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "set_material", 2757459619)

    internal val getMaterialPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "get_material", 5934680)

    internal val getMeshArraysPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "get_mesh_arrays", 3995934104)

    internal val setCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "set_custom_aabb", 259215842)

    internal val getCustomAabbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "get_custom_aabb", 1068685055)

    internal val setFlipFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "set_flip_faces", 2586408642)

    internal val getFlipFacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "get_flip_faces", 36873697)

    internal val setAddUv2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "set_add_uv2", 2586408642)

    internal val getAddUv2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "get_add_uv2", 36873697)

    internal val setUv2PaddingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "set_uv2_padding", 373806689)

    internal val getUv2PaddingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "get_uv2_padding", 1740695150)

    internal val requestUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PrimitiveMesh", "request_update", 3218959716)
  }
}
