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
import godot.core.MethodStringName3
import godot.core.Vector2
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments_DOUBLE_DOUBLE_LONG
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * The runtime part of an [AudioEffectSpectrumAnalyzer], which can be used to query the magnitude of
 * a frequency range on its host bus.
 *
 * An instance of this class can be obtained with [AudioServer.getBusEffectInstance].
 */
@GodotBaseType
public open class AudioEffectSpectrumAnalyzerInstance internal constructor() : AudioEffectInstance()
    {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(74, scriptPtr)
  }

  /**
   * Returns the magnitude of the frequencies from [fromHz] to [toHz] in linear energy as a Vector2.
   * The `x` component of the return value represents the left stereo channel, and `y` represents the
   * right channel.
   *
   * [mode] determines how the frequency range will be processed.
   */
  @JvmOverloads
  public final fun getMagnitudeForFrequencyRange(
    fromHz: Float,
    toHz: Float,
    mode: MagnitudeMode = AudioEffectSpectrumAnalyzerInstance.MagnitudeMode.MAX,
  ): Vector2 {
    TransferContext.writeMethodArguments_DOUBLE_DOUBLE_LONG(ptr, objectID.id, fromHz.toDouble(), toHz.toDouble(), mode.value)
    TransferContext.callPtrMethod(MethodBindings.getMagnitudeForFrequencyRangePtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  public enum class MagnitudeMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Use the average value across the frequency range as magnitude.
     */
    AVERAGE(0),
    /**
     * Use the maximum value of the frequency range as magnitude.
     */
    MAX(1),
    ;

    public companion object {
      public fun from(`value`: Long): MagnitudeMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getMagnitudeForFrequencyRangeName:
        MethodStringName3<AudioEffectSpectrumAnalyzerInstance, Vector2, Float, Float, MagnitudeMode>
        =
        MethodStringName3<AudioEffectSpectrumAnalyzerInstance, Vector2, Float, Float, MagnitudeMode>("get_magnitude_for_frequency_range")
  }

  public object MethodBindings {
    internal val getMagnitudeForFrequencyRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AudioEffectSpectrumAnalyzerInstance", "get_magnitude_for_frequency_range", 797993915)
  }
}
