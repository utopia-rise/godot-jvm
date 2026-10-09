// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class Corner(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Top-left corner.
   */
  TOP_LEFT(0),
  /**
   * Top-right corner.
   */
  TOP_RIGHT(1),
  /**
   * Bottom-right corner.
   */
  BOTTOM_RIGHT(2),
  /**
   * Bottom-left corner.
   */
  BOTTOM_LEFT(3),
  ;

  public companion object {
    public fun from(`value`: Long): Corner = entries.first { it.`value` == `value` }
  }
}
