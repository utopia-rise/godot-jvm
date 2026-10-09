// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class JoyAxis(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * An invalid game controller axis.
   */
  INVALID(-1),
  /**
   * Game controller left joystick x-axis.
   */
  LEFT_X(0),
  /**
   * Game controller left joystick y-axis.
   */
  LEFT_Y(1),
  /**
   * Game controller right joystick x-axis.
   */
  RIGHT_X(2),
  /**
   * Game controller right joystick y-axis.
   */
  RIGHT_Y(3),
  /**
   * Game controller left trigger axis.
   */
  TRIGGER_LEFT(4),
  /**
   * Game controller right trigger axis.
   */
  TRIGGER_RIGHT(5),
  /**
   * The number of SDL game controller axes.
   */
  SDL_MAX(6),
  /**
   * The maximum number of game controller axes: OpenVR supports up to 5 Joysticks making a total of
   * 10 axes.
   */
  MAX(10),
  ;

  public companion object {
    public fun from(`value`: Long): JoyAxis = entries.first { it.`value` == `value` }
  }
}
