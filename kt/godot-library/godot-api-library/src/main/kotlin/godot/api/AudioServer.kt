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
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.Signal0
import godot.core.Signal3
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_PACKED_VECTOR2_ARRAY
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG_LONG
import godot.writeMethodArguments_LONG_OBJECT_LONG
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_LONG_STRING_NAME
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME
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
import kotlin.jvm.JvmStatic

/**
 * [AudioServer] is a low-level server interface for audio access. It is in charge of creating
 * sample data (playable audio) as well as its playback via a voice interface.
 */
@GodotBaseType
public object AudioServer : Object() {
  @JvmField
  public val setBusCountName: MethodStringName1<AudioServer, Unit, Int> =
      MethodStringName1<AudioServer, Unit, Int>("set_bus_count")

  @JvmField
  public val getBusCountName: MethodStringName0<AudioServer, Int> =
      MethodStringName0<AudioServer, Int>("get_bus_count")

  @JvmField
  public val removeBusName: MethodStringName1<AudioServer, Unit, Int> =
      MethodStringName1<AudioServer, Unit, Int>("remove_bus")

  @JvmField
  public val addBusName: MethodStringName1<AudioServer, Unit, Int> =
      MethodStringName1<AudioServer, Unit, Int>("add_bus")

  @JvmField
  public val moveBusName: MethodStringName2<AudioServer, Unit, Int, Int> =
      MethodStringName2<AudioServer, Unit, Int, Int>("move_bus")

  @JvmField
  public val setBusNameName: MethodStringName2<AudioServer, Unit, Int, String> =
      MethodStringName2<AudioServer, Unit, Int, String>("set_bus_name")

  @JvmField
  public val getBusNameName: MethodStringName1<AudioServer, String, Int> =
      MethodStringName1<AudioServer, String, Int>("get_bus_name")

  @JvmField
  public val getBusIndexName: MethodStringName1<AudioServer, Int, StringName> =
      MethodStringName1<AudioServer, Int, StringName>("get_bus_index")

  @JvmField
  public val getBusChannelsName: MethodStringName1<AudioServer, Int, Int> =
      MethodStringName1<AudioServer, Int, Int>("get_bus_channels")

  @JvmField
  public val setBusVolumeDbName: MethodStringName2<AudioServer, Unit, Int, Float> =
      MethodStringName2<AudioServer, Unit, Int, Float>("set_bus_volume_db")

  @JvmField
  public val getBusVolumeDbName: MethodStringName1<AudioServer, Float, Int> =
      MethodStringName1<AudioServer, Float, Int>("get_bus_volume_db")

  @JvmField
  public val setBusVolumeLinearName: MethodStringName2<AudioServer, Unit, Int, Float> =
      MethodStringName2<AudioServer, Unit, Int, Float>("set_bus_volume_linear")

  @JvmField
  public val getBusVolumeLinearName: MethodStringName1<AudioServer, Float, Int> =
      MethodStringName1<AudioServer, Float, Int>("get_bus_volume_linear")

  @JvmField
  public val setBusSendName: MethodStringName2<AudioServer, Unit, Int, StringName> =
      MethodStringName2<AudioServer, Unit, Int, StringName>("set_bus_send")

  @JvmField
  public val getBusSendName: MethodStringName1<AudioServer, StringName, Int> =
      MethodStringName1<AudioServer, StringName, Int>("get_bus_send")

  @JvmField
  public val setBusSoloName: MethodStringName2<AudioServer, Unit, Int, Boolean> =
      MethodStringName2<AudioServer, Unit, Int, Boolean>("set_bus_solo")

  @JvmField
  public val isBusSoloName: MethodStringName1<AudioServer, Boolean, Int> =
      MethodStringName1<AudioServer, Boolean, Int>("is_bus_solo")

  @JvmField
  public val setBusMuteName: MethodStringName2<AudioServer, Unit, Int, Boolean> =
      MethodStringName2<AudioServer, Unit, Int, Boolean>("set_bus_mute")

  @JvmField
  public val isBusMuteName: MethodStringName1<AudioServer, Boolean, Int> =
      MethodStringName1<AudioServer, Boolean, Int>("is_bus_mute")

