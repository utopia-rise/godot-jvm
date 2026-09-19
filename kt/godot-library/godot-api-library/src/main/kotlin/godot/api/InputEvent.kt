// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT_BOOL_ret_BOOL
import godot.callPtrMethod_OBJECT_ret_BOOL
import godot.callPtrMethod_STRING_NAME_BOOL_BOOL_ret_BOOL
import godot.callPtrMethod_STRING_NAME_BOOL_ret_BOOL
import godot.callPtrMethod_STRING_NAME_BOOL_ret_DOUBLE
import godot.callPtrMethod_TRANSFORM2D_VECTOR2_ret_OBJECT_REF
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.StringName
import godot.core.Transform2D
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Boolean
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
 * Abstract base class of all types of input events. See [Node.Input].
 */
@GodotBaseType
public open class InputEvent internal constructor() : Resource() {
  /**
   * The event's device ID.
   *
   * **Note:** [device] can be negative for special use cases that don't refer to devices physically
   * present on the system. See [DEVICE_ID_EMULATION].
   */
  public final inline var device: Int
    @JvmName("deviceProperty")
    get() = getDevice()
    @JvmName("deviceProperty")
    set(`value`) {
      setDevice(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(308, scriptPtr)
  }

  public final fun setDevice(device: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setDevicePtr, device.toLong())
  }

  public final fun getDevice(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDevicePtr).toInt()

  /**
   * Returns `true` if this input event matches a pre-defined action of any type.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  public final fun isAction(action: StringName, exactMatch: Boolean = false): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_BOOL_ret_BOOL(ptr, objectID.id, MethodBindings.isActionPtr, action, exactMatch)

  /**
   * Returns `true` if the given action matches this event and is being pressed (and is not an echo
   * event for [InputEventKey] events, unless [allowEcho] is `true`). Not relevant for events of type
   * [InputEventMouseMotion] or [InputEventScreenDrag].
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** Due to keyboard ghosting, [isActionPressed] may return `false` even if one of the
   * action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   */
  @JvmOverloads
  public final fun isActionPressed(
    action: StringName,
    allowEcho: Boolean = false,
    exactMatch: Boolean = false,
  ): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_BOOL_BOOL_ret_BOOL(ptr, objectID.id, MethodBindings.isActionPressedPtr, action, allowEcho, exactMatch)

  /**
   * Returns `true` if the given action matches this event and is released (i.e. not pressed). Not
   * relevant for events of type [InputEventMouseMotion] or [InputEventScreenDrag].
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  public final fun isActionReleased(action: StringName, exactMatch: Boolean = false): Boolean =
      TransferContext.callPtrMethod_STRING_NAME_BOOL_ret_BOOL(ptr, objectID.id, MethodBindings.isActionReleasedPtr, action, exactMatch)

  /**
   * Returns a value between 0.0 and 1.0 depending on the given actions' state. Useful for getting
   * the value of events of type [InputEventJoypadMotion].
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  public final fun getActionStrength(action: StringName, exactMatch: Boolean = false): Float =
      TransferContext.callPtrMethod_STRING_NAME_BOOL_ret_DOUBLE(ptr, objectID.id, MethodBindings.getActionStrengthPtr, action, exactMatch).toFloat()

  /**
   * Returns `true` if this input event has been canceled.
   */
  public final fun isCanceled(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isCanceledPtr)

  /**
   * Returns `true` if this input event is pressed. Not relevant for events of type
   * [InputEventMouseMotion] or [InputEventScreenDrag].
   *
   * **Note:** Due to keyboard ghosting, [isPressed] may return `false` even if one of the action's
   * keys is pressed. See [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input
   * examples[/url] in the documentation for more information.
   */
  public final fun isPressed(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isPressedPtr)

  /**
   * Returns `true` if this input event is released. Not relevant for events of type
   * [InputEventMouseMotion] or [InputEventScreenDrag].
   */
  public final fun isReleased(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isReleasedPtr)

