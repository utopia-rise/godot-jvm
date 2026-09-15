// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 * When used directly in an [AudioStreamPlayer] node, [AudioStreamMicrophone] plays back microphone
 * input in real-time. This can be used in conjunction with [AudioEffectCapture] to process the data or
 * save it.
 *
 * **Note:** [ProjectSettings.audio/driver/enableInput] must be `true` for audio input to work. See
 * also that setting's description for caveats related to permissions and operating system privacy
 * settings.
 */
@GodotBaseType
public open class AudioStreamMicrophone : AudioStream() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(86, scriptPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamMicrophone::_instantiatePlayback can't be called from the JVM.")
  }

  public companion object

  public object MethodBindings
}
