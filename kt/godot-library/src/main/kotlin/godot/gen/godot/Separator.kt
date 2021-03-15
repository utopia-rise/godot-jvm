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
 * Base class for separators.
 *
 * Separator is a [godot.Control] used for separating other controls. It's purely a visual decoration. Horizontal ([godot.HSeparator]) and Vertical ([godot.VSeparator]) versions are available.
 */
@GodotBaseType
open class Separator : Control() {
  override fun __new(): VoidPtr = TransferContext.invokeConstructor(ENGINECLASS_SEPARATOR)
}
