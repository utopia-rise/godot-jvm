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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName5
import godot.core.MethodStringName6
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG_LONG_LONG_LONG
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_LONG_LONG_LONG_LONG_LONG
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A MultiplayerPeer implementation that should be passed to [MultiplayerAPI.multiplayerPeer] after
 * being initialized as either a client, server, or mesh. Events can then be handled by connecting to
 * [MultiplayerAPI] signals. See [ENetConnection] for more information on the ENet library wrapper.
 *
 * **Note:** ENet only uses UDP, not TCP. When forwarding the server port to make your server
 * accessible on the public Internet, you only need to forward the server port in UDP. You can use the
 * [UPNP] class to try to forward the server port automatically when starting the server.
 */
@GodotBaseType
public open class ENetMultiplayerPeer : MultiplayerPeer() {
  /**
   * The underlying [ENetConnection] created after [createClient] and [createServer].
   */
  public final inline val host: ENetConnection?
    @JvmName("hostProperty")
    get() = getHost()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(211, scriptPtr)
  }

  /**
   * Create server that listens to connections via [port]. The port needs to be an available, unused
   * port between 0 and 65535. Note that ports below 1024 are privileged and may require elevated
   * permissions depending on the platform. To change the interface the server listens on, use
   * [setBindIp]. The default IP is the wildcard `"*"`, which listens on all available interfaces.
   * [maxClients] is the maximum number of clients that are allowed at once, any number up to 4095 may
   * be used, although the achievable number of simultaneous clients may be far lower and depends on
   * the application. For additional details on the bandwidth parameters, see [createClient]. Returns
   * [OK] if a server was created, [ERR_ALREADY_IN_USE] if this ENetMultiplayerPeer instance already
   * has an open connection (in which case you need to call [MultiplayerPeer.close] first) or
   * [ERR_CANT_CREATE] if the server could not be created.
   */
  @JvmOverloads
  public final fun createServer(
    port: Int,
    maxClients: Int = 32,
    maxChannels: Int = 0,
    inBandwidth: Int = 0,
    outBandwidth: Int = 0,
  ): Error {
    TransferContext.writeMethodArguments_LONG_LONG_LONG_LONG_LONG(ptr, objectID.id, port.toLong(), maxClients.toLong(), maxChannels.toLong(), inBandwidth.toLong(), outBandwidth.toLong())
    TransferContext.callPtrMethod(MethodBindings.createServerPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Create client that connects to a server at [address] using specified [port]. The given address
   * needs to be either a fully qualified domain name (e.g. `"www.example.com"`) or an IP address in
   * IPv4 or IPv6 format (e.g. `"192.168.1.1"`). The [port] is the port the server is listening on. The
   * [channelCount] parameter can be used to specify the number of ENet channels allocated for the
   * connection. The [inBandwidth] and [outBandwidth] parameters can be used to limit the incoming and
   * outgoing bandwidth to the given number of bytes per second. The default of 0 means unlimited
   * bandwidth. Note that ENet will strategically drop packets on specific sides of a connection
   * between peers to ensure the peer's bandwidth is not overwhelmed. The bandwidth parameters also
   * determine the window size of a connection which limits the amount of reliable packets that may be
   * in transit at any given time. Returns [OK] if a client was created, [ERR_ALREADY_IN_USE] if this
   * ENetMultiplayerPeer instance already has an open connection (in which case you need to call
   * [MultiplayerPeer.close] first) or [ERR_CANT_CREATE] if the client could not be created. If
   * [localPort] is specified, the client will also listen to the given port; this is useful for some
   * NAT traversal techniques.
   */
  @JvmOverloads
  public final fun createClient(
    address: String,
    port: Int,
    channelCount: Int = 0,
    inBandwidth: Int = 0,
    outBandwidth: Int = 0,
    localPort: Int = 0,
  ): Error {
    TransferContext.writeMethodArguments_STRING_LONG_LONG_LONG_LONG_LONG(ptr, objectID.id, address, port.toLong(), channelCount.toLong(), inBandwidth.toLong(), outBandwidth.toLong(), localPort.toLong())
    TransferContext.callMethod(MethodBindings.createClientPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Initialize this [MultiplayerPeer] in mesh mode. The provided [uniqueId] will be used as the
   * local peer network unique ID once assigned as the [MultiplayerAPI.multiplayerPeer]. In the mesh
   * configuration you will need to set up each new peer manually using [ENetConnection] before calling
   * [addMeshPeer]. While this technique is more advanced, it allows for better control over the
   * connection process (e.g. when dealing with NAT punch-through) and for better distribution of the
   * network load (which would otherwise be more taxing on the server).
   */
  public final fun createMesh(uniqueId: Int): Error {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, uniqueId.toLong())
    TransferContext.callPtrMethod(MethodBindings.createMeshPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Add a new remote peer with the given [peerId] connected to the given [host].
   *
   * **Note:** The [host] must have exactly one peer in the [ENetPacketPeer.STATE_CONNECTED] state.
   */
  public final fun addMeshPeer(peerId: Int, host: ENetConnection?): Error {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, peerId.toLong(), host)
    TransferContext.callPtrMethod(MethodBindings.addMeshPeerPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * The IP used when creating a server. This is set to the wildcard `"*"` by default, which binds
   * to all available interfaces. The given IP needs to be in IPv4 or IPv6 address format, for example:
   * `"192.168.1.1"`.
   */
  public final fun setBindIp(ip: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, ip)
    TransferContext.callMethod(MethodBindings.setBindIpPtr)
  }

  public final fun getHost(): ENetConnection? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHostPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as ENetConnection?)
  }

  /**
   * Returns the [ENetPacketPeer] associated to the given [id].
   */
  public final fun getPeer(id: Int): ENetPacketPeer? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, id.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPeerPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as ENetPacketPeer?)
  }

  public companion object {
    @JvmField
    public val createServerName:
        MethodStringName5<ENetMultiplayerPeer, Error, Int, Int, Int, Int, Int> =
        MethodStringName5<ENetMultiplayerPeer, Error, Int, Int, Int, Int, Int>("create_server")

    @JvmField
    public val createClientName:
        MethodStringName6<ENetMultiplayerPeer, Error, String, Int, Int, Int, Int, Int> =
        MethodStringName6<ENetMultiplayerPeer, Error, String, Int, Int, Int, Int, Int>("create_client")

    @JvmField
    public val createMeshName: MethodStringName1<ENetMultiplayerPeer, Error, Int> =
        MethodStringName1<ENetMultiplayerPeer, Error, Int>("create_mesh")

    @JvmField
    public val addMeshPeerName: MethodStringName2<ENetMultiplayerPeer, Error, Int, ENetConnection?>
        = MethodStringName2<ENetMultiplayerPeer, Error, Int, ENetConnection?>("add_mesh_peer")

    @JvmField
    public val setBindIpName: MethodStringName1<ENetMultiplayerPeer, Unit, String> =
        MethodStringName1<ENetMultiplayerPeer, Unit, String>("set_bind_ip")

    @JvmField
    public val getHostName: MethodStringName0<ENetMultiplayerPeer, ENetConnection?> =
        MethodStringName0<ENetMultiplayerPeer, ENetConnection?>("get_host")

    @JvmField
    public val getPeerName: MethodStringName1<ENetMultiplayerPeer, ENetPacketPeer?, Int> =
        MethodStringName1<ENetMultiplayerPeer, ENetPacketPeer?, Int>("get_peer")
  }

  public object MethodBindings {
    internal val createServerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetMultiplayerPeer", "create_server", 2917761309)

    internal val createClientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetMultiplayerPeer", "create_client", 2327163476)

    internal val createMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetMultiplayerPeer", "create_mesh", 844576869)

    internal val addMeshPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetMultiplayerPeer", "add_mesh_peer", 1293458335)

    internal val setBindIpPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetMultiplayerPeer", "set_bind_ip", 83702148)

    internal val getHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetMultiplayerPeer", "get_host", 4103238886)

    internal val getPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetMultiplayerPeer", "get_peer", 3793311544)
  }
}
