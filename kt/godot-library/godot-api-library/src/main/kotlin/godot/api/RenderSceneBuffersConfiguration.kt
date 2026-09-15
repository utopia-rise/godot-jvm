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
import godot.core.RID
import godot.core.Vector2i
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_RID
import godot.readReturnValue_VECTOR2I
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_VECTOR2I
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This configuration object is created and populated by the render engine on a viewport change and
 * used to (re)configure a [RenderSceneBuffers] object.
 */
@GodotBaseType
public open class RenderSceneBuffersConfiguration : RefCounted() {
  /**
   * The render target associated with these buffer.
   */
  public final inline var renderTarget: RID
    @JvmName("renderTargetProperty")
    get() = getRenderTarget()
    @JvmName("renderTargetProperty")
    set(`value`) {
      setRenderTarget(value)
    }

  /**
   * The size of the 3D render buffer used for rendering.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var internalSize: Vector2i
    @JvmName("internalSizeProperty")
    get() = getInternalSize()
    @JvmName("internalSizeProperty")
    set(`value`) {
      setInternalSize(value)
    }

  /**
   * The target (upscale) size if scaling is used.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var targetSize: Vector2i
    @JvmName("targetSizeProperty")
    get() = getTargetSize()
    @JvmName("targetSizeProperty")
    set(`value`) {
      setTargetSize(value)
    }

  /**
   * The number of views we're rendering.
   */
  public final inline var viewCount: Long
    @JvmName("viewCountProperty")
    get() = getViewCount()
    @JvmName("viewCountProperty")
    set(`value`) {
      setViewCount(value)
    }

  /**
   * The requested scaling mode with which we upscale/downscale if [internalSize] and [targetSize]
   * are not equal.
   */
  public final inline var scaling3dMode: RenderingServer.ViewportScaling3DMode
    @JvmName("scaling3dModeProperty")
    get() = getScaling3dMode()
    @JvmName("scaling3dModeProperty")
    set(`value`) {
      setScaling3dMode(value)
    }

  /**
   * The MSAA mode we're using for 3D rendering.
   */
  public final inline var msaa3d: RenderingServer.ViewportMSAA
    @JvmName("msaa3dProperty")
    get() = getMsaa3d()
    @JvmName("msaa3dProperty")
    set(`value`) {
      setMsaa3d(value)
    }

  /**
   * The requested screen space AA applied in post processing.
   */
  public final inline var screenSpaceAa: RenderingServer.ViewportScreenSpaceAA
    @JvmName("screenSpaceAaProperty")
    get() = getScreenSpaceAa()
    @JvmName("screenSpaceAaProperty")
    set(`value`) {
      setScreenSpaceAa(value)
    }

  /**
   * FSR Sharpness applicable if FSR upscaling is used.
   */
  public final inline var fsrSharpness: Float
    @JvmName("fsrSharpnessProperty")
    get() = getFsrSharpness()
    @JvmName("fsrSharpnessProperty")
    set(`value`) {
      setFsrSharpness(value)
    }

  /**
   * Bias applied to mipmaps.
   *
   * **Note:** This property is only supported in the Forward+ and Mobile renderers, not
   * Compatibility. In Compatibility, this property is always treated as if it was set to `0.0`.
   */
  public final inline var textureMipmapBias: Float
    @JvmName("textureMipmapBiasProperty")
    get() = getTextureMipmapBias()
    @JvmName("textureMipmapBiasProperty")
    set(`value`) {
      setTextureMipmapBias(value)
    }

