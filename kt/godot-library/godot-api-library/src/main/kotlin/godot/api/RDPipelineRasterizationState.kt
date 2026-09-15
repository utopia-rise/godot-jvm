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
public open class RDPipelineRasterizationState : RefCounted() {
  /**
   * If `true`, clamps depth values according to the minimum and maximum depth of the associated
   * viewport.
   */
  public final inline var enableDepthClamp: Boolean
    @JvmName("enableDepthClampProperty")
    get() = getEnableDepthClamp()
    @JvmName("enableDepthClampProperty")
    set(`value`) {
      setEnableDepthClamp(value)
    }

  /**
   * If `true`, primitives are discarded immediately before the rasterization stage.
   */
  public final inline var discardPrimitives: Boolean
    @JvmName("discardPrimitivesProperty")
    get() = getDiscardPrimitives()
    @JvmName("discardPrimitivesProperty")
    set(`value`) {
      setDiscardPrimitives(value)
    }

  /**
   * If `true`, performs wireframe rendering for triangles instead of flat or textured rendering.
   */
  public final inline var wireframe: Boolean
    @JvmName("wireframeProperty")
    get() = getWireframe()
    @JvmName("wireframeProperty")
    set(`value`) {
      setWireframe(value)
    }

  /**
   * The cull mode to use when drawing polygons, which determines whether front faces or backfaces
   * are hidden.
   */
  public final inline var cullMode: RenderingDevice.PolygonCullMode
    @JvmName("cullModeProperty")
    get() = getCullMode()
    @JvmName("cullModeProperty")
    set(`value`) {
      setCullMode(value)
    }

  /**
   * The winding order to use to determine which face of a triangle is considered its front face.
   */
  public final inline var frontFace: RenderingDevice.PolygonFrontFace
    @JvmName("frontFaceProperty")
    get() = getFrontFace()
    @JvmName("frontFaceProperty")
    set(`value`) {
      setFrontFace(value)
    }

  /**
   * If `true`, each generated depth value will by offset by some amount. The specific amount is
   * generated per polygon based on the values of [depthBiasSlopeFactor] and [depthBiasConstantFactor].
   */
  public final inline var depthBiasEnabled: Boolean
    @JvmName("depthBiasEnabledProperty")
    get() = getDepthBiasEnabled()
    @JvmName("depthBiasEnabledProperty")
    set(`value`) {
      setDepthBiasEnabled(value)
    }

  /**
   * A constant offset added to each depth value. Applied after [depthBiasSlopeFactor].
   */
  public final inline var depthBiasConstantFactor: Float
    @JvmName("depthBiasConstantFactorProperty")
    get() = getDepthBiasConstantFactor()
    @JvmName("depthBiasConstantFactorProperty")
    set(`value`) {
      setDepthBiasConstantFactor(value)
    }

  /**
   * A limit for how much each depth value can be offset. If negative, it serves as a minimum value,
   * but if positive, it serves as a maximum value.
   */
  public final inline var depthBiasClamp: Float
    @JvmName("depthBiasClampProperty")
    get() = getDepthBiasClamp()
    @JvmName("depthBiasClampProperty")
    set(`value`) {
      setDepthBiasClamp(value)
    }

  /**
   * A constant scale applied to the slope of each polygons' depth. Applied before
   * [depthBiasConstantFactor].
   */
  public final inline var depthBiasSlopeFactor: Float
    @JvmName("depthBiasSlopeFactorProperty")
    get() = getDepthBiasSlopeFactor()
    @JvmName("depthBiasSlopeFactorProperty")
    set(`value`) {
      setDepthBiasSlopeFactor(value)
    }

  /**
   * The line width to use when drawing lines (in pixels). Thick lines may not be supported on all
   * hardware.
   */
  public final inline var lineWidth: Float
    @JvmName("lineWidthProperty")
    get() = getLineWidth()
    @JvmName("lineWidthProperty")
    set(`value`) {
      setLineWidth(value)
    }

  /**
   * The number of control points to use when drawing a patch with tessellation enabled. Higher
   * values result in higher quality at the cost of performance.
   */
  public final inline var patchControlPoints: Long
    @JvmName("patchControlPointsProperty")
    get() = getPatchControlPoints()
    @JvmName("patchControlPointsProperty")
    set(`value`) {
      setPatchControlPoints(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(586, scriptPtr)
  }

  public final fun setEnableDepthClamp(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pMember)
    TransferContext.callMethod(MethodBindings.setEnableDepthClampPtr)
  }

