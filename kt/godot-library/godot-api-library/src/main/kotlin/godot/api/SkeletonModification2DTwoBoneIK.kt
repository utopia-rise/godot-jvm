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
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_NODE_PATH
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_NODE_PATH
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.asCachedNodePath
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This [SkeletonModification2D] uses an algorithm typically called TwoBoneIK. This algorithm works
 * by leveraging the law of cosines and the lengths of the bones to figure out what rotation the bones
 * currently have, and what rotation they need to make a complete triangle, where the first bone, the
 * second bone, and the target form the three vertices of the triangle. Because the algorithm works by
 * making a triangle, it can only operate on two bones.
 *
 * TwoBoneIK is great for arms, legs, and really any joints that can be represented by just two
 * bones that bend to reach a target. This solver is more lightweight than
 * [SkeletonModification2DFABRIK], but gives similar, natural looking results.
 */
@GodotBaseType
public open class SkeletonModification2DTwoBoneIK : SkeletonModification2D() {
  /**
   * The NodePath to the node that is the target for the TwoBoneIK modification. This node is what
   * the modification will use when bending the [Bone2D] nodes.
   */
  public final inline var targetNodepath: NodePath
    @JvmName("targetNodepathProperty")
    get() = getTargetNode()
    @JvmName("targetNodepathProperty")
    set(`value`) {
      setTargetNode(value)
    }

  /**
   * The minimum distance the target can be at. If the target is closer than this distance, the
   * modification will solve as if it's at this minimum distance. When set to `0`, the modification
   * will solve without distance constraints.
   */
  public final inline var targetMinimumDistance: Float
    @JvmName("targetMinimumDistanceProperty")
    get() = getTargetMinimumDistance()
    @JvmName("targetMinimumDistanceProperty")
    set(`value`) {
      setTargetMinimumDistance(value)
    }

  /**
   * The maximum distance the target can be at. If the target is farther than this distance, the
   * modification will solve as if it's at this maximum distance. When set to `0`, the modification
   * will solve without distance constraints.
   */
  public final inline var targetMaximumDistance: Float
    @JvmName("targetMaximumDistanceProperty")
    get() = getTargetMaximumDistance()
    @JvmName("targetMaximumDistanceProperty")
    set(`value`) {
      setTargetMaximumDistance(value)
    }

  /**
   * If `true`, the bones in the modification will bend outward as opposed to inwards when
   * contracting. If `false`, the bones will bend inwards when contracting.
   */
  public final inline var flipBendDirection: Boolean
    @JvmName("flipBendDirectionProperty")
    get() = getFlipBendDirection()
    @JvmName("flipBendDirectionProperty")
    set(`value`) {
      setFlipBendDirection(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(674, scriptPtr)
  }

  public final fun setTargetNode(targetNodepath: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setTargetNodePtr, targetNodepath)
  }

  public final fun getTargetNode(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getTargetNodePtr)

