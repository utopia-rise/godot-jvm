extends GdUnitTestSuite

func test_coroutine_await():
    var test_script: Node = CoroutineTest.new()
    add_child(test_script)

    assert_that(test_script.step).override_failure_message("Property should be 0 at first.").is_equal(0)

    test_script.start_coroutine_without_parameter()
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 1 after coroutine started but waiting.").is_equal(1)

    test_script.signal_without_parameter.emit()
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 2 after coroutine ran and signal triggered.").is_equal(2)

    test_script.start_coroutine_with_one_parameter()
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 3 after coroutine started but waiting.").is_equal(3)

    test_script.signal_with_one_parameter.emit(4)
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 4 after coroutine ran.").is_equal(4)

    test_script.start_coroutine_with_many_parameters()
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 5 after coroutine started but waiting.").is_equal(5)

    test_script.signal_with_many_parameters.emit(6, 0.1, Vector2(0,0), "test")
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 6 after coroutine ran.").is_equal(6)
    assert_that(test_script.many_parameter_payload_summary).override_failure_message("Coroutine signal awaits should preserve the full payload order across the bridge.").is_equal("6|0.1|0.0,0.0|test")

    test_script.start_coroutine_undispatched()
    assert_that(test_script.step).override_failure_message("Property should be immediately 7 when coroutine is undispatched.").is_equal(7)

    test_script.signal_without_parameter.emit()
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 8 when coroutine is resumed.").is_equal(8)
    
    test_script.start_coroutine_with_physics_frame()
    await get_tree().physics_frame
    assert_that(test_script.step).override_failure_message("Property should be 10 when coroutine is resumed.").is_equal(10)
    
    test_script.start_coroutine_with_process_frame()
    await get_tree().process_frame
    assert_that(test_script.step).override_failure_message("Property should be 12 when coroutine is resumed.").is_equal(12)

    test_script.start_coroutine_with_flow()
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 13 while the flow is waiting.").is_equal(13)

    test_script.signal_with_one_parameter.emit(14)
    await get_tree().create_timer(1).timeout
    assert_that(test_script.step).override_failure_message("Property should be 14 when the flow receives a signal.").is_equal(14)

    test_script.run_on_main_thread_from_background_thread()
    var run_on_main_thread_from_background_thread_success = await test_script.run_on_main_thread_from_background_thread_finished
    assert_bool(run_on_main_thread_from_background_thread_success).override_failure_message("Code should be executed on the correct threads").is_true()

    test_script.async_load_resource()
    var async_load_resource_success = await test_script.async_load_resource_finished
    assert_bool(async_load_resource_success).override_failure_message("Resource should be loaded").is_true()
    
    test_script.cancel_coroutine()
    await get_tree().create_timer(4).timeout
    assert_bool(test_script.was_child_cancelled).override_failure_message("Coroutine children should have been cancelled").is_true()
    assert_bool(test_script.was_parent_cancelled).override_failure_message("Coroutine parent should not have been cancelled").is_false()

    await get_tree().create_timer(1).timeout
    test_script.free()
