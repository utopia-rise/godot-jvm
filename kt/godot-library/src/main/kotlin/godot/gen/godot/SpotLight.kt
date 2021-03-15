// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName")

package godot

import godot.annotation.GodotBaseType
import godot.core.TransferContext
import godot.util.VoidPtr
import kotlin.Suppress

/**
 * A spotlight, such as a reflector spotlight or a lantern.
 *
 * Tutorials:
 * [https://docs.godotengine.org/en/latest/tutorials/3d/lights_and_shadows.html](https://docs.godotengine.org/en/latest/tutorials/3d/lights_and_shadows.html)
 *
 * A Spotlight is a type of [godot.Light] node that emits lights in a specific direction, in the shape of a cone. The light is attenuated through the distance. This attenuation can be configured by changing the energy, radius and attenuation parameters of [godot.Light].
 */
@GodotBaseType
open class SpotLight : Light() {
  override fun __new(): VoidPtr = TransferContext.invokeConstructor(ENGINECLASS_SPOTLIGHT)
}
