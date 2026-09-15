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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.Vector3
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_STRING
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_VECTOR3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This [SkeletonModifier3D] rotates a bone to look at a target. This is helpful for moving a
 * character's head to look at the player, rotating a turret to look at a target, or any other case
 * where you want to make a bone rotate towards something quickly and easily.
 *
 * When applying multiple [LookAtModifier3D]s, the [LookAtModifier3D] assigned to the parent bone
 * must be put above the [LookAtModifier3D] assigned to the child bone in the list in order for the
 * child bone results to be correct.
 */
@GodotBaseType
public open class LookAtModifier3D : SkeletonModifier3D() {
  /**
   * The [NodePath] to the node that is the target for the look at modification. This node is what
   * the modification will rotate the bone to.
   */
  public final inline var targetNode: NodePath
    @JvmName("targetNodeProperty")
    get() = getTargetNode()
    @JvmName("targetNodeProperty")
    set(`value`) {
      setTargetNode(value)
    }

  /**
   * The bone name of the [Skeleton3D] that the modification will operate on.
   */
  public final inline var boneName: String
    @JvmName("boneNameProperty")
    get() = getBoneName()
    @JvmName("boneNameProperty")
    set(`value`) {
      setBoneName(value)
    }

  /**
   * Index of the [boneName] in the parent [Skeleton3D].
   */
  public final inline var bone: Int
    @JvmName("boneProperty")
    get() = getBone()
    @JvmName("boneProperty")
    set(`value`) {
      setBone(value)
    }

  /**
   * The forward axis of the bone. This [SkeletonModifier3D] modifies the bone so that this axis
   * points toward the [targetNode].
   */
  public final inline var forwardAxis: SkeletonModifier3D.BoneAxis
    @JvmName("forwardAxisProperty")
    get() = getForwardAxis()
    @JvmName("forwardAxisProperty")
    set(`value`) {
      setForwardAxis(value)
    }

  /**
   * The axis of the first rotation. This [SkeletonModifier3D] works by compositing the rotation by
   * Euler angles to prevent to rotate the [forwardAxis].
   */
  public final inline var primaryRotationAxis: Vector3.Axis
    @JvmName("primaryRotationAxisProperty")
    get() = getPrimaryRotationAxis()
    @JvmName("primaryRotationAxisProperty")
    set(`value`) {
      setPrimaryRotationAxis(value)
    }

  /**
   * If `true`, provides rotation by two axes.
   */
  public final inline var useSecondaryRotation: Boolean
    @JvmName("useSecondaryRotationProperty")
    get() = isUsingSecondaryRotation()
    @JvmName("useSecondaryRotationProperty")
    set(`value`) {
      setUseSecondaryRotation(value)
    }

  /**
   * The relative option. If `true`, the rotation is applied relative to the pose. If `false`, the
   * rotation is applied relative to the rest. It means to replace the current pose with the
   * [LookAtModifier3D]'s result.
   *
   * **Note:** This option affects the base angle for [useAngleLimitation]. Since the
   * [LookAtModifier3D] relies strongly on Euler rotation, the axis that determines the limitation and
   * the actual rotation are strongly tied together.
   */
  public final inline var relative: Boolean
    @JvmName("relativeProperty")
    get() = isRelative()
    @JvmName("relativeProperty")
    set(`value`) {
      setRelative(value)
    }

  /**
   * This value determines from what origin is retrieved for use in the calculation of the forward
   * vector.
   */
  public final inline var originFrom: OriginFrom
    @JvmName("originFromProperty")
    get() = getOriginFrom()
    @JvmName("originFromProperty")
    set(`value`) {
      setOriginFrom(value)
    }

  /**
   * If [originFrom] is [ORIGIN_FROM_SPECIFIC_BONE], the bone global pose position specified for
   * this is used as origin.
   */
  public final inline var originBoneName: String
    @JvmName("originBoneNameProperty")
    get() = getOriginBoneName()
    @JvmName("originBoneNameProperty")
    set(`value`) {
      setOriginBoneName(value)
    }

  /**
   * Index of the [originBoneName] in the parent [Skeleton3D].
   */
  public final inline var originBone: Int
    @JvmName("originBoneProperty")
    get() = getOriginBone()
    @JvmName("originBoneProperty")
    set(`value`) {
      setOriginBone(value)
    }

  /**
   * If [originFrom] is [ORIGIN_FROM_EXTERNAL_NODE], the global position of the [Node3D] specified
   * for this is used as origin.
   */
  public final inline var originExternalNode: NodePath
    @JvmName("originExternalNodeProperty")
    get() = getOriginExternalNode()
    @JvmName("originExternalNodeProperty")
    set(`value`) {
      setOriginExternalNode(value)
    }

