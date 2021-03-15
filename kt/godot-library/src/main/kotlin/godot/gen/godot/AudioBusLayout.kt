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
 * Stores information about the audio buses.
 *
 * Stores position, muting, solo, bypass, effects, effect position, volume, and the connections between buses. See [godot.AudioServer] for usage.
 */
@GodotBaseType
open class AudioBusLayout : Resource() {
  override fun __new(): VoidPtr = TransferContext.invokeConstructor(ENGINECLASS_AUDIOBUSLAYOUT)
}
