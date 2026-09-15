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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING_NAME
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * The [AudioStreamPlayer] node plays an audio stream non-positionally. It is ideal for user
 * interfaces, menus, or background music.
 *
 * To use this node, [stream] needs to be set to a valid [AudioStream] resource. Playing more than
 * one sound at the same time is also supported, see [maxPolyphony].
 *
 * If you need to play audio at a specific position, use [AudioStreamPlayer2D] or
 * [AudioStreamPlayer3D] instead.
 */
@GodotBaseType
public open class AudioStreamPlayer : Node() {
  /**
   * Emitted when a sound finishes playing without interruptions. This signal is *not* emitted when
   * calling [stop], or when exiting the tree while sounds are playing.
   */
  public val finished: Signal0 by Signal0

  /**
   * The [AudioStream] resource to be played. Setting this property stops all currently playing
   * sounds. If left empty, the [AudioStreamPlayer] does not work.
   */
  public final inline var stream: AudioStream?
    @JvmName("streamProperty")
    get() = getStream()
    @JvmName("streamProperty")
    set(`value`) {
      setStream(value)
    }

  /**
   * Volume of sound, in decibels. This is an offset of the [stream]'s volume.
   *
   * **Note:** To convert between decibel and linear energy (like most volume sliders do), use
   * [volumeLinear], or [@GlobalScope.dbToLinear] and [@GlobalScope.linearToDb].
   */
  public final inline var volumeDb: Float
    @JvmName("volumeDbProperty")
    get() = getVolumeDb()
    @JvmName("volumeDbProperty")
    set(`value`) {
      setVolumeDb(value)
    }

  /**
   * Volume of sound, as a linear value.
   *
   * **Note:** This member modifies [volumeDb] for convenience. The returned value is equivalent to
   * the result of [@GlobalScope.dbToLinear] on [volumeDb]. Setting this member is equivalent to
   * setting [volumeDb] to the result of [@GlobalScope.linearToDb] on a value.
   */
  public final inline var volumeLinear: Float
    @JvmName("volumeLinearProperty")
    get() = getVolumeLinear()
    @JvmName("volumeLinearProperty")
    set(`value`) {
      setVolumeLinear(value)
    }

  /**
   * The audio's pitch and tempo, as a multiplier of the [stream]'s sample rate. A value of `2.0`
   * doubles the audio's pitch, while a value of `0.5` halves the pitch.
   */
  public final inline var pitchScale: Float
    @JvmName("pitchScaleProperty")
    get() = getPitchScale()
    @JvmName("pitchScaleProperty")
    set(`value`) {
      setPitchScale(value)
    }

  /**
   * If `true`, this node is playing sounds. Setting this property has the same effect as [play] and
   * [stop].
   */
  public final inline var playing: Boolean
    @JvmName("playingProperty")
    get() = isPlaying()
    @JvmName("playingProperty")
    set(`value`) {
      setPlaying(value)
    }

  /**
   * If `true`, this node calls [play] when entering the tree.
   */
  public final inline var autoplay: Boolean
    @JvmName("autoplayProperty")
    get() = isAutoplayEnabled()
    @JvmName("autoplayProperty")
    set(`value`) {
      setAutoplay(value)
    }

  /**
   * If `true`, the sounds are paused. Setting [streamPaused] to `false` resumes all sounds.
   *
   * **Note:** This property is automatically changed when exiting or entering the tree, or this
   * node is paused (see [Node.processMode]).
   */
  public final inline var streamPaused: Boolean
    @JvmName("streamPausedProperty")
    get() = getStreamPaused()
    @JvmName("streamPausedProperty")
    set(`value`) {
      setStreamPaused(value)
    }

  /**
   * The mix target channels. Has no effect when two speakers or less are detected (see
   * [AudioServer.SpeakerMode]).
   */
  public final inline var mixTarget: MixTarget
    @JvmName("mixTargetProperty")
    get() = getMixTarget()
    @JvmName("mixTargetProperty")
    set(`value`) {
      setMixTarget(value)
    }

