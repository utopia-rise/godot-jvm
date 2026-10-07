extends GdUnitTestSuite


func test_kotlin_test_class() -> void:
    var kotlin_scene: KotlinTestClass = load("res://kotlin_test_scene.tscn").instantiate()
    get_tree().root.add_child(kotlin_scene)

    assert_that(kotlin_scene.exported_int).override_failure_message("Field from kotlin should match").is_equal(1)
    kotlin_scene.exported_int = 2
    assert_that(kotlin_scene.exported_int).override_failure_message("Field from kotlin should be writable").is_equal(2)
    assert_that(kotlin_scene.greeting()).override_failure_message("Greeting from kotlin should match").is_equal("Hello from kotlin")
    assert_bool(kotlin_scene.entered_tree).override_failure_message("_enter_tree should've been invoked in kotlin").is_true()

    kotlin_scene.notification(0)
    assert_bool(kotlin_scene.notification_triggered).override_failure_message("_notification should be registered and invoked in kotlin").is_true()

    # Both signals fire before the callbacks of that step, so the second emission is the first after a complete one.
    await get_tree().process_frame
    await get_tree().process_frame
    await get_tree().physics_frame
    await get_tree().physics_frame
    assert_float(kotlin_scene.process_delta).override_failure_message("_process should've been invoked by the engine in kotlin").is_greater(0.0)
    assert_float(kotlin_scene.physics_process_delta).override_failure_message("_physics_process should've been invoked by the engine in kotlin").is_greater(0.0)
    kotlin_scene.set_process(false)
    kotlin_scene.set_physics_process(false)
    var process_delta: float = kotlin_scene.process_delta
    kotlin_scene._process(0.5)
    assert_float(kotlin_scene.process_delta).override_failure_message("_process should be callable by name in kotlin").is_equal(process_delta + 0.5)
    process_delta = kotlin_scene.process_delta
    kotlin_scene.call("_process", 2)
    assert_float(kotlin_scene.process_delta).override_failure_message("_process should accept an int by name in kotlin").is_equal(process_delta + 2.0)

    get_tree().root.remove_child(kotlin_scene)
    kotlin_scene.free()


func test_java_test_class() -> void:
    var java_scene: JavaTestClass = load("res://java_test_scene.tscn").instantiate()
    get_tree().root.add_child(java_scene)

    assert_that(java_scene.exported_int).override_failure_message("Field from java should match").is_equal(1)
    java_scene.exported_int = 2
    assert_that(java_scene.exported_int).override_failure_message("Field from java should be writable").is_equal(2)
    assert_that(java_scene.greeting()).override_failure_message("Greeting from java should match").is_equal("Hello from java")
    assert_bool(java_scene.entered_tree).override_failure_message("_enter_tree should've been invoked in java").is_true()

    java_scene.notification(0)
    assert_bool(java_scene.notification_triggered).override_failure_message("_notification should be registered and invoked in java").is_true()

    # Both signals fire before the callbacks of that step, so the second emission is the first after a complete one.
    await get_tree().process_frame
    await get_tree().process_frame
    await get_tree().physics_frame
    await get_tree().physics_frame
    assert_float(java_scene.process_delta).override_failure_message("_process should've been invoked by the engine in java").is_greater(0.0)
    assert_float(java_scene.physics_process_delta).override_failure_message("_physics_process should've been invoked by the engine in java").is_greater(0.0)
    java_scene.set_process(false)
    java_scene.set_physics_process(false)
    var process_delta: float = java_scene.process_delta
    java_scene._process(0.5)
    assert_float(java_scene.process_delta).override_failure_message("_process should be callable by name in java").is_equal(process_delta + 0.5)
    process_delta = java_scene.process_delta
    java_scene.call("_process", 2)
    assert_float(java_scene.process_delta).override_failure_message("_process should accept an int by name in java").is_equal(process_delta + 2.0)

    get_tree().root.remove_child(java_scene)
    java_scene.free()


func test_scala_test_class() -> void:
    var scala_scene: ScalaTestClass = load("res://scala_test_scene.tscn").instantiate()
    get_tree().root.add_child(scala_scene)

    assert_that(scala_scene.exported_int).override_failure_message("Field from scala should match").is_equal(1)
    scala_scene.exported_int = 2
    assert_that(scala_scene.exported_int).override_failure_message("Field from scala should be writable").is_equal(2)
    assert_that(scala_scene.greeting()).override_failure_message("Greeting from scala should match").is_equal("Hello from scala")
    assert_bool(scala_scene.entered_tree).override_failure_message("_enter_tree should've been invoked in scala").is_true()

    scala_scene.notification(0)
    assert_bool(scala_scene.notification_triggered).override_failure_message("_notification should be registered and invoked in scala").is_true()

    # Both signals fire before the callbacks of that step, so the second emission is the first after a complete one.
    await get_tree().process_frame
    await get_tree().process_frame
    await get_tree().physics_frame
    await get_tree().physics_frame
    assert_float(scala_scene.process_delta).override_failure_message("_process should've been invoked by the engine in scala").is_greater(0.0)
    assert_float(scala_scene.physics_process_delta).override_failure_message("_physics_process should've been invoked by the engine in scala").is_greater(0.0)
    scala_scene.set_process(false)
    scala_scene.set_physics_process(false)
    var process_delta: float = scala_scene.process_delta
    scala_scene._process(0.5)
    assert_float(scala_scene.process_delta).override_failure_message("_process should be callable by name in scala").is_equal(process_delta + 0.5)
    process_delta = scala_scene.process_delta
    scala_scene.call("_process", 2)
    assert_float(scala_scene.process_delta).override_failure_message("_process should accept an int by name in scala").is_equal(process_delta + 2.0)

    get_tree().root.remove_child(scala_scene)
    scala_scene.free()
