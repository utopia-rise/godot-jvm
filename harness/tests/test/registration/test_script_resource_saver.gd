extends GdUnitTestSuite

const JVM_EXTENSIONS := ["kt", "java", "scala", "gdj"]


func test_jvm_extensions_are_only_offered_for_their_own_script():
    assert_array(_offered_jvm_extensions(PackedScene.new())).override_failure_message("a scene should not be offered JVM script extensions").is_empty()
    var scripts := {
        "kt": "res://src/main/kotlin/godot/tests/registration/KotlinExport.kt",
        "java": "res://src/main/java/godot/tests/registration/JavaExport.java",
        "scala": "res://src/main/scala/godot/tests/registration/ScalaExport.scala",
    }
    for extension: String in scripts:
        assert_array(_offered_jvm_extensions(load(scripts[extension]))).override_failure_message("a %s script should only be offered its own extension" % extension).is_equal([extension])


func _offered_jvm_extensions(resource: Resource) -> Array:
    var offered := []
    for extension in ResourceSaver.get_recognized_extensions(resource):
        if extension in JVM_EXTENSIONS:
            offered.append(extension)
    return offered
