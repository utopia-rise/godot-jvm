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
 * Frequency bands:
 *
 * Band 1: 22 Hz
 *
 * Band 2: 32 Hz
 *
 * Band 3: 44 Hz
 *
 * Band 4: 63 Hz
 *
 * Band 5: 90 Hz
 *
 * Band 6: 125 Hz
 *
 * Band 7: 175 Hz
 *
 * Band 8: 250 Hz
 *
 * Band 9: 350 Hz
 *
 * Band 10: 500 Hz
 *
 * Band 11: 700 Hz
 *
 * Band 12: 1000 Hz
 *
 * Band 13: 1400 Hz
 *
 * Band 14: 2000 Hz
 *
 * Band 15: 2800 Hz
 *
 * Band 16: 4000 Hz
 *
 * Band 17: 5600 Hz
 *
 * Band 18: 8000 Hz
 *
 * Band 19: 11000 Hz
 *
 * Band 20: 16000 Hz
 *
 * Band 21: 22000 Hz
 *
 * See also [AudioEffectEQ], [AudioEffectEQ6], [AudioEffectEQ10].
 */
@GodotBaseType
public open class AudioEffectEQ21 : AudioEffectEQ() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(57, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
