// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Gives access to input variables (built-ins) available for the shader. See the shading reference
 * for the list of available built-ins for each shader type (check `Tutorials` section for link).
 */
@GodotBaseType
public open class VisualShaderNodeInput : VisualShaderNode() {
  /**
   * Emitted when input is changed via [inputName].
   */
  public val inputTypeChanged: Signal0 by Signal0

  /**
   * One of the several input constants in lower-case style like: "vertex" (`VERTEX`) or
   * "point_size" (`POINT_SIZE`).
   */
  public final inline var inputName: String
    @JvmName("inputNameProperty")
    get() = getInputName()
    @JvmName("inputNameProperty")
    set(`value`) {
      setInputName(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(837, scriptPtr)
  }

  public final fun setInputName(name: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setInputNamePtr, name)
  }

  public final fun getInputName(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getInputNamePtr)

  /**
   * Returns a translated name of the current constant in the Godot Shader Language. E.g. `"ALBEDO"`
   * if the [inputName] equal to `"albedo"`.
   */
  public final fun getInputRealName(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getInputRealNamePtr)

  public companion object {
    @JvmField
    public val setInputNameName: MethodStringName1<VisualShaderNodeInput, Unit, String> =
        MethodStringName1<VisualShaderNodeInput, Unit, String>("set_input_name")

    @JvmField
    public val getInputNameName: MethodStringName0<VisualShaderNodeInput, String> =
        MethodStringName0<VisualShaderNodeInput, String>("get_input_name")

    @JvmField
    public val getInputRealNameName: MethodStringName0<VisualShaderNodeInput, String> =
        MethodStringName0<VisualShaderNodeInput, String>("get_input_real_name")
  }

  public object MethodBindings {
    internal val setInputNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeInput", "set_input_name", 83702148)

    internal val getInputNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeInput", "get_input_name", 201670096)

    internal val getInputRealNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeInput", "get_input_real_name", 201670096)
  }
}
