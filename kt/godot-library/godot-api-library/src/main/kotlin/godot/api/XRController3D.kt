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
import godot.core.Signal1
import godot.core.Signal2
import godot.core.StringName
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * This is a helper 3D node that is linked to the tracking of controllers. It also offers several
 * handy passthroughs to the state of buttons and such on the controllers.
 *
 * Controllers are linked by their ID. You can create controller nodes before the controllers are
 * available. If your game always uses two controllers (one for each hand), you can predefine the
 * controllers with ID 1 and 2; they will become active as soon as the controllers are identified. If
 * you expect additional controllers to be used, you should react to the signals and add XRController3D
 * nodes to your scene.
 *
 * The position of the controller node is automatically updated by the [XRServer]. This makes this
 * node ideal to add child nodes to visualize the controller.
 *
 * The current [XRInterface] defines the names of inputs. In the case of OpenXR, these are the names
 * of actions in the current action set from the OpenXR action map.
 */
@GodotBaseType
public open class XRController3D : XRNode3D() {
  /**
   * Emitted when a button on this controller is pressed.
   */
  public val buttonPressed: Signal1<String> by Signal1

  /**
   * Emitted when a button on this controller is released.
   */
  public val buttonReleased: Signal1<String> by Signal1

  /**
   * Emitted when a trigger or similar input on this controller changes value.
   */
  public val inputFloatChanged: Signal2<String, Double> by Signal2

  /**
   * Emitted when a thumbstick or thumbpad on this controller is moved.
   */
  public val inputVector2Changed: Signal2<String, Vector2> by Signal2

  /**
   * Emitted when the interaction profile on this controller is changed.
   */
  public val profileChanged: Signal1<String> by Signal1

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(940, scriptPtr)
  }

  /**
   * Returns `true` if the button with the given [name] is pressed.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun isButtonPressed(name: StringName): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.isButtonPressedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns a [Any] for the input with the given [name]. This works for any input type, the variant
   * will be typed according to the actions configuration.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun getInput(name: StringName): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getInputPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns a numeric value for the input with the given [name]. This is used for triggers and grip
   * sensors.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun getFloat(name: StringName): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getFloatPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Returns a [Vector2] for the input with the given [name]. This is used for thumbsticks and
   * thumbpads found on many controllers.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun getVector2(name: StringName): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.getVector2Ptr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  /**
   * Returns the hand holding this controller, if known.
   */
  public final fun getTrackerHand(): XRPositionalTracker.TrackerHand {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackerHandPtr)
    return XRPositionalTracker.TrackerHand.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the button with the given [name] is pressed.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun isButtonPressed(name: String): Boolean =
      isButtonPressed(name.asCachedStringName())

  /**
   * Returns a [Any] for the input with the given [name]. This works for any input type, the variant
   * will be typed according to the actions configuration.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun getInput(name: String): Any? = getInput(name.asCachedStringName())

  /**
   * Returns a numeric value for the input with the given [name]. This is used for triggers and grip
   * sensors.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun getFloat(name: String): Float = getFloat(name.asCachedStringName())

  /**
   * Returns a [Vector2] for the input with the given [name]. This is used for thumbsticks and
   * thumbpads found on many controllers.
   *
   * **Note:** The current [XRInterface] defines the [name] for each input. In the case of OpenXR,
   * these are the names of actions in the current action set.
   */
  public final fun getVector2(name: String): Vector2 = getVector2(name.asCachedStringName())

  public companion object {
    @JvmField
    public val isButtonPressedName: MethodStringName1<XRController3D, Boolean, StringName> =
        MethodStringName1<XRController3D, Boolean, StringName>("is_button_pressed")

    @JvmField
    public val getInputName: MethodStringName1<XRController3D, Any?, StringName> =
        MethodStringName1<XRController3D, Any?, StringName>("get_input")

    @JvmField
    public val getFloatName: MethodStringName1<XRController3D, Float, StringName> =
        MethodStringName1<XRController3D, Float, StringName>("get_float")

    @JvmField
    public val getVector2Name: MethodStringName1<XRController3D, Vector2, StringName> =
        MethodStringName1<XRController3D, Vector2, StringName>("get_vector2")

    @JvmField
    public val getTrackerHandName:
        MethodStringName0<XRController3D, XRPositionalTracker.TrackerHand> =
        MethodStringName0<XRController3D, XRPositionalTracker.TrackerHand>("get_tracker_hand")
  }

  public object MethodBindings {
    internal val isButtonPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRController3D", "is_button_pressed", 2619796661)

    internal val getInputPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRController3D", "get_input", 2760726917)

    internal val getFloatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRController3D", "get_float", 2349060816)

    internal val getVector2Ptr: VoidPtr =
        TypeManager.getMethodBindPtr("XRController3D", "get_vector2", 3100822709)

    internal val getTrackerHandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRController3D", "get_tracker_hand", 4181770860)
  }
}
