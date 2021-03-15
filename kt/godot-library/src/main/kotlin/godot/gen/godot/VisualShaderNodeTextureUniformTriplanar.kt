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
 * Performs a uniform texture lookup with triplanar within the visual shader graph.
 *
 * Performs a lookup operation on the texture provided as a uniform for the shader, with support for triplanar mapping.
 */
@GodotBaseType
open class VisualShaderNodeTextureUniformTriplanar : VisualShaderNodeTextureUniform() {
  override fun __new(): VoidPtr =
      TransferContext.invokeConstructor(ENGINECLASS_VISUALSHADERNODETEXTUREUNIFORMTRIPLANAR)
}
