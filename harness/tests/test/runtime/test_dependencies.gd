extends GdUnitTestSuite


func test_dependencies_of_every_configuration_are_loadable() -> void:
    var dependency_test = load("res://src/main/kotlin/godot/tests/dependencies/DependencyTest.kt").new()

    assert_that(dependency_test.bootstrap_jar_dependency()).override_failure_message("implementation dependencies should load from godot-bootstrap.jar").is_equal("2024")
    assert_that(dependency_test.user_code_jar_dependency()).override_failure_message("godotGameImplementation dependencies should load from usercode.jar").is_equal("Godot")
    assert_that(dependency_test.single_jar_dependency()).override_failure_message("godotSplitImplementation dependencies should load from jvm/<variant>/dependencies/ next to the bootstrap jar").is_equal("jvm")
    assert_that(dependency_test.user_code_jar_runtime_only_dependency()).override_failure_message("godotGameRuntimeOnly dependencies should load from usercode.jar").is_equal("Bag")
    assert_that(dependency_test.single_jar_runtime_only_dependency()).override_failure_message("godotSplitRuntimeOnly dependencies should load from jvm/<variant>/dependencies/ next to the bootstrap jar").is_equal("Hex")

    dependency_test.free()


func test_merged_dependencies_keep_every_service_provider() -> void:
    var dependency_test = load("res://src/main/kotlin/godot/tests/dependencies/DependencyTest.kt").new()

    assert_that(dependency_test.merged_service_providers()).override_failure_message("every dependency registering the same service, in godot-bootstrap.jar and usercode.jar alike, should be found").is_equal("JavaTimeModule,Jdk8Module,KotlinModule")

    dependency_test.free()


func test_multi_release_dependencies_use_their_versioned_classes() -> void:
    # D8 dexes only the base classes of a multi-release jar, so ART never sees the versioned ones.
    if OS.get_name() == "Android":
        return
    var dependency_test = load("res://src/main/kotlin/godot/tests/dependencies/DependencyTest.kt").new()

    assert_that(dependency_test.multi_release_dependency()).override_failure_message("classes under META-INF/versions of a merged multi-release jar should be loaded").is_equal("DependencyTest")

    dependency_test.free()
