extends GdUnitTestSuite


func test_reading_a_missing_key_leaves_the_dictionary_unchanged() -> void:
    var instance := CollectionsTest.new()
    var dictionary: Dictionary[String, int] = {"present": 1}

    assert_that(instance.read_missing_key(dictionary)).override_failure_message("Reading a missing key should return null").is_null()
    assert_that(dictionary).override_failure_message("Reading a missing key should not add it").is_equal({"present": 1})
    assert_bool(instance.get_value_of_missing_key_throws(dictionary)).override_failure_message("getValue should throw for a missing key").is_true()
    instance.free()


func test_untyped_nulls_read_as_null() -> void:
    var instance := CollectionsTest.new()

    assert_bool(instance.untyped_nulls_read_as_null()).override_failure_message("A null element of an untyped container should read as null").is_true()
    instance.free()
