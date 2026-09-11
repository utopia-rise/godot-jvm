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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.JoyAxis
import godot.core.JoyButton
import godot.core.Key
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.MethodStringName5
import godot.core.MouseButton
import godot.core.MouseButtonMask
import godot.core.Signal2
import godot.core.StringName
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.COLOR
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.VariantParser.VECTOR3
import godot.core.Vector2
import godot.core.Vector3
import godot.core.asCachedStringName
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
import kotlin.jvm.JvmStatic

/**
 * The [Input] singleton handles key presses, mouse buttons and movement, gamepads, and input
 * actions. Actions and their events can be set in the **Input Map** tab in **Project > Project
 * Settings**, or with the [InputMap] class.
 *
 * **Note:** [Input]'s methods reflect the global input state and are not affected by
 * [Control.acceptEvent] or [Viewport.setInputAsHandled], as those methods only deal with the way input
 * is propagated in the [SceneTree].
 */
@GodotBaseType
public object Input : Object() {
  @JvmField
  public val isAnythingPressedName: MethodStringName0<Input, Boolean> =
      MethodStringName0<Input, Boolean>("is_anything_pressed")

  @JvmField
  public val isKeyPressedName: MethodStringName1<Input, Boolean, Key> =
      MethodStringName1<Input, Boolean, Key>("is_key_pressed")

  @JvmField
  public val isPhysicalKeyPressedName: MethodStringName1<Input, Boolean, Key> =
      MethodStringName1<Input, Boolean, Key>("is_physical_key_pressed")

  @JvmField
  public val isKeyLabelPressedName: MethodStringName1<Input, Boolean, Key> =
      MethodStringName1<Input, Boolean, Key>("is_key_label_pressed")

  @JvmField
  public val isMouseButtonPressedName: MethodStringName1<Input, Boolean, MouseButton> =
      MethodStringName1<Input, Boolean, MouseButton>("is_mouse_button_pressed")

  @JvmField
  public val isJoyButtonPressedName: MethodStringName2<Input, Boolean, Int, JoyButton> =
      MethodStringName2<Input, Boolean, Int, JoyButton>("is_joy_button_pressed")

  @JvmField
  public val isActionPressedName: MethodStringName2<Input, Boolean, StringName, Boolean> =
      MethodStringName2<Input, Boolean, StringName, Boolean>("is_action_pressed")

  @JvmField
  public val isActionJustPressedName: MethodStringName2<Input, Boolean, StringName, Boolean> =
      MethodStringName2<Input, Boolean, StringName, Boolean>("is_action_just_pressed")

  @JvmField
  public val isActionJustReleasedName: MethodStringName2<Input, Boolean, StringName, Boolean> =
      MethodStringName2<Input, Boolean, StringName, Boolean>("is_action_just_released")

  @JvmField
  public val isActionJustPressedByEventName:
      MethodStringName3<Input, Boolean, StringName, InputEvent, Boolean> =
      MethodStringName3<Input, Boolean, StringName, InputEvent, Boolean>("is_action_just_pressed_by_event")

  @JvmField
  public val isActionJustReleasedByEventName:
      MethodStringName3<Input, Boolean, StringName, InputEvent, Boolean> =
      MethodStringName3<Input, Boolean, StringName, InputEvent, Boolean>("is_action_just_released_by_event")

  @JvmField
  public val getActionStrengthName: MethodStringName2<Input, Float, StringName, Boolean> =
      MethodStringName2<Input, Float, StringName, Boolean>("get_action_strength")

  @JvmField
  public val getActionRawStrengthName: MethodStringName2<Input, Float, StringName, Boolean> =
      MethodStringName2<Input, Float, StringName, Boolean>("get_action_raw_strength")

  @JvmField
  public val getAxisName: MethodStringName2<Input, Float, StringName, StringName> =
      MethodStringName2<Input, Float, StringName, StringName>("get_axis")

  @JvmField
  public val getVectorName:
      MethodStringName5<Input, Vector2, StringName, StringName, StringName, StringName, Float> =
      MethodStringName5<Input, Vector2, StringName, StringName, StringName, StringName, Float>("get_vector")

  @JvmField
  public val addJoyMappingName: MethodStringName2<Input, Unit, String, Boolean> =
      MethodStringName2<Input, Unit, String, Boolean>("add_joy_mapping")

  @JvmField
  public val removeJoyMappingName: MethodStringName1<Input, Unit, String> =
      MethodStringName1<Input, Unit, String>("remove_joy_mapping")

  @JvmField
  public val isJoyKnownName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("is_joy_known")

  @JvmField
  public val getJoyAxisName: MethodStringName2<Input, Float, Int, JoyAxis> =
      MethodStringName2<Input, Float, Int, JoyAxis>("get_joy_axis")

  @JvmField
  public val getJoyNameName: MethodStringName1<Input, String, Int> =
      MethodStringName1<Input, String, Int>("get_joy_name")

  @JvmField
  public val getJoyGuidName: MethodStringName1<Input, String, Int> =
      MethodStringName1<Input, String, Int>("get_joy_guid")

  @JvmField
  public val getJoyInfoName: MethodStringName1<Input, Dictionary<Any?, Any?>, Int> =
      MethodStringName1<Input, Dictionary<Any?, Any?>, Int>("get_joy_info")

  @JvmField
  public val shouldIgnoreDeviceName: MethodStringName2<Input, Boolean, Int, Int> =
      MethodStringName2<Input, Boolean, Int, Int>("should_ignore_device")

  @JvmField
  public val getConnectedJoypadsName: MethodStringName0<Input, VariantArray<Long>> =
      MethodStringName0<Input, VariantArray<Long>>("get_connected_joypads")

  @JvmField
  public val getJoyVibrationStrengthName: MethodStringName1<Input, Vector2, Int> =
      MethodStringName1<Input, Vector2, Int>("get_joy_vibration_strength")

  @JvmField
  public val getJoyVibrationDurationName: MethodStringName1<Input, Float, Int> =
      MethodStringName1<Input, Float, Int>("get_joy_vibration_duration")

  @JvmField
  public val getJoyVibrationRemainingDurationName: MethodStringName1<Input, Float, Int> =
      MethodStringName1<Input, Float, Int>("get_joy_vibration_remaining_duration")

  @JvmField
  public val isJoyVibratingName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("is_joy_vibrating")

  @JvmField
  public val hasJoyVibrationName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("has_joy_vibration")

  @JvmField
  public val startJoyVibrationName: MethodStringName4<Input, Unit, Int, Float, Float, Float> =
      MethodStringName4<Input, Unit, Int, Float, Float, Float>("start_joy_vibration")

  @JvmField
  public val stopJoyVibrationName: MethodStringName1<Input, Unit, Int> =
      MethodStringName1<Input, Unit, Int>("stop_joy_vibration")

  @JvmField
  public val vibrateHandheldName: MethodStringName2<Input, Unit, Int, Float> =
      MethodStringName2<Input, Unit, Int, Float>("vibrate_handheld")

  @JvmField
  public val setIgnoreJoypadOnUnfocusedApplicationName: MethodStringName1<Input, Unit, Boolean> =
      MethodStringName1<Input, Unit, Boolean>("set_ignore_joypad_on_unfocused_application")

  @JvmField
  public val isIgnoringJoypadOnUnfocusedApplicationName: MethodStringName0<Input, Boolean> =
      MethodStringName0<Input, Boolean>("is_ignoring_joypad_on_unfocused_application")

  @JvmField
  public val getGravityName: MethodStringName0<Input, Vector3> =
      MethodStringName0<Input, Vector3>("get_gravity")

  @JvmField
  public val getAccelerometerName: MethodStringName0<Input, Vector3> =
      MethodStringName0<Input, Vector3>("get_accelerometer")

  @JvmField
  public val getMagnetometerName: MethodStringName0<Input, Vector3> =
      MethodStringName0<Input, Vector3>("get_magnetometer")

  @JvmField
  public val getGyroscopeName: MethodStringName0<Input, Vector3> =
      MethodStringName0<Input, Vector3>("get_gyroscope")

  @JvmField
  public val getJoyAccelerometerName: MethodStringName1<Input, Vector3, Int> =
      MethodStringName1<Input, Vector3, Int>("get_joy_accelerometer")

  @JvmField
  public val getJoyGravityName: MethodStringName1<Input, Vector3, Int> =
      MethodStringName1<Input, Vector3, Int>("get_joy_gravity")

  @JvmField
  public val getJoyGyroscopeName: MethodStringName1<Input, Vector3, Int> =
      MethodStringName1<Input, Vector3, Int>("get_joy_gyroscope")

  @JvmField
  public val getJoyMotionSensorsRateName: MethodStringName1<Input, Float, Int> =
      MethodStringName1<Input, Float, Int>("get_joy_motion_sensors_rate")

  @JvmField
  public val isJoyMotionSensorsEnabledName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("is_joy_motion_sensors_enabled")

  @JvmField
  public val setJoyMotionSensorsEnabledName: MethodStringName2<Input, Unit, Int, Boolean> =
      MethodStringName2<Input, Unit, Int, Boolean>("set_joy_motion_sensors_enabled")

  @JvmField
  public val hasJoyMotionSensorsName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("has_joy_motion_sensors")

  @JvmField
  public val startJoyMotionSensorsCalibrationName: MethodStringName1<Input, Unit, Int> =
      MethodStringName1<Input, Unit, Int>("start_joy_motion_sensors_calibration")

