// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import godot.signals.Signal0
import godot.signals.signal
import kotlin.Suppress
import kotlin.Unit

/**
 * Contains a [godot.Curve3D] path for [godot.PathFollow] nodes to follow.
 *
 * Can have [godot.PathFollow] child nodes moving along the [godot.Curve3D]. See [godot.PathFollow] for more information on the usage.
 *
 * Note that the path is considered as relative to the moved nodes (children of [godot.PathFollow]). As such, the curve should usually start with a zero vector `(0, 0, 0)`.
 */
@GodotBaseType
public open class Path : Spatial() {
  /**
   * Emitted when the [curve] changes.
   */
  public val curveChanged: Signal0 by signal()

  /**
   * A [godot.Curve3D] describing the path.
   */
  public open var curve: Curve3D?
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_PATH_GET_CURVE, OBJECT)
      return TransferContext.readReturnValue(OBJECT, true) as Curve3D?
    }
    set(`value`) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_PATH_SET_CURVE, NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_PATH)
  }

  public open fun _curveChanged(): Unit {
  }
}
