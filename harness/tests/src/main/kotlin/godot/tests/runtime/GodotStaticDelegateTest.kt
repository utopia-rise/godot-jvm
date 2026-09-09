package godot.tests.runtime

import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node
import godot.api.PackedScene
import godot.api.ResourceLoader
import godot.extension.asStatic

@Script
class GodotStaticDelegateTest : Node() {

    @Visible
    var loadedScene: PackedScene? = ResourceLoader.load("res://Spatial.tscn") as PackedScene?

    @Visible
    var staticNode: Node = Node().asStatic()
}

