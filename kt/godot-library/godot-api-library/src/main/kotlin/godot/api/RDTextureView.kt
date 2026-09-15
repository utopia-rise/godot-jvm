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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDTextureView : RefCounted() {
  /**
   * Optional override for the data format to return sampled values in. The corresponding
   * [RDTextureFormat] must have had this added as a shareable format. The default value of
   * [RenderingDevice.DATA_FORMAT_MAX] does not override the format.
   */
  public final inline var formatOverride: RenderingDevice.DataFormat
    @JvmName("formatOverrideProperty")
    get() = getFormatOverride()
    @JvmName("formatOverrideProperty")
    set(`value`) {
      setFormatOverride(value)
    }

  /**
   * The channel to sample when sampling the red color channel.
   */
  public final inline var swizzleR: RenderingDevice.TextureSwizzle
    @JvmName("swizzleRProperty")
    get() = getSwizzleR()
    @JvmName("swizzleRProperty")
    set(`value`) {
      setSwizzleR(value)
    }

  /**
   * The channel to sample when sampling the green color channel.
   */
  public final inline var swizzleG: RenderingDevice.TextureSwizzle
    @JvmName("swizzleGProperty")
    get() = getSwizzleG()
    @JvmName("swizzleGProperty")
    set(`value`) {
      setSwizzleG(value)
    }

  /**
   * The channel to sample when sampling the blue color channel.
   */
  public final inline var swizzleB: RenderingDevice.TextureSwizzle
    @JvmName("swizzleBProperty")
    get() = getSwizzleB()
    @JvmName("swizzleBProperty")
    set(`value`) {
      setSwizzleB(value)
    }

  /**
   * The channel to sample when sampling the alpha channel.
   */
  public final inline var swizzleA: RenderingDevice.TextureSwizzle
    @JvmName("swizzleAProperty")
    get() = getSwizzleA()
    @JvmName("swizzleAProperty")
    set(`value`) {
      setSwizzleA(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(594, scriptPtr)
  }

  public final fun setFormatOverride(pMember: RenderingDevice.DataFormat): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setFormatOverridePtr, 0)
  }

  public final fun getFormatOverride(): RenderingDevice.DataFormat {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFormatOverridePtr, 2)
    return RenderingDevice.DataFormat.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSwizzleR(pMember: RenderingDevice.TextureSwizzle): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setSwizzleRPtr, 0)
  }

  public final fun getSwizzleR(): RenderingDevice.TextureSwizzle {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSwizzleRPtr, 2)
    return RenderingDevice.TextureSwizzle.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSwizzleG(pMember: RenderingDevice.TextureSwizzle): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setSwizzleGPtr, 0)
  }

  public final fun getSwizzleG(): RenderingDevice.TextureSwizzle {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSwizzleGPtr, 2)
    return RenderingDevice.TextureSwizzle.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSwizzleB(pMember: RenderingDevice.TextureSwizzle): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setSwizzleBPtr, 0)
  }

  public final fun getSwizzleB(): RenderingDevice.TextureSwizzle {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSwizzleBPtr, 2)
    return RenderingDevice.TextureSwizzle.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSwizzleA(pMember: RenderingDevice.TextureSwizzle): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, pMember.value)
    TransferContext.callPtrMethod(MethodBindings.setSwizzleAPtr, 0)
  }

  public final fun getSwizzleA(): RenderingDevice.TextureSwizzle {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSwizzleAPtr, 2)
    return RenderingDevice.TextureSwizzle.from(TransferContext.readReturnValue_LONG())
  }

  public companion object {
    @JvmField
    public val setFormatOverrideName:
        MethodStringName1<RDTextureView, Unit, RenderingDevice.DataFormat> =
        MethodStringName1<RDTextureView, Unit, RenderingDevice.DataFormat>("set_format_override")

    @JvmField
    public val getFormatOverrideName: MethodStringName0<RDTextureView, RenderingDevice.DataFormat> =
        MethodStringName0<RDTextureView, RenderingDevice.DataFormat>("get_format_override")

    @JvmField
    public val setSwizzleRName:
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle> =
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle>("set_swizzle_r")

    @JvmField
    public val getSwizzleRName: MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle> =
        MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle>("get_swizzle_r")

    @JvmField
    public val setSwizzleGName:
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle> =
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle>("set_swizzle_g")

    @JvmField
    public val getSwizzleGName: MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle> =
        MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle>("get_swizzle_g")

    @JvmField
    public val setSwizzleBName:
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle> =
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle>("set_swizzle_b")

    @JvmField
    public val getSwizzleBName: MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle> =
        MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle>("get_swizzle_b")

    @JvmField
    public val setSwizzleAName:
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle> =
        MethodStringName1<RDTextureView, Unit, RenderingDevice.TextureSwizzle>("set_swizzle_a")

    @JvmField
    public val getSwizzleAName: MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle> =
        MethodStringName0<RDTextureView, RenderingDevice.TextureSwizzle>("get_swizzle_a")
  }

  public object MethodBindings {
    internal val setFormatOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "set_format_override", 565531219)

    internal val getFormatOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "get_format_override", 2235804183)

    internal val setSwizzleRPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "set_swizzle_r", 3833362581)

    internal val getSwizzleRPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "get_swizzle_r", 4150792614)

    internal val setSwizzleGPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "set_swizzle_g", 3833362581)

    internal val getSwizzleGPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "get_swizzle_g", 4150792614)

    internal val setSwizzleBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "set_swizzle_b", 3833362581)

    internal val getSwizzleBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "get_swizzle_b", 4150792614)

    internal val setSwizzleAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "set_swizzle_a", 3833362581)

    internal val getSwizzleAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDTextureView", "get_swizzle_a", 4150792614)
  }
}
