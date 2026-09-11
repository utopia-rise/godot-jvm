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
import godot.core.Color
import godot.core.Key
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.Signal0
import godot.core.Signal1
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [PopupMenu] is a modal window used to display a list of options. Useful for toolbars and context
 * menus.
 *
 * The size of a [PopupMenu] can be limited by using [Window.maxSize]. If the height of the list of
 * items is larger than the maximum height of the [PopupMenu], a [ScrollContainer] within the popup
 * will allow the user to scroll the contents. If no maximum size is set, or if it is set to `0`, the
 * [PopupMenu] height will be limited by its parent rect.
 *
 * All `set_*` methods allow negative item indices, i.e. `-1` to access the last item, `-2` to
 * select the second-to-last item, and so on.
 *
 * **Incremental search:** Like [ItemList] and [Tree], [PopupMenu] supports searching within the
 * list while the control is focused. Press a key that matches the first letter of an item's name to
 * select the first item starting with the given letter. After that point, there are two ways to
 * perform incremental search: 1) Press the same key again before the timeout duration to select the
 * next item starting with the same letter. 2) Press letter keys that match the rest of the word before
 * the timeout duration to match to select the item in question directly. Both of these actions will be
 * reset to the beginning of the list if the timeout duration has passed since the last keystroke was
 * registered. You can adjust the timeout duration by changing
 * [ProjectSettings.gui/timers/incrementalSearchMaxIntervalMsec].
 *
 * **Note:** [PopupMenu] is invisible by default. To make it visible, call one of the `popup_*`
 * methods from [Window] on the node, such as [Window.popupCenteredClamped].
 *
 * **Note:** The ID values used for items are limited to 32 bits, not full 64 bits of [Long]. This
 * has a range of `-2^32` to `2^32 - 1`, i.e. `-2147483648` to `2147483647`.
 */
@GodotBaseType
public open class PopupMenu : Popup() {
  /**
   * Emitted when an item of some [id] is pressed. Also emitted when its accelerator is activated on
   * macOS.
   *
   * **Note:** If [id] is negative (either explicitly or due to overflow), this will return the
   * corresponding index instead.
   */
  public val idPressed: Signal1<Long> by Signal1

  /**
   * Emitted when the user navigated to an item of some [id] using the [ProjectSettings.input/uiUp]
   * or [ProjectSettings.input/uiDown] input action.
   */
  public val idFocused: Signal1<Long> by Signal1

  /**
   * Emitted when an item of some [index] is pressed. Also emitted when its accelerator is activated
   * on macOS.
   */
  public val indexPressed: Signal1<Long> by Signal1

  /**
   * Emitted when any item is added, modified or removed.
   */
  public val menuChanged: Signal0 by Signal0

  /**
   * If `true`, hides the [PopupMenu] when an item is selected.
   */
  public final inline var hideOnItemSelection: Boolean
    @JvmName("hideOnItemSelectionProperty")
    get() = isHideOnItemSelection()
    @JvmName("hideOnItemSelectionProperty")
    set(`value`) {
      setHideOnItemSelection(value)
    }

  /**
   * If `true`, hides the [PopupMenu] when a checkbox or radio button is selected.
   */
  public final inline var hideOnCheckableItemSelection: Boolean
    @JvmName("hideOnCheckableItemSelectionProperty")
    get() = isHideOnCheckableItemSelection()
    @JvmName("hideOnCheckableItemSelectionProperty")
    set(`value`) {
      setHideOnCheckableItemSelection(value)
    }

  /**
   * If `true`, hides the [PopupMenu] when a state item is selected.
   */
  public final inline var hideOnStateItemSelection: Boolean
    @JvmName("hideOnStateItemSelectionProperty")
    get() = isHideOnStateItemSelection()
    @JvmName("hideOnStateItemSelectionProperty")
    set(`value`) {
      setHideOnStateItemSelection(value)
    }

  /**
   * Sets the delay time in seconds for the submenu item to popup on mouse hovering. If the popup
   * menu is added as a child of another (acting as a submenu), it will inherit the delay time of the
   * parent menu item.
   *
   * **Note:** If the mouse is exiting a submenu item with an open submenu and enters a different
   * submenu item, the submenu popup delay time is affected by the direction of the mouse movement
   * toward the open submenu. If the mouse is moving toward the submenu, the open submenu will wait
   * approximately `0.5` seconds before closing, which then allows the hovered submenu item to open.
   * This additional delay allows the mouse time to move to the open submenu across other menu items
   * without prematurely closing. If the mouse is not moving toward the open submenu, for example in a
   * downward direction, the open submenu will close immediately.
   */
  public final inline var submenuPopupDelay: Float
    @JvmName("submenuPopupDelayProperty")
    get() = getSubmenuPopupDelay()
    @JvmName("submenuPopupDelayProperty")
    set(`value`) {
      setSubmenuPopupDelay(value)
    }

  /**
   * If `true`, allows navigating [PopupMenu] with letter keys.
   */
  public final inline var allowSearch: Boolean
    @JvmName("allowSearchProperty")
    get() = getAllowSearch()
    @JvmName("allowSearchProperty")
    set(`value`) {
      setAllowSearch(value)
    }

  /**
   * If set to one of the values of [NativeMenu.SystemMenus], this [PopupMenu] is bound to the
   * special system menu. Only one [PopupMenu] can be bound to each special menu at a time.
   */
  public final inline var systemMenuId: NativeMenu.SystemMenus
    @JvmName("systemMenuIdProperty")
    get() = getSystemMenu()
    @JvmName("systemMenuIdProperty")
    set(`value`) {
      setSystemMenu(value)
    }

  /**
   * If `true`, [MenuBar] will use native menu when supported.
   *
   * **Note:** If [PopupMenu] is linked to [StatusIndicator], [MenuBar], or another [PopupMenu] item
   * it can use native menu regardless of this property, use [isNativeMenu] to check it.
   */
  public final inline var preferNativeMenu: Boolean
    @JvmName("preferNativeMenuProperty")
    get() = isPreferNativeMenu()
    @JvmName("preferNativeMenuProperty")
    set(`value`) {
      setPreferNativeMenu(value)
    }

  /**
   * If `true`, shrinks [PopupMenu] to minimum height when it's shown.
   */
  public final inline var shrinkHeight: Boolean
    @JvmName("shrinkHeightProperty")
    get() = getShrinkHeight()
    @JvmName("shrinkHeightProperty")
    set(`value`) {
      setShrinkHeight(value)
    }

  /**
   * If `true`, shrinks [PopupMenu] to minimum width when it's shown.
   */
  public final inline var shrinkWidth: Boolean
    @JvmName("shrinkWidthProperty")
    get() = getShrinkWidth()
    @JvmName("shrinkWidthProperty")
    set(`value`) {
      setShrinkWidth(value)
    }

  /**
   * If `true`, shows a search bar at the top of the [PopupMenu] for filtering items. See
   * [searchBarMinItemCount] for dynamically controlling its visibility based on the number of items.
   *
   * **Note:** When enabled, [allowSearch] is ignored.
   */
  public final inline var searchBarEnabled: Boolean
    @JvmName("searchBarEnabledProperty")
    get() = isSearchBarEnabled()
    @JvmName("searchBarEnabledProperty")
    set(`value`) {
      setSearchBarEnabled(value)
    }

  /**
   * Sets the minimum number of items required for the search bar to be visible. [searchBarEnabled]
   * must be `true` for this to have any effect. Separator items are not counted.
   */
  public final inline var searchBarMinItemCount: Int
    @JvmName("searchBarMinItemCountProperty")
    get() = getSearchBarMinItemCount()
    @JvmName("searchBarMinItemCountProperty")
    set(`value`) {
      setSearchBarMinItemCount(value)
    }

