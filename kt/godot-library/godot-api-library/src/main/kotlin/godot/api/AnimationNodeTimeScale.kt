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
 * Allows to scale the speed of the animation (or reverse it) in any child [AnimationNode]s. Setting
 * it to `0.0` will pause the animation.
 */
@GodotBaseType
public open class AnimationNodeTimeScale : AnimationNode() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(32, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
