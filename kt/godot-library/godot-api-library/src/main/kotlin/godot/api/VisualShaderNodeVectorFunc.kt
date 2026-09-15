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
 * A visual shader node able to perform different functions using vectors.
 */
@GodotBaseType
public open class VisualShaderNodeVectorFunc : VisualShaderNodeVectorBase() {
  /**
   * The function to be performed.
   */
  public final inline var function: Function
    @JvmName("functionProperty")
    get() = getFunction()
    @JvmName("functionProperty")
    set(`value`) {
      setFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(911, scriptPtr)
  }

  public final fun setFunction(func: Function): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, func.value)
    TransferContext.callPtrMethod(MethodBindings.setFunctionPtr, 0)
  }

  public final fun getFunction(): Function {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFunctionPtr, 2)
    return Function.from(TransferContext.readReturnValue_LONG())
  }

  public enum class Function(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Normalizes the vector so that it has a length of `1` but points in the same direction.
     */
    NORMALIZE(0),
    /**
     * Clamps the value between `0.0` and `1.0`.
     */
    SATURATE(1),
    /**
     * Returns the opposite value of the parameter.
     */
    NEGATE(2),
    /**
     * Returns `1/vector`.
     */
    RECIPROCAL(3),
    /**
     * Returns the absolute value of the parameter.
     */
    ABS(4),
    /**
     * Returns the arc-cosine of the parameter.
     */
    ACOS(5),
    /**
     * Returns the inverse hyperbolic cosine of the parameter.
     */
    ACOSH(6),
    /**
     * Returns the arc-sine of the parameter.
     */
    ASIN(7),
    /**
     * Returns the inverse hyperbolic sine of the parameter.
     */
    ASINH(8),
    /**
     * Returns the arc-tangent of the parameter.
     */
    ATAN(9),
    /**
     * Returns the inverse hyperbolic tangent of the parameter.
     */
    ATANH(10),
    /**
     * Finds the nearest integer that is greater than or equal to the parameter.
     */
    CEIL(11),
    /**
     * Returns the cosine of the parameter.
     */
    COS(12),
    /**
     * Returns the hyperbolic cosine of the parameter.
     */
    COSH(13),
    /**
     * Converts a quantity in radians to degrees.
     */
    DEGREES(14),
    /**
     * Base-e Exponential.
     */
    EXP(15),
    /**
     * Base-2 Exponential.
     */
    EXP2(16),
    /**
     * Finds the nearest integer less than or equal to the parameter.
     */
    FLOOR(17),
    /**
     * Computes the fractional part of the argument.
     */
    FRACT(18),
    /**
     * Returns the inverse of the square root of the parameter.
     */
    INVERSE_SQRT(19),
    /**
     * Natural logarithm.
     */
    LOG(20),
    /**
     * Base-2 logarithm.
     */
    LOG2(21),
    /**
     * Converts a quantity in degrees to radians.
     */
    RADIANS(22),
    /**
     * Finds the nearest integer to the parameter.
     */
    ROUND(23),
    /**
     * Finds the nearest even integer to the parameter.
     */
    ROUNDEVEN(24),
    /**
     * Extracts the sign of the parameter, i.e. returns `-1` if the parameter is negative, `1` if
     * it's positive and `0` otherwise.
     */
    SIGN(25),
    /**
     * Returns the sine of the parameter.
     */
    SIN(26),
    /**
     * Returns the hyperbolic sine of the parameter.
     */
    SINH(27),
    /**
     * Returns the square root of the parameter.
     */
    SQRT(28),
    /**
     * Returns the tangent of the parameter.
     */
    TAN(29),
    /**
     * Returns the hyperbolic tangent of the parameter.
     */
    TANH(30),
    /**
     * Returns a value equal to the nearest integer to the parameter whose absolute value is not
     * larger than the absolute value of the parameter.
     */
    TRUNC(31),
    /**
     * Returns `1.0 - vector`.
     */
    ONEMINUS(32),
    /**
     * Represents the size of the [Function] enum.
     */
    MAX(33),
    ;

    public companion object {
      public fun from(`value`: Long): Function = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFunctionName: MethodStringName1<VisualShaderNodeVectorFunc, Unit, Function> =
        MethodStringName1<VisualShaderNodeVectorFunc, Unit, Function>("set_function")

    @JvmField
    public val getFunctionName: MethodStringName0<VisualShaderNodeVectorFunc, Function> =
        MethodStringName0<VisualShaderNodeVectorFunc, Function>("get_function")
  }

  public object MethodBindings {
    internal val setFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVectorFunc", "set_function", 629964457)

    internal val getFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeVectorFunc", "get_function", 4047776843)
  }
}
