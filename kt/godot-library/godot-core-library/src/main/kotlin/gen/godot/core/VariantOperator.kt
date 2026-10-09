// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class VariantOperator(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Equality operator (`==`).
   */
  OP_EQUAL(0),
  /**
   * Inequality operator (`!=`).
   */
  OP_NOT_EQUAL(1),
  /**
   * Less than operator (`<`).
   */
  OP_LESS(2),
  /**
   * Less than or equal operator (`<=`).
   */
  OP_LESS_EQUAL(3),
  /**
   * Greater than operator (`>`).
   */
  OP_GREATER(4),
  /**
   * Greater than or equal operator (`>=`).
   */
  OP_GREATER_EQUAL(5),
  /**
   * Addition operator (`+`).
   */
  OP_ADD(6),
  /**
   * Subtraction operator (`-`).
   */
  OP_SUBTRACT(7),
  /**
   * Multiplication operator (`*`).
   */
  OP_MULTIPLY(8),
  /**
   * Division operator (`/`).
   */
  OP_DIVIDE(9),
  /**
   * Unary negation operator (`-`).
   */
  OP_NEGATE(10),
  /**
   * Unary plus operator (`+`).
   */
  OP_POSITIVE(11),
  /**
   * Remainder/modulo operator (`&#37;`).
   */
  OP_MODULE(12),
  /**
   * Power operator (`**`).
   */
  OP_POWER(13),
  /**
   * Left shift operator (`<<`).
   */
  OP_SHIFT_LEFT(14),
  /**
   * Right shift operator (`>>`).
   */
  OP_SHIFT_RIGHT(15),
  /**
   * Bitwise AND operator (`&`).
   */
  OP_BIT_AND(16),
  /**
   * Bitwise OR operator (`|`).
   */
  OP_BIT_OR(17),
  /**
   * Bitwise XOR operator (`^`).
   */
  OP_BIT_XOR(18),
  /**
   * Bitwise NOT operator (`~`).
   */
  OP_BIT_NEGATE(19),
  /**
   * Logical AND operator (`and` or `&&`).
   */
  OP_AND(20),
  /**
   * Logical OR operator (`or` or `||`).
   */
  OP_OR(21),
  /**
   * Logical XOR operator (not implemented in GDScript).
   */
  OP_XOR(22),
  /**
   * Logical NOT operator (`not` or `!`).
   */
  OP_NOT(23),
  /**
   * Logical IN operator (`in`).
   */
  OP_IN(24),
  /**
   * Represents the size of the [Variant.Operator] enum.
   */
  OP_MAX(25),
  ;

  public companion object {
    public fun from(`value`: Long): VariantOperator = entries.first { it.`value` == `value` }
  }
}
