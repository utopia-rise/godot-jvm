// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class MouseButton(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Enum value which doesn't correspond to any mouse button. This is used to initialize
   * [MouseButton] properties with a generic state.
   */
  NONE(0),
  /**
   * Primary mouse button, usually assigned to the left button.
   */
  LEFT(1),
  /**
   * Secondary mouse button, usually assigned to the right button.
   */
  RIGHT(2),
  /**
   * Middle mouse button.
   */
  MIDDLE(3),
  /**
   * Mouse wheel scrolling up.
   */
  WHEEL_UP(4),
  /**
   * Mouse wheel scrolling down.
   */
  WHEEL_DOWN(5),
  /**
   * Mouse wheel left button (only present on some mice).
   */
  WHEEL_LEFT(6),
  /**
   * Mouse wheel right button (only present on some mice).
   */
  WHEEL_RIGHT(7),
  /**
   * Extra mouse button 1. This is sometimes present, usually to the sides of the mouse.
   */
  XBUTTON1(8),
  /**
   * Extra mouse button 2. This is sometimes present, usually to the sides of the mouse.
   */
  XBUTTON2(9),
  ;

  public companion object {
    public fun from(`value`: Long): MouseButton = entries.first { it.`value` == `value` }
  }
}
