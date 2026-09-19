// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod0_ret_RID
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_NODE_PATH
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.RID
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Float
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Abstract base class for all joints in 2D physics. 2D joints bind together two physics bodies
 * ([nodeA] and [nodeB]) and apply a constraint.
 */
@GodotBaseType
public open class Joint2D internal constructor() : Node2D() {
  /**
   * Path to the first body (A) attached to the joint. The node must inherit [PhysicsBody2D].
   */
  public final inline var nodeA: NodePath
    @JvmName("nodeAProperty")
    get() = getNodeA()
    @JvmName("nodeAProperty")
    set(`value`) {
      setNodeA(value)
    }

  /**
   * Path to the second body (B) attached to the joint. The node must inherit [PhysicsBody2D].
   */
  public final inline var nodeB: NodePath
    @JvmName("nodeBProperty")
    get() = getNodeB()
    @JvmName("nodeBProperty")
    set(`value`) {
      setNodeB(value)
    }

  /**
   * When [nodeA] and [nodeB] move in different directions the [bias] controls how fast the joint
   * pulls them back to their original position. The lower the [bias] the more the two bodies can pull
   * on the joint.
   *
   * When set to `0`, the default value from
   * [ProjectSettings.physics/2d/solver/defaultConstraintBias] is used.
   */
  public final inline var bias: Float
    @JvmName("biasProperty")
    get() = getBias()
    @JvmName("biasProperty")
    set(`value`) {
      setBias(value)
    }

  /**
   * If `true`, the two bodies bound together do not collide with each other.
   */
  public final inline var disableCollision: Boolean
    @JvmName("disableCollisionProperty")
    get() = getExcludeNodesFromCollision()
    @JvmName("disableCollisionProperty")
    set(`value`) {
      setExcludeNodesFromCollision(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(340, scriptPtr)
  }

  public final fun setNodeA(node: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setNodeAPtr, node)
  }

  public final fun getNodeA(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getNodeAPtr)

  public final fun setNodeB(node: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setNodeBPtr, node)
  }

  public final fun getNodeB(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getNodeBPtr)

  public final fun setBias(bias: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setBiasPtr, bias.toDouble())
  }

  public final fun getBias(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getBiasPtr).toFloat()

  public final fun setExcludeNodesFromCollision(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setExcludeNodesFromCollisionPtr, enable)
  }

  public final fun getExcludeNodesFromCollision(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getExcludeNodesFromCollisionPtr)

  /**
   * Returns the joint's internal [RID] from the [PhysicsServer2D].
   */
  public final fun getRid(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getRidPtr)

  public final fun setNodeA(node: String) = setNodeA(node.asCachedNodePath())

  public final fun setNodeB(node: String) = setNodeB(node.asCachedNodePath())

  public companion object {
    @JvmField
    public val setNodeAName: MethodStringName1<Joint2D, Unit, NodePath> =
        MethodStringName1<Joint2D, Unit, NodePath>("set_node_a")

    @JvmField
    public val getNodeAName: MethodStringName0<Joint2D, NodePath> =
        MethodStringName0<Joint2D, NodePath>("get_node_a")

    @JvmField
    public val setNodeBName: MethodStringName1<Joint2D, Unit, NodePath> =
        MethodStringName1<Joint2D, Unit, NodePath>("set_node_b")

    @JvmField
    public val getNodeBName: MethodStringName0<Joint2D, NodePath> =
        MethodStringName0<Joint2D, NodePath>("get_node_b")

    @JvmField
    public val setBiasName: MethodStringName1<Joint2D, Unit, Float> =
        MethodStringName1<Joint2D, Unit, Float>("set_bias")

    @JvmField
    public val getBiasName: MethodStringName0<Joint2D, Float> =
        MethodStringName0<Joint2D, Float>("get_bias")

    @JvmField
    public val setExcludeNodesFromCollisionName: MethodStringName1<Joint2D, Unit, Boolean> =
        MethodStringName1<Joint2D, Unit, Boolean>("set_exclude_nodes_from_collision")

    @JvmField
    public val getExcludeNodesFromCollisionName: MethodStringName0<Joint2D, Boolean> =
        MethodStringName0<Joint2D, Boolean>("get_exclude_nodes_from_collision")

    @JvmField
    public val getRidName: MethodStringName0<Joint2D, RID> =
        MethodStringName0<Joint2D, RID>("get_rid")
  }

  public object MethodBindings {
    internal val setNodeAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "set_node_a", 1348162250)

    internal val getNodeAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "get_node_a", 4075236667)

    internal val setNodeBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "set_node_b", 1348162250)

    internal val getNodeBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "get_node_b", 4075236667)

    internal val setBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "set_bias", 373806689)

    internal val getBiasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "get_bias", 1740695150)

    internal val setExcludeNodesFromCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "set_exclude_nodes_from_collision", 2586408642)

    internal val getExcludeNodesFromCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint2D", "get_exclude_nodes_from_collision", 36873697)

    internal val getRidPtr: VoidPtr = TypeManager.getMethodBindPtr("Joint2D", "get_rid", 2944877500)
  }
}
