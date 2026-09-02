extends GdUnitTestSuite


func test_kotlin_autoloads_are_accessible() -> void:
    assert_that(KotlinScriptSingleton).override_failure_message("The direct Kotlin script autoload should be accessible").is_not_null()
    assert_that(KotlinScriptSingleton.property_value).is_equal("script-autoload-property")
    assert_that(KotlinScriptSingleton.read_value()).is_equal("script-autoload-method")

    assert_that(KotlinSceneSingleton).override_failure_message("The scene Kotlin autoload should be accessible").is_not_null()
    assert_that(KotlinSceneSingleton.property_value).is_equal("scene-autoload-property")
    assert_that(KotlinSceneSingleton.read_value()).is_equal("scene-autoload-method")
