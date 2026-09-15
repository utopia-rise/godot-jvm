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
import godot.core.Signal0
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A container used to provide a child control with scrollbars when needed. Scrollbars will
 * automatically be drawn at the right (for vertical) or bottom (for horizontal) and will enable
 * dragging to move the viewable Control (and its children) within the ScrollContainer. Scrollbars will
 * also automatically resize the grabber based on the [Control.customMinimumSize] of the Control
 * relative to the ScrollContainer.
 */
@GodotBaseType
public open class ScrollContainer : Container() {
  /**
   * Emitted when scrolling starts when dragging the scrollable area *with a touch event*. This
   * signal is *not* emitted when scrolling by dragging the scrollbar, scrolling with the mouse wheel
   * or scrolling with keyboard/gamepad events.
   *
   * **Note:** This signal is only emitted on Android or iOS, or on desktop/web platforms when
   * [ProjectSettings.inputDevices/pointing/emulateTouchFromMouse] is enabled.
   */
  public val scrollStarted: Signal0 by Signal0

  /**
   * Emitted when scrolling stops when dragging the scrollable area *with a touch event*. This
   * signal is *not* emitted when scrolling by dragging the scrollbar, scrolling with the mouse wheel
   * or scrolling with keyboard/gamepad events.
   *
   * **Note:** This signal is only emitted on Android or iOS, or on desktop/web platforms when
   * [ProjectSettings.inputDevices/pointing/emulateTouchFromMouse] is enabled.
   */
  public val scrollEnded: Signal0 by Signal0

  /**
   * If `true`, the ScrollContainer will automatically scroll to focused children (including
   * indirect children) to make sure they are fully visible.
   */
  public final inline var followFocus: Boolean
    @JvmName("followFocusProperty")
    get() = isFollowingFocus()
    @JvmName("followFocusProperty")
    set(`value`) {
      setFollowFocus(value)
    }

  /**
   * If `true`, [theme_item focus] is drawn when the ScrollContainer or one of its descendant nodes
   * is focused.
   */
  public final inline var drawFocusBorder: Boolean
    @JvmName("drawFocusBorderProperty")
    get() = getDrawFocusBorder()
    @JvmName("drawFocusBorderProperty")
    set(`value`) {
      setDrawFocusBorder(value)
    }

  /**
   * The current horizontal scroll value.
   *
   * **Note:** If you are setting this value in the [Node.Ready] function or earlier, it needs to be
   * wrapped with [Object.setDeferred], since scroll bar's [Range.maxValue] is not initialized yet.
   *
   * ```
   * func _ready():
   * 	set_deferred("scroll_horizontal", 600)
   * ```
   */
  public final inline var scrollHorizontal: Int
    @JvmName("scrollHorizontalProperty")
    get() = getHScroll()
    @JvmName("scrollHorizontalProperty")
    set(`value`) {
      setHScroll(value)
    }

  /**
   * The current vertical scroll value.
   *
   * **Note:** Setting it early needs to be deferred, just like in [scrollHorizontal].
   *
   * ```
   * func _ready():
   * 	set_deferred("scroll_vertical", 600)
   * ```
   */
  public final inline var scrollVertical: Int
    @JvmName("scrollVerticalProperty")
    get() = getVScroll()
    @JvmName("scrollVerticalProperty")
    set(`value`) {
      setVScroll(value)
    }

  /**
   * Overrides the [ScrollBar.customStep] used when clicking the internal scroll bar's horizontal
   * increment and decrement buttons or when using arrow keys when the [ScrollBar] is focused.
   */
  public final inline var scrollHorizontalCustomStep: Float
    @JvmName("scrollHorizontalCustomStepProperty")
    get() = getHorizontalCustomStep()
    @JvmName("scrollHorizontalCustomStepProperty")
    set(`value`) {
      setHorizontalCustomStep(value)
    }

