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
 * A [godot.core.Transform] uniform for use within the visual shader graph.
 *
 * Translated to `uniform mat4` in the shader language.
 */
@GodotBaseType
open class VisualShaderNodeTransformUniform : VisualShaderNodeUniform() {
  override fun __new(): VoidPtr =
      TransferContext.invokeConstructor(ENGINECLASS_VISUALSHADERNODETRANSFORMUNIFORM)
}
