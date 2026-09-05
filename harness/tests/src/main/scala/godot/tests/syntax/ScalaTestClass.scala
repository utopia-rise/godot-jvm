package godot.tests.syntax

import godot.annotation.{Export, Notification, Script, Register, Visible}
import godot.api.Node

@Script
class ScalaTestClass extends Node {
  @Export
  @Visible
  var exportedInt: Int = 1

  @Visible
  var enteredTree: Boolean = false

  @Visible
  var notificationTriggered: Boolean = false

  @Register
  def greeting: String = "Hello from scala"

  @Register
  override def _enterTree(): Unit = {
    enteredTree = true
  }

  @Notification(0)
  def onNotification(): Unit =
    notificationTriggered = true
}
