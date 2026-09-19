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
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A "phaser" effect creates a copy of the original audio that phase-rotates differently across the
 * entire frequency spectrum, with the use of a series of all-pass filter stages (6 in this effect).
 * This copy modulates with a low-frequency oscillator and combines with the original audio, resulting
 * in peaks and troughs that sweep across the spectrum.
 *
 * This effect can be used to create a "glassy" or "bubbly" sound.
 */
@GodotBaseType
public open class AudioEffectPhaser : AudioEffect() {
  /**
   * Determines the minimum frequency affected by the low-frequency oscillator modulations, in Hz.
   * Value can range from 10 to 10000.
   */
  public final inline var rangeMinHz: Float
    @JvmName("rangeMinHzProperty")
    get() = getRangeMinHz()
    @JvmName("rangeMinHzProperty")
    set(`value`) {
      setRangeMinHz(value)
    }

  /**
   * Determines the maximum frequency affected by the low-frequency oscillator modulations, in Hz.
   * Value can range from 10 to 10000.
   */
  public final inline var rangeMaxHz: Float
    @JvmName("rangeMaxHzProperty")
    get() = getRangeMaxHz()
    @JvmName("rangeMaxHzProperty")
    set(`value`) {
      setRangeMaxHz(value)
    }

  /**
   * Adjusts the rate in Hz at which the effect sweeps up and down across the frequency range. Value
   * can range from 0.01 to 20.
   */
  public final inline var rateHz: Float
    @JvmName("rateHzProperty")
    get() = getRateHz()
    @JvmName("rateHzProperty")
    set(`value`) {
      setRateHz(value)
    }

  /**
   * The volume ratio of the filtered audio that is fed back to the all-pass filters. The higher the
   * value, the sharper and louder the peak filters created by the effect. Value can range from 0.1 to
   * 0.9.
   */
  public final inline var feedback: Float
    @JvmName("feedbackProperty")
    get() = getFeedback()
    @JvmName("feedbackProperty")
    set(`value`) {
      setFeedback(value)
    }

  /**
   * Intensity of the effect. Value can range from 0.1 to 4.0.
   */
  public final inline var depth: Float
    @JvmName("depthProperty")
    get() = getDepth()
    @JvmName("depthProperty")
    set(`value`) {
      setDepth(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(69, scriptPtr)
  }

  public final fun setRangeMinHz(hz: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRangeMinHzPtr, hz.toDouble())
  }

  public final fun getRangeMinHz(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRangeMinHzPtr).toFloat()

  public final fun setRangeMaxHz(hz: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRangeMaxHzPtr, hz.toDouble())
  }

  public final fun getRangeMaxHz(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRangeMaxHzPtr).toFloat()

  public final fun setRateHz(hz: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRateHzPtr, hz.toDouble())
  }

  public final fun getRateHz(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRateHzPtr).toFloat()

  public final fun setFeedback(fbk: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setFeedbackPtr, fbk.toDouble())
  }

  public final fun getFeedback(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFeedbackPtr).toFloat()

  public final fun setDepth(depth: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDepthPtr, depth.toDouble())
  }

  public final fun getDepth(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDepthPtr).toFloat()

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectPhaser::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setRangeMinHzName: MethodStringName1<AudioEffectPhaser, Unit, Float> =
        MethodStringName1<AudioEffectPhaser, Unit, Float>("set_range_min_hz")

    @JvmField
    public val getRangeMinHzName: MethodStringName0<AudioEffectPhaser, Float> =
        MethodStringName0<AudioEffectPhaser, Float>("get_range_min_hz")

    @JvmField
    public val setRangeMaxHzName: MethodStringName1<AudioEffectPhaser, Unit, Float> =
        MethodStringName1<AudioEffectPhaser, Unit, Float>("set_range_max_hz")

    @JvmField
    public val getRangeMaxHzName: MethodStringName0<AudioEffectPhaser, Float> =
        MethodStringName0<AudioEffectPhaser, Float>("get_range_max_hz")

    @JvmField
    public val setRateHzName: MethodStringName1<AudioEffectPhaser, Unit, Float> =
        MethodStringName1<AudioEffectPhaser, Unit, Float>("set_rate_hz")

    @JvmField
    public val getRateHzName: MethodStringName0<AudioEffectPhaser, Float> =
        MethodStringName0<AudioEffectPhaser, Float>("get_rate_hz")

    @JvmField
    public val setFeedbackName: MethodStringName1<AudioEffectPhaser, Unit, Float> =
        MethodStringName1<AudioEffectPhaser, Unit, Float>("set_feedback")

    @JvmField
    public val getFeedbackName: MethodStringName0<AudioEffectPhaser, Float> =
        MethodStringName0<AudioEffectPhaser, Float>("get_feedback")

    @JvmField
    public val setDepthName: MethodStringName1<AudioEffectPhaser, Unit, Float> =
        MethodStringName1<AudioEffectPhaser, Unit, Float>("set_depth")

    @JvmField
    public val getDepthName: MethodStringName0<AudioEffectPhaser, Float> =
        MethodStringName0<AudioEffectPhaser, Float>("get_depth")
  }

  public object MethodBindings {
    internal val setRangeMinHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "set_range_min_hz", 373806689)

    internal val getRangeMinHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "get_range_min_hz", 1740695150)

    internal val setRangeMaxHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "set_range_max_hz", 373806689)

    internal val getRangeMaxHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "get_range_max_hz", 1740695150)

    internal val setRateHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "set_rate_hz", 373806689)

    internal val getRateHzPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "get_rate_hz", 1740695150)

    internal val setFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "set_feedback", 373806689)

    internal val getFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "get_feedback", 1740695150)

    internal val setDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "set_depth", 373806689)

    internal val getDepthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectPhaser", "get_depth", 1740695150)
  }
}
