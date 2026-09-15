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
 * Accept a floating-point scalar (`x`) to the input port and transform it according to [function].
 */
@GodotBaseType
public open class VisualShaderNodeFloatFunc : VisualShaderNode() {
  /**
   * A function to be applied to the scalar.
   */
  public final inline var function: Function
    @JvmName("functionProperty")
    get() = getFunction()
    @JvmName("functionProperty")
    set(`value`) {
      setFunction(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(829, scriptPtr)
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
     * Returns the sine of the parameter. Translates to `sin(x)` in the Godot Shader Language.
     */
    SIN(0),
    /**
     * Returns the cosine of the parameter. Translates to `cos(x)` in the Godot Shader Language.
     */
    COS(1),
    /**
     * Returns the tangent of the parameter. Translates to `tan(x)` in the Godot Shader Language.
     */
    TAN(2),
    /**
     * Returns the arc-sine of the parameter. Translates to `asin(x)` in the Godot Shader Language.
     */
    ASIN(3),
    /**
     * Returns the arc-cosine of the parameter. Translates to `acos(x)` in the Godot Shader
     * Language.
     */
    ACOS(4),
    /**
     * Returns the arc-tangent of the parameter. Translates to `atan(x)` in the Godot Shader
     * Language.
     */
    ATAN(5),
    /**
     * Returns the hyperbolic sine of the parameter. Translates to `sinh(x)` in the Godot Shader
     * Language.
     */
    SINH(6),
    /**
     * Returns the hyperbolic cosine of the parameter. Translates to `cosh(x)` in the Godot Shader
     * Language.
     */
    COSH(7),
    /**
     * Returns the hyperbolic tangent of the parameter. Translates to `tanh(x)` in the Godot Shader
     * Language.
     */
    TANH(8),
    /**
     * Returns the natural logarithm of the parameter. Translates to `log(x)` in the Godot Shader
     * Language.
     */
    LOG(9),
    /**
     * Returns the natural exponentiation of the parameter. Translates to `exp(x)` in the Godot
     * Shader Language.
     */
    EXP(10),
    /**
     * Returns the square root of the parameter. Translates to `sqrt(x)` in the Godot Shader
     * Language.
     */
    SQRT(11),
    /**
     * Returns the absolute value of the parameter. Translates to `abs(x)` in the Godot Shader
     * Language.
     */
    ABS(12),
    /**
     * Extracts the sign of the parameter. Translates to `sign(x)` in the Godot Shader Language.
     */
    SIGN(13),
    /**
     * Finds the nearest integer less than or equal to the parameter. Translates to `floor(x)` in
     * the Godot Shader Language.
     */
    FLOOR(14),
    /**
     * Finds the nearest integer to the parameter. Translates to `round(x)` in the Godot Shader
     * Language.
     */
    ROUND(15),
    /**
     * Finds the nearest integer that is greater than or equal to the parameter. Translates to
     * `ceil(x)` in the Godot Shader Language.
     */
    CEIL(16),
    /**
     * Computes the fractional part of the argument. Translates to `fract(x)` in the Godot Shader
     * Language.
     */
    FRACT(17),
    /**
     * Clamps the value between `0.0` and `1.0` using `min(max(x, 0.0), 1.0)`.
     */
    SATURATE(18),
    /**
     * Negates the `x` using `-(x)`.
     */
    NEGATE(19),
    /**
     * Returns the arc-hyperbolic-cosine of the parameter. Translates to `acosh(x)` in the Godot
     * Shader Language.
     */
    ACOSH(20),
    /**
     * Returns the arc-hyperbolic-sine of the parameter. Translates to `asinh(x)` in the Godot
     * Shader Language.
     */
    ASINH(21),
    /**
     * Returns the arc-hyperbolic-tangent of the parameter. Translates to `atanh(x)` in the Godot
     * Shader Language.
     */
    ATANH(22),
    /**
     * Convert a quantity in radians to degrees. Translates to `degrees(x)` in the Godot Shader
     * Language.
     */
    DEGREES(23),
    /**
     * Returns 2 raised by the power of the parameter. Translates to `exp2(x)` in the Godot Shader
     * Language.
     */
    EXP2(24),
    /**
     * Returns the inverse of the square root of the parameter. Translates to `inversesqrt(x)` in
     * the Godot Shader Language.
     */
    INVERSE_SQRT(25),
    /**
     * Returns the base 2 logarithm of the parameter. Translates to `log2(x)` in the Godot Shader
     * Language.
     */
    LOG2(26),
    /**
     * Convert a quantity in degrees to radians. Translates to `radians(x)` in the Godot Shader
     * Language.
     */
    RADIANS(27),
    /**
     * Finds reciprocal value of dividing 1 by `x` (i.e. `1 / x`).
     */
    RECIPROCAL(28),
    /**
     * Finds the nearest even integer to the parameter. Translates to `roundEven(x)` in the Godot
     * Shader Language.
     */
    ROUNDEVEN(29),
    /**
     * Returns a value equal to the nearest integer to `x` whose absolute value is not larger than
     * the absolute value of `x`. Translates to `trunc(x)` in the Godot Shader Language.
     */
    TRUNC(30),
    /**
     * Subtracts scalar `x` from 1 (i.e. `1 - x`).
     */
    ONEMINUS(31),
    /**
     * Represents the size of the [Function] enum.
     */
    MAX(32),
    ;

    public companion object {
      public fun from(`value`: Long): Function = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setFunctionName: MethodStringName1<VisualShaderNodeFloatFunc, Unit, Function> =
        MethodStringName1<VisualShaderNodeFloatFunc, Unit, Function>("set_function")

    @JvmField
    public val getFunctionName: MethodStringName0<VisualShaderNodeFloatFunc, Function> =
        MethodStringName0<VisualShaderNodeFloatFunc, Function>("get_function")
  }

  public object MethodBindings {
    internal val setFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatFunc", "set_function", 536026177)

    internal val getFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VisualShaderNodeFloatFunc", "get_function", 2033948868)
  }
}
