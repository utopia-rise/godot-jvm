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
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A "limiter" is an audio effect designed to stop audio signals from exceeding a specified volume
 * threshold level, and usually works by decreasing the volume or soft-clipping the audio. Adding one
 * in the Master bus is always recommended to prevent clipping when the volume goes above 0 dB.
 *
 * Soft clipping starts to decrease the peaks a little below the volume threshold level and
 * progressively increases its effect as the input volume increases such that the threshold level is
 * never exceeded.
 *
 * If hard clipping is desired, consider [AudioEffectDistortion.MODE_CLIP].
 */
@GodotBaseType
public open class AudioEffectLimiter : AudioEffect() {
  /**
   * The waveform's maximum allowed value, in dB. Value can range from -20 to -0.1.
   */
  public final inline var ceilingDb: Float
    @JvmName("ceilingDbProperty")
    get() = getCeilingDb()
    @JvmName("ceilingDbProperty")
    set(`value`) {
      setCeilingDb(value)
    }

  /**
   * The volume threshold level from which the limiter begins to be active, in dB. Value can range
   * from -30 to 0.
   */
  public final inline var thresholdDb: Float
    @JvmName("thresholdDbProperty")
    get() = getThresholdDb()
    @JvmName("thresholdDbProperty")
    set(`value`) {
      setThresholdDb(value)
    }

  /**
   * Modifies the volume of the limited waves, in dB. Value can range from 0 to 6.
   */
  public final inline var softClipDb: Float
    @JvmName("softClipDbProperty")
    get() = getSoftClipDb()
    @JvmName("softClipDbProperty")
    set(`value`) {
      setSoftClipDb(value)
    }

  /**
   * This property has no effect on the audio. Use [AudioEffectHardLimiter] instead, as this Limiter
   * effect is deprecated.
   */
  public final inline var softClipRatio: Float
    @JvmName("softClipRatioProperty")
    get() = getSoftClipRatio()
    @JvmName("softClipRatioProperty")
    set(`value`) {
      setSoftClipRatio(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(64, scriptPtr)
  }

  public final fun setCeilingDb(ceiling: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, ceiling.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCeilingDbPtr, 0)
  }

  public final fun getCeilingDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCeilingDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setThresholdDb(threshold: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, threshold.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setThresholdDbPtr, 0)
  }

  public final fun getThresholdDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getThresholdDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSoftClipDb(softClip: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, softClip.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSoftClipDbPtr, 0)
  }

  public final fun getSoftClipDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSoftClipDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSoftClipRatio(softClip: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, softClip.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSoftClipRatioPtr, 0)
  }

  public final fun getSoftClipRatio(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSoftClipRatioPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectLimiter::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setCeilingDbName: MethodStringName1<AudioEffectLimiter, Unit, Float> =
        MethodStringName1<AudioEffectLimiter, Unit, Float>("set_ceiling_db")

    @JvmField
    public val getCeilingDbName: MethodStringName0<AudioEffectLimiter, Float> =
        MethodStringName0<AudioEffectLimiter, Float>("get_ceiling_db")

    @JvmField
    public val setThresholdDbName: MethodStringName1<AudioEffectLimiter, Unit, Float> =
        MethodStringName1<AudioEffectLimiter, Unit, Float>("set_threshold_db")

    @JvmField
    public val getThresholdDbName: MethodStringName0<AudioEffectLimiter, Float> =
        MethodStringName0<AudioEffectLimiter, Float>("get_threshold_db")

    @JvmField
    public val setSoftClipDbName: MethodStringName1<AudioEffectLimiter, Unit, Float> =
        MethodStringName1<AudioEffectLimiter, Unit, Float>("set_soft_clip_db")

    @JvmField
    public val getSoftClipDbName: MethodStringName0<AudioEffectLimiter, Float> =
        MethodStringName0<AudioEffectLimiter, Float>("get_soft_clip_db")

    @JvmField
    public val setSoftClipRatioName: MethodStringName1<AudioEffectLimiter, Unit, Float> =
        MethodStringName1<AudioEffectLimiter, Unit, Float>("set_soft_clip_ratio")

    @JvmField
    public val getSoftClipRatioName: MethodStringName0<AudioEffectLimiter, Float> =
        MethodStringName0<AudioEffectLimiter, Float>("get_soft_clip_ratio")
  }

  public object MethodBindings {
    internal val setCeilingDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "set_ceiling_db", 373806689)

    internal val getCeilingDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "get_ceiling_db", 1740695150)

    internal val setThresholdDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "set_threshold_db", 373806689)

    internal val getThresholdDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "get_threshold_db", 1740695150)

    internal val setSoftClipDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "set_soft_clip_db", 373806689)

    internal val getSoftClipDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "get_soft_clip_db", 1740695150)

    internal val setSoftClipRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "set_soft_clip_ratio", 373806689)

    internal val getSoftClipRatioPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectLimiter", "get_soft_clip_ratio", 1740695150)
  }
}
