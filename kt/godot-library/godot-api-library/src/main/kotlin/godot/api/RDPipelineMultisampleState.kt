// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_ARRAY
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantArray
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [RDPipelineMultisampleState] is used to control how multisample or supersample antialiasing is
 * being performed when rendering using [RenderingDevice].
 */
@GodotBaseType
public open class RDPipelineMultisampleState : RefCounted() {
  /**
   * The number of MSAA samples (or SSAA samples if [enableSampleShading] is `true`) to perform.
   * Higher values result in better antialiasing, at the cost of performance.
   */
  public final inline var sampleCount: RenderingDevice.TextureSamples
    @JvmName("sampleCountProperty")
    get() = getSampleCount()
    @JvmName("sampleCountProperty")
    set(`value`) {
      setSampleCount(value)
    }

  /**
   * If `true`, enables per-sample shading which replaces MSAA by SSAA. This provides higher quality
   * antialiasing that works with transparent (alpha scissor) edges. This has a very high performance
   * cost. See also [minSampleShading]. See the
   * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#primsrast-sampleshading]per-sample
   * shading Vulkan documentation[/url] for more details.
   */
  public final inline var enableSampleShading: Boolean
    @JvmName("enableSampleShadingProperty")
    get() = getEnableSampleShading()
    @JvmName("enableSampleShadingProperty")
    set(`value`) {
      setEnableSampleShading(value)
    }

  /**
   * The multiplier of [sampleCount] that determines how many samples are performed for each
   * fragment. Must be between `0.0` and `1.0` (inclusive). Only effective if [enableSampleShading] is
   * `true`. If [minSampleShading] is `1.0`, fragment invocation must only read from the coverage index
   * sample. Tile image access must not be used if [enableSampleShading] is *not* `1.0`.
   */
  public final inline var minSampleShading: Float
    @JvmName("minSampleShadingProperty")
    get() = getMinSampleShading()
    @JvmName("minSampleShadingProperty")
    set(`value`) {
      setMinSampleShading(value)
    }

  /**
   * If `true`, alpha to coverage is enabled. This generates a temporary coverage value based on the
   * alpha component of the fragment's first color output. This allows alpha transparency to make use
   * of multisample antialiasing.
   */
  public final inline var enableAlphaToCoverage: Boolean
    @JvmName("enableAlphaToCoverageProperty")
    get() = getEnableAlphaToCoverage()
    @JvmName("enableAlphaToCoverageProperty")
    set(`value`) {
      setEnableAlphaToCoverage(value)
    }

  /**
   * If `true`, alpha is forced to either `0.0` or `1.0`. This allows hardening the edges of
   * antialiased alpha transparencies. Only relevant if [enableAlphaToCoverage] is `true`.
   */
  public final inline var enableAlphaToOne: Boolean
    @JvmName("enableAlphaToOneProperty")
    get() = getEnableAlphaToOne()
    @JvmName("enableAlphaToOneProperty")
    set(`value`) {
      setEnableAlphaToOne(value)
    }

