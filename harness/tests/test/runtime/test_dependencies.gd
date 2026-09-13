extends GdUnitTestSuite


func test_dependencies_of_every_configuration_are_loadable() -> void:
    var dependency_test = load("res://src/main/kotlin/godot/tests/dependencies/DependencyTest.kt").new()

    assert_that(dependency_test.bootstrap_jar_dependency()).override_failure_message("implementation dependencies should load from godot-bootstrap.jar").is_equal("2024")
    assert_that(dependency_test.user_code_jar_dependency()).override_failure_message("godotGameImplementation dependencies should load from usercode.jar").is_equal("Godot")
    assert_that(dependency_test.single_jar_dependency()).override_failure_message("godotSplitImplementation dependencies should load from jvm/<variant>/dependencies/ next to the user code jar").is_equal("jvm")

    dependency_test.free()
