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
 * A popup with a configurable panel background. Any child controls added to this node will be
 * stretched to fit the panel's size (similar to how [PanelContainer] works). If you are making
 * windows, see [Window].
 */
@GodotBaseType
public open class PopupPanel : Popup() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(567, scriptPtr)
  }

  public companion object

  public object MethodBindings
}
