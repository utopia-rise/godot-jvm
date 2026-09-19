// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_CALLABLE
import godot.callMethod_CALLABLE
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod0_ret_PACKED_INT_32_ARRAY
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_PACKED_BYTE_ARRAY_ret_LONG
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_NODE_PATH
import godot.callPtrMethod_PACKED_BYTE_ARRAY_LONG_LONG_LONG_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.PackedByteArray
import godot.core.PackedInt32Array
import godot.core.Signal1
import godot.core.Signal2
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * This class is the default implementation of [MultiplayerAPI], used to provide multiplayer
 * functionalities in Godot Engine.
 *
 * This implementation supports RPCs via [Node.rpc] and [Node.rpcId] and requires
 * [MultiplayerAPI.rpc] to be passed a [Node] (it will fail for other object types).
 *
 * This implementation additionally provide [SceneTree] replication via the [MultiplayerSpawner] and
 * [MultiplayerSynchronizer] nodes, and the [SceneReplicationConfig] resource.
 *
 * **Note:** The high-level multiplayer API protocol is an implementation detail and isn't meant to
 * be used by non-Godot servers. It may change without notice.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class SceneMultiplayer : MultiplayerAPI() {
  /**
   * Emitted when this MultiplayerAPI's [MultiplayerAPI.multiplayerPeer] connects to a new peer and
   * a valid [authCallback] is set. In this case, the [signal MultiplayerAPI.peer_connected] will not
   * be emitted until [completeAuth] is called with given peer [id]. While in this state, the peer will
   * not be included in the list returned by [MultiplayerAPI.getPeers] (but in the one returned by
   * [getAuthenticatingPeers]), and only authentication data will be sent or received. See [sendAuth]
   * for sending authentication data.
   */
  public val peerAuthenticating: Signal1<Long> by Signal1

  /**
   * Emitted when this MultiplayerAPI's [MultiplayerAPI.multiplayerPeer] disconnects from a peer for
   * which authentication had not yet completed. See [signal peer_authenticating].
   */
  public val peerAuthenticationFailed: Signal1<Long> by Signal1

  /**
   * Emitted when this MultiplayerAPI's [MultiplayerAPI.multiplayerPeer] receives a [packet] with
   * custom data (see [sendBytes]). ID is the peer ID of the peer that sent the packet.
   */
  public val peerPacket: Signal2<Long, PackedByteArray> by Signal2

  /**
   * The root path to use for RPCs and replication. Instead of an absolute path, a relative path
   * will be used to find the node upon which the RPC should be executed.
   *
   * This effectively allows to have different branches of the scene tree to be managed by different
   * MultiplayerAPI, allowing for example to run both client and server in the same scene.
   */
  public final inline var rootPath: NodePath
    @JvmName("rootPathProperty")
    get() = getRootPath()
    @JvmName("rootPathProperty")
    set(`value`) {
      setRootPath(value)
    }

  /**
   * The callback to execute when receiving authentication data sent via [sendAuth]. If the
   * [Callable] is empty (default), peers will be automatically accepted as soon as they connect.
   */
  public final inline var authCallback: Callable
    @JvmName("authCallbackProperty")
    get() = getAuthCallback()
    @JvmName("authCallbackProperty")
    set(`value`) {
      setAuthCallback(value)
    }

  /**
   * If set to a value greater than `0.0`, the maximum duration in seconds peers can stay in the
   * authenticating state, after which the authentication will automatically fail. See the [signal
   * peer_authenticating] and [signal peer_authentication_failed] signals.
   */
  public final inline var authTimeout: Double
    @JvmName("authTimeoutProperty")
    get() = getAuthTimeout()
    @JvmName("authTimeoutProperty")
    set(`value`) {
      setAuthTimeout(value)
    }

  /**
   * If `true`, the MultiplayerAPI will allow encoding and decoding of object during RPCs.
   *
   * **Warning:** Deserialized objects can contain code which gets executed. Do not use this option
   * if the serialized object comes from untrusted sources to avoid potential security threat such as
   * remote code execution.
   */
  public final inline var allowObjectDecoding: Boolean
    @JvmName("allowObjectDecodingProperty")
    get() = isObjectDecodingAllowed()
    @JvmName("allowObjectDecodingProperty")
    set(`value`) {
      setAllowObjectDecoding(value)
    }

  /**
   * If `true`, the MultiplayerAPI's [MultiplayerAPI.multiplayerPeer] refuses new incoming
   * connections.
   */
  public final inline var refuseNewConnections: Boolean
    @JvmName("refuseNewConnectionsProperty")
    get() = isRefusingNewConnections()
    @JvmName("refuseNewConnectionsProperty")
    set(`value`) {
      setRefuseNewConnections(value)
    }

  /**
   * Enable or disable the server feature that notifies clients of other peers'
   * connection/disconnection, and relays messages between them. When this option is `false`, clients
   * won't be automatically notified of other peers and won't be able to send them packets through the
   * server.
   *
   * **Note:** Changing this option while other peers are connected may lead to unexpected
   * behaviors.
   *
   * **Note:** Support for this feature may depend on the current [MultiplayerPeer] configuration.
   * See [MultiplayerPeer.isServerRelaySupported].
   */
  public final inline var serverRelay: Boolean
    @JvmName("serverRelayProperty")
    get() = isServerRelayEnabled()
    @JvmName("serverRelayProperty")
    set(`value`) {
      setServerRelayEnabled(value)
    }

  /**
   * Maximum size of each synchronization packet. Higher values increase the chance of receiving
   * full updates in a single frame, but also the chance of packet loss. See [MultiplayerSynchronizer].
   */
  public final inline var maxSyncPacketSize: Int
    @JvmName("maxSyncPacketSizeProperty")
    get() = getMaxSyncPacketSize()
    @JvmName("maxSyncPacketSizeProperty")
    set(`value`) {
      setMaxSyncPacketSize(value)
    }

  /**
   * Maximum size of each delta packet. Higher values increase the chance of receiving full updates
   * in a single frame, but also the chance of causing networking congestion (higher latency,
   * disconnections). See [MultiplayerSynchronizer].
   */
  public final inline var maxDeltaPacketSize: Int
    @JvmName("maxDeltaPacketSizeProperty")
    get() = getMaxDeltaPacketSize()
    @JvmName("maxDeltaPacketSizeProperty")
    set(`value`) {
      setMaxDeltaPacketSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(637, scriptPtr)
  }

  public final fun setRootPath(path: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setRootPathPtr, path)
  }

  public final fun getRootPath(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getRootPathPtr)

  /**
   * Clears the current SceneMultiplayer network state (you shouldn't call this unless you know what
   * you are doing).
   */
  public final fun clear(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  /**
   * Disconnects the peer identified by [id], removing it from the list of connected peers, and
   * closing the underlying connection with it.
   */
  public final fun disconnectPeer(id: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.disconnectPeerPtr, id.toLong())
  }

  /**
   * Returns the IDs of the peers currently trying to authenticate with this [MultiplayerAPI].
   */
  public final fun getAuthenticatingPeers(): PackedInt32Array =
      TransferContext.callPtrMethod0_ret_PACKED_INT_32_ARRAY(ptr, objectID.id, MethodBindings.getAuthenticatingPeersPtr)

  /**
   * Sends the specified [data] to the remote peer identified by [id] as part of an authentication
   * message. This can be used to authenticate peers, and control when [signal
   * MultiplayerAPI.peer_connected] is emitted (and the remote peer accepted as one of the connected
   * peers).
   */
  public final fun sendAuth(id: Int, `data`: PackedByteArray): Error =
      Error.from(TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_ret_LONG(ptr, objectID.id, MethodBindings.sendAuthPtr, id.toLong(), data))

  /**
   * Mark the authentication step as completed for the remote peer identified by [id]. The [signal
   * MultiplayerAPI.peer_connected] signal will be emitted for this peer once the remote side also
   * completes the authentication. No further authentication messages are expected to be received from
   * this peer.
   *
   * If a peer disconnects before completing authentication, either due to a network issue, the
   * [authTimeout] expiring, or manually calling [disconnectPeer], the [signal
   * peer_authentication_failed] signal will be emitted instead of [signal
   * MultiplayerAPI.peer_disconnected].
   */
  public final fun completeAuth(id: Int): Error =
      Error.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.completeAuthPtr, id.toLong()))

  public final fun setAuthCallback(callback: Callable): Unit {
    TransferContext.callMethod_CALLABLE(ptr, objectID.id, MethodBindings.setAuthCallbackPtr, callback)
  }

  public final fun getAuthCallback(): Callable =
      TransferContext.callMethod0_ret_CALLABLE(ptr, objectID.id, MethodBindings.getAuthCallbackPtr)

  public final fun setAuthTimeout(timeout: Double): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAuthTimeoutPtr, timeout)
  }

  public final fun getAuthTimeout(): Double =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAuthTimeoutPtr)

  public final fun setRefuseNewConnections(refuse: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setRefuseNewConnectionsPtr, refuse)
  }

  public final fun isRefusingNewConnections(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isRefusingNewConnectionsPtr)

  public final fun setAllowObjectDecoding(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAllowObjectDecodingPtr, enable)
  }

  public final fun isObjectDecodingAllowed(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isObjectDecodingAllowedPtr)

  public final fun setServerRelayEnabled(enabled: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setServerRelayEnabledPtr, enabled)
  }

  public final fun isServerRelayEnabled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isServerRelayEnabledPtr)

  /**
   * Sends the given raw [bytes] to a specific peer identified by [id] (see
   * [MultiplayerPeer.setTargetPeer]). Default ID is `0`, i.e. broadcast to all peers.
   */
  @JvmOverloads
  public final fun sendBytes(
    bytes: PackedByteArray,
    id: Int = 0,
    mode: MultiplayerPeer.TransferMode = MultiplayerPeer.TransferMode.RELIABLE,
    channel: Int = 0,
  ): Error =
      Error.from(TransferContext.callPtrMethod_PACKED_BYTE_ARRAY_LONG_LONG_LONG_ret_LONG(ptr, objectID.id, MethodBindings.sendBytesPtr, bytes, id.toLong(), mode.value, channel.toLong()))

  public final fun getMaxSyncPacketSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMaxSyncPacketSizePtr).toInt()

  public final fun setMaxSyncPacketSize(size: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setMaxSyncPacketSizePtr, size.toLong())
  }

  public final fun getMaxDeltaPacketSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMaxDeltaPacketSizePtr).toInt()

  public final fun setMaxDeltaPacketSize(size: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setMaxDeltaPacketSizePtr, size.toLong())
  }

  public final fun setRootPath(path: String) = setRootPath(path.asCachedNodePath())

  public companion object {
    @JvmField
    public val setRootPathName: MethodStringName1<SceneMultiplayer, Unit, NodePath> =
        MethodStringName1<SceneMultiplayer, Unit, NodePath>("set_root_path")

    @JvmField
    public val getRootPathName: MethodStringName0<SceneMultiplayer, NodePath> =
        MethodStringName0<SceneMultiplayer, NodePath>("get_root_path")

    @JvmField
    public val clearName: MethodStringName0<SceneMultiplayer, Unit> =
        MethodStringName0<SceneMultiplayer, Unit>("clear")

    @JvmField
    public val disconnectPeerName: MethodStringName1<SceneMultiplayer, Unit, Int> =
        MethodStringName1<SceneMultiplayer, Unit, Int>("disconnect_peer")

    @JvmField
    public val getAuthenticatingPeersName: MethodStringName0<SceneMultiplayer, PackedInt32Array> =
        MethodStringName0<SceneMultiplayer, PackedInt32Array>("get_authenticating_peers")

    @JvmField
    public val sendAuthName: MethodStringName2<SceneMultiplayer, Error, Int, PackedByteArray> =
        MethodStringName2<SceneMultiplayer, Error, Int, PackedByteArray>("send_auth")

    @JvmField
    public val completeAuthName: MethodStringName1<SceneMultiplayer, Error, Int> =
        MethodStringName1<SceneMultiplayer, Error, Int>("complete_auth")

    @JvmField
    public val setAuthCallbackName: MethodStringName1<SceneMultiplayer, Unit, Callable> =
        MethodStringName1<SceneMultiplayer, Unit, Callable>("set_auth_callback")

    @JvmField
    public val getAuthCallbackName: MethodStringName0<SceneMultiplayer, Callable> =
        MethodStringName0<SceneMultiplayer, Callable>("get_auth_callback")

    @JvmField
    public val setAuthTimeoutName: MethodStringName1<SceneMultiplayer, Unit, Double> =
        MethodStringName1<SceneMultiplayer, Unit, Double>("set_auth_timeout")

    @JvmField
    public val getAuthTimeoutName: MethodStringName0<SceneMultiplayer, Double> =
        MethodStringName0<SceneMultiplayer, Double>("get_auth_timeout")

    @JvmField
    public val setRefuseNewConnectionsName: MethodStringName1<SceneMultiplayer, Unit, Boolean> =
        MethodStringName1<SceneMultiplayer, Unit, Boolean>("set_refuse_new_connections")

    @JvmField
    public val isRefusingNewConnectionsName: MethodStringName0<SceneMultiplayer, Boolean> =
        MethodStringName0<SceneMultiplayer, Boolean>("is_refusing_new_connections")

    @JvmField
    public val setAllowObjectDecodingName: MethodStringName1<SceneMultiplayer, Unit, Boolean> =
        MethodStringName1<SceneMultiplayer, Unit, Boolean>("set_allow_object_decoding")

    @JvmField
    public val isObjectDecodingAllowedName: MethodStringName0<SceneMultiplayer, Boolean> =
        MethodStringName0<SceneMultiplayer, Boolean>("is_object_decoding_allowed")

    @JvmField
    public val setServerRelayEnabledName: MethodStringName1<SceneMultiplayer, Unit, Boolean> =
        MethodStringName1<SceneMultiplayer, Unit, Boolean>("set_server_relay_enabled")

    @JvmField
    public val isServerRelayEnabledName: MethodStringName0<SceneMultiplayer, Boolean> =
        MethodStringName0<SceneMultiplayer, Boolean>("is_server_relay_enabled")

    @JvmField
    public val sendBytesName:
        MethodStringName4<SceneMultiplayer, Error, PackedByteArray, Int, MultiplayerPeer.TransferMode, Int>
        =
        MethodStringName4<SceneMultiplayer, Error, PackedByteArray, Int, MultiplayerPeer.TransferMode, Int>("send_bytes")

    @JvmField
    public val getMaxSyncPacketSizeName: MethodStringName0<SceneMultiplayer, Int> =
        MethodStringName0<SceneMultiplayer, Int>("get_max_sync_packet_size")

    @JvmField
    public val setMaxSyncPacketSizeName: MethodStringName1<SceneMultiplayer, Unit, Int> =
        MethodStringName1<SceneMultiplayer, Unit, Int>("set_max_sync_packet_size")

    @JvmField
    public val getMaxDeltaPacketSizeName: MethodStringName0<SceneMultiplayer, Int> =
        MethodStringName0<SceneMultiplayer, Int>("get_max_delta_packet_size")

    @JvmField
    public val setMaxDeltaPacketSizeName: MethodStringName1<SceneMultiplayer, Unit, Int> =
        MethodStringName1<SceneMultiplayer, Unit, Int>("set_max_delta_packet_size")
  }

  public object MethodBindings {
    internal val setRootPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_root_path", 1348162250)

    internal val getRootPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "get_root_path", 4075236667)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "clear", 3218959716)

    internal val disconnectPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "disconnect_peer", 1286410249)

    internal val getAuthenticatingPeersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "get_authenticating_peers", 969006518)

    internal val sendAuthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "send_auth", 506032537)

    internal val completeAuthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "complete_auth", 844576869)

    internal val setAuthCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_auth_callback", 1611583062)

    internal val getAuthCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "get_auth_callback", 1307783378)

    internal val setAuthTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_auth_timeout", 373806689)

    internal val getAuthTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "get_auth_timeout", 1740695150)

    internal val setRefuseNewConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_refuse_new_connections", 2586408642)

    internal val isRefusingNewConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "is_refusing_new_connections", 36873697)

    internal val setAllowObjectDecodingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_allow_object_decoding", 2586408642)

    internal val isObjectDecodingAllowedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "is_object_decoding_allowed", 36873697)

    internal val setServerRelayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_server_relay_enabled", 2586408642)

    internal val isServerRelayEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "is_server_relay_enabled", 36873697)

    internal val sendBytesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "send_bytes", 1307428718)

    internal val getMaxSyncPacketSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "get_max_sync_packet_size", 3905245786)

    internal val setMaxSyncPacketSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_max_sync_packet_size", 1286410249)

    internal val getMaxDeltaPacketSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "get_max_delta_packet_size", 3905245786)

    internal val setMaxDeltaPacketSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SceneMultiplayer", "set_max_delta_packet_size", 1286410249)
  }
}
