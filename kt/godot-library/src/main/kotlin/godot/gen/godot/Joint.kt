// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE")

package godot

import godot.`annotation`.GodotBaseType
import godot.core.NodePath
import godot.core.TransferContext
import godot.core.VariantType.BOOL
import godot.core.VariantType.LONG
import godot.core.VariantType.NIL
import godot.core.VariantType.NODE_PATH
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit

/**
 * Base class for all 3D joints.
 *
 * Tutorials:
 * [https://godotengine.org/asset-library/asset/524](https://godotengine.org/asset-library/asset/524)
 *
 * Joints are used to bind together two physics bodies. They have a solver priority and can define if the bodies of the two attached nodes should be able to collide with each other.
 */
@GodotBaseType
public open class Joint : Spatial() {
  public open var collision_excludeNodes: Boolean
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_GET_COLLISION_EXCLUDE_NODES,
          BOOL)
      return TransferContext.readReturnValue(BOOL, false) as Boolean
    }
    set(`value`) {
      TransferContext.writeArguments(BOOL to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_SET_COLLISION_EXCLUDE_NODES,
          NIL)
    }

  public open var nodes_nodeA: NodePath
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_GET_NODES_NODE_A, NODE_PATH)
      return TransferContext.readReturnValue(NODE_PATH, false) as NodePath
    }
    set(`value`) {
      TransferContext.writeArguments(NODE_PATH to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_SET_NODES_NODE_A, NIL)
    }

  public open var nodes_nodeB: NodePath
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_GET_NODES_NODE_B, NODE_PATH)
      return TransferContext.readReturnValue(NODE_PATH, false) as NodePath
    }
    set(`value`) {
      TransferContext.writeArguments(NODE_PATH to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_SET_NODES_NODE_B, NIL)
    }

  public open var solver_priority: Long
    get() {
      TransferContext.writeArguments()
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_GET_SOLVER_PRIORITY, LONG)
      return TransferContext.readReturnValue(LONG, false) as Long
    }
    set(`value`) {
      TransferContext.writeArguments(LONG to value)
      TransferContext.callMethod(rawPtr, ENGINEMETHOD_ENGINECLASS_JOINT_SET_SOLVER_PRIORITY, NIL)
    }

  public override fun __new(): Unit {
    callConstructor(ENGINECLASS_JOINT)
  }

  public open fun _bodyExitTree(): Unit {
  }
}
