extends GdUnitTestSuite

func test_throw_exception_reports_runtime_error() -> void:
    print("ANDROID_DIAG_EXCEPTION:before_new")
    var exception_test := ExceptionTest.new()
    print("ANDROID_DIAG_EXCEPTION:after_new")

    assert_bool(exception_test.has_method("throw_exception")).override_failure_message("The JVM exception fixture should still expose the throw_exception method").is_true()
    print("ANDROID_DIAG_EXCEPTION:after_has_method")

    exception_test.free()
    print("ANDROID_DIAG_EXCEPTION:after_free")
