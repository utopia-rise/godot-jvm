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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Translated to `uint` in the shader language.
 */
@GodotBaseType
public open class VisualShaderNodeUIntConstant : VisualShaderNodeConstant() {
  /**
   * An unsigned integer constant which represents a state of this node.
   */
  public final inline var constant: Int
    @JvmName("constantProperty")
    get() = getConstant()
    @JvmName("constantProperty")
    set(`value`) {
      setConstant(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(892, scriptPtr)
  }

  public final fun setConstant(constant: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, constant.toLong())
    TransferContext.callMethod(MethodBindings.setConstantPtr)
  }

  public final fun getConstant(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConstantPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val setConstantName: MethodStringName1<VisualShaderNodeUIntConstant, Unit, Int> =
        MethodStringName1<VisualShaderNodeUIntConstant, Unit, Int>("set_constant")

    @JvmField
    public val getConstantName: MethodStringName0<VisualShaderNodeUIntConstant, Int> =
        MethodStringName0<VisualShaderNodeUIntConstant, Int>("get_constant")
  }

  public object MethodBindings {
    internal val setConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntConstant", "set_constant", 1286410249)

    internal val getConstantPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntConstant", "get_constant", 3905245786)
  }
}
