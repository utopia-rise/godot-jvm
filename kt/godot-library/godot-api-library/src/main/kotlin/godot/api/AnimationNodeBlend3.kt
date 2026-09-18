// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * A resource to add to an [AnimationNodeBlendTree]. Blends two animations out of three linearly out
 * of three based on the amount value.
 *
 * This animation node has three inputs:
 *
 * - The base animation to blend with
 *
 * - A "-blend" animation to blend with when the blend amount is negative value
 *
 * - A "+blend" animation to blend with when the blend amount is positive value
 *
 * In general, the blend value should be in the `[-1.0, 1.0]` range. Values outside of this range
 * can blend amplified animations, however, [AnimationNodeAdd3] works better for this purpose.
 */
@GodotBaseType
public open class AnimationNodeBlend3 : AnimationNodeSync() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(20, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
