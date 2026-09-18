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
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_NODE_PATH
import godot.writeMethodArguments_NODE_PATH
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This [SkeletonModification2D] uses an algorithm called Cyclic Coordinate Descent Inverse
 * Kinematics, or CCDIK, to manipulate a chain of bones in a [Skeleton2D] so it reaches a defined
 * target.
 *
 * CCDIK works by rotating a set of bones, typically called a "bone chain", on a single axis. Each
 * bone is rotated to face the target from the tip (by default), which over a chain of bones allow it
 * to rotate properly to reach the target. Because the bones only rotate on a single axis, CCDIK *can*
 * look more robotic than other IK solvers.
 *
 * **Note:** The CCDIK modifier has `ccdik_joints`, which are the data objects that hold the data
 * for each joint in the CCDIK chain. This is different from a bone! CCDIK joints hold the data needed
 * for each bone in the bone chain used by CCDIK.
 *
 * CCDIK also fully supports angle constraints, allowing for more control over how a solution is
 * met.
 */
@GodotBaseType
public open class SkeletonModification2DCCDIK : SkeletonModification2D() {
  /**
   * The NodePath to the node that is the target for the CCDIK modification. This node is what the
   * CCDIK chain will attempt to rotate the bone chain to.
   */
  public final inline var targetNodepath: NodePath
    @JvmName("targetNodepathProperty")
    get() = getTargetNode()
    @JvmName("targetNodepathProperty")
    set(`value`) {
      setTargetNode(value)
    }

  /**
   * The end position of the CCDIK chain. Typically, this should be a child of a [Bone2D] node
   * attached to the final [Bone2D] in the CCDIK chain.
   */
  public final inline var tipNodepath: NodePath
    @JvmName("tipNodepathProperty")
    get() = getTipNode()
    @JvmName("tipNodepathProperty")
    set(`value`) {
      setTipNode(value)
    }

  /**
   * The number of CCDIK joints in the CCDIK modification.
   */
  public final inline var ccdikDataChainLength: Int
    @JvmName("ccdikDataChainLengthProperty")
    get() = getCcdikDataChainLength()
    @JvmName("ccdikDataChainLengthProperty")
    set(`value`) {
      setCcdikDataChainLength(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(668, scriptPtr)
  }

  public final fun setTargetNode(targetNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, targetNodepath)
    TransferContext.callPtrMethod(MethodBindings.setTargetNodePtr, 0)
  }

