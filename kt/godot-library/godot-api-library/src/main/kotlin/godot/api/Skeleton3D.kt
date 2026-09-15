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
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName4
import godot.core.PackedInt32Array
import godot.core.Quaternion
import godot.core.RID
import godot.core.Signal0
import godot.core.Signal1
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector3
import godot.core.asCachedStringName
import godot.readReturnValue_ANY
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_PACKED_INT_32_ARRAY
import godot.readReturnValue_QUATERNION
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_ARRAY
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_QUATERNION
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_LONG_STRING_NAME
import godot.writeMethodArguments_LONG_STRING_NAME_ANY
import godot.writeMethodArguments_LONG_TRANSFORM3D
import godot.writeMethodArguments_LONG_TRANSFORM3D_DOUBLE_BOOL
import godot.writeMethodArguments_LONG_VECTOR3
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_STRING
import kotlin.Any
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
 * [Skeleton3D] provides an interface for managing a hierarchy of bones, including pose, rest and
 * animation (see [Animation]). It can also use ragdoll physics.
 *
 * The overall transform of a bone with respect to the skeleton is determined by bone pose. Bone
 * rest defines the initial transform of the bone pose.
 *
 * Note that "global pose" below refers to the overall transform of the bone with respect to
 * skeleton, so it is not the actual global/world transform of the bone.
 */
@GodotBaseType
public open class Skeleton3D : Node3D() {
  /**
   * Emitted when the rest is updated.
   */
  public val restUpdated: Signal0 by Signal0

  /**
   * Emitted when the pose is updated.
   *
   * **Note:** During the update process, this signal is not fired, so modification by
   * [SkeletonModifier3D] is not detected.
   */
  public val poseUpdated: Signal0 by Signal0

  /**
   * Emitted when the final pose has been calculated will be applied to the skin in the update
   * process.
   *
   * This means that all [SkeletonModifier3D] processing is complete. In order to detect the
   * completion of the processing of each [SkeletonModifier3D], use [signal
   * SkeletonModifier3D.modification_processed].
   */
  public val skeletonUpdated: Signal0 by Signal0

  /**
   * Emitted when the bone at [boneIdx] is toggled with [setBoneEnabled]. Use [isBoneEnabled] to
   * check the new value.
   */
  public val boneEnabledChanged: Signal1<Long> by Signal1

  /**
   * Emitted when the list of bones changes, such as when calling [addBone], [setBoneParent],
   * [unparentBoneAndRest], or [clearBones].
   */
  public val boneListChanged: Signal0 by Signal0

  /**
   * Emitted when the value of [showRestOnly] changes.
   */
  public val showRestOnlyChanged: Signal0 by Signal0

  /**
   * Multiplies the 3D position track animation.
   *
   * **Note:** Unless this value is `1.0`, the key value in animation will not match the actual
   * position value.
   */
  public final inline var motionScale: Float
    @JvmName("motionScaleProperty")
    get() = getMotionScale()
    @JvmName("motionScaleProperty")
    set(`value`) {
      setMotionScale(value)
    }

  /**
   * If `true`, forces the bones in their default rest pose, regardless of their values. In the
   * editor, this also prevents the bones from being edited.
   */
  public final inline var showRestOnly: Boolean
    @JvmName("showRestOnlyProperty")
    get() = isShowRestOnly()
    @JvmName("showRestOnlyProperty")
    set(`value`) {
      setShowRestOnly(value)
    }

  /**
   * Sets the processing timing for the Modifier.
   */
  public final inline var modifierCallbackModeProcess: ModifierCallbackModeProcess
    @JvmName("modifierCallbackModeProcessProperty")
    get() = getModifierCallbackModeProcess()
    @JvmName("modifierCallbackModeProcessProperty")
    set(`value`) {
      setModifierCallbackModeProcess(value)
    }