  /**
   * The maximum number of sounds this node can play at the same time. Calling [play] after this
   * value is reached will cut off the oldest sounds.
   */
  public final inline var maxPolyphony: Int
    @JvmName("maxPolyphonyProperty")
    get() = getMaxPolyphony()
    @JvmName("maxPolyphonyProperty")
    set(`value`) {
      setMaxPolyphony(value)
    }

  /**
   * The target bus name. All sounds from this node will be playing on this bus.
   *
   * **Note:** At runtime, if no bus with the given name exists, all sounds will fall back on
   * `"Master"`. See also [AudioServer.getBusName].
   */
  public final inline var bus: StringName
    @JvmName("busProperty")
    get() = getBus()
    @JvmName("busProperty")
    set(`value`) {
      setBus(value)
    }

  /**
   * The playback type of the stream player. If set other than to the default value, it will force
   * that playback type.
   */
  public final inline var playbackType: AudioServer.PlaybackType
    @JvmName("playbackTypeProperty")
    get() = getPlaybackType()
    @JvmName("playbackTypeProperty")
    set(`value`) {
      setPlaybackType(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(95, scriptPtr)
  }

  public final fun setStream(stream: AudioStream?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, stream)
    TransferContext.callPtrMethod(MethodBindings.setStreamPtr, 0)
  }

