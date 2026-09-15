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
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Float
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A "distortion" effect modifies the waveform via a nonlinear mathematical function (see available
 * ones in [Mode]), based on the amplitude of the waveform's samples.
 *
 * **Note:** In a nonlinear function, an input sample at *x* amplitude value, will either have its
 * amplitude increased or decreased to a *y* value, based on the function value at *x*, which is why
 * even at the same [drive], the output sound will vary depending on the input's volume. To change the
 * volume while maintaining the output waveform, use [postGain].
 *
 * In this effect, each type is a different nonlinear function. The different types available are:
 * clip, atan, lofi (bitcrush), overdrive, and waveshape. Every distortion type available here is
 * symmetric: negative amplitude values are affected the same way as positive ones.
 *
 * Although distortion will always change frequency content, usually by introducing high harmonics,
 * different distortion types offer a range of sound qualities; from "soft" and "warm", to "crunchy"
 * and "abrasive".
 *
 * For games, it can help simulate sound coming from some saturated device or speaker very
 * efficiently. It can also help the audio stand out in a mix, by introducing higher frequencies and
 * increasing the volume.
 *
 * **Note:** Although usually imperceptible, an enabled distortion effect still changes the sound
 * even when [drive] is set to 0. This is not a bug. If this behavior is undesirable, consider
 * disabling the effect using [AudioServer.setBusEffectEnabled].
 */
@GodotBaseType
public open class AudioEffectDistortion : AudioEffect() {
  /**
   * Distortion type. Changes the nonlinear function used to distort the waveform. See [Mode].
   */
  public final inline var mode: Mode
    @JvmName("modeProperty")
    get() = getMode()
    @JvmName("modeProperty")
    set(`value`) {
      setMode(value)
    }

  /**
   * Gain before the effect, in dB. Value can range from -60 to 60.
   */
  public final inline var preGain: Float
    @JvmName("preGainProperty")
    get() = getPreGain()
    @JvmName("preGainProperty")
    set(`value`) {
      setPreGain(value)
    }

  /**
   * High-pass filter, in Hz. Frequencies higher than this value will not be affected by the
   * distortion. Value can range from 1 to 20000.
   */
  public final inline var keepHfHz: Float
    @JvmName("keepHfHzProperty")
    get() = getKeepHfHz()
    @JvmName("keepHfHzProperty")
    set(`value`) {
      setKeepHfHz(value)
    }

  /**
   * Distortion intensity. Controls how much of the input audio is affected by the distortion curve
   * by moving from a linear function to a nonlinear one. Value can range from 0 to 1.
   */
  public final inline var drive: Float
    @JvmName("driveProperty")
    get() = getDrive()
    @JvmName("driveProperty")
    set(`value`) {
      setDrive(value)
    }

  /**
   * Gain after the effect, in dB. Value can range from -80 to 24.
   */
  public final inline var postGain: Float
    @JvmName("postGainProperty")
    get() = getPostGain()
    @JvmName("postGainProperty")
    set(`value`) {
      setPostGain(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(54, scriptPtr)
  }

  public final fun setMode(mode: Mode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setModePtr)
  }

