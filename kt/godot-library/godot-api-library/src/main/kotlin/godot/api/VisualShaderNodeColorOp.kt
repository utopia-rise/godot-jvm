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
 * Applies [operator] to two color inputs.
 */
@GodotBaseType
public open class VisualShaderNodeColorOp : VisualShaderNode() {
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
    createNativeObject(812, scriptPtr)
  }

  public final fun setOperator(op: Operator): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, op.value)
    TransferContext.callPtrMethod(MethodBindings.setOperatorPtr, 0)
  }

  public final fun getOperator(): Operator {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOperatorPtr, 2)
    return Operator.from(TransferContext.readReturnValue_LONG())
  }

  public enum class Operator(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Produce a screen effect with the following formula:
     *
     * ```
     * result = vec3(1.0) - (vec3(1.0) - a) * (vec3(1.0) - b);
     * ```
     */
    SCREEN(0),
    /**
     * Produce a difference effect with the following formula:
     *
     * ```
     * result = abs(a - b);
     * ```
     */
    DIFFERENCE(1),
    /**
     * Produce a darken effect with the following formula:
     *
     * ```
     * result = min(a, b);
     * ```
     */
    DARKEN(2),
    /**
     * Produce a lighten effect with the following formula:
     *
     * ```
     * result = max(a, b);
     * ```
     */
    LIGHTEN(3),
    /**
     * Produce an overlay effect with the following formula:
     *
     * ```
     * for (int i = 0; i < 3; i++) {
     * 	float base = a[i];
     * 	float blend = b[i];
     * 	if (base < 0.5) {
     * 		result[i] = 2.0 * base * blend;
     * 	} else {
     * 		result[i] = 1.0 - 2.0 * (1.0 - blend) * (1.0 - base);
     * 	}
     * }
     * ```
     */
    OVERLAY(4),
    /**
     * Produce a dodge effect with the following formula:
     *
     * ```
     * result = a / (vec3(1.0) - b);
     * ```
     */
    DODGE(5),
    /**
     * Produce a burn effect with the following formula:
     *
     * ```
     * result = vec3(1.0) - (vec3(1.0) - a) / b;
     * ```
     */
    BURN(6),
    /**
     * Produce a soft light effect with the following formula:
     *
     * ```
     * for (int i = 0; i < 3; i++) {
     * 	float base = a[i];
     * 	float blend = b[i];
     * 	if (base < 0.5) {
     * 		result[i] = base * (blend + 0.5);
     * 	} else {
     * 		result[i] = 1.0 - (1.0 - base) * (1.0 - (blend - 0.5));
     * 	}
     * }
     * ```
     */
    SOFT_LIGHT(7),
    /**
     * Produce a hard light effect with the following formula:
     *
     * ```
     * for (int i = 0; i < 3; i++) {
     * 	float base = a[i];
     * 	float blend = b[i];
     * 	if (base < 0.5) {
     * 		result[i] = base * (2.0 * blend);
     * 	} else {
     * 		result[i] = 1.0 - (1.0 - base) * (1.0 - 2.0 * (blend - 0.5));
     * 	}
     * }
     * ```
     */
    HARD_LIGHT(8),
    /**
     * Represents the size of the [Operator] enum.
     */
    MAX(9),
    ;

    public companion object {
      public fun from(`value`: Long): Operator = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setOperatorName: MethodStringName1<VisualShaderNodeColorOp, Unit, Operator> =
        MethodStringName1<VisualShaderNodeColorOp, Unit, Operator>("set_operator")

    @JvmField
    public val getOperatorName: MethodStringName0<VisualShaderNodeColorOp, Operator> =
        MethodStringName0<VisualShaderNodeColorOp, Operator>("get_operator")
  }

  public object MethodBindings {
    internal val setOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeColorOp", "set_operator", 4260370673)

    internal val getOperatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeColorOp", "get_operator", 1950956529)
  }
}
