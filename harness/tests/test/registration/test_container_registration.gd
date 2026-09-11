extends GdUnitTestSuite

# Each case is one round trip: read the JVM value (JVM -> Godot), assign from GDScript, read it back through the JVM
# `describe` function that consumes the elements with their declared JVM type (Godot -> JVM).


func test_any_array() -> void:
    var script := ContainerRegistration.new()

    assert_array(script.any_array).contains_exactly([1, "two", 3.0, Vector2(4, 5)])

    script.any_array = [true, 7, "seven", Vector2i(1, 1)]
    assert_that(script.describe_any_array()).is_equal("Boolean:true|Long:7|String:seven|Vector2i:(1, 1)")

    script.free()


func test_star_array() -> void:
    var script := ContainerRegistration.new()

    assert_array(script.star_array).contains_exactly([1, "two", 3.0])

    script.star_array = [false, 9, Vector3(1, 2, 3)]
    assert_that(script.describe_star_array()).is_equal("Boolean:false|Long:9|Vector3:(1.0, 2.0, 3.0)")

    script.free()


func test_int_array() -> void:
    var script := ContainerRegistration.new()

    assert_array(script.int_array).contains_exactly([1, 2, 3])

    script.int_array = [10, 20]
    assert_that(script.describe_int_array()).is_equal("11|21")

    var typed: Array[int] = [30]
    script.int_array = typed
    assert_that(script.describe_int_array()).is_equal("31")

    script.free()


func test_byte_array() -> void:
    var script := ContainerRegistration.new()

    assert_array(script.byte_array).contains_exactly([1, 2])

    script.byte_array = [5, 6, 7]
    assert_that(script.describe_byte_array()).is_equal("6|7|8")

    script.free()


func test_string_array() -> void:
    var script := ContainerRegistration.new()

    assert_array(script.string_array).contains_exactly(["a", "b"])

    script.string_array = ["x", "y", "z"]
    assert_that(script.describe_string_array()).is_equal("X|Y|Z")

    script.free()


func test_nested_int_array() -> void:
    var script := ContainerRegistration.new()

    assert_array(script.nested_int_array).contains_exactly([[1, 2], [3]])

    script.nested_int_array = [[4, 5, 6], [], [7]]
    assert_that(script.describe_nested_int_array()).is_equal("15|0|7")

    script.free()


func test_star_dictionary() -> void:
    var script := ContainerRegistration.new()

    assert_dict(script.star_dictionary).contains_key_value("one", 1).contains_key_value(2, "two")

    script.star_dictionary = {"k": 4.5}
    assert_that(script.describe_star_dictionary()).is_equal("k=Double:4.5")

    script.free()


func test_string_int_dictionary() -> void:
    var script := ContainerRegistration.new()

    assert_dict(script.string_int_dictionary).contains_key_value("one", 1).contains_key_value("two", 2)

    script.string_int_dictionary = {"three": 3, "four": 4}
    assert_that(script.describe_string_int_dictionary()).is_equal("four=5|three=4")

    script.free()


func test_byte_float_dictionary() -> void:
    var script := ContainerRegistration.new()

    assert_dict(script.byte_float_dictionary).contains_key_value(1, 1.5).contains_key_value(2, 2.5)

    script.byte_float_dictionary = {3: 0.25, 4: 1.0}
    assert_that(script.describe_byte_float_dictionary()).is_equal("4=0.5|5=2.0")

    script.free()


func test_nested_dictionary() -> void:
    var script := ContainerRegistration.new()

    assert_dict(script.nested_dictionary).contains_key_value("odd", [1, 3]).contains_key_value("even", [2])

    script.nested_dictionary = {"a": [1, 1], "b": [5]}
    assert_that(script.describe_nested_dictionary()).is_equal("a=2|b=5")

    script.free()