  /**
   * Overrides the [ScrollBar.customStep] used when clicking the internal scroll bar's vertical
   * increment and decrement buttons or when using arrow keys when the [ScrollBar] is focused.
   */
  public final inline var scrollVerticalCustomStep: Float
    @JvmName("scrollVerticalCustomStepProperty")
    get() = getVerticalCustomStep()
    @JvmName("scrollVerticalCustomStepProperty")
    set(`value`) {
      setVerticalCustomStep(value)
    }

  /**
   * Controls whether horizontal scrollbar can be used and when it should be visible.
   */
  public final inline var horizontalScrollMode: ScrollMode
    @JvmName("horizontalScrollModeProperty")
    get() = getHorizontalScrollMode()
    @JvmName("horizontalScrollModeProperty")
    set(`value`) {
      setHorizontalScrollMode(value)
    }

  /**
   * Controls whether vertical scrollbar can be used and when it should be visible.
   */
  public final inline var verticalScrollMode: ScrollMode
    @JvmName("verticalScrollModeProperty")
    get() = getVerticalScrollMode()
    @JvmName("verticalScrollModeProperty")
    set(`value`) {
      setVerticalScrollMode(value)
    }

  /**
   * If `true`, the mouse wheel scrolls the view horizontally, and holding [kbd]Shift[/kbd] scrolls
   * vertically.
   *
   * If `false` (default), the mouse wheel scrolls the view vertically, and holding [kbd]Shift[/kbd]
   * scrolls horizontally.
   */
  public final inline var scrollHorizontalByDefault: Boolean
    @JvmName("scrollHorizontalByDefaultProperty")
    get() = isScrollHorizontalByDefault()
    @JvmName("scrollHorizontalByDefaultProperty")
    set(`value`) {
      setScrollHorizontalByDefault(value)
    }

  /**
   * Deadzone for touch scrolling. Lower deadzone makes the scrolling more sensitive.
   */
  public final inline var scrollDeadzone: Int
    @JvmName("scrollDeadzoneProperty")
    get() = getDeadzone()
    @JvmName("scrollDeadzoneProperty")
    set(`value`) {
      setDeadzone(value)
    }

