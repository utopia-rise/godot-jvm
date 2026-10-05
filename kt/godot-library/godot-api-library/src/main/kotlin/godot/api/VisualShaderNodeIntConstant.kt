// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to [code skip-lint]int[/code] in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeIntConstant : VisualShaderNodeConstant() {
  /**
   * An integer constant which represents a state of this node.
   */
  public final inline var constant: Int
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(838, scriptPtr)
  }

  public final fun setConstant(constant: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setConstantPtr, constant.toLong())
  }

  public final fun getConstant(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getConstantPtr).toInt()

  public companion object {
    @JvmField
    public val setConstantName: MethodStringName1<VisualShaderNodeIntConstant, Unit, Int> =
        MethodStringName1<VisualShaderNodeIntConstant, Unit, Int>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeIntConstant, Int> =
        MethodStringName0<VisualShaderNodeIntConstant, Int>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeIntConstant", "set_constant", 1286410249)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeIntConstant", "get_constant", 3905245786)
  }
}