  /**
   * The offset of the bone pose origin. Matching the origins by offset is useful for cases where
   * multiple bones must always face the same direction, such as the eyes.
   *
   * **Note:** This value indicates the local position of the object set in [originFrom].
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var originOffset: Vector3
    @JvmName("originOffsetProperty")
    get() = getOriginOffset()
    @JvmName("originOffsetProperty")
    set(`value`) {
      setOriginOffset(value)
    }

  /**
   * If the target passes through too close to the origin than this value, time-based interpolation
   * is used even if the target is within the angular limitations, to prevent the angular velocity from
   * becoming too high.
   */
  public final inline var originSafeMargin: Float
    @JvmName("originSafeMarginProperty")
    get() = getOriginSafeMargin()
    @JvmName("originSafeMarginProperty")
    set(`value`) {
      setOriginSafeMargin(value)
    }

  /**
   * The duration of the time-based interpolation. Interpolation is triggered at the following
   * cases:
   *
   * - When the target node is changed
   *
   * - When an axis is flipped due to angle limitation
   *
   * **Note:** The flipping occurs when the target is outside the angle limitation and the
   * internally computed secondary rotation axis of the forward vector is flipped. Visually, it occurs
   * when the target is outside the angle limitation and crosses the plane of the [forwardAxis] and
   * [primaryRotationAxis].
   */
  public final inline var duration: Float
    @JvmName("durationProperty")
    get() = getDuration()
    @JvmName("durationProperty")
    set(`value`) {
      setDuration(value)
    }

  /**
   * The transition type of the time-based interpolation. See also [Tween.TransitionType].
   */
  public final inline var transitionType: Tween.TransitionType
    @JvmName("transitionTypeProperty")
    get() = getTransitionType()
    @JvmName("transitionTypeProperty")
    set(`value`) {
      setTransitionType(value)
    }

  /**
   * The ease type of the time-based interpolation. See also [Tween.EaseType].
   */
  public final inline var easeType: Tween.EaseType
    @JvmName("easeTypeProperty")
    get() = getEaseType()
    @JvmName("easeTypeProperty")
    set(`value`) {
      setEaseType(value)
    }

  /**
   * If `true`, limits the amount of rotation. For example, this helps to prevent a character's neck
   * from rotating 360 degrees.
   *
   * **Note:** As with [AnimationTree] blending, interpolation is provided that favors
   * [Skeleton3D.getBoneRest] or [Skeleton3D.getBonePose] depends on the [relative] option. This means
   * that interpolation does not select the shortest path in some cases.
   *
   * **Note:** Some values for [transitionType] (such as [Tween.TRANS_BACK], [Tween.TRANS_ELASTIC],
   * and [Tween.TRANS_SPRING]) may exceed the limitations. If interpolation occurs while overshooting
   * the limitations, the result might not respect the bone rest.
   */
  public final inline var useAngleLimitation: Boolean
    @JvmName("useAngleLimitationProperty")
    get() = isUsingAngleLimitation()
    @JvmName("useAngleLimitationProperty")
    set(`value`) {
      setUseAngleLimitation(value)
    }

  /**
   * If `true`, the limitations are spread from the bone symmetrically.
   *
   * If `false`, the limitation can be specified separately for each side of the bone rest.
   */
  public final inline var symmetryLimitation: Boolean
    @JvmName("symmetryLimitationProperty")
    get() = isLimitationSymmetry()
    @JvmName("symmetryLimitationProperty")
    set(`value`) {
      setSymmetryLimitation(value)
    }

  /**
   * The limit angle of the primary rotation when [symmetryLimitation] is `true`, in radians.
   */
  public final inline var primaryLimitAngle: Float
    @JvmName("primaryLimitAngleProperty")
    get() = getPrimaryLimitAngle()
    @JvmName("primaryLimitAngleProperty")
    set(`value`) {
      setPrimaryLimitAngle(value)
    }

  /**
   * The threshold to start damping for [primaryLimitAngle]. It provides non-linear (b-spline)
   * interpolation, let it feel more resistance the more it rotate to the edge limit. This is useful
   * for simulating the limits of human motion.
   *
   * If `1.0`, no damping is performed. If `0.0`, damping is always performed.
   */
  public final inline var primaryDampThreshold: Float
    @JvmName("primaryDampThresholdProperty")
    get() = getPrimaryDampThreshold()
    @JvmName("primaryDampThresholdProperty")
    set(`value`) {
      setPrimaryDampThreshold(value)
    }

