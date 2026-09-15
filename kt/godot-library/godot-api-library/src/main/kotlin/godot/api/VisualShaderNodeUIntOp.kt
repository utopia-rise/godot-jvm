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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Applies [operator] to two unsigned integer inputs: `a` and `b`.
 */
@GodotBaseType
public open class VisualShaderNodeUIntOp : VisualShaderNode() {
  /**
   * An operator to be applied to the inputs.
   */
  public final inline var `operator`: Operator
    @JvmName("operatorProperty")
    get() = getOperator()
    @JvmName("operatorProperty")
    set(`value`) {
      setOperator(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(894, scriptPtr)
  }

  public final fun setOperator(op: Operator): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, op.value)
    TransferContext.callMethod(MethodBindings.setOperatorPtr)
  }

  public final fun getOperator(): Operator {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOperatorPtr)
    return Operator.from(TransferContext.readReturnValue_LONG())
  }

  public enum class Operator(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Sums two numbers using `a + b`.
     */
    ADD(0),
    /**
     * Subtracts two numbers using `a - b`.
     */
    SUB(1),
    /**
     * Multiplies two numbers using `a * b`.
     */
    MUL(2),
    /**
     * Divides two numbers using `a / b`.
     */
    DIV(3),
    /**
     * Calculates the remainder of two numbers using `a &#37; b`.
     */
    MOD(4),
    /**
     * Returns the greater of two numbers. Translates to `max(a, b)` in the Godot Shader Language.
     */
    MAX(5),
    /**
     * Returns the lesser of two numbers. Translates to `max(a, b)` in the Godot Shader Language.
     */
    MIN(6),
    /**
     * Returns the result of bitwise `AND` operation on the integer. Translates to `a & b` in the
     * Godot Shader Language.
     */
    BITWISE_AND(7),
    /**
     * Returns the result of bitwise `OR` operation for two integers. Translates to `a | b` in the
     * Godot Shader Language.
     */
    BITWISE_OR(8),
    /**
     * Returns the result of bitwise `XOR` operation for two integers. Translates to `a ^ b` in the
     * Godot Shader Language.
     */
    BITWISE_XOR(9),
    /**
     * Returns the result of bitwise left shift operation on the integer. Translates to `a << b` in
     * the Godot Shader Language.
     */
    BITWISE_LEFT_SHIFT(10),
    /**
     * Returns the result of bitwise right shift operation on the integer. Translates to `a >> b` in
     * the Godot Shader Language.
     */
    BITWISE_RIGHT_SHIFT(11),
    /**
     * Represents the size of the [Operator] enum.
     */
    ENUM_SIZE(12),
    ;

    public companion object {
      public fun from(`value`: Long): Operator = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOperatorName: MethodStringName1<VisualShaderNodeUIntOp, Unit, Operator> =
        MethodStringName1<VisualShaderNodeUIntOp, Unit, Operator>("set_operator")

    @JvmField
    public val getOperatorName: MethodStringName0<VisualShaderNodeUIntOp, Operator> =
        MethodStringName0<VisualShaderNodeUIntOp, Operator>("get_operator")
  }

  public object MethodBindings {
    internal val setOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntOp", "set_operator", 3463048345)

    internal val getOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeUIntOp", "get_operator", 256631461)
  }
}
