extends GdUnitTestSuite

# Names below resolve through the global class cache only, never through a script path. Release exports in CI are made
# without a debug build, so they check the cache built from the script class index.

func test_instantiate_jvm_class_by_name() -> void:
    var child: ClassInheritanceChild = ClassInheritanceChild.new()
    assert_object(child).is_not_null()
    assert_bool(child is ClassInheritanceParent).is_true()
    assert_bool(child is Node).is_true()
    child.free()

func test_global_class_cache_lists_jvm_classes() -> void:
    var classes := {}
    for entry in ProjectSettings.get_global_class_list():
        classes[entry["class"]] = entry
    assert_bool(classes.has("ClassInheritanceChild")).is_true()
    assert_str(classes["ClassInheritanceChild"]["base"]).is_equal("ClassInheritanceParent")
    assert_str(classes["ClassInheritanceChild"]["language"]).is_equal("Kotlin")
    assert_bool(classes.has("ClassInheritanceParent")).is_true()
    assert_str(classes["ClassInheritanceParent"]["base"]).is_equal("Node")
    assert_bool(classes.has("Simple")).is_true()
    assert_str(classes["Simple"]["base"]).is_equal("Node")
