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
 * Plays audio with positional sound effects, based on the relative position of the audio listener.
 * Positional effects include distance attenuation, directionality, and the Doppler effect. For greater
 * realism, a low-pass filter is applied to distant sounds. This can be disabled by setting
 * [attenuationFilterCutoffHz] to `20500`.
 *
 * By default, audio is heard from the camera position. This can be changed by adding an
 * [AudioListener3D] node to the scene and enabling it by calling [AudioListener3D.makeCurrent] on it.
 *
 * See also [AudioStreamPlayer] to play a sound non-positionally.
 *
 * **Note:** Hiding an [AudioStreamPlayer3D] node does not disable its audio output. To temporarily
 * disable an [AudioStreamPlayer3D]'s audio output, set [volumeDb] to a very low value like `-100`
 * (which isn't audible to human hearing).
 */
@GodotBaseType
public open class AudioStreamPlayer3D : Node3D() {
  /**
   * Emitted when the audio stops playing.
   */
  public val finished: Signal0 by Signal0

  /**
   * The [AudioStream] resource to be played.
   */
  public final inline var stream: AudioStream?
    @JvmName("streamProperty")
    get() = getStream()
    @JvmName("streamProperty")
    set(`value`) {
      setStream(value)
    }

  /**
   * Decides if audio should get quieter with distance linearly, quadratically, logarithmically, or
   * not be affected by distance, effectively disabling attenuation.
   */
  public final inline var attenuationModel: AttenuationModel
    @JvmName("attenuationModelProperty")
    get() = getAttenuationModel()
    @JvmName("attenuationModelProperty")
    set(`value`) {
      setAttenuationModel(value)
    }

  /**
   * The base sound level before attenuation, in decibels.
   */
  public final inline var volumeDb: Float
    @JvmName("volumeDbProperty")
    get() = getVolumeDb()
    @JvmName("volumeDbProperty")
    set(`value`) {
      setVolumeDb(value)
    }

  /**
   * The base sound level before attenuation, as a linear value.
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
   * The factor for the attenuation effect. Higher values make the sound audible over a larger
   * distance.
   */
  public final inline var unitSize: Float
    @JvmName("unitSizeProperty")
    get() = getUnitSize()
    @JvmName("unitSizeProperty")
    set(`value`) {
      setUnitSize(value)
    }

  /**
   * Sets the absolute maximum of the sound level, in decibels.
   */
  public final inline var maxDb: Float
    @JvmName("maxDbProperty")
    get() = getMaxDb()
    @JvmName("maxDbProperty")
    set(`value`) {
      setMaxDb(value)
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
   * If `true`, audio plays when the AudioStreamPlayer3D node is added to scene tree.
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
   * The distance past which the sound can no longer be heard at all. Only has an effect if set to a
   * value greater than `0.0`. [maxDistance] works in tandem with [unitSize]. However, unlike
   * [unitSize] whose behavior depends on the [attenuationModel], [maxDistance] always works in a
   * linear fashion. This can be used to prevent the [AudioStreamPlayer3D] from requiring audio mixing
   * when the listener is far away, which saves CPU resources.
   */
  public final inline var maxDistance: Float
    @JvmName("maxDistanceProperty")
    get() = getMaxDistance()
    @JvmName("maxDistanceProperty")
    set(`value`) {
      setMaxDistance(value)
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
   * [ProjectSettings.audio/general/3dPanningStrength] by this factor. If the product is `0.0` then
   * stereo panning is disabled and the volume is the same for all channels. If the product is `1.0`
   * then one of the channels will be muted when the sound is located exactly to the left (or right) of
   * the listener.
   *
   * Two speaker stereo arrangements implement the
   * [url=https://webaudio.github.io/web-audio-api/#stereopanner-algorithm]WebAudio standard for
   * StereoPannerNode Panning[/url] where the volume is cosine of half the azimuth angle to the ear.
   *
   * For other speaker arrangements such as the 5.1 and 7.1 the SPCAP (Speaker-Placement Correction
   * Amplitude) algorithm is implemented.
   */
  public final inline var panningStrength: Float
    @JvmName("panningStrengthProperty")
    get() = getPanningStrength()
    @JvmName("panningStrengthProperty")
    set(`value`) {
      setPanningStrength(value)
    }

  /**
   * The bus on which this audio is playing.
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
   * Determines which [Area3D] layers affect the sound for reverb and audio bus effects. Areas can
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

  /**
   * If `true`, the audio should be attenuated according to the direction of the sound.
   */
  public final inline var emissionAngleEnabled: Boolean
    @JvmName("emissionAngleEnabledProperty")
    get() = isEmissionAngleEnabled()
    @JvmName("emissionAngleEnabledProperty")
    set(`value`) {
      setEmissionAngleEnabled(value)
    }

  /**
   * The angle in which the audio reaches a listener unattenuated.
   */
  public final inline var emissionAngleDegrees: Float
    @JvmName("emissionAngleDegreesProperty")
    get() = getEmissionAngle()
    @JvmName("emissionAngleDegreesProperty")
    set(`value`) {
      setEmissionAngle(value)
    }

  /**
   * Attenuation factor used if listener is outside of [emissionAngleDegrees] and
   * [emissionAngleEnabled] is set, in decibels.
   */
  public final inline var emissionAngleFilterAttenuationDb: Float
    @JvmName("emissionAngleFilterAttenuationDbProperty")
    get() = getEmissionAngleFilterAttenuationDb()
    @JvmName("emissionAngleFilterAttenuationDbProperty")
    set(`value`) {
      setEmissionAngleFilterAttenuationDb(value)
    }

  /**
   * The cutoff frequency of the attenuation low-pass filter, in Hz. A sound above this frequency is
   * attenuated more than a sound below this frequency. To disable this effect, set this to `20500` as
   * this frequency is above the human hearing limit.
   */
  public final inline var attenuationFilterCutoffHz: Float
    @JvmName("attenuationFilterCutoffHzProperty")
    get() = getAttenuationFilterCutoffHz()
    @JvmName("attenuationFilterCutoffHzProperty")
    set(`value`) {
      setAttenuationFilterCutoffHz(value)
    }

  /**
   * Amount how much the filter affects the loudness, in decibels.
   */
  public final inline var attenuationFilterDb: Float
    @JvmName("attenuationFilterDbProperty")
    get() = getAttenuationFilterDb()
    @JvmName("attenuationFilterDbProperty")
    set(`value`) {
      setAttenuationFilterDb(value)
    }

  /**
   * Decides in which step the Doppler effect should be calculated.
   *
   * **Note:** If [dopplerTracking] is not [DOPPLER_TRACKING_DISABLED] but the current
   * [Camera3D]/[AudioListener3D] has doppler tracking disabled, the Doppler effect will be heard but
   * will not take the movement of the current listener into account. If accurate Doppler effect is
   * desired, doppler tracking should be enabled on both the [AudioStreamPlayer3D] and the current
   * [Camera3D]/[AudioListener3D].
   */
  public final inline var dopplerTracking: DopplerTracking
    @JvmName("dopplerTrackingProperty")
    get() = getDopplerTracking()
    @JvmName("dopplerTrackingProperty")
    set(`value`) {
      setDopplerTracking(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(97, scriptPtr)
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

  public final fun setUnitSize(unitSize: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, unitSize.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setUnitSizePtr, 0)
  }

  public final fun getUnitSize(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUnitSizePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMaxDb(maxDb: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, maxDb.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMaxDbPtr, 0)
  }

  public final fun getMaxDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxDbPtr, 3)
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
   * Queues the audio to play on the next physics frame, from the given position [fromPosition], in
   * seconds.
   */
  @JvmOverloads
  public final fun play(fromPosition: Float = 0.0f): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, fromPosition.toDouble())
    TransferContext.callPtrMethod(MethodBindings.playPtr, 0)
  }

  /**
   * Sets the position from which audio will be played, in seconds.
   */
  public final fun seek(toPosition: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, toPosition.toDouble())
    TransferContext.callPtrMethod(MethodBindings.seekPtr, 0)
  }

  /**
   * Stops the audio.
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
   * Returns the position in the [AudioStream].
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
    TransferContext.callPtrMethod(MethodBindings.getBusPtr, 21)
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

  public final fun setPlaying(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setPlayingPtr, 0)
  }

  public final fun setMaxDistance(meters: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, meters.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMaxDistancePtr, 0)
  }

  public final fun getMaxDistance(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxDistancePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAreaMask(mask: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mask)
    TransferContext.callPtrMethod(MethodBindings.setAreaMaskPtr, 0)
  }

  public final fun getAreaMask(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAreaMaskPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setEmissionAngle(degrees: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, degrees.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setEmissionAnglePtr, 0)
  }

  public final fun getEmissionAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEmissionAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setEmissionAngleEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setEmissionAngleEnabledPtr, 0)
  }

  public final fun isEmissionAngleEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isEmissionAngleEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEmissionAngleFilterAttenuationDb(db: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, db.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setEmissionAngleFilterAttenuationDbPtr, 0)
  }

  public final fun getEmissionAngleFilterAttenuationDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEmissionAngleFilterAttenuationDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAttenuationFilterCutoffHz(degrees: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, degrees.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAttenuationFilterCutoffHzPtr, 0)
  }

  public final fun getAttenuationFilterCutoffHz(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAttenuationFilterCutoffHzPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAttenuationFilterDb(db: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, db.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAttenuationFilterDbPtr, 0)
  }

  public final fun getAttenuationFilterDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAttenuationFilterDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAttenuationModel(model: AttenuationModel): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, model.value)
    TransferContext.callPtrMethod(MethodBindings.setAttenuationModelPtr, 0)
  }

  public final fun getAttenuationModel(): AttenuationModel {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAttenuationModelPtr, 2)
    return AttenuationModel.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setDopplerTracking(mode: DopplerTracking): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setDopplerTrackingPtr, 0)
  }

  public final fun getDopplerTracking(): DopplerTracking {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDopplerTrackingPtr, 2)
    return DopplerTracking.from(TransferContext.readReturnValue_LONG())
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

  public final fun setPanningStrength(panningStrength: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, panningStrength.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPanningStrengthPtr, 0)
  }

  public final fun getPanningStrength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPanningStrengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns whether the [AudioStreamPlayer] can return the [AudioStreamPlayback] object or not.
   */
  public final fun hasStreamPlayback(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasStreamPlaybackPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the [AudioStreamPlayback] object associated with this [AudioStreamPlayer3D].
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

  public enum class AttenuationModel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Attenuation of loudness according to linear distance.
     */
    INVERSE_DISTANCE(0),
    /**
     * Attenuation of loudness according to squared distance.
     */
    INVERSE_SQUARE_DISTANCE(1),
    /**
     * Attenuation of loudness according to logarithmic distance.
     */
    LOGARITHMIC(2),
    /**
     * No attenuation of loudness according to distance. The sound will still be heard positionally,
     * unlike an [AudioStreamPlayer]. [ATTENUATION_DISABLED] can be combined with a [maxDistance] value
     * greater than `0.0` to achieve linear attenuation clamped to a sphere of a defined size.
     */
    DISABLED(3),
    ;

    public companion object {
      public fun from(`value`: Long): AttenuationModel = entries.single { it.`value` == `value` }
    }
  }

  public enum class DopplerTracking(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables doppler tracking.
     */
    DISABLED(0),
    /**
     * Executes doppler tracking during process frames (see [Node.NOTIFICATION_INTERNAL_PROCESS]).
     */
    IDLE_STEP(1),
    /**
     * Executes doppler tracking during physics frames (see
     * [Node.NOTIFICATION_INTERNAL_PHYSICS_PROCESS]).
     */
    PHYSICS_STEP(2),
    ;

    public companion object {
      public fun from(`value`: Long): DopplerTracking = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setStreamName: MethodStringName1<AudioStreamPlayer3D, Unit, AudioStream?> =
        MethodStringName1<AudioStreamPlayer3D, Unit, AudioStream?>("set_stream")

    @JvmField
    public val getStreamName: MethodStringName0<AudioStreamPlayer3D, AudioStream?> =
        MethodStringName0<AudioStreamPlayer3D, AudioStream?>("get_stream")

    @JvmField
    public val setVolumeDbName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_volume_db")

    @JvmField
    public val getVolumeDbName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_volume_db")

    @JvmField
    public val setVolumeLinearName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_volume_linear")

    @JvmField
    public val getVolumeLinearName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_volume_linear")

    @JvmField
    public val setUnitSizeName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_unit_size")

    @JvmField
    public val getUnitSizeName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_unit_size")

    @JvmField
    public val setMaxDbName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_max_db")

    @JvmField
    public val getMaxDbName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_max_db")

    @JvmField
    public val setPitchScaleName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_pitch_scale")

    @JvmField
    public val getPitchScaleName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_pitch_scale")

    @JvmField
    public val playName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("play")

    @JvmField
    public val seekName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("seek")

    @JvmField
    public val stopName: MethodStringName0<AudioStreamPlayer3D, Unit> =
        MethodStringName0<AudioStreamPlayer3D, Unit>("stop")

    @JvmField
    public val isPlayingName: MethodStringName0<AudioStreamPlayer3D, Boolean> =
        MethodStringName0<AudioStreamPlayer3D, Boolean>("is_playing")

    @JvmField
    public val getPlaybackPositionName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_playback_position")

    @JvmField
    public val setBusName: MethodStringName1<AudioStreamPlayer3D, Unit, StringName> =
        MethodStringName1<AudioStreamPlayer3D, Unit, StringName>("set_bus")

    @JvmField
    public val getBusName: MethodStringName0<AudioStreamPlayer3D, StringName> =
        MethodStringName0<AudioStreamPlayer3D, StringName>("get_bus")

    @JvmField
    public val setAutoplayName: MethodStringName1<AudioStreamPlayer3D, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Boolean>("set_autoplay")

    @JvmField
    public val isAutoplayEnabledName: MethodStringName0<AudioStreamPlayer3D, Boolean> =
        MethodStringName0<AudioStreamPlayer3D, Boolean>("is_autoplay_enabled")

    @JvmField
    public val setPlayingName: MethodStringName1<AudioStreamPlayer3D, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Boolean>("set_playing")

    @JvmField
    public val setMaxDistanceName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_max_distance")

    @JvmField
    public val getMaxDistanceName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_max_distance")

    @JvmField
    public val setAreaMaskName: MethodStringName1<AudioStreamPlayer3D, Unit, Long> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Long>("set_area_mask")

    @JvmField
    public val getAreaMaskName: MethodStringName0<AudioStreamPlayer3D, Long> =
        MethodStringName0<AudioStreamPlayer3D, Long>("get_area_mask")

    @JvmField
    public val setEmissionAngleName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_emission_angle")

    @JvmField
    public val getEmissionAngleName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_emission_angle")

    @JvmField
    public val setEmissionAngleEnabledName: MethodStringName1<AudioStreamPlayer3D, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Boolean>("set_emission_angle_enabled")

    @JvmField
    public val isEmissionAngleEnabledName: MethodStringName0<AudioStreamPlayer3D, Boolean> =
        MethodStringName0<AudioStreamPlayer3D, Boolean>("is_emission_angle_enabled")

    @JvmField
    public val setEmissionAngleFilterAttenuationDbName:
        MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_emission_angle_filter_attenuation_db")

    @JvmField
    public val getEmissionAngleFilterAttenuationDbName:
        MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_emission_angle_filter_attenuation_db")

    @JvmField
    public val setAttenuationFilterCutoffHzName: MethodStringName1<AudioStreamPlayer3D, Unit, Float>
        = MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_attenuation_filter_cutoff_hz")

    @JvmField
    public val getAttenuationFilterCutoffHzName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_attenuation_filter_cutoff_hz")

    @JvmField
    public val setAttenuationFilterDbName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_attenuation_filter_db")

    @JvmField
    public val getAttenuationFilterDbName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_attenuation_filter_db")

    @JvmField
    public val setAttenuationModelName:
        MethodStringName1<AudioStreamPlayer3D, Unit, AttenuationModel> =
        MethodStringName1<AudioStreamPlayer3D, Unit, AttenuationModel>("set_attenuation_model")

    @JvmField
    public val getAttenuationModelName: MethodStringName0<AudioStreamPlayer3D, AttenuationModel> =
        MethodStringName0<AudioStreamPlayer3D, AttenuationModel>("get_attenuation_model")

    @JvmField
    public val setDopplerTrackingName: MethodStringName1<AudioStreamPlayer3D, Unit, DopplerTracking>
        = MethodStringName1<AudioStreamPlayer3D, Unit, DopplerTracking>("set_doppler_tracking")

    @JvmField
    public val getDopplerTrackingName: MethodStringName0<AudioStreamPlayer3D, DopplerTracking> =
        MethodStringName0<AudioStreamPlayer3D, DopplerTracking>("get_doppler_tracking")

    @JvmField
    public val setStreamPausedName: MethodStringName1<AudioStreamPlayer3D, Unit, Boolean> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Boolean>("set_stream_paused")

    @JvmField
    public val getStreamPausedName: MethodStringName0<AudioStreamPlayer3D, Boolean> =
        MethodStringName0<AudioStreamPlayer3D, Boolean>("get_stream_paused")

    @JvmField
    public val setMaxPolyphonyName: MethodStringName1<AudioStreamPlayer3D, Unit, Int> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Int>("set_max_polyphony")

    @JvmField
    public val getMaxPolyphonyName: MethodStringName0<AudioStreamPlayer3D, Int> =
        MethodStringName0<AudioStreamPlayer3D, Int>("get_max_polyphony")

    @JvmField
    public val setPanningStrengthName: MethodStringName1<AudioStreamPlayer3D, Unit, Float> =
        MethodStringName1<AudioStreamPlayer3D, Unit, Float>("set_panning_strength")

    @JvmField
    public val getPanningStrengthName: MethodStringName0<AudioStreamPlayer3D, Float> =
        MethodStringName0<AudioStreamPlayer3D, Float>("get_panning_strength")

    @JvmField
    public val hasStreamPlaybackName: MethodStringName0<AudioStreamPlayer3D, Boolean> =
        MethodStringName0<AudioStreamPlayer3D, Boolean>("has_stream_playback")

    @JvmField
    public val getStreamPlaybackName: MethodStringName0<AudioStreamPlayer3D, AudioStreamPlayback?> =
        MethodStringName0<AudioStreamPlayer3D, AudioStreamPlayback?>("get_stream_playback")

    @JvmField
    public val setPlaybackTypeName:
        MethodStringName1<AudioStreamPlayer3D, Unit, AudioServer.PlaybackType> =
        MethodStringName1<AudioStreamPlayer3D, Unit, AudioServer.PlaybackType>("set_playback_type")

    @JvmField
    public val getPlaybackTypeName: MethodStringName0<AudioStreamPlayer3D, AudioServer.PlaybackType>
        = MethodStringName0<AudioStreamPlayer3D, AudioServer.PlaybackType>("get_playback_type")
  }

  public object MethodBindings {
    internal val setStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_stream", 2210767741)

    internal val getStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_stream", 160907539)

    internal val setVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_volume_db", 373806689)

    internal val getVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_volume_db", 1740695150)

    internal val setVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_volume_linear", 373806689)

    internal val getVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_volume_linear", 1740695150)

    internal val setUnitSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_unit_size", 373806689)

    internal val getUnitSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_unit_size", 1740695150)

    internal val setMaxDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_max_db", 373806689)

    internal val getMaxDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_max_db", 1740695150)

    internal val setPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_pitch_scale", 373806689)

    internal val getPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_pitch_scale", 1740695150)

    internal val playPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "play", 1958160172)

    internal val seekPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "seek", 373806689)

    internal val stopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "stop", 3218959716)

    internal val isPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "is_playing", 36873697)

    internal val getPlaybackPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_playback_position", 191475506)

    internal val setBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_bus", 3304788590)

    internal val getBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_bus", 2002593661)

    internal val setAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_autoplay", 2586408642)

    internal val isAutoplayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "is_autoplay_enabled", 36873697)

    internal val setPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_playing", 2586408642)

    internal val setMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_max_distance", 373806689)

    internal val getMaxDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_max_distance", 1740695150)

    internal val setAreaMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_area_mask", 1286410249)

    internal val getAreaMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_area_mask", 3905245786)

    internal val setEmissionAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_emission_angle", 373806689)

    internal val getEmissionAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_emission_angle", 1740695150)

    internal val setEmissionAngleEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_emission_angle_enabled", 2586408642)

    internal val isEmissionAngleEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "is_emission_angle_enabled", 36873697)

    internal val setEmissionAngleFilterAttenuationDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_emission_angle_filter_attenuation_db", 373806689)

    internal val getEmissionAngleFilterAttenuationDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_emission_angle_filter_attenuation_db", 1740695150)

    internal val setAttenuationFilterCutoffHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_attenuation_filter_cutoff_hz", 373806689)

    internal val getAttenuationFilterCutoffHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_attenuation_filter_cutoff_hz", 1740695150)

    internal val setAttenuationFilterDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_attenuation_filter_db", 373806689)

    internal val getAttenuationFilterDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_attenuation_filter_db", 1740695150)

    internal val setAttenuationModelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_attenuation_model", 2988086229)

    internal val getAttenuationModelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_attenuation_model", 3035106060)

    internal val setDopplerTrackingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_doppler_tracking", 3968161450)

    internal val getDopplerTrackingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_doppler_tracking", 1702418664)

    internal val setStreamPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_stream_paused", 2586408642)

    internal val getStreamPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_stream_paused", 36873697)

    internal val setMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_max_polyphony", 1286410249)

    internal val getMaxPolyphonyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_max_polyphony", 3905245786)

    internal val setPanningStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_panning_strength", 373806689)

    internal val getPanningStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_panning_strength", 1740695150)

    internal val hasStreamPlaybackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "has_stream_playback", 2240911060)

    internal val getStreamPlaybackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_stream_playback", 210135309)

    internal val setPlaybackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "set_playback_type", 725473817)

    internal val getPlaybackTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamPlayer3D", "get_playback_type", 4011264623)
  }
}
