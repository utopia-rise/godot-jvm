// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class JoyButton(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * An invalid game controller button.
   */
  INVALID(-1),
  /**
   * Game controller SDL button A. Corresponds to the bottom action button: Sony Cross, Xbox A,
   * Nintendo B.
   */
  A(0),
  /**
   * Game controller SDL button B. Corresponds to the right action button: Sony Circle, Xbox B,
   * Nintendo A.
   */
  B(1),
  /**
   * Game controller SDL button X. Corresponds to the left action button: Sony Square, Xbox X,
   * Nintendo Y.
   */
  X(2),
  /**
   * Game controller SDL button Y. Corresponds to the top action button: Sony Triangle, Xbox Y,
   * Nintendo X.
   */
  Y(3),
  /**
   * Game controller SDL back button. Corresponds to the Sony Select, Xbox Back, Nintendo - button.
   */
  BACK(4),
  /**
   * Game controller SDL guide button. Corresponds to the Sony PS, Xbox Home button.
   */
  GUIDE(5),
  /**
   * Game controller SDL start button. Corresponds to the Sony Options, Xbox Menu, Nintendo +
   * button.
   */
  START(6),
  /**
   * Game controller SDL left stick button. Corresponds to the Sony L3, Xbox L/LS button.
   */
  LEFT_STICK(7),
  /**
   * Game controller SDL right stick button. Corresponds to the Sony R3, Xbox R/RS button.
   */
  RIGHT_STICK(8),
  /**
   * Game controller SDL left shoulder button. Corresponds to the Sony L1, Xbox LB button.
   */
  LEFT_SHOULDER(9),
  /**
   * Game controller SDL right shoulder button. Corresponds to the Sony R1, Xbox RB button.
   */
  RIGHT_SHOULDER(10),
  /**
   * Game controller D-pad up button.
   */
  DPAD_UP(11),
  /**
   * Game controller D-pad down button.
   */
  DPAD_DOWN(12),
  /**
   * Game controller D-pad left button.
   */
  DPAD_LEFT(13),
  /**
   * Game controller D-pad right button.
   */
  DPAD_RIGHT(14),
  /**
   * Game controller SDL miscellaneous button. Corresponds to Xbox share button, PS5 microphone
   * button, Nintendo Switch capture button.
   */
  MISC1(15),
  /**
   * Game controller SDL paddle 1 button.
   */
  PADDLE1(16),
  /**
   * Game controller SDL paddle 2 button.
   */
  PADDLE2(17),
  /**
   * Game controller SDL paddle 3 button.
   */
  PADDLE3(18),
  /**
   * Game controller SDL paddle 4 button.
   */
  PADDLE4(19),
  /**
   * Game controller SDL touchpad button.
   */
  TOUCHPAD(20),
  /**
   * Game controller SDL miscellaneous button. Used by Nintendo Switch 2 Pro Controller and Horipad
   * Steam controllers.
   */
  MISC2(21),
  /**
   * Game controller SDL miscellaneous button.
   */
  MISC3(22),
  /**
   * Game controller SDL miscellaneous button.
   */
  MISC4(23),
  /**
   * Game controller SDL miscellaneous button.
   */
  MISC5(24),
  /**
   * Game controller SDL miscellaneous button.
   */
  MISC6(25),
  /**
   * The number of SDL game controller buttons.
   */
  SDL_MAX(26),
  /**
   * The maximum number of game controller buttons supported by the engine. The actual limit may be
   * lower on specific platforms:
   *
   * - **Android:** Up to 36 buttons.
   *
   * - **Linux:** Up to 80 buttons.
   *
   * - **Windows** and **macOS:** Up to 128 buttons.
   */
  MAX(128),
  ;

  public companion object {
    public fun from(`value`: Long): JoyButton = entries.first { it.`value` == `value` }
  }
}
