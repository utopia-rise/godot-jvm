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
 * Adds a panner audio effect to an Audio bus. Pans sound left or right.
 *
 * Determines how much of an audio signal is sent to the left and right buses.
 */
@GodotBaseType
public open class AudioEffectPanner : AudioEffect() {
  /**
   * Pan position. Value can range from -1 (fully left) to 1 (fully right).
   */
  public open var pan: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTPANNER_GET_PAN, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_AUDIOEFFECTPANNER_SET_PAN, NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_AUDIOEFFECTPANNER)
  }
}
