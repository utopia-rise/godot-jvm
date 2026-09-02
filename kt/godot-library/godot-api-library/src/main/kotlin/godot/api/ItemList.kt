// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.Color
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedInt32Array
import godot.core.Rect2
import godot.core.Signal1
import godot.core.Signal2
import godot.core.Signal3
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_32_ARRAY
import godot.core.VariantParser.RECT2
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR2I
import godot.core.Vector2
import godot.core.Vector2i
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
 * This control provides a vertical list of selectable items that may be in a single or in multiple
 * columns, with each item having options for text and an icon. Tooltips are supported and may be
 * different for every item in the list.
 *
 * Selectable items in the list may be selected or deselected and multiple selection may be enabled.
 * Selection with right mouse button may also be enabled to allow use of popup context menus. Items may
 * also be "activated" by double-clicking them or by pressing [kbd]Enter[/kbd].
 *
 * Item text only supports single-line strings. Newline characters (e.g. `\n`) in the string won't
 * produce a newline. Text wrapping is enabled in [ICON_MODE_TOP] mode, but the column's width is
 * adjusted to fully fit its content by default. You need to set [fixedColumnWidth] greater than zero
 * to wrap the text.
 *
 * All `set_*` methods allow negative item indices, i.e. `-1` to access the last item, `-2` to
 * select the second-to-last item, and so on.
 *
 * **Incremental search:** Like [PopupMenu] and [Tree], [ItemList] supports searching within the
 * list while the control is focused. Press a key that matches the first letter of an item's name to
 * select the first item starting with the given letter. After that point, there are two ways to
 * perform incremental search: 1) Press the same key again before the timeout duration to select the
 * next item starting with the same letter. 2) Press letter keys that match the rest of the word before
 * the timeout duration to match to select the item in question directly. Both of these actions will be
 * reset to the beginning of the list if the timeout duration has passed since the last keystroke was
 * registered. You can adjust the timeout duration by changing
 * [ProjectSettings.gui/timers/incrementalSearchMaxIntervalMsec].
 */
@GodotBaseType
public open class ItemList : Control() {
  /**
   * Emitted when specified item has been selected. Only applicable in single selection mode.
   *
   * [allowReselect] must be enabled to reselect an item.
   */
  public val itemSelected: Signal1<Long> by Signal1

  /**
   * Emitted when any mouse click is issued within the rect of the list but on empty space.
   *
   * [atPosition] is the click position in this control's local coordinate system.
   */
  public val emptyClicked: Signal2<Vector2, Long> by Signal2

  /**
   * Emitted when specified list item has been clicked with any mouse button.
   *
   * [atPosition] is the click position in this control's local coordinate system.
   */
  public val itemClicked: Signal3<Long, Vector2, Long> by Signal3

  /**
   * Emitted when a multiple selection is altered on a list allowing multiple selection.
   */
  public val multiSelected: Signal2<Long, Boolean> by Signal2

  /**
   * Emitted when specified list item is activated via double-clicking or by pressing
   * [kbd]Enter[/kbd].
   */
  public val itemActivated: Signal1<Long> by Signal1

