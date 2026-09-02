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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_BYTE_ARRAY
import godot.core.VariantParser.PACKED_STRING_ARRAY
import godot.core.VariantParser.STRING
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
 * This class represents WebSocket connection, and can be used as a WebSocket client
 * ([url=https://datatracker.ietf.org/doc/html/rfc6455]RFC 6455[/url]-compliant) or as a remote peer of
 * a WebSocket server.
 *
 * You can send WebSocket binary frames using [PacketPeer.putPacket], and WebSocket text frames
 * using [send] (prefer text frames when interacting with text-based API). You can check the frame type
 * of the last packet via [wasStringPacket].
 *
 * To start a WebSocket client, first call [connectToUrl], then regularly call [poll] (e.g. during
 * [Node] process). You can query the socket state via [getReadyState], get the number of pending
 * packets using [PacketPeer.getAvailablePacketCount], and retrieve them via [PacketPeer.getPacket].
 *
 * ```gdscript
 * //gdscript
 * extends Node
 *
 * var socket = WebSocketPeer.new()
 *
 * func _ready():
 * 	socket.connect_to_url("wss://example.com")
 *
 * func _process(delta):
 * 	socket.poll()
 * 	var state = socket.get_ready_state()
 * 	if state == WebSocketPeer.STATE_OPEN:
 * 		while socket.get_available_packet_count():
 * 			print("Packet: ", socket.get_packet())
 * 	elif state == WebSocketPeer.STATE_CLOSING:
 * 		# Keep polling to achieve proper close.
 * 		pass
 * 	elif state == WebSocketPeer.STATE_CLOSED:
 * 		var code = socket.get_close_code()
 * 		var reason = socket.get_close_reason()
 * 		print("WebSocket closed with code: &#37;d, reason &#37;s. Clean: &#37;s" &#37; [code, reason,
 * code != -1])
 * 		set_process(false) # Stop processing.
 * ```
 *
 * To use the peer as part of a WebSocket server refer to [acceptStream] and the online tutorial.
 */
@GodotBaseType
public open class WebSocketPeer : PacketPeer() {
  /**
   * The WebSocket sub-protocols allowed during the WebSocket handshake.
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
   * The extra HTTP headers to be sent during the WebSocket handshake.
   *
   * **Note:** Not supported in Web exports due to browsers' restrictions.
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
   * The size of the input buffer in bytes (roughly the maximum amount of memory that will be
   * allocated for the inbound packets).
   */
  public final inline var inboundBufferSize: Int
    @JvmName("inboundBufferSizeProperty")
    get() = getInboundBufferSize()
    @JvmName("inboundBufferSizeProperty")
    set(`value`) {
      setInboundBufferSize(value)
    }

  /**
   * The size of the input buffer in bytes (roughly the maximum amount of memory that will be
   * allocated for the outbound packets).
   */
  public final inline var outboundBufferSize: Int
    @JvmName("outboundBufferSizeProperty")
    get() = getOutboundBufferSize()
    @JvmName("outboundBufferSizeProperty")
    set(`value`) {
      setOutboundBufferSize(value)
    }

  /**
   * The maximum amount of packets that will be allowed in the queues (both inbound and outbound).
   */
  public final inline var maxQueuedPackets: Int
    @JvmName("maxQueuedPacketsProperty")
    get() = getMaxQueuedPackets()
    @JvmName("maxQueuedPacketsProperty")
    set(`value`) {
      setMaxQueuedPackets(value)
    }

  /**
   * The interval (in seconds) at which the peer will automatically send WebSocket "ping" control
   * frames. When set to `0`, no "ping" control frames will be sent.
   *
   * **Note:** Has no effect in Web exports due to browser restrictions.
   */
  public final inline var heartbeatInterval: Double
    @JvmName("heartbeatIntervalProperty")
    get() = getHeartbeatInterval()
    @JvmName("heartbeatIntervalProperty")
    set(`value`) {
      setHeartbeatInterval(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(925, scriptPtr)
  }

  /**
   * This is a helper function for [supportedProtocols] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = websocketpeer.supportedProtocols
   * //Your changes
   * websocketpeer.supportedProtocols = myCoreType
   * ``````
   *
   * The WebSocket sub-protocols allowed during the WebSocket handshake.
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
   * The WebSocket sub-protocols allowed during the WebSocket handshake.
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
   * val myCoreType = websocketpeer.handshakeHeaders
   * //Your changes
   * websocketpeer.handshakeHeaders = myCoreType
   * ``````
   *
   * The extra HTTP headers to be sent during the WebSocket handshake.
   *
   * **Note:** Not supported in Web exports due to browsers' restrictions.
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
   * The extra HTTP headers to be sent during the WebSocket handshake.
   *
   * **Note:** Not supported in Web exports due to browsers' restrictions.
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
   * Connects to the given URL. TLS certificates will be verified against the hostname when
   * connecting using the `wss://` protocol. You can pass the optional [tlsClientOptions] parameter to
   * customize the trusted certification authorities, or disable the common name verification. See
   * [TLSOptions.client] and [TLSOptions.clientUnsafe].
   *
   * **Note:** This method is non-blocking, and will return [OK] before the connection is
   * established as long as the provided parameters are valid and the peer is not in an invalid state
   * (e.g. already connected). Regularly call [poll] (e.g. during [Node] process) and check the result
   * of [getReadyState] to know whether the connection succeeds or fails.
   *
   * **Note:** To avoid mixed content warnings or errors in Web, you may have to use a [url] that
   * starts with `wss://` (secure) instead of `ws://`. When doing so, make sure to use the fully
   * qualified domain name that matches the one defined in the server's TLS certificate. Do not connect
   * directly via the IP address for `wss://` connections, as it won't match with the TLS certificate.
   */
  @JvmOverloads
  public final fun connectToUrl(url: String, tlsClientOptions: TLSOptions? = null): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to url, OBJECT to tlsClientOptions)
    TransferContext.callMethod(MethodBindings.connectToUrlPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Accepts a peer connection performing the HTTP handshake as a WebSocket server. The [stream]
   * must be a valid TCP stream retrieved via [TCPServer.takeConnection], or a TLS stream accepted via
   * [StreamPeerTLS.acceptStream].
   *
   * **Note:** Not supported in Web exports due to browsers' restrictions.
   */
  public final fun acceptStream(stream: StreamPeer?): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to stream)
    TransferContext.callMethod(MethodBindings.acceptStreamPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sends the given [message] using the desired [writeMode]. When sending a [String], prefer using
   * [sendText].
   */
  @JvmOverloads
  public final fun send(message: PackedByteArray, writeMode: WriteMode =
      WebSocketPeer.WriteMode.BINARY): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, PACKED_BYTE_ARRAY to message, LONG to writeMode.value)
    TransferContext.callMethod(MethodBindings.sendPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sends the given [message] using WebSocket text mode. Prefer this method over
   * [PacketPeer.putPacket] when interacting with third-party text-based API (e.g. when using [JSON]
   * formatted messages).
   */
  public final fun sendText(message: String): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to message)
    TransferContext.callMethod(MethodBindings.sendTextPtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the last received packet was sent as a text payload. See [WriteMode].
   */
  public final fun wasStringPacket(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.wasStringPacketPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Updates the connection state and receive incoming packets. Call this function regularly to keep
   * it in a clean state.
   */
  public final fun poll(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.pollPtr)
  }

  /**
   * Closes this WebSocket connection.
   *
   * [code] is the status code for the closure (see
   * [url=https://datatracker.ietf.org/doc/html/rfc6455#section-7.4.1]RFC 6455 section 7.4[/url] for a
   * list of valid status codes). If [code] is negative, the connection will be closed immediately
   * without notifying the remote peer.
   *
   * [reason] is the human-readable reason for closing the connection. It can be any UTF-8 string
   * that's smaller than 123 bytes.
   *
   * **Note:** To achieve a clean closure, you will need to keep polling until [STATE_CLOSED] is
   * reached.
   *
   * **Note:** The Web export might not support all status codes. Please refer to browser-specific
   * documentation for more details.
   */
  @JvmOverloads
  public final fun close(code: Int = 1000, reason: String = ""): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to code.toLong(), STRING to reason)
    TransferContext.callMethod(MethodBindings.closePtr)
  }

  /**
   * Returns the IP address of the connected peer.
   *
   * **Note:** Not available in the Web export.
   */
  public final fun getConnectedHost(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectedHostPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the remote port of the connected peer.
   *
   * **Note:** Not available in the Web export.
   */
  public final fun getConnectedPort(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectedPortPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the selected WebSocket sub-protocol for this connection or an empty string if the
   * sub-protocol has not been selected yet.
   */
  public final fun getSelectedProtocol(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedProtocolPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the URL requested by this peer. The URL is derived from the `url` passed to
   * [connectToUrl] or from the HTTP headers when acting as server (i.e. when using [acceptStream]).
   */
  public final fun getRequestedUrl(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRequestedUrlPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Disable Nagle's algorithm on the underlying TCP socket (default). See
   * [StreamPeerTCP.setNoDelay] for more information.
   *
   * **Note:** Not available in the Web export.
   */
  public final fun setNoDelay(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setNoDelayPtr)
  }

  /**
   * Returns the current amount of data in the outbound websocket buffer. **Note:** Web exports use
   * WebSocket.bufferedAmount, while other platforms use an internal buffer.
   */
  public final fun getCurrentOutboundBufferedAmount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentOutboundBufferedAmountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the ready state of the connection.
   */
  public final fun getReadyState(): State {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReadyStatePtr)
    return State.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the received WebSocket close frame status code, or `-1` when the connection was not
   * cleanly closed. Only call this method when [getReadyState] returns [STATE_CLOSED].
   */
  public final fun getCloseCode(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCloseCodePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the received WebSocket close frame status reason string. Only call this method when
   * [getReadyState] returns [STATE_CLOSED].
   */
  public final fun getCloseReason(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCloseReasonPtr)
    return (TransferContext.readReturnValue(STRING) as String)
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

  public final fun setMaxQueuedPackets(bufferSize: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to bufferSize.toLong())
    TransferContext.callMethod(MethodBindings.setMaxQueuedPacketsPtr)
  }

  public final fun getMaxQueuedPackets(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxQueuedPacketsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setHeartbeatInterval(interval: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to interval)
    TransferContext.callMethod(MethodBindings.setHeartbeatIntervalPtr)
  }

  public final fun getHeartbeatInterval(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHeartbeatIntervalPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  public enum class WriteMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Specifies that WebSockets messages should be transferred as text payload (only valid UTF-8 is
     * allowed).
     */
    TEXT(0),
    /**
     * Specifies that WebSockets messages should be transferred as binary payload (any byte
     * combination is allowed).
     */
    BINARY(1),
    ;

    public companion object {
      public fun from(`value`: Long): WriteMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class State(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Socket has been created. The connection is not yet open.
     */
    CONNECTING(0),
    /**
     * The connection is open and ready to communicate.
     */
    OPEN(1),
    /**
     * The connection is in the process of closing. This means a close request has been sent to the
     * remote peer but confirmation has not been received.
     */
    CLOSING(2),
    /**
     * The connection is closed or couldn't be opened.
     */
    CLOSED(3),
    ;

    public companion object {
      public fun from(`value`: Long): State = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val connectToUrlName: MethodStringName2<WebSocketPeer, Error, String, TLSOptions?> =
        MethodStringName2<WebSocketPeer, Error, String, TLSOptions?>("connect_to_url")

    @JvmField
    public val acceptStreamName: MethodStringName1<WebSocketPeer, Error, StreamPeer?> =
        MethodStringName1<WebSocketPeer, Error, StreamPeer?>("accept_stream")

    @JvmField
    public val sendName: MethodStringName2<WebSocketPeer, Error, PackedByteArray, WriteMode> =
        MethodStringName2<WebSocketPeer, Error, PackedByteArray, WriteMode>("send")

    @JvmField
    public val sendTextName: MethodStringName1<WebSocketPeer, Error, String> =
        MethodStringName1<WebSocketPeer, Error, String>("send_text")

    @JvmField
    public val wasStringPacketName: MethodStringName0<WebSocketPeer, Boolean> =
        MethodStringName0<WebSocketPeer, Boolean>("was_string_packet")

    @JvmField
    public val pollName: MethodStringName0<WebSocketPeer, Unit> =
        MethodStringName0<WebSocketPeer, Unit>("poll")

    @JvmField
    public val closeName: MethodStringName2<WebSocketPeer, Unit, Int, String> =
        MethodStringName2<WebSocketPeer, Unit, Int, String>("close")

    @JvmField
    public val getConnectedHostName: MethodStringName0<WebSocketPeer, String> =
        MethodStringName0<WebSocketPeer, String>("get_connected_host")

    @JvmField
    public val getConnectedPortName: MethodStringName0<WebSocketPeer, Int> =
        MethodStringName0<WebSocketPeer, Int>("get_connected_port")

    @JvmField
    public val getSelectedProtocolName: MethodStringName0<WebSocketPeer, String> =
        MethodStringName0<WebSocketPeer, String>("get_selected_protocol")

    @JvmField
    public val getRequestedUrlName: MethodStringName0<WebSocketPeer, String> =
        MethodStringName0<WebSocketPeer, String>("get_requested_url")

    @JvmField
    public val setNoDelayName: MethodStringName1<WebSocketPeer, Unit, Boolean> =
        MethodStringName1<WebSocketPeer, Unit, Boolean>("set_no_delay")

    @JvmField
    public val getCurrentOutboundBufferedAmountName: MethodStringName0<WebSocketPeer, Int> =
        MethodStringName0<WebSocketPeer, Int>("get_current_outbound_buffered_amount")

    @JvmField
    public val getReadyStateName: MethodStringName0<WebSocketPeer, State> =
        MethodStringName0<WebSocketPeer, State>("get_ready_state")

    @JvmField
    public val getCloseCodeName: MethodStringName0<WebSocketPeer, Int> =
        MethodStringName0<WebSocketPeer, Int>("get_close_code")

    @JvmField
    public val getCloseReasonName: MethodStringName0<WebSocketPeer, String> =
        MethodStringName0<WebSocketPeer, String>("get_close_reason")

    @JvmField
    public val getSupportedProtocolsName: MethodStringName0<WebSocketPeer, PackedStringArray> =
        MethodStringName0<WebSocketPeer, PackedStringArray>("get_supported_protocols")

    @JvmField
    public val setSupportedProtocolsName: MethodStringName1<WebSocketPeer, Unit, PackedStringArray>
        = MethodStringName1<WebSocketPeer, Unit, PackedStringArray>("set_supported_protocols")

    @JvmField
    public val getHandshakeHeadersName: MethodStringName0<WebSocketPeer, PackedStringArray> =
        MethodStringName0<WebSocketPeer, PackedStringArray>("get_handshake_headers")

    @JvmField
    public val setHandshakeHeadersName: MethodStringName1<WebSocketPeer, Unit, PackedStringArray> =
        MethodStringName1<WebSocketPeer, Unit, PackedStringArray>("set_handshake_headers")

    @JvmField
    public val getInboundBufferSizeName: MethodStringName0<WebSocketPeer, Int> =
        MethodStringName0<WebSocketPeer, Int>("get_inbound_buffer_size")

    @JvmField
    public val setInboundBufferSizeName: MethodStringName1<WebSocketPeer, Unit, Int> =
        MethodStringName1<WebSocketPeer, Unit, Int>("set_inbound_buffer_size")

    @JvmField
    public val getOutboundBufferSizeName: MethodStringName0<WebSocketPeer, Int> =
        MethodStringName0<WebSocketPeer, Int>("get_outbound_buffer_size")

    @JvmField
    public val setOutboundBufferSizeName: MethodStringName1<WebSocketPeer, Unit, Int> =
        MethodStringName1<WebSocketPeer, Unit, Int>("set_outbound_buffer_size")

    @JvmField
    public val setMaxQueuedPacketsName: MethodStringName1<WebSocketPeer, Unit, Int> =
        MethodStringName1<WebSocketPeer, Unit, Int>("set_max_queued_packets")

    @JvmField
    public val getMaxQueuedPacketsName: MethodStringName0<WebSocketPeer, Int> =
        MethodStringName0<WebSocketPeer, Int>("get_max_queued_packets")

    @JvmField
    public val setHeartbeatIntervalName: MethodStringName1<WebSocketPeer, Unit, Double> =
        MethodStringName1<WebSocketPeer, Unit, Double>("set_heartbeat_interval")

    @JvmField
    public val getHeartbeatIntervalName: MethodStringName0<WebSocketPeer, Double> =
        MethodStringName0<WebSocketPeer, Double>("get_heartbeat_interval")
  }

  public object MethodBindings {
    internal val connectToUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "connect_to_url", 1966198364)

    internal val acceptStreamPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "accept_stream", 255125695)

    internal val sendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "send", 2780360567)

    internal val sendTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "send_text", 166001499)

    internal val wasStringPacketPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "was_string_packet", 36873697)

    internal val pollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "poll", 3218959716)

    internal val closePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "close", 1047156615)

    internal val getConnectedHostPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_connected_host", 201670096)

    internal val getConnectedPortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_connected_port", 3905245786)

    internal val getSelectedProtocolPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_selected_protocol", 201670096)

    internal val getRequestedUrlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_requested_url", 201670096)

    internal val setNoDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "set_no_delay", 2586408642)

    internal val getCurrentOutboundBufferedAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_current_outbound_buffered_amount", 3905245786)

    internal val getReadyStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_ready_state", 346482985)

    internal val getCloseCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_close_code", 3905245786)

    internal val getCloseReasonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_close_reason", 201670096)

    internal val getSupportedProtocolsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_supported_protocols", 1139954409)

    internal val setSupportedProtocolsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "set_supported_protocols", 4015028928)

    internal val getHandshakeHeadersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_handshake_headers", 1139954409)

    internal val setHandshakeHeadersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "set_handshake_headers", 4015028928)

    internal val getInboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_inbound_buffer_size", 3905245786)

    internal val setInboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "set_inbound_buffer_size", 1286410249)

    internal val getOutboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_outbound_buffer_size", 3905245786)

    internal val setOutboundBufferSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "set_outbound_buffer_size", 1286410249)

    internal val setMaxQueuedPacketsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "set_max_queued_packets", 1286410249)

    internal val getMaxQueuedPacketsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_max_queued_packets", 3905245786)

    internal val setHeartbeatIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "set_heartbeat_interval", 373806689)

    internal val getHeartbeatIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebSocketPeer", "get_heartbeat_interval", 1740695150)
  }
}
