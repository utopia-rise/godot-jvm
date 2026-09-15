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
import godot.core.MethodStringName2
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_STRING
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Shader source code in text form.
 *
 * See also [RDShaderFile]. [RDShaderSource] is only meant to be used with the [RenderingDevice]
 * API. It should not be confused with Godot's own [Shader] resource, which is what Godot's various
 * nodes use for high-level shader programming.
 */
@GodotBaseType
public open class RDShaderSource : RefCounted() {
  /**
   * Source code for the shader's vertex stage.
   */
  public final inline var sourceVertex: String
    @JvmName("sourceVertexProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.VERTEX)
    @JvmName("sourceVertexProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.VERTEX, value)
    }

  /**
   * Source code for the shader's fragment stage.
   */
  public final inline var sourceFragment: String
    @JvmName("sourceFragmentProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.FRAGMENT)
    @JvmName("sourceFragmentProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.FRAGMENT, value)
    }

  /**
   * Source code for the shader's tessellation control stage.
   */
  public final inline var sourceTesselationControl: String
    @JvmName("sourceTesselationControlProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.TESSELATION_CONTROL)
    @JvmName("sourceTesselationControlProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.TESSELATION_CONTROL, value)
    }

  /**
   * Source code for the shader's tessellation evaluation stage.
   */
  public final inline var sourceTesselationEvaluation: String
    @JvmName("sourceTesselationEvaluationProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.TESSELATION_EVALUATION)
    @JvmName("sourceTesselationEvaluationProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.TESSELATION_EVALUATION, value)
    }

  /**
   * Source code for the shader's compute stage.
   */
  public final inline var sourceCompute: String
    @JvmName("sourceComputeProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.COMPUTE)
    @JvmName("sourceComputeProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.COMPUTE, value)
    }

  /**
   * Source code for the shader's ray generation stage.
   */
  public final inline var sourceRaygen: String
    @JvmName("sourceRaygenProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.RAYGEN)
    @JvmName("sourceRaygenProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.RAYGEN, value)
    }

  /**
   * Source code for the shader's any hit stage.
   */
  public final inline var sourceAnyHit: String
    @JvmName("sourceAnyHitProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.ANY_HIT)
    @JvmName("sourceAnyHitProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.ANY_HIT, value)
    }

  /**
   * Source code for the shader's closest hit stage.
   */
  public final inline var sourceClosestHit: String
    @JvmName("sourceClosestHitProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.CLOSEST_HIT)
    @JvmName("sourceClosestHitProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.CLOSEST_HIT, value)
    }

  /**
   * Source code for the shader's miss stage.
   */
  public final inline var sourceMiss: String
    @JvmName("sourceMissProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.MISS)
    @JvmName("sourceMissProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.MISS, value)
    }

  /**
   * Source code for the shader's intersection stage.
   */
  public final inline var sourceIntersection: String
    @JvmName("sourceIntersectionProperty")
    get() = getStageSource(RenderingDevice.ShaderStage.INTERSECTION)
    @JvmName("sourceIntersectionProperty")
    set(`value`) {
      setStageSource(RenderingDevice.ShaderStage.INTERSECTION, value)
    }

  /**
   * The language the shader is written in.
   */
  public final inline var language: RenderingDevice.ShaderLanguage
    @JvmName("languageProperty")
    get() = getLanguage()
    @JvmName("languageProperty")
    set(`value`) {
      setLanguage(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(592, scriptPtr)
  }

  /**
   * Sets [source] code for the specified shader [stage]. Equivalent to setting one of
   * [sourceCompute], [sourceFragment], [sourceTesselationControl], [sourceTesselationEvaluation] or
   * [sourceVertex].
   *
   * **Note:** If you set the compute shader source code using this method directly, remember to
   * remove the Godot-specific hint `#[compute]`.
   */
  public final fun setStageSource(stage: RenderingDevice.ShaderStage, source: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, stage.value, source)
    TransferContext.callMethod(MethodBindings.setStageSourcePtr)
  }

  /**
   * Returns source code for the specified shader [stage]. Equivalent to getting one of
   * [sourceCompute], [sourceFragment], [sourceTesselationControl], [sourceTesselationEvaluation] or
   * [sourceVertex].
   */
  public final fun getStageSource(stage: RenderingDevice.ShaderStage): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, stage.value)
    TransferContext.callMethod(MethodBindings.getStageSourcePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setLanguage(language: RenderingDevice.ShaderLanguage): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, language.value)
    TransferContext.callMethod(MethodBindings.setLanguagePtr)
  }

  public final fun getLanguage(): RenderingDevice.ShaderLanguage {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguagePtr)
    return RenderingDevice.ShaderLanguage.from(TransferContext.readReturnValue_LONG())
  }

  public companion object {
    @JvmField
    public val setStageSourceName:
        MethodStringName2<RDShaderSource, Unit, RenderingDevice.ShaderStage, String> =
        MethodStringName2<RDShaderSource, Unit, RenderingDevice.ShaderStage, String>("set_stage_source")

    @JvmField
    public val getStageSourceName:
        MethodStringName1<RDShaderSource, String, RenderingDevice.ShaderStage> =
        MethodStringName1<RDShaderSource, String, RenderingDevice.ShaderStage>("get_stage_source")

    @JvmField
    public val setLanguageName:
        MethodStringName1<RDShaderSource, Unit, RenderingDevice.ShaderLanguage> =
        MethodStringName1<RDShaderSource, Unit, RenderingDevice.ShaderLanguage>("set_language")

    @JvmField
    public val getLanguageName: MethodStringName0<RDShaderSource, RenderingDevice.ShaderLanguage> =
        MethodStringName0<RDShaderSource, RenderingDevice.ShaderLanguage>("get_language")
  }

  public object MethodBindings {
    internal val setStageSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSource", "set_stage_source", 620821314)

    internal val getStageSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSource", "get_stage_source", 3354920045)

    internal val setLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSource", "set_language", 3422186742)

    internal val getLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDShaderSource", "get_language", 1063538261)
  }
}
