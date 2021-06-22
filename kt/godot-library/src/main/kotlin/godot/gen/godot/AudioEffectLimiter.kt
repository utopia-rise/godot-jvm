// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.NIL
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit

/**
 * Adds a soft-clip limiter audio effect to an Audio bus.
 *
 * A limiter is similar to a compressor, but it's less flexible and designed to disallow sound going over a given dB threshold. Adding one in the Master bus is always recommended to reduce the effects of clipping.
 *
 * Soft clipping starts to reduce the peaks a little below the threshold level and progressively increases its effect as the input level increases such that the threshold is never exceeded.
 */
@GodotBaseType
public open class AudioEffectLimiter : AudioEffect() {
  /**
   * The waveform's maximum allowed value, in decibels. Value can range from -20 to -0.1.
   */
  public open var ceilingDb: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_GET_CEILING_DB,
          DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_SET_CEILING_DB,
          NIL)
    }

  /**
   * Applies a gain to the limited waves, in decibels. Value can range from 0 to 6.
   */
  public open var softClipDb: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_GET_SOFT_CLIP_DB, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_SET_SOFT_CLIP_DB, NIL)
    }

  /**
   *
   */
  public open var softClipRatio: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_GET_SOFT_CLIP_RATIO, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_SET_SOFT_CLIP_RATIO, NIL)
    }

  /**
   * Threshold from which the limiter begins to be active, in decibels. Value can range from -30 to 0.
   */
  public open var thresholdDb: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_GET_THRESHOLD_DB, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTLIMITER_SET_THRESHOLD_DB, NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_AUDIOEFFECTLIMITER)
  }
}
