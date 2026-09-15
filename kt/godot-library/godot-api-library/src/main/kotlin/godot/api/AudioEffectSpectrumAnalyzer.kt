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
 * Calculates a Fourier Transform of the audio signal. This effect does not alter the audio. Can be
 * used for creating real-time audio visualizations, like a spectrogram.
 *
 * This resource configures an [AudioEffectSpectrumAnalyzerInstance], which performs the actual
 * analysis at runtime. An instance should be obtained with [AudioServer.getBusEffectInstance] to make
 * use of this effect.
 */
@GodotBaseType
public open class AudioEffectSpectrumAnalyzer : AudioEffect() {
  /**
   * The length of the buffer to keep, in seconds. Higher values keep data around for longer, but
   * require more memory. Value can range from 0.1 to 4.
   */
  public final inline var bufferLength: Float
    @JvmName("bufferLengthProperty")
    get() = getBufferLength()
    @JvmName("bufferLengthProperty")
    set(`value`) {
      setBufferLength(value)
    }

  /**
   * The size of the [url=https://en.wikipedia.org/wiki/Fast_Fourier_transform]Fast Fourier
   * transform[/url] buffer. Higher values smooth out the spectrum analysis over time, but have greater
   * latency. The effects of this higher latency are especially noticeable with sudden amplitude
   * changes.
   */
  public final inline var fftSize: FFTSize
    @JvmName("fftSizeProperty")
    get() = getFftSize()
    @JvmName("fftSizeProperty")
    set(`value`) {
      setFftSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(73, scriptPtr)
  }

  public final fun setBufferLength(seconds: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, seconds.toDouble())
    TransferContext.callMethod(MethodBindings.setBufferLengthPtr)
  }

  public final fun getBufferLength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBufferLengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setFftSize(size: FFTSize): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, size.value)
    TransferContext.callMethod(MethodBindings.setFftSizePtr)
  }

  public final fun getFftSize(): FFTSize {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFftSizePtr)
    return FFTSize.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectSpectrumAnalyzer::_instantiate can't be called from the JVM.")
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
    public val setBufferLengthName: MethodStringName1<AudioEffectSpectrumAnalyzer, Unit, Float> =
        MethodStringName1<AudioEffectSpectrumAnalyzer, Unit, Float>("set_buffer_length")

    @JvmField
    public val getBufferLengthName: MethodStringName0<AudioEffectSpectrumAnalyzer, Float> =
        MethodStringName0<AudioEffectSpectrumAnalyzer, Float>("get_buffer_length")

    @JvmField
    public val setFftSizeName: MethodStringName1<AudioEffectSpectrumAnalyzer, Unit, FFTSize> =
        MethodStringName1<AudioEffectSpectrumAnalyzer, Unit, FFTSize>("set_fft_size")

    @JvmField
    public val getFftSizeName: MethodStringName0<AudioEffectSpectrumAnalyzer, FFTSize> =
        MethodStringName0<AudioEffectSpectrumAnalyzer, FFTSize>("get_fft_size")
  }

  public object MethodBindings {
    internal val setBufferLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectSpectrumAnalyzer", "set_buffer_length", 373806689)

    internal val getBufferLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectSpectrumAnalyzer", "get_buffer_length", 1740695150)

    internal val setFftSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectSpectrumAnalyzer", "set_fft_size", 1202879215)

    internal val getFftSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectSpectrumAnalyzer", "get_fft_size", 3925405343)
  }
}
