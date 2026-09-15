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
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_STRING
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Creating a reference to a [VisualShaderNodeParameter] allows you to reuse this parameter in
 * different shaders or shader stages easily.
 */
@GodotBaseType
public open class VisualShaderNodeParameterRef : VisualShaderNode() {
  /**
   * The name of the parameter which this reference points to.
   */
  public final inline var parameterName: String
    @JvmName("parameterNameProperty")
    get() = getParameterName()
    @JvmName("parameterNameProperty")
    set(`value`) {
      setParameterName(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(849, scriptPtr)
  }

  public final fun setParameterName(name: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setParameterNamePtr)
  }

  public final fun getParameterName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParameterNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val setParameterNameName: MethodStringName1<VisualShaderNodeParameterRef, Unit, String> =
        MethodStringName1<VisualShaderNodeParameterRef, Unit, String>("set_parameter_name")

    @JvmField
    public val getParameterNameName: MethodStringName0<VisualShaderNodeParameterRef, String> =
        MethodStringName0<VisualShaderNodeParameterRef, String>("get_parameter_name")
  }

  public object MethodBindings {
    internal val setParameterNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameterRef", "set_parameter_name", 83702148)

    internal val getParameterNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeParameterRef", "get_parameter_name", 201670096)
  }
}
