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
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Int
import kotlin.Long
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
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to peer)
    TransferContext.callMethod(MethodBindings.setStreamPeerPtr)
  }

  public final fun getStreamPeer(): StreamPeer? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStreamPeerPtr)
    return (TransferContext.readReturnValue(OBJECT) as StreamPeer?)
  }

  public final fun setInputBufferMaxSize(maxSizeBytes: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxSizeBytes.toLong())
    TransferContext.callMethod(MethodBindings.setInputBufferMaxSizePtr)
  }

  public final fun setOutputBufferMaxSize(maxSizeBytes: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxSizeBytes.toLong())
    TransferContext.callMethod(MethodBindings.setOutputBufferMaxSizePtr)
  }

  public final fun getInputBufferMaxSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInputBufferMaxSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getOutputBufferMaxSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutputBufferMaxSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

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