  public final fun getMode(): Mode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModePtr)
    return Mode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPreGain(preGain: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, preGain.toDouble())
    TransferContext.callMethod(MethodBindings.setPreGainPtr)
  }

  public final fun getPreGain(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPreGainPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setKeepHfHz(keepHfHz: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, keepHfHz.toDouble())
    TransferContext.callMethod(MethodBindings.setKeepHfHzPtr)
  }

  public final fun getKeepHfHz(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getKeepHfHzPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDrive(drive: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, drive.toDouble())
    TransferContext.callMethod(MethodBindings.setDrivePtr)
  }

  public final fun getDrive(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDrivePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPostGain(postGain: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, postGain.toDouble())
    TransferContext.callMethod(MethodBindings.setPostGainPtr)
  }

  public final fun getPostGain(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPostGainPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectDistortion::_instantiate can't be called from the JVM.")
  }

  public enum class Mode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Flattens the waveform at 0 dB in a sharp manner. [drive] increases amplitude of samples
     * exponentially. This mode functions as a hard clipper if [drive] is set to 0, and is the only
     * mode that clips audio signals at 0 dB.
     */
    CLIP(0),
    /**
     * Flattens the waveform in a smooth manner, following an arctangent curve. The audio decreases
     * in volume, before flattening peaks to `PI * 4.0` (linear value), if it was normalized
     * beforehand.
     */
    ATAN(1),
    /**
     * Decreases audio bit depth to achieve a low-resolution audio signal, going from 16-bit to
     * 2-bit. Can be used to emulate the sound of early digital audio devices.
     */
    LOFI(2),
    /**
     * Emulates the warm distortion produced by a field effect transistor, which is commonly used in
     * solid-state musical instrument amplifiers. [drive] has no effect in this mode.
     */
    OVERDRIVE(3),
    /**
     * Flattens the waveform in a smooth manner, until it reaches a sharp peak at `drive = 1`,
     * following a generic absolute sigmoid function.
     */
    WAVESHAPE(4),
    ;

    public companion object {
      public fun from(`value`: Long): Mode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setModeName: MethodStringName1<AudioEffectDistortion, Unit, Mode> =
        MethodStringName1<AudioEffectDistortion, Unit, Mode>("set_mode")

    @JvmField
    public val getModeName: MethodStringName0<AudioEffectDistortion, Mode> =
        MethodStringName0<AudioEffectDistortion, Mode>("get_mode")

    @JvmField
    public val setPreGainName: MethodStringName1<AudioEffectDistortion, Unit, Float> =
        MethodStringName1<AudioEffectDistortion, Unit, Float>("set_pre_gain")

    @JvmField
    public val getPreGainName: MethodStringName0<AudioEffectDistortion, Float> =
        MethodStringName0<AudioEffectDistortion, Float>("get_pre_gain")

    @JvmField
    public val setKeepHfHzName: MethodStringName1<AudioEffectDistortion, Unit, Float> =
        MethodStringName1<AudioEffectDistortion, Unit, Float>("set_keep_hf_hz")

    @JvmField
    public val getKeepHfHzName: MethodStringName0<AudioEffectDistortion, Float> =
        MethodStringName0<AudioEffectDistortion, Float>("get_keep_hf_hz")

    @JvmField
    public val setDriveName: MethodStringName1<AudioEffectDistortion, Unit, Float> =
        MethodStringName1<AudioEffectDistortion, Unit, Float>("set_drive")

    @JvmField
    public val getDriveName: MethodStringName0<AudioEffectDistortion, Float> =
        MethodStringName0<AudioEffectDistortion, Float>("get_drive")

    @JvmField
    public val setPostGainName: MethodStringName1<AudioEffectDistortion, Unit, Float> =
        MethodStringName1<AudioEffectDistortion, Unit, Float>("set_post_gain")

    @JvmField
    public val getPostGainName: MethodStringName0<AudioEffectDistortion, Float> =
        MethodStringName0<AudioEffectDistortion, Float>("get_post_gain")
  }

  public object MethodBindings {
    internal val setModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "set_mode", 1314744793)

    internal val getModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "get_mode", 809118343)

    internal val setPreGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "set_pre_gain", 373806689)

    internal val getPreGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "get_pre_gain", 1740695150)

    internal val setKeepHfHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "set_keep_hf_hz", 373806689)

    internal val getKeepHfHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "get_keep_hf_hz", 1740695150)

    internal val setDrivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "set_drive", 373806689)

    internal val getDrivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "get_drive", 1740695150)

    internal val setPostGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "set_post_gain", 373806689)

    internal val getPostGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDistortion", "get_post_gain", 1740695150)
  }
}
