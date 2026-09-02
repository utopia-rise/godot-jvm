package godot.tests.runtime

import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node

@Script
class KotlinScriptAutoload : Node() {
    @Visible
    val propertyValue = "script-autoload-property"

    @Register
    fun readValue(): String = "script-autoload-method"
}
