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
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.Vector2
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_NODE_PATH
import godot.writeMethodArguments_LONG_VECTOR2
import godot.writeMethodArguments_NODE_PATH
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This [SkeletonModification2D] uses an algorithm called Forward And Backward Reaching Inverse
 * Kinematics, or FABRIK, to rotate a bone chain so that it reaches a target.
 *
 * FABRIK works by knowing the positions and lengths of a series of bones, typically called a "bone
 * chain". It first starts by running a forward pass, which places the final bone at the target's
 * position. Then all other bones are moved towards the tip bone, so they stay at the defined bone
 * length away. Then a backwards pass is performed, where the root/first bone in the FABRIK chain is
 * placed back at the origin. Then all other bones are moved so they stay at the defined bone length
 * away. This positions the bone chain so that it reaches the target when possible, but all of the
 * bones stay the correct length away from each other.
 *
 * Because of how FABRIK works, it often gives more natural results than those seen in
 * [SkeletonModification2DCCDIK].
 *
 * **Note:** The FABRIK modifier has `fabrik_joints`, which are the data objects that hold the data
 * for each joint in the FABRIK chain. This is different from [Bone2D] nodes! FABRIK joints hold the
 * data needed for each [Bone2D] in the bone chain used by FABRIK.
 *
 * To help control how the FABRIK joints move, a magnet vector can be passed, which can nudge the
 * bones in a certain direction prior to solving, giving a level of control over the final result.
 */
@GodotBaseType
public open class SkeletonModification2DFABRIK : SkeletonModification2D() {
  /**
   * The NodePath to the node that is the target for the FABRIK modification. This node is what the
   * FABRIK chain will attempt to rotate the bone chain to.
   */
  public final inline var targetNodepath: NodePath
    @JvmName("targetNodepathProperty")
    get() = getTargetNode()
    @JvmName("targetNodepathProperty")
    set(`value`) {
      setTargetNode(value)
    }

  /**
   * The number of FABRIK joints in the FABRIK modification.
   */
  public final inline var fabrikDataChainLength: Int
    @JvmName("fabrikDataChainLengthProperty")
    get() = getFabrikDataChainLength()
    @JvmName("fabrikDataChainLengthProperty")
    set(`value`) {
      setFabrikDataChainLength(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(669, scriptPtr)
  }

  public final fun setTargetNode(targetNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, targetNodepath)
    TransferContext.callMethod(MethodBindings.setTargetNodePtr)
  }

