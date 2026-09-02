extends GdUnitTestSuite


func test_call_function_in_godot_jvm_dependency():
	var library_test_script = load("res://scripts/third-party-library/godot/tests/library/Simple.gdj")
	var library_test = library_test_script.new()

	assert_that(library_test.provide_greeting()).override_failure_message("Greeting from dependency library does not match").is_equal("Hello from third-party-library!")

	library_test.free()
