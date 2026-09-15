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
import godot.readReturnValue_DOUBLE
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import kotlin.Float
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Stores the factor of a magnifying touch gesture. This is usually performed when the user pinches
 * the touch screen and used for zooming in/out.
 *
 * **Note:** On Android, this requires the
 * [ProjectSettings.inputDevices/pointing/android/enablePanAndScaleGestures] project setting to be
 * enabled.
 */
@GodotBaseType
public open class InputEventMagnifyGesture : InputEventGesture() {
  /**
   * The amount (or delta) of the event. This value is closer to `1.0` the slower the gesture is
   * performed.
   */
  public final inline var factor: Float
    @JvmName("factorProperty")
    get() = getFactor()
    @JvmName("factorProperty")
    set(`value`) {
      setFactor(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(316, scriptPtr)
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

  public companion object {
    @JvmField
    public val setFactorName: MethodStringName1<InputEventMagnifyGesture, Unit, Float> =
        MethodStringName1<InputEventMagnifyGesture, Unit, Float>("set_factor")

    @JvmField
    public val getFactorName: MethodStringName0<InputEventMagnifyGesture, Float> =
        MethodStringName0<InputEventMagnifyGesture, Float>("get_factor")
  }

  public object MethodBindings {
    internal val setFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMagnifyGesture", "set_factor", 373806689)

    internal val getFactorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("InputEventMagnifyGesture", "get_factor", 1740695150)
  }
}
