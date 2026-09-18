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
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_STRING_NAME
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A "compressor" decreases the volume of sounds when it exceeds a certain volume threshold level.
 *
 * A compressor can have many uses in a mix:
 *
 * - To compress the whole volume in the Master bus (although an [AudioEffectHardLimiter] is
 * probably better).
 *
 * - To ensure balance of voice audio clips.
 *
 * - To sidechain, using another bus as a trigger. This decreases the volume of the bus it is
 * attached to, by using the volume from another audio bus for threshold detection. This technique is
 * common in video game mixing to decrease the volume of music and SFX while voices are being heard.
 * This effect is also known as "ducking".
 *
 * - To accentuate transients by using a long attack, letting sounds exceed the volume threshold
 * level for a short period before compressing them. This can be used to make SFX more punchy.
 */
@GodotBaseType
public open class AudioEffectCompressor : AudioEffect() {
  /**
   * The volume level above which compression is applied to the audio, in dB. Value can range
   * from -60 to 0.
   */
  public final inline var threshold: Float
    @JvmName("thresholdProperty")
    get() = getThreshold()
    @JvmName("thresholdProperty")
    set(`value`) {
      setThreshold(value)
    }

  /**
   * Amount of compression applied to the audio once it passes the volume threshold level. The
   * higher the ratio, the stronger the compression applied to audio signals that pass the volume
   * threshold level. Value can range from 1 to 48.
   */
  public final inline var ratio: Float
    @JvmName("ratioProperty")
    get() = getRatio()
    @JvmName("ratioProperty")
    set(`value`) {
      setRatio(value)
    }

  /**
   * Gain of the audio signal, in dB. Value can range from -20 to 20.
   */
  public final inline var gain: Float
    @JvmName("gainProperty")
    get() = getGain()
    @JvmName("gainProperty")
    set(`value`) {
      setGain(value)
    }

  /**
   * Compressor's reaction time when the audio exceeds the volume threshold level, in microseconds.
   * Value can range from 20 to 2000.
   */
  public final inline var attackUs: Float
    @JvmName("attackUsProperty")
    get() = getAttackUs()
    @JvmName("attackUsProperty")
    set(`value`) {
      setAttackUs(value)
    }

  /**
   * Compressor's delay time to stop decreasing the volume after the it falls below the volume
   * threshold level, in milliseconds. Value can range from 20 to 2000.
   */
  public final inline var releaseMs: Float
    @JvmName("releaseMsProperty")
    get() = getReleaseMs()
    @JvmName("releaseMsProperty")
    set(`value`) {
      setReleaseMs(value)
    }

  /**
   * Balance between the original audio and the compressed audio. Value can range from 0 (totally
   * dry) to 1 (totally wet).
   */
  public final inline var mix: Float
    @JvmName("mixProperty")
    get() = getMix()
    @JvmName("mixProperty")
    set(`value`) {
      setMix(value)
    }

  /**
   * Audio bus to use for the volume threshold detection.
   */
  public final inline var sidechain: StringName
    @JvmName("sidechainProperty")
    get() = getSidechain()
    @JvmName("sidechainProperty")
    set(`value`) {
      setSidechain(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(52, scriptPtr)
  }

  public final fun setThreshold(threshold: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, threshold.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setThresholdPtr, 0)
  }

  public final fun getThreshold(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getThresholdPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRatio(ratio: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, ratio.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setRatioPtr, 0)
  }

  public final fun getRatio(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRatioPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setGain(gain: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, gain.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setGainPtr, 0)
  }

  public final fun getGain(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGainPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAttackUs(attackUs: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, attackUs.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAttackUsPtr, 0)
  }

  public final fun getAttackUs(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAttackUsPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setReleaseMs(releaseMs: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, releaseMs.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setReleaseMsPtr, 0)
  }

  public final fun getReleaseMs(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getReleaseMsPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setMix(mix: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, mix.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setMixPtr, 0)
  }

