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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This object is used by [RenderingDevice].
 */
@GodotBaseType
public open class RDSamplerState : RefCounted() {
  /**
   * The sampler's magnification filter. It is the filtering method used when sampling texels that
   * appear bigger than on-screen pixels.
   */
  public final inline var magFilter: RenderingDevice.SamplerFilter
    @JvmName("magFilterProperty")
    get() = getMagFilter()
    @JvmName("magFilterProperty")
    set(`value`) {
      setMagFilter(value)
    }

  /**
   * The sampler's minification filter. It is the filtering method used when sampling texels that
   * appear smaller than on-screen pixels.
   */
  public final inline var minFilter: RenderingDevice.SamplerFilter
    @JvmName("minFilterProperty")
    get() = getMinFilter()
    @JvmName("minFilterProperty")
    set(`value`) {
      setMinFilter(value)
    }

  /**
   * The filtering method to use for mipmaps.
   */
  public final inline var mipFilter: RenderingDevice.SamplerFilter
    @JvmName("mipFilterProperty")
    get() = getMipFilter()
    @JvmName("mipFilterProperty")
    set(`value`) {
      setMipFilter(value)
    }

  /**
   * The repeat mode to use along the U axis of UV coordinates. This affects the returned values if
   * sampling outside the UV bounds.
   */
  public final inline var repeatU: RenderingDevice.SamplerRepeatMode
    @JvmName("repeatUProperty")
    get() = getRepeatU()
    @JvmName("repeatUProperty")
    set(`value`) {
      setRepeatU(value)
    }

  /**
   * The repeat mode to use along the V axis of UV coordinates. This affects the returned values if
   * sampling outside the UV bounds.
   */
  public final inline var repeatV: RenderingDevice.SamplerRepeatMode
    @JvmName("repeatVProperty")
    get() = getRepeatV()
    @JvmName("repeatVProperty")
    set(`value`) {
      setRepeatV(value)
    }

  /**
   * The repeat mode to use along the W axis of UV coordinates. This affects the returned values if
   * sampling outside the UV bounds. Only effective for 3D samplers.
   */
  public final inline var repeatW: RenderingDevice.SamplerRepeatMode
    @JvmName("repeatWProperty")
    get() = getRepeatW()
    @JvmName("repeatWProperty")
    set(`value`) {
      setRepeatW(value)
    }

  /**
   * The mipmap LOD bias to use. Positive values will make the sampler blurrier at a given distance,
   * while negative values will make the sampler sharper at a given distance (at the risk of looking
   * grainy). Recommended values are between `-0.5` and `0.0`. Only effective if the sampler has
   * mipmaps available.
   */
  public final inline var lodBias: Float
    @JvmName("lodBiasProperty")
    get() = getLodBias()
    @JvmName("lodBiasProperty")
    set(`value`) {
      setLodBias(value)
    }

  /**
   * If `true`, perform anisotropic sampling. See [anisotropyMax].
   */
  public final inline var useAnisotropy: Boolean
    @JvmName("useAnisotropyProperty")
    get() = getUseAnisotropy()
    @JvmName("useAnisotropyProperty")
    set(`value`) {
      setUseAnisotropy(value)
    }

  /**
   * Maximum anisotropy that can be used when sampling. Only effective if [useAnisotropy] is `true`.
   * Higher values result in a sharper sampler at oblique angles, at the cost of performance (due to
   * memory bandwidth). This value may be limited by the graphics hardware in use. Most graphics
   * hardware only supports values up to `16.0`.
   *
   * If [anisotropyMax] is `1.0`, forcibly disables anisotropy even if [useAnisotropy] is `true`.
   */
  public final inline var anisotropyMax: Float
    @JvmName("anisotropyMaxProperty")
    get() = getAnisotropyMax()
    @JvmName("anisotropyMaxProperty")
    set(`value`) {
      setAnisotropyMax(value)
    }

  /**
   * If `true`, returned values will be based on the comparison operation defined in [compareOp].
   * This is a hardware-based approach and is therefore faster than performing this manually in a
   * shader. For example, compare operations are used for shadow map rendering by comparing depth
   * values from a shadow sampler.
   */
  public final inline var enableCompare: Boolean
    @JvmName("enableCompareProperty")
    get() = getEnableCompare()
    @JvmName("enableCompareProperty")
    set(`value`) {
      setEnableCompare(value)
    }