  /**
   * The limit angle of positive side of the primary rotation when [symmetryLimitation] is `false`,
   * in radians.
   */
  public final inline var primaryPositiveLimitAngle: Float
    @JvmName("primaryPositiveLimitAngleProperty")
    get() = getPrimaryPositiveLimitAngle()
    @JvmName("primaryPositiveLimitAngleProperty")
    set(`value`) {
      setPrimaryPositiveLimitAngle(value)
    }

  /**
   * The threshold to start damping for [primaryPositiveLimitAngle].
   */
  public final inline var primaryPositiveDampThreshold: Float
    @JvmName("primaryPositiveDampThresholdProperty")
    get() = getPrimaryPositiveDampThreshold()
    @JvmName("primaryPositiveDampThresholdProperty")
    set(`value`) {
      setPrimaryPositiveDampThreshold(value)
    }

  /**
   * The limit angle of negative side of the primary rotation when [symmetryLimitation] is `false`,
   * in radians.
   */
  public final inline var primaryNegativeLimitAngle: Float
    @JvmName("primaryNegativeLimitAngleProperty")
    get() = getPrimaryNegativeLimitAngle()
    @JvmName("primaryNegativeLimitAngleProperty")
    set(`value`) {
      setPrimaryNegativeLimitAngle(value)
    }

  /**
   * The threshold to start damping for [primaryNegativeLimitAngle].
   */
  public final inline var primaryNegativeDampThreshold: Float
    @JvmName("primaryNegativeDampThresholdProperty")
    get() = getPrimaryNegativeDampThreshold()
    @JvmName("primaryNegativeDampThresholdProperty")
    set(`value`) {
      setPrimaryNegativeDampThreshold(value)
    }

  /**
   * The limit angle of the secondary rotation when [symmetryLimitation] is `true`, in radians.
   */
  public final inline var secondaryLimitAngle: Float
    @JvmName("secondaryLimitAngleProperty")
    get() = getSecondaryLimitAngle()
    @JvmName("secondaryLimitAngleProperty")
    set(`value`) {
      setSecondaryLimitAngle(value)
    }

  /**
   * The threshold to start damping for [secondaryLimitAngle].
   */
  public final inline var secondaryDampThreshold: Float
    @JvmName("secondaryDampThresholdProperty")
    get() = getSecondaryDampThreshold()
    @JvmName("secondaryDampThresholdProperty")
    set(`value`) {
      setSecondaryDampThreshold(value)
    }

  /**
   * The limit angle of positive side of the secondary rotation when [symmetryLimitation] is
   * `false`, in radians.
   */
  public final inline var secondaryPositiveLimitAngle: Float
    @JvmName("secondaryPositiveLimitAngleProperty")
    get() = getSecondaryPositiveLimitAngle()
    @JvmName("secondaryPositiveLimitAngleProperty")
    set(`value`) {
      setSecondaryPositiveLimitAngle(value)
    }

  /**
   * The threshold to start damping for [secondaryPositiveLimitAngle].
   */
  public final inline var secondaryPositiveDampThreshold: Float
    @JvmName("secondaryPositiveDampThresholdProperty")
    get() = getSecondaryPositiveDampThreshold()
    @JvmName("secondaryPositiveDampThresholdProperty")
    set(`value`) {
      setSecondaryPositiveDampThreshold(value)
    }

  /**
   * The limit angle of negative side of the secondary rotation when [symmetryLimitation] is
   * `false`, in radians.
   */
  public final inline var secondaryNegativeLimitAngle: Float
    @JvmName("secondaryNegativeLimitAngleProperty")
    get() = getSecondaryNegativeLimitAngle()
    @JvmName("secondaryNegativeLimitAngleProperty")
    set(`value`) {
      setSecondaryNegativeLimitAngle(value)
    }

  /**
   * The threshold to start damping for [secondaryNegativeLimitAngle].
   */
  public final inline var secondaryNegativeDampThreshold: Float
    @JvmName("secondaryNegativeDampThresholdProperty")
    get() = getSecondaryNegativeDampThreshold()
    @JvmName("secondaryNegativeDampThresholdProperty")
    set(`value`) {
      setSecondaryNegativeDampThreshold(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(364, scriptPtr)
  }

  /**
   * This is a helper function for [originOffset] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = lookatmodifier3d.originOffset
   * //Your changes
   * lookatmodifier3d.originOffset = myCoreType
   * ``````
   *
   * The offset of the bone pose origin. Matching the origins by offset is useful for cases where
   * multiple bones must always face the same direction, such as the eyes.
   *
   * **Note:** This value indicates the local position of the object set in [originFrom].
   */
  @CoreTypeHelper
  public final fun originOffsetMutate(block: Vector3.() -> Unit): Vector3 = originOffset.apply {
     block(this)
     originOffset = this
  }

  public final fun setTargetNode(targetNode: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, targetNode)
    TransferContext.callPtrMethod(MethodBindings.setTargetNodePtr, 0)
  }

