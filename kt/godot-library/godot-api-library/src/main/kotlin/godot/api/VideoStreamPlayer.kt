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
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING_NAME
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A control used for playback of [VideoStream] resources.
 *
 * Supported video formats are [url=https://www.theora.org/]Ogg Theora[/url] (`.ogv`,
 * [VideoStreamTheora]) and any format exposed via a GDExtension plugin.
 *
 * **Warning:** On Web, video playback *will* perform poorly due to missing architecture-specific
 * assembly optimizations.
 */
@GodotBaseType
public open class VideoStreamPlayer : Control() {
  /**
   * Emitted when playback is finished.
   */
  public val finished: Signal0 by Signal0

  /**
   * The embedded audio track to play.
   */
  public final inline var audioTrack: Int
    @JvmName("audioTrackProperty")
    get() = getAudioTrack()
    @JvmName("audioTrackProperty")
    set(`value`) {
      setAudioTrack(value)
    }

  /**
   * The assigned video stream. See description for supported formats.
   */
  public final inline var stream: VideoStream?
    @JvmName("streamProperty")
    get() = getStream()
    @JvmName("streamProperty")
    set(`value`) {
      setStream(value)
    }

  /**
   * Audio volume in dB.
   */
  public final inline var volumeDb: Float
    @JvmName("volumeDbProperty")
    get() = getVolumeDb()
    @JvmName("volumeDbProperty")
    set(`value`) {
      setVolumeDb(value)
    }

  /**
   * Audio volume as a linear value.
   */
  public final inline var volume: Float
    @JvmName("volumeProperty")
    get() = getVolume()
    @JvmName("volumeProperty")
    set(`value`) {
      setVolume(value)
    }

  /**
   * The stream's current speed scale. `1.0` is the normal speed, while `2.0` is double speed and
   * `0.5` is half speed. A speed scale of `0.0` pauses the video, similar to setting [paused] to
   * `true`.
   */
  public final inline var speedScale: Float
    @JvmName("speedScaleProperty")
    get() = getSpeedScale()
    @JvmName("speedScaleProperty")
    set(`value`) {
      setSpeedScale(value)
    }

  /**
   * If `true`, playback starts when the scene loads.
   */
  public final inline var autoplay: Boolean
    @JvmName("autoplayProperty")
    get() = hasAutoplay()
    @JvmName("autoplayProperty")
    set(`value`) {
      setAutoplay(value)
    }

  /**
   * If `true`, the video is paused.
   */
  public final inline var paused: Boolean
    @JvmName("pausedProperty")
    get() = isPaused()
    @JvmName("pausedProperty")
    set(`value`) {
      setPaused(value)
    }

  /**
   * If `true`, the video scales to the control size. Otherwise, the control minimum size will be
   * automatically adjusted to match the video stream's dimensions.
   */
  public final inline var expand: Boolean
    @JvmName("expandProperty")
    get() = hasExpand()
    @JvmName("expandProperty")
    set(`value`) {
      setExpand(value)
    }

  /**
   * If `true`, the video restarts when it reaches its end.
   */
  public final inline var loop: Boolean
    @JvmName("loopProperty")
    get() = hasLoop()
    @JvmName("loopProperty")
    set(`value`) {
      setLoop(value)
    }

  /**
   * Amount of time in milliseconds to store in buffer while playing.
   */
  public final inline var bufferingMsec: Int
    @JvmName("bufferingMsecProperty")
    get() = getBufferingMsec()
    @JvmName("bufferingMsecProperty")
    set(`value`) {
      setBufferingMsec(value)
    }

  /**
   * The current position of the stream, in seconds.
   */
  public final inline var streamPosition: Double
    @JvmName("streamPositionProperty")
    get() = getStreamPosition()
    @JvmName("streamPositionProperty")
    set(`value`) {
      setStreamPosition(value)
    }

  /**
   * Audio bus to use for sound playback.
   */
  public final inline var bus: StringName
    @JvmName("busProperty")
    get() = getBus()
    @JvmName("busProperty")
    set(`value`) {
      setBus(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(794, scriptPtr)
  }

  public final fun setStream(stream: VideoStream?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, stream)
    TransferContext.callMethod(MethodBindings.setStreamPtr)
  }

