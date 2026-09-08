package godot.tests.multiplayer

import godot.annotation.Register
import godot.annotation.Rpc
import godot.annotation.RpcMode
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node
import godot.core.methodCallable2

@Script
class RpcLoopbackTest : Node() {

    @Visible
    var receivedCount = 0

    @Visible
    var receivedLabel = ""

    @Visible
    var receivedFromPeer = 0

    @Rpc(rpcMode = RpcMode.ANY)
    @Register
    fun receiveValues(count: Int, label: String) {
        receivedCount = count
        receivedLabel = label
        receivedFromPeer = multiplayer?.getRemoteSenderId() ?: 0
    }

    @Register
    fun triggerTypedRpc() {
        rpc(::receiveValues, 3, "crate")
    }

    @Register
    fun triggerMethodCallableRpc() {
        methodCallable2(this, RpcLoopbackTest::receiveValues).rpc(5, "barrel")
    }

    @Register
    fun triggerMethodCallableRpcId(peerId: Long) {
        methodCallable2(this, RpcLoopbackTest::receiveValues).rpcId(peerId, 7, "lantern")
    }
}
