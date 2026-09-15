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
import godot.core.Callable
import godot.core.GodotEnum
import godot.core.Key
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.core.MethodStringName7
import godot.core.MethodStringName8
import godot.core.MethodStringName9
import godot.core.RID
import godot.core.VariantCallable
import godot.core.Vector2
import godot.core.Vector2i
import godot.readReturnValue_ANY
import godot.readReturnValue_BOOL
import godot.readReturnValue_CALLABLE
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RID
import godot.readReturnValue_STRING
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_RID_ANY
import godot.writeMethodArguments_RID_BOOL
import godot.writeMethodArguments_RID_CALLABLE
import godot.writeMethodArguments_RID_DOUBLE
import godot.writeMethodArguments_RID_LONG
import godot.writeMethodArguments_RID_LONG_ANY
import godot.writeMethodArguments_RID_LONG_BOOL
import godot.writeMethodArguments_RID_LONG_CALLABLE
import godot.writeMethodArguments_RID_LONG_LONG
import godot.writeMethodArguments_RID_LONG_OBJECT
import godot.writeMethodArguments_RID_LONG_RID
import godot.writeMethodArguments_RID_LONG_STRING
import godot.writeMethodArguments_RID_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG
import godot.writeMethodArguments_RID_RID
import godot.writeMethodArguments_RID_STRING
import godot.writeMethodArguments_RID_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG
import godot.writeMethodArguments_RID_STRING_LONG_LONG_CALLABLE_CALLABLE_ANY_LONG_LONG
import godot.writeMethodArguments_RID_STRING_RID_ANY_LONG
import godot.writeMethodArguments_RID_VECTOR2I
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * [NativeMenu] handles low-level access to the OS native global menu bar and popup menus.
 *
 * **Note:** This is low-level API, consider using [MenuBar] with [MenuBar.preferGlobalMenu] set to
 * `true`, and [PopupMenu] with [PopupMenu.preferNativeMenu] set to `true`.
 *
 * To create a menu, use [createMenu], add menu items using `add_*_item` methods. To remove a menu,
 * use [freeMenu].
 *
 * ```
 * var menu
 *
 * func _menu_callback(item_id):
 * 	if item_id == "ITEM_CUT":
 * 		cut()
 * 	elif item_id == "ITEM_COPY":
 * 		copy()
 * 	elif item_id == "ITEM_PASTE":
 * 		paste()
 *
 * func _enter_tree():
 * 	# Create new menu and add items:
 * 	menu = NativeMenu.create_menu()
 * 	NativeMenu.add_item(menu, "Cut", _menu_callback, Callable(), "ITEM_CUT")
 * 	NativeMenu.add_item(menu, "Copy", _menu_callback, Callable(), "ITEM_COPY")
 * 	NativeMenu.add_separator(menu)
 * 	NativeMenu.add_item(menu, "Paste", _menu_callback, Callable(), "ITEM_PASTE")
 *
 * func _on_button_pressed():
 * 	# Show popup menu at mouse position:
 * 	NativeMenu.popup(menu, DisplayServer.mouse_get_position())
 *
 * func _exit_tree():
 * 	# Remove menu when it's no longer needed:
 * 	NativeMenu.free_menu(menu)
 * ```
 */
@GodotBaseType
public object NativeMenu : Object() {
  @JvmField
  public val hasFeatureName: MethodStringName1<NativeMenu, Boolean, Feature> =
      MethodStringName1<NativeMenu, Boolean, Feature>("has_feature")

  @JvmField
  public val hasSystemMenuName: MethodStringName1<NativeMenu, Boolean, SystemMenus> =
      MethodStringName1<NativeMenu, Boolean, SystemMenus>("has_system_menu")

  @JvmField
  public val getSystemMenuName: MethodStringName1<NativeMenu, RID, SystemMenus> =
      MethodStringName1<NativeMenu, RID, SystemMenus>("get_system_menu")

  @JvmField
  public val getSystemMenuNameName: MethodStringName1<NativeMenu, String, SystemMenus> =
      MethodStringName1<NativeMenu, String, SystemMenus>("get_system_menu_name")

  @JvmField
  public val getSystemMenuTextName: MethodStringName1<NativeMenu, String, SystemMenus> =
      MethodStringName1<NativeMenu, String, SystemMenus>("get_system_menu_text")

  @JvmField
  public val setSystemMenuTextName: MethodStringName2<NativeMenu, Unit, SystemMenus, String> =
      MethodStringName2<NativeMenu, Unit, SystemMenus, String>("set_system_menu_text")

  @JvmField
  public val createMenuName: MethodStringName0<NativeMenu, RID> =
      MethodStringName0<NativeMenu, RID>("create_menu")

  @JvmField
  public val hasMenuName: MethodStringName1<NativeMenu, Boolean, RID> =
      MethodStringName1<NativeMenu, Boolean, RID>("has_menu")

  @JvmField
  public val freeMenuName: MethodStringName1<NativeMenu, Unit, RID> =
      MethodStringName1<NativeMenu, Unit, RID>("free_menu")

  @JvmField
  public val getSizeName: MethodStringName1<NativeMenu, Vector2, RID> =
      MethodStringName1<NativeMenu, Vector2, RID>("get_size")

  @JvmField
  public val popupName: MethodStringName2<NativeMenu, Unit, RID, Vector2i> =
      MethodStringName2<NativeMenu, Unit, RID, Vector2i>("popup")