  @JvmField
  public val setBusBypassEffectsName: MethodStringName2<AudioServer, Unit, Int, Boolean> =
      MethodStringName2<AudioServer, Unit, Int, Boolean>("set_bus_bypass_effects")

  @JvmField
  public val isBusBypassingEffectsName: MethodStringName1<AudioServer, Boolean, Int> =
      MethodStringName1<AudioServer, Boolean, Int>("is_bus_bypassing_effects")

  @JvmField
  public val addBusEffectName: MethodStringName3<AudioServer, Unit, Int, AudioEffect?, Int> =
      MethodStringName3<AudioServer, Unit, Int, AudioEffect?, Int>("add_bus_effect")

  @JvmField
  public val removeBusEffectName: MethodStringName2<AudioServer, Unit, Int, Int> =
      MethodStringName2<AudioServer, Unit, Int, Int>("remove_bus_effect")

  @JvmField
  public val getBusEffectCountName: MethodStringName1<AudioServer, Int, Int> =
      MethodStringName1<AudioServer, Int, Int>("get_bus_effect_count")

  @JvmField
  public val getBusEffectName: MethodStringName2<AudioServer, AudioEffect?, Int, Int> =
      MethodStringName2<AudioServer, AudioEffect?, Int, Int>("get_bus_effect")

  @JvmField
  public val getBusEffectInstanceName:
      MethodStringName3<AudioServer, AudioEffectInstance?, Int, Int, Int> =
      MethodStringName3<AudioServer, AudioEffectInstance?, Int, Int, Int>("get_bus_effect_instance")

  @JvmField
  public val swapBusEffectsName: MethodStringName3<AudioServer, Unit, Int, Int, Int> =
      MethodStringName3<AudioServer, Unit, Int, Int, Int>("swap_bus_effects")

  @JvmField
  public val setBusEffectEnabledName: MethodStringName3<AudioServer, Unit, Int, Int, Boolean> =
      MethodStringName3<AudioServer, Unit, Int, Int, Boolean>("set_bus_effect_enabled")

  @JvmField
  public val isBusEffectEnabledName: MethodStringName2<AudioServer, Boolean, Int, Int> =
      MethodStringName2<AudioServer, Boolean, Int, Int>("is_bus_effect_enabled")

  @JvmField
  public val getBusPeakVolumeLeftDbName: MethodStringName2<AudioServer, Float, Int, Int> =
      MethodStringName2<AudioServer, Float, Int, Int>("get_bus_peak_volume_left_db")

  @JvmField
  public val getBusPeakVolumeRightDbName: MethodStringName2<AudioServer, Float, Int, Int> =
      MethodStringName2<AudioServer, Float, Int, Int>("get_bus_peak_volume_right_db")

  @JvmField
  public val setPlaybackSpeedScaleName: MethodStringName1<AudioServer, Unit, Float> =
      MethodStringName1<AudioServer, Unit, Float>("set_playback_speed_scale")

  @JvmField
  public val getPlaybackSpeedScaleName: MethodStringName0<AudioServer, Float> =
      MethodStringName0<AudioServer, Float>("get_playback_speed_scale")

  @JvmField
  public val lockName: MethodStringName0<AudioServer, Unit> =
      MethodStringName0<AudioServer, Unit>("lock")

  @JvmField
  public val unlockName: MethodStringName0<AudioServer, Unit> =
      MethodStringName0<AudioServer, Unit>("unlock")

  @JvmField
  public val getSpeakerModeName: MethodStringName0<AudioServer, SpeakerMode> =
      MethodStringName0<AudioServer, SpeakerMode>("get_speaker_mode")

  @JvmField
  public val getMixRateName: MethodStringName0<AudioServer, Float> =
      MethodStringName0<AudioServer, Float>("get_mix_rate")

  @JvmField
  public val getInputMixRateName: MethodStringName0<AudioServer, Float> =
      MethodStringName0<AudioServer, Float>("get_input_mix_rate")

  @JvmField
  public val getDriverNameName: MethodStringName0<AudioServer, String> =
      MethodStringName0<AudioServer, String>("get_driver_name")

  @JvmField
  public val getOutputDeviceListName: MethodStringName0<AudioServer, PackedStringArray> =
      MethodStringName0<AudioServer, PackedStringArray>("get_output_device_list")

  @JvmField
  public val getOutputDeviceName: MethodStringName0<AudioServer, String> =
      MethodStringName0<AudioServer, String>("get_output_device")