  /**
   * Allows single or multiple item selection. See the [SelectMode] constants.
   */
  public final inline var selectMode: SelectMode
    @JvmName("selectModeProperty")
    get() = getSelectMode()
    @JvmName("selectModeProperty")
    set(`value`) {
      setSelectMode(value)
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
   * If `true`, right mouse button click can select items.
   */
  public final inline var allowRmbSelect: Boolean
    @JvmName("allowRmbSelectProperty")
    get() = getAllowRmbSelect()
    @JvmName("allowRmbSelectProperty")
    set(`value`) {
      setAllowRmbSelect(value)
    }

  /**
   * If `true`, allows navigating the [ItemList] with letter keys through incremental search.
   */
  public final inline var allowSearch: Boolean
    @JvmName("allowSearchProperty")
    get() = getAllowSearch()
    @JvmName("allowSearchProperty")
    set(`value`) {
      setAllowSearch(value)
    }

  /**
   * Maximum lines of text allowed in each item. Space will be reserved even when there is not
   * enough lines of text to display.
   *
   * **Note:** This property takes effect only when [iconMode] is [ICON_MODE_TOP]. To make the text
   * wrap, [fixedColumnWidth] should be greater than zero.
   */
  public final inline var maxTextLines: Int
    @JvmName("maxTextLinesProperty")
    get() = getMaxTextLines()
    @JvmName("maxTextLinesProperty")
    set(`value`) {
      setMaxTextLines(value)
    }

  /**
   * If `true`, the control will automatically resize the width to fit its content.
   */
  public final inline var autoWidth: Boolean
    @JvmName("autoWidthProperty")
    get() = hasAutoWidth()
    @JvmName("autoWidthProperty")
    set(`value`) {
      setAutoWidth(value)
    }

  /**
   * If `true`, the control will automatically resize the height to fit its content.
   */
  public final inline var autoHeight: Boolean
    @JvmName("autoHeightProperty")
    get() = hasAutoHeight()
    @JvmName("autoHeightProperty")
    set(`value`) {
      setAutoHeight(value)
    }

  /**
   * The clipping behavior when the text exceeds an item's bounding rectangle.
   */
  public final inline var textOverrunBehavior: TextServer.OverrunBehavior
    @JvmName("textOverrunBehaviorProperty")
    get() = getTextOverrunBehavior()
    @JvmName("textOverrunBehaviorProperty")
    set(`value`) {
      setTextOverrunBehavior(value)
    }

  /**
   * If `true`, the control will automatically move items into a new row to fit its content. See
   * also [HFlowContainer] for this behavior.
   *
   * If `false`, the control will add a horizontal scrollbar to make all items visible.
   */
  public final inline var wraparoundItems: Boolean
    @JvmName("wraparoundItemsProperty")
    get() = hasWraparoundItems()
    @JvmName("wraparoundItemsProperty")
    set(`value`) {
      setWraparoundItems(value)
    }

  /**
   * The way which scroll hints (indicators that show that the content can still be scrolled in a
   * certain direction) will be shown.
   */
  public final inline var scrollHintMode: ScrollHintMode
    @JvmName("scrollHintModeProperty")
    get() = getScrollHintMode()
    @JvmName("scrollHintModeProperty")
    set(`value`) {
      setScrollHintMode(value)
    }

  /**
   * If `true`, the scroll hint texture will be tiled instead of stretched. See [scrollHintMode].
   */
  public final inline var tileScrollHint: Boolean
    @JvmName("tileScrollHintProperty")
    get() = isScrollHintTiled()
    @JvmName("tileScrollHintProperty")
    set(`value`) {
      setTileScrollHint(value)
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

  /**
   * Maximum columns the list will have.
   *
   * If greater than zero, the content will be split among the specified columns.
   *
   * A value of zero means unlimited columns, i.e. all items will be put in the same row.
   */
  public final inline var maxColumns: Int
    @JvmName("maxColumnsProperty")
    get() = getMaxColumns()
    @JvmName("maxColumnsProperty")
    set(`value`) {
      setMaxColumns(value)
    }

  /**
   * Whether all columns will have the same width.
   *
   * If `true`, the width is equal to the largest column width of all columns.
   */
  public final inline var sameColumnWidth: Boolean
    @JvmName("sameColumnWidthProperty")
    get() = isSameColumnWidth()
    @JvmName("sameColumnWidthProperty")
    set(`value`) {
      setSameColumnWidth(value)
    }

  /**
   * The width all columns will be adjusted to.
   *
   * A value of zero disables the adjustment, each item will have a width equal to the width of its
   * content and the columns will have an uneven width.
   */
  public final inline var fixedColumnWidth: Int
    @JvmName("fixedColumnWidthProperty")
    get() = getFixedColumnWidth()
    @JvmName("fixedColumnWidthProperty")
    set(`value`) {
      setFixedColumnWidth(value)
    }

  /**
   * The icon position, whether above or to the left of the text. See the [IconMode] constants.
   */
  public final inline var iconMode: IconMode
    @JvmName("iconModeProperty")
    get() = getIconMode()
    @JvmName("iconModeProperty")
    set(`value`) {
      setIconMode(value)
    }

  /**
   * The scale of icon applied after [fixedIconSize] and transposing takes effect.
   */
  public final inline var iconScale: Float
    @JvmName("iconScaleProperty")
    get() = getIconScale()
    @JvmName("iconScaleProperty")
    set(`value`) {
      setIconScale(value)
    }

  /**
   * The size all icons will be adjusted to.
   *
   * If either X or Y component is not greater than zero, icon size won't be affected.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var fixedIconSize: Vector2i
    @JvmName("fixedIconSizeProperty")
    get() = getFixedIconSize()
    @JvmName("fixedIconSizeProperty")
    set(`value`) {
      setFixedIconSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(330, scriptPtr)
  }

  /**
   * This is a helper function for [fixedIconSize] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = itemlist.fixedIconSize
   * //Your changes
   * itemlist.fixedIconSize = myCoreType
   * ``````
   *
   * The size all icons will be adjusted to.
   *
   * If either X or Y component is not greater than zero, icon size won't be affected.
   */
  @CoreTypeHelper
  public final fun fixedIconSizeMutate(block: Vector2i.() -> Unit): Vector2i = fixedIconSize.apply {
     block(this)
     fixedIconSize = this
  }

  /**
   * Adds an item to the item list with specified text. Returns the index of an added item.
   *
   * Specify an [icon], or use `null` as the [icon] for a list item with no icon.
   *
   * If [selectable] is `true`, the list item will be selectable.
   */
  @JvmOverloads
  public final fun addItem(
    text: String,
    icon: Texture2D? = null,
    selectable: Boolean = true,
  ): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to text, OBJECT to icon, BOOL to selectable)
    TransferContext.callMethod(MethodBindings.addItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Adds an item to the item list with no text, only an icon. Returns the index of an added item.
   */
  @JvmOverloads
  public final fun addIconItem(icon: Texture2D?, selectable: Boolean = true): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to icon, BOOL to selectable)
    TransferContext.callMethod(MethodBindings.addIconItemPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets text of the item associated with the specified index.
   */
  public final fun setItemText(idx: Int, text: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), STRING to text)
    TransferContext.callMethod(MethodBindings.setItemTextPtr)
  }