  @JvmField
  public val setInterfaceDirectionName: MethodStringName2<NativeMenu, Unit, RID, Boolean> =
      MethodStringName2<NativeMenu, Unit, RID, Boolean>("set_interface_direction")

  @JvmField
  public val setPopupOpenCallbackName: MethodStringName2<NativeMenu, Unit, RID, Callable> =
      MethodStringName2<NativeMenu, Unit, RID, Callable>("set_popup_open_callback")

  @JvmField
  public val getPopupOpenCallbackName: MethodStringName1<NativeMenu, Callable, RID> =
      MethodStringName1<NativeMenu, Callable, RID>("get_popup_open_callback")

  @JvmField
  public val setPopupCloseCallbackName: MethodStringName2<NativeMenu, Unit, RID, Callable> =
      MethodStringName2<NativeMenu, Unit, RID, Callable>("set_popup_close_callback")

  @JvmField
  public val getPopupCloseCallbackName: MethodStringName1<NativeMenu, Callable, RID> =
      MethodStringName1<NativeMenu, Callable, RID>("get_popup_close_callback")

  @JvmField
  public val setMinimumWidthName: MethodStringName2<NativeMenu, Unit, RID, Float> =
      MethodStringName2<NativeMenu, Unit, RID, Float>("set_minimum_width")

  @JvmField
  public val getMinimumWidthName: MethodStringName1<NativeMenu, Float, RID> =
      MethodStringName1<NativeMenu, Float, RID>("get_minimum_width")

  @JvmField
  public val isOpenedName: MethodStringName1<NativeMenu, Boolean, RID> =
      MethodStringName1<NativeMenu, Boolean, RID>("is_opened")

  @JvmField
  public val addSubmenuItemName: MethodStringName5<NativeMenu, Int, RID, String, RID, Any?, Int> =
      MethodStringName5<NativeMenu, Int, RID, String, RID, Any?, Int>("add_submenu_item")

  @JvmField
  public val addItemName:
      MethodStringName7<NativeMenu, Int, RID, String, Callable, Callable, Any?, Key, Int> =
      MethodStringName7<NativeMenu, Int, RID, String, Callable, Callable, Any?, Key, Int>("add_item")

  @JvmField
  public val addCheckItemName:
      MethodStringName7<NativeMenu, Int, RID, String, Callable, Callable, Any?, Key, Int> =
      MethodStringName7<NativeMenu, Int, RID, String, Callable, Callable, Any?, Key, Int>("add_check_item")

  @JvmField
  public val addIconItemName:
      MethodStringName8<NativeMenu, Int, RID, Texture2D?, String, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName8<NativeMenu, Int, RID, Texture2D?, String, Callable, Callable, Any?, Key, Int>("add_icon_item")

  @JvmField
  public val addIconCheckItemName:
      MethodStringName8<NativeMenu, Int, RID, Texture2D?, String, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName8<NativeMenu, Int, RID, Texture2D?, String, Callable, Callable, Any?, Key, Int>("add_icon_check_item")

  @JvmField
  public val addRadioCheckItemName:
      MethodStringName7<NativeMenu, Int, RID, String, Callable, Callable, Any?, Key, Int> =
      MethodStringName7<NativeMenu, Int, RID, String, Callable, Callable, Any?, Key, Int>("add_radio_check_item")

  @JvmField
  public val addIconRadioCheckItemName:
      MethodStringName8<NativeMenu, Int, RID, Texture2D?, String, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName8<NativeMenu, Int, RID, Texture2D?, String, Callable, Callable, Any?, Key, Int>("add_icon_radio_check_item")

  @JvmField
  public val addMultistateItemName:
      MethodStringName9<NativeMenu, Int, RID, String, Int, Int, Callable, Callable, Any?, Key, Int>
      =
      MethodStringName9<NativeMenu, Int, RID, String, Int, Int, Callable, Callable, Any?, Key, Int>("add_multistate_item")

  @JvmField
  public val addSeparatorName: MethodStringName2<NativeMenu, Int, RID, Int> =
      MethodStringName2<NativeMenu, Int, RID, Int>("add_separator")

  @JvmField
  public val findItemIndexWithTextName: MethodStringName2<NativeMenu, Int, RID, String> =
      MethodStringName2<NativeMenu, Int, RID, String>("find_item_index_with_text")

  @JvmField
  public val findItemIndexWithTagName: MethodStringName2<NativeMenu, Int, RID, Any?> =
      MethodStringName2<NativeMenu, Int, RID, Any?>("find_item_index_with_tag")

  @JvmField
  public val findItemIndexWithSubmenuName: MethodStringName2<NativeMenu, Int, RID, RID> =
      MethodStringName2<NativeMenu, Int, RID, RID>("find_item_index_with_submenu")

  @JvmField
  public val isItemCheckedName: MethodStringName2<NativeMenu, Boolean, RID, Int> =
      MethodStringName2<NativeMenu, Boolean, RID, Int>("is_item_checked")

  @JvmField
  public val isItemCheckableName: MethodStringName2<NativeMenu, Boolean, RID, Int> =
      MethodStringName2<NativeMenu, Boolean, RID, Int>("is_item_checkable")

  @JvmField
  public val isItemRadioCheckableName: MethodStringName2<NativeMenu, Boolean, RID, Int> =
      MethodStringName2<NativeMenu, Boolean, RID, Int>("is_item_radio_checkable")

