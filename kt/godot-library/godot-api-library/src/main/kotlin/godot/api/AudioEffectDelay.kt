// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import kotlin.Boolean
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A "delay" effect plays the input audio signal back after a period of time. Each repetition is
 * called a "delay tap" or simply "tap". Delay taps may be played back multiple times to create the
 * sound of a repeating, decaying echo. Delay effects range from a subtle echo to a pronounced blending
 * of previous sounds with new sounds.
 *
 * See also [AudioEffectReverb] for a blurry, continuous echo.
 */
@GodotBaseType
public open class AudioEffectDelay : AudioEffect() {
  /**
   * The volume ratio of the original audio. Value can range from 0 to 1.
   */
  public final inline var dry: Float
    @JvmName("dryProperty")
    get() = getDry()
    @JvmName("dryProperty")
    set(`value`) {
      setDry(value)
    }

  /**
   * If `true`, the first tap will be enabled.
   */
  public final inline var tap1Active: Boolean
    @JvmName("tap1ActiveProperty")
    get() = isTap1Active()
    @JvmName("tap1ActiveProperty")
    set(`value`) {
      setTap1Active(value)
    }

  /**
   * First tap delay time in milliseconds, compared to the original audio. Value can range from 0 to
   * 1500.
   */
  public final inline var tap1DelayMs: Float
    @JvmName("tap1DelayMsProperty")
    get() = getTap1DelayMs()
    @JvmName("tap1DelayMsProperty")
    set(`value`) {
      setTap1DelayMs(value)
    }

  /**
   * Gain for the first tap, in dB. Value can range from -60 to 0.
   */
  public final inline var tap1LevelDb: Float
    @JvmName("tap1LevelDbProperty")
    get() = getTap1LevelDb()
    @JvmName("tap1LevelDbProperty")
    set(`value`) {
      setTap1LevelDb(value)
    }

  /**
   * Pan position for the first tap. Negative values pan the sound to the left, positive pan to the
   * right. Value can range from -1 to 1.
   */
  public final inline var tap1Pan: Float
    @JvmName("tap1PanProperty")
    get() = getTap1Pan()
    @JvmName("tap1PanProperty")
    set(`value`) {
      setTap1Pan(value)
    }

  /**
   * If `true`, the second tap will be enabled.
   */
  public final inline var tap2Active: Boolean
    @JvmName("tap2ActiveProperty")
    get() = isTap2Active()
    @JvmName("tap2ActiveProperty")
    set(`value`) {
      setTap2Active(value)
    }

  /**
   * Second tap delay time in milliseconds, compared to the original audio. Value can range from 0
   * to 1500.
   */
  public final inline var tap2DelayMs: Float
    @JvmName("tap2DelayMsProperty")
    get() = getTap2DelayMs()
    @JvmName("tap2DelayMsProperty")
    set(`value`) {
      setTap2DelayMs(value)
    }

  /**
   * Gain for the second tap, in dB. Value can range from -60 to 0.
   */
  public final inline var tap2LevelDb: Float
    @JvmName("tap2LevelDbProperty")
    get() = getTap2LevelDb()
    @JvmName("tap2LevelDbProperty")
    set(`value`) {
      setTap2LevelDb(value)
    }

  /**
   * Pan position for the second tap. Negative values pan the sound to the left, positive pan to the
   * right. Value can range from -1 to 1.
   */
  public final inline var tap2Pan: Float
    @JvmName("tap2PanProperty")
    get() = getTap2Pan()
    @JvmName("tap2PanProperty")
    set(`value`) {
      setTap2Pan(value)
    }

  /**
   * If `true`, feedback is enabled, repeating taps after they are played.
   */
  public final inline var feedbackActive: Boolean
    @JvmName("feedbackActiveProperty")
    get() = isFeedbackActive()
    @JvmName("feedbackActiveProperty")
    set(`value`) {
      setFeedbackActive(value)
    }

