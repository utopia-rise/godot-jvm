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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.NodePath
import godot.core.PackedInt32Array
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.STRING_NAME
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Base class for high-level multiplayer API implementations. See also [MultiplayerPeer].
 *
 * By default, [SceneTree] has a reference to an implementation of this class and uses it to provide
 * multiplayer capabilities (i.e. RPCs) across the whole scene.
 *
 * It is possible to override the MultiplayerAPI instance used by specific tree branches by calling
 * the [SceneTree.setMultiplayer] method, effectively allowing to run both client and server in the
 * same scene.
 *
 * It is also possible to extend or replace the default implementation via scripting or native
 * extensions. See [MultiplayerAPIExtension] for details about extensions, [SceneMultiplayer] for the
 * details about the default implementation.
 */
@GodotBaseType
public open class MultiplayerAPI internal constructor() : RefCounted() {
  /**
   * Emitted when this MultiplayerAPI's [multiplayerPeer] connects with a new peer. ID is the peer
   * ID of the new peer. Clients get notified when other clients connect to the same server. Upon
   * connecting to a server, a client also receives this signal for the server (with ID being 1).
   */
  public val peerConnected: Signal1<Long> by Signal1

  /**
   * Emitted when this MultiplayerAPI's [multiplayerPeer] disconnects from a peer. Clients get
   * notified when other clients disconnect from the same server.
   */
  public val peerDisconnected: Signal1<Long> by Signal1

  /**
   * Emitted when this MultiplayerAPI's [multiplayerPeer] successfully connected to a server. Only
   * emitted on clients.
   */
  public val connectedToServer: Signal0 by Signal0

  /**
   * Emitted when this MultiplayerAPI's [multiplayerPeer] fails to establish a connection to a
   * server. Only emitted on clients.
   */
  public val connectionFailed: Signal0 by Signal0

  /**
   * Emitted when this MultiplayerAPI's [multiplayerPeer] disconnects from server. Only emitted on
   * clients.
   */
  public val serverDisconnected: Signal0 by Signal0

  /**
   * The peer object to handle the RPC system (effectively enabling networking when set). Depending
   * on the peer itself, the MultiplayerAPI will become a network server (check with [isServer]) and
   * will set root node's network mode to authority, or it will become a regular client peer. All child
   * nodes are set to inherit the network mode by default. Handling of networking-related events
   * (connection, disconnection, new clients) is done by connecting to MultiplayerAPI's signals.
   */
  public final inline var multiplayerPeer: MultiplayerPeer?
    @JvmName("multiplayerPeerProperty")
    get() = getMultiplayerPeer()
    @JvmName("multiplayerPeerProperty")
    set(`value`) {
      setMultiplayerPeer(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(391, scriptPtr)
  }

  /**
   * Returns `true` if there is a [multiplayerPeer] set.
   */
  public final fun hasMultiplayerPeer(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasMultiplayerPeerPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun getMultiplayerPeer(): MultiplayerPeer? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMultiplayerPeerPtr)
    return (TransferContext.readReturnValue(OBJECT) as MultiplayerPeer?)
  }

