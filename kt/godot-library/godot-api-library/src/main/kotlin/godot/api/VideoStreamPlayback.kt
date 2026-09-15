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
import godot.core.MethodStringName3
import godot.core.PackedFloat32Array
import godot.readReturnValue_LONG
import godot.writeMethodArguments_LONG_PACKED_FLOAT_32_ARRAY_LONG
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class is intended to be overridden by video decoder extensions with custom implementations
 * of [VideoStream].
 */
@GodotBaseType
public abstract class VideoStreamPlayback : Resource() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(793, scriptPtr)
  }

  /**
   * Stops playback. May be called multiple times before [_play], or in response to
   * [VideoStreamPlayer.stop]. [_isPlaying] should return `false` once stopped.
   */
  public open fun _stop(): Unit {
    throw NotImplementedError("VideoStreamPlayback::_stop is not implemented.")
  }

  /**
   * Called in response to [VideoStreamPlayer.autoplay] or [VideoStreamPlayer.play]. Note that
   * manual playback may also invoke [_stop] multiple times before this method is called. [_isPlaying]
   * should return `true` once playing.
   */
  public open fun _play(): Unit {
    throw NotImplementedError("VideoStreamPlayback::_play is not implemented.")
  }

  /**
   * Returns the playback state, as determined by calls to [_play] and [_stop].
   */
  public open fun _isPlaying(): Boolean {
    throw NotImplementedError("VideoStreamPlayback::_isPlaying is not implemented.")
  }

  /**
   * Set the paused status of video playback. [_isPaused] must return [paused]. Called in response
   * to the [VideoStreamPlayer.paused] setter.
   */
  public open fun _setPaused(paused: Boolean): Unit {
    throw NotImplementedError("VideoStreamPlayback::_setPaused is not implemented.")
  }

  /**
   * Returns the paused status, as set by [_setPaused].
   */
  public open fun _isPaused(): Boolean {
    throw NotImplementedError("VideoStreamPlayback::_isPaused is not implemented.")
  }

  /**
   * Returns the video duration in seconds, if known, or 0 if unknown.
   */
  public open fun _getLength(): Double {
    throw NotImplementedError("VideoStreamPlayback::_getLength is not implemented.")
  }

  /**
   * Return the current playback timestamp. Called in response to the
   * [VideoStreamPlayer.streamPosition] getter.
   */
  public open fun _getPlaybackPosition(): Double {
    throw NotImplementedError("VideoStreamPlayback::_getPlaybackPosition is not implemented.")
  }

  /**
   * Seeks to [time] seconds. Called in response to the [VideoStreamPlayer.streamPosition] setter.
   */
  public open fun _seek(time: Double): Unit {
    throw NotImplementedError("VideoStreamPlayback::_seek is not implemented.")
  }

  /**
   * Select the audio track [idx]. Called when playback starts, and in response to the
   * [VideoStreamPlayer.audioTrack] setter.
   */
  public open fun _setAudioTrack(idx: Int): Unit {
    throw NotImplementedError("VideoStreamPlayback::_setAudioTrack is not implemented.")
  }

  /**
   * Allocates a [Texture2D] in which decoded video frames will be drawn.
   */
  public open fun _getTexture(): Texture2D? {
    throw NotImplementedError("VideoStreamPlayback::_getTexture is not implemented.")
  }

  /**
   * Ticks video playback for [delta] seconds. Called every frame as long as both [_isPaused] and
   * [_isPlaying] return `true`.
   */
  public abstract fun _update(delta: Double): Unit

  /**
   * Returns the number of audio channels.
   */
  public open fun _getChannels(): Int {
    throw NotImplementedError("VideoStreamPlayback::_getChannels is not implemented.")
  }

  /**
   * Returns the audio sample rate used for mixing.
   */
  public open fun _getMixRate(): Int {
    throw NotImplementedError("VideoStreamPlayback::_getMixRate is not implemented.")
  }

  /**
   * Render [numFrames] audio frames (of [_getChannels] floats each) from [buffer], starting from
   * index [offset] in the array. Returns the number of audio frames rendered, or -1 on error.
   */
  @JvmOverloads
  public final fun mixAudio(
    numFrames: Int,
    buffer: PackedFloat32Array = PackedFloat32Array(),
    offset: Int = 0,
  ): Int {
    TransferContext.writeMethodArguments_LONG_PACKED_FLOAT_32_ARRAY_LONG(ptr, objectID.id, numFrames.toLong(), buffer, offset.toLong())
    TransferContext.callMethod(MethodBindings.mixAudioPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val mixAudioName:
        MethodStringName3<VideoStreamPlayback, Int, Int, PackedFloat32Array, Int> =
        MethodStringName3<VideoStreamPlayback, Int, Int, PackedFloat32Array, Int>("mix_audio")
  }

  public object MethodBindings {
    internal val mixAudioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayback", "mix_audio", 93876830)
  }
}

internal class VideoStreamPlaybackDummy : VideoStreamPlayback() {
  public override fun _update(delta: Double): Unit {
    throw NotImplementedError("VideoStreamPlayback::_update is only implemented by non-JVM code.")
  }
}
