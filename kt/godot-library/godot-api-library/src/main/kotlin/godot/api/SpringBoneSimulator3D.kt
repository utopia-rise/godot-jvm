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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.NodePath
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.NODE_PATH
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import godot.core.asCachedNodePath
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

/**
 * This [SkeletonModifier3D] can be used to wiggle hair, cloth, and tails. This modifier behaves
 * differently from [PhysicalBoneSimulator3D] as it attempts to return the original pose after
 * modification.
 *
 * If you setup [setRootBone] and [setEndBone], it is treated as one bone chain. Note that it does
 * not support a branched chain like Y-shaped chains.
 *
 * When a bone chain is created, an array is generated from the bones that exist in between and
 * listed in the joint list.
 *
 * Several properties can be applied to each joint, such as [setJointStiffness], [setJointDrag], and
 * [setJointGravity].
 *
 * For simplicity, you can set values to all joints at the same time by using a [Curve]. If you want
 * to specify detailed values individually, set [setIndividualConfig] to `true`.
 *
 * For physical simulation, [SpringBoneSimulator3D] can have children as self-standing collisions
 * that are not related to [PhysicsServer3D], see also [SpringBoneCollision3D].
 *
 * **Warning:** A scaled [SpringBoneSimulator3D] will likely not behave as expected. Make sure that
 * the parent [Skeleton3D] and its bones are not scaled.
 *
 * **Note:** Most methods in this class take an `index` parameter. This parameter specifies which
 * setting list entry to return if the IK has multiple entries (e.g.
 * `settings/<index>/root_bone_name`).
 */
@GodotBaseType
public open class SpringBoneSimulator3D : SkeletonModifier3D() {
  /**
   * The constant force that always affected bones. It is equal to the result when the parent
   * [Skeleton3D] moves at this speed in the opposite direction.
   *
   * This is useful for effects such as wind and anti-gravity.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var externalForce: Vector3
    @JvmName("externalForceProperty")
    get() = getExternalForce()
    @JvmName("externalForceProperty")
    set(`value`) {
      setExternalForce(value)
    }

  /**
   * If `true`, the solver retrieves the bone axis from the bone pose every frame.
   *
   * If `false`, the solver retrieves the bone axis from the bone rest and caches it, which
   * increases performance slightly, but position changes in the bone pose made before processing this
   * [SpringBoneSimulator3D] are ignored.
   */
  public final inline var mutableBoneAxes: Boolean
    @JvmName("mutableBoneAxesProperty")
    get() = areBoneAxesMutable()
    @JvmName("mutableBoneAxesProperty")
    set(`value`) {
      setMutableBoneAxes(value)
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
    createNativeObject(698, scriptPtr)
  }

  /**
   * This is a helper function for [externalForce] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = springbonesimulator3d.externalForce
   * //Your changes
   * springbonesimulator3d.externalForce = myCoreType
   * ``````
   *
   * The constant force that always affected bones. It is equal to the result when the parent
   * [Skeleton3D] moves at this speed in the opposite direction.
   *
   * This is useful for effects such as wind and anti-gravity.
   */
  @CoreTypeHelper
  public final fun externalForceMutate(block: Vector3.() -> Unit): Vector3 = externalForce.apply {
     block(this)
     externalForce = this
  }

