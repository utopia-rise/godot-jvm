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
import godot.core.MouseButtonMask
import godot.core.Signal0
import godot.core.Signal1
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import kotlin.Boolean
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * [BaseButton] is an abstract base class for GUI buttons. It doesn't display anything by itself.
 */
@GodotBaseType
public open class BaseButton : Control() {
  /**
   * Emitted when the button is toggled or pressed. This is on [signal button_down] if [actionMode]
   * is [ACTION_MODE_BUTTON_PRESS] and on [signal button_up] otherwise.
   *
   * If you need to know the button's pressed state (and [toggleMode] is active), use [signal
   * toggled] instead.
   */
  public val pressed: Signal0 by Signal0

  /**
   * Emitted when the button stops being held down.
   */
  public val buttonUp: Signal0 by Signal0

  /**
   * Emitted when the button starts being held down.
   */
  public val buttonDown: Signal0 by Signal0

  /**
   * Emitted when the button was just toggled between pressed and normal states (only if
   * [toggleMode] is active). The new state is contained in the [toggledOn] argument.
   */
  public val toggled: Signal1<Boolean> by Signal1

  /**
   * If `true`, the button is in disabled state and can't be clicked or toggled.
   *
   * **Note:** If the button is disabled while held down, [signal button_up] will be emitted.
   */
  public final inline var disabled: Boolean
    @JvmName("disabledProperty")
    get() = isDisabled()
    @JvmName("disabledProperty")
    set(`value`) {
      setDisabled(value)
    }

  /**
   * If `true`, the button is in toggle mode. Makes the button flip state between pressed and
   * unpressed each time its area is clicked.
   */
  public final inline var toggleMode: Boolean
    @JvmName("toggleModeProperty")
    get() = isToggleMode()
    @JvmName("toggleModeProperty")
    set(`value`) {
      setToggleMode(value)
    }

  /**
   * If `true`, the button's state is pressed. Means the button is pressed down or toggled (if
   * [toggleMode] is active). Only works if [toggleMode] is `true`.
   *
   * **Note:** Changing the value of [buttonPressed] will result in [signal toggled] to be emitted.
   * If you want to change the pressed state without emitting that signal, use [setPressedNoSignal].
   */
  public final inline var buttonPressed: Boolean
    @JvmName("buttonPressedProperty")
    get() = isPressed()
    @JvmName("buttonPressedProperty")
    set(`value`) {
      setPressed(value)
    }

  /**
   * Determines when the button is considered clicked.
   */
  public final inline var actionMode: ActionMode
    @JvmName("actionModeProperty")
    get() = getActionMode()
    @JvmName("actionModeProperty")
    set(`value`) {
      setActionMode(value)
    }

  /**
   * Binary mask to choose which mouse buttons this button will respond to.
   *
   * To allow both left-click and right-click, use `MOUSE_BUTTON_MASK_LEFT |
   * MOUSE_BUTTON_MASK_RIGHT`.
   */
  public final inline var buttonMask: MouseButtonMask
    @JvmName("buttonMaskProperty")
    get() = getButtonMask()
    @JvmName("buttonMaskProperty")
    set(`value`) {
      setButtonMask(value)
    }

  /**
   * If `true`, the button stays pressed when moving the cursor outside the button while pressing
   * it.
   *
   * **Note:** This property only affects the button's visual appearance. Signals will be emitted at
   * the same moment regardless of this property's value.
   */
  public final inline var keepPressedOutside: Boolean
    @JvmName("keepPressedOutsideProperty")
    get() = isKeepPressedOutside()
    @JvmName("keepPressedOutsideProperty")
    set(`value`) {
      setKeepPressedOutside(value)
    }

