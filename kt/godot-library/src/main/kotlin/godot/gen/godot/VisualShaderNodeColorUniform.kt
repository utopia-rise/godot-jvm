// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName")

package godot

import godot.annotation.GodotBaseType
import godot.core.TransferContext
import kotlin.Suppress

/**
 * A [godot.core.Color] uniform to be used within the visual shader graph.
 *
 * Translated to `uniform vec4` in the shader language.
 */
@GodotBaseType
open class VisualShaderNodeColorUniform : VisualShaderNodeUniform() {
  override fun __new() {
    TransferContext.invokeConstructor(ENGINECLASS_VISUALSHADERNODECOLORUNIFORM)
    val buffer = TransferContext.buffer
    rawPtr = buffer.long
    id = buffer.long
    buffer.rewind()
  }
}