  /**
   * If `true`, enables fuzzy searching in the [PopupMenu] search bar. This allows the search
   * results to include items that almost match the search query, as well items that match the
   * individual characters of the search query, but not in sequence.
   *
   * Use [searchBarFuzzySearchMaxMisses] to set the maximum number of mismatches allowed in the
   * search results.
   */
  public final inline var searchBarFuzzySearchEnabled: Boolean
    @JvmName("searchBarFuzzySearchEnabledProperty")
    get() = isSearchBarFuzzySearchEnabled()
    @JvmName("searchBarFuzzySearchEnabledProperty")
    set(`value`) {
      setSearchBarFuzzySearchEnabled(value)
    }

  /**
   * Sets the maximum number of mismatches allowed in each search result when fuzzy searching is
   * enabled for the [PopupMenu] search bar. Any item with more mismatches will be hidden from the
   * search results.
   */
  public final inline var searchBarFuzzySearchMaxMisses: Int
    @JvmName("searchBarFuzzySearchMaxMissesProperty")
    get() = getSearchBarFuzzySearchMaxMisses()
    @JvmName("searchBarFuzzySearchMaxMissesProperty")
    set(`value`) {
      setSearchBarFuzzySearchMaxMisses(value)
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
    createNativeObject(567, scriptPtr)
  }

