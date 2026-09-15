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
import godot.core.MethodStringName2
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A "chorus" effect creates multiple copies of the original audio (called "voices") with variations
 * in pitch, and layers on top of the original, giving the impression that the sound comes from
 * multiple sources. This creates spectral and spatial movement.
 *
 * Each voice is played a short period of time after the original audio, controlled by `delay`. An
 * internal low-frequency oscillator (LFO) controls their pitch, and `depth` controls the LFO's maximum
 * amount.
 *
 * In the real world, this kind of effect is found in pianos, choirs, and instrument ensembles.
 *
 * This effect can also be used to widen mono audio and make digital sounds have a more natural or
 * analog quality.
 */
@GodotBaseType
public open class AudioEffectChorus : AudioEffect() {
  /**
   * The number of voices in the effect. Value can range from 1 to 4.
   */
  public final inline var voiceCount: Int
    @JvmName("voiceCountProperty")
    get() = getVoiceCount()
    @JvmName("voiceCountProperty")
    set(`value`) {
      setVoiceCount(value)
    }

  /**
   * The volume ratio of the original audio. Value can range from 0 to 1.
   */
  public final inline var dry: Float
    @JvmName("dryProperty")
    get() = getDry()
    @JvmName("dryProperty")
    set(`value`) {
      setDry(value)
    }

  /**
   * The volume ratio of all voices. Value can range from 0 to 1.
   */
  public final inline var wet: Float
    @JvmName("wetProperty")
    get() = getWet()
    @JvmName("wetProperty")
    set(`value`) {
      setWet(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(51, scriptPtr)
  }

  public final fun setVoiceCount(voices: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voices.toLong())
    TransferContext.callMethod(MethodBindings.setVoiceCountPtr)
  }

