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
 * A "notch" filter attenuates frequencies at [AudioEffectFilter.cutoffHz] and allows frequencies
 * outside the frequency threshold to pass unchanged. It is a narrower and stronger version of
 * [AudioEffectBandLimitFilter], and is the opposite of [AudioEffectBandPassFilter].
 *
 * This filter can be used to give more room for other sounds to play at that frequency. Because of
 * how much it attenuates frequencies, it can also be used to completely remove undesired frequencies.
 */
@GodotBaseType
public open class AudioEffectNotchFilter : AudioEffectFilter() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(67, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
