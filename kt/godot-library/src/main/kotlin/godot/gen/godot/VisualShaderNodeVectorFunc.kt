// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit

/**
 * A vector function to be used within the visual shader graph.
 *
 * A visual shader node able to perform different functions using vectors.
 */
@GodotBaseType
public open class VisualShaderNodeVectorFunc : VisualShaderNode() {
  /**
   * The function to be performed. See [enum Function] for options.
   */
  public open var function: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_VISUALSHADERNODEVECTORFUNC_GET_FUNCTION, LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_VISUALSHADERNODEVECTORFUNC_SET_FUNCTION, NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_VISUALSHADERNODEVECTORFUNC)
  }

  public enum class Function(
    id: Long
  ) {
    /**
     * Normalizes the vector so that it has a length of `1` but points in the same direction.
     */
    FUNC_NORMALIZE(0),
    /**
     * Clamps the value between `0.0` and `1.0`.
     */
    FUNC_SATURATE(1),
    /**
     * Returns the opposite value of the parameter.
     */
    FUNC_NEGATE(2),
    /**
     * Returns `1/vector`.
     */
    FUNC_RECIPROCAL(3),
    /**
     * Converts RGB vector to HSV equivalent.
     */
    FUNC_RGB2HSV(4),
    /**
     * Converts HSV vector to RGB equivalent.
     */
    FUNC_HSV2RGB(5),
    /**
     * Returns the absolute value of the parameter.
     */
    FUNC_ABS(6),
    /**
     * Returns the arc-cosine of the parameter.
     */
    FUNC_ACOS(7),
    /**
     * Returns the inverse hyperbolic cosine of the parameter.
     */
    FUNC_ACOSH(8),
    /**
     * Returns the arc-sine of the parameter.
     */
    FUNC_ASIN(9),
    /**
     * Returns the inverse hyperbolic sine of the parameter.
     */
    FUNC_ASINH(10),
    /**
     * Returns the arc-tangent of the parameter.
     */
    FUNC_ATAN(11),
    /**
     * Returns the inverse hyperbolic tangent of the parameter.
     */
    FUNC_ATANH(12),
    /**
     * Finds the nearest integer that is greater than or equal to the parameter.
     */
    FUNC_CEIL(13),
    /**
     * Returns the cosine of the parameter.
     */
    FUNC_COS(14),
    /**
     * Returns the hyperbolic cosine of the parameter.
     */
    FUNC_COSH(15),
    /**
     * Converts a quantity in radians to degrees.
     */
    FUNC_DEGREES(16),
    /**
     * Base-e Exponential.
     */
    FUNC_EXP(17),
    /**
     * Base-2 Exponential.
     */
    FUNC_EXP2(18),
    /**
     * Finds the nearest integer less than or equal to the parameter.
     */
    FUNC_FLOOR(19),
    /**
     * Computes the fractional part of the argument.
     */
    FUNC_FRAC(20),
    /**
     * Returns the inverse of the square root of the parameter.
     */
    FUNC_INVERSE_SQRT(21),
    /**
     * Natural logarithm.
     */
    FUNC_LOG(22),
    /**
     * Base-2 logarithm.
     */
    FUNC_LOG2(23),
    /**
     * Converts a quantity in degrees to radians.
     */
    FUNC_RADIANS(24),
    /**
     * Finds the nearest integer to the parameter.
     */
    FUNC_ROUND(25),
    /**
     * Finds the nearest even integer to the parameter.
     */
    FUNC_ROUNDEVEN(26),
    /**
     * Extracts the sign of the parameter, i.e. returns `-1` if the parameter is negative, `1` if it's positive and `0` otherwise.
     */
    FUNC_SIGN(27),
    /**
     * Returns the sine of the parameter.
     */
    FUNC_SIN(28),
    /**
     * Returns the hyperbolic sine of the parameter.
     */
    FUNC_SINH(29),
    /**
     * Returns the square root of the parameter.
     */
    FUNC_SQRT(30),
    /**
     * Returns the tangent of the parameter.
     */
    FUNC_TAN(31),
    /**
     * Returns the hyperbolic tangent of the parameter.
     */
    FUNC_TANH(32),
    /**
     * Returns a value equal to the nearest integer to the parameter whose absolute value is not larger than the absolute value of the parameter.
     */
    FUNC_TRUNC(33),
    /**
     * Returns `1.0 - vector`.
     */
    FUNC_ONEMINUS(34),
    ;

    public val id: Long
    init {
      this.id = id
    }

    public companion object {
      public fun from(`value`: Long) = values().single { it.id == `value` }
    }
  }

  public companion object {
    /**
     * Returns the absolute value of the parameter.
     */
    public final const val FUNC_ABS: Long = 6

    /**
     * Returns the arc-cosine of the parameter.
     */
    public final const val FUNC_ACOS: Long = 7

    /**
     * Returns the inverse hyperbolic cosine of the parameter.
     */
    public final const val FUNC_ACOSH: Long = 8

    /**
     * Returns the arc-sine of the parameter.
     */
    public final const val FUNC_ASIN: Long = 9

    /**
     * Returns the inverse hyperbolic sine of the parameter.
     */
    public final const val FUNC_ASINH: Long = 10

    /**
     * Returns the arc-tangent of the parameter.
     */
    public final const val FUNC_ATAN: Long = 11

    /**
     * Returns the inverse hyperbolic tangent of the parameter.
     */
    public final const val FUNC_ATANH: Long = 12

    /**
     * Finds the nearest integer that is greater than or equal to the parameter.
     */
    public final const val FUNC_CEIL: Long = 13

    /**
     * Returns the cosine of the parameter.
     */
    public final const val FUNC_COS: Long = 14

    /**
     * Returns the hyperbolic cosine of the parameter.
     */
    public final const val FUNC_COSH: Long = 15

    /**
     * Converts a quantity in radians to degrees.
     */
    public final const val FUNC_DEGREES: Long = 16

    /**
     * Base-e Exponential.
     */
    public final const val FUNC_EXP: Long = 17

    /**
     * Base-2 Exponential.
     */
    public final const val FUNC_EXP2: Long = 18

    /**
     * Finds the nearest integer less than or equal to the parameter.
     */
    public final const val FUNC_FLOOR: Long = 19

    /**
     * Computes the fractional part of the argument.
     */
    public final const val FUNC_FRAC: Long = 20

    /**
     * Converts HSV vector to RGB equivalent.
     */
    public final const val FUNC_HSV2RGB: Long = 5

    /**
     * Returns the inverse of the square root of the parameter.
     */
    public final const val FUNC_INVERSE_SQRT: Long = 21

    /**
     * Natural logarithm.
     */
    public final const val FUNC_LOG: Long = 22

    /**
     * Base-2 logarithm.
     */
    public final const val FUNC_LOG2: Long = 23

    /**
     * Returns the opposite value of the parameter.
     */
    public final const val FUNC_NEGATE: Long = 2

    /**
     * Normalizes the vector so that it has a length of `1` but points in the same direction.
     */
    public final const val FUNC_NORMALIZE: Long = 0

    /**
     * Returns `1.0 - vector`.
     */
    public final const val FUNC_ONEMINUS: Long = 34

    /**
     * Converts a quantity in degrees to radians.
     */
    public final const val FUNC_RADIANS: Long = 24

    /**
     * Returns `1/vector`.
     */
    public final const val FUNC_RECIPROCAL: Long = 3

    /**
     * Converts RGB vector to HSV equivalent.
     */
    public final const val FUNC_RGB2HSV: Long = 4

    /**
     * Finds the nearest integer to the parameter.
     */
    public final const val FUNC_ROUND: Long = 25

    /**
     * Finds the nearest even integer to the parameter.
     */
    public final const val FUNC_ROUNDEVEN: Long = 26

    /**
     * Clamps the value between `0.0` and `1.0`.
     */
    public final const val FUNC_SATURATE: Long = 1

    /**
     * Extracts the sign of the parameter, i.e. returns `-1` if the parameter is negative, `1` if it's positive and `0` otherwise.
     */
    public final const val FUNC_SIGN: Long = 27

    /**
     * Returns the sine of the parameter.
     */
    public final const val FUNC_SIN: Long = 28

    /**
     * Returns the hyperbolic sine of the parameter.
     */
    public final const val FUNC_SINH: Long = 29

    /**
     * Returns the square root of the parameter.
     */
    public final const val FUNC_SQRT: Long = 30

    /**
     * Returns the tangent of the parameter.
     */
    public final const val FUNC_TAN: Long = 31

    /**
     * Returns the hyperbolic tangent of the parameter.
     */
    public final const val FUNC_TANH: Long = 32

    /**
     * Returns a value equal to the nearest integer to the parameter whose absolute value is not larger than the absolute value of the parameter.
     */
    public final const val FUNC_TRUNC: Long = 33
  }
}
