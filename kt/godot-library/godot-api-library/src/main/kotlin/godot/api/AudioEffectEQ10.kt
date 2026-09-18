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
 * Band 1: 31 Hz
 *
 * Band 2: 62 Hz
 *
 * Band 3: 125 Hz
 *
 * Band 4: 250 Hz
 *
 * Band 5: 500 Hz
 *
 * Band 6: 1000 Hz
 *
 * Band 7: 2000 Hz
 *
 * Band 8: 4000 Hz
 *
 * Band 9: 8000 Hz
 *
 * Band 10: 16000 Hz
 *
 * See also [AudioEffectEQ], [AudioEffectEQ6], [AudioEffectEQ21].
 */
@GodotBaseType
public open class AudioEffectEQ10 : AudioEffectEQ() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(56, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
