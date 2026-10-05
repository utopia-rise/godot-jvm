// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Controls how blending between source and destination fragments is performed when using
 * [RenderingDevice].
 *
 * For reference, this is how common user-facing blend modes are implemented in Godot's 2D renderer:
 *
 * **Mix:**
 *
 * ```
 * var attachment = RDPipelineColorBlendStateAttachment.new()
 * attachment.enable_blend = true
 * attachment.color_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.src_color_blend_factor = RenderingDevice.BLEND_FACTOR_SRC_ALPHA
 * attachment.dst_color_blend_factor = RenderingDevice.BLEND_FACTOR_ONE_MINUS_SRC_ALPHA
 * attachment.alpha_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.src_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_ONE
 * attachment.dst_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_ONE_MINUS_SRC_ALPHA
 * ```
 *
 * **Add:**
 *
 * ```
 * var attachment = RDPipelineColorBlendStateAttachment.new()
 * attachment.enable_blend = true
 * attachment.alpha_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.color_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.src_color_blend_factor = RenderingDevice.BLEND_FACTOR_SRC_ALPHA
 * attachment.dst_color_blend_factor = RenderingDevice.BLEND_FACTOR_ONE
 * attachment.src_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_SRC_ALPHA
 * attachment.dst_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_ONE
 * ```
 *
 * **Subtract:**
 *
 * ```
 * var attachment = RDPipelineColorBlendStateAttachment.new()
 * attachment.enable_blend = true
 * attachment.alpha_blend_op = RenderingDevice.BLEND_OP_REVERSE_SUBTRACT
 * attachment.color_blend_op = RenderingDevice.BLEND_OP_REVERSE_SUBTRACT
 * attachment.src_color_blend_factor = RenderingDevice.BLEND_FACTOR_SRC_ALPHA
 * attachment.dst_color_blend_factor = RenderingDevice.BLEND_FACTOR_ONE
 * attachment.src_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_SRC_ALPHA
 * attachment.dst_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_ONE
 * ```
 *
 * **Multiply:**
 *
 * ```
 * var attachment = RDPipelineColorBlendStateAttachment.new()
 * attachment.enable_blend = true
 * attachment.alpha_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.color_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.src_color_blend_factor = RenderingDevice.BLEND_FACTOR_DST_COLOR
 * attachment.dst_color_blend_factor = RenderingDevice.BLEND_FACTOR_ZERO
 * attachment.src_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_DST_ALPHA
 * attachment.dst_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_ZERO
 * ```
 *
 * **Pre-multiplied alpha:**
 *
 * ```
 * var attachment = RDPipelineColorBlendStateAttachment.new()
 * attachment.enable_blend = true
 * attachment.alpha_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.color_blend_op = RenderingDevice.BLEND_OP_ADD
 * attachment.src_color_blend_factor = RenderingDevice.BLEND_FACTOR_ONE
 * attachment.dst_color_blend_factor = RenderingDevice.BLEND_FACTOR_ONE_MINUS_SRC_ALPHA
 * attachment.src_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_ONE
 * attachment.dst_alpha_blend_factor = RenderingDevice.BLEND_FACTOR_ONE_MINUS_SRC_ALPHA
 * ```
 */
@GodotBaseType
public open class RDPipelineColorBlendStateAttachment : RefCounted() {
  /**
   * If `true`, performs blending between the source and destination according to the factors
   * defined in [srcColorBlendFactor], [dstColorBlendFactor], [srcAlphaBlendFactor] and
   * [dstAlphaBlendFactor]. The blend modes [colorBlendOp] and [alphaBlendOp] are also taken into
   * account, with [writeR], [writeG], [writeB] and [writeA] controlling the output.
   */
  public final inline var enableBlend: Boolean
    @JvmName("enableBlendProperty")
    get() = getEnableBlend()
    @JvmName("enableBlendProperty")
    set(`value`) {
      setEnableBlend(value)
    }

  /**
   * Controls how the blend factor for the color channels is determined based on the source's
   * fragments.
   */
  public final inline var srcColorBlendFactor: RenderingDevice.BlendFactor
    @JvmName("srcColorBlendFactorProperty")
    get() = getSrcColorBlendFactor()
    @JvmName("srcColorBlendFactorProperty")
    set(`value`) {
      setSrcColorBlendFactor(value)
    }

  /**
   * Controls how the blend factor for the color channels is determined based on the destination's
   * fragments.
   */
  public final inline var dstColorBlendFactor: RenderingDevice.BlendFactor
    @JvmName("dstColorBlendFactorProperty")
    get() = getDstColorBlendFactor()
    @JvmName("dstColorBlendFactorProperty")
    set(`value`) {
      setDstColorBlendFactor(value)
    }

  /**
   * The blend mode to use for the red/green/blue color channels.
   */
  public final inline var colorBlendOp: RenderingDevice.BlendOperation
    @JvmName("colorBlendOpProperty")
    get() = getColorBlendOp()
    @JvmName("colorBlendOpProperty")
    set(`value`) {
      setColorBlendOp(value)
    }

