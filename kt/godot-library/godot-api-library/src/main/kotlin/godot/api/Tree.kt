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
import godot.core.GodotEnum
import godot.core.HorizontalAlignment
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.RID
import godot.core.Rect2
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal2
import godot.core.Signal3
import godot.core.Signal4
import godot.core.Vector2
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RECT2
import godot.readReturnValue_RID
import godot.readReturnValue_STRING
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_OBJECT_BOOL
import godot.writeMethodArguments_OBJECT_LONG
import godot.writeMethodArguments_OBJECT_LONG_LONG
import godot.writeMethodArguments_VECTOR2
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
 * A control used to show a set of internal [TreeItem]s in a hierarchical structure. The tree items
 * can be selected, expanded and collapsed. The tree can have multiple columns with custom controls
 * like [LineEdit]s, buttons and popups. It can be useful for structured displays and interactions.
 *
 * Trees are built via code, using [TreeItem] objects to create the structure. They have a single
 * root, but multiple roots can be simulated with [hideRoot]:
 *
 * ```gdscript
 * //gdscript
 * func _ready():
 * 	var tree = Tree.new()
 * 	var root = tree.create_item()
 * 	tree.hide_root = true
 * 	var child1 = tree.create_item(root)
 * 	var child2 = tree.create_item(root)
 * 	var subchild1 = tree.create_item(child1)
 * 	subchild1.set_text(0, "Subchild1")
 * ```
 *
 * ```csharp
 * //csharp
 * public override void _Ready()
 * {
 * 	var tree = new Tree();
 * 	TreeItem root = tree.CreateItem();
 * 	tree.HideRoot = true;
 * 	TreeItem child1 = tree.CreateItem(root);
 * 	TreeItem child2 = tree.CreateItem(root);
 * 	TreeItem subchild1 = tree.CreateItem(child1);
 * 	subchild1.SetText(0, "Subchild1");
 * }
 * ```
 *
 * To iterate over all the [TreeItem] objects in a [Tree] object, use [TreeItem.getNext] and
 * [TreeItem.getFirstChild] after getting the root through [getRoot]. You can use [Object.free] on a
 * [TreeItem] to remove it from the [Tree].
 *
 * **Incremental search:** Like [ItemList] and [PopupMenu], [Tree] supports searching within the
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
public open class Tree : Control() {
  /**
   * Emitted when an item is selected.
   */
  public val itemSelected: Signal0 by Signal0

  /**
   * Emitted when a cell is selected.
   */
  public val cellSelected: Signal0 by Signal0

  /**
   * Emitted instead of [signal item_selected] if [selectMode] is set to [SELECT_MULTI].
   */
  public val multiSelected: Signal3<TreeItem, Long, Boolean> by Signal3

  /**
   * Emitted when an item is selected with a mouse button.
   */
  public val itemMouseSelected: Signal2<Vector2, Long> by Signal2

  /**
   * Emitted when a mouse button is clicked in the empty space of the tree.
   */
  public val emptyClicked: Signal2<Vector2, Long> by Signal2

  /**
   * Emitted when an item is edited.
   */
  public val itemEdited: Signal0 by Signal0

  /**
   * Emitted when an item with [TreeItem.CELL_MODE_CUSTOM] is clicked with a mouse button.
   */
  public val customItemClicked: Signal1<Long> by Signal1

  /**
   * Emitted when an item's icon is double-clicked. For a signal that emits when any part of the
   * item is double-clicked, see [signal item_activated].
   */
  public val itemIconDoubleClicked: Signal0 by Signal0

  /**
   * Emitted when an item is expanded or collapsed by clicking on the folding arrow or through code.
   *
   * **Note:** Despite its name, this signal is also emitted when an item is expanded.
   */
  public val itemCollapsed: Signal1<TreeItem> by Signal1

  /**
   * Emitted when [TreeItem.propagateCheck] is called. Connect to this signal to process the items
   * that are affected when [TreeItem.propagateCheck] is invoked. The order that the items affected
   * will be processed is as follows: the item that invoked the method, children of that item, and
   * finally parents of that item.
   */
  public val checkPropagatedToItem: Signal2<TreeItem, Long> by Signal2

  /**
   * Emitted when a button on the tree was pressed (see [TreeItem.addButton]).
   */
  public val buttonClicked: Signal4<TreeItem, Long, Long, Long> by Signal4

  /**
   * Emitted when a cell with the [TreeItem.CELL_MODE_CUSTOM] is clicked to be edited.
   */
  public val customPopupEdited: Signal1<Boolean> by Signal1

  /**
   * Emitted when an item is double-clicked, or selected with a `ui_accept` input event (e.g. using
   * [kbd]Enter[/kbd] or [kbd]Space[/kbd] on the keyboard).
   */
  public val itemActivated: Signal0 by Signal0

  /**
   * Emitted when a column's title is clicked with either [MOUSE_BUTTON_LEFT] or
   * [MOUSE_BUTTON_RIGHT].
   */
  public val columnTitleClicked: Signal2<Long, Long> by Signal2

  /**
   * Emitted when a left mouse button click does not select any item.
   */
  public val nothingSelected: Signal0 by Signal0

  /**
   * The number of columns.
   *
   * Prints an error and does not allow setting the columns during mouse selection.
   */
  public final inline var columns: Int
    @JvmName("columnsProperty")
    get() = getColumns()
    @JvmName("columnsProperty")
    set(`value`) {
      setColumns(value)
    }

