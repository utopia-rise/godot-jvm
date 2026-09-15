// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.Signal0
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A button that brings up a [PopupMenu] when clicked. To create new items inside this [PopupMenu],
 * use `get_popup().add_item("My Item Name")`. You can also create them directly from Godot editor's
 * inspector.
 *
 * See also [BaseButton] which contains common properties and methods associated with this node.
 */
@GodotBaseType
public open class MenuButton : Button() {
  /**
   * Emitted when the [PopupMenu] of this MenuButton is about to show.
   */
  public val aboutToPopup: Signal0 by Signal0

  /**
   * If `true`, when the cursor hovers above another [MenuButton] within the same parent which also
   * has [switchOnHover] enabled, it will close the current [MenuButton] and open the other one.
   */
  public final inline var switchOnHover: Boolean
    @JvmName("switchOnHoverProperty")
    get() = isSwitchOnHover()
    @JvmName("switchOnHoverProperty")
    set(`value`) {
      setSwitchOnHover(value)
    }

  /**
   * The number of items currently in the list.
   */
  public final inline var itemCount: Int
    @JvmName("itemCountProperty")
    get() = getItemCount()
    @JvmName("itemCountProperty")
    set(`value`) {
      setItemCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(372, scriptPtr)
  }

  /**
   * Returns the [PopupMenu] contained in this button.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [Window.visible] property.
   */
  public final fun getPopup(): PopupMenu? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPopupPtr)
    return (TransferContext.readReturnValue(OBJECT) as PopupMenu?)
  }

  /**
   * Adjusts popup position and sizing for the [MenuButton], then shows the [PopupMenu]. Prefer this
   * over using `get_popup().popup()`.
   */
  public final fun showPopup(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.showPopupPtr)
  }

  public final fun setSwitchOnHover(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSwitchOnHoverPtr)
  }

  public final fun isSwitchOnHover(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSwitchOnHoverPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, shortcuts are disabled and cannot be used to trigger the button.
   */
  public final fun setDisableShortcuts(disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setDisableShortcutsPtr)
  }

  public final fun setItemCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setItemCountPtr)
  }

  public final fun getItemCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getItemCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public companion object {
    @JvmField
    public val getPopupName: MethodStringName0<MenuButton, PopupMenu?> =
        MethodStringName0<MenuButton, PopupMenu?>("get_popup")

    @JvmField
    public val showPopupName: MethodStringName0<MenuButton, Unit> =
        MethodStringName0<MenuButton, Unit>("show_popup")

    @JvmField
    public val setSwitchOnHoverName: MethodStringName1<MenuButton, Unit, Boolean> =
        MethodStringName1<MenuButton, Unit, Boolean>("set_switch_on_hover")

    @JvmField
    public val isSwitchOnHoverName: MethodStringName0<MenuButton, Boolean> =
        MethodStringName0<MenuButton, Boolean>("is_switch_on_hover")

    @JvmField
    public val setDisableShortcutsName: MethodStringName1<MenuButton, Unit, Boolean> =
        MethodStringName1<MenuButton, Unit, Boolean>("set_disable_shortcuts")

    @JvmField
    public val setItemCountName: MethodStringName1<MenuButton, Unit, Int> =
        MethodStringName1<MenuButton, Unit, Int>("set_item_count")

    @JvmField
    public val getItemCountName: MethodStringName0<MenuButton, Int> =
        MethodStringName0<MenuButton, Int>("get_item_count")
  }

  public object MethodBindings {
    internal val getPopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuButton", "get_popup", 229722558)

    internal val showPopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuButton", "show_popup", 3218959716)

    internal val setSwitchOnHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuButton", "set_switch_on_hover", 2586408642)

    internal val isSwitchOnHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuButton", "is_switch_on_hover", 2240911060)

    internal val setDisableShortcutsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuButton", "set_disable_shortcuts", 2586408642)

    internal val setItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuButton", "set_item_count", 1286410249)

    internal val getItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("MenuButton", "get_item_count", 3905245786)
  }
}
