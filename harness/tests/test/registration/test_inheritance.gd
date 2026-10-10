extends GdUnitTestSuite

func test_call_parent_closed_method_from_child() -> void:
    var child_script = ClassInheritanceChild.new()
    child_script.closed_function()
    assert_bool(child_script.closed_function_has_been_called)
    child_script.free()

func test_call_parent_open_method_from_parent() -> void:
    var parent_script = ClassInheritanceParent.new()
    parent_script.open_function()
    assert_bool(parent_script.parent_open_function_has_been_called).is_true()
    parent_script.free()

func test_call_parent_open_method_from_child() -> void:
    var child_script = ClassInheritanceChild.new()
    child_script.open_function()
    assert_bool(child_script.parent_open_function_has_been_called)
    assert_bool(child_script.child_open_function_has_been_called).is_true()
    child_script.free()

func test_call_parent_closed_var_from_child() -> void:
    var child_script = ClassInheritanceChild.new()
    assert_that(child_script.closed_var).override_failure_message("Parent's closed var should be 0").is_equal(0)
    child_script.closed_var = 1
    assert_that(child_script.closed_var).override_failure_message("Parent's closed var should be set to 1").is_equal(1)
    child_script.free()

func test_call_parent_open_var_from_parent() -> void:
    var parent_script = ClassInheritanceParent.new()
    assert_that(parent_script.open_var).override_failure_message("Parent's open var should be 0").is_equal(0)
    parent_script.open_var = 1
    assert_that(parent_script.open_var).override_failure_message("Parent's open var should be 1").is_equal(1)
    parent_script.free()

func test_call_parent_open_var_from_child() -> void:
    var child_script = ClassInheritanceChild.new()
    assert_that(child_script.open_var).override_failure_message("Open var inherited from parent should be to 100 by default.").is_equal(100)
    child_script.open_var = 101
    assert_that(child_script.open_var).override_failure_message("Open var inherited from parent should now be 101").is_equal(101)
    child_script.free()

func test_call_notification_without_inheritance() -> void:
    var parent_script = ClassInheritanceParent.new()
    parent_script.notification(0)
    assert_that(parent_script.notification_call_bit_flag).is_equal(1)
    parent_script.notification_call_bit_flag = 0
    parent_script.notification(0, true)
    assert_that(parent_script.notification_call_bit_flag).is_equal(1)
    parent_script.free()

func test_call_notification_with_inheritance() -> void:
    var child_script = ClassInheritanceChild.new()
    child_script.notification(0)
    assert_that(child_script.notification_call_bit_flag).is_equal(4)
    child_script.notification_call_bit_flag = 0
    child_script.notification(0, true)
    assert_that(child_script.notification_call_bit_flag).is_equal(3)
    child_script.free()
    
func test_script_is_child_of() -> void:
    var child = ClassInheritanceChild.new()
    var child_script: Script = child.get_script()
    var parent = ClassInheritanceParent.new()
    var parent_script: Script = parent.get_script()
    assert_that(child_script.get_base_script().get_global_name()).is_equal(parent_script.get_global_name())
    child.free()
    parent.free()


func test_abstract_call_parent_closed_method_from_child() -> void:
    var child_script = AbstractClassInheritanceChild.new()
    child_script.closed_function()
    assert_bool(child_script.closed_function_has_been_called).is_true()
    child_script.free()


func test_abstract_call_parent_open_method_from_child() -> void:
    var child_script = AbstractClassInheritanceChild.new()
    child_script.open_function()
    assert_bool(child_script.child_open_function_has_been_called).is_true()
    child_script.free()


func test_abstract_call_parent_closed_var_from_child() -> void:
    var child_script = AbstractClassInheritanceChild.new()
    assert_that(child_script.closed_var).override_failure_message("Parent's closed var should be 0").is_equal(0)
    child_script.closed_var = 1
    assert_that(child_script.closed_var).override_failure_message("Parent's closed var should be set to 1").is_equal(1)
    child_script.free()


func test_abstract_call_parent_open_var_from_child() -> void:
    var child_script = AbstractClassInheritanceChild.new()
    assert_that(child_script.open_var).override_failure_message("Open var inherited from parent should be to 100 by default.").is_equal(100)
    child_script.open_var = 101
    assert_that(child_script.open_var).override_failure_message("Open var inherited from parent should now be 101").is_equal(101)
    child_script.free()


const TEXTURE_2D_SCRIPTS := [
    "res://src/main/kotlin/godot/tests/registration/Texture2DInheritanceKotlin.kt",
    "res://src/main/java/godot/tests/registration/Texture2DInheritanceJava.java",
    "res://src/main/scala/godot/tests/registration/Texture2DInheritanceScala.scala",
]
const GD_TEXTURE_2D := preload("res://test/registration/fixtures/gd_texture_2d.gd")


func test_jvm_constructing_class_godot_cannot_instantiate_fails_cleanly() -> void:
    for constructor: Node in [CanvasItemConstructionJava.new(), CanvasItemConstructionScala.new()]:
        assert_str(constructor.construct_canvas_item()).override_failure_message("%s should not construct a CanvasItem" % constructor.get_script().resource_path).is_equal("Godot can't instantiate CanvasItem.")
        constructor.free()


func test_jvm_script_extends_class_with_required_virtuals() -> void:
    for path: String in TEXTURE_2D_SCRIPTS:
        var texture: Texture2D = load(path).new()
        assert_int(texture.get_width()).override_failure_message("%s should give Godot its width" % path).is_equal(7)
        assert_int(texture.get_height()).override_failure_message("%s should give Godot its height" % path).is_equal(3)


func test_jvm_receives_class_with_required_virtuals_carrying_gdscript() -> void:
    var receiver := Texture2DReceiver.new()
    var texture: Texture2D = GD_TEXTURE_2D.new()
    assert_int(receiver.texture_width(texture)).override_failure_message("the JVM should reach the GDScript's virtual through Texture2D").is_equal(5)
    assert_object(receiver.texture_as_variant(texture)).override_failure_message("the JVM should pass it back as a Variant").is_same(texture)
    receiver.free()