  /**
   * Returns `true` if this input event is an echo event (only for events of type [InputEventKey]).
   * An echo event is a repeated key event sent when the user is holding down the key. Any other event
   * type returns `false`.
   *
   * **Note:** The rate at which echo events are sent is typically around 20 events per second
   * (after holding down the key for roughly half a second). However, the key repeat delay/speed can be
   * changed by the user or disabled entirely in the operating system settings. To ensure your project
   * works correctly on all configurations, do not assume the user has a specific key repeat
   * configuration in your project's behavior.
   */
  public final fun isEcho(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isEchoPtr)

  /**
   * Returns a [String] representation of the event.
   */
  public final fun asText(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.asTextPtr)

  /**
   * Returns `true` if the specified [event] matches this event. Only valid for action events, which
   * include key ([InputEventKey]), button ([InputEventMouseButton] or [InputEventJoypadButton]), axis
   * [InputEventJoypadMotion], and action ([InputEventAction]) events.
   *
   * If [exactMatch] is `false`, the check ignores additional input modifiers for [InputEventKey]
   * and [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** This method only considers the event configuration (such as the keyboard key or the
   * joypad axis), not state information like [isPressed], [isReleased], [isEcho], or [isCanceled].
   */
  @JvmOverloads
  public final fun isMatch(event: InputEvent?, exactMatch: Boolean = true): Boolean =
      TransferContext.callPtrMethod_OBJECT_BOOL_ret_BOOL(ptr, objectID.id, MethodBindings.isMatchPtr, event, exactMatch)

  /**
   * Returns `true` if this input event's type is one that can be assigned to an input action:
   * [InputEventKey], [InputEventMouseButton], [InputEventJoypadButton], [InputEventJoypadMotion],
   * [InputEventAction]. Returns `false` for all other input event types.
   */
  public final fun isActionType(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isActionTypePtr)

  /**
   * Returns `true` if the given input event and this input event can be added together (only for
   * events of type [InputEventMouseMotion]).
   *
   * The given input event's position, global position and speed will be copied. The resulting
   * `relative` is a sum of both events. Both events' modifiers have to be identical.
   */
  public final fun accumulate(withEvent: InputEvent?): Boolean =
      TransferContext.callPtrMethod_OBJECT_ret_BOOL(ptr, objectID.id, MethodBindings.accumulatePtr, withEvent)

