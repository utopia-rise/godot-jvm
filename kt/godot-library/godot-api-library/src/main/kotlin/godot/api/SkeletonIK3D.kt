// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import godot.core.asCachedNodePath
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * SkeletonIK3D is used to rotate all bones of a [Skeleton3D] bone chain a way that places the end
 * bone at a desired 3D position. A typical scenario for IK in games is to place a character's feet on
 * the ground or a character's hands on a currently held object. SkeletonIK uses FabrikInverseKinematic
 * internally to solve the bone chain and applies the results to the [Skeleton3D]
 * `bones_global_pose_override` property for all affected bones in the chain. If fully applied, this
 * overwrites any bone transform from [Animation]s or bone custom poses set by users. The applied
 * amount can be controlled with the [SkeletonModifier3D.influence] property.
 *
 * ```
 * # Apply IK effect automatically on every new frame (not the current)
 * skeleton_ik_node.start()
 *
 * # Apply IK effect only on the current frame
 * skeleton_ik_node.start(true)
 *
 * # Stop IK effect and reset bones_global_pose_override on Skeleton
 * skeleton_ik_node.stop()
 *
 * # Apply full IK effect
 * skeleton_ik_node.set_influence(1.0)
 *
 * # Apply half IK effect
 * skeleton_ik_node.set_influence(0.5)
 *
 * # Apply zero IK effect (a value at or below 0.01 also removes bones_global_pose_override on
 * Skeleton)
 * skeleton_ik_node.set_influence(0.0)
 * ```
 */
@GodotBaseType
public open class SkeletonIK3D : SkeletonModifier3D() {
  /**
   * The name of the current root bone, the first bone in the IK chain.
   */
  public final inline var rootBone: StringName
    @JvmName("rootBoneProperty")
    get() = getRootBone()
    @JvmName("rootBoneProperty")
    set(`value`) {
      setRootBone(value)
    }

  /**
   * The name of the current tip bone, the last bone in the IK chain placed at the [target]
   * transform (or [targetNode] if defined).
   */
  public final inline var tipBone: StringName
    @JvmName("tipBoneProperty")
    get() = getTipBone()
    @JvmName("tipBoneProperty")
    set(`value`) {
      setTipBone(value)
    }

  /**
   * First target of the IK chain where the tip bone is placed and, if [overrideTipBasis] is `true`,
   * how the tip bone is rotated. If a [targetNode] path is available the nodes transform is used
   * instead and this property is ignored.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var target: Transform3D
    @JvmName("targetProperty")
    get() = getTargetTransform()
    @JvmName("targetProperty")
    set(`value`) {
      setTargetTransform(value)
    }

  /**
   * If `true` overwrites the rotation of the tip bone with the rotation of the [target] (or
   * [targetNode] if defined).
   */
  public final inline var overrideTipBasis: Boolean
    @JvmName("overrideTipBasisProperty")
    get() = isOverrideTipBasis()
    @JvmName("overrideTipBasisProperty")
    set(`value`) {
      setOverrideTipBasis(value)
    }

  /**
   * If `true`, instructs the IK solver to consider the secondary magnet target (pole target) when
   * calculating the bone chain. Use the magnet position (pole target) to control the bending of the IK
   * chain.
   */
  public final inline var useMagnet: Boolean
    @JvmName("useMagnetProperty")
    get() = isUsingMagnet()
    @JvmName("useMagnetProperty")
    set(`value`) {
      setUseMagnet(value)
    }

  /**
   * Secondary target position (first is [target] property or [targetNode]) for the IK chain. Use
   * magnet position (pole target) to control the bending of the IK chain. Only works if the bone chain
   * has more than 2 bones. The middle chain bone position will be linearly interpolated with the
   * magnet position.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var magnet: Vector3
    @JvmName("magnetProperty")
    get() = getMagnetPosition()
    @JvmName("magnetProperty")
    set(`value`) {
      setMagnetPosition(value)
    }

  /**
   * Target node [NodePath] for the IK chain. If available, the node's current [Transform3D] is used
   * instead of the [target] property.
   */
  public final inline var targetNode: NodePath
    @JvmName("targetNodeProperty")
    get() = getTargetNode()
    @JvmName("targetNodeProperty")
    set(`value`) {
      setTargetNode(value)
    }

