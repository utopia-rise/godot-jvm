// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Boolean
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 * An audio effect instance manipulates the audio it receives for a given effect. This instance is
 * automatically created by an [AudioEffect] when it is added to a bus, and should usually not be
 * created directly. If necessary, it can be fetched at run-time with
 * [AudioServer.getBusEffectInstance].
 */
@GodotBaseType
public abstract class AudioEffectInstance : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(63, scriptPtr)
  }

  /**
   * Override this method to customize the processing behavior of this effect instance.
   *
   * Should return `true` to force the [AudioServer] to always call [_process], even if the bus has
   * been muted or cannot otherwise be heard.
   */
  public open fun _processSilence(): Boolean {
    throw NotImplementedError("AudioEffectInstance::_processSilence is not implemented.")
  }

  public companion object

  public object MethodBindings
}

internal class AudioEffectInstanceDummy : AudioEffectInstance()
