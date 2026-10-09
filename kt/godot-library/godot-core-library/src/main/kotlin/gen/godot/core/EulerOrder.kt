// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class EulerOrder(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Specifies that Euler angles should be in intrinsic XYZ order. When composing, the rotations
   * happen around the local X, Y, and Z axes, in that order. When decomposing, the order is reversed,
   * first Z, then Y, and X last.
   */
  XYZ(0),
  /**
   * Specifies that Euler angles should be in intrinsic XZY order. When composing, the rotations
   * happen around the local X, Z, and Y axes, in that order. When decomposing, the order is reversed,
   * first Y, then Z, and X last.
   */
  XZY(1),
  /**
   * Specifies that Euler angles should be in intrinsic YXZ order. When composing, the rotations
   * happen around the local Y, X, and Z axes, in that order. When decomposing, the order is reversed,
   * first Z, then X, and Y last.
   */
  YXZ(2),
  /**
   * Specifies that Euler angles should be in intrinsic YZX order. When composing, the rotations
   * happen around the local Y, Z, and X axes, in that order. When decomposing, the order is reversed,
   * first X, then Z, and Y last.
   */
  YZX(3),
  /**
   * Specifies that Euler angles should be in intrinsic ZXY order. When composing, the rotations
   * happen around the local Z, X, and Y axes, in that order. When decomposing, the order is reversed,
   * first Y, then X, and Z last.
   */
  ZXY(4),
  /**
   * Specifies that Euler angles should be in intrinsic ZYX order. When composing, the rotations
   * happen around the local Z, Y, and X axes, in that order. When decomposing, the order is reversed,
   * first X, then Y, and Z last.
   */
  ZYX(5),
  ;

  public companion object {
    public fun from(`value`: Long): EulerOrder = entries.first { it.`value` == `value` }
  }
}
