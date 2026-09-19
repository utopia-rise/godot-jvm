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
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Custom Godot Shading Language expression, with a custom number of input and output ports.
 *
 * The provided code is directly injected into the graph's matching shader function (`vertex`,
 * `fragment`, or `light`), so it cannot be used to declare functions, varyings, uniforms, or global
 * constants. See [VisualShaderNodeGlobalExpression] for such global definitions.
 */
@GodotBaseType
public open class VisualShaderNodeExpression : VisualShaderNodeGroupBase() {
  /**
   * An expression in Godot Shading Language, which will be injected at the start of the graph's
   * matching shader function (`vertex`, `fragment`, or `light`), and thus cannot be used to declare
   * functions, varyings, uniforms, or global constants.
   */
  public final inline var expression: String
    @JvmName("expressionProperty")
    get() = getExpression()
    @JvmName("expressionProperty")
    set(`value`) {
      setExpression(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(826, scriptPtr)
  }

  public final fun setExpression(expression: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setExpressionPtr, expression)
  }

  public final fun getExpression(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getExpressionPtr)

  public companion object {
    @JvmField
    public val setExpressionName: MethodStringName1<VisualShaderNodeExpression, Unit, String> =
        MethodStringName1<VisualShaderNodeExpression, Unit, String>("set_expression")

    @JvmField
    public val getExpressionName: MethodStringName0<VisualShaderNodeExpression, String> =
        MethodStringName0<VisualShaderNodeExpression, String>("get_expression")
  }

  public object MethodBindings {
    internal val setExpressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeExpression", "set_expression", 83702148)

    internal val getExpressionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeExpression", "get_expression", 201670096)
  }
}