  @JvmField
  public val getItemCallbackName: MethodStringName2<NativeMenu, Callable, RID, Int> =
      MethodStringName2<NativeMenu, Callable, RID, Int>("get_item_callback")

  @JvmField
  public val getItemKeyCallbackName: MethodStringName2<NativeMenu, Callable, RID, Int> =
      MethodStringName2<NativeMenu, Callable, RID, Int>("get_item_key_callback")

  @JvmField
  public val getItemTagName: MethodStringName2<NativeMenu, Any?, RID, Int> =
      MethodStringName2<NativeMenu, Any?, RID, Int>("get_item_tag")

  @JvmField
  public val getItemTextName: MethodStringName2<NativeMenu, String, RID, Int> =
      MethodStringName2<NativeMenu, String, RID, Int>("get_item_text")

  @JvmField
  public val getItemSubmenuName: MethodStringName2<NativeMenu, RID, RID, Int> =
      MethodStringName2<NativeMenu, RID, RID, Int>("get_item_submenu")

  @JvmField
  public val getItemAcceleratorName: MethodStringName2<NativeMenu, Key, RID, Int> =
      MethodStringName2<NativeMenu, Key, RID, Int>("get_item_accelerator")

  @JvmField
  public val isItemDisabledName: MethodStringName2<NativeMenu, Boolean, RID, Int> =
      MethodStringName2<NativeMenu, Boolean, RID, Int>("is_item_disabled")

  @JvmField
  public val isItemHiddenName: MethodStringName2<NativeMenu, Boolean, RID, Int> =
      MethodStringName2<NativeMenu, Boolean, RID, Int>("is_item_hidden")

  @JvmField
  public val getItemTooltipName: MethodStringName2<NativeMenu, String, RID, Int> =
      MethodStringName2<NativeMenu, String, RID, Int>("get_item_tooltip")

  @JvmField
  public val getItemStateName: MethodStringName2<NativeMenu, Int, RID, Int> =
      MethodStringName2<NativeMenu, Int, RID, Int>("get_item_state")

  @JvmField
  public val getItemMaxStatesName: MethodStringName2<NativeMenu, Int, RID, Int> =
      MethodStringName2<NativeMenu, Int, RID, Int>("get_item_max_states")

  @JvmField
  public val getItemIconName: MethodStringName2<NativeMenu, Texture2D?, RID, Int> =
      MethodStringName2<NativeMenu, Texture2D?, RID, Int>("get_item_icon")

  @JvmField
  public val getItemIndentationLevelName: MethodStringName2<NativeMenu, Int, RID, Int> =
      MethodStringName2<NativeMenu, Int, RID, Int>("get_item_indentation_level")

  @JvmField
  public val setItemCheckedName: MethodStringName3<NativeMenu, Unit, RID, Int, Boolean> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Boolean>("set_item_checked")

  @JvmField
  public val setItemCheckableName: MethodStringName3<NativeMenu, Unit, RID, Int, Boolean> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Boolean>("set_item_checkable")

  @JvmField
  public val setItemRadioCheckableName: MethodStringName3<NativeMenu, Unit, RID, Int, Boolean> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Boolean>("set_item_radio_checkable")

  @JvmField
  public val setItemCallbackName: MethodStringName3<NativeMenu, Unit, RID, Int, Callable> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Callable>("set_item_callback")

  @JvmField
  public val setItemHoverCallbacksName: MethodStringName3<NativeMenu, Unit, RID, Int, Callable> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Callable>("set_item_hover_callbacks")

  @JvmField
  public val setItemKeyCallbackName: MethodStringName3<NativeMenu, Unit, RID, Int, Callable> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Callable>("set_item_key_callback")

  @JvmField
  public val setItemTagName: MethodStringName3<NativeMenu, Unit, RID, Int, Any?> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Any?>("set_item_tag")

  @JvmField
  public val setItemTextName: MethodStringName3<NativeMenu, Unit, RID, Int, String> =
      MethodStringName3<NativeMenu, Unit, RID, Int, String>("set_item_text")

  @JvmField
  public val setItemSubmenuName: MethodStringName3<NativeMenu, Unit, RID, Int, RID> =
      MethodStringName3<NativeMenu, Unit, RID, Int, RID>("set_item_submenu")

  @JvmField
  public val setItemAcceleratorName: MethodStringName3<NativeMenu, Unit, RID, Int, Key> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Key>("set_item_accelerator")

  @JvmField
  public val setItemDisabledName: MethodStringName3<NativeMenu, Unit, RID, Int, Boolean> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Boolean>("set_item_disabled")

  @JvmField
  public val setItemHiddenName: MethodStringName3<NativeMenu, Unit, RID, Int, Boolean> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Boolean>("set_item_hidden")

  @JvmField
  public val setItemTooltipName: MethodStringName3<NativeMenu, Unit, RID, Int, String> =
      MethodStringName3<NativeMenu, Unit, RID, Int, String>("set_item_tooltip")

  @JvmField
  public val setItemStateName: MethodStringName3<NativeMenu, Unit, RID, Int, Int> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Int>("set_item_state")

  @JvmField
  public val setItemMaxStatesName: MethodStringName3<NativeMenu, Unit, RID, Int, Int> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Int>("set_item_max_states")

  @JvmField
  public val setItemIconName: MethodStringName3<NativeMenu, Unit, RID, Int, Texture2D?> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Texture2D?>("set_item_icon")

  @JvmField
  public val setItemIndentationLevelName: MethodStringName3<NativeMenu, Unit, RID, Int, Int> =
      MethodStringName3<NativeMenu, Unit, RID, Int, Int>("set_item_indentation_level")

