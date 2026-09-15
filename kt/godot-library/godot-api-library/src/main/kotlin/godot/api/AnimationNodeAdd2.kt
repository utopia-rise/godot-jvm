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
 * A resource to add to an [AnimationNodeBlendTree]. Blends two animations additively based on the
 * amount value.
 *
 * If the amount is greater than `1.0`, the animation connected to "in" port is blended with the
 * amplified animation connected to "add" port.
 *
 * If the amount is less than `0.0`, the animation connected to "in" port is blended with the
 * inverted animation connected to "add" port.
 */
@GodotBaseType
public open class AnimationNodeAdd2 : AnimationNodeSync() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(16, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
