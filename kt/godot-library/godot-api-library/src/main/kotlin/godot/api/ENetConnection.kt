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
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName6
import godot.core.PackedByteArray
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * ENet's purpose is to provide a relatively thin, simple and robust network communication layer on
 * top of UDP (User Datagram Protocol).
 */
@GodotBaseType
public open class ENetConnection : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(212, scriptPtr)
  }

  /**
   * Creates an ENetHost bound to the given [bindAddress] and [bindPort] that allows up to
   * [maxPeers] connected peers, each allocating up to [maxChannels] channels, optionally limiting
   * bandwidth to [inBandwidth] and [outBandwidth] (if greater than zero).
   *
   * **Note:** It is necessary to create a host in both client and server in order to establish a
   * connection.
   */
  @JvmOverloads
  public final fun createHostBound(
    bindAddress: String,
    bindPort: Int,
    maxPeers: Int = 32,
    maxChannels: Int = 0,
    inBandwidth: Int = 0,
    outBandwidth: Int = 0,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to bindAddress, LONG to bindPort.toLong(), LONG to maxPeers.toLong(), LONG to maxChannels.toLong(), LONG to inBandwidth.toLong(), LONG to outBandwidth.toLong())
    TransferContext.callMethod(MethodBindings.createHostBoundPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Creates an ENetHost that allows up to [maxPeers] connected peers, each allocating up to
   * [maxChannels] channels, optionally limiting bandwidth to [inBandwidth] and [outBandwidth] (if
   * greater than zero).
   *
   * This method binds a random available dynamic UDP port on the host machine at the *unspecified*
   * address. Use [createHostBound] to specify the address and port.
   *
   * **Note:** It is necessary to create a host in both client and server in order to establish a
   * connection.
   */
  @JvmOverloads
  public final fun createHost(
    maxPeers: Int = 32,
    maxChannels: Int = 0,
    inBandwidth: Int = 0,
    outBandwidth: Int = 0,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxPeers.toLong(), LONG to maxChannels.toLong(), LONG to inBandwidth.toLong(), LONG to outBandwidth.toLong())
    TransferContext.callMethod(MethodBindings.createHostPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Destroys the host and all resources associated with it.
   */
  public final fun destroy(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.destroyPtr)
  }

  /**
   * Initiates a connection to a foreign [address] using the specified [port] and allocating the
   * requested [channels]. Optional [data] can be passed during connection in the form of a 32 bit
   * integer.
   *
   * **Note:** You must call either [createHost] or [createHostBound] on both ends before calling
   * this method.
   */
  @JvmOverloads
  public final fun connectToHost(
    address: String,
    port: Int,
    channels: Int = 0,
    `data`: Int = 0,
  ): ENetPacketPeer? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to address, LONG to port.toLong(), LONG to channels.toLong(), LONG to data.toLong())
    TransferContext.callMethod(MethodBindings.connectToHostPtr)
    return (TransferContext.readReturnValue(OBJECT) as ENetPacketPeer?)
  }

  /**
   * Waits for events on this connection and shuttles packets between the host and its peers, with
   * the given [timeout] (in milliseconds). The returned [VariantArray] will have 4 elements. An
   * [EventType], the [ENetPacketPeer] which generated the event, the event associated data (if any),
   * the event associated channel (if any). If the generated event is [EVENT_RECEIVE], the received
   * packet will be queued to the associated [ENetPacketPeer].
   *
   * Call this function regularly to handle connections, disconnections, and to receive new packets.
   *
   * **Note:** This method must be called on both ends involved in the event (sending and receiving
   * hosts).
   */
  @JvmOverloads
  public final fun service(timeout: Int = 0): VariantArray<Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to timeout.toLong())
    TransferContext.callMethod(MethodBindings.servicePtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Any?>)
  }

  /**
   * Sends any queued packets on the host specified to its designated peers.
   */
  public final fun flush(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.flushPtr)
  }

  /**
   * Adjusts the bandwidth limits of a host.
   */
  @JvmOverloads
  public final fun bandwidthLimit(inBandwidth: Int = 0, outBandwidth: Int = 0): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to inBandwidth.toLong(), LONG to outBandwidth.toLong())
    TransferContext.callMethod(MethodBindings.bandwidthLimitPtr)
  }

  /**
   * Limits the maximum allowed channels of future incoming connections.
   */
  public final fun channelLimit(limit: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to limit.toLong())
    TransferContext.callMethod(MethodBindings.channelLimitPtr)
  }

  /**
   * Queues a [packet] to be sent to all peers associated with the host over the specified
   * [channel]. See [ENetPacketPeer] `FLAG_*` constants for available packet flags.
   */
  public final fun broadcast(
    channel: Int,
    packet: PackedByteArray,
    flags: Int,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to channel.toLong(), PACKED_BYTE_ARRAY to packet, LONG to flags.toLong())
    TransferContext.callMethod(MethodBindings.broadcastPtr)
  }

  /**
   * Sets the compression method used for network packets. These have different tradeoffs of
   * compression speed versus bandwidth, you may need to test which one works best for your use case if
   * you use compression at all.
   *
   * **Note:** Most games' network design involve sending many small packets frequently (smaller
   * than 4 KB each). If in doubt, it is recommended to keep the default compression algorithm as it
   * works best on these small packets.
   *
   * **Note:** The compression mode must be set to the same value on both the server and all its
   * clients. Clients will fail to connect if the compression mode set on the client differs from the
   * one set on the server.
   */
  public final fun compress(mode: CompressionMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.compressPtr)
  }

  /**
   * Configure this ENetHost to use the custom Godot extension allowing DTLS encryption for ENet
   * servers. Call this right after [createHostBound] to have ENet expect peers to connect using DTLS.
   * See [TLSOptions.server].
   */
  public final fun dtlsServerSetup(serverOptions: TLSOptions?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to serverOptions)
    TransferContext.callMethod(MethodBindings.dtlsServerSetupPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Configure this ENetHost to use the custom Godot extension allowing DTLS encryption for ENet
   * clients. Call this before [connectToHost] to have ENet connect using DTLS validating the server
   * certificate against [hostname]. You can pass the optional [clientOptions] parameter to customize
   * the trusted certification authorities, or disable the common name verification. See
   * [TLSOptions.client] and [TLSOptions.clientUnsafe].
   */
  @JvmOverloads
  public final fun dtlsClientSetup(hostname: String, clientOptions: TLSOptions? = null): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to hostname, OBJECT to clientOptions)
    TransferContext.callMethod(MethodBindings.dtlsClientSetupPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Configures the DTLS server to automatically drop new connections.
   *
   * **Note:** This method is only relevant after calling [dtlsServerSetup].
   */
  public final fun refuseNewConnections(refuse: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to refuse)
    TransferContext.callMethod(MethodBindings.refuseNewConnectionsPtr)
  }

  /**
   * Returns and resets host statistics.
   */
  public final fun popStatistic(statistic: HostStatistic): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to statistic.value)
    TransferContext.callMethod(MethodBindings.popStatisticPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the maximum number of channels allowed for connected peers.
   */
  public final fun getMaxChannels(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxChannelsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the local port to which this peer is bound.
   */
  public final fun getLocalPort(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLocalPortPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the list of peers associated with this host.
   *
   * **Note:** This list might include some peers that are not fully connected or are still being
   * disconnected.
   */
  public final fun getPeers(): VariantArray<ENetPacketPeer> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPeersPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<ENetPacketPeer>)
  }

  /**
   * Sends a [packet] toward a destination from the address and port currently bound by this
   * ENetConnection instance.
   *
   * This is useful as it serves to establish entries in NAT routing tables on all devices between
   * this bound instance and the public facing internet, allowing a prospective client's connection
   * packets to be routed backward through the NAT device(s) between the public internet and this host.
   *
   * This requires forward knowledge of a prospective client's address and communication port as
   * seen by the public internet - after any NAT devices have handled their connection request. This
   * information can be obtained by a [url=https://en.wikipedia.org/wiki/STUN]STUN[/url] service, and
   * must be handed off to your host by an entity that is not the prospective client. This will never
   * work for a client behind a Symmetric NAT due to the nature of the Symmetric NAT routing algorithm,
   * as their IP and Port cannot be known beforehand.
   */
  public final fun socketSend(
    destinationAddress: String,
    destinationPort: Int,
    packet: PackedByteArray,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to destinationAddress, LONG to destinationPort.toLong(), PACKED_BYTE_ARRAY to packet)
    TransferContext.callMethod(MethodBindings.socketSendPtr)
  }

  public enum class CompressionMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No compression. This uses the most bandwidth, but has the upside of requiring the fewest CPU
     * resources. This option may also be used to make network debugging using tools like Wireshark
     * easier.
     */
    NONE(0),
    /**
     * ENet's built-in range encoding. Works well on small packets, but is not the most efficient
     * algorithm on packets larger than 4 KB.
     */
    RANGE_CODER(1),
    /**
     * [url=https://fastlz.org/]FastLZ[/url] compression. This option uses less CPU resources
     * compared to [COMPRESS_ZLIB], at the expense of using more bandwidth.
     */
    FASTLZ(2),
    /**
     * [url=https://www.zlib.net/]Zlib[/url] compression. This option uses less bandwidth compared
     * to [COMPRESS_FASTLZ], at the expense of using more CPU resources.
     */
    ZLIB(3),
    /**
     * [url=https://facebook.github.io/zstd/]Zstandard[/url] compression. Note that this algorithm
     * is not very efficient on packets smaller than 4 KB. Therefore, it's recommended to use other
     * compression algorithms in most cases.
     */
    ZSTD(4),
    ;

    public companion object {
      public fun from(`value`: Long): CompressionMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class EventType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * An error occurred during [service]. You will likely need to [destroy] the host and recreate
     * it.
     */
    ERROR(-1),
    /**
     * No event occurred within the specified time limit.
     */
    NONE(0),
    /**
     * A connection request initiated by enet_host_connect has completed. The array will contain the
     * peer which successfully connected.
     */
    CONNECT(1),
    /**
     * A peer has disconnected. This event is generated on a successful completion of a disconnect
     * initiated by [ENetPacketPeer.peerDisconnect], if a peer has timed out, or if a connection
     * request initialized by [connectToHost] has timed out. The array will contain the peer which
     * disconnected. The data field contains user supplied data describing the disconnection, or 0, if
     * none is available.
     */
    DISCONNECT(2),
    /**
     * A packet has been received from a peer. The array will contain the peer which sent the packet
     * and the channel number upon which the packet was received. The received packet will be queued to
     * the associated [ENetPacketPeer].
     */
    RECEIVE(3),
    ;

    public companion object {
      public fun from(`value`: Long): EventType = entries.single { it.`value` == `value` }
    }
  }

  public enum class HostStatistic(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Total data sent.
     */
    TOTAL_SENT_DATA(0),
    /**
     * Total UDP packets sent.
     */
    TOTAL_SENT_PACKETS(1),
    /**
     * Total data received.
     */
    TOTAL_RECEIVED_DATA(2),
    /**
     * Total UDP packets received.
     */
    TOTAL_RECEIVED_PACKETS(3),
    ;

    public companion object {
      public fun from(`value`: Long): HostStatistic = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val createHostBoundName:
        MethodStringName6<ENetConnection, Error, String, Int, Int, Int, Int, Int> =
        MethodStringName6<ENetConnection, Error, String, Int, Int, Int, Int, Int>("create_host_bound")

    @JvmField
    public val createHostName: MethodStringName4<ENetConnection, Error, Int, Int, Int, Int> =
        MethodStringName4<ENetConnection, Error, Int, Int, Int, Int>("create_host")

    @JvmField
    public val destroyName: MethodStringName0<ENetConnection, Unit> =
        MethodStringName0<ENetConnection, Unit>("destroy")

    @JvmField
    public val connectToHostName:
        MethodStringName4<ENetConnection, ENetPacketPeer?, String, Int, Int, Int> =
        MethodStringName4<ENetConnection, ENetPacketPeer?, String, Int, Int, Int>("connect_to_host")

    @JvmField
    public val serviceName: MethodStringName1<ENetConnection, VariantArray<Any?>, Int> =
        MethodStringName1<ENetConnection, VariantArray<Any?>, Int>("service")

    @JvmField
    public val flushName: MethodStringName0<ENetConnection, Unit> =
        MethodStringName0<ENetConnection, Unit>("flush")

    @JvmField
    public val bandwidthLimitName: MethodStringName2<ENetConnection, Unit, Int, Int> =
        MethodStringName2<ENetConnection, Unit, Int, Int>("bandwidth_limit")

    @JvmField
    public val channelLimitName: MethodStringName1<ENetConnection, Unit, Int> =
        MethodStringName1<ENetConnection, Unit, Int>("channel_limit")

    @JvmField
    public val broadcastName: MethodStringName3<ENetConnection, Unit, Int, PackedByteArray, Int> =
        MethodStringName3<ENetConnection, Unit, Int, PackedByteArray, Int>("broadcast")

    @JvmField
    public val compressName: MethodStringName1<ENetConnection, Unit, CompressionMode> =
        MethodStringName1<ENetConnection, Unit, CompressionMode>("compress")

    @JvmField
    public val dtlsServerSetupName: MethodStringName1<ENetConnection, Error, TLSOptions?> =
        MethodStringName1<ENetConnection, Error, TLSOptions?>("dtls_server_setup")

    @JvmField
    public val dtlsClientSetupName: MethodStringName2<ENetConnection, Error, String, TLSOptions?> =
        MethodStringName2<ENetConnection, Error, String, TLSOptions?>("dtls_client_setup")

    @JvmField
    public val refuseNewConnectionsName: MethodStringName1<ENetConnection, Unit, Boolean> =
        MethodStringName1<ENetConnection, Unit, Boolean>("refuse_new_connections")

    @JvmField
    public val popStatisticName: MethodStringName1<ENetConnection, Double, HostStatistic> =
        MethodStringName1<ENetConnection, Double, HostStatistic>("pop_statistic")

    @JvmField
    public val getMaxChannelsName: MethodStringName0<ENetConnection, Int> =
        MethodStringName0<ENetConnection, Int>("get_max_channels")

    @JvmField
    public val getLocalPortName: MethodStringName0<ENetConnection, Int> =
        MethodStringName0<ENetConnection, Int>("get_local_port")

    @JvmField
    public val getPeersName: MethodStringName0<ENetConnection, VariantArray<ENetPacketPeer>> =
        MethodStringName0<ENetConnection, VariantArray<ENetPacketPeer>>("get_peers")

    @JvmField
    public val socketSendName: MethodStringName3<ENetConnection, Unit, String, Int, PackedByteArray>
        = MethodStringName3<ENetConnection, Unit, String, Int, PackedByteArray>("socket_send")
  }

  public object MethodBindings {
    internal val createHostBoundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "create_host_bound", 1515002313)

    internal val createHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "create_host", 117198950)

    internal val destroyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "destroy", 3218959716)

    internal val connectToHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "connect_to_host", 2171300490)

    internal val servicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "service", 2402345344)

    internal val flushPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "flush", 3218959716)

    internal val bandwidthLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "bandwidth_limit", 2302169788)

    internal val channelLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "channel_limit", 1286410249)

    internal val broadcastPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "broadcast", 2772371345)

    internal val compressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "compress", 2660215187)

    internal val dtlsServerSetupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "dtls_server_setup", 1262296096)

    internal val dtlsClientSetupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "dtls_client_setup", 1966198364)

    internal val refuseNewConnectionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "refuse_new_connections", 2586408642)

    internal val popStatisticPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "pop_statistic", 2166904170)

    internal val getMaxChannelsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "get_max_channels", 3905245786)

    internal val getLocalPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "get_local_port", 3905245786)

    internal val getPeersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "get_peers", 2915620761)

    internal val socketSendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetConnection", "socket_send", 1100646812)
  }
}