  @JvmField
  public val setOutputDeviceName: MethodStringName1<AudioServer, Unit, String> =
      MethodStringName1<AudioServer, Unit, String>("set_output_device")

  @JvmField
  public val getTimeToNextMixName: MethodStringName0<AudioServer, Double> =
      MethodStringName0<AudioServer, Double>("get_time_to_next_mix")

  @JvmField
  public val getTimeSinceLastMixName: MethodStringName0<AudioServer, Double> =
      MethodStringName0<AudioServer, Double>("get_time_since_last_mix")

  @JvmField
  public val getOutputLatencyName: MethodStringName0<AudioServer, Double> =
      MethodStringName0<AudioServer, Double>("get_output_latency")

  @JvmField
  public val getInputDeviceListName: MethodStringName0<AudioServer, PackedStringArray> =
      MethodStringName0<AudioServer, PackedStringArray>("get_input_device_list")

  @JvmField
  public val getInputDeviceName: MethodStringName0<AudioServer, String> =
      MethodStringName0<AudioServer, String>("get_input_device")

  @JvmField
  public val setInputDeviceName: MethodStringName1<AudioServer, Unit, String> =
      MethodStringName1<AudioServer, Unit, String>("set_input_device")

  @JvmField
  public val setInputDeviceActiveName: MethodStringName1<AudioServer, Error, Boolean> =
      MethodStringName1<AudioServer, Error, Boolean>("set_input_device_active")

  @JvmField
  public val getInputFramesAvailableName: MethodStringName0<AudioServer, Int> =
      MethodStringName0<AudioServer, Int>("get_input_frames_available")

  @JvmField
  public val getInputBufferLengthFramesName: MethodStringName0<AudioServer, Int> =
      MethodStringName0<AudioServer, Int>("get_input_buffer_length_frames")

  @JvmField
  public val getInputFramesName: MethodStringName1<AudioServer, PackedVector2Array, Int> =
      MethodStringName1<AudioServer, PackedVector2Array, Int>("get_input_frames")

  @JvmField
  public val setBusLayoutName: MethodStringName1<AudioServer, Unit, AudioBusLayout?> =
      MethodStringName1<AudioServer, Unit, AudioBusLayout?>("set_bus_layout")

  @JvmField
  public val generateBusLayoutName: MethodStringName0<AudioServer, AudioBusLayout?> =
      MethodStringName0<AudioServer, AudioBusLayout?>("generate_bus_layout")

  @JvmField
  public val setEnableTaggingUsedAudioStreamsName: MethodStringName1<AudioServer, Unit, Boolean> =
      MethodStringName1<AudioServer, Unit, Boolean>("set_enable_tagging_used_audio_streams")

  @JvmField
  public val isStreamRegisteredAsSampleName: MethodStringName1<AudioServer, Boolean, AudioStream?> =
      MethodStringName1<AudioServer, Boolean, AudioStream?>("is_stream_registered_as_sample")

  @JvmField
  public val registerStreamAsSampleName: MethodStringName1<AudioServer, Unit, AudioStream?> =
      MethodStringName1<AudioServer, Unit, AudioStream?>("register_stream_as_sample")

  /**
   * Emitted when an audio bus is added, deleted, or moved.
   */
  @JvmStatic
  public val busLayoutChanged: Signal0 by Signal0

  /**
   * Emitted when the audio bus at [busIndex] is renamed from [oldName] to [newName].
   */
  @JvmStatic
  public val busRenamed: Signal3<Long, StringName, StringName> by Signal3

  /**
   * Number of available audio buses.
   */
  @JvmStatic
  public final inline var busCount: Int
    @JvmName("busCountProperty")
    get() = getBusCount()
    @JvmName("busCountProperty")
    set(`value`) {
      setBusCount(value)
    }

  /**
   * Name of the current device for audio output (see [getOutputDeviceList]). On systems with
   * multiple audio outputs (such as analog, USB and HDMI audio), this can be used to select the audio
   * output device. The value `"Default"` will play audio on the system-wide default audio output. If
   * an invalid device name is set, the value will be reverted back to `"Default"`.
   */
  @JvmStatic
  public final inline var outputDevice: String
    @JvmName("outputDeviceProperty")
    get() = getOutputDevice()
    @JvmName("outputDeviceProperty")
    set(`value`) {
      setOutputDevice(value)
    }

