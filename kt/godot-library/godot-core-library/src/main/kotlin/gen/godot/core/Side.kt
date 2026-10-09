// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class Side(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Left side, usually used for [Control] or [StyleBox]-derived classes.
   */
  LEFT(0),
  /**
   * Top side, usually used for [Control] or [StyleBox]-derived classes.
   */
  TOP(1),
  /**
   * Right side, usually used for [Control] or [StyleBox]-derived classes.
   */
  RIGHT(2),
  /**
   * Bottom side, usually used for [Control] or [StyleBox]-derived classes.
   */
  BOTTOM(3),
  ;

  public companion object {
    public fun from(`value`: Long): Side = entries.first { it.`value` == `value` }
  }
}
