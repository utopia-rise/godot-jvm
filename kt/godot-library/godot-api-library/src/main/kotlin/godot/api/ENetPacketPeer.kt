// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_LONG_LONG
import godot.callPtrMethod_LONG_PACKED_BYTE_ARRAY_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName3
import godot.core.PackedByteArray
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
 * A PacketPeer implementation representing a peer of an [ENetConnection].
 *
 * This class cannot be instantiated directly but can be retrieved during [ENetConnection.service]
 * or via [ENetConnection.getPeers].
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class ENetPacketPeer internal constructor() : PacketPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(212, scriptPtr)
  }

  /**
   * Request a disconnection from a peer. An [ENetConnection.EVENT_DISCONNECT] will be generated
   * during [ENetConnection.service] once the disconnection is complete.
   */
  @JvmOverloads
  public final fun peerDisconnect(`data`: Int = 0): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.peerDisconnectPtr, data.toLong())
  }

  /**
   * Request a disconnection from a peer, but only after all queued outgoing packets are sent. An
   * [ENetConnection.EVENT_DISCONNECT] will be generated during [ENetConnection.service] once the
   * disconnection is complete.
   */
  @JvmOverloads
  public final fun peerDisconnectLater(`data`: Int = 0): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.peerDisconnectLaterPtr, data.toLong())
  }

  /**
   * Force an immediate disconnection from a peer. No [ENetConnection.EVENT_DISCONNECT] will be
   * generated. The foreign peer is not guaranteed to receive the disconnect notification, and is reset
   * immediately upon return from this function.
   */
  @JvmOverloads
  public final fun peerDisconnectNow(`data`: Int = 0): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.peerDisconnectNowPtr, data.toLong())
  }

  /**
   * Sends a ping request to a peer. ENet automatically pings all connected peers at regular
   * intervals, however, this function may be called to ensure more frequent ping requests.
   */
  public final fun ping(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.pingPtr)
  }

  /**
   * Sets the [pingInterval] in milliseconds at which pings will be sent to a peer. Pings are used
   * both to monitor the liveness of the connection and also to dynamically adjust the throttle during
   * periods of low traffic so that the throttle has reasonable responsiveness during traffic spikes.
   * The default ping interval is `500` milliseconds.
   */
  public final fun pingInterval(pingInterval: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.pingIntervalPtr, pingInterval.toLong())
  }

  /**
   * Forcefully disconnects a peer. The foreign host represented by the peer is not notified of the
   * disconnection and will timeout on its connection to the local host.
   */
  public final fun reset(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.resetPtr)
  }

  /**
   * Queues a [packet] to be sent over the specified [channel]. See `FLAG_*` constants for available
   * packet flags.
   */
  public final fun send(
    channel: Int,
    packet: PackedByteArray,
    flags: Int,
  ): Error =
      Error.from(TransferContext.callPtrMethod_LONG_PACKED_BYTE_ARRAY_LONG_ret_LONG(ptr, objectID.id, MethodBindings.sendPtr, channel.toLong(), packet, flags.toLong()))

  /**
   * Configures throttle parameter for a peer.
   *
   * Unreliable packets are dropped by ENet in response to the varying conditions of the Internet
   * connection to the peer. The throttle represents a probability that an unreliable packet should not
   * be dropped and thus sent by ENet to the peer. By measuring fluctuations in round trip times of
   * reliable packets over the specified [interval], ENet will either increase the probability by the
   * amount specified in the [acceleration] parameter, or decrease it by the amount specified in the
   * [deceleration] parameter (both are ratios to [PACKET_THROTTLE_SCALE]).
   *
   * When the throttle has a value of [PACKET_THROTTLE_SCALE], no unreliable packets are dropped by
   * ENet, and so 100&#37; of all unreliable packets will be sent.
   *
   * When the throttle has a value of `0`, all unreliable packets are dropped by ENet, and so 0&#37;
   * of all unreliable packets will be sent.
   *
   * Intermediate values for the throttle represent intermediate probabilities between 0&#37; and
   * 100&#37; of unreliable packets being sent. The bandwidth limits of the local and foreign hosts are
   * taken into account to determine a sensible limit for the throttle probability above which it
   * should not raise even in the best of conditions.
   */
  public final fun throttleConfigure(
    interval: Int,
    acceleration: Int,
    deceleration: Int,
  ): Unit {
    TransferContext.callPtrMethod_LONG_LONG_LONG(ptr, objectID.id, MethodBindings.throttleConfigurePtr, interval.toLong(), acceleration.toLong(), deceleration.toLong())
  }

  /**
   * Sets the timeout parameters for a peer. The timeout parameters control how and when a peer will
   * timeout from a failure to acknowledge reliable traffic. Timeout values are expressed in
   * milliseconds.
   *
   * The [timeout] is a factor that, multiplied by a value based on the average round trip time,
   * will determine the timeout limit for a reliable packet. When that limit is reached, the timeout
   * will be doubled, and the peer will be disconnected if that limit has reached [timeoutMin]. The
   * [timeoutMax] parameter, on the other hand, defines a fixed timeout for which any packet must be
   * acknowledged or the peer will be dropped.
   */
  public final fun setTimeout(
    timeout: Int,
    timeoutMin: Int,
    timeoutMax: Int,
  ): Unit {
    TransferContext.callPtrMethod_LONG_LONG_LONG(ptr, objectID.id, MethodBindings.setTimeoutPtr, timeout.toLong(), timeoutMin.toLong(), timeoutMax.toLong())
  }

  /**
   * Returns the ENet flags of the next packet in the received queue. See `FLAG_*` constants for
   * available packet flags. Note that not all flags are replicated from the sending peer to the
   * receiving peer.
   */
  public final fun getPacketFlags(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getPacketFlagsPtr).toInt()

  /**
   * Returns the IP address of this peer.
   */
  public final fun getRemoteAddress(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getRemoteAddressPtr)

  /**
   * Returns the remote port of this peer.
   */
  public final fun getRemotePort(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getRemotePortPtr).toInt()

  /**
   * Returns the requested [statistic] for this peer.
   */
  public final fun getStatistic(statistic: PeerStatistic): Double =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getStatisticPtr, statistic.value)

  /**
   * Returns the current peer state.
   */
  public final fun getState(): PeerState =
      PeerState.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getStatePtr))

  /**
   * Returns the number of channels allocated for communication with peer.
   */
  public final fun getChannels(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getChannelsPtr).toInt()

  /**
   * Returns `true` if the peer is currently active (i.e. the associated [ENetConnection] is still
   * valid).
   */
  public final fun isActive(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isActivePtr)

  public enum class PeerState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The peer is disconnected.
     */
    STATE_DISCONNECTED(0),
    /**
     * The peer is currently attempting to connect.
     */
    STATE_CONNECTING(1),
    /**
     * The peer has acknowledged the connection request.
     */
    STATE_ACKNOWLEDGING_CONNECT(2),
    /**
     * The peer is currently connecting.
     */
    STATE_CONNECTION_PENDING(3),
    /**
     * The peer has successfully connected, but is not ready to communicate with yet
     * ([STATE_CONNECTED]).
     */
    STATE_CONNECTION_SUCCEEDED(4),
    /**
     * The peer is currently connected and ready to communicate with.
     */
    STATE_CONNECTED(5),
    /**
     * The peer is expected to disconnect after it has no more outgoing packets to send.
     */
    STATE_DISCONNECT_LATER(6),
    /**
     * The peer is currently disconnecting.
     */
    STATE_DISCONNECTING(7),
    /**
     * The peer has acknowledged the disconnection request.
     */
    STATE_ACKNOWLEDGING_DISCONNECT(8),
    /**
     * The peer has lost connection, but is not considered truly disconnected (as the peer didn't
     * acknowledge the disconnection request).
     */
    STATE_ZOMBIE(9),
    ;

    public companion object {
      public fun from(`value`: Long): PeerState = entries.single { it.`value` == `value` }
    }
  }

  public enum class PeerStatistic(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Mean packet loss of reliable packets as a ratio with respect to the [PACKET_LOSS_SCALE].
     */
    PACKET_LOSS(0),
    /**
     * Packet loss variance.
     */
    PACKET_LOSS_VARIANCE(1),
    /**
     * The time at which packet loss statistics were last updated (in milliseconds since the
     * connection started). The interval for packet loss statistics updates is 10 seconds, and at least
     * one packet must have been sent since the last statistics update.
     */
    PACKET_LOSS_EPOCH(2),
    /**
     * Mean packet round trip time for reliable packets.
     */
    ROUND_TRIP_TIME(3),
    /**
     * Variance of the mean round trip time.
     */
    ROUND_TRIP_TIME_VARIANCE(4),
    /**
     * Last recorded round trip time for a reliable packet.
     */
    LAST_ROUND_TRIP_TIME(5),
    /**
     * Variance of the last trip time recorded.
     */
    LAST_ROUND_TRIP_TIME_VARIANCE(6),
    /**
     * The peer's current throttle status.
     */
    PACKET_THROTTLE(7),
    /**
     * The maximum number of unreliable packets that should not be dropped. This value is always
     * greater than or equal to `1`. The initial value is equal to [PACKET_THROTTLE_SCALE].
     */
    PACKET_THROTTLE_LIMIT(8),
    /**
     * Internal value used to increment the packet throttle counter. The value is hardcoded to `7`
     * and cannot be changed. You probably want to look at [PEER_PACKET_THROTTLE_ACCELERATION] instead.
     */
    PACKET_THROTTLE_COUNTER(9),
    /**
     * The time at which throttle statistics were last updated (in milliseconds since the connection
     * started). The interval for throttle statistics updates is [PEER_PACKET_THROTTLE_INTERVAL].
     */
    PACKET_THROTTLE_EPOCH(10),
    /**
     * The throttle's acceleration factor. Higher values will make ENet adapt to fluctuating network
     * conditions faster, causing unrelaible packets to be sent *more* often. The default value is `2`.
     */
    PACKET_THROTTLE_ACCELERATION(11),
    /**
     * The throttle's deceleration factor. Higher values will make ENet adapt to fluctuating network
     * conditions faster, causing unrelaible packets to be sent *less* often. The default value is `2`.
     */
    PACKET_THROTTLE_DECELERATION(12),
    /**
     * The interval over which the lowest mean round trip time should be measured for use by the
     * throttle mechanism (in milliseconds). The default value is `5000`.
     */
    PACKET_THROTTLE_INTERVAL(13),
    ;

    public companion object {
      public fun from(`value`: Long): PeerStatistic = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val peerDisconnectName: MethodStringName1<ENetPacketPeer, Unit, Int> =
        MethodStringName1<ENetPacketPeer, Unit, Int>("peer_disconnect")

    @JvmField
    public val peerDisconnectLaterName: MethodStringName1<ENetPacketPeer, Unit, Int> =
        MethodStringName1<ENetPacketPeer, Unit, Int>("peer_disconnect_later")

    @JvmField
    public val peerDisconnectNowName: MethodStringName1<ENetPacketPeer, Unit, Int> =
        MethodStringName1<ENetPacketPeer, Unit, Int>("peer_disconnect_now")

    @JvmField
    public val pingName: MethodStringName0<ENetPacketPeer, Unit> =
        MethodStringName0<ENetPacketPeer, Unit>("ping")

    @JvmField
    public val pingIntervalName: MethodStringName1<ENetPacketPeer, Unit, Int> =
        MethodStringName1<ENetPacketPeer, Unit, Int>("ping_interval")

    @JvmField
    public val resetName: MethodStringName0<ENetPacketPeer, Unit> =
        MethodStringName0<ENetPacketPeer, Unit>("reset")

    @JvmField
    public val sendName: MethodStringName3<ENetPacketPeer, Error, Int, PackedByteArray, Int> =
        MethodStringName3<ENetPacketPeer, Error, Int, PackedByteArray, Int>("send")

    @JvmField
    public val throttleConfigureName: MethodStringName3<ENetPacketPeer, Unit, Int, Int, Int> =
        MethodStringName3<ENetPacketPeer, Unit, Int, Int, Int>("throttle_configure")

    @JvmField
    public val setTimeoutName: MethodStringName3<ENetPacketPeer, Unit, Int, Int, Int> =
        MethodStringName3<ENetPacketPeer, Unit, Int, Int, Int>("set_timeout")

    @JvmField
    public val getPacketFlagsName: MethodStringName0<ENetPacketPeer, Int> =
        MethodStringName0<ENetPacketPeer, Int>("get_packet_flags")

    @JvmField
    public val getRemoteAddressName: MethodStringName0<ENetPacketPeer, String> =
        MethodStringName0<ENetPacketPeer, String>("get_remote_address")

    @JvmField
    public val getRemotePortName: MethodStringName0<ENetPacketPeer, Int> =
        MethodStringName0<ENetPacketPeer, Int>("get_remote_port")

    @JvmField
    public val getStatisticName: MethodStringName1<ENetPacketPeer, Double, PeerStatistic> =
        MethodStringName1<ENetPacketPeer, Double, PeerStatistic>("get_statistic")

    @JvmField
    public val getStateName: MethodStringName0<ENetPacketPeer, PeerState> =
        MethodStringName0<ENetPacketPeer, PeerState>("get_state")

    @JvmField
    public val getChannelsName: MethodStringName0<ENetPacketPeer, Int> =
        MethodStringName0<ENetPacketPeer, Int>("get_channels")

    @JvmField
    public val isActiveName: MethodStringName0<ENetPacketPeer, Boolean> =
        MethodStringName0<ENetPacketPeer, Boolean>("is_active")

    /**
     * The reference scale for packet loss. See [getStatistic] and [PEER_PACKET_LOSS].
     */
    public final const val PACKET_LOSS_SCALE: Long = 65536

    /**
     * The reference value for throttle configuration. The default value is `32`. See
     * [throttleConfigure].
     */
    public final const val PACKET_THROTTLE_SCALE: Long = 32

    /**
     * Mark the packet to be sent as reliable.
     */
    public final const val FLAG_RELIABLE: Long = 1

    /**
     * Mark the packet to be sent unsequenced (unreliable).
     */
    public final const val FLAG_UNSEQUENCED: Long = 2

    /**
     * Mark the packet to be sent unreliable even if the packet is too big and needs fragmentation
     * (increasing the chance of it being dropped).
     */
    public final const val FLAG_UNRELIABLE_FRAGMENT: Long = 8
  }

  public object MethodBindings {
    internal val peerDisconnectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "peer_disconnect", 1995695955)

    internal val peerDisconnectLaterPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "peer_disconnect_later", 1995695955)

    internal val peerDisconnectNowPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "peer_disconnect_now", 1995695955)

    internal val pingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "ping", 3218959716)

    internal val pingIntervalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "ping_interval", 1286410249)

    internal val resetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "reset", 3218959716)

    internal val sendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "send", 120522849)

    internal val throttleConfigurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "throttle_configure", 1649997291)

    internal val setTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "set_timeout", 1649997291)

    internal val getPacketFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "get_packet_flags", 3905245786)

    internal val getRemoteAddressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "get_remote_address", 201670096)

    internal val getRemotePortPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "get_remote_port", 3905245786)

    internal val getStatisticPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "get_statistic", 1642578323)

    internal val getStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "get_state", 711068532)

    internal val getChannelsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "get_channels", 3905245786)

    internal val isActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ENetPacketPeer", "is_active", 36873697)
  }
}