  /**
   * The compare operation to use. Only effective if [enableCompare] is `true`.
   */
  public final inline var compareOp: RenderingDevice.CompareOperator
    @JvmName("compareOpProperty")
    get() = getCompareOp()
    @JvmName("compareOpProperty")
    set(`value`) {
      setCompareOp(value)
    }

  /**
   * The minimum mipmap LOD bias to display (highest resolution). Only effective if the sampler has
   * mipmaps available.
   */
  public final inline var minLod: Float
    @JvmName("minLodProperty")
    get() = getMinLod()
    @JvmName("minLodProperty")
    set(`value`) {
      setMinLod(value)
    }

  /**
   * The maximum mipmap LOD bias to display (lowest resolution). Only effective if the sampler has
   * mipmaps available.
   */
  public final inline var maxLod: Float
    @JvmName("maxLodProperty")
    get() = getMaxLod()
    @JvmName("maxLodProperty")
    set(`value`) {
      setMaxLod(value)
    }

  /**
   * The border color that will be returned when sampling outside the sampler's bounds and the
   * [repeatU], [repeatV] or [repeatW] modes have repeating disabled.
   */
  public final inline var borderColor: RenderingDevice.SamplerBorderColor
    @JvmName("borderColorProperty")
    get() = getBorderColor()
    @JvmName("borderColorProperty")
    set(`value`) {
      setBorderColor(value)
    }

  /**
   * If `true`, the texture will be sampled with coordinates ranging from 0 to the texture's
   * resolution. Otherwise, the coordinates will be normalized and range from 0 to 1.
   */
  public final inline var unnormalizedUvw: Boolean
    @JvmName("unnormalizedUvwProperty")
    get() = getUnnormalizedUvw()
    @JvmName("unnormalizedUvwProperty")
    set(`value`) {
      setUnnormalizedUvw(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(589, scriptPtr)
  }

  public final fun setMagFilter(pMember: RenderingDevice.SamplerFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setMagFilterPtr)
  }

