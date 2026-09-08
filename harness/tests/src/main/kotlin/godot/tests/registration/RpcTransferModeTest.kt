package godot.tests.registration

import godot.annotation.Register
import godot.annotation.Rpc
import godot.annotation.RpcMode
import godot.annotation.Script
import godot.annotation.TransferMode
import godot.api.Node

@Script
class RpcTransferModeTest : Node() {

    @Rpc
    @Register
    fun defaultTransferMode() {
    }

    @Rpc(transferMode = TransferMode.UNRELIABLE)
    @Register
    fun unreliableTransferMode() {
    }

    @Rpc(rpcMode = RpcMode.ANY, transferMode = TransferMode.UNRELIABLE_ORDERED, transferChannel = 2)
    @Register
    fun unreliableOrderedTransferMode() {
    }
}
