extends GdUnitTestSuite

var test_data = [
    "arg1",
    "arg2",
    "arg3",
    "arg4",
    "arg5",
    "arg6",
    "arg7",
    "arg8",
    "arg9",
    "arg10",
    "arg11",
    "arg12",
    "arg13",
    "arg14",
    "arg15",
    "arg16",
]

func test_function_arg_size():
    for arg_count in range(0, test_data.size()):
        var data = test_data.slice(0, arg_count)
        var test_instance = FunctionArgSizeTest.new()

        var result = test_instance.callv("arg%s" % arg_count, data)

        if arg_count != 0:
            for arg_index in range(0, arg_count):
                var expected_data = data[arg_index]
                var actual_data = result[arg_index]
                assert_that(expected_data).override_failure_message("arg with index %s did not match expected arg" % arg_index).is_equal(actual_data)
        else:
            assert_that(result.size()).override_failure_message("arg count should be 0 when calling no arg function").is_equal(0)

        test_instance.free()

func test_rejected_call_leaves_the_next_call_working():
    var test_instance = FunctionArgSizeTest.new()

    assert_that(test_instance.callv("arg2", ["arg1"])).override_failure_message("a call with too few arguments should be rejected").is_null()
    assert_that(test_instance.callv("arg1", ["arg1", "arg2"])).override_failure_message("a call with too many arguments should be rejected").is_null()
    assert_that(test_instance.callv("arg1", [1])).override_failure_message("a call with an argument of the wrong type should return null").is_null()
    assert_that(test_instance.callv("arg1", ["arg1"])).override_failure_message("a call after rejected ones should work").is_equal(["arg1"])

    test_instance.free()

func test_call_above_the_argument_limit_is_rejected():
    if not OS.is_debug_build():
        return
    var too_many := []
    for i in 64:
        too_many.append("x".repeat(120))
    var test_instance = FunctionArgSizeTest.new()
    var lambdas := LambdaCallableKotlinTest.new()

    assert_that(test_instance.callv("arg1", too_many)).override_failure_message("a script call above the argument limit should be rejected").is_null()
    assert_that(lambdas.returns_int.callv(too_many)).override_failure_message("a lambda call above the argument limit should be rejected").is_null()
    assert_that(test_instance.callv("arg1", ["arg1"])).override_failure_message("a call after a rejected one should work").is_equal(["arg1"])
    assert_that(lambdas.returns_int.call()).override_failure_message("a lambda call after a rejected one should work").is_equal(42)

    lambdas.free()
    test_instance.free()