  public final fun setTargetMinimumDistance(minimumDistance: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTargetMinimumDistancePtr, minimumDistance.toDouble())
  }

  public final fun getTargetMinimumDistance(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTargetMinimumDistancePtr).toFloat()

  public final fun setTargetMaximumDistance(maximumDistance: Float): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTargetMaximumDistancePtr, maximumDistance.toDouble())
  }

  public final fun getTargetMaximumDistance(): Float =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTargetMaximumDistancePtr).toFloat()

  public final fun setFlipBendDirection(flipDirection: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setFlipBendDirectionPtr, flipDirection)
  }

  public final fun getFlipBendDirection(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getFlipBendDirectionPtr)

  /**
   * Sets the [Bone2D] node that is being used as the first bone in the TwoBoneIK modification.
   */
  public final fun setJointOneBone2dNode(bone2dNode: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setJointOneBone2dNodePtr, bone2dNode)
  }

  /**
   * Returns the [Bone2D] node that is being used as the first bone in the TwoBoneIK modification.
   */
  public final fun getJointOneBone2dNode(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getJointOneBone2dNodePtr)

  /**
   * Sets the index of the [Bone2D] node that is being used as the first bone in the TwoBoneIK
   * modification.
   */
  public final fun setJointOneBoneIdx(boneIdx: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setJointOneBoneIdxPtr, boneIdx.toLong())
  }

  /**
   * Returns the index of the [Bone2D] node that is being used as the first bone in the TwoBoneIK
   * modification.
   */
  public final fun getJointOneBoneIdx(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getJointOneBoneIdxPtr).toInt()

  /**
   * Sets the [Bone2D] node that is being used as the second bone in the TwoBoneIK modification.
   */
  public final fun setJointTwoBone2dNode(bone2dNode: NodePath): Unit {
    TransferContext.callPtrMethod_NODE_PATH(ptr, objectID.id, MethodBindings.setJointTwoBone2dNodePtr, bone2dNode)
  }

  /**
   * Returns the [Bone2D] node that is being used as the second bone in the TwoBoneIK modification.
   */
  public final fun getJointTwoBone2dNode(): NodePath =
      TransferContext.callPtrMethod0_ret_NODE_PATH(ptr, objectID.id, MethodBindings.getJointTwoBone2dNodePtr)

  /**
   * Sets the index of the [Bone2D] node that is being used as the second bone in the TwoBoneIK
   * modification.
   */
  public final fun setJointTwoBoneIdx(boneIdx: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setJointTwoBoneIdxPtr, boneIdx.toLong())
  }

  /**
   * Returns the index of the [Bone2D] node that is being used as the second bone in the TwoBoneIK
   * modification.
   */
  public final fun getJointTwoBoneIdx(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getJointTwoBoneIdxPtr).toInt()

  public final fun setTargetNode(targetNodepath: String) =
      setTargetNode(targetNodepath.asCachedNodePath())

  /**
   * Sets the [Bone2D] node that is being used as the first bone in the TwoBoneIK modification.
   */
  public final fun setJointOneBone2dNode(bone2dNode: String) =
      setJointOneBone2dNode(bone2dNode.asCachedNodePath())

  /**
   * Sets the [Bone2D] node that is being used as the second bone in the TwoBoneIK modification.
   */
  public final fun setJointTwoBone2dNode(bone2dNode: String) =
      setJointTwoBone2dNode(bone2dNode.asCachedNodePath())

  public companion object {
    @JvmField
    public val setTargetNodeName: MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, NodePath>
        = MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName0<SkeletonModification2DTwoBoneIK, NodePath> =
        MethodStringName0<SkeletonModification2DTwoBoneIK, NodePath>("get_target_node")

    @JvmField
    public val setTargetMinimumDistanceName:
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Float> =
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Float>("set_target_minimum_distance")

    @JvmField
    public val getTargetMinimumDistanceName:
        MethodStringName0<SkeletonModification2DTwoBoneIK, Float> =
        MethodStringName0<SkeletonModification2DTwoBoneIK, Float>("get_target_minimum_distance")

    @JvmField
    public val setTargetMaximumDistanceName:
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Float> =
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Float>("set_target_maximum_distance")

    @JvmField
    public val getTargetMaximumDistanceName:
        MethodStringName0<SkeletonModification2DTwoBoneIK, Float> =
        MethodStringName0<SkeletonModification2DTwoBoneIK, Float>("get_target_maximum_distance")

    @JvmField
    public val setFlipBendDirectionName:
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Boolean> =
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Boolean>("set_flip_bend_direction")

    @JvmField
    public val getFlipBendDirectionName: MethodStringName0<SkeletonModification2DTwoBoneIK, Boolean>
        = MethodStringName0<SkeletonModification2DTwoBoneIK, Boolean>("get_flip_bend_direction")

    @JvmField
    public val setJointOneBone2dNodeName:
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, NodePath>("set_joint_one_bone2d_node")

    @JvmField
    public val getJointOneBone2dNodeName:
        MethodStringName0<SkeletonModification2DTwoBoneIK, NodePath> =
        MethodStringName0<SkeletonModification2DTwoBoneIK, NodePath>("get_joint_one_bone2d_node")

    @JvmField
    public val setJointOneBoneIdxName: MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Int>
        = MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Int>("set_joint_one_bone_idx")

    @JvmField
    public val getJointOneBoneIdxName: MethodStringName0<SkeletonModification2DTwoBoneIK, Int> =
        MethodStringName0<SkeletonModification2DTwoBoneIK, Int>("get_joint_one_bone_idx")

    @JvmField
    public val setJointTwoBone2dNodeName:
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, NodePath>("set_joint_two_bone2d_node")

    @JvmField
    public val getJointTwoBone2dNodeName:
        MethodStringName0<SkeletonModification2DTwoBoneIK, NodePath> =
        MethodStringName0<SkeletonModification2DTwoBoneIK, NodePath>("get_joint_two_bone2d_node")

    @JvmField
    public val setJointTwoBoneIdxName: MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Int>
        = MethodStringName1<SkeletonModification2DTwoBoneIK, Unit, Int>("set_joint_two_bone_idx")

    @JvmField
    public val getJointTwoBoneIdxName: MethodStringName0<SkeletonModification2DTwoBoneIK, Int> =
        MethodStringName0<SkeletonModification2DTwoBoneIK, Int>("get_joint_two_bone_idx")
  }

  public object MethodBindings {
    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_target_node", 1348162250)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_target_node", 4075236667)

    internal val setTargetMinimumDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_target_minimum_distance", 373806689)

    internal val getTargetMinimumDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_target_minimum_distance", 1740695150)

    internal val setTargetMaximumDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_target_maximum_distance", 373806689)

    internal val getTargetMaximumDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_target_maximum_distance", 1740695150)

    internal val setFlipBendDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_flip_bend_direction", 2586408642)

    internal val getFlipBendDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_flip_bend_direction", 36873697)

    internal val setJointOneBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_joint_one_bone2d_node", 1348162250)

    internal val getJointOneBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_joint_one_bone2d_node", 4075236667)

    internal val setJointOneBoneIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_joint_one_bone_idx", 1286410249)

    internal val getJointOneBoneIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_joint_one_bone_idx", 3905245786)

    internal val setJointTwoBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_joint_two_bone2d_node", 1348162250)

    internal val getJointTwoBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_joint_two_bone2d_node", 4075236667)

    internal val setJointTwoBoneIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "set_joint_two_bone_idx", 1286410249)

    internal val getJointTwoBoneIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DTwoBoneIK", "get_joint_two_bone_idx", 3905245786)
  }
}