  public final fun getVoiceCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVoiceCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the delay of a given [voiceIdx] in milliseconds, compared to the original audio. Value can
   * range from 0 to 50.
   */
  public final fun setVoiceDelayMs(voiceIdx: Int, delayMs: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, voiceIdx.toLong(), delayMs.toDouble())
    TransferContext.callMethod(MethodBindings.setVoiceDelayMsPtr)
  }

  /**
   * Returns the delay of a given [voiceIdx] in milliseconds, compared to the original audio.
   */
  public final fun getVoiceDelayMs(voiceIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voiceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getVoiceDelayMsPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the rate of a given [voiceIdx]'s low-frequency oscillator in Hz. Value can range from 0.1
   * to 20.
   */
  public final fun setVoiceRateHz(voiceIdx: Int, rateHz: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, voiceIdx.toLong(), rateHz.toDouble())
    TransferContext.callMethod(MethodBindings.setVoiceRateHzPtr)
  }

  /**
   * Returns the rate of a given [voiceIdx]'s low-frequency oscillator in Hz.
   */
  public final fun getVoiceRateHz(voiceIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voiceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getVoiceRateHzPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the depth of a given [voiceIdx]'s low-frequency oscillator in milliseconds. Value can
   * range from 0 to 20.
   */
  public final fun setVoiceDepthMs(voiceIdx: Int, depthMs: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, voiceIdx.toLong(), depthMs.toDouble())
    TransferContext.callMethod(MethodBindings.setVoiceDepthMsPtr)
  }

  /**
   * Returns the depth of a given [voiceIdx]'s low-frequency oscillator in milliseconds.
   */
  public final fun getVoiceDepthMs(voiceIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voiceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getVoiceDepthMsPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the gain of a given [voiceIdx] in dB. Value can range from -60 to 24.
   */
  public final fun setVoiceLevelDb(voiceIdx: Int, levelDb: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, voiceIdx.toLong(), levelDb.toDouble())
    TransferContext.callMethod(MethodBindings.setVoiceLevelDbPtr)
  }

  /**
   * Returns the gain of a given [voiceIdx] in dB.
   */
  public final fun getVoiceLevelDb(voiceIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voiceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getVoiceLevelDbPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the frequency threshold of a given [voiceIdx]'s low-pass filter in Hz. Frequencies above
   * [cutoffHz] are removed from [voiceIdx]. Value can range from 1 to 20500.
   */
  public final fun setVoiceCutoffHz(voiceIdx: Int, cutoffHz: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, voiceIdx.toLong(), cutoffHz.toDouble())
    TransferContext.callMethod(MethodBindings.setVoiceCutoffHzPtr)
  }

  /**
   * Returns the frequency threshold of a given [voiceIdx]'s low-pass filter in Hz. Frequencies
   * above this value are removed from the voice.
   */
  public final fun getVoiceCutoffHz(voiceIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voiceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getVoiceCutoffHzPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the pan position of a given [voiceIdx]. Negative values pan the sound to the left,
   * positive pan to the right. Value can range from -1 to 1.
   */
  public final fun setVoicePan(voiceIdx: Int, pan: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, voiceIdx.toLong(), pan.toDouble())
    TransferContext.callMethod(MethodBindings.setVoicePanPtr)
  }

  /**
   * Returns the pan position of a given [voiceIdx]. Negative values mean the left channel, positive
   * mean the right.
   */
  public final fun getVoicePan(voiceIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, voiceIdx.toLong())
    TransferContext.callMethod(MethodBindings.getVoicePanPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setWet(amount: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, amount.toDouble())
    TransferContext.callMethod(MethodBindings.setWetPtr)
  }

  public final fun getWet(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWetPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDry(amount: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, amount.toDouble())
    TransferContext.callMethod(MethodBindings.setDryPtr)
  }

  public final fun getDry(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDryPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectChorus::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setVoiceCountName: MethodStringName1<AudioEffectChorus, Unit, Int> =
        MethodStringName1<AudioEffectChorus, Unit, Int>("set_voice_count")

    @JvmField
    public val getVoiceCountName: MethodStringName0<AudioEffectChorus, Int> =
        MethodStringName0<AudioEffectChorus, Int>("get_voice_count")

    @JvmField
    public val setVoiceDelayMsName: MethodStringName2<AudioEffectChorus, Unit, Int, Float> =
        MethodStringName2<AudioEffectChorus, Unit, Int, Float>("set_voice_delay_ms")

    @JvmField
    public val getVoiceDelayMsName: MethodStringName1<AudioEffectChorus, Float, Int> =
        MethodStringName1<AudioEffectChorus, Float, Int>("get_voice_delay_ms")

    @JvmField
    public val setVoiceRateHzName: MethodStringName2<AudioEffectChorus, Unit, Int, Float> =
        MethodStringName2<AudioEffectChorus, Unit, Int, Float>("set_voice_rate_hz")

    @JvmField
    public val getVoiceRateHzName: MethodStringName1<AudioEffectChorus, Float, Int> =
        MethodStringName1<AudioEffectChorus, Float, Int>("get_voice_rate_hz")

    @JvmField
    public val setVoiceDepthMsName: MethodStringName2<AudioEffectChorus, Unit, Int, Float> =
        MethodStringName2<AudioEffectChorus, Unit, Int, Float>("set_voice_depth_ms")

    @JvmField
    public val getVoiceDepthMsName: MethodStringName1<AudioEffectChorus, Float, Int> =
        MethodStringName1<AudioEffectChorus, Float, Int>("get_voice_depth_ms")

    @JvmField
    public val setVoiceLevelDbName: MethodStringName2<AudioEffectChorus, Unit, Int, Float> =
        MethodStringName2<AudioEffectChorus, Unit, Int, Float>("set_voice_level_db")

    @JvmField
    public val getVoiceLevelDbName: MethodStringName1<AudioEffectChorus, Float, Int> =
        MethodStringName1<AudioEffectChorus, Float, Int>("get_voice_level_db")

    @JvmField
    public val setVoiceCutoffHzName: MethodStringName2<AudioEffectChorus, Unit, Int, Float> =
        MethodStringName2<AudioEffectChorus, Unit, Int, Float>("set_voice_cutoff_hz")

    @JvmField
    public val getVoiceCutoffHzName: MethodStringName1<AudioEffectChorus, Float, Int> =
        MethodStringName1<AudioEffectChorus, Float, Int>("get_voice_cutoff_hz")

    @JvmField
    public val setVoicePanName: MethodStringName2<AudioEffectChorus, Unit, Int, Float> =
        MethodStringName2<AudioEffectChorus, Unit, Int, Float>("set_voice_pan")

    @JvmField
    public val getVoicePanName: MethodStringName1<AudioEffectChorus, Float, Int> =
        MethodStringName1<AudioEffectChorus, Float, Int>("get_voice_pan")

    @JvmField
    public val setWetName: MethodStringName1<AudioEffectChorus, Unit, Float> =
        MethodStringName1<AudioEffectChorus, Unit, Float>("set_wet")

    @JvmField
    public val getWetName: MethodStringName0<AudioEffectChorus, Float> =
        MethodStringName0<AudioEffectChorus, Float>("get_wet")

    @JvmField
    public val setDryName: MethodStringName1<AudioEffectChorus, Unit, Float> =
        MethodStringName1<AudioEffectChorus, Unit, Float>("set_dry")

    @JvmField
    public val getDryName: MethodStringName0<AudioEffectChorus, Float> =
        MethodStringName0<AudioEffectChorus, Float>("get_dry")
  }

  public object MethodBindings {
    internal val setVoiceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_voice_count", 1286410249)

    internal val getVoiceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_voice_count", 3905245786)

    internal val setVoiceDelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_voice_delay_ms", 1602489585)

    internal val getVoiceDelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_voice_delay_ms", 2339986948)

    internal val setVoiceRateHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_voice_rate_hz", 1602489585)

    internal val getVoiceRateHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_voice_rate_hz", 2339986948)

    internal val setVoiceDepthMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_voice_depth_ms", 1602489585)

    internal val getVoiceDepthMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_voice_depth_ms", 2339986948)

    internal val setVoiceLevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_voice_level_db", 1602489585)

    internal val getVoiceLevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_voice_level_db", 2339986948)

    internal val setVoiceCutoffHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_voice_cutoff_hz", 1602489585)

    internal val getVoiceCutoffHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_voice_cutoff_hz", 2339986948)

    internal val setVoicePanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_voice_pan", 1602489585)

    internal val getVoicePanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_voice_pan", 2339986948)

    internal val setWetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_wet", 373806689)

    internal val getWetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_wet", 1740695150)

    internal val setDryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "set_dry", 373806689)

    internal val getDryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectChorus", "get_dry", 1740695150)
  }
}
