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
 * A multiplication operation on a transform (4×4 matrix) and a vector, with support for different
 * multiplication operators.
 */
@GodotBaseType
public open class VisualShaderNodeTransformVecMult : VisualShaderNode() {
  /**
   * The multiplication type to be performed.
   */
  public final inline var `operator`: Operator
    @JvmName("operatorProperty")
    get() = getOperator()
    @JvmName("operatorProperty")
    set(`value`) {
      setOperator(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(891, scriptPtr)
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
     * Multiplies transform `a` by the vector `b`.
     */
    AxB(0),
    /**
     * Multiplies vector `b` by the transform `a`.
     */
    BxA(1),
    /**
     * Multiplies transform `a` by the vector `b`, skipping the last row and column of the
     * transform.
     */
    OP_3x3_AxB(2),
    /**
     * Multiplies vector `b` by the transform `a`, skipping the last row and column of the
     * transform.
     */
    OP_3x3_BxA(3),
    /**
     * Represents the size of the [Operator] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): Operator = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOperatorName: MethodStringName1<VisualShaderNodeTransformVecMult, Unit, Operator>
        = MethodStringName1<VisualShaderNodeTransformVecMult, Unit, Operator>("set_operator")

    @JvmField
    public val getOperatorName: MethodStringName0<VisualShaderNodeTransformVecMult, Operator> =
        MethodStringName0<VisualShaderNodeTransformVecMult, Operator>("get_operator")
  }

  public object MethodBindings {
    internal val setOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformVecMult", "set_operator", 1785665912)

    internal val getOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeTransformVecMult", "get_operator", 1622088722)
  }
}
