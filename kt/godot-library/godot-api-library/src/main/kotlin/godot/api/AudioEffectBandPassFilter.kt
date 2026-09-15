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
 * A "band-pass" filter allows the frequencies at [AudioEffectFilter.cutoffHz] to pass unchanged,
 * and attenuates frequencies outside the frequency threshold. It is the opposite of
 * [AudioEffectBandLimitFilter] and [AudioEffectNotchFilter].
 *
 * This filter can be used to emulate sounds coming from weak speakers.
 */
@GodotBaseType
public open class AudioEffectBandPassFilter : AudioEffectFilter() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(49, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
