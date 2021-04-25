// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.annotation.CoreTypeHelper
import godot.annotation.GodotBaseType
import godot.core.TransferContext
import godot.core.Transform
import godot.core.VariantType.NIL
import godot.core.VariantType.TRANSFORM
import kotlin.Suppress
import kotlin.Unit

/**
 * A [godot.core.Transform] constant for use within the visual shader graph.
 *
 * A constant [godot.core.Transform], which can be used as an input node.
 */
@GodotBaseType
open class VisualShaderNodeTransformConstant : VisualShaderNode() {
  /**
   * A [godot.core.Transform] constant which represents the state of this node.
   */
  open var constant: Transform
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_VISUALSHADERNODETRANSFORMCONSTANT_GET_CONSTANT, TRANSFORM)
      return TransferContext.readReturnValue(TRANSFORM, false) as Transform
    }
    set(value) {
      TransferContext.writeArguments(TRANSFORM to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_VISUALSHADERNODETRANSFORMCONSTANT_SET_CONSTANT, NIL)
    }

  override fun __new() {
    callConstructor(ENGINECLASS_VISUALSHADERNODETRANSFORMCONSTANT)
  }

  @CoreTypeHelper
  open fun constant(schedule: Transform.() -> Unit): Transform = constant.apply{
      schedule(this)
      constant = this
  }

}