  /**
   * Feedback delay time in milliseconds. Value can range from 0 to 1500.
   */
  public final inline var feedbackDelayMs: Float
    @JvmName("feedbackDelayMsProperty")
    get() = getFeedbackDelayMs()
    @JvmName("feedbackDelayMsProperty")
    set(`value`) {
      setFeedbackDelayMs(value)
    }

  /**
   * Gain for feedback, in dB. Value can range from -60 to 0.
   */
  public final inline var feedbackLevelDb: Float
    @JvmName("feedbackLevelDbProperty")
    get() = getFeedbackLevelDb()
    @JvmName("feedbackLevelDbProperty")
    set(`value`) {
      setFeedbackLevelDb(value)
    }

  /**
   * Low-pass filter for feedback, in Hz. Frequencies above this value are filtered out. Value can
   * range from 1 to 16000.
   */
  public final inline var feedbackLowpass: Float
    @JvmName("feedbackLowpassProperty")
    get() = getFeedbackLowpass()
    @JvmName("feedbackLowpassProperty")
    set(`value`) {
      setFeedbackLowpass(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(53, scriptPtr)
  }

  public final fun setDry(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDryPtr, amount.toDouble())
  }

  public final fun getDry(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDryPtr).toFloat()

  public final fun setTap1Active(amount: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setTap1ActivePtr, amount)
  }

  public final fun isTap1Active(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isTap1ActivePtr)

  public final fun setTap1DelayMs(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTap1DelayMsPtr, amount.toDouble())
  }

  public final fun getTap1DelayMs(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTap1DelayMsPtr).toFloat()

  public final fun setTap1LevelDb(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTap1LevelDbPtr, amount.toDouble())
  }

  public final fun getTap1LevelDb(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTap1LevelDbPtr).toFloat()

  public final fun setTap1Pan(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTap1PanPtr, amount.toDouble())
  }

  public final fun getTap1Pan(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTap1PanPtr).toFloat()

  public final fun setTap2Active(amount: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setTap2ActivePtr, amount)
  }

  public final fun isTap2Active(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isTap2ActivePtr)

  public final fun setTap2DelayMs(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTap2DelayMsPtr, amount.toDouble())
  }

  public final fun getTap2DelayMs(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTap2DelayMsPtr).toFloat()

  public final fun setTap2LevelDb(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTap2LevelDbPtr, amount.toDouble())
  }

  public final fun getTap2LevelDb(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTap2LevelDbPtr).toFloat()

  public final fun setTap2Pan(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTap2PanPtr, amount.toDouble())
  }

  public final fun getTap2Pan(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTap2PanPtr).toFloat()

  public final fun setFeedbackActive(amount: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setFeedbackActivePtr, amount)
  }

  public final fun isFeedbackActive(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isFeedbackActivePtr)

  public final fun setFeedbackDelayMs(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setFeedbackDelayMsPtr, amount.toDouble())
  }

  public final fun getFeedbackDelayMs(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFeedbackDelayMsPtr).toFloat()

  public final fun setFeedbackLevelDb(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setFeedbackLevelDbPtr, amount.toDouble())
  }

  public final fun getFeedbackLevelDb(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFeedbackLevelDbPtr).toFloat()

  public final fun setFeedbackLowpass(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setFeedbackLowpassPtr, amount.toDouble())
  }

  public final fun getFeedbackLowpass(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getFeedbackLowpassPtr).toFloat()

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectDelay::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setDryName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_dry")

    @JvmField
    public val getDryName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_dry")

    @JvmField
    public val setTap1ActiveName: MethodStringName1<AudioEffectDelay, Unit, Boolean> =
        MethodStringName1<AudioEffectDelay, Unit, Boolean>("set_tap1_active")

    @JvmField
    public val isTap1ActiveName: MethodStringName0<AudioEffectDelay, Boolean> =
        MethodStringName0<AudioEffectDelay, Boolean>("is_tap1_active")

    @JvmField
    public val setTap1DelayMsName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_tap1_delay_ms")

    @JvmField
    public val getTap1DelayMsName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_tap1_delay_ms")

    @JvmField
    public val setTap1LevelDbName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_tap1_level_db")

    @JvmField
    public val getTap1LevelDbName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_tap1_level_db")

    @JvmField
    public val setTap1PanName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_tap1_pan")

    @JvmField
    public val getTap1PanName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_tap1_pan")

    @JvmField
    public val setTap2ActiveName: MethodStringName1<AudioEffectDelay, Unit, Boolean> =
        MethodStringName1<AudioEffectDelay, Unit, Boolean>("set_tap2_active")

    @JvmField
    public val isTap2ActiveName: MethodStringName0<AudioEffectDelay, Boolean> =
        MethodStringName0<AudioEffectDelay, Boolean>("is_tap2_active")

    @JvmField
    public val setTap2DelayMsName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_tap2_delay_ms")

    @JvmField
    public val getTap2DelayMsName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_tap2_delay_ms")

    @JvmField
    public val setTap2LevelDbName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_tap2_level_db")

    @JvmField
    public val getTap2LevelDbName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_tap2_level_db")

    @JvmField
    public val setTap2PanName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_tap2_pan")

    @JvmField
    public val getTap2PanName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_tap2_pan")

    @JvmField
    public val setFeedbackActiveName: MethodStringName1<AudioEffectDelay, Unit, Boolean> =
        MethodStringName1<AudioEffectDelay, Unit, Boolean>("set_feedback_active")

    @JvmField
    public val isFeedbackActiveName: MethodStringName0<AudioEffectDelay, Boolean> =
        MethodStringName0<AudioEffectDelay, Boolean>("is_feedback_active")

    @JvmField
    public val setFeedbackDelayMsName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_feedback_delay_ms")

    @JvmField
    public val getFeedbackDelayMsName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_feedback_delay_ms")

    @JvmField
    public val setFeedbackLevelDbName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_feedback_level_db")

    @JvmField
    public val getFeedbackLevelDbName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_feedback_level_db")

    @JvmField
    public val setFeedbackLowpassName: MethodStringName1<AudioEffectDelay, Unit, Float> =
        MethodStringName1<AudioEffectDelay, Unit, Float>("set_feedback_lowpass")

    @JvmField
    public val getFeedbackLowpassName: MethodStringName0<AudioEffectDelay, Float> =
        MethodStringName0<AudioEffectDelay, Float>("get_feedback_lowpass")
  }

  public object MethodBindings {
    internal val setDryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_dry", 373806689)

    internal val getDryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_dry", 191475506)

    internal val setTap1ActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap1_active", 2586408642)

    internal val isTap1ActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "is_tap1_active", 36873697)

    internal val setTap1DelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap1_delay_ms", 373806689)

    internal val getTap1DelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_tap1_delay_ms", 1740695150)

    internal val setTap1LevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap1_level_db", 373806689)

    internal val getTap1LevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_tap1_level_db", 1740695150)

    internal val setTap1PanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap1_pan", 373806689)

    internal val getTap1PanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_tap1_pan", 1740695150)

    internal val setTap2ActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap2_active", 2586408642)

    internal val isTap2ActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "is_tap2_active", 36873697)

    internal val setTap2DelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap2_delay_ms", 373806689)

    internal val getTap2DelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_tap2_delay_ms", 1740695150)

    internal val setTap2LevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap2_level_db", 373806689)

    internal val getTap2LevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_tap2_level_db", 1740695150)

    internal val setTap2PanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_tap2_pan", 373806689)

    internal val getTap2PanPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_tap2_pan", 1740695150)

    internal val setFeedbackActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_feedback_active", 2586408642)

    internal val isFeedbackActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "is_feedback_active", 36873697)

    internal val setFeedbackDelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_feedback_delay_ms", 373806689)

    internal val getFeedbackDelayMsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_feedback_delay_ms", 1740695150)

    internal val setFeedbackLevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_feedback_level_db", 373806689)

    internal val getFeedbackLevelDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_feedback_level_db", 1740695150)

    internal val setFeedbackLowpassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "set_feedback_lowpass", 373806689)

    internal val getFeedbackLowpassPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectDelay", "get_feedback_lowpass", 1740695150)
  }
}
