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
 * A horizontal slider, used to adjust a value by moving a grabber along a horizontal axis. It is a
 * [Range]-based control and goes from left (min) to right (max).
 */
@GodotBaseType
public open class HSlider : Slider() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(289, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
