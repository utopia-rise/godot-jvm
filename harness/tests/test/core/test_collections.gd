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


func test_dictionary_typing_matches_the_engine() -> void:
    var instance := CollectionsTest.new()
    var engine_dictionary: Dictionary = instance.new_typed_dictionary()

    assert_that([
        engine_dictionary.is_typed(),
        engine_dictionary.is_typed_key(),
        engine_dictionary.is_typed_value(),
        engine_dictionary.get_typed_key_builtin(),
        engine_dictionary.get_typed_value_builtin(),
    ]).override_failure_message("A Dictionary<String, Long> should be typed on the Godot side").is_equal([true, true, true, TYPE_STRING, TYPE_INT])
    assert_that(instance.jvm_typing_of_dictionary()).override_failure_message("The JVM typing queries should answer like Godot").is_equal([
        true, true, true, TYPE_STRING, TYPE_INT,
        false, false, TYPE_NIL,
        true, true, false,
    ])
    instance.free()


func test_dictionary_operations() -> void:
    var instance := CollectionsTest.new()

    assert_that(instance.dictionary_operations()).is_equal([
        3,
        1,
        {"a": 100, "b": 2, "c": 3, "d": 4},
        true,
        false,
        "b",
        null,
        true,
        true,
        null,
        true,
        true,
        {"a": 1, "b": 2, "e": 5},
    ])
    instance.free()


func test_empty_typed_array_accessors_return_null() -> void:
    var instance := CollectionsTest.new()

    assert_that(instance.empty_typed_array_accessors()).is_equal([null, null, null, null])
    instance.free()


func test_out_of_range_indexes_throw_in_debug_builds() -> void:
    if not OS.is_debug_build():
        return
    var instance := CollectionsTest.new()

    assert_that(instance.out_of_range_indexes_throw()).is_equal([true, true, true, true, true, true])
    instance.free()


func test_array_typed_callables() -> void:
    var instance := CollectionsTest.new()

    assert_that(instance.array_callables()).is_equal([
        1,
        3,
        true,
        true,
        [3, 4, 5],
        [6, 2, 8, 2, 10],
        14,
        [5, 4, 3, 1, 1],
        2,
    ])
    instance.free()


func test_array_operations() -> void:
    var instance := CollectionsTest.new()

    assert_that(instance.array_operations()).is_equal([
        [3, 9, 1, 0],
        2,
        OK,
        OK,
        [3, 9, 1, 0, 7],
        true,
        true,
        true,
        true,
        false,
        true,
        true,
        TYPE_INT,
    ])
    instance.free()


func test_arrays_from_packed_arrays_are_typed() -> void:
    var instance := CollectionsTest.new()
    var result: Array = instance.arrays_from_packed_arrays()

    assert_that(result.slice(0, 5)).is_equal([[1, 2], [3, 4], [0.5], ["a", "b"], [Color(1, 0, 0, 1)]])
    assert_that(result.slice(0, 5).map(func(array: Array) -> int: return array.get_typed_builtin())).is_equal([TYPE_INT, TYPE_INT, TYPE_FLOAT, TYPE_STRING, TYPE_COLOR])
    assert_that(result.slice(5)).is_equal([1, 4])
    instance.free()
