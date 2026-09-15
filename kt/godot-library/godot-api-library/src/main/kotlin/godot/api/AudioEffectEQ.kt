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
import godot.core.MethodStringName2
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import kotlin.Float
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * An "equalizer" gives you control over the gain of frequencies in the entire spectrum, by allowing
 * their adjustment through bands. A band is a point in the frequency spectrum, and each band means a
 * division of the spectrum that can be adjusted.
 *
 * Use equalizers to compensate for existing deficiencies in the audio, make room for other
 * elements, or remove undesirable frequencies. AudioEffectEQs are useful on the Master bus to balance
 * the entire mix or give it more character. They are also useful when a game is run on a mobile
 * device, to adjust the mix to that kind of speakers (it can be disabled when headphones are plugged
 * in).
 */
@GodotBaseType
public open class AudioEffectEQ : AudioEffect() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(55, scriptPtr)
  }

  /**
   * Sets band's gain at the specified index, in dB.
   */
  public final fun setBandGainDb(bandIdx: Int, volumeDb: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, bandIdx.toLong(), volumeDb.toDouble())
    TransferContext.callMethod(MethodBindings.setBandGainDbPtr)
  }

  /**
   * Returns the band's gain at the specified index, in dB.
   */
  public final fun getBandGainDb(bandIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bandIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBandGainDbPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the number of bands of the equalizer.
   */
  public final fun getBandCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBandCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Virtual method inherited from base class implemented in non-JVM code. Don't call it.
   */
  public override fun _instantiate(): AudioEffectInstance? {
    throw NotImplementedError("AudioEffectEQ::_instantiate can't be called from the JVM.")
  }

  public companion object {
    @JvmField
    public val setBandGainDbName: MethodStringName2<AudioEffectEQ, Unit, Int, Float> =
        MethodStringName2<AudioEffectEQ, Unit, Int, Float>("set_band_gain_db")

    @JvmField
    public val getBandGainDbName: MethodStringName1<AudioEffectEQ, Float, Int> =
        MethodStringName1<AudioEffectEQ, Float, Int>("get_band_gain_db")

    @JvmField
    public val getBandCountName: MethodStringName0<AudioEffectEQ, Int> =
        MethodStringName0<AudioEffectEQ, Int>("get_band_count")
  }

  public object MethodBindings {
    internal val setBandGainDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectEQ", "set_band_gain_db", 1602489585)

    internal val getBandGainDbPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectEQ", "get_band_gain_db", 2339986948)

    internal val getBandCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectEQ", "get_band_count", 3905245786)
  }
}