  /**
   * Name of the current device for audio input (see [getInputDeviceList]). On systems with multiple
   * audio inputs (such as analog, USB and HDMI audio), this can be used to select the audio input
   * device. The value `"Default"` will record audio on the system-wide default audio input. If an
   * invalid device name is set, the value will be reverted back to `"Default"`.
   *
   * **Note:** [ProjectSettings.audio/driver/enableInput] must be `true` for audio input to work.
   * See also that setting's description for caveats related to permissions and operating system
   * privacy settings.
   */
  @JvmStatic
  public final inline var inputDevice: String
    @JvmName("inputDeviceProperty")
    get() = getInputDevice()
    @JvmName("inputDeviceProperty")
    set(`value`) {
      setInputDevice(value)
    }

  /**
   * Scales the rate at which audio is played (i.e. setting it to `0.5` will make the audio be
   * played at half its speed). See also [Engine.timeScale] to affect the general simulation speed,
   * which is independent from [AudioServer.playbackSpeedScale].
   */
  @JvmStatic
  public final inline var playbackSpeedScale: Float
    @JvmName("playbackSpeedScaleProperty")
    get() = getPlaybackSpeedScale()
    @JvmName("playbackSpeedScaleProperty")
    set(`value`) {
      setPlaybackSpeedScale(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(1)
  }

  @JvmStatic
  public final fun setBusCount(amount: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, amount.toLong())
    TransferContext.callPtrMethod(MethodBindings.setBusCountPtr, 0)
  }

