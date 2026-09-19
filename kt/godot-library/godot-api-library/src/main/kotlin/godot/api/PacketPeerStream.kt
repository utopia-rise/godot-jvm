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
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * PacketStreamPeer provides a wrapper for working using packets over a stream. This allows for
 * using packet based code with StreamPeers. PacketPeerStream implements a custom protocol over the
 * StreamPeer, so the user should not read or write to the wrapped StreamPeer directly.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class PacketPeerStream : PacketPeer() {
  public final inline var inputBufferMaxSize: Int
    @JvmName("inputBufferMaxSizeProperty")
    get() = getInputBufferMaxSize()
    @JvmName("inputBufferMaxSizeProperty")
    set(`value`) {
      setInputBufferMaxSize(value)
    }

  public final inline var outputBufferMaxSize: Int
    @JvmName("outputBufferMaxSizeProperty")
    get() = getOutputBufferMaxSize()
    @JvmName("outputBufferMaxSizeProperty")
    set(`value`) {
      setOutputBufferMaxSize(value)
    }

  /**
   * The wrapped [StreamPeer] object.
   */
  public final inline var streamPeer: StreamPeer?
    @JvmName("streamPeerProperty")
    get() = getStreamPeer()
    @JvmName("streamPeerProperty")
    set(`value`) {
      setStreamPeer(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(505, scriptPtr)
  }

  public final fun setStreamPeer(peer: StreamPeer?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setStreamPeerPtr, peer)
  }

  public final fun getStreamPeer(): StreamPeer? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getStreamPeerPtr) as StreamPeer?)

  public final fun setInputBufferMaxSize(maxSizeBytes: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setInputBufferMaxSizePtr, maxSizeBytes.toLong())
  }

  public final fun setOutputBufferMaxSize(maxSizeBytes: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setOutputBufferMaxSizePtr, maxSizeBytes.toLong())
  }

  public final fun getInputBufferMaxSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getInputBufferMaxSizePtr).toInt()

  public final fun getOutputBufferMaxSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getOutputBufferMaxSizePtr).toInt()

  public companion object {
    @JvmField
    public val setStreamPeerName: MethodStringName1<PacketPeerStream, Unit, StreamPeer?> =
        MethodStringName1<PacketPeerStream, Unit, StreamPeer?>("set_stream_peer")

    @JvmField
    public val getStreamPeerName: MethodStringName0<PacketPeerStream, StreamPeer?> =
        MethodStringName0<PacketPeerStream, StreamPeer?>("get_stream_peer")

    @JvmField
    public val setInputBufferMaxSizeName: MethodStringName1<PacketPeerStream, Unit, Int> =
        MethodStringName1<PacketPeerStream, Unit, Int>("set_input_buffer_max_size")

    @JvmField
    public val setOutputBufferMaxSizeName: MethodStringName1<PacketPeerStream, Unit, Int> =
        MethodStringName1<PacketPeerStream, Unit, Int>("set_output_buffer_max_size")

    @JvmField
    public val getInputBufferMaxSizeName: MethodStringName0<PacketPeerStream, Int> =
        MethodStringName0<PacketPeerStream, Int>("get_input_buffer_max_size")

    @JvmField
    public val getOutputBufferMaxSizeName: MethodStringName0<PacketPeerStream, Int> =
        MethodStringName0<PacketPeerStream, Int>("get_output_buffer_max_size")
  }

  public object MethodBindings {
    internal val setStreamPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerStream", "set_stream_peer", 3281897016)

    internal val getStreamPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerStream", "get_stream_peer", 2741655269)

    internal val setInputBufferMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerStream", "set_input_buffer_max_size", 1286410249)

    internal val setOutputBufferMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerStream", "set_output_buffer_max_size", 1286410249)

    internal val getInputBufferMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerStream", "get_input_buffer_max_size", 3905245786)

    internal val getOutputBufferMaxSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerStream", "get_output_buffer_max_size", 3905245786)
  }
}