  @JvmField
  public val setItemIndexName: MethodStringName3<NativeMenu, Int, RID, Int, Int> =
      MethodStringName3<NativeMenu, Int, RID, Int, Int>("set_item_index")

  @JvmField
  public val getItemCountName: MethodStringName1<NativeMenu, Int, RID> =
      MethodStringName1<NativeMenu, Int, RID>("get_item_count")

  @JvmField
  public val isSystemMenuName: MethodStringName1<NativeMenu, Boolean, RID> =
      MethodStringName1<NativeMenu, Boolean, RID>("is_system_menu")

  @JvmField
  public val removeItemName: MethodStringName2<NativeMenu, Unit, RID, Int> =
      MethodStringName2<NativeMenu, Unit, RID, Int>("remove_item")

  @JvmField
  public val clearName: MethodStringName1<NativeMenu, Unit, RID> =
      MethodStringName1<NativeMenu, Unit, RID>("clear")

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(16)
  }

  /**
   * Returns `true` if the specified [feature] is supported by the current [NativeMenu], `false`
   * otherwise.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun hasFeature(feature: Feature): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, feature.value)
    TransferContext.callMethod(MethodBindings.hasFeaturePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if a special system menu is supported.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun hasSystemMenu(menuId: SystemMenus): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, menuId.value)
    TransferContext.callMethod(MethodBindings.hasSystemMenuPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns RID of a special system menu.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getSystemMenu(menuId: SystemMenus): RID {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, menuId.value)
    TransferContext.callMethod(MethodBindings.getSystemMenuPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns readable name of a special system menu.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getSystemMenuName(menuId: SystemMenus): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, menuId.value)
    TransferContext.callMethod(MethodBindings.getSystemMenuNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the text of the system menu item.
   *
   * **Note:** This method is implemented on macOS.
   */
  @JvmStatic
  public final fun getSystemMenuText(menuId: SystemMenus): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, menuId.value)
    TransferContext.callMethod(MethodBindings.getSystemMenuTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the text of the system menu item.
   *
   * **Note:** This method is implemented on macOS.
   */
  @JvmStatic
  public final fun setSystemMenuText(menuId: SystemMenus, name: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, menuId.value, name)
    TransferContext.callMethod(MethodBindings.setSystemMenuTextPtr)
  }

  /**
   * Creates a new global menu object.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun createMenu(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createMenuPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns `true` if [rid] is valid global menu.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun hasMenu(rid: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.hasMenuPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Frees a global menu object created by this [NativeMenu].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun freeMenu(rid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.freeMenuPtr)
  }

  /**
   * Returns global menu size.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getSize(rid: RID): Vector2 {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.getSizePtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Shows the global menu at [position] in the screen coordinates.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun popup(rid: RID, position: Vector2i): Unit {
    TransferContext.writeMethodArguments_RID_VECTOR2I(ptr, objectID.id, rid, position)
    TransferContext.callMethod(MethodBindings.popupPtr)
  }

  /**
   * Sets the menu text layout direction from right-to-left if [isRtl] is `true`.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setInterfaceDirection(rid: RID, isRtl: Boolean): Unit {
    TransferContext.writeMethodArguments_RID_BOOL(ptr, objectID.id, rid, isRtl)
    TransferContext.callMethod(MethodBindings.setInterfaceDirectionPtr)
  }

  /**
   * Registers callable to emit after the menu is closed.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setPopupOpenCallback(rid: RID, callback: Callable): Unit {
    TransferContext.writeMethodArguments_RID_CALLABLE(ptr, objectID.id, rid, callback)
    TransferContext.callMethod(MethodBindings.setPopupOpenCallbackPtr)
  }

  /**
   * Returns global menu open callback.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getPopupOpenCallback(rid: RID): Callable {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.getPopupOpenCallbackPtr)
    return TransferContext.readReturnValue_CALLABLE()
  }

  /**
   * Registers callable to emit when the menu is about to show.
   *
   * **Note:** The OS can simulate menu opening to track menu item changes and global shortcuts, in
   * which case the corresponding close callback is not triggered. Use [isOpened] to check if the menu
   * is currently opened.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setPopupCloseCallback(rid: RID, callback: Callable): Unit {
    TransferContext.writeMethodArguments_RID_CALLABLE(ptr, objectID.id, rid, callback)
    TransferContext.callMethod(MethodBindings.setPopupCloseCallbackPtr)
  }

  /**
   * Returns global menu close callback.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getPopupCloseCallback(rid: RID): Callable {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.getPopupCloseCallbackPtr)
    return TransferContext.readReturnValue_CALLABLE()
  }

  /**
   * Sets the minimum width of the global menu.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setMinimumWidth(rid: RID, width: Float): Unit {
    TransferContext.writeMethodArguments_RID_DOUBLE(ptr, objectID.id, rid, width.toDouble())
    TransferContext.callMethod(MethodBindings.setMinimumWidthPtr)
  }

  /**
   * Returns global menu minimum width.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getMinimumWidth(rid: RID): Float {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.getMinimumWidthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns `true` if the menu is currently opened.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun isOpened(rid: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.isOpenedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Adds an item that will act as a submenu of the global menu [rid]. The [submenuRid] argument is
   * the RID of the global menu that will be shown when the item is clicked.
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addSubmenuItem(
    rid: RID,
    label: String,
    submenuRid: RID,
    tag: Any? = null,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_STRING_RID_ANY_LONG(ptr, objectID.id, rid, label, submenuRid, tag, index.toLong())
    TransferContext.callMethod(MethodBindings.addSubmenuItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a new item with text [label] to the global menu [rid].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** On Windows, [accelerator] and [keyCallback] are ignored.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addItem(
    rid: RID,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(ptr, objectID.id, rid, label, callback, keyCallback, tag, accelerator.value, index.toLong())
    TransferContext.callMethod(MethodBindings.addItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a new checkable item with text [label] to the global menu [rid].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** On Windows, [accelerator] and [keyCallback] are ignored.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addCheckItem(
    rid: RID,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(ptr, objectID.id, rid, label, callback, keyCallback, tag, accelerator.value, index.toLong())
    TransferContext.callMethod(MethodBindings.addCheckItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a new item with text [label] and icon [icon] to the global menu [rid].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** On Windows, [accelerator] and [keyCallback] are ignored.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addIconItem(
    rid: RID,
    icon: Texture2D?,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(ptr, objectID.id, rid, icon, label, callback, keyCallback, tag, accelerator.value, index.toLong())
    TransferContext.callMethod(MethodBindings.addIconItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a new checkable item with text [label] and icon [icon] to the global menu [rid].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** On Windows, [accelerator] and [keyCallback] are ignored.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addIconCheckItem(
    rid: RID,
    icon: Texture2D?,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(ptr, objectID.id, rid, icon, label, callback, keyCallback, tag, accelerator.value, index.toLong())
    TransferContext.callMethod(MethodBindings.addIconCheckItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a new radio-checkable item with text [label] to the global menu [rid].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** Radio-checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** On Windows, [accelerator] and [keyCallback] are ignored.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addRadioCheckItem(
    rid: RID,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(ptr, objectID.id, rid, label, callback, keyCallback, tag, accelerator.value, index.toLong())
    TransferContext.callMethod(MethodBindings.addRadioCheckItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a new radio-checkable item with text [label] and icon [icon] to the global menu [rid].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** Radio-checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** On Windows, [accelerator] and [keyCallback] are ignored.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addIconRadioCheckItem(
    rid: RID,
    icon: Texture2D?,
    label: String,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_OBJECT_STRING_CALLABLE_CALLABLE_ANY_LONG_LONG(ptr, objectID.id, rid, icon, label, callback, keyCallback, tag, accelerator.value, index.toLong())
    TransferContext.callMethod(MethodBindings.addIconRadioCheckItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a new item with text [label] to the global menu [rid].
   *
   * Contrarily to normal binary items, multistate items can have more than two states, as defined
   * by [maxStates]. Each press or activate of the item will increase the state by one. The default
   * value is defined by [defaultState].
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * An [accelerator] can optionally be defined, which is a keyboard shortcut that can be pressed to
   * trigger the menu button even if it's not currently open. The [accelerator] is generally a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** By default, there's no indication of the current item state, it should be changed
   * manually.
   *
   * **Note:** The [callback] and [keyCallback] Callables need to accept exactly one Variant
   * parameter, the parameter passed to the Callables will be the value passed to [tag].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** On Windows, [accelerator] and [keyCallback] are ignored.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addMultistateItem(
    rid: RID,
    label: String,
    maxStates: Int,
    defaultState: Int,
    callback: Callable = VariantCallable(),
    keyCallback: Callable = VariantCallable(),
    tag: Any? = null,
    accelerator: Key = Key.NONE,
    index: Int = -1,
  ): Int {
    TransferContext.writeMethodArguments_RID_STRING_LONG_LONG_CALLABLE_CALLABLE_ANY_LONG_LONG(ptr, objectID.id, rid, label, maxStates.toLong(), defaultState.toLong(), callback, keyCallback, tag, accelerator.value, index.toLong())
    TransferContext.callMethod(MethodBindings.addMultistateItemPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Adds a separator between items to the global menu [rid]. Separators also occupy an index.
   *
   * Returns index of the inserted item, it's not guaranteed to be the same as [index] value.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addSeparator(rid: RID, index: Int = -1): Int {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, index.toLong())
    TransferContext.callMethod(MethodBindings.addSeparatorPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the index of the item with the specified [text]. Indices are automatically assigned to
   * each item by the engine.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun findItemIndexWithText(rid: RID, text: String): Int {
    TransferContext.writeMethodArguments_RID_STRING(ptr, objectID.id, rid, text)
    TransferContext.callMethod(MethodBindings.findItemIndexWithTextPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the index of the item with the specified [tag]. Indices are automatically assigned to
   * each item by the engine.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun findItemIndexWithTag(rid: RID, tag: Any?): Int {
    TransferContext.writeMethodArguments_RID_ANY(ptr, objectID.id, rid, tag)
    TransferContext.callMethod(MethodBindings.findItemIndexWithTagPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the index of the item with the submenu specified by [submenuRid]. Indices are
   * automatically assigned to each item by the engine.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun findItemIndexWithSubmenu(rid: RID, submenuRid: RID): Int {
    TransferContext.writeMethodArguments_RID_RID(ptr, objectID.id, rid, submenuRid)
    TransferContext.callMethod(MethodBindings.findItemIndexWithSubmenuPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the item at index [idx] is checked.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun isItemChecked(rid: RID, idx: Int): Boolean {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemCheckedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the item at index [idx] is checkable in some way, i.e. if it has a checkbox
   * or radio button.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun isItemCheckable(rid: RID, idx: Int): Boolean {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemCheckablePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the item at index [idx] has radio button-style checkability.
   *
   * **Note:** This is purely cosmetic; you must add the logic for checking/unchecking items in
   * radio groups.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun isItemRadioCheckable(rid: RID, idx: Int): Boolean {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemRadioCheckablePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the callback of the item at index [idx].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemCallback(rid: RID, idx: Int): Callable {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemCallbackPtr)
    return TransferContext.readReturnValue_CALLABLE()
  }

  /**
   * Returns the callback of the item accelerator at index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getItemKeyCallback(rid: RID, idx: Int): Callable {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemKeyCallbackPtr)
    return TransferContext.readReturnValue_CALLABLE()
  }

  /**
   * Returns the metadata of the specified item, which might be of any type. You can set it with
   * [setItemTag], which provides a simple way of assigning context data to items.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemTag(rid: RID, idx: Int): Any? {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTagPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns the text of the item at index [idx].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemText(rid: RID, idx: Int): String {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the submenu ID of the item at index [idx]. See [addSubmenuItem] for more info on how to
   * add a submenu.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemSubmenu(rid: RID, idx: Int): RID {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemSubmenuPtr)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Returns the accelerator of the item at index [idx]. Accelerators are special combinations of
   * keys that activate the item, no matter which control is focused.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getItemAccelerator(rid: RID, idx: Int): Key {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemAcceleratorPtr)
    return Key.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns `true` if the item at index [idx] is disabled. When it is disabled it can't be
   * selected, or its action invoked.
   *
   * See [setItemDisabled] for more info on how to disable an item.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun isItemDisabled(rid: RID, idx: Int): Boolean {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemDisabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the item at index [idx] is hidden.
   *
   * See [setItemHidden] for more info on how to hide an item.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun isItemHidden(rid: RID, idx: Int): Boolean {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemHiddenPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the tooltip associated with the specified index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getItemTooltip(rid: RID, idx: Int): String {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTooltipPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the state of a multistate item. See [addMultistateItem] for details.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemState(rid: RID, idx: Int): Int {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemStatePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns number of states of a multistate item. See [addMultistateItem] for details.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemMaxStates(rid: RID, idx: Int): Int {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemMaxStatesPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the icon of the item at index [idx].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemIcon(rid: RID, idx: Int): Texture2D? {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  /**
   * Returns the horizontal offset of the item at the given [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun getItemIndentationLevel(rid: RID, idx: Int): Int {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemIndentationLevelPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the checkstate status of the item at index [idx].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemChecked(
    rid: RID,
    idx: Int,
    checked: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, rid, idx.toLong(), checked)
    TransferContext.callMethod(MethodBindings.setItemCheckedPtr)
  }

  /**
   * Sets whether the item at index [idx] has a checkbox. If `false`, sets the type of the item to
   * plain text.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemCheckable(
    rid: RID,
    idx: Int,
    checkable: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, rid, idx.toLong(), checkable)
    TransferContext.callMethod(MethodBindings.setItemCheckablePtr)
  }

  /**
   * Sets the type of the item at the specified index [idx] to radio button. If `false`, sets the
   * type of the item to plain text.
   *
   * **Note:** This is purely cosmetic; you must add the logic for checking/unchecking items in
   * radio groups.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemRadioCheckable(
    rid: RID,
    idx: Int,
    checkable: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, rid, idx.toLong(), checkable)
    TransferContext.callMethod(MethodBindings.setItemRadioCheckablePtr)
  }

  /**
   * Sets the callback of the item at index [idx]. Callback is emitted when an item is pressed.
   *
   * **Note:** The [callback] Callable needs to accept exactly one Variant parameter, the parameter
   * passed to the Callable will be the value passed to the `tag` parameter when the menu item was
   * created.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemCallback(
    rid: RID,
    idx: Int,
    callback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_CALLABLE(ptr, objectID.id, rid, idx.toLong(), callback)
    TransferContext.callMethod(MethodBindings.setItemCallbackPtr)
  }

  /**
   * Sets the callback of the item at index [idx]. The callback is emitted when an item is hovered.
   *
   * **Note:** The [callback] Callable needs to accept exactly one Variant parameter, the parameter
   * passed to the Callable will be the value passed to the `tag` parameter when the menu item was
   * created.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setItemHoverCallbacks(
    rid: RID,
    idx: Int,
    callback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_CALLABLE(ptr, objectID.id, rid, idx.toLong(), callback)
    TransferContext.callMethod(MethodBindings.setItemHoverCallbacksPtr)
  }

  /**
   * Sets the callback of the item at index [idx]. Callback is emitted when its accelerator is
   * activated.
   *
   * **Note:** The [keyCallback] Callable needs to accept exactly one Variant parameter, the
   * parameter passed to the Callable will be the value passed to the `tag` parameter when the menu
   * item was created.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setItemKeyCallback(
    rid: RID,
    idx: Int,
    keyCallback: Callable,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_CALLABLE(ptr, objectID.id, rid, idx.toLong(), keyCallback)
    TransferContext.callMethod(MethodBindings.setItemKeyCallbackPtr)
  }

  /**
   * Sets the metadata of an item, which may be of any type. You can later get it with [getItemTag],
   * which provides a simple way of assigning context data to items.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemTag(
    rid: RID,
    idx: Int,
    tag: Any?,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_ANY(ptr, objectID.id, rid, idx.toLong(), tag)
    TransferContext.callMethod(MethodBindings.setItemTagPtr)
  }

  /**
   * Sets the text of the item at index [idx].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemText(
    rid: RID,
    idx: Int,
    text: String,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_STRING(ptr, objectID.id, rid, idx.toLong(), text)
    TransferContext.callMethod(MethodBindings.setItemTextPtr)
  }

  /**
   * Sets the submenu RID of the item at index [idx]. The submenu is a global menu that would be
   * shown when the item is clicked.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemSubmenu(
    rid: RID,
    idx: Int,
    submenuRid: RID,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_RID(ptr, objectID.id, rid, idx.toLong(), submenuRid)
    TransferContext.callMethod(MethodBindings.setItemSubmenuPtr)
  }

  /**
   * Sets the accelerator of the item at index [idx]. [keycode] can be a single [Key], or a
   * combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL | KEY_A`
   * ([kbd]Ctrl + A[/kbd]).
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setItemAccelerator(
    rid: RID,
    idx: Int,
    keycode: Key,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, rid, idx.toLong(), keycode.value)
    TransferContext.callMethod(MethodBindings.setItemAcceleratorPtr)
  }

  /**
   * Enables/disables the item at index [idx]. When it is disabled, it can't be selected and its
   * action can't be invoked.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemDisabled(
    rid: RID,
    idx: Int,
    disabled: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, rid, idx.toLong(), disabled)
    TransferContext.callMethod(MethodBindings.setItemDisabledPtr)
  }

  /**
   * Hides/shows the item at index [idx]. When it is hidden, an item does not appear in a menu and
   * its action cannot be invoked.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setItemHidden(
    rid: RID,
    idx: Int,
    hidden: Boolean,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_BOOL(ptr, objectID.id, rid, idx.toLong(), hidden)
    TransferContext.callMethod(MethodBindings.setItemHiddenPtr)
  }

  /**
   * Sets the [String] tooltip of the item at the specified index [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setItemTooltip(
    rid: RID,
    idx: Int,
    tooltip: String,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_STRING(ptr, objectID.id, rid, idx.toLong(), tooltip)
    TransferContext.callMethod(MethodBindings.setItemTooltipPtr)
  }

  /**
   * Sets the state of a multistate item. See [addMultistateItem] for details.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemState(
    rid: RID,
    idx: Int,
    state: Int,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, rid, idx.toLong(), state.toLong())
    TransferContext.callMethod(MethodBindings.setItemStatePtr)
  }

  /**
   * Sets number of state of a multistate item. See [addMultistateItem] for details.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemMaxStates(
    rid: RID,
    idx: Int,
    maxStates: Int,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, rid, idx.toLong(), maxStates.toLong())
    TransferContext.callMethod(MethodBindings.setItemMaxStatesPtr)
  }

  /**
   * Replaces the [Texture2D] icon of the specified [idx].
   *
   * **Note:** This method is implemented on macOS and Windows.
   *
   * **Note:** This method is not supported by macOS Dock menu items.
   */
  @JvmStatic
  public final fun setItemIcon(
    rid: RID,
    idx: Int,
    icon: Texture2D?,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_OBJECT(ptr, objectID.id, rid, idx.toLong(), icon)
    TransferContext.callMethod(MethodBindings.setItemIconPtr)
  }

  /**
   * Sets the horizontal offset of the item at the given [idx].
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun setItemIndentationLevel(
    rid: RID,
    idx: Int,
    level: Int,
  ): Unit {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, rid, idx.toLong(), level.toLong())
    TransferContext.callMethod(MethodBindings.setItemIndentationLevelPtr)
  }

  /**
   * Changes the index of the item at index [idx] to be at index [targetIdx]. This can be used to
   * move an item above other items.
   *
   * Returns the new index of the moved item, it's not guaranteed to be the same as [targetIdx].
   *
   * **Note:** The indices of any items between index [idx] and index [targetIdx] will be shifted by
   * one.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun setItemIndex(
    rid: RID,
    idx: Int,
    targetIdx: Int,
  ): Int {
    TransferContext.writeMethodArguments_RID_LONG_LONG(ptr, objectID.id, rid, idx.toLong(), targetIdx.toLong())
    TransferContext.callMethod(MethodBindings.setItemIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns number of items in the global menu [rid].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun getItemCount(rid: RID): Int {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.getItemCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Return `true` is global menu is a special system menu.
   *
   * **Note:** This method is implemented only on macOS.
   */
  @JvmStatic
  public final fun isSystemMenu(rid: RID): Boolean {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.isSystemMenuPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Removes the item at index [idx] from the global menu [rid].
   *
   * **Note:** The indices of items after the removed item will be shifted by one.
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun removeItem(rid: RID, idx: Int): Unit {
    TransferContext.writeMethodArguments_RID_LONG(ptr, objectID.id, rid, idx.toLong())
    TransferContext.callMethod(MethodBindings.removeItemPtr)
  }

  /**
   * Removes all items from the global menu [rid].
   *
   * **Note:** This method is implemented on macOS and Windows.
   */
  @JvmStatic
  public final fun clear(rid: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, rid)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  public enum class Feature(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * [NativeMenu] supports native global main menu.
     */
    GLOBAL_MENU(0),
    /**
     * [NativeMenu] supports native popup menus.
     */
    POPUP_MENU(1),
    /**
     * [NativeMenu] supports menu open and close callbacks.
     */
    OPEN_CLOSE_CALLBACK(2),
    /**
     * [NativeMenu] supports menu item hover callback.
     */
    HOVER_CALLBACK(3),
    /**
     * [NativeMenu] supports menu item accelerator/key callback.
     */
    KEY_CALLBACK(4),
    ;

    public companion object {
      public fun from(`value`: Long): Feature = entries.single { it.`value` == `value` }
    }
  }

  public enum class SystemMenus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Invalid special system menu ID.
     */
    INVALID_MENU_ID(0),
    /**
     * Global main menu ID.
     */
    MAIN_MENU_ID(1),
    /**
     * Application (first menu after "Apple" menu on macOS) menu ID.
     */
    APPLICATION_MENU_ID(2),
    /**
     * "Window" menu ID (on macOS this menu includes standard window control items and a list of
     * open windows).
     */
    WINDOW_MENU_ID(3),
    /**
     * "Help" menu ID (on macOS this menu includes help search bar).
     */
    HELP_MENU_ID(4),
    /**
     * Dock icon right-click menu ID (on macOS this menu include standard application control items
     * and a list of open windows).
     */
    DOCK_MENU_ID(5),
    ;

    public companion object {
      public fun from(`value`: Long): SystemMenus = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val hasFeaturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "has_feature", 1708975490)

    internal val hasSystemMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "has_system_menu", 718213027)

    internal val getSystemMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_system_menu", 469707506)

    internal val getSystemMenuNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_system_menu_name", 1281499290)

    internal val getSystemMenuTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_system_menu_text", 1281499290)

    internal val setSystemMenuTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_system_menu_text", 3925225603)

    internal val createMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "create_menu", 529393457)

    internal val hasMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "has_menu", 4155700596)

    internal val freeMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "free_menu", 2722037293)

    internal val getSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_size", 2440833711)

    internal val popupPtr: VoidPtr = TypeManager.getMethodBindPtr("NativeMenu", "popup", 2450610377)

    internal val setInterfaceDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_interface_direction", 1265174801)

    internal val setPopupOpenCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_popup_open_callback", 3379118538)

    internal val getPopupOpenCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_popup_open_callback", 3170603026)

    internal val setPopupCloseCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_popup_close_callback", 3379118538)

    internal val getPopupCloseCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_popup_close_callback", 3170603026)

    internal val setMinimumWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_minimum_width", 1794382983)

    internal val getMinimumWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_minimum_width", 866169185)

    internal val isOpenedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "is_opened", 4155700596)

    internal val addSubmenuItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_submenu_item", 1002030223)

    internal val addItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_item", 980552939)

    internal val addCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_check_item", 980552939)

    internal val addIconItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_icon_item", 1372188274)

    internal val addIconCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_icon_check_item", 1372188274)

    internal val addRadioCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_radio_check_item", 980552939)

    internal val addIconRadioCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_icon_radio_check_item", 1372188274)

    internal val addMultistateItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_multistate_item", 2674635658)

    internal val addSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "add_separator", 448810126)

    internal val findItemIndexWithTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "find_item_index_with_text", 1362438794)

    internal val findItemIndexWithTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "find_item_index_with_tag", 1260085030)

    internal val findItemIndexWithSubmenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "find_item_index_with_submenu", 893635918)

    internal val isItemCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "is_item_checked", 3120086654)

    internal val isItemCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "is_item_checkable", 3120086654)

    internal val isItemRadioCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "is_item_radio_checkable", 3120086654)

    internal val getItemCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_callback", 1639989698)

    internal val getItemKeyCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_key_callback", 1639989698)

    internal val getItemTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_tag", 4069510997)

    internal val getItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_text", 1464764419)

    internal val getItemSubmenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_submenu", 1066463050)

    internal val getItemAcceleratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_accelerator", 316800700)

    internal val isItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "is_item_disabled", 3120086654)

    internal val isItemHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "is_item_hidden", 3120086654)

    internal val getItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_tooltip", 1464764419)

    internal val getItemStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_state", 1120910005)

    internal val getItemMaxStatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_max_states", 1120910005)

    internal val getItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_icon", 3391850701)

    internal val getItemIndentationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_indentation_level", 1120910005)

    internal val setItemCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_checked", 2658558584)

    internal val setItemCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_checkable", 2658558584)

    internal val setItemRadioCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_radio_checkable", 2658558584)

    internal val setItemCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_callback", 2779810226)

    internal val setItemHoverCallbacksPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_hover_callbacks", 2779810226)

    internal val setItemKeyCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_key_callback", 2779810226)

    internal val setItemTagPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_tag", 2706844827)

    internal val setItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_text", 4153150897)

    internal val setItemSubmenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_submenu", 2310537182)

    internal val setItemAcceleratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_accelerator", 786300043)

    internal val setItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_disabled", 2658558584)

    internal val setItemHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_hidden", 2658558584)

    internal val setItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_tooltip", 4153150897)

    internal val setItemStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_state", 4288446313)

    internal val setItemMaxStatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_max_states", 4288446313)

    internal val setItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_icon", 1388763257)

    internal val setItemIndentationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_indentation_level", 4288446313)

    internal val setItemIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "set_item_index", 23951185)

    internal val getItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "get_item_count", 2198884583)

    internal val isSystemMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "is_system_menu", 4155700596)

    internal val removeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("NativeMenu", "remove_item", 3411492887)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("NativeMenu", "clear", 2722037293)
  }
}
