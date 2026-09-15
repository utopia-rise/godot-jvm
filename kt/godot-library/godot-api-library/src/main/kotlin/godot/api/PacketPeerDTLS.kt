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
import godot.core.MethodStringName3
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class represents a DTLS peer connection. It can be used to connect to a DTLS server, and is
 * returned by [DTLSServer.takeConnection].
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 *
 * **Warning:** TLS certificate revocation and certificate pinning are currently not supported.
 * Revoked certificates are accepted as long as they are otherwise valid. If this is a concern, you may
 * want to use automatically managed certificates with a short validity period.
 */
@GodotBaseType
public open class PacketPeerDTLS : PacketPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(503, scriptPtr)
  }

  /**
   * Poll the connection to check for incoming packets. Call this frequently to update the status
   * and keep the connection working.
   */
  public final fun poll(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.pollPtr)
  }

  /**
   * Connects a [packetPeer] beginning the DTLS handshake using the underlying [PacketPeerUDP] which
   * must be connected (see [PacketPeerUDP.connectToHost]). You can optionally specify the
   * [clientOptions] to be used while verifying the TLS connections. See [TLSOptions.client] and
   * [TLSOptions.clientUnsafe].
   */
  @JvmOverloads
  public final fun connectToPeer(
    packetPeer: PacketPeerUDP?,
    hostname: String,
    clientOptions: TLSOptions? = null,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to packetPeer, STRING to hostname, OBJECT to clientOptions)
    TransferContext.callMethod(MethodBindings.connectToPeerPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the status of the connection.
   */
  public final fun getStatus(): Status {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getStatusPtr)
    return Status.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Disconnects this peer, terminating the DTLS session.
   */
  public final fun disconnectFromPeer(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.disconnectFromPeerPtr)
  }

  public enum class Status(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * A status representing a [PacketPeerDTLS] that is disconnected.
     */
    DISCONNECTED(0),
    /**
     * A status representing a [PacketPeerDTLS] that is currently performing the handshake with a
     * remote peer.
     */
    HANDSHAKING(1),
    /**
     * A status representing a [PacketPeerDTLS] that is connected to a remote peer.
     */
    CONNECTED(2),
    /**
     * A status representing a [PacketPeerDTLS] in a generic error state.
     */
    ERROR(3),
    /**
     * An error status that shows a mismatch in the DTLS certificate domain presented by the host
     * and the domain requested for validation.
     */
    ERROR_HOSTNAME_MISMATCH(4),
    ;

    public companion object {
      public fun from(`value`: Long): Status = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val pollName: MethodStringName0<PacketPeerDTLS, Unit> =
        MethodStringName0<PacketPeerDTLS, Unit>("poll")

    @JvmField
    public val connectToPeerName:
        MethodStringName3<PacketPeerDTLS, Error, PacketPeerUDP?, String, TLSOptions?> =
        MethodStringName3<PacketPeerDTLS, Error, PacketPeerUDP?, String, TLSOptions?>("connect_to_peer")

    @JvmField
    public val getStatusName: MethodStringName0<PacketPeerDTLS, Status> =
        MethodStringName0<PacketPeerDTLS, Status>("get_status")

    @JvmField
    public val disconnectFromPeerName: MethodStringName0<PacketPeerDTLS, Unit> =
        MethodStringName0<PacketPeerDTLS, Unit>("disconnect_from_peer")
  }

  public object MethodBindings {
    internal val pollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerDTLS", "poll", 3218959716)

    internal val connectToPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerDTLS", "connect_to_peer", 2880188099)

    internal val getStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerDTLS", "get_status", 3248654679)

    internal val disconnectFromPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PacketPeerDTLS", "disconnect_from_peer", 3218959716)
  }
}
