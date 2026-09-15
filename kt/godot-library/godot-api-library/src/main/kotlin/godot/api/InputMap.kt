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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.Signal0
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_OBJECT_STRING_NAME_BOOL
import godot.writeMethodArguments_STRING_NAME
import godot.writeMethodArguments_STRING_NAME_DOUBLE
import godot.writeMethodArguments_STRING_NAME_OBJECT
import kotlin.Boolean
import kotlin.Float
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * Manages all [InputEventAction] which can be created/modified from the project settings menu
 * **Project > Project Settings > Input Map** or in code with [addAction] and [actionAddEvent]. See
 * [Node.Input].
 */
@GodotBaseType
public object InputMap : Object() {
  @JvmField
  public val hasActionName: MethodStringName1<InputMap, Boolean, StringName> =
      MethodStringName1<InputMap, Boolean, StringName>("has_action")

  @JvmField
  public val getActionsName: MethodStringName0<InputMap, VariantArray<StringName>> =
      MethodStringName0<InputMap, VariantArray<StringName>>("get_actions")

  @JvmField
  public val addActionName: MethodStringName2<InputMap, Unit, StringName, Float> =
      MethodStringName2<InputMap, Unit, StringName, Float>("add_action")

  @JvmField
  public val eraseActionName: MethodStringName1<InputMap, Unit, StringName> =
      MethodStringName1<InputMap, Unit, StringName>("erase_action")

  @JvmField
  public val getActionDescriptionName: MethodStringName1<InputMap, String, StringName> =
      MethodStringName1<InputMap, String, StringName>("get_action_description")

  @JvmField
  public val actionSetDeadzoneName: MethodStringName2<InputMap, Unit, StringName, Float> =
      MethodStringName2<InputMap, Unit, StringName, Float>("action_set_deadzone")

  @JvmField
  public val actionGetDeadzoneName: MethodStringName1<InputMap, Float, StringName> =
      MethodStringName1<InputMap, Float, StringName>("action_get_deadzone")

  @JvmField
  public val actionAddEventName: MethodStringName2<InputMap, Unit, StringName, InputEvent> =
      MethodStringName2<InputMap, Unit, StringName, InputEvent>("action_add_event")

  @JvmField
  public val actionHasEventName: MethodStringName2<InputMap, Boolean, StringName, InputEvent> =
      MethodStringName2<InputMap, Boolean, StringName, InputEvent>("action_has_event")

  @JvmField
  public val actionEraseEventName: MethodStringName2<InputMap, Unit, StringName, InputEvent> =
      MethodStringName2<InputMap, Unit, StringName, InputEvent>("action_erase_event")

  @JvmField
  public val actionEraseEventsName: MethodStringName1<InputMap, Unit, StringName> =
      MethodStringName1<InputMap, Unit, StringName>("action_erase_events")

  @JvmField
  public val actionGetEventsName: MethodStringName1<InputMap, VariantArray<InputEvent>, StringName>
      = MethodStringName1<InputMap, VariantArray<InputEvent>, StringName>("action_get_events")

  @JvmField
  public val eventIsActionName:
      MethodStringName3<InputMap, Boolean, InputEvent, StringName, Boolean> =
      MethodStringName3<InputMap, Boolean, InputEvent, StringName, Boolean>("event_is_action")

  @JvmField
  public val loadFromProjectSettingsName: MethodStringName0<InputMap, Unit> =
      MethodStringName0<InputMap, Unit>("load_from_project_settings")

