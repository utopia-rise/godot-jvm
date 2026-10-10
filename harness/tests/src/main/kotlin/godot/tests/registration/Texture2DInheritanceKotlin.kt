package godot.tests.registration

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Texture2D

@Script
class Texture2DInheritanceKotlin : Texture2D() {
    @Register
    override fun _getWidth(): Int = 7

    @Register
    override fun _getHeight(): Int = 3
}
