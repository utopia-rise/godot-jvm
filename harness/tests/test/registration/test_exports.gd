extends GdUnitTestSuite

const EXPORT_INSPECTOR_SCENE := preload("res://export_inspector_scene.tscn")


func test_reenabled_core_exports_are_registered_across_languages() -> void:
    var scene: Node = EXPORT_INSPECTOR_SCENE.instantiate()
    add_child(scene)

    var kotlin_export_node := scene.get_node(^"KotlinExportNode")
    _assert_reenabled_exports(kotlin_export_node, true)
    _assert_reenabled_exports(scene.get_node(^"JavaExportNode"))
    _assert_reenabled_exports(scene.get_node(^"ScalaExportNode"))

    scene.queue_free()
    await get_tree().process_frame


func test_kotlin_object_export_resolves_scene_node() -> void:
    var scene: Node = EXPORT_INSPECTOR_SCENE.instantiate()
    add_child(scene)

    var kotlin_export_node := scene.get_node(^"KotlinExportNode")
    assert_object(kotlin_export_node.get("button"))\
        .override_failure_message("Expected the Kotlin exported node property to resolve from the scene NodePath")\
        .is_same(kotlin_export_node.get_node(^"Button"))

    scene.queue_free()
    await get_tree().process_frame


func test_kotlin_node_path_export_retains_scene_path() -> void:
    var scene: Node = EXPORT_INSPECTOR_SCENE.instantiate()
    add_child(scene)

    var kotlin_export_node := scene.get_node(^"KotlinExportNode")
    var node_path: NodePath = kotlin_export_node.get("node_path")
    assert_that(node_path)\
        .override_failure_message("Expected the Kotlin NodePath export to retain the scene path")\
        .is_equal(NodePath("Button"))
    assert_object(kotlin_export_node.get_node(node_path))\
        .override_failure_message("Expected the Kotlin NodePath export to resolve to the scene Button")\
        .is_same(kotlin_export_node.get_node(^"Button"))

    scene.queue_free()
    await get_tree().process_frame


func test_kotlin_resource_export_retains_scene_resource() -> void:
    var scene: Node = EXPORT_INSPECTOR_SCENE.instantiate()
    add_child(scene)

    var resource = scene.get_node(^"KotlinExportNode").get("resource_test")
    assert_bool(resource is NavigationMesh)\
        .override_failure_message("Expected the Kotlin resource export to retain its NavigationMesh")\
        .is_true()
    assert_that(resource.agent_height)\
        .override_failure_message("Expected the Kotlin resource export to retain its scene value")\
        .is_equal(2.5)

    scene.queue_free()
    await get_tree().process_frame


func _assert_reenabled_exports(instance: Object, expect_lazy_export := false) -> void:
    var property_map := _property_map(instance)

    if expect_lazy_export:
        _assert_exported_property(property_map, "lazy_int_value", TYPE_INT)
        assert_that(instance.get("lazy_int_value")).is_equal(42)

        _assert_kotlin_delegate_property(property_map, instance, "observable_visible_int_value", 110, 111, false)
        _assert_kotlin_delegate_property(property_map, instance, "observable_export_int_value", 10, 11, true)
        _assert_kotlin_delegate_property(property_map, instance, "vetoable_visible_int_value", 120, 121, false)
        _assert_kotlin_delegate_property(property_map, instance, "vetoable_export_int_value", 20, 21, true)
        _assert_kotlin_delegate_property(property_map, instance, "not_null_visible_int_value", 130, 131, false)
        _assert_kotlin_delegate_property(property_map, instance, "not_null_export_int_value", 30, 31, true)
        _assert_kotlin_delegate_property(property_map, instance, "custom_delegate_visible_int_value", 140, 141, false)
        _assert_kotlin_delegate_property(property_map, instance, "custom_delegate_export_int_value", 40, 41, true)
        _assert_kotlin_delegate_property(property_map, instance, "static_delegate_visible_int_value", 160, 161, false)
        _assert_kotlin_delegate_property(property_map, instance, "static_delegate_export_int_value", 60, 61, true)
        _assert_kotlin_delegate_property(property_map, instance, "delegated_property_reference_visible_int_value", 170, 171, false)
        _assert_kotlin_delegate_property(property_map, instance, "delegated_property_reference_export_int_value", 70, 71, true)
        _assert_kotlin_delegate_property(property_map, instance, "computed_visible_int_value", 180, 181, false)
        _assert_kotlin_delegate_property(property_map, instance, "computed_export_int_value", 80, 81, true)

        _assert_exported_property(property_map, "vector2_alias", TYPE_VECTOR2)
        assert_that(instance.get("vector2_alias")).is_equal(Vector2(3, 4))

        _assert_exported_property(property_map, "node_path", TYPE_NODE_PATH)
        _assert_exported_property(property_map, "resource_test", TYPE_OBJECT)

    _assert_exported_property(property_map, "vector2i", TYPE_VECTOR2I)
    assert_that(instance.get("vector2i")).is_equal(Vector2i(1, 2))

    _assert_exported_property(property_map, "rect2i", TYPE_RECT2I)
    assert_that(instance.get("rect2i")).is_equal(Rect2i(1, 2, 3, 4))

    _assert_exported_property(property_map, "vector3i", TYPE_VECTOR3I)
    assert_that(instance.get("vector3i")).is_equal(Vector3i(1, 2, 3))

    _assert_exported_property(property_map, "projection_value", TYPE_PROJECTION)
    assert_that(str(instance.get("projection_value"))).is_equal(str(Projection()))

    _assert_exported_property(property_map, "packed_vector4_array", TYPE_PACKED_VECTOR4_ARRAY)
    assert_that(instance.get("packed_vector4_array").size()).is_equal(0)


func _assert_kotlin_delegate_property(property_map: Dictionary, instance: Object, property_name: String, initial_value: int, assigned_value: int, is_exported: bool) -> void:
    _assert_registered_property(property_map, property_name, TYPE_INT, is_exported)
    assert_that(instance.get(property_name)).is_equal(initial_value)
    instance.set(property_name, assigned_value)
    assert_that(instance.get(property_name)).is_equal(assigned_value)


func _property_map(instance: Object) -> Dictionary:
    var properties := {}
    for property: Dictionary in instance.get_property_list():
        properties[property["name"]] = property
    return properties


func _assert_exported_property(property_map: Dictionary, property_name: String, variant_type: int) -> void:
    _assert_registered_property(property_map, property_name, variant_type, true)


func _assert_registered_property(property_map: Dictionary, property_name: String, variant_type: int, is_exported: bool) -> void:
    assert_bool(property_map.has(property_name))\
        .override_failure_message("Expected registered property '%s' to be present in the property list" % property_name)\
        .is_true()

    var property: Dictionary = property_map[property_name]
    assert_that(property["type"])\
        .override_failure_message("Expected registered property '%s' to keep its Variant type" % property_name)\
        .is_equal(variant_type)
    var is_editor_export: bool = (property["usage"] & PROPERTY_USAGE_EDITOR) != 0
    if is_exported:
        assert_bool(is_editor_export)\
            .override_failure_message("Expected property '%s' to remain marked as an editor-visible export" % property_name)\
            .is_true()
    else:
        assert_bool(is_editor_export)\
            .override_failure_message("Expected visible property '%s' not to be exported to the editor" % property_name)\
            .is_false()
