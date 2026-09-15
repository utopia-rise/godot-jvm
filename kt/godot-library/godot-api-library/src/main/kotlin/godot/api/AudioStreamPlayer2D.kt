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
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.core.StringName
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Double
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
 * Plays audio that is attenuated with distance to the listener.
 *
 * By default, audio is heard from the screen center. This can be changed by adding an
 * [AudioListener2D] node to the scene and enabling it by calling [AudioListener2D.makeCurrent] on it.
 *
 * See also [AudioStreamPlayer] to play a sound non-positionally.
 *
 * **Note:** Hiding an [AudioStreamPlayer2D] node does not disable its audio output. To temporarily
 * disable an [AudioStreamPlayer2D]'s audio output, set [volumeDb] to a very low value like `-100`
 * (which isn't audible to human hearing).
 */
@GodotBaseType
public open class AudioStreamPlayer2D : Node2D() {
  /**
   * Emitted when the audio stops playing.
   */
  public val finished: Signal0 by Signal0

  /**
   * The [AudioStream] object to be played.
   */
  public final inline var stream: AudioStream?
    @JvmName("streamProperty")
    get() = getStream()
    @JvmName("streamProperty")
    set(`value`) {
      setStream(value)
    }

  /**
   * Base volume before attenuation, in decibels.
   */
  public final inline var volumeDb: Float
    @JvmName("volumeDbProperty")
    get() = getVolumeDb()
    @JvmName("volumeDbProperty")
    set(`value`) {
      setVolumeDb(value)
    }

  /**
   * Base volume before attenuation, as a linear value.
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
   * The pitch and the tempo of the audio, as a multiplier of the audio sample's sample rate.
   */
  public final inline var pitchScale: Float
    @JvmName("pitchScaleProperty")
    get() = getPitchScale()
    @JvmName("pitchScaleProperty")
    set(`value`) {
      setPitchScale(value)
    }

  /**
   * If `true`, audio is playing or is queued to be played (see [play]).
   */
  public final inline var playing: Boolean
    @JvmName("playingProperty")
    get() = isPlaying()
    @JvmName("playingProperty")
    set(`value`) {
      setPlaying(value)
    }

  /**
   * If `true`, audio plays when added to scene tree.
   */
  public final inline var autoplay: Boolean
    @JvmName("autoplayProperty")
    get() = isAutoplayEnabled()
    @JvmName("autoplayProperty")
    set(`value`) {
      setAutoplay(value)
    }

  /**
   * If `true`, the playback is paused. You can resume it by setting [streamPaused] to `false`.
   */
  public final inline var streamPaused: Boolean
    @JvmName("streamPausedProperty")
    get() = getStreamPaused()
    @JvmName("streamPausedProperty")
    set(`value`) {
      setStreamPaused(value)
    }

  /**
   * Maximum distance from which audio is still hearable.
   */
  public final inline var maxDistance: Float
    @JvmName("maxDistanceProperty")
    get() = getMaxDistance()
    @JvmName("maxDistanceProperty")
    set(`value`) {
      setMaxDistance(value)
    }

  /**
   * The volume is attenuated over distance with this as an exponent.
   */
  public final inline var attenuation: Float
    @JvmName("attenuationProperty")
    get() = getAttenuation()
    @JvmName("attenuationProperty")
    set(`value`) {
      setAttenuation(value)
    }

  /**
   * The maximum number of sounds this node can play at the same time. Playing additional sounds
   * after this value is reached will cut off the oldest sounds.
   */
  public final inline var maxPolyphony: Int
    @JvmName("maxPolyphonyProperty")
    get() = getMaxPolyphony()
    @JvmName("maxPolyphonyProperty")
    set(`value`) {
      setMaxPolyphony(value)
    }

  /**
   * Scales the panning strength for this node by multiplying the base
   * [ProjectSettings.audio/general/2dPanningStrength] with this factor. Higher values will pan audio
   * from left to right more dramatically than lower values.
   */
  public final inline var panningStrength: Float
    @JvmName("panningStrengthProperty")
    get() = getPanningStrength()
    @JvmName("panningStrengthProperty")
    set(`value`) {
      setPanningStrength(value)
    }

  /**
   * Bus on which this audio is playing.
   *
   * **Note:** When setting this property, keep in mind that no validation is performed to see if
   * the given name matches an existing bus. This is because audio bus layouts might be loaded after
   * this property is set. If this given name can't be resolved at runtime, it will fall back to
   * `"Master"`.
   */
  public final inline var bus: StringName
    @JvmName("busProperty")
    get() = getBus()
    @JvmName("busProperty")
    set(`value`) {
      setBus(value)
    }

  /**
   * Determines which [Area2D] layers affect the sound for reverb and audio bus effects. Areas can
   * be used to redirect [AudioStream]s so that they play in a certain audio bus. An example of how you
   * might use this is making a "water" area so that sounds played in the water are redirected through
   * an audio bus to make them sound like they are being played underwater.
   */
  public final inline var areaMask: Long
    @JvmName("areaMaskProperty")
    get() = getAreaMask()
    @JvmName("areaMaskProperty")
    set(`value`) {
      setAreaMask(value)
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
    createNativeObject(96, scriptPtr)
  }

  public final fun setStream(stream: AudioStream?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to stream)
    TransferContext.callMethod(MethodBindings.setStreamPtr)
  }

  public final fun getStream(): AudioStream? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamPtr)
    return (TransferContext.readReturnValue(OBJECT) as AudioStream?)
  }

  public final fun setVolumeDb(volumeDb: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to volumeDb.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumeDbPtr)
  }

  public final fun getVolumeDb(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumeDbPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setVolumeLinear(volumeLinear: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to volumeLinear.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumeLinearPtr)
  }

  public final fun getVolumeLinear(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumeLinearPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setPitchScale(pitchScale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pitchScale.toDouble())
    TransferContext.callMethod(MethodBindings.setPitchScalePtr)
  }

  public final fun getPitchScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPitchScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Queues the audio to play on the next physics frame, from the given position [fromPosition], in
   * seconds.
   */
  @JvmOverloads
  public final fun play(fromPosition: Float = 0.0f): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to fromPosition.toDouble())
    TransferContext.callMethod(MethodBindings.playPtr)
  }

  /**
   * Sets the position from which audio will be played, in seconds.
   */
  public final fun seek(toPosition: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to toPosition.toDouble())
    TransferContext.callMethod(MethodBindings.seekPtr)
  }

  /**
   * Stops the audio.
   */
  public final fun stop(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.stopPtr)
  }

  public final fun isPlaying(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPlayingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the position in the [AudioStream].
   */
  public final fun getPlaybackPosition(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaybackPositionPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setBus(bus: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to bus)
    TransferContext.callMethod(MethodBindings.setBusPtr)
  }

  public final fun getBus(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBusPtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setAutoplay(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoplayPtr)
  }

  public final fun isAutoplayEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoplayEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPlaying(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setPlayingPtr)
  }

  public final fun setMaxDistance(pixels: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to pixels.toDouble())
    TransferContext.callMethod(MethodBindings.setMaxDistancePtr)
  }

  public final fun getMaxDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAttenuation(curve: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to curve.toDouble())
    TransferContext.callMethod(MethodBindings.setAttenuationPtr)
  }

  public final fun getAttenuation(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAttenuationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAreaMask(mask: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask)
    TransferContext.callMethod(MethodBindings.setAreaMaskPtr)
  }

  public final fun getAreaMask(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAreaMaskPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setStreamPaused(pause: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pause)
    TransferContext.callMethod(MethodBindings.setStreamPausedPtr)
  }

  public final fun getStreamPaused(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamPausedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMaxPolyphony(maxPolyphony: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxPolyphony.toLong())
    TransferContext.callMethod(MethodBindings.setMaxPolyphonyPtr)
  }

  public final fun getMaxPolyphony(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxPolyphonyPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setPanningStrength(panningStrength: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to panningStrength.toDouble())
    TransferContext.callMethod(MethodBindings.setPanningStrengthPtr)
  }

  public final fun getPanningStrength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPanningStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns whether the [AudioStreamPlayer] can return the [AudioStreamPlayback] object or not.
   */
  public final fun hasStreamPlayback(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasStreamPlaybackPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [AudioStreamPlayback] object associated with this [AudioStreamPlayer2D].
   */
  public final fun getStreamPlayback(): AudioStreamPlayback? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamPlaybackPtr)
    return (TransferContext.readReturnValue(OBJECT) as AudioStreamPlayback?)
  }

  public final fun setPlaybackType(playbackType: AudioServer.PlaybackType): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to playbackType.value)
    TransferContext.callMethod(MethodBindings.setPlaybackTypePtr)
  }

  public final fun getPlaybackType(): AudioServer.PlaybackType {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaybackTypePtr)
    return AudioServer.PlaybackType.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setBus(bus: String) = setBus(bus.asCachedStringName())

  public companion object {
    @JvmField
    public val setStreamName: MethodStringName1<AudioStreamPlayer2D, Unit, AudioStream?> =
        MethodStringName1<AudioStreamPlayer2D, Unit, AudioStream?>("set_stream")

    @JvmField
    public val getStreamName: MethodStringName0<AudioStreamPlayer2D, AudioStream?> =
        MethodStringName0<AudioStreamPlayer2D, AudioStream?>("get_stream")

    @JvmField
    public val setVolumeDbName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("set_volume_db")

    @JvmField
    public val getVolumeDbName: MethodStringName0<AudioStreamPlayer2D, Float> =
        MethodStringName0<AudioStreamPlayer2D, Float>("get_volume_db")

    @JvmField
    public val setVolumeLinearName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("set_volume_linear")

    @JvmField
    public val getVolumeLinearName: MethodStringName0<AudioStreamPlayer2D, Float> =
        MethodStringName0<AudioStreamPlayer2D, Float>("get_volume_linear")

    @JvmField
    public val setPitchScaleName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("set_pitch_scale")

    @JvmField
    public val getPitchScaleName: MethodStringName0<AudioStreamPlayer2D, Float> =
        MethodStringName0<AudioStreamPlayer2D, Float>("get_pitch_scale")

    @JvmField
    public val playName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("play")

    @JvmField
    public val seekName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("seek")

    @JvmField
    public val stopName: MethodStringName0<AudioStreamPlayer2D, Unit> =
        MethodStringName0<AudioStreamPlayer2D, Unit>("stop")

    @JvmField
    public val isPlayingName: MethodStringName0<AudioStreamPlayer2D, Boolean> =
        MethodStringName0<AudioStreamPlayer2D, Boolean>("is_playing")

    @JvmField
    public val getPlaybackPositionName: MethodStringName0<AudioStreamPlayer2D, Float> =
        MethodStringName0<AudioStreamPlayer2D, Float>("get_playback_position")

    @JvmField
    public val setBusName: MethodStringName1<AudioStreamPlayer2D, Unit, StringName> =
        MethodStringName1<AudioStreamPlayer2D, Unit, StringName>("set_bus")

    @JvmField
    public val getBusName: MethodStringName0<AudioStreamPlayer2D, StringName> =
        MethodStringName0<AudioStreamPlayer2D, StringName>("get_bus")

    @JvmField
    public val setAutoplayName: MethodStringName1<AudioStreamPlayer2D, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Boolean>("set_autoplay")

    @JvmField
    public val isAutoplayEnabledName: MethodStringName0<AudioStreamPlayer2D, Boolean> =
        MethodStringName0<AudioStreamPlayer2D, Boolean>("is_autoplay_enabled")

    @JvmField
    public val setPlayingName: MethodStringName1<AudioStreamPlayer2D, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Boolean>("set_playing")

    @JvmField
    public val setMaxDistanceName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("set_max_distance")

    @JvmField
    public val getMaxDistanceName: MethodStringName0<AudioStreamPlayer2D, Float> =
        MethodStringName0<AudioStreamPlayer2D, Float>("get_max_distance")

    @JvmField
    public val setAttenuationName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("set_attenuation")

    @JvmField
    public val getAttenuationName: MethodStringName0<AudioStreamPlayer2D, Float> =
        MethodStringName0<AudioStreamPlayer2D, Float>("get_attenuation")

    @JvmField
    public val setAreaMaskName: MethodStringName1<AudioStreamPlayer2D, Unit, Long> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Long>("set_area_mask")

    @JvmField
    public val getAreaMaskName: MethodStringName0<AudioStreamPlayer2D, Long> =
        MethodStringName0<AudioStreamPlayer2D, Long>("get_area_mask")

    @JvmField
    public val setStreamPausedName: MethodStringName1<AudioStreamPlayer2D, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Boolean>("set_stream_paused")

    @JvmField
    public val getStreamPausedName: MethodStringName0<AudioStreamPlayer2D, Boolean> =
        MethodStringName0<AudioStreamPlayer2D, Boolean>("get_stream_paused")

    @JvmField
    public val setMaxPolyphonyName: MethodStringName1<AudioStreamPlayer2D, Unit, Int> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Int>("set_max_polyphony")

    @JvmField
    public val getMaxPolyphonyName: MethodStringName0<AudioStreamPlayer2D, Int> =
        MethodStringName0<AudioStreamPlayer2D, Int>("get_max_polyphony")

    @JvmField
    public val setPanningStrengthName: MethodStringName1<AudioStreamPlayer2D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer2D, Unit, Float>("set_panning_strength")

    @JvmField
    public val getPanningStrengthName: MethodStringName0<AudioStreamPlayer2D, Float> =
        MethodStringName0<AudioStreamPlayer2D, Float>("get_panning_strength")

    @JvmField
    public val hasStreamPlaybackName: MethodStringName0<AudioStreamPlayer2D, Boolean> =
        MethodStringName0<AudioStreamPlayer2D, Boolean>("has_stream_playback")

    @JvmField
    public val getStreamPlaybackName: MethodStringName0<AudioStreamPlayer2D, AudioStreamPlayback?> =
        MethodStringName0<AudioStreamPlayer2D, AudioStreamPlayback?>("get_stream_playback")

    @JvmField
    public val setPlaybackTypeName:
        MethodStringName1<AudioStreamPlayer2D, Unit, AudioServer.PlaybackType> =
        MethodStringName1<AudioStreamPlayer2D, Unit, AudioServer.PlaybackType>("set_playback_type")

    @JvmField
    public val getPlaybackTypeName: MethodStringName0<AudioStreamPlayer2D, AudioServer.PlaybackType>
        = MethodStringName0<AudioStreamPlayer2D, AudioServer.PlaybackType>("get_playback_type")
  }

  public object MethodBindings {
    internal val setStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_stream", 2210767741)

    internal val getStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_stream", 160907539)

    internal val setVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_volume_db", 373806689)

    internal val getVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_volume_db", 1740695150)

    internal val setVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_volume_linear", 373806689)

    internal val getVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_volume_linear", 1740695150)

    internal val setPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_pitch_scale", 373806689)

    internal val getPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_pitch_scale", 1740695150)

    internal val playPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "play", 1958160172)

    internal val seekPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "seek", 373806689)

    internal val stopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "stop", 3218959716)

    internal val isPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "is_playing", 36873697)

    internal val getPlaybackPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_playback_position", 191475506)

    internal val setBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_bus", 3304788590)

    internal val getBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_bus", 2002593661)

    internal val setAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_autoplay", 2586408642)

    internal val isAutoplayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "is_autoplay_enabled", 36873697)

    internal val setPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_playing", 2586408642)

    internal val setMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_max_distance", 373806689)

    internal val getMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_max_distance", 1740695150)

    internal val setAttenuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_attenuation", 373806689)

    internal val getAttenuationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_attenuation", 1740695150)

    internal val setAreaMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_area_mask", 1286410249)

    internal val getAreaMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_area_mask", 3905245786)

    internal val setStreamPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_stream_paused", 2586408642)

    internal val getStreamPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_stream_paused", 36873697)

    internal val setMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_max_polyphony", 1286410249)

    internal val getMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_max_polyphony", 3905245786)

    internal val setPanningStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_panning_strength", 373806689)

    internal val getPanningStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_panning_strength", 1740695150)

    internal val hasStreamPlaybackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "has_stream_playback", 2240911060)

    internal val getStreamPlaybackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_stream_playback", 210135309)

    internal val setPlaybackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "set_playback_type", 725473817)

    internal val getPlaybackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer2D", "get_playback_type", 4011264623)
  }
}
