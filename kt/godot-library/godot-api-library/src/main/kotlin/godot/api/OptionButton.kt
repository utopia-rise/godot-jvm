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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.Signal1
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * [OptionButton] is a type of button that brings up a dropdown with selectable items when pressed.
 * The item selected becomes the "current" item and is displayed as the button text.
 *
 * See also [BaseButton] which contains common properties and methods associated with this node.
 *
 * **Note:** The IDs used for items are limited to signed 32-bit integers, not the full 64 bits of
 * [Long]. These have a range of `-2^31` to `2^31 - 1`, that is, `-2147483648` to `2147483647`.
 *
 * **Note:** The [Button.text] and [Button.icon] properties are set automatically based on the
 * selected item. They shouldn't be changed manually.
 */
@GodotBaseType
public open class OptionButton : Button() {
  /**
   * Emitted when the current item has been changed by the user. The index of the item selected is
   * passed as argument.
   *
   * [allowReselect] must be enabled to reselect an item.
   */
  public val itemSelected: Signal1<Long> by Signal1

  /**
   * Emitted when the user navigates to an item using the [ProjectSettings.input/uiUp] or
   * [ProjectSettings.input/uiDown] input actions. The index of the item focused is passed as argument.
   */
  public val itemFocused: Signal1<Long> by Signal1

  /**
   * The index of the currently selected item, or `-1` if no item is selected.
   */
  public final inline val selected: Int
    @JvmName("selectedProperty")
    get() = getSelected()

  /**
   * If `true`, minimum size will be determined by the longest item's width, instead of the
   * currently selected one's. It will also take the popup's margins into account, making the button
   * match its total width.
   *
   * **Note:** For performance reasons, the minimum size doesn't update immediately when adding,
   * removing or modifying items.
   */
  public final inline var fitToLongestItem: Boolean
    @JvmName("fitToLongestItemProperty")
    get() = isFitToLongestItem()
    @JvmName("fitToLongestItemProperty")
    set(`value`) {
      setFitToLongestItem(value)
    }

  /**
   * If `true`, the currently selected item can be selected again.
   */
  public final inline var allowReselect: Boolean
    @JvmName("allowReselectProperty")
    get() = getAllowReselect()
    @JvmName("allowReselectProperty")
    set(`value`) {
      setAllowReselect(value)
    }

  /**
   * If `true`, shows a search bar at the top of the [PopupMenu] for filtering items. See
   * [searchBarMinItemCount] for dynamically controlling its visibility based on the number of items.
   */
  public final inline var searchBarEnabled: Boolean
    @JvmName("searchBarEnabledProperty")
    get() = isSearchBarEnabled()
    @JvmName("searchBarEnabledProperty")
    set(`value`) {
      setSearchBarEnabled(value)
    }

  /**
   * Sets the minimum number of items required for the [PopupMenu] search bar to be visible.
   * [searchBarEnabled] must be `true` for this to have any effect.
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
   * The number of items to select from.
   */
  public final inline var itemCount: Int
    @JvmName("itemCountProperty")
    get() = getItemCount()
    @JvmName("itemCountProperty")
    set(`value`) {
      setItemCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(498, scriptPtr)
  }