  /**
   * Returns the text associated with the specified index.
   */
  public final fun getItemText(idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets (or replaces) the icon's [Texture2D] associated with the specified index.
   */
  public final fun setItemIcon(idx: Int, icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), OBJECT to icon)
    TransferContext.callMethod(MethodBindings.setItemIconPtr)
  }

  /**
   * Returns the icon associated with the specified index.
   */
  public final fun getItemIcon(idx: Int): Texture2D? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconPtr)
    return (TransferContext.readReturnValue(OBJECT) as Texture2D?)
  }

  /**
   * Sets item's text base writing direction.
   */
  public final fun setItemTextDirection(idx: Int, direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), LONG to direction.value)
    TransferContext.callMethod(MethodBindings.setItemTextDirectionPtr)
  }

  /**
   * Returns item's text base writing direction.
   */
  public final fun getItemTextDirection(idx: Int): Control.TextDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTextDirectionPtr)
    return Control.TextDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the language code of the text for the item at the given index to [language]. This is used
   * for line-breaking and text shaping algorithms. If [language] is empty, the current locale is used.
   */
  public final fun setItemLanguage(idx: Int, language: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), STRING to language)
    TransferContext.callMethod(MethodBindings.setItemLanguagePtr)
  }

  /**
   * Returns item's text language code.
   */
  public final fun getItemLanguage(idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemLanguagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the auto translate mode of the item associated with the specified index.
   *
   * Items use [Node.AUTO_TRANSLATE_MODE_INHERIT] by default, which uses the same auto translate
   * mode as the [ItemList] itself.
   */
  public final fun setItemAutoTranslateMode(idx: Int, mode: Node.AutoTranslateMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setItemAutoTranslateModePtr)
  }

  /**
   * Returns item's auto translate mode.
   */
  public final fun getItemAutoTranslateMode(idx: Int): Node.AutoTranslateMode {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemAutoTranslateModePtr)
    return Node.AutoTranslateMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets whether the item icon will be drawn transposed.
   */
  public final fun setItemIconTransposed(idx: Int, transposed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), BOOL to transposed)
    TransferContext.callMethod(MethodBindings.setItemIconTransposedPtr)
  }

  /**
   * Returns `true` if the item icon will be drawn transposed, i.e. the X and Y axes are swapped.
   */
  public final fun isItemIconTransposed(idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemIconTransposedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the region of item's icon used. The whole icon will be used if the region has no area.
   */
  public final fun setItemIconRegion(idx: Int, rect: Rect2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), RECT2 to rect)
    TransferContext.callMethod(MethodBindings.setItemIconRegionPtr)
  }

  /**
   * Returns the region of item's icon used. The whole icon will be used if the region has no area.
   */
  public final fun getItemIconRegion(idx: Int): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconRegionPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Sets a modulating [Color] of the item associated with the specified index.
   */
  public final fun setItemIconModulate(idx: Int, modulate: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), COLOR to modulate)
    TransferContext.callMethod(MethodBindings.setItemIconModulatePtr)
  }

  /**
   * Returns a [Color] modulating item's icon at the specified index.
   */
  public final fun getItemIconModulate(idx: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemIconModulatePtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Allows or disallows selection of the item associated with the specified index.
   */
  public final fun setItemSelectable(idx: Int, selectable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), BOOL to selectable)
    TransferContext.callMethod(MethodBindings.setItemSelectablePtr)
  }

  /**
   * Returns `true` if the item at the specified index is selectable.
   */
  public final fun isItemSelectable(idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemSelectablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Disables (or enables) the item at the specified index.
   *
   * Disabled items cannot be selected and do not trigger activation signals (when double-clicking
   * or pressing [kbd]Enter[/kbd]).
   */
  public final fun setItemDisabled(idx: Int, disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setItemDisabledPtr)
  }

  /**
   * Returns `true` if the item at the specified index is disabled.
   */
  public final fun isItemDisabled(idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets a value (of any type) to be stored with the item associated with the specified index.
   */
  public final fun setItemMetadata(idx: Int, metadata: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), ANY to metadata)
    TransferContext.callMethod(MethodBindings.setItemMetadataPtr)
  }

  /**
   * Returns the metadata value of the specified index.
   */
  public final fun getItemMetadata(idx: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemMetadataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Sets the background color of the item specified by [idx] index to the specified [Color].
   */
  public final fun setItemCustomBgColor(idx: Int, customBgColor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), COLOR to customBgColor)
    TransferContext.callMethod(MethodBindings.setItemCustomBgColorPtr)
  }

  /**
   * Returns the custom background color of the item specified by [idx] index.
   */
  public final fun getItemCustomBgColor(idx: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemCustomBgColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Sets the foreground color of the item specified by [idx] index to the specified [Color].
   */
  public final fun setItemCustomFgColor(idx: Int, customFgColor: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), COLOR to customFgColor)
    TransferContext.callMethod(MethodBindings.setItemCustomFgColorPtr)
  }

  /**
   * Returns the custom foreground color of the item specified by [idx] index.
   */
  public final fun getItemCustomFgColor(idx: Int): Color {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemCustomFgColorPtr)
    return (TransferContext.readReturnValue(COLOR) as Color)
  }

  /**
   * Returns the position and size of the item with the specified index, in the coordinate system of
   * the [ItemList] node. If [expand] is `true` the last column expands to fill the rest of the row.
   *
   * **Note:** The returned value is unreliable if called right after modifying the [ItemList],
   * before it redraws in the next frame.
   */
  @JvmOverloads
  public final fun getItemRect(idx: Int, expand: Boolean = true): Rect2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), BOOL to expand)
    TransferContext.callMethod(MethodBindings.getItemRectPtr)
    return (TransferContext.readReturnValue(RECT2) as Rect2)
  }

  /**
   * Sets whether the tooltip hint is enabled for specified item index.
   */
  public final fun setItemTooltipEnabled(idx: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setItemTooltipEnabledPtr)
  }

  /**
   * Returns `true` if the tooltip is enabled for specified item index.
   */
  public final fun isItemTooltipEnabled(idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.isItemTooltipEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the tooltip hint for the item associated with the specified index.
   */
  public final fun setItemTooltip(idx: Int, tooltip: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), STRING to tooltip)
    TransferContext.callMethod(MethodBindings.setItemTooltipPtr)
  }

  /**
   * Returns the tooltip hint associated with the specified index.
   */
  public final fun getItemTooltip(idx: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getItemTooltipPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Selects the item at the specified index.
   *
   * **Note:** This method does not trigger the item selection signal.
   */
  @JvmOverloads
  public final fun select(idx: Int, single: Boolean = true): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong(), BOOL to single)
    TransferContext.callMethod(MethodBindings.selectPtr)
  }

  /**
   * Ensures the item associated with the specified index is not selected.
   */
  public final fun deselect(idx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.deselectPtr)
  }

  /**
   * Ensures there are no items selected.
   */
  public final fun deselectAll(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.deselectAllPtr)
  }

  /**
   * Returns `true` if the item at the specified index is currently selected.
   */
  public final fun isSelected(idx: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.isSelectedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns an array with the indexes of the selected items.
   */
  public final fun getSelectedItems(): PackedInt32Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedItemsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_32_ARRAY) as PackedInt32Array)
  }

  /**
   * Moves item from index [fromIdx] to [toIdx].
   */
  public final fun moveItem(fromIdx: Int, toIdx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to fromIdx.toLong(), LONG to toIdx.toLong())
    TransferContext.callMethod(MethodBindings.moveItemPtr)
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
   * Removes the item specified by [idx] index from the list.
   */
  public final fun removeItem(idx: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.removeItemPtr)
  }

  /**
   * Removes all items from the list.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Sorts items in the list by their text.
   */
  public final fun sortItemsByText(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.sortItemsByTextPtr)
  }

  public final fun setFixedColumnWidth(width: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to width.toLong())
    TransferContext.callMethod(MethodBindings.setFixedColumnWidthPtr)
  }

  public final fun getFixedColumnWidth(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFixedColumnWidthPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSameColumnWidth(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setSameColumnWidthPtr)
  }

  public final fun isSameColumnWidth(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isSameColumnWidthPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMaxTextLines(lines: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to lines.toLong())
    TransferContext.callMethod(MethodBindings.setMaxTextLinesPtr)
  }

  public final fun getMaxTextLines(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxTextLinesPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setMaxColumns(amount: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to amount.toLong())
    TransferContext.callMethod(MethodBindings.setMaxColumnsPtr)
  }

  public final fun getMaxColumns(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxColumnsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  public final fun setSelectMode(mode: SelectMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setSelectModePtr)
  }

  public final fun getSelectMode(): SelectMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectModePtr)
    return SelectMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setIconMode(mode: IconMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setIconModePtr)
  }

  public final fun getIconMode(): IconMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIconModePtr)
    return IconMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setFixedIconSize(size: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to size)
    TransferContext.callMethod(MethodBindings.setFixedIconSizePtr)
  }

  public final fun getFixedIconSize(): Vector2i {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFixedIconSizePtr)
    return (TransferContext.readReturnValue(VECTOR2I) as Vector2i)
  }

  public final fun setIconScale(scale: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale.toDouble())
    TransferContext.callMethod(MethodBindings.setIconScalePtr)
  }

  public final fun getIconScale(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIconScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setAllowRmbSelect(allow: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to allow)
    TransferContext.callMethod(MethodBindings.setAllowRmbSelectPtr)
  }

  public final fun getAllowRmbSelect(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllowRmbSelectPtr)
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

  public final fun setAllowSearch(allow: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to allow)
    TransferContext.callMethod(MethodBindings.setAllowSearchPtr)
  }

  public final fun getAllowSearch(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllowSearchPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoWidth(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoWidthPtr)
  }

  public final fun hasAutoWidth(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasAutoWidthPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setAutoHeight(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setAutoHeightPtr)
  }

  public final fun hasAutoHeight(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasAutoHeightPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if one or more items are selected.
   */
  public final fun isAnythingSelected(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAnythingSelectedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the item index at the given [position].
   *
   * When there is no item at that point, -1 will be returned if [exact] is `true`, and the closest
   * item index will be returned otherwise.
   *
   * **Note:** The returned value is unreliable if called right after modifying the [ItemList],
   * before it redraws in the next frame.
   */
  @JvmOverloads
  public final fun getItemAtPosition(position: Vector2, exact: Boolean = false): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position, BOOL to exact)
    TransferContext.callMethod(MethodBindings.getItemAtPositionPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Ensures the currently selected item (the first selected item if multiple selection is enabled)
   * is visible, adjusting the scroll position as necessary. See also [centerOnCurrent].
   */
  public final fun ensureCurrentIsVisible(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ensureCurrentIsVisiblePtr)
  }

  /**
   * Ensures the currently selected item (the first selected item if multiple selection is enabled)
   * is visible, adjusting the scroll position as necessary to place the item at the center of the list
   * if possible. See also [ensureCurrentIsVisible].
   *
   * Fails and prints an error if both arguments are `false`.
   */
  @JvmOverloads
  public final fun centerOnCurrent(centerVerically: Boolean = true, centerHorizontally: Boolean =
      true): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to centerVerically, BOOL to centerHorizontally)
    TransferContext.callMethod(MethodBindings.centerOnCurrentPtr)
  }

  /**
   * Returns the vertical scrollbar.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getVScrollBar(): VScrollBar? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVScrollBarPtr)
    return (TransferContext.readReturnValue(OBJECT) as VScrollBar?)
  }

  /**
   * Returns the horizontal scrollbar.
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [CanvasItem.visible] property.
   */
  public final fun getHScrollBar(): HScrollBar? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHScrollBarPtr)
    return (TransferContext.readReturnValue(OBJECT) as HScrollBar?)
  }

  public final fun setScrollHintMode(scrollHintMode: ScrollHintMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to scrollHintMode.value)
    TransferContext.callMethod(MethodBindings.setScrollHintModePtr)
  }

  public final fun getScrollHintMode(): ScrollHintMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollHintModePtr)
    return ScrollHintMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setTileScrollHint(tileScrollHint: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to tileScrollHint)
    TransferContext.callMethod(MethodBindings.setTileScrollHintPtr)
  }

  public final fun isScrollHintTiled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isScrollHintTiledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setTextOverrunBehavior(overrunBehavior: TextServer.OverrunBehavior): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to overrunBehavior.value)
    TransferContext.callMethod(MethodBindings.setTextOverrunBehaviorPtr)
  }

  public final fun getTextOverrunBehavior(): TextServer.OverrunBehavior {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTextOverrunBehaviorPtr)
    return TextServer.OverrunBehavior.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setWraparoundItems(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setWraparoundItemsPtr)
  }

  public final fun hasWraparoundItems(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasWraparoundItemsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Forces an update to the list size based on its items. This happens automatically whenever size
   * of the items, or other relevant settings like [autoHeight], change. The method can be used to
   * trigger the update ahead of next drawing pass.
   */
  public final fun forceUpdateListSize(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceUpdateListSizePtr)
  }

  public enum class IconMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Icon is drawn above the text.
     */
    TOP(0),
    /**
     * Icon is drawn to the left of the text.
     */
    LEFT(1),
    ;

    public companion object {
      public fun from(`value`: Long): IconMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class SelectMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Only allow selecting a single item.
     */
    SINGLE(0),
    /**
     * Allows selecting multiple items by holding [kbd]Ctrl[/kbd] or [kbd]Shift[/kbd].
     */
    MULTI(1),
    /**
     * Allows selecting multiple items by toggling them on and off.
     */
    TOGGLE(2),
    ;

    public companion object {
      public fun from(`value`: Long): SelectMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ScrollHintMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Scroll hints will never be shown.
     */
    DISABLED(0),
    /**
     * Scroll hints will be shown at the top and bottom.
     */
    BOTH(1),
    /**
     * Only the top scroll hint will be shown.
     */
    TOP(2),
    /**
     * Only the bottom scroll hint will be shown.
     */
    BOTTOM(3),
    ;

    public companion object {
      public fun from(`value`: Long): ScrollHintMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addItemName: MethodStringName3<ItemList, Int, String, Texture2D?, Boolean> =
        MethodStringName3<ItemList, Int, String, Texture2D?, Boolean>("add_item")

    @JvmField
    public val addIconItemName: MethodStringName2<ItemList, Int, Texture2D?, Boolean> =
        MethodStringName2<ItemList, Int, Texture2D?, Boolean>("add_icon_item")

    @JvmField
    public val setItemTextName: MethodStringName2<ItemList, Unit, Int, String> =
        MethodStringName2<ItemList, Unit, Int, String>("set_item_text")

    @JvmField
    public val getItemTextName: MethodStringName1<ItemList, String, Int> =
        MethodStringName1<ItemList, String, Int>("get_item_text")

    @JvmField
    public val setItemIconName: MethodStringName2<ItemList, Unit, Int, Texture2D?> =
        MethodStringName2<ItemList, Unit, Int, Texture2D?>("set_item_icon")

    @JvmField
    public val getItemIconName: MethodStringName1<ItemList, Texture2D?, Int> =
        MethodStringName1<ItemList, Texture2D?, Int>("get_item_icon")

    @JvmField
    public val setItemTextDirectionName:
        MethodStringName2<ItemList, Unit, Int, Control.TextDirection> =
        MethodStringName2<ItemList, Unit, Int, Control.TextDirection>("set_item_text_direction")

    @JvmField
    public val getItemTextDirectionName: MethodStringName1<ItemList, Control.TextDirection, Int> =
        MethodStringName1<ItemList, Control.TextDirection, Int>("get_item_text_direction")

    @JvmField
    public val setItemLanguageName: MethodStringName2<ItemList, Unit, Int, String> =
        MethodStringName2<ItemList, Unit, Int, String>("set_item_language")

    @JvmField
    public val getItemLanguageName: MethodStringName1<ItemList, String, Int> =
        MethodStringName1<ItemList, String, Int>("get_item_language")

    @JvmField
    public val setItemAutoTranslateModeName:
        MethodStringName2<ItemList, Unit, Int, Node.AutoTranslateMode> =
        MethodStringName2<ItemList, Unit, Int, Node.AutoTranslateMode>("set_item_auto_translate_mode")

    @JvmField
    public val getItemAutoTranslateModeName:
        MethodStringName1<ItemList, Node.AutoTranslateMode, Int> =
        MethodStringName1<ItemList, Node.AutoTranslateMode, Int>("get_item_auto_translate_mode")

    @JvmField
    public val setItemIconTransposedName: MethodStringName2<ItemList, Unit, Int, Boolean> =
        MethodStringName2<ItemList, Unit, Int, Boolean>("set_item_icon_transposed")

    @JvmField
    public val isItemIconTransposedName: MethodStringName1<ItemList, Boolean, Int> =
        MethodStringName1<ItemList, Boolean, Int>("is_item_icon_transposed")

    @JvmField
    public val setItemIconRegionName: MethodStringName2<ItemList, Unit, Int, Rect2> =
        MethodStringName2<ItemList, Unit, Int, Rect2>("set_item_icon_region")

    @JvmField
    public val getItemIconRegionName: MethodStringName1<ItemList, Rect2, Int> =
        MethodStringName1<ItemList, Rect2, Int>("get_item_icon_region")

    @JvmField
    public val setItemIconModulateName: MethodStringName2<ItemList, Unit, Int, Color> =
        MethodStringName2<ItemList, Unit, Int, Color>("set_item_icon_modulate")

    @JvmField
    public val getItemIconModulateName: MethodStringName1<ItemList, Color, Int> =
        MethodStringName1<ItemList, Color, Int>("get_item_icon_modulate")

    @JvmField
    public val setItemSelectableName: MethodStringName2<ItemList, Unit, Int, Boolean> =
        MethodStringName2<ItemList, Unit, Int, Boolean>("set_item_selectable")

    @JvmField
    public val isItemSelectableName: MethodStringName1<ItemList, Boolean, Int> =
        MethodStringName1<ItemList, Boolean, Int>("is_item_selectable")

    @JvmField
    public val setItemDisabledName: MethodStringName2<ItemList, Unit, Int, Boolean> =
        MethodStringName2<ItemList, Unit, Int, Boolean>("set_item_disabled")

    @JvmField
    public val isItemDisabledName: MethodStringName1<ItemList, Boolean, Int> =
        MethodStringName1<ItemList, Boolean, Int>("is_item_disabled")

    @JvmField
    public val setItemMetadataName: MethodStringName2<ItemList, Unit, Int, Any?> =
        MethodStringName2<ItemList, Unit, Int, Any?>("set_item_metadata")

    @JvmField
    public val getItemMetadataName: MethodStringName1<ItemList, Any?, Int> =
        MethodStringName1<ItemList, Any?, Int>("get_item_metadata")

    @JvmField
    public val setItemCustomBgColorName: MethodStringName2<ItemList, Unit, Int, Color> =
        MethodStringName2<ItemList, Unit, Int, Color>("set_item_custom_bg_color")

    @JvmField
    public val getItemCustomBgColorName: MethodStringName1<ItemList, Color, Int> =
        MethodStringName1<ItemList, Color, Int>("get_item_custom_bg_color")

    @JvmField
    public val setItemCustomFgColorName: MethodStringName2<ItemList, Unit, Int, Color> =
        MethodStringName2<ItemList, Unit, Int, Color>("set_item_custom_fg_color")

    @JvmField
    public val getItemCustomFgColorName: MethodStringName1<ItemList, Color, Int> =
        MethodStringName1<ItemList, Color, Int>("get_item_custom_fg_color")

    @JvmField
    public val getItemRectName: MethodStringName2<ItemList, Rect2, Int, Boolean> =
        MethodStringName2<ItemList, Rect2, Int, Boolean>("get_item_rect")

    @JvmField
    public val setItemTooltipEnabledName: MethodStringName2<ItemList, Unit, Int, Boolean> =
        MethodStringName2<ItemList, Unit, Int, Boolean>("set_item_tooltip_enabled")

    @JvmField
    public val isItemTooltipEnabledName: MethodStringName1<ItemList, Boolean, Int> =
        MethodStringName1<ItemList, Boolean, Int>("is_item_tooltip_enabled")

    @JvmField
    public val setItemTooltipName: MethodStringName2<ItemList, Unit, Int, String> =
        MethodStringName2<ItemList, Unit, Int, String>("set_item_tooltip")

    @JvmField
    public val getItemTooltipName: MethodStringName1<ItemList, String, Int> =
        MethodStringName1<ItemList, String, Int>("get_item_tooltip")

    @JvmField
    public val selectName: MethodStringName2<ItemList, Unit, Int, Boolean> =
        MethodStringName2<ItemList, Unit, Int, Boolean>("select")

    @JvmField
    public val deselectName: MethodStringName1<ItemList, Unit, Int> =
        MethodStringName1<ItemList, Unit, Int>("deselect")

    @JvmField
    public val deselectAllName: MethodStringName0<ItemList, Unit> =
        MethodStringName0<ItemList, Unit>("deselect_all")

    @JvmField
    public val isSelectedName: MethodStringName1<ItemList, Boolean, Int> =
        MethodStringName1<ItemList, Boolean, Int>("is_selected")

    @JvmField
    public val getSelectedItemsName: MethodStringName0<ItemList, PackedInt32Array> =
        MethodStringName0<ItemList, PackedInt32Array>("get_selected_items")

    @JvmField
    public val moveItemName: MethodStringName2<ItemList, Unit, Int, Int> =
        MethodStringName2<ItemList, Unit, Int, Int>("move_item")

    @JvmField
    public val setItemCountName: MethodStringName1<ItemList, Unit, Int> =
        MethodStringName1<ItemList, Unit, Int>("set_item_count")

    @JvmField
    public val getItemCountName: MethodStringName0<ItemList, Int> =
        MethodStringName0<ItemList, Int>("get_item_count")

    @JvmField
    public val removeItemName: MethodStringName1<ItemList, Unit, Int> =
        MethodStringName1<ItemList, Unit, Int>("remove_item")

    @JvmField
    public val clearName: MethodStringName0<ItemList, Unit> =
        MethodStringName0<ItemList, Unit>("clear")

    @JvmField
    public val sortItemsByTextName: MethodStringName0<ItemList, Unit> =
        MethodStringName0<ItemList, Unit>("sort_items_by_text")

    @JvmField
    public val setFixedColumnWidthName: MethodStringName1<ItemList, Unit, Int> =
        MethodStringName1<ItemList, Unit, Int>("set_fixed_column_width")

    @JvmField
    public val getFixedColumnWidthName: MethodStringName0<ItemList, Int> =
        MethodStringName0<ItemList, Int>("get_fixed_column_width")

    @JvmField
    public val setSameColumnWidthName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_same_column_width")

    @JvmField
    public val isSameColumnWidthName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("is_same_column_width")

    @JvmField
    public val setMaxTextLinesName: MethodStringName1<ItemList, Unit, Int> =
        MethodStringName1<ItemList, Unit, Int>("set_max_text_lines")

    @JvmField
    public val getMaxTextLinesName: MethodStringName0<ItemList, Int> =
        MethodStringName0<ItemList, Int>("get_max_text_lines")

    @JvmField
    public val setMaxColumnsName: MethodStringName1<ItemList, Unit, Int> =
        MethodStringName1<ItemList, Unit, Int>("set_max_columns")

    @JvmField
    public val getMaxColumnsName: MethodStringName0<ItemList, Int> =
        MethodStringName0<ItemList, Int>("get_max_columns")

    @JvmField
    public val setSelectModeName: MethodStringName1<ItemList, Unit, SelectMode> =
        MethodStringName1<ItemList, Unit, SelectMode>("set_select_mode")

    @JvmField
    public val getSelectModeName: MethodStringName0<ItemList, SelectMode> =
        MethodStringName0<ItemList, SelectMode>("get_select_mode")

    @JvmField
    public val setIconModeName: MethodStringName1<ItemList, Unit, IconMode> =
        MethodStringName1<ItemList, Unit, IconMode>("set_icon_mode")

    @JvmField
    public val getIconModeName: MethodStringName0<ItemList, IconMode> =
        MethodStringName0<ItemList, IconMode>("get_icon_mode")

    @JvmField
    public val setFixedIconSizeName: MethodStringName1<ItemList, Unit, Vector2i> =
        MethodStringName1<ItemList, Unit, Vector2i>("set_fixed_icon_size")

    @JvmField
    public val getFixedIconSizeName: MethodStringName0<ItemList, Vector2i> =
        MethodStringName0<ItemList, Vector2i>("get_fixed_icon_size")

    @JvmField
    public val setIconScaleName: MethodStringName1<ItemList, Unit, Float> =
        MethodStringName1<ItemList, Unit, Float>("set_icon_scale")

    @JvmField
    public val getIconScaleName: MethodStringName0<ItemList, Float> =
        MethodStringName0<ItemList, Float>("get_icon_scale")

    @JvmField
    public val setAllowRmbSelectName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_allow_rmb_select")

    @JvmField
    public val getAllowRmbSelectName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("get_allow_rmb_select")

    @JvmField
    public val setAllowReselectName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_allow_reselect")

    @JvmField
    public val getAllowReselectName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("get_allow_reselect")

    @JvmField
    public val setAllowSearchName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_allow_search")

    @JvmField
    public val getAllowSearchName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("get_allow_search")

    @JvmField
    public val setAutoWidthName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_auto_width")

    @JvmField
    public val hasAutoWidthName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("has_auto_width")

    @JvmField
    public val setAutoHeightName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_auto_height")

    @JvmField
    public val hasAutoHeightName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("has_auto_height")

    @JvmField
    public val isAnythingSelectedName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("is_anything_selected")

    @JvmField
    public val getItemAtPositionName: MethodStringName2<ItemList, Int, Vector2, Boolean> =
        MethodStringName2<ItemList, Int, Vector2, Boolean>("get_item_at_position")

    @JvmField
    public val ensureCurrentIsVisibleName: MethodStringName0<ItemList, Unit> =
        MethodStringName0<ItemList, Unit>("ensure_current_is_visible")

    @JvmField
    public val centerOnCurrentName: MethodStringName2<ItemList, Unit, Boolean, Boolean> =
        MethodStringName2<ItemList, Unit, Boolean, Boolean>("center_on_current")

    @JvmField
    public val getVScrollBarName: MethodStringName0<ItemList, VScrollBar?> =
        MethodStringName0<ItemList, VScrollBar?>("get_v_scroll_bar")

    @JvmField
    public val getHScrollBarName: MethodStringName0<ItemList, HScrollBar?> =
        MethodStringName0<ItemList, HScrollBar?>("get_h_scroll_bar")

    @JvmField
    public val setScrollHintModeName: MethodStringName1<ItemList, Unit, ScrollHintMode> =
        MethodStringName1<ItemList, Unit, ScrollHintMode>("set_scroll_hint_mode")

    @JvmField
    public val getScrollHintModeName: MethodStringName0<ItemList, ScrollHintMode> =
        MethodStringName0<ItemList, ScrollHintMode>("get_scroll_hint_mode")

    @JvmField
    public val setTileScrollHintName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_tile_scroll_hint")

    @JvmField
    public val isScrollHintTiledName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("is_scroll_hint_tiled")

    @JvmField
    public val setTextOverrunBehaviorName:
        MethodStringName1<ItemList, Unit, TextServer.OverrunBehavior> =
        MethodStringName1<ItemList, Unit, TextServer.OverrunBehavior>("set_text_overrun_behavior")

    @JvmField
    public val getTextOverrunBehaviorName: MethodStringName0<ItemList, TextServer.OverrunBehavior> =
        MethodStringName0<ItemList, TextServer.OverrunBehavior>("get_text_overrun_behavior")

    @JvmField
    public val setWraparoundItemsName: MethodStringName1<ItemList, Unit, Boolean> =
        MethodStringName1<ItemList, Unit, Boolean>("set_wraparound_items")

    @JvmField
    public val hasWraparoundItemsName: MethodStringName0<ItemList, Boolean> =
        MethodStringName0<ItemList, Boolean>("has_wraparound_items")

    @JvmField
    public val forceUpdateListSizeName: MethodStringName0<ItemList, Unit> =
        MethodStringName0<ItemList, Unit>("force_update_list_size")
  }

  public object MethodBindings {
    internal val addItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "add_item", 359861678)

    internal val addIconItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "add_icon_item", 4256579627)

    internal val setItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_text", 501894301)

    internal val getItemTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_text", 844755477)

    internal val setItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_icon", 666127730)

    internal val getItemIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_icon", 3536238170)

    internal val setItemTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_text_direction", 1707680378)

    internal val getItemTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_text_direction", 4235602388)

    internal val setItemLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_language", 501894301)

    internal val getItemLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_language", 844755477)

    internal val setItemAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_auto_translate_mode", 287402019)

    internal val getItemAutoTranslateModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_auto_translate_mode", 906302372)

    internal val setItemIconTransposedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_icon_transposed", 300928843)

    internal val isItemIconTransposedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_item_icon_transposed", 1116898809)

    internal val setItemIconRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_icon_region", 1356297692)

    internal val getItemIconRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_icon_region", 3327874267)

    internal val setItemIconModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_icon_modulate", 2878471219)

    internal val getItemIconModulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_icon_modulate", 3457211756)

    internal val setItemSelectablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_selectable", 300928843)

    internal val isItemSelectablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_item_selectable", 1116898809)

    internal val setItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_disabled", 300928843)

    internal val isItemDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_item_disabled", 1116898809)

    internal val setItemMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_metadata", 2152698145)

    internal val getItemMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_metadata", 4227898402)

    internal val setItemCustomBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_custom_bg_color", 2878471219)

    internal val getItemCustomBgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_custom_bg_color", 3457211756)

    internal val setItemCustomFgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_custom_fg_color", 2878471219)

    internal val getItemCustomFgColorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_custom_fg_color", 3457211756)

    internal val getItemRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_rect", 159227807)

    internal val setItemTooltipEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_tooltip_enabled", 300928843)

    internal val isItemTooltipEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_item_tooltip_enabled", 1116898809)

    internal val setItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_tooltip", 501894301)

    internal val getItemTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_tooltip", 844755477)

    internal val selectPtr: VoidPtr = TypeManager.getMethodBindPtr("ItemList", "select", 972357352)

    internal val deselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "deselect", 1286410249)

    internal val deselectAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "deselect_all", 3218959716)

    internal val isSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_selected", 1116898809)

    internal val getSelectedItemsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_selected_items", 969006518)

    internal val moveItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "move_item", 3937882851)

    internal val setItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_item_count", 1286410249)

    internal val getItemCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_count", 3905245786)

    internal val removeItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "remove_item", 1286410249)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("ItemList", "clear", 3218959716)

    internal val sortItemsByTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "sort_items_by_text", 3218959716)

    internal val setFixedColumnWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_fixed_column_width", 1286410249)

    internal val getFixedColumnWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_fixed_column_width", 3905245786)

    internal val setSameColumnWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_same_column_width", 2586408642)

    internal val isSameColumnWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_same_column_width", 36873697)

    internal val setMaxTextLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_max_text_lines", 1286410249)

    internal val getMaxTextLinesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_max_text_lines", 3905245786)

    internal val setMaxColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_max_columns", 1286410249)

    internal val getMaxColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_max_columns", 3905245786)

    internal val setSelectModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_select_mode", 928267388)

    internal val getSelectModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_select_mode", 1191945842)

    internal val setIconModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_icon_mode", 2025053633)

    internal val getIconModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_icon_mode", 3353929232)

    internal val setFixedIconSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_fixed_icon_size", 1130785943)

    internal val getFixedIconSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_fixed_icon_size", 3690982128)

    internal val setIconScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_icon_scale", 373806689)

    internal val getIconScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_icon_scale", 1740695150)

    internal val setAllowRmbSelectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_allow_rmb_select", 2586408642)

    internal val getAllowRmbSelectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_allow_rmb_select", 36873697)

    internal val setAllowReselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_allow_reselect", 2586408642)

    internal val getAllowReselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_allow_reselect", 36873697)

    internal val setAllowSearchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_allow_search", 2586408642)

    internal val getAllowSearchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_allow_search", 36873697)

    internal val setAutoWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_auto_width", 2586408642)

    internal val hasAutoWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "has_auto_width", 36873697)

    internal val setAutoHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_auto_height", 2586408642)

    internal val hasAutoHeightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "has_auto_height", 36873697)

    internal val isAnythingSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_anything_selected", 2240911060)

    internal val getItemAtPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_item_at_position", 2300324924)

    internal val ensureCurrentIsVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "ensure_current_is_visible", 3218959716)

    internal val centerOnCurrentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "center_on_current", 3058350285)

    internal val getVScrollBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_v_scroll_bar", 2630340773)

    internal val getHScrollBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_h_scroll_bar", 4004517983)

    internal val setScrollHintModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_scroll_hint_mode", 2917787337)

    internal val getScrollHintModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_scroll_hint_mode", 2522227939)

    internal val setTileScrollHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_tile_scroll_hint", 2586408642)

    internal val isScrollHintTiledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "is_scroll_hint_tiled", 2240911060)

    internal val setTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_text_overrun_behavior", 1008890932)

    internal val getTextOverrunBehaviorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "get_text_overrun_behavior", 3779142101)

    internal val setWraparoundItemsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "set_wraparound_items", 2586408642)

    internal val hasWraparoundItemsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "has_wraparound_items", 36873697)

    internal val forceUpdateListSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ItemList", "force_update_list_size", 3218959716)
  }
}