  public final fun getTargetNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setFabrikDataChainLength(length: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, length.toLong())
    TransferContext.callMethod(MethodBindings.setFabrikDataChainLengthPtr)
  }

  public final fun getFabrikDataChainLength(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFabrikDataChainLengthPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the [Bone2D] node assigned to the FABRIK joint at [jointIdx].
   */
  public final fun setFabrikJointBone2dNode(jointIdx: Int, bone2dNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_LONG_NODE_PATH(ptr, objectID.id, jointIdx.toLong(), bone2dNodepath)
    TransferContext.callMethod(MethodBindings.setFabrikJointBone2dNodePtr)
  }

  /**
   * Returns the [Bone2D] node assigned to the FABRIK joint at [jointIdx].
   */
  public final fun getFabrikJointBone2dNode(jointIdx: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getFabrikJointBone2dNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the bone index, [boneIdx], of the FABRIK joint at [jointIdx]. When possible, this will
   * also update the `bone2d_node` of the FABRIK joint based on data provided by the linked skeleton.
   */
  public final fun setFabrikJointBoneIndex(jointIdx: Int, boneIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, jointIdx.toLong(), boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.setFabrikJointBoneIndexPtr)
  }

  /**
   * Returns the index of the [Bone2D] node assigned to the FABRIK joint at [jointIdx].
   */
  public final fun getFabrikJointBoneIndex(jointIdx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getFabrikJointBoneIndexPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the magnet position vector for the joint at [jointIdx].
   */
  public final fun setFabrikJointMagnetPosition(jointIdx: Int, magnetPosition: Vector2): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR2(ptr, objectID.id, jointIdx.toLong(), magnetPosition)
    TransferContext.callMethod(MethodBindings.setFabrikJointMagnetPositionPtr)
  }

  /**
   * Returns the magnet position vector for the joint at [jointIdx].
   */
  public final fun getFabrikJointMagnetPosition(jointIdx: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getFabrikJointMagnetPositionPtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Sets whether the joint at [jointIdx] will use the target node's rotation rather than letting
   * FABRIK rotate the node.
   *
   * **Note:** This option only works for the tip/final joint in the chain. For all other nodes,
   * this option will be ignored.
   */
  public final fun setFabrikJointUseTargetRotation(jointIdx: Int, useTargetRotation: Boolean):
      Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, jointIdx.toLong(), useTargetRotation)
    TransferContext.callMethod(MethodBindings.setFabrikJointUseTargetRotationPtr)
  }

  /**
   * Returns whether the joint is using the target's rotation rather than allowing FABRIK to rotate
   * the joint. This option only applies to the tip/final joint in the chain.
   */
  public final fun getFabrikJointUseTargetRotation(jointIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callMethod(MethodBindings.getFabrikJointUseTargetRotationPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTargetNode(targetNodepath: String) =
      setTargetNode(targetNodepath.asCachedNodePath())

  /**
   * Sets the [Bone2D] node assigned to the FABRIK joint at [jointIdx].
   */
  public final fun setFabrikJointBone2dNode(jointIdx: Int, bone2dNodepath: String) =
      setFabrikJointBone2dNode(jointIdx, bone2dNodepath.asCachedNodePath())

  public companion object {
    @JvmField
    public val setTargetNodeName: MethodStringName1<SkeletonModification2DFABRIK, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DFABRIK, Unit, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName0<SkeletonModification2DFABRIK, NodePath> =
        MethodStringName0<SkeletonModification2DFABRIK, NodePath>("get_target_node")

    @JvmField
    public val setFabrikDataChainLengthName:
        MethodStringName1<SkeletonModification2DFABRIK, Unit, Int> =
        MethodStringName1<SkeletonModification2DFABRIK, Unit, Int>("set_fabrik_data_chain_length")

    @JvmField
    public val getFabrikDataChainLengthName: MethodStringName0<SkeletonModification2DFABRIK, Int> =
        MethodStringName0<SkeletonModification2DFABRIK, Int>("get_fabrik_data_chain_length")

    @JvmField
    public val setFabrikJointBone2dNodeName:
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, NodePath> =
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, NodePath>("set_fabrik_joint_bone2d_node")

    @JvmField
    public val getFabrikJointBone2dNodeName:
        MethodStringName1<SkeletonModification2DFABRIK, NodePath, Int> =
        MethodStringName1<SkeletonModification2DFABRIK, NodePath, Int>("get_fabrik_joint_bone2d_node")

    @JvmField
    public val setFabrikJointBoneIndexName:
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, Int> =
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, Int>("set_fabrik_joint_bone_index")

    @JvmField
    public val getFabrikJointBoneIndexName:
        MethodStringName1<SkeletonModification2DFABRIK, Int, Int> =
        MethodStringName1<SkeletonModification2DFABRIK, Int, Int>("get_fabrik_joint_bone_index")

    @JvmField
    public val setFabrikJointMagnetPositionName:
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, Vector2> =
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, Vector2>("set_fabrik_joint_magnet_position")

    @JvmField
    public val getFabrikJointMagnetPositionName:
        MethodStringName1<SkeletonModification2DFABRIK, Vector2, Int> =
        MethodStringName1<SkeletonModification2DFABRIK, Vector2, Int>("get_fabrik_joint_magnet_position")

    @JvmField
    public val setFabrikJointUseTargetRotationName:
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, Boolean> =
        MethodStringName2<SkeletonModification2DFABRIK, Unit, Int, Boolean>("set_fabrik_joint_use_target_rotation")

    @JvmField
    public val getFabrikJointUseTargetRotationName:
        MethodStringName1<SkeletonModification2DFABRIK, Boolean, Int> =
        MethodStringName1<SkeletonModification2DFABRIK, Boolean, Int>("get_fabrik_joint_use_target_rotation")
  }

  public object MethodBindings {
    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "set_target_node", 1348162250)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "get_target_node", 4075236667)

    internal val setFabrikDataChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "set_fabrik_data_chain_length", 1286410249)

    internal val getFabrikDataChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "get_fabrik_data_chain_length", 2455072627)

    internal val setFabrikJointBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "set_fabrik_joint_bone2d_node", 2761262315)

    internal val getFabrikJointBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "get_fabrik_joint_bone2d_node", 408788394)

    internal val setFabrikJointBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "set_fabrik_joint_bone_index", 3937882851)

    internal val getFabrikJointBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "get_fabrik_joint_bone_index", 923996154)

    internal val setFabrikJointMagnetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "set_fabrik_joint_magnet_position", 163021252)

    internal val getFabrikJointMagnetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "get_fabrik_joint_magnet_position", 2299179447)

    internal val setFabrikJointUseTargetRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "set_fabrik_joint_use_target_rotation", 300928843)

    internal val getFabrikJointUseTargetRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DFABRIK", "get_fabrik_joint_use_target_rotation", 1116898809)
  }
}
