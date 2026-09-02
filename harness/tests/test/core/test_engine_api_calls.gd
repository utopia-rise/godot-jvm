extends GdUnitTestSuite


func _call_on_instance(method: String) -> Variant:
    var instance := EngineApiCallTest.new()
    var result: Variant = instance.call(method)
    instance.free()
    return result


func test_label_text_only() -> void:
    assert_str(_call_on_instance("label_text_only"))\
        .override_failure_message("Setting and reading back a String property on a Label should round-trip")\
        .is_equal("x")


# Resizing a text-drawing Control built by InstanceCreator used to crash, because engine objects were
# never sent NOTIFICATION_POSTINITIALIZE and so never built their theme item cache. Button covers the
# same path; Panel and Control cover the other side of the split, having passed even while broken
# because they never read that cache.
func test_label_set_size_without_text() -> void:
    assert_that(_call_on_instance("label_set_size_without_text"))\
        .override_failure_message("setSize(Vector2) on a Label should apply the size")\
        .is_equal(Vector2(24, 24))


func test_label_text_then_set_size() -> void:
    assert_that(_call_on_instance("label_text_then_set_size"))\
        .override_failure_message("Setting a String property and then calling setSize(Vector2) should keep the size")\
        .is_equal(Vector2(24, 24))


func test_button_set_size() -> void:
    assert_that(_call_on_instance("button_set_size"))\
        .override_failure_message("setSize(Vector2) on a Button should apply the size")\
        .is_equal(Vector2(24, 24))


func test_panel_set_size() -> void:
    assert_that(_call_on_instance("panel_set_size"))\
        .override_failure_message("setSize(Vector2) on a Panel should apply the size")\
        .is_equal(Vector2(24, 24))


# The JVM builds the Control but GDScript resizes it, so a half-built object still fails here even
# though the call itself never crosses the JVM boundary.
func test_jvm_built_label_resized_by_gdscript() -> void:
    var instance := EngineApiCallTest.new()
    var label: Label = instance.create_label_for_caller()
    label.set_size(Vector2(24, 24))
    assert_that(label.size)\
        .override_failure_message("A JVM-constructed Label should be fully usable from GDScript")\
        .is_equal(Vector2(24, 24))
    label.free()
    instance.free()


# The mirror image: GDScript builds it, the JVM resizes it.
func test_gdscript_built_label_resized_by_jvm() -> void:
    var instance := EngineApiCallTest.new()
    var label := Label.new()
    assert_that(instance.set_size_on_given_control(label))\
        .override_failure_message("A GDScript-constructed Label should be resizable from JVM code")\
        .is_equal(Vector2(24, 24))
    label.free()
    instance.free()


func test_control_set_size_with_defaulted_argument() -> void:
    assert_that(_call_on_instance("control_set_size_with_defaulted_argument"))\
        .override_failure_message("setSize should apply the size when its trailing argument is left defaulted")\
        .is_equal(Vector2(12.5, 34.25))


# Passing false still exercises the explicit trailing boolean without asking a parentless Control to
# recompute offsets from a parent rect.
func test_control_set_size_with_explicit_argument() -> void:
    assert_that(_call_on_instance("control_set_size_with_explicit_argument"))\
        .override_failure_message("setSize with an explicit trailing argument should preserve the requested size")\
        .is_equal(Vector2(48, 64))


func test_control_set_position_with_defaulted_argument() -> void:
    assert_that(_call_on_instance("control_set_position_with_defaulted_argument"))\
        .override_failure_message("setPosition should apply the position when its trailing argument is left defaulted")\
        .is_equal(Vector2(7.5, -3.25))


func test_control_set_custom_minimum_size() -> void:
    assert_that(_call_on_instance("control_set_custom_minimum_size"))\
        .override_failure_message("setCustomMinimumSize should apply the size")\
        .is_equal(Vector2(5, 6))


func test_control_set_anchor_mixed_arguments() -> void:
    assert_float(_call_on_instance("control_set_anchor_mixed_arguments"))\
        .override_failure_message("setAnchor should preserve its float anchor alongside its enum and bool arguments")\
        .is_equal_approx(0.25, 0.0001)


func test_control_set_anchors_preset_with_defaulted_argument() -> void:
    assert_float(_call_on_instance("control_set_anchors_preset_with_defaulted_argument"))\
        .override_failure_message("setAnchorsPreset(PRESET_FULL_RECT) should push the right anchor to 1.0")\
        .is_equal_approx(1.0, 0.0001)


func test_control_theme_overrides_mixed_arguments() -> void:
    var values: Array = _call_on_instance("control_theme_overrides_mixed_arguments")

    assert_int(values.size())\
        .override_failure_message("The theme override call should return both read-back values")\
        .is_equal(2)
    assert_that(values[0])\
        .override_failure_message("addThemeColorOverride(StringName, Color) should preserve the color")\
        .is_equal(Color(0.25, 0.5, 0.75, 1.0))
    assert_int(values[1])\
        .override_failure_message("addThemeConstantOverride(StringName, int) should preserve the constant")\
        .is_equal(7)


func test_node_set_name_then_multiplayer_authority() -> void:
    assert_str(_call_on_instance("node_set_name_then_multiplayer_authority"))\
        .override_failure_message("setName(String) should survive a following (int, bool) call")\
        .is_equal("MixedArgumentNode")


func test_node3d_vector3_and_transform_arguments() -> void:
    assert_that(_call_on_instance("node3d_vector3_and_transform_arguments"))\
        .override_failure_message("The last setPosition(Vector3) should win after interleaved Vector3 and Transform3D calls")\
        .is_equal(Vector3(4.5, 5.5, 6.5))


func test_interleaved_mixed_argument_calls() -> void:
    assert_that(_call_on_instance("interleaved_mixed_argument_calls"))\
        .override_failure_message("setSize should still apply after calls with differing argument arities and types")\
        .is_equal(Vector2(101.5, 202.5))
