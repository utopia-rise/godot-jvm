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
import godot.core.MethodStringName2
import godot.core.PackedFloat32Array
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_FLOAT_32_ARRAY
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * GLTFMesh handles 3D mesh data imported from glTF files. It includes properties for blend
 * channels, blend weights, instance materials, and the mesh itself.
 */
@GodotBaseType
public open class GLTFMesh : Resource() {
  /**
   * The original name of the mesh.
   */
  public final inline var originalName: String
    @JvmName("originalNameProperty")
    get() = getOriginalName()
    @JvmName("originalNameProperty")
    set(`value`) {
      setOriginalName(value)
    }

  /**
   * The [ImporterMesh] object representing the mesh itself.
   */
  public final inline var mesh: ImporterMesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
    }

  /**
   * An array of floats representing the blend weights of the mesh.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var blendWeights: PackedFloat32Array
    @JvmName("blendWeightsProperty")
    get() = getBlendWeights()
    @JvmName("blendWeightsProperty")
    set(`value`) {
      setBlendWeights(value)
    }

  /**
   * An array of Material objects representing the materials used in the mesh.
   */
  public final inline var instanceMaterials: VariantArray<Material>
    @JvmName("instanceMaterialsProperty")
    get() = getInstanceMaterials()
    @JvmName("instanceMaterialsProperty")
    set(`value`) {
      setInstanceMaterials(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(248, scriptPtr)
  }

  /**
   * This is a helper function for [blendWeights] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = gltfmesh.blendWeights
   * //Your changes
   * gltfmesh.blendWeights = myCoreType
   * ``````
   *
   * An array of floats representing the blend weights of the mesh.
   */
  @CoreTypeHelper
  public final fun blendWeightsMutate(block: PackedFloat32Array.() -> Unit): PackedFloat32Array =
      blendWeights.apply {
     block(this)
     blendWeights = this
  }

  /**
   * This is a helper function for [blendWeights] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * An array of floats representing the blend weights of the mesh.
   */
  @CoreTypeHelper
  public final fun blendWeightsMutateEach(block: (index: Int, `value`: Float) -> Unit):
      PackedFloat32Array = blendWeights.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     blendWeights = this
  }

  public final fun getOriginalName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginalNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public final fun setOriginalName(originalName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to originalName)
    TransferContext.callMethod(MethodBindings.setOriginalNamePtr)
  }

  public final fun getMesh(): ImporterMesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as ImporterMesh?)
  }

  public final fun setMesh(mesh: ImporterMesh?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh)
    TransferContext.callMethod(MethodBindings.setMeshPtr)
  }

  public final fun getBlendWeights(): PackedFloat32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBlendWeightsPtr)
    return (TransferContext.readReturnValue(PACKED_FLOAT_32_ARRAY) as PackedFloat32Array)
  }

  public final fun setBlendWeights(blendWeights: PackedFloat32Array): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_FLOAT_32_ARRAY to blendWeights)
    TransferContext.callMethod(MethodBindings.setBlendWeightsPtr)
  }

  public final fun getInstanceMaterials(): VariantArray<Material> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInstanceMaterialsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Material>)
  }

  public final fun setInstanceMaterials(instanceMaterials: VariantArray<Material>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ARRAY to instanceMaterials)
    TransferContext.callMethod(MethodBindings.setInstanceMaterialsPtr)
  }

  /**
   * Gets additional arbitrary data in this [GLTFMesh] instance. This can be used to keep per-node
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The argument should be the [GLTFDocumentExtension] name (does not have to match the extension
   * name in the glTF file), and the return value can be anything you set. If nothing was set, the
   * return value is `null`.
   */
  public final fun getAdditionalData(extensionName: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to extensionName)
    TransferContext.callMethod(MethodBindings.getAdditionalDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets additional arbitrary data in this [GLTFMesh] instance. This can be used to keep per-node
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: StringName, additionalData: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to extensionName, ANY to additionalData)
    TransferContext.callMethod(MethodBindings.setAdditionalDataPtr)
  }

  /**
   * Gets additional arbitrary data in this [GLTFMesh] instance. This can be used to keep per-node
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The argument should be the [GLTFDocumentExtension] name (does not have to match the extension
   * name in the glTF file), and the return value can be anything you set. If nothing was set, the
   * return value is `null`.
   */
  public final fun getAdditionalData(extensionName: String): Any? =
      getAdditionalData(extensionName.asCachedStringName())

  /**
   * Sets additional arbitrary data in this [GLTFMesh] instance. This can be used to keep per-node
   * state data in [GLTFDocumentExtension] classes, which is important because they are stateless.
   *
   * The first argument should be the [GLTFDocumentExtension] name (does not have to match the
   * extension name in the glTF file), and the second argument can be anything you want.
   */
  public final fun setAdditionalData(extensionName: String, additionalData: Any?) =
      setAdditionalData(extensionName.asCachedStringName(), additionalData)

  public companion object {
    @JvmField
    public val getOriginalNameName: MethodStringName0<GLTFMesh, String> =
        MethodStringName0<GLTFMesh, String>("get_original_name")

    @JvmField
    public val setOriginalNameName: MethodStringName1<GLTFMesh, Unit, String> =
        MethodStringName1<GLTFMesh, Unit, String>("set_original_name")

    @JvmField
    public val getMeshName: MethodStringName0<GLTFMesh, ImporterMesh?> =
        MethodStringName0<GLTFMesh, ImporterMesh?>("get_mesh")

    @JvmField
    public val setMeshName: MethodStringName1<GLTFMesh, Unit, ImporterMesh?> =
        MethodStringName1<GLTFMesh, Unit, ImporterMesh?>("set_mesh")

    @JvmField
    public val getBlendWeightsName: MethodStringName0<GLTFMesh, PackedFloat32Array> =
        MethodStringName0<GLTFMesh, PackedFloat32Array>("get_blend_weights")

    @JvmField
    public val setBlendWeightsName: MethodStringName1<GLTFMesh, Unit, PackedFloat32Array> =
        MethodStringName1<GLTFMesh, Unit, PackedFloat32Array>("set_blend_weights")

    @JvmField
    public val getInstanceMaterialsName: MethodStringName0<GLTFMesh, VariantArray<Material>> =
        MethodStringName0<GLTFMesh, VariantArray<Material>>("get_instance_materials")

    @JvmField
    public val setInstanceMaterialsName: MethodStringName1<GLTFMesh, Unit, VariantArray<Material>> =
        MethodStringName1<GLTFMesh, Unit, VariantArray<Material>>("set_instance_materials")

    @JvmField
    public val getAdditionalDataName: MethodStringName1<GLTFMesh, Any?, StringName> =
        MethodStringName1<GLTFMesh, Any?, StringName>("get_additional_data")

    @JvmField
    public val setAdditionalDataName: MethodStringName2<GLTFMesh, Unit, StringName, Any?> =
        MethodStringName2<GLTFMesh, Unit, StringName, Any?>("set_additional_data")
  }

  public object MethodBindings {
    internal val getOriginalNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "get_original_name", 2841200299)

    internal val setOriginalNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "set_original_name", 83702148)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "get_mesh", 3754628756)

    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "set_mesh", 2255166972)

    internal val getBlendWeightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "get_blend_weights", 2445143706)

    internal val setBlendWeightsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "set_blend_weights", 2899603908)

    internal val getInstanceMaterialsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "get_instance_materials", 2915620761)

    internal val setInstanceMaterialsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "set_instance_materials", 381264803)

    internal val getAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "get_additional_data", 2138907829)

    internal val setAdditionalDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFMesh", "set_additional_data", 3776071444)
  }
}
