extends GdUnitTestSuite


func _call_on_instance(method: String) -> Variant:
    var instance := IcallTest.new()
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
    var instance := IcallTest.new()
    var label: Label = instance.create_label_for_caller()
    label.set_size(Vector2(24, 24))
    assert_that(label.size)\
        .override_failure_message("A JVM-constructed Label should be fully usable from GDScript")\
        .is_equal(Vector2(24, 24))
    label.free()
    instance.free()


# The mirror image: GDScript builds it, the JVM resizes it.
func test_gdscript_built_label_resized_by_jvm() -> void:
    var instance := IcallTest.new()
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


func test_call_with_variadic_arguments() -> void:
    assert_that(_call_on_instance("call_with_variadic_arguments"))        .override_failure_message("Object.call with a (Vector2, bool) tail should reach set_size through the variadic native call")        .is_equal(Vector2(3.5, 4.5))


func test_call_with_empty_variadic_tail() -> void:
    assert_str(_call_on_instance("call_with_empty_variadic_tail"))        .override_failure_message("Object.call with no extra arguments should still return the getter's value")        .is_equal("variadic")


func test_emit_signal_with_variadic_arguments() -> void:
    assert_str(_call_on_instance("emit_signal_with_variadic_arguments"))        .override_failure_message("Object.emit_signal with an (int, String) tail should deliver both values to the connected lambda")        .is_equal("seven:7")


func test_ptrcall_primitive_return() -> void:
    var instance := IcallTest.new()
    assert_int(instance.ptrcall_primitive_return())\
        .override_failure_message("A Long returned through the ptrcall should be the instance id")\
        .is_equal(instance.get_instance_id())
    instance.free()


func test_ptrcall_object_argument_and_return() -> void:
    assert_bool(_call_on_instance("ptrcall_object_argument_and_return"))\
        .override_failure_message("A Node passed and returned through the ptrcall should resolve to the same JVM instance")\
        .is_true()


func test_ptrcall_ref_counted_argument_and_return() -> void:
    assert_bool(_call_on_instance("ptrcall_ref_counted_argument_and_return"))\
        .override_failure_message("A Texture2D passed and returned through the ptrcall should resolve to the same JVM instance")\
        .is_true()


func test_ptrcall_ref_counted_return_keeps_reference_count() -> void:
    assert_int(_call_on_instance("ptrcall_ref_counted_return_keeps_reference_count"))\
        .override_failure_message("Reading a RefCounted through the ptrcall must not leak the reference the engine hands over")\
        .is_equal(2)


func test_icall_object_argument_and_return() -> void:
    assert_bool(_call_on_instance("icall_object_argument_and_return"))\
        .override_failure_message("A Node passed and returned through Object.call should resolve to the same JVM instance")\
        .is_true()


func test_icall_ref_counted_argument_and_return() -> void:
    assert_bool(_call_on_instance("icall_ref_counted_argument_and_return"))\
        .override_failure_message("A Texture2D passed and returned through Object.call should resolve to the same JVM instance")\
        .is_true()


func test_icall_ref_counted_return_keeps_reference_count() -> void:
    assert_int(_call_on_instance("icall_ref_counted_return_keeps_reference_count"))\
        .override_failure_message("Reading a RefCounted through Object.call must not change its reference count")\
        .is_equal(2)


func test_ptrcall_string_name_argument_and_return() -> void:
    assert_bool(_call_on_instance("ptrcall_string_name_argument_and_return"))\
        .override_failure_message("A StringName passed to setName and read back through getName should round-trip through the ptrcall")\
        .is_true()


func test_ptrcall_node_path_return() -> void:
    assert_that(_call_on_instance("ptrcall_node_path_return"))\
        .override_failure_message("getPathTo should return the child's NodePath through the ptrcall")\
        .is_equal(NodePath("Child"))


func test_ptrcall_node_path_argument() -> void:
    assert_bool(_call_on_instance("ptrcall_node_path_argument"))\
        .override_failure_message("getNodeOrNull(NodePath) should resolve the child through the ptrcall")\
        .is_true()


func test_ptrcall_array_return() -> void:
    assert_bool(_call_on_instance("ptrcall_array_return"))\
        .override_failure_message("getChildren should return both children in order through the ptrcall")\
        .is_true()


func test_ptrcall_dictionary_argument_and_return() -> void:
    var tags: Dictionary = _call_on_instance("ptrcall_dictionary_argument_and_return")
    assert_dict(tags)\
        .override_failure_message("A Dictionary passed to setTags and read back through getTags should round-trip through the ptrcall")\
        .is_equal({"title": "icall", "track": 7})


