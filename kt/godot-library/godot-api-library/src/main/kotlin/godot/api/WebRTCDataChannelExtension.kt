// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Error
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public abstract class WebRTCDataChannelExtension : WebRTCDataChannel() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(920, scriptPtr)
  }

  public abstract fun _getAvailablePacketCount(): Int

  public abstract fun _getMaxPacketSize(): Int

  public abstract fun _poll(): Error

  public abstract fun _close(): Unit

  public abstract fun _setWriteMode(writeMode: WebRTCDataChannel.WriteMode): Unit

  public abstract fun _getWriteMode(): WebRTCDataChannel.WriteMode

  public abstract fun _wasStringPacket(): Boolean

  public abstract fun _getReadyState(): WebRTCDataChannel.ChannelState

  public abstract fun _getLabel(): String

  public abstract fun _isOrdered(): Boolean

  public abstract fun _getId(): Int

  public abstract fun _getMaxPacketLifeTime(): Int

  public abstract fun _getMaxRetransmits(): Int

  public abstract fun _getProtocol(): String

  public abstract fun _isNegotiated(): Boolean

  public abstract fun _getBufferedAmount(): Int

  public companion object

  public object MethodBindings
}

@GodotBaseType
internal class WebRTCDataChannelExtensionDummy : WebRTCDataChannelExtension() {
  public override fun _getAvailablePacketCount(): Int {
    throw NotImplementedError("WebRTCDataChannelExtension::_getAvailablePacketCount is only implemented by non-JVM code.")
  }

  public override fun _getMaxPacketSize(): Int {
    throw NotImplementedError("WebRTCDataChannelExtension::_getMaxPacketSize is only implemented by non-JVM code.")
  }

  public override fun _poll(): Error {
    throw NotImplementedError("WebRTCDataChannelExtension::_poll is only implemented by non-JVM code.")
  }

  public override fun _close(): Unit {
    throw NotImplementedError("WebRTCDataChannelExtension::_close is only implemented by non-JVM code.")
  }

  public override fun _setWriteMode(writeMode: WebRTCDataChannel.WriteMode): Unit {
    throw NotImplementedError("WebRTCDataChannelExtension::_setWriteMode is only implemented by non-JVM code.")
  }

  public override fun _getWriteMode(): WebRTCDataChannel.WriteMode {
    throw NotImplementedError("WebRTCDataChannelExtension::_getWriteMode is only implemented by non-JVM code.")
  }

  public override fun _wasStringPacket(): Boolean {
    throw NotImplementedError("WebRTCDataChannelExtension::_wasStringPacket is only implemented by non-JVM code.")
  }

  public override fun _getReadyState(): WebRTCDataChannel.ChannelState {
    throw NotImplementedError("WebRTCDataChannelExtension::_getReadyState is only implemented by non-JVM code.")
  }

  public override fun _getLabel(): String {
    throw NotImplementedError("WebRTCDataChannelExtension::_getLabel is only implemented by non-JVM code.")
  }

  public override fun _isOrdered(): Boolean {
    throw NotImplementedError("WebRTCDataChannelExtension::_isOrdered is only implemented by non-JVM code.")
  }

  public override fun _getId(): Int {
    throw NotImplementedError("WebRTCDataChannelExtension::_getId is only implemented by non-JVM code.")
  }

  public override fun _getMaxPacketLifeTime(): Int {
    throw NotImplementedError("WebRTCDataChannelExtension::_getMaxPacketLifeTime is only implemented by non-JVM code.")
  }

  public override fun _getMaxRetransmits(): Int {
    throw NotImplementedError("WebRTCDataChannelExtension::_getMaxRetransmits is only implemented by non-JVM code.")
  }

  public override fun _getProtocol(): String {
    throw NotImplementedError("WebRTCDataChannelExtension::_getProtocol is only implemented by non-JVM code.")
  }

  public override fun _isNegotiated(): Boolean {
    throw NotImplementedError("WebRTCDataChannelExtension::_isNegotiated is only implemented by non-JVM code.")
  }

  public override fun _getBufferedAmount(): Int {
    throw NotImplementedError("WebRTCDataChannelExtension::_getBufferedAmount is only implemented by non-JVM code.")
  }
}
