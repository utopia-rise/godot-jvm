// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedStringArray
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Base class for WebSocket server and client, allowing them to be used as multiplayer peer for the
 * [MultiplayerAPI].
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class WebSocketMultiplayerPeer : MultiplayerPeer() {
  /**
   * The supported WebSocket sub-protocols. See [WebSocketPeer.supportedProtocols] for more details.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var supportedProtocols: PackedStringArray
    @JvmName("supportedProtocolsProperty")
    get() = getSupportedProtocols()
    @JvmName("supportedProtocolsProperty")
    set(`value`) {
      setSupportedProtocols(value)
    }

  /**
   * The extra headers to use during handshake. See [WebSocketPeer.handshakeHeaders] for more
   * details.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var handshakeHeaders: PackedStringArray
    @JvmName("handshakeHeadersProperty")
    get() = getHandshakeHeaders()
    @JvmName("handshakeHeadersProperty")
    set(`value`) {
      setHandshakeHeaders(value)
    }

  /**
   * The inbound buffer size for connected peers. See [WebSocketPeer.inboundBufferSize] for more
   * details.
   */
  public final inline var inboundBufferSize: Int
    @JvmName("inboundBufferSizeProperty")
    get() = getInboundBufferSize()
    @JvmName("inboundBufferSizeProperty")
    set(`value`) {
      setInboundBufferSize(value)
    }

  /**
   * The outbound buffer size for connected peers. See [WebSocketPeer.outboundBufferSize] for more
   * details.
   */
  public final inline var outboundBufferSize: Int
    @JvmName("outboundBufferSizeProperty")
    get() = getOutboundBufferSize()
    @JvmName("outboundBufferSizeProperty")
    set(`value`) {
      setOutboundBufferSize(value)
    }

  /**
   * The maximum time each peer can stay in a connecting state before being dropped.
   */
  public final inline var handshakeTimeout: Float
    @JvmName("handshakeTimeoutProperty")
    get() = getHandshakeTimeout()
    @JvmName("handshakeTimeoutProperty")
    set(`value`) {
      setHandshakeTimeout(value)
    }

  /**
   * The maximum number of queued packets for connected peers. See [WebSocketPeer.maxQueuedPackets]
   * for more details.
   */
  public final inline var maxQueuedPackets: Int
    @JvmName("maxQueuedPacketsProperty")
    get() = getMaxQueuedPackets()
    @JvmName("maxQueuedPacketsProperty")
    set(`value`) {
      setMaxQueuedPackets(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(924, scriptPtr)
  }

  /**
   * This is a helper function for [supportedProtocols] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = websocketmultiplayerpeer.supportedProtocols
   * //Your changes
   * websocketmultiplayerpeer.supportedProtocols = myCoreType
   * ``````
   *
   * The supported WebSocket sub-protocols. See [WebSocketPeer.supportedProtocols] for more details.
   */
  @CoreTypeHelper
  public final fun supportedProtocolsMutate(block: PackedStringArray.() -> Unit): PackedStringArray
      = supportedProtocols.apply {
     block(this)
     supportedProtocols = this
  }

  /**
   * This is a helper function for [supportedProtocols] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The supported WebSocket sub-protocols. See [WebSocketPeer.supportedProtocols] for more details.
   */
  @CoreTypeHelper
  public final fun supportedProtocolsMutateEach(block: (index: Int, `value`: String) -> Unit):
      PackedStringArray = supportedProtocols.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     supportedProtocols = this
  }

  /**
   * This is a helper function for [handshakeHeaders] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = websocketmultiplayerpeer.handshakeHeaders
   * //Your changes
   * websocketmultiplayerpeer.handshakeHeaders = myCoreType
   * ``````
   *
   * The extra headers to use during handshake. See [WebSocketPeer.handshakeHeaders] for more
   * details.
   */
  @CoreTypeHelper
  public final fun handshakeHeadersMutate(block: PackedStringArray.() -> Unit): PackedStringArray =
      handshakeHeaders.apply {
     block(this)
     handshakeHeaders = this
  }

  /**
   * This is a helper function for [handshakeHeaders] to make dealing with local copies easier.
   * Allow to directly modify each element of the local copy of the property and assign it back to
   * the Object.
   *
   * The extra headers to use during handshake. See [WebSocketPeer.handshakeHeaders] for more
   * details.
   */
  @CoreTypeHelper
  public final fun handshakeHeadersMutateEach(block: (index: Int, `value`: String) -> Unit):
      PackedStringArray = handshakeHeaders.apply {
     this.forEachIndexed { index, value ->
         block(index, value)
         this[index] = value
     }
     handshakeHeaders = this
  }

  /**
   * Starts a new multiplayer client connecting to the given [url]. TLS certificates will be
   * verified against the hostname when connecting using the `wss://` protocol. You can pass the
   * optional [tlsClientOptions] parameter to customize the trusted certification authorities, or
   * disable the common name verification. See [TLSOptions.client] and [TLSOptions.clientUnsafe].
   *
   * **Note:** It is recommended to specify the scheme part of the URL, i.e. the [url] should start
   * with either `ws://` or `wss://`.
   */
  @JvmOverloads
  public final fun createClient(url: String, tlsClientOptions: TLSOptions? = null): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to url, OBJECT to tlsClientOptions)
    TransferContext.callMethod(MethodBindings.createClientPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Starts a new multiplayer server listening on the given [port]. You can optionally specify a
   * [bindAddress], and provide valid [tlsServerOptions] to use TLS. See [TLSOptions.server].
   */
  @JvmOverloads
  public final fun createServer(
    port: Int,
    bindAddress: String = "*",
    tlsServerOptions: TLSOptions? = null,
  ): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to port.toLong(), STRING to bindAddress, OBJECT to tlsServerOptions)
    TransferContext.callMethod(MethodBindings.createServerPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the [WebSocketPeer] associated to the given [peerId].
   */
  public final fun getPeer(peerId: Int): WebSocketPeer? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to peerId.toLong())
    TransferContext.callMethod(MethodBindings.getPeerPtr)
    return (TransferContext.readReturnValue(OBJECT) as WebSocketPeer?)
  }

  /**
   * Returns the IP address of the given peer.
   */
  public final fun getPeerAddress(id: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getPeerAddressPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the remote port of the given peer.
   */
  public final fun getPeerPort(id: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getPeerPortPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun getSupportedProtocols(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportedProtocolsPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  public final fun setSupportedProtocols(protocols: PackedStringArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_STRING_ARRAY to protocols)
    TransferContext.callMethod(MethodBindings.setSupportedProtocolsPtr)
  }

  public final fun getHandshakeHeaders(): PackedStringArray {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHandshakeHeadersPtr)
    return (TransferContext.readReturnValue(PACKED_STRING_ARRAY) as PackedStringArray)
  }

  public final fun setHandshakeHeaders(protocols: PackedStringArray): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_STRING_ARRAY to protocols)
    TransferContext.callMethod(MethodBindings.setHandshakeHeadersPtr)
  }

  public final fun getInboundBufferSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInboundBufferSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setInboundBufferSize(bufferSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bufferSize.toLong())
    TransferContext.callMethod(MethodBindings.setInboundBufferSizePtr)
  }

  public final fun getOutboundBufferSize(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOutboundBufferSizePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setOutboundBufferSize(bufferSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bufferSize.toLong())
    TransferContext.callMethod(MethodBindings.setOutboundBufferSizePtr)
  }

  public final fun getHandshakeTimeout(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHandshakeTimeoutPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setHandshakeTimeout(timeout: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to timeout.toDouble())
    TransferContext.callMethod(MethodBindings.setHandshakeTimeoutPtr)
  }

  public final fun setMaxQueuedPackets(maxQueuedPackets: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxQueuedPackets.toLong())
    TransferContext.callMethod(MethodBindings.setMaxQueuedPacketsPtr)
  }

  public final fun getMaxQueuedPackets(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxQueuedPacketsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public companion object {
    @JvmField
    public val createClientName:
        MethodStringName2<WebSocketMultiplayerPeer, Error, String, TLSOptions?> =
        MethodStringName2<WebSocketMultiplayerPeer, Error, String, TLSOptions?>("create_client")

    @JvmField
    public val createServerName:
        MethodStringName3<WebSocketMultiplayerPeer, Error, Int, String, TLSOptions?> =
        MethodStringName3<WebSocketMultiplayerPeer, Error, Int, String, TLSOptions?>("create_server")

    @JvmField
    public val getPeerName: MethodStringName1<WebSocketMultiplayerPeer, WebSocketPeer?, Int> =
        MethodStringName1<WebSocketMultiplayerPeer, WebSocketPeer?, Int>("get_peer")

    @JvmField
    public val getPeerAddressName: MethodStringName1<WebSocketMultiplayerPeer, String, Int> =
        MethodStringName1<WebSocketMultiplayerPeer, String, Int>("get_peer_address")

    @JvmField
    public val getPeerPortName: MethodStringName1<WebSocketMultiplayerPeer, Int, Int> =
        MethodStringName1<WebSocketMultiplayerPeer, Int, Int>("get_peer_port")

    @JvmField
    public val getSupportedProtocolsName:
        MethodStringName0<WebSocketMultiplayerPeer, PackedStringArray> =
        MethodStringName0<WebSocketMultiplayerPeer, PackedStringArray>("get_supported_protocols")

    @JvmField
    public val setSupportedProtocolsName:
        MethodStringName1<WebSocketMultiplayerPeer, Unit, PackedStringArray> =
        MethodStringName1<WebSocketMultiplayerPeer, Unit, PackedStringArray>("set_supported_protocols")

    @JvmField
    public val getHandshakeHeadersName:
        MethodStringName0<WebSocketMultiplayerPeer, PackedStringArray> =
        MethodStringName0<WebSocketMultiplayerPeer, PackedStringArray>("get_handshake_headers")

    @JvmField
    public val setHandshakeHeadersName:
        MethodStringName1<WebSocketMultiplayerPeer, Unit, PackedStringArray> =
        MethodStringName1<WebSocketMultiplayerPeer, Unit, PackedStringArray>("set_handshake_headers")

    @JvmField
    public val getInboundBufferSizeName: MethodStringName0<WebSocketMultiplayerPeer, Int> =
        MethodStringName0<WebSocketMultiplayerPeer, Int>("get_inbound_buffer_size")

    @JvmField
    public val setInboundBufferSizeName: MethodStringName1<WebSocketMultiplayerPeer, Unit, Int> =
        MethodStringName1<WebSocketMultiplayerPeer, Unit, Int>("set_inbound_buffer_size")

    @JvmField
    public val getOutboundBufferSizeName: MethodStringName0<WebSocketMultiplayerPeer, Int> =
        MethodStringName0<WebSocketMultiplayerPeer, Int>("get_outbound_buffer_size")

    @JvmField
    public val setOutboundBufferSizeName: MethodStringName1<WebSocketMultiplayerPeer, Unit, Int> =
        MethodStringName1<WebSocketMultiplayerPeer, Unit, Int>("set_outbound_buffer_size")

    @JvmField
    public val getHandshakeTimeoutName: MethodStringName0<WebSocketMultiplayerPeer, Float> =
        MethodStringName0<WebSocketMultiplayerPeer, Float>("get_handshake_timeout")

    @JvmField
    public val setHandshakeTimeoutName: MethodStringName1<WebSocketMultiplayerPeer, Unit, Float> =
        MethodStringName1<WebSocketMultiplayerPeer, Unit, Float>("set_handshake_timeout")

    @JvmField
    public val setMaxQueuedPacketsName: MethodStringName1<WebSocketMultiplayerPeer, Unit, Int> =
        MethodStringName1<WebSocketMultiplayerPeer, Unit, Int>("set_max_queued_packets")

    @JvmField
    public val getMaxQueuedPacketsName: MethodStringName0<WebSocketMultiplayerPeer, Int> =
        MethodStringName0<WebSocketMultiplayerPeer, Int>("get_max_queued_packets")
  }

  public object MethodBindings {
    internal val createClientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "create_client", 1966198364)

    internal val createServerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "create_server", 2400822951)

    internal val getPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_peer", 1381378851)

    internal val getPeerAddressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_peer_address", 844755477)

    internal val getPeerPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_peer_port", 923996154)

    internal val getSupportedProtocolsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_supported_protocols", 1139954409)

    internal val setSupportedProtocolsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "set_supported_protocols", 4015028928)

    internal val getHandshakeHeadersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_handshake_headers", 1139954409)

    internal val setHandshakeHeadersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "set_handshake_headers", 4015028928)

    internal val getInboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_inbound_buffer_size", 3905245786)

    internal val setInboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "set_inbound_buffer_size", 1286410249)

    internal val getOutboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_outbound_buffer_size", 3905245786)

    internal val setOutboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "set_outbound_buffer_size", 1286410249)

    internal val getHandshakeTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_handshake_timeout", 1740695150)

    internal val setHandshakeTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "set_handshake_timeout", 373806689)

    internal val setMaxQueuedPacketsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "set_max_queued_packets", 1286410249)

    internal val getMaxQueuedPacketsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketMultiplayerPeer", "get_max_queued_packets", 3905245786)
  }
}
