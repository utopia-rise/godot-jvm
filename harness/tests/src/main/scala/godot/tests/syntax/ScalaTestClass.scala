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

  @Visible
  var processDelta: Double = 0.0

  @Visible
  var physicsProcessDelta: Double = 0.0

  @Register
  def greeting: String = "Hello from scala"

  @Register
  override def _enterTree(): Unit = {
    enteredTree = true
  }

  @Register
  override def _process(delta: Double): Unit = {
    processDelta += delta
  }

  @Register
  override def _physicsProcess(delta: Double): Unit = {
    physicsProcessDelta += delta
  }

  @Notification(0)
  def onNotification(): Unit =
    notificationTriggered = true
}
