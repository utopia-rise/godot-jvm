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
import godot.core.MouseButton
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Boolean
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Stores information about mouse click events. See [Node.Input].
 *
 * **Note:** On Wear OS devices, rotary input is mapped to [MOUSE_BUTTON_WHEEL_UP] and
 * [MOUSE_BUTTON_WHEEL_DOWN]. This can be changed to [MOUSE_BUTTON_WHEEL_LEFT] and
 * [MOUSE_BUTTON_WHEEL_RIGHT] with the
 * [ProjectSettings.inputDevices/pointing/android/rotaryInputScrollAxis] setting.
 */
@GodotBaseType
public open class InputEventMouseButton : InputEventMouse() {
  /**
   * The amount (or delta) of the event. When used for high-precision scroll events, this indicates
   * the scroll amount (vertical or horizontal). This is only supported on some platforms; the reported
   * sensitivity varies depending on the platform. May be `0` if not supported.
   */
  public final inline var factor: Float
    @JvmName("factorProperty")
    get() = getFactor()
    @JvmName("factorProperty")
    set(`value`) {
      setFactor(value)
    }

  /**
   * The mouse button identifier, one of the [MouseButton] button or button wheel constants.
   */
  public final inline var buttonIndex: MouseButton
    @JvmName("buttonIndexProperty")
    get() = getButtonIndex()
    @JvmName("buttonIndexProperty")
    set(`value`) {
      setButtonIndex(value)
    }

  /**
   * If `true`, the mouse button event has been canceled.
   */
  public final inline var canceled: Boolean
    @JvmName("canceledProperty")
    get() = isCanceled()
    @JvmName("canceledProperty")
    set(`value`) {
      setCanceled(value)
    }

  /**
   * If `true`, the mouse button's state is pressed. If `false`, the mouse button's state is
   * released.
   */
  public final inline var pressed: Boolean
    @JvmName("pressedProperty")
    get() = isPressed()
    @JvmName("pressedProperty")
    set(`value`) {
      setPressed(value)
    }

  /**
   * If `true`, the mouse button's state is a double-click.
   */
  public final inline var doubleClick: Boolean
    @JvmName("doubleClickProperty")
    get() = isDoubleClick()
    @JvmName("doubleClickProperty")
    set(`value`) {
      setDoubleClick(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(318, scriptPtr)
  }

  public final fun setFactor(factor: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, factor.toDouble())
    TransferContext.callMethod(MethodBindings.setFactorPtr)
  }

  public final fun getFactor(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFactorPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setButtonIndex(buttonIndex: MouseButton): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, buttonIndex.value)
    TransferContext.callMethod(MethodBindings.setButtonIndexPtr)
  }

  public final fun getButtonIndex(): MouseButton {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getButtonIndexPtr)
    return MouseButton.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pressed)
    TransferContext.callMethod(MethodBindings.setPressedPtr)
  }

  public final fun setCanceled(canceled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, canceled)
    TransferContext.callMethod(MethodBindings.setCanceledPtr)
  }

  public final fun setDoubleClick(doubleClick: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, doubleClick)
    TransferContext.callMethod(MethodBindings.setDoubleClickPtr)
  }

  public final fun isDoubleClick(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isDoubleClickPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public companion object {
    @JvmField
    public val setFactorName: MethodStringName1<InputEventMouseButton, Unit, Float> =
        MethodStringName1<InputEventMouseButton, Unit, Float>("set_factor")

    @JvmField
    public val getFactorName: MethodStringName0<InputEventMouseButton, Float> =
        MethodStringName0<InputEventMouseButton, Float>("get_factor")

    @JvmField
    public val setButtonIndexName: MethodStringName1<InputEventMouseButton, Unit, MouseButton> =
        MethodStringName1<InputEventMouseButton, Unit, MouseButton>("set_button_index")

    @JvmField
    public val getButtonIndexName: MethodStringName0<InputEventMouseButton, MouseButton> =
        MethodStringName0<InputEventMouseButton, MouseButton>("get_button_index")

    @JvmField
    public val setPressedName: MethodStringName1<InputEventMouseButton, Unit, Boolean> =
        MethodStringName1<InputEventMouseButton, Unit, Boolean>("set_pressed")

    @JvmField
    public val setCanceledName: MethodStringName1<InputEventMouseButton, Unit, Boolean> =
        MethodStringName1<InputEventMouseButton, Unit, Boolean>("set_canceled")

    @JvmField
    public val setDoubleClickName: MethodStringName1<InputEventMouseButton, Unit, Boolean> =
        MethodStringName1<InputEventMouseButton, Unit, Boolean>("set_double_click")

    @JvmField
    public val isDoubleClickName: MethodStringName0<InputEventMouseButton, Boolean> =
        MethodStringName0<InputEventMouseButton, Boolean>("is_double_click")
  }

  public object MethodBindings {
    internal val setFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "set_factor", 373806689)

    internal val getFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "get_factor", 1740695150)

    internal val setButtonIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "set_button_index", 3624991109)

    internal val getButtonIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "get_button_index", 1132662608)

    internal val setPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "set_pressed", 2586408642)

    internal val setCanceledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "set_canceled", 2586408642)

    internal val setDoubleClickPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "set_double_click", 2586408642)

    internal val isDoubleClickPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMouseButton", "is_double_click", 36873697)
  }
}