  /**
   * Controls how the blend factor for the alpha channel is determined based on the source's
   * fragments.
   */
  public final inline var srcAlphaBlendFactor: RenderingDevice.BlendFactor
    @JvmName("srcAlphaBlendFactorProperty")
    get() = getSrcAlphaBlendFactor()
    @JvmName("srcAlphaBlendFactorProperty")
    set(`value`) {
      setSrcAlphaBlendFactor(value)
    }

  /**
   * Controls how the blend factor for the alpha channel is determined based on the destination's
   * fragments.
   */
  public final inline var dstAlphaBlendFactor: RenderingDevice.BlendFactor
    @JvmName("dstAlphaBlendFactorProperty")
    get() = getDstAlphaBlendFactor()
    @JvmName("dstAlphaBlendFactorProperty")
    set(`value`) {
      setDstAlphaBlendFactor(value)
    }

  /**
   * The blend mode to use for the alpha channel.
   */
  public final inline var alphaBlendOp: RenderingDevice.BlendOperation
    @JvmName("alphaBlendOpProperty")
    get() = getAlphaBlendOp()
    @JvmName("alphaBlendOpProperty")
    set(`value`) {
      setAlphaBlendOp(value)
    }

  /**
   * If `true`, writes the new red color channel to the final result.
   */
  public final inline var writeR: Boolean
    @JvmName("writeRProperty")
    get() = getWriteR()
    @JvmName("writeRProperty")
    set(`value`) {
      setWriteR(value)
    }

  /**
   * If `true`, writes the new green color channel to the final result.
   */
  public final inline var writeG: Boolean
    @JvmName("writeGProperty")
    get() = getWriteG()
    @JvmName("writeGProperty")
    set(`value`) {
      setWriteG(value)
    }

  /**
   * If `true`, writes the new blue color channel to the final result.
   */
  public final inline var writeB: Boolean
    @JvmName("writeBProperty")
    get() = getWriteB()
    @JvmName("writeBProperty")
    set(`value`) {
      setWriteB(value)
    }

  /**
   * If `true`, writes the new alpha channel to the final result.
   */
  public final inline var writeA: Boolean
    @JvmName("writeAProperty")
    get() = getWriteA()
    @JvmName("writeAProperty")
    set(`value`) {
      setWriteA(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(583, scriptPtr)
  }

  /**
   * Convenience method to perform standard mix blending with straight (non-premultiplied) alpha.
   * This sets [enableBlend] to `true`, [srcColorBlendFactor] to
   * [RenderingDevice.BLEND_FACTOR_SRC_ALPHA], [dstColorBlendFactor] to
   * [RenderingDevice.BLEND_FACTOR_ONE_MINUS_SRC_ALPHA], [srcAlphaBlendFactor] to
   * [RenderingDevice.BLEND_FACTOR_SRC_ALPHA] and [dstAlphaBlendFactor] to
   * [RenderingDevice.BLEND_FACTOR_ONE_MINUS_SRC_ALPHA].
   */
  public final fun setAsMix(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.setAsMixPtr)
  }