  /**
   * Returns a copy of the given input event which has been offset by [localOfs] and transformed by
   * [xform]. Relevant for events of type [InputEventMouseButton], [InputEventMouseMotion],
   * [InputEventScreenTouch], [InputEventScreenDrag], [InputEventMagnifyGesture] and
   * [InputEventPanGesture].
   */
  @JvmOverloads
  public final fun xformedBy(xform: Transform2D, localOfs: Vector2 = Vector2(0, 0)): InputEvent =
      (TransferContext.callPtrMethod_TRANSFORM2D_VECTOR2_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.xformedByPtr, xform, localOfs) as InputEvent)

  /**
   * Returns `true` if this input event matches a pre-defined action of any type.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  public final fun isAction(action: String, exactMatch: Boolean = false): Boolean =
      isAction(action.asCachedStringName(), exactMatch)

  /**
   * Returns `true` if the given action matches this event and is being pressed (and is not an echo
   * event for [InputEventKey] events, unless [allowEcho] is `true`). Not relevant for events of type
   * [InputEventMouseMotion] or [InputEventScreenDrag].
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** Due to keyboard ghosting, [isActionPressed] may return `false` even if one of the
   * action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   */
  @JvmOverloads
  public final fun isActionPressed(
    action: String,
    allowEcho: Boolean = false,
    exactMatch: Boolean = false,
  ): Boolean = isActionPressed(action.asCachedStringName(), allowEcho, exactMatch)

  /**
   * Returns `true` if the given action matches this event and is released (i.e. not pressed). Not
   * relevant for events of type [InputEventMouseMotion] or [InputEventScreenDrag].
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  public final fun isActionReleased(action: String, exactMatch: Boolean = false): Boolean =
      isActionReleased(action.asCachedStringName(), exactMatch)

  /**
   * Returns a value between 0.0 and 1.0 depending on the given actions' state. Useful for getting
   * the value of events of type [InputEventJoypadMotion].
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  public final fun getActionStrength(action: String, exactMatch: Boolean = false): Float =
      getActionStrength(action.asCachedStringName(), exactMatch)

  public companion object {
    @JvmField
    public val setDeviceName: MethodStringName1<InputEvent, Unit, Int> =
        MethodStringName1<InputEvent, Unit, Int>("set_device")

    @JvmField
    public val getDeviceName: MethodStringName0<InputEvent, Int> =
        MethodStringName0<InputEvent, Int>("get_device")

    @JvmField
    public val isActionName: MethodStringName2<InputEvent, Boolean, StringName, Boolean> =
        MethodStringName2<InputEvent, Boolean, StringName, Boolean>("is_action")

    @JvmField
    public val isActionPressedName:
        MethodStringName3<InputEvent, Boolean, StringName, Boolean, Boolean> =
        MethodStringName3<InputEvent, Boolean, StringName, Boolean, Boolean>("is_action_pressed")

    @JvmField
    public val isActionReleasedName: MethodStringName2<InputEvent, Boolean, StringName, Boolean> =
        MethodStringName2<InputEvent, Boolean, StringName, Boolean>("is_action_released")

    @JvmField
    public val getActionStrengthName: MethodStringName2<InputEvent, Float, StringName, Boolean> =
        MethodStringName2<InputEvent, Float, StringName, Boolean>("get_action_strength")

    @JvmField
    public val isCanceledName: MethodStringName0<InputEvent, Boolean> =
        MethodStringName0<InputEvent, Boolean>("is_canceled")

    @JvmField
    public val isPressedName: MethodStringName0<InputEvent, Boolean> =
        MethodStringName0<InputEvent, Boolean>("is_pressed")

    @JvmField
    public val isReleasedName: MethodStringName0<InputEvent, Boolean> =
        MethodStringName0<InputEvent, Boolean>("is_released")

    @JvmField
    public val isEchoName: MethodStringName0<InputEvent, Boolean> =
        MethodStringName0<InputEvent, Boolean>("is_echo")

    @JvmField
    public val asTextName: MethodStringName0<InputEvent, String> =
        MethodStringName0<InputEvent, String>("as_text")

    @JvmField
    public val isMatchName: MethodStringName2<InputEvent, Boolean, InputEvent?, Boolean> =
        MethodStringName2<InputEvent, Boolean, InputEvent?, Boolean>("is_match")

    @JvmField
    public val isActionTypeName: MethodStringName0<InputEvent, Boolean> =
        MethodStringName0<InputEvent, Boolean>("is_action_type")

    @JvmField
    public val accumulateName: MethodStringName1<InputEvent, Boolean, InputEvent?> =
        MethodStringName1<InputEvent, Boolean, InputEvent?>("accumulate")

    @JvmField
    public val xformedByName: MethodStringName2<InputEvent, InputEvent, Transform2D, Vector2> =
        MethodStringName2<InputEvent, InputEvent, Transform2D, Vector2>("xformed_by")

    /**
     * Device ID used for emulated mouse input from a touchscreen, or for emulated touch input from
     * a mouse. This can be used to distinguish emulated mouse input from physical mouse input, or
     * emulated touch input from physical touch input.
     */
    public final const val DEVICE_ID_EMULATION: Long = -1

    /**
     * Device ID used for input from a keyboard. This can be used to distinguish keyboard input
     * events from joypad input events.
     */
    public final const val DEVICE_ID_KEYBOARD: Long = 16

    /**
     * Device ID used for input from a mouse. This can be used to distinguish mouse input events
     * from joypad input events.
     */
    public final const val DEVICE_ID_MOUSE: Long = 32
  }

  public object MethodBindings {
    internal val setDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "set_device", 1286410249)

    internal val getDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "get_device", 3905245786)

    internal val isActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_action", 1558498928)

    internal val isActionPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_action_pressed", 1631499404)

    internal val isActionReleasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_action_released", 1558498928)

    internal val getActionStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "get_action_strength", 801543509)

    internal val isCanceledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_canceled", 36873697)

    internal val isPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_pressed", 36873697)

    internal val isReleasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_released", 36873697)

    internal val isEchoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_echo", 36873697)

    internal val asTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "as_text", 201670096)

    internal val isMatchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_match", 1754951977)

    internal val isActionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "is_action_type", 36873697)

    internal val accumulatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "accumulate", 1062211774)

    internal val xformedByPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEvent", "xformed_by", 1282766827)
  }
}
