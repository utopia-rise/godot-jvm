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
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.common.interop.VoidPtr
import godot.core.JoyAxis
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Stores information about joystick motions. One [InputEventJoypadMotion] represents one axis at a
 * time. For gamepad buttons, see [InputEventJoypadButton].
 */
@GodotBaseType
public open class InputEventJoypadMotion : InputEvent() {
  /**
   * Axis identifier.
   */
  public final inline var axis: JoyAxis
    @JvmName("axisProperty")
    get() = getAxis()
    @JvmName("axisProperty")
    set(`value`) {
      setAxis(value)
    }

  /**
   * Current position of the joystick on the given axis. The value ranges from `-1.0` to `1.0`. A
   * value of `0` means the axis is in its resting position.
   */
  public final inline var axisValue: Float
    @JvmName("axisValueProperty")
    get() = getAxisValue()
    @JvmName("axisValueProperty")
    set(`value`) {
      setAxisValue(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(313, scriptPtr)
  }

  public final fun setAxis(axis: JoyAxis): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setAxisPtr, axis.value)
  }

  public final fun getAxis(): JoyAxis =
      JoyAxis.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getAxisPtr))

  public final fun setAxisValue(axisValue: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setAxisValuePtr, axisValue.toDouble())
  }

  public final fun getAxisValue(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getAxisValuePtr).toFloat()

  public companion object {
    @JvmField
    public val setAxisName: MethodStringName1<InputEventJoypadMotion, Unit, JoyAxis> =
        MethodStringName1<InputEventJoypadMotion, Unit, JoyAxis>("set_axis")

    @JvmField
    public val getAxisName: MethodStringName0<InputEventJoypadMotion, JoyAxis> =
        MethodStringName0<InputEventJoypadMotion, JoyAxis>("get_axis")

    @JvmField
    public val setAxisValueName: MethodStringName1<InputEventJoypadMotion, Unit, Float> =
        MethodStringName1<InputEventJoypadMotion, Unit, Float>("set_axis_value")

    @JvmField
    public val getAxisValueName: MethodStringName0<InputEventJoypadMotion, Float> =
        MethodStringName0<InputEventJoypadMotion, Float>("get_axis_value")
  }

  public object MethodBindings {
    internal val setAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadMotion", "set_axis", 1332685170)

    internal val getAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadMotion", "get_axis", 4019121683)

    internal val setAxisValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadMotion", "set_axis_value", 373806689)

    internal val getAxisValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventJoypadMotion", "get_axis_value", 1740695150)
  }
}
