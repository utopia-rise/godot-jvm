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
import godot.core.MouseButtonMask
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Stores general information about mouse events.
 */
@GodotBaseType
public open class InputEventMouse internal constructor() : InputEventWithModifiers() {
  /**
   * The mouse button mask identifier, one of or a bitwise combination of the [MouseButton] button
   * masks.
   */
  public final inline var buttonMask: MouseButtonMask
    @JvmName("buttonMaskProperty")
    get() = getButtonMask()
    @JvmName("buttonMaskProperty")
    set(`value`) {
      setButtonMask(value)
    }

  /**
   * When received in [Node.Input] or [Node.UnhandledInput], returns the mouse's position in the
   * [Viewport] this [Node] is in using the coordinate system of this [Viewport].
   *
   * When received in [Control.GuiInput], returns the mouse's position in the [Control] using the
   * local coordinate system of the [Control].
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

  /**
   * When received in [Node.Input] or [Node.UnhandledInput], returns the mouse's position in the
   * root [Viewport] using the coordinate system of the root [Viewport].
   *
   * When received in [Control.GuiInput], returns the mouse's position in the [CanvasLayer] that the
   * [Control] is in using the coordinate system of the [CanvasLayer].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var globalPosition: Vector2
    @JvmName("globalPositionProperty")
    get() = getGlobalPosition()
    @JvmName("globalPositionProperty")
    set(`value`) {
      setGlobalPosition(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(319, scriptPtr)
  }

  /**
   * This is a helper function for [position] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventmouse.position
   * //Your changes
   * inputeventmouse.position = myCoreType
   * ``````
   *
   * When received in [Node.Input] or [Node.UnhandledInput], returns the mouse's position in the
   * [Viewport] this [Node] is in using the coordinate system of this [Viewport].
   *
   * When received in [Control.GuiInput], returns the mouse's position in the [Control] using the
   * local coordinate system of the [Control].
   */
  @CoreTypeHelper
  public final fun positionMutate(block: Vector2.() -> Unit): Vector2 = position.apply {
     block(this)
     position = this
  }

  /**
   * This is a helper function for [globalPosition] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventmouse.globalPosition
   * //Your changes
   * inputeventmouse.globalPosition = myCoreType
   * ``````
   *
   * When received in [Node.Input] or [Node.UnhandledInput], returns the mouse's position in the
   * root [Viewport] using the coordinate system of the root [Viewport].
   *
   * When received in [Control.GuiInput], returns the mouse's position in the [CanvasLayer] that the
   * [Control] is in using the coordinate system of the [CanvasLayer].
   */
  @CoreTypeHelper
  public final fun globalPositionMutate(block: Vector2.() -> Unit): Vector2 = globalPosition.apply {
     block(this)
     globalPosition = this
  }

  public final fun setButtonMask(buttonMask: MouseButtonMask): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to buttonMask.flag)
    TransferContext.callMethod(MethodBindings.setButtonMaskPtr)
  }

  public final fun getButtonMask(): MouseButtonMask {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getButtonMaskPtr)
    return MouseButtonMask(TransferContext.readReturnValue(LONG) as Long)
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

  public final fun setGlobalPosition(globalPosition: Vector2): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2 to globalPosition)
    TransferContext.callMethod(MethodBindings.setGlobalPositionPtr)
  }

  public final fun getGlobalPosition(): Vector2 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalPositionPtr)
    return (TransferContext.readReturnValue(VECTOR2) as Vector2)
  }

  public companion object {
    @JvmField
    public val setButtonMaskName: MethodStringName1<InputEventMouse, Unit, MouseButtonMask> =
        MethodStringName1<InputEventMouse, Unit, MouseButtonMask>("set_button_mask")

    @JvmField
    public val getButtonMaskName: MethodStringName0<InputEventMouse, MouseButtonMask> =
        MethodStringName0<InputEventMouse, MouseButtonMask>("get_button_mask")

    @JvmField
    public val setPositionName: MethodStringName1<InputEventMouse, Unit, Vector2> =
        MethodStringName1<InputEventMouse, Unit, Vector2>("set_position")

    @JvmField
    public val getPositionName: MethodStringName0<InputEventMouse, Vector2> =
        MethodStringName0<InputEventMouse, Vector2>("get_position")

    @JvmField
    public val setGlobalPositionName: MethodStringName1<InputEventMouse, Unit, Vector2> =
        MethodStringName1<InputEventMouse, Unit, Vector2>("set_global_position")

    @JvmField
    public val getGlobalPositionName: MethodStringName0<InputEventMouse, Vector2> =
        MethodStringName0<InputEventMouse, Vector2>("get_global_position")
  }

  public object MethodBindings {
    internal val setButtonMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouse", "set_button_mask", 3950145251)

    internal val getButtonMaskPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouse", "get_button_mask", 2512161324)

    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouse", "set_position", 743155724)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouse", "get_position", 3341600327)

    internal val setGlobalPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouse", "set_global_position", 743155724)

    internal val getGlobalPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouse", "get_global_position", 3341600327)
  }
}
