// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod_BOOL
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Has only one output port and no inputs.
 *
 * Translated to [code skip-lint]bool[/code] in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeBooleanConstant : VisualShaderNodeConstant() {
  /**
   * A boolean constant which represents a state of this node.
   */
  public final inline var constant: Boolean
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(807, scriptPtr)
  }

  public final fun setConstant(constant: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setConstantPtr, constant)
  }

  public final fun getConstant(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getConstantPtr)

  public companion object {
    @JvmField
    public val setConstantName: MethodStringName1<VisualShaderNodeBooleanConstant, Unit, Boolean> =
        MethodStringName1<VisualShaderNodeBooleanConstant, Unit, Boolean>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeBooleanConstant, Boolean> =
        MethodStringName0<VisualShaderNodeBooleanConstant, Boolean>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeBooleanConstant", "set_constant", 2586408642)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeBooleanConstant", "get_constant", 36873697)
  }
}
