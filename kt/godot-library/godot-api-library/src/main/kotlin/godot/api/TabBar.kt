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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Rect2
import godot.core.Signal1
import godot.core.Vector2
import godot.readReturnValue_ANY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_RECT2
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_ANY
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_STRING_OBJECT
import godot.writeMethodArguments_VECTOR2
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
 * A control that provides a horizontal bar with tabs. Similar to [TabContainer] but is only in
 * charge of drawing tabs, not interacting with children.
 */
@GodotBaseType
public open class TabBar : Control() {
  /**
   * Emitted when a tab is selected via click, directional input, or script, even if it is the
   * current tab.
   */
  public val tabSelected: Signal1<Long> by Signal1

  /**
   * Emitted when switching to another tab.
   */
  public val tabChanged: Signal1<Long> by Signal1

  /**
   * Emitted when a tab is clicked, even if it is the current tab.
   */
  public val tabClicked: Signal1<Long> by Signal1

  /**
   * Emitted when a tab is right-clicked.
   */
  public val tabRmbClicked: Signal1<Long> by Signal1

  /**
   * Emitted when a tab's close button is pressed or, if [closeWithMiddleMouse] is `true`, when
   * middle-clicking on a tab.
   *
   * **Note:** Tabs are not removed automatically; this behavior needs to be coded manually. For
   * example:
   *
   * ```gdscript
   * //gdscript
   * $TabBar.tab_close_pressed.connect($TabBar.remove_tab)
   * ```
   *
   * ```csharp
   * //csharp
   * GetNode<TabBar>("TabBar").TabClosePressed += GetNode<TabBar>("TabBar").RemoveTab;
   * ```
   */
  public val tabClosePressed: Signal1<Long> by Signal1

  /**
   * Emitted when a tab's right button is pressed. See [setTabButtonIcon].
   */
  public val tabButtonPressed: Signal1<Long> by Signal1

  /**
   * Emitted when a tab is hovered by the mouse.
   */
  public val tabHovered: Signal1<Long> by Signal1

  /**
   * Emitted when the active tab is rearranged via mouse drag. See [dragToRearrangeEnabled].
   */
  public val activeTabRearranged: Signal1<Long> by Signal1

  /**
   * The index of the current selected tab. A value of `-1` means that no tab is selected and can
   * only be set when [deselectEnabled] is `true` or if all tabs are hidden or disabled.
   */
  public final inline var currentTab: Int
    @JvmName("currentTabProperty")
    get() = getCurrentTab()
    @JvmName("currentTabProperty")
    set(`value`) {
      setCurrentTab(value)
    }

  /**
   * The horizontal alignment of the tabs.
   */
  public final inline var tabAlignment: AlignmentMode
    @JvmName("tabAlignmentProperty")
    get() = getTabAlignment()
    @JvmName("tabAlignmentProperty")
    set(`value`) {
      setTabAlignment(value)
    }

  /**
   * If `true`, tabs overflowing this node's width will be hidden, displaying two navigation buttons
   * instead. Otherwise, this node's minimum size is updated so that all tabs are visible.
   */
  public final inline var clipTabs: Boolean
    @JvmName("clipTabsProperty")
    get() = getClipTabs()
    @JvmName("clipTabsProperty")
    set(`value`) {
      setClipTabs(value)
    }

  /**
   * If `true`, middle-clicking on a tab will emit the [signal tab_close_pressed] signal.
   */
  public final inline var closeWithMiddleMouse: Boolean
    @JvmName("closeWithMiddleMouseProperty")
    get() = getCloseWithMiddleMouse()
    @JvmName("closeWithMiddleMouseProperty")
    set(`value`) {
      setCloseWithMiddleMouse(value)
    }

  /**
   * When the close button will appear on the tabs.
   */
  public final inline var tabCloseDisplayPolicy: CloseButtonDisplayPolicy
    @JvmName("tabCloseDisplayPolicyProperty")
    get() = getTabCloseDisplayPolicy()
    @JvmName("tabCloseDisplayPolicyProperty")
    set(`value`) {
      setTabCloseDisplayPolicy(value)
    }