  /**
   * The minimum distance between bone and goal target. If the distance is below this value, the IK
   * solver stops further iterations.
   */
  public final inline var minDistance: Float
    @JvmName("minDistanceProperty")
    get() = getMinDistance()
    @JvmName("minDistanceProperty")
    set(`value`) {
      setMinDistance(value)
    }

  /**
   * Number of iteration loops used by the IK solver to produce more accurate (and elegant) bone
   * chain results.
   */
  public final inline var maxIterations: Int
    @JvmName("maxIterationsProperty")
    get() = getMaxIterations()
    @JvmName("maxIterationsProperty")
    set(`value`) {
      setMaxIterations(value)
    }

  /**
   * Interpolation value for how much the IK results are applied to the current skeleton bone chain.
   * A value of `1.0` will overwrite all skeleton bone transforms completely while a value of `0.0`
   * will visually disable the SkeletonIK.
   */
  public final inline var interpolation: Float
    @JvmName("interpolationProperty")
    get() = getInterpolation()
    @JvmName("interpolationProperty")
    set(`value`) {
      setInterpolation(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(666, scriptPtr)
  }

  /**
   * This is a helper function for [target] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = skeletonik3d.target
   * //Your changes
   * skeletonik3d.target = myCoreType
   * ``````
   *
   * First target of the IK chain where the tip bone is placed and, if [overrideTipBasis] is `true`,
   * how the tip bone is rotated. If a [targetNode] path is available the nodes transform is used
   * instead and this property is ignored.
   */
  @CoreTypeHelper
  public final fun targetMutate(block: Transform3D.() -> Unit): Transform3D = target.apply {
     block(this)
     target = this
  }

  /**
   * This is a helper function for [magnet] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = skeletonik3d.magnet
   * //Your changes
   * skeletonik3d.magnet = myCoreType
   * ``````
   *
   * Secondary target position (first is [target] property or [targetNode]) for the IK chain. Use
   * magnet position (pole target) to control the bending of the IK chain. Only works if the bone chain
   * has more than 2 bones. The middle chain bone position will be linearly interpolated with the
   * magnet position.
   */
  @CoreTypeHelper
  public final fun magnetMutate(block: Vector3.() -> Unit): Vector3 = magnet.apply {
     block(this)
     magnet = this
  }

  public final fun setRootBone(rootBone: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to rootBone)
    TransferContext.callMethod(MethodBindings.setRootBonePtr)
  }

  public final fun getRootBone(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootBonePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setTipBone(tipBone: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to tipBone)
    TransferContext.callMethod(MethodBindings.setTipBonePtr)
  }

  public final fun getTipBone(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTipBonePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setTargetTransform(target: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to target)
    TransferContext.callMethod(MethodBindings.setTargetTransformPtr)
  }

