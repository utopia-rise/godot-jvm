package godot.tests.runtime

import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node

@Script
class KotlinSceneAutoload : Node() {
    @Visible
    val propertyValue = "scene-autoload-property"

    @Register
    fun readValue(): String = "scene-autoload-method"
}
