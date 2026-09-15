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
import godot.core.JoyButton
import godot.core.MethodStringName0
import godot.core.MethodStringName1
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
 * Input event type for gamepad buttons. For gamepad analog sticks and joysticks, see
 * [InputEventJoypadMotion].
 */
@GodotBaseType
public open class InputEventJoypadButton : InputEvent() {
  /**
   * Button identifier. One of the [JoyButton] button constants.
   */
  public final inline var buttonIndex: JoyButton
    @JvmName("buttonIndexProperty")
    get() = getButtonIndex()
    @JvmName("buttonIndexProperty")
    set(`value`) {
      setButtonIndex(value)
    }

  public final inline var pressure: Float
    @JvmName("pressureProperty")
    get() = getPressure()
    @JvmName("pressureProperty")
    set(`value`) {
      setPressure(value)
    }

  /**
   * If `true`, the button's state is pressed. If `false`, the button's state is released.
   */
  public final inline var pressed: Boolean
    @JvmName("pressedProperty")
    get() = isPressed()
    @JvmName("pressedProperty")
    set(`value`) {
      setPressed(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(312, scriptPtr)
  }

  public final fun setButtonIndex(buttonIndex: JoyButton): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, buttonIndex.value)
    TransferContext.callMethod(MethodBindings.setButtonIndexPtr)
  }

  public final fun getButtonIndex(): JoyButton {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getButtonIndexPtr)
    return JoyButton.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPressure(pressure: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, pressure.toDouble())
    TransferContext.callMethod(MethodBindings.setPressurePtr)
  }

  public final fun getPressure(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPressurePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPressed(pressed: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, pressed)
    TransferContext.callMethod(MethodBindings.setPressedPtr)
  }

  public companion object {
    @JvmField
    public val setButtonIndexName: MethodStringName1<InputEventJoypadButton, Unit, JoyButton> =
        MethodStringName1<InputEventJoypadButton, Unit, JoyButton>("set_button_index")

    @JvmField
    public val getButtonIndexName: MethodStringName0<InputEventJoypadButton, JoyButton> =
        MethodStringName0<InputEventJoypadButton, JoyButton>("get_button_index")

    @JvmField
    public val setPressureName: MethodStringName1<InputEventJoypadButton, Unit, Float> =
        MethodStringName1<InputEventJoypadButton, Unit, Float>("set_pressure")

    @JvmField
    public val getPressureName: MethodStringName0<InputEventJoypadButton, Float> =
        MethodStringName0<InputEventJoypadButton, Float>("get_pressure")

    @JvmField
    public val setPressedName: MethodStringName1<InputEventJoypadButton, Unit, Boolean> =
        MethodStringName1<InputEventJoypadButton, Unit, Boolean>("set_pressed")
  }

  public object MethodBindings {
    internal val setButtonIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadButton", "set_button_index", 1466368136)

    internal val getButtonIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadButton", "get_button_index", 595588182)

    internal val setPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadButton", "set_pressure", 373806689)

    internal val getPressurePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadButton", "get_pressure", 1740695150)

    internal val setPressedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadButton", "set_pressed", 2586408642)
  }
}
