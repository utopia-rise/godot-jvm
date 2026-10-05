// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import kotlin.Suppress
import kotlin.Unit

/**
 * The visibility mask allows us to black out the part of the render result that is invisible due to
 * lens distortion.
 *
 * As this is rendered first, it prevents fragments with expensive lighting calculations to be
 * processed as they are discarded through z-checking.
 */
@GodotBaseType
public open class OpenXRVisibilityMask : VisualInstance3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(495, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