  public final fun getMix(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMixPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSidechain(sidechain: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, sidechain)
    TransferContext.callPtrMethod(MethodBindings.setSidechainPtr, 0)
  }

  public final fun getSidechain(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSidechainPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectCompressor::_instantiate can't be called from the JVM.")
  }

  public final fun setSidechain(sidechain: String) = setSidechain(sidechain.asCachedStringName())

  public companion object {
    @JvmField
    public val setThresholdName: MethodStringName1<AudioEffectCompressor, Unit, Float> =
        MethodStringName1<AudioEffectCompressor, Unit, Float>("set_threshold")

    @JvmField
    public val getThresholdName: MethodStringName0<AudioEffectCompressor, Float> =
        MethodStringName0<AudioEffectCompressor, Float>("get_threshold")

    @JvmField
    public val setRatioName: MethodStringName1<AudioEffectCompressor, Unit, Float> =
        MethodStringName1<AudioEffectCompressor, Unit, Float>("set_ratio")

    @JvmField
    public val getRatioName: MethodStringName0<AudioEffectCompressor, Float> =
        MethodStringName0<AudioEffectCompressor, Float>("get_ratio")

    @JvmField
    public val setGainName: MethodStringName1<AudioEffectCompressor, Unit, Float> =
        MethodStringName1<AudioEffectCompressor, Unit, Float>("set_gain")

    @JvmField
    public val getGainName: MethodStringName0<AudioEffectCompressor, Float> =
        MethodStringName0<AudioEffectCompressor, Float>("get_gain")

    @JvmField
    public val setAttackUsName: MethodStringName1<AudioEffectCompressor, Unit, Float> =
        MethodStringName1<AudioEffectCompressor, Unit, Float>("set_attack_us")

    @JvmField
    public val getAttackUsName: MethodStringName0<AudioEffectCompressor, Float> =
        MethodStringName0<AudioEffectCompressor, Float>("get_attack_us")

    @JvmField
    public val setReleaseMsName: MethodStringName1<AudioEffectCompressor, Unit, Float> =
        MethodStringName1<AudioEffectCompressor, Unit, Float>("set_release_ms")

    @JvmField
    public val getReleaseMsName: MethodStringName0<AudioEffectCompressor, Float> =
        MethodStringName0<AudioEffectCompressor, Float>("get_release_ms")

    @JvmField
    public val setMixName: MethodStringName1<AudioEffectCompressor, Unit, Float> =
        MethodStringName1<AudioEffectCompressor, Unit, Float>("set_mix")

    @JvmField
    public val getMixName: MethodStringName0<AudioEffectCompressor, Float> =
        MethodStringName0<AudioEffectCompressor, Float>("get_mix")

    @JvmField
    public val setSidechainName: MethodStringName1<AudioEffectCompressor, Unit, StringName> =
        MethodStringName1<AudioEffectCompressor, Unit, StringName>("set_sidechain")

    @JvmField
    public val getSidechainName: MethodStringName0<AudioEffectCompressor, StringName> =
        MethodStringName0<AudioEffectCompressor, StringName>("get_sidechain")
  }

  public object MethodBindings {
    internal val setThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "set_threshold", 373806689)

    internal val getThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "get_threshold", 1740695150)

    internal val setRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "set_ratio", 373806689)

    internal val getRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "get_ratio", 1740695150)

    internal val setGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "set_gain", 373806689)

    internal val getGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "get_gain", 1740695150)

    internal val setAttackUsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "set_attack_us", 373806689)

    internal val getAttackUsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "get_attack_us", 1740695150)

    internal val setReleaseMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "set_release_ms", 373806689)

    internal val getReleaseMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "get_release_ms", 1740695150)

    internal val setMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "set_mix", 373806689)

    internal val getMixPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "get_mix", 1740695150)

    internal val setSidechainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "set_sidechain", 3304788590)

    internal val getSidechainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCompressor", "get_sidechain", 2002593661)
  }
}
