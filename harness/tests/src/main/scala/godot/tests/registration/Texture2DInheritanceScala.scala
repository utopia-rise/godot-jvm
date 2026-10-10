package godot.tests.registration

import godot.annotation.{Register, Script}
import godot.api.Texture2D

@Script
class Texture2DInheritanceScala extends Texture2D {
  @Register
  override def _getWidth(): Int = 7

  @Register
  override def _getHeight(): Int = 3
}
