extends GdUnitTestSuite

# The JVM calls the engine, the engine calls back into the JVM from inside that call, and the JVM calls the engine
# again. The value buffer keeps one frame per engine call still in flight, so these assertions fail if a nested call
# reuses an outer frame, or if a frame is left on the stack after its call returns.

const DEPTH3_POSITION := Vector3(1.5, -2.25, 3.75)
const META_VALUE := 41
const SCENE_FILE_PATH := "res://buffer_nesting.tscn"


func _run_chain() -> Array:
    var instance := BufferNestingTest.new()
    var values: Array = instance.run_nested_chain()
    instance.free()
    return values


func test_nested_calls_run_in_order() -> void:
    assert_str(_run_chain()[0])\
        .override_failure_message("The engine should reenter the JVM from inside each notification, innermost last")\
        .is_equal("enter,first,second,exit")


func test_value_buffer_call_nested_two_frames_deep() -> void:
    assert_that(_run_chain()[1])\
        .override_failure_message("getPosition three levels down should read its own return slot, not an outer frame's")\
        .is_equal(DEPTH3_POSITION)


func test_variant_buffer_call_nested_inside_value_buffer_frames() -> void:
    assert_int(_run_chain()[2])\
        .override_failure_message("A Variant argument forces the variant buffer; its value must survive the nesting")\
        .is_equal(META_VALUE)


func test_string_argument_falls_back_to_the_variant_buffer() -> void:
    assert_str(_run_chain()[3])\
        .override_failure_message("A String argument forces the variant buffer and must round-trip while nested")\
        .is_equal(SCENE_FILE_PATH)


func test_state_written_while_nested_survives_the_unwind() -> void:
    var values := _run_chain()
    assert_that(values[4])\
        .override_failure_message("The position set three levels down should still be readable once the chain unwinds")\
        .is_equal(DEPTH3_POSITION)
    assert_int(values[5])\
        .override_failure_message("The metadata set while nested should still be readable once the chain unwinds")\
        .is_equal(META_VALUE)


# A frame pushed without being popped would drift the stack up by one frame per run and eventually overflow it.
func test_repeated_nesting_does_not_leak_frames() -> void:
    var instance := BufferNestingTest.new()
    var ok: bool = instance.run_nested_chain_repeatedly(64)
    instance.free()
    assert_bool(ok)\
        .override_failure_message("Running the nested chain 64 times should leave the frame stack exactly as it found it")\
        .is_true()


# Frames are packed, so the size factor is room for entirely full frames, not a cap on how many calls may nest.
# Twelve nested engine calls are far more than the four the default factor is named after, and still fit easily.
func test_nesting_is_not_limited_to_the_size_factor() -> void:
    var instance := BufferNestingTest.new()
    var ok: bool = instance.run_deep_nesting(12)
    instance.free()
    assert_bool(ok)\
        .override_failure_message("Twelve nested engine calls should fit in the default value buffer")\
        .is_true()
