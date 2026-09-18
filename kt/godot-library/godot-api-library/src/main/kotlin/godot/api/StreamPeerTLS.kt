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
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT_OBJECT
import godot.writeMethodArguments_OBJECT_STRING_OBJECT
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * A stream peer that handles TLS connections. This object can be used to connect to a TLS server or
 * accept a single TLS client connection.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class StreamPeerTLS : StreamPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(713, scriptPtr)
  }

  /**
   * Poll the connection to check for incoming bytes. Call this right before
   * [StreamPeer.getAvailableBytes] for it to work properly.
   */
  public final fun poll(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.pollPtr, 0)
  }

  /**
   * Accepts a peer connection as a server using the given [serverOptions]. See [TLSOptions.server].
   */
  public final fun acceptStream(stream: StreamPeer?, serverOptions: TLSOptions?): Error {
    TransferContext.writeMethodArguments_OBJECT_OBJECT(ptr, objectID.id, stream, serverOptions)
    TransferContext.callPtrMethod(MethodBindings.acceptStreamPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Connects to a peer using an underlying [StreamPeer] [stream] and verifying the remote
   * certificate is correctly signed for the given [commonName]. You can pass the optional
   * [clientOptions] parameter to customize the trusted certification authorities, or disable the
   * common name verification. See [TLSOptions.client] and [TLSOptions.clientUnsafe].
   */
  @JvmOverloads
  public final fun connectToStream(
    stream: StreamPeer?,
    commonName: String,
    clientOptions: TLSOptions? = null,
  ): Error {
    TransferContext.writeMethodArguments_OBJECT_STRING_OBJECT(ptr, objectID.id, stream, commonName, clientOptions)
    TransferContext.callMethod(MethodBindings.connectToStreamPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the status of the connection.
   */
  public final fun getStatus(): Status {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStatusPtr, 2)
    return Status.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the underlying [StreamPeer] connection, used in [acceptStream] or [connectToStream].
   */
  public final fun getStream(): StreamPeer? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStreamPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as StreamPeer?)
  }

  /**
   * Disconnects from host.
   */
  public final fun disconnectFromStream(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.disconnectFromStreamPtr, 0)
  }

  public enum class Status(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A status representing a [StreamPeerTLS] that is disconnected.
     */
    DISCONNECTED(0),
    /**
     * A status representing a [StreamPeerTLS] during handshaking.
     */
    HANDSHAKING(1),
    /**
     * A status representing a [StreamPeerTLS] that is connected to a host.
     */
    CONNECTED(2),
    /**
     * A status representing a [StreamPeerTLS] in error state.
     */
    ERROR(3),
    /**
     * An error status that shows a mismatch in the TLS certificate domain presented by the host and
     * the domain requested for validation.
     */
    ERROR_HOSTNAME_MISMATCH(4),
    ;

    public companion object {
      public fun from(`value`: Long): Status = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val pollName: MethodStringName0<StreamPeerTLS, Unit> =
        MethodStringName0<StreamPeerTLS, Unit>("poll")

    @JvmField
    public val acceptStreamName: MethodStringName2<StreamPeerTLS, Error, StreamPeer?, TLSOptions?> =
        MethodStringName2<StreamPeerTLS, Error, StreamPeer?, TLSOptions?>("accept_stream")

    @JvmField
    public val connectToStreamName:
        MethodStringName3<StreamPeerTLS, Error, StreamPeer?, String, TLSOptions?> =
        MethodStringName3<StreamPeerTLS, Error, StreamPeer?, String, TLSOptions?>("connect_to_stream")

    @JvmField
    public val getStatusName: MethodStringName0<StreamPeerTLS, Status> =
        MethodStringName0<StreamPeerTLS, Status>("get_status")

    @JvmField
    public val getStreamName: MethodStringName0<StreamPeerTLS, StreamPeer?> =
        MethodStringName0<StreamPeerTLS, StreamPeer?>("get_stream")

    @JvmField
    public val disconnectFromStreamName: MethodStringName0<StreamPeerTLS, Unit> =
        MethodStringName0<StreamPeerTLS, Unit>("disconnect_from_stream")
  }

  public object MethodBindings {
    internal val pollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTLS", "poll", 3218959716)

    internal val acceptStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTLS", "accept_stream", 4292689651)

    internal val connectToStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTLS", "connect_to_stream", 57169517)

    internal val getStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTLS", "get_status", 1128380576)

    internal val getStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTLS", "get_stream", 2741655269)

    internal val disconnectFromStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("StreamPeerTLS", "disconnect_from_stream", 3218959716)
  }
}
