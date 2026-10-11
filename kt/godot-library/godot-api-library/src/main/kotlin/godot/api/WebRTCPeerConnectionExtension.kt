// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.Error
import kotlin.Any
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public abstract class WebRTCPeerConnectionExtension : WebRTCPeerConnection() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(923, scriptPtr)
  }

  public abstract fun _getConnectionState(): WebRTCPeerConnection.ConnectionState

  public abstract fun _getGatheringState(): WebRTCPeerConnection.GatheringState

  public abstract fun _getSignalingState(): WebRTCPeerConnection.SignalingState

  public abstract fun _initialize(config: Dictionary<Any?, Any?>): Error

  public abstract fun _createDataChannel(label: String, config: Dictionary<Any?, Any?>):
      WebRTCDataChannel?

  public abstract fun _createOffer(): Error

  public abstract fun _setRemoteDescription(type: String, sdp: String): Error

  public abstract fun _setLocalDescription(type: String, sdp: String): Error

  public abstract fun _addIceCandidate(
    sdpMidName: String,
    sdpMlineIndex: Int,
    sdpName: String,
  ): Error

  public abstract fun _poll(): Error

  public abstract fun _close(): Unit

  public companion object

  public object MethodBindings
}

@GodotBaseType
internal class WebRTCPeerConnectionExtensionDummy : WebRTCPeerConnectionExtension() {
  public override fun _getConnectionState(): WebRTCPeerConnection.ConnectionState {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_getConnectionState is only implemented by non-JVM code.")
  }

  public override fun _getGatheringState(): WebRTCPeerConnection.GatheringState {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_getGatheringState is only implemented by non-JVM code.")
  }

  public override fun _getSignalingState(): WebRTCPeerConnection.SignalingState {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_getSignalingState is only implemented by non-JVM code.")
  }

  public override fun _initialize(config: Dictionary<Any?, Any?>): Error {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_initialize is only implemented by non-JVM code.")
  }

  public override fun _createDataChannel(label: String, config: Dictionary<Any?, Any?>):
      WebRTCDataChannel? {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_createDataChannel is only implemented by non-JVM code.")
  }

  public override fun _createOffer(): Error {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_createOffer is only implemented by non-JVM code.")
  }

  public override fun _setRemoteDescription(type: String, sdp: String): Error {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_setRemoteDescription is only implemented by non-JVM code.")
  }

  public override fun _setLocalDescription(type: String, sdp: String): Error {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_setLocalDescription is only implemented by non-JVM code.")
  }

  public override fun _addIceCandidate(
    sdpMidName: String,
    sdpMlineIndex: Int,
    sdpName: String,
  ): Error {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_addIceCandidate is only implemented by non-JVM code.")
  }

  public override fun _poll(): Error {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_poll is only implemented by non-JVM code.")
  }

  public override fun _close(): Unit {
    throw NotImplementedError("WebRTCPeerConnectionExtension::_close is only implemented by non-JVM code.")
  }
}
