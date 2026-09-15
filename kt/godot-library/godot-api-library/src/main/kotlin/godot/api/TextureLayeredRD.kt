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
import godot.core.RID
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_RID
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Base class for [Texture2DArrayRD], [TextureCubemapRD] and [TextureCubemapArrayRD]. Cannot be used
 * directly, but contains all the functions necessary for accessing the derived resource types.
 *
 * **Note:** [TextureLayeredRD] is intended for low-level usage with [RenderingDevice]. For most use
 * cases, use [TextureLayered] instead.
 */
@GodotBaseType
public open class TextureLayeredRD internal constructor() : TextureLayered() {
  /**
   * The RID of the texture object created on the [RenderingDevice].
   */
  public final inline var textureRdRid: RID
    @JvmName("textureRdRidProperty")
    get() = getTextureRdRid()
    @JvmName("textureRdRidProperty")
    set(`value`) {
      setTextureRdRid(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(750, scriptPtr)
  }

  public final fun setTextureRdRid(textureRdRid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, textureRdRid)
    TransferContext.callPtrMethod(MethodBindings.setTextureRdRidPtr, 0)
  }

  public final fun getTextureRdRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextureRdRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getFormat(): Image.Format {
    throw NotImplementedError("TextureLayeredRD::_getFormat can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayeredType(): Long {
    throw NotImplementedError("TextureLayeredRD::_getLayeredType can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getWidth(): Int {
    throw NotImplementedError("TextureLayeredRD::_getWidth can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getHeight(): Int {
    throw NotImplementedError("TextureLayeredRD::_getHeight can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayers(): Int {
    throw NotImplementedError("TextureLayeredRD::_getLayers can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _hasMipmaps(): Boolean {
    throw NotImplementedError("TextureLayeredRD::_hasMipmaps can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getLayerData(layerIndex: Int): Image? {
    throw NotImplementedError("TextureLayeredRD::_getLayerData can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setTextureRdRidName: MethodStringName1<TextureLayeredRD, Unit, RID> =
        MethodStringName1<TextureLayeredRD, Unit, RID>("set_texture_rd_rid")

    @JvmField
    public val getTextureRdRidName: MethodStringName0<TextureLayeredRD, RID> =
        MethodStringName0<TextureLayeredRD, RID>("get_texture_rd_rid")
  }

  public object MethodBindings {
    internal val setTextureRdRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayeredRD", "set_texture_rd_rid", 2722037293)

    internal val getTextureRdRidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TextureLayeredRD", "get_texture_rd_rid", 2944877500)
  }
}
