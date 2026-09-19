// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_STRING_NAME
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_STRING_NAME
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.StringName
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Contains a generic action which can be targeted from several types of inputs. Actions and their
 * events can be set in the **Input Map** tab in **Project > Project Settings**, or with the [InputMap]
 * class.
 *
 * **Note:** Unlike the other [InputEvent] subclasses which map to unique physical events, this
 * virtual one is not emitted by the engine. This class is useful to emit actions manually with
 * [Input.parseInputEvent], which are then received in [Node.Input]. To check if a physical event
 * matches an action from the Input Map, use [InputEvent.isAction] and [InputEvent.isActionPressed].
 */
@GodotBaseType
public open class InputEventAction : InputEvent() {
  /**
   * The action's name. This is usually the name of an existing action in the [InputMap] which you
   * want this custom event to match.
   */
  public final inline var action: StringName
    @JvmName("actionProperty")
    get() = getAction()
    @JvmName("actionProperty")
    set(`value`) {
      setAction(value)
    }

  /**
   * If `true`, the action's state is pressed. If `false`, the action's state is released.
   */
  public final inline var pressed: Boolean
    @JvmName("pressedProperty")
    get() = isPressed()
    @JvmName("pressedProperty")
    set(`value`) {
      setPressed(value)
    }

  /**
   * The action's strength between 0 and 1. This value is considered as equal to 0 if pressed is
   * `false`. The event strength allows faking analog joypad motion events, by specifying how strongly
   * the joypad axis is bent or pressed.
   */
  public final inline var strength: Float
    @JvmName("strengthProperty")
    get() = getStrength()
    @JvmName("strengthProperty")
    set(`value`) {
      setStrength(value)
    }

  /**
   * The real event index in action this event corresponds to (from events defined for this action
   * in the [InputMap]). If `-1`, a unique ID will be used and actions pressed with this ID will need
   * to be released with another [InputEventAction].
   */
  public final inline var eventIndex: Int
    @JvmName("eventIndexProperty")
    get() = getEventIndex()
    @JvmName("eventIndexProperty")
    set(`value`) {
      setEventIndex(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(309, scriptPtr)
  }

  public final fun setAction(action: StringName): Unit {
    TransferContext.callPtrMethod_STRING_NAME(ptr, objectID.id, MethodBindings.setActionPtr, action)
  }

  public final fun getAction(): StringName =
      TransferContext.callPtrMethod0_ret_STRING_NAME(ptr, objectID.id, MethodBindings.getActionPtr)

  public final fun setPressed(pressed: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setPressedPtr, pressed)
  }

  public final fun setStrength(strength: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setStrengthPtr, strength.toDouble())
  }

  public final fun getStrength(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getStrengthPtr).toFloat()

  public final fun setEventIndex(index: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setEventIndexPtr, index.toLong())
  }

  public final fun getEventIndex(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getEventIndexPtr).toInt()

  public final fun setAction(action: String) = setAction(action.asCachedStringName())

  public companion object {
    @JvmField
    public val setActionName: MethodStringName1<InputEventAction, Unit, StringName> =
        MethodStringName1<InputEventAction, Unit, StringName>("set_action")

    @JvmField
    public val getActionName: MethodStringName0<InputEventAction, StringName> =
        MethodStringName0<InputEventAction, StringName>("get_action")

    @JvmField
    public val setPressedName: MethodStringName1<InputEventAction, Unit, Boolean> =
        MethodStringName1<InputEventAction, Unit, Boolean>("set_pressed")

    @JvmField
    public val setStrengthName: MethodStringName1<InputEventAction, Unit, Float> =
        MethodStringName1<InputEventAction, Unit, Float>("set_strength")

    @JvmField
    public val getStrengthName: MethodStringName0<InputEventAction, Float> =
        MethodStringName0<InputEventAction, Float>("get_strength")

    @JvmField
    public val setEventIndexName: MethodStringName1<InputEventAction, Unit, Int> =
        MethodStringName1<InputEventAction, Unit, Int>("set_event_index")

    @JvmField
    public val getEventIndexName: MethodStringName0<InputEventAction, Int> =
        MethodStringName0<InputEventAction, Int>("get_event_index")
  }

  public object MethodBindings {
    internal val setActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventAction", "set_action", 3304788590)

    internal val getActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventAction", "get_action", 2002593661)

    internal val setPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventAction", "set_pressed", 2586408642)

    internal val setStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventAction", "set_strength", 373806689)

    internal val getStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventAction", "get_strength", 1740695150)

    internal val setEventIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventAction", "set_event_index", 1286410249)

    internal val getEventIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventAction", "get_event_index", 3905245786)
  }
}
