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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A visual shader node for use of vector operators. Operates on vector `a` and vector `b`.
 */
@GodotBaseType
public open class VisualShaderNodeVectorOp : VisualShaderNodeVectorBase() {
  /**
   * The operator to be used.
   */
  public final inline var `operator`: Operator
    @JvmName("operatorProperty")
    get() = getOperator()
    @JvmName("operatorProperty")
    set(`value`) {
      setOperator(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(913, scriptPtr)
  }

  public final fun setOperator(op: Operator): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOperatorPtr, op.value)
  }

  public final fun getOperator(): Operator =
      Operator.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOperatorPtr))

  public enum class Operator(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Adds two vectors.
     */
    ADD(0),
    /**
     * Subtracts a vector from a vector.
     */
    SUB(1),
    /**
     * Multiplies two vectors.
     */
    MUL(2),
    /**
     * Divides vector by vector.
     */
    DIV(3),
    /**
     * Returns the remainder of the two vectors.
     */
    MOD(4),
    /**
     * Returns the value of the first parameter raised to the power of the second, for each
     * component of the vectors.
     */
    POW(5),
    /**
     * Returns the greater of two values, for each component of the vectors.
     */
    MAX(6),
    /**
     * Returns the lesser of two values, for each component of the vectors.
     */
    MIN(7),
    /**
     * Calculates the cross product of two vectors.
     */
    CROSS(8),
    /**
     * Returns the arc-tangent of the parameters.
     */
    ATAN2(9),
    /**
     * Returns the vector that points in the direction of reflection. `a` is incident vector and `b`
     * is the normal vector.
     */
    REFLECT(10),
    /**
     * Vector step operator. Returns `0.0` if `a` is smaller than `b` and `1.0` otherwise.
     */
    STEP(11),
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
    public val setOperatorName: MethodStringName1<VisualShaderNodeVectorOp, Unit, Operator> =
        MethodStringName1<VisualShaderNodeVectorOp, Unit, Operator>("set_operator")

    @JvmField
    public val getOperatorName: MethodStringName0<VisualShaderNodeVectorOp, Operator> =
        MethodStringName0<VisualShaderNodeVectorOp, Operator>("get_operator")
  }

  public object MethodBindings {
    internal val setOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVectorOp", "set_operator", 3371507302)

    internal val getOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVectorOp", "get_operator", 11793929)
  }
}
