// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.PackedByteArray
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit

/**
 * This class is designed to be inherited from a GDExtension plugin to implement custom networking
 * layers for the multiplayer API (such as WebRTC). All the methods below **must** be implemented to
 * have a working custom multiplayer implementation. See also [MultiplayerAPI].
 */
@GodotBaseType
public abstract class MultiplayerPeerExtension : MultiplayerPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(392, scriptPtr)
  }

  /**
   * Called when the available packet count is internally requested by the [MultiplayerAPI].
   */
  public abstract fun _getAvailablePacketCount(): Int

  /**
   * Called when the maximum allowed packet size (in bytes) is requested by the [MultiplayerAPI].
   */
  public abstract fun _getMaxPacketSize(): Int

  /**
   * Called when a packet needs to be received by the [MultiplayerAPI], if [_getPacket] isn't
   * implemented. Use this when extending this class via GDScript.
   */
  public open fun _getPacketScript(): PackedByteArray {
    throw NotImplementedError("MultiplayerPeerExtension::_getPacketScript is not implemented.")
  }

  /**
   * Called when a packet needs to be sent by the [MultiplayerAPI], if [_putPacket] isn't
   * implemented. Use this when extending this class via GDScript.
   */
  public open fun _putPacketScript(buffer: PackedByteArray): Error {
    throw NotImplementedError("MultiplayerPeerExtension::_putPacketScript is not implemented.")
  }

  /**
   * Called to get the channel over which the next available packet was received. See
   * [MultiplayerPeer.getPacketChannel].
   */
  public abstract fun _getPacketChannel(): Int

  /**
   * Called to get the transfer mode the remote peer used to send the next available packet. See
   * [MultiplayerPeer.getPacketMode].
   */
  public abstract fun _getPacketMode(): MultiplayerPeer.TransferMode

  /**
   * Called when the channel to use is set for this [MultiplayerPeer] (see
   * [MultiplayerPeer.transferChannel]).
   */
  public abstract fun _setTransferChannel(channel: Int): Unit

  /**
   * Called when the transfer channel to use is read on this [MultiplayerPeer] (see
   * [MultiplayerPeer.transferChannel]).
   */
  public abstract fun _getTransferChannel(): Int

  /**
   * Called when the transfer mode is set on this [MultiplayerPeer] (see
   * [MultiplayerPeer.transferMode]).
   */
  public abstract fun _setTransferMode(mode: MultiplayerPeer.TransferMode): Unit

  /**
   * Called when the transfer mode to use is read on this [MultiplayerPeer] (see
   * [MultiplayerPeer.transferMode]).
   */
  public abstract fun _getTransferMode(): MultiplayerPeer.TransferMode

  /**
   * Called when the target peer to use is set for this [MultiplayerPeer] (see
   * [MultiplayerPeer.setTargetPeer]).
   */
  public abstract fun _setTargetPeer(peer: Int): Unit

  /**
   * Called when the ID of the [MultiplayerPeer] who sent the most recent packet is requested (see
   * [MultiplayerPeer.getPacketPeer]).
   */
  public abstract fun _getPacketPeer(): Int

  /**
   * Called when the "is server" status is requested on the [MultiplayerAPI]. See
   * [MultiplayerAPI.isServer].
   */
  public abstract fun _isServer(): Boolean

  /**
   * Called when the [MultiplayerAPI] is polled. See [MultiplayerAPI.poll].
   */
  public abstract fun _poll(): Unit

  /**
   * Called when the multiplayer peer should be immediately closed (see [MultiplayerPeer.close]).
   */
  public abstract fun _close(): Unit

  /**
   * Called when the connected [peer] should be forcibly disconnected (see
   * [MultiplayerPeer.disconnectPeer]).
   */
  public abstract fun _disconnectPeer(peer: Int, force: Boolean): Unit

  /**
   * Called when the unique ID of this [MultiplayerPeer] is requested (see
   * [MultiplayerPeer.getUniqueId]). The value must be between `1` and `2147483647`.
   */
  public abstract fun _getUniqueId(): Int

  /**
   * Called when the "refuse new connections" status is set on this [MultiplayerPeer] (see
   * [MultiplayerPeer.refuseNewConnections]).
   */
  public open fun _setRefuseNewConnections(enable: Boolean): Unit {
    throw NotImplementedError("MultiplayerPeerExtension::_setRefuseNewConnections is not implemented.")
  }

  /**
   * Called when the "refuse new connections" status is requested on this [MultiplayerPeer] (see
   * [MultiplayerPeer.refuseNewConnections]).
   */
  public open fun _isRefusingNewConnections(): Boolean {
    throw NotImplementedError("MultiplayerPeerExtension::_isRefusingNewConnections is not implemented.")
  }

  /**
   * Called to check if the server can act as a relay in the current configuration. See
   * [MultiplayerPeer.isServerRelaySupported].
   */
  public open fun _isServerRelaySupported(): Boolean {
    throw NotImplementedError("MultiplayerPeerExtension::_isServerRelaySupported is not implemented.")
  }

  /**
   * Called when the connection status is requested on the [MultiplayerPeer] (see
   * [MultiplayerPeer.getConnectionStatus]).
   */
  public abstract fun _getConnectionStatus(): MultiplayerPeer.ConnectionStatus

  public companion object

  public object MethodBindings
}

