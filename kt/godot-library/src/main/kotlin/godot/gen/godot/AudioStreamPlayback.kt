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
 * Meta class for playing back audio.
 *
 * Can play, loop, pause a scroll through audio. See [godot.AudioStream] and [godot.AudioStreamOGGVorbis] for usage.
 */
@GodotBaseType
open class AudioStreamPlayback : Reference() {
  override fun __new(): VoidPtr = TransferContext.invokeConstructor(ENGINECLASS_AUDIOSTREAMPLAYBACK)
}