  public final fun setMultiplayerPeer(peer: MultiplayerPeer?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to peer)
    TransferContext.callMethod(MethodBindings.setMultiplayerPeerPtr)
  }

  /**
   * Returns the unique peer ID of this MultiplayerAPI's [multiplayerPeer].
   */
  public final fun getUniqueId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUniqueIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns `true` if this MultiplayerAPI's [multiplayerPeer] is valid and in server mode
   * (listening for connections).
   */
  public final fun isServer(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isServerPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the sender's peer ID for the RPC currently being executed.
   *
   * **Note:** This method returns `0` when called outside of an RPC. As such, the original peer ID
   * may be lost when code execution is delayed (such as with GDScript's `await` keyword).
   */
  public final fun getRemoteSenderId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRemoteSenderIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Method used for polling the MultiplayerAPI. You only need to worry about this if you set
   * [SceneTree.multiplayerPoll] to `false`. By default, [SceneTree] will poll its MultiplayerAPI(s)
   * for you.
   *
   * **Note:** This method results in RPCs being called, so they will be executed in the same
   * context of this function (e.g. `_process`, `physics`, [Thread]).
   */
  public final fun poll(): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.pollPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sends an RPC to the target [peer]. The given [method] will be called on the remote [object]
   * with the provided [arguments]. The RPC may also be called locally depending on the implementation
   * and RPC configuration. See [Node.rpc] and [Node.rpcConfig].
   *
   * **Note:** Prefer using [Node.rpc], [Node.rpcId], or `my_method.rpc(peer, arg1, arg2, ...)` (in
   * GDScript), since they are faster. This method is mostly useful in conjunction with
   * [MultiplayerAPIExtension] when extending or replacing the multiplayer capabilities.
   */
  @JvmOverloads
  public final fun rpc(
    peer: Int,
    `object`: Object?,
    method: StringName,
    arguments: VariantArray<Any?> = godot.core.variantArrayOf(),
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to peer.toLong(), OBJECT to `object`, STRING_NAME to method, ARRAY to arguments)
    TransferContext.callMethod(MethodBindings.rpcPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Notifies the MultiplayerAPI of a new [configuration] for the given [object]. This method is
   * used internally by [SceneTree] to configure the root path for this MultiplayerAPI (passing `null`
   * and a valid [NodePath] as [configuration]). This method can be further used by MultiplayerAPI
   * implementations to provide additional features, refer to specific implementation (e.g.
   * [SceneMultiplayer]) for details on how they use it.
   *
   * **Note:** This method is mostly relevant when extending or overriding the MultiplayerAPI
   * behavior via [MultiplayerAPIExtension].
   */
  public final fun objectConfigurationAdd(`object`: Object?, configuration: Any?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to `object`, ANY to configuration)
    TransferContext.callMethod(MethodBindings.objectConfigurationAddPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Notifies the MultiplayerAPI to remove a [configuration] for the given [object]. This method is
   * used internally by [SceneTree] to configure the root path for this MultiplayerAPI (passing `null`
   * and an empty [NodePath] as [configuration]). This method can be further used by MultiplayerAPI
   * implementations to provide additional features, refer to specific implementation (e.g.
   * [SceneMultiplayer]) for details on how they use it.
   *
   * **Note:** This method is mostly relevant when extending or overriding the MultiplayerAPI
   * behavior via [MultiplayerAPIExtension].
   */
  public final fun objectConfigurationRemove(`object`: Object?, configuration: Any?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to `object`, ANY to configuration)
    TransferContext.callMethod(MethodBindings.objectConfigurationRemovePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the peer IDs of all connected peers of this MultiplayerAPI's [multiplayerPeer].
   */
  public final fun getPeers(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPeersPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Sends an RPC to the target [peer]. The given [method] will be called on the remote [object]
   * with the provided [arguments]. The RPC may also be called locally depending on the implementation
   * and RPC configuration. See [Node.rpc] and [Node.rpcConfig].
   *
   * **Note:** Prefer using [Node.rpc], [Node.rpcId], or `my_method.rpc(peer, arg1, arg2, ...)` (in
   * GDScript), since they are faster. This method is mostly useful in conjunction with
   * [MultiplayerAPIExtension] when extending or replacing the multiplayer capabilities.
   */
  @JvmOverloads
  public final fun rpc(
    peer: Int,
    `object`: Object?,
    method: String,
    arguments: VariantArray<Any?> = godot.core.variantArrayOf(),
  ): Error = rpc(peer, `object`, method.asCachedStringName(), arguments)

  public enum class RPCMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Used with [Node.rpcConfig] to disable a method or property for all RPC calls, making it
     * unavailable. Default for all methods.
     */
    DISABLED(0),
    /**
     * Used with [Node.rpcConfig] to set a method to be callable remotely by any peer. Analogous to
     * the `@rpc("any_peer")` annotation. Calls are accepted from all remote peers, no matter if they
     * are node's authority or not.
     */
    ANY_PEER(1),
    /**
     * Used with [Node.rpcConfig] to set a method to be callable remotely only by the current
     * multiplayer authority (which is the server by default). Analogous to the `@rpc("authority")`
     * annotation. See [Node.setMultiplayerAuthority].
     */
    AUTHORITY(2),
    ;

    public companion object {
      public fun from(`value`: Long): RPCMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val hasMultiplayerPeerName: MethodStringName0<MultiplayerAPI, Boolean> =
        MethodStringName0<MultiplayerAPI, Boolean>("has_multiplayer_peer")

    @JvmField
    public val getMultiplayerPeerName: MethodStringName0<MultiplayerAPI, MultiplayerPeer?> =
        MethodStringName0<MultiplayerAPI, MultiplayerPeer?>("get_multiplayer_peer")

    @JvmField
    public val setMultiplayerPeerName: MethodStringName1<MultiplayerAPI, Unit, MultiplayerPeer?> =
        MethodStringName1<MultiplayerAPI, Unit, MultiplayerPeer?>("set_multiplayer_peer")

    @JvmField
    public val getUniqueIdName: MethodStringName0<MultiplayerAPI, Int> =
        MethodStringName0<MultiplayerAPI, Int>("get_unique_id")

    @JvmField
    public val isServerName: MethodStringName0<MultiplayerAPI, Boolean> =
        MethodStringName0<MultiplayerAPI, Boolean>("is_server")

    @JvmField
    public val getRemoteSenderIdName: MethodStringName0<MultiplayerAPI, Int> =
        MethodStringName0<MultiplayerAPI, Int>("get_remote_sender_id")

    @JvmField
    public val pollName: MethodStringName0<MultiplayerAPI, Error> =
        MethodStringName0<MultiplayerAPI, Error>("poll")

    @JvmField
    public val rpcName:
        MethodStringName4<MultiplayerAPI, Error, Int, Object?, StringName, VariantArray<Any?>> =
        MethodStringName4<MultiplayerAPI, Error, Int, Object?, StringName, VariantArray<Any?>>("rpc")

    @JvmField
    public val objectConfigurationAddName: MethodStringName2<MultiplayerAPI, Error, Object?, Any?> =
        MethodStringName2<MultiplayerAPI, Error, Object?, Any?>("object_configuration_add")

    @JvmField
    public val objectConfigurationRemoveName:
        MethodStringName2<MultiplayerAPI, Error, Object?, Any?> =
        MethodStringName2<MultiplayerAPI, Error, Object?, Any?>("object_configuration_remove")

    @JvmField
    public val getPeersName: MethodStringName0<MultiplayerAPI, PackedInt32Array> =
        MethodStringName0<MultiplayerAPI, PackedInt32Array>("get_peers")

    @JvmField
    public val setDefaultInterfaceName: MethodStringName1<MultiplayerAPI, Unit, StringName> =
        MethodStringName1<MultiplayerAPI, Unit, StringName>("set_default_interface")

    @JvmField
    public val getDefaultInterfaceName: MethodStringName0<MultiplayerAPI, StringName> =
        MethodStringName0<MultiplayerAPI, StringName>("get_default_interface")

    @JvmField
    public val createDefaultInterfaceName: MethodStringName0<MultiplayerAPI, MultiplayerAPI?> =
        MethodStringName0<MultiplayerAPI, MultiplayerAPI?>("create_default_interface")

    /**
     * Sets the default MultiplayerAPI implementation class. This method can be used by modules and
     * extensions to configure which implementation will be used by [SceneTree] when the engine starts.
     */
    @JvmStatic
    public final fun setDefaultInterface(interfaceName: StringName): Unit {
      TransferContext.writeMethodArguments(0L, 0L, STRING_NAME to interfaceName)
      TransferContext.callMethod(MethodBindings.setDefaultInterfacePtr)
    }

    /**
     * Returns the default MultiplayerAPI implementation class name. This is usually
     * `"SceneMultiplayer"` when [SceneMultiplayer] is available. See [setDefaultInterface].
     */
    @JvmStatic
    public final fun getDefaultInterface(): StringName {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.getDefaultInterfacePtr)
      return (TransferContext.readReturnValue(STRING_NAME) as StringName)
    }

    /**
     * Returns a new instance of the default MultiplayerAPI.
     */
    @JvmStatic
    public final fun createDefaultInterface(): MultiplayerAPI? {
      TransferContext.writeMethodArguments(0L, 0L)
      TransferContext.callMethod(MethodBindings.createDefaultInterfacePtr)
      return (TransferContext.readReturnValue(OBJECT) as MultiplayerAPI?)
    }

    /**
     * Sets the default MultiplayerAPI implementation class. This method can be used by modules and
     * extensions to configure which implementation will be used by [SceneTree] when the engine starts.
     */
    @JvmStatic
    public final fun setDefaultInterface(interfaceName: String) =
        setDefaultInterface(interfaceName.asCachedStringName())
  }

  public object MethodBindings {
    internal val hasMultiplayerPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "has_multiplayer_peer", 2240911060)

    internal val getMultiplayerPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "get_multiplayer_peer", 3223692825)

    internal val setMultiplayerPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "set_multiplayer_peer", 3694835298)

    internal val getUniqueIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "get_unique_id", 2455072627)

    internal val isServerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "is_server", 2240911060)

    internal val getRemoteSenderIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "get_remote_sender_id", 2455072627)

    internal val pollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "poll", 166280745)

    internal val rpcPtr: VoidPtr = TypeManager.getMethodBindPtr("MultiplayerAPI", "rpc", 2077486355)

    internal val objectConfigurationAddPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "object_configuration_add", 1171879464)

    internal val objectConfigurationRemovePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "object_configuration_remove", 1171879464)

    internal val getPeersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "get_peers", 969006518)

    internal val setDefaultInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "set_default_interface", 3304788590)

    internal val getDefaultInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "get_default_interface", 2737447660)

    internal val createDefaultInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("MultiplayerAPI", "create_default_interface", 3294156723)
  }
}