  @JvmField
  public val stopJoyMotionSensorsCalibrationName: MethodStringName1<Input, Unit, Int> =
      MethodStringName1<Input, Unit, Int>("stop_joy_motion_sensors_calibration")

  @JvmField
  public val clearJoyMotionSensorsCalibrationName: MethodStringName1<Input, Unit, Int> =
      MethodStringName1<Input, Unit, Int>("clear_joy_motion_sensors_calibration")

  @JvmField
  public val getJoyMotionSensorsCalibrationName:
      MethodStringName1<Input, Dictionary<Any?, Any?>, Int> =
      MethodStringName1<Input, Dictionary<Any?, Any?>, Int>("get_joy_motion_sensors_calibration")

  @JvmField
  public val setJoyMotionSensorsCalibrationName:
      MethodStringName2<Input, Unit, Int, Dictionary<Any?, Any?>> =
      MethodStringName2<Input, Unit, Int, Dictionary<Any?, Any?>>("set_joy_motion_sensors_calibration")

  @JvmField
  public val isJoyMotionSensorsCalibratedName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("is_joy_motion_sensors_calibrated")

  @JvmField
  public val isJoyMotionSensorsCalibratingName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("is_joy_motion_sensors_calibrating")

  @JvmField
  public val setGravityName: MethodStringName1<Input, Unit, Vector3> =
      MethodStringName1<Input, Unit, Vector3>("set_gravity")

  @JvmField
  public val setAccelerometerName: MethodStringName1<Input, Unit, Vector3> =
      MethodStringName1<Input, Unit, Vector3>("set_accelerometer")

  @JvmField
  public val setMagnetometerName: MethodStringName1<Input, Unit, Vector3> =
      MethodStringName1<Input, Unit, Vector3>("set_magnetometer")

  @JvmField
  public val setGyroscopeName: MethodStringName1<Input, Unit, Vector3> =
      MethodStringName1<Input, Unit, Vector3>("set_gyroscope")

  @JvmField
  public val setJoyLightName: MethodStringName2<Input, Unit, Int, Color> =
      MethodStringName2<Input, Unit, Int, Color>("set_joy_light")

  @JvmField
  public val hasJoyLightName: MethodStringName1<Input, Boolean, Int> =
      MethodStringName1<Input, Boolean, Int>("has_joy_light")

  @JvmField
  public val getLastMouseVelocityName: MethodStringName0<Input, Vector2> =
      MethodStringName0<Input, Vector2>("get_last_mouse_velocity")

  @JvmField
  public val getLastMouseScreenVelocityName: MethodStringName0<Input, Vector2> =
      MethodStringName0<Input, Vector2>("get_last_mouse_screen_velocity")

  @JvmField
  public val getMouseButtonMaskName: MethodStringName0<Input, MouseButtonMask> =
      MethodStringName0<Input, MouseButtonMask>("get_mouse_button_mask")

  @JvmField
  public val setMouseModeName: MethodStringName1<Input, Unit, MouseMode> =
      MethodStringName1<Input, Unit, MouseMode>("set_mouse_mode")

  @JvmField
  public val getMouseModeName: MethodStringName0<Input, MouseMode> =
      MethodStringName0<Input, MouseMode>("get_mouse_mode")

  @JvmField
  public val warpMouseName: MethodStringName1<Input, Unit, Vector2> =
      MethodStringName1<Input, Unit, Vector2>("warp_mouse")

  @JvmField
  public val actionPressName: MethodStringName2<Input, Unit, StringName, Float> =
      MethodStringName2<Input, Unit, StringName, Float>("action_press")

  @JvmField
  public val actionReleaseName: MethodStringName1<Input, Unit, StringName> =
      MethodStringName1<Input, Unit, StringName>("action_release")

  @JvmField
  public val setDefaultCursorShapeName: MethodStringName1<Input, Unit, CursorShape> =
      MethodStringName1<Input, Unit, CursorShape>("set_default_cursor_shape")

  @JvmField
  public val getCurrentCursorShapeName: MethodStringName0<Input, CursorShape> =
      MethodStringName0<Input, CursorShape>("get_current_cursor_shape")

  @JvmField
  public val setCustomMouseCursorName:
      MethodStringName3<Input, Unit, Resource?, CursorShape, Vector2> =
      MethodStringName3<Input, Unit, Resource?, CursorShape, Vector2>("set_custom_mouse_cursor")

  @JvmField
  public val parseInputEventName: MethodStringName1<Input, Unit, InputEvent> =
      MethodStringName1<Input, Unit, InputEvent>("parse_input_event")

  @JvmField
  public val setUseAccumulatedInputName: MethodStringName1<Input, Unit, Boolean> =
      MethodStringName1<Input, Unit, Boolean>("set_use_accumulated_input")

  @JvmField
  public val isUsingAccumulatedInputName: MethodStringName0<Input, Boolean> =
      MethodStringName0<Input, Boolean>("is_using_accumulated_input")

  @JvmField
  public val flushBufferedEventsName: MethodStringName0<Input, Unit> =
      MethodStringName0<Input, Unit>("flush_buffered_events")

  @JvmField
  public val setEmulateMouseFromTouchName: MethodStringName1<Input, Unit, Boolean> =
      MethodStringName1<Input, Unit, Boolean>("set_emulate_mouse_from_touch")

  @JvmField
  public val isEmulatingMouseFromTouchName: MethodStringName0<Input, Boolean> =
      MethodStringName0<Input, Boolean>("is_emulating_mouse_from_touch")

  @JvmField
  public val setEmulateTouchFromMouseName: MethodStringName1<Input, Unit, Boolean> =
      MethodStringName1<Input, Unit, Boolean>("set_emulate_touch_from_mouse")

  @JvmField
  public val isEmulatingTouchFromMouseName: MethodStringName0<Input, Boolean> =
      MethodStringName0<Input, Boolean>("is_emulating_touch_from_mouse")

  /**
   * Emitted when a joypad device has been connected or disconnected.
   */
  @JvmStatic
  public val joyConnectionChanged: Signal2<Long, Boolean> by Signal2

  /**
   * Controls the mouse mode.
   */
  @JvmStatic
  public final inline var mouseMode: MouseMode
    @JvmName("mouseModeProperty")
    get() = getMouseMode()
    @JvmName("mouseModeProperty")
    set(`value`) {
      setMouseMode(value)
    }

  /**
   * If `true`, similar input events sent by the operating system are accumulated. When input
   * accumulation is enabled, all input events generated during a frame will be merged and emitted when
   * the frame is done rendering. Therefore, this limits the number of input method calls per second to
   * the rendering FPS.
   *
   * Input accumulation can be disabled to get slightly more precise/reactive input at the cost of
   * increased CPU usage. In applications where drawing freehand lines is required, input accumulation
   * should generally be disabled while the user is drawing the line to get results that closely follow
   * the actual input.
   *
   * **Note:** Input accumulation is *enabled* by default.
   */
  @JvmStatic
  public final inline var useAccumulatedInput: Boolean
    @JvmName("useAccumulatedInputProperty")
    get() = isUsingAccumulatedInput()
    @JvmName("useAccumulatedInputProperty")
    set(`value`) {
      setUseAccumulatedInput(value)
    }

  /**
   * If `true`, sends mouse input events when tapping or swiping on the touchscreen. See also
   * [ProjectSettings.inputDevices/pointing/emulateMouseFromTouch].
   */
  @JvmStatic
  public final inline var emulateMouseFromTouch: Boolean
    @JvmName("emulateMouseFromTouchProperty")
    get() = isEmulatingMouseFromTouch()
    @JvmName("emulateMouseFromTouchProperty")
    set(`value`) {
      setEmulateMouseFromTouch(value)
    }

  /**
   * If `true`, sends touch input events when clicking or dragging the mouse. See also
   * [ProjectSettings.inputDevices/pointing/emulateTouchFromMouse].
   */
  @JvmStatic
  public final inline var emulateTouchFromMouse: Boolean
    @JvmName("emulateTouchFromMouseProperty")
    get() = isEmulatingTouchFromMouse()
    @JvmName("emulateTouchFromMouseProperty")
    set(`value`) {
      setEmulateTouchFromMouse(value)
    }