  /**
   * Emitted when the [ProjectSettings] [InputMap] has been loaded.
   */
  @JvmStatic
  public val projectSettingsLoaded: Signal0 by Signal0

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(12)
  }

  /**
   * Returns `true` if the [InputMap] has a registered action with the given name.
   */
  @JvmStatic
  public final fun hasAction(action: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, action)
    TransferContext.callMethod(MethodBindings.hasActionPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns an array of all actions in the [InputMap].
   */
  @JvmStatic
  public final fun getActions(): VariantArray<StringName> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<StringName>)
  }

  /**
   * Adds an empty action to the [InputMap] with a configurable [deadzone].
   *
   * An [InputEvent] can then be added to this action with [actionAddEvent].
   */
  @JvmOverloads
  @JvmStatic
  public final fun addAction(action: StringName, deadzone: Float = 0.2f): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE(ptr, objectID.id, action, deadzone.toDouble())
    TransferContext.callMethod(MethodBindings.addActionPtr)
  }

  /**
   * Removes an action from the [InputMap].
   */
  @JvmStatic
  public final fun eraseAction(action: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, action)
    TransferContext.callMethod(MethodBindings.eraseActionPtr)
  }

  /**
   * Returns the human-readable description of the given action.
   */
  @JvmStatic
  public final fun getActionDescription(action: StringName): String {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, action)
    TransferContext.callMethod(MethodBindings.getActionDescriptionPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets a deadzone value for the action.
   */
  @JvmStatic
  public final fun actionSetDeadzone(action: StringName, deadzone: Float): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_DOUBLE(ptr, objectID.id, action, deadzone.toDouble())
    TransferContext.callMethod(MethodBindings.actionSetDeadzonePtr)
  }

  /**
   * Returns a deadzone value for the action.
   */
  @JvmStatic
  public final fun actionGetDeadzone(action: StringName): Float {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, action)
    TransferContext.callMethod(MethodBindings.actionGetDeadzonePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Adds an [InputEvent] to an action. This [InputEvent] will trigger the action.
   */
  @JvmStatic
  public final fun actionAddEvent(action: StringName, event: InputEvent): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_OBJECT(ptr, objectID.id, action, event)
    TransferContext.callMethod(MethodBindings.actionAddEventPtr)
  }

  /**
   * Returns `true` if the action has the given [InputEvent] associated with it.
   */
  @JvmStatic
  public final fun actionHasEvent(action: StringName, event: InputEvent): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME_OBJECT(ptr, objectID.id, action, event)
    TransferContext.callMethod(MethodBindings.actionHasEventPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Removes an [InputEvent] from an action.
   */
  @JvmStatic
  public final fun actionEraseEvent(action: StringName, event: InputEvent): Unit {
    TransferContext.writeMethodArguments_STRING_NAME_OBJECT(ptr, objectID.id, action, event)
    TransferContext.callMethod(MethodBindings.actionEraseEventPtr)
  }

  /**
   * Removes all events from an action.
   */
  @JvmStatic
  public final fun actionEraseEvents(action: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, action)
    TransferContext.callMethod(MethodBindings.actionEraseEventsPtr)
  }

  /**
   * Returns an array of [InputEvent]s associated with a given action.
   *
   * **Note:** When used in the editor (e.g. a tool script or [EditorPlugin]), this method will
   * return events for the editor action. If you want to access your project's input binds from the
   * editor, read the `input&#47;*` settings from [ProjectSettings].
   */
  @JvmStatic
  public final fun actionGetEvents(action: StringName): VariantArray<InputEvent> {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, action)
    TransferContext.callMethod(MethodBindings.actionGetEventsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<InputEvent>)
  }

  /**
   * Returns `true` if the given event is part of an existing action. This method ignores keyboard
   * modifiers if the given [InputEvent] is not pressed (for proper release detection). See
   * [actionHasEvent] if you don't want this behavior.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun eventIsAction(
    event: InputEvent,
    action: StringName,
    exactMatch: Boolean = false,
  ): Boolean {
    TransferContext.writeMethodArguments_OBJECT_STRING_NAME_BOOL(ptr, objectID.id, event, action, exactMatch)
    TransferContext.callMethod(MethodBindings.eventIsActionPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Clears all [InputEventAction] in the [InputMap] and load it anew from [ProjectSettings].
   */
  @JvmStatic
  public final fun loadFromProjectSettings(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.loadFromProjectSettingsPtr)
  }

  /**
   * Returns `true` if the [InputMap] has a registered action with the given name.
   */
  @JvmStatic
  public final fun hasAction(action: String): Boolean = hasAction(action.asCachedStringName())

  /**
   * Adds an empty action to the [InputMap] with a configurable [deadzone].
   *
   * An [InputEvent] can then be added to this action with [actionAddEvent].
   */
  @JvmOverloads
  @JvmStatic
  public final fun addAction(action: String, deadzone: Float = 0.2f) =
      addAction(action.asCachedStringName(), deadzone)

  /**
   * Removes an action from the [InputMap].
   */
  @JvmStatic
  public final fun eraseAction(action: String) = eraseAction(action.asCachedStringName())

  /**
   * Returns the human-readable description of the given action.
   */
  @JvmStatic
  public final fun getActionDescription(action: String): String =
      getActionDescription(action.asCachedStringName())

  /**
   * Sets a deadzone value for the action.
   */
  @JvmStatic
  public final fun actionSetDeadzone(action: String, deadzone: Float) =
      actionSetDeadzone(action.asCachedStringName(), deadzone)

  /**
   * Returns a deadzone value for the action.
   */
  @JvmStatic
  public final fun actionGetDeadzone(action: String): Float =
      actionGetDeadzone(action.asCachedStringName())

  /**
   * Adds an [InputEvent] to an action. This [InputEvent] will trigger the action.
   */
  @JvmStatic
  public final fun actionAddEvent(action: String, event: InputEvent) =
      actionAddEvent(action.asCachedStringName(), event)

  /**
   * Returns `true` if the action has the given [InputEvent] associated with it.
   */
  @JvmStatic
  public final fun actionHasEvent(action: String, event: InputEvent): Boolean =
      actionHasEvent(action.asCachedStringName(), event)

  /**
   * Removes an [InputEvent] from an action.
   */
  @JvmStatic
  public final fun actionEraseEvent(action: String, event: InputEvent) =
      actionEraseEvent(action.asCachedStringName(), event)

  /**
   * Removes all events from an action.
   */
  @JvmStatic
  public final fun actionEraseEvents(action: String) =
      actionEraseEvents(action.asCachedStringName())

  /**
   * Returns an array of [InputEvent]s associated with a given action.
   *
   * **Note:** When used in the editor (e.g. a tool script or [EditorPlugin]), this method will
   * return events for the editor action. If you want to access your project's input binds from the
   * editor, read the `input&#47;*` settings from [ProjectSettings].
   */
  @JvmStatic
  public final fun actionGetEvents(action: String): VariantArray<InputEvent> =
      actionGetEvents(action.asCachedStringName())

  /**
   * Returns `true` if the given event is part of an existing action. This method ignores keyboard
   * modifiers if the given [InputEvent] is not pressed (for proper release detection). See
   * [actionHasEvent] if you don't want this behavior.
   *
   * If [exactMatch] is `false`, it ignores additional input modifiers for [InputEventKey] and
   * [InputEventMouseButton] events, and the direction for [InputEventJoypadMotion] events.
   */
  @JvmOverloads
  @JvmStatic
  public final fun eventIsAction(
    event: InputEvent,
    action: String,
    exactMatch: Boolean = false,
  ): Boolean = eventIsAction(event, action.asCachedStringName(), exactMatch)

  public object MethodBindings {
    internal val hasActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "has_action", 2619796661)

    internal val getActionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "get_actions", 2915620761)

    internal val addActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "add_action", 1195233573)

    internal val eraseActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "erase_action", 3304788590)

    internal val getActionDescriptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "get_action_description", 957595536)

    internal val actionSetDeadzonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "action_set_deadzone", 4135858297)

    internal val actionGetDeadzonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "action_get_deadzone", 1391627649)

    internal val actionAddEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "action_add_event", 518302593)

    internal val actionHasEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "action_has_event", 1185871985)

    internal val actionEraseEventPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "action_erase_event", 518302593)

    internal val actionEraseEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "action_erase_events", 3304788590)

    internal val actionGetEventsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "action_get_events", 689397652)

    internal val eventIsActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "event_is_action", 3193353650)

    internal val loadFromProjectSettingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputMap", "load_from_project_settings", 3218959716)
  }
}
