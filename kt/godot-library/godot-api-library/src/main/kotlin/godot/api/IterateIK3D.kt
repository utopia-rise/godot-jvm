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
import godot.core.MethodStringName3
import godot.core.NodePath
import godot.core.Quaternion
import godot.core.Vector3
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_OBJECT
import godot.readReturnValue_QUATERNION
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_LONG_LONG
import godot.writeMethodArguments_LONG_LONG_OBJECT
import godot.writeMethodArguments_LONG_LONG_QUATERNION
import godot.writeMethodArguments_LONG_LONG_VECTOR3
import godot.writeMethodArguments_LONG_NODE_PATH
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Base class of [SkeletonModifier3D] to approach the goal by repeating small rotations.
 *
 * Each bone chain (setting) has one effector, which is processed in order of the setting list. You
 * can set some limitations for each joint.
 *
 * **Note:** All the methods in this class take an `index` parameter. This parameter specifies which
 * setting list entry to return if the IK has multiple entries (e.g. `settings/<index>/target_node`).
 */
@GodotBaseType
public open class IterateIK3D internal constructor() : ChainIK3D() {
  /**
   * The number of iteration loops used by the IK solver to produce more accurate results.
   */
  public final inline var maxIterations: Int
    @JvmName("maxIterationsProperty")
    get() = getMaxIterations()
    @JvmName("maxIterationsProperty")
    set(`value`) {
      setMaxIterations(value)
    }

  /**
   * The minimum distance between the end bone and the target. If the distance is below this value,
   * the IK solver stops any further iterations.
   */
  public final inline var minDistance: Double
    @JvmName("minDistanceProperty")
    get() = getMinDistance()
    @JvmName("minDistanceProperty")
    set(`value`) {
      setMinDistance(value)
    }

  /**
   * The maximum amount each bone can rotate in a single iteration.
   *
   * **Note:** This limitation is applied during each iteration. For example, if [maxIterations] is
   * `4` and [angularDeltaLimit] is `5` degrees, the maximum rotation possible in a single frame is
   * `20` degrees.
   */
  public final inline var angularDeltaLimit: Double
    @JvmName("angularDeltaLimitProperty")
    get() = getAngularDeltaLimit()
    @JvmName("angularDeltaLimitProperty")
    set(`value`) {
      setAngularDeltaLimit(value)
    }

  /**
   * If `false`, the result is calculated from the previous frame's [IterateIK3D] result as the
   * initial state.
   *
   * If `true`, the previous frame's [IterateIK3D] result is discarded. At this point, the new
   * result is calculated from the bone pose excluding the [IterateIK3D] as the initial state. This
   * means the result will be always equal as long as the target position and the previous bone pose
   * are the same. However, if [angularDeltaLimit] and [maxIterations] are set too small, the end bone
   * of the chain will never reach the target.
   */
  public final inline var deterministic: Boolean
    @JvmName("deterministicProperty")
    get() = isDeterministic()
    @JvmName("deterministicProperty")
    set(`value`) {
      setDeterministic(value)
    }

  /**
   * The number of settings.
   */
  public final inline var settingCount: Int
    @JvmName("settingCountProperty")
    get() = getSettingCount()
    @JvmName("settingCountProperty")
    set(`value`) {
      setSettingCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(329, scriptPtr)
  }

