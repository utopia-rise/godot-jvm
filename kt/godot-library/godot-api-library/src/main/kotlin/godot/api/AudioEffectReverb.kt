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
 * A "reverb" effect plays the input audio back continuously, decaying over a period of time. It
 * simulates sounds in different kinds of spaces, ranging from small rooms, to big caverns.
 *
 * See also [AudioEffectDelay] for a non-blurry type of echo.
 */
@GodotBaseType
public open class AudioEffectReverb : AudioEffect() {
  /**
   * Time between the original audio and the early reflections of the reverb signal, in
   * milliseconds. Value can range from 20 to 500.
   */
  public final inline var predelayMsec: Float
    @JvmName("predelayMsecProperty")
    get() = getPredelayMsec()
    @JvmName("predelayMsecProperty")
    set(`value`) {
      setPredelayMsec(value)
    }

  /**
   * Gain of early reflection copies. At higher values, early reflection copies are louder and ring
   * out for longer. Value can range from 0 to 1.
   */
  public final inline var predelayFeedback: Float
    @JvmName("predelayFeedbackProperty")
    get() = getPredelayFeedback()
    @JvmName("predelayFeedbackProperty")
    set(`value`) {
      setPredelayFeedback(value)
    }

  /**
   * Dimensions of simulated room. Bigger means more echoes. Value can range from 0 to 1.
   */
  public final inline var roomSize: Float
    @JvmName("roomSizeProperty")
    get() = getRoomSize()
    @JvmName("roomSizeProperty")
    set(`value`) {
      setRoomSize(value)
    }

  /**
   * Defines how reflective the imaginary room's walls are. The more reflective, the more high
   * frequency content the reverb has. Value can range from 0 to 1.
   */
  public final inline var damping: Float
    @JvmName("dampingProperty")
    get() = getDamping()
    @JvmName("dampingProperty")
    set(`value`) {
      setDamping(value)
    }

  /**
   * Widens or narrows the stereo image of the reverb tail. At 1, it fully widens. Value can range
   * from 0 to 1.
   */
  public final inline var spread: Float
    @JvmName("spreadProperty")
    get() = getSpread()
    @JvmName("spreadProperty")
    set(`value`) {
      setSpread(value)
    }

  /**
   * High-pass filter allows frequencies higher than a certain cutoff threshold and attenuates
   * frequencies lower than the cutoff threshold. Value can range from 0 to 1.
   */
  public final inline var hipass: Float
    @JvmName("hipassProperty")
    get() = getHpf()
    @JvmName("hipassProperty")
    set(`value`) {
      setHpf(value)
    }

  /**
   * The volume ratio of the original audio. At 0, only the modified audio is outputted. Value can
   * range from 0 to 1.
   */
  public final inline var dry: Float
    @JvmName("dryProperty")
    get() = getDry()
    @JvmName("dryProperty")
    set(`value`) {
      setDry(value)
    }

  /**
   * The volume ratio of the modified audio. At 0, only the original audio is outputted. Value can
   * range from 0 to 1.
   */
  public final inline var wet: Float
    @JvmName("wetProperty")
    get() = getWet()
    @JvmName("wetProperty")
    set(`value`) {
      setWet(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(72, scriptPtr)
  }

  public final fun setPredelayMsec(msec: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setPredelayMsecPtr, msec.toDouble())
  }

  public final fun getPredelayMsec(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getPredelayMsecPtr).toFloat()

  public final fun setPredelayFeedback(feedback: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setPredelayFeedbackPtr, feedback.toDouble())
  }

  public final fun getPredelayFeedback(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getPredelayFeedbackPtr).toFloat()

  public final fun setRoomSize(size: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setRoomSizePtr, size.toDouble())
  }

  public final fun getRoomSize(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getRoomSizePtr).toFloat()

  public final fun setDamping(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDampingPtr, amount.toDouble())
  }

  public final fun getDamping(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDampingPtr).toFloat()

  public final fun setSpread(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setSpreadPtr, amount.toDouble())
  }

  public final fun getSpread(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getSpreadPtr).toFloat()

  public final fun setDry(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setDryPtr, amount.toDouble())
  }

  public final fun getDry(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getDryPtr).toFloat()

  public final fun setWet(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setWetPtr, amount.toDouble())
  }

  public final fun getWet(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getWetPtr).toFloat()

  public final fun setHpf(amount: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setHpfPtr, amount.toDouble())
  }

  public final fun getHpf(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getHpfPtr).toFloat()

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectReverb::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setPredelayMsecName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_predelay_msec")

    @JvmField
    public val getPredelayMsecName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_predelay_msec")

    @JvmField
    public val setPredelayFeedbackName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_predelay_feedback")

    @JvmField
    public val getPredelayFeedbackName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_predelay_feedback")

    @JvmField
    public val setRoomSizeName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_room_size")

    @JvmField
    public val getRoomSizeName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_room_size")

    @JvmField
    public val setDampingName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_damping")

    @JvmField
    public val getDampingName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_damping")

    @JvmField
    public val setSpreadName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_spread")

    @JvmField
    public val getSpreadName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_spread")

    @JvmField
    public val setDryName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_dry")

    @JvmField
    public val getDryName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_dry")

    @JvmField
    public val setWetName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_wet")

    @JvmField
    public val getWetName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_wet")

    @JvmField
    public val setHpfName: MethodStringName1<AudioEffectReverb, Unit, Float> =
        MethodStringName1<AudioEffectReverb, Unit, Float>("set_hpf")

    @JvmField
    public val getHpfName: MethodStringName0<AudioEffectReverb, Float> =
        MethodStringName0<AudioEffectReverb, Float>("get_hpf")
  }

  public object MethodBindings {
    internal val setPredelayMsecPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_predelay_msec", 373806689)

    internal val getPredelayMsecPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_predelay_msec", 1740695150)

    internal val setPredelayFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_predelay_feedback", 373806689)

    internal val getPredelayFeedbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_predelay_feedback", 1740695150)

    internal val setRoomSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_room_size", 373806689)

    internal val getRoomSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_room_size", 1740695150)

    internal val setDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_damping", 373806689)

    internal val getDampingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_damping", 1740695150)

    internal val setSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_spread", 373806689)

    internal val getSpreadPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_spread", 1740695150)

    internal val setDryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_dry", 373806689)

    internal val getDryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_dry", 1740695150)

    internal val setWetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_wet", 373806689)

    internal val getWetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_wet", 1740695150)

    internal val setHpfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "set_hpf", 373806689)

    internal val getHpfPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectReverb", "get_hpf", 1740695150)
  }
}
