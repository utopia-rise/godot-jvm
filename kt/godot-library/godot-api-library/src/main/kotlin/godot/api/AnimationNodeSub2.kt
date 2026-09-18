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
 * A resource to add to an [AnimationNodeBlendTree]. Blends two animations subtractively based on
 * the amount value.
 *
 * This animation node is usually used for pre-calculation to cancel out any extra poses from the
 * animation for the "add" animation source in [AnimationNodeAdd2] or [AnimationNodeAdd3].
 *
 * In general, the blend value should be in the `[0.0, 1.0]` range, but values outside of this range
 * can be used for amplified or inverted animations.
 *
 * **Note:** This calculation is different from using a negative value in [AnimationNodeAdd2], since
 * the transformation matrices do not satisfy the commutative law. [AnimationNodeSub2] multiplies the
 * transformation matrix of the inverted animation from the left side, while negative
 * [AnimationNodeAdd2] multiplies it from the right side.
 */
@GodotBaseType
public open class AnimationNodeSub2 : AnimationNodeSync() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(30, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
