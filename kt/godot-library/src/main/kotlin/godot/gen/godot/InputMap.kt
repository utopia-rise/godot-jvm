// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName")

package godot

import godot.annotation.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantArray
import godot.core.VariantType.ARRAY
import godot.core.VariantType.BOOL
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.core.VariantType.STRING
import godot.util.VoidPtr
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress

@GodotBaseType
object InputMap : Object() {
  override fun __new(): VoidPtr = TransferContext.getSingleton(ENGINESINGLETON_INPUTMAP)

  override fun ____DO_NOT_TOUCH_THIS_isSingleton____() = true

  fun actionAddEvent(action: String, event: InputEvent) {
    TransferContext.writeArguments(STRING to action, OBJECT to event)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_ACTION_ADD_EVENT, NIL)
  }

  fun actionEraseEvent(action: String, event: InputEvent) {
    TransferContext.writeArguments(STRING to action, OBJECT to event)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_ACTION_ERASE_EVENT, NIL)
  }

  fun actionEraseEvents(action: String) {
    TransferContext.writeArguments(STRING to action)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_ACTION_ERASE_EVENTS, NIL)
  }

  fun actionHasEvent(action: String, event: InputEvent): Boolean {
    TransferContext.writeArguments(STRING to action, OBJECT to event)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_ACTION_HAS_EVENT, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  fun actionSetDeadzone(action: String, deadzone: Double) {
    TransferContext.writeArguments(STRING to action, DOUBLE to deadzone)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_ACTION_SET_DEADZONE, NIL)
  }

  fun addAction(action: String, deadzone: Double = 0.5) {
    TransferContext.writeArguments(STRING to action, DOUBLE to deadzone)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_ADD_ACTION, NIL)
  }

  fun eraseAction(action: String) {
    TransferContext.writeArguments(STRING to action)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_ERASE_ACTION, NIL)
  }

  fun eventIsAction(event: InputEvent, action: String): Boolean {
    TransferContext.writeArguments(OBJECT to event, STRING to action)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_EVENT_IS_ACTION, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  fun getActionList(action: String): VariantArray<Any?> {
    TransferContext.writeArguments(STRING to action)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_GET_ACTION_LIST, ARRAY)
    return TransferContext.readReturnValue(ARRAY, false) as VariantArray<Any?>
  }

  fun getActions(): VariantArray<Any?> {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_GET_ACTIONS, ARRAY)
    return TransferContext.readReturnValue(ARRAY, false) as VariantArray<Any?>
  }

  fun hasAction(action: String): Boolean {
    TransferContext.writeArguments(STRING to action)
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_HAS_ACTION, BOOL)
    return TransferContext.readReturnValue(BOOL, false) as Boolean
  }

  fun loadFromGlobals() {
    TransferContext.writeArguments()
    TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INPUTMAP_LOAD_FROM_GLOBALS, NIL)
  }
}