  /**
   * If `true`, joypad input (including motion sensors) and LED light changes will be ignored and
   * joypad vibration will be stopped when the application is not focused.
   */
  @JvmStatic
  public final inline var ignoreJoypadOnUnfocusedApplication: Boolean
    @JvmName("ignoreJoypadOnUnfocusedApplicationProperty")
    get() = isIgnoringJoypadOnUnfocusedApplication()
    @JvmName("ignoreJoypadOnUnfocusedApplicationProperty")
    set(`value`) {
      setIgnoreJoypadOnUnfocusedApplication(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(11)
  }

  /**
   * Returns `true` if any action, key, joypad button, or mouse button is being pressed. This will
   * also return `true` if any action is simulated via code by calling [actionPress].
   */
  @JvmStatic
  public final fun isAnythingPressed(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAnythingPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if you are pressing the Latin key in the current keyboard layout. You can pass a
   * [Key] constant.
   *
   * [isKeyPressed] is only recommended over [isPhysicalKeyPressed] in non-game applications. This
   * ensures that shortcut keys behave as expected depending on the user's keyboard layout, as keyboard
   * shortcuts are generally dependent on the keyboard layout in non-game applications. If in doubt,
   * use [isPhysicalKeyPressed].
   *
   * **Note:** Due to keyboard ghosting, [isKeyPressed] may return `false` even if one of the
   * action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   *
   * **Note:** If you want to check if a key was just pressed by using its keycode, use Godot's
   * input action system with [isActionJustPressed] or use the [Node.Input] method like this instead:
   *
   * ```gdscript
   * //gdscript
   * func _input(event):
   * 	if event is InputEventKey and not event.is_echo() and event.is_pressed() and event.keycode ==
   * KEY_SPACE:
   * 		pass # Your code here.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Input(InputEvent @event)
   * {
   * 	if (@event is InputEventKey eventKey && !eventKey.IsEcho() && eventKey.Pressed &&
   * eventKey.Keycode == Key.Space)
   * 	{
   * 		// Your code here.
   * 	}
   * }
   * ```
   */
  @JvmStatic
  public final fun isKeyPressed(keycode: Key): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to keycode.value)
    TransferContext.callMethod(MethodBindings.isKeyPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if you are pressing the key in the physical location on the 101/102-key US
   * QWERTY keyboard. You can pass a [Key] constant.
   *
   * [isPhysicalKeyPressed] is recommended over [isKeyPressed] for in-game actions, as it will make
   * [kbd]W[/kbd]/[kbd]A[/kbd]/[kbd]S[/kbd]/[kbd]D[/kbd] layouts work regardless of the user's keyboard
   * layout. [isPhysicalKeyPressed] will also ensure that the top row number keys work on any keyboard
   * layout. If in doubt, use [isPhysicalKeyPressed].
   *
   * **Note:** Due to keyboard ghosting, [isPhysicalKeyPressed] may return `false` even if one of
   * the action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   *
   * **Note:** If you want to check if a key was just pressed by using its physical keycode, use
   * Godot's input action system with [isActionJustPressed] or use the [Node.Input] method like this
   * instead:
   *
   * ```gdscript
   * //gdscript
   * func _input(event):
   * 	if event is InputEventKey and not event.is_echo() and event.is_pressed() and
   * event.physical_keycode == KEY_SPACE:
   * 		pass # Your code here.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Input(InputEvent @event)
   * {
   * 	if (@event is InputEventKey eventKey && !eventKey.IsEcho() && eventKey.Pressed &&
   * eventKey.PhysicalKeycode == Key.Space)
   * 	{
   * 		// Your code here.
   * 	}
   * }
   * ```
   */
  @JvmStatic
  public final fun isPhysicalKeyPressed(keycode: Key): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to keycode.value)
    TransferContext.callMethod(MethodBindings.isPhysicalKeyPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if you are pressing the key with the [keycode] printed on it. You can pass a
   * [Key] constant or any Unicode character code.
   *
   * **Note:** If you want to check if a key was just pressed by using its label, use Godot's input
   * action system with [isActionJustPressed] or use the [Node.Input] method like this instead:
   *
   * ```gdscript
   * //gdscript
   * func _input(event):
   * 	if event is InputEventKey and not event.is_echo() and event.is_pressed() and event.key_label
   * == KEY_SPACE:
   * 		pass # Your code here.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Input(InputEvent @event)
   * {
   * 	if (@event is InputEventKey eventKey && !eventKey.IsEcho() && eventKey.Pressed &&
   * eventKey.KeyLabel == Key.Space)
   * 	{
   * 		// Your code here.
   * 	}
   * }
   * ```
   */
  @JvmStatic
  public final fun isKeyLabelPressed(keycode: Key): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to keycode.value)
    TransferContext.callMethod(MethodBindings.isKeyLabelPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if you are pressing the mouse button specified with [MouseButton].
   *
   * **Note:** If you want to check if a mouse button was just pressed, use Godot's input action
   * system with [isActionJustPressed] or use the [Node.Input] method like this instead:
   *
   * ```gdscript
   * //gdscript
   * func _input(event):
   * 	if event is InputEventMouseButton and event.is_pressed() and event.button_index ==
   * MOUSE_BUTTON_LEFT:
   * 		pass # Your code here.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Input(InputEvent @event)
   * {
   * 	if (@event is InputEventMouseButton eventMouseButton && eventMouseButton.Pressed &&
   * eventMouseButton.ButtonIndex == MouseButton.Left)
   * 	{
   * 		// Your code here.
   * 	}
   * }
   * ```
   */
  @JvmStatic
  public final fun isMouseButtonPressed(button: MouseButton): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to button.value)
    TransferContext.callMethod(MethodBindings.isMouseButtonPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if you are pressing the joypad button at index [button].
   *
   * **Note:** If you want to check if a joypad button was just pressed, use Godot's input action
   * system with [isActionJustPressed] or use the [Node.Input] method like this instead:
   *
   * ```gdscript
   * //gdscript
   * func _input(event):
   * 	if event is InputEventJoypadButton and event.is_pressed() and event.button_index ==
   * JOY_BUTTON_A:
   * 		pass # Your code here.
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Input(InputEvent @event)
   * {
   * 	if (@event is InputEventJoypadButton eventButton && eventButton.Pressed &&
   * eventButton.ButtonIndex == JoyButton.A)
   * 	{
   * 		// Your code here.
   * 	}
   * }
   * ```
   */
  @JvmStatic
  public final fun isJoyButtonPressed(device: Int, button: JoyButton): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong(), LONG to button.value)
    TransferContext.callMethod(MethodBindings.isJoyButtonPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if you are pressing the action event.
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
  @JvmStatic
  public final fun isActionPressed(action: StringName, exactMatch: Boolean = false): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, BOOL to exactMatch)
    TransferContext.callMethod(MethodBindings.isActionPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` when the user has *started* pressing the action event in the current frame or
   * physics tick. It will only return `true` on the frame or tick that the user pressed down the
   * button.
   *
   * This is useful for code that needs to run only once when an action is pressed, instead of every
   * frame while it's pressed.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** Returning `true` does not imply that the action is *still* pressed. An action can be
   * pressed and released again rapidly, and `true` will still be returned so as not to miss input.
   *
   * **Note:** Due to keyboard ghosting, [isActionJustPressed] may return `false` even if one of the
   * action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   *
   * **Note:** During input handling (e.g. [Node.Input]), use [InputEvent.isActionPressed] instead
   * to query the action state of the current event. See also [isActionJustPressedByEvent].
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustPressed(action: StringName, exactMatch: Boolean = false): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, BOOL to exactMatch)
    TransferContext.callMethod(MethodBindings.isActionJustPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` when the user *stops* pressing the action event in the current frame or physics
   * tick. It will only return `true` on the frame or tick that the user releases the button.
   *
   * **Note:** Returning `true` does not imply that the action is *still* not pressed. An action can
   * be released and pressed again rapidly, and `true` will still be returned so as not to miss input.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** During input handling (e.g. [Node.Input]), use [InputEvent.isActionReleased] instead
   * to query the action state of the current event. See also [isActionJustReleasedByEvent].
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustReleased(action: StringName, exactMatch: Boolean = false): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, BOOL to exactMatch)
    TransferContext.callMethod(MethodBindings.isActionJustReleasedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` when the user has *started* pressing the action event in the current frame or
   * physics tick, and the first event that triggered action press in the current frame/physics tick
   * was [event]. It will only return `true` on the frame or tick that the user pressed down the
   * button.
   *
   * This is useful for code that needs to run only once when an action is pressed, and the action
   * is processed during input handling (e.g. [Node.Input]).
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** Returning `true` does not imply that the action is *still* pressed. An action can be
   * pressed and released again rapidly, and `true` will still be returned so as not to miss input.
   *
   * **Note:** Due to keyboard ghosting, [isActionJustPressed] may return `false` even if one of the
   * action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustPressedByEvent(
    action: StringName,
    event: InputEvent,
    exactMatch: Boolean = false,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, OBJECT to event, BOOL to exactMatch)
    TransferContext.callMethod(MethodBindings.isActionJustPressedByEventPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` when the user *stops* pressing the action event in the current frame or physics
   * tick, and the first event that triggered action release in the current frame/physics tick was
   * [event]. It will only return `true` on the frame or tick that the user releases the button.
   *
   * This is useful when an action is processed during input handling (e.g. [Node.Input]).
   *
   * **Note:** Returning `true` does not imply that the action is *still* not pressed. An action can
   * be released and pressed again rapidly, and `true` will still be returned so as not to miss input.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustReleasedByEvent(
    action: StringName,
    event: InputEvent,
    exactMatch: Boolean = false,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, OBJECT to event, BOOL to exactMatch)
    TransferContext.callMethod(MethodBindings.isActionJustReleasedByEventPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a value between 0 and 1 representing the intensity of the given action. In a joypad,
   * for example, the further away the axis (analog sticks or L2, R2 triggers) is from the dead zone,
   * the closer the value will be to 1. If the action is mapped to a control that has no axis such as
   * the keyboard, the value returned will be 0 or 1.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getActionStrength(action: StringName, exactMatch: Boolean = false): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, BOOL to exactMatch)
    TransferContext.callMethod(MethodBindings.getActionStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns a value between 0 and 1 representing the raw intensity of the given action, ignoring
   * the action's deadzone. In most cases, you should use [getActionStrength] instead.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getActionRawStrength(action: StringName, exactMatch: Boolean = false): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, BOOL to exactMatch)
    TransferContext.callMethod(MethodBindings.getActionRawStrengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Get axis input by specifying two actions, one negative and one positive.
   *
   * This is a shorthand for writing `Input.get_action_strength("positive_action") -
   * Input.get_action_strength("negative_action")`.
   */
  @JvmStatic
  public final fun getAxis(negativeAction: StringName, positiveAction: StringName): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to negativeAction, STRING_NAME to positiveAction)
    TransferContext.callMethod(MethodBindings.getAxisPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Gets an input vector by specifying four actions for the positive and negative X and Y axes.
   *
   * This method is useful when getting vector input, such as from a joystick, directional pad,
   * arrows, or WASD. The vector has its length limited to 1 and has a circular deadzone, which is
   * useful for using vector input as movement.
   *
   * By default, the deadzone is automatically calculated from the average of the action deadzones.
   * However, you can override the deadzone to be whatever you want (on the range of 0 to 1).
   */
  @JvmOverloads
  @JvmStatic
  public final fun getVector(
    negativeX: StringName,
    positiveX: StringName,
    negativeY: StringName,
    positiveY: StringName,
    deadzone: Float = -1.0f,
  ): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to negativeX, STRING_NAME to positiveX, STRING_NAME to negativeY, STRING_NAME to positiveY, DOUBLE to deadzone.toDouble())
    TransferContext.callMethod(MethodBindings.getVectorPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Adds a new mapping entry (in SDL2 format) to the mapping database. Optionally update already
   * connected devices.
   */
  @JvmOverloads
  @JvmStatic
  public final fun addJoyMapping(mapping: String, updateExisting: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to mapping, BOOL to updateExisting)
    TransferContext.callMethod(MethodBindings.addJoyMappingPtr)
  }

  /**
   * Removes all mappings from the internal database that match the given GUID. All currently
   * connected joypads that use this GUID will become unmapped.
   *
   * On Android, Godot will map to an internal fallback mapping.
   */
  @JvmStatic
  public final fun removeJoyMapping(guid: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to guid)
    TransferContext.callMethod(MethodBindings.removeJoyMappingPtr)
  }

  /**
   * Returns `true` if the system knows the specified device. This means that it sets all button and
   * axis indices. Unknown joypads are not expected to match these constants, but you can still
   * retrieve events from them.
   */
  @JvmStatic
  public final fun isJoyKnown(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.isJoyKnownPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the current value of the joypad axis at index [axis].
   */
  @JvmStatic
  public final fun getJoyAxis(device: Int, axis: JoyAxis): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong(), LONG to axis.value)
    TransferContext.callMethod(MethodBindings.getJoyAxisPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the name of the joypad at the specified device index, e.g. `PS4 Controller`. Godot uses
   * the [url=https://github.com/gabomdq/SDL_GameControllerDB]SDL2 game controller database[/url] to
   * determine gamepad names.
   */
  @JvmStatic
  public final fun getJoyName(device: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns an SDL-compatible device GUID on platforms that use gamepad remapping, e.g.
   * `030000004c050000c405000000010000`. Returns an empty string if it cannot be found. Godot uses
   * SDL's internal mappings, supplemented by community-contributed mappings, to determine gamepad
   * names and mappings based on this GUID.
   *
   * On Windows, all XInput joypad GUIDs will be overridden by Godot to `__XINPUT_DEVICE__`, because
   * their mappings are the same.
   */
  @JvmStatic
  public final fun getJoyGuid(device: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyGuidPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns a dictionary with extra platform-specific information about the device, e.g. the raw
   * gamepad name from the OS or the Steam Input index.
   *
   * On Windows, Linux, macOS, and iOS, the dictionary contains the following fields:
   *
   * `raw_name`: The name of the controller as it came from the OS, before getting renamed by the
   * controller database.
   *
   * `vendor_id`: The USB vendor ID of the device.
   *
   * `product_id`: The USB product ID of the device.
   *
   * `serial_number`: The serial number of the device. This key won't be present if the serial
   * number is unavailable.
   *
   * The dictionary can also include the following fields under selected platforms:
   *
   * `steam_input_index`: The Steam Input gamepad index (Windows, Linux, and macOS only). If the
   * device is not a Steam Input device this key won't be present.
   *
   * `xinput_index`: The index of the controller in the XInput system (Windows only). This key won't
   * be present for devices not handled by XInput.
   *
   * **Note:** The returned dictionary is always empty on Android and Web.
   */
  @JvmStatic
  public final fun getJoyInfo(device: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyInfoPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Queries whether an input device should be ignored or not. Devices can be ignored by setting the
   * environment variable `SDL_GAMECONTROLLER_IGNORE_DEVICES`. Read the
   * [url=https://wiki.libsdl.org/SDL2]SDL documentation[/url] for more information.
   *
   * **Note:** Some 3rd party tools can contribute to the list of ignored devices. For example,
   * *SteamInput* creates virtual devices from physical devices for remapping purposes. To avoid
   * handling the same input device twice, the original device is added to the ignore list.
   */
  @JvmStatic
  public final fun shouldIgnoreDevice(vendorId: Int, productId: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to vendorId.toLong(), LONG to productId.toLong())
    TransferContext.callMethod(MethodBindings.shouldIgnoreDevicePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns an [VariantArray] containing the device IDs of all currently connected joypads.
   *
   * **Note:** The order of connected joypads can not be guaranteed to be the same after a project
   * and/or the editor is restarted, because Godot doesn't save the order of joypad connections.
   * Joypads are registered in the order they are discovered by Godot.
   */
  @JvmStatic
  public final fun getConnectedJoypads(): VariantArray<Long> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConnectedJoypadsPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Long>)
  }

  /**
   * Returns the strength of the joypad vibration: x is the strength of the weak motor, and y is the
   * strength of the strong motor.
   *
   * **Note:** This method returns the same values that were passed to [startJoyVibration], and
   * these values do **not** change when the joypad's vibration runs out, they only get reset after a
   * call to [stopJoyVibration].
   *
   * If you want to check if a joypad is still vibrating, use [isJoyVibrating] instead.
   */
  @JvmStatic
  public final fun getJoyVibrationStrength(device: Int): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyVibrationStrengthPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the duration of the current vibration effect in seconds.
   *
   * **Note:** This method returns the same value that was passed to [startJoyVibration], and this
   * value does **not** change when the joypad's vibration runs out, it only gets reset after a call to
   * [stopJoyVibration].
   *
   * If you want to check if a joypad is still vibrating, use [isJoyVibrating] instead.
   */
  @JvmStatic
  public final fun getJoyVibrationDuration(device: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyVibrationDurationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns the remaining duration of the current vibration effect in seconds.
   */
  @JvmStatic
  public final fun getJoyVibrationRemainingDuration(device: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyVibrationRemainingDurationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns `true` if the joypad is still vibrating after a call to [startJoyVibration].
   *
   * Unlike [getJoyVibrationStrength] and [getJoyVibrationDuration], this method returns `false`
   * after the joypad's vibration runs out.
   */
  @JvmStatic
  public final fun isJoyVibrating(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.isJoyVibratingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the joypad supports vibration. See also [startJoyVibration].
   *
   * **Note:** For macOS, vibration is only supported in macOS 11 and later. When connected via USB,
   * vibration is only supported for major brand controllers (except Xbox One and Xbox Series X/S
   * controllers) due to macOS limitations.
   */
  @JvmStatic
  public final fun hasJoyVibration(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.hasJoyVibrationPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Starts to vibrate the joypad. See also [hasJoyVibration] and [isJoyVibrating].
   *
   * Joypads usually come with two rumble motors, a strong and a weak one.
   *
   * [weakMagnitude] is the strength of the weak motor (between `0.0` and `1.0`).
   *
   * [strongMagnitude] is the strength of the strong motor (between `0.0` and `1.0`).
   *
   * [duration] is the duration of the effect in seconds (a duration of `0.0` will try to play the
   * vibration as long as possible, which is about 65 seconds).
   *
   * The vibration can be stopped early by calling [stopJoyVibration].
   *
   * See also [getJoyVibrationStrength] and [getJoyVibrationDuration].
   *
   * **Note:** For macOS, vibration is only supported in macOS 11 and later. When connected via USB,
   * vibration is only supported for major brand controllers (except Xbox One and Xbox Series X/S
   * controllers) due to macOS limitations.
   */
  @JvmOverloads
  @JvmStatic
  public final fun startJoyVibration(
    device: Int,
    weakMagnitude: Float,
    strongMagnitude: Float,
    duration: Float = 0.0f,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong(), DOUBLE to weakMagnitude.toDouble(), DOUBLE to strongMagnitude.toDouble(), DOUBLE to duration.toDouble())
    TransferContext.callMethod(MethodBindings.startJoyVibrationPtr)
  }

  /**
   * Stops the vibration of the joypad started with [startJoyVibration].
   */
  @JvmStatic
  public final fun stopJoyVibration(device: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.stopJoyVibrationPtr)
  }

  /**
   * Vibrate the handheld device for the specified duration in milliseconds.
   *
   * [amplitude] is the strength of the vibration, as a value between `0.0` and `1.0`. If set to
   * `-1.0`, the default vibration strength of the device is used.
   *
   * **Note:** This method is implemented on Android, iOS, and Web. It has no effect on other
   * platforms.
   *
   * **Note:** For Android, [vibrateHandheld] requires enabling the `VIBRATE` permission in the
   * export preset. Otherwise, [vibrateHandheld] will have no effect.
   *
   * **Note:** For iOS, specifying the duration is only supported in iOS 13 and later.
   *
   * **Note:** For Web, the amplitude cannot be changed.
   *
   * **Note:** Some web browsers such as Safari and Firefox for Android do not support
   * [vibrateHandheld].
   *
   * **Note:** Device settings such as vibration on/off, "do not disturb" mode or specific haptic
   * feedback on/off may prevent [vibrateHandheld] effects.
   */
  @JvmOverloads
  @JvmStatic
  public final fun vibrateHandheld(durationMs: Int = 500, amplitude: Float = -1.0f): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to durationMs.toLong(), DOUBLE to amplitude.toDouble())
    TransferContext.callMethod(MethodBindings.vibrateHandheldPtr)
  }

  @JvmStatic
  public final fun setIgnoreJoypadOnUnfocusedApplication(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setIgnoreJoypadOnUnfocusedApplicationPtr)
  }

  @JvmStatic
  public final fun isIgnoringJoypadOnUnfocusedApplication(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isIgnoringJoypadOnUnfocusedApplicationPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the gravity in m/s² of the device's accelerometer sensor, if the device has one.
   * Otherwise, the method returns [Vector3.ZERO].
   *
   * **Note:** This method only works on Android and iOS. On other platforms, it always returns
   * [Vector3.ZERO].
   *
   * **Note:** For Android, [ProjectSettings.inputDevices/sensors/enableGravity] must be enabled.
   */
  @JvmStatic
  public final fun getGravity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGravityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the acceleration in m/s² of the device's accelerometer sensor, if the device has one.
   * Otherwise, the method returns [Vector3.ZERO].
   *
   * Note this method returns an empty [Vector3] when running from the editor even when your device
   * has an accelerometer. You must export your project to a supported device to read values from the
   * accelerometer.
   *
   * **Note:** This method only works on Android and iOS. On other platforms, it always returns
   * [Vector3.ZERO].
   *
   * **Note:** For Android, [ProjectSettings.inputDevices/sensors/enableAccelerometer] must be
   * enabled.
   */
  @JvmStatic
  public final fun getAccelerometer(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAccelerometerPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the magnetic field strength in micro-Tesla for all axes of the device's magnetometer
   * sensor, if the device has one. Otherwise, the method returns [Vector3.ZERO].
   *
   * **Note:** This method only works on Android and iOS. On other platforms, it always returns
   * [Vector3.ZERO].
   *
   * **Note:** For Android, [ProjectSettings.inputDevices/sensors/enableMagnetometer] must be
   * enabled.
   */
  @JvmStatic
  public final fun getMagnetometer(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMagnetometerPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the rotation rate in rad/s around a device's X, Y, and Z axes of the gyroscope sensor,
   * if the device has one. Otherwise, the method returns [Vector3.ZERO].
   *
   * **Note:** This method only works on Android and iOS. On other platforms, it always returns
   * [Vector3.ZERO].
   *
   * **Note:** For Android, [ProjectSettings.inputDevices/sensors/enableGyroscope] must be enabled.
   */
  @JvmStatic
  public final fun getGyroscope(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGyroscopePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the acceleration, including the force of gravity, in m/s² of the joypad's accelerometer
   * sensor, if the joypad has one and it's currently enabled. Otherwise, the method returns
   * [Vector3.ZERO]. See also [getJoyGravity] and [setJoyMotionSensorsEnabled].
   *
   * For a joypad held in front of you, the returned axes are defined as follows:
   *
   * +X ... -X: left ... right;
   *
   * +Y ... -Y: bottom ... top;
   *
   * +Z ... -Z: farther ... closer.
   *
   * The gravity part value is measured as a vector with length of `9.8` away from the center of the
   * Earth, which is a negative Y value.
   *
   * **Note:** This feature is only supported on Windows, Linux, and macOS. On iOS, joypad
   * accelerometer sensor reading is not supported due to OS limitations.
   */
  @JvmStatic
  public final fun getJoyAccelerometer(device: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyAccelerometerPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the gravity in m/s² of the joypad's accelerometer sensor, if the joypad has one and
   * it's currently enabled. Otherwise, the method returns [Vector3.ZERO]. See also
   * [getJoyAccelerometer] and [setJoyMotionSensorsEnabled].
   *
   * For a joypad held in front of you, the returned axes are defined as follows:
   *
   * +X ... -X: left ... right;
   *
   * +Y ... -Y: bottom ... top;
   *
   * +Z ... -Z: farther ... closer.
   *
   * The gravity part value is measured as a vector with length of `9.8` away from the center of the
   * Earth, which is a negative Y value.
   *
   * **Note:** This feature is only supported on Windows, Linux, and macOS. On iOS, joypad
   * accelerometer sensor reading is not supported due to OS limitations.
   */
  @JvmStatic
  public final fun getJoyGravity(device: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyGravityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the rotation rate in rad/s around a joypad's X, Y, and Z axes of the gyroscope sensor,
   * if the joypad has one and it's currently enabled. Otherwise, the method returns [Vector3.ZERO].
   * See also [setJoyMotionSensorsEnabled].
   *
   * The rotation is positive in the counter-clockwise direction.
   *
   * For a joypad held in front of you, the returned axes are defined as follows:
   *
   * X: Angular speed around the X axis (pitch);
   *
   * Y: Angular speed around the Y axis (yaw);
   *
   * Z: Angular speed around the Z axis (roll).
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad gyroscope and
   * gyroscope calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun getJoyGyroscope(device: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyGyroscopePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the joypad's motion sensor rate in Hz, if the joypad has motion sensors and they're
   * currently enabled. See also [setJoyMotionSensorsEnabled].
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun getJoyMotionSensorsRate(device: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyMotionSensorsRatePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns `true` if the requested joypad has motion sensors (accelerometer and gyroscope) and
   * they are currently enabled. See also [setJoyMotionSensorsEnabled] and [hasJoyMotionSensors].
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun isJoyMotionSensorsEnabled(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.isJoyMotionSensorsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Enables or disables the motion sensors (accelerometer and gyroscope), if available, on the
   * specified joypad.
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * It's recommended to disable the motion sensors when they're no longer being used, because
   * otherwise it might drain the controller battery faster.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun setJoyMotionSensorsEnabled(device: Int, enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong(), BOOL to enable)
    TransferContext.callMethod(MethodBindings.setJoyMotionSensorsEnabledPtr)
  }

  /**
   * Returns `true` if the joypad has motion sensors (accelerometer and gyroscope).
   *
   * **Note:** On iOS, joypad accelerometer sensor reading is not supported due to OS limitations.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun hasJoyMotionSensors(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.hasJoyMotionSensorsPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Starts the process of calibrating the specified joypad's gyroscope, if it has one.
   *
   * Once a joypad's gyroscope has been calibrated correctly (e.g. laying still on a table without
   * being rotated), [getJoyGyroscope] will return values close or equal to [Vector3.ZERO] when the
   * joypad is not being rotated.
   *
   * Here's an example of how to use joypad gyroscope and gyroscope calibration in your games:
   *
   * ```gdscript
   * //gdscript
   * const GYRO_SENSITIVITY = 10.0
   *
   * func _ready():
   * 	# In this example we only use the first connected joypad (id 0).
   * 	if 0 not in Input.get_connected_joypads():
   * 		return
   *
   * 	if not Input.has_joy_motion_sensors(0):
   * 		return
   *
   * 	# We must enable the motion sensors before using them.
   * 	Input.set_joy_motion_sensors_enabled(0, true)
   *
   * 	# (Tell the users here that they need to put their joypads on a flat surface and wait for
   * confirmation.)
   *
   * 	# Start the calibration process.
   * 	calibrate_motion()
   *
   * func _process(delta):
   * 	# Only move the object if the joypad motion sensors are calibrated.
   * 	if Input.is_joy_motion_sensors_calibrated(0):
   * 		move_object(delta)
   *
   * func calibrate_motion():
   * 	Input.start_joy_motion_sensors_calibration(0)
   *
   * 	# Wait for some time.
   * 	await get_tree().create_timer(1.0).timeout
   *
   * 	Input.stop_joy_motion_sensors_calibration(0)
   * 	# The joypad is now calibrated.
   *
   * func move_object(delta):
   * 	var node: Node3D = ... # Put your node here.
   *
   * 	var gyro := Input.get_joy_gyroscope(0)
   * 	node.rotation.x -= -gyro.y * GYRO_SENSITIVITY * delta # Use rotation around the Y axis (yaw)
   * here.
   * 	node.rotation.y += -gyro.x * GYRO_SENSITIVITY * delta # Use rotation around the X axis (pitch)
   * here.
   * ```
   *
   * ```csharp
   * //csharp
   * private const float GyroSensitivity = 10.0;
   *
   * public override void _Ready()
   * {
   * 	// In this example we only use the first connected joypad (id 0).
   * 	if (!Input.GetConnectedJoypads().Contains(0))
   * 	{
   * 		return;
   * 	}
   *
   * 	if (!Input.HasJoyMotionSensors(0))
   * 	{
   * 		return;
   * 	}
   *
   * 	// We must enable the accelerometer and the gyroscope before using them.
   * 	Input.SetJoyMotionSensorsEnabled(0, true);
   *
   * 	// (Tell the users here that they need to put their joypads on a flat surface and wait for
   * confirmation.)
   *
   * 	// Start the calibration process.
   * 	CalibrateMotion();
   * }
   *
   * public override void _Process(double delta)
   * {
   * 	// Only move the object if the joypad motion sensors are calibrated.
   * 	if (Input.IsJoyMotionSensorsCalibrated(0))
   * 	{
   * 		MoveObject(delta);
   * 	}
   * }
   *
   * private async Task CalibrateMotion()
   * {
   * 	Input.StartJoyMotionSensorsCalibration(0);
   *
   * 	// Wait for some time.
   * 	await ToSignal(GetTree().CreateTimer(1.0), SceneTreeTimer.SignalName.Timeout);
   *
   * 	Input.StopJoyMotionSensorsCalibration(0);
   * 	// The joypad is now calibrated.
   * }
   *
   * private void MoveObject(double delta)
   * {
   * 	Node3D node = ... ; // Put your object here.
   * 	Vector3 gyro = Input.GetJoyGyroscope(0);
   * 	Vector3 rotation = node.Rotation;
   * 	rotation.X -= -gyro.Y * GyroSensitivity * (float)delta; // Use rotation around the Y axis
   * (yaw) here.
   * 	rotation.Y += -gyro.X * GyroSensitivity * (float)delta; // Use rotation around the X axis
   * (pitch) here.
   * 	node.Rotation = rotation;
   * }
   * ```
   *
   * **Note:** Accelerometer sensor doesn't usually require calibration.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun startJoyMotionSensorsCalibration(device: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.startJoyMotionSensorsCalibrationPtr)
  }

  /**
   * Stops the calibration process of the specified joypad's motion sensors.
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun stopJoyMotionSensorsCalibration(device: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.stopJoyMotionSensorsCalibrationPtr)
  }

  /**
   * Clears the calibration information for the specified joypad's motion sensors, if it has any and
   * if they were calibrated.
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun clearJoyMotionSensorsCalibration(device: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.clearJoyMotionSensorsCalibrationPtr)
  }

  /**
   * Returns the calibration information about the specified joypad's motion sensors in the form of
   * a [Dictionary], if it has any and if they have been calibrated, otherwise returns an empty
   * [Dictionary].
   *
   * The dictionary contains the following fields:
   *
   * `gyroscope_offset`: average offset in gyroscope values from [Vector2.ZERO] in rad/s.
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun getJoyMotionSensorsCalibration(device: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.getJoyMotionSensorsCalibrationPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Sets the specified joypad's calibration information. See also [getJoyMotionSensorsCalibration].
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun setJoyMotionSensorsCalibration(device: Int,
      calibrationInfo: Dictionary<Any?, Any?>): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong(), DICTIONARY to calibrationInfo)
    TransferContext.callMethod(MethodBindings.setJoyMotionSensorsCalibrationPtr)
  }

  /**
   * Returns `true` if the joypad's motion sensors have been calibrated.
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun isJoyMotionSensorsCalibrated(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.isJoyMotionSensorsCalibratedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if the joypad's motion sensors are currently being calibrated.
   *
   * See [startJoyMotionSensorsCalibration] for an example on how to use joypad motion sensors and
   * calibration in your games.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun isJoyMotionSensorsCalibrating(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.isJoyMotionSensorsCalibratingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the gravity value of the accelerometer sensor. Can be used for debugging on devices
   * without a hardware sensor, for example in an editor on a PC.
   *
   * **Note:** This value can be immediately overwritten by the hardware sensor value on Android and
   * iOS.
   */
  @JvmStatic
  public final fun setGravity(`value`: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to value)
    TransferContext.callMethod(MethodBindings.setGravityPtr)
  }

  /**
   * Sets the acceleration value of the accelerometer sensor. Can be used for debugging on devices
   * without a hardware sensor, for example in an editor on a PC.
   *
   * **Note:** This value can be immediately overwritten by the hardware sensor value on Android and
   * iOS.
   */
  @JvmStatic
  public final fun setAccelerometer(`value`: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to value)
    TransferContext.callMethod(MethodBindings.setAccelerometerPtr)
  }

  /**
   * Sets the value of the magnetic field of the magnetometer sensor. Can be used for debugging on
   * devices without a hardware sensor, for example in an editor on a PC.
   *
   * **Note:** This value can be immediately overwritten by the hardware sensor value on Android and
   * iOS.
   */
  @JvmStatic
  public final fun setMagnetometer(`value`: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to value)
    TransferContext.callMethod(MethodBindings.setMagnetometerPtr)
  }

  /**
   * Sets the value of the rotation rate of the gyroscope sensor. Can be used for debugging on
   * devices without a hardware sensor, for example in an editor on a PC.
   *
   * **Note:** This value can be immediately overwritten by the hardware sensor value on Android and
   * iOS.
   */
  @JvmStatic
  public final fun setGyroscope(`value`: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to value)
    TransferContext.callMethod(MethodBindings.setGyroscopePtr)
  }

  /**
   * Sets the joypad's LED light, if available, to the specified color. See also [hasJoyLight].
   *
   * **Note:** There is no way to get the color of the light from a joypad. If you need to know the
   * assigned color, store it separately.
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun setJoyLight(device: Int, color: Color): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong(), COLOR to color)
    TransferContext.callMethod(MethodBindings.setJoyLightPtr)
  }

  /**
   * Returns `true` if the joypad has an LED light that can change colors and/or brightness. See
   * also [setJoyLight].
   *
   * **Note:** This feature is only supported on Windows, Linux, macOS, and iOS.
   */
  @JvmStatic
  public final fun hasJoyLight(device: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to device.toLong())
    TransferContext.callMethod(MethodBindings.hasJoyLightPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the last mouse velocity. To provide a precise and jitter-free velocity, mouse velocity
   * is only calculated every 0.1s. Therefore, mouse velocity will lag mouse movements.
   */
  @JvmStatic
  public final fun getLastMouseVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastMouseVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the last mouse velocity in screen coordinates. To provide a precise and jitter-free
   * velocity, mouse velocity is only calculated every 0.1s. Therefore, mouse velocity will lag mouse
   * movements.
   */
  @JvmStatic
  public final fun getLastMouseScreenVelocity(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLastMouseScreenVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns mouse buttons as a bitmask. If multiple mouse buttons are pressed at the same time, the
   * bits are added together. Equivalent to [DisplayServer.mouseGetButtonState].
   */
  @JvmStatic
  public final fun getMouseButtonMask(): MouseButtonMask {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMouseButtonMaskPtr)
    return MouseButtonMask(TransferContext.readReturnValue(LONG) as Long)
  }

  @JvmStatic
  public final fun setMouseMode(mode: MouseMode): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to mode.value)
    TransferContext.callMethod(MethodBindings.setMouseModePtr)
  }

  @JvmStatic
  public final fun getMouseMode(): MouseMode {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMouseModePtr)
    return MouseMode.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the mouse position to the specified vector, provided in pixels and relative to an origin
   * at the upper left corner of the currently focused Window Manager game window.
   *
   * Mouse position is clipped to the limits of the screen resolution, or to the limits of the game
   * window if [MouseMode] is set to [MOUSE_MODE_CONFINED] or [MOUSE_MODE_CONFINED_HIDDEN].
   *
   * **Note:** [warpMouse] is only supported on Windows, macOS and Linux. It has no effect on
   * Android, iOS and Web.
   */
  @JvmStatic
  public final fun warpMouse(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.warpMousePtr)
  }

  /**
   * This will simulate pressing the specified action.
   *
   * The strength can be used for non-boolean actions, it's ranged between 0 and 1 representing the
   * intensity of the given action.
   *
   * **Note:** This method will not cause any [Node.Input] calls. It is intended to be used with
   * [isActionPressed] and [isActionJustPressed]. If you want to simulate `_input`, use
   * [parseInputEvent] instead.
   */
  @JvmOverloads
  @JvmStatic
  public final fun actionPress(action: StringName, strength: Float = 1.0f): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action, DOUBLE to strength.toDouble())
    TransferContext.callMethod(MethodBindings.actionPressPtr)
  }

  /**
   * If the specified action is already pressed, this will release it.
   */
  @JvmStatic
  public final fun actionRelease(action: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to action)
    TransferContext.callMethod(MethodBindings.actionReleasePtr)
  }

  /**
   * Sets the default cursor shape to be used in the viewport instead of [CURSOR_ARROW].
   *
   * **Note:** If you want to change the default cursor shape for [Control]'s nodes, use
   * [Control.mouseDefaultCursorShape] instead.
   *
   * **Note:** This method generates an [InputEventMouseMotion] to update cursor immediately.
   */
  @JvmOverloads
  @JvmStatic
  public final fun setDefaultCursorShape(shape: CursorShape = Input.CursorShape.ARROW): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to shape.value)
    TransferContext.callMethod(MethodBindings.setDefaultCursorShapePtr)
  }

  /**
   * Returns the currently assigned cursor shape.
   */
  @JvmStatic
  public final fun getCurrentCursorShape(): CursorShape {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCurrentCursorShapePtr)
    return CursorShape.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets a custom mouse cursor image, which is only visible inside the game window, for the given
   * mouse [shape]. The hotspot can also be specified. Passing `null` to the image parameter resets to
   * the system cursor.
   *
   * [image] can be either [Texture2D] or [Image] and its size must be lower than or equal to
   * 256×256. To avoid rendering issues, sizes lower than or equal to 128×128 are recommended.
   *
   * [hotspot] must be within [image]'s size.
   *
   * **Note:** [AnimatedTexture]s aren't supported as custom mouse cursors. If using an
   * [AnimatedTexture], only the first frame will be displayed.
   *
   * **Note:** The **Lossless**, **Lossy** or **Uncompressed** compression modes are recommended.
   * The **Video RAM** compression mode can be used, but it will be decompressed on the CPU, which
   * means loading times are slowed down and no memory is saved compared to lossless modes.
   *
   * **Note:** On the web platform, the maximum allowed cursor image size is 128×128. Cursor images
   * larger than 32×32 will also only be displayed if the mouse cursor image is entirely located within
   * the page for [url=https://chromestatus.com/feature/5825971391299584]security reasons[/url].
   */
  @JvmOverloads
  @JvmStatic
  public final fun setCustomMouseCursor(
    image: Resource?,
    shape: CursorShape = Input.CursorShape.ARROW,
    hotspot: Vector2 = Vector2(0, 0),
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to image, LONG to shape.value, VECTOR2 to hotspot)
    TransferContext.callMethod(MethodBindings.setCustomMouseCursorPtr)
  }

  /**
   * Feeds an [InputEvent] to the game. Can be used to artificially trigger input events from code.
   * Also generates [Node.Input] calls.
   *
   * ```gdscript
   * //gdscript
   * var cancel_event = InputEventAction.new()
   * cancel_event.action = "ui_cancel"
   * cancel_event.pressed = true
   * Input.parse_input_event(cancel_event)
   * ```
   *
   * ```csharp
   * //csharp
   * var cancelEvent = new InputEventAction();
   * cancelEvent.Action = "ui_cancel";
   * cancelEvent.Pressed = true;
   * Input.ParseInputEvent(cancelEvent);
   * ```
   *
   * **Note:** Calling this function has no influence on the operating system. So for example
   * sending an [InputEventMouseMotion] will not move the OS mouse cursor to the specified position
   * (use [warpMouse] instead) and sending [kbd]Alt/Cmd + Tab[/kbd] as [InputEventKey] won't toggle
   * between active windows.
   */
  @JvmStatic
  public final fun parseInputEvent(event: InputEvent): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to event)
    TransferContext.callMethod(MethodBindings.parseInputEventPtr)
  }

  @JvmStatic
  public final fun setUseAccumulatedInput(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setUseAccumulatedInputPtr)
  }

