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
import godot.core.MethodStringName2
import godot.core.Signal1
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Manages the connection with one or more remote peers acting as server or client and assigning
 * unique IDs to each of them. See also [MultiplayerAPI].
 *
 * **Note:** The [MultiplayerAPI] protocol is an implementation detail and isn't meant to be used by
 * non-Godot servers. It may change without notice.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class MultiplayerPeer internal constructor() : PacketPeer() {
  /**
   * Emitted when a remote peer connects.
   */
  public val peerConnected: Signal1<Long> by Signal1

  /**
   * Emitted when a remote peer has disconnected.
   */
  public val peerDisconnected: Signal1<Long> by Signal1

  /**
   * If `true`, this [MultiplayerPeer] refuses new connections.
   */
  public final inline var refuseNewConnections: Boolean
    @JvmName("refuseNewConnectionsProperty")
    get() = isRefusingNewConnections()
    @JvmName("refuseNewConnectionsProperty")
    set(`value`) {
      setRefuseNewConnections(value)
    }

  /**
   * The manner in which to send packets to the target peer. See the [setTargetPeer] method.
   */
  public final inline var transferMode: TransferMode
    @JvmName("transferModeProperty")
    get() = getTransferMode()
    @JvmName("transferModeProperty")
    set(`value`) {
      setTransferMode(value)
    }

  /**
   * The channel to use to send packets. Many network APIs such as ENet and WebRTC allow the
   * creation of multiple independent channels which behaves, in a way, like separate connections. This
   * means that reliable data will only block delivery of other packets on that channel, and ordering
   * will only be in respect to the channel the packet is being sent on. Using different channels to
   * send **different and independent** state updates is a common way to optimize network usage and
   * decrease latency in fast-paced games.
   *
   * **Note:** The default channel (`0`) actually works as 3 separate channels (one for each
   * [TransferMode]) so that [TRANSFER_MODE_RELIABLE] and [TRANSFER_MODE_UNRELIABLE_ORDERED] does not
   * interact with each other by default. Refer to the specific network API documentation (e.g. ENet or
   * WebRTC) to learn how to set up channels correctly.
   */
  public final inline var transferChannel: Int
    @JvmName("transferChannelProperty")
    get() = getTransferChannel()
    @JvmName("transferChannelProperty")
    set(`value`) {
      setTransferChannel(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(391, scriptPtr)
  }

  public final fun setTransferChannel(channel: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, channel.toLong())
    TransferContext.callPtrMethod(MethodBindings.setTransferChannelPtr, 0)
  }

  public final fun getTransferChannel(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTransferChannelPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setTransferMode(mode: TransferMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callPtrMethod(MethodBindings.setTransferModePtr, 0)
  }

  public final fun getTransferMode(): TransferMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTransferModePtr, 2)
    return TransferMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the peer to which packets will be sent.
   *
   * The [id] can be one of: [TARGET_PEER_BROADCAST] to send to all connected peers,
   * [TARGET_PEER_SERVER] to send to the peer acting as server, a valid peer ID to send to that
   * specific peer, a negative peer ID to send to all peers except that one. By default, the target
   * peer is [TARGET_PEER_BROADCAST].
   */
  public final fun setTargetPeer(id: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callPtrMethod(MethodBindings.setTargetPeerPtr, 0)
  }

  /**
   * Returns the ID of the [MultiplayerPeer] who sent the next available packet. See
   * [PacketPeer.getAvailablePacketCount].
   */
  public final fun getPacketPeer(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPacketPeerPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the channel over which the next available packet was received. See
   * [PacketPeer.getAvailablePacketCount].
   */
  public final fun getPacketChannel(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPacketChannelPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the transfer mode the remote peer used to send the next available packet. See
   * [PacketPeer.getAvailablePacketCount].
   */
  public final fun getPacketMode(): TransferMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPacketModePtr, 2)
    return TransferMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Waits up to 1 second to receive a new network event.
   */
  public final fun poll(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.pollPtr, 0)
  }

  /**
   * Immediately close the multiplayer peer returning to the state [CONNECTION_DISCONNECTED].
   * Connected peers will be dropped without emitting [signal peer_disconnected].
   */
  public final fun close(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.closePtr, 0)
  }

  /**
   * Disconnects the given [peer] from this host. If [force] is `true` the [signal
   * peer_disconnected] signal will not be emitted for this peer.
   */
  @JvmOverloads
  public final fun disconnectPeer(peer: Int, force: Boolean = false): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, peer.toLong(), force)
    TransferContext.callPtrMethod(MethodBindings.disconnectPeerPtr, 0)
  }

  /**
   * Returns the current state of the connection.
   */
  public final fun getConnectionStatus(): ConnectionStatus {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getConnectionStatusPtr, 2)
    return ConnectionStatus.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the ID of this [MultiplayerPeer].
   */
  public final fun getUniqueId(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUniqueIdPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns a randomly generated integer that can be used as a network unique ID.
   */
  public final fun generateUniqueId(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.generateUniqueIdPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setRefuseNewConnections(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setRefuseNewConnectionsPtr, 0)
  }

  public final fun isRefusingNewConnections(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isRefusingNewConnectionsPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the server can act as a relay in the current configuration. That is, if the
   * higher level [MultiplayerAPI] should notify connected clients of other peers, and implement a
   * relay protocol to allow communication between them.
   */
  public final fun isServerRelaySupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isServerRelaySupportedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class ConnectionStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The MultiplayerPeer is disconnected.
     */
    DISCONNECTED(0),
    /**
     * The MultiplayerPeer is currently connecting to a server.
     */
    CONNECTING(1),
    /**
     * This MultiplayerPeer is connected.
     */
    CONNECTED(2),
    ;

    public companion object {
      public fun from(`value`: Long): ConnectionStatus = entries.single { it.`value` == `value` }
    }
  }

  public enum class TransferMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Packets are not acknowledged, no resend attempts are made for lost packets. Packets may
     * arrive in any order. Potentially faster than [TRANSFER_MODE_UNRELIABLE_ORDERED]. Use for
     * non-critical data, and always consider whether the order matters.
     */
    UNRELIABLE(0),
    /**
     * Packets are not acknowledged, no resend attempts are made for lost packets. Packets are
     * received in the order they were sent in. Potentially faster than [TRANSFER_MODE_RELIABLE]. Use
     * for non-critical data or data that would be outdated if received late due to resend attempt(s)
     * anyway, for example movement and positional data.
     */
    UNRELIABLE_ORDERED(1),
    /**
     * Packets must be received and resend attempts should be made until the packets are
     * acknowledged. Packets must be received in the order they were sent in. Most reliable transfer
     * mode, but potentially the slowest due to the overhead. Use for critical data that must be
     * transmitted and arrive in order, for example an ability being triggered or a chat message.
     * Consider carefully if the information really is critical, and use sparingly.
     */
    RELIABLE(2),
    ;

    public companion object {
      public fun from(`value`: Long): TransferMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTransferChannelName: MethodStringName1<MultiplayerPeer, Unit, Int> =
        MethodStringName1<MultiplayerPeer, Unit, Int>("set_transfer_channel")

    @JvmField
    public val getTransferChannelName: MethodStringName0<MultiplayerPeer, Int> =
        MethodStringName0<MultiplayerPeer, Int>("get_transfer_channel")

    @JvmField
    public val setTransferModeName: MethodStringName1<MultiplayerPeer, Unit, TransferMode> =
        MethodStringName1<MultiplayerPeer, Unit, TransferMode>("set_transfer_mode")

    @JvmField
    public val getTransferModeName: MethodStringName0<MultiplayerPeer, TransferMode> =
        MethodStringName0<MultiplayerPeer, TransferMode>("get_transfer_mode")

    @JvmField
    public val setTargetPeerName: MethodStringName1<MultiplayerPeer, Unit, Int> =
        MethodStringName1<MultiplayerPeer, Unit, Int>("set_target_peer")

    @JvmField
    public val getPacketPeerName: MethodStringName0<MultiplayerPeer, Int> =
        MethodStringName0<MultiplayerPeer, Int>("get_packet_peer")

    @JvmField
    public val getPacketChannelName: MethodStringName0<MultiplayerPeer, Int> =
        MethodStringName0<MultiplayerPeer, Int>("get_packet_channel")

    @JvmField
    public val getPacketModeName: MethodStringName0<MultiplayerPeer, TransferMode> =
        MethodStringName0<MultiplayerPeer, TransferMode>("get_packet_mode")

    @JvmField
    public val pollName: MethodStringName0<MultiplayerPeer, Unit> =
        MethodStringName0<MultiplayerPeer, Unit>("poll")

    @JvmField
    public val closeName: MethodStringName0<MultiplayerPeer, Unit> =
        MethodStringName0<MultiplayerPeer, Unit>("close")

    @JvmField
    public val disconnectPeerName: MethodStringName2<MultiplayerPeer, Unit, Int, Boolean> =
        MethodStringName2<MultiplayerPeer, Unit, Int, Boolean>("disconnect_peer")

    @JvmField
    public val getConnectionStatusName: MethodStringName0<MultiplayerPeer, ConnectionStatus> =
        MethodStringName0<MultiplayerPeer, ConnectionStatus>("get_connection_status")

    @JvmField
    public val getUniqueIdName: MethodStringName0<MultiplayerPeer, Int> =
        MethodStringName0<MultiplayerPeer, Int>("get_unique_id")

    @JvmField
    public val generateUniqueIdName: MethodStringName0<MultiplayerPeer, Long> =
        MethodStringName0<MultiplayerPeer, Long>("generate_unique_id")

    @JvmField
    public val setRefuseNewConnectionsName: MethodStringName1<MultiplayerPeer, Unit, Boolean> =
        MethodStringName1<MultiplayerPeer, Unit, Boolean>("set_refuse_new_connections")

    @JvmField
    public val isRefusingNewConnectionsName: MethodStringName0<MultiplayerPeer, Boolean> =
        MethodStringName0<MultiplayerPeer, Boolean>("is_refusing_new_connections")

    @JvmField
    public val isServerRelaySupportedName: MethodStringName0<MultiplayerPeer, Boolean> =
        MethodStringName0<MultiplayerPeer, Boolean>("is_server_relay_supported")

    /**
     * Packets are sent to all connected peers.
     */
    public final const val TARGET_PEER_BROADCAST: Long = 0

    /**
     * Packets are sent to the remote peer acting as server.
     */
    public final const val TARGET_PEER_SERVER: Long = 1
  }

  public object MethodBindings {
    internal val setTransferChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "set_transfer_channel", 1286410249)

    internal val getTransferChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "get_transfer_channel", 3905245786)

    internal val setTransferModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "set_transfer_mode", 950411049)

    internal val getTransferModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "get_transfer_mode", 3369852622)

    internal val setTargetPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "set_target_peer", 1286410249)

    internal val getPacketPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "get_packet_peer", 3905245786)

    internal val getPacketChannelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "get_packet_channel", 3905245786)

    internal val getPacketModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "get_packet_mode", 3369852622)

    internal val pollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "poll", 3218959716)

    internal val closePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "close", 3218959716)

    internal val disconnectPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "disconnect_peer", 4023243586)

    internal val getConnectionStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "get_connection_status", 2147374275)

    internal val getUniqueIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "get_unique_id", 3905245786)

    internal val generateUniqueIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "generate_unique_id", 3905245786)

    internal val setRefuseNewConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "set_refuse_new_connections", 2586408642)

    internal val isRefusingNewConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "is_refusing_new_connections", 36873697)

    internal val isServerRelaySupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerPeer", "is_server_relay_supported", 36873697)
  }
}