  /**
   * Level of the anisotropic filter.
   */
  public final inline var anisotropicFilteringLevel: RenderingServer.ViewportAnisotropicFiltering
    @JvmName("anisotropicFilteringLevelProperty")
    get() = getAnisotropicFilteringLevel()
    @JvmName("anisotropicFilteringLevelProperty")
    set(`value`) {
      setAnisotropicFilteringLevel(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(613, scriptPtr)
  }

  /**
   * This is a helper function for [internalSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = renderscenebuffersconfiguration.internalSize
   * //Your changes
   * renderscenebuffersconfiguration.internalSize = myCoreType
   * ``````
   *
   * The size of the 3D render buffer used for rendering.
   */
  @CoreTypeHelper
  public final fun internalSizeMutate(block: Vector2i.() -> Unit): Vector2i = internalSize.apply {
     block(this)
     internalSize = this
  }

  /**
   * This is a helper function for [targetSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = renderscenebuffersconfiguration.targetSize
   * //Your changes
   * renderscenebuffersconfiguration.targetSize = myCoreType
   * ``````
   *
   * The target (upscale) size if scaling is used.
   */
  @CoreTypeHelper
  public final fun targetSizeMutate(block: Vector2i.() -> Unit): Vector2i = targetSize.apply {
     block(this)
     targetSize = this
  }

  public final fun getRenderTarget(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRenderTargetPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setRenderTarget(renderTarget: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, renderTarget)
    TransferContext.callPtrMethod(MethodBindings.setRenderTargetPtr, 0)
  }

  public final fun getInternalSize(): Vector2i {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInternalSizePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  public final fun setInternalSize(internalSize: Vector2i): Unit {
    TransferContext.writeMethodArguments_VECTOR2I(ptr, objectID.id, internalSize)
    TransferContext.callPtrMethod(MethodBindings.setInternalSizePtr, 0)
  }

  public final fun getTargetSize(): Vector2i {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTargetSizePtr, 6)
    return TransferContext.readReturnValue_VECTOR2I()
  }

  public final fun setTargetSize(targetSize: Vector2i): Unit {
    TransferContext.writeMethodArguments_VECTOR2I(ptr, objectID.id, targetSize)
    TransferContext.callPtrMethod(MethodBindings.setTargetSizePtr, 0)
  }

  public final fun getViewCount(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getViewCountPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setViewCount(viewCount: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, viewCount)
    TransferContext.callPtrMethod(MethodBindings.setViewCountPtr, 0)
  }

  public final fun getScaling3dMode(): RenderingServer.ViewportScaling3DMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getScaling3dModePtr, 2)
    return RenderingServer.ViewportScaling3DMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setScaling3dMode(scaling3dMode: RenderingServer.ViewportScaling3DMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, scaling3dMode.value)
    TransferContext.callPtrMethod(MethodBindings.setScaling3dModePtr, 0)
  }

  public final fun getMsaa3d(): RenderingServer.ViewportMSAA {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMsaa3dPtr, 2)
    return RenderingServer.ViewportMSAA.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setMsaa3d(msaa3d: RenderingServer.ViewportMSAA): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, msaa3d.value)
    TransferContext.callPtrMethod(MethodBindings.setMsaa3dPtr, 0)
  }

  public final fun getScreenSpaceAa(): RenderingServer.ViewportScreenSpaceAA {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getScreenSpaceAaPtr, 2)
    return RenderingServer.ViewportScreenSpaceAA.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setScreenSpaceAa(screenSpaceAa: RenderingServer.ViewportScreenSpaceAA): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, screenSpaceAa.value)
    TransferContext.callPtrMethod(MethodBindings.setScreenSpaceAaPtr, 0)
  }

  public final fun getFsrSharpness(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFsrSharpnessPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFsrSharpness(fsrSharpness: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, fsrSharpness.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFsrSharpnessPtr, 0)
  }

  public final fun getTextureMipmapBias(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTextureMipmapBiasPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setTextureMipmapBias(textureMipmapBias: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, textureMipmapBias.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setTextureMipmapBiasPtr, 0)
  }

  public final fun getAnisotropicFilteringLevel(): RenderingServer.ViewportAnisotropicFiltering {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAnisotropicFilteringLevelPtr, 2)
    return RenderingServer.ViewportAnisotropicFiltering.from(TransferContext.readReturnValue_LONG())
  }

  public final
      fun setAnisotropicFilteringLevel(anisotropicFilteringLevel: RenderingServer.ViewportAnisotropicFiltering):
      Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, anisotropicFilteringLevel.value)
    TransferContext.callPtrMethod(MethodBindings.setAnisotropicFilteringLevelPtr, 0)
  }

  public companion object {
    @JvmField
    public val getRenderTargetName: MethodStringName0<RenderSceneBuffersConfiguration, RID> =
        MethodStringName0<RenderSceneBuffersConfiguration, RID>("get_render_target")

    @JvmField
    public val setRenderTargetName: MethodStringName1<RenderSceneBuffersConfiguration, Unit, RID> =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RID>("set_render_target")

    @JvmField
    public val getInternalSizeName: MethodStringName0<RenderSceneBuffersConfiguration, Vector2i> =
        MethodStringName0<RenderSceneBuffersConfiguration, Vector2i>("get_internal_size")

    @JvmField
    public val setInternalSizeName:
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, Vector2i> =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, Vector2i>("set_internal_size")

    @JvmField
    public val getTargetSizeName: MethodStringName0<RenderSceneBuffersConfiguration, Vector2i> =
        MethodStringName0<RenderSceneBuffersConfiguration, Vector2i>("get_target_size")

    @JvmField
    public val setTargetSizeName: MethodStringName1<RenderSceneBuffersConfiguration, Unit, Vector2i>
        = MethodStringName1<RenderSceneBuffersConfiguration, Unit, Vector2i>("set_target_size")

    @JvmField
    public val getViewCountName: MethodStringName0<RenderSceneBuffersConfiguration, Long> =
        MethodStringName0<RenderSceneBuffersConfiguration, Long>("get_view_count")

    @JvmField
    public val setViewCountName: MethodStringName1<RenderSceneBuffersConfiguration, Unit, Long> =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, Long>("set_view_count")

    @JvmField
    public val getScaling3dModeName:
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportScaling3DMode> =
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportScaling3DMode>("get_scaling_3d_mode")

    @JvmField
    public val setScaling3dModeName:
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportScaling3DMode>
        =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportScaling3DMode>("set_scaling_3d_mode")

    @JvmField
    public val getMsaa3dName:
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportMSAA> =
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportMSAA>("get_msaa_3d")

    @JvmField
    public val setMsaa3dName:
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportMSAA> =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportMSAA>("set_msaa_3d")

    @JvmField
    public val getScreenSpaceAaName:
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportScreenSpaceAA> =
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportScreenSpaceAA>("get_screen_space_aa")

    @JvmField
    public val setScreenSpaceAaName:
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportScreenSpaceAA>
        =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportScreenSpaceAA>("set_screen_space_aa")

    @JvmField
    public val getFsrSharpnessName: MethodStringName0<RenderSceneBuffersConfiguration, Float> =
        MethodStringName0<RenderSceneBuffersConfiguration, Float>("get_fsr_sharpness")

    @JvmField
    public val setFsrSharpnessName: MethodStringName1<RenderSceneBuffersConfiguration, Unit, Float>
        = MethodStringName1<RenderSceneBuffersConfiguration, Unit, Float>("set_fsr_sharpness")

    @JvmField
    public val getTextureMipmapBiasName: MethodStringName0<RenderSceneBuffersConfiguration, Float> =
        MethodStringName0<RenderSceneBuffersConfiguration, Float>("get_texture_mipmap_bias")

    @JvmField
    public val setTextureMipmapBiasName:
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, Float> =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, Float>("set_texture_mipmap_bias")

    @JvmField
    public val getAnisotropicFilteringLevelName:
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportAnisotropicFiltering>
        =
        MethodStringName0<RenderSceneBuffersConfiguration, RenderingServer.ViewportAnisotropicFiltering>("get_anisotropic_filtering_level")

    @JvmField
    public val setAnisotropicFilteringLevelName:
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportAnisotropicFiltering>
        =
        MethodStringName1<RenderSceneBuffersConfiguration, Unit, RenderingServer.ViewportAnisotropicFiltering>("set_anisotropic_filtering_level")
  }

  public object MethodBindings {
    internal val getRenderTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_render_target", 2944877500)

    internal val setRenderTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_render_target", 2722037293)

    internal val getInternalSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_internal_size", 3690982128)

    internal val setInternalSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_internal_size", 1130785943)

    internal val getTargetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_target_size", 3690982128)

    internal val setTargetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_target_size", 1130785943)

    internal val getViewCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_view_count", 3905245786)

    internal val setViewCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_view_count", 1286410249)

    internal val getScaling3dModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_scaling_3d_mode", 976778074)

    internal val setScaling3dModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_scaling_3d_mode", 447477857)

    internal val getMsaa3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_msaa_3d", 3109158617)

    internal val setMsaa3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_msaa_3d", 3952630748)

    internal val getScreenSpaceAaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_screen_space_aa", 641513172)

    internal val setScreenSpaceAaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_screen_space_aa", 139543108)

    internal val getFsrSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_fsr_sharpness", 1740695150)

    internal val setFsrSharpnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_fsr_sharpness", 373806689)

    internal val getTextureMipmapBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_texture_mipmap_bias", 1740695150)

    internal val setTextureMipmapBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_texture_mipmap_bias", 373806689)

    internal val getAnisotropicFilteringLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "get_anisotropic_filtering_level", 1617414954)

    internal val setAnisotropicFilteringLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RenderSceneBuffersConfiguration", "set_anisotropic_filtering_level", 2559658741)
  }
}