  public final fun getTargetNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTargetNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setBoneName(boneName: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, boneName)
    TransferContext.callMethod(MethodBindings.setBoneNamePtr)
  }

  public final fun getBoneName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setBone(bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setBonePtr, 0)
  }

  public final fun getBone(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setForwardAxis(forwardAxis: SkeletonModifier3D.BoneAxis): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, forwardAxis.value)
    TransferContext.callPtrMethod(MethodBindings.setForwardAxisPtr, 0)
  }

  public final fun getForwardAxis(): SkeletonModifier3D.BoneAxis {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getForwardAxisPtr, 2)
    return SkeletonModifier3D.BoneAxis.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setPrimaryRotationAxis(axis: Vector3.Axis): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, axis.value)
    TransferContext.callPtrMethod(MethodBindings.setPrimaryRotationAxisPtr, 0)
  }

  public final fun getPrimaryRotationAxis(): Vector3.Axis {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPrimaryRotationAxisPtr, 2)
    return Vector3.Axis.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setUseSecondaryRotation(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setUseSecondaryRotationPtr, 0)
  }

  public final fun isUsingSecondaryRotation(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isUsingSecondaryRotationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setRelative(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setRelativePtr, 0)
  }

  public final fun isRelative(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isRelativePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setOriginSafeMargin(margin: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, margin.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setOriginSafeMarginPtr, 0)
  }

  public final fun getOriginSafeMargin(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOriginSafeMarginPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setOriginFrom(originFrom: OriginFrom): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, originFrom.value)
    TransferContext.callPtrMethod(MethodBindings.setOriginFromPtr, 0)
  }

  public final fun getOriginFrom(): OriginFrom {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOriginFromPtr, 2)
    return OriginFrom.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setOriginBoneName(boneName: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, boneName)
    TransferContext.callMethod(MethodBindings.setOriginBoneNamePtr)
  }

  public final fun getOriginBoneName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setOriginBone(bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setOriginBonePtr, 0)
  }

  public final fun getOriginBone(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOriginBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setOriginExternalNode(externalNode: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, externalNode)
    TransferContext.callPtrMethod(MethodBindings.setOriginExternalNodePtr, 0)
  }

  public final fun getOriginExternalNode(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOriginExternalNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setOriginOffset(offset: Vector3): Unit {
    TransferContext.writeMethodArguments_VECTOR3(ptr, objectID.id, offset)
    TransferContext.callPtrMethod(MethodBindings.setOriginOffsetPtr, 0)
  }

  public final fun getOriginOffset(): Vector3 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getOriginOffsetPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  public final fun setDuration(duration: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, duration.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setDurationPtr, 0)
  }

  public final fun getDuration(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDurationPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setTransitionType(transitionType: Tween.TransitionType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, transitionType.value)
    TransferContext.callPtrMethod(MethodBindings.setTransitionTypePtr, 0)
  }

  public final fun getTransitionType(): Tween.TransitionType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getTransitionTypePtr, 2)
    return Tween.TransitionType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setEaseType(easeType: Tween.EaseType): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, easeType.value)
    TransferContext.callPtrMethod(MethodBindings.setEaseTypePtr, 0)
  }

  public final fun getEaseType(): Tween.EaseType {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEaseTypePtr, 2)
    return Tween.EaseType.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setUseAngleLimitation(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setUseAngleLimitationPtr, 0)
  }

  public final fun isUsingAngleLimitation(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isUsingAngleLimitationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setSymmetryLimitation(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setSymmetryLimitationPtr, 0)
  }

  public final fun isLimitationSymmetry(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isLimitationSymmetryPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPrimaryLimitAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPrimaryLimitAnglePtr, 0)
  }

  public final fun getPrimaryLimitAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPrimaryLimitAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPrimaryDampThreshold(power: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, power.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPrimaryDampThresholdPtr, 0)
  }

  public final fun getPrimaryDampThreshold(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPrimaryDampThresholdPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPrimaryPositiveLimitAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPrimaryPositiveLimitAnglePtr, 0)
  }

  public final fun getPrimaryPositiveLimitAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPrimaryPositiveLimitAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPrimaryPositiveDampThreshold(power: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, power.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPrimaryPositiveDampThresholdPtr, 0)
  }

  public final fun getPrimaryPositiveDampThreshold(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPrimaryPositiveDampThresholdPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPrimaryNegativeLimitAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPrimaryNegativeLimitAnglePtr, 0)
  }

  public final fun getPrimaryNegativeLimitAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPrimaryNegativeLimitAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setPrimaryNegativeDampThreshold(power: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, power.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setPrimaryNegativeDampThresholdPtr, 0)
  }

  public final fun getPrimaryNegativeDampThreshold(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPrimaryNegativeDampThresholdPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSecondaryLimitAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSecondaryLimitAnglePtr, 0)
  }

  public final fun getSecondaryLimitAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSecondaryLimitAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSecondaryDampThreshold(power: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, power.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSecondaryDampThresholdPtr, 0)
  }

  public final fun getSecondaryDampThreshold(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSecondaryDampThresholdPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSecondaryPositiveLimitAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSecondaryPositiveLimitAnglePtr, 0)
  }

  public final fun getSecondaryPositiveLimitAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSecondaryPositiveLimitAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSecondaryPositiveDampThreshold(power: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, power.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSecondaryPositiveDampThresholdPtr, 0)
  }

  public final fun getSecondaryPositiveDampThreshold(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSecondaryPositiveDampThresholdPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSecondaryNegativeLimitAngle(angle: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, angle.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSecondaryNegativeLimitAnglePtr, 0)
  }

  public final fun getSecondaryNegativeLimitAngle(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSecondaryNegativeLimitAnglePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setSecondaryNegativeDampThreshold(power: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, power.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setSecondaryNegativeDampThresholdPtr, 0)
  }

  public final fun getSecondaryNegativeDampThreshold(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getSecondaryNegativeDampThresholdPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns the remaining seconds of the time-based interpolation.
   */
  public final fun getInterpolationRemaining(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getInterpolationRemainingPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Returns `true` if time-based interpolation is running. If `true`, it is equivalent to
   * [getInterpolationRemaining] returning `0.0`.
   *
   * This is useful to determine whether a [LookAtModifier3D] can be removed safely.
   */
  public final fun isInterpolating(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isInterpolatingPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns whether the target is within the angle limitations. It is useful for unsetting the
   * [targetNode] when the target is outside of the angle limitations.
   *
   * **Note:** The value is updated after [SkeletonModifier3D.ProcessModification]. To retrieve this
   * value correctly, we recommend using the signal [signal SkeletonModifier3D.modification_processed].
   */
  public final fun isTargetWithinLimitation(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isTargetWithinLimitationPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setTargetNode(targetNode: String) = setTargetNode(targetNode.asCachedNodePath())

  public final fun setOriginExternalNode(externalNode: String) =
      setOriginExternalNode(externalNode.asCachedNodePath())

  public enum class OriginFrom(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The bone rest position of the bone specified in [bone] is used as origin.
     */
    SELF(0),
    /**
     * The bone global pose position of the bone specified in [originBone] is used as origin.
     *
     * **Note:** It is recommended that you select only the parent bone unless you are familiar with
     * the bone processing process. The specified bone pose at the time the [LookAtModifier3D] is
     * processed is used as a reference. In other words, if you specify a child bone and the
     * [LookAtModifier3D] causes the child bone to move, the rendered result and direction will not
     * match.
     */
    SPECIFIC_BONE(1),
    /**
     * The global position of the [Node3D] specified in [originExternalNode] is used as origin.
     *
     * **Note:** Same as [ORIGIN_FROM_SPECIFIC_BONE], when specifying a [BoneAttachment3D] with a
     * child bone assigned, the rendered result and direction will not match.
     */
    EXTERNAL_NODE(2),
    ;

    public companion object {
      public fun from(`value`: Long): OriginFrom = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setTargetNodeName: MethodStringName1<LookAtModifier3D, Unit, NodePath> =
        MethodStringName1<LookAtModifier3D, Unit, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName0<LookAtModifier3D, NodePath> =
        MethodStringName0<LookAtModifier3D, NodePath>("get_target_node")

    @JvmField
    public val setBoneNameName: MethodStringName1<LookAtModifier3D, Unit, String> =
        MethodStringName1<LookAtModifier3D, Unit, String>("set_bone_name")

    @JvmField
    public val getBoneNameName: MethodStringName0<LookAtModifier3D, String> =
        MethodStringName0<LookAtModifier3D, String>("get_bone_name")

    @JvmField
    public val setBoneName: MethodStringName1<LookAtModifier3D, Unit, Int> =
        MethodStringName1<LookAtModifier3D, Unit, Int>("set_bone")

    @JvmField
    public val getBoneName: MethodStringName0<LookAtModifier3D, Int> =
        MethodStringName0<LookAtModifier3D, Int>("get_bone")

    @JvmField
    public val setForwardAxisName:
        MethodStringName1<LookAtModifier3D, Unit, SkeletonModifier3D.BoneAxis> =
        MethodStringName1<LookAtModifier3D, Unit, SkeletonModifier3D.BoneAxis>("set_forward_axis")

    @JvmField
    public val getForwardAxisName: MethodStringName0<LookAtModifier3D, SkeletonModifier3D.BoneAxis>
        = MethodStringName0<LookAtModifier3D, SkeletonModifier3D.BoneAxis>("get_forward_axis")

    @JvmField
    public val setPrimaryRotationAxisName: MethodStringName1<LookAtModifier3D, Unit, Vector3.Axis> =
        MethodStringName1<LookAtModifier3D, Unit, Vector3.Axis>("set_primary_rotation_axis")

    @JvmField
    public val getPrimaryRotationAxisName: MethodStringName0<LookAtModifier3D, Vector3.Axis> =
        MethodStringName0<LookAtModifier3D, Vector3.Axis>("get_primary_rotation_axis")

    @JvmField
    public val setUseSecondaryRotationName: MethodStringName1<LookAtModifier3D, Unit, Boolean> =
        MethodStringName1<LookAtModifier3D, Unit, Boolean>("set_use_secondary_rotation")

    @JvmField
    public val isUsingSecondaryRotationName: MethodStringName0<LookAtModifier3D, Boolean> =
        MethodStringName0<LookAtModifier3D, Boolean>("is_using_secondary_rotation")

    @JvmField
    public val setRelativeName: MethodStringName1<LookAtModifier3D, Unit, Boolean> =
        MethodStringName1<LookAtModifier3D, Unit, Boolean>("set_relative")

    @JvmField
    public val isRelativeName: MethodStringName0<LookAtModifier3D, Boolean> =
        MethodStringName0<LookAtModifier3D, Boolean>("is_relative")

    @JvmField
    public val setOriginSafeMarginName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_origin_safe_margin")

    @JvmField
    public val getOriginSafeMarginName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_origin_safe_margin")

    @JvmField
    public val setOriginFromName: MethodStringName1<LookAtModifier3D, Unit, OriginFrom> =
        MethodStringName1<LookAtModifier3D, Unit, OriginFrom>("set_origin_from")

    @JvmField
    public val getOriginFromName: MethodStringName0<LookAtModifier3D, OriginFrom> =
        MethodStringName0<LookAtModifier3D, OriginFrom>("get_origin_from")

    @JvmField
    public val setOriginBoneNameName: MethodStringName1<LookAtModifier3D, Unit, String> =
        MethodStringName1<LookAtModifier3D, Unit, String>("set_origin_bone_name")

    @JvmField
    public val getOriginBoneNameName: MethodStringName0<LookAtModifier3D, String> =
        MethodStringName0<LookAtModifier3D, String>("get_origin_bone_name")

    @JvmField
    public val setOriginBoneName: MethodStringName1<LookAtModifier3D, Unit, Int> =
        MethodStringName1<LookAtModifier3D, Unit, Int>("set_origin_bone")

    @JvmField
    public val getOriginBoneName: MethodStringName0<LookAtModifier3D, Int> =
        MethodStringName0<LookAtModifier3D, Int>("get_origin_bone")

    @JvmField
    public val setOriginExternalNodeName: MethodStringName1<LookAtModifier3D, Unit, NodePath> =
        MethodStringName1<LookAtModifier3D, Unit, NodePath>("set_origin_external_node")

    @JvmField
    public val getOriginExternalNodeName: MethodStringName0<LookAtModifier3D, NodePath> =
        MethodStringName0<LookAtModifier3D, NodePath>("get_origin_external_node")

    @JvmField
    public val setOriginOffsetName: MethodStringName1<LookAtModifier3D, Unit, Vector3> =
        MethodStringName1<LookAtModifier3D, Unit, Vector3>("set_origin_offset")

    @JvmField
    public val getOriginOffsetName: MethodStringName0<LookAtModifier3D, Vector3> =
        MethodStringName0<LookAtModifier3D, Vector3>("get_origin_offset")

    @JvmField
    public val setDurationName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_duration")

    @JvmField
    public val getDurationName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_duration")

    @JvmField
    public val setTransitionTypeName:
        MethodStringName1<LookAtModifier3D, Unit, Tween.TransitionType> =
        MethodStringName1<LookAtModifier3D, Unit, Tween.TransitionType>("set_transition_type")

    @JvmField
    public val getTransitionTypeName: MethodStringName0<LookAtModifier3D, Tween.TransitionType> =
        MethodStringName0<LookAtModifier3D, Tween.TransitionType>("get_transition_type")

    @JvmField
    public val setEaseTypeName: MethodStringName1<LookAtModifier3D, Unit, Tween.EaseType> =
        MethodStringName1<LookAtModifier3D, Unit, Tween.EaseType>("set_ease_type")

    @JvmField
    public val getEaseTypeName: MethodStringName0<LookAtModifier3D, Tween.EaseType> =
        MethodStringName0<LookAtModifier3D, Tween.EaseType>("get_ease_type")

    @JvmField
    public val setUseAngleLimitationName: MethodStringName1<LookAtModifier3D, Unit, Boolean> =
        MethodStringName1<LookAtModifier3D, Unit, Boolean>("set_use_angle_limitation")

    @JvmField
    public val isUsingAngleLimitationName: MethodStringName0<LookAtModifier3D, Boolean> =
        MethodStringName0<LookAtModifier3D, Boolean>("is_using_angle_limitation")

    @JvmField
    public val setSymmetryLimitationName: MethodStringName1<LookAtModifier3D, Unit, Boolean> =
        MethodStringName1<LookAtModifier3D, Unit, Boolean>("set_symmetry_limitation")

    @JvmField
    public val isLimitationSymmetryName: MethodStringName0<LookAtModifier3D, Boolean> =
        MethodStringName0<LookAtModifier3D, Boolean>("is_limitation_symmetry")

    @JvmField
    public val setPrimaryLimitAngleName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_primary_limit_angle")

    @JvmField
    public val getPrimaryLimitAngleName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_primary_limit_angle")

    @JvmField
    public val setPrimaryDampThresholdName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_primary_damp_threshold")

    @JvmField
    public val getPrimaryDampThresholdName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_primary_damp_threshold")

    @JvmField
    public val setPrimaryPositiveLimitAngleName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_primary_positive_limit_angle")

    @JvmField
    public val getPrimaryPositiveLimitAngleName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_primary_positive_limit_angle")

    @JvmField
    public val setPrimaryPositiveDampThresholdName: MethodStringName1<LookAtModifier3D, Unit, Float>
        = MethodStringName1<LookAtModifier3D, Unit, Float>("set_primary_positive_damp_threshold")

    @JvmField
    public val getPrimaryPositiveDampThresholdName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_primary_positive_damp_threshold")

    @JvmField
    public val setPrimaryNegativeLimitAngleName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_primary_negative_limit_angle")

    @JvmField
    public val getPrimaryNegativeLimitAngleName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_primary_negative_limit_angle")

    @JvmField
    public val setPrimaryNegativeDampThresholdName: MethodStringName1<LookAtModifier3D, Unit, Float>
        = MethodStringName1<LookAtModifier3D, Unit, Float>("set_primary_negative_damp_threshold")

    @JvmField
    public val getPrimaryNegativeDampThresholdName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_primary_negative_damp_threshold")

    @JvmField
    public val setSecondaryLimitAngleName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_secondary_limit_angle")

    @JvmField
    public val getSecondaryLimitAngleName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_secondary_limit_angle")

    @JvmField
    public val setSecondaryDampThresholdName: MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_secondary_damp_threshold")

    @JvmField
    public val getSecondaryDampThresholdName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_secondary_damp_threshold")

    @JvmField
    public val setSecondaryPositiveLimitAngleName: MethodStringName1<LookAtModifier3D, Unit, Float>
        = MethodStringName1<LookAtModifier3D, Unit, Float>("set_secondary_positive_limit_angle")

    @JvmField
    public val getSecondaryPositiveLimitAngleName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_secondary_positive_limit_angle")

    @JvmField
    public val setSecondaryPositiveDampThresholdName:
        MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_secondary_positive_damp_threshold")

    @JvmField
    public val getSecondaryPositiveDampThresholdName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_secondary_positive_damp_threshold")

    @JvmField
    public val setSecondaryNegativeLimitAngleName: MethodStringName1<LookAtModifier3D, Unit, Float>
        = MethodStringName1<LookAtModifier3D, Unit, Float>("set_secondary_negative_limit_angle")

    @JvmField
    public val getSecondaryNegativeLimitAngleName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_secondary_negative_limit_angle")

    @JvmField
    public val setSecondaryNegativeDampThresholdName:
        MethodStringName1<LookAtModifier3D, Unit, Float> =
        MethodStringName1<LookAtModifier3D, Unit, Float>("set_secondary_negative_damp_threshold")

    @JvmField
    public val getSecondaryNegativeDampThresholdName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_secondary_negative_damp_threshold")

    @JvmField
    public val getInterpolationRemainingName: MethodStringName0<LookAtModifier3D, Float> =
        MethodStringName0<LookAtModifier3D, Float>("get_interpolation_remaining")

    @JvmField
    public val isInterpolatingName: MethodStringName0<LookAtModifier3D, Boolean> =
        MethodStringName0<LookAtModifier3D, Boolean>("is_interpolating")

    @JvmField
    public val isTargetWithinLimitationName: MethodStringName0<LookAtModifier3D, Boolean> =
        MethodStringName0<LookAtModifier3D, Boolean>("is_target_within_limitation")
  }

  public object MethodBindings {
    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_target_node", 1348162250)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_target_node", 4075236667)

    internal val setBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_bone_name", 83702148)

    internal val getBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_bone_name", 201670096)

    internal val setBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_bone", 1286410249)

    internal val getBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_bone", 3905245786)

    internal val setForwardAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_forward_axis", 3199955933)

    internal val getForwardAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_forward_axis", 4076020284)

    internal val setPrimaryRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_primary_rotation_axis", 1144690656)

    internal val getPrimaryRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_primary_rotation_axis", 3050976882)

    internal val setUseSecondaryRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_use_secondary_rotation", 2586408642)

    internal val isUsingSecondaryRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "is_using_secondary_rotation", 36873697)

    internal val setRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_relative", 2586408642)

    internal val isRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "is_relative", 36873697)

    internal val setOriginSafeMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_origin_safe_margin", 373806689)

    internal val getOriginSafeMarginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_origin_safe_margin", 1740695150)

    internal val setOriginFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_origin_from", 4254695669)

    internal val getOriginFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_origin_from", 4057166297)

    internal val setOriginBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_origin_bone_name", 83702148)

    internal val getOriginBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_origin_bone_name", 201670096)

    internal val setOriginBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_origin_bone", 1286410249)

    internal val getOriginBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_origin_bone", 3905245786)

    internal val setOriginExternalNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_origin_external_node", 1348162250)

    internal val getOriginExternalNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_origin_external_node", 4075236667)

    internal val setOriginOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_origin_offset", 3460891852)

    internal val getOriginOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_origin_offset", 3360562783)

    internal val setDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_duration", 373806689)

    internal val getDurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_duration", 1740695150)

    internal val setTransitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_transition_type", 1058637742)

    internal val getTransitionTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_transition_type", 3842314528)

    internal val setEaseTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_ease_type", 1208105857)

    internal val getEaseTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_ease_type", 631880200)

    internal val setUseAngleLimitationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_use_angle_limitation", 2586408642)

    internal val isUsingAngleLimitationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "is_using_angle_limitation", 36873697)

    internal val setSymmetryLimitationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_symmetry_limitation", 2586408642)

    internal val isLimitationSymmetryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "is_limitation_symmetry", 36873697)

    internal val setPrimaryLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_primary_limit_angle", 373806689)

    internal val getPrimaryLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_primary_limit_angle", 1740695150)

    internal val setPrimaryDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_primary_damp_threshold", 373806689)

    internal val getPrimaryDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_primary_damp_threshold", 1740695150)

    internal val setPrimaryPositiveLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_primary_positive_limit_angle", 373806689)

    internal val getPrimaryPositiveLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_primary_positive_limit_angle", 1740695150)

    internal val setPrimaryPositiveDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_primary_positive_damp_threshold", 373806689)

    internal val getPrimaryPositiveDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_primary_positive_damp_threshold", 1740695150)

    internal val setPrimaryNegativeLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_primary_negative_limit_angle", 373806689)

    internal val getPrimaryNegativeLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_primary_negative_limit_angle", 1740695150)

    internal val setPrimaryNegativeDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_primary_negative_damp_threshold", 373806689)

    internal val getPrimaryNegativeDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_primary_negative_damp_threshold", 1740695150)

    internal val setSecondaryLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_secondary_limit_angle", 373806689)

    internal val getSecondaryLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_secondary_limit_angle", 1740695150)

    internal val setSecondaryDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_secondary_damp_threshold", 373806689)

    internal val getSecondaryDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_secondary_damp_threshold", 1740695150)

    internal val setSecondaryPositiveLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_secondary_positive_limit_angle", 373806689)

    internal val getSecondaryPositiveLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_secondary_positive_limit_angle", 1740695150)

    internal val setSecondaryPositiveDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_secondary_positive_damp_threshold", 373806689)

    internal val getSecondaryPositiveDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_secondary_positive_damp_threshold", 1740695150)

    internal val setSecondaryNegativeLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_secondary_negative_limit_angle", 373806689)

    internal val getSecondaryNegativeLimitAnglePtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_secondary_negative_limit_angle", 1740695150)

    internal val setSecondaryNegativeDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "set_secondary_negative_damp_threshold", 373806689)

    internal val getSecondaryNegativeDampThresholdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_secondary_negative_damp_threshold", 1740695150)

    internal val getInterpolationRemainingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "get_interpolation_remaining", 1740695150)

    internal val isInterpolatingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "is_interpolating", 36873697)

    internal val isTargetWithinLimitationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("LookAtModifier3D", "is_target_within_limitation", 36873697)
  }
}