  /**
   * If `true`, column titles are visible.
   */
  public final inline var columnTitlesVisible: Boolean
    @JvmName("columnTitlesVisibleProperty")
    get() = areColumnTitlesVisible()
    @JvmName("columnTitlesVisibleProperty")
    set(`value`) {
      setColumnTitlesVisible(value)
    }

  /**
   * If `true`, the currently selected cell may be selected again.
   */
  public final inline var allowReselect: Boolean
    @JvmName("allowReselectProperty")
    get() = getAllowReselect()
    @JvmName("allowReselectProperty")
    set(`value`) {
      setAllowReselect(value)
    }

  /**
   * If `true`, a right mouse button click can select items.
   */
  public final inline var allowRmbSelect: Boolean
    @JvmName("allowRmbSelectProperty")
    get() = getAllowRmbSelect()
    @JvmName("allowRmbSelectProperty")
    set(`value`) {
      setAllowRmbSelect(value)
    }

  /**
   * If `true`, allows navigating the [Tree] with letter keys through incremental search.
   */
  public final inline var allowSearch: Boolean
    @JvmName("allowSearchProperty")
    get() = getAllowSearch()
    @JvmName("allowSearchProperty")
    set(`value`) {
      setAllowSearch(value)
    }

  /**
   * If `true`, the folding arrow is hidden.
   */
  public final inline var hideFolding: Boolean
    @JvmName("hideFoldingProperty")
    get() = isFoldingHidden()
    @JvmName("hideFoldingProperty")
    set(`value`) {
      setHideFolding(value)
    }

  /**
   * If `true`, recursive folding is enabled for this [Tree]. Holding down [kbd]Shift[/kbd] while
   * clicking the fold arrow or using `ui_right`/`ui_left` shortcuts collapses or uncollapses the
   * [TreeItem] and all its descendants.
   */
  public final inline var enableRecursiveFolding: Boolean
    @JvmName("enableRecursiveFoldingProperty")
    get() = isRecursiveFoldingEnabled()
    @JvmName("enableRecursiveFoldingProperty")
    set(`value`) {
      setEnableRecursiveFolding(value)
    }

  /**
   * If `true`, tree items will unfold when hovered over during a drag-and-drop. The delay for when
   * this happens is dictated by [theme_item dragging_unfold_wait_msec].
   */
  public final inline var enableDragUnfolding: Boolean
    @JvmName("enableDragUnfoldingProperty")
    get() = isDragUnfoldingEnabled()
    @JvmName("enableDragUnfoldingProperty")
    set(`value`) {
      setEnableDragUnfolding(value)
    }

  /**
   * If `true`, the tree's root is hidden.
   */
  public final inline var hideRoot: Boolean
    @JvmName("hideRootProperty")
    get() = isRootHidden()
    @JvmName("hideRootProperty")
    set(`value`) {
      setHideRoot(value)
    }

  /**
   * The drop mode as an OR combination of flags. See [DropModeFlags] constants. Once dropping is
   * done, reverts to [DROP_MODE_DISABLED]. Setting this during [Control.CanDropData] is recommended.
   *
   * This controls the drop sections, i.e. the decision and drawing of possible drop locations based
   * on the mouse position.
   */
  public final inline var dropModeFlags: Int
    @JvmName("dropModeFlagsProperty")
    get() = getDropModeFlags()
    @JvmName("dropModeFlagsProperty")
    set(`value`) {
      setDropModeFlags(value)
    }

  /**
   * Allows single or multiple selection. See the [SelectMode] constants.
   */
  public final inline var selectMode: SelectMode
    @JvmName("selectModeProperty")
    get() = getSelectMode()
    @JvmName("selectModeProperty")
    set(`value`) {
      setSelectMode(value)
    }

  /**
   * If `true`, tree items with no tooltip assigned display their text as their tooltip. See also
   * [TreeItem.getTooltipText] and [TreeItem.getButtonTooltipText].
   */
  public final inline var autoTooltip: Boolean
    @JvmName("autoTooltipProperty")
    get() = isAutoTooltipEnabled()
    @JvmName("autoTooltipProperty")
    set(`value`) {
      setAutoTooltip(value)
    }

  /**
   * If `true`, enables horizontal scrolling.
   */
  public final inline var scrollHorizontalEnabled: Boolean
    @JvmName("scrollHorizontalEnabledProperty")
    get() = isHScrollEnabled()
    @JvmName("scrollHorizontalEnabledProperty")
    set(`value`) {
      setHScrollEnabled(value)
    }

  /**
   * If `true`, enables vertical scrolling.
   */
  public final inline var scrollVerticalEnabled: Boolean
    @JvmName("scrollVerticalEnabledProperty")
    get() = isVScrollEnabled()
    @JvmName("scrollVerticalEnabledProperty")
    set(`value`) {
      setVScrollEnabled(value)
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

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(771, scriptPtr)
  }

