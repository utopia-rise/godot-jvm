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
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Vector2
import godot.readReturnValue_ANY
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_ANY
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_OBJECT
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

/**
 * Arranges child controls into a tabbed view, creating a tab for each one. The active tab's
 * corresponding control is made visible, while all other child controls are hidden. Ignores
 * non-control children.
 *
 * **Note:** The drawing of the clickable tabs is handled by this node; [TabBar] is not needed.
 */
@GodotBaseType
public open class TabContainer : Container() {
  /**
   * Emitted when the active tab is rearranged via mouse drag. See [dragToRearrangeEnabled].
   */
  public val activeTabRearranged: Signal1<Long> by Signal1

  /**
   * Emitted when switching to another tab.
   */
  public val tabChanged: Signal1<Long> by Signal1

  /**
   * Emitted when a tab is clicked, even if it is the current tab.
   */
  public val tabClicked: Signal1<Long> by Signal1

  /**
   * Emitted when a tab is hovered by the mouse.
   */
  public val tabHovered: Signal1<Long> by Signal1

  /**
   * Emitted when a tab is selected via click, directional input, or script, even if it is the
   * current tab.
   */
  public val tabSelected: Signal1<Long> by Signal1

  /**
   * Emitted when the user clicks on the button icon on this tab.
   */
  public val tabButtonPressed: Signal1<Long> by Signal1

  /**
   * Emitted when the [TabContainer]'s [Popup] button is clicked. See [setPopup] for details.
   */
  public val prePopupPressed: Signal0 by Signal0

  /**
   * The position at which tabs will be placed.
   */
  public final inline var tabAlignment: TabBar.AlignmentMode
    @JvmName("tabAlignmentProperty")
    get() = getTabAlignment()
    @JvmName("tabAlignmentProperty")
    set(`value`) {
      setTabAlignment(value)
    }

  /**
   * The current tab index. When set, this index's [Control] node's `visible` property is set to
   * `true` and all others are set to `false`.
   *
   * A value of `-1` means that no tab is selected.
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
  public final inline var tabsPosition: TabPosition
    @JvmName("tabsPositionProperty")
    get() = getTabsPosition()
    @JvmName("tabsPositionProperty")
    set(`value`) {
      setTabsPosition(value)
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
   * If `true`, tabs are visible. If `false`, tabs' content and titles are hidden.
   */
  public final inline var tabsVisible: Boolean
    @JvmName("tabsVisibleProperty")
    get() = areTabsVisible()
    @JvmName("tabsVisibleProperty")
    set(`value`) {
      setTabsVisible(value)
    }

  /**
   * This doesn't do anything.
   */
  public final inline var allTabsInFront: Boolean
    @JvmName("allTabsInFrontProperty")
    get() = isAllTabsInFront()
    @JvmName("allTabsInFrontProperty")
    set(`value`) {
      setAllTabsInFront(value)
    }

