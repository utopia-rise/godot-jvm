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
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Allows modulation of pitch without modifying speed. All frequencies can be raised or lowered with
 * minimal effect on transients.
 */
@GodotBaseType
public open class AudioEffectPitchShift : AudioEffect() {
  /**
   * The pitch scale to use. `1.0` is the default pitch and plays sounds unaffected. [pitchScale]
   * can range from 0 (infinitely low pitch, inaudible) to 16 (16 times higher than the initial pitch).
   */
  public final inline var pitchScale: Float
    @JvmName("pitchScaleProperty")
    get() = getPitchScale()
    @JvmName("pitchScaleProperty")
    set(`value`) {
      setPitchScale(value)
    }

  /**
   * The oversampling factor to use. Higher values result in better quality, but are more demanding
   * on the CPU and may cause audio cracking if the CPU can't keep up.
   */
  public final inline var oversampling: Int
    @JvmName("oversamplingProperty")
    get() = getOversampling()
    @JvmName("oversamplingProperty")
    set(`value`) {
      setOversampling(value)
    }

  /**
   * The size of the [url=https://en.wikipedia.org/wiki/Fast_Fourier_transform]Fast Fourier
   * transform[/url] buffer. Higher values smooth out the effect over time, but have greater latency.
   * The effects of this higher latency are especially noticeable on audio signals that have sudden
   * amplitude changes.
   */
  public final inline var fftSize: FFTSize
    @JvmName("fftSizeProperty")
    get() = getFftSize()
    @JvmName("fftSizeProperty")
    set(`value`) {
      setFftSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(70, scriptPtr)
  }

  public final fun setPitchScale(rate: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, rate.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPitchScalePtr, 0)
  }

  public final fun getPitchScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPitchScalePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setOversampling(amount: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, amount.toLong())
    TransferContext.callPtrMethod(MethodBindings.setOversamplingPtr, 0)
  }

  public final fun getOversampling(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOversamplingPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setFftSize(size: FFTSize): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, size.value)
    TransferContext.callPtrMethod(MethodBindings.setFftSizePtr, 0)
  }

  public final fun getFftSize(): FFTSize {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFftSizePtr, 2)
    return FFTSize.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectPitchShift::_instantiate can't be called from the JVM.")
  }

  public enum class FFTSize(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use a buffer of 256 samples for the Fast Fourier transform. Lowest latency, but least stable
     * over time.
     */
    FFT_SIZE_256(0),
    /**
     * Use a buffer of 512 samples for the Fast Fourier transform. Low latency, but less stable over
     * time.
     */
    FFT_SIZE_512(1),
    /**
     * Use a buffer of 1024 samples for the Fast Fourier transform. This is a compromise between
     * latency and stability over time.
     */
    FFT_SIZE_1024(2),
    /**
     * Use a buffer of 2048 samples for the Fast Fourier transform. High latency, but stable over
     * time.
     */
    FFT_SIZE_2048(3),
    /**
     * Use a buffer of 4096 samples for the Fast Fourier transform. Highest latency, but most stable
     * over time.
     */
    FFT_SIZE_4096(4),
    /**
     * Represents the size of the [FFTSize] enum.
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): FFTSize = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setPitchScaleName: MethodStringName1<AudioEffectPitchShift, Unit, Float> =
        MethodStringName1<AudioEffectPitchShift, Unit, Float>("set_pitch_scale")

    @JvmField
    public val getPitchScaleName: MethodStringName0<AudioEffectPitchShift, Float> =
        MethodStringName0<AudioEffectPitchShift, Float>("get_pitch_scale")

    @JvmField
    public val setOversamplingName: MethodStringName1<AudioEffectPitchShift, Unit, Int> =
        MethodStringName1<AudioEffectPitchShift, Unit, Int>("set_oversampling")

    @JvmField
    public val getOversamplingName: MethodStringName0<AudioEffectPitchShift, Int> =
        MethodStringName0<AudioEffectPitchShift, Int>("get_oversampling")

    @JvmField
    public val setFftSizeName: MethodStringName1<AudioEffectPitchShift, Unit, FFTSize> =
        MethodStringName1<AudioEffectPitchShift, Unit, FFTSize>("set_fft_size")

    @JvmField
    public val getFftSizeName: MethodStringName0<AudioEffectPitchShift, FFTSize> =
        MethodStringName0<AudioEffectPitchShift, FFTSize>("get_fft_size")
  }

  public object MethodBindings {
    internal val setPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPitchShift", "set_pitch_scale", 373806689)

    internal val getPitchScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPitchShift", "get_pitch_scale", 1740695150)

    internal val setOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPitchShift", "set_oversampling", 1286410249)

    internal val getOversamplingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPitchShift", "get_oversampling", 3905245786)

    internal val setFftSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPitchShift", "set_fft_size", 2323518741)

    internal val getFftSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPitchShift", "get_fft_size", 2361246789)
  }
}
