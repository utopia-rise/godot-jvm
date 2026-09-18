// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Boolean
import kotlin.Double
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 * Playback component of [AudioStreamSynchronized]. Handles the playback of multiple [AudioStream]s
 * in synchrony.
 */
@GodotBaseType
public open class AudioStreamPlaybackSynchronized internal constructor() : AudioStreamPlayback() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(94, scriptPtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _start(fromPos: Double): Unit {
    throw NotImplementedError("AudioStreamPlaybackSynchronized::_start can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _stop(): Unit {
    throw NotImplementedError("AudioStreamPlaybackSynchronized::_stop can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _isPlaying(): Boolean {
    throw NotImplementedError("AudioStreamPlaybackSynchronized::_isPlaying can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getPlaybackPosition(): Double {
    throw NotImplementedError("AudioStreamPlaybackSynchronized::_getPlaybackPosition can't be called from the JVM.")
  }

  public companion object

  public object MethodBindings
}
