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
 * A "high-pass" filter attenuates frequencies lower than [AudioEffectFilter.cutoffHz] and allows
 * higher frequencies to pass unchanged.
 *
 * This filter can be used to remove "strength" from a sound, and give low-end space for basses and
 * impact sounds.
 */
@GodotBaseType
public open class AudioEffectHighPassFilter : AudioEffectFilter() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(61, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
