// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class VerticalAlignment(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Vertical top alignment, usually for text-derived classes.
   */
  TOP(0),
  /**
   * Vertical center alignment, usually for text-derived classes.
   */
  CENTER(1),
  /**
   * Vertical bottom alignment, usually for text-derived classes.
   */
  BOTTOM(2),
  /**
   * Expand rows to fit height, usually for text-derived classes.
   */
  FILL(3),
  ;

  public companion object {
    public fun from(`value`: Long): VerticalAlignment = entries.first { it.`value` == `value` }
  }
}