  @JvmStatic
  public final fun getBusCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBusCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Removes the bus at index [index].
   */
  @JvmStatic
  public final fun removeBus(index: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.removeBusPtr, 0)
  }

  /**
   * Adds a bus at [atPosition].
   */
  @JvmOverloads
  @JvmStatic
  public final fun addBus(atPosition: Int = -1): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, atPosition.toLong())
    TransferContext.callPtrMethod(MethodBindings.addBusPtr, 0)
  }

  /**
   * Moves the bus from index [index] to index [toIndex].
   */
  @JvmStatic
  public final fun moveBus(index: Int, toIndex: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), toIndex.toLong())
    TransferContext.callPtrMethod(MethodBindings.moveBusPtr, 0)
  }

  /**
   * Sets the name of the bus at index [busIdx] to [name].
   */
  @JvmStatic
  public final fun setBusName(busIdx: Int, name: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, busIdx.toLong(), name)
    TransferContext.callMethod(MethodBindings.setBusNamePtr)
  }

  /**
   * Returns the name of the bus with the index [busIdx].
   */
  @JvmStatic
  public final fun getBusName(busIdx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBusNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the index of the bus with the name [busName]. Returns `-1` if no bus with the specified
   * name exist.
   */
  @JvmStatic
  public final fun getBusIndex(busName: StringName): Int {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, busName)
    TransferContext.callPtrMethod(MethodBindings.getBusIndexPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the number of channels of the bus at index [busIdx].
   */
  @JvmStatic
  public final fun getBusChannels(busIdx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusChannelsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the volume in decibels of the bus at index [busIdx] to [volumeDb].
   */
  @JvmStatic
  public final fun setBusVolumeDb(busIdx: Int, volumeDb: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, busIdx.toLong(), volumeDb.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setBusVolumeDbPtr, 0)
  }

  /**
   * Returns the volume of the bus at index [busIdx] in dB.
   */
  @JvmStatic
  public final fun getBusVolumeDb(busIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusVolumeDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the volume as a linear value of the bus at index [busIdx] to [volumeLinear].
   *
   * **Note:** Using this method is equivalent to calling [setBusVolumeDb] with the result of
   * [@GlobalScope.linearToDb] on a value.
   */
  @JvmStatic
  public final fun setBusVolumeLinear(busIdx: Int, volumeLinear: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, busIdx.toLong(), volumeLinear.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setBusVolumeLinearPtr, 0)
  }

  /**
   * Returns the volume of the bus at index [busIdx] as a linear value.
   *
   * **Note:** The returned value is equivalent to the result of [@GlobalScope.dbToLinear] on the
   * result of [getBusVolumeDb].
   */
  @JvmStatic
  public final fun getBusVolumeLinear(busIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusVolumeLinearPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Connects the output of the bus at [busIdx] to the bus named [send].
   */
  @JvmStatic
  public final fun setBusSend(busIdx: Int, send: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, busIdx.toLong(), send)
    TransferContext.callPtrMethod(MethodBindings.setBusSendPtr, 0)
  }

  /**
   * Returns the name of the bus that the bus at index [busIdx] sends to.
   */
  @JvmStatic
  public final fun getBusSend(busIdx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBusSendPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * If `true`, the bus at index [busIdx] is in solo mode.
   */
  @JvmStatic
  public final fun setBusSolo(busIdx: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, busIdx.toLong(), enable)
    TransferContext.callPtrMethod(MethodBindings.setBusSoloPtr, 0)
  }

  /**
   * If `true`, the bus at index [busIdx] is in solo mode.
   */
  @JvmStatic
  public final fun isBusSolo(busIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.isBusSoloPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * If `true`, the bus at index [busIdx] is muted.
   */
  @JvmStatic
  public final fun setBusMute(busIdx: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, busIdx.toLong(), enable)
    TransferContext.callPtrMethod(MethodBindings.setBusMutePtr, 0)
  }

  /**
   * If `true`, the bus at index [busIdx] is muted.
   */
  @JvmStatic
  public final fun isBusMute(busIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.isBusMutePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * If `true`, the bus at index [busIdx] is bypassing effects.
   */
  @JvmStatic
  public final fun setBusBypassEffects(busIdx: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, busIdx.toLong(), enable)
    TransferContext.callPtrMethod(MethodBindings.setBusBypassEffectsPtr, 0)
  }

  /**
   * If `true`, the bus at index [busIdx] is bypassing effects.
   */
  @JvmStatic
  public final fun isBusBypassingEffects(busIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.isBusBypassingEffectsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Adds an [AudioEffect] effect to the bus [busIdx] at [atPosition].
   */
  @JvmOverloads
  @JvmStatic
  public final fun addBusEffect(
    busIdx: Int,
    effect: AudioEffect?,
    atPosition: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT_LONG(ptr, objectID.id, busIdx.toLong(), effect, atPosition.toLong())
    TransferContext.callPtrMethod(MethodBindings.addBusEffectPtr, 0)
  }

  /**
   * Removes the effect at index [effectIdx] from the bus at index [busIdx].
   */
  @JvmStatic
  public final fun removeBusEffect(busIdx: Int, effectIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, busIdx.toLong(), effectIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.removeBusEffectPtr, 0)
  }

  /**
   * Returns the number of effects on the bus at [busIdx].
   */
  @JvmStatic
  public final fun getBusEffectCount(busIdx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, busIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusEffectCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the [AudioEffect] at position [effectIdx] in bus [busIdx].
   */
  @JvmStatic
  public final fun getBusEffect(busIdx: Int, effectIdx: Int): AudioEffect? {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, busIdx.toLong(), effectIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusEffectPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AudioEffect?)
  }

  /**
   * Returns the [AudioEffectInstance] assigned to the given bus and effect indices (and optionally
   * channel).
   */
  @JvmOverloads
  @JvmStatic
  public final fun getBusEffectInstance(
    busIdx: Int,
    effectIdx: Int,
    channel: Int = 0,
  ): AudioEffectInstance? {
    TransferContext.writeMethodArguments_LONG_LONG_LONG(ptr, objectID.id, busIdx.toLong(), effectIdx.toLong(), channel.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusEffectInstancePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AudioEffectInstance?)
  }

  /**
   * Swaps the position of two effects in bus [busIdx].
   */
  @JvmStatic
  public final fun swapBusEffects(
    busIdx: Int,
    effectIdx: Int,
    byEffectIdx: Int,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_LONG(ptr, objectID.id, busIdx.toLong(), effectIdx.toLong(), byEffectIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.swapBusEffectsPtr, 0)
  }

  /**
   * If `true`, the effect at index [effectIdx] on the bus at index [busIdx] is enabled.
   */
  @JvmStatic
  public final fun setBusEffectEnabled(
    busIdx: Int,
    effectIdx: Int,
    enabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_BOOL(ptr, objectID.id, busIdx.toLong(), effectIdx.toLong(), enabled)
    TransferContext.callPtrMethod(MethodBindings.setBusEffectEnabledPtr, 0)
  }

  /**
   * If `true`, the effect at index [effectIdx] on the bus at index [busIdx] is enabled.
   */
  @JvmStatic
  public final fun isBusEffectEnabled(busIdx: Int, effectIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, busIdx.toLong(), effectIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.isBusEffectEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the peak volume of the left speaker at bus index [busIdx] and channel index [channel].
   */
  @JvmStatic
  public final fun getBusPeakVolumeLeftDb(busIdx: Int, channel: Int): Float {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, busIdx.toLong(), channel.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusPeakVolumeLeftDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the peak volume of the right speaker at bus index [busIdx] and channel index [channel].
   */
  @JvmStatic
  public final fun getBusPeakVolumeRightDb(busIdx: Int, channel: Int): Float {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, busIdx.toLong(), channel.toLong())
    TransferContext.callPtrMethod(MethodBindings.getBusPeakVolumeRightDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  @JvmStatic
  public final fun setPlaybackSpeedScale(scale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, scale.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPlaybackSpeedScalePtr, 0)
  }

  @JvmStatic
  public final fun getPlaybackSpeedScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPlaybackSpeedScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Locks the audio driver's main loop.
   *
   * **Note:** Remember to unlock it afterwards.
   */
  @JvmStatic
  public final fun lock(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.lockPtr, 0)
  }

  /**
   * Unlocks the audio driver's main loop. (After locking it, you should always unlock it.)
   */
  @JvmStatic
  public final fun unlock(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.unlockPtr, 0)
  }

  /**
   * Returns the speaker configuration.
   */
  @JvmStatic
  public final fun getSpeakerMode(): SpeakerMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSpeakerModePtr, 2)
    return SpeakerMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the sample rate at the output of the [AudioServer].
   */
  @JvmStatic
  public final fun getMixRate(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMixRatePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the sample rate at the input of the [AudioServer].
   */
  @JvmStatic
  public final fun getInputMixRate(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInputMixRatePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the name of the current audio driver. The default usually depends on the operating
   * system, but may be overridden via the `--audio-driver`
   * [url=$DOCS_URL/tutorials/editor/command_line_tutorial.html]command line argument[/url].
   * `--headless` also automatically sets the audio driver to `Dummy`. See also
   * [ProjectSettings.audio/driver/driver].
   */
  @JvmStatic
  public final fun getDriverName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDriverNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the names of all audio output devices detected on the system.
   */
  @JvmStatic
  public final fun getOutputDeviceList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutputDeviceListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  @JvmStatic
  public final fun getOutputDevice(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutputDevicePtr)
    return TransferContext.readReturnValue_STRING()
  }

  @JvmStatic
  public final fun setOutputDevice(name: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setOutputDevicePtr)
  }

  /**
   * Returns the relative time until the next mix occurs, in seconds.
   */
  @JvmStatic
  public final fun getTimeToNextMix(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTimeToNextMixPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * Returns the relative time since the last mix occurred, in seconds.
   */
  @JvmStatic
  public final fun getTimeSinceLastMix(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTimeSinceLastMixPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * Returns the audio driver's effective output latency. This is based on
   * [ProjectSettings.audio/driver/outputLatency], but the exact returned value will differ depending
   * on the operating system and audio driver.
   *
   * **Note:** This can be expensive; it is not recommended to call [getOutputLatency] every frame.
   */
  @JvmStatic
  public final fun getOutputLatency(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOutputLatencyPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  /**
   * Returns the names of all audio input devices detected on the system.
   *
   * **Note:** [ProjectSettings.audio/driver/enableInput] must be `true` for audio input to work.
   * See also that setting's description for caveats related to permissions and operating system
   * privacy settings.
   */
  @JvmStatic
  public final fun getInputDeviceList(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInputDeviceListPtr)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  @JvmStatic
  public final fun getInputDevice(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInputDevicePtr)
    return TransferContext.readReturnValue_STRING()
  }

  @JvmStatic
  public final fun setInputDevice(name: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.setInputDevicePtr)
  }

  /**
   * If [active] is `true`, starts the microphone input stream specified by [inputDevice] or returns
   * an error if it failed.
   *
   * If [active] is `false`, stops the input stream if it is running.
   */
  @JvmStatic
  public final fun setInputDeviceActive(active: Boolean): Error {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, active)
    TransferContext.callPtrMethod(MethodBindings.setInputDeviceActivePtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the number of frames available to read using [getInputFrames].
   */
  @JvmStatic
  public final fun getInputFramesAvailable(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInputFramesAvailablePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the absolute size of the microphone input buffer. This is set to a multiple of the
   * audio latency and can be used to estimate the minimum rate at which the frames need to be fetched.
   */
  @JvmStatic
  public final fun getInputBufferLengthFrames(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInputBufferLengthFramesPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns a [PackedVector2Array] containing exactly [frames] audio samples from the internal
   * microphone buffer if available, otherwise returns an empty [PackedVector2Array].
   *
   * The buffer is filled at the rate of [getInputMixRate] frames per second when
   * [setInputDeviceActive] has successfully been set to `true`.
   *
   * The samples are signed floating-point PCM values between `-1` and `1`.
   */
  @JvmStatic
  public final fun getInputFrames(frames: Int): PackedVector2Array {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, frames.toLong())
    TransferContext.callMethod(MethodBindings.getInputFramesPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR2_ARRAY()
  }

  /**
   * Overwrites the currently used [AudioBusLayout].
   */
  @JvmStatic
  public final fun setBusLayout(busLayout: AudioBusLayout?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, busLayout)
    TransferContext.callPtrMethod(MethodBindings.setBusLayoutPtr, 0)
  }

  /**
   * Generates an [AudioBusLayout] using the available buses and effects.
   */
  @JvmStatic
  public final fun generateBusLayout(): AudioBusLayout? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.generateBusLayoutPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as AudioBusLayout?)
  }

  /**
   * If set to `true`, all instances of [AudioStreamPlayback] will call
   * [AudioStreamPlayback.TagUsedStreams] every mix step.
   *
   * **Note:** This is enabled by default in the editor, as it is used by editor plugins for the
   * audio stream previews.
   */
  @JvmStatic
  public final fun setEnableTaggingUsedAudioStreams(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setEnableTaggingUsedAudioStreamsPtr, 0)
  }

  /**
   * If `true`, the stream is registered as a sample. The engine will not have to register it before
   * playing the sample.
   *
   * If `false`, the stream will have to be registered before playing it. To prevent lag spikes,
   * register the stream as sample with [registerStreamAsSample].
   */
  @JvmStatic
  public final fun isStreamRegisteredAsSample(stream: AudioStream?): Boolean {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, stream)
    TransferContext.callPtrMethod(MethodBindings.isStreamRegisteredAsSamplePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Forces the registration of a stream as a sample.
   *
   * **Note:** Lag spikes may occur when calling this method, especially on single-threaded builds.
   * It is suggested to call this method while loading assets, where the lag spike could be masked,
   * instead of registering the sample right before it needs to be played.
   */
  @JvmStatic
  public final fun registerStreamAsSample(stream: AudioStream?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, stream)
    TransferContext.callPtrMethod(MethodBindings.registerStreamAsSamplePtr, 0)
  }

  /**
   * Returns the index of the bus with the name [busName]. Returns `-1` if no bus with the specified
   * name exist.
   */
  @JvmStatic
  public final fun getBusIndex(busName: String): Int = getBusIndex(busName.asCachedStringName())

  /**
   * Connects the output of the bus at [busIdx] to the bus named [send].
   */
  @JvmStatic
  public final fun setBusSend(busIdx: Int, send: String) =
      setBusSend(busIdx, send.asCachedStringName())

  public enum class SpeakerMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Two or fewer speakers were detected.
     */
    STEREO(0),
    /**
     * A 3.1 channel surround setup was detected.
     */
    SURROUND_31(1),
    /**
     * A 5.1 channel surround setup was detected.
     */
    SURROUND_51(2),
    /**
     * A 7.1 channel surround setup was detected.
     */
    SURROUND_71(3),
    ;

    public companion object {
      public fun from(`value`: Long): SpeakerMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class PlaybackType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The playback will be considered of the type declared at
     * [ProjectSettings.audio/general/defaultPlaybackType].
     */
    DEFAULT(0),
    /**
     * Force the playback to be considered as a stream.
     */
    STREAM(1),
    /**
     * Force the playback to be considered as a sample. This can provide lower latency and more
     * stable playback (with less risk of audio crackling), at the cost of having less flexibility.
     *
     * **Note:** Only currently supported on the web platform.
     *
     * **Note:** [AudioEffect]s are not supported when playback is considered as a sample.
     */
    SAMPLE(2),
    /**
     * Represents the size of the [PlaybackType] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): PlaybackType = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val setBusCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_count", 1286410249)

    internal val getBusCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_count", 3905245786)

    internal val removeBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "remove_bus", 1286410249)

    internal val addBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "add_bus", 1025054187)

    internal val moveBusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "move_bus", 3937882851)

    internal val setBusNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_name", 501894301)

    internal val getBusNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_name", 844755477)

    internal val getBusIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_index", 2458036349)

    internal val getBusChannelsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_channels", 923996154)

    internal val setBusVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_volume_db", 1602489585)

    internal val getBusVolumeDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_volume_db", 2339986948)

    internal val setBusVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_volume_linear", 1602489585)

    internal val getBusVolumeLinearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_volume_linear", 2339986948)

    internal val setBusSendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_send", 3780747571)

    internal val getBusSendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_send", 659327637)

    internal val setBusSoloPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_solo", 300928843)

    internal val isBusSoloPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "is_bus_solo", 1116898809)

    internal val setBusMutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_mute", 300928843)

    internal val isBusMutePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "is_bus_mute", 1116898809)

    internal val setBusBypassEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_bypass_effects", 300928843)

    internal val isBusBypassingEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "is_bus_bypassing_effects", 1116898809)

    internal val addBusEffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "add_bus_effect", 4068819785)

    internal val removeBusEffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "remove_bus_effect", 3937882851)

    internal val getBusEffectCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_effect_count", 3744713108)

    internal val getBusEffectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_effect", 726064442)

    internal val getBusEffectInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_effect_instance", 1829771234)

    internal val swapBusEffectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "swap_bus_effects", 1649997291)

    internal val setBusEffectEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_effect_enabled", 1383440665)

    internal val isBusEffectEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "is_bus_effect_enabled", 2522259332)

    internal val getBusPeakVolumeLeftDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_peak_volume_left_db", 3085491603)

    internal val getBusPeakVolumeRightDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_bus_peak_volume_right_db", 3085491603)

    internal val setPlaybackSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_playback_speed_scale", 373806689)

    internal val getPlaybackSpeedScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_playback_speed_scale", 1740695150)

    internal val lockPtr: VoidPtr = TypeManager.getMethodBindPtr("AudioServer", "lock", 3218959716)

    internal val unlockPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "unlock", 3218959716)

    internal val getSpeakerModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_speaker_mode", 2549190337)

    internal val getMixRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_mix_rate", 1740695150)

    internal val getInputMixRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_input_mix_rate", 1740695150)

    internal val getDriverNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_driver_name", 201670096)

    internal val getOutputDeviceListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_output_device_list", 2981934095)

    internal val getOutputDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_output_device", 2841200299)

    internal val setOutputDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_output_device", 83702148)

    internal val getTimeToNextMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_time_to_next_mix", 1740695150)

    internal val getTimeSinceLastMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_time_since_last_mix", 1740695150)

    internal val getOutputLatencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_output_latency", 1740695150)

    internal val getInputDeviceListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_input_device_list", 2981934095)

    internal val getInputDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_input_device", 2841200299)

    internal val setInputDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_input_device", 83702148)

    internal val setInputDeviceActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_input_device_active", 1413768114)

    internal val getInputFramesAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_input_frames_available", 2455072627)

    internal val getInputBufferLengthFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_input_buffer_length_frames", 2455072627)

    internal val getInputFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "get_input_frames", 2649534757)

    internal val setBusLayoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_bus_layout", 3319058824)

    internal val generateBusLayoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "generate_bus_layout", 3769973890)

    internal val setEnableTaggingUsedAudioStreamsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "set_enable_tagging_used_audio_streams", 2586408642)

    internal val isStreamRegisteredAsSamplePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "is_stream_registered_as_sample", 500225754)

    internal val registerStreamAsSamplePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioServer", "register_stream_as_sample", 2210767741)
  }
}