  public final fun getStream(): VideoStream? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamPtr)
    return (TransferContext.readReturnValue_OBJECT() as VideoStream?)
  }

  /**
   * Starts the video playback from the beginning. If the video is paused, this will not unpause the
   * video.
   */
  public final fun play(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.playPtr)
  }

  /**
   * Stops the video playback and sets the stream position to 0.
   *
   * **Note:** Although the stream position will be set to 0, the first frame of the video stream
   * won't become the current frame.
   */
  public final fun stop(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.stopPtr)
  }

  /**
   * Returns `true` if the video is playing.
   *
   * **Note:** The video is still considered playing if paused during playback.
   */
  public final fun isPlaying(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPlayingPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPaused(paused: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, paused)
    TransferContext.callMethod(MethodBindings.setPausedPtr)
  }

  public final fun isPaused(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPausedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setLoop(loop: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, loop)
    TransferContext.callMethod(MethodBindings.setLoopPtr)
  }

  public final fun hasLoop(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasLoopPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setVolume(volume: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, volume.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumePtr)
  }

  public final fun getVolume(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setVolumeDb(db: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, db.toDouble())
    TransferContext.callMethod(MethodBindings.setVolumeDbPtr)
  }

  public final fun getVolumeDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVolumeDbPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSpeedScale(speedScale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, speedScale.toDouble())
    TransferContext.callMethod(MethodBindings.setSpeedScalePtr)
  }

  public final fun getSpeedScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSpeedScalePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAudioTrack(track: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, track.toLong())
    TransferContext.callMethod(MethodBindings.setAudioTrackPtr)
  }

  public final fun getAudioTrack(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAudioTrackPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the video stream's name, or `"<No Stream>"` if no video stream is assigned.
   */
  public final fun getStreamName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * The length of the current stream, in seconds.
   */
  public final fun getStreamLength(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamLengthPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setStreamPosition(position: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, position)
    TransferContext.callMethod(MethodBindings.setStreamPositionPtr)
  }

  public final fun getStreamPosition(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamPositionPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setAutoplay(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setAutoplayPtr)
  }

  public final fun hasAutoplay(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasAutoplayPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setExpand(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setExpandPtr)
  }

  public final fun hasExpand(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasExpandPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setBufferingMsec(msec: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, msec.toLong())
    TransferContext.callMethod(MethodBindings.setBufferingMsecPtr)
  }

  public final fun getBufferingMsec(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBufferingMsecPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setBus(bus: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, bus)
    TransferContext.callMethod(MethodBindings.setBusPtr)
  }

  public final fun getBus(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBusPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the current frame as a [Texture2D].
   */
  public final fun getVideoTexture(): Texture2D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVideoTexturePtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  public final fun setBus(bus: String) = setBus(bus.asCachedStringName())

  public companion object {
    @JvmField
    public val setStreamName: MethodStringName1<VideoStreamPlayer, Unit, VideoStream?> =
        MethodStringName1<VideoStreamPlayer, Unit, VideoStream?>("set_stream")

    @JvmField
    public val getStreamName: MethodStringName0<VideoStreamPlayer, VideoStream?> =
        MethodStringName0<VideoStreamPlayer, VideoStream?>("get_stream")

    @JvmField
    public val playName: MethodStringName0<VideoStreamPlayer, Unit> =
        MethodStringName0<VideoStreamPlayer, Unit>("play")

    @JvmField
    public val stopName: MethodStringName0<VideoStreamPlayer, Unit> =
        MethodStringName0<VideoStreamPlayer, Unit>("stop")

    @JvmField
    public val isPlayingName: MethodStringName0<VideoStreamPlayer, Boolean> =
        MethodStringName0<VideoStreamPlayer, Boolean>("is_playing")

    @JvmField
    public val setPausedName: MethodStringName1<VideoStreamPlayer, Unit, Boolean> =
        MethodStringName1<VideoStreamPlayer, Unit, Boolean>("set_paused")

    @JvmField
    public val isPausedName: MethodStringName0<VideoStreamPlayer, Boolean> =
        MethodStringName0<VideoStreamPlayer, Boolean>("is_paused")

    @JvmField
    public val setLoopName: MethodStringName1<VideoStreamPlayer, Unit, Boolean> =
        MethodStringName1<VideoStreamPlayer, Unit, Boolean>("set_loop")

    @JvmField
    public val hasLoopName: MethodStringName0<VideoStreamPlayer, Boolean> =
        MethodStringName0<VideoStreamPlayer, Boolean>("has_loop")

    @JvmField
    public val setVolumeName: MethodStringName1<VideoStreamPlayer, Unit, Float> =
        MethodStringName1<VideoStreamPlayer, Unit, Float>("set_volume")

    @JvmField
    public val getVolumeName: MethodStringName0<VideoStreamPlayer, Float> =
        MethodStringName0<VideoStreamPlayer, Float>("get_volume")

    @JvmField
    public val setVolumeDbName: MethodStringName1<VideoStreamPlayer, Unit, Float> =
        MethodStringName1<VideoStreamPlayer, Unit, Float>("set_volume_db")

    @JvmField
    public val getVolumeDbName: MethodStringName0<VideoStreamPlayer, Float> =
        MethodStringName0<VideoStreamPlayer, Float>("get_volume_db")

    @JvmField
    public val setSpeedScaleName: MethodStringName1<VideoStreamPlayer, Unit, Float> =
        MethodStringName1<VideoStreamPlayer, Unit, Float>("set_speed_scale")

    @JvmField
    public val getSpeedScaleName: MethodStringName0<VideoStreamPlayer, Float> =
        MethodStringName0<VideoStreamPlayer, Float>("get_speed_scale")

    @JvmField
    public val setAudioTrackName: MethodStringName1<VideoStreamPlayer, Unit, Int> =
        MethodStringName1<VideoStreamPlayer, Unit, Int>("set_audio_track")

    @JvmField
    public val getAudioTrackName: MethodStringName0<VideoStreamPlayer, Int> =
        MethodStringName0<VideoStreamPlayer, Int>("get_audio_track")

    @JvmField
    public val getStreamNameName: MethodStringName0<VideoStreamPlayer, String> =
        MethodStringName0<VideoStreamPlayer, String>("get_stream_name")

    @JvmField
    public val getStreamLengthName: MethodStringName0<VideoStreamPlayer, Double> =
        MethodStringName0<VideoStreamPlayer, Double>("get_stream_length")

    @JvmField
    public val setStreamPositionName: MethodStringName1<VideoStreamPlayer, Unit, Double> =
        MethodStringName1<VideoStreamPlayer, Unit, Double>("set_stream_position")

    @JvmField
    public val getStreamPositionName: MethodStringName0<VideoStreamPlayer, Double> =
        MethodStringName0<VideoStreamPlayer, Double>("get_stream_position")

    @JvmField
    public val setAutoplayName: MethodStringName1<VideoStreamPlayer, Unit, Boolean> =
        MethodStringName1<VideoStreamPlayer, Unit, Boolean>("set_autoplay")

    @JvmField
    public val hasAutoplayName: MethodStringName0<VideoStreamPlayer, Boolean> =
        MethodStringName0<VideoStreamPlayer, Boolean>("has_autoplay")

    @JvmField
    public val setExpandName: MethodStringName1<VideoStreamPlayer, Unit, Boolean> =
        MethodStringName1<VideoStreamPlayer, Unit, Boolean>("set_expand")

    @JvmField
    public val hasExpandName: MethodStringName0<VideoStreamPlayer, Boolean> =
        MethodStringName0<VideoStreamPlayer, Boolean>("has_expand")

    @JvmField
    public val setBufferingMsecName: MethodStringName1<VideoStreamPlayer, Unit, Int> =
        MethodStringName1<VideoStreamPlayer, Unit, Int>("set_buffering_msec")

    @JvmField
    public val getBufferingMsecName: MethodStringName0<VideoStreamPlayer, Int> =
        MethodStringName0<VideoStreamPlayer, Int>("get_buffering_msec")

    @JvmField
    public val setBusName: MethodStringName1<VideoStreamPlayer, Unit, StringName> =
        MethodStringName1<VideoStreamPlayer, Unit, StringName>("set_bus")

    @JvmField
    public val getBusName: MethodStringName0<VideoStreamPlayer, StringName> =
        MethodStringName0<VideoStreamPlayer, StringName>("get_bus")

    @JvmField
    public val getVideoTextureName: MethodStringName0<VideoStreamPlayer, Texture2D?> =
        MethodStringName0<VideoStreamPlayer, Texture2D?>("get_video_texture")
  }

  public object MethodBindings {
    internal val setStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_stream", 2317102564)

    internal val getStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_stream", 438621487)

    internal val playPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "play", 3218959716)

    internal val stopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "stop", 3218959716)

    internal val isPlayingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "is_playing", 36873697)

    internal val setPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_paused", 2586408642)

    internal val isPausedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "is_paused", 36873697)

    internal val setLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_loop", 2586408642)

    internal val hasLoopPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "has_loop", 36873697)

    internal val setVolumePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_volume", 373806689)

    internal val getVolumePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_volume", 1740695150)

    internal val setVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_volume_db", 373806689)

    internal val getVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_volume_db", 1740695150)

    internal val setSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_speed_scale", 373806689)

    internal val getSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_speed_scale", 1740695150)

    internal val setAudioTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_audio_track", 1286410249)

    internal val getAudioTrackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_audio_track", 3905245786)

    internal val getStreamNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_stream_name", 201670096)

    internal val getStreamLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_stream_length", 1740695150)

    internal val setStreamPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_stream_position", 373806689)

    internal val getStreamPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_stream_position", 1740695150)

    internal val setAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_autoplay", 2586408642)

    internal val hasAutoplayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "has_autoplay", 36873697)

    internal val setExpandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_expand", 2586408642)

    internal val hasExpandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "has_expand", 36873697)

    internal val setBufferingMsecPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_buffering_msec", 1286410249)

    internal val getBufferingMsecPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_buffering_msec", 3905245786)

    internal val setBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "set_bus", 3304788590)

    internal val getBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_bus", 2002593661)

    internal val getVideoTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("VideoStreamPlayer", "get_video_texture", 3635182373)
  }
}