  public final fun getTargetTransform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  public final fun setTargetNode(node: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, NODE_PATH to node)
    TransferContext.callMethod(MethodBindings.setTargetNodePtr)
  }

  public final fun getTargetNode(): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetNodePtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  public final fun setOverrideTipBasis(`override`: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to override)
    TransferContext.callMethod(MethodBindings.setOverrideTipBasisPtr)
  }

  public final fun isOverrideTipBasis(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isOverrideTipBasisPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setUseMagnet(use: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to use)
    TransferContext.callMethod(MethodBindings.setUseMagnetPtr)
  }

  public final fun isUsingMagnet(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUsingMagnetPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMagnetPosition(localPosition: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to localPosition)
    TransferContext.callMethod(MethodBindings.setMagnetPositionPtr)
  }

  public final fun getMagnetPosition(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMagnetPositionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the parent [Skeleton3D] node that was present when SkeletonIK entered the scene tree.
   * Returns `null` if the parent node was not a [Skeleton3D] node when SkeletonIK3D entered the scene
   * tree.
   */
  public final fun getParentSkeleton(): Skeleton3D? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParentSkeletonPtr)
    return (TransferContext.readReturnValue(OBJECT) as Skeleton3D?)
  }

  /**
   * Returns `true` if SkeletonIK is applying IK effects on continues frames to the [Skeleton3D]
   * bones. Returns `false` if SkeletonIK is stopped or [start] was used with the `one_time` parameter
   * set to `true`.
   */
  public final fun isRunning(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRunningPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setMinDistance(minDistance: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to minDistance.toDouble())
    TransferContext.callMethod(MethodBindings.setMinDistancePtr)
  }

  public final fun getMinDistance(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMinDistancePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setMaxIterations(iterations: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to iterations.toLong())
    TransferContext.callMethod(MethodBindings.setMaxIterationsPtr)
  }

  public final fun getMaxIterations(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMaxIterationsPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Starts applying IK effects on each frame to the [Skeleton3D] bones but will only take effect
   * starting on the next frame. If [oneTime] is `true`, this will take effect immediately but also
   * reset on the next frame.
   */
  @JvmOverloads
  public final fun start(oneTime: Boolean = false): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to oneTime)
    TransferContext.callMethod(MethodBindings.startPtr)
  }

  /**
   * Stops applying IK effects on each frame to the [Skeleton3D] bones and also calls
   * [Skeleton3D.clearBonesGlobalPoseOverride] to remove existing overrides on all bones.
   */
  public final fun stop(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.stopPtr)
  }

  public final fun setInterpolation(interpolation: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to interpolation.toDouble())
    TransferContext.callMethod(MethodBindings.setInterpolationPtr)
  }

  public final fun getInterpolation(): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInterpolationPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  public final fun setRootBone(rootBone: String) = setRootBone(rootBone.asCachedStringName())

  public final fun setTipBone(tipBone: String) = setTipBone(tipBone.asCachedStringName())

  public final fun setTargetNode(node: String) = setTargetNode(node.asCachedNodePath())

  public companion object {
    @JvmField
    public val setRootBoneName: MethodStringName1<SkeletonIK3D, Unit, StringName> =
        MethodStringName1<SkeletonIK3D, Unit, StringName>("set_root_bone")

    @JvmField
    public val getRootBoneName: MethodStringName0<SkeletonIK3D, StringName> =
        MethodStringName0<SkeletonIK3D, StringName>("get_root_bone")

    @JvmField
    public val setTipBoneName: MethodStringName1<SkeletonIK3D, Unit, StringName> =
        MethodStringName1<SkeletonIK3D, Unit, StringName>("set_tip_bone")

    @JvmField
    public val getTipBoneName: MethodStringName0<SkeletonIK3D, StringName> =
        MethodStringName0<SkeletonIK3D, StringName>("get_tip_bone")

    @JvmField
    public val setTargetTransformName: MethodStringName1<SkeletonIK3D, Unit, Transform3D> =
        MethodStringName1<SkeletonIK3D, Unit, Transform3D>("set_target_transform")

    @JvmField
    public val getTargetTransformName: MethodStringName0<SkeletonIK3D, Transform3D> =
        MethodStringName0<SkeletonIK3D, Transform3D>("get_target_transform")

    @JvmField
    public val setTargetNodeName: MethodStringName1<SkeletonIK3D, Unit, NodePath> =
        MethodStringName1<SkeletonIK3D, Unit, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName0<SkeletonIK3D, NodePath> =
        MethodStringName0<SkeletonIK3D, NodePath>("get_target_node")

    @JvmField
    public val setOverrideTipBasisName: MethodStringName1<SkeletonIK3D, Unit, Boolean> =
        MethodStringName1<SkeletonIK3D, Unit, Boolean>("set_override_tip_basis")

    @JvmField
    public val isOverrideTipBasisName: MethodStringName0<SkeletonIK3D, Boolean> =
        MethodStringName0<SkeletonIK3D, Boolean>("is_override_tip_basis")

    @JvmField
    public val setUseMagnetName: MethodStringName1<SkeletonIK3D, Unit, Boolean> =
        MethodStringName1<SkeletonIK3D, Unit, Boolean>("set_use_magnet")

    @JvmField
    public val isUsingMagnetName: MethodStringName0<SkeletonIK3D, Boolean> =
        MethodStringName0<SkeletonIK3D, Boolean>("is_using_magnet")

    @JvmField
    public val setMagnetPositionName: MethodStringName1<SkeletonIK3D, Unit, Vector3> =
        MethodStringName1<SkeletonIK3D, Unit, Vector3>("set_magnet_position")

    @JvmField
    public val getMagnetPositionName: MethodStringName0<SkeletonIK3D, Vector3> =
        MethodStringName0<SkeletonIK3D, Vector3>("get_magnet_position")

    @JvmField
    public val getParentSkeletonName: MethodStringName0<SkeletonIK3D, Skeleton3D?> =
        MethodStringName0<SkeletonIK3D, Skeleton3D?>("get_parent_skeleton")

    @JvmField
    public val isRunningName: MethodStringName0<SkeletonIK3D, Boolean> =
        MethodStringName0<SkeletonIK3D, Boolean>("is_running")

    @JvmField
    public val setMinDistanceName: MethodStringName1<SkeletonIK3D, Unit, Float> =
        MethodStringName1<SkeletonIK3D, Unit, Float>("set_min_distance")

    @JvmField
    public val getMinDistanceName: MethodStringName0<SkeletonIK3D, Float> =
        MethodStringName0<SkeletonIK3D, Float>("get_min_distance")

    @JvmField
    public val setMaxIterationsName: MethodStringName1<SkeletonIK3D, Unit, Int> =
        MethodStringName1<SkeletonIK3D, Unit, Int>("set_max_iterations")

    @JvmField
    public val getMaxIterationsName: MethodStringName0<SkeletonIK3D, Int> =
        MethodStringName0<SkeletonIK3D, Int>("get_max_iterations")

    @JvmField
    public val startName: MethodStringName1<SkeletonIK3D, Unit, Boolean> =
        MethodStringName1<SkeletonIK3D, Unit, Boolean>("start")

    @JvmField
    public val stopName: MethodStringName0<SkeletonIK3D, Unit> =
        MethodStringName0<SkeletonIK3D, Unit>("stop")

    @JvmField
    public val setInterpolationName: MethodStringName1<SkeletonIK3D, Unit, Float> =
        MethodStringName1<SkeletonIK3D, Unit, Float>("set_interpolation")

    @JvmField
    public val getInterpolationName: MethodStringName0<SkeletonIK3D, Float> =
        MethodStringName0<SkeletonIK3D, Float>("get_interpolation")
  }

  public object MethodBindings {
    internal val setRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_root_bone", 3304788590)

    internal val getRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_root_bone", 2002593661)

    internal val setTipBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_tip_bone", 3304788590)

    internal val getTipBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_tip_bone", 2002593661)

    internal val setTargetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_target_transform", 2952846383)

    internal val getTargetTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_target_transform", 3229777777)

    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_target_node", 1348162250)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_target_node", 277076166)

    internal val setOverrideTipBasisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_override_tip_basis", 2586408642)

    internal val isOverrideTipBasisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "is_override_tip_basis", 36873697)

    internal val setUseMagnetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_use_magnet", 2586408642)

    internal val isUsingMagnetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "is_using_magnet", 36873697)

    internal val setMagnetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_magnet_position", 3460891852)

    internal val getMagnetPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_magnet_position", 3360562783)

    internal val getParentSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_parent_skeleton", 1488626673)

    internal val isRunningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "is_running", 2240911060)

    internal val setMinDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_min_distance", 373806689)

    internal val getMinDistancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_min_distance", 1740695150)

    internal val setMaxIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_max_iterations", 1286410249)

    internal val getMaxIterationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_max_iterations", 3905245786)

    internal val startPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "start", 107499316)

    internal val stopPtr: VoidPtr = TypeManager.getMethodBindPtr("SkeletonIK3D", "stop", 3218959716)

    internal val setInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "set_interpolation", 373806689)

    internal val getInterpolationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonIK3D", "get_interpolation", 1740695150)
  }
}