  /**
   * The [ButtonGroup] associated with the button. Not to be confused with node groups.
   *
   * **Note:** The button will be configured as a radio button if a [ButtonGroup] is assigned to it.
   */
  public final inline var buttonGroup: ButtonGroup?
    @JvmName("buttonGroupProperty")
    get() = getButtonGroup()
    @JvmName("buttonGroupProperty")
    set(`value`) {
      setButtonGroup(value)
    }

  /**
   * [Shortcut] associated to the button.
   */
  public final inline var shortcut: Shortcut?
    @JvmName("shortcutProperty")
    get() = getShortcut()
    @JvmName("shortcutProperty")
    set(`value`) {
      setShortcut(value)
    }

  /**
   * If `true`, the button will highlight for a short amount of time when its shortcut is activated.
   * If `false` and [toggleMode] is `false`, the shortcut will activate without any visual feedback.
   */
  public final inline var shortcutFeedback: Boolean
    @JvmName("shortcutFeedbackProperty")
    get() = isShortcutFeedback()
    @JvmName("shortcutFeedbackProperty")
    set(`value`) {
      setShortcutFeedback(value)
    }

  /**
   * If `true`, the button will add information about its shortcut in the tooltip. This includes the
   * shortcut's events and its [Resource.resourceName]. If both events and name are empty, the shortcut
   * will not be included.
   *
   * **Note:** This property does nothing when the tooltip control is customized using
   * [Control.MakeCustomTooltip].
   */
  public final inline var shortcutInTooltip: Boolean
    @JvmName("shortcutInTooltipProperty")
    get() = isShortcutInTooltipEnabled()
    @JvmName("shortcutInTooltipProperty")
    set(`value`) {
      setShortcutInTooltip(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(105, scriptPtr)
  }

  /**
   * Called when the button is pressed. If you need to know the button's pressed state (and
   * [toggleMode] is active), use [_toggled] instead.
   */
  public open fun _pressed(): Unit {
    throw NotImplementedError("BaseButton::_pressed is not implemented.")
  }

  /**
   * Called when the button is toggled (only if [toggleMode] is active).
   */
  public open fun _toggled(toggledOn: Boolean): Unit {
    throw NotImplementedError("BaseButton::_toggled is not implemented.")
  }

  public final fun setPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pressed)
    TransferContext.callMethod(MethodBindings.setPressedPtr)
  }

  public final fun isPressed(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Changes the [buttonPressed] state of the button, without emitting [signal toggled]. Use when
   * you just want to change the state of the button without sending the pressed event (e.g. when
   * initializing scene). Only works if [toggleMode] is `true`.
   *
   * **Note:** This method doesn't unpress other buttons in [buttonGroup].
   */
  public final fun setPressedNoSignal(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pressed)
    TransferContext.callMethod(MethodBindings.setPressedNoSignalPtr)
  }

  /**
   * Returns `true` if the mouse has entered the button and has not left it yet.
   */
  public final fun isHovered(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHoveredPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setToggleMode(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setToggleModePtr)
  }

  public final fun isToggleMode(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isToggleModePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShortcutInTooltip(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setShortcutInTooltipPtr)
  }

  public final fun isShortcutInTooltipEnabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShortcutInTooltipEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setDisabled(disabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to disabled)
    TransferContext.callMethod(MethodBindings.setDisabledPtr)
  }

  public final fun isDisabled(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDisabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setActionMode(mode: ActionMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setActionModePtr)
  }

  public final fun getActionMode(): ActionMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionModePtr)
    return ActionMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setButtonMask(mask: MouseButtonMask): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mask.flag)
    TransferContext.callMethod(MethodBindings.setButtonMaskPtr)
  }

  public final fun getButtonMask(): MouseButtonMask {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getButtonMaskPtr)
    return MouseButtonMask(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the visual state used to draw the button. This is useful mainly when implementing your
   * own draw code by either overriding _draw() or connecting to "draw" signal. The visual state of the
   * button is defined by the [DrawMode] enum.
   */
  public final fun getDrawMode(): DrawMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDrawModePtr)
    return DrawMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setKeepPressedOutside(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setKeepPressedOutsidePtr)
  }

  public final fun isKeepPressedOutside(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isKeepPressedOutsidePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShortcutFeedback(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setShortcutFeedbackPtr)
  }

  public final fun isShortcutFeedback(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShortcutFeedbackPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setShortcut(shortcut: Shortcut?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to shortcut)
    TransferContext.callMethod(MethodBindings.setShortcutPtr)
  }

  public final fun getShortcut(): Shortcut? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getShortcutPtr)
    return (TransferContext.readReturnValue(OBJECT) as Shortcut?)
  }

  public final fun setButtonGroup(buttonGroup: ButtonGroup?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to buttonGroup)
    TransferContext.callMethod(MethodBindings.setButtonGroupPtr)
  }

  public final fun getButtonGroup(): ButtonGroup? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getButtonGroupPtr)
    return (TransferContext.readReturnValue(OBJECT) as ButtonGroup?)
  }

  public enum class DrawMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The normal state (i.e. not pressed, not hovered, not toggled and enabled) of buttons.
     */
    NORMAL(0),
    /**
     * The state of buttons are pressed.
     */
    PRESSED(1),
    /**
     * The state of buttons are hovered.
     */
    HOVER(2),
    /**
     * The state of buttons are disabled.
     */
    DISABLED(3),
    /**
     * The state of buttons are both hovered and pressed.
     */
    HOVER_PRESSED(4),
    ;

    public companion object {
      public fun from(`value`: Long): DrawMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class ActionMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Require just a press to consider the button clicked.
     */
    BUTTON_PRESS(0),
    /**
     * Require a press and a subsequent release before considering the button clicked.
     */
    BUTTON_RELEASE(1),
    ;

    public companion object {
      public fun from(`value`: Long): ActionMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setPressedName: MethodStringName1<BaseButton, Unit, Boolean> =
        MethodStringName1<BaseButton, Unit, Boolean>("set_pressed")

    @JvmField
    public val isPressedName: MethodStringName0<BaseButton, Boolean> =
        MethodStringName0<BaseButton, Boolean>("is_pressed")

    @JvmField
    public val setPressedNoSignalName: MethodStringName1<BaseButton, Unit, Boolean> =
        MethodStringName1<BaseButton, Unit, Boolean>("set_pressed_no_signal")

    @JvmField
    public val isHoveredName: MethodStringName0<BaseButton, Boolean> =
        MethodStringName0<BaseButton, Boolean>("is_hovered")

    @JvmField
    public val setToggleModeName: MethodStringName1<BaseButton, Unit, Boolean> =
        MethodStringName1<BaseButton, Unit, Boolean>("set_toggle_mode")

    @JvmField
    public val isToggleModeName: MethodStringName0<BaseButton, Boolean> =
        MethodStringName0<BaseButton, Boolean>("is_toggle_mode")

    @JvmField
    public val setShortcutInTooltipName: MethodStringName1<BaseButton, Unit, Boolean> =
        MethodStringName1<BaseButton, Unit, Boolean>("set_shortcut_in_tooltip")

    @JvmField
    public val isShortcutInTooltipEnabledName: MethodStringName0<BaseButton, Boolean> =
        MethodStringName0<BaseButton, Boolean>("is_shortcut_in_tooltip_enabled")

    @JvmField
    public val setDisabledName: MethodStringName1<BaseButton, Unit, Boolean> =
        MethodStringName1<BaseButton, Unit, Boolean>("set_disabled")

    @JvmField
    public val isDisabledName: MethodStringName0<BaseButton, Boolean> =
        MethodStringName0<BaseButton, Boolean>("is_disabled")

    @JvmField
    public val setActionModeName: MethodStringName1<BaseButton, Unit, ActionMode> =
        MethodStringName1<BaseButton, Unit, ActionMode>("set_action_mode")

    @JvmField
    public val getActionModeName: MethodStringName0<BaseButton, ActionMode> =
        MethodStringName0<BaseButton, ActionMode>("get_action_mode")

    @JvmField
    public val setButtonMaskName: MethodStringName1<BaseButton, Unit, MouseButtonMask> =
        MethodStringName1<BaseButton, Unit, MouseButtonMask>("set_button_mask")

    @JvmField
    public val getButtonMaskName: MethodStringName0<BaseButton, MouseButtonMask> =
        MethodStringName0<BaseButton, MouseButtonMask>("get_button_mask")

    @JvmField
    public val getDrawModeName: MethodStringName0<BaseButton, DrawMode> =
        MethodStringName0<BaseButton, DrawMode>("get_draw_mode")

    @JvmField
    public val setKeepPressedOutsideName: MethodStringName1<BaseButton, Unit, Boolean> =
        MethodStringName1<BaseButton, Unit, Boolean>("set_keep_pressed_outside")

    @JvmField
    public val isKeepPressedOutsideName: MethodStringName0<BaseButton, Boolean> =
        MethodStringName0<BaseButton, Boolean>("is_keep_pressed_outside")

    @JvmField
    public val setShortcutFeedbackName: MethodStringName1<BaseButton, Unit, Boolean> =
        MethodStringName1<BaseButton, Unit, Boolean>("set_shortcut_feedback")

    @JvmField
    public val isShortcutFeedbackName: MethodStringName0<BaseButton, Boolean> =
        MethodStringName0<BaseButton, Boolean>("is_shortcut_feedback")

    @JvmField
    public val setShortcutName: MethodStringName1<BaseButton, Unit, Shortcut?> =
        MethodStringName1<BaseButton, Unit, Shortcut?>("set_shortcut")

    @JvmField
    public val getShortcutName: MethodStringName0<BaseButton, Shortcut?> =
        MethodStringName0<BaseButton, Shortcut?>("get_shortcut")

    @JvmField
    public val setButtonGroupName: MethodStringName1<BaseButton, Unit, ButtonGroup?> =
        MethodStringName1<BaseButton, Unit, ButtonGroup?>("set_button_group")

    @JvmField
    public val getButtonGroupName: MethodStringName0<BaseButton, ButtonGroup?> =
        MethodStringName0<BaseButton, ButtonGroup?>("get_button_group")
  }

  public object MethodBindings {
    internal val setPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_pressed", 2586408642)

    internal val isPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "is_pressed", 36873697)

    internal val setPressedNoSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_pressed_no_signal", 2586408642)

    internal val isHoveredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "is_hovered", 36873697)

    internal val setToggleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_toggle_mode", 2586408642)

    internal val isToggleModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "is_toggle_mode", 36873697)

    internal val setShortcutInTooltipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_shortcut_in_tooltip", 2586408642)

    internal val isShortcutInTooltipEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "is_shortcut_in_tooltip_enabled", 36873697)

    internal val setDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_disabled", 2586408642)

    internal val isDisabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "is_disabled", 36873697)

    internal val setActionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_action_mode", 1985162088)

    internal val getActionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "get_action_mode", 2589712189)

    internal val setButtonMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_button_mask", 3950145251)

    internal val getButtonMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "get_button_mask", 2512161324)

    internal val getDrawModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "get_draw_mode", 2492721305)

    internal val setKeepPressedOutsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_keep_pressed_outside", 2586408642)

    internal val isKeepPressedOutsidePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "is_keep_pressed_outside", 36873697)

    internal val setShortcutFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_shortcut_feedback", 2586408642)

    internal val isShortcutFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "is_shortcut_feedback", 36873697)

    internal val setShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_shortcut", 857163497)

    internal val getShortcutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "get_shortcut", 3415666916)

    internal val setButtonGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "set_button_group", 1794463739)

    internal val getButtonGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BaseButton", "get_button_group", 281644053)
  }
}
