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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.RID
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Abstract base class for all joints in 3D physics. 3D joints bind together two physics bodies
 * ([nodeA] and [nodeB]) and apply a constraint. If only one body is defined, it is attached to a fixed
 * [StaticBody3D] without collision shapes.
 */
@GodotBaseType
public open class Joint3D internal constructor() : Node3D() {
  /**
   * Path to the first node (A) attached to the joint. The node must inherit [PhysicsBody3D].
   *
   * If left empty and [nodeB] is set, the body is attached to a fixed [StaticBody3D] without
   * collision shapes.
   */
  public final inline var nodeA: NodePath
    @JvmName("nodeAProperty")
    get() = getNodeA()
    @JvmName("nodeAProperty")
    set(`value`) {
      setNodeA(value)
    }

  /**
   * Path to the second node (B) attached to the joint. The node must inherit [PhysicsBody3D].
   *
   * If left empty and [nodeA] is set, the body is attached to a fixed [StaticBody3D] without
   * collision shapes.
   */
  public final inline var nodeB: NodePath
    @JvmName("nodeBProperty")
    get() = getNodeB()
    @JvmName("nodeBProperty")
    set(`value`) {
      setNodeB(value)
    }

  /**
   * The priority used to define which solver is executed first for multiple joints. The lower the
   * value, the higher the priority.
   *
   * **Note:** Only supported when using GodotPhysics3D. This property is ignored when using Jolt
   * Physics.
   */
  public final inline var solverPriority: Int
    @JvmName("solverPriorityProperty")
    get() = getSolverPriority()
    @JvmName("solverPriorityProperty")
    set(`value`) {
      setSolverPriority(value)
    }

  /**
   * If `true`, the two bodies bound together do not collide with each other.
   */
  public final inline var excludeNodesFromCollision: Boolean
    @JvmName("excludeNodesFromCollisionProperty")
    get() = getExcludeNodesFromCollision()
    @JvmName("excludeNodesFromCollisionProperty")
    set(`value`) {
      setExcludeNodesFromCollision(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(341, scriptPtr)
  }

  public final fun setNodeA(node: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, node)
    TransferContext.callPtrMethod(MethodBindings.setNodeAPtr, 0)
  }

  public final fun getNodeA(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNodeAPtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setNodeB(node: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, node)
    TransferContext.callPtrMethod(MethodBindings.setNodeBPtr, 0)
  }

  public final fun getNodeB(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNodeBPtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setSolverPriority(priority: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, priority.toLong())
    TransferContext.callPtrMethod(MethodBindings.setSolverPriorityPtr, 0)
  }

  public final fun getSolverPriority(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSolverPriorityPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setExcludeNodesFromCollision(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callPtrMethod(MethodBindings.setExcludeNodesFromCollisionPtr, 0)
  }

  public final fun getExcludeNodesFromCollision(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getExcludeNodesFromCollisionPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the joint's internal [RID] from the [PhysicsServer3D].
   */
  public final fun getRid(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getRidPtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun setNodeA(node: String) = setNodeA(node.asCachedNodePath())

  public final fun setNodeB(node: String) = setNodeB(node.asCachedNodePath())

  public companion object {
    @JvmField
    public val setNodeAName: MethodStringName1<Joint3D, Unit, NodePath> =
        MethodStringName1<Joint3D, Unit, NodePath>("set_node_a")

    @JvmField
    public val getNodeAName: MethodStringName0<Joint3D, NodePath> =
        MethodStringName0<Joint3D, NodePath>("get_node_a")

    @JvmField
    public val setNodeBName: MethodStringName1<Joint3D, Unit, NodePath> =
        MethodStringName1<Joint3D, Unit, NodePath>("set_node_b")

    @JvmField
    public val getNodeBName: MethodStringName0<Joint3D, NodePath> =
        MethodStringName0<Joint3D, NodePath>("get_node_b")

    @JvmField
    public val setSolverPriorityName: MethodStringName1<Joint3D, Unit, Int> =
        MethodStringName1<Joint3D, Unit, Int>("set_solver_priority")

    @JvmField
    public val getSolverPriorityName: MethodStringName0<Joint3D, Int> =
        MethodStringName0<Joint3D, Int>("get_solver_priority")

    @JvmField
    public val setExcludeNodesFromCollisionName: MethodStringName1<Joint3D, Unit, Boolean> =
        MethodStringName1<Joint3D, Unit, Boolean>("set_exclude_nodes_from_collision")

    @JvmField
    public val getExcludeNodesFromCollisionName: MethodStringName0<Joint3D, Boolean> =
        MethodStringName0<Joint3D, Boolean>("get_exclude_nodes_from_collision")

    @JvmField
    public val getRidName: MethodStringName0<Joint3D, RID> =
        MethodStringName0<Joint3D, RID>("get_rid")
  }

  public object MethodBindings {
    internal val setNodeAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "set_node_a", 1348162250)

    internal val getNodeAPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "get_node_a", 4075236667)

    internal val setNodeBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "set_node_b", 1348162250)

    internal val getNodeBPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "get_node_b", 4075236667)

    internal val setSolverPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "set_solver_priority", 1286410249)

    internal val getSolverPriorityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "get_solver_priority", 3905245786)

    internal val setExcludeNodesFromCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "set_exclude_nodes_from_collision", 2586408642)

    internal val getExcludeNodesFromCollisionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Joint3D", "get_exclude_nodes_from_collision", 36873697)

    internal val getRidPtr: VoidPtr = TypeManager.getMethodBindPtr("Joint3D", "get_rid", 2944877500)
  }
}
