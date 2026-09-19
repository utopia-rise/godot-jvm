// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_DOUBLE
import godot.callPtrMethod_LONG_OBJECT
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This is a stream that can be fitted with sub-streams, which will be played in-sync. The streams
 * begin at exactly the same time when play is pressed, and will end when the last of them ends. If one
 * of the sub-streams loops, then playback will continue.
 */
@GodotBaseType
public open class AudioStreamSynchronized : AudioStream() {
  /**
   * Set the total amount of streams that will be played back synchronized.
   */
  public final inline var streamCount: Int
    @JvmName("streamCountProperty")
    get() = getStreamCount()
    @JvmName("streamCountProperty")
    set(`value`) {
      setStreamCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(101, scriptPtr)
  }

  public final fun setStreamCount(streamCount: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setStreamCountPtr, streamCount.toLong())
  }

  public final fun getStreamCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStreamCountPtr).toInt()

  /**
   * Set one of the synchronized streams, by index.
   */
  public final fun setSyncStream(streamIndex: Int, audioStream: AudioStream?): Unit {
    TransferContext.callPtrMethod_LONG_OBJECT(ptr, objectID.id, MethodBindings.setSyncStreamPtr, streamIndex.toLong(), audioStream)
  }

  /**
   * Get one of the synchronized streams, by index.
   */
  public final fun getSyncStream(streamIndex: Int): AudioStream? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getSyncStreamPtr, streamIndex.toLong()) as AudioStream?)

  /**
   * Set the volume of one of the synchronized streams, by index.
   */
  public final fun setSyncStreamVolume(streamIndex: Int, volumeDb: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setSyncStreamVolumePtr, streamIndex.toLong(), volumeDb.toDouble())
  }

  /**
   * Get the volume of one of the synchronized streams, by index.
   */
  public final fun getSyncStreamVolume(streamIndex: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getSyncStreamVolumePtr, streamIndex.toLong()).toFloat()

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiatePlayback(): AudioStreamPlayback? {
    throw NotImplementedError("AudioStreamSynchronized::_instantiatePlayback can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setStreamCountName: MethodStringName1<AudioStreamSynchronized, Unit, Int> =
        MethodStringName1<AudioStreamSynchronized, Unit, Int>("set_stream_count")

    @JvmField
    public val getStreamCountName: MethodStringName0<AudioStreamSynchronized, Int> =
        MethodStringName0<AudioStreamSynchronized, Int>("get_stream_count")

    @JvmField
    public val setSyncStreamName:
        MethodStringName2<AudioStreamSynchronized, Unit, Int, AudioStream?> =
        MethodStringName2<AudioStreamSynchronized, Unit, Int, AudioStream?>("set_sync_stream")

    @JvmField
    public val getSyncStreamName: MethodStringName1<AudioStreamSynchronized, AudioStream?, Int> =
        MethodStringName1<AudioStreamSynchronized, AudioStream?, Int>("get_sync_stream")

    @JvmField
    public val setSyncStreamVolumeName: MethodStringName2<AudioStreamSynchronized, Unit, Int, Float>
        = MethodStringName2<AudioStreamSynchronized, Unit, Int, Float>("set_sync_stream_volume")

    @JvmField
    public val getSyncStreamVolumeName: MethodStringName1<AudioStreamSynchronized, Float, Int> =
        MethodStringName1<AudioStreamSynchronized, Float, Int>("get_sync_stream_volume")

    /**
     * Maximum amount of streams that can be synchronized.
     */
    public final const val MAX_STREAMS: Long = 32
  }

  public object MethodBindings {
    internal val setStreamCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamSynchronized", "set_stream_count", 1286410249)

    internal val getStreamCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamSynchronized", "get_stream_count", 3905245786)

    internal val setSyncStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamSynchronized", "set_sync_stream", 111075094)

    internal val getSyncStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamSynchronized", "get_sync_stream", 2739380747)

    internal val setSyncStreamVolumePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamSynchronized", "set_sync_stream_volume", 1602489585)

    internal val getSyncStreamVolumePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioStreamSynchronized", "get_sync_stream_volume", 2339986948)
  }
}