  /**
   * If you follow the recommended workflow and explicitly have [PhysicalBoneSimulator3D] as a child
   * of [Skeleton3D], you can control whether it is affected by raycasting without running
   * [physicalBonesStartSimulation], by its [SkeletonModifier3D.active].
   *
   * However, for old (deprecated) configurations, [Skeleton3D] has an internal virtual
   * [PhysicalBoneSimulator3D] for compatibility. This property controls the internal virtual
   * [PhysicalBoneSimulator3D]'s [SkeletonModifier3D.active].
   */
  public final inline var animatePhysicalBones: Boolean
    @JvmName("animatePhysicalBonesProperty")
    get() = getAnimatePhysicalBones()
    @JvmName("animatePhysicalBonesProperty")
    set(`value`) {
      setAnimatePhysicalBones(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(665, scriptPtr)
  }

  /**
   * Adds a new bone with the given name. Returns the new bone's index, or `-1` if this method
   * fails.
   *
   * **Note:** Bone names should be unique, non empty, and cannot include the `:` and `/`
   * characters.
   */
  public final fun addBone(name: String): Int {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.addBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the bone index that matches [name] as its name. Returns `-1` if no bone with this name
   * exists.
   */
  public final fun findBone(name: String): Int {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.findBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the name of the bone at index [boneIdx].
   */
  public final fun getBoneName(boneIdx: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the bone name, [name], for the bone at [boneIdx].
   */
  public final fun setBoneName(boneIdx: Int, name: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, boneIdx.toLong(), name)
    TransferContext.callMethod(MethodBindings.setBoneNamePtr)
  }

  /**
   * Returns the metadata with the given [key] for the bone at index [boneIdx].
   */
  public final fun getBoneMeta(boneIdx: Int, key: StringName): Any? {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, boneIdx.toLong(), key)
    TransferContext.callMethod(MethodBindings.getBoneMetaPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns the list of all metadata keys for the bone at index [boneIdx].
   */
  public final fun getBoneMetaList(boneIdx: Int): VariantArray<StringName> {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneMetaListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<StringName>)
  }

  /**
   * Returns `true` if the bone at index [boneIdx] has metadata with the given [key].
   */
  public final fun hasBoneMeta(boneIdx: Int, key: StringName): Boolean {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, boneIdx.toLong(), key)
    TransferContext.callMethod(MethodBindings.hasBoneMetaPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the metadata with the given [key] to [value] for the bone at index [boneIdx].
   */
  public final fun setBoneMeta(
    boneIdx: Int,
    key: StringName,
    `value`: Any?,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME_ANY(ptr, objectID.id, boneIdx.toLong(), key, value)
    TransferContext.callMethod(MethodBindings.setBoneMetaPtr)
  }

  /**
   * Returns all bone names concatenated with commas (`,`) as a single [StringName].
   *
   * It is useful to set it as a hint for the enum property.
   */
  public final fun getConcatenatedBoneNames(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getConcatenatedBoneNamesPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the bone index which is the parent of the bone at [boneIdx]. If -1, then bone has no
   * parent.
   *
   * **Note:** The parent bone returned will always be less than [boneIdx].
   */
  public final fun getBoneParent(boneIdx: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneParentPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the bone index [parentIdx] as the parent of the bone at [boneIdx]. If -1, then bone has no
   * parent.
   *
   * **Note:** [parentIdx] must be less than [boneIdx].
   */
  public final fun setBoneParent(boneIdx: Int, parentIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, boneIdx.toLong(), parentIdx.toLong())
    TransferContext.callMethod(MethodBindings.setBoneParentPtr)
  }

  /**
   * Returns the number of bones in the skeleton.
   */
  public final fun getBoneCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the number of times the bone hierarchy has changed within this skeleton, including
   * renames.
   *
   * The Skeleton version is not serialized: only use within a single instance of Skeleton3D.
   *
   * Use for invalidating caches in IK solvers and other nodes which process bones.
   */
  public final fun getVersion(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVersionPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Unparents the bone at [boneIdx] and sets its rest position to that of its parent prior to being
   * reset.
   */
  public final fun unparentBoneAndRest(boneIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.unparentBoneAndRestPtr)
  }

  /**
   * Returns an array containing the bone indexes of all the child node of the passed in bone,
   * [boneIdx].
   */
  public final fun getBoneChildren(boneIdx: Int): PackedInt32Array {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneChildrenPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  /**
   * Returns an array with all of the bones that are parentless. Another way to look at this is that
   * it returns the indexes of all the bones that are not dependent or modified by other bones in the
   * Skeleton.
   */
  public final fun getParentlessBones(): PackedInt32Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParentlessBonesPtr)
    return TransferContext.readReturnValue_PACKED_INT_32_ARRAY()
  }

  /**
   * Returns the rest transform for a bone [boneIdx].
   */
  public final fun getBoneRest(boneIdx: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneRestPtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Sets the rest transform for bone [boneIdx].
   */
  public final fun setBoneRest(boneIdx: Int, rest: Transform3D): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, boneIdx.toLong(), rest)
    TransferContext.callMethod(MethodBindings.setBoneRestPtr)
  }

  /**
   * Returns the global rest transform for [boneIdx].
   */
  public final fun getBoneGlobalRest(boneIdx: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneGlobalRestPtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  public final fun createSkinFromRestTransforms(): Skin? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.createSkinFromRestTransformsPtr)
    return (TransferContext.readReturnValue_OBJECT() as Skin?)
  }

  /**
   * Binds the given Skin to the Skeleton.
   */
  public final fun registerSkin(skin: Skin?): SkinReference? {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, skin)
    TransferContext.callMethod(MethodBindings.registerSkinPtr)
    return (TransferContext.readReturnValue_OBJECT() as SkinReference?)
  }

  /**
   * Returns all bones in the skeleton to their rest poses.
   */
  public final fun localizeRests(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.localizeRestsPtr)
  }