  @JvmStatic
  public final fun isUsingAccumulatedInput(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingAccumulatedInputPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sends all input events which are in the current buffer to the game loop. These events may have
   * been buffered as a result of accumulated input ([useAccumulatedInput]) or agile input flushing
   * ([ProjectSettings.inputDevices/buffering/agileEventFlushing]).
   *
   * The engine will already do this itself at key execution points (at least once per frame).
   * However, this can be useful in advanced cases where you want precise control over the timing of
   * event handling.
   */
  @JvmStatic
  public final fun flushBufferedEvents(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.flushBufferedEventsPtr)
  }

  @JvmStatic
  public final fun setEmulateMouseFromTouch(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEmulateMouseFromTouchPtr)
  }

  @JvmStatic
  public final fun isEmulatingMouseFromTouch(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmulatingMouseFromTouchPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  @JvmStatic
  public final fun setEmulateTouchFromMouse(enable: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enable)
    TransferContext.callMethod(MethodBindings.setEmulateTouchFromMousePtr)
  }

  @JvmStatic
  public final fun isEmulatingTouchFromMouse(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmulatingTouchFromMousePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if you are pressing the action event.
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
  @JvmStatic
  public final fun isActionPressed(action: String, exactMatch: Boolean = false): Boolean =
      isActionPressed(action.asCachedStringName(), exactMatch)

  /**
   * Returns `true` when the user has *started* pressing the action event in the current frame or
   * physics tick. It will only return `true` on the frame or tick that the user pressed down the
   * button.
   *
   * This is useful for code that needs to run only once when an action is pressed, instead of every
   * frame while it's pressed.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** Returning `true` does not imply that the action is *still* pressed. An action can be
   * pressed and released again rapidly, and `true` will still be returned so as not to miss input.
   *
   * **Note:** Due to keyboard ghosting, [isActionJustPressed] may return `false` even if one of the
   * action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   *
   * **Note:** During input handling (e.g. [Node.Input]), use [InputEvent.isActionPressed] instead
   * to query the action state of the current event. See also [isActionJustPressedByEvent].
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustPressed(action: String, exactMatch: Boolean = false): Boolean =
      isActionJustPressed(action.asCachedStringName(), exactMatch)

  /**
   * Returns `true` when the user *stops* pressing the action event in the current frame or physics
   * tick. It will only return `true` on the frame or tick that the user releases the button.
   *
   * **Note:** Returning `true` does not imply that the action is *still* not pressed. An action can
   * be released and pressed again rapidly, and `true` will still be returned so as not to miss input.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** During input handling (e.g. [Node.Input]), use [InputEvent.isActionReleased] instead
   * to query the action state of the current event. See also [isActionJustReleasedByEvent].
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustReleased(action: String, exactMatch: Boolean = false): Boolean =
      isActionJustReleased(action.asCachedStringName(), exactMatch)

  /**
   * Returns `true` when the user has *started* pressing the action event in the current frame or
   * physics tick, and the first event that triggered action press in the current frame/physics tick
   * was [event]. It will only return `true` on the frame or tick that the user pressed down the
   * button.
   *
   * This is useful for code that needs to run only once when an action is pressed, and the action
   * is processed during input handling (e.g. [Node.Input]).
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   *
   * **Note:** Returning `true` does not imply that the action is *still* pressed. An action can be
   * pressed and released again rapidly, and `true` will still be returned so as not to miss input.
   *
   * **Note:** Due to keyboard ghosting, [isActionJustPressed] may return `false` even if one of the
   * action's keys is pressed. See
   * [url=$DOCS_URL/tutorials/inputs/input_examples.html#keyboard-events]Input examples[/url] in the
   * documentation for more information.
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustPressedByEvent(
    action: String,
    event: InputEvent,
    exactMatch: Boolean = false,
  ): Boolean = isActionJustPressedByEvent(action.asCachedStringName(), event, exactMatch)

  /**
   * Returns `true` when the user *stops* pressing the action event in the current frame or physics
   * tick, and the first event that triggered action release in the current frame/physics tick was
   * [event]. It will only return `true` on the frame or tick that the user releases the button.
   *
   * This is useful when an action is processed during input handling (e.g. [Node.Input]).
   *
   * **Note:** Returning `true` does not imply that the action is *still* not pressed. An action can
   * be released and pressed again rapidly, and `true` will still be returned so as not to miss input.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun isActionJustReleasedByEvent(
    action: String,
    event: InputEvent,
    exactMatch: Boolean = false,
  ): Boolean = isActionJustReleasedByEvent(action.asCachedStringName(), event, exactMatch)

  /**
   * Returns a value between 0 and 1 representing the intensity of the given action. In a joypad,
   * for example, the further away the axis (analog sticks or L2, R2 triggers) is from the dead zone,
   * the closer the value will be to 1. If the action is mapped to a control that has no axis such as
   * the keyboard, the value returned will be 0 or 1.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getActionStrength(action: String, exactMatch: Boolean = false): Float =
      getActionStrength(action.asCachedStringName(), exactMatch)

  /**
   * Returns a value between 0 and 1 representing the raw intensity of the given action, ignoring
   * the action's deadzone. In most cases, you should use [getActionStrength] instead.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun getActionRawStrength(action: String, exactMatch: Boolean = false): Float =
      getActionRawStrength(action.asCachedStringName(), exactMatch)

  /**
   * Get axis input by specifying two actions, one negative and one positive.
   *
   * This is a shorthand for writing `Input.get_action_strength("positive_action") -
   * Input.get_action_strength("negative_action")`.
   */
  @JvmStatic
  public final fun getAxis(negativeAction: String, positiveAction: String): Float =
      getAxis(negativeAction.asCachedStringName(), positiveAction.asCachedStringName())

  /**
   * Gets an input vector by specifying four actions for the positive and negative X and Y axes.
   *
   * This method is useful when getting vector input, such as from a joystick, directional pad,
   * arrows, or WASD. The vector has its length limited to 1 and has a circular deadzone, which is
   * useful for using vector input as movement.
   *
   * By default, the deadzone is automatically calculated from the average of the action deadzones.
   * However, you can override the deadzone to be whatever you want (on the range of 0 to 1).
   */
  @JvmOverloads
  @JvmStatic
  public final fun getVector(
    negativeX: String,
    positiveX: String,
    negativeY: String,
    positiveY: String,
    deadzone: Float = -1.0f,
  ): Vector2 =
      getVector(negativeX.asCachedStringName(), positiveX.asCachedStringName(), negativeY.asCachedStringName(), positiveY.asCachedStringName(), deadzone)

  /**
   * This will simulate pressing the specified action.
   *
   * The strength can be used for non-boolean actions, it's ranged between 0 and 1 representing the
   * intensity of the given action.
   *
   * **Note:** This method will not cause any [Node.Input] calls. It is intended to be used with
   * [isActionPressed] and [isActionJustPressed]. If you want to simulate `_input`, use
   * [parseInputEvent] instead.
   */
  @JvmOverloads
  @JvmStatic
  public final fun actionPress(action: String, strength: Float = 1.0f) =
      actionPress(action.asCachedStringName(), strength)

  /**
   * If the specified action is already pressed, this will release it.
   */
  @JvmStatic
  public final fun actionRelease(action: String) = actionRelease(action.asCachedStringName())

  public enum class MouseMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Makes the mouse cursor visible if it is hidden.
     */
    VISIBLE(0),
    /**
     * Makes the mouse cursor hidden if it is visible.
     */
    HIDDEN(1),
    /**
     * Captures the mouse. The mouse will be hidden and its position locked at the center of the
     * window manager's window.
     *
     * **Note:** If you want to process the mouse's movement in this mode, you need to use
     * [InputEventMouseMotion.relative].
     */
    CAPTURED(2),
    /**
     * Confines the mouse cursor to the game window, and make it visible.
     */
    CONFINED(3),
    /**
     * Confines the mouse cursor to the game window, and make it hidden.
     */
    CONFINED_HIDDEN(4),
    /**
     * Max value of the [MouseMode].
     */
    MAX(5),
    ;

    public companion object {
      public fun from(`value`: Long): MouseMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class CursorShape(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Arrow cursor. Standard, default pointing cursor.
     */
    ARROW(0),
    /**
     * I-beam cursor. Usually used to show where the text cursor will appear when the mouse is
     * clicked.
     */
    IBEAM(1),
    /**
     * Pointing hand cursor. Usually used to indicate the pointer is over a link or other
     * interactable item.
     */
    POINTING_HAND(2),
    /**
     * Cross cursor. Typically appears over regions in which a drawing operation can be performed or
     * for selections.
     */
    CROSS(3),
    /**
     * Wait cursor. Indicates that the application is busy performing an operation, and that it
     * cannot be used during the operation (e.g. something is blocking its main thread).
     */
    WAIT(4),
    /**
     * Busy cursor. Indicates that the application is busy performing an operation, and that it is
     * still usable during the operation.
     */
    BUSY(5),
    /**
     * Drag cursor. Usually displayed when dragging something.
     *
     * **Note:** Windows lacks a dragging cursor, so [CURSOR_DRAG] is the same as [CURSOR_MOVE] for
     * this platform.
     */
    DRAG(6),
    /**
     * Can drop cursor. Usually displayed when dragging something to indicate that it can be dropped
     * at the current position.
     */
    CAN_DROP(7),
    /**
     * Forbidden cursor. Indicates that the current action is forbidden (for example, when dragging
     * something) or that the control at a position is disabled.
     */
    FORBIDDEN(8),
    /**
     * Vertical resize mouse cursor. A double-headed vertical arrow. It tells the user they can
     * resize the window or the panel vertically.
     */
    VSIZE(9),
    /**
     * Horizontal resize mouse cursor. A double-headed horizontal arrow. It tells the user they can
     * resize the window or the panel horizontally.
     */
    HSIZE(10),
    /**
     * Window resize mouse cursor. The cursor is a double-headed arrow that goes from the bottom
     * left to the top right. It tells the user they can resize the window or the panel both
     * horizontally and vertically.
     */
    BDIAGSIZE(11),
    /**
     * Window resize mouse cursor. The cursor is a double-headed arrow that goes from the top left
     * to the bottom right, the opposite of [CURSOR_BDIAGSIZE]. It tells the user they can resize the
     * window or the panel both horizontally and vertically.
     */
    FDIAGSIZE(12),
    /**
     * Move cursor. Indicates that something can be moved.
     */
    MOVE(13),
    /**
     * Vertical split mouse cursor. On Windows, it's the same as [CURSOR_VSIZE].
     */
    VSPLIT(14),
    /**
     * Horizontal split mouse cursor. On Windows, it's the same as [CURSOR_HSIZE].
     */
    HSPLIT(15),
    /**
     * Help cursor. Usually a question mark.
     */
    HELP(16),
    ;

    public companion object {
      public fun from(`value`: Long): CursorShape = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val isAnythingPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_anything_pressed", 36873697)

    internal val isKeyPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_key_pressed", 1938909964)

    internal val isPhysicalKeyPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_physical_key_pressed", 1938909964)

    internal val isKeyLabelPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_key_label_pressed", 1938909964)

    internal val isMouseButtonPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_mouse_button_pressed", 1821097125)

    internal val isJoyButtonPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_joy_button_pressed", 787208542)

    internal val isActionPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_action_pressed", 1558498928)

    internal val isActionJustPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_action_just_pressed", 1558498928)

    internal val isActionJustReleasedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_action_just_released", 1558498928)

    internal val isActionJustPressedByEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_action_just_pressed_by_event", 551972873)

    internal val isActionJustReleasedByEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_action_just_released_by_event", 551972873)

    internal val getActionStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_action_strength", 801543509)

    internal val getActionRawStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_action_raw_strength", 801543509)

    internal val getAxisPtr: VoidPtr = TypeManager.getMethodBindPtr("Input", "get_axis", 1958752504)

    internal val getVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_vector", 2479607902)

    internal val addJoyMappingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "add_joy_mapping", 1168363258)

    internal val removeJoyMappingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "remove_joy_mapping", 83702148)

    internal val isJoyKnownPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_joy_known", 3067735520)

    internal val getJoyAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_axis", 4063175957)

    internal val getJoyNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_name", 990163283)

    internal val getJoyGuidPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_guid", 844755477)

    internal val getJoyInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_info", 3485342025)

    internal val shouldIgnoreDevicePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "should_ignore_device", 2522259332)

    internal val getConnectedJoypadsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_connected_joypads", 2915620761)

    internal val getJoyVibrationStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_vibration_strength", 3114997196)

    internal val getJoyVibrationDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_vibration_duration", 4025615559)

    internal val getJoyVibrationRemainingDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_vibration_remaining_duration", 4025615559)

    internal val isJoyVibratingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_joy_vibrating", 3067735520)

    internal val hasJoyVibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "has_joy_vibration", 1116898809)

    internal val startJoyVibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "start_joy_vibration", 2576575033)

    internal val stopJoyVibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "stop_joy_vibration", 1286410249)

    internal val vibrateHandheldPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "vibrate_handheld", 544894297)

    internal val setIgnoreJoypadOnUnfocusedApplicationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_ignore_joypad_on_unfocused_application", 2586408642)

    internal val isIgnoringJoypadOnUnfocusedApplicationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_ignoring_joypad_on_unfocused_application", 36873697)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_gravity", 3360562783)

    internal val getAccelerometerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_accelerometer", 3360562783)

    internal val getMagnetometerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_magnetometer", 3360562783)

    internal val getGyroscopePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_gyroscope", 3360562783)

    internal val getJoyAccelerometerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_accelerometer", 711720468)

    internal val getJoyGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_gravity", 711720468)

    internal val getJoyGyroscopePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_gyroscope", 711720468)

    internal val getJoyMotionSensorsRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_motion_sensors_rate", 2339986948)

    internal val isJoyMotionSensorsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_joy_motion_sensors_enabled", 1116898809)

    internal val setJoyMotionSensorsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_joy_motion_sensors_enabled", 300928843)

    internal val hasJoyMotionSensorsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "has_joy_motion_sensors", 1116898809)

    internal val startJoyMotionSensorsCalibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "start_joy_motion_sensors_calibration", 1286410249)

    internal val stopJoyMotionSensorsCalibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "stop_joy_motion_sensors_calibration", 1286410249)

    internal val clearJoyMotionSensorsCalibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "clear_joy_motion_sensors_calibration", 1286410249)

    internal val getJoyMotionSensorsCalibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_joy_motion_sensors_calibration", 3485342025)

    internal val setJoyMotionSensorsCalibrationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_joy_motion_sensors_calibration", 64545446)

    internal val isJoyMotionSensorsCalibratedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_joy_motion_sensors_calibrated", 1116898809)

    internal val isJoyMotionSensorsCalibratingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_joy_motion_sensors_calibrating", 1116898809)

    internal val setGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_gravity", 3460891852)

    internal val setAccelerometerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_accelerometer", 3460891852)

    internal val setMagnetometerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_magnetometer", 3460891852)

    internal val setGyroscopePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_gyroscope", 3460891852)

    internal val setJoyLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_joy_light", 2878471219)

    internal val hasJoyLightPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "has_joy_light", 1116898809)

    internal val getLastMouseVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_last_mouse_velocity", 1497962370)

    internal val getLastMouseScreenVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_last_mouse_screen_velocity", 1497962370)

    internal val getMouseButtonMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_mouse_button_mask", 2512161324)

    internal val setMouseModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_mouse_mode", 2228490894)

    internal val getMouseModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_mouse_mode", 965286182)

    internal val warpMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "warp_mouse", 743155724)

    internal val actionPressPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "action_press", 1713091165)

    internal val actionReleasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "action_release", 3304788590)

    internal val setDefaultCursorShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_default_cursor_shape", 2124816902)

    internal val getCurrentCursorShapePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "get_current_cursor_shape", 3455658929)

    internal val setCustomMouseCursorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_custom_mouse_cursor", 703945977)

    internal val parseInputEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "parse_input_event", 3754044979)

    internal val setUseAccumulatedInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_use_accumulated_input", 2586408642)

    internal val isUsingAccumulatedInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_using_accumulated_input", 2240911060)

    internal val flushBufferedEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "flush_buffered_events", 3218959716)

    internal val setEmulateMouseFromTouchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_emulate_mouse_from_touch", 2586408642)

    internal val isEmulatingMouseFromTouchPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_emulating_mouse_from_touch", 36873697)

    internal val setEmulateTouchFromMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "set_emulate_touch_from_mouse", 2586408642)

    internal val isEmulatingTouchFromMousePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Input", "is_emulating_touch_from_mouse", 36873697)
  }
}
