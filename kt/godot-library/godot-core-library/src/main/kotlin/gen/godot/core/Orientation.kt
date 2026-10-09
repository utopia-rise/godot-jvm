// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class Orientation(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * General vertical alignment, usually used for [Separator], [ScrollBar], [Slider], etc.
   */
  VERTICAL(1),
  /**
   * General horizontal alignment, usually used for [Separator], [ScrollBar], [Slider], etc.
   */
  HORIZONTAL(0),
  ;

  public companion object {
    public fun from(`value`: Long): Orientation = entries.first { it.`value` == `value` }
  }
}
