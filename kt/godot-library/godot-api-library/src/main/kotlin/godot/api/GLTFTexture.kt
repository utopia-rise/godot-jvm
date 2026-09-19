// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

@GodotBaseType
public open class GLTFTexture : Resource() {
  /**
   * The index of the image associated with this texture, see [GLTFState.getImages]. If -1, then
   * this texture does not have an image assigned.
   */
  public final inline var srcImage: Int
    @JvmName("srcImageProperty")
    get() = getSrcImage()
    @JvmName("srcImageProperty")
    set(`value`) {
      setSrcImage(value)
    }

  /**
   * ID of the texture sampler to use when sampling the image. If -1, then the default texture
   * sampler is used (linear filtering, and repeat wrapping in both axes).
   */
  public final inline var sampler: Int
    @JvmName("samplerProperty")
    get() = getSampler()
    @JvmName("samplerProperty")
    set(`value`) {
      setSampler(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(255, scriptPtr)
  }

  public final fun getSrcImage(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSrcImagePtr).toInt()

  public final fun setSrcImage(srcImage: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSrcImagePtr, srcImage.toLong())
  }

  public final fun getSampler(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSamplerPtr).toInt()

  public final fun setSampler(sampler: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSamplerPtr, sampler.toLong())
  }

  public companion object {
    @JvmField
    public val getSrcImageName: MethodStringName0<GLTFTexture, Int> =
        MethodStringName0<GLTFTexture, Int>("get_src_image")

    @JvmField
    public val setSrcImageName: MethodStringName1<GLTFTexture, Unit, Int> =
        MethodStringName1<GLTFTexture, Unit, Int>("set_src_image")

    @JvmField
    public val getSamplerName: MethodStringName0<GLTFTexture, Int> =
        MethodStringName0<GLTFTexture, Int>("get_sampler")

    @JvmField
    public val setSamplerName: MethodStringName1<GLTFTexture, Unit, Int> =
        MethodStringName1<GLTFTexture, Unit, Int>("set_sampler")
  }

  public object MethodBindings {
    internal val getSrcImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTexture", "get_src_image", 3905245786)

    internal val setSrcImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTexture", "set_src_image", 1286410249)

    internal val getSamplerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTexture", "get_sampler", 3905245786)

    internal val setSamplerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("GLTFTexture", "set_sampler", 1286410249)
  }
}