  public final fun getTargetNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTargetNodePtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setTipNode(tipNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, tipNodepath)
    TransferContext.callPtrMethod(MethodBindings.setTipNodePtr, 0)
  }

  public final fun getTipNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTipNodePtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setCcdikDataChainLength(length: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, length.toLong())
    TransferContext.callPtrMethod(MethodBindings.setCcdikDataChainLengthPtr, 0)
  }

  public final fun getCcdikDataChainLength(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getCcdikDataChainLengthPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the [Bone2D] node assigned to the CCDIK joint at [jointIdx].
   */
  public final fun setCcdikJointBone2dNode(jointIdx: Int, bone2dNodepath: NodePath): Unit {
    TransferContext.writeMethodArguments_LONG_NODE_PATH(ptr, objectID.id, jointIdx.toLong(), bone2dNodepath)
    TransferContext.callPtrMethod(MethodBindings.setCcdikJointBone2dNodePtr, 0)
  }

  /**
   * Returns the [Bone2D] node assigned to the CCDIK joint at [jointIdx].
   */
  public final fun getCcdikJointBone2dNode(jointIdx: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCcdikJointBone2dNodePtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the bone index, [boneIdx], of the CCDIK joint at [jointIdx]. When possible, this will also
   * update the `bone2d_node` of the CCDIK joint based on data provided by the linked skeleton.
   */
  public final fun setCcdikJointBoneIndex(jointIdx: Int, boneIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, jointIdx.toLong(), boneIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.setCcdikJointBoneIndexPtr, 0)
  }

  /**
   * Returns the index of the [Bone2D] node assigned to the CCDIK joint at [jointIdx].
   */
  public final fun getCcdikJointBoneIndex(jointIdx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCcdikJointBoneIndexPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets whether the joint at [jointIdx] is set to rotate from the joint, `true`, or to rotate from
   * the tip, `false`.
   */
  public final fun setCcdikJointRotateFromJoint(jointIdx: Int, rotateFromJoint: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, jointIdx.toLong(), rotateFromJoint)
    TransferContext.callPtrMethod(MethodBindings.setCcdikJointRotateFromJointPtr, 0)
  }

  /**
   * Returns whether the joint at [jointIdx] is set to rotate from the joint, `true`, or to rotate
   * from the tip, `false`. The default is to rotate from the tip.
   */
  public final fun getCcdikJointRotateFromJoint(jointIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCcdikJointRotateFromJointPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Determines whether angle constraints on the CCDIK joint at [jointIdx] are enabled. When `true`,
   * constraints will be enabled and taken into account when solving.
   */
  public final fun setCcdikJointEnableConstraint(jointIdx: Int, enableConstraint: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, jointIdx.toLong(), enableConstraint)
    TransferContext.callPtrMethod(MethodBindings.setCcdikJointEnableConstraintPtr, 0)
  }

  /**
   * Returns whether angle constraints on the CCDIK joint at [jointIdx] are enabled.
   */
  public final fun getCcdikJointEnableConstraint(jointIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCcdikJointEnableConstraintPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the minimum angle constraint for the joint at [jointIdx].
   */
  public final fun setCcdikJointConstraintAngleMin(jointIdx: Int, angleMin: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, jointIdx.toLong(), angleMin.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCcdikJointConstraintAngleMinPtr, 0)
  }

  /**
   * Returns the minimum angle constraint for the joint at [jointIdx].
   */
  public final fun getCcdikJointConstraintAngleMin(jointIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCcdikJointConstraintAngleMinPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the maximum angle constraint for the joint at [jointIdx].
   */
  public final fun setCcdikJointConstraintAngleMax(jointIdx: Int, angleMax: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, jointIdx.toLong(), angleMax.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setCcdikJointConstraintAngleMaxPtr, 0)
  }

  /**
   * Returns the maximum angle constraint for the joint at [jointIdx].
   */
  public final fun getCcdikJointConstraintAngleMax(jointIdx: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCcdikJointConstraintAngleMaxPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets whether the CCDIK joint at [jointIdx] uses an inverted joint constraint.
   *
   * An inverted joint constraint only constraints the CCDIK joint to the angles *outside of* the
   * inputted minimum and maximum angles. For this reason, it is referred to as an inverted joint
   * constraint, as it constraints the joint to the outside of the inputted values.
   */
  public final fun setCcdikJointConstraintAngleInvert(jointIdx: Int, invert: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, jointIdx.toLong(), invert)
    TransferContext.callPtrMethod(MethodBindings.setCcdikJointConstraintAngleInvertPtr, 0)
  }

  /**
   * Returns whether the CCDIK joint at [jointIdx] uses an inverted joint constraint. See
   * [setCcdikJointConstraintAngleInvert] for details.
   */
  public final fun getCcdikJointConstraintAngleInvert(jointIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, jointIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getCcdikJointConstraintAngleInvertPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTargetNode(targetNodepath: String) =
      setTargetNode(targetNodepath.asCachedNodePath())

  public final fun setTipNode(tipNodepath: String) = setTipNode(tipNodepath.asCachedNodePath())

  /**
   * Sets the [Bone2D] node assigned to the CCDIK joint at [jointIdx].
   */
  public final fun setCcdikJointBone2dNode(jointIdx: Int, bone2dNodepath: String) =
      setCcdikJointBone2dNode(jointIdx, bone2dNodepath.asCachedNodePath())

  public companion object {
    @JvmField
    public val setTargetNodeName: MethodStringName1<SkeletonModification2DCCDIK, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DCCDIK, Unit, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName0<SkeletonModification2DCCDIK, NodePath> =
        MethodStringName0<SkeletonModification2DCCDIK, NodePath>("get_target_node")

    @JvmField
    public val setTipNodeName: MethodStringName1<SkeletonModification2DCCDIK, Unit, NodePath> =
        MethodStringName1<SkeletonModification2DCCDIK, Unit, NodePath>("set_tip_node")

    @JvmField
    public val getTipNodeName: MethodStringName0<SkeletonModification2DCCDIK, NodePath> =
        MethodStringName0<SkeletonModification2DCCDIK, NodePath>("get_tip_node")

    @JvmField
    public val setCcdikDataChainLengthName:
        MethodStringName1<SkeletonModification2DCCDIK, Unit, Int> =
        MethodStringName1<SkeletonModification2DCCDIK, Unit, Int>("set_ccdik_data_chain_length")

    @JvmField
    public val getCcdikDataChainLengthName: MethodStringName0<SkeletonModification2DCCDIK, Int> =
        MethodStringName0<SkeletonModification2DCCDIK, Int>("get_ccdik_data_chain_length")

    @JvmField
    public val setCcdikJointBone2dNodeName:
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, NodePath> =
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, NodePath>("set_ccdik_joint_bone2d_node")

    @JvmField
    public val getCcdikJointBone2dNodeName:
        MethodStringName1<SkeletonModification2DCCDIK, NodePath, Int> =
        MethodStringName1<SkeletonModification2DCCDIK, NodePath, Int>("get_ccdik_joint_bone2d_node")

    @JvmField
    public val setCcdikJointBoneIndexName:
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Int> =
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Int>("set_ccdik_joint_bone_index")

    @JvmField
    public val getCcdikJointBoneIndexName: MethodStringName1<SkeletonModification2DCCDIK, Int, Int>
        = MethodStringName1<SkeletonModification2DCCDIK, Int, Int>("get_ccdik_joint_bone_index")

    @JvmField
    public val setCcdikJointRotateFromJointName:
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Boolean> =
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Boolean>("set_ccdik_joint_rotate_from_joint")

    @JvmField
    public val getCcdikJointRotateFromJointName:
        MethodStringName1<SkeletonModification2DCCDIK, Boolean, Int> =
        MethodStringName1<SkeletonModification2DCCDIK, Boolean, Int>("get_ccdik_joint_rotate_from_joint")

    @JvmField
    public val setCcdikJointEnableConstraintName:
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Boolean> =
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Boolean>("set_ccdik_joint_enable_constraint")

    @JvmField
    public val getCcdikJointEnableConstraintName:
        MethodStringName1<SkeletonModification2DCCDIK, Boolean, Int> =
        MethodStringName1<SkeletonModification2DCCDIK, Boolean, Int>("get_ccdik_joint_enable_constraint")

    @JvmField
    public val setCcdikJointConstraintAngleMinName:
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Float> =
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Float>("set_ccdik_joint_constraint_angle_min")

    @JvmField
    public val getCcdikJointConstraintAngleMinName:
        MethodStringName1<SkeletonModification2DCCDIK, Float, Int> =
        MethodStringName1<SkeletonModification2DCCDIK, Float, Int>("get_ccdik_joint_constraint_angle_min")

    @JvmField
    public val setCcdikJointConstraintAngleMaxName:
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Float> =
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Float>("set_ccdik_joint_constraint_angle_max")

    @JvmField
    public val getCcdikJointConstraintAngleMaxName:
        MethodStringName1<SkeletonModification2DCCDIK, Float, Int> =
        MethodStringName1<SkeletonModification2DCCDIK, Float, Int>("get_ccdik_joint_constraint_angle_max")

    @JvmField
    public val setCcdikJointConstraintAngleInvertName:
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Boolean> =
        MethodStringName2<SkeletonModification2DCCDIK, Unit, Int, Boolean>("set_ccdik_joint_constraint_angle_invert")

    @JvmField
    public val getCcdikJointConstraintAngleInvertName:
        MethodStringName1<SkeletonModification2DCCDIK, Boolean, Int> =
        MethodStringName1<SkeletonModification2DCCDIK, Boolean, Int>("get_ccdik_joint_constraint_angle_invert")
  }

  public object MethodBindings {
    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_target_node", 1348162250)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_target_node", 4075236667)

    internal val setTipNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_tip_node", 1348162250)

    internal val getTipNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_tip_node", 4075236667)

    internal val setCcdikDataChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_data_chain_length", 1286410249)

    internal val getCcdikDataChainLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_data_chain_length", 2455072627)

    internal val setCcdikJointBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_joint_bone2d_node", 2761262315)

    internal val getCcdikJointBone2dNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_joint_bone2d_node", 408788394)

    internal val setCcdikJointBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_joint_bone_index", 3937882851)

    internal val getCcdikJointBoneIndexPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_joint_bone_index", 923996154)

    internal val setCcdikJointRotateFromJointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_joint_rotate_from_joint", 300928843)

    internal val getCcdikJointRotateFromJointPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_joint_rotate_from_joint", 1116898809)

    internal val setCcdikJointEnableConstraintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_joint_enable_constraint", 300928843)

    internal val getCcdikJointEnableConstraintPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_joint_enable_constraint", 1116898809)

    internal val setCcdikJointConstraintAngleMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_joint_constraint_angle_min", 1602489585)

    internal val getCcdikJointConstraintAngleMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_joint_constraint_angle_min", 2339986948)

    internal val setCcdikJointConstraintAngleMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_joint_constraint_angle_max", 1602489585)

    internal val getCcdikJointConstraintAngleMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_joint_constraint_angle_max", 2339986948)

    internal val setCcdikJointConstraintAngleInvertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "set_ccdik_joint_constraint_angle_invert", 300928843)

    internal val getCcdikJointConstraintAngleInvertPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonModification2DCCDIK", "get_ccdik_joint_constraint_angle_invert", 1116898809)
  }
}
