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
 * A container that accepts only two child controls, then arranges them horizontally and creates a
 * divisor between them. The divisor can be dragged around to change the size relation between the
 * child controls.
 */
@GodotBaseType
public open class HSplitContainer : SplitContainer() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(290, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
