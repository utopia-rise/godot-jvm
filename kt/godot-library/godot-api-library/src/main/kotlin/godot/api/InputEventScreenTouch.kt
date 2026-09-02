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
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.VECTOR2
import godot.core.Vector2
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Stores information about multi-touch press/release input events. Supports touch press, touch
 * release and [index] for multi-touch count and order.
 */
@GodotBaseType
public open class InputEventScreenTouch : InputEventFromWindow() {
  /**
   * The touch index in the case of a multi-touch event. One index = one finger.
   */
  public final inline var index: Int
    @JvmName("indexProperty")
    get() = getIndex()
    @JvmName("indexProperty")
    set(`value`) {
      setIndex(value)
    }

  /**
   * The touch position in the viewport the node is in, using the coordinate system of this
   * viewport.
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
   * If `true`, the touch event has been canceled.
   */
  public final inline var canceled: Boolean
    @JvmName("canceledProperty")
    get() = isCanceled()
    @JvmName("canceledProperty")
    set(`value`) {
      setCanceled(value)
    }

  /**
   * If `true`, the touch's state is pressed. If `false`, the touch's state is released.
   */
  public final inline var pressed: Boolean
    @JvmName("pressedProperty")
    get() = isPressed()
    @JvmName("pressedProperty")
    set(`value`) {
      setPressed(value)
    }

  /**
   * If `true`, the touch's state is a double tap.
   */
  public final inline var doubleTap: Boolean
    @JvmName("doubleTapProperty")
    get() = isDoubleTap()
    @JvmName("doubleTapProperty")
    set(`value`) {
      setDoubleTap(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(324, scriptPtr)
  }

  /**
   * This is a helper function for [position] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = inputeventscreentouch.position
   * //Your changes
   * inputeventscreentouch.position = myCoreType
   * ``````
   *
   * The touch position in the viewport the node is in, using the coordinate system of this
   * viewport.
   */
  @CoreTypeHelper
  public final fun positionMutate(block: Vector2.() -> Unit): Vector2 = position.apply {
     block(this)
     position = this
  }

  public final fun setIndex(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.setIndexPtr)
  }

  public final fun getIndex(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getIndexPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
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

  public final fun setPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to pressed)
    TransferContext.callMethod(MethodBindings.setPressedPtr)
  }

  public final fun setCanceled(canceled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to canceled)
    TransferContext.callMethod(MethodBindings.setCanceledPtr)
  }

  public final fun setDoubleTap(doubleTap: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to doubleTap)
    TransferContext.callMethod(MethodBindings.setDoubleTapPtr)
  }

  public final fun isDoubleTap(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDoubleTapPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public companion object {
    @JvmField
    public val setIndexName: MethodStringName1<InputEventScreenTouch, Unit, Int> =
        MethodStringName1<InputEventScreenTouch, Unit, Int>("set_index")

    @JvmField
    public val getIndexName: MethodStringName0<InputEventScreenTouch, Int> =
        MethodStringName0<InputEventScreenTouch, Int>("get_index")

    @JvmField
    public val setPositionName: MethodStringName1<InputEventScreenTouch, Unit, Vector2> =
        MethodStringName1<InputEventScreenTouch, Unit, Vector2>("set_position")

    @JvmField
    public val getPositionName: MethodStringName0<InputEventScreenTouch, Vector2> =
        MethodStringName0<InputEventScreenTouch, Vector2>("get_position")

    @JvmField
    public val setPressedName: MethodStringName1<InputEventScreenTouch, Unit, Boolean> =
        MethodStringName1<InputEventScreenTouch, Unit, Boolean>("set_pressed")

    @JvmField
    public val setCanceledName: MethodStringName1<InputEventScreenTouch, Unit, Boolean> =
        MethodStringName1<InputEventScreenTouch, Unit, Boolean>("set_canceled")

    @JvmField
    public val setDoubleTapName: MethodStringName1<InputEventScreenTouch, Unit, Boolean> =
        MethodStringName1<InputEventScreenTouch, Unit, Boolean>("set_double_tap")

    @JvmField
    public val isDoubleTapName: MethodStringName0<InputEventScreenTouch, Boolean> =
        MethodStringName0<InputEventScreenTouch, Boolean>("is_double_tap")
  }

  public object MethodBindings {
    internal val setIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "set_index", 1286410249)

    internal val getIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "get_index", 3905245786)

    internal val setPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "set_position", 743155724)

    internal val getPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "get_position", 3341600327)

    internal val setPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "set_pressed", 2586408642)

    internal val setCanceledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "set_canceled", 2586408642)

    internal val setDoubleTapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "set_double_tap", 2586408642)

    internal val isDoubleTapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventScreenTouch", "is_double_tap", 36873697)
  }
}
