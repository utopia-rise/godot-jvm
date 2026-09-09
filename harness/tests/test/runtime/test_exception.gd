extends GdUnitTestSuite

func test_throw_exception_reports_runtime_error() -> void:
    var exception_test := ExceptionTest.new()

    assert_bool(exception_test.has_method("throw_exception")).override_failure_message("The JVM exception fixture should still expose the throw_exception method").is_true()

    exception_test.free()
