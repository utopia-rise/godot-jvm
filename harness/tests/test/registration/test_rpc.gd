extends GdUnitTestSuite


func test_nullables_are_correctly_set_from_function_lika_a_ready_call():
    var node3d = Node3D.new()
    var rpc_tests_script = load("res://src/main/kotlin/godot/tests/registration/RpcTests.kt").new()
    node3d.add_child(rpc_tests_script)
    get_tree().root.add_child(node3d)
    var network_peer = ENetMultiplayerPeer.new()
    assert_that(network_peer.create_server(0)).is_equal(OK)
    get_tree().get_multiplayer().multiplayer_peer = network_peer

    assert_that(rpc_tests_script.remote_sync_called).override_failure_message("remote_sync_called should be false before actually calling the corresponding function").is_equal(false)
    rpc_tests_script.trigger_function_remote_sync_call()
    assert_that(rpc_tests_script.remote_sync_called).override_failure_message("remote_sync_called should be true after calling the corresponding function").is_equal(true)

    get_tree().get_multiplayer().multiplayer_peer = null
    network_peer.close()
    node3d.free()
