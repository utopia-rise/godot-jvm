extends GdUnitTestSuite


func _install_loopback(node: Node) -> LoopbackMultiplayerPeer:
    get_tree().root.add_child(node)
    var peer := LoopbackMultiplayerPeer.new()
    get_tree().get_multiplayer().multiplayer_peer = peer
    get_tree().get_multiplayer().poll()
    assert_that(get_tree().get_multiplayer().get_peers()).override_failure_message("polling the loopback peer once must announce the remote peer").contains([1])
    return peer


func _remove_loopback(node: Node) -> void:
    get_tree().get_multiplayer().multiplayer_peer = null
    get_tree().root.remove_child(node)
    node.free()


func test_typed_rpc_is_sent_reliably_and_delivered_through_the_extension_peer() -> void:
    var node := RpcLoopbackTest.new()
    var peer := _install_loopback(node)

    node.trigger_typed_rpc()
    assert_that(peer.sent_packet_count).override_failure_message("the rpc must reach _put_packet_script").is_greater(0)
    assert_that(peer.last_sent_transfer_mode_id).override_failure_message("@Rpc defaults to the reliable transfer mode").is_equal(MultiplayerPeer.TRANSFER_MODE_RELIABLE)
    assert_that(peer.last_sent_channel).is_equal(0)
    assert_that(node.received_count).override_failure_message("the rpc must not run locally without sync").is_equal(0)

    get_tree().get_multiplayer().poll()
    assert_that(peer.received_packet_count).override_failure_message("polling must hand the looped packets to _get_packet_script").is_greater(0)
    assert_that(node.received_count).is_equal(3)
    assert_that(node.received_label).is_equal("crate")
    assert_that(node.received_from_peer).is_equal(1)

    _remove_loopback(node)


func test_method_callable_rpc_spreads_its_arguments() -> void:
    var node := RpcLoopbackTest.new()
    _install_loopback(node)

    node.trigger_method_callable_rpc()
    get_tree().get_multiplayer().poll()
    assert_that(node.received_count).override_failure_message("MethodCallable.rpc must forward each argument on its own").is_equal(5)
    assert_that(node.received_label).is_equal("barrel")

    node.trigger_method_callable_rpc_id(1)
    get_tree().get_multiplayer().poll()
    assert_that(node.received_count).override_failure_message("MethodCallable.rpcId must forward each argument on its own").is_equal(7)
    assert_that(node.received_label).is_equal("lantern")

    _remove_loopback(node)
