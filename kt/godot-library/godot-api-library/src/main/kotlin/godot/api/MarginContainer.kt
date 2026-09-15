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
 * [MarginContainer] adds an adjustable margin on each side of its child controls. The margins are
 * added around all children, not around each individual one. To control the [MarginContainer]'s
 * margins, use the `margin_*` theme properties listed below.
 *
 * **Note:** The margin sizes are theme overrides, not normal properties. This is an example of how
 * to change them in code:
 *
 * ```gdscript
 * //gdscript
 * # This code sample assumes the current script is extending MarginContainer.
 * var margin_value = 100
 * add_theme_constant_override("margin_top", margin_value)
 * add_theme_constant_override("margin_left", margin_value)
 * add_theme_constant_override("margin_bottom", margin_value)
 * add_theme_constant_override("margin_right", margin_value)
 * ```
 *
 * ```csharp
 * //csharp
 * // This code sample assumes the current script is extending MarginContainer.
 * int marginValue = 100;
 * AddThemeConstantOverride("margin_top", marginValue);
 * AddThemeConstantOverride("margin_left", marginValue);
 * AddThemeConstantOverride("margin_bottom", marginValue);
 * AddThemeConstantOverride("margin_right", marginValue);
 * ```
 */
@GodotBaseType
public open class MarginContainer : Container() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(366, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