  public final fun setMaxIterations(maxIterations: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, maxIterations.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMaxIterationsPtr, 0)
  }

  public final fun getMaxIterations(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMaxIterationsPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setMinDistance(minDistance: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, minDistance)
    TransferContext.callPtrMethod(MethodBindings.setMinDistancePtr, 0)
  }

  public final fun getMinDistance(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getMinDistancePtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setAngularDeltaLimit(angularDeltaLimit: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angularDeltaLimit)
    TransferContext.callPtrMethod(MethodBindings.setAngularDeltaLimitPtr, 0)
  }

  public final fun getAngularDeltaLimit(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getAngularDeltaLimitPtr, 3)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setDeterministic(deterministic: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, deterministic)
    TransferContext.callPtrMethod(MethodBindings.setDeterministicPtr, 0)
  }

  public final fun isDeterministic(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isDeterministicPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the target node that the end bone is trying to reach.
   */
  public final fun setTargetNode(index: Int, targetNode: NodePath): Unit {
    TransferContext.writeMethodArguments_LONG_NODE_PATH(ptr, objectID.id, index.toLong(), targetNode)
    TransferContext.callPtrMethod(MethodBindings.setTargetNodePtr, 0)
  }

  /**
   * Returns the target node that the end bone is trying to reach.
   */
  public final fun getTargetNode(index: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTargetNodePtr, 22)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the rotation axis at [joint] in the bone chain's joint list.
   *
   * The axes are based on the reference pose's space, if [axis] is
   * [SkeletonModifier3D.ROTATION_AXIS_CUSTOM], you can specify any axis.
   *
   * In here, the reference pose is the bone pose immediately before processing IK.
   *
   * **Note:** The rotation axis and the forward vector shouldn't be colinear to avoid unintended
   * rotation since [ChainIK3D] does not factor in twisting forces.
   */
  public final fun setJointRotationAxis(
    index: Int,
    joint: Int,
    axis: SkeletonModifier3D.RotationAxis,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong(), axis.value)
    TransferContext.callPtrMethod(MethodBindings.setJointRotationAxisPtr, 0)
  }

  /**
   * Returns the rotation axis at [joint] in the bone chain's joint list.
   */
  public final fun getJointRotationAxis(index: Int, joint: Int): SkeletonModifier3D.RotationAxis {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callPtrMethod(MethodBindings.getJointRotationAxisPtr, 2)
    return SkeletonModifier3D.RotationAxis.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the rotation axis vector for the specified joint in the bone chain.
   *
   * This vector is normalized by an internal process and represents the axis around which the bone
   * chain can rotate.
   *
   * If the vector length is `0`, it is considered synonymous with
   * [SkeletonModifier3D.ROTATION_AXIS_ALL].
   */
  public final fun setJointRotationAxisVector(
    index: Int,
    joint: Int,
    axisVector: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_VECTOR3(ptr, objectID.id, index.toLong(), joint.toLong(), axisVector)
    TransferContext.callPtrMethod(MethodBindings.setJointRotationAxisVectorPtr, 0)
  }

  /**
   * Returns the rotation axis vector for the specified joint in the bone chain. This vector
   * represents the axis around which the joint can rotate. It is determined based on the rotation axis
   * set for the joint.
   *
   * If [getJointRotationAxis] is [SkeletonModifier3D.ROTATION_AXIS_ALL], this method returns
   * `Vector3(0, 0, 0)`.
   */
  public final fun getJointRotationAxisVector(index: Int, joint: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callPtrMethod(MethodBindings.getJointRotationAxisVectorPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the joint limitation at [joint] in the bone chain's joint list.
   */
  public final fun setJointLimitation(
    index: Int,
    joint: Int,
    limitation: JointLimitation3D?,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_OBJECT(ptr, objectID.id, index.toLong(), joint.toLong(), limitation)
    TransferContext.callPtrMethod(MethodBindings.setJointLimitationPtr, 0)
  }

  /**
   * Returns the joint limitation at [joint] in the bone chain's joint list.
   */
  public final fun getJointLimitation(index: Int, joint: Int): JointLimitation3D? {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callPtrMethod(MethodBindings.getJointLimitationPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as JointLimitation3D?)
  }

  /**
   * Sets the joint limitation right axis at [joint] in the bone chain's joint list.
   */
  public final fun setJointLimitationRightAxis(
    index: Int,
    joint: Int,
    direction: SkeletonModifier3D.SecondaryDirection,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong(), direction.value)
    TransferContext.callPtrMethod(MethodBindings.setJointLimitationRightAxisPtr, 0)
  }

  /**
   * Returns the joint limitation right axis at [joint] in the bone chain's joint list.
   */
  public final fun getJointLimitationRightAxis(index: Int, joint: Int):
      SkeletonModifier3D.SecondaryDirection {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callPtrMethod(MethodBindings.getJointLimitationRightAxisPtr, 2)
    return SkeletonModifier3D.SecondaryDirection.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the optional joint limitation right axis vector at [joint] in the bone chain's joint list.
   */
  public final fun setJointLimitationRightAxisVector(
    index: Int,
    joint: Int,
    vector: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_VECTOR3(ptr, objectID.id, index.toLong(), joint.toLong(), vector)
    TransferContext.callPtrMethod(MethodBindings.setJointLimitationRightAxisVectorPtr, 0)
  }

  /**
   * Returns the joint limitation right axis vector at [joint] in the bone chain's joint list.
   *
   * If [getJointLimitationRightAxis] is [SkeletonModifier3D.SECONDARY_DIRECTION_NONE], this method
   * returns `Vector3(0, 0, 0)`.
   */
  public final fun getJointLimitationRightAxisVector(index: Int, joint: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callPtrMethod(MethodBindings.getJointLimitationRightAxisVectorPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the joint limitation rotation offset at [joint] in the bone chain's joint list.
   *
   * Rotation is done in the local space which is constructed by the bone direction (in general
   * parent to child) as the +Y axis and [getJointLimitationRightAxisVector] as the +X axis.
   *
   * If the +X and +Y axes are not orthogonal, the +X axis is implicitly modified to make it
   * orthogonal.
   *
   * Also, if the length of [getJointLimitationRightAxisVector] is zero, the space is created by
   * rotating the reference pose using the shortest arc that rotates the +Y axis of the reference pose
   * to match the bone direction.
   *
   * In here, the reference pose is the bone pose immediately before processing IK.
   */
  public final fun setJointLimitationRotationOffset(
    index: Int,
    joint: Int,
    offset: Quaternion,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_QUATERNION(ptr, objectID.id, index.toLong(), joint.toLong(), offset)
    TransferContext.callPtrMethod(MethodBindings.setJointLimitationRotationOffsetPtr, 0)
  }

  /**
   * Returns the joint limitation rotation offset at [joint] in the bone chain's joint list.
   *
   * Rotation is done in the local space which is constructed by the bone direction (in general
   * parent to child) as the +Y axis and [getJointLimitationRightAxisVector] as the +X axis.
   *
   * If the +X and +Y axes are not orthogonal, the +X axis is implicitly modified to make it
   * orthogonal.
   *
   * Also, if the length of [getJointLimitationRightAxisVector] is zero, the space is created by
   * rotating the reference pose using the shortest arc that rotates the +Y axis of the reference pose
   * to match the bone direction.
   *
   * In here, the reference pose is the bone pose immediately before processing IK.
   */
  public final fun getJointLimitationRotationOffset(index: Int, joint: Int): Quaternion {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callPtrMethod(MethodBindings.getJointLimitationRotationOffsetPtr, 15)
    return TransferContext.readReturnValue_QUATERNION()
  }

  /**
   * Sets the target node that the end bone is trying to reach.
   */
  public final fun setTargetNode(index: Int, targetNode: String) =
      setTargetNode(index, targetNode.asCachedNodePath())

  public companion object {
    @JvmField
    public val setMaxIterationsName: MethodStringName1<IterateIK3D, Unit, Int> =
        MethodStringName1<IterateIK3D, Unit, Int>("set_max_iterations")

    @JvmField
    public val getMaxIterationsName: MethodStringName0<IterateIK3D, Int> =
        MethodStringName0<IterateIK3D, Int>("get_max_iterations")

    @JvmField
    public val setMinDistanceName: MethodStringName1<IterateIK3D, Unit, Double> =
        MethodStringName1<IterateIK3D, Unit, Double>("set_min_distance")

    @JvmField
    public val getMinDistanceName: MethodStringName0<IterateIK3D, Double> =
        MethodStringName0<IterateIK3D, Double>("get_min_distance")

    @JvmField
    public val setAngularDeltaLimitName: MethodStringName1<IterateIK3D, Unit, Double> =
        MethodStringName1<IterateIK3D, Unit, Double>("set_angular_delta_limit")

    @JvmField
    public val getAngularDeltaLimitName: MethodStringName0<IterateIK3D, Double> =
        MethodStringName0<IterateIK3D, Double>("get_angular_delta_limit")

    @JvmField
    public val setDeterministicName: MethodStringName1<IterateIK3D, Unit, Boolean> =
        MethodStringName1<IterateIK3D, Unit, Boolean>("set_deterministic")

    @JvmField
    public val isDeterministicName: MethodStringName0<IterateIK3D, Boolean> =
        MethodStringName0<IterateIK3D, Boolean>("is_deterministic")

    @JvmField
    public val setTargetNodeName: MethodStringName2<IterateIK3D, Unit, Int, NodePath> =
        MethodStringName2<IterateIK3D, Unit, Int, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName1<IterateIK3D, NodePath, Int> =
        MethodStringName1<IterateIK3D, NodePath, Int>("get_target_node")

    @JvmField
    public val setJointRotationAxisName:
        MethodStringName3<IterateIK3D, Unit, Int, Int, SkeletonModifier3D.RotationAxis> =
        MethodStringName3<IterateIK3D, Unit, Int, Int, SkeletonModifier3D.RotationAxis>("set_joint_rotation_axis")

    @JvmField
    public val getJointRotationAxisName:
        MethodStringName2<IterateIK3D, SkeletonModifier3D.RotationAxis, Int, Int> =
        MethodStringName2<IterateIK3D, SkeletonModifier3D.RotationAxis, Int, Int>("get_joint_rotation_axis")

    @JvmField
    public val setJointRotationAxisVectorName:
        MethodStringName3<IterateIK3D, Unit, Int, Int, Vector3> =
        MethodStringName3<IterateIK3D, Unit, Int, Int, Vector3>("set_joint_rotation_axis_vector")

    @JvmField
    public val getJointRotationAxisVectorName: MethodStringName2<IterateIK3D, Vector3, Int, Int> =
        MethodStringName2<IterateIK3D, Vector3, Int, Int>("get_joint_rotation_axis_vector")

    @JvmField
    public val setJointLimitationName:
        MethodStringName3<IterateIK3D, Unit, Int, Int, JointLimitation3D?> =
        MethodStringName3<IterateIK3D, Unit, Int, Int, JointLimitation3D?>("set_joint_limitation")

    @JvmField
    public val getJointLimitationName: MethodStringName2<IterateIK3D, JointLimitation3D?, Int, Int>
        = MethodStringName2<IterateIK3D, JointLimitation3D?, Int, Int>("get_joint_limitation")

    @JvmField
    public val setJointLimitationRightAxisName:
        MethodStringName3<IterateIK3D, Unit, Int, Int, SkeletonModifier3D.SecondaryDirection> =
        MethodStringName3<IterateIK3D, Unit, Int, Int, SkeletonModifier3D.SecondaryDirection>("set_joint_limitation_right_axis")

    @JvmField
    public val getJointLimitationRightAxisName:
        MethodStringName2<IterateIK3D, SkeletonModifier3D.SecondaryDirection, Int, Int> =
        MethodStringName2<IterateIK3D, SkeletonModifier3D.SecondaryDirection, Int, Int>("get_joint_limitation_right_axis")

    @JvmField
    public val setJointLimitationRightAxisVectorName:
        MethodStringName3<IterateIK3D, Unit, Int, Int, Vector3> =
        MethodStringName3<IterateIK3D, Unit, Int, Int, Vector3>("set_joint_limitation_right_axis_vector")

    @JvmField
    public val getJointLimitationRightAxisVectorName:
        MethodStringName2<IterateIK3D, Vector3, Int, Int> =
        MethodStringName2<IterateIK3D, Vector3, Int, Int>("get_joint_limitation_right_axis_vector")

    @JvmField
    public val setJointLimitationRotationOffsetName:
        MethodStringName3<IterateIK3D, Unit, Int, Int, Quaternion> =
        MethodStringName3<IterateIK3D, Unit, Int, Int, Quaternion>("set_joint_limitation_rotation_offset")

    @JvmField
    public val getJointLimitationRotationOffsetName:
        MethodStringName2<IterateIK3D, Quaternion, Int, Int> =
        MethodStringName2<IterateIK3D, Quaternion, Int, Int>("get_joint_limitation_rotation_offset")
  }

  public object MethodBindings {
    internal val setMaxIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_max_iterations", 1286410249)

    internal val getMaxIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_max_iterations", 3905245786)

    internal val setMinDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_min_distance", 373806689)

    internal val getMinDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_min_distance", 1740695150)

    internal val setAngularDeltaLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_angular_delta_limit", 373806689)

    internal val getAngularDeltaLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_angular_delta_limit", 1740695150)

    internal val setDeterministicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_deterministic", 2586408642)

    internal val isDeterministicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "is_deterministic", 36873697)

    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_target_node", 2761262315)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_target_node", 408788394)

    internal val setJointRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_joint_rotation_axis", 1391134969)

    internal val getJointRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_joint_rotation_axis", 3312594080)

    internal val setJointRotationAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_joint_rotation_axis_vector", 2866752138)

    internal val getJointRotationAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_joint_rotation_axis_vector", 1592972041)

    internal val setJointLimitationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_joint_limitation", 1194636955)

    internal val getJointLimitationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_joint_limitation", 91665146)

    internal val setJointLimitationRightAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_joint_limitation_right_axis", 3838967147)

    internal val getJointLimitationRightAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_joint_limitation_right_axis", 623936134)

    internal val setJointLimitationRightAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_joint_limitation_right_axis_vector", 2866752138)

    internal val getJointLimitationRightAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_joint_limitation_right_axis_vector", 1592972041)

    internal val setJointLimitationRotationOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "set_joint_limitation_rotation_offset", 4188936002)

    internal val getJointLimitationRotationOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("IterateIK3D", "get_joint_limitation_rotation_offset", 2722473700)
  }
}
