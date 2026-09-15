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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Allows the user to record the sound from an audio bus into an [AudioStreamWAV]. When used on the
 * Master audio bus, this includes all audio output by Godot.
 *
 * Unlike [AudioEffectCapture], this effect encodes the recording with the given format (8-bit,
 * 16-bit, or compressed) instead of giving access to the raw audio samples.
 *
 * Can be used (with an [AudioStreamMicrophone]) to record from a microphone.
 *
 * **Note:** [ProjectSettings.audio/driver/enableInput] must be `true` for audio input to work. See
 * also that setting's description for caveats related to permissions and operating system privacy
 * settings.
 */
@GodotBaseType
public open class AudioEffectRecord : AudioEffect() {
  /**
   * Specifies the format in which the sample will be recorded.
   */
  public final inline var format: AudioStreamWAV.Format
    @JvmName("formatProperty")
    get() = getFormat()
    @JvmName("formatProperty")
    set(`value`) {
      setFormat(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(71, scriptPtr)
  }

  /**
   * If `true`, the sound will be recorded. Note that restarting the recording will remove the
   * previously recorded sample.
   */
  public final fun setRecordingActive(record: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to record)
    TransferContext.callMethod(MethodBindings.setRecordingActivePtr)
  }

  /**
   * Returns whether the recording is active or not.
   */
  public final fun isRecordingActive(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRecordingActivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setFormat(format: AudioStreamWAV.Format): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to format.value)
    TransferContext.callMethod(MethodBindings.setFormatPtr)
  }

  public final fun getFormat(): AudioStreamWAV.Format {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFormatPtr)
    return AudioStreamWAV.Format.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the recorded sample.
   */
  public final fun getRecording(): AudioStreamWAV? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRecordingPtr)
    return (TransferContext.readReturnValue(OBJECT) as AudioStreamWAV?)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectRecord::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setRecordingActiveName: MethodStringName1<AudioEffectRecord, Unit, Boolean> =
        MethodStringName1<AudioEffectRecord, Unit, Boolean>("set_recording_active")

    @JvmField
    public val isRecordingActiveName: MethodStringName0<AudioEffectRecord, Boolean> =
        MethodStringName0<AudioEffectRecord, Boolean>("is_recording_active")

    @JvmField
    public val setFormatName: MethodStringName1<AudioEffectRecord, Unit, AudioStreamWAV.Format> =
        MethodStringName1<AudioEffectRecord, Unit, AudioStreamWAV.Format>("set_format")

    @JvmField
    public val getFormatName: MethodStringName0<AudioEffectRecord, AudioStreamWAV.Format> =
        MethodStringName0<AudioEffectRecord, AudioStreamWAV.Format>("get_format")

    @JvmField
    public val getRecordingName: MethodStringName0<AudioEffectRecord, AudioStreamWAV?> =
        MethodStringName0<AudioEffectRecord, AudioStreamWAV?>("get_recording")
  }

  public object MethodBindings {
    internal val setRecordingActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectRecord", "set_recording_active", 2586408642)

    internal val isRecordingActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectRecord", "is_recording_active", 36873697)

    internal val setFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectRecord", "set_format", 60648488)

    internal val getFormatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectRecord", "get_format", 3151724922)

    internal val getRecordingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectRecord", "get_recording", 2964110865)
  }
}
