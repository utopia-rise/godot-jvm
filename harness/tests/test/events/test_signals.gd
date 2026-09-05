extends GdUnitTestSuite

func test_kotlin_signals() -> void:
    var script := SignalKotlinTest.new()
    get_tree().root.add_child(script)
    script.name = "SignalKotlinRoot"

    assert_bool(script.other_script.hook_no_param_called).override_failure_message("Kotlin no-param signals should call OtherScript.hookNoParam").is_true()
    assert_bool(script.other_script.hook_one_param_called).override_failure_message("Kotlin one-param signals should call OtherScript.hookOneParam").is_true()
    assert_that(script.other_script.hook_one_param_value).override_failure_message("Kotlin one-param signal should forward the boolean payload").is_equal(false)
    assert_bool(script.other_script.hook_two_param_called).override_failure_message("Kotlin two-param signals should call OtherScript.hookTwoParam").is_true()
    assert_that(script.other_script.hook_two_param_value).override_failure_message("Kotlin two-param signal should forward the string payload").is_equal("My Awesome param !")
    assert_object(script.other_script.hook_two_param_node).override_failure_message("Kotlin two-param signal should forward the sender node").is_equal(script)

    assert_that(script.array.size()).is_equal(16)
    assert_that(script.array[0]).is_equal(Vector2(0, 0))
    assert_that(script.array[1]).is_equal(Vector2(1, 1))
    assert_that(script.array[2]).is_equal(Vector2(1, 2))
    assert_that(script.array[3]).is_equal(Vector2(1, 3))
    assert_that(script.array[4]).is_equal(Vector2(1, 4))
    assert_that(script.array[5]).is_equal(Vector2(1, 5))
    assert_that(script.array[6]).is_equal(Vector2(1, 6))
    assert_that(script.array[7]).is_equal(Vector2(1, 7))
    assert_that(script.array[8]).is_equal(Vector2(1, 7))
    assert_that(script.array[9]).is_equal(Vector2(1, 6))
    assert_that(script.array[10]).is_equal(Vector2(1, 5))
    assert_that(script.array[11]).is_equal(Vector2(1, 4))
    assert_that(script.array[12]).is_equal(Vector2(1, 3))
    assert_that(script.array[13]).is_equal(Vector2(1, 2))
    assert_that(script.array[14]).is_equal(Vector2(1, 1))
    assert_that(script.array[15]).is_equal(Vector2(0, 0))

    script.emit_self_connected_signal()
    await get_tree().create_timer(1).timeout
    assert_bool(script.self_connected_signal_triggered).is_true()

    script.reset_reconnect_state()
    script.connect_reconnect_signal()
    script.emit_reconnect_signal("")
    await get_tree().create_timer(1).timeout
    assert_that(script.reconnect_signal_deliveries).override_failure_message("Reconnect signal should be delivered once while connected").is_equal(1)
    assert_that(script.reconnect_payload_value).override_failure_message("Reconnect signal should preserve the payload value across the bridge").is_equal("")
    assert_that(script.reconnect_payload_node_name).override_failure_message("Reconnect signal should forward the correct sender instance").is_equal("SignalKotlinRoot")
    assert_bool(script.secondary_reconnect_triggered).override_failure_message("Secondary receiver should be triggered while the reconnect signal is connected").is_true()

    script.disconnect_reconnect_signal()
    script.secondary_reconnect_triggered = false
    script.emit_reconnect_signal("after-disconnect")
    await get_tree().create_timer(1).timeout
    assert_that(script.reconnect_signal_deliveries).override_failure_message("Reconnect signal should stop delivering after disconnect").is_equal(1)
    assert_bool(script.secondary_reconnect_triggered).override_failure_message("Secondary receiver should stop receiving after disconnect").is_false()

    script.connect_reconnect_signal()
    script.emit_reconnect_signal("after-reconnect")
    await get_tree().create_timer(1).timeout
    assert_that(script.reconnect_signal_deliveries).override_failure_message("Reconnect signal should resume after reconnect").is_equal(2)
    assert_that(script.reconnect_payload_value).override_failure_message("Reconnect signal should update the latest payload after reconnect").is_equal("after-reconnect")

    get_tree().root.remove_child(script)
    script.free()


func test_java_signals() -> void:
    var script := SignalJavaTest.new()
    get_tree().root.add_child(script)

    assert_bool(script.method_signal_triggered).override_failure_message("Java method-connected signal should have fired").is_true()
    assert_bool(script.lambda_signal_triggered).override_failure_message("Java payload signal should have fired").is_true()
    assert_that(script.payload_string).override_failure_message("Java payload signal should capture the string").is_equal("java-events")
    assert_that(script.payload_int).override_failure_message("Java payload signal should capture the int").is_equal(17)

    get_tree().root.remove_child(script)
    script.free()


func test_scala_signals() -> void:
    var script := SignalScalaTest.new()
    get_tree().root.add_child(script)
    _assert_signal_argument_type(script, "ready_signal", TYPE_BOOL)

    assert_bool(script.method_signal_triggered).override_failure_message("Scala method-connected signal should have fired").is_true()
    assert_bool(script.lambda_signal_triggered).override_failure_message("Scala payload signal should have fired").is_true()
    assert_that(script.payload_string).override_failure_message("Scala payload signal should capture the string").is_equal("scala-events")
    assert_that(script.payload_int).override_failure_message("Scala payload signal should capture the int").is_equal(23)

    get_tree().root.remove_child(script)
    script.free()


func _assert_signal_argument_type(instance: Object, signal_name: String, variant_type: int) -> void:
    var found := false
    for signal_info: Dictionary in instance.get_signal_list():
        if signal_info["name"] == signal_name:
            found = true
            assert_that(signal_info["args"][0]["type"]).override_failure_message("Signal '%s' should keep its argument type" % signal_name).is_equal(variant_type)
    assert_bool(found).override_failure_message("Signal '%s' should be registered" % signal_name).is_true()