  /**
   * The way which scroll hints (indicators that show that the content can still be scrolled in a
   * certain direction) will be shown.
   *
   * **Note:** Hints won't be shown if the content can be scrolled both vertically and horizontally.
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
    createNativeObject(648, scriptPtr)
  }

  public final fun setHScroll(`value`: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, value.toLong())
    TransferContext.callPtrMethod(MethodBindings.setHScrollPtr, 0)
  }

  public final fun getHScroll(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHScrollPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setVScroll(`value`: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, value.toLong())
    TransferContext.callPtrMethod(MethodBindings.setVScrollPtr, 0)
  }

  public final fun getVScroll(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVScrollPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setHorizontalCustomStep(`value`: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setHorizontalCustomStepPtr, 0)
  }

  public final fun getHorizontalCustomStep(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHorizontalCustomStepPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setVerticalCustomStep(`value`: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, value.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setVerticalCustomStepPtr, 0)
  }

  public final fun getVerticalCustomStep(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVerticalCustomStepPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setHorizontalScrollMode(enable: ScrollMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, enable.value)
    TransferContext.callPtrMethod(MethodBindings.setHorizontalScrollModePtr, 0)
  }

  public final fun getHorizontalScrollMode(): ScrollMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHorizontalScrollModePtr, 2)
    return ScrollMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setVerticalScrollMode(enable: ScrollMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, enable.value)
    TransferContext.callPtrMethod(MethodBindings.setVerticalScrollModePtr, 0)
  }

  public final fun getVerticalScrollMode(): ScrollMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVerticalScrollModePtr, 2)
    return ScrollMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setScrollHorizontalByDefault(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setScrollHorizontalByDefaultPtr, 0)
  }

  public final fun isScrollHorizontalByDefault(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isScrollHorizontalByDefaultPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setDeadzone(deadzone: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, deadzone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setDeadzonePtr, 0)
  }

  public final fun getDeadzone(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDeadzonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setScrollHintMode(scrollHintMode: ScrollHintMode): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, scrollHintMode.value)
    TransferContext.callPtrMethod(MethodBindings.setScrollHintModePtr, 0)
  }

  public final fun getScrollHintMode(): ScrollHintMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getScrollHintModePtr, 2)
    return ScrollHintMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setTileScrollHint(tileScrollHint: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, tileScrollHint)
    TransferContext.callPtrMethod(MethodBindings.setTileScrollHintPtr, 0)
  }

  public final fun isScrollHintTiled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isScrollHintTiledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setFollowFocus(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setFollowFocusPtr, 0)
  }

  public final fun isFollowingFocus(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isFollowingFocusPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the horizontal scrollbar [HScrollBar] of this [ScrollContainer].
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to disable or hide a scrollbar, you can use [horizontalScrollMode].
   */
  public final fun getHScrollBar(): HScrollBar? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHScrollBarPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as HScrollBar?)
  }

  /**
   * Returns the vertical scrollbar [VScrollBar] of this [ScrollContainer].
   *
   * **Warning:** This is a required internal node, removing and freeing it may cause a crash. If
   * you wish to disable or hide a scrollbar, you can use [verticalScrollMode].
   */
  public final fun getVScrollBar(): VScrollBar? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVScrollBarPtr, 24)
    return (TransferContext.readReturnValue_OBJECT() as VScrollBar?)
  }

  /**
   * Ensures the given [control] is visible (must be a direct or indirect child of the
   * ScrollContainer). Used by [followFocus].
   *
   * **Note:** This will not work on a node that was just added during the same frame. If you want
   * to scroll to a newly added child, you must wait until the next frame using [signal
   * SceneTree.process_frame]:
   *
   * ```
   * add_child(child_node)
   * await get_tree().process_frame
   * ensure_control_visible(child_node)
   * ```
   */
  public final fun ensureControlVisible(control: Control?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, control)
    TransferContext.callPtrMethod(MethodBindings.ensureControlVisiblePtr, 0)
  }

  public final fun setDrawFocusBorder(draw: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, draw)
    TransferContext.callPtrMethod(MethodBindings.setDrawFocusBorderPtr, 0)
  }

  public final fun getDrawFocusBorder(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDrawFocusBorderPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public enum class ScrollMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Scrolling disabled, scrollbar will be invisible.
     */
    DISABLED(0),
    /**
     * Scrolling enabled, scrollbar will be visible only if necessary, i.e. container's content is
     * bigger than the container.
     */
    AUTO(1),
    /**
     * Scrolling enabled, scrollbar will be always visible.
     */
    SHOW_ALWAYS(2),
    /**
     * Scrolling enabled, scrollbar will be hidden.
     */
    SHOW_NEVER(3),
    /**
     * Combines [SCROLL_MODE_AUTO] and [SCROLL_MODE_SHOW_ALWAYS]. The scrollbar is only visible if
     * necessary, but the content size is adjusted as if it was always visible. It's useful for
     * ensuring that content size stays the same regardless if the scrollbar is visible.
     */
    RESERVE(4),
    /**
     * Behaves like [SCROLL_MODE_AUTO], but makes the [ScrollContainer] report a minimum size based
     * on its content (limited by [Control.customMaximumSize] when set on the corresponding axis). This
     * allows it to grow first and only start scrolling once constrained.
     */
    MAXIMIZE_FIRST(5),
    ;

    public companion object {
      public fun from(`value`: Long): ScrollMode = entries.single { it.`value` == `value` }
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
     * Scroll hints will be shown at the top and bottom (if vertical), or left and right (if
     * horizontal).
     */
    ALL(1),
    /**
     * Scroll hints will be shown at the top (if vertical), or the left (if horizontal).
     */
    TOP_AND_LEFT(2),
    /**
     * Scroll hints will be shown at the bottom (if horizontal), or the right (if horizontal).
     */
    BOTTOM_AND_RIGHT(3),
    ;

    public companion object {
      public fun from(`value`: Long): ScrollHintMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setHScrollName: MethodStringName1<ScrollContainer, Unit, Int> =
        MethodStringName1<ScrollContainer, Unit, Int>("set_h_scroll")

    @JvmField
    public val getHScrollName: MethodStringName0<ScrollContainer, Int> =
        MethodStringName0<ScrollContainer, Int>("get_h_scroll")

    @JvmField
    public val setVScrollName: MethodStringName1<ScrollContainer, Unit, Int> =
        MethodStringName1<ScrollContainer, Unit, Int>("set_v_scroll")

    @JvmField
    public val getVScrollName: MethodStringName0<ScrollContainer, Int> =
        MethodStringName0<ScrollContainer, Int>("get_v_scroll")

    @JvmField
    public val setHorizontalCustomStepName: MethodStringName1<ScrollContainer, Unit, Float> =
        MethodStringName1<ScrollContainer, Unit, Float>("set_horizontal_custom_step")

    @JvmField
    public val getHorizontalCustomStepName: MethodStringName0<ScrollContainer, Float> =
        MethodStringName0<ScrollContainer, Float>("get_horizontal_custom_step")

    @JvmField
    public val setVerticalCustomStepName: MethodStringName1<ScrollContainer, Unit, Float> =
        MethodStringName1<ScrollContainer, Unit, Float>("set_vertical_custom_step")

    @JvmField
    public val getVerticalCustomStepName: MethodStringName0<ScrollContainer, Float> =
        MethodStringName0<ScrollContainer, Float>("get_vertical_custom_step")

    @JvmField
    public val setHorizontalScrollModeName: MethodStringName1<ScrollContainer, Unit, ScrollMode> =
        MethodStringName1<ScrollContainer, Unit, ScrollMode>("set_horizontal_scroll_mode")

    @JvmField
    public val getHorizontalScrollModeName: MethodStringName0<ScrollContainer, ScrollMode> =
        MethodStringName0<ScrollContainer, ScrollMode>("get_horizontal_scroll_mode")

    @JvmField
    public val setVerticalScrollModeName: MethodStringName1<ScrollContainer, Unit, ScrollMode> =
        MethodStringName1<ScrollContainer, Unit, ScrollMode>("set_vertical_scroll_mode")

    @JvmField
    public val getVerticalScrollModeName: MethodStringName0<ScrollContainer, ScrollMode> =
        MethodStringName0<ScrollContainer, ScrollMode>("get_vertical_scroll_mode")

    @JvmField
    public val setScrollHorizontalByDefaultName: MethodStringName1<ScrollContainer, Unit, Boolean> =
        MethodStringName1<ScrollContainer, Unit, Boolean>("set_scroll_horizontal_by_default")

    @JvmField
    public val isScrollHorizontalByDefaultName: MethodStringName0<ScrollContainer, Boolean> =
        MethodStringName0<ScrollContainer, Boolean>("is_scroll_horizontal_by_default")

    @JvmField
    public val setDeadzoneName: MethodStringName1<ScrollContainer, Unit, Int> =
        MethodStringName1<ScrollContainer, Unit, Int>("set_deadzone")

    @JvmField
    public val getDeadzoneName: MethodStringName0<ScrollContainer, Int> =
        MethodStringName0<ScrollContainer, Int>("get_deadzone")

    @JvmField
    public val setScrollHintModeName: MethodStringName1<ScrollContainer, Unit, ScrollHintMode> =
        MethodStringName1<ScrollContainer, Unit, ScrollHintMode>("set_scroll_hint_mode")

    @JvmField
    public val getScrollHintModeName: MethodStringName0<ScrollContainer, ScrollHintMode> =
        MethodStringName0<ScrollContainer, ScrollHintMode>("get_scroll_hint_mode")

    @JvmField
    public val setTileScrollHintName: MethodStringName1<ScrollContainer, Unit, Boolean> =
        MethodStringName1<ScrollContainer, Unit, Boolean>("set_tile_scroll_hint")

    @JvmField
    public val isScrollHintTiledName: MethodStringName0<ScrollContainer, Boolean> =
        MethodStringName0<ScrollContainer, Boolean>("is_scroll_hint_tiled")

    @JvmField
    public val setFollowFocusName: MethodStringName1<ScrollContainer, Unit, Boolean> =
        MethodStringName1<ScrollContainer, Unit, Boolean>("set_follow_focus")

    @JvmField
    public val isFollowingFocusName: MethodStringName0<ScrollContainer, Boolean> =
        MethodStringName0<ScrollContainer, Boolean>("is_following_focus")

    @JvmField
    public val getHScrollBarName: MethodStringName0<ScrollContainer, HScrollBar?> =
        MethodStringName0<ScrollContainer, HScrollBar?>("get_h_scroll_bar")

    @JvmField
    public val getVScrollBarName: MethodStringName0<ScrollContainer, VScrollBar?> =
        MethodStringName0<ScrollContainer, VScrollBar?>("get_v_scroll_bar")

    @JvmField
    public val ensureControlVisibleName: MethodStringName1<ScrollContainer, Unit, Control?> =
        MethodStringName1<ScrollContainer, Unit, Control?>("ensure_control_visible")

    @JvmField
    public val setDrawFocusBorderName: MethodStringName1<ScrollContainer, Unit, Boolean> =
        MethodStringName1<ScrollContainer, Unit, Boolean>("set_draw_focus_border")

    @JvmField
    public val getDrawFocusBorderName: MethodStringName0<ScrollContainer, Boolean> =
        MethodStringName0<ScrollContainer, Boolean>("get_draw_focus_border")
  }

  public object MethodBindings {
    internal val setHScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_h_scroll", 1286410249)

    internal val getHScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_h_scroll", 3905245786)

    internal val setVScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_v_scroll", 1286410249)

    internal val getVScrollPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_v_scroll", 3905245786)

    internal val setHorizontalCustomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_horizontal_custom_step", 373806689)

    internal val getHorizontalCustomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_horizontal_custom_step", 1740695150)

    internal val setVerticalCustomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_vertical_custom_step", 373806689)

    internal val getVerticalCustomStepPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_vertical_custom_step", 1740695150)

    internal val setHorizontalScrollModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_horizontal_scroll_mode", 2750506364)

    internal val getHorizontalScrollModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_horizontal_scroll_mode", 3987985145)

    internal val setVerticalScrollModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_vertical_scroll_mode", 2750506364)

    internal val getVerticalScrollModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_vertical_scroll_mode", 3987985145)

    internal val setScrollHorizontalByDefaultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_scroll_horizontal_by_default", 2586408642)

    internal val isScrollHorizontalByDefaultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "is_scroll_horizontal_by_default", 36873697)

    internal val setDeadzonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_deadzone", 1286410249)

    internal val getDeadzonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_deadzone", 3905245786)

    internal val setScrollHintModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_scroll_hint_mode", 578158943)

    internal val getScrollHintModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_scroll_hint_mode", 246835423)

    internal val setTileScrollHintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_tile_scroll_hint", 2586408642)

    internal val isScrollHintTiledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "is_scroll_hint_tiled", 2240911060)

    internal val setFollowFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_follow_focus", 2586408642)

    internal val isFollowingFocusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "is_following_focus", 36873697)

    internal val getHScrollBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_h_scroll_bar", 4004517983)

    internal val getVScrollBarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_v_scroll_bar", 2630340773)

    internal val ensureControlVisiblePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "ensure_control_visible", 1496901182)

    internal val setDrawFocusBorderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "set_draw_focus_border", 2586408642)

    internal val getDrawFocusBorderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScrollContainer", "get_draw_focus_border", 2240911060)
  }
}
