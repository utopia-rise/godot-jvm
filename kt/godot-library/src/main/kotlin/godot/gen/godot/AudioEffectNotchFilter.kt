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
 * Adds a notch filter to the Audio bus.
 *
 * Attenuates frequencies in a narrow band around the [godot.AudioEffectFilter.cutoffHz] and cuts frequencies outside of this range.
 */
@GodotBaseType
open class AudioEffectNotchFilter : AudioEffectFilter() {
  override fun __new(): VoidPtr =
      TransferContext.invokeConstructor(ENGINECLASS_AUDIOEFFECTNOTCHFILTER)
}