internal class MultiplayerPeerExtensionDummy : MultiplayerPeerExtension() {
  public override fun _getAvailablePacketCount(): Int {
    throw NotImplementedError("MultiplayerPeerExtension::_getAvailablePacketCount is only implemented by non-JVM code.")
  }

  public override fun _getMaxPacketSize(): Int {
    throw NotImplementedError("MultiplayerPeerExtension::_getMaxPacketSize is only implemented by non-JVM code.")
  }

  public override fun _getPacketChannel(): Int {
    throw NotImplementedError("MultiplayerPeerExtension::_getPacketChannel is only implemented by non-JVM code.")
  }

  public override fun _getPacketMode(): MultiplayerPeer.TransferMode {
    throw NotImplementedError("MultiplayerPeerExtension::_getPacketMode is only implemented by non-JVM code.")
  }

  public override fun _setTransferChannel(channel: Int): Unit {
    throw NotImplementedError("MultiplayerPeerExtension::_setTransferChannel is only implemented by non-JVM code.")
  }

  public override fun _getTransferChannel(): Int {
    throw NotImplementedError("MultiplayerPeerExtension::_getTransferChannel is only implemented by non-JVM code.")
  }

  public override fun _setTransferMode(mode: MultiplayerPeer.TransferMode): Unit {
    throw NotImplementedError("MultiplayerPeerExtension::_setTransferMode is only implemented by non-JVM code.")
  }

  public override fun _getTransferMode(): MultiplayerPeer.TransferMode {
    throw NotImplementedError("MultiplayerPeerExtension::_getTransferMode is only implemented by non-JVM code.")
  }

  public override fun _setTargetPeer(peer: Int): Unit {
    throw NotImplementedError("MultiplayerPeerExtension::_setTargetPeer is only implemented by non-JVM code.")
  }

  public override fun _getPacketPeer(): Int {
    throw NotImplementedError("MultiplayerPeerExtension::_getPacketPeer is only implemented by non-JVM code.")
  }

  public override fun _isServer(): Boolean {
    throw NotImplementedError("MultiplayerPeerExtension::_isServer is only implemented by non-JVM code.")
  }

  public override fun _poll(): Unit {
    throw NotImplementedError("MultiplayerPeerExtension::_poll is only implemented by non-JVM code.")
  }

  public override fun _close(): Unit {
    throw NotImplementedError("MultiplayerPeerExtension::_close is only implemented by non-JVM code.")
  }

  public override fun _disconnectPeer(peer: Int, force: Boolean): Unit {
    throw NotImplementedError("MultiplayerPeerExtension::_disconnectPeer is only implemented by non-JVM code.")
  }

  public override fun _getUniqueId(): Int {
    throw NotImplementedError("MultiplayerPeerExtension::_getUniqueId is only implemented by non-JVM code.")
  }

  public override fun _getConnectionStatus(): MultiplayerPeer.ConnectionStatus {
    throw NotImplementedError("MultiplayerPeerExtension::_getConnectionStatus is only implemented by non-JVM code.")
  }
}