  public final fun getMagFilter(): RenderingDevice.SamplerFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMagFilterPtr)
    return RenderingDevice.SamplerFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMinFilter(pMember: RenderingDevice.SamplerFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setMinFilterPtr)
  }

  public final fun getMinFilter(): RenderingDevice.SamplerFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinFilterPtr)
    return RenderingDevice.SamplerFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMipFilter(pMember: RenderingDevice.SamplerFilter): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setMipFilterPtr)
  }

  public final fun getMipFilter(): RenderingDevice.SamplerFilter {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMipFilterPtr)
    return RenderingDevice.SamplerFilter.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setRepeatU(pMember: RenderingDevice.SamplerRepeatMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setRepeatUPtr)
  }

  public final fun getRepeatU(): RenderingDevice.SamplerRepeatMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRepeatUPtr)
    return RenderingDevice.SamplerRepeatMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setRepeatV(pMember: RenderingDevice.SamplerRepeatMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setRepeatVPtr)
  }

  public final fun getRepeatV(): RenderingDevice.SamplerRepeatMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRepeatVPtr)
    return RenderingDevice.SamplerRepeatMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setRepeatW(pMember: RenderingDevice.SamplerRepeatMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setRepeatWPtr)
  }

  public final fun getRepeatW(): RenderingDevice.SamplerRepeatMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRepeatWPtr)
    return RenderingDevice.SamplerRepeatMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setLodBias(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setLodBiasPtr)
  }

  public final fun getLodBias(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLodBiasPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setUseAnisotropy(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pMember)
    TransferContext.callMethod(MethodBindings.setUseAnisotropyPtr)
  }

  public final fun getUseAnisotropy(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseAnisotropyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAnisotropyMax(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setAnisotropyMaxPtr)
  }

  public final fun getAnisotropyMax(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnisotropyMaxPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setEnableCompare(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pMember)
    TransferContext.callMethod(MethodBindings.setEnableComparePtr)
  }

  public final fun getEnableCompare(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnableComparePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCompareOp(pMember: RenderingDevice.CompareOperator): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setCompareOpPtr)
  }

  public final fun getCompareOp(): RenderingDevice.CompareOperator {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCompareOpPtr)
    return RenderingDevice.CompareOperator.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setMinLod(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setMinLodPtr)
  }

  public final fun getMinLod(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinLodPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMaxLod(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setMaxLodPtr)
  }

  public final fun getMaxLod(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxLodPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBorderColor(pMember: RenderingDevice.SamplerBorderColor): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setBorderColorPtr)
  }

  public final fun getBorderColor(): RenderingDevice.SamplerBorderColor {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBorderColorPtr)
    return RenderingDevice.SamplerBorderColor.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setUnnormalizedUvw(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pMember)
    TransferContext.callMethod(MethodBindings.setUnnormalizedUvwPtr)
  }

  public final fun getUnnormalizedUvw(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUnnormalizedUvwPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setMagFilterName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerFilter> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerFilter>("set_mag_filter")

    @JvmField
    public val getMagFilterName: MethodStringName0<RDSamplerState, RenderingDevice.SamplerFilter> =
        MethodStringName0<RDSamplerState, RenderingDevice.SamplerFilter>("get_mag_filter")

    @JvmField
    public val setMinFilterName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerFilter> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerFilter>("set_min_filter")

    @JvmField
    public val getMinFilterName: MethodStringName0<RDSamplerState, RenderingDevice.SamplerFilter> =
        MethodStringName0<RDSamplerState, RenderingDevice.SamplerFilter>("get_min_filter")

    @JvmField
    public val setMipFilterName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerFilter> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerFilter>("set_mip_filter")

    @JvmField
    public val getMipFilterName: MethodStringName0<RDSamplerState, RenderingDevice.SamplerFilter> =
        MethodStringName0<RDSamplerState, RenderingDevice.SamplerFilter>("get_mip_filter")

    @JvmField
    public val setRepeatUName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerRepeatMode> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerRepeatMode>("set_repeat_u")

    @JvmField
    public val getRepeatUName: MethodStringName0<RDSamplerState, RenderingDevice.SamplerRepeatMode>
        = MethodStringName0<RDSamplerState, RenderingDevice.SamplerRepeatMode>("get_repeat_u")

    @JvmField
    public val setRepeatVName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerRepeatMode> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerRepeatMode>("set_repeat_v")

    @JvmField
    public val getRepeatVName: MethodStringName0<RDSamplerState, RenderingDevice.SamplerRepeatMode>
        = MethodStringName0<RDSamplerState, RenderingDevice.SamplerRepeatMode>("get_repeat_v")

    @JvmField
    public val setRepeatWName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerRepeatMode> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerRepeatMode>("set_repeat_w")

    @JvmField
    public val getRepeatWName: MethodStringName0<RDSamplerState, RenderingDevice.SamplerRepeatMode>
        = MethodStringName0<RDSamplerState, RenderingDevice.SamplerRepeatMode>("get_repeat_w")

    @JvmField
    public val setLodBiasName: MethodStringName1<RDSamplerState, Unit, Float> =
        MethodStringName1<RDSamplerState, Unit, Float>("set_lod_bias")

    @JvmField
    public val getLodBiasName: MethodStringName0<RDSamplerState, Float> =
        MethodStringName0<RDSamplerState, Float>("get_lod_bias")

    @JvmField
    public val setUseAnisotropyName: MethodStringName1<RDSamplerState, Unit, Boolean> =
        MethodStringName1<RDSamplerState, Unit, Boolean>("set_use_anisotropy")

    @JvmField
    public val getUseAnisotropyName: MethodStringName0<RDSamplerState, Boolean> =
        MethodStringName0<RDSamplerState, Boolean>("get_use_anisotropy")

    @JvmField
    public val setAnisotropyMaxName: MethodStringName1<RDSamplerState, Unit, Float> =
        MethodStringName1<RDSamplerState, Unit, Float>("set_anisotropy_max")

    @JvmField
    public val getAnisotropyMaxName: MethodStringName0<RDSamplerState, Float> =
        MethodStringName0<RDSamplerState, Float>("get_anisotropy_max")

    @JvmField
    public val setEnableCompareName: MethodStringName1<RDSamplerState, Unit, Boolean> =
        MethodStringName1<RDSamplerState, Unit, Boolean>("set_enable_compare")

    @JvmField
    public val getEnableCompareName: MethodStringName0<RDSamplerState, Boolean> =
        MethodStringName0<RDSamplerState, Boolean>("get_enable_compare")

    @JvmField
    public val setCompareOpName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.CompareOperator> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.CompareOperator>("set_compare_op")

    @JvmField
    public val getCompareOpName: MethodStringName0<RDSamplerState, RenderingDevice.CompareOperator>
        = MethodStringName0<RDSamplerState, RenderingDevice.CompareOperator>("get_compare_op")

    @JvmField
    public val setMinLodName: MethodStringName1<RDSamplerState, Unit, Float> =
        MethodStringName1<RDSamplerState, Unit, Float>("set_min_lod")

    @JvmField
    public val getMinLodName: MethodStringName0<RDSamplerState, Float> =
        MethodStringName0<RDSamplerState, Float>("get_min_lod")

    @JvmField
    public val setMaxLodName: MethodStringName1<RDSamplerState, Unit, Float> =
        MethodStringName1<RDSamplerState, Unit, Float>("set_max_lod")

    @JvmField
    public val getMaxLodName: MethodStringName0<RDSamplerState, Float> =
        MethodStringName0<RDSamplerState, Float>("get_max_lod")

    @JvmField
    public val setBorderColorName:
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerBorderColor> =
        MethodStringName1<RDSamplerState, Unit, RenderingDevice.SamplerBorderColor>("set_border_color")

    @JvmField
    public val getBorderColorName:
        MethodStringName0<RDSamplerState, RenderingDevice.SamplerBorderColor> =
        MethodStringName0<RDSamplerState, RenderingDevice.SamplerBorderColor>("get_border_color")

    @JvmField
    public val setUnnormalizedUvwName: MethodStringName1<RDSamplerState, Unit, Boolean> =
        MethodStringName1<RDSamplerState, Unit, Boolean>("set_unnormalized_uvw")

    @JvmField
    public val getUnnormalizedUvwName: MethodStringName0<RDSamplerState, Boolean> =
        MethodStringName0<RDSamplerState, Boolean>("get_unnormalized_uvw")
  }

  public object MethodBindings {
    internal val setMagFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_mag_filter", 1493420382)

    internal val getMagFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_mag_filter", 2209202801)

    internal val setMinFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_min_filter", 1493420382)

    internal val getMinFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_min_filter", 2209202801)

    internal val setMipFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_mip_filter", 1493420382)

    internal val getMipFilterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_mip_filter", 2209202801)

    internal val setRepeatUPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_repeat_u", 246127626)

    internal val getRepeatUPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_repeat_u", 3227895872)

    internal val setRepeatVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_repeat_v", 246127626)

    internal val getRepeatVPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_repeat_v", 3227895872)

    internal val setRepeatWPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_repeat_w", 246127626)

    internal val getRepeatWPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_repeat_w", 3227895872)

    internal val setLodBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_lod_bias", 373806689)

    internal val getLodBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_lod_bias", 1740695150)

    internal val setUseAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_use_anisotropy", 2586408642)

    internal val getUseAnisotropyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_use_anisotropy", 36873697)

    internal val setAnisotropyMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_anisotropy_max", 373806689)

    internal val getAnisotropyMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_anisotropy_max", 1740695150)

    internal val setEnableComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_enable_compare", 2586408642)

    internal val getEnableComparePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_enable_compare", 36873697)

    internal val setCompareOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_compare_op", 2573711505)

    internal val getCompareOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_compare_op", 269730778)

    internal val setMinLodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_min_lod", 373806689)

    internal val getMinLodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_min_lod", 1740695150)

    internal val setMaxLodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_max_lod", 373806689)

    internal val getMaxLodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_max_lod", 1740695150)

    internal val setBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_border_color", 1115869595)

    internal val getBorderColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_border_color", 3514246478)

    internal val setUnnormalizedUvwPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "set_unnormalized_uvw", 2586408642)

    internal val getUnnormalizedUvwPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDSamplerState", "get_unnormalized_uvw", 36873697)
  }
}
