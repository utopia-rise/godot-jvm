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
import godot.core.Key
import godot.core.KeyLocation
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * An input event for keys on a keyboard. Supports key presses, key releases and [echo] events. It
 * can also be received in [Node.UnhandledKeyInput].
 *
 * **Note:** Events received from the keyboard usually have all properties set. Event mappings
 * should have only one of the [keycode], [physicalKeycode] or [unicode] set.
 *
 * When events are compared, properties are checked in the following priority - [keycode],
 * [physicalKeycode] and [unicode]. Events with the first matching value will be considered equal.
 */
@GodotBaseType
public open class InputEventKey : InputEventWithModifiers() {
  /**
   * If `true`, the key's state is pressed. If `false`, the key's state is released.
   */
  public final inline var pressed: Boolean
    @JvmName("pressedProperty")
    get() = isPressed()
    @JvmName("pressedProperty")
    set(`value`) {
      setPressed(value)
    }

  /**
   * Latin label printed on the key in the current keyboard layout, which corresponds to one of the
   * [Key] constants. Key codes are meant for shortcuts expressed with a standard Latin keyboard, such
   * as [kbd]Ctrl + S[/kbd] for a "Save" shortcut.
   *
   * To get a human-readable representation of the [InputEventKey], use
   * `OS.get_keycode_string(event.keycode)` where `event` is the [InputEventKey].
   *
   * [codeblock lang=text]
   *
   * +-----+ +-----+
   *
   * | Q   | | Q   | - "Q" - keycode
   *
   * |   Й | |  ض | - "Й" and "ض" - key_label
   *
   * +-----+ +-----+
   *
   * ```
   */
  public final inline var keycode: Key
    @JvmName("keycodeProperty")
    get() = getKeycode()
    @JvmName("keycodeProperty")
    set(`value`) {
      setKeycode(value)
    }

  /**
   * Represents the physical location of a key on the 101/102-key US QWERTY keyboard, which
   * corresponds to one of the [Key] constants. Physical key codes meant for game input, such as WASD
   * movement, where only the location of the keys is important.
   *
   * To get a human-readable representation of the [InputEventKey], use [OS.getKeycodeString] in
   * combination with [DisplayServer.keyboardGetKeycodeFromPhysical] or
   * [DisplayServer.keyboardGetLabelFromPhysical]:
   *
   * ```gdscript
   * //gdscript
   * func _input(event):
   * 	if event is InputEventKey:
   * 		var keycode = DisplayServer.keyboard_get_keycode_from_physical(event.physical_keycode)
   * 		var label = DisplayServer.keyboard_get_label_from_physical(event.physical_keycode)
   * 		print(OS.get_keycode_string(keycode))
   * 		print(OS.get_keycode_string(label))
   * ```
   *
   * ```csharp
   * //csharp
   * public override void _Input(InputEvent @event)
   * {
   * 	if (@event is InputEventKey inputEventKey)
   * 	{
   * 		var keycode = DisplayServer.KeyboardGetKeycodeFromPhysical(inputEventKey.PhysicalKeycode);
   * 		var label = DisplayServer.KeyboardGetLabelFromPhysical(inputEventKey.PhysicalKeycode);
   * 		GD.Print(OS.GetKeycodeString(keycode));
   * 		GD.Print(OS.GetKeycodeString(label));
   * 	}
   * }
   * ```
   */
  public final inline var physicalKeycode: Key
    @JvmName("physicalKeycodeProperty")
    get() = getPhysicalKeycode()
    @JvmName("physicalKeycodeProperty")
    set(`value`) {
      setPhysicalKeycode(value)
    }

  /**
   * Represents the localized label printed on the key in the current keyboard layout, which
   * corresponds to one of the [Key] constants or any valid Unicode character. Key labels are meant for
   * key prompts.
   *
   * For keyboard layouts with a single label on the key, it is equivalent to [keycode].
   *
   * To get a human-readable representation of the [InputEventKey], use
   * `OS.get_keycode_string(event.key_label)` where `event` is the [InputEventKey].
   *
   * [codeblock lang=text]
   *
   * +-----+ +-----+
   *
   * | Q   | | Q   | - "Q" - keycode
   *
   * |   Й | |  ض | - "Й" and "ض" - key_label
   *
   * +-----+ +-----+
   *
   * ```
   */
  public final inline var keyLabel: Key
    @JvmName("keyLabelProperty")
    get() = getKeyLabel()
    @JvmName("keyLabelProperty")
    set(`value`) {
      setKeyLabel(value)
    }

  /**
   * The key Unicode character code (when relevant), shifted by modifier keys. Unicode character
   * codes for composite characters and complex scripts may not be available unless IME input mode is
   * active. See [Window.setImeActive] for more information. Unicode character codes are meant for text
   * input.
   *
   * **Note:** This property is set by the engine only for a pressed event. If the event is sent by
   * an IME or a virtual keyboard, no corresponding key released event is sent.
   */
  public final inline var unicode: Long
    @JvmName("unicodeProperty")
    get() = getUnicode()
    @JvmName("unicodeProperty")
    set(`value`) {
      setUnicode(value)
    }

