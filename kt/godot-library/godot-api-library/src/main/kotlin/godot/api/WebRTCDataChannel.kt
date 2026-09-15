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
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

@GodotBaseType
public open class WebRTCDataChannel internal constructor() : PacketPeer() {
  /**
   * The transfer mode to use when sending outgoing packet. Either text or binary.
   */
  public final inline var writeMode: WriteMode
    @JvmName("writeModeProperty")
    get() = getWriteMode()
    @JvmName("writeModeProperty")
    set(`value`) {
      setWriteMode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(919, scriptPtr)
  }

  /**
   * Reserved, but not used for now.
   */
  public final fun poll(): Error {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.pollPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Closes this data channel, notifying the other peer.
   */
  public final fun close(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.closePtr, 0)
  }

  /**
   * Returns `true` if the last received packet was transferred as text. See [writeMode].
   */
  public final fun wasStringPacket(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.wasStringPacketPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setWriteMode(writeMode: WriteMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, writeMode.value)
    TransferContext.callPtrMethod(MethodBindings.setWriteModePtr, 0)
  }

  public final fun getWriteMode(): WriteMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getWriteModePtr, 2)
    return WriteMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the current state of this channel.
   */
  public final fun getReadyState(): ChannelState {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getReadyStatePtr, 2)
    return ChannelState.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the label assigned to this channel during creation.
   */
  public final fun getLabel(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLabelPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if this channel was created with ordering enabled (default).
   */
  public final fun isOrdered(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isOrderedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the ID assigned to this channel during creation (or auto-assigned during negotiation).
   *
   * If the channel is not negotiated out-of-band the ID will only be available after the connection
   * is established (will return `65535` until then).
   */
  public final fun getId(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIdPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the `maxPacketLifeTime` value assigned to this channel during creation.
   *
   * Will be `65535` if not specified.
   */
  public final fun getMaxPacketLifeTime(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxPacketLifeTimePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the `maxRetransmits` value assigned to this channel during creation.
   *
   * Will be `65535` if not specified.
   */
  public final fun getMaxRetransmits(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxRetransmitsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the sub-protocol assigned to this channel during creation. An empty string if not
   * specified.
   */
  public final fun getProtocol(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProtocolPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if this channel was created with out-of-band configuration.
   */
  public final fun isNegotiated(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isNegotiatedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the number of bytes currently queued to be sent over this channel.
   */
  public final fun getBufferedAmount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBufferedAmountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public enum class WriteMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Tells the channel to send data over this channel as text. An external peer (non-Godot) would
     * receive this as a string.
     */
    TEXT(0),
    /**
     * Tells the channel to send data over this channel as binary. An external peer (non-Godot)
     * would receive this as array buffer or blob.
     */
    BINARY(1),
    ;

    public companion object {
      public fun from(`value`: Long): WriteMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ChannelState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The channel was created, but it's still trying to connect.
     */
    STATE_CONNECTING(0),
    /**
     * The channel is currently open, and data can flow over it.
     */
    STATE_OPEN(1),
    /**
     * The channel is being closed, no new messages will be accepted, but those already in queue
     * will be flushed.
     */
    STATE_CLOSING(2),
    /**
     * The channel was closed, or connection failed.
     */
    STATE_CLOSED(3),
    ;

    public companion object {
      public fun from(`value`: Long): ChannelState = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val pollName: MethodStringName0<WebRTCDataChannel, Error> =
        MethodStringName0<WebRTCDataChannel, Error>("poll")

    @JvmField
    public val closeName: MethodStringName0<WebRTCDataChannel, Unit> =
        MethodStringName0<WebRTCDataChannel, Unit>("close")

    @JvmField
    public val wasStringPacketName: MethodStringName0<WebRTCDataChannel, Boolean> =
        MethodStringName0<WebRTCDataChannel, Boolean>("was_string_packet")

    @JvmField
    public val setWriteModeName: MethodStringName1<WebRTCDataChannel, Unit, WriteMode> =
        MethodStringName1<WebRTCDataChannel, Unit, WriteMode>("set_write_mode")

    @JvmField
    public val getWriteModeName: MethodStringName0<WebRTCDataChannel, WriteMode> =
        MethodStringName0<WebRTCDataChannel, WriteMode>("get_write_mode")

    @JvmField
    public val getReadyStateName: MethodStringName0<WebRTCDataChannel, ChannelState> =
        MethodStringName0<WebRTCDataChannel, ChannelState>("get_ready_state")

    @JvmField
    public val getLabelName: MethodStringName0<WebRTCDataChannel, String> =
        MethodStringName0<WebRTCDataChannel, String>("get_label")

    @JvmField
    public val isOrderedName: MethodStringName0<WebRTCDataChannel, Boolean> =
        MethodStringName0<WebRTCDataChannel, Boolean>("is_ordered")

    @JvmField
    public val getIdName: MethodStringName0<WebRTCDataChannel, Int> =
        MethodStringName0<WebRTCDataChannel, Int>("get_id")

    @JvmField
    public val getMaxPacketLifeTimeName: MethodStringName0<WebRTCDataChannel, Int> =
        MethodStringName0<WebRTCDataChannel, Int>("get_max_packet_life_time")

    @JvmField
    public val getMaxRetransmitsName: MethodStringName0<WebRTCDataChannel, Int> =
        MethodStringName0<WebRTCDataChannel, Int>("get_max_retransmits")

    @JvmField
    public val getProtocolName: MethodStringName0<WebRTCDataChannel, String> =
        MethodStringName0<WebRTCDataChannel, String>("get_protocol")

    @JvmField
    public val isNegotiatedName: MethodStringName0<WebRTCDataChannel, Boolean> =
        MethodStringName0<WebRTCDataChannel, Boolean>("is_negotiated")

    @JvmField
    public val getBufferedAmountName: MethodStringName0<WebRTCDataChannel, Int> =
        MethodStringName0<WebRTCDataChannel, Int>("get_buffered_amount")
  }

  public object MethodBindings {
    internal val pollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "poll", 166280745)

    internal val closePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "close", 3218959716)

    internal val wasStringPacketPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "was_string_packet", 36873697)

    internal val setWriteModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "set_write_mode", 1999768052)

    internal val getWriteModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_write_mode", 2848495172)

    internal val getReadyStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_ready_state", 3501143017)

    internal val getLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_label", 201670096)

    internal val isOrderedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "is_ordered", 36873697)

    internal val getIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_id", 3905245786)

    internal val getMaxPacketLifeTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_max_packet_life_time", 3905245786)

    internal val getMaxRetransmitsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_max_retransmits", 3905245786)

    internal val getProtocolPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_protocol", 201670096)

    internal val isNegotiatedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "is_negotiated", 36873697)

    internal val getBufferedAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCDataChannel", "get_buffered_amount", 3905245786)
  }
}
