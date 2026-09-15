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
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to [code skip-lint]float[/code] in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeFloatConstant : VisualShaderNodeConstant() {
  /**
   * A floating-point constant which represents a state of this node.
   */
  public final inline var constant: Float
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(828, scriptPtr)
  }

  public final fun setConstant(constant: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, constant.toDouble())
    TransferContext.callMethod(MethodBindings.setConstantPtr)
  }

  public final fun getConstant(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setConstantName: MethodStringName1<VisualShaderNodeFloatConstant, Unit, Float> =
        MethodStringName1<VisualShaderNodeFloatConstant, Unit, Float>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeFloatConstant, Float> =
        MethodStringName0<VisualShaderNodeFloatConstant, Float>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatConstant", "set_constant", 373806689)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatConstant", "get_constant", 1740695150)
  }
}