  /**
   * Clears the tree. This removes all items.
   *
   * Prints an error and does not allow clearing the tree if called during mouse selection.
   */
  public final fun clear(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearPtr)
  }

  /**
   * Creates an item in the tree and adds it as a child of [parent], which can be either a valid
   * [TreeItem] or `null`.
   *
   * If [parent] is `null`, the root item will be the parent, or the new item will be the root
   * itself if the tree is empty.
   *
   * The new item will be the [index]-th child of parent, or it will be the last child if there are
   * not enough siblings.
   *
   * Prints an error and returns `null` if called during mouse selection, or if the [parent] does
   * not belong to this tree.
   */
  @JvmOverloads
  public final fun createItem(parent: TreeItem? = null, index: Int = -1): TreeItem? {
    TransferContext.writeMethodArguments_OBJECT_LONG(ptr, objectID.id, parent, index.toLong())
    TransferContext.callMethod(MethodBindings.createItemPtr)
    return (TransferContext.readReturnValue_OBJECT() as TreeItem?)
  }

  /**
   * Returns the tree's root item, or `null` if the tree is empty.
   */
  public final fun getRoot(): TreeItem? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootPtr)
    return (TransferContext.readReturnValue_OBJECT() as TreeItem?)
  }

  /**
   * Overrides the calculated minimum width of a column. It can be set to `0` to restore the default
   * behavior. Columns that have the "Expand" flag will use their "min_width" in a similar fashion to
   * [Control.sizeFlagsStretchRatio].
   */
  public final fun setColumnCustomMinimumWidth(column: Int, minWidth: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, column.toLong(), minWidth.toLong())
    TransferContext.callMethod(MethodBindings.setColumnCustomMinimumWidthPtr)
  }

  /**
   * If `true`, the column will have the "Expand" flag of [Control]. Columns that have the "Expand"
   * flag will use their expand ratio in a similar fashion to [Control.sizeFlagsStretchRatio] (see
   * [setColumnExpandRatio]).
   */
  public final fun setColumnExpand(column: Int, expand: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, column.toLong(), expand)
    TransferContext.callMethod(MethodBindings.setColumnExpandPtr)
  }

  /**
   * Sets the relative expand ratio for a column. See [setColumnExpand].
   */
  public final fun setColumnExpandRatio(column: Int, ratio: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, column.toLong(), ratio.toLong())
    TransferContext.callMethod(MethodBindings.setColumnExpandRatioPtr)
  }

  /**
   * Allows to enable clipping for column's content, making the content size ignored.
   */
  public final fun setColumnClipContent(column: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, column.toLong(), enable)
    TransferContext.callMethod(MethodBindings.setColumnClipContentPtr)
  }

  /**
   * Returns `true` if the column has enabled expanding (see [setColumnExpand]).
   */
  public final fun isColumnExpanding(column: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.isColumnExpandingPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the column has enabled clipping (see [setColumnClipContent]).
   */
  public final fun isColumnClippingContent(column: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.isColumnClippingContentPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the expand ratio assigned to the column.
   */
  public final fun getColumnExpandRatio(column: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.getColumnExpandRatioPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the column's width in pixels.
   */
  public final fun getColumnWidth(column: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.getColumnWidthPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the internal canvas item designated for custom drawing. See
   * [TreeItem.setCustomDrawCallback].
   *
   * **Note:** This canvas item clears automatically on each Tree draw call.
   */
  public final fun getCustomDrawingCanvasItem(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomDrawingCanvasItemPtr)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setHideRoot(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setHideRootPtr)
  }

  public final fun isRootHidden(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRootHiddenPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the next selected [TreeItem] after the given one, or `null` if the end is reached.
   *
   * If [from] is `null`, this returns the first selected item.
   */
  public final fun getNextSelected(from: TreeItem?): TreeItem? {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, from)
    TransferContext.callMethod(MethodBindings.getNextSelectedPtr)
    return (TransferContext.readReturnValue_OBJECT() as TreeItem?)
  }

  /**
   * Returns the currently focused item, or `null` if no item is focused.
   *
   * In [SELECT_ROW] and [SELECT_SINGLE] modes, the focused item is same as the selected item. In
   * [SELECT_MULTI] mode, the focused item is the item under the focus cursor, not necessarily
   * selected.
   *
   * To get the currently selected item(s), use [getNextSelected].
   */
  public final fun getSelected(): TreeItem? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedPtr)
    return (TransferContext.readReturnValue_OBJECT() as TreeItem?)
  }

  /**
   * Selects the specified [TreeItem] and column.
   */
  public final fun setSelected(item: TreeItem?, column: Int): Unit {
    TransferContext.writeMethodArguments_OBJECT_LONG(ptr, objectID.id, item, column.toLong())
    TransferContext.callMethod(MethodBindings.setSelectedPtr)
  }

  /**
   * Returns the currently focused column, or -1 if no column is focused.
   *
   * In [SELECT_SINGLE] mode, the focused column is the selected column. In [SELECT_ROW] mode, the
   * focused column is always 0 if any item is selected. In [SELECT_MULTI] mode, the focused column is
   * the column under the focus cursor, and there are not necessarily any column selected.
   *
   * To tell whether a column of an item is selected, use [TreeItem.isSelected].
   */
  public final fun getSelectedColumn(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectedColumnPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the last pressed button's index.
   */
  public final fun getPressedButton(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPressedButtonPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setSelectMode(mode: SelectMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setSelectModePtr)
  }

  public final fun getSelectMode(): SelectMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectModePtr)
    return SelectMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Deselects all tree items (rows and columns). In [SELECT_MULTI] mode also removes selection
   * cursor.
   */
  public final fun deselectAll(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.deselectAllPtr)
  }

  public final fun setColumns(amount: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, amount.toLong())
    TransferContext.callMethod(MethodBindings.setColumnsPtr)
  }

  public final fun getColumns(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getColumnsPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the currently edited item. Can be used with [signal item_edited] to get the item that
   * was modified.
   *
   * ```gdscript
   * //gdscript
   * func _ready():
   * 	$Tree.item_edited.connect(on_Tree_item_edited)
   *
   * func on_Tree_item_edited():
   * 	print($Tree.get_edited()) # This item just got edited (e.g. checked).
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Ready()
   * {
   * 	GetNode<Tree>("Tree").ItemEdited += OnTreeItemEdited;
   * }
   *
   * public void OnTreeItemEdited()
   * {
   * 	GD.Print(GetNode<Tree>("Tree").GetEdited()); // This item just got edited (e.g. checked).
   * }
   * ```
   */
  public final fun getEdited(): TreeItem? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEditedPtr)
    return (TransferContext.readReturnValue_OBJECT() as TreeItem?)
  }

  /**
   * Returns the column for the currently edited item.
   */
  public final fun getEditedColumn(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEditedColumnPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Edits the selected tree item as if it was clicked.
   *
   * Either the item must be set editable with [TreeItem.setEditable] or [forceEdit] must be `true`.
   *
   * Returns `true` if the item could be edited. Fails if no item is selected.
   */
  @JvmOverloads
  public final fun editSelected(forceEdit: Boolean = false): Boolean {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, forceEdit)
    TransferContext.callMethod(MethodBindings.editSelectedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the rectangle for custom popups. Helper to create custom cell controls that display a
   * popup. See [TreeItem.setCellMode].
   */
  public final fun getCustomPopupRect(): Rect2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCustomPopupRectPtr)
    return TransferContext.readReturnValue_RECT2()
  }

  /**
   * Returns the rectangle area for the specified [TreeItem]. If [column] is specified, only get the
   * position and size of that column, otherwise get the rectangle containing all columns. If a button
   * index is specified, the rectangle of that button will be returned.
   */
  @JvmOverloads
  public final fun getItemAreaRect(
    item: TreeItem?,
    column: Int = -1,
    buttonIndex: Int = -1,
  ): Rect2 {
    TransferContext.writeMethodArguments_OBJECT_LONG_LONG(ptr, objectID.id, item, column.toLong(), buttonIndex.toLong())
    TransferContext.callMethod(MethodBindings.getItemAreaRectPtr)
    return TransferContext.readReturnValue_RECT2()
  }

  /**
   * Returns the tree item at the specified position (relative to the tree origin position).
   */
  public final fun getItemAtPosition(position: Vector2): TreeItem? {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callMethod(MethodBindings.getItemAtPositionPtr)
    return (TransferContext.readReturnValue_OBJECT() as TreeItem?)
  }

  /**
   * Returns the column index at [position], or -1 if no item is there.
   */
  public final fun getColumnAtPosition(position: Vector2): Int {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callMethod(MethodBindings.getColumnAtPositionPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the drop section at [position], as permitted by enabled [DropModeFlags].
   *
   * - `-1` if the position is **above** the item. Typically used to insert as the item's previous
   * sibling.
   *
   * - `0` if the position is **on** the item. Typically used to insert as the item's last child.
   *
   * - `1` if the position is **below** the item, when the item has no children. Typically used to
   * insert as the item's next sibling. If the item *does* have children, this section is still
   * reachable by hovering to the left of the item's collapse arrow, and below.
   *
   * - `2` if the position is **below** the item, when the item has children. Typically used to
   * insert as the item's first child.
   *
   * - `-100` if the position is not over any item, or no [DropModeFlags] are set.
   *
   * See [DropModeFlags] for a description of each drop region. To get the item which the returned
   * drop section refers to, use [getItemAtPosition].
   */
  public final fun getDropSectionAtPosition(position: Vector2): Int {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callMethod(MethodBindings.getDropSectionAtPositionPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the button ID at [position], or -1 if no button is there.
   */
  public final fun getButtonIdAtPosition(position: Vector2): Int {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, position)
    TransferContext.callMethod(MethodBindings.getButtonIdAtPositionPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Makes the currently focused cell visible.
   *
   * This will scroll the tree if necessary. In [SELECT_ROW] mode, this will not do horizontal
   * scrolling, as all the cells in the selected row is focused logically.
   *
   * **Note:** Despite the name of this method, the focus cursor itself is only visible in
   * [SELECT_MULTI] mode.
   */
  public final fun ensureCursorIsVisible(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.ensureCursorIsVisiblePtr)
  }

  public final fun setColumnTitlesVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, visible)
    TransferContext.callMethod(MethodBindings.setColumnTitlesVisiblePtr)
  }

  public final fun areColumnTitlesVisible(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areColumnTitlesVisiblePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the title of a column.
   */
  public final fun setColumnTitle(column: Int, title: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, column.toLong(), title)
    TransferContext.callMethod(MethodBindings.setColumnTitlePtr)
  }

  /**
   * Returns the column's title.
   */
  public final fun getColumnTitle(column: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.getColumnTitlePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the column title's tooltip text.
   */
  public final fun setColumnTitleTooltipText(column: Int, tooltipText: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, column.toLong(), tooltipText)
    TransferContext.callMethod(MethodBindings.setColumnTitleTooltipTextPtr)
  }

  /**
   * Returns the column title's tooltip text.
   */
  public final fun getColumnTitleTooltipText(column: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.getColumnTitleTooltipTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the column title alignment. Note that [@GlobalScope.HORIZONTAL_ALIGNMENT_FILL] is not
   * supported for column titles.
   */
  public final fun setColumnTitleAlignment(column: Int, titleAlignment: HorizontalAlignment): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, column.toLong(), titleAlignment.value)
    TransferContext.callMethod(MethodBindings.setColumnTitleAlignmentPtr)
  }

  /**
   * Returns the column title alignment.
   */
  public final fun getColumnTitleAlignment(column: Int): HorizontalAlignment {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.getColumnTitleAlignmentPtr)
    return HorizontalAlignment.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets column title base writing direction.
   */
  public final fun setColumnTitleDirection(column: Int, direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, column.toLong(), direction.value)
    TransferContext.callMethod(MethodBindings.setColumnTitleDirectionPtr)
  }

  /**
   * Returns column title base writing direction.
   */
  public final fun getColumnTitleDirection(column: Int): Control.TextDirection {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.getColumnTitleDirectionPtr)
    return Control.TextDirection.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the language code of the given [column]'s title to [language]. This is used for
   * line-breaking and text shaping algorithms. If [language] is empty, the current locale is used.
   */
  public final fun setColumnTitleLanguage(column: Int, language: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, column.toLong(), language)
    TransferContext.callMethod(MethodBindings.setColumnTitleLanguagePtr)
  }

  /**
   * Returns column title language code.
   */
  public final fun getColumnTitleLanguage(column: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, column.toLong())
    TransferContext.callMethod(MethodBindings.getColumnTitleLanguagePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the current scrolling position.
   */
  public final fun getScroll(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollPtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Causes the [Tree] to jump to the specified [TreeItem].
   */
  @JvmOverloads
  public final fun scrollToItem(item: TreeItem?, centerOnItem: Boolean = false): Unit {
    TransferContext.writeMethodArguments_OBJECT_BOOL(ptr, objectID.id, item, centerOnItem)
    TransferContext.callMethod(MethodBindings.scrollToItemPtr)
  }

  public final fun setHScrollEnabled(hScroll: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, hScroll)
    TransferContext.callMethod(MethodBindings.setHScrollEnabledPtr)
  }

  public final fun isHScrollEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHScrollEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setVScrollEnabled(hScroll: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, hScroll)
    TransferContext.callMethod(MethodBindings.setVScrollEnabledPtr)
  }

  public final fun isVScrollEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isVScrollEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setScrollHintMode(scrollHintMode: ScrollHintMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, scrollHintMode.value)
    TransferContext.callMethod(MethodBindings.setScrollHintModePtr)
  }

  public final fun getScrollHintMode(): ScrollHintMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollHintModePtr)
    return ScrollHintMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTileScrollHint(tileScrollHint: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, tileScrollHint)
    TransferContext.callMethod(MethodBindings.setTileScrollHintPtr)
  }

  public final fun isScrollHintTiled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isScrollHintTiledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setHideFolding(hide: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, hide)
    TransferContext.callMethod(MethodBindings.setHideFoldingPtr)
  }

  public final fun isFoldingHidden(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFoldingHiddenPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEnableRecursiveFolding(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setEnableRecursiveFoldingPtr)
  }

  public final fun isRecursiveFoldingEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRecursiveFoldingEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEnableDragUnfolding(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setEnableDragUnfoldingPtr)
  }

  public final fun isDragUnfoldingEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDragUnfoldingEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDropModeFlags(flags: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, flags.toLong())
    TransferContext.callMethod(MethodBindings.setDropModeFlagsPtr)
  }

  public final fun getDropModeFlags(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDropModeFlagsPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setAllowRmbSelect(allow: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, allow)
    TransferContext.callMethod(MethodBindings.setAllowRmbSelectPtr)
  }

  public final fun getAllowRmbSelect(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllowRmbSelectPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAllowReselect(allow: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, allow)
    TransferContext.callMethod(MethodBindings.setAllowReselectPtr)
  }

  public final fun getAllowReselect(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllowReselectPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAllowSearch(allow: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, allow)
    TransferContext.callMethod(MethodBindings.setAllowSearchPtr)
  }

  public final fun getAllowSearch(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAllowSearchPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAutoTooltip(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setAutoTooltipPtr)
  }

  public final fun isAutoTooltipEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAutoTooltipEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class SelectMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Allows selection of a single cell at a time. From the perspective of items, only a single
     * item is allowed to be selected. And there is only one column selected in the selected item.
     *
     * The focus cursor is always hidden in this mode, but it is positioned at the current
     * selection, making the currently selected item the currently focused item.
     */
    SINGLE(0),
    /**
     * Allows selection of a single row at a time. From the perspective of items, only a single
     * items is allowed to be selected. And all the columns are selected in the selected item.
     *
     * The focus cursor is always hidden in this mode, but it is positioned at the first column of
     * the current selection, making the currently selected item the currently focused item.
     */
    ROW(1),
    /**
     * Allows selection of multiple cells at the same time. From the perspective of items, multiple
     * items are allowed to be selected. And there can be multiple columns selected in each selected
     * item.
     *
     * The focus cursor is visible in this mode, the item or column under the cursor is not
     * necessarily selected.
     */
    MULTI(2),
    ;

    public companion object {
      public fun from(`value`: Long): SelectMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class DropModeFlags(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Disables all drop sections.
     *
     * **Note:** This is the default flag, it has no effect when combined with other flags.
     */
    DISABLED(0),
    /**
     * Enables the "on item" drop section. This drop section covers the entire item.
     *
     * When combined with [DROP_MODE_INBETWEEN], this drop section halves in height and stays
     * centered vertically.
     */
    ON_ITEM(1),
    /**
     * Enables "above item" and "below item" drop sections. The "above item" drop section covers the
     * top half of the item, while the "below item" drop section covers the bottom half, and extends
     * downward to the left of any children.
     *
     * When combined with [DROP_MODE_ON_ITEM], these drop sections halve in height and stay at the
     * top and bottom respectively.
     */
    INBETWEEN(2),
    ;

    public companion object {
      public fun from(`value`: Long): DropModeFlags = entries.single { it.`value` == `value` }
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
    public val clearName: MethodStringName0<Tree, Unit> = MethodStringName0<Tree, Unit>("clear")

    @JvmField
    public val createItemName: MethodStringName2<Tree, TreeItem?, TreeItem?, Int> =
        MethodStringName2<Tree, TreeItem?, TreeItem?, Int>("create_item")

    @JvmField
    public val getRootName: MethodStringName0<Tree, TreeItem?> =
        MethodStringName0<Tree, TreeItem?>("get_root")

    @JvmField
    public val setColumnCustomMinimumWidthName: MethodStringName2<Tree, Unit, Int, Int> =
        MethodStringName2<Tree, Unit, Int, Int>("set_column_custom_minimum_width")

    @JvmField
    public val setColumnExpandName: MethodStringName2<Tree, Unit, Int, Boolean> =
        MethodStringName2<Tree, Unit, Int, Boolean>("set_column_expand")

    @JvmField
    public val setColumnExpandRatioName: MethodStringName2<Tree, Unit, Int, Int> =
        MethodStringName2<Tree, Unit, Int, Int>("set_column_expand_ratio")

    @JvmField
    public val setColumnClipContentName: MethodStringName2<Tree, Unit, Int, Boolean> =
        MethodStringName2<Tree, Unit, Int, Boolean>("set_column_clip_content")

    @JvmField
    public val isColumnExpandingName: MethodStringName1<Tree, Boolean, Int> =
        MethodStringName1<Tree, Boolean, Int>("is_column_expanding")

    @JvmField
    public val isColumnClippingContentName: MethodStringName1<Tree, Boolean, Int> =
        MethodStringName1<Tree, Boolean, Int>("is_column_clipping_content")

    @JvmField
    public val getColumnExpandRatioName: MethodStringName1<Tree, Int, Int> =
        MethodStringName1<Tree, Int, Int>("get_column_expand_ratio")

    @JvmField
    public val getColumnWidthName: MethodStringName1<Tree, Int, Int> =
        MethodStringName1<Tree, Int, Int>("get_column_width")

    @JvmField
    public val getCustomDrawingCanvasItemName: MethodStringName0<Tree, RID> =
        MethodStringName0<Tree, RID>("get_custom_drawing_canvas_item")

    @JvmField
    public val setHideRootName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_hide_root")

    @JvmField
    public val isRootHiddenName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_root_hidden")

    @JvmField
    public val getNextSelectedName: MethodStringName1<Tree, TreeItem?, TreeItem?> =
        MethodStringName1<Tree, TreeItem?, TreeItem?>("get_next_selected")

    @JvmField
    public val getSelectedName: MethodStringName0<Tree, TreeItem?> =
        MethodStringName0<Tree, TreeItem?>("get_selected")

    @JvmField
    public val setSelectedName: MethodStringName2<Tree, Unit, TreeItem?, Int> =
        MethodStringName2<Tree, Unit, TreeItem?, Int>("set_selected")

    @JvmField
    public val getSelectedColumnName: MethodStringName0<Tree, Int> =
        MethodStringName0<Tree, Int>("get_selected_column")

    @JvmField
    public val getPressedButtonName: MethodStringName0<Tree, Int> =
        MethodStringName0<Tree, Int>("get_pressed_button")

    @JvmField
    public val setSelectModeName: MethodStringName1<Tree, Unit, SelectMode> =
        MethodStringName1<Tree, Unit, SelectMode>("set_select_mode")

    @JvmField
    public val getSelectModeName: MethodStringName0<Tree, SelectMode> =
        MethodStringName0<Tree, SelectMode>("get_select_mode")

    @JvmField
    public val deselectAllName: MethodStringName0<Tree, Unit> =
        MethodStringName0<Tree, Unit>("deselect_all")

    @JvmField
    public val setColumnsName: MethodStringName1<Tree, Unit, Int> =
        MethodStringName1<Tree, Unit, Int>("set_columns")

    @JvmField
    public val getColumnsName: MethodStringName0<Tree, Int> =
        MethodStringName0<Tree, Int>("get_columns")

    @JvmField
    public val getEditedName: MethodStringName0<Tree, TreeItem?> =
        MethodStringName0<Tree, TreeItem?>("get_edited")

    @JvmField
    public val getEditedColumnName: MethodStringName0<Tree, Int> =
        MethodStringName0<Tree, Int>("get_edited_column")

    @JvmField
    public val editSelectedName: MethodStringName1<Tree, Boolean, Boolean> =
        MethodStringName1<Tree, Boolean, Boolean>("edit_selected")

    @JvmField
    public val getCustomPopupRectName: MethodStringName0<Tree, Rect2> =
        MethodStringName0<Tree, Rect2>("get_custom_popup_rect")

    @JvmField
    public val getItemAreaRectName: MethodStringName3<Tree, Rect2, TreeItem?, Int, Int> =
        MethodStringName3<Tree, Rect2, TreeItem?, Int, Int>("get_item_area_rect")

    @JvmField
    public val getItemAtPositionName: MethodStringName1<Tree, TreeItem?, Vector2> =
        MethodStringName1<Tree, TreeItem?, Vector2>("get_item_at_position")

    @JvmField
    public val getColumnAtPositionName: MethodStringName1<Tree, Int, Vector2> =
        MethodStringName1<Tree, Int, Vector2>("get_column_at_position")

    @JvmField
    public val getDropSectionAtPositionName: MethodStringName1<Tree, Int, Vector2> =
        MethodStringName1<Tree, Int, Vector2>("get_drop_section_at_position")

    @JvmField
    public val getButtonIdAtPositionName: MethodStringName1<Tree, Int, Vector2> =
        MethodStringName1<Tree, Int, Vector2>("get_button_id_at_position")

    @JvmField
    public val ensureCursorIsVisibleName: MethodStringName0<Tree, Unit> =
        MethodStringName0<Tree, Unit>("ensure_cursor_is_visible")

    @JvmField
    public val setColumnTitlesVisibleName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_column_titles_visible")

    @JvmField
    public val areColumnTitlesVisibleName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("are_column_titles_visible")

    @JvmField
    public val setColumnTitleName: MethodStringName2<Tree, Unit, Int, String> =
        MethodStringName2<Tree, Unit, Int, String>("set_column_title")

    @JvmField
    public val getColumnTitleName: MethodStringName1<Tree, String, Int> =
        MethodStringName1<Tree, String, Int>("get_column_title")

    @JvmField
    public val setColumnTitleTooltipTextName: MethodStringName2<Tree, Unit, Int, String> =
        MethodStringName2<Tree, Unit, Int, String>("set_column_title_tooltip_text")

    @JvmField
    public val getColumnTitleTooltipTextName: MethodStringName1<Tree, String, Int> =
        MethodStringName1<Tree, String, Int>("get_column_title_tooltip_text")

    @JvmField
    public val setColumnTitleAlignmentName: MethodStringName2<Tree, Unit, Int, HorizontalAlignment>
        = MethodStringName2<Tree, Unit, Int, HorizontalAlignment>("set_column_title_alignment")

    @JvmField
    public val getColumnTitleAlignmentName: MethodStringName1<Tree, HorizontalAlignment, Int> =
        MethodStringName1<Tree, HorizontalAlignment, Int>("get_column_title_alignment")

    @JvmField
    public val setColumnTitleDirectionName:
        MethodStringName2<Tree, Unit, Int, Control.TextDirection> =
        MethodStringName2<Tree, Unit, Int, Control.TextDirection>("set_column_title_direction")

    @JvmField
    public val getColumnTitleDirectionName: MethodStringName1<Tree, Control.TextDirection, Int> =
        MethodStringName1<Tree, Control.TextDirection, Int>("get_column_title_direction")

    @JvmField
    public val setColumnTitleLanguageName: MethodStringName2<Tree, Unit, Int, String> =
        MethodStringName2<Tree, Unit, Int, String>("set_column_title_language")

    @JvmField
    public val getColumnTitleLanguageName: MethodStringName1<Tree, String, Int> =
        MethodStringName1<Tree, String, Int>("get_column_title_language")

    @JvmField
    public val getScrollName: MethodStringName0<Tree, Vector2> =
        MethodStringName0<Tree, Vector2>("get_scroll")

    @JvmField
    public val scrollToItemName: MethodStringName2<Tree, Unit, TreeItem?, Boolean> =
        MethodStringName2<Tree, Unit, TreeItem?, Boolean>("scroll_to_item")

    @JvmField
    public val setHScrollEnabledName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_h_scroll_enabled")

    @JvmField
    public val isHScrollEnabledName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_h_scroll_enabled")

    @JvmField
    public val setVScrollEnabledName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_v_scroll_enabled")

    @JvmField
    public val isVScrollEnabledName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_v_scroll_enabled")

    @JvmField
    public val setScrollHintModeName: MethodStringName1<Tree, Unit, ScrollHintMode> =
        MethodStringName1<Tree, Unit, ScrollHintMode>("set_scroll_hint_mode")

    @JvmField
    public val getScrollHintModeName: MethodStringName0<Tree, ScrollHintMode> =
        MethodStringName0<Tree, ScrollHintMode>("get_scroll_hint_mode")

    @JvmField
    public val setTileScrollHintName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_tile_scroll_hint")

    @JvmField
    public val isScrollHintTiledName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_scroll_hint_tiled")

    @JvmField
    public val setHideFoldingName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_hide_folding")

    @JvmField
    public val isFoldingHiddenName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_folding_hidden")

    @JvmField
    public val setEnableRecursiveFoldingName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_enable_recursive_folding")

    @JvmField
    public val isRecursiveFoldingEnabledName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_recursive_folding_enabled")

    @JvmField
    public val setEnableDragUnfoldingName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_enable_drag_unfolding")

    @JvmField
    public val isDragUnfoldingEnabledName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_drag_unfolding_enabled")

    @JvmField
    public val setDropModeFlagsName: MethodStringName1<Tree, Unit, Int> =
        MethodStringName1<Tree, Unit, Int>("set_drop_mode_flags")

    @JvmField
    public val getDropModeFlagsName: MethodStringName0<Tree, Int> =
        MethodStringName0<Tree, Int>("get_drop_mode_flags")

    @JvmField
    public val setAllowRmbSelectName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_allow_rmb_select")

    @JvmField
    public val getAllowRmbSelectName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("get_allow_rmb_select")

    @JvmField
    public val setAllowReselectName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_allow_reselect")

    @JvmField
    public val getAllowReselectName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("get_allow_reselect")

    @JvmField
    public val setAllowSearchName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_allow_search")

    @JvmField
    public val getAllowSearchName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("get_allow_search")

    @JvmField
    public val setAutoTooltipName: MethodStringName1<Tree, Unit, Boolean> =
        MethodStringName1<Tree, Unit, Boolean>("set_auto_tooltip")

    @JvmField
    public val isAutoTooltipEnabledName: MethodStringName0<Tree, Boolean> =
        MethodStringName0<Tree, Boolean>("is_auto_tooltip_enabled")
  }

  public object MethodBindings {
    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("Tree", "clear", 3218959716)

    internal val createItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "create_item", 528467046)

    internal val getRootPtr: VoidPtr = TypeManager.getMethodBindPtr("Tree", "get_root", 1514277247)

    internal val setColumnCustomMinimumWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_custom_minimum_width", 3937882851)

    internal val setColumnExpandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_expand", 300928843)

    internal val setColumnExpandRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_expand_ratio", 3937882851)

    internal val setColumnClipContentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_clip_content", 300928843)

    internal val isColumnExpandingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_column_expanding", 1116898809)

    internal val isColumnClippingContentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_column_clipping_content", 1116898809)

    internal val getColumnExpandRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_expand_ratio", 923996154)

    internal val getColumnWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_width", 923996154)

    internal val getCustomDrawingCanvasItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_custom_drawing_canvas_item", 2944877500)

    internal val setHideRootPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_hide_root", 2586408642)

    internal val isRootHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_root_hidden", 36873697)

    internal val getNextSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_next_selected", 873446299)

    internal val getSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_selected", 1514277247)

    internal val setSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_selected", 2662547442)

    internal val getSelectedColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_selected_column", 3905245786)

    internal val getPressedButtonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_pressed_button", 3905245786)

    internal val setSelectModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_select_mode", 3223887270)

    internal val getSelectModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_select_mode", 100748571)

    internal val deselectAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "deselect_all", 3218959716)

    internal val setColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_columns", 1286410249)

    internal val getColumnsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_columns", 3905245786)

    internal val getEditedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_edited", 1514277247)

    internal val getEditedColumnPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_edited_column", 3905245786)

    internal val editSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "edit_selected", 2595650253)

    internal val getCustomPopupRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_custom_popup_rect", 1639390495)

    internal val getItemAreaRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_item_area_rect", 47968679)

    internal val getItemAtPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_item_at_position", 4193340126)

    internal val getColumnAtPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_at_position", 3820158470)

    internal val getDropSectionAtPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_drop_section_at_position", 3820158470)

    internal val getButtonIdAtPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_button_id_at_position", 3820158470)

    internal val ensureCursorIsVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "ensure_cursor_is_visible", 3218959716)

    internal val setColumnTitlesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_titles_visible", 2586408642)

    internal val areColumnTitlesVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "are_column_titles_visible", 36873697)

    internal val setColumnTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_title", 501894301)

    internal val getColumnTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_title", 844755477)

    internal val setColumnTitleTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_title_tooltip_text", 501894301)

    internal val getColumnTitleTooltipTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_title_tooltip_text", 844755477)

    internal val setColumnTitleAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_title_alignment", 3276431499)

    internal val getColumnTitleAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_title_alignment", 4171562184)

    internal val setColumnTitleDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_title_direction", 1707680378)

    internal val getColumnTitleDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_title_direction", 4235602388)

    internal val setColumnTitleLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_column_title_language", 501894301)

    internal val getColumnTitleLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_column_title_language", 844755477)

    internal val getScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_scroll", 3341600327)

    internal val scrollToItemPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "scroll_to_item", 1314737213)

    internal val setHScrollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_h_scroll_enabled", 2586408642)

    internal val isHScrollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_h_scroll_enabled", 36873697)

    internal val setVScrollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_v_scroll_enabled", 2586408642)

    internal val isVScrollEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_v_scroll_enabled", 36873697)

    internal val setScrollHintModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_scroll_hint_mode", 415911924)

    internal val getScrollHintModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_scroll_hint_mode", 553087187)

    internal val setTileScrollHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_tile_scroll_hint", 2586408642)

    internal val isScrollHintTiledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_scroll_hint_tiled", 2240911060)

    internal val setHideFoldingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_hide_folding", 2586408642)

    internal val isFoldingHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_folding_hidden", 36873697)

    internal val setEnableRecursiveFoldingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_enable_recursive_folding", 2586408642)

    internal val isRecursiveFoldingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_recursive_folding_enabled", 36873697)

    internal val setEnableDragUnfoldingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_enable_drag_unfolding", 2586408642)

    internal val isDragUnfoldingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_drag_unfolding_enabled", 36873697)

    internal val setDropModeFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_drop_mode_flags", 1286410249)

    internal val getDropModeFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_drop_mode_flags", 3905245786)

    internal val setAllowRmbSelectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_allow_rmb_select", 2586408642)

    internal val getAllowRmbSelectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_allow_rmb_select", 36873697)

    internal val setAllowReselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_allow_reselect", 2586408642)

    internal val getAllowReselectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_allow_reselect", 36873697)

    internal val setAllowSearchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_allow_search", 2586408642)

    internal val getAllowSearchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "get_allow_search", 36873697)

    internal val setAutoTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "set_auto_tooltip", 2586408642)

    internal val isAutoTooltipEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Tree", "is_auto_tooltip_enabled", 36873697)
  }
}