  /**
   * Sets the root bone name of the bone chain.
   */
  public final fun setRootBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), STRING to boneName)
    TransferContext.callMethod(MethodBindings.setRootBoneNamePtr)
  }

  /**
   * Returns the root bone name of the bone chain.
   */
  public final fun getRootBoneName(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getRootBoneNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the root bone index of the bone chain.
   */
  public final fun setRootBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to bone.toLong())
    TransferContext.callMethod(MethodBindings.setRootBonePtr)
  }

  /**
   * Returns the root bone index of the bone chain.
   */
  public final fun getRootBone(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getRootBonePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the end bone name of the bone chain.
   *
   * **Note:** End bone must be the root bone or a child of the root bone. If they are the same, the
   * tail must be extended by [setExtendEndBone] to jiggle the bone.
   */
  public final fun setEndBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), STRING to boneName)
    TransferContext.callMethod(MethodBindings.setEndBoneNamePtr)
  }

  /**
   * Returns the end bone name of the bone chain.
   */
  public final fun getEndBoneName(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBoneNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the end bone index of the bone chain.
   */
  public final fun setEndBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to bone.toLong())
    TransferContext.callMethod(MethodBindings.setEndBonePtr)
  }

  /**
   * Returns the end bone index of the bone chain.
   */
  public final fun getEndBone(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBonePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * If [enabled] is `true`, the end bone is extended to have a tail.
   *
   * The extended tail config is allocated to the last element in the joint list. In other words, if
   * you set [enabled] to `false`, the config of the last element in the joint list has no effect in
   * the simulated result.
   */
  public final fun setExtendEndBone(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setExtendEndBonePtr)
  }

  /**
   * Returns `true` if the end bone is extended to have a tail.
   */
  public final fun isEndBoneExtended(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isEndBoneExtendedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the end bone tail direction of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun setEndBoneDirection(index: Int, boneDirection: SkeletonModifier3D.BoneDirection):
      Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to boneDirection.value)
    TransferContext.callMethod(MethodBindings.setEndBoneDirectionPtr)
  }

  /**
   * Returns the tail direction of the end bone of the bone chain when [isEndBoneExtended] is
   * `true`.
   */
  public final fun getEndBoneDirection(index: Int): SkeletonModifier3D.BoneDirection {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBoneDirectionPtr)
    return SkeletonModifier3D.BoneDirection.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the end bone tail length of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun setEndBoneLength(index: Int, length: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to length.toDouble())
    TransferContext.callMethod(MethodBindings.setEndBoneLengthPtr)
  }

  /**
   * Returns the end bone tail length of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun getEndBoneLength(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBoneLengthPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets what the center originates from in the bone chain.
   *
   * Bone movement is calculated based on the difference in relative distance between center and
   * bone in the previous and next frames.
   *
   * For example, if the parent [Skeleton3D] is used as the center, the bones are considered to have
   * not moved if the [Skeleton3D] moves in the world.
   *
   * In this case, only a change in the bone pose is considered to be a bone movement.
   */
  public final fun setCenterFrom(index: Int, centerFrom: CenterFrom): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to centerFrom.value)
    TransferContext.callMethod(MethodBindings.setCenterFromPtr)
  }

  /**
   * Returns what the center originates from in the bone chain.
   */
  public final fun getCenterFrom(index: Int): CenterFrom {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getCenterFromPtr)
    return CenterFrom.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the center node path of the bone chain.
   */
  public final fun setCenterNode(index: Int, nodePath: NodePath): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), NODE_PATH to nodePath)
    TransferContext.callMethod(MethodBindings.setCenterNodePtr)
  }

  /**
   * Returns the center node path of the bone chain.
   */
  public final fun getCenterNode(index: Int): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getCenterNodePtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Sets the center bone name of the bone chain.
   */
  public final fun setCenterBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), STRING to boneName)
    TransferContext.callMethod(MethodBindings.setCenterBoneNamePtr)
  }

  /**
   * Returns the center bone name of the bone chain.
   */
  public final fun getCenterBoneName(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getCenterBoneNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Sets the center bone index of the bone chain.
   */
  public final fun setCenterBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to bone.toLong())
    TransferContext.callMethod(MethodBindings.setCenterBonePtr)
  }

  /**
   * Returns the center bone index of the bone chain.
   */
  public final fun getCenterBone(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getCenterBonePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the joint radius of the bone chain. It is used to move and slide with the
   * [SpringBoneCollision3D] in the collision list.
   *
   * The value is scaled by [setRadiusDampingCurve] and cached in each joint setting in the joint
   * list.
   */
  public final fun setRadius(index: Int, radius: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setRadiusPtr)
  }

  /**
   * Returns the joint radius of the bone chain.
   */
  public final fun getRadius(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the rotation axis of the bone chain. If set to a specific axis, it acts like a hinge
   * joint. The value is cached in each joint setting in the joint list.
   *
   * The axes are based on the reference pose's space, if [axis] is
   * [SkeletonModifier3D.ROTATION_AXIS_CUSTOM], you can specify any axis.
   *
   * In here, the reference pose is the bone pose immediately before the simulation.
   *
   * **Note:** The rotation axis vector and the forward vector shouldn't be colinear to avoid
   * unintended rotation since [SpringBoneSimulator3D] does not factor in twisting forces.
   */
  public final fun setRotationAxis(index: Int, axis: SkeletonModifier3D.RotationAxis): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to axis.value)
    TransferContext.callMethod(MethodBindings.setRotationAxisPtr)
  }

  /**
   * Returns the rotation axis of the bone chain.
   */
  public final fun getRotationAxis(index: Int): SkeletonModifier3D.RotationAxis {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getRotationAxisPtr)
    return SkeletonModifier3D.RotationAxis.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the rotation axis vector of the bone chain. The value is cached in each joint setting in
   * the joint list.
   *
   * This vector is normalized by an internal process and represents the axis around which the bone
   * chain can rotate.
   *
   * If the vector length is `0`, it is considered synonymous with
   * [SkeletonModifier3D.ROTATION_AXIS_ALL].
   */
  public final fun setRotationAxisVector(index: Int, vector: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), VECTOR3 to vector)
    TransferContext.callMethod(MethodBindings.setRotationAxisVectorPtr)
  }

  /**
   * Returns the rotation axis vector of the bone chain. This vector represents the axis around
   * which the bone chain can rotate. It is determined based on the rotation axis set for the bone
   * chain.
   *
   * If [getRotationAxis] is [SkeletonModifier3D.ROTATION_AXIS_ALL], this method returns `Vector3(0,
   * 0, 0)`.
   */
  public final fun getRotationAxisVector(index: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getRotationAxisVectorPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the joint radius damping curve of the bone chain.
   */
  public final fun setRadiusDampingCurve(index: Int, curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setRadiusDampingCurvePtr)
  }

  /**
   * Returns the joint radius damping curve of the bone chain.
   */
  public final fun getRadiusDampingCurve(index: Int): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getRadiusDampingCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  /**
   * Sets the stiffness force of the bone chain. The greater the value, the faster it recovers to
   * its initial pose.
   *
   * If [stiffness] is `0`, the modified pose will not return to the original pose.
   *
   * The value is scaled by [setStiffnessDampingCurve] and cached in each joint setting in the joint
   * list.
   */
  public final fun setStiffness(index: Int, stiffness: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to stiffness.toDouble())
    TransferContext.callMethod(MethodBindings.setStiffnessPtr)
  }

  /**
   * Returns the stiffness force of the bone chain.
   */
  public final fun getStiffness(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStiffnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the stiffness force damping curve of the bone chain.
   */
  public final fun setStiffnessDampingCurve(index: Int, curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setStiffnessDampingCurvePtr)
  }

  /**
   * Returns the stiffness force damping curve of the bone chain.
   */
  public final fun getStiffnessDampingCurve(index: Int): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getStiffnessDampingCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  /**
   * Sets the drag force of the bone chain. The greater the value, the more suppressed the wiggling.
   *
   * The value is scaled by [setDragDampingCurve] and cached in each joint setting in the joint
   * list.
   */
  public final fun setDrag(index: Int, drag: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to drag.toDouble())
    TransferContext.callMethod(MethodBindings.setDragPtr)
  }

  /**
   * Returns the drag force damping curve of the bone chain.
   */
  public final fun getDrag(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getDragPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the drag force damping curve of the bone chain.
   */
  public final fun setDragDampingCurve(index: Int, curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setDragDampingCurvePtr)
  }

  /**
   * Returns the drag force damping curve of the bone chain.
   */
  public final fun getDragDampingCurve(index: Int): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getDragDampingCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  /**
   * Sets the gravity amount of the bone chain. This value is not an acceleration, but a constant
   * velocity of movement in [setGravityDirection].
   *
   * If [gravity] is not `0`, the modified pose will not return to the original pose since it is
   * always affected by gravity.
   *
   * The value is scaled by [setGravityDampingCurve] and cached in each joint setting in the joint
   * list.
   */
  public final fun setGravity(index: Int, gravity: Float): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), DOUBLE to gravity.toDouble())
    TransferContext.callMethod(MethodBindings.setGravityPtr)
  }

  /**
   * Returns the gravity amount of the bone chain.
   */
  public final fun getGravity(index: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getGravityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the gravity amount damping curve of the bone chain.
   */
  public final fun setGravityDampingCurve(index: Int, curve: Curve?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), OBJECT to curve)
    TransferContext.callMethod(MethodBindings.setGravityDampingCurvePtr)
  }

  /**
   * Returns the gravity amount damping curve of the bone chain.
   */
  public final fun getGravityDampingCurve(index: Int): Curve? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getGravityDampingCurvePtr)
    return (TransferContext.readReturnValue(OBJECT) as Curve?)
  }

  /**
   * Sets the gravity direction of the bone chain. This value is internally normalized and then
   * multiplied by [setGravity].
   *
   * The value is cached in each joint setting in the joint list.
   */
  public final fun setGravityDirection(index: Int, gravityDirection: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), VECTOR3 to gravityDirection)
    TransferContext.callMethod(MethodBindings.setGravityDirectionPtr)
  }

  /**
   * Returns the gravity direction of the bone chain.
   */
  public final fun getGravityDirection(index: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getGravityDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setSettingCount(count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setSettingCountPtr)
  }

  public final fun getSettingCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSettingCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Clears all settings.
   */
  public final fun clearSettings(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearSettingsPtr)
  }

  /**
   * If [enabled] is `true`, the config can be edited individually for each joint.
   */
  public final fun setIndividualConfig(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setIndividualConfigPtr)
  }

  /**
   * Returns `true` if the config can be edited individually for each joint.
   */
  public final fun isConfigIndividual(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isConfigIndividualPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the bone name at [joint] in the bone chain's joint list.
   */
  public final fun getJointBoneName(index: Int, joint: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointBoneNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the bone index at [joint] in the bone chain's joint list.
   */
  public final fun getJointBone(index: Int, joint: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointBonePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Sets the rotation axis at [joint] in the bone chain's joint list when [isConfigIndividual] is
   * `true`.
   *
   * The axes are based on the reference pose's space, if [axis] is
   * [SkeletonModifier3D.ROTATION_AXIS_CUSTOM], you can specify any axis.
   *
   * In here, the reference pose is the bone pose immediately before the simulation.
   *
   * **Note:** The rotation axis and the forward vector shouldn't be colinear to avoid unintended
   * rotation since [SpringBoneSimulator3D] does not factor in twisting forces.
   */
  public final fun setJointRotationAxis(
    index: Int,
    joint: Int,
    axis: SkeletonModifier3D.RotationAxis,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong(), LONG to axis.value)
    TransferContext.callMethod(MethodBindings.setJointRotationAxisPtr)
  }

  /**
   * Returns the rotation axis at [joint] in the bone chain's joint list.
   */
  public final fun getJointRotationAxis(index: Int, joint: Int): SkeletonModifier3D.RotationAxis {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointRotationAxisPtr)
    return SkeletonModifier3D.RotationAxis.from(TransferContext.readReturnValue(LONG) as Long)
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
    vector: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong(), VECTOR3 to vector)
    TransferContext.callMethod(MethodBindings.setJointRotationAxisVectorPtr)
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
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointRotationAxisVectorPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Sets the joint radius at [joint] in the bone chain's joint list when [isConfigIndividual] is
   * `true`.
   */
  public final fun setJointRadius(
    index: Int,
    joint: Int,
    radius: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong(), DOUBLE to radius.toDouble())
    TransferContext.callMethod(MethodBindings.setJointRadiusPtr)
  }

  /**
   * Returns the radius at [joint] in the bone chain's joint list.
   */
  public final fun getJointRadius(index: Int, joint: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointRadiusPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the stiffness force at [joint] in the bone chain's joint list when [isConfigIndividual] is
   * `true`.
   */
  public final fun setJointStiffness(
    index: Int,
    joint: Int,
    stiffness: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong(), DOUBLE to stiffness.toDouble())
    TransferContext.callMethod(MethodBindings.setJointStiffnessPtr)
  }

  /**
   * Returns the stiffness force at [joint] in the bone chain's joint list.
   */
  public final fun getJointStiffness(index: Int, joint: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointStiffnessPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the drag force at [joint] in the bone chain's joint list when [isConfigIndividual] is
   * `true`.
   */
  public final fun setJointDrag(
    index: Int,
    joint: Int,
    drag: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong(), DOUBLE to drag.toDouble())
    TransferContext.callMethod(MethodBindings.setJointDragPtr)
  }

  /**
   * Returns the drag force at [joint] in the bone chain's joint list.
   */
  public final fun getJointDrag(index: Int, joint: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointDragPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the gravity amount at [joint] in the bone chain's joint list when [isConfigIndividual] is
   * `true`.
   */
  public final fun setJointGravity(
    index: Int,
    joint: Int,
    gravity: Float,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong(), DOUBLE to gravity.toDouble())
    TransferContext.callMethod(MethodBindings.setJointGravityPtr)
  }

  /**
   * Returns the gravity amount at [joint] in the bone chain's joint list.
   */
  public final fun getJointGravity(index: Int, joint: Int): Float {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointGravityPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double).toFloat()
  }

  /**
   * Sets the gravity direction at [joint] in the bone chain's joint list when [isConfigIndividual]
   * is `true`.
   */
  public final fun setJointGravityDirection(
    index: Int,
    joint: Int,
    gravityDirection: Vector3,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong(), VECTOR3 to gravityDirection)
    TransferContext.callMethod(MethodBindings.setJointGravityDirectionPtr)
  }

  /**
   * Returns the gravity direction at [joint] in the bone chain's joint list.
   */
  public final fun getJointGravityDirection(index: Int, joint: Int): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointGravityDirectionPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  /**
   * Returns the joint count of the bone chain's joint list.
   */
  public final fun getJointCount(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getJointCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * If [enabled] is `true`, all child [SpringBoneCollision3D]s are colliding and
   * [setExcludeCollisionPath] is enabled as an exclusion list at [index] in the settings.
   *
   * If [enabled] is `false`, you need to manually register all valid collisions with
   * [setCollisionPath].
   */
  public final fun setEnableAllChildCollisions(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEnableAllChildCollisionsPtr)
  }

  /**
   * Returns `true` if all child [SpringBoneCollision3D]s are contained in the collision list at
   * [index] in the settings.
   */
  public final fun areAllChildCollisionsEnabled(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.areAllChildCollisionsEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets the node path of the [SpringBoneCollision3D] at [collision] in the bone chain's exclude
   * collision list when [areAllChildCollisionsEnabled] is `true`.
   */
  public final fun setExcludeCollisionPath(
    index: Int,
    collision: Int,
    nodePath: NodePath,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to collision.toLong(), NODE_PATH to nodePath)
    TransferContext.callMethod(MethodBindings.setExcludeCollisionPathPtr)
  }

  /**
   * Returns the node path of the [SpringBoneCollision3D] at [collision] in the bone chain's exclude
   * collision list when [areAllChildCollisionsEnabled] is `true`.
   */
  public final fun getExcludeCollisionPath(index: Int, collision: Int): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to collision.toLong())
    TransferContext.callMethod(MethodBindings.getExcludeCollisionPathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Sets the number of exclude collisions in the exclude collision list at [index] in the settings
   * when [areAllChildCollisionsEnabled] is `true`.
   */
  public final fun setExcludeCollisionCount(index: Int, count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setExcludeCollisionCountPtr)
  }

  /**
   * Returns the exclude collision count of the bone chain's exclude collision list when
   * [areAllChildCollisionsEnabled] is `true`.
   */
  public final fun getExcludeCollisionCount(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getExcludeCollisionCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Clears all exclude collisions from the collision list at [index] in the settings when
   * [areAllChildCollisionsEnabled] is `true`.
   */
  public final fun clearExcludeCollisions(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.clearExcludeCollisionsPtr)
  }

  /**
   * Sets the node path of the [SpringBoneCollision3D] at [collision] in the bone chain's collision
   * list when [areAllChildCollisionsEnabled] is `false`.
   */
  public final fun setCollisionPath(
    index: Int,
    collision: Int,
    nodePath: NodePath,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to collision.toLong(), NODE_PATH to nodePath)
    TransferContext.callMethod(MethodBindings.setCollisionPathPtr)
  }

  /**
   * Returns the node path of the [SpringBoneCollision3D] at [collision] in the bone chain's
   * collision list when [areAllChildCollisionsEnabled] is `false`.
   */
  public final fun getCollisionPath(index: Int, collision: Int): NodePath {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to collision.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionPathPtr)
    return (TransferContext.readReturnValue(NODE_PATH) as NodePath)
  }

  /**
   * Sets the number of collisions in the collision list at [index] in the settings when
   * [areAllChildCollisionsEnabled] is `false`.
   */
  public final fun setCollisionCount(index: Int, count: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to count.toLong())
    TransferContext.callMethod(MethodBindings.setCollisionCountPtr)
  }

  /**
   * Returns the collision count of the bone chain's collision list when
   * [areAllChildCollisionsEnabled] is `false`.
   */
  public final fun getCollisionCount(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getCollisionCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Clears all collisions from the collision list at [index] in the settings when
   * [areAllChildCollisionsEnabled] is `false`.
   */
  public final fun clearCollisions(index: Int): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.clearCollisionsPtr)
  }

  public final fun setExternalForce(force: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to force)
    TransferContext.callMethod(MethodBindings.setExternalForcePtr)
  }

  public final fun getExternalForce(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExternalForcePtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setMutableBoneAxes(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setMutableBoneAxesPtr)
  }

  public final fun areBoneAxesMutable(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areBoneAxesMutablePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Resets a simulating state with respect to the current bone pose.
   *
   * It is useful to prevent the simulation result getting violent. For example, calling this
   * immediately after a call to [AnimationPlayer.play] without a fading, or within the previous
   * [signal SkeletonModifier3D.modification_processed] signal if it's condition changes significantly.
   */
  public final fun reset(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetPtr)
  }

  /**
   * Sets the center node path of the bone chain.
   */
  public final fun setCenterNode(index: Int, nodePath: String) =
      setCenterNode(index, nodePath.asCachedNodePath())

  /**
   * Sets the node path of the [SpringBoneCollision3D] at [collision] in the bone chain's exclude
   * collision list when [areAllChildCollisionsEnabled] is `true`.
   */
  public final fun setExcludeCollisionPath(
    index: Int,
    collision: Int,
    nodePath: String,
  ) = setExcludeCollisionPath(index, collision, nodePath.asCachedNodePath())

  /**
   * Sets the node path of the [SpringBoneCollision3D] at [collision] in the bone chain's collision
   * list when [areAllChildCollisionsEnabled] is `false`.
   */
  public final fun setCollisionPath(
    index: Int,
    collision: Int,
    nodePath: String,
  ) = setCollisionPath(index, collision, nodePath.asCachedNodePath())

  public enum class CenterFrom(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The world origin is defined as center.
     */
    WORLD_ORIGIN(0),
    /**
     * The [Node3D] specified by [setCenterNode] is defined as center.
     *
     * If [Node3D] is not found, the parent [Skeleton3D] is treated as center.
     */
    NODE(1),
    /**
     * The bone pose origin of the parent [Skeleton3D] specified by [setCenterBone] is defined as
     * center.
     *
     * If [Node3D] is not found, the parent [Skeleton3D] is treated as center.
     */
    BONE(2),
    ;

    public companion object {
      public fun from(`value`: Long): CenterFrom = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setRootBoneNameName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, String> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, String>("set_root_bone_name")

    @JvmField
    public val getRootBoneNameName: MethodStringName1<SpringBoneSimulator3D, String, Int> =
        MethodStringName1<SpringBoneSimulator3D, String, Int>("get_root_bone_name")

    @JvmField
    public val setRootBoneName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int>("set_root_bone")

    @JvmField
    public val getRootBoneName: MethodStringName1<SpringBoneSimulator3D, Int, Int> =
        MethodStringName1<SpringBoneSimulator3D, Int, Int>("get_root_bone")

    @JvmField
    public val setEndBoneNameName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, String> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, String>("set_end_bone_name")

    @JvmField
    public val getEndBoneNameName: MethodStringName1<SpringBoneSimulator3D, String, Int> =
        MethodStringName1<SpringBoneSimulator3D, String, Int>("get_end_bone_name")

    @JvmField
    public val setEndBoneName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int>("set_end_bone")

    @JvmField
    public val getEndBoneName: MethodStringName1<SpringBoneSimulator3D, Int, Int> =
        MethodStringName1<SpringBoneSimulator3D, Int, Int>("get_end_bone")

    @JvmField
    public val setExtendEndBoneName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Boolean> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Boolean>("set_extend_end_bone")

    @JvmField
    public val isEndBoneExtendedName: MethodStringName1<SpringBoneSimulator3D, Boolean, Int> =
        MethodStringName1<SpringBoneSimulator3D, Boolean, Int>("is_end_bone_extended")

    @JvmField
    public val setEndBoneDirectionName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, SkeletonModifier3D.BoneDirection> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, SkeletonModifier3D.BoneDirection>("set_end_bone_direction")

    @JvmField
    public val getEndBoneDirectionName:
        MethodStringName1<SpringBoneSimulator3D, SkeletonModifier3D.BoneDirection, Int> =
        MethodStringName1<SpringBoneSimulator3D, SkeletonModifier3D.BoneDirection, Int>("get_end_bone_direction")

    @JvmField
    public val setEndBoneLengthName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float>("set_end_bone_length")

    @JvmField
    public val getEndBoneLengthName: MethodStringName1<SpringBoneSimulator3D, Float, Int> =
        MethodStringName1<SpringBoneSimulator3D, Float, Int>("get_end_bone_length")

    @JvmField
    public val setCenterFromName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, CenterFrom> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, CenterFrom>("set_center_from")

    @JvmField
    public val getCenterFromName: MethodStringName1<SpringBoneSimulator3D, CenterFrom, Int> =
        MethodStringName1<SpringBoneSimulator3D, CenterFrom, Int>("get_center_from")

    @JvmField
    public val setCenterNodeName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, NodePath> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, NodePath>("set_center_node")

    @JvmField
    public val getCenterNodeName: MethodStringName1<SpringBoneSimulator3D, NodePath, Int> =
        MethodStringName1<SpringBoneSimulator3D, NodePath, Int>("get_center_node")

    @JvmField
    public val setCenterBoneNameName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, String> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, String>("set_center_bone_name")

    @JvmField
    public val getCenterBoneNameName: MethodStringName1<SpringBoneSimulator3D, String, Int> =
        MethodStringName1<SpringBoneSimulator3D, String, Int>("get_center_bone_name")

    @JvmField
    public val setCenterBoneName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int>("set_center_bone")

    @JvmField
    public val getCenterBoneName: MethodStringName1<SpringBoneSimulator3D, Int, Int> =
        MethodStringName1<SpringBoneSimulator3D, Int, Int>("get_center_bone")

    @JvmField
    public val setRadiusName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float>("set_radius")

    @JvmField
    public val getRadiusName: MethodStringName1<SpringBoneSimulator3D, Float, Int> =
        MethodStringName1<SpringBoneSimulator3D, Float, Int>("get_radius")

    @JvmField
    public val setRotationAxisName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, SkeletonModifier3D.RotationAxis> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, SkeletonModifier3D.RotationAxis>("set_rotation_axis")

    @JvmField
    public val getRotationAxisName:
        MethodStringName1<SpringBoneSimulator3D, SkeletonModifier3D.RotationAxis, Int> =
        MethodStringName1<SpringBoneSimulator3D, SkeletonModifier3D.RotationAxis, Int>("get_rotation_axis")

    @JvmField
    public val setRotationAxisVectorName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Vector3> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Vector3>("set_rotation_axis_vector")

    @JvmField
    public val getRotationAxisVectorName: MethodStringName1<SpringBoneSimulator3D, Vector3, Int> =
        MethodStringName1<SpringBoneSimulator3D, Vector3, Int>("get_rotation_axis_vector")

    @JvmField
    public val setRadiusDampingCurveName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?>("set_radius_damping_curve")

    @JvmField
    public val getRadiusDampingCurveName: MethodStringName1<SpringBoneSimulator3D, Curve?, Int> =
        MethodStringName1<SpringBoneSimulator3D, Curve?, Int>("get_radius_damping_curve")

    @JvmField
    public val setStiffnessName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float>("set_stiffness")

    @JvmField
    public val getStiffnessName: MethodStringName1<SpringBoneSimulator3D, Float, Int> =
        MethodStringName1<SpringBoneSimulator3D, Float, Int>("get_stiffness")

    @JvmField
    public val setStiffnessDampingCurveName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?>("set_stiffness_damping_curve")

    @JvmField
    public val getStiffnessDampingCurveName: MethodStringName1<SpringBoneSimulator3D, Curve?, Int> =
        MethodStringName1<SpringBoneSimulator3D, Curve?, Int>("get_stiffness_damping_curve")

    @JvmField
    public val setDragName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float>("set_drag")

    @JvmField
    public val getDragName: MethodStringName1<SpringBoneSimulator3D, Float, Int> =
        MethodStringName1<SpringBoneSimulator3D, Float, Int>("get_drag")

    @JvmField
    public val setDragDampingCurveName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?>
        = MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?>("set_drag_damping_curve")

    @JvmField
    public val getDragDampingCurveName: MethodStringName1<SpringBoneSimulator3D, Curve?, Int> =
        MethodStringName1<SpringBoneSimulator3D, Curve?, Int>("get_drag_damping_curve")

    @JvmField
    public val setGravityName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Float>("set_gravity")

    @JvmField
    public val getGravityName: MethodStringName1<SpringBoneSimulator3D, Float, Int> =
        MethodStringName1<SpringBoneSimulator3D, Float, Int>("get_gravity")

    @JvmField
    public val setGravityDampingCurveName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Curve?>("set_gravity_damping_curve")

    @JvmField
    public val getGravityDampingCurveName: MethodStringName1<SpringBoneSimulator3D, Curve?, Int> =
        MethodStringName1<SpringBoneSimulator3D, Curve?, Int>("get_gravity_damping_curve")

    @JvmField
    public val setGravityDirectionName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Vector3>
        = MethodStringName2<SpringBoneSimulator3D, Unit, Int, Vector3>("set_gravity_direction")

    @JvmField
    public val getGravityDirectionName: MethodStringName1<SpringBoneSimulator3D, Vector3, Int> =
        MethodStringName1<SpringBoneSimulator3D, Vector3, Int>("get_gravity_direction")

    @JvmField
    public val setSettingCountName: MethodStringName1<SpringBoneSimulator3D, Unit, Int> =
        MethodStringName1<SpringBoneSimulator3D, Unit, Int>("set_setting_count")

    @JvmField
    public val getSettingCountName: MethodStringName0<SpringBoneSimulator3D, Int> =
        MethodStringName0<SpringBoneSimulator3D, Int>("get_setting_count")

    @JvmField
    public val clearSettingsName: MethodStringName0<SpringBoneSimulator3D, Unit> =
        MethodStringName0<SpringBoneSimulator3D, Unit>("clear_settings")

    @JvmField
    public val setIndividualConfigName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Boolean>
        = MethodStringName2<SpringBoneSimulator3D, Unit, Int, Boolean>("set_individual_config")

    @JvmField
    public val isConfigIndividualName: MethodStringName1<SpringBoneSimulator3D, Boolean, Int> =
        MethodStringName1<SpringBoneSimulator3D, Boolean, Int>("is_config_individual")

    @JvmField
    public val getJointBoneNameName: MethodStringName2<SpringBoneSimulator3D, String, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, String, Int, Int>("get_joint_bone_name")

    @JvmField
    public val getJointBoneName: MethodStringName2<SpringBoneSimulator3D, Int, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Int, Int, Int>("get_joint_bone")

    @JvmField
    public val setJointRotationAxisName:
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, SkeletonModifier3D.RotationAxis> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, SkeletonModifier3D.RotationAxis>("set_joint_rotation_axis")

    @JvmField
    public val getJointRotationAxisName:
        MethodStringName2<SpringBoneSimulator3D, SkeletonModifier3D.RotationAxis, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, SkeletonModifier3D.RotationAxis, Int, Int>("get_joint_rotation_axis")

    @JvmField
    public val setJointRotationAxisVectorName:
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Vector3> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Vector3>("set_joint_rotation_axis_vector")

    @JvmField
    public val getJointRotationAxisVectorName:
        MethodStringName2<SpringBoneSimulator3D, Vector3, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Vector3, Int, Int>("get_joint_rotation_axis_vector")

    @JvmField
    public val setJointRadiusName: MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float>("set_joint_radius")

    @JvmField
    public val getJointRadiusName: MethodStringName2<SpringBoneSimulator3D, Float, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Float, Int, Int>("get_joint_radius")

    @JvmField
    public val setJointStiffnessName:
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float>("set_joint_stiffness")

    @JvmField
    public val getJointStiffnessName: MethodStringName2<SpringBoneSimulator3D, Float, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Float, Int, Int>("get_joint_stiffness")

    @JvmField
    public val setJointDragName: MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float>("set_joint_drag")

    @JvmField
    public val getJointDragName: MethodStringName2<SpringBoneSimulator3D, Float, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Float, Int, Int>("get_joint_drag")

    @JvmField
    public val setJointGravityName: MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float>
        = MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Float>("set_joint_gravity")

    @JvmField
    public val getJointGravityName: MethodStringName2<SpringBoneSimulator3D, Float, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Float, Int, Int>("get_joint_gravity")

    @JvmField
    public val setJointGravityDirectionName:
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Vector3> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, Vector3>("set_joint_gravity_direction")

    @JvmField
    public val getJointGravityDirectionName:
        MethodStringName2<SpringBoneSimulator3D, Vector3, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Vector3, Int, Int>("get_joint_gravity_direction")

    @JvmField
    public val getJointCountName: MethodStringName1<SpringBoneSimulator3D, Int, Int> =
        MethodStringName1<SpringBoneSimulator3D, Int, Int>("get_joint_count")

    @JvmField
    public val setEnableAllChildCollisionsName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Boolean> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Boolean>("set_enable_all_child_collisions")

    @JvmField
    public val areAllChildCollisionsEnabledName:
        MethodStringName1<SpringBoneSimulator3D, Boolean, Int> =
        MethodStringName1<SpringBoneSimulator3D, Boolean, Int>("are_all_child_collisions_enabled")

    @JvmField
    public val setExcludeCollisionPathName:
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, NodePath> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, NodePath>("set_exclude_collision_path")

    @JvmField
    public val getExcludeCollisionPathName:
        MethodStringName2<SpringBoneSimulator3D, NodePath, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, NodePath, Int, Int>("get_exclude_collision_path")

    @JvmField
    public val setExcludeCollisionCountName:
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int>("set_exclude_collision_count")

    @JvmField
    public val getExcludeCollisionCountName: MethodStringName1<SpringBoneSimulator3D, Int, Int> =
        MethodStringName1<SpringBoneSimulator3D, Int, Int>("get_exclude_collision_count")

    @JvmField
    public val clearExcludeCollisionsName: MethodStringName1<SpringBoneSimulator3D, Unit, Int> =
        MethodStringName1<SpringBoneSimulator3D, Unit, Int>("clear_exclude_collisions")

    @JvmField
    public val setCollisionPathName:
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, NodePath> =
        MethodStringName3<SpringBoneSimulator3D, Unit, Int, Int, NodePath>("set_collision_path")

    @JvmField
    public val getCollisionPathName: MethodStringName2<SpringBoneSimulator3D, NodePath, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, NodePath, Int, Int>("get_collision_path")

    @JvmField
    public val setCollisionCountName: MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int> =
        MethodStringName2<SpringBoneSimulator3D, Unit, Int, Int>("set_collision_count")

    @JvmField
    public val getCollisionCountName: MethodStringName1<SpringBoneSimulator3D, Int, Int> =
        MethodStringName1<SpringBoneSimulator3D, Int, Int>("get_collision_count")

    @JvmField
    public val clearCollisionsName: MethodStringName1<SpringBoneSimulator3D, Unit, Int> =
        MethodStringName1<SpringBoneSimulator3D, Unit, Int>("clear_collisions")

    @JvmField
    public val setExternalForceName: MethodStringName1<SpringBoneSimulator3D, Unit, Vector3> =
        MethodStringName1<SpringBoneSimulator3D, Unit, Vector3>("set_external_force")

    @JvmField
    public val getExternalForceName: MethodStringName0<SpringBoneSimulator3D, Vector3> =
        MethodStringName0<SpringBoneSimulator3D, Vector3>("get_external_force")

    @JvmField
    public val setMutableBoneAxesName: MethodStringName1<SpringBoneSimulator3D, Unit, Boolean> =
        MethodStringName1<SpringBoneSimulator3D, Unit, Boolean>("set_mutable_bone_axes")

    @JvmField
    public val areBoneAxesMutableName: MethodStringName0<SpringBoneSimulator3D, Boolean> =
        MethodStringName0<SpringBoneSimulator3D, Boolean>("are_bone_axes_mutable")

    @JvmField
    public val resetName: MethodStringName0<SpringBoneSimulator3D, Unit> =
        MethodStringName0<SpringBoneSimulator3D, Unit>("reset")
  }

  public object MethodBindings {
    internal val setRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_root_bone_name", 501894301)

    internal val getRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_root_bone_name", 844755477)

    internal val setRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_root_bone", 3937882851)

    internal val getRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_root_bone", 923996154)

    internal val setEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_end_bone_name", 501894301)

    internal val getEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_end_bone_name", 844755477)

    internal val setEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_end_bone", 3937882851)

    internal val getEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_end_bone", 923996154)

    internal val setExtendEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_extend_end_bone", 300928843)

    internal val isEndBoneExtendedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "is_end_bone_extended", 1116898809)

    internal val setEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_end_bone_direction", 2838484201)

    internal val getEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_end_bone_direction", 1843036459)

    internal val setEndBoneLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_end_bone_length", 1602489585)

    internal val getEndBoneLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_end_bone_length", 2339986948)

    internal val setCenterFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_center_from", 2551505749)

    internal val getCenterFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_center_from", 2721930813)

    internal val setCenterNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_center_node", 2761262315)

    internal val getCenterNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_center_node", 408788394)

    internal val setCenterBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_center_bone_name", 501894301)

    internal val getCenterBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_center_bone_name", 844755477)

    internal val setCenterBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_center_bone", 3937882851)

    internal val getCenterBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_center_bone", 923996154)

    internal val setRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_radius", 1602489585)

    internal val getRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_radius", 2339986948)

    internal val setRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_rotation_axis", 1539703856)

    internal val getRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_rotation_axis", 2844851118)

    internal val setRotationAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_rotation_axis_vector", 1530502735)

    internal val getRotationAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_rotation_axis_vector", 711720468)

    internal val setRadiusDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_radius_damping_curve", 1447180063)

    internal val getRadiusDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_radius_damping_curve", 747537754)

    internal val setStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_stiffness", 1602489585)

    internal val getStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_stiffness", 2339986948)

    internal val setStiffnessDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_stiffness_damping_curve", 1447180063)

    internal val getStiffnessDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_stiffness_damping_curve", 747537754)

    internal val setDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_drag", 1602489585)

    internal val getDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_drag", 2339986948)

    internal val setDragDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_drag_damping_curve", 1447180063)

    internal val getDragDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_drag_damping_curve", 747537754)

    internal val setGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_gravity", 1602489585)

    internal val getGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_gravity", 2339986948)

    internal val setGravityDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_gravity_damping_curve", 1447180063)

    internal val getGravityDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_gravity_damping_curve", 747537754)

    internal val setGravityDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_gravity_direction", 1530502735)

    internal val getGravityDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_gravity_direction", 711720468)

    internal val setSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_setting_count", 1286410249)

    internal val getSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_setting_count", 3905245786)

    internal val clearSettingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "clear_settings", 3218959716)

    internal val setIndividualConfigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_individual_config", 300928843)

    internal val isConfigIndividualPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "is_config_individual", 1116898809)

    internal val getJointBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_bone_name", 1391810591)

    internal val getJointBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_bone", 3175239445)

    internal val setJointRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_joint_rotation_axis", 1391134969)

    internal val getJointRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_rotation_axis", 3312594080)

    internal val setJointRotationAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_joint_rotation_axis_vector", 2866752138)

    internal val getJointRotationAxisVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_rotation_axis_vector", 1592972041)

    internal val setJointRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_joint_radius", 3506521499)

    internal val getJointRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_radius", 3085491603)

    internal val setJointStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_joint_stiffness", 3506521499)

    internal val getJointStiffnessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_stiffness", 3085491603)

    internal val setJointDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_joint_drag", 3506521499)

    internal val getJointDragPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_drag", 3085491603)

    internal val setJointGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_joint_gravity", 3506521499)

    internal val getJointGravityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_gravity", 3085491603)

    internal val setJointGravityDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_joint_gravity_direction", 2866752138)

    internal val getJointGravityDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_gravity_direction", 1592972041)

    internal val getJointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_joint_count", 923996154)

    internal val setEnableAllChildCollisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_enable_all_child_collisions", 300928843)

    internal val areAllChildCollisionsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "are_all_child_collisions_enabled", 1116898809)

    internal val setExcludeCollisionPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_exclude_collision_path", 132481804)

    internal val getExcludeCollisionPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_exclude_collision_path", 464924783)

    internal val setExcludeCollisionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_exclude_collision_count", 3937882851)

    internal val getExcludeCollisionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_exclude_collision_count", 923996154)

    internal val clearExcludeCollisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "clear_exclude_collisions", 1286410249)

    internal val setCollisionPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_collision_path", 132481804)

    internal val getCollisionPathPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_collision_path", 464924783)

    internal val setCollisionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_collision_count", 3937882851)

    internal val getCollisionCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_collision_count", 923996154)

    internal val clearCollisionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "clear_collisions", 1286410249)

    internal val setExternalForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_external_force", 3460891852)

    internal val getExternalForcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "get_external_force", 3360562783)

    internal val setMutableBoneAxesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "set_mutable_bone_axes", 2586408642)

    internal val areBoneAxesMutablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "are_bone_axes_mutable", 36873697)

    internal val resetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SpringBoneSimulator3D", "reset", 3218959716)
  }
}
