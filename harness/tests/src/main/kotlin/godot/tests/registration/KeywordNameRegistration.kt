package godot.tests.registration

import godot.annotation.Export
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.api.Node

@Script
class KeywordNameRegistration : Node() {
    @Export
    @Visible
    var `object` = 1

    @Register
    fun `throw`(value: Int): Int = value * 2
}