  /**
   * Sets the maximum width which all tabs should be limited to. Unlimited if set to `0`.
   */
  public final inline var maxTabWidth: Int
    @JvmName("maxTabWidthProperty")
    get() = getMaxTabWidth()
    @JvmName("maxTabWidthProperty")
    set(`value`) {
      setMaxTabWidth(value)
    }

  /**
   * if `true`, the mouse's scroll wheel can be used to navigate the scroll view.
   */
  public final inline var scrollingEnabled: Boolean
    @JvmName("scrollingEnabledProperty")
    get() = getScrollingEnabled()
    @JvmName("scrollingEnabledProperty")
    set(`value`) {
      setScrollingEnabled(value)
    }

  /**
   * If `true`, tabs can be rearranged with mouse drag.
   */
  public final inline var dragToRearrangeEnabled: Boolean
    @JvmName("dragToRearrangeEnabledProperty")
    get() = getDragToRearrangeEnabled()
    @JvmName("dragToRearrangeEnabledProperty")
    set(`value`) {
      setDragToRearrangeEnabled(value)
    }

  /**
   * If `true`, hovering over a tab while dragging something will switch to that tab. Does not have
   * effect when hovering another tab to rearrange. The delay for when this happens is dictated by
   * [theme_item hover_switch_wait_msec].
   */
  public final inline var switchOnDragHover: Boolean
    @JvmName("switchOnDragHoverProperty")
    get() = getSwitchOnDragHover()
    @JvmName("switchOnDragHoverProperty")
    set(`value`) {
      setSwitchOnDragHover(value)
    }

  /**
   * [TabBar]s with the same rearrange group ID will allow dragging the tabs between them. Enable
   * drag with [dragToRearrangeEnabled].
   *
   * Setting this to `-1` will disable rearranging between [TabBar]s.
   */
  public final inline var tabsRearrangeGroup: Int
    @JvmName("tabsRearrangeGroupProperty")
    get() = getTabsRearrangeGroup()
    @JvmName("tabsRearrangeGroupProperty")
    set(`value`) {
      setTabsRearrangeGroup(value)
    }

  /**
   * If `true`, the tab offset will be changed to keep the currently selected tab visible.
   */
  public final inline var scrollToSelected: Boolean
    @JvmName("scrollToSelectedProperty")
    get() = getScrollToSelected()
    @JvmName("scrollToSelectedProperty")
    set(`value`) {
      setScrollToSelected(value)
    }

  /**
   * If `true`, enables selecting a tab with the right mouse button.
   */
  public final inline var selectWithRmb: Boolean
    @JvmName("selectWithRmbProperty")
    get() = getSelectWithRmb()
    @JvmName("selectWithRmbProperty")
    set(`value`) {
      setSelectWithRmb(value)
    }

  /**
   * If `true`, all tabs can be deselected so that no tab is selected. Click on the current tab to
   * deselect it.
   */
  public final inline var deselectEnabled: Boolean
    @JvmName("deselectEnabledProperty")
    get() = getDeselectEnabled()
    @JvmName("deselectEnabledProperty")
    set(`value`) {
      setDeselectEnabled(value)
    }

  /**
   * The number of tabs currently in the bar.
   */
  public final inline var tabCount: Int
    @JvmName("tabCountProperty")
    get() = getTabCount()
    @JvmName("tabCountProperty")
    set(`value`) {
      setTabCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(728, scriptPtr)
  }

