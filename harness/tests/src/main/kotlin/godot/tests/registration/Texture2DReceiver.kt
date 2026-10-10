package godot.tests.registration

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.api.Texture2D

@Script
class Texture2DReceiver : Node() {
    @Register
    fun textureWidth(texture: Texture2D): Int = texture.getWidth()

    @Register
    fun textureAsVariant(texture: Texture2D): Any? = texture
}