  /**
   * The sample mask array. See the
   * [url=https://registry.khronos.org/vulkan/specs/1.3-extensions/html/vkspec.html#fragops-samplemask]sample
   * mask Vulkan documentation[/url] for more details.
   */
  public final inline var sampleMasks: VariantArray<Long>
    @JvmName("sampleMasksProperty")
    get() = getSampleMasks()
    @JvmName("sampleMasksProperty")
    set(`value`) {
      setSampleMasks(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(585, scriptPtr)
  }

  public final fun setSampleCount(pMember: RenderingDevice.TextureSamples): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSampleCountPtr, pMember.value)
  }

  public final fun getSampleCount(): RenderingDevice.TextureSamples =
      RenderingDevice.TextureSamples.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSampleCountPtr))

  public final fun setEnableSampleShading(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableSampleShadingPtr, pMember)
  }

  public final fun getEnableSampleShading(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableSampleShadingPtr)

  public final fun setMinSampleShading(pMember: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setMinSampleShadingPtr, pMember.toDouble())
  }

  public final fun getMinSampleShading(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getMinSampleShadingPtr).toFloat()

  public final fun setEnableAlphaToCoverage(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableAlphaToCoveragePtr, pMember)
  }

  public final fun getEnableAlphaToCoverage(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableAlphaToCoveragePtr)

  public final fun setEnableAlphaToOne(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableAlphaToOnePtr, pMember)
  }

  public final fun getEnableAlphaToOne(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableAlphaToOnePtr)

  public final fun setSampleMasks(masks: VariantArray<Long>): Unit {
    TransferContext.callPtrMethod_ARRAY(ptr, objectID.id, MethodBindings.setSampleMasksPtr, masks)
  }

  public final fun getSampleMasks(): VariantArray<Long> =
      (TransferContext.callPtrMethod0_ret_ARRAY(ptr, objectID.id, MethodBindings.getSampleMasksPtr) as VariantArray<Long>)

  public companion object {
    @JvmField
    public val setSampleCountName:
        MethodStringName1<RDPipelineMultisampleState, Unit, RenderingDevice.TextureSamples> =
        MethodStringName1<RDPipelineMultisampleState, Unit, RenderingDevice.TextureSamples>("set_sample_count")

    @JvmField
    public val getSampleCountName:
        MethodStringName0<RDPipelineMultisampleState, RenderingDevice.TextureSamples> =
        MethodStringName0<RDPipelineMultisampleState, RenderingDevice.TextureSamples>("get_sample_count")

    @JvmField
    public val setEnableSampleShadingName:
        MethodStringName1<RDPipelineMultisampleState, Unit, Boolean> =
        MethodStringName1<RDPipelineMultisampleState, Unit, Boolean>("set_enable_sample_shading")

    @JvmField
    public val getEnableSampleShadingName: MethodStringName0<RDPipelineMultisampleState, Boolean> =
        MethodStringName0<RDPipelineMultisampleState, Boolean>("get_enable_sample_shading")

    @JvmField
    public val setMinSampleShadingName: MethodStringName1<RDPipelineMultisampleState, Unit, Float> =
        MethodStringName1<RDPipelineMultisampleState, Unit, Float>("set_min_sample_shading")

    @JvmField
    public val getMinSampleShadingName: MethodStringName0<RDPipelineMultisampleState, Float> =
        MethodStringName0<RDPipelineMultisampleState, Float>("get_min_sample_shading")

    @JvmField
    public val setEnableAlphaToCoverageName:
        MethodStringName1<RDPipelineMultisampleState, Unit, Boolean> =
        MethodStringName1<RDPipelineMultisampleState, Unit, Boolean>("set_enable_alpha_to_coverage")

    @JvmField
    public val getEnableAlphaToCoverageName: MethodStringName0<RDPipelineMultisampleState, Boolean>
        = MethodStringName0<RDPipelineMultisampleState, Boolean>("get_enable_alpha_to_coverage")

    @JvmField
    public val setEnableAlphaToOneName: MethodStringName1<RDPipelineMultisampleState, Unit, Boolean>
        = MethodStringName1<RDPipelineMultisampleState, Unit, Boolean>("set_enable_alpha_to_one")

    @JvmField
    public val getEnableAlphaToOneName: MethodStringName0<RDPipelineMultisampleState, Boolean> =
        MethodStringName0<RDPipelineMultisampleState, Boolean>("get_enable_alpha_to_one")

    @JvmField
    public val setSampleMasksName:
        MethodStringName1<RDPipelineMultisampleState, Unit, VariantArray<Long>> =
        MethodStringName1<RDPipelineMultisampleState, Unit, VariantArray<Long>>("set_sample_masks")

    @JvmField
    public val getSampleMasksName: MethodStringName0<RDPipelineMultisampleState, VariantArray<Long>>
        = MethodStringName0<RDPipelineMultisampleState, VariantArray<Long>>("get_sample_masks")
  }

  public object MethodBindings {
    internal val setSampleCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "set_sample_count", 3774171498)

    internal val getSampleCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "get_sample_count", 407791724)

    internal val setEnableSampleShadingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "set_enable_sample_shading", 2586408642)

    internal val getEnableSampleShadingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "get_enable_sample_shading", 36873697)

    internal val setMinSampleShadingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "set_min_sample_shading", 373806689)

    internal val getMinSampleShadingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "get_min_sample_shading", 1740695150)

    internal val setEnableAlphaToCoveragePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "set_enable_alpha_to_coverage", 2586408642)

    internal val getEnableAlphaToCoveragePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "get_enable_alpha_to_coverage", 36873697)

    internal val setEnableAlphaToOnePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "set_enable_alpha_to_one", 2586408642)

    internal val getEnableAlphaToOnePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "get_enable_alpha_to_one", 36873697)

    internal val setSampleMasksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "set_sample_masks", 381264803)

    internal val getSampleMasksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineMultisampleState", "get_sample_masks", 3995934104)
  }
}
