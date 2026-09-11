extends GdUnitTestSuite

func test_custom_enum_property():
	var script := EnumRegistration.new()
	assert_that(script.enum_value).override_failure_message("Should return enum with ordinal 1").is_equal(1)
	script.free()


func test_godot_error_enum_property():
	var script := EnumRegistration.new()
	assert_that(script.godot_error_enum_value).override_failure_message("Should return GodotError enum ERR_BUG").is_equal(ERR_BUG)
	script.free()


func test_godot_enum_property():
	var script := EnumRegistration.new()
	assert_that(script.godot_enum_value).override_failure_message("Should return Tween.EaseType.EASE_IN_OUT").is_equal(Tween.EaseType.EASE_IN_OUT)
	script.free()


func test_custom_enum_function_return():
	var script := EnumRegistration.new()
	assert_that(script.provide_enum_value()).override_failure_message("Should return enum with ordinal 1").is_equal(1)
	script.free()


func test_godot_error_enum_function_return():
	var script := EnumRegistration.new()
	assert_that(script.provide_godot_error_enum_value()).override_failure_message("Should return GodotError enum ERR_BUG").is_equal(ERR_BUG)
	script.free()


func test_godot_enum_function_return():
	var script := EnumRegistration.new()
	assert_that(script.provide_godot_enum_value()).override_failure_message("Should return Tween.EaseType.EASE_IN_OUT").is_equal(Tween.EaseType.EASE_IN_OUT)
	script.free()


func test_custom_enum_round_trip_and_history():
	var script := EnumRegistration.new()
	script.store_enum_by_ordinal(0)
	assert_that(script.enum_value).override_failure_message("Enum properties should round-trip when updated from GDScript through a Kotlin helper").is_equal(0)

	script.append_enum_to_history(0)
	assert_that(script.enum_history.size()).override_failure_message("Enum-backed arrays should remain appendable from bridge-facing helpers").is_equal(3)
	assert_that(script.enum_history[2]).override_failure_message("Appended enum entry should preserve its ordinal value").is_equal(0)
	script.free()


func test_invalid_enum_ordinal_handling():
	var script := EnumRegistration.new()
	assert_bool(script.invalid_enum_ordinal_handled(99)).override_failure_message("Invalid enum ordinals should be handled predictably instead of silently mapping to a wrong enum").is_true()
	assert_that(script.bit_flag_value).override_failure_message("Bit flag style enum values should stay readable from GDScript").is_equal(0b011)
	script.free()


func test_enum_list_property_round_trip():
	var script := EnumRegistration.new()
	assert_array(script.enum_list).override_failure_message("Enum list properties should be read as their ordinals").contains_exactly([1, 0])

	script.enum_list = [0, 1, 1]
	assert_that(script.enum_list_names()).override_failure_message("An untyped GDScript array assigned to an enum list should map back to enum entries").is_equal("ENUM_1,ENUM_2,ENUM_2")
	assert_array(script.enum_list).contains_exactly([0, 1, 1])

	var typed: Array[int] = [1]
	script.enum_list = typed
	assert_that(script.enum_list_names()).override_failure_message("A typed Array[int] assigned to an enum list should map back to enum entries").is_equal("ENUM_2")

	# JVM to Godot: the list is replaced on the Kotlin side and read back here.
	script.set_enum_list_from_jvm()
	assert_array(script.enum_list).override_failure_message("An enum list set from the JVM should be read as its godot values").contains_exactly([0, 0, 1])
	script.free()
