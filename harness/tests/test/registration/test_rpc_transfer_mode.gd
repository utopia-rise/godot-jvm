extends GdUnitTestSuite


func _config_for(rpc_config: Dictionary, method_name: String) -> Dictionary:
    for key in rpc_config.keys():
        if str(key) == method_name:
            return rpc_config[key]
    fail("No rpc configuration found for %s in %s" % [method_name, rpc_config])
    return {}


func test_rpc_annotation_values_map_to_engine_enum_values() -> void:
    var script := RpcTransferModeTest.new()
    var rpc_config: Dictionary = script.get_script().get_rpc_config()

    var default_config := _config_for(rpc_config, "default_transfer_mode")
    assert_that(default_config["transfer_mode"]).override_failure_message("@Rpc defaults to the reliable transfer mode").is_equal(MultiplayerPeer.TRANSFER_MODE_RELIABLE)
    assert_that(default_config["rpc_mode"]).override_failure_message("@Rpc defaults to the authority rpc mode").is_equal(MultiplayerAPI.RPC_MODE_AUTHORITY)
    assert_that(default_config["call_local"]).is_equal(false)
    assert_that(default_config["channel"]).is_equal(0)

    var unreliable_config := _config_for(rpc_config, "unreliable_transfer_mode")
    assert_that(unreliable_config["transfer_mode"]).override_failure_message("TransferMode.UNRELIABLE must map to the engine's unreliable mode").is_equal(MultiplayerPeer.TRANSFER_MODE_UNRELIABLE)

    var ordered_config := _config_for(rpc_config, "unreliable_ordered_transfer_mode")
    assert_that(ordered_config["transfer_mode"]).override_failure_message("TransferMode.UNRELIABLE_ORDERED must map to the engine's unreliable ordered mode").is_equal(MultiplayerPeer.TRANSFER_MODE_UNRELIABLE_ORDERED)
    assert_that(ordered_config["rpc_mode"]).override_failure_message("RpcMode.ANY must map to the engine's any peer mode").is_equal(MultiplayerAPI.RPC_MODE_ANY_PEER)
    assert_that(ordered_config["channel"]).is_equal(2)

    script.free()