  public final fun getEnableDepthClamp(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnableDepthClampPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDiscardPrimitives(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pMember)
    TransferContext.callMethod(MethodBindings.setDiscardPrimitivesPtr)
  }

  public final fun getDiscardPrimitives(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDiscardPrimitivesPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setWireframe(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pMember)
    TransferContext.callMethod(MethodBindings.setWireframePtr)
  }

  public final fun getWireframe(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWireframePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setCullMode(pMember: RenderingDevice.PolygonCullMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setCullModePtr)
  }

  public final fun getCullMode(): RenderingDevice.PolygonCullMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCullModePtr)
    return RenderingDevice.PolygonCullMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFrontFace(pMember: RenderingDevice.PolygonFrontFace): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember.value)
    TransferContext.callMethod(MethodBindings.setFrontFacePtr)
  }

  public final fun getFrontFace(): RenderingDevice.PolygonFrontFace {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrontFacePtr)
    return RenderingDevice.PolygonFrontFace.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setDepthBiasEnabled(pMember: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pMember)
    TransferContext.callMethod(MethodBindings.setDepthBiasEnabledPtr)
  }

  public final fun getDepthBiasEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthBiasEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDepthBiasConstantFactor(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setDepthBiasConstantFactorPtr)
  }

  public final fun getDepthBiasConstantFactor(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthBiasConstantFactorPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDepthBiasClamp(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setDepthBiasClampPtr)
  }

  public final fun getDepthBiasClamp(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthBiasClampPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setDepthBiasSlopeFactor(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setDepthBiasSlopeFactorPtr)
  }

  public final fun getDepthBiasSlopeFactor(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDepthBiasSlopeFactorPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setLineWidth(pMember: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pMember.toDouble())
    TransferContext.callMethod(MethodBindings.setLineWidthPtr)
  }

  public final fun getLineWidth(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLineWidthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPatchControlPoints(pMember: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to pMember)
    TransferContext.callMethod(MethodBindings.setPatchControlPointsPtr)
  }

  public final fun getPatchControlPoints(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPatchControlPointsPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public companion object {
    @JvmField
    public val setEnableDepthClampName:
        MethodStringName1<RDPipelineRasterizationState, Unit, Boolean> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Boolean>("set_enable_depth_clamp")

    @JvmField
    public val getEnableDepthClampName: MethodStringName0<RDPipelineRasterizationState, Boolean> =
        MethodStringName0<RDPipelineRasterizationState, Boolean>("get_enable_depth_clamp")

    @JvmField
    public val setDiscardPrimitivesName:
        MethodStringName1<RDPipelineRasterizationState, Unit, Boolean> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Boolean>("set_discard_primitives")

    @JvmField
    public val getDiscardPrimitivesName: MethodStringName0<RDPipelineRasterizationState, Boolean> =
        MethodStringName0<RDPipelineRasterizationState, Boolean>("get_discard_primitives")

    @JvmField
    public val setWireframeName: MethodStringName1<RDPipelineRasterizationState, Unit, Boolean> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Boolean>("set_wireframe")

    @JvmField
    public val getWireframeName: MethodStringName0<RDPipelineRasterizationState, Boolean> =
        MethodStringName0<RDPipelineRasterizationState, Boolean>("get_wireframe")

    @JvmField
    public val setCullModeName:
        MethodStringName1<RDPipelineRasterizationState, Unit, RenderingDevice.PolygonCullMode> =
        MethodStringName1<RDPipelineRasterizationState, Unit, RenderingDevice.PolygonCullMode>("set_cull_mode")

    @JvmField
    public val getCullModeName:
        MethodStringName0<RDPipelineRasterizationState, RenderingDevice.PolygonCullMode> =
        MethodStringName0<RDPipelineRasterizationState, RenderingDevice.PolygonCullMode>("get_cull_mode")

    @JvmField
    public val setFrontFaceName:
        MethodStringName1<RDPipelineRasterizationState, Unit, RenderingDevice.PolygonFrontFace> =
        MethodStringName1<RDPipelineRasterizationState, Unit, RenderingDevice.PolygonFrontFace>("set_front_face")

    @JvmField
    public val getFrontFaceName:
        MethodStringName0<RDPipelineRasterizationState, RenderingDevice.PolygonFrontFace> =
        MethodStringName0<RDPipelineRasterizationState, RenderingDevice.PolygonFrontFace>("get_front_face")

    @JvmField
    public val setDepthBiasEnabledName:
        MethodStringName1<RDPipelineRasterizationState, Unit, Boolean> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Boolean>("set_depth_bias_enabled")

    @JvmField
    public val getDepthBiasEnabledName: MethodStringName0<RDPipelineRasterizationState, Boolean> =
        MethodStringName0<RDPipelineRasterizationState, Boolean>("get_depth_bias_enabled")

    @JvmField
    public val setDepthBiasConstantFactorName:
        MethodStringName1<RDPipelineRasterizationState, Unit, Float> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Float>("set_depth_bias_constant_factor")

    @JvmField
    public val getDepthBiasConstantFactorName:
        MethodStringName0<RDPipelineRasterizationState, Float> =
        MethodStringName0<RDPipelineRasterizationState, Float>("get_depth_bias_constant_factor")

    @JvmField
    public val setDepthBiasClampName: MethodStringName1<RDPipelineRasterizationState, Unit, Float> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Float>("set_depth_bias_clamp")

    @JvmField
    public val getDepthBiasClampName: MethodStringName0<RDPipelineRasterizationState, Float> =
        MethodStringName0<RDPipelineRasterizationState, Float>("get_depth_bias_clamp")

    @JvmField
    public val setDepthBiasSlopeFactorName:
        MethodStringName1<RDPipelineRasterizationState, Unit, Float> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Float>("set_depth_bias_slope_factor")

    @JvmField
    public val getDepthBiasSlopeFactorName: MethodStringName0<RDPipelineRasterizationState, Float> =
        MethodStringName0<RDPipelineRasterizationState, Float>("get_depth_bias_slope_factor")

    @JvmField
    public val setLineWidthName: MethodStringName1<RDPipelineRasterizationState, Unit, Float> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Float>("set_line_width")

    @JvmField
    public val getLineWidthName: MethodStringName0<RDPipelineRasterizationState, Float> =
        MethodStringName0<RDPipelineRasterizationState, Float>("get_line_width")

    @JvmField
    public val setPatchControlPointsName:
        MethodStringName1<RDPipelineRasterizationState, Unit, Long> =
        MethodStringName1<RDPipelineRasterizationState, Unit, Long>("set_patch_control_points")

    @JvmField
    public val getPatchControlPointsName: MethodStringName0<RDPipelineRasterizationState, Long> =
        MethodStringName0<RDPipelineRasterizationState, Long>("get_patch_control_points")
  }

  public object MethodBindings {
    internal val setEnableDepthClampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_enable_depth_clamp", 2586408642)

    internal val getEnableDepthClampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_enable_depth_clamp", 36873697)

    internal val setDiscardPrimitivesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_discard_primitives", 2586408642)

    internal val getDiscardPrimitivesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_discard_primitives", 36873697)

    internal val setWireframePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_wireframe", 2586408642)

    internal val getWireframePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_wireframe", 36873697)

    internal val setCullModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_cull_mode", 2662586502)

    internal val getCullModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_cull_mode", 2192484313)

    internal val setFrontFacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_front_face", 2637251213)

    internal val getFrontFacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_front_face", 708793786)

    internal val setDepthBiasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_depth_bias_enabled", 2586408642)

    internal val getDepthBiasEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_depth_bias_enabled", 36873697)

    internal val setDepthBiasConstantFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_depth_bias_constant_factor", 373806689)

    internal val getDepthBiasConstantFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_depth_bias_constant_factor", 1740695150)

    internal val setDepthBiasClampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_depth_bias_clamp", 373806689)

    internal val getDepthBiasClampPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_depth_bias_clamp", 1740695150)

    internal val setDepthBiasSlopeFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_depth_bias_slope_factor", 373806689)

    internal val getDepthBiasSlopeFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_depth_bias_slope_factor", 1740695150)

    internal val setLineWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_line_width", 373806689)

    internal val getLineWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_line_width", 1740695150)

    internal val setPatchControlPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "set_patch_control_points", 1286410249)

    internal val getPatchControlPointsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineRasterizationState", "get_patch_control_points", 3905245786)
  }
}