  public final fun getStream(): AudioStream? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStreamPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AudioStream?)
  }

  public final fun setVolumeDb(volumeDb: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, volumeDb.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setVolumeDbPtr, 0)
  }

  public final fun getVolumeDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVolumeDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setVolumeLinear(volumeLinear: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, volumeLinear.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setVolumeLinearPtr, 0)
  }

  public final fun getVolumeLinear(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVolumeLinearPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPitchScale(pitchScale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, pitchScale.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPitchScalePtr, 0)
  }

  public final fun getPitchScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPitchScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Plays a sound from the beginning, or the given [fromPosition] in seconds.
   */
  @JvmOverloads
  public final fun play(fromPosition: Float = 0.0f): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, fromPosition.toDouble())
    TransferContext.callPtrMethod(MethodBindings.playPtr, 0)
  }

  /**
   * Restarts all sounds to be played from the given [toPosition], in seconds. Does nothing if no
   * sounds are playing.
   */
  public final fun seek(toPosition: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, toPosition.toDouble())
    TransferContext.callPtrMethod(MethodBindings.seekPtr, 0)
  }

  /**
   * Stops all sounds from this node.
   */
  public final fun stop(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.stopPtr, 0)
  }

  public final fun isPlaying(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPlayingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the position in the [AudioStream] of the latest sound, in seconds. Returns `0.0` if no
   * sounds are playing.
   *
   * **Note:** The position is not always accurate, as the [AudioServer] does not mix audio every
   * processed frame. To get more accurate results, add [AudioServer.getTimeSinceLastMix] to the
   * returned position.
   *
   * **Note:** This method always returns `0.0` if the [stream] is an [AudioStreamInteractive],
   * since it can have multiple clips playing at once.
   */
  public final fun getPlaybackPosition(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPlaybackPositionPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setBus(bus: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, bus)
    TransferContext.callPtrMethod(MethodBindings.setBusPtr, 0)
  }

  public final fun getBus(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBusPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setAutoplay(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setAutoplayPtr, 0)
  }

  public final fun isAutoplayEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isAutoplayEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setMixTarget(mixTarget: MixTarget): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mixTarget.value)
    TransferContext.callPtrMethod(MethodBindings.setMixTargetPtr, 0)
  }

  public final fun getMixTarget(): MixTarget {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMixTargetPtr, 2)
    return MixTarget.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPlaying(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setPlayingPtr, 0)
  }

  public final fun setStreamPaused(pause: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pause)
    TransferContext.callPtrMethod(MethodBindings.setStreamPausedPtr, 0)
  }

  public final fun getStreamPaused(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStreamPausedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setMaxPolyphony(maxPolyphony: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxPolyphony.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMaxPolyphonyPtr, 0)
  }

  public final fun getMaxPolyphony(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxPolyphonyPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if any sound is active, even if [streamPaused] is set to `true`. See also
   * [playing] and [getStreamPlayback].
   */
  public final fun hasStreamPlayback(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasStreamPlaybackPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the latest [AudioStreamPlayback] of this node, usually the most recently created by
   * [play]. If no sounds are playing, this method fails and returns an empty playback.
   */
  public final fun getStreamPlayback(): AudioStreamPlayback? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStreamPlaybackPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AudioStreamPlayback?)
  }

  public final fun setPlaybackType(playbackType: AudioServer.PlaybackType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, playbackType.value)
    TransferContext.callPtrMethod(MethodBindings.setPlaybackTypePtr, 0)
  }

  public final fun getPlaybackType(): AudioServer.PlaybackType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPlaybackTypePtr, 2)
    return AudioServer.PlaybackType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setBus(bus: String) = setBus(bus.asCachedStringName())

  public enum class MixTarget(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The audio will be played only on the first channel. This is the default.
     */
    STEREO(0),
    /**
     * The audio will be played on all surround channels.
     */
    SURROUND(1),
    /**
     * The audio will be played on the second channel, which is usually the center.
     */
    CENTER(2),
    ;

    public companion object {
      public fun from(`value`: Long): MixTarget = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setStreamName: MethodStringName1<AudioStreamPlayer, Unit, AudioStream?> =
        MethodStringName1<AudioStreamPlayer, Unit, AudioStream?>("set_stream")

    @JvmField
    public val getStreamName: MethodStringName0<AudioStreamPlayer, AudioStream?> =
        MethodStringName0<AudioStreamPlayer, AudioStream?>("get_stream")

    @JvmField
    public val setVolumeDbName: MethodStringName1<AudioStreamPlayer, Unit, Float> =
        MethodStringName1<AudioStreamPlayer, Unit, Float>("set_volume_db")

    @JvmField
    public val getVolumeDbName: MethodStringName0<AudioStreamPlayer, Float> =
        MethodStringName0<AudioStreamPlayer, Float>("get_volume_db")

    @JvmField
    public val setVolumeLinearName: MethodStringName1<AudioStreamPlayer, Unit, Float> =
        MethodStringName1<AudioStreamPlayer, Unit, Float>("set_volume_linear")

    @JvmField
    public val getVolumeLinearName: MethodStringName0<AudioStreamPlayer, Float> =
        MethodStringName0<AudioStreamPlayer, Float>("get_volume_linear")

    @JvmField
    public val setPitchScaleName: MethodStringName1<AudioStreamPlayer, Unit, Float> =
        MethodStringName1<AudioStreamPlayer, Unit, Float>("set_pitch_scale")

    @JvmField
    public val getPitchScaleName: MethodStringName0<AudioStreamPlayer, Float> =
        MethodStringName0<AudioStreamPlayer, Float>("get_pitch_scale")

    @JvmField
    public val playName: MethodStringName1<AudioStreamPlayer, Unit, Float> =
        MethodStringName1<AudioStreamPlayer, Unit, Float>("play")

    @JvmField
    public val seekName: MethodStringName1<AudioStreamPlayer, Unit, Float> =
        MethodStringName1<AudioStreamPlayer, Unit, Float>("seek")

    @JvmField
    public val stopName: MethodStringName0<AudioStreamPlayer, Unit> =
        MethodStringName0<AudioStreamPlayer, Unit>("stop")

    @JvmField
    public val isPlayingName: MethodStringName0<AudioStreamPlayer, Boolean> =
        MethodStringName0<AudioStreamPlayer, Boolean>("is_playing")

    @JvmField
    public val getPlaybackPositionName: MethodStringName0<AudioStreamPlayer, Float> =
        MethodStringName0<AudioStreamPlayer, Float>("get_playback_position")

    @JvmField
    public val setBusName: MethodStringName1<AudioStreamPlayer, Unit, StringName> =
        MethodStringName1<AudioStreamPlayer, Unit, StringName>("set_bus")

    @JvmField
    public val getBusName: MethodStringName0<AudioStreamPlayer, StringName> =
        MethodStringName0<AudioStreamPlayer, StringName>("get_bus")

    @JvmField
    public val setAutoplayName: MethodStringName1<AudioStreamPlayer, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer, Unit, Boolean>("set_autoplay")

    @JvmField
    public val isAutoplayEnabledName: MethodStringName0<AudioStreamPlayer, Boolean> =
        MethodStringName0<AudioStreamPlayer, Boolean>("is_autoplay_enabled")

    @JvmField
    public val setMixTargetName: MethodStringName1<AudioStreamPlayer, Unit, MixTarget> =
        MethodStringName1<AudioStreamPlayer, Unit, MixTarget>("set_mix_target")

    @JvmField
    public val getMixTargetName: MethodStringName0<AudioStreamPlayer, MixTarget> =
        MethodStringName0<AudioStreamPlayer, MixTarget>("get_mix_target")

    @JvmField
    public val setPlayingName: MethodStringName1<AudioStreamPlayer, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer, Unit, Boolean>("set_playing")

    @JvmField
    public val setStreamPausedName: MethodStringName1<AudioStreamPlayer, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer, Unit, Boolean>("set_stream_paused")

    @JvmField
    public val getStreamPausedName: MethodStringName0<AudioStreamPlayer, Boolean> =
        MethodStringName0<AudioStreamPlayer, Boolean>("get_stream_paused")

    @JvmField
    public val setMaxPolyphonyName: MethodStringName1<AudioStreamPlayer, Unit, Int> =
        MethodStringName1<AudioStreamPlayer, Unit, Int>("set_max_polyphony")

    @JvmField
    public val getMaxPolyphonyName: MethodStringName0<AudioStreamPlayer, Int> =
        MethodStringName0<AudioStreamPlayer, Int>("get_max_polyphony")

    @JvmField
    public val hasStreamPlaybackName: MethodStringName0<AudioStreamPlayer, Boolean> =
        MethodStringName0<AudioStreamPlayer, Boolean>("has_stream_playback")

    @JvmField
    public val getStreamPlaybackName: MethodStringName0<AudioStreamPlayer, AudioStreamPlayback?> =
        MethodStringName0<AudioStreamPlayer, AudioStreamPlayback?>("get_stream_playback")

    @JvmField
    public val setPlaybackTypeName:
        MethodStringName1<AudioStreamPlayer, Unit, AudioServer.PlaybackType> =
        MethodStringName1<AudioStreamPlayer, Unit, AudioServer.PlaybackType>("set_playback_type")

    @JvmField
    public val getPlaybackTypeName: MethodStringName0<AudioStreamPlayer, AudioServer.PlaybackType> =
        MethodStringName0<AudioStreamPlayer, AudioServer.PlaybackType>("get_playback_type")
  }

  public object MethodBindings {
    internal val setStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_stream", 2210767741)

    internal val getStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_stream", 160907539)

    internal val setVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_volume_db", 373806689)

    internal val getVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_volume_db", 1740695150)

    internal val setVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_volume_linear", 373806689)

    internal val getVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_volume_linear", 1740695150)

    internal val setPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_pitch_scale", 373806689)

    internal val getPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_pitch_scale", 1740695150)

    internal val playPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "play", 1958160172)

    internal val seekPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "seek", 373806689)

    internal val stopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "stop", 3218959716)

    internal val isPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "is_playing", 36873697)

    internal val getPlaybackPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_playback_position", 191475506)

    internal val setBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_bus", 3304788590)

    internal val getBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_bus", 2002593661)

    internal val setAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_autoplay", 2586408642)

    internal val isAutoplayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "is_autoplay_enabled", 36873697)

    internal val setMixTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_mix_target", 2300306138)

    internal val getMixTargetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_mix_target", 172807476)

    internal val setPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_playing", 2586408642)

    internal val setStreamPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_stream_paused", 2586408642)

    internal val getStreamPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_stream_paused", 36873697)

    internal val setMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_max_polyphony", 1286410249)

    internal val getMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_max_polyphony", 3905245786)

    internal val hasStreamPlaybackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "has_stream_playback", 2240911060)

    internal val getStreamPlaybackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_stream_playback", 210135309)

    internal val setPlaybackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "set_playback_type", 725473817)

    internal val getPlaybackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer", "get_playback_type", 4011264623)
  }
}