  /**
   * Clear all the bones in this skeleton.
   */
  public final fun clearBones(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearBonesPtr)
  }

  /**
   * Returns the pose transform of the specified bone.
   *
   * **Note:** This is the pose you set to the skeleton in the process, the final pose can get
   * overridden by modifiers in the deferred process, if you want to access the final pose, use [signal
   * SkeletonModifier3D.modification_processed].
   */
  public final fun getBonePose(boneIdx: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBonePosePtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Sets the pose transform, [pose], for the bone at [boneIdx].
   */
  public final fun setBonePose(boneIdx: Int, pose: Transform3D): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, boneIdx.toLong(), pose)
    TransferContext.callMethod(MethodBindings.setBonePosePtr)
  }

  /**
   * Sets the pose position of the bone at [boneIdx] to [position]. [position] is a [Vector3]
   * describing a position local to the [Skeleton3D] node.
   */
  public final fun setBonePosePosition(boneIdx: Int, position: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, boneIdx.toLong(), position)
    TransferContext.callMethod(MethodBindings.setBonePosePositionPtr)
  }

  /**
   * Sets the pose rotation of the bone at [boneIdx] to [rotation]. [rotation] is a [Quaternion]
   * describing a rotation in the bone's local coordinate space with respect to the rotation of any
   * parent bones.
   */
  public final fun setBonePoseRotation(boneIdx: Int, rotation: Quaternion): Unit {
    TransferContext.writeMethodArguments_LONG_QUATERNION(ptr, objectID.id, boneIdx.toLong(), rotation)
    TransferContext.callMethod(MethodBindings.setBonePoseRotationPtr)
  }

  /**
   * Sets the pose scale of the bone at [boneIdx] to [scale].
   */
  public final fun setBonePoseScale(boneIdx: Int, scale: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, boneIdx.toLong(), scale)
    TransferContext.callMethod(MethodBindings.setBonePoseScalePtr)
  }

  /**
   * Returns the pose position of the bone at [boneIdx]. The returned [Vector3] is in the local
   * coordinate space of the [Skeleton3D] node.
   */
  public final fun getBonePosePosition(boneIdx: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBonePosePositionPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns the pose rotation of the bone at [boneIdx]. The returned [Quaternion] is local to the
   * bone with respect to the rotation of any parent bones.
   */
  public final fun getBonePoseRotation(boneIdx: Int): Quaternion {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBonePoseRotationPtr)
    return TransferContext.readReturnValue_QUATERNION()
  }

  /**
   * Returns the pose scale of the bone at [boneIdx].
   */
  public final fun getBonePoseScale(boneIdx: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBonePoseScalePtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the bone pose to rest for [boneIdx].
   */
  public final fun resetBonePose(boneIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.resetBonePosePtr)
  }

  /**
   * Sets all bone poses to rests.
   */
  public final fun resetBonePoses(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.resetBonePosesPtr)
  }

  /**
   * Returns whether the bone pose for the bone at [boneIdx] is enabled.
   */
  public final fun isBoneEnabled(boneIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.isBoneEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Disables the pose for the bone at [boneIdx] if `false`, enables the bone pose if `true`.
   */
  @JvmOverloads
  public final fun setBoneEnabled(boneIdx: Int, enabled: Boolean = true): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, boneIdx.toLong(), enabled)
    TransferContext.callMethod(MethodBindings.setBoneEnabledPtr)
  }

  /**
   * Returns the overall transform of the specified bone, with respect to the skeleton. Being
   * relative to the skeleton frame, this is not the actual "global" transform of the bone.
   *
   * **Note:** This is the global pose you set to the skeleton in the process, the final global pose
   * can get overridden by modifiers in the deferred process, if you want to access the final global
   * pose, use [signal SkeletonModifier3D.modification_processed].
   */
  public final fun getBoneGlobalPose(boneIdx: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneGlobalPosePtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Sets the global pose transform, [pose], for the bone at [boneIdx].
   *
   * **Note:** If other bone poses have been changed, this method executes a dirty poses
   * recalculation and will cause performance to deteriorate. If you know that multiple global poses
   * will be applied, consider using [setBonePose] with precalculation.
   */
  public final fun setBoneGlobalPose(boneIdx: Int, pose: Transform3D): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, boneIdx.toLong(), pose)
    TransferContext.callMethod(MethodBindings.setBoneGlobalPosePtr)
  }

  /**
   * Force updates the bone transforms/poses for all bones in the skeleton.
   */
  public final fun forceUpdateAllBoneTransforms(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.forceUpdateAllBoneTransformsPtr)
  }

  /**
   * Force updates the bone transform for the bone at [boneIdx] and all of its children.
   */
  public final fun forceUpdateBoneChildTransform(boneIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.forceUpdateBoneChildTransformPtr)
  }

  public final fun setMotionScale(motionScale: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, motionScale.toDouble())
    TransferContext.callMethod(MethodBindings.setMotionScalePtr)
  }

  public final fun getMotionScale(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMotionScalePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setShowRestOnly(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setShowRestOnlyPtr)
  }

  public final fun isShowRestOnly(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isShowRestOnlyPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setModifierCallbackModeProcess(mode: ModifierCallbackModeProcess): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setModifierCallbackModeProcessPtr)
  }

  public final fun getModifierCallbackModeProcess(): ModifierCallbackModeProcess {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getModifierCallbackModeProcessPtr)
    return ModifierCallbackModeProcess.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Manually advance the child [SkeletonModifier3D]s by the specified time (in seconds).
   *
   * **Note:** The [delta] is temporarily accumulated in the [Skeleton3D], and the deferred process
   * uses the accumulated value to process the modification.
   */
  public final fun advance(delta: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, delta)
    TransferContext.callMethod(MethodBindings.advancePtr)
  }

  /**
   * Removes the global pose override on all bones in the skeleton.
   */
  public final fun clearBonesGlobalPoseOverride(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearBonesGlobalPoseOverridePtr)
  }

  /**
   * Sets the global pose transform, [pose], for the bone at [boneIdx].
   *
   * [amount] is the interpolation strength that will be used when applying the pose, and
   * [persistent] determines if the applied pose will remain.
   *
   * **Note:** The pose transform needs to be a global pose! To convert a world transform from a
   * [Node3D] to a global bone pose, multiply the [Transform3D.affineInverse] of the node's
   * [Node3D.globalTransform] by the desired world transform.
   */
  @JvmOverloads
  public final fun setBoneGlobalPoseOverride(
    boneIdx: Int,
    pose: Transform3D,
    amount: Float,
    persistent: Boolean = false,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D_DOUBLE_BOOL(ptr, objectID.id, boneIdx.toLong(), pose, amount.toDouble(), persistent)
    TransferContext.callMethod(MethodBindings.setBoneGlobalPoseOverridePtr)
  }

  /**
   * Returns the global pose override transform for [boneIdx].
   */
  public final fun getBoneGlobalPoseOverride(boneIdx: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneGlobalPoseOverridePtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Returns the overall transform of the specified bone, with respect to the skeleton, but without
   * any global pose overrides. Being relative to the skeleton frame, this is not the actual "global"
   * transform of the bone.
   */
  public final fun getBoneGlobalPoseNoOverride(boneIdx: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneGlobalPoseNoOverridePtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  public final fun setAnimatePhysicalBones(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setAnimatePhysicalBonesPtr)
  }

  public final fun getAnimatePhysicalBones(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnimatePhysicalBonesPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Tells the [PhysicalBone3D] nodes in the Skeleton to stop simulating.
   */
  public final fun physicalBonesStopSimulation(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.physicalBonesStopSimulationPtr)
  }

  /**
   * Tells the [PhysicalBone3D] nodes in the Skeleton to start simulating and reacting to the
   * physics world.
   *
   * Optionally, a list of bone names can be passed-in, allowing only the passed-in bones to be
   * simulated.
   */
  @JvmOverloads
  public final fun physicalBonesStartSimulation(bones: VariantArray<StringName> =
      godot.core.variantArrayOf()): Unit {
    TransferContext.writeMethodArguments_ARRAY(ptr, objectID.id, bones)
    TransferContext.callMethod(MethodBindings.physicalBonesStartSimulationPtr)
  }

  /**
   * Adds a collision exception to the physical bone.
   *
   * Works just like the [RigidBody3D] node.
   */
  public final fun physicalBonesAddCollisionException(exception: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, exception)
    TransferContext.callMethod(MethodBindings.physicalBonesAddCollisionExceptionPtr)
  }

  /**
   * Removes a collision exception to the physical bone.
   *
   * Works just like the [RigidBody3D] node.
   */
  public final fun physicalBonesRemoveCollisionException(exception: RID): Unit {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, exception)
    TransferContext.callMethod(MethodBindings.physicalBonesRemoveCollisionExceptionPtr)
  }

  /**
   * Returns the metadata with the given [key] for the bone at index [boneIdx].
   */
  public final fun getBoneMeta(boneIdx: Int, key: String): Any? =
      getBoneMeta(boneIdx, key.asCachedStringName())

  /**
   * Returns `true` if the bone at index [boneIdx] has metadata with the given [key].
   */
  public final fun hasBoneMeta(boneIdx: Int, key: String): Boolean =
      hasBoneMeta(boneIdx, key.asCachedStringName())

  /**
   * Sets the metadata with the given [key] to [value] for the bone at index [boneIdx].
   */
  public final fun setBoneMeta(
    boneIdx: Int,
    key: String,
    `value`: Any?,
  ) = setBoneMeta(boneIdx, key.asCachedStringName(), value)

  public enum class ModifierCallbackModeProcess(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Set a flag to process modification during physics frames (see
     * [Node.NOTIFICATION_INTERNAL_PHYSICS_PROCESS]).
     */
    PHYSICS(0),
    /**
     * Set a flag to process modification during process frames (see
     * [Node.NOTIFICATION_INTERNAL_PROCESS]).
     */
    IDLE(1),
    /**
     * Do not process modification. Use [advance] to process the modification manually.
     */
    MANUAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): ModifierCallbackModeProcess =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val addBoneName: MethodStringName1<Skeleton3D, Int, String> =
        MethodStringName1<Skeleton3D, Int, String>("add_bone")

    @JvmField
    public val findBoneName: MethodStringName1<Skeleton3D, Int, String> =
        MethodStringName1<Skeleton3D, Int, String>("find_bone")

    @JvmField
    public val getBoneNameName: MethodStringName1<Skeleton3D, String, Int> =
        MethodStringName1<Skeleton3D, String, Int>("get_bone_name")

    @JvmField
    public val setBoneNameName: MethodStringName2<Skeleton3D, Unit, Int, String> =
        MethodStringName2<Skeleton3D, Unit, Int, String>("set_bone_name")

    @JvmField
    public val getBoneMetaName: MethodStringName2<Skeleton3D, Any?, Int, StringName> =
        MethodStringName2<Skeleton3D, Any?, Int, StringName>("get_bone_meta")

    @JvmField
    public val getBoneMetaListName: MethodStringName1<Skeleton3D, VariantArray<StringName>, Int> =
        MethodStringName1<Skeleton3D, VariantArray<StringName>, Int>("get_bone_meta_list")

    @JvmField
    public val hasBoneMetaName: MethodStringName2<Skeleton3D, Boolean, Int, StringName> =
        MethodStringName2<Skeleton3D, Boolean, Int, StringName>("has_bone_meta")

    @JvmField
    public val setBoneMetaName: MethodStringName3<Skeleton3D, Unit, Int, StringName, Any?> =
        MethodStringName3<Skeleton3D, Unit, Int, StringName, Any?>("set_bone_meta")

    @JvmField
    public val getConcatenatedBoneNamesName: MethodStringName0<Skeleton3D, StringName> =
        MethodStringName0<Skeleton3D, StringName>("get_concatenated_bone_names")

    @JvmField
    public val getBoneParentName: MethodStringName1<Skeleton3D, Int, Int> =
        MethodStringName1<Skeleton3D, Int, Int>("get_bone_parent")

    @JvmField
    public val setBoneParentName: MethodStringName2<Skeleton3D, Unit, Int, Int> =
        MethodStringName2<Skeleton3D, Unit, Int, Int>("set_bone_parent")

    @JvmField
    public val getBoneCountName: MethodStringName0<Skeleton3D, Int> =
        MethodStringName0<Skeleton3D, Int>("get_bone_count")

    @JvmField
    public val getVersionName: MethodStringName0<Skeleton3D, Long> =
        MethodStringName0<Skeleton3D, Long>("get_version")

    @JvmField
    public val unparentBoneAndRestName: MethodStringName1<Skeleton3D, Unit, Int> =
        MethodStringName1<Skeleton3D, Unit, Int>("unparent_bone_and_rest")

    @JvmField
    public val getBoneChildrenName: MethodStringName1<Skeleton3D, PackedInt32Array, Int> =
        MethodStringName1<Skeleton3D, PackedInt32Array, Int>("get_bone_children")

    @JvmField
    public val getParentlessBonesName: MethodStringName0<Skeleton3D, PackedInt32Array> =
        MethodStringName0<Skeleton3D, PackedInt32Array>("get_parentless_bones")

    @JvmField
    public val getBoneRestName: MethodStringName1<Skeleton3D, Transform3D, Int> =
        MethodStringName1<Skeleton3D, Transform3D, Int>("get_bone_rest")

    @JvmField
    public val setBoneRestName: MethodStringName2<Skeleton3D, Unit, Int, Transform3D> =
        MethodStringName2<Skeleton3D, Unit, Int, Transform3D>("set_bone_rest")

    @JvmField
    public val getBoneGlobalRestName: MethodStringName1<Skeleton3D, Transform3D, Int> =
        MethodStringName1<Skeleton3D, Transform3D, Int>("get_bone_global_rest")

    @JvmField
    public val createSkinFromRestTransformsName: MethodStringName0<Skeleton3D, Skin?> =
        MethodStringName0<Skeleton3D, Skin?>("create_skin_from_rest_transforms")

    @JvmField
    public val registerSkinName: MethodStringName1<Skeleton3D, SkinReference?, Skin?> =
        MethodStringName1<Skeleton3D, SkinReference?, Skin?>("register_skin")

    @JvmField
    public val localizeRestsName: MethodStringName0<Skeleton3D, Unit> =
        MethodStringName0<Skeleton3D, Unit>("localize_rests")

    @JvmField
    public val clearBonesName: MethodStringName0<Skeleton3D, Unit> =
        MethodStringName0<Skeleton3D, Unit>("clear_bones")

    @JvmField
    public val getBonePoseName: MethodStringName1<Skeleton3D, Transform3D, Int> =
        MethodStringName1<Skeleton3D, Transform3D, Int>("get_bone_pose")

    @JvmField
    public val setBonePoseName: MethodStringName2<Skeleton3D, Unit, Int, Transform3D> =
        MethodStringName2<Skeleton3D, Unit, Int, Transform3D>("set_bone_pose")

    @JvmField
    public val setBonePosePositionName: MethodStringName2<Skeleton3D, Unit, Int, Vector3> =
        MethodStringName2<Skeleton3D, Unit, Int, Vector3>("set_bone_pose_position")

    @JvmField
    public val setBonePoseRotationName: MethodStringName2<Skeleton3D, Unit, Int, Quaternion> =
        MethodStringName2<Skeleton3D, Unit, Int, Quaternion>("set_bone_pose_rotation")

    @JvmField
    public val setBonePoseScaleName: MethodStringName2<Skeleton3D, Unit, Int, Vector3> =
        MethodStringName2<Skeleton3D, Unit, Int, Vector3>("set_bone_pose_scale")

    @JvmField
    public val getBonePosePositionName: MethodStringName1<Skeleton3D, Vector3, Int> =
        MethodStringName1<Skeleton3D, Vector3, Int>("get_bone_pose_position")

    @JvmField
    public val getBonePoseRotationName: MethodStringName1<Skeleton3D, Quaternion, Int> =
        MethodStringName1<Skeleton3D, Quaternion, Int>("get_bone_pose_rotation")

    @JvmField
    public val getBonePoseScaleName: MethodStringName1<Skeleton3D, Vector3, Int> =
        MethodStringName1<Skeleton3D, Vector3, Int>("get_bone_pose_scale")

    @JvmField
    public val resetBonePoseName: MethodStringName1<Skeleton3D, Unit, Int> =
        MethodStringName1<Skeleton3D, Unit, Int>("reset_bone_pose")

    @JvmField
    public val resetBonePosesName: MethodStringName0<Skeleton3D, Unit> =
        MethodStringName0<Skeleton3D, Unit>("reset_bone_poses")

    @JvmField
    public val isBoneEnabledName: MethodStringName1<Skeleton3D, Boolean, Int> =
        MethodStringName1<Skeleton3D, Boolean, Int>("is_bone_enabled")

    @JvmField
    public val setBoneEnabledName: MethodStringName2<Skeleton3D, Unit, Int, Boolean> =
        MethodStringName2<Skeleton3D, Unit, Int, Boolean>("set_bone_enabled")

    @JvmField
    public val getBoneGlobalPoseName: MethodStringName1<Skeleton3D, Transform3D, Int> =
        MethodStringName1<Skeleton3D, Transform3D, Int>("get_bone_global_pose")

    @JvmField
    public val setBoneGlobalPoseName: MethodStringName2<Skeleton3D, Unit, Int, Transform3D> =
        MethodStringName2<Skeleton3D, Unit, Int, Transform3D>("set_bone_global_pose")

    @JvmField
    public val forceUpdateAllBoneTransformsName: MethodStringName0<Skeleton3D, Unit> =
        MethodStringName0<Skeleton3D, Unit>("force_update_all_bone_transforms")

    @JvmField
    public val forceUpdateBoneChildTransformName: MethodStringName1<Skeleton3D, Unit, Int> =
        MethodStringName1<Skeleton3D, Unit, Int>("force_update_bone_child_transform")

    @JvmField
    public val setMotionScaleName: MethodStringName1<Skeleton3D, Unit, Float> =
        MethodStringName1<Skeleton3D, Unit, Float>("set_motion_scale")

    @JvmField
    public val getMotionScaleName: MethodStringName0<Skeleton3D, Float> =
        MethodStringName0<Skeleton3D, Float>("get_motion_scale")

    @JvmField
    public val setShowRestOnlyName: MethodStringName1<Skeleton3D, Unit, Boolean> =
        MethodStringName1<Skeleton3D, Unit, Boolean>("set_show_rest_only")

    @JvmField
    public val isShowRestOnlyName: MethodStringName0<Skeleton3D, Boolean> =
        MethodStringName0<Skeleton3D, Boolean>("is_show_rest_only")

    @JvmField
    public val setModifierCallbackModeProcessName:
        MethodStringName1<Skeleton3D, Unit, ModifierCallbackModeProcess> =
        MethodStringName1<Skeleton3D, Unit, ModifierCallbackModeProcess>("set_modifier_callback_mode_process")

    @JvmField
    public val getModifierCallbackModeProcessName:
        MethodStringName0<Skeleton3D, ModifierCallbackModeProcess> =
        MethodStringName0<Skeleton3D, ModifierCallbackModeProcess>("get_modifier_callback_mode_process")

    @JvmField
    public val advanceName: MethodStringName1<Skeleton3D, Unit, Double> =
        MethodStringName1<Skeleton3D, Unit, Double>("advance")

    @JvmField
    public val clearBonesGlobalPoseOverrideName: MethodStringName0<Skeleton3D, Unit> =
        MethodStringName0<Skeleton3D, Unit>("clear_bones_global_pose_override")

    @JvmField
    public val setBoneGlobalPoseOverrideName:
        MethodStringName4<Skeleton3D, Unit, Int, Transform3D, Float, Boolean> =
        MethodStringName4<Skeleton3D, Unit, Int, Transform3D, Float, Boolean>("set_bone_global_pose_override")

    @JvmField
    public val getBoneGlobalPoseOverrideName: MethodStringName1<Skeleton3D, Transform3D, Int> =
        MethodStringName1<Skeleton3D, Transform3D, Int>("get_bone_global_pose_override")

    @JvmField
    public val getBoneGlobalPoseNoOverrideName: MethodStringName1<Skeleton3D, Transform3D, Int> =
        MethodStringName1<Skeleton3D, Transform3D, Int>("get_bone_global_pose_no_override")

    @JvmField
    public val setAnimatePhysicalBonesName: MethodStringName1<Skeleton3D, Unit, Boolean> =
        MethodStringName1<Skeleton3D, Unit, Boolean>("set_animate_physical_bones")

    @JvmField
    public val getAnimatePhysicalBonesName: MethodStringName0<Skeleton3D, Boolean> =
        MethodStringName0<Skeleton3D, Boolean>("get_animate_physical_bones")

    @JvmField
    public val physicalBonesStopSimulationName: MethodStringName0<Skeleton3D, Unit> =
        MethodStringName0<Skeleton3D, Unit>("physical_bones_stop_simulation")

    @JvmField
    public val physicalBonesStartSimulationName:
        MethodStringName1<Skeleton3D, Unit, VariantArray<StringName>> =
        MethodStringName1<Skeleton3D, Unit, VariantArray<StringName>>("physical_bones_start_simulation")

    @JvmField
    public val physicalBonesAddCollisionExceptionName: MethodStringName1<Skeleton3D, Unit, RID> =
        MethodStringName1<Skeleton3D, Unit, RID>("physical_bones_add_collision_exception")

    @JvmField
    public val physicalBonesRemoveCollisionExceptionName: MethodStringName1<Skeleton3D, Unit, RID> =
        MethodStringName1<Skeleton3D, Unit, RID>("physical_bones_remove_collision_exception")

    /**
     * Notification received when this skeleton's pose needs to be updated. In that case, this is
     * called only once per frame in a deferred process.
     */
    public final const val NOTIFICATION_UPDATE_SKELETON: Long = 50
  }

  public object MethodBindings {
    internal val addBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "add_bone", 1597066294)

    internal val findBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "find_bone", 1321353865)

    internal val getBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_name", 844755477)

    internal val setBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_name", 501894301)

    internal val getBoneMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_meta", 203112058)

    internal val getBoneMetaListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_meta_list", 663333327)

    internal val hasBoneMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "has_bone_meta", 921227809)

    internal val setBoneMetaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_meta", 702482756)

    internal val getConcatenatedBoneNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_concatenated_bone_names", 2002593661)

    internal val getBoneParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_parent", 923996154)

    internal val setBoneParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_parent", 3937882851)

    internal val getBoneCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_count", 3905245786)

    internal val getVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_version", 3905245786)

    internal val unparentBoneAndRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "unparent_bone_and_rest", 1286410249)

    internal val getBoneChildrenPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_children", 1706082319)

    internal val getParentlessBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_parentless_bones", 1930428628)

    internal val getBoneRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_rest", 1965739696)

    internal val setBoneRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_rest", 3616898986)

    internal val getBoneGlobalRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_global_rest", 1965739696)

    internal val createSkinFromRestTransformsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "create_skin_from_rest_transforms", 1032037385)

    internal val registerSkinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "register_skin", 3405789568)

    internal val localizeRestsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "localize_rests", 3218959716)

    internal val clearBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "clear_bones", 3218959716)

    internal val getBonePosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_pose", 1965739696)

    internal val setBonePosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_pose", 3616898986)

    internal val setBonePosePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_pose_position", 1530502735)

    internal val setBonePoseRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_pose_rotation", 2823819782)

    internal val setBonePoseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_pose_scale", 1530502735)

    internal val getBonePosePositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_pose_position", 711720468)

    internal val getBonePoseRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_pose_rotation", 476865136)

    internal val getBonePoseScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_pose_scale", 711720468)

    internal val resetBonePosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "reset_bone_pose", 1286410249)

    internal val resetBonePosesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "reset_bone_poses", 3218959716)

    internal val isBoneEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "is_bone_enabled", 1116898809)

    internal val setBoneEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_enabled", 972357352)

    internal val getBoneGlobalPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_global_pose", 1965739696)

    internal val setBoneGlobalPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_global_pose", 3616898986)

    internal val forceUpdateAllBoneTransformsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "force_update_all_bone_transforms", 3218959716)

    internal val forceUpdateBoneChildTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "force_update_bone_child_transform", 1286410249)

    internal val setMotionScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_motion_scale", 373806689)

    internal val getMotionScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_motion_scale", 1740695150)

    internal val setShowRestOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_show_rest_only", 2586408642)

    internal val isShowRestOnlyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "is_show_rest_only", 36873697)

    internal val setModifierCallbackModeProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_modifier_callback_mode_process", 3916362634)

    internal val getModifierCallbackModeProcessPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_modifier_callback_mode_process", 997182536)

    internal val advancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "advance", 373806689)

    internal val clearBonesGlobalPoseOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "clear_bones_global_pose_override", 3218959716)

    internal val setBoneGlobalPoseOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_bone_global_pose_override", 3483398371)

    internal val getBoneGlobalPoseOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_global_pose_override", 1965739696)

    internal val getBoneGlobalPoseNoOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_bone_global_pose_no_override", 1965739696)

    internal val setAnimatePhysicalBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "set_animate_physical_bones", 2586408642)

    internal val getAnimatePhysicalBonesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "get_animate_physical_bones", 36873697)

    internal val physicalBonesStopSimulationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "physical_bones_stop_simulation", 3218959716)

    internal val physicalBonesStartSimulationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "physical_bones_start_simulation", 2787316981)

    internal val physicalBonesAddCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "physical_bones_add_collision_exception", 2722037293)

    internal val physicalBonesRemoveCollisionExceptionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton3D", "physical_bones_remove_collision_exception", 2722037293)
  }
}
