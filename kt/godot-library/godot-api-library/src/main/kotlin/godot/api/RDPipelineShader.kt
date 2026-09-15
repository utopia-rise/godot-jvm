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
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_RID
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Wraps a shader resource and allows specialization constants to be applied at pipeline creation
 * time.
 *
 * Used by [RenderingDevice.raytracingPipelineCreate] for ray generation, miss, and hit shaders. The
 * pipeline selects the required shader stage automatically.
 */
@GodotBaseType
public open class RDPipelineShader : RefCounted() {
  /**
   * Shader resource. The required stage is selected by the pipeline.
   */
  public final inline var shader: RID
    @JvmName("shaderProperty")
    get() = getShader()
    @JvmName("shaderProperty")
    set(`value`) {
      setShader(value)
    }

  /**
   * Specialization constants applied to the selected shader stage at pipeline creation time.
   */
  public final inline var specializationConstants: VariantArray<RDPipelineSpecializationConstant>
    @JvmName("specializationConstantsProperty")
    get() = getSpecializationConstants()
    @JvmName("specializationConstantsProperty")
    set(`value`) {
      setSpecializationConstants(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(587, scriptPtr)
  }

  public final fun setShader(pMember: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, pMember)
    TransferContext.callMethod(MethodBindings.setShaderPtr)
  }

  public final fun getShader(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShaderPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final
      fun setSpecializationConstants(specializationConstants: VariantArray<RDPipelineSpecializationConstant>):
      Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, specializationConstants)
    TransferContext.callMethod(MethodBindings.setSpecializationConstantsPtr)
  }

  public final fun getSpecializationConstants(): VariantArray<RDPipelineSpecializationConstant> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpecializationConstantsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<RDPipelineSpecializationConstant>)
  }

  public companion object {
    @JvmField
    public val setShaderName: MethodStringName1<RDPipelineShader, Unit, RID> =
        MethodStringName1<RDPipelineShader, Unit, RID>("set_shader")

    @JvmField
    public val getShaderName: MethodStringName0<RDPipelineShader, RID> =
        MethodStringName0<RDPipelineShader, RID>("get_shader")

    @JvmField
    public val setSpecializationConstantsName:
        MethodStringName1<RDPipelineShader, Unit, VariantArray<RDPipelineSpecializationConstant>> =
        MethodStringName1<RDPipelineShader, Unit, VariantArray<RDPipelineSpecializationConstant>>("set_specialization_constants")

    @JvmField
    public val getSpecializationConstantsName:
        MethodStringName0<RDPipelineShader, VariantArray<RDPipelineSpecializationConstant>> =
        MethodStringName0<RDPipelineShader, VariantArray<RDPipelineSpecializationConstant>>("get_specialization_constants")
  }

  public object MethodBindings {
    internal val setShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineShader", "set_shader", 2722037293)

    internal val getShaderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineShader", "get_shader", 2944877500)

    internal val setSpecializationConstantsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineShader", "set_specialization_constants", 381264803)

    internal val getSpecializationConstantsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RDPipelineShader", "get_specialization_constants", 3995934104)
  }
}
