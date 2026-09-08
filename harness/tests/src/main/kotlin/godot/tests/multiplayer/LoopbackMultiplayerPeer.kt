package godot.tests.multiplayer

import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.MultiplayerPeer
import godot.api.MultiplayerPeerExtension
import godot.core.Error
import godot.core.PackedByteArray

/**
 * Delivers every packet it is asked to send back to itself as if a remote peer with id [REMOTE_PEER_ID]
 * had sent it, so a single process can exercise the whole RPC path of the multiplayer API. SceneMultiplayer
 * reads the peer, channel and mode before fetching a packet, so those describe the head of the queue.
 */
@Script
class LoopbackMultiplayerPeer : MultiplayerPeerExtension() {
    private class Packet(val bytes: ByteArray, val channel: Int, val mode: MultiplayerPeer.TransferMode)

    private val outgoing = ArrayDeque<Packet>()
    private val incoming = ArrayDeque<Packet>()
    private var targetPeer = 0
    private var requestedChannel = 0
    private var requestedMode = MultiplayerPeer.TransferMode.RELIABLE
    private var remotePeerAnnounced = false

    @Visible
    var pollCount = 0

    @Visible
    var sentPacketCount = 0

    @Visible
    var receivedPacketCount = 0

    @Visible
    var lastSentTransferModeId = -1

    @Visible
    var lastSentChannel = -1

    @Visible
    var lastTargetPeer = 0

    @Register
    override fun _getAvailablePacketCount(): Int = incoming.size

    @Register
    override fun _getMaxPacketSize(): Int = MAXIMUM_PACKET_SIZE

    @Register
    override fun _getPacketScript(): PackedByteArray {
        val packet = incoming.removeFirst()
        receivedPacketCount++
        return PackedByteArray(packet.bytes)
    }

    @Register
    override fun _putPacketScript(buffer: PackedByteArray): Error {
        outgoing.addLast(Packet(buffer.toByteArray(), requestedChannel, requestedMode))
        sentPacketCount++
        lastSentTransferModeId = requestedMode.value.toInt()
        lastSentChannel = requestedChannel
        lastTargetPeer = targetPeer
        return Error.OK
    }

    @Register
    override fun _getPacketChannel(): Int = incoming.firstOrNull()?.channel ?: 0

    @Register
    override fun _getPacketMode(): MultiplayerPeer.TransferMode = incoming.firstOrNull()?.mode ?: MultiplayerPeer.TransferMode.RELIABLE

    @Register
    override fun _setTransferChannel(channel: Int) {
        requestedChannel = channel
    }

    @Register
    override fun _getTransferChannel(): Int = requestedChannel

    @Register
    override fun _setTransferMode(mode: MultiplayerPeer.TransferMode) {
        requestedMode = mode
    }

    @Register
    override fun _getTransferMode(): MultiplayerPeer.TransferMode = requestedMode

    @Register
    override fun _setTargetPeer(peer: Int) {
        targetPeer = peer
    }

    @Register
    override fun _getPacketPeer(): Int = REMOTE_PEER_ID

    @Register
    override fun _isServer(): Boolean = false

    @Register
    override fun _poll() {
        pollCount++
        if (!remotePeerAnnounced) {
            remotePeerAnnounced = true
            peerConnected.emit(REMOTE_PEER_ID.toLong())
        }
        while (outgoing.isNotEmpty()) {
            incoming.addLast(outgoing.removeFirst())
        }
    }

    @Register
    override fun _close() {
        outgoing.clear()
        incoming.clear()
    }

    @Register
    override fun _disconnectPeer(peer: Int, force: Boolean) {
    }

    @Register
    override fun _getUniqueId(): Int = LOCAL_PEER_ID

    @Register
    override fun _setRefuseNewConnections(enable: Boolean) {
    }

    @Register
    override fun _isRefusingNewConnections(): Boolean = false

    @Register
    override fun _isServerRelaySupported(): Boolean = false

    @Register
    override fun _getConnectionStatus(): MultiplayerPeer.ConnectionStatus = MultiplayerPeer.ConnectionStatus.CONNECTED

    companion object {
        const val LOCAL_PEER_ID = 2
        const val REMOTE_PEER_ID = 1
        const val MAXIMUM_PACKET_SIZE = 1 shl 16
    }
}
