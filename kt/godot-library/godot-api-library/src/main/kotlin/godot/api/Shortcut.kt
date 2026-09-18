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
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_OBJECT
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Shortcuts (also known as hotkeys) are containers of [InputEvent] resources. They are commonly
 * used to interact with a [Control] element from an [InputEvent].
 *
 * One shortcut can contain multiple [InputEvent] resources, making it possible to trigger one
 * action with multiple different inputs.
 *
 * **Example:** Capture the [kbd]Ctrl + S[/kbd] shortcut using a [Shortcut] resource:
 *
 * ```gdscript
 * //gdscript
 * extends Node
 *
 * var save_shortcut = Shortcut.new()
 * func _ready():
 * 	var key_event = InputEventKey.new()
 * 	key_event.keycode = KEY_S
 * 	key_event.ctrl_pressed = true
 * 	key_event.command_or_control_autoremap = true # Swaps Ctrl for Command on Mac.
 * 	save_shortcut.events = [key_event]
 *
 * func _input(event):
 * 	if save_shortcut.matches_event(event) and event.is_pressed() and not event.is_echo():
 * 		print("Save shortcut pressed!")
 * 		get_viewport().set_input_as_handled()
 * ```
 *
 * ```csharp
 * //csharp
 * using Godot;
 *
 * public partial class MyNode : Node
 * {
 * 	private readonly Shortcut _saveShortcut = new Shortcut();
 *
 * 	public override void _Ready()
 * 	{
 * 		InputEventKey keyEvent = new InputEventKey
 * 		{
 * 			Keycode = Key.S,
 * 			CtrlPressed = true,
 * 			CommandOrControlAutoremap = true, // Swaps Ctrl for Command on Mac.
 * 		};
 *
 * 		_saveShortcut.Events = [keyEvent];
 * 	}
 *
 * 	public override void _Input(InputEvent @event)
 * 	{
 * 		if (@event is InputEventKey keyEvent &&
 * 			_saveShortcut.MatchesEvent(@event) &&
 * 			keyEvent.Pressed && !keyEvent.Echo)
 * 		{
 * 			GD.Print("Save shortcut pressed!");
 * 			GetViewport().SetInputAsHandled();
 * 		}
 * 	}
 * }
 * ```
 */
@GodotBaseType
public open class Shortcut : Resource() {
  /**
   * The shortcut's [InputEvent] array.
   *
   * Generally the [InputEvent] used is an [InputEventKey], though it can be any [InputEvent],
   * including an [InputEventAction].
   */
  public final inline var events: VariantArray<Any?>
    @JvmName("eventsProperty")
    get() = getEvents()
    @JvmName("eventsProperty")
    set(`value`) {
      setEvents(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(663, scriptPtr)
  }

  public final fun setEvents(events: VariantArray<Any?>): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, events)
    TransferContext.callPtrMethod(MethodBindings.setEventsPtr, 0)
  }

  public final fun getEvents(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEventsPtr, 28)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Returns whether [events] contains an [InputEvent] which is valid.
   */
  public final fun hasValidEvent(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.hasValidEventPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns whether any [InputEvent] in [events] equals [event]. This uses [InputEvent.isMatch] to
   * compare events.
   */
  public final fun matchesEvent(event: InputEvent?): Boolean {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, event)
    TransferContext.callPtrMethod(MethodBindings.matchesEventPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the shortcut's first valid [InputEvent] as a [String].
   */
  public final fun getAsText(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAsTextPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public companion object {
    @JvmField
    public val setEventsName: MethodStringName1<Shortcut, Unit, VariantArray<Any?>> =
        MethodStringName1<Shortcut, Unit, VariantArray<Any?>>("set_events")

    @JvmField
    public val getEventsName: MethodStringName0<Shortcut, VariantArray<Any?>> =
        MethodStringName0<Shortcut, VariantArray<Any?>>("get_events")

    @JvmField
    public val hasValidEventName: MethodStringName0<Shortcut, Boolean> =
        MethodStringName0<Shortcut, Boolean>("has_valid_event")

    @JvmField
    public val matchesEventName: MethodStringName1<Shortcut, Boolean, InputEvent?> =
        MethodStringName1<Shortcut, Boolean, InputEvent?>("matches_event")

    @JvmField
    public val getAsTextName: MethodStringName0<Shortcut, String> =
        MethodStringName0<Shortcut, String>("get_as_text")
  }

  public object MethodBindings {
    internal val setEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shortcut", "set_events", 381264803)

    internal val getEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shortcut", "get_events", 3995934104)

    internal val hasValidEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shortcut", "has_valid_event", 36873697)

    internal val matchesEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shortcut", "matches_event", 3738334489)

    internal val getAsTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Shortcut", "get_as_text", 201670096)
  }
}
