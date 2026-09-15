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
import godot.core.PackedVector2Array
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.PACKED_VECTOR2_ARRAY
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Copies all audio frames, also known as "samples" or "audio samples", from the attached audio bus
 * into its internal ring buffer. This effect does not alter the audio. Can be used for storing
 * real-time audio data for playback, and for creating real-time audio visualizations, like an
 * oscilloscope.
 *
 * Application code should consume these audio frames from this ring buffer using [getBuffer] and
 * process it as needed, for example to capture data from an [AudioStreamMicrophone], implement
 * application-defined effects, or to transmit audio over the network. When capturing audio data from a
 * microphone, the format of the samples will be stereo 32-bit floating-point PCM.
 *
 * Unlike [AudioEffectRecord], this effect only returns the raw audio samples instead of encoding
 * them into an [AudioStream].
 */
@GodotBaseType
public open class AudioEffectCapture : AudioEffect() {
  /**
   * Length of the internal ring buffer, in seconds. Higher values keep data around for longer, but
   * require more memory. Value can range from 0.01 to 10.
   *
   * **Note:** Setting the buffer length will have no effect if already initialized.
   */
  public final inline var bufferLength: Float
    @JvmName("bufferLengthProperty")
    get() = getBufferLength()
    @JvmName("bufferLengthProperty")
    set(`value`) {
      setBufferLength(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(50, scriptPtr)
  }

  /**
   * Returns `true` if at least [frames] samples are available to read in the internal ring buffer.
   */
  public final fun canGetBuffer(frames: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frames.toLong())
    TransferContext.callMethod(MethodBindings.canGetBufferPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Gets the next [frames] samples from the internal ring buffer.
   *
   * Returns a [PackedVector2Array] containing exactly [frames] samples if available, or an empty
   * [PackedVector2Array] if insufficient data was available.
   *
   * The samples are signed floating-point PCM between `-1` and `1`. You will have to scale them if
   * you want to use them as 8 or 16-bit integer samples. (`v = 0x7fff * samples[0].x`)
   */
  public final fun getBuffer(frames: Int): PackedVector2Array {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frames.toLong())
    TransferContext.callMethod(MethodBindings.getBufferPtr)
    return (TransferContext.readReturnValue(PACKED_VECTOR2_ARRAY) as PackedVector2Array)
  }

  /**
   * Clears the internal ring buffer.
   *
   * **Note:** Calling this during a capture can cause the loss of samples which causes popping in
   * the playback.
   */
  public final fun clearBuffer(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearBufferPtr)
  }

  public final fun setBufferLength(bufferLengthSeconds: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to bufferLengthSeconds.toDouble())
    TransferContext.callMethod(MethodBindings.setBufferLengthPtr)
  }

  public final fun getBufferLength(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBufferLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the number of samples available to read using [getBuffer].
   */
  public final fun getFramesAvailable(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFramesAvailablePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of samples discarded from the audio bus due to full buffer.
   */
  public final fun getDiscardedFrames(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDiscardedFramesPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the total size of the internal ring buffer in number of samples.
   */
  public final fun getBufferLengthFrames(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBufferLengthFramesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of samples inserted from the audio bus.
   */
  public final fun getPushedFrames(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPushedFramesPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectCapture::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val canGetBufferName: MethodStringName1<AudioEffectCapture, Boolean, Int> =
        MethodStringName1<AudioEffectCapture, Boolean, Int>("can_get_buffer")

    @JvmField
    public val getBufferName: MethodStringName1<AudioEffectCapture, PackedVector2Array, Int> =
        MethodStringName1<AudioEffectCapture, PackedVector2Array, Int>("get_buffer")

    @JvmField
    public val clearBufferName: MethodStringName0<AudioEffectCapture, Unit> =
        MethodStringName0<AudioEffectCapture, Unit>("clear_buffer")

    @JvmField
    public val setBufferLengthName: MethodStringName1<AudioEffectCapture, Unit, Float> =
        MethodStringName1<AudioEffectCapture, Unit, Float>("set_buffer_length")

    @JvmField
    public val getBufferLengthName: MethodStringName0<AudioEffectCapture, Float> =
        MethodStringName0<AudioEffectCapture, Float>("get_buffer_length")

    @JvmField
    public val getFramesAvailableName: MethodStringName0<AudioEffectCapture, Int> =
        MethodStringName0<AudioEffectCapture, Int>("get_frames_available")

    @JvmField
    public val getDiscardedFramesName: MethodStringName0<AudioEffectCapture, Long> =
        MethodStringName0<AudioEffectCapture, Long>("get_discarded_frames")

    @JvmField
    public val getBufferLengthFramesName: MethodStringName0<AudioEffectCapture, Int> =
        MethodStringName0<AudioEffectCapture, Int>("get_buffer_length_frames")

    @JvmField
    public val getPushedFramesName: MethodStringName0<AudioEffectCapture, Long> =
        MethodStringName0<AudioEffectCapture, Long>("get_pushed_frames")
  }

  public object MethodBindings {
    internal val canGetBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "can_get_buffer", 1116898809)

    internal val getBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "get_buffer", 2649534757)

    internal val clearBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "clear_buffer", 3218959716)

    internal val setBufferLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "set_buffer_length", 373806689)

    internal val getBufferLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "get_buffer_length", 191475506)

    internal val getFramesAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "get_frames_available", 3905245786)

    internal val getDiscardedFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "get_discarded_frames", 3905245786)

    internal val getBufferLengthFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "get_buffer_length_frames", 3905245786)

    internal val getPushedFramesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectCapture", "get_pushed_frames", 3905245786)
  }
}