func test_ptrcall_packed_byte_array_argument_and_return() -> void:
    assert_array(_call_on_instance("ptrcall_packed_byte_array_argument_and_return"))\
        .override_failure_message("A PackedByteArray passed to setData and read back through getData should round-trip through the ptrcall")\
        .is_equal(PackedByteArray([1, 2, 3, 4]))


func test_ptrcall_packed_int32_array_return_from_packed_vector2_array_argument() -> void:
    var indices: PackedInt32Array = _call_on_instance("ptrcall_packed_int32_array_return_from_packed_vector2_array_argument")
    assert_int(indices.size())\
        .override_failure_message("Triangulating a square should yield two triangles, six indices")\
        .is_equal(6)


func test_ptrcall_packed_int64_array_return() -> void:
    var ids: PackedInt64Array = _call_on_instance("ptrcall_packed_int64_array_return")
    ids.sort()
    assert_array(ids)\
        .override_failure_message("getPointIds should return both point ids through the ptrcall")\
        .is_equal(PackedInt64Array([3, 5]))


func test_ptrcall_packed_float32_array_argument_and_return() -> void:
    assert_array(_call_on_instance("ptrcall_packed_float32_array_argument_and_return"))\
        .override_failure_message("A PackedFloat32Array passed to setOffsets and read back through getOffsets should round-trip through the ptrcall")\
        .is_equal(PackedFloat32Array([0.0, 0.25, 1.0]))


func test_ptrcall_packed_float64_array_argument_and_return() -> void:
    assert_array(_call_on_instance("ptrcall_packed_float64_array_argument_and_return"))\
        .override_failure_message("A PackedFloat64Array passed to setMin and read back through getMin should round-trip through the ptrcall")\
        .is_equal(PackedFloat64Array([-1.5, 0.0, 2.5]))


func test_ptrcall_packed_string_array_argument_and_return() -> void:
    assert_array(_call_on_instance("ptrcall_packed_string_array_argument_and_return"))\
        .override_failure_message("A PackedStringArray passed to setFontNames and read back through getFontNames should round-trip through the ptrcall")\
        .is_equal(PackedStringArray(["Sans", "Serif"]))


func test_ptrcall_packed_vector2_array_argument_and_return() -> void:
    var hull: PackedVector2Array = _call_on_instance("ptrcall_packed_vector2_array_argument_and_return")
    assert_bool(hull.has(Vector2(1, 1)))\
        .override_failure_message("The convex hull must drop the interior point (1, 1)")\
        .is_false()
    for corner in [Vector2(0, 0), Vector2(2, 0), Vector2(2, 2), Vector2(0, 2)]:
        assert_bool(hull.has(corner))\
            .override_failure_message("The convex hull must keep corner %s" % corner)\
            .is_true()


func test_ptrcall_packed_vector3_array_argument_and_return() -> void:
    var clipped: PackedVector3Array = _call_on_instance("ptrcall_packed_vector3_array_argument_and_return")
    assert_int(clipped.size())\
        .override_failure_message("Clipping a quad through its middle should leave a four-point polygon")\
        .is_equal(4)
    var signs := {}
    for point in clipped:
        signs[signf(point.x)] = true
    assert_bool(signs.has(1.0) and signs.has(-1.0))\
        .override_failure_message("The clipped polygon must lie on one side of the plane, got x values %s" % [clipped])\
        .is_false()


func test_ptrcall_packed_color_array_argument_and_return() -> void:
    assert_array(_call_on_instance("ptrcall_packed_color_array_argument_and_return"))\
        .override_failure_message("A PackedColorArray passed to setColors and read back through getColors should round-trip through the ptrcall")\
        .is_equal(PackedColorArray([Color(1, 0, 0), Color(0, 1, 0), Color(0, 0, 1)]))


func test_ptrcall_string_name_returns_in_bulk() -> void:
    assert_int(_call_on_instance("ptrcall_string_name_returns_in_bulk"))\
        .override_failure_message("Every getName call through the ptrcall should read back the name")\
        .is_equal(10000)


func test_ptrcall_dictionary_returns_in_bulk() -> void:
    assert_int(_call_on_instance("ptrcall_dictionary_returns_in_bulk"))\
        .override_failure_message("Every getTags call through the ptrcall should read back the dictionary")\
        .is_equal(10000)
