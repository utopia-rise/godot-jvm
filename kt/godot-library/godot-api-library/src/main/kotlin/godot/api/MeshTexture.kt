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
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Simple texture that uses a mesh to draw itself. It's limited because flags can't be changed and
 * region drawing is not supported.
 */
@GodotBaseType
public open class MeshTexture : Texture2D() {
  /**
   * Sets the mesh used to draw. It must be a mesh using 2D vertices.
   */
  public final inline var mesh: Mesh?
    @JvmName("meshProperty")
    get() = getMesh()
    @JvmName("meshProperty")
    set(`value`) {
      setMesh(value)
    }

  /**
   * Sets the base texture that the Mesh will use to draw.
   */
  public final inline var baseTexture: Texture2D?
    @JvmName("baseTextureProperty")
    get() = getBaseTexture()
    @JvmName("baseTextureProperty")
    set(`value`) {
      setBaseTexture(value)
    }

  /**
   * Sets the size of the image, needed for reference.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var imageSize: Vector2
    @JvmName("imageSizeProperty")
    get() = getImageSize()
    @JvmName("imageSizeProperty")
    set(`value`) {
      setImageSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(381, scriptPtr)
  }

  /**
   * This is a helper function for [imageSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = meshtexture.imageSize
   * //Your changes
   * meshtexture.imageSize = myCoreType
   * ``````
   *
   * Sets the size of the image, needed for reference.
   */
  @CoreTypeHelper
  public final fun imageSizeMutate(block: Vector2.() -> Unit): Vector2 = imageSize.apply {
     block(this)
     imageSize = this
  }

  public final fun setMesh(mesh: Mesh?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to mesh)
    TransferContext.callMethod(MethodBindings.setMeshPtr)
  }

  public final fun getMesh(): Mesh? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMeshPtr)
    return (TransferContext.readReturnValue(OBJECT) as Mesh?)
  }

  public final fun setImageSize(size: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to size)
    TransferContext.callMethod(MethodBindings.setImageSizePtr)
  }

  public final fun getImageSize(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getImageSizePtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public final fun setBaseTexture(texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setBaseTexturePtr)
  }

  public final fun getBaseTexture(): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBaseTexturePtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("MeshTexture::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("MeshTexture::_getHeight can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setMeshName: MethodStringName1<MeshTexture, Unit, Mesh?> =
        MethodStringName1<MeshTexture, Unit, Mesh?>("set_mesh")

    @JvmField
    public val getMeshName: MethodStringName0<MeshTexture, Mesh?> =
        MethodStringName0<MeshTexture, Mesh?>("get_mesh")

    @JvmField
    public val setImageSizeName: MethodStringName1<MeshTexture, Unit, Vector2> =
        MethodStringName1<MeshTexture, Unit, Vector2>("set_image_size")

    @JvmField
    public val getImageSizeName: MethodStringName0<MeshTexture, Vector2> =
        MethodStringName0<MeshTexture, Vector2>("get_image_size")

    @JvmField
    public val setBaseTextureName: MethodStringName1<MeshTexture, Unit, Texture2D?> =
        MethodStringName1<MeshTexture, Unit, Texture2D?>("set_base_texture")

    @JvmField
    public val getBaseTextureName: MethodStringName0<MeshTexture, Texture2D?> =
        MethodStringName0<MeshTexture, Texture2D?>("get_base_texture")
  }

  public object MethodBindings {
    internal val setMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshTexture", "set_mesh", 194775623)

    internal val getMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshTexture", "get_mesh", 1808005922)

    internal val setImageSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshTexture", "set_image_size", 743155724)

    internal val getImageSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshTexture", "get_image_size", 3341600327)

    internal val setBaseTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshTexture", "set_base_texture", 4051416890)

    internal val getBaseTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MeshTexture", "get_base_texture", 3635182373)
  }
}
