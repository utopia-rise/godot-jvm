// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.writeMethodArguments0
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Playback class used to mix an [AudioStream]'s audio samples to [AudioServer.getMixRate] using
 * cubic interpolation.
 */
@GodotBaseType
public abstract class AudioStreamPlaybackResampled : AudioStreamPlayback() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(93, scriptPtr)
  }

  /**
   * Returns an [AudioStream]'s sample rate, in Hz. Used to perform resampling.
   */
  public abstract fun _getStreamSamplingRate(): Float

  /**
   * Called when an [AudioStream] is played. Clears the cubic interpolation history and starts
   * mixing by calling [_mixResampled].
   */
  public final fun beginResample(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.beginResamplePtr)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _start(fromPos: Double): Unit {
    throw NotImplementedError("AudioStreamPlaybackResampled::_start can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _stop(): Unit {
    throw NotImplementedError("AudioStreamPlaybackResampled::_stop can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _isPlaying(): Boolean {
    throw NotImplementedError("AudioStreamPlaybackResampled::_isPlaying can't be called from the JVM.")
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getPlaybackPosition(): Double {
    throw NotImplementedError("AudioStreamPlaybackResampled::_getPlaybackPosition can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val beginResampleName: MethodStringName0<AudioStreamPlaybackResampled, Unit> =
        MethodStringName0<AudioStreamPlaybackResampled, Unit>("begin_resample")
  }

  public object MethodBindings {
    internal val beginResamplePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlaybackResampled", "begin_resample", 3218959716)
  }
}

internal class AudioStreamPlaybackResampledDummy : AudioStreamPlaybackResampled() {
  public override fun _getStreamSamplingRate(): Float {
    throw NotImplementedError("AudioStreamPlaybackResampled::_getStreamSamplingRate is only implemented by non-JVM code.")
  }
}