  public final fun setEnableBlend(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setEnableBlendPtr, pMember)
  }

  public final fun getEnableBlend(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getEnableBlendPtr)

  public final fun setSrcColorBlendFactor(pMember: RenderingDevice.BlendFactor): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSrcColorBlendFactorPtr, pMember.value)
  }

  public final fun getSrcColorBlendFactor(): RenderingDevice.BlendFactor =
      RenderingDevice.BlendFactor.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSrcColorBlendFactorPtr))

  public final fun setDstColorBlendFactor(pMember: RenderingDevice.BlendFactor): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setDstColorBlendFactorPtr, pMember.value)
  }

  public final fun getDstColorBlendFactor(): RenderingDevice.BlendFactor =
      RenderingDevice.BlendFactor.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDstColorBlendFactorPtr))

  public final fun setColorBlendOp(pMember: RenderingDevice.BlendOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setColorBlendOpPtr, pMember.value)
  }

  public final fun getColorBlendOp(): RenderingDevice.BlendOperation =
      RenderingDevice.BlendOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getColorBlendOpPtr))

  public final fun setSrcAlphaBlendFactor(pMember: RenderingDevice.BlendFactor): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setSrcAlphaBlendFactorPtr, pMember.value)
  }

  public final fun getSrcAlphaBlendFactor(): RenderingDevice.BlendFactor =
      RenderingDevice.BlendFactor.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getSrcAlphaBlendFactorPtr))

  public final fun setDstAlphaBlendFactor(pMember: RenderingDevice.BlendFactor): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setDstAlphaBlendFactorPtr, pMember.value)
  }

  public final fun getDstAlphaBlendFactor(): RenderingDevice.BlendFactor =
      RenderingDevice.BlendFactor.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDstAlphaBlendFactorPtr))

  public final fun setAlphaBlendOp(pMember: RenderingDevice.BlendOperation): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAlphaBlendOpPtr, pMember.value)
  }

  public final fun getAlphaBlendOp(): RenderingDevice.BlendOperation =
      RenderingDevice.BlendOperation.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAlphaBlendOpPtr))

  public final fun setWriteR(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setWriteRPtr, pMember)
  }

  public final fun getWriteR(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getWriteRPtr)

  public final fun setWriteG(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setWriteGPtr, pMember)
  }

  public final fun getWriteG(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getWriteGPtr)

  public final fun setWriteB(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setWriteBPtr, pMember)
  }

  public final fun getWriteB(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getWriteBPtr)

  public final fun setWriteA(pMember: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setWriteAPtr, pMember)
  }

  public final fun getWriteA(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getWriteAPtr)

  public companion object {
    @JvmField
    public val setAsMixName: MethodStringName0<RDPipelineColorBlendStateAttachment, Unit> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, Unit>("set_as_mix")

    @JvmField
    public val setEnableBlendName:
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean> =
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>("set_enable_blend")

    @JvmField
    public val getEnableBlendName: MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean>("get_enable_blend")

    @JvmField
    public val setSrcColorBlendFactorName:
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor> =
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor>("set_src_color_blend_factor")

    @JvmField
    public val getSrcColorBlendFactorName:
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor>("get_src_color_blend_factor")

    @JvmField
    public val setDstColorBlendFactorName:
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor> =
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor>("set_dst_color_blend_factor")

    @JvmField
    public val getDstColorBlendFactorName:
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor>("get_dst_color_blend_factor")

    @JvmField
    public val setColorBlendOpName:
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendOperation>
        =
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendOperation>("set_color_blend_op")

    @JvmField
    public val getColorBlendOpName:
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendOperation> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendOperation>("get_color_blend_op")

    @JvmField
    public val setSrcAlphaBlendFactorName:
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor> =
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor>("set_src_alpha_blend_factor")

    @JvmField
    public val getSrcAlphaBlendFactorName:
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor>("get_src_alpha_blend_factor")

    @JvmField
    public val setDstAlphaBlendFactorName:
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor> =
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendFactor>("set_dst_alpha_blend_factor")

    @JvmField
    public val getDstAlphaBlendFactorName:
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendFactor>("get_dst_alpha_blend_factor")

    @JvmField
    public val setAlphaBlendOpName:
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendOperation>
        =
        MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, RenderingDevice.BlendOperation>("set_alpha_blend_op")

    @JvmField
    public val getAlphaBlendOpName:
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendOperation> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, RenderingDevice.BlendOperation>("get_alpha_blend_op")

    @JvmField
    public val setWriteRName: MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>
        = MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>("set_write_r")

    @JvmField
    public val getWriteRName: MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean>("get_write_r")

    @JvmField
    public val setWriteGName: MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>
        = MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>("set_write_g")

    @JvmField
    public val getWriteGName: MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean>("get_write_g")

    @JvmField
    public val setWriteBName: MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>
        = MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>("set_write_b")

    @JvmField
    public val getWriteBName: MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean>("get_write_b")

    @JvmField
    public val setWriteAName: MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>
        = MethodStringName1<RDPipelineColorBlendStateAttachment, Unit, Boolean>("set_write_a")

    @JvmField
    public val getWriteAName: MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean> =
        MethodStringName0<RDPipelineColorBlendStateAttachment, Boolean>("get_write_a")
  }

  public object MethodBindings {
    internal val setAsMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_as_mix", 3218959716)

    internal val setEnableBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_enable_blend", 2586408642)

    internal val getEnableBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_enable_blend", 36873697)

    internal val setSrcColorBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_src_color_blend_factor", 2251019273)

    internal val getSrcColorBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_src_color_blend_factor", 3691288359)

    internal val setDstColorBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_dst_color_blend_factor", 2251019273)

    internal val getDstColorBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_dst_color_blend_factor", 3691288359)

    internal val setColorBlendOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_color_blend_op", 3073022720)

    internal val getColorBlendOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_color_blend_op", 1385093561)

    internal val setSrcAlphaBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_src_alpha_blend_factor", 2251019273)

    internal val getSrcAlphaBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_src_alpha_blend_factor", 3691288359)

    internal val setDstAlphaBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_dst_alpha_blend_factor", 2251019273)

    internal val getDstAlphaBlendFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_dst_alpha_blend_factor", 3691288359)

    internal val setAlphaBlendOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_alpha_blend_op", 3073022720)

    internal val getAlphaBlendOpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_alpha_blend_op", 1385093561)

    internal val setWriteRPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_write_r", 2586408642)

    internal val getWriteRPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_write_r", 36873697)

    internal val setWriteGPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_write_g", 2586408642)

    internal val getWriteGPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_write_g", 36873697)

    internal val setWriteBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_write_b", 2586408642)

    internal val getWriteBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_write_b", 36873697)

    internal val setWriteAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "set_write_a", 2586408642)

    internal val getWriteAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineColorBlendStateAttachment", "get_write_a", 36873697)
  }
}
