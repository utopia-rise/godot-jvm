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
import godot.core.Vector2
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_PACKED_VECTOR2_ARRAY
import godot.writeMethodArguments_VECTOR2
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This class is meant to be used with [AudioStreamGenerator] to play back the generated audio in
 * real-time.
 */
@GodotBaseType
public open class AudioStreamGeneratorPlayback internal constructor() :
    AudioStreamPlaybackResampled() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(83, scriptPtr)
  }

  /**
   * Pushes a single audio data frame to the buffer. This is usually less efficient than
   * [pushBuffer] in C# and compiled languages via GDExtension, but [pushFrame] may be *more* efficient
   * in GDScript.
   */
  public final fun pushFrame(frame: Vector2): Boolean {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, frame)
    TransferContext.callPtrMethod(MethodBindings.pushFramePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if a buffer of the size [amount] can be pushed to the audio sample data buffer
   * without overflowing it, `false` otherwise.
   */
  public final fun canPushBuffer(amount: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, amount.toLong())
    TransferContext.callPtrMethod(MethodBindings.canPushBufferPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Pushes several audio data frames to the buffer. This is usually more efficient than [pushFrame]
   * in C# and compiled languages via GDExtension, but [pushBuffer] may be *less* efficient in
   * GDScript.
   */
  public final fun pushBuffer(frames: PackedVector2Array): Boolean {
    TransferContext.writeMethodArguments_PACKED_VECTOR2_ARRAY(ptr, objectID.id, frames)
    TransferContext.callPtrMethod(MethodBindings.pushBufferPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the number of frames that can be pushed to the audio sample data buffer without
   * overflowing it. If the result is `0`, the buffer is full.
   */
  public final fun getFramesAvailable(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFramesAvailablePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the number of times the playback skipped due to a buffer underrun in the audio sample
   * data. This value is reset at the start of the playback.
   */
  public final fun getSkips(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSkipsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Clears the audio sample data buffer.
   */
  public final fun clearBuffer(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.clearBufferPtr, 0)
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _getStreamSamplingRate(): Float {
    throw NotImplementedError("AudioStreamGeneratorPlayback::_getStreamSamplingRate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val pushFrameName: MethodStringName1<AudioStreamGeneratorPlayback, Boolean, Vector2> =
        MethodStringName1<AudioStreamGeneratorPlayback, Boolean, Vector2>("push_frame")

    @JvmField
    public val canPushBufferName: MethodStringName1<AudioStreamGeneratorPlayback, Boolean, Int> =
        MethodStringName1<AudioStreamGeneratorPlayback, Boolean, Int>("can_push_buffer")

    @JvmField
    public val pushBufferName:
        MethodStringName1<AudioStreamGeneratorPlayback, Boolean, PackedVector2Array> =
        MethodStringName1<AudioStreamGeneratorPlayback, Boolean, PackedVector2Array>("push_buffer")

    @JvmField
    public val getFramesAvailableName: MethodStringName0<AudioStreamGeneratorPlayback, Int> =
        MethodStringName0<AudioStreamGeneratorPlayback, Int>("get_frames_available")

    @JvmField
    public val getSkipsName: MethodStringName0<AudioStreamGeneratorPlayback, Int> =
        MethodStringName0<AudioStreamGeneratorPlayback, Int>("get_skips")

    @JvmField
    public val clearBufferName: MethodStringName0<AudioStreamGeneratorPlayback, Unit> =
        MethodStringName0<AudioStreamGeneratorPlayback, Unit>("clear_buffer")
  }

  public object MethodBindings {
    internal val pushFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamGeneratorPlayback", "push_frame", 3975407249)

    internal val canPushBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamGeneratorPlayback", "can_push_buffer", 1116898809)

    internal val pushBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamGeneratorPlayback", "push_buffer", 1361156557)

    internal val getFramesAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamGeneratorPlayback", "get_frames_available", 3905245786)

    internal val getSkipsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamGeneratorPlayback", "get_skips", 3905245786)

    internal val clearBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamGeneratorPlayback", "clear_buffer", 3218959716)
  }
}