  /**
   * Represents the location of a key which has both left and right versions, such as
   * [kbd]Shift[/kbd] or [kbd]Alt[/kbd].
   */
  public final inline var location: KeyLocation
    @JvmName("locationProperty")
    get() = getLocation()
    @JvmName("locationProperty")
    set(`value`) {
      setLocation(value)
    }

  /**
   * If `true`, the key was already pressed before this event. An echo event is a repeated key event
   * sent when the user is holding down the key.
   *
   * **Note:** The rate at which echo events are sent is typically around 20 events per second
   * (after holding down the key for roughly half a second). However, the key repeat delay/speed can be
   * changed by the user or disabled entirely in the operating system settings. To ensure your project
   * works correctly on all configurations, do not assume the user has a specific key repeat
   * configuration in your project's behavior.
   */
  public final inline var echo: Boolean
    @JvmName("echoProperty")
    get() = isEcho()
    @JvmName("echoProperty")
    set(`value`) {
      setEcho(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(314, scriptPtr)
  }

  public final fun setPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pressed)
    TransferContext.callPtrMethod(MethodBindings.setPressedPtr, 0)
  }

  public final fun setKeycode(keycode: Key): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, keycode.value)
    TransferContext.callPtrMethod(MethodBindings.setKeycodePtr, 0)
  }

  public final fun getKeycode(): Key {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getKeycodePtr, 2)
    return Key.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPhysicalKeycode(physicalKeycode: Key): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, physicalKeycode.value)
    TransferContext.callPtrMethod(MethodBindings.setPhysicalKeycodePtr, 0)
  }

  public final fun getPhysicalKeycode(): Key {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPhysicalKeycodePtr, 2)
    return Key.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setKeyLabel(keyLabel: Key): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, keyLabel.value)
    TransferContext.callPtrMethod(MethodBindings.setKeyLabelPtr, 0)
  }

  public final fun getKeyLabel(): Key {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getKeyLabelPtr, 2)
    return Key.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setUnicode(unicode: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, unicode)
    TransferContext.callPtrMethod(MethodBindings.setUnicodePtr, 0)
  }

  public final fun getUnicode(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getUnicodePtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setLocation(location: KeyLocation): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, location.value)
    TransferContext.callPtrMethod(MethodBindings.setLocationPtr, 0)
  }

  public final fun getLocation(): KeyLocation {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getLocationPtr, 2)
    return KeyLocation.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setEcho(echo: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, echo)
    TransferContext.callPtrMethod(MethodBindings.setEchoPtr, 0)
  }

  /**
   * Returns the Latin keycode combined with modifier keys such as [kbd]Shift[/kbd] or
   * [kbd]Alt[/kbd]. See also [InputEventWithModifiers].
   *
   * To get a human-readable representation of the [InputEventKey] with modifiers, use
   * `OS.get_keycode_string(event.get_keycode_with_modifiers())` where `event` is the [InputEventKey].
   */
  public final fun getKeycodeWithModifiers(): Key {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getKeycodeWithModifiersPtr, 2)
    return Key.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the physical keycode combined with modifier keys such as [kbd]Shift[/kbd] or
   * [kbd]Alt[/kbd]. See also [InputEventWithModifiers].
   *
   * To get a human-readable representation of the [InputEventKey] with modifiers, use
   * `OS.get_keycode_string(event.get_physical_keycode_with_modifiers())` where `event` is the
   * [InputEventKey].
   */
  public final fun getPhysicalKeycodeWithModifiers(): Key {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPhysicalKeycodeWithModifiersPtr, 2)
    return Key.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the localized key label combined with modifier keys such as [kbd]Shift[/kbd] or
   * [kbd]Alt[/kbd]. See also [InputEventWithModifiers].
   *
   * To get a human-readable representation of the [InputEventKey] with modifiers, use
   * `OS.get_keycode_string(event.get_key_label_with_modifiers())` where `event` is the
   * [InputEventKey].
   */
  public final fun getKeyLabelWithModifiers(): Key {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getKeyLabelWithModifiersPtr, 2)
    return Key.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns a [String] representation of the event's [keycode] and modifiers.
   */
  public final fun asTextKeycode(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.asTextKeycodePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns a [String] representation of the event's [physicalKeycode] and modifiers.
   */
  public final fun asTextPhysicalKeycode(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.asTextPhysicalKeycodePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns a [String] representation of the event's [keyLabel] and modifiers.
   */
  public final fun asTextKeyLabel(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.asTextKeyLabelPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns a [String] representation of the event's [location]. This will be a blank string if the
   * event is not specific to a location.
   */
  public final fun asTextLocation(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.asTextLocationPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val setPressedName: MethodStringName1<InputEventKey, Unit, Boolean> =
        MethodStringName1<InputEventKey, Unit, Boolean>("set_pressed")

    @JvmField
    public val setKeycodeName: MethodStringName1<InputEventKey, Unit, Key> =
        MethodStringName1<InputEventKey, Unit, Key>("set_keycode")

    @JvmField
    public val getKeycodeName: MethodStringName0<InputEventKey, Key> =
        MethodStringName0<InputEventKey, Key>("get_keycode")

    @JvmField
    public val setPhysicalKeycodeName: MethodStringName1<InputEventKey, Unit, Key> =
        MethodStringName1<InputEventKey, Unit, Key>("set_physical_keycode")

    @JvmField
    public val getPhysicalKeycodeName: MethodStringName0<InputEventKey, Key> =
        MethodStringName0<InputEventKey, Key>("get_physical_keycode")

    @JvmField
    public val setKeyLabelName: MethodStringName1<InputEventKey, Unit, Key> =
        MethodStringName1<InputEventKey, Unit, Key>("set_key_label")

    @JvmField
    public val getKeyLabelName: MethodStringName0<InputEventKey, Key> =
        MethodStringName0<InputEventKey, Key>("get_key_label")

    @JvmField
    public val setUnicodeName: MethodStringName1<InputEventKey, Unit, Long> =
        MethodStringName1<InputEventKey, Unit, Long>("set_unicode")

    @JvmField
    public val getUnicodeName: MethodStringName0<InputEventKey, Long> =
        MethodStringName0<InputEventKey, Long>("get_unicode")

    @JvmField
    public val setLocationName: MethodStringName1<InputEventKey, Unit, KeyLocation> =
        MethodStringName1<InputEventKey, Unit, KeyLocation>("set_location")

    @JvmField
    public val getLocationName: MethodStringName0<InputEventKey, KeyLocation> =
        MethodStringName0<InputEventKey, KeyLocation>("get_location")

    @JvmField
    public val setEchoName: MethodStringName1<InputEventKey, Unit, Boolean> =
        MethodStringName1<InputEventKey, Unit, Boolean>("set_echo")

    @JvmField
    public val getKeycodeWithModifiersName: MethodStringName0<InputEventKey, Key> =
        MethodStringName0<InputEventKey, Key>("get_keycode_with_modifiers")

    @JvmField
    public val getPhysicalKeycodeWithModifiersName: MethodStringName0<InputEventKey, Key> =
        MethodStringName0<InputEventKey, Key>("get_physical_keycode_with_modifiers")

    @JvmField
    public val getKeyLabelWithModifiersName: MethodStringName0<InputEventKey, Key> =
        MethodStringName0<InputEventKey, Key>("get_key_label_with_modifiers")

    @JvmField
    public val asTextKeycodeName: MethodStringName0<InputEventKey, String> =
        MethodStringName0<InputEventKey, String>("as_text_keycode")

    @JvmField
    public val asTextPhysicalKeycodeName: MethodStringName0<InputEventKey, String> =
        MethodStringName0<InputEventKey, String>("as_text_physical_keycode")

    @JvmField
    public val asTextKeyLabelName: MethodStringName0<InputEventKey, String> =
        MethodStringName0<InputEventKey, String>("as_text_key_label")

    @JvmField
    public val asTextLocationName: MethodStringName0<InputEventKey, String> =
        MethodStringName0<InputEventKey, String>("as_text_location")
  }

  public object MethodBindings {
    internal val setPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "set_pressed", 2586408642)

    internal val setKeycodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "set_keycode", 888074362)

    internal val getKeycodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_keycode", 1585896689)

    internal val setPhysicalKeycodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "set_physical_keycode", 888074362)

    internal val getPhysicalKeycodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_physical_keycode", 1585896689)

    internal val setKeyLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "set_key_label", 888074362)

    internal val getKeyLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_key_label", 1585896689)

    internal val setUnicodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "set_unicode", 1286410249)

    internal val getUnicodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_unicode", 3905245786)

    internal val setLocationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "set_location", 634453155)

    internal val getLocationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_location", 211810873)

    internal val setEchoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "set_echo", 2586408642)

    internal val getKeycodeWithModifiersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_keycode_with_modifiers", 1585896689)

    internal val getPhysicalKeycodeWithModifiersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_physical_keycode_with_modifiers", 1585896689)

    internal val getKeyLabelWithModifiersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "get_key_label_with_modifiers", 1585896689)

    internal val asTextKeycodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "as_text_keycode", 201670096)

    internal val asTextPhysicalKeycodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "as_text_physical_keycode", 201670096)

    internal val asTextKeyLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "as_text_key_label", 201670096)

    internal val asTextLocationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventKey", "as_text_location", 201670096)
  }
}
