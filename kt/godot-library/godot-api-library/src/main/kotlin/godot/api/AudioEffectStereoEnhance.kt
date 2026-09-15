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
import godot.core.VariantParser.DOUBLE
import kotlin.Double
import kotlin.Float
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Adjusts gain of the left and right channels, and makes mono sounds stereo through phase shifting.
 */
@GodotBaseType
public open class AudioEffectStereoEnhance : AudioEffect() {
  /**
   * Gain of the side channels, if they exist. A value of 0 will downmix stereo to mono. Value can
   * range from 0 to 4.
   */
  public final inline var panPullout: Float
    @JvmName("panPulloutProperty")
    get() = getPanPullout()
    @JvmName("panPulloutProperty")
    set(`value`) {
      setPanPullout(value)
    }

  /**
   * Widens the stereo image through phase shifting in conjunction with [surround]. Just delays the
   * right channel if [surround] is 0. Value is in milliseconds, and can range from 0 to 50.
   */
  public final inline var timePulloutMs: Float
    @JvmName("timePulloutMsProperty")
    get() = getTimePullout()
    @JvmName("timePulloutMsProperty")
    set(`value`) {
      setTimePullout(value)
    }

  /**
   * Widens the stereo image through phase shifting in conjunction with [timePulloutMs]. Just pans
   * sound to the left channel if [timePulloutMs] is 0. Value can range from 0 to 1.
   */
  public final inline var surround: Float
    @JvmName("surroundProperty")
    get() = getSurround()
    @JvmName("surroundProperty")
    set(`value`) {
      setSurround(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(75, scriptPtr)
  }

  public final fun setPanPullout(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setPanPulloutPtr)
  }

  public final fun getPanPullout(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPanPulloutPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setTimePullout(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setTimePulloutPtr)
  }

  public final fun getTimePullout(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTimePulloutPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setSurround(amount: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to amount.toDouble())
    TransferContext.callMethod(MethodBindings.setSurroundPtr)
  }

  public final fun getSurround(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSurroundPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectStereoEnhance::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setPanPulloutName: MethodStringName1<AudioEffectStereoEnhance, Unit, Float> =
        MethodStringName1<AudioEffectStereoEnhance, Unit, Float>("set_pan_pullout")

    @JvmField
    public val getPanPulloutName: MethodStringName0<AudioEffectStereoEnhance, Float> =
        MethodStringName0<AudioEffectStereoEnhance, Float>("get_pan_pullout")

    @JvmField
    public val setTimePulloutName: MethodStringName1<AudioEffectStereoEnhance, Unit, Float> =
        MethodStringName1<AudioEffectStereoEnhance, Unit, Float>("set_time_pullout")

    @JvmField
    public val getTimePulloutName: MethodStringName0<AudioEffectStereoEnhance, Float> =
        MethodStringName0<AudioEffectStereoEnhance, Float>("get_time_pullout")

    @JvmField
    public val setSurroundName: MethodStringName1<AudioEffectStereoEnhance, Unit, Float> =
        MethodStringName1<AudioEffectStereoEnhance, Unit, Float>("set_surround")

    @JvmField
    public val getSurroundName: MethodStringName0<AudioEffectStereoEnhance, Float> =
        MethodStringName0<AudioEffectStereoEnhance, Float>("get_surround")
  }

  public object MethodBindings {
    internal val setPanPulloutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectStereoEnhance", "set_pan_pullout", 373806689)

    internal val getPanPulloutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectStereoEnhance", "get_pan_pullout", 1740695150)

    internal val setTimePulloutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectStereoEnhance", "set_time_pullout", 373806689)

    internal val getTimePulloutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectStereoEnhance", "get_time_pullout", 1740695150)

    internal val setSurroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectStereoEnhance", "set_surround", 373806689)

    internal val getSurroundPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectStereoEnhance", "get_surround", 1740695150)
  }
}