  /**
   * Adds an item, with text [label] and (optionally) [id]. If no [id] is passed, the item index
   * will be used as the item's ID. New items are appended at the end.
   *
   * **Note:** The item will be selected if there are no other items.
   */
  @JvmOverloads
  public final fun addItem(label: String, id: Int = -1): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to label, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.addItemPtr)
  }

  /**
   * Adds an item, with a [texture] icon, text [label] and (optionally) [id]. If no [id] is passed,
   * the item index will be used as the item's ID. New items are appended at the end.
   *
   * **Note:** The item will be selected if there are no other items.
   */
  @JvmOverloads
  public final fun addIconItem(
    texture: Texture2D?,
    label: String,
    id: Int = -1,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to texture, STRING to label, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.addIconItemPtr)
  }

  /**
   * Sets the text of the item at index [idx].
   */
  public final fun setItemText(idx: Int, text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), STRING to text)
    TransferContext.callMethod(MethodBindings.setItemTextPtr)
  }

  /**
   * Sets the icon of the item at index [idx].
   */
  public final fun setItemIcon(idx: Int, texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), OBJECT to texture)
    TransferContext.callMethod(MethodBindings.setItemIconPtr)
  }

  /**
   * Sets whether the item at index [idx] is disabled.
   *
   * Disabled items are drawn differently in the dropdown and are not selectable by the user. If the
   * current selected item is set as disabled, it will remain selected.
   */
  public final fun setItemDisabled(idx: Int, disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setItemDisabledPtr)
  }

  /**
   * Sets the ID of the item at index [idx].
   */
  public final fun setItemId(idx: Int, id: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.setItemIdPtr)
  }

  /**
   * Sets the metadata of an item. Metadata may be of any type and can be used to store extra
   * information about an item, such as an external string ID.
   */
  public final fun setItemMetadata(idx: Int, metadata: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), ANY to metadata)
    TransferContext.callMethod(MethodBindings.setItemMetadataPtr)
  }

  /**
   * Sets the tooltip of the item at index [idx].
   */
  public final fun setItemTooltip(idx: Int, tooltip: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), STRING to tooltip)
    TransferContext.callMethod(MethodBindings.setItemTooltipPtr)
  }

  /**
   * Sets the auto translate mode of the item at index [idx].
   *
   * Items use [Node.AUTO_TRANSLATE_MODE_INHERIT] by default, which uses the same auto translate
   * mode as the [OptionButton] itself.
   */
  public final fun setItemAutoTranslateMode(idx: Int, mode: Node.AutoTranslateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setItemAutoTranslateModePtr)
  }

  public final fun setSearchBarEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setSearchBarEnabledPtr)
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

  /**
   * Returns the text of the item at index [idx].
   */
  public final fun getItemText(idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the icon of the item at index [idx].
   */
  public final fun getItemIcon(idx: Int): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Returns the ID of the item at index [idx].
   */
  public final fun getItemId(idx: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the index of the item with the given [id].
   */
  public final fun getItemIndex(id: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to id.toLong())
    TransferContext.callMethod(MethodBindings.getItemIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Retrieves the metadata of an item. Metadata may be any type and can be used to store extra
   * information about an item, such as an external string ID.
   */
  public final fun getItemMetadata(idx: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemMetadataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the tooltip of the item at index [idx].
   */
  public final fun getItemTooltip(idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTooltipPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the auto translate mode of the item at index [idx].
   */
  public final fun getItemAutoTranslateMode(idx: Int): Node.AutoTranslateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemAutoTranslateModePtr)
    return Node.AutoTranslateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the item at index [idx] is disabled.
   */
  public final fun isItemDisabled(idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the item at index [idx] is marked as a separator.
   */
  public final fun isItemSeparator(idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemSeparatorPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun isSearchBarEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSearchBarEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Adds a separator to the list of items. Separators help to group items, and can optionally be
   * given a [text] header. A separator also gets an index assigned, and is appended at the end of the
   * item list.
   */
  @JvmOverloads
  public final fun addSeparator(text: String = ""): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text)
    TransferContext.callMethod(MethodBindings.addSeparatorPtr)
  }

  /**
   * Clears all the items in the [OptionButton].
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Selects an item by index and makes it the current item. This will work even if the item is
   * disabled.
   *
   * Passing `-1` as the index deselects any currently selected item.
   */
  public final fun select(idx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.selectPtr)
  }

  public final fun getSelected(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the ID of the selected item, or `-1` if no item is selected.
   */
  public final fun getSelectedId(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Gets the metadata of the selected item. Metadata for items can be set using [setItemMetadata].
   */
  public final fun getSelectedMetadata(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedMetadataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Removes the item at index [idx].
   */
  public final fun removeItem(idx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.removeItemPtr)
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
   * Adjusts popup position and sizing for the [OptionButton], then shows the [PopupMenu]. Prefer
   * this over using `get_popup().popup()`.
   */
  public final fun showPopup(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.showPopupPtr)
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
   * Returns `true` if this button contains at least one item which is not disabled, or marked as a
   * separator.
   */
  public final fun hasSelectableItems(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasSelectableItemsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the index of the first item which is not disabled, or marked as a separator. If
   * [fromLast] is `true`, the items will be searched in reverse order.
   *
   * Returns `-1` if no item is found.
   */
  @JvmOverloads
  public final fun getSelectableItem(fromLast: Boolean = false): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to fromLast)
    TransferContext.callMethod(MethodBindings.getSelectableItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setFitToLongestItem(fit: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to fit)
    TransferContext.callMethod(MethodBindings.setFitToLongestItemPtr)
  }

  public final fun isFitToLongestItem(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFitToLongestItemPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAllowReselect(allow: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to allow)
    TransferContext.callMethod(MethodBindings.setAllowReselectPtr)
  }

  public final fun getAllowReselect(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllowReselectPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If `true`, shortcuts are disabled and cannot be used to trigger the button.
   */
  public final fun setDisableShortcuts(disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setDisableShortcutsPtr)
  }

  public companion object {
    @JvmField
    public val addItemName: MethodStringName2<OptionButton, Unit, String, Int> =
        MethodStringName2<OptionButton, Unit, String, Int>("add_item")

    @JvmField
    public val addIconItemName: MethodStringName3<OptionButton, Unit, Texture2D?, String, Int> =
        MethodStringName3<OptionButton, Unit, Texture2D?, String, Int>("add_icon_item")

    @JvmField
    public val setItemTextName: MethodStringName2<OptionButton, Unit, Int, String> =
        MethodStringName2<OptionButton, Unit, Int, String>("set_item_text")

    @JvmField
    public val setItemIconName: MethodStringName2<OptionButton, Unit, Int, Texture2D?> =
        MethodStringName2<OptionButton, Unit, Int, Texture2D?>("set_item_icon")

    @JvmField
    public val setItemDisabledName: MethodStringName2<OptionButton, Unit, Int, Boolean> =
        MethodStringName2<OptionButton, Unit, Int, Boolean>("set_item_disabled")

    @JvmField
    public val setItemIdName: MethodStringName2<OptionButton, Unit, Int, Int> =
        MethodStringName2<OptionButton, Unit, Int, Int>("set_item_id")

    @JvmField
    public val setItemMetadataName: MethodStringName2<OptionButton, Unit, Int, Any?> =
        MethodStringName2<OptionButton, Unit, Int, Any?>("set_item_metadata")

    @JvmField
    public val setItemTooltipName: MethodStringName2<OptionButton, Unit, Int, String> =
        MethodStringName2<OptionButton, Unit, Int, String>("set_item_tooltip")

    @JvmField
    public val setItemAutoTranslateModeName:
        MethodStringName2<OptionButton, Unit, Int, Node.AutoTranslateMode> =
        MethodStringName2<OptionButton, Unit, Int, Node.AutoTranslateMode>("set_item_auto_translate_mode")

    @JvmField
    public val setSearchBarEnabledName: MethodStringName1<OptionButton, Unit, Boolean> =
        MethodStringName1<OptionButton, Unit, Boolean>("set_search_bar_enabled")

    @JvmField
    public val setSearchBarMinItemCountName: MethodStringName1<OptionButton, Unit, Int> =
        MethodStringName1<OptionButton, Unit, Int>("set_search_bar_min_item_count")

    @JvmField
    public val getSearchBarMinItemCountName: MethodStringName0<OptionButton, Int> =
        MethodStringName0<OptionButton, Int>("get_search_bar_min_item_count")

    @JvmField
    public val setSearchBarFuzzySearchEnabledName: MethodStringName1<OptionButton, Unit, Boolean> =
        MethodStringName1<OptionButton, Unit, Boolean>("set_search_bar_fuzzy_search_enabled")

    @JvmField
    public val isSearchBarFuzzySearchEnabledName: MethodStringName0<OptionButton, Boolean> =
        MethodStringName0<OptionButton, Boolean>("is_search_bar_fuzzy_search_enabled")

    @JvmField
    public val setSearchBarFuzzySearchMaxMissesName: MethodStringName1<OptionButton, Unit, Int> =
        MethodStringName1<OptionButton, Unit, Int>("set_search_bar_fuzzy_search_max_misses")

    @JvmField
    public val getSearchBarFuzzySearchMaxMissesName: MethodStringName0<OptionButton, Int> =
        MethodStringName0<OptionButton, Int>("get_search_bar_fuzzy_search_max_misses")

    @JvmField
    public val getItemTextName: MethodStringName1<OptionButton, String, Int> =
        MethodStringName1<OptionButton, String, Int>("get_item_text")

    @JvmField
    public val getItemIconName: MethodStringName1<OptionButton, Texture2D?, Int> =
        MethodStringName1<OptionButton, Texture2D?, Int>("get_item_icon")

    @JvmField
    public val getItemIdName: MethodStringName1<OptionButton, Int, Int> =
        MethodStringName1<OptionButton, Int, Int>("get_item_id")

    @JvmField
    public val getItemIndexName: MethodStringName1<OptionButton, Int, Int> =
        MethodStringName1<OptionButton, Int, Int>("get_item_index")

    @JvmField
    public val getItemMetadataName: MethodStringName1<OptionButton, Any?, Int> =
        MethodStringName1<OptionButton, Any?, Int>("get_item_metadata")

    @JvmField
    public val getItemTooltipName: MethodStringName1<OptionButton, String, Int> =
        MethodStringName1<OptionButton, String, Int>("get_item_tooltip")

    @JvmField
    public val getItemAutoTranslateModeName:
        MethodStringName1<OptionButton, Node.AutoTranslateMode, Int> =
        MethodStringName1<OptionButton, Node.AutoTranslateMode, Int>("get_item_auto_translate_mode")

    @JvmField
    public val isItemDisabledName: MethodStringName1<OptionButton, Boolean, Int> =
        MethodStringName1<OptionButton, Boolean, Int>("is_item_disabled")

    @JvmField
    public val isItemSeparatorName: MethodStringName1<OptionButton, Boolean, Int> =
        MethodStringName1<OptionButton, Boolean, Int>("is_item_separator")

    @JvmField
    public val isSearchBarEnabledName: MethodStringName0<OptionButton, Boolean> =
        MethodStringName0<OptionButton, Boolean>("is_search_bar_enabled")

    @JvmField
    public val addSeparatorName: MethodStringName1<OptionButton, Unit, String> =
        MethodStringName1<OptionButton, Unit, String>("add_separator")

    @JvmField
    public val clearName: MethodStringName0<OptionButton, Unit> =
        MethodStringName0<OptionButton, Unit>("clear")

    @JvmField
    public val selectName: MethodStringName1<OptionButton, Unit, Int> =
        MethodStringName1<OptionButton, Unit, Int>("select")

    @JvmField
    public val getSelectedName: MethodStringName0<OptionButton, Int> =
        MethodStringName0<OptionButton, Int>("get_selected")

    @JvmField
    public val getSelectedIdName: MethodStringName0<OptionButton, Int> =
        MethodStringName0<OptionButton, Int>("get_selected_id")

    @JvmField
    public val getSelectedMetadataName: MethodStringName0<OptionButton, Any?> =
        MethodStringName0<OptionButton, Any?>("get_selected_metadata")

    @JvmField
    public val removeItemName: MethodStringName1<OptionButton, Unit, Int> =
        MethodStringName1<OptionButton, Unit, Int>("remove_item")

    @JvmField
    public val getPopupName: MethodStringName0<OptionButton, PopupMenu?> =
        MethodStringName0<OptionButton, PopupMenu?>("get_popup")

    @JvmField
    public val showPopupName: MethodStringName0<OptionButton, Unit> =
        MethodStringName0<OptionButton, Unit>("show_popup")

    @JvmField
    public val setItemCountName: MethodStringName1<OptionButton, Unit, Int> =
        MethodStringName1<OptionButton, Unit, Int>("set_item_count")

    @JvmField
    public val getItemCountName: MethodStringName0<OptionButton, Int> =
        MethodStringName0<OptionButton, Int>("get_item_count")

    @JvmField
    public val hasSelectableItemsName: MethodStringName0<OptionButton, Boolean> =
        MethodStringName0<OptionButton, Boolean>("has_selectable_items")

    @JvmField
    public val getSelectableItemName: MethodStringName1<OptionButton, Int, Boolean> =
        MethodStringName1<OptionButton, Int, Boolean>("get_selectable_item")

    @JvmField
    public val setFitToLongestItemName: MethodStringName1<OptionButton, Unit, Boolean> =
        MethodStringName1<OptionButton, Unit, Boolean>("set_fit_to_longest_item")

    @JvmField
    public val isFitToLongestItemName: MethodStringName0<OptionButton, Boolean> =
        MethodStringName0<OptionButton, Boolean>("is_fit_to_longest_item")

    @JvmField
    public val setAllowReselectName: MethodStringName1<OptionButton, Unit, Boolean> =
        MethodStringName1<OptionButton, Unit, Boolean>("set_allow_reselect")

    @JvmField
    public val getAllowReselectName: MethodStringName0<OptionButton, Boolean> =
        MethodStringName0<OptionButton, Boolean>("get_allow_reselect")

    @JvmField
    public val setDisableShortcutsName: MethodStringName1<OptionButton, Unit, Boolean> =
        MethodStringName1<OptionButton, Unit, Boolean>("set_disable_shortcuts")
  }

  public object MethodBindings {
    internal val addItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "add_item", 2697778442)

    internal val addIconItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "add_icon_item", 3781678508)

    internal val setItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_text", 501894301)

    internal val setItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_icon", 666127730)

    internal val setItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_disabled", 300928843)

    internal val setItemIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_id", 3937882851)

    internal val setItemMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_metadata", 2152698145)

    internal val setItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_tooltip", 501894301)

    internal val setItemAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_auto_translate_mode", 287402019)

    internal val setSearchBarEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_search_bar_enabled", 2586408642)

    internal val setSearchBarMinItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_search_bar_min_item_count", 1286410249)

    internal val getSearchBarMinItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_search_bar_min_item_count", 3905245786)

    internal val setSearchBarFuzzySearchEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_search_bar_fuzzy_search_enabled", 2586408642)

    internal val isSearchBarFuzzySearchEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "is_search_bar_fuzzy_search_enabled", 36873697)

    internal val setSearchBarFuzzySearchMaxMissesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_search_bar_fuzzy_search_max_misses", 1286410249)

    internal val getSearchBarFuzzySearchMaxMissesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_search_bar_fuzzy_search_max_misses", 3905245786)

    internal val getItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_text", 844755477)

    internal val getItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_icon", 3536238170)

    internal val getItemIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_id", 923996154)

    internal val getItemIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_index", 923996154)

    internal val getItemMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_metadata", 4227898402)

    internal val getItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_tooltip", 844755477)

    internal val getItemAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_auto_translate_mode", 906302372)

    internal val isItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "is_item_disabled", 1116898809)

    internal val isItemSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "is_item_separator", 1116898809)

    internal val isSearchBarEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "is_search_bar_enabled", 36873697)

    internal val addSeparatorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "add_separator", 3005725572)

    internal val clearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "clear", 3218959716)

    internal val selectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "select", 1286410249)

    internal val getSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_selected", 3905245786)

    internal val getSelectedIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_selected_id", 3905245786)

    internal val getSelectedMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_selected_metadata", 1214101251)

    internal val removeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "remove_item", 1286410249)

    internal val getPopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_popup", 229722558)

    internal val showPopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "show_popup", 3218959716)

    internal val setItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_item_count", 1286410249)

    internal val getItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_item_count", 3905245786)

    internal val hasSelectableItemsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "has_selectable_items", 36873697)

    internal val getSelectableItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_selectable_item", 894402480)

    internal val setFitToLongestItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_fit_to_longest_item", 2586408642)

    internal val isFitToLongestItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "is_fit_to_longest_item", 36873697)

    internal val setAllowReselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_allow_reselect", 2586408642)

    internal val getAllowReselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "get_allow_reselect", 36873697)

    internal val setDisableShortcutsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OptionButton", "set_disable_shortcuts", 2586408642)
  }
}
