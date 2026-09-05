package godot.tests.syntax

import godot.annotation.Export
import godot.annotation.Notification
import godot.annotation.Script
import godot.annotation.Register
import godot.annotation.Visible
import godot.api.Node

@Script
class KotlinTestClass : Node() {
    @Export
    @Visible
    var exportedInt = 1

    @Visible
    var enteredTree = false

    @Visible
    var notificationTriggered = false

    @Register
    fun greeting() = "Hello from kotlin"

    @Register
    override fun _enterTree() {
        enteredTree = true
    }

    @Notification(0)
    fun onNotification() {
        notificationTriggered = true
    }
}
