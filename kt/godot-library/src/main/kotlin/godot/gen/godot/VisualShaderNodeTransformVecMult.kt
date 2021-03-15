// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName")

package godot

import godot.annotation.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.util.VoidPtr
import kotlin.Long
import kotlin.Suppress

/**
 * Multiplies a [godot.core.Transform] and a [godot.core.Vector3] within the visual shader graph.
 *
 * A multiplication operation on a transform (4x4 matrix) and a vector, with support for different multiplication operators.
 */
@GodotBaseType
open class VisualShaderNodeTransformVecMult : VisualShaderNode() {
  /**
   * The multiplication type to be performed. See [enum Operator] for options.
   */
  open var operator: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_VISUALSHADERNODETRANSFORMVECMULT_GET_OPERATOR, LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(value) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_VISUALSHADERNODETRANSFORMVECMULT_SET_OPERATOR, NIL)
    }

  override fun __new(): VoidPtr =
      TransferContext.invokeConstructor(ENGINECLASS_VISUALSHADERNODETRANSFORMVECMULT)

  enum class Operator(
    id: Long
  ) {
    /**
     * Multiplies transform `a` by the vector `b`.
     */
    OP_AxB(0),

    /**
     * Multiplies vector `b` by the transform `a`.
     */
    OP_BxA(1),

    /**
     * Multiplies transform `a` by the vector `b`, skipping the last row and column of the transform.
     */
    OP_3x3_AxB(2),

    /**
     * Multiplies vector `b` by the transform `a`, skipping the last row and column of the transform.
     */
    OP_3x3_BxA(3);

    val id: Long
    init {
      this.id = id
    }

    companion object {
      fun from(value: Long) = values().single { it.id == value }
    }
  }

  companion object {
    /**
     * Multiplies transform `a` by the vector `b`, skipping the last row and column of the transform.
     */
    final const val OP_3x3_AxB: Long = 2

    /**
     * Multiplies vector `b` by the transform `a`, skipping the last row and column of the transform.
     */
    final const val OP_3x3_BxA: Long = 3

    /**
     * Multiplies transform `a` by the vector `b`.
     */
    final const val OP_AxB: Long = 0

    /**
     * Multiplies vector `b` by the transform `a`.
     */
    final const val OP_BxA: Long = 1
  }
}
