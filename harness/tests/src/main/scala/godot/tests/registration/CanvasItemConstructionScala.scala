package godot.tests.registration

import godot.annotation.{Register, Script}
import godot.api.{CanvasItem, Node}

@Script
class CanvasItemConstructionScala extends Node {
  @Register
  def constructCanvasItem(): String =
    try {
      new CanvasItem()
      "constructed"
    } catch {
      case exception: IllegalStateException => exception.getMessage
    }
}
