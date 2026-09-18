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
import godot.core.Dictionary
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.VariantArray
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_ARRAY
import godot.writeMethodArguments_OBJECT_LONG_LONG
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * This class constructs a full mesh of [WebRTCPeerConnection] (one connection for each peer) that
 * can be used as a [MultiplayerAPI.multiplayerPeer].
 *
 * You can add each [WebRTCPeerConnection] via [addPeer] or remove them via [removePeer]. Peers must
 * be added in [WebRTCPeerConnection.STATE_NEW] state to allow it to create the appropriate channels.
 * This class will not create offers nor set descriptions, it will only poll them, and notify
 * connections and disconnections.
 *
 * When creating the peer via [createClient] or [createServer] the
 * [MultiplayerPeer.isServerRelaySupported] method will return `true` enabling peer exchange and packet
 * relaying when supported by the [MultiplayerAPI] implementation.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 */
@GodotBaseType
public open class WebRTCMultiplayerPeer : MultiplayerPeer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(921, scriptPtr)
  }

  /**
   * Initialize the multiplayer peer as a server (with unique ID of `1`). This mode enables
   * [MultiplayerPeer.isServerRelaySupported], allowing the upper [MultiplayerAPI] layer to perform
   * peer exchange and packet relaying.
   *
   * You can optionally specify a [channelsConfig] array of [MultiplayerPeer.TransferMode] which
   * will be used to create extra channels (WebRTC only supports one transfer mode per channel).
   */
  @JvmOverloads
  public final fun createServer(channelsConfig: VariantArray<Any?> = godot.core.variantArrayOf()):
      Error {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, channelsConfig)
    TransferContext.callPtrMethod(MethodBindings.createServerPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Initialize the multiplayer peer as a client with the given [peerId] (must be between 2 and
   * 2147483647). In this mode, you should only call [addPeer] once and with [peerId] of `1`. This mode
   * enables [MultiplayerPeer.isServerRelaySupported], allowing the upper [MultiplayerAPI] layer to
   * perform peer exchange and packet relaying.
   *
   * You can optionally specify a [channelsConfig] array of [MultiplayerPeer.TransferMode] which
   * will be used to create extra channels (WebRTC only supports one transfer mode per channel).
   */
  @JvmOverloads
  public final fun createClient(peerId: Int, channelsConfig: VariantArray<Any?> =
      godot.core.variantArrayOf()): Error {
    TransferContext.writeMethodArguments_LONG_ARRAY(ptr, objectID.id, peerId.toLong(), channelsConfig)
    TransferContext.callPtrMethod(MethodBindings.createClientPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Initialize the multiplayer peer as a mesh (i.e. all peers connect to each other) with the given
   * [peerId] (must be between 1 and 2147483647).
   */
  @JvmOverloads
  public final fun createMesh(peerId: Int, channelsConfig: VariantArray<Any?> =
      godot.core.variantArrayOf()): Error {
    TransferContext.writeMethodArguments_LONG_ARRAY(ptr, objectID.id, peerId.toLong(), channelsConfig)
    TransferContext.callPtrMethod(MethodBindings.createMeshPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Add a new peer to the mesh with the given [peerId]. The [WebRTCPeerConnection] must be in state
   * [WebRTCPeerConnection.STATE_NEW].
   *
   * Three channels will be created for reliable, unreliable, and ordered transport. The value of
   * [unreliableLifetime] will be passed to the `"maxPacketLifetime"` option when creating unreliable
   * and ordered channels (see [WebRTCPeerConnection.createDataChannel]).
   */
  @JvmOverloads
  public final fun addPeer(
    peer: WebRTCPeerConnection?,
    peerId: Int,
    unreliableLifetime: Int = 1,
  ): Error {
    TransferContext.writeMethodArguments_OBJECT_LONG_LONG(ptr, objectID.id, peer, peerId.toLong(), unreliableLifetime.toLong())
    TransferContext.callPtrMethod(MethodBindings.addPeerPtr, 2)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Remove the peer with given [peerId] from the mesh. If the peer was connected, and [signal
   * MultiplayerPeer.peer_connected] was emitted for it, then [signal
   * MultiplayerPeer.peer_disconnected] will be emitted.
   */
  public final fun removePeer(peerId: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, peerId.toLong())
    TransferContext.callPtrMethod(MethodBindings.removePeerPtr, 0)
  }

  /**
   * Returns `true` if the given [peerId] is in the peers map (it might not be connected though).
   */
  public final fun hasPeer(peerId: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, peerId.toLong())
    TransferContext.callPtrMethod(MethodBindings.hasPeerPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a dictionary representation of the peer with given [peerId] with three keys.
   * `"connection"` containing the [WebRTCPeerConnection] to this peer, `"channels"` an array of three
   * [WebRTCDataChannel], and `"connected"` a boolean representing if the peer connection is currently
   * connected (all three channels are open).
   */
  public final fun getPeer(peerId: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, peerId.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPeerPtr, 27)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Returns a dictionary which keys are the peer ids and values the peer representation as in
   * [getPeer].
   */
  public final fun getPeers(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPeersPtr, 27)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  public companion object {
    @JvmField
    public val createServerName: MethodStringName1<WebRTCMultiplayerPeer, Error, VariantArray<Any?>>
        = MethodStringName1<WebRTCMultiplayerPeer, Error, VariantArray<Any?>>("create_server")

    @JvmField
    public val createClientName:
        MethodStringName2<WebRTCMultiplayerPeer, Error, Int, VariantArray<Any?>> =
        MethodStringName2<WebRTCMultiplayerPeer, Error, Int, VariantArray<Any?>>("create_client")

    @JvmField
    public val createMeshName:
        MethodStringName2<WebRTCMultiplayerPeer, Error, Int, VariantArray<Any?>> =
        MethodStringName2<WebRTCMultiplayerPeer, Error, Int, VariantArray<Any?>>("create_mesh")

    @JvmField
    public val addPeerName:
        MethodStringName3<WebRTCMultiplayerPeer, Error, WebRTCPeerConnection?, Int, Int> =
        MethodStringName3<WebRTCMultiplayerPeer, Error, WebRTCPeerConnection?, Int, Int>("add_peer")

    @JvmField
    public val removePeerName: MethodStringName1<WebRTCMultiplayerPeer, Unit, Int> =
        MethodStringName1<WebRTCMultiplayerPeer, Unit, Int>("remove_peer")

    @JvmField
    public val hasPeerName: MethodStringName1<WebRTCMultiplayerPeer, Boolean, Int> =
        MethodStringName1<WebRTCMultiplayerPeer, Boolean, Int>("has_peer")

    @JvmField
    public val getPeerName: MethodStringName1<WebRTCMultiplayerPeer, Dictionary<Any?, Any?>, Int> =
        MethodStringName1<WebRTCMultiplayerPeer, Dictionary<Any?, Any?>, Int>("get_peer")

    @JvmField
    public val getPeersName: MethodStringName0<WebRTCMultiplayerPeer, Dictionary<Any?, Any?>> =
        MethodStringName0<WebRTCMultiplayerPeer, Dictionary<Any?, Any?>>("get_peers")
  }

  public object MethodBindings {
    internal val createServerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "create_server", 2865356025)

    internal val createClientPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "create_client", 2641732907)

    internal val createMeshPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "create_mesh", 2641732907)

    internal val addPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "add_peer", 4078953270)

    internal val removePeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "remove_peer", 1286410249)

    internal val hasPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "has_peer", 3067735520)

    internal val getPeerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "get_peer", 3554694381)

    internal val getPeersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebRTCMultiplayerPeer", "get_peers", 2382534195)
  }
}
