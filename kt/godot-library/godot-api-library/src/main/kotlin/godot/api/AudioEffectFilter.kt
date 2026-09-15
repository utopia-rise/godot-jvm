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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import kotlin.Float
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A "filter" controls the gain of frequencies, using [cutoffHz] as a frequency threshold. Filters
 * can help to give room for each sound, and create interesting effects.
 *
 * There are different types of filter that inherit this class:
 *
 * Shelf filters: [AudioEffectLowShelfFilter] and [AudioEffectHighShelfFilter]
 *
 * Band-pass and notch filters: [AudioEffectBandPassFilter], [AudioEffectBandLimitFilter], and
 * [AudioEffectNotchFilter]
 *
 * Low/high-pass filters: [AudioEffectLowPassFilter] and [AudioEffectHighPassFilter]
 */
@GodotBaseType
public open class AudioEffectFilter : AudioEffect() {
  /**
   * Frequency threshold for the filter, in Hz. Value can range from 1 to 20500.
   */
  public final inline var cutoffHz: Float
    @JvmName("cutoffHzProperty")
    get() = getCutoff()
    @JvmName("cutoffHzProperty")
    set(`value`) {
      setCutoff(value)
    }

  /**
   * Gain at or directly next to the [cutoffHz] frequency threshold. Value can range from 0 to 1.
   *
   * Its exact behavior depends on the selected filter type:
   *
   * - For shelf filters, it accentuates or masks the order by increasing frequencies right next to
   * the [cutoffHz] frequency and decreasing frequencies on the opposite side.
   *
   * - For the band-pass and notch filters, it widens or narrows the filter at the [cutoffHz]
   * frequency threshold.
   *
   * - For low/high-pass filters, it increases or decreases frequencies at the [cutoffHz] frequency
   * threshold.
   */
  public final inline var resonance: Float
    @JvmName("resonanceProperty")
    get() = getResonance()
    @JvmName("resonanceProperty")
    set(`value`) {
      setResonance(value)
    }

  /**
   * Gain of the frequencies affected by the filter. This property is only available for
   * [AudioEffectLowShelfFilter] and [AudioEffectHighShelfFilter]. Value can range from 0 to 4.
   */
  public final inline var gain: Float
    @JvmName("gainProperty")
    get() = getGain()
    @JvmName("gainProperty")
    set(`value`) {
      setGain(value)
    }

  /**
   * Steepness of the cutoff curve in dB per octave (twice the frequency above [cutoffHz], or half
   * the frequency below [cutoffHz]), also known as the "order" of the filter. Higher orders have a
   * more aggressive cutoff.
   */
  public final inline var db: FilterDB
    @JvmName("dbProperty")
    get() = getDb()
    @JvmName("dbProperty")
    set(`value`) {
      setDb(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(59, scriptPtr)
  }

  public final fun setCutoff(freq: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, freq.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCutoffPtr, 0)
  }

  public final fun getCutoff(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCutoffPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setResonance(amount: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, amount.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setResonancePtr, 0)
  }

  public final fun getResonance(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getResonancePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setGain(amount: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, amount.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setGainPtr, 0)
  }

  public final fun getGain(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGainPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDb(amount: FilterDB): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, amount.value)
    TransferContext.callPtrMethod(MethodBindings.setDbPtr, 0)
  }

  public final fun getDb(): FilterDB {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDbPtr, 2)
    return FilterDB.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectFilter::_instantiate can't be called from the JVM.")
  }

  public enum class FilterDB(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Cutting off at 6 dB per octave. One octave is twice the frequency above [cutoffHz], or half
     * the frequency below [cutoffHz].
     */
    FILTER_6DB(0),
    /**
     * Cutting off at 12 dB per octave. One octave is twice the frequency above [cutoffHz], or half
     * the frequency below [cutoffHz].
     */
    FILTER_12DB(1),
    /**
     * Cutting off at 18 dB per octave. One octave is twice the frequency above [cutoffHz], or half
     * the frequency below [cutoffHz].
     */
    FILTER_18DB(2),
    /**
     * Cutting off at 24 dB per octave. One octave is twice the frequency above [cutoffHz], or half
     * the frequency below [cutoffHz].
     */
    FILTER_24DB(3),
    ;

    public companion object {
      public fun from(`value`: Long): FilterDB = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setCutoffName: MethodStringName1<AudioEffectFilter, Unit, Float> =
        MethodStringName1<AudioEffectFilter, Unit, Float>("set_cutoff")

    @JvmField
    public val getCutoffName: MethodStringName0<AudioEffectFilter, Float> =
        MethodStringName0<AudioEffectFilter, Float>("get_cutoff")

    @JvmField
    public val setResonanceName: MethodStringName1<AudioEffectFilter, Unit, Float> =
        MethodStringName1<AudioEffectFilter, Unit, Float>("set_resonance")

    @JvmField
    public val getResonanceName: MethodStringName0<AudioEffectFilter, Float> =
        MethodStringName0<AudioEffectFilter, Float>("get_resonance")

    @JvmField
    public val setGainName: MethodStringName1<AudioEffectFilter, Unit, Float> =
        MethodStringName1<AudioEffectFilter, Unit, Float>("set_gain")

    @JvmField
    public val getGainName: MethodStringName0<AudioEffectFilter, Float> =
        MethodStringName0<AudioEffectFilter, Float>("get_gain")

    @JvmField
    public val setDbName: MethodStringName1<AudioEffectFilter, Unit, FilterDB> =
        MethodStringName1<AudioEffectFilter, Unit, FilterDB>("set_db")

    @JvmField
    public val getDbName: MethodStringName0<AudioEffectFilter, FilterDB> =
        MethodStringName0<AudioEffectFilter, FilterDB>("get_db")
  }

  public object MethodBindings {
    internal val setCutoffPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "set_cutoff", 373806689)

    internal val getCutoffPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "get_cutoff", 1740695150)

    internal val setResonancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "set_resonance", 373806689)

    internal val getResonancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "get_resonance", 1740695150)

    internal val setGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "set_gain", 373806689)

    internal val getGainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "get_gain", 1740695150)

    internal val setDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "set_db", 771740901)

    internal val getDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectFilter", "get_db", 3981721890)
  }
}
