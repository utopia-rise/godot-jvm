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
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This haptic feedback resource makes it possible to define a vibration based haptic feedback pulse
 * that can be triggered through actions in the OpenXR action map.
 */
@GodotBaseType
public open class OpenXRHapticVibration : OpenXRHapticBase() {
  /**
   * The duration of the pulse in nanoseconds. Use `-1` for a minimum duration pulse for the current
   * XR runtime.
   */
  public final inline var duration: Long
    @JvmName("durationProperty")
    get() = getDuration()
    @JvmName("durationProperty")
    set(`value`) {
      setDuration(value)
    }

  /**
   * The frequency of the pulse in Hz. `0.0` will let the XR runtime chose an optimal frequency for
   * the device used.
   */
  public final inline var frequency: Float
    @JvmName("frequencyProperty")
    get() = getFrequency()
    @JvmName("frequencyProperty")
    set(`value`) {
      setFrequency(value)
    }

  /**
   * The amplitude of the pulse between `0.0` and `1.0`.
   */
  public final inline var amplitude: Float
    @JvmName("amplitudeProperty")
    get() = getAmplitude()
    @JvmName("amplitudeProperty")
    set(`value`) {
      setAmplitude(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(457, scriptPtr)
  }

  public final fun setDuration(duration: Long): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, duration)
    TransferContext.callPtrMethod(MethodBindings.setDurationPtr, 0)
  }

  public final fun getDuration(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDurationPtr, 2)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun setFrequency(frequency: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, frequency.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setFrequencyPtr, 0)
  }

  public final fun getFrequency(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getFrequencyPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setAmplitude(amplitude: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, amplitude.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setAmplitudePtr, 0)
  }

  public final fun getAmplitude(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAmplitudePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public companion object {
    @JvmField
    public val setDurationName: MethodStringName1<OpenXRHapticVibration, Unit, Long> =
        MethodStringName1<OpenXRHapticVibration, Unit, Long>("set_duration")

    @JvmField
    public val getDurationName: MethodStringName0<OpenXRHapticVibration, Long> =
        MethodStringName0<OpenXRHapticVibration, Long>("get_duration")

    @JvmField
    public val setFrequencyName: MethodStringName1<OpenXRHapticVibration, Unit, Float> =
        MethodStringName1<OpenXRHapticVibration, Unit, Float>("set_frequency")

    @JvmField
    public val getFrequencyName: MethodStringName0<OpenXRHapticVibration, Float> =
        MethodStringName0<OpenXRHapticVibration, Float>("get_frequency")

    @JvmField
    public val setAmplitudeName: MethodStringName1<OpenXRHapticVibration, Unit, Float> =
        MethodStringName1<OpenXRHapticVibration, Unit, Float>("set_amplitude")

    @JvmField
    public val getAmplitudeName: MethodStringName0<OpenXRHapticVibration, Float> =
        MethodStringName0<OpenXRHapticVibration, Float>("get_amplitude")
  }

  public object MethodBindings {
    internal val setDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHapticVibration", "set_duration", 1286410249)

    internal val getDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHapticVibration", "get_duration", 3905245786)

    internal val setFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHapticVibration", "set_frequency", 373806689)

    internal val getFrequencyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHapticVibration", "get_frequency", 1740695150)

    internal val setAmplitudePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHapticVibration", "set_amplitude", 373806689)

    internal val getAmplitudePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHapticVibration", "get_amplitude", 1740695150)
  }
}
