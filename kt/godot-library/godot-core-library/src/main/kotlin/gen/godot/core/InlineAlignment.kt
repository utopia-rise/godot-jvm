// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.core

import kotlin.Long
import kotlin.Suppress

public enum class InlineAlignment(
  public override val `value`: Long,
) : GodotEnum {
  /**
   * Aligns the top of the inline object (e.g. image, table) to the position of the text specified
   * by `INLINE_ALIGNMENT_TO_*` constant.
   */
  TOP_TO(0),
  /**
   * Aligns the center of the inline object (e.g. image, table) to the position of the text
   * specified by `INLINE_ALIGNMENT_TO_*` constant.
   */
  CENTER_TO(1),
  /**
   * Aligns the baseline (user defined) of the inline object (e.g. image, table) to the position of
   * the text specified by `INLINE_ALIGNMENT_TO_*` constant.
   */
  BASELINE_TO(3),
  /**
   * Aligns the bottom of the inline object (e.g. image, table) to the position of the text
   * specified by `INLINE_ALIGNMENT_TO_*` constant.
   */
  BOTTOM_TO(2),
  /**
   * Aligns the position of the inline object (e.g. image, table) specified by
   * `INLINE_ALIGNMENT_*_TO` constant to the top of the text.
   */
  TO_TOP(0),
  /**
   * Aligns the position of the inline object (e.g. image, table) specified by
   * `INLINE_ALIGNMENT_*_TO` constant to the center of the text.
   */
  TO_CENTER(4),
  /**
   * Aligns the position of the inline object (e.g. image, table) specified by
   * `INLINE_ALIGNMENT_*_TO` constant to the baseline of the text.
   */
  TO_BASELINE(8),
  /**
   * Aligns inline object (e.g. image, table) to the bottom of the text.
   */
  TO_BOTTOM(12),
  /**
   * Aligns top of the inline object (e.g. image, table) to the top of the text. Equivalent to
   * `INLINE_ALIGNMENT_TOP_TO | INLINE_ALIGNMENT_TO_TOP`.
   */
  TOP(0),
  /**
   * Aligns center of the inline object (e.g. image, table) to the center of the text. Equivalent to
   * `INLINE_ALIGNMENT_CENTER_TO | INLINE_ALIGNMENT_TO_CENTER`.
   */
  CENTER(5),
  /**
   * Aligns bottom of the inline object (e.g. image, table) to the bottom of the text. Equivalent to
   * `INLINE_ALIGNMENT_BOTTOM_TO | INLINE_ALIGNMENT_TO_BOTTOM`.
   */
  BOTTOM(14),
  /**
   * A bit mask for `INLINE_ALIGNMENT_*_TO` alignment constants.
   */
  IMAGE_MASK(3),
  /**
   * A bit mask for `INLINE_ALIGNMENT_TO_*` alignment constants.
   */
  TEXT_MASK(12),
  ;

  public companion object {
    public fun from(`value`: Long): InlineAlignment = entries.first { it.`value` == `value` }
  }
}
