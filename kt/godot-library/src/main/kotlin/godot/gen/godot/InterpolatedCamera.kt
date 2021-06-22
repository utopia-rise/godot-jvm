// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.NodePath
import godot.core.TransferContext
import godot.core.VariantType.BOOL
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.NIL
import godot.core.VariantType.NODE_PATH
import kotlin.Boolean
import kotlin.Double
import kotlin.Suppress
import kotlin.Unit

/**
 * *Deprecated.* Camera which moves toward another node.
 *
 * *Deprecated (will be removed in Godot 4.0).* InterpolatedCamera is a [godot.Camera] which smoothly moves to match a target node's position and rotation.
 *
 * If it is not [enabled] or does not have a valid target set, InterpolatedCamera acts like a normal Camera.
 */
@GodotBaseType
public open class InterpolatedCamera : Camera() {
  /**
   * If `true`, and a target is set, the camera will move automatically.
   */
  public open var enabled: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INTERPOLATEDCAMERA_GET_ENABLED,
          BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INTERPOLATEDCAMERA_SET_ENABLED,
          NIL)
    }

  /**
   * How quickly the camera moves toward its target. Higher values will result in tighter camera motion.
   */
  public open var speed: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INTERPOLATEDCAMERA_GET_SPEED,
          DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(`value`) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INTERPOLATEDCAMERA_SET_SPEED, NIL)
    }

  /**
   * The target's [godot.core.NodePath].
   */
  public open var target: NodePath
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INTERPOLATEDCAMERA_GET_TARGET,
          NODE_PATH)
      return TransferContext.readReturnValue(NODE_PATH, false) as NodePath
    }
    set(`value`) {
      TransferContext.writeArguments(NODE_PATH to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_INTERPOLATEDCAMERA_SET_TARGET,
          NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_INTERPOLATEDCAMERA)
  }
}