  public final fun setTabCount(count: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, count.toLong())
    TransferContext.callMethod(MethodBindings.setTabCountPtr)
  }

  public final fun getTabCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setCurrentTab(tabIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.setCurrentTabPtr)
  }

  public final fun getCurrentTab(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentTabPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the previously active tab index.
   */
  public final fun getPreviousTab(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPreviousTabPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Selects the first available tab with lower index than the currently selected. Returns `true` if
   * tab selection changed.
   */
  public final fun selectPreviousAvailable(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.selectPreviousAvailablePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Selects the first available tab with greater index than the currently selected. Returns `true`
   * if tab selection changed.
   */
  public final fun selectNextAvailable(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.selectNextAvailablePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets a [title] for the tab at index [tabIdx].
   */
  public final fun setTabTitle(tabIdx: Int, title: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, tabIdx.toLong(), title)
    TransferContext.callMethod(MethodBindings.setTabTitlePtr)
  }

  /**
   * Returns the title of the tab at index [tabIdx].
   */
  public final fun getTabTitle(tabIdx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabTitlePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets a [tooltip] for tab at index [tabIdx].
   *
   * **Note:** By default, if the [tooltip] is empty and the tab text is truncated (not all
   * characters fit into the tab), the title will be displayed as a tooltip. To hide the tooltip,
   * assign `" "` as the [tooltip] text.
   */
  public final fun setTabTooltip(tabIdx: Int, tooltip: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, tabIdx.toLong(), tooltip)
    TransferContext.callMethod(MethodBindings.setTabTooltipPtr)
  }

  /**
   * Returns the tooltip text of the tab at index [tabIdx].
   */
  public final fun getTabTooltip(tabIdx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabTooltipPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets tab title base writing direction.
   */
  public final fun setTabTextDirection(tabIdx: Int, direction: Control.TextDirection): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, tabIdx.toLong(), direction.value)
    TransferContext.callMethod(MethodBindings.setTabTextDirectionPtr)
  }

  /**
   * Returns tab title text base writing direction.
   */
  public final fun getTabTextDirection(tabIdx: Int): Control.TextDirection {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabTextDirectionPtr)
    return Control.TextDirection.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the language code of the title for the tab at index [tabIdx] to [language]. This is used
   * for line-breaking and text shaping algorithms. If [language] is empty, the current locale is used.
   */
  public final fun setTabLanguage(tabIdx: Int, language: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, tabIdx.toLong(), language)
    TransferContext.callMethod(MethodBindings.setTabLanguagePtr)
  }

  /**
   * Returns tab title language code.
   */
  public final fun getTabLanguage(tabIdx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabLanguagePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets an [icon] for the tab at index [tabIdx].
   */
  public final fun setTabIcon(tabIdx: Int, icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, tabIdx.toLong(), icon)
    TransferContext.callMethod(MethodBindings.setTabIconPtr)
  }

  /**
   * Returns the icon for the tab at index [tabIdx] or `null` if the tab has no icon.
   */
  public final fun getTabIcon(tabIdx: Int): Texture2D? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabIconPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  /**
   * Sets the maximum allowed width of the icon for the tab at index [tabIdx]. This limit is applied
   * on top of the default size of the icon and on top of [theme_item icon_max_width]. The height is
   * adjusted according to the icon's ratio.
   */
  public final fun setTabIconMaxWidth(tabIdx: Int, width: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, tabIdx.toLong(), width.toLong())
    TransferContext.callMethod(MethodBindings.setTabIconMaxWidthPtr)
  }

  /**
   * Returns the maximum allowed width of the icon for the tab at index [tabIdx].
   */
  public final fun getTabIconMaxWidth(tabIdx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabIconMaxWidthPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets an [icon] for the button of the tab at index [tabIdx] (located to the right, before the
   * close button), making it visible and clickable (See [signal tab_button_pressed]). Giving it a
   * `null` value will hide the button.
   */
  public final fun setTabButtonIcon(tabIdx: Int, icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, tabIdx.toLong(), icon)
    TransferContext.callMethod(MethodBindings.setTabButtonIconPtr)
  }

  /**
   * Returns the icon for the right button of the tab at index [tabIdx] or `null` if the right
   * button has no icon.
   */
  public final fun getTabButtonIcon(tabIdx: Int): Texture2D? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabButtonIconPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  /**
   * If [disabled] is `true`, disables the tab at index [tabIdx], making it non-interactable.
   */
  public final fun setTabDisabled(tabIdx: Int, disabled: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, tabIdx.toLong(), disabled)
    TransferContext.callMethod(MethodBindings.setTabDisabledPtr)
  }

  /**
   * Returns `true` if the tab at index [tabIdx] is disabled.
   */
  public final fun isTabDisabled(tabIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.isTabDisabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * If [hidden] is `true`, hides the tab at index [tabIdx], making it disappear from the tab area.
   */
  public final fun setTabHidden(tabIdx: Int, hidden: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, tabIdx.toLong(), hidden)
    TransferContext.callMethod(MethodBindings.setTabHiddenPtr)
  }

  /**
   * Returns `true` if the tab at index [tabIdx] is hidden.
   */
  public final fun isTabHidden(tabIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.isTabHiddenPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the metadata value for the tab at index [tabIdx], which can be retrieved later using
   * [getTabMetadata].
   */
  public final fun setTabMetadata(tabIdx: Int, metadata: Any?): Unit {
    TransferContext.writeMethodArguments_LONG_ANY(ptr, objectID.id, tabIdx.toLong(), metadata)
    TransferContext.callMethod(MethodBindings.setTabMetadataPtr)
  }

  /**
   * Returns the metadata value set to the tab at index [tabIdx] using [setTabMetadata]. If no
   * metadata was previously set, returns `null` by default.
   */
  public final fun getTabMetadata(tabIdx: Int): Any? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabMetadataPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Removes the tab at index [tabIdx].
   */
  public final fun removeTab(tabIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.removeTabPtr)
  }

  /**
   * Adds a new tab.
   */
  @JvmOverloads
  public final fun addTab(title: String = "", icon: Texture2D? = null): Unit {
    TransferContext.writeMethodArguments_STRING_OBJECT(ptr, objectID.id, title, icon)
    TransferContext.callMethod(MethodBindings.addTabPtr)
  }

  /**
   * Returns the index of the tab at local coordinates [point]. Returns `-1` if the point is outside
   * the control boundaries or if there's no tab at the queried position.
   */
  public final fun getTabIdxAtPoint(point: Vector2): Int {
    TransferContext.writeMethodArguments_VECTOR2(ptr, objectID.id, point)
    TransferContext.callMethod(MethodBindings.getTabIdxAtPointPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setTabAlignment(alignment: AlignmentMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callMethod(MethodBindings.setTabAlignmentPtr)
  }

  public final fun getTabAlignment(): AlignmentMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabAlignmentPtr)
    return AlignmentMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setClipTabs(clipTabs: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, clipTabs)
    TransferContext.callMethod(MethodBindings.setClipTabsPtr)
  }

  public final fun getClipTabs(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getClipTabsPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the number of hidden tabs offsetted to the left.
   */
  public final fun getTabOffset(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabOffsetPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if the offset buttons (the ones that appear when there's not enough space for
   * all tabs) are visible.
   */
  public final fun getOffsetButtonsVisible(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOffsetButtonsVisiblePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Moves the scroll view to make the tab visible.
   */
  public final fun ensureTabVisible(idx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, idx.toLong())
    TransferContext.callMethod(MethodBindings.ensureTabVisiblePtr)
  }

  /**
   * Returns tab [Rect2] with local position and size.
   */
  public final fun getTabRect(tabIdx: Int): Rect2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabRectPtr)
    return TransferContext.readReturnValue_RECT2()
  }

  /**
   * Moves a tab from [from] to [to].
   */
  public final fun moveTab(from: Int, to: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, from.toLong(), to.toLong())
    TransferContext.callMethod(MethodBindings.moveTabPtr)
  }

  public final fun setCloseWithMiddleMouse(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setCloseWithMiddleMousePtr)
  }

  public final fun getCloseWithMiddleMouse(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCloseWithMiddleMousePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTabCloseDisplayPolicy(policy: CloseButtonDisplayPolicy): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, policy.value)
    TransferContext.callMethod(MethodBindings.setTabCloseDisplayPolicyPtr)
  }

  public final fun getTabCloseDisplayPolicy(): CloseButtonDisplayPolicy {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabCloseDisplayPolicyPtr)
    return CloseButtonDisplayPolicy.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setMaxTabWidth(width: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, width.toLong())
    TransferContext.callMethod(MethodBindings.setMaxTabWidthPtr)
  }

  public final fun getMaxTabWidth(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxTabWidthPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setScrollingEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setScrollingEnabledPtr)
  }

  public final fun getScrollingEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollingEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDragToRearrangeEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setDragToRearrangeEnabledPtr)
  }

  public final fun getDragToRearrangeEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDragToRearrangeEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSwitchOnDragHover(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setSwitchOnDragHoverPtr)
  }

  public final fun getSwitchOnDragHover(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSwitchOnDragHoverPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTabsRearrangeGroup(groupId: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, groupId.toLong())
    TransferContext.callMethod(MethodBindings.setTabsRearrangeGroupPtr)
  }

  public final fun getTabsRearrangeGroup(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabsRearrangeGroupPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setScrollToSelected(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setScrollToSelectedPtr)
  }

  public final fun getScrollToSelected(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScrollToSelectedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSelectWithRmb(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setSelectWithRmbPtr)
  }

  public final fun getSelectWithRmb(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSelectWithRmbPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDeselectEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setDeselectEnabledPtr)
  }

  public final fun getDeselectEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDeselectEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Clears all tabs.
   */
  public final fun clearTabs(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearTabsPtr)
  }

  public enum class AlignmentMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Aligns tabs to the left.
     */
    LEFT(0),
    /**
     * Aligns tabs in the middle.
     */
    CENTER(1),
    /**
     * Aligns tabs to the right.
     */
    RIGHT(2),
    /**
     * Represents the size of the [AlignmentMode] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): AlignmentMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CloseButtonDisplayPolicy(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Never show the close buttons.
     */
    SHOW_NEVER(0),
    /**
     * Only show the close button on the currently active tab.
     */
    SHOW_ACTIVE_ONLY(1),
    /**
     * Show the close button on all tabs.
     */
    SHOW_ALWAYS(2),
    /**
     * Represents the size of the [CloseButtonDisplayPolicy] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): CloseButtonDisplayPolicy =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTabCountName: MethodStringName1<TabBar, Unit, Int> =
        MethodStringName1<TabBar, Unit, Int>("set_tab_count")

    @JvmField
    public val getTabCountName: MethodStringName0<TabBar, Int> =
        MethodStringName0<TabBar, Int>("get_tab_count")

    @JvmField
    public val setCurrentTabName: MethodStringName1<TabBar, Unit, Int> =
        MethodStringName1<TabBar, Unit, Int>("set_current_tab")

    @JvmField
    public val getCurrentTabName: MethodStringName0<TabBar, Int> =
        MethodStringName0<TabBar, Int>("get_current_tab")

    @JvmField
    public val getPreviousTabName: MethodStringName0<TabBar, Int> =
        MethodStringName0<TabBar, Int>("get_previous_tab")

    @JvmField
    public val selectPreviousAvailableName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("select_previous_available")

    @JvmField
    public val selectNextAvailableName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("select_next_available")

    @JvmField
    public val setTabTitleName: MethodStringName2<TabBar, Unit, Int, String> =
        MethodStringName2<TabBar, Unit, Int, String>("set_tab_title")

    @JvmField
    public val getTabTitleName: MethodStringName1<TabBar, String, Int> =
        MethodStringName1<TabBar, String, Int>("get_tab_title")

    @JvmField
    public val setTabTooltipName: MethodStringName2<TabBar, Unit, Int, String> =
        MethodStringName2<TabBar, Unit, Int, String>("set_tab_tooltip")

    @JvmField
    public val getTabTooltipName: MethodStringName1<TabBar, String, Int> =
        MethodStringName1<TabBar, String, Int>("get_tab_tooltip")

    @JvmField
    public val setTabTextDirectionName: MethodStringName2<TabBar, Unit, Int, Control.TextDirection>
        = MethodStringName2<TabBar, Unit, Int, Control.TextDirection>("set_tab_text_direction")

    @JvmField
    public val getTabTextDirectionName: MethodStringName1<TabBar, Control.TextDirection, Int> =
        MethodStringName1<TabBar, Control.TextDirection, Int>("get_tab_text_direction")

    @JvmField
    public val setTabLanguageName: MethodStringName2<TabBar, Unit, Int, String> =
        MethodStringName2<TabBar, Unit, Int, String>("set_tab_language")

    @JvmField
    public val getTabLanguageName: MethodStringName1<TabBar, String, Int> =
        MethodStringName1<TabBar, String, Int>("get_tab_language")

    @JvmField
    public val setTabIconName: MethodStringName2<TabBar, Unit, Int, Texture2D?> =
        MethodStringName2<TabBar, Unit, Int, Texture2D?>("set_tab_icon")

    @JvmField
    public val getTabIconName: MethodStringName1<TabBar, Texture2D?, Int> =
        MethodStringName1<TabBar, Texture2D?, Int>("get_tab_icon")

    @JvmField
    public val setTabIconMaxWidthName: MethodStringName2<TabBar, Unit, Int, Int> =
        MethodStringName2<TabBar, Unit, Int, Int>("set_tab_icon_max_width")

    @JvmField
    public val getTabIconMaxWidthName: MethodStringName1<TabBar, Int, Int> =
        MethodStringName1<TabBar, Int, Int>("get_tab_icon_max_width")

    @JvmField
    public val setTabButtonIconName: MethodStringName2<TabBar, Unit, Int, Texture2D?> =
        MethodStringName2<TabBar, Unit, Int, Texture2D?>("set_tab_button_icon")

    @JvmField
    public val getTabButtonIconName: MethodStringName1<TabBar, Texture2D?, Int> =
        MethodStringName1<TabBar, Texture2D?, Int>("get_tab_button_icon")

    @JvmField
    public val setTabDisabledName: MethodStringName2<TabBar, Unit, Int, Boolean> =
        MethodStringName2<TabBar, Unit, Int, Boolean>("set_tab_disabled")

    @JvmField
    public val isTabDisabledName: MethodStringName1<TabBar, Boolean, Int> =
        MethodStringName1<TabBar, Boolean, Int>("is_tab_disabled")

    @JvmField
    public val setTabHiddenName: MethodStringName2<TabBar, Unit, Int, Boolean> =
        MethodStringName2<TabBar, Unit, Int, Boolean>("set_tab_hidden")

    @JvmField
    public val isTabHiddenName: MethodStringName1<TabBar, Boolean, Int> =
        MethodStringName1<TabBar, Boolean, Int>("is_tab_hidden")

    @JvmField
    public val setTabMetadataName: MethodStringName2<TabBar, Unit, Int, Any?> =
        MethodStringName2<TabBar, Unit, Int, Any?>("set_tab_metadata")

    @JvmField
    public val getTabMetadataName: MethodStringName1<TabBar, Any?, Int> =
        MethodStringName1<TabBar, Any?, Int>("get_tab_metadata")

    @JvmField
    public val removeTabName: MethodStringName1<TabBar, Unit, Int> =
        MethodStringName1<TabBar, Unit, Int>("remove_tab")

    @JvmField
    public val addTabName: MethodStringName2<TabBar, Unit, String, Texture2D?> =
        MethodStringName2<TabBar, Unit, String, Texture2D?>("add_tab")

    @JvmField
    public val getTabIdxAtPointName: MethodStringName1<TabBar, Int, Vector2> =
        MethodStringName1<TabBar, Int, Vector2>("get_tab_idx_at_point")

    @JvmField
    public val setTabAlignmentName: MethodStringName1<TabBar, Unit, AlignmentMode> =
        MethodStringName1<TabBar, Unit, AlignmentMode>("set_tab_alignment")

    @JvmField
    public val getTabAlignmentName: MethodStringName0<TabBar, AlignmentMode> =
        MethodStringName0<TabBar, AlignmentMode>("get_tab_alignment")

    @JvmField
    public val setClipTabsName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_clip_tabs")

    @JvmField
    public val getClipTabsName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_clip_tabs")

    @JvmField
    public val getTabOffsetName: MethodStringName0<TabBar, Int> =
        MethodStringName0<TabBar, Int>("get_tab_offset")

    @JvmField
    public val getOffsetButtonsVisibleName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_offset_buttons_visible")

    @JvmField
    public val ensureTabVisibleName: MethodStringName1<TabBar, Unit, Int> =
        MethodStringName1<TabBar, Unit, Int>("ensure_tab_visible")

    @JvmField
    public val getTabRectName: MethodStringName1<TabBar, Rect2, Int> =
        MethodStringName1<TabBar, Rect2, Int>("get_tab_rect")

    @JvmField
    public val moveTabName: MethodStringName2<TabBar, Unit, Int, Int> =
        MethodStringName2<TabBar, Unit, Int, Int>("move_tab")

    @JvmField
    public val setCloseWithMiddleMouseName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_close_with_middle_mouse")

    @JvmField
    public val getCloseWithMiddleMouseName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_close_with_middle_mouse")

    @JvmField
    public val setTabCloseDisplayPolicyName:
        MethodStringName1<TabBar, Unit, CloseButtonDisplayPolicy> =
        MethodStringName1<TabBar, Unit, CloseButtonDisplayPolicy>("set_tab_close_display_policy")

    @JvmField
    public val getTabCloseDisplayPolicyName: MethodStringName0<TabBar, CloseButtonDisplayPolicy> =
        MethodStringName0<TabBar, CloseButtonDisplayPolicy>("get_tab_close_display_policy")

    @JvmField
    public val setMaxTabWidthName: MethodStringName1<TabBar, Unit, Int> =
        MethodStringName1<TabBar, Unit, Int>("set_max_tab_width")

    @JvmField
    public val getMaxTabWidthName: MethodStringName0<TabBar, Int> =
        MethodStringName0<TabBar, Int>("get_max_tab_width")

    @JvmField
    public val setScrollingEnabledName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_scrolling_enabled")

    @JvmField
    public val getScrollingEnabledName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_scrolling_enabled")

    @JvmField
    public val setDragToRearrangeEnabledName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_drag_to_rearrange_enabled")

    @JvmField
    public val getDragToRearrangeEnabledName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_drag_to_rearrange_enabled")

    @JvmField
    public val setSwitchOnDragHoverName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_switch_on_drag_hover")

    @JvmField
    public val getSwitchOnDragHoverName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_switch_on_drag_hover")

    @JvmField
    public val setTabsRearrangeGroupName: MethodStringName1<TabBar, Unit, Int> =
        MethodStringName1<TabBar, Unit, Int>("set_tabs_rearrange_group")

    @JvmField
    public val getTabsRearrangeGroupName: MethodStringName0<TabBar, Int> =
        MethodStringName0<TabBar, Int>("get_tabs_rearrange_group")

    @JvmField
    public val setScrollToSelectedName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_scroll_to_selected")

    @JvmField
    public val getScrollToSelectedName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_scroll_to_selected")

    @JvmField
    public val setSelectWithRmbName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_select_with_rmb")

    @JvmField
    public val getSelectWithRmbName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_select_with_rmb")

    @JvmField
    public val setDeselectEnabledName: MethodStringName1<TabBar, Unit, Boolean> =
        MethodStringName1<TabBar, Unit, Boolean>("set_deselect_enabled")

    @JvmField
    public val getDeselectEnabledName: MethodStringName0<TabBar, Boolean> =
        MethodStringName0<TabBar, Boolean>("get_deselect_enabled")

    @JvmField
    public val clearTabsName: MethodStringName0<TabBar, Unit> =
        MethodStringName0<TabBar, Unit>("clear_tabs")
  }

  public object MethodBindings {
    internal val setTabCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_count", 1286410249)

    internal val getTabCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_count", 3905245786)

    internal val setCurrentTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_current_tab", 1286410249)

    internal val getCurrentTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_current_tab", 3905245786)

    internal val getPreviousTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_previous_tab", 3905245786)

    internal val selectPreviousAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "select_previous_available", 2240911060)

    internal val selectNextAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "select_next_available", 2240911060)

    internal val setTabTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_title", 501894301)

    internal val getTabTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_title", 844755477)

    internal val setTabTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_tooltip", 501894301)

    internal val getTabTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_tooltip", 844755477)

    internal val setTabTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_text_direction", 1707680378)

    internal val getTabTextDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_text_direction", 4235602388)

    internal val setTabLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_language", 501894301)

    internal val getTabLanguagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_language", 844755477)

    internal val setTabIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_icon", 666127730)

    internal val getTabIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_icon", 3536238170)

    internal val setTabIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_icon_max_width", 3937882851)

    internal val getTabIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_icon_max_width", 923996154)

    internal val setTabButtonIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_button_icon", 666127730)

    internal val getTabButtonIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_button_icon", 3536238170)

    internal val setTabDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_disabled", 300928843)

    internal val isTabDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "is_tab_disabled", 1116898809)

    internal val setTabHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_hidden", 300928843)

    internal val isTabHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "is_tab_hidden", 1116898809)

    internal val setTabMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_metadata", 2152698145)

    internal val getTabMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_metadata", 4227898402)

    internal val removeTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "remove_tab", 1286410249)

    internal val addTabPtr: VoidPtr = TypeManager.getMethodBindPtr("TabBar", "add_tab", 1465444425)

    internal val getTabIdxAtPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_idx_at_point", 3820158470)

    internal val setTabAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_alignment", 2413632353)

    internal val getTabAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_alignment", 2178122193)

    internal val setClipTabsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_clip_tabs", 2586408642)

    internal val getClipTabsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_clip_tabs", 36873697)

    internal val getTabOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_offset", 3905245786)

    internal val getOffsetButtonsVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_offset_buttons_visible", 36873697)

    internal val ensureTabVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "ensure_tab_visible", 1286410249)

    internal val getTabRectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_rect", 3327874267)

    internal val moveTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "move_tab", 3937882851)

    internal val setCloseWithMiddleMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_close_with_middle_mouse", 2586408642)

    internal val getCloseWithMiddleMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_close_with_middle_mouse", 36873697)

    internal val setTabCloseDisplayPolicyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tab_close_display_policy", 2212906737)

    internal val getTabCloseDisplayPolicyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tab_close_display_policy", 2956568028)

    internal val setMaxTabWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_max_tab_width", 1286410249)

    internal val getMaxTabWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_max_tab_width", 3905245786)

    internal val setScrollingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_scrolling_enabled", 2586408642)

    internal val getScrollingEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_scrolling_enabled", 36873697)

    internal val setDragToRearrangeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_drag_to_rearrange_enabled", 2586408642)

    internal val getDragToRearrangeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_drag_to_rearrange_enabled", 36873697)

    internal val setSwitchOnDragHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_switch_on_drag_hover", 2586408642)

    internal val getSwitchOnDragHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_switch_on_drag_hover", 36873697)

    internal val setTabsRearrangeGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_tabs_rearrange_group", 1286410249)

    internal val getTabsRearrangeGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_tabs_rearrange_group", 3905245786)

    internal val setScrollToSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_scroll_to_selected", 2586408642)

    internal val getScrollToSelectedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_scroll_to_selected", 36873697)

    internal val setSelectWithRmbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_select_with_rmb", 2586408642)

    internal val getSelectWithRmbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_select_with_rmb", 36873697)

    internal val setDeselectEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "set_deselect_enabled", 2586408642)

    internal val getDeselectEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "get_deselect_enabled", 36873697)

    internal val clearTabsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabBar", "clear_tabs", 3218959716)
  }
}
