// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * InputEventGestures are sent when a user performs a supported gesture on a touch screen. Gestures
 * can't be emulated using mouse, because they typically require multi-touch.
 */
@GodotBaseType
public open class InputEventGesture internal constructor() : InputEventWithModifiers() {
  /**
   * The local gesture position relative to the [Viewport]. If used in [Control.GuiInput], the
   * position is relative to the current [Control] that received this gesture.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var position: Vector2
    @JvmName("positionProperty")
    get() = getPosition()
    @JvmName("positionProperty")
    set(`value`) {
      setPosition(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(313, scriptPtr)
  }

  /**
   * This is a helper function for [position] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventgesture.position
   * //Your changes
   * inputeventgesture.position = myCoreType
   * ``````
   *
   * The local gesture position relative to the [Viewport]. If used in [Control.GuiInput], the
   * position is relative to the current [Control] that received this gesture.
   */
  @CoreTypeHelper
  public final fun positionMutate(block: Vector2.() -> Unit): Vector2 = position.apply {
     block(this)
     position = this
  }

  public final fun setPosition(position: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to position)
    TransferContext.callMethod(MethodBindings.setPositionPtr)
  }

  public final fun getPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setPositionName: MethodStringName1<InputEventGesture, Unit, Vector2> =
        MethodStringName1<InputEventGesture, Unit, Vector2>("set_position")

    @JvmField
    public val getPositionName: MethodStringName0<InputEventGesture, Vector2> =
        MethodStringName0<InputEventGesture, Vector2>("get_position")
  }

  public object MethodBindings {
    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventGesture", "set_position", 743155724)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventGesture", "get_position", 3341600327)
  }
}