  /**
   * Checks the provided [event] against the [PopupMenu]'s shortcuts and accelerators, and activates
   * the first item with matching events. If [forGlobalOnly] is `true`, only shortcuts and accelerators
   * with `global` set to `true` will be called.
   *
   * Returns `true` if an item was successfully activated.
   *
   * **Note:** Certain [Control]s, such as [MenuButton], will call this method automatically.
   */
  @JvmOverloads
  public final fun activateItemByEvent(event: InputEvent?, forGlobalOnly: Boolean = false):
      Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to event, BOOL to forGlobalOnly)
    TransferContext.callMethod(MethodBindings.activateItemByEventPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setPreferNativeMenu(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setPreferNativeMenuPtr)
  }

  public final fun isPreferNativeMenu(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPreferNativeMenuPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the system native menu is supported and currently used by this [PopupMenu].
   */
  public final fun isNativeMenu(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isNativeMenuPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds a new item with text [label].
   *
   * An [id] can optionally be provided, as well as an accelerator ([accel]). If no [id] is
   * provided, one will be created from the index. If no [accel] is provided, then the default value of
   * 0 (corresponding to [@GlobalScope.KEY_NONE]) will be assigned to the item (which means it won't
   * have any accelerator). See [getItemAccelerator] for more info on accelerators.
   *
   * **Note:** The provided [id] is used only in [signal id_pressed] and [signal id_focused]
   * signals. It's not related to the `index` arguments in e.g. [setItemChecked].
   */
  @JvmOverloads
  public final fun addItem(
    label: String,
    id: Int = -1,
    accel: Key = Key.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, LONG to id.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.addItemPtr)
  }

  /**
   * Adds a new item with text [label] and icon [texture].
   *
   * An [id] can optionally be provided, as well as an accelerator ([accel]). If no [id] is
   * provided, one will be created from the index. If no [accel] is provided, then the default value of
   * 0 (corresponding to [@GlobalScope.KEY_NONE]) will be assigned to the item (which means it won't
   * have any accelerator). See [getItemAccelerator] for more info on accelerators.
   */
  @JvmOverloads
  public final fun addIconItem(
    texture: Texture2D?,
    label: String,
    id: Int = -1,
    accel: Key = Key.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, STRING to label, LONG to id.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.addIconItemPtr)
  }

  /**
   * Adds a new checkable item with text [label].
   *
   * An [id] can optionally be provided, as well as an accelerator ([accel]). If no [id] is
   * provided, one will be created from the index. If no [accel] is provided, then the default value of
   * 0 (corresponding to [@GlobalScope.KEY_NONE]) will be assigned to the item (which means it won't
   * have any accelerator). See [getItemAccelerator] for more info on accelerators.
   *
   * **Note:** Checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   */
  @JvmOverloads
  public final fun addCheckItem(
    label: String,
    id: Int = -1,
    accel: Key = Key.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, LONG to id.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.addCheckItemPtr)
  }

  /**
   * Adds a new checkable item with text [label] and icon [texture].
   *
   * An [id] can optionally be provided, as well as an accelerator ([accel]). If no [id] is
   * provided, one will be created from the index. If no [accel] is provided, then the default value of
   * 0 (corresponding to [@GlobalScope.KEY_NONE]) will be assigned to the item (which means it won't
   * have any accelerator). See [getItemAccelerator] for more info on accelerators.
   *
   * **Note:** Checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   */
  @JvmOverloads
  public final fun addIconCheckItem(
    texture: Texture2D?,
    label: String,
    id: Int = -1,
    accel: Key = Key.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, STRING to label, LONG to id.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.addIconCheckItemPtr)
  }

  /**
   * Adds a new radio check button with text [label].
   *
   * An [id] can optionally be provided, as well as an accelerator ([accel]). If no [id] is
   * provided, one will be created from the index. If no [accel] is provided, then the default value of
   * 0 (corresponding to [@GlobalScope.KEY_NONE]) will be assigned to the item (which means it won't
   * have any accelerator). See [getItemAccelerator] for more info on accelerators.
   *
   * **Note:** Checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   */
  @JvmOverloads
  public final fun addRadioCheckItem(
    label: String,
    id: Int = -1,
    accel: Key = Key.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, LONG to id.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.addRadioCheckItemPtr)
  }

  /**
   * Same as [addIconCheckItem], but uses a radio check button.
   */
  @JvmOverloads
  public final fun addIconRadioCheckItem(
    texture: Texture2D?,
    label: String,
    id: Int = -1,
    accel: Key = Key.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, STRING to label, LONG to id.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.addIconRadioCheckItemPtr)
  }

  /**
   * Adds a new multistate item with text [label].
   *
   * Contrarily to normal binary items, multistate items can have more than two states, as defined
   * by [maxStates]. The default value is defined by [defaultState].
   *
   * An [id] can optionally be provided, as well as an accelerator ([accel]). If no [id] is
   * provided, one will be created from the index. If no [accel] is provided, then the default value of
   * 0 (corresponding to [@GlobalScope.KEY_NONE]) will be assigned to the item (which means it won't
   * have any accelerator). See [getItemAccelerator] for more info on accelerators.
   *
   * ```
   * func _ready():
   * 	add_multistate_item("Item", 3, 0)
   *
   * 	index_pressed.connect(func(index: int):
   * 			toggle_item_multistate(index)
   * 			match get_item_multistate(index):
   * 				0:
   * 					print("First state")
   * 				1:
   * 					print("Second state")
   * 				2:
   * 					print("Third state")
   * 		)
   * ```
   *
   * **Note:** Multistate items don't update their state automatically and must be done manually.
   * See [toggleItemMultistate], [setItemMultistate] and [getItemMultistate] for more info on how to
   * control it.
   */
  @JvmOverloads
  public final fun addMultistateItem(
    label: String,
    maxStates: Int,
    defaultState: Int = 0,
    id: Int = -1,
    accel: Key = Key.NONE,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, LONG to maxStates.toLong(), LONG to defaultState.toLong(), LONG to id.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.addMultistateItemPtr)
  }

  /**
   * Adds a [Shortcut].
   *
   * An [id] can optionally be provided. If no [id] is provided, one will be created from the index.
   *
   * If [allowEcho] is `true`, the shortcut can be activated with echo events.
   */
  @JvmOverloads
  public final fun addShortcut(
    shortcut: Shortcut?,
    id: Int = -1,
    global: Boolean = false,
    allowEcho: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shortcut, LONG to id.toLong(), BOOL to global, BOOL to allowEcho)
    TransferContext.callMethod(MethodBindings.addShortcutPtr)
  }

  /**
   * Adds a new item and assigns the specified [Shortcut] and icon [texture] to it. Sets the label
   * of the checkbox to the [Shortcut]'s name.
   *
   * An [id] can optionally be provided. If no [id] is provided, one will be created from the index.
   *
   * If [allowEcho] is `true`, the shortcut can be activated with echo events.
   */
  @JvmOverloads
  public final fun addIconShortcut(
    texture: Texture2D?,
    shortcut: Shortcut?,
    id: Int = -1,
    global: Boolean = false,
    allowEcho: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, OBJECT to shortcut, LONG to id.toLong(), BOOL to global, BOOL to allowEcho)
    TransferContext.callMethod(MethodBindings.addIconShortcutPtr)
  }

  /**
   * Adds a new checkable item and assigns the specified [Shortcut] to it. Sets the label of the
   * checkbox to the [Shortcut]'s name.
   *
   * An [id] can optionally be provided. If no [id] is provided, one will be created from the index.
   *
   * **Note:** Checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   */
  @JvmOverloads
  public final fun addCheckShortcut(
    shortcut: Shortcut?,
    id: Int = -1,
    global: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shortcut, LONG to id.toLong(), BOOL to global)
    TransferContext.callMethod(MethodBindings.addCheckShortcutPtr)
  }

  /**
   * Adds a new checkable item and assigns the specified [Shortcut] and icon [texture] to it. Sets
   * the label of the checkbox to the [Shortcut]'s name.
   *
   * An [id] can optionally be provided. If no [id] is provided, one will be created from the index.
   *
   * **Note:** Checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   */
  @JvmOverloads
  public final fun addIconCheckShortcut(
    texture: Texture2D?,
    shortcut: Shortcut?,
    id: Int = -1,
    global: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, OBJECT to shortcut, LONG to id.toLong(), BOOL to global)
    TransferContext.callMethod(MethodBindings.addIconCheckShortcutPtr)
  }

  /**
   * Adds a new radio check button and assigns a [Shortcut] to it. Sets the label of the checkbox to
   * the [Shortcut]'s name.
   *
   * An [id] can optionally be provided. If no [id] is provided, one will be created from the index.
   *
   * **Note:** Checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually. See [setItemChecked] for more info on how to
   * control it.
   */
  @JvmOverloads
  public final fun addRadioCheckShortcut(
    shortcut: Shortcut?,
    id: Int = -1,
    global: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shortcut, LONG to id.toLong(), BOOL to global)
    TransferContext.callMethod(MethodBindings.addRadioCheckShortcutPtr)
  }

  /**
   * Same as [addIconCheckShortcut], but uses a radio check button.
   */
  @JvmOverloads
  public final fun addIconRadioCheckShortcut(
    texture: Texture2D?,
    shortcut: Shortcut?,
    id: Int = -1,
    global: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, OBJECT to shortcut, LONG to id.toLong(), BOOL to global)
    TransferContext.callMethod(MethodBindings.addIconRadioCheckShortcutPtr)
  }

  /**
   * Adds an item that will act as a submenu of the parent [PopupMenu] node when clicked. The
   * [submenu] argument must be the name of an existing [PopupMenu] that has been added as a child to
   * this node. This submenu will be shown when the item is clicked, hovered for long enough, or
   * activated using the `ui_select` or `ui_right` input actions.
   *
   * An [id] can optionally be provided. If no [id] is provided, one will be created from the index.
   */
  @JvmOverloads
  public final fun addSubmenuItem(
    label: String,
    submenu: String,
    id: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, STRING to submenu, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.addSubmenuItemPtr)
  }

  /**
   * Adds an item that will act as a submenu of the parent [PopupMenu] node when clicked. This
   * submenu will be shown when the item is clicked, hovered for long enough, or activated using the
   * `ui_select` or `ui_right` input actions.
   *
   * [submenu] must be either child of this [PopupMenu] or has no parent node (in which case it will
   * be automatically added as a child). If the [submenu] popup has another parent, this method will
   * fail.
   *
   * An [id] can optionally be provided. If no [id] is provided, one will be created from the index.
   */
  @JvmOverloads
  public final fun addSubmenuNodeItem(
    label: String,
    submenu: PopupMenu?,
    id: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, OBJECT to submenu, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.addSubmenuNodeItemPtr)
  }

  /**
   * Sets the text of the item at the given [index].
   */
  public final fun setItemText(index: Int, text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), STRING to text)
    TransferContext.callMethod(MethodBindings.setItemTextPtr)
  }

  /**
   * Sets item's text base writing direction.
   */
  public final fun setItemTextDirection(index: Int, direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setItemTextDirectionPtr)
  }

  /**
   * Sets the language code of the text for the item at the given index to [language]. This is used
   * for line-breaking and text shaping algorithms. If [language] is empty, the current locale is used.
   */
  public final fun setItemLanguage(index: Int, language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), STRING to language)
    TransferContext.callMethod(MethodBindings.setItemLanguagePtr)
  }

  /**
   * Sets the auto translate mode of the item at the given [index].
   *
   * Items use [Node.AUTO_TRANSLATE_MODE_INHERIT] by default, which uses the same auto translate
   * mode as the [PopupMenu] itself.
   */
  public final fun setItemAutoTranslateMode(index: Int, mode: Node.AutoTranslateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setItemAutoTranslateModePtr)
  }

  /**
   * Replaces the [Texture2D] icon of the item at the given [index].
   */
  public final fun setItemIcon(index: Int, icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to icon)
    TransferContext.callMethod(MethodBindings.setItemIconPtr)
  }

  /**
   * Sets the maximum allowed width of the icon for the item at the given [index]. This limit is
   * applied on top of the default size of the icon and on top of [theme_item icon_max_width]. The
   * height is adjusted according to the icon's ratio.
   */
  public final fun setItemIconMaxWidth(index: Int, width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setItemIconMaxWidthPtr)
  }

  /**
   * Sets a modulating [Color] of the item's icon at the given [index].
   */
  public final fun setItemIconModulate(index: Int, modulate: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), COLOR to modulate)
    TransferContext.callMethod(MethodBindings.setItemIconModulatePtr)
  }

  /**
   * Sets the checkstate status of the item at the given [index].
   */
  public final fun setItemChecked(index: Int, checked: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to checked)
    TransferContext.callMethod(MethodBindings.setItemCheckedPtr)
  }

  /**
   * Sets the [id] of the item at the given [index].
   *
   * The [id] is used in [signal id_pressed] and [signal id_focused] signals.
   */
  public final fun setItemId(index: Int, id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.setItemIdPtr)
  }

  /**
   * Sets the accelerator of the item at the given [index]. An accelerator is a keyboard shortcut
   * that can be pressed to trigger the menu button even if it's not currently open. [accel] is
   * generally a combination of [KeyModifierMask]s and [Key]s using bitwise OR such as `KEY_MASK_CTRL |
   * KEY_A` ([kbd]Ctrl + A[/kbd]).
   */
  public final fun setItemAccelerator(index: Int, accel: Key): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to accel.value)
    TransferContext.callMethod(MethodBindings.setItemAcceleratorPtr)
  }

  /**
   * Sets the metadata of an item, which may be of any type. You can later get it with
   * [getItemMetadata], which provides a simple way of assigning context data to items.
   */
  public final fun setItemMetadata(index: Int, metadata: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), ANY to metadata)
    TransferContext.callMethod(MethodBindings.setItemMetadataPtr)
  }

  /**
   * Enables/disables the item at the given [index]. When it is disabled, it can't be selected and
   * its action can't be invoked.
   */
  public final fun setItemDisabled(index: Int, disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setItemDisabledPtr)
  }

  /**
   * Sets the submenu of the item at the given [index]. The submenu is the name of a child
   * [PopupMenu] node that would be shown when the item is clicked.
   */
  public final fun setItemSubmenu(index: Int, submenu: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), STRING to submenu)
    TransferContext.callMethod(MethodBindings.setItemSubmenuPtr)
  }

  /**
   * Sets the submenu of the item at the given [index]. The submenu is a [PopupMenu] node that would
   * be shown when the item is clicked. It must either be a child of this [PopupMenu] or has no parent
   * (in which case it will be automatically added as a child). If the [submenu] popup has another
   * parent, this method will fail.
   */
  public final fun setItemSubmenuNode(index: Int, submenu: PopupMenu?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to submenu)
    TransferContext.callMethod(MethodBindings.setItemSubmenuNodePtr)
  }

  /**
   * Mark the item at the given [index] as a separator, which means that it would be displayed as a
   * line. If `false`, sets the type of the item to plain text.
   */
  public final fun setItemAsSeparator(index: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setItemAsSeparatorPtr)
  }

  /**
   * Sets whether the item at the given [index] has a checkbox. If `false`, sets the type of the
   * item to plain text.
   *
   * **Note:** Checkable items just display a checkmark, but don't have any built-in checking
   * behavior and must be checked/unchecked manually.
   */
  public final fun setItemAsCheckable(index: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setItemAsCheckablePtr)
  }

  /**
   * Sets the type of the item at the given [index] to radio button. If `false`, sets the type of
   * the item to plain text.
   */
  public final fun setItemAsRadioCheckable(index: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setItemAsRadioCheckablePtr)
  }

  /**
   * Sets the [String] tooltip of the item at the given [index].
   */
  public final fun setItemTooltip(index: Int, tooltip: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), STRING to tooltip)
    TransferContext.callMethod(MethodBindings.setItemTooltipPtr)
  }

  /**
   * Sets a [Shortcut] for the item at the given [index].
   */
  @JvmOverloads
  public final fun setItemShortcut(
    index: Int,
    shortcut: Shortcut?,
    global: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to shortcut, BOOL to global)
    TransferContext.callMethod(MethodBindings.setItemShortcutPtr)
  }

  /**
   * Sets the horizontal offset of the item at the given [index].
   */
  public final fun setItemIndent(index: Int, indent: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to indent.toLong())
    TransferContext.callMethod(MethodBindings.setItemIndentPtr)
  }

  /**
   * Sets the state of a multistate item. See [addMultistateItem] for details.
   */
  public final fun setItemMultistate(index: Int, state: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to state.toLong())
    TransferContext.callMethod(MethodBindings.setItemMultistatePtr)
  }

  /**
   * Sets the max states of a multistate item. See [addMultistateItem] for details.
   */
  public final fun setItemMultistateMax(index: Int, maxStates: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to maxStates.toLong())
    TransferContext.callMethod(MethodBindings.setItemMultistateMaxPtr)
  }

  /**
   * Disables the [Shortcut] of the item at the given [index].
   */
  public final fun setItemShortcutDisabled(index: Int, disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setItemShortcutDisabledPtr)
  }

  /**
   * Changes the index of the item at index [index] to be at index [targetIndex]. This can be used
   * to move an item above other items. The moved item will keep the same ID, even if it was generated
   * from the original index.
   *
   * **Note:** The indices of any items between index [index] and index [targetIndex] will be
   * shifted by one.
   */
  public final fun setItemIndex(index: Int, targetIndex: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to targetIndex.toLong())
    TransferContext.callMethod(MethodBindings.setItemIndexPtr)
  }

  /**
   * Toggles the check state of the item at the given [index].
   */
  public final fun toggleItemChecked(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.toggleItemCheckedPtr)
  }

  /**
   * Cycle to the next state of a multistate item. See [addMultistateItem] for details.
   */
  public final fun toggleItemMultistate(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.toggleItemMultistatePtr)
  }

  /**
   * Returns the text of the item at the given [index].
   */
  public final fun getItemText(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns item's text base writing direction.
   */
  public final fun getItemTextDirection(index: Int): Control.TextDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemTextDirectionPtr)
    return Control.TextDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns item's text language code.
   */
  public final fun getItemLanguage(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the auto translate mode of the item at the given [index].
   */
  public final fun getItemAutoTranslateMode(index: Int): Node.AutoTranslateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemAutoTranslateModePtr)
    return Node.AutoTranslateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the icon of the item at the given [index].
   */
  public final fun getItemIcon(index: Int): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Returns the maximum allowed width of the icon for the item at the given [index].
   */
  public final fun getItemIconMaxWidth(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconMaxWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns a [Color] modulating the item's icon at the given [index].
   */
  public final fun getItemIconModulate(index: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns `true` if the item at the given [index] is checked.
   */
  public final fun isItemChecked(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isItemCheckedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the ID of the item at the given [index].
   */
  public final fun getItemId(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the item containing the specified [id]. The index is automatically
   * assigned to each item by the engine when added and represents the order items will be displayed.
   */
  public final fun getItemIndex(id: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getItemIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the accelerator of the item at the given [index]. An accelerator is a keyboard shortcut
   * that can be pressed to trigger the menu button even if it's not currently open. The return value
   * is an integer which is generally a combination of [KeyModifierMask]s and [Key]s using bitwise OR
   * such as `KEY_MASK_CTRL | KEY_A` ([kbd]Ctrl + A[/kbd]). If no accelerator is defined for the
   * specified [index], [getItemAccelerator] returns `0` (corresponding to [@GlobalScope.KEY_NONE]).
   */
  public final fun getItemAccelerator(index: Int): Key {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemAcceleratorPtr)
    return Key.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the metadata of the specified item, which might be of any type. You can set it with
   * [setItemMetadata], which provides a simple way of assigning context data to items.
   */
  public final fun getItemMetadata(index: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemMetadataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns `true` if the item at the given [index] is disabled. When it is disabled it can't be
   * selected, or its action invoked.
   *
   * See [setItemDisabled] for more info on how to disable an item.
   */
  public final fun isItemDisabled(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isItemDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the submenu name of the item at the given [index]. See [addSubmenuItem] for more info
   * on how to add a submenu.
   */
  public final fun getItemSubmenu(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemSubmenuPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the submenu of the item at the given [index], or `null` if no submenu was added. See
   * [addSubmenuNodeItem] for more info on how to add a submenu.
   */
  public final fun getItemSubmenuNode(index: Int): PopupMenu? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemSubmenuNodePtr)
    return (TransferContext.readReturnValue(OBJECT) as PopupMenu?)
  }

  /**
   * Returns `true` if the item is a separator. If it is, it will be displayed as a line. See
   * [addSeparator] for more info on how to add a separator.
   */
  public final fun isItemSeparator(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isItemSeparatorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the item at the given [index] is checkable in some way, i.e. if it has a
   * checkbox or radio button.
   *
   * **Note:** Checkable items just display a checkmark or radio button, but don't have any built-in
   * checking behavior and must be checked/unchecked manually.
   */
  public final fun isItemCheckable(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isItemCheckablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the item at the given [index] has radio button-style checkability.
   *
   * **Note:** This is purely cosmetic; you must add the logic for checking/unchecking items in
   * radio groups.
   */
  public final fun isItemRadioCheckable(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isItemRadioCheckablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the specified item's shortcut is disabled.
   */
  public final fun isItemShortcutDisabled(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isItemShortcutDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the tooltip associated with the item at the given [index].
   */
  public final fun getItemTooltip(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemTooltipPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the [Shortcut] associated with the item at the given [index].
   */
  public final fun getItemShortcut(index: Int): Shortcut? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemShortcutPtr)
    return (TransferContext.readReturnValue(OBJECT) as Shortcut?)
  }

  /**
   * Returns the horizontal offset of the item at the given [index].
   */
  public final fun getItemIndent(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemIndentPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the max states of the item at the given [index].
   */
  public final fun getItemMultistateMax(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemMultistateMaxPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the state of the item at the given [index].
   */
  public final fun getItemMultistate(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getItemMultistatePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the currently focused item as the given [index].
   *
   * Passing `-1` as the index makes so that no item is focused.
   */
  public final fun setFocusedItem(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.setFocusedItemPtr)
  }

  /**
   * Returns the index of the currently focused item. Returns `-1` if no item is focused.
   */
  public final fun getFocusedItem(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFocusedItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
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

  /**
   * Moves the scroll view to make the item at the given [index] visible.
   */
  public final fun scrollToItem(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.scrollToItemPtr)
  }

  /**
   * Removes the item at the given [index] from the menu.
   *
   * **Note:** The indices of items after the removed item will be shifted by one.
   */
  public final fun removeItem(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.removeItemPtr)
  }

  /**
   * Adds a separator between items. Separators also occupy an index, which you can set by using the
   * [id] parameter.
   *
   * A [label] can optionally be provided, which will appear at the center of the separator.
   */
  @JvmOverloads
  public final fun addSeparator(label: String = "", id: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.addSeparatorPtr)
  }

  /**
   * Removes all items from the [PopupMenu]. If [freeSubmenus] is `true`, the submenu nodes are
   * automatically freed.
   */
  @JvmOverloads
  public final fun clear(freeSubmenus: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to freeSubmenus)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  public final fun setHideOnItemSelection(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHideOnItemSelectionPtr)
  }

  public final fun isHideOnItemSelection(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHideOnItemSelectionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHideOnCheckableItemSelection(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHideOnCheckableItemSelectionPtr)
  }

  public final fun isHideOnCheckableItemSelection(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHideOnCheckableItemSelectionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setHideOnStateItemSelection(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setHideOnStateItemSelectionPtr)
  }

  public final fun isHideOnStateItemSelection(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHideOnStateItemSelectionPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSubmenuPopupDelay(seconds: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to seconds.toDouble())
    TransferContext.callMethod(MethodBindings.setSubmenuPopupDelayPtr)
  }

  public final fun getSubmenuPopupDelay(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubmenuPopupDelayPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAllowSearch(allow: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to allow)
    TransferContext.callMethod(MethodBindings.setAllowSearchPtr)
  }

  public final fun getAllowSearch(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllowSearchPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the menu is bound to the special system menu.
   */
  public final fun isSystemMenu(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSystemMenuPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSystemMenu(systemMenuId: NativeMenu.SystemMenus): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to systemMenuId.value)
    TransferContext.callMethod(MethodBindings.setSystemMenuPtr)
  }

  public final fun getSystemMenu(): NativeMenu.SystemMenus {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSystemMenuPtr)
    return NativeMenu.SystemMenus.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setSearchBarEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSearchBarEnabledPtr)
  }

  public final fun isSearchBarEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSearchBarEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSearchBarMinItemCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setSearchBarMinItemCountPtr)
  }

  public final fun getSearchBarMinItemCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSearchBarMinItemCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSearchBarFuzzySearchEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSearchBarFuzzySearchEnabledPtr)
  }

  public final fun isSearchBarFuzzySearchEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSearchBarFuzzySearchEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setSearchBarFuzzySearchMaxMisses(maxMisses: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to maxMisses.toLong())
    TransferContext.callMethod(MethodBindings.setSearchBarFuzzySearchMaxMissesPtr)
  }

  public final fun getSearchBarFuzzySearchMaxMisses(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSearchBarFuzzySearchMaxMissesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setShrinkHeight(shrink: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to shrink)
    TransferContext.callMethod(MethodBindings.setShrinkHeightPtr)
  }

  public final fun getShrinkHeight(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShrinkHeightPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShrinkWidth(shrink: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to shrink)
    TransferContext.callMethod(MethodBindings.setShrinkWidthPtr)
  }

  public final fun getShrinkWidth(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShrinkWidthPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val activateItemByEventName: MethodStringName2<PopupMenu, Boolean, InputEvent?, Boolean>
        = MethodStringName2<PopupMenu, Boolean, InputEvent?, Boolean>("activate_item_by_event")

    @JvmField
    public val setPreferNativeMenuName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_prefer_native_menu")

    @JvmField
    public val isPreferNativeMenuName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_prefer_native_menu")

    @JvmField
    public val isNativeMenuName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_native_menu")

    @JvmField
    public val addItemName: MethodStringName3<PopupMenu, Unit, String, Int, Key> =
        MethodStringName3<PopupMenu, Unit, String, Int, Key>("add_item")

    @JvmField
    public val addIconItemName: MethodStringName4<PopupMenu, Unit, Texture2D?, String, Int, Key> =
        MethodStringName4<PopupMenu, Unit, Texture2D?, String, Int, Key>("add_icon_item")

    @JvmField
    public val addCheckItemName: MethodStringName3<PopupMenu, Unit, String, Int, Key> =
        MethodStringName3<PopupMenu, Unit, String, Int, Key>("add_check_item")

    @JvmField
    public val addIconCheckItemName:
        MethodStringName4<PopupMenu, Unit, Texture2D?, String, Int, Key> =
        MethodStringName4<PopupMenu, Unit, Texture2D?, String, Int, Key>("add_icon_check_item")

    @JvmField
    public val addRadioCheckItemName: MethodStringName3<PopupMenu, Unit, String, Int, Key> =
        MethodStringName3<PopupMenu, Unit, String, Int, Key>("add_radio_check_item")

    @JvmField
    public val addIconRadioCheckItemName:
        MethodStringName4<PopupMenu, Unit, Texture2D?, String, Int, Key> =
        MethodStringName4<PopupMenu, Unit, Texture2D?, String, Int, Key>("add_icon_radio_check_item")

    @JvmField
    public val addMultistateItemName: MethodStringName5<PopupMenu, Unit, String, Int, Int, Int, Key>
        = MethodStringName5<PopupMenu, Unit, String, Int, Int, Int, Key>("add_multistate_item")

    @JvmField
    public val addShortcutName: MethodStringName4<PopupMenu, Unit, Shortcut?, Int, Boolean, Boolean>
        = MethodStringName4<PopupMenu, Unit, Shortcut?, Int, Boolean, Boolean>("add_shortcut")

    @JvmField
    public val addIconShortcutName:
        MethodStringName5<PopupMenu, Unit, Texture2D?, Shortcut?, Int, Boolean, Boolean> =
        MethodStringName5<PopupMenu, Unit, Texture2D?, Shortcut?, Int, Boolean, Boolean>("add_icon_shortcut")

    @JvmField
    public val addCheckShortcutName: MethodStringName3<PopupMenu, Unit, Shortcut?, Int, Boolean> =
        MethodStringName3<PopupMenu, Unit, Shortcut?, Int, Boolean>("add_check_shortcut")

    @JvmField
    public val addIconCheckShortcutName:
        MethodStringName4<PopupMenu, Unit, Texture2D?, Shortcut?, Int, Boolean> =
        MethodStringName4<PopupMenu, Unit, Texture2D?, Shortcut?, Int, Boolean>("add_icon_check_shortcut")

    @JvmField
    public val addRadioCheckShortcutName:
        MethodStringName3<PopupMenu, Unit, Shortcut?, Int, Boolean> =
        MethodStringName3<PopupMenu, Unit, Shortcut?, Int, Boolean>("add_radio_check_shortcut")

    @JvmField
    public val addIconRadioCheckShortcutName:
        MethodStringName4<PopupMenu, Unit, Texture2D?, Shortcut?, Int, Boolean> =
        MethodStringName4<PopupMenu, Unit, Texture2D?, Shortcut?, Int, Boolean>("add_icon_radio_check_shortcut")

    @JvmField
    public val addSubmenuItemName: MethodStringName3<PopupMenu, Unit, String, String, Int> =
        MethodStringName3<PopupMenu, Unit, String, String, Int>("add_submenu_item")

    @JvmField
    public val addSubmenuNodeItemName: MethodStringName3<PopupMenu, Unit, String, PopupMenu?, Int> =
        MethodStringName3<PopupMenu, Unit, String, PopupMenu?, Int>("add_submenu_node_item")

    @JvmField
    public val setItemTextName: MethodStringName2<PopupMenu, Unit, Int, String> =
        MethodStringName2<PopupMenu, Unit, Int, String>("set_item_text")

    @JvmField
    public val setItemTextDirectionName:
        MethodStringName2<PopupMenu, Unit, Int, Control.TextDirection> =
        MethodStringName2<PopupMenu, Unit, Int, Control.TextDirection>("set_item_text_direction")

    @JvmField
    public val setItemLanguageName: MethodStringName2<PopupMenu, Unit, Int, String> =
        MethodStringName2<PopupMenu, Unit, Int, String>("set_item_language")

    @JvmField
    public val setItemAutoTranslateModeName:
        MethodStringName2<PopupMenu, Unit, Int, Node.AutoTranslateMode> =
        MethodStringName2<PopupMenu, Unit, Int, Node.AutoTranslateMode>("set_item_auto_translate_mode")

    @JvmField
    public val setItemIconName: MethodStringName2<PopupMenu, Unit, Int, Texture2D?> =
        MethodStringName2<PopupMenu, Unit, Int, Texture2D?>("set_item_icon")

    @JvmField
    public val setItemIconMaxWidthName: MethodStringName2<PopupMenu, Unit, Int, Int> =
        MethodStringName2<PopupMenu, Unit, Int, Int>("set_item_icon_max_width")

    @JvmField
    public val setItemIconModulateName: MethodStringName2<PopupMenu, Unit, Int, Color> =
        MethodStringName2<PopupMenu, Unit, Int, Color>("set_item_icon_modulate")

    @JvmField
    public val setItemCheckedName: MethodStringName2<PopupMenu, Unit, Int, Boolean> =
        MethodStringName2<PopupMenu, Unit, Int, Boolean>("set_item_checked")

    @JvmField
    public val setItemIdName: MethodStringName2<PopupMenu, Unit, Int, Int> =
        MethodStringName2<PopupMenu, Unit, Int, Int>("set_item_id")

    @JvmField
    public val setItemAcceleratorName: MethodStringName2<PopupMenu, Unit, Int, Key> =
        MethodStringName2<PopupMenu, Unit, Int, Key>("set_item_accelerator")

    @JvmField
    public val setItemMetadataName: MethodStringName2<PopupMenu, Unit, Int, Any?> =
        MethodStringName2<PopupMenu, Unit, Int, Any?>("set_item_metadata")

    @JvmField
    public val setItemDisabledName: MethodStringName2<PopupMenu, Unit, Int, Boolean> =
        MethodStringName2<PopupMenu, Unit, Int, Boolean>("set_item_disabled")

    @JvmField
    public val setItemSubmenuName: MethodStringName2<PopupMenu, Unit, Int, String> =
        MethodStringName2<PopupMenu, Unit, Int, String>("set_item_submenu")

    @JvmField
    public val setItemSubmenuNodeName: MethodStringName2<PopupMenu, Unit, Int, PopupMenu?> =
        MethodStringName2<PopupMenu, Unit, Int, PopupMenu?>("set_item_submenu_node")

    @JvmField
    public val setItemAsSeparatorName: MethodStringName2<PopupMenu, Unit, Int, Boolean> =
        MethodStringName2<PopupMenu, Unit, Int, Boolean>("set_item_as_separator")

    @JvmField
    public val setItemAsCheckableName: MethodStringName2<PopupMenu, Unit, Int, Boolean> =
        MethodStringName2<PopupMenu, Unit, Int, Boolean>("set_item_as_checkable")

    @JvmField
    public val setItemAsRadioCheckableName: MethodStringName2<PopupMenu, Unit, Int, Boolean> =
        MethodStringName2<PopupMenu, Unit, Int, Boolean>("set_item_as_radio_checkable")

    @JvmField
    public val setItemTooltipName: MethodStringName2<PopupMenu, Unit, Int, String> =
        MethodStringName2<PopupMenu, Unit, Int, String>("set_item_tooltip")

    @JvmField
    public val setItemShortcutName: MethodStringName3<PopupMenu, Unit, Int, Shortcut?, Boolean> =
        MethodStringName3<PopupMenu, Unit, Int, Shortcut?, Boolean>("set_item_shortcut")

    @JvmField
    public val setItemIndentName: MethodStringName2<PopupMenu, Unit, Int, Int> =
        MethodStringName2<PopupMenu, Unit, Int, Int>("set_item_indent")

    @JvmField
    public val setItemMultistateName: MethodStringName2<PopupMenu, Unit, Int, Int> =
        MethodStringName2<PopupMenu, Unit, Int, Int>("set_item_multistate")

    @JvmField
    public val setItemMultistateMaxName: MethodStringName2<PopupMenu, Unit, Int, Int> =
        MethodStringName2<PopupMenu, Unit, Int, Int>("set_item_multistate_max")

    @JvmField
    public val setItemShortcutDisabledName: MethodStringName2<PopupMenu, Unit, Int, Boolean> =
        MethodStringName2<PopupMenu, Unit, Int, Boolean>("set_item_shortcut_disabled")

    @JvmField
    public val setItemIndexName: MethodStringName2<PopupMenu, Unit, Int, Int> =
        MethodStringName2<PopupMenu, Unit, Int, Int>("set_item_index")

    @JvmField
    public val toggleItemCheckedName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("toggle_item_checked")

    @JvmField
    public val toggleItemMultistateName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("toggle_item_multistate")

    @JvmField
    public val getItemTextName: MethodStringName1<PopupMenu, String, Int> =
        MethodStringName1<PopupMenu, String, Int>("get_item_text")

    @JvmField
    public val getItemTextDirectionName: MethodStringName1<PopupMenu, Control.TextDirection, Int> =
        MethodStringName1<PopupMenu, Control.TextDirection, Int>("get_item_text_direction")

    @JvmField
    public val getItemLanguageName: MethodStringName1<PopupMenu, String, Int> =
        MethodStringName1<PopupMenu, String, Int>("get_item_language")

    @JvmField
    public val getItemAutoTranslateModeName:
        MethodStringName1<PopupMenu, Node.AutoTranslateMode, Int> =
        MethodStringName1<PopupMenu, Node.AutoTranslateMode, Int>("get_item_auto_translate_mode")

    @JvmField
    public val getItemIconName: MethodStringName1<PopupMenu, Texture2D?, Int> =
        MethodStringName1<PopupMenu, Texture2D?, Int>("get_item_icon")

    @JvmField
    public val getItemIconMaxWidthName: MethodStringName1<PopupMenu, Int, Int> =
        MethodStringName1<PopupMenu, Int, Int>("get_item_icon_max_width")

    @JvmField
    public val getItemIconModulateName: MethodStringName1<PopupMenu, Color, Int> =
        MethodStringName1<PopupMenu, Color, Int>("get_item_icon_modulate")

    @JvmField
    public val isItemCheckedName: MethodStringName1<PopupMenu, Boolean, Int> =
        MethodStringName1<PopupMenu, Boolean, Int>("is_item_checked")

    @JvmField
    public val getItemIdName: MethodStringName1<PopupMenu, Int, Int> =
        MethodStringName1<PopupMenu, Int, Int>("get_item_id")

    @JvmField
    public val getItemIndexName: MethodStringName1<PopupMenu, Int, Int> =
        MethodStringName1<PopupMenu, Int, Int>("get_item_index")

    @JvmField
    public val getItemAcceleratorName: MethodStringName1<PopupMenu, Key, Int> =
        MethodStringName1<PopupMenu, Key, Int>("get_item_accelerator")

    @JvmField
    public val getItemMetadataName: MethodStringName1<PopupMenu, Any?, Int> =
        MethodStringName1<PopupMenu, Any?, Int>("get_item_metadata")

    @JvmField
    public val isItemDisabledName: MethodStringName1<PopupMenu, Boolean, Int> =
        MethodStringName1<PopupMenu, Boolean, Int>("is_item_disabled")

    @JvmField
    public val getItemSubmenuName: MethodStringName1<PopupMenu, String, Int> =
        MethodStringName1<PopupMenu, String, Int>("get_item_submenu")

    @JvmField
    public val getItemSubmenuNodeName: MethodStringName1<PopupMenu, PopupMenu?, Int> =
        MethodStringName1<PopupMenu, PopupMenu?, Int>("get_item_submenu_node")

    @JvmField
    public val isItemSeparatorName: MethodStringName1<PopupMenu, Boolean, Int> =
        MethodStringName1<PopupMenu, Boolean, Int>("is_item_separator")

    @JvmField
    public val isItemCheckableName: MethodStringName1<PopupMenu, Boolean, Int> =
        MethodStringName1<PopupMenu, Boolean, Int>("is_item_checkable")

    @JvmField
    public val isItemRadioCheckableName: MethodStringName1<PopupMenu, Boolean, Int> =
        MethodStringName1<PopupMenu, Boolean, Int>("is_item_radio_checkable")

    @JvmField
    public val isItemShortcutDisabledName: MethodStringName1<PopupMenu, Boolean, Int> =
        MethodStringName1<PopupMenu, Boolean, Int>("is_item_shortcut_disabled")

    @JvmField
    public val getItemTooltipName: MethodStringName1<PopupMenu, String, Int> =
        MethodStringName1<PopupMenu, String, Int>("get_item_tooltip")

    @JvmField
    public val getItemShortcutName: MethodStringName1<PopupMenu, Shortcut?, Int> =
        MethodStringName1<PopupMenu, Shortcut?, Int>("get_item_shortcut")

    @JvmField
    public val getItemIndentName: MethodStringName1<PopupMenu, Int, Int> =
        MethodStringName1<PopupMenu, Int, Int>("get_item_indent")

    @JvmField
    public val getItemMultistateMaxName: MethodStringName1<PopupMenu, Int, Int> =
        MethodStringName1<PopupMenu, Int, Int>("get_item_multistate_max")

    @JvmField
    public val getItemMultistateName: MethodStringName1<PopupMenu, Int, Int> =
        MethodStringName1<PopupMenu, Int, Int>("get_item_multistate")

    @JvmField
    public val setFocusedItemName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("set_focused_item")

    @JvmField
    public val getFocusedItemName: MethodStringName0<PopupMenu, Int> =
        MethodStringName0<PopupMenu, Int>("get_focused_item")

    @JvmField
    public val setItemCountName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("set_item_count")

    @JvmField
    public val getItemCountName: MethodStringName0<PopupMenu, Int> =
        MethodStringName0<PopupMenu, Int>("get_item_count")

    @JvmField
    public val scrollToItemName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("scroll_to_item")

    @JvmField
    public val removeItemName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("remove_item")

    @JvmField
    public val addSeparatorName: MethodStringName2<PopupMenu, Unit, String, Int> =
        MethodStringName2<PopupMenu, Unit, String, Int>("add_separator")

    @JvmField
    public val clearName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("clear")

    @JvmField
    public val setHideOnItemSelectionName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_hide_on_item_selection")

    @JvmField
    public val isHideOnItemSelectionName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_hide_on_item_selection")

    @JvmField
    public val setHideOnCheckableItemSelectionName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_hide_on_checkable_item_selection")

    @JvmField
    public val isHideOnCheckableItemSelectionName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_hide_on_checkable_item_selection")

    @JvmField
    public val setHideOnStateItemSelectionName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_hide_on_state_item_selection")

    @JvmField
    public val isHideOnStateItemSelectionName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_hide_on_state_item_selection")

    @JvmField
    public val setSubmenuPopupDelayName: MethodStringName1<PopupMenu, Unit, Float> =
        MethodStringName1<PopupMenu, Unit, Float>("set_submenu_popup_delay")

    @JvmField
    public val getSubmenuPopupDelayName: MethodStringName0<PopupMenu, Float> =
        MethodStringName0<PopupMenu, Float>("get_submenu_popup_delay")

    @JvmField
    public val setAllowSearchName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_allow_search")

    @JvmField
    public val getAllowSearchName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("get_allow_search")

    @JvmField
    public val isSystemMenuName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_system_menu")

    @JvmField
    public val setSystemMenuName: MethodStringName1<PopupMenu, Unit, NativeMenu.SystemMenus> =
        MethodStringName1<PopupMenu, Unit, NativeMenu.SystemMenus>("set_system_menu")

    @JvmField
    public val getSystemMenuName: MethodStringName0<PopupMenu, NativeMenu.SystemMenus> =
        MethodStringName0<PopupMenu, NativeMenu.SystemMenus>("get_system_menu")

    @JvmField
    public val setSearchBarEnabledName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_search_bar_enabled")

    @JvmField
    public val isSearchBarEnabledName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_search_bar_enabled")

    @JvmField
    public val setSearchBarMinItemCountName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("set_search_bar_min_item_count")

    @JvmField
    public val getSearchBarMinItemCountName: MethodStringName0<PopupMenu, Int> =
        MethodStringName0<PopupMenu, Int>("get_search_bar_min_item_count")

    @JvmField
    public val setSearchBarFuzzySearchEnabledName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_search_bar_fuzzy_search_enabled")

    @JvmField
    public val isSearchBarFuzzySearchEnabledName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("is_search_bar_fuzzy_search_enabled")

    @JvmField
    public val setSearchBarFuzzySearchMaxMissesName: MethodStringName1<PopupMenu, Unit, Int> =
        MethodStringName1<PopupMenu, Unit, Int>("set_search_bar_fuzzy_search_max_misses")

    @JvmField
    public val getSearchBarFuzzySearchMaxMissesName: MethodStringName0<PopupMenu, Int> =
        MethodStringName0<PopupMenu, Int>("get_search_bar_fuzzy_search_max_misses")

    @JvmField
    public val setShrinkHeightName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_shrink_height")

    @JvmField
    public val getShrinkHeightName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("get_shrink_height")

    @JvmField
    public val setShrinkWidthName: MethodStringName1<PopupMenu, Unit, Boolean> =
        MethodStringName1<PopupMenu, Unit, Boolean>("set_shrink_width")

    @JvmField
    public val getShrinkWidthName: MethodStringName0<PopupMenu, Boolean> =
        MethodStringName0<PopupMenu, Boolean>("get_shrink_width")
  }

  public object MethodBindings {
    internal val activateItemByEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "activate_item_by_event", 3716412023)

    internal val setPreferNativeMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_prefer_native_menu", 2586408642)

    internal val isPreferNativeMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_prefer_native_menu", 36873697)

    internal val isNativeMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_native_menu", 36873697)

    internal val addItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_item", 3674230041)

    internal val addIconItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_icon_item", 1086190128)

    internal val addCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_check_item", 3674230041)

    internal val addIconCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_icon_check_item", 1086190128)

    internal val addRadioCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_radio_check_item", 3674230041)

    internal val addIconRadioCheckItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_icon_radio_check_item", 1086190128)

    internal val addMultistateItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_multistate_item", 150780458)

    internal val addShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_shortcut", 3451850107)

    internal val addIconShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_icon_shortcut", 2997871092)

    internal val addCheckShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_check_shortcut", 1642193386)

    internal val addIconCheckShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_icon_check_shortcut", 3856247530)

    internal val addRadioCheckShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_radio_check_shortcut", 1642193386)

    internal val addIconRadioCheckShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_icon_radio_check_shortcut", 3856247530)

    internal val addSubmenuItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_submenu_item", 2979222410)

    internal val addSubmenuNodeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_submenu_node_item", 1325455216)

    internal val setItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_text", 501894301)

    internal val setItemTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_text_direction", 1707680378)

    internal val setItemLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_language", 501894301)

    internal val setItemAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_auto_translate_mode", 287402019)

    internal val setItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_icon", 666127730)

    internal val setItemIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_icon_max_width", 3937882851)

    internal val setItemIconModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_icon_modulate", 2878471219)

    internal val setItemCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_checked", 300928843)

    internal val setItemIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_id", 3937882851)

    internal val setItemAcceleratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_accelerator", 2992817551)

    internal val setItemMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_metadata", 2152698145)

    internal val setItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_disabled", 300928843)

    internal val setItemSubmenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_submenu", 501894301)

    internal val setItemSubmenuNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_submenu_node", 1068370740)

    internal val setItemAsSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_as_separator", 300928843)

    internal val setItemAsCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_as_checkable", 300928843)

    internal val setItemAsRadioCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_as_radio_checkable", 300928843)

    internal val setItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_tooltip", 501894301)

    internal val setItemShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_shortcut", 825127832)

    internal val setItemIndentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_indent", 3937882851)

    internal val setItemMultistatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_multistate", 3937882851)

    internal val setItemMultistateMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_multistate_max", 3937882851)

    internal val setItemShortcutDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_shortcut_disabled", 300928843)

    internal val setItemIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_index", 3937882851)

    internal val toggleItemCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "toggle_item_checked", 1286410249)

    internal val toggleItemMultistatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "toggle_item_multistate", 1286410249)

    internal val getItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_text", 844755477)

    internal val getItemTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_text_direction", 4235602388)

    internal val getItemLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_language", 844755477)

    internal val getItemAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_auto_translate_mode", 906302372)

    internal val getItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_icon", 3536238170)

    internal val getItemIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_icon_max_width", 923996154)

    internal val getItemIconModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_icon_modulate", 3457211756)

    internal val isItemCheckedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_item_checked", 1116898809)

    internal val getItemIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_id", 923996154)

    internal val getItemIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_index", 923996154)

    internal val getItemAcceleratorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_accelerator", 253789942)

    internal val getItemMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_metadata", 4227898402)

    internal val isItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_item_disabled", 1116898809)

    internal val getItemSubmenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_submenu", 844755477)

    internal val getItemSubmenuNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_submenu_node", 2100501353)

    internal val isItemSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_item_separator", 1116898809)

    internal val isItemCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_item_checkable", 1116898809)

    internal val isItemRadioCheckablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_item_radio_checkable", 1116898809)

    internal val isItemShortcutDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_item_shortcut_disabled", 1116898809)

    internal val getItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_tooltip", 844755477)

    internal val getItemShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_shortcut", 1449483325)

    internal val getItemIndentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_indent", 923996154)

    internal val getItemMultistateMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_multistate_max", 923996154)

    internal val getItemMultistatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_multistate", 923996154)

    internal val setFocusedItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_focused_item", 1286410249)

    internal val getFocusedItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_focused_item", 3905245786)

    internal val setItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_item_count", 1286410249)

    internal val getItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_item_count", 3905245786)

    internal val scrollToItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "scroll_to_item", 1286410249)

    internal val removeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "remove_item", 1286410249)

    internal val addSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "add_separator", 2266703459)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("PopupMenu", "clear", 107499316)

    internal val setHideOnItemSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_hide_on_item_selection", 2586408642)

    internal val isHideOnItemSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_hide_on_item_selection", 36873697)

    internal val setHideOnCheckableItemSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_hide_on_checkable_item_selection", 2586408642)

    internal val isHideOnCheckableItemSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_hide_on_checkable_item_selection", 36873697)

    internal val setHideOnStateItemSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_hide_on_state_item_selection", 2586408642)

    internal val isHideOnStateItemSelectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_hide_on_state_item_selection", 36873697)

    internal val setSubmenuPopupDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_submenu_popup_delay", 373806689)

    internal val getSubmenuPopupDelayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_submenu_popup_delay", 1740695150)

    internal val setAllowSearchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_allow_search", 2586408642)

    internal val getAllowSearchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_allow_search", 36873697)

    internal val isSystemMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_system_menu", 36873697)

    internal val setSystemMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_system_menu", 600639674)

    internal val getSystemMenuPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_system_menu", 1222557358)

    internal val setSearchBarEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_search_bar_enabled", 2586408642)

    internal val isSearchBarEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_search_bar_enabled", 36873697)

    internal val setSearchBarMinItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_search_bar_min_item_count", 1286410249)

    internal val getSearchBarMinItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_search_bar_min_item_count", 3905245786)

    internal val setSearchBarFuzzySearchEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_search_bar_fuzzy_search_enabled", 2586408642)

    internal val isSearchBarFuzzySearchEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "is_search_bar_fuzzy_search_enabled", 36873697)

    internal val setSearchBarFuzzySearchMaxMissesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_search_bar_fuzzy_search_max_misses", 1286410249)

    internal val getSearchBarFuzzySearchMaxMissesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_search_bar_fuzzy_search_max_misses", 3905245786)

    internal val setShrinkHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_shrink_height", 2586408642)

    internal val getShrinkHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_shrink_height", 36873697)

    internal val setShrinkWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "set_shrink_width", 2586408642)

    internal val getShrinkWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("PopupMenu", "get_shrink_width", 36873697)
  }
}