  /**
   * If `true`, hovering over a tab while dragging something will switch to that tab. Does not have
   * effect when hovering another tab to rearrange.
   */
  public final inline var switchOnDragHover: Boolean
    @JvmName("switchOnDragHoverProperty")
    get() = getSwitchOnDragHover()
    @JvmName("switchOnDragHoverProperty")
    set(`value`) {
      setSwitchOnDragHover(value)
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
   * [TabContainer]s with the same rearrange group ID will allow dragging the tabs between them.
   * Enable drag with [dragToRearrangeEnabled].
   *
   * Setting this to `-1` will disable rearranging between [TabContainer]s.
   */
  public final inline var tabsRearrangeGroup: Int
    @JvmName("tabsRearrangeGroupProperty")
    get() = getTabsRearrangeGroup()
    @JvmName("tabsRearrangeGroupProperty")
    set(`value`) {
      setTabsRearrangeGroup(value)
    }

  /**
   * If `true`, child [Control] nodes that are hidden have their minimum size take into account in
   * the total, instead of only the currently visible one.
   */
  public final inline var useHiddenTabsForMinSize: Boolean
    @JvmName("useHiddenTabsForMinSizeProperty")
    get() = getUseHiddenTabsForMinSize()
    @JvmName("useHiddenTabsForMinSizeProperty")
    set(`value`) {
      setUseHiddenTabsForMinSize(value)
    }

  /**
   * The focus access mode for the internal [TabBar] node.
   */
  public final inline var tabFocusMode: Control.FocusMode
    @JvmName("tabFocusModeProperty")
    get() = getTabFocusMode()
    @JvmName("tabFocusModeProperty")
    set(`value`) {
      setTabFocusMode(value)
    }

  /**
   * If `true`, all tabs can be deselected so that no tab is selected. Click on the [currentTab] to
   * deselect it.
   *
   * Only the tab header will be shown if no tabs are selected.
   */
  public final inline var deselectEnabled: Boolean
    @JvmName("deselectEnabledProperty")
    get() = getDeselectEnabled()
    @JvmName("deselectEnabledProperty")
    set(`value`) {
      setDeselectEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(729, scriptPtr)
  }

  /**
   * Returns the number of tabs.
   */
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
   * Returns the child [Control] node located at the active tab index.
   */
  public final fun getCurrentTabControl(): Control? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentTabControlPtr)
    return (TransferContext.readReturnValue_OBJECT() as Control?)
  }

  /**
   * Returns the [TabBar] contained in this container.
   *
   * **Warning:** This is a required internal node, removing and freeing it or editing its tabs may
   * cause a crash. If you wish to edit the tabs, use the methods provided in [TabContainer].
   */
  public final fun getTabBar(): TabBar? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabBarPtr)
    return (TransferContext.readReturnValue_OBJECT() as TabBar?)
  }

  /**
   * Returns the [Control] node from the tab at index [tabIdx].
   */
  public final fun getTabControl(tabIdx: Int): Control? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabControlPtr)
    return (TransferContext.readReturnValue_OBJECT() as Control?)
  }

  public final fun setTabAlignment(alignment: TabBar.AlignmentMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, alignment.value)
    TransferContext.callMethod(MethodBindings.setTabAlignmentPtr)
  }

  public final fun getTabAlignment(): TabBar.AlignmentMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabAlignmentPtr)
    return TabBar.AlignmentMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTabsPosition(tabsPosition: TabPosition): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabsPosition.value)
    TransferContext.callMethod(MethodBindings.setTabsPositionPtr)
  }

  public final fun getTabsPosition(): TabPosition {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabsPositionPtr)
    return TabPosition.from(TransferContext.readReturnValue_LONG())
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

  public final fun setTabsVisible(visible: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, visible)
    TransferContext.callMethod(MethodBindings.setTabsVisiblePtr)
  }

  public final fun areTabsVisible(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areTabsVisiblePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAllTabsInFront(isFront: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, isFront)
    TransferContext.callMethod(MethodBindings.setAllTabsInFrontPtr)
  }

  public final fun isAllTabsInFront(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAllTabsInFrontPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets a custom title for the tab at index [tabIdx] (tab titles default to the name of the
   * indexed child node). Set it back to the child's name to make the tab default to it again.
   */
  public final fun setTabTitle(tabIdx: Int, title: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, tabIdx.toLong(), title)
    TransferContext.callMethod(MethodBindings.setTabTitlePtr)
  }

  /**
   * Returns the title of the tab at index [tabIdx]. Tab titles default to the name of the indexed
   * child node, but this can be overridden with [setTabTitle].
   */
  public final fun getTabTitle(tabIdx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabTitlePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets a custom tooltip text for tab at index [tabIdx].
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
   * Sets an icon for the tab at index [tabIdx].
   */
  public final fun setTabIcon(tabIdx: Int, icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, tabIdx.toLong(), icon)
    TransferContext.callMethod(MethodBindings.setTabIconPtr)
  }

  /**
   * Returns the [Texture2D] for the tab at index [tabIdx] or `null` if the tab has no [Texture2D].
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
   * Sets the button icon from the tab at index [tabIdx].
   */
  public final fun setTabButtonIcon(tabIdx: Int, icon: Texture2D?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, tabIdx.toLong(), icon)
    TransferContext.callMethod(MethodBindings.setTabButtonIconPtr)
  }

  /**
   * Returns the button icon from the tab at index [tabIdx].
   */
  public final fun getTabButtonIcon(tabIdx: Int): Texture2D? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, tabIdx.toLong())
    TransferContext.callMethod(MethodBindings.getTabButtonIconPtr)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
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

  /**
   * Returns the index of the tab tied to the given [control]. The control must be a child of the
   * [TabContainer].
   */
  public final fun getTabIdxFromControl(control: Control?): Int {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, control)
    TransferContext.callMethod(MethodBindings.getTabIdxFromControlPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * If set on a [Popup] node instance, a popup menu icon appears in the top-right corner of the
   * [TabContainer] (setting it to `null` will make it go away). Clicking it will expand the [Popup]
   * node.
   */
  public final fun setPopup(popup: Node?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, popup)
    TransferContext.callMethod(MethodBindings.setPopupPtr)
  }

  /**
   * Returns the [Popup] node instance if one has been set already with [setPopup].
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to hide it or any of its children, use their [Window.visible] property.
   */
  public final fun getPopup(): Popup? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPopupPtr)
    return (TransferContext.readReturnValue_OBJECT() as Popup?)
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

  public final fun setDragToRearrangeEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setDragToRearrangeEnabledPtr)
  }

  public final fun getDragToRearrangeEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDragToRearrangeEnabledPtr)
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

  public final fun setUseHiddenTabsForMinSize(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setUseHiddenTabsForMinSizePtr)
  }

  public final fun getUseHiddenTabsForMinSize(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseHiddenTabsForMinSizePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTabFocusMode(focusMode: Control.FocusMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, focusMode.value)
    TransferContext.callMethod(MethodBindings.setTabFocusModePtr)
  }

  public final fun getTabFocusMode(): Control.FocusMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTabFocusModePtr)
    return Control.FocusMode.from(TransferContext.readReturnValue_LONG())
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

  public enum class TabPosition(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Places the tab bar at the top.
     */
    POSITION_TOP(0),
    /**
     * Places the tab bar at the bottom. The tab bar's [StyleBox] will be flipped vertically.
     */
    POSITION_BOTTOM(1),
    /**
     * Represents the size of the [TabPosition] enum.
     */
    POSITION_MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): TabPosition = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getTabCountName: MethodStringName0<TabContainer, Int> =
        MethodStringName0<TabContainer, Int>("get_tab_count")

    @JvmField
    public val setCurrentTabName: MethodStringName1<TabContainer, Unit, Int> =
        MethodStringName1<TabContainer, Unit, Int>("set_current_tab")

    @JvmField
    public val getCurrentTabName: MethodStringName0<TabContainer, Int> =
        MethodStringName0<TabContainer, Int>("get_current_tab")

    @JvmField
    public val getPreviousTabName: MethodStringName0<TabContainer, Int> =
        MethodStringName0<TabContainer, Int>("get_previous_tab")

    @JvmField
    public val selectPreviousAvailableName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("select_previous_available")

    @JvmField
    public val selectNextAvailableName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("select_next_available")

    @JvmField
    public val getCurrentTabControlName: MethodStringName0<TabContainer, Control?> =
        MethodStringName0<TabContainer, Control?>("get_current_tab_control")

    @JvmField
    public val getTabBarName: MethodStringName0<TabContainer, TabBar?> =
        MethodStringName0<TabContainer, TabBar?>("get_tab_bar")

    @JvmField
    public val getTabControlName: MethodStringName1<TabContainer, Control?, Int> =
        MethodStringName1<TabContainer, Control?, Int>("get_tab_control")

    @JvmField
    public val setTabAlignmentName: MethodStringName1<TabContainer, Unit, TabBar.AlignmentMode> =
        MethodStringName1<TabContainer, Unit, TabBar.AlignmentMode>("set_tab_alignment")

    @JvmField
    public val getTabAlignmentName: MethodStringName0<TabContainer, TabBar.AlignmentMode> =
        MethodStringName0<TabContainer, TabBar.AlignmentMode>("get_tab_alignment")

    @JvmField
    public val setTabsPositionName: MethodStringName1<TabContainer, Unit, TabPosition> =
        MethodStringName1<TabContainer, Unit, TabPosition>("set_tabs_position")

    @JvmField
    public val getTabsPositionName: MethodStringName0<TabContainer, TabPosition> =
        MethodStringName0<TabContainer, TabPosition>("get_tabs_position")

    @JvmField
    public val setClipTabsName: MethodStringName1<TabContainer, Unit, Boolean> =
        MethodStringName1<TabContainer, Unit, Boolean>("set_clip_tabs")

    @JvmField
    public val getClipTabsName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("get_clip_tabs")

    @JvmField
    public val setTabsVisibleName: MethodStringName1<TabContainer, Unit, Boolean> =
        MethodStringName1<TabContainer, Unit, Boolean>("set_tabs_visible")

    @JvmField
    public val areTabsVisibleName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("are_tabs_visible")

    @JvmField
    public val setAllTabsInFrontName: MethodStringName1<TabContainer, Unit, Boolean> =
        MethodStringName1<TabContainer, Unit, Boolean>("set_all_tabs_in_front")

    @JvmField
    public val isAllTabsInFrontName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("is_all_tabs_in_front")

    @JvmField
    public val setTabTitleName: MethodStringName2<TabContainer, Unit, Int, String> =
        MethodStringName2<TabContainer, Unit, Int, String>("set_tab_title")

    @JvmField
    public val getTabTitleName: MethodStringName1<TabContainer, String, Int> =
        MethodStringName1<TabContainer, String, Int>("get_tab_title")

    @JvmField
    public val setTabTooltipName: MethodStringName2<TabContainer, Unit, Int, String> =
        MethodStringName2<TabContainer, Unit, Int, String>("set_tab_tooltip")

    @JvmField
    public val getTabTooltipName: MethodStringName1<TabContainer, String, Int> =
        MethodStringName1<TabContainer, String, Int>("get_tab_tooltip")

    @JvmField
    public val setTabIconName: MethodStringName2<TabContainer, Unit, Int, Texture2D?> =
        MethodStringName2<TabContainer, Unit, Int, Texture2D?>("set_tab_icon")

    @JvmField
    public val getTabIconName: MethodStringName1<TabContainer, Texture2D?, Int> =
        MethodStringName1<TabContainer, Texture2D?, Int>("get_tab_icon")

    @JvmField
    public val setTabIconMaxWidthName: MethodStringName2<TabContainer, Unit, Int, Int> =
        MethodStringName2<TabContainer, Unit, Int, Int>("set_tab_icon_max_width")

    @JvmField
    public val getTabIconMaxWidthName: MethodStringName1<TabContainer, Int, Int> =
        MethodStringName1<TabContainer, Int, Int>("get_tab_icon_max_width")

    @JvmField
    public val setTabDisabledName: MethodStringName2<TabContainer, Unit, Int, Boolean> =
        MethodStringName2<TabContainer, Unit, Int, Boolean>("set_tab_disabled")

    @JvmField
    public val isTabDisabledName: MethodStringName1<TabContainer, Boolean, Int> =
        MethodStringName1<TabContainer, Boolean, Int>("is_tab_disabled")

    @JvmField
    public val setTabHiddenName: MethodStringName2<TabContainer, Unit, Int, Boolean> =
        MethodStringName2<TabContainer, Unit, Int, Boolean>("set_tab_hidden")

    @JvmField
    public val isTabHiddenName: MethodStringName1<TabContainer, Boolean, Int> =
        MethodStringName1<TabContainer, Boolean, Int>("is_tab_hidden")

    @JvmField
    public val setTabMetadataName: MethodStringName2<TabContainer, Unit, Int, Any?> =
        MethodStringName2<TabContainer, Unit, Int, Any?>("set_tab_metadata")

    @JvmField
    public val getTabMetadataName: MethodStringName1<TabContainer, Any?, Int> =
        MethodStringName1<TabContainer, Any?, Int>("get_tab_metadata")

    @JvmField
    public val setTabButtonIconName: MethodStringName2<TabContainer, Unit, Int, Texture2D?> =
        MethodStringName2<TabContainer, Unit, Int, Texture2D?>("set_tab_button_icon")

    @JvmField
    public val getTabButtonIconName: MethodStringName1<TabContainer, Texture2D?, Int> =
        MethodStringName1<TabContainer, Texture2D?, Int>("get_tab_button_icon")

    @JvmField
    public val getTabIdxAtPointName: MethodStringName1<TabContainer, Int, Vector2> =
        MethodStringName1<TabContainer, Int, Vector2>("get_tab_idx_at_point")

    @JvmField
    public val getTabIdxFromControlName: MethodStringName1<TabContainer, Int, Control?> =
        MethodStringName1<TabContainer, Int, Control?>("get_tab_idx_from_control")

    @JvmField
    public val setPopupName: MethodStringName1<TabContainer, Unit, Node?> =
        MethodStringName1<TabContainer, Unit, Node?>("set_popup")

    @JvmField
    public val getPopupName: MethodStringName0<TabContainer, Popup?> =
        MethodStringName0<TabContainer, Popup?>("get_popup")

    @JvmField
    public val setSwitchOnDragHoverName: MethodStringName1<TabContainer, Unit, Boolean> =
        MethodStringName1<TabContainer, Unit, Boolean>("set_switch_on_drag_hover")

    @JvmField
    public val getSwitchOnDragHoverName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("get_switch_on_drag_hover")

    @JvmField
    public val setDragToRearrangeEnabledName: MethodStringName1<TabContainer, Unit, Boolean> =
        MethodStringName1<TabContainer, Unit, Boolean>("set_drag_to_rearrange_enabled")

    @JvmField
    public val getDragToRearrangeEnabledName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("get_drag_to_rearrange_enabled")

    @JvmField
    public val setTabsRearrangeGroupName: MethodStringName1<TabContainer, Unit, Int> =
        MethodStringName1<TabContainer, Unit, Int>("set_tabs_rearrange_group")

    @JvmField
    public val getTabsRearrangeGroupName: MethodStringName0<TabContainer, Int> =
        MethodStringName0<TabContainer, Int>("get_tabs_rearrange_group")

    @JvmField
    public val setUseHiddenTabsForMinSizeName: MethodStringName1<TabContainer, Unit, Boolean> =
        MethodStringName1<TabContainer, Unit, Boolean>("set_use_hidden_tabs_for_min_size")

    @JvmField
    public val getUseHiddenTabsForMinSizeName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("get_use_hidden_tabs_for_min_size")

    @JvmField
    public val setTabFocusModeName: MethodStringName1<TabContainer, Unit, Control.FocusMode> =
        MethodStringName1<TabContainer, Unit, Control.FocusMode>("set_tab_focus_mode")

    @JvmField
    public val getTabFocusModeName: MethodStringName0<TabContainer, Control.FocusMode> =
        MethodStringName0<TabContainer, Control.FocusMode>("get_tab_focus_mode")

    @JvmField
    public val setDeselectEnabledName: MethodStringName1<TabContainer, Unit, Boolean> =
        MethodStringName1<TabContainer, Unit, Boolean>("set_deselect_enabled")

    @JvmField
    public val getDeselectEnabledName: MethodStringName0<TabContainer, Boolean> =
        MethodStringName0<TabContainer, Boolean>("get_deselect_enabled")
  }

  public object MethodBindings {
    internal val getTabCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_count", 3905245786)

    internal val setCurrentTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_current_tab", 1286410249)

    internal val getCurrentTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_current_tab", 3905245786)

    internal val getPreviousTabPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_previous_tab", 3905245786)

    internal val selectPreviousAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "select_previous_available", 2240911060)

    internal val selectNextAvailablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "select_next_available", 2240911060)

    internal val getCurrentTabControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_current_tab_control", 2783021301)

    internal val getTabBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_bar", 1865451809)

    internal val getTabControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_control", 1065994134)

    internal val setTabAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_alignment", 2413632353)

    internal val getTabAlignmentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_alignment", 2178122193)

    internal val setTabsPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tabs_position", 256673370)

    internal val getTabsPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tabs_position", 919937023)

    internal val setClipTabsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_clip_tabs", 2586408642)

    internal val getClipTabsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_clip_tabs", 36873697)

    internal val setTabsVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tabs_visible", 2586408642)

    internal val areTabsVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "are_tabs_visible", 36873697)

    internal val setAllTabsInFrontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_all_tabs_in_front", 2586408642)

    internal val isAllTabsInFrontPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "is_all_tabs_in_front", 36873697)

    internal val setTabTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_title", 501894301)

    internal val getTabTitlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_title", 844755477)

    internal val setTabTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_tooltip", 501894301)

    internal val getTabTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_tooltip", 844755477)

    internal val setTabIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_icon", 666127730)

    internal val getTabIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_icon", 3536238170)

    internal val setTabIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_icon_max_width", 3937882851)

    internal val getTabIconMaxWidthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_icon_max_width", 923996154)

    internal val setTabDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_disabled", 300928843)

    internal val isTabDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "is_tab_disabled", 1116898809)

    internal val setTabHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_hidden", 300928843)

    internal val isTabHiddenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "is_tab_hidden", 1116898809)

    internal val setTabMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_metadata", 2152698145)

    internal val getTabMetadataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_metadata", 4227898402)

    internal val setTabButtonIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_button_icon", 666127730)

    internal val getTabButtonIconPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_button_icon", 3536238170)

    internal val getTabIdxAtPointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_idx_at_point", 3820158470)

    internal val getTabIdxFromControlPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_idx_from_control", 2787397975)

    internal val setPopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_popup", 1078189570)

    internal val getPopupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_popup", 111095082)

    internal val setSwitchOnDragHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_switch_on_drag_hover", 2586408642)

    internal val getSwitchOnDragHoverPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_switch_on_drag_hover", 36873697)

    internal val setDragToRearrangeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_drag_to_rearrange_enabled", 2586408642)

    internal val getDragToRearrangeEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_drag_to_rearrange_enabled", 36873697)

    internal val setTabsRearrangeGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tabs_rearrange_group", 1286410249)

    internal val getTabsRearrangeGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tabs_rearrange_group", 3905245786)

    internal val setUseHiddenTabsForMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_use_hidden_tabs_for_min_size", 2586408642)

    internal val getUseHiddenTabsForMinSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_use_hidden_tabs_for_min_size", 36873697)

    internal val setTabFocusModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_tab_focus_mode", 3232914922)

    internal val getTabFocusModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_tab_focus_mode", 2132829277)

    internal val setDeselectEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "set_deselect_enabled", 2586408642)

    internal val getDeselectEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TabContainer", "get_deselect_enabled", 36873697)
  }
}
