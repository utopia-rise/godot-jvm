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
 * A "limiter" disallows audio signals from exceeding a given volume threshold level in dB. Hard
 * limiters predict volume peaks, and will smoothly apply gain reduction when a peak crosses the
 * ceiling threshold level to prevent clipping. It preserves the waveform and prevents it from crossing
 * the ceiling threshold level. Adding one in the Master bus is recommended as a safety measure to
 * prevent sudden volume peaks from occurring, and to prevent distortion caused by clipping, when the
 * volume exceeds 0 dB.
 *
 * If clipping is desired, consider [AudioEffectDistortion.MODE_CLIP].
 */
@GodotBaseType
public open class AudioEffectHardLimiter : AudioEffect() {
  /**
   * Gain before limiting, in dB. Value can range from -24 to 24.
   */
  public final inline var preGainDb: Float
    @JvmName("preGainDbProperty")
    get() = getPreGainDb()
    @JvmName("preGainDbProperty")
    set(`value`) {
      setPreGainDb(value)
    }

  /**
   * The waveform's maximum allowed value, in dB. This value can range from -24 to 0.
   *
   * The default value of -0.3 prevents potential inter-sample peaks (ISP) from crossing over 0 dB,
   * which can cause slight distortion on some older hardware.
   */
  public final inline var ceilingDb: Float
    @JvmName("ceilingDbProperty")
    get() = getCeilingDb()
    @JvmName("ceilingDbProperty")
    set(`value`) {
      setCeilingDb(value)
    }

  /**
   * Time it takes in seconds for the gain reduction to fully release. Value can range from 0.01 to
   * 3.
   */
  public final inline var release: Float
    @JvmName("releaseProperty")
    get() = getRelease()
    @JvmName("releaseProperty")
    set(`value`) {
      setRelease(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(60, scriptPtr)
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

  public final fun setPreGainDb(preGain: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, preGain.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPreGainDbPtr, 0)
  }

  public final fun getPreGainDb(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPreGainDbPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setRelease(release: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, release.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setReleasePtr, 0)
  }

  public final fun getRelease(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getReleasePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectHardLimiter::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setCeilingDbName: MethodStringName1<AudioEffectHardLimiter, Unit, Float> =
        MethodStringName1<AudioEffectHardLimiter, Unit, Float>("set_ceiling_db")

    @JvmField
    public val getCeilingDbName: MethodStringName0<AudioEffectHardLimiter, Float> =
        MethodStringName0<AudioEffectHardLimiter, Float>("get_ceiling_db")

    @JvmField
    public val setPreGainDbName: MethodStringName1<AudioEffectHardLimiter, Unit, Float> =
        MethodStringName1<AudioEffectHardLimiter, Unit, Float>("set_pre_gain_db")

    @JvmField
    public val getPreGainDbName: MethodStringName0<AudioEffectHardLimiter, Float> =
        MethodStringName0<AudioEffectHardLimiter, Float>("get_pre_gain_db")

    @JvmField
    public val setReleaseName: MethodStringName1<AudioEffectHardLimiter, Unit, Float> =
        MethodStringName1<AudioEffectHardLimiter, Unit, Float>("set_release")

    @JvmField
    public val getReleaseName: MethodStringName0<AudioEffectHardLimiter, Float> =
        MethodStringName0<AudioEffectHardLimiter, Float>("get_release")
  }

  public object MethodBindings {
    internal val setCeilingDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectHardLimiter", "set_ceiling_db", 373806689)

    internal val getCeilingDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectHardLimiter", "get_ceiling_db", 1740695150)

    internal val setPreGainDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectHardLimiter", "set_pre_gain_db", 373806689)

    internal val getPreGainDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectHardLimiter", "get_pre_gain_db", 1740695150)

    internal val setReleasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectHardLimiter", "set_release", 373806689)

    internal val getReleasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectHardLimiter", "get_release", 1740695150)
  }
}
