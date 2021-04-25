// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.annotation.GodotBaseType
import godot.core.TransferContext
import godot.core.VariantType.BOOL
import godot.core.VariantType.DOUBLE
import godot.core.VariantType.NIL
import godot.core.VariantType.OBJECT
import kotlin.Boolean
import kotlin.Double
import kotlin.Suppress

/**
 * Node that represents collision shape data in 2D space.
 *
 * Tutorials:
 * [https://docs.godotengine.org/en/latest/tutorials/physics/physics_introduction.html](https://docs.godotengine.org/en/latest/tutorials/physics/physics_introduction.html)
 *
 * Editor facility for creating and editing collision shapes in 2D space. You can use this node to represent all sorts of collision shapes, for example, add this to an [godot.Area2D] to give it a detection shape, or add it to a [godot.PhysicsBody2D] to create a solid object. **IMPORTANT**: this is an Editor-only helper to create shapes, use [godot.CollisionObject2D.shapeOwnerGetShape] to get the actual shape.
 */
@GodotBaseType
open class CollisionShape2D : Node2D() {
  /**
   * A disabled collision shape has no effect in the world. This property should be changed with [godot.Object.setDeferred].
   */
  open var disabled: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_GET_DISABLED,
          BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(value) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_SET_DISABLED,
          NIL)
    }

  /**
   * Sets whether this collision shape should only detect collision on one side (top or bottom).
   */
  open var oneWayCollision: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_GET_ONE_WAY_COLLISION, BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(value) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_SET_ONE_WAY_COLLISION, NIL)
    }

  /**
   * The margin used for one-way collision (in pixels). Higher values will make the shape thicker, and work better for colliders that enter the shape at a high velocity.
   */
  open var oneWayCollisionMargin: Double
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_GET_ONE_WAY_COLLISION_MARGIN, DOUBLE)
      return TransferContext.readReturnValue(DOUBLE, false) as Double
    }
    set(value) {
      TransferContext.writeArguments(DOUBLE to value)
      TransferContext.callMethod(rawPtr,
          ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_SET_ONE_WAY_COLLISION_MARGIN, NIL)
    }

  /**
   * The actual shape owned by this collision shape.
   */
  open var shape: Shape2D?
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_GET_SHAPE,
          OBJECT)
      return TransferContext.readReturnValue(OBJECT, true) as Shape2D?
    }
    set(value) {
      TransferContext.writeArguments(OBJECT to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_COLLISIONSHAPE2D_SET_SHAPE, NIL)
    }

  override fun __new() {
    callConstructor(ENGINECLASS_COLLISIONSHAPE2D)
  }

  open fun _shapeChanged() {
  }
}
