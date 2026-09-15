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
import godot.core.Quaternion
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_QUATERNION
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_LONG_DOUBLE
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_LONG_QUATERNION
import godot.writeMethodArguments_LONG_STRING
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
 * This [BoneTwistDisperser3D] allows for smooth twist interpolation between multiple bones by
 * dispersing the end bone's twist to the parents. This only changes the twist without changing the
 * global position of each joint.
 *
 * This is useful for smoothly twisting bones in combination with [CopyTransformModifier3D] and IK.
 *
 * **Note:** If an extracted twist is greater than 180 degrees, flipping occurs. This is similar to
 * [ConvertTransformModifier3D].
 *
 * **Note:** Most methods in this class take an `index` parameter. This parameter specifies which
 * setting list entry to return if the IK has multiple entries (e.g.
 * `settings/<index>/root_bone_name`).
 */
@GodotBaseType
public open class BoneTwistDisperser3D : SkeletonModifier3D() {
  /**
   * If `true`, the solver retrieves the bone axis from the bone pose every frame.
   *
   * If `false`, the solver retrieves the bone axis from the bone rest and caches it.
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
    createNativeObject(113, scriptPtr)
  }

  public final fun setSettingCount(count: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, count.toLong())
    TransferContext.callMethod(MethodBindings.setSettingCountPtr)
  }

  public final fun getSettingCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSettingCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Clears all settings.
   */
  public final fun clearSettings(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearSettingsPtr)
  }

  public final fun setMutableBoneAxes(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setMutableBoneAxesPtr)
  }

  public final fun areBoneAxesMutable(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.areBoneAxesMutablePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the root bone name of the bone chain.
   */
  public final fun setRootBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, index.toLong(), boneName)
    TransferContext.callMethod(MethodBindings.setRootBoneNamePtr)
  }

  /**
   * Returns the root bone name of the bone chain.
   */
  public final fun getRootBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getRootBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the root bone index of the bone chain.
   */
  public final fun setRootBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), bone.toLong())
    TransferContext.callMethod(MethodBindings.setRootBonePtr)
  }

  /**
   * Returns the root bone index of the bone chain.
   */
  public final fun getRootBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getRootBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the end bone name of the bone chain.
   *
   * **Note:** The end bone must be a child of the root bone.
   */
  public final fun setEndBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, index.toLong(), boneName)
    TransferContext.callMethod(MethodBindings.setEndBoneNamePtr)
  }

  /**
   * Returns the end bone name of the bone chain.
   */
  public final fun getEndBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the end bone index of the bone chain.
   */
  public final fun setEndBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), bone.toLong())
    TransferContext.callMethod(MethodBindings.setEndBonePtr)
  }

  /**
   * Returns the end bone index of the bone chain.
   */
  public final fun getEndBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the reference bone name to extract twist of the setting at [index].
   *
   * This bone is either the end of the chain or its parent, depending on [isEndBoneExtended].
   */
  public final fun getReferenceBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getReferenceBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the reference bone to extract twist of the setting at [index].
   *
   * This bone is either the end of the chain or its parent, depending on [isEndBoneExtended].
   */
  public final fun getReferenceBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getReferenceBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * If [enabled] is `true`, the end bone is extended to have a tail.
   *
   * If [enabled] is `false`, [getReferenceBone] becomes a parent of the end bone and it uses the
   * vector to the end bone as a twist axis.
   */
  public final fun setExtendEndBone(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, index.toLong(), enabled)
    TransferContext.callMethod(MethodBindings.setExtendEndBonePtr)
  }

  /**
   * Returns `true` if the end bone is extended to have a tail.
   */
  public final fun isEndBoneExtended(index: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.isEndBoneExtendedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the end bone tail direction of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun setEndBoneDirection(index: Int, boneDirection: SkeletonModifier3D.BoneDirection):
      Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), boneDirection.value)
    TransferContext.callMethod(MethodBindings.setEndBoneDirectionPtr)
  }

  /**
   * Returns the tail direction of the end bone of the bone chain when [isEndBoneExtended] is
   * `true`.
   */
  public final fun getEndBoneDirection(index: Int): SkeletonModifier3D.BoneDirection {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBoneDirectionPtr)
    return SkeletonModifier3D.BoneDirection.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * If [enabled] is `true`, it extracts the twist amount from the difference between the bone rest
   * and the current bone pose.
   *
   * If [enabled] is `false`, it extracts the twist amount from the difference between
   * [getTwistFrom] and the current bone pose. See also [setTwistFrom].
   */
  public final fun setTwistFromRest(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, index.toLong(), enabled)
    TransferContext.callMethod(MethodBindings.setTwistFromRestPtr)
  }

  /**
   * Returns `true` if extracting the twist amount from the difference between the bone rest and the
   * current bone pose.
   */
  public final fun isTwistFromRest(index: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.isTwistFromRestPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the rotation to an arbitrary state before twisting for the current bone pose to extract
   * the twist when [isTwistFromRest] is `false`.
   *
   * In other words, by calling [setTwistFrom] by [signal SkeletonModifier3D.modification_processed]
   * of a specific [SkeletonModifier3D], you can extract only the twists generated by modifiers
   * processed after that but before this [BoneTwistDisperser3D].
   */
  public final fun setTwistFrom(index: Int, from: Quaternion): Unit {
    TransferContext.writeMethodArguments_LONG_QUATERNION(ptr, objectID.id, index.toLong(), from)
    TransferContext.callMethod(MethodBindings.setTwistFromPtr)
  }

  /**
   * Returns the rotation to an arbitrary state before twisting for the current bone pose to extract
   * the twist when [isTwistFromRest] is `false`.
   */
  public final fun getTwistFrom(index: Int): Quaternion {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getTwistFromPtr)
    return TransferContext.readReturnValue_QUATERNION()
  }

  /**
   * Sets whether to use automatic amount assignment or to allow manual assignment.
   */
  public final fun setDisperseMode(index: Int, disperseMode: DisperseMode): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), disperseMode.value)
    TransferContext.callMethod(MethodBindings.setDisperseModePtr)
  }

  /**
   * Returns whether to use automatic amount assignment or to allow manual assignment.
   */
  public final fun getDisperseMode(index: Int): DisperseMode {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getDisperseModePtr)
    return DisperseMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the position at which to divide the segment between joints for weight assignment when
   * [getDisperseMode] is [DISPERSE_MODE_WEIGHTED].
   *
   * For example, when [weightPosition] is `0.5`, if two bone segments with a length of `1.0` exist
   * between three joints, weights are assigned to each joint from root to end at ratios of `0.5`,
   * `1.0`, and `0.5`. Then amounts become `0.25`, `0.75`, and `1.0` respectively.
   */
  public final fun setWeightPosition(index: Int, weightPosition: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, index.toLong(), weightPosition.toDouble())
    TransferContext.callMethod(MethodBindings.setWeightPositionPtr)
  }

  /**
   * Returns the position at which to divide the segment between joints for weight assignment when
   * [getDisperseMode] is [DISPERSE_MODE_WEIGHTED].
   */
  public final fun getWeightPosition(index: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getWeightPositionPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the damping curve when [getDisperseMode] is [DISPERSE_MODE_CUSTOM].
   */
  public final fun setDampingCurve(index: Int, curve: Curve?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, index.toLong(), curve)
    TransferContext.callMethod(MethodBindings.setDampingCurvePtr)
  }

  /**
   * Returns the damping curve when [getDisperseMode] is [DISPERSE_MODE_CUSTOM].
   */
  public final fun getDampingCurve(index: Int): Curve? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getDampingCurvePtr)
    return (TransferContext.readReturnValue_OBJECT() as Curve?)
  }

  /**
   * Returns the bone name at [joint] in the bone chain's joint list.
   */
  public final fun getJointBoneName(index: Int, joint: Int): String {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the bone index at [joint] in the bone chain's joint list.
   */
  public final fun getJointBone(index: Int, joint: Int): Int {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointBonePtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the twist amount at [joint] in the bone chain's joint list when [getDisperseMode] is
   * [DISPERSE_MODE_CUSTOM].
   */
  public final fun getJointTwistAmount(index: Int, joint: Int): Float {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), joint.toLong())
    TransferContext.callMethod(MethodBindings.getJointTwistAmountPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the twist amount at [joint] in the bone chain's joint list when [getDisperseMode] is
   * [DISPERSE_MODE_CUSTOM].
   */
  public final fun setJointTwistAmount(
    index: Int,
    joint: Int,
    twistAmount: Float,
  ): Unit {
    TransferContext.writeMethodArguments_LONG_LONG_DOUBLE(ptr, objectID.id, index.toLong(), joint.toLong(), twistAmount.toDouble())
    TransferContext.callMethod(MethodBindings.setJointTwistAmountPtr)
  }

  /**
   * Returns the joint count of the bone chain's joint list.
   */
  public final fun getJointCount(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getJointCountPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public enum class DisperseMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Assign amounts so that they monotonically increase from `0.0` to `1.0`, ensuring all weights
     * are equal. For example, with five joints, the amounts would be `0.2`, `0.4`, `0.6`, `0.8`, and
     * `1.0` starting from the root bone.
     */
    EVEN(0),
    /**
     * Assign amounts so that they monotonically increase from `0.0` to `1.0`, based on the length
     * of the bones between joint segments. See also [setWeightPosition].
     */
    WEIGHTED(1),
    /**
     * You can assign arbitrary amounts to the joint list. See also [setJointTwistAmount].
     *
     * When [isEndBoneExtended] is `false`, a child of the reference bone exists solely to determine
     * the twist axis, so its custom amount has absolutely no effect at all.
     */
    CUSTOM(2),
    ;

    public companion object {
      public fun from(`value`: Long): DisperseMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setSettingCountName: MethodStringName1<BoneTwistDisperser3D, Unit, Int> =
        MethodStringName1<BoneTwistDisperser3D, Unit, Int>("set_setting_count")

    @JvmField
    public val getSettingCountName: MethodStringName0<BoneTwistDisperser3D, Int> =
        MethodStringName0<BoneTwistDisperser3D, Int>("get_setting_count")

    @JvmField
    public val clearSettingsName: MethodStringName0<BoneTwistDisperser3D, Unit> =
        MethodStringName0<BoneTwistDisperser3D, Unit>("clear_settings")

    @JvmField
    public val setMutableBoneAxesName: MethodStringName1<BoneTwistDisperser3D, Unit, Boolean> =
        MethodStringName1<BoneTwistDisperser3D, Unit, Boolean>("set_mutable_bone_axes")

    @JvmField
    public val areBoneAxesMutableName: MethodStringName0<BoneTwistDisperser3D, Boolean> =
        MethodStringName0<BoneTwistDisperser3D, Boolean>("are_bone_axes_mutable")

    @JvmField
    public val setRootBoneNameName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, String> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, String>("set_root_bone_name")

    @JvmField
    public val getRootBoneNameName: MethodStringName1<BoneTwistDisperser3D, String, Int> =
        MethodStringName1<BoneTwistDisperser3D, String, Int>("get_root_bone_name")

    @JvmField
    public val setRootBoneName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, Int> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, Int>("set_root_bone")

    @JvmField
    public val getRootBoneName: MethodStringName1<BoneTwistDisperser3D, Int, Int> =
        MethodStringName1<BoneTwistDisperser3D, Int, Int>("get_root_bone")

    @JvmField
    public val setEndBoneNameName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, String> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, String>("set_end_bone_name")

    @JvmField
    public val getEndBoneNameName: MethodStringName1<BoneTwistDisperser3D, String, Int> =
        MethodStringName1<BoneTwistDisperser3D, String, Int>("get_end_bone_name")

    @JvmField
    public val setEndBoneName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, Int> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, Int>("set_end_bone")

    @JvmField
    public val getEndBoneName: MethodStringName1<BoneTwistDisperser3D, Int, Int> =
        MethodStringName1<BoneTwistDisperser3D, Int, Int>("get_end_bone")

    @JvmField
    public val getReferenceBoneNameName: MethodStringName1<BoneTwistDisperser3D, String, Int> =
        MethodStringName1<BoneTwistDisperser3D, String, Int>("get_reference_bone_name")

    @JvmField
    public val getReferenceBoneName: MethodStringName1<BoneTwistDisperser3D, Int, Int> =
        MethodStringName1<BoneTwistDisperser3D, Int, Int>("get_reference_bone")

    @JvmField
    public val setExtendEndBoneName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, Boolean> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, Boolean>("set_extend_end_bone")

    @JvmField
    public val isEndBoneExtendedName: MethodStringName1<BoneTwistDisperser3D, Boolean, Int> =
        MethodStringName1<BoneTwistDisperser3D, Boolean, Int>("is_end_bone_extended")

    @JvmField
    public val setEndBoneDirectionName:
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, SkeletonModifier3D.BoneDirection> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, SkeletonModifier3D.BoneDirection>("set_end_bone_direction")

    @JvmField
    public val getEndBoneDirectionName:
        MethodStringName1<BoneTwistDisperser3D, SkeletonModifier3D.BoneDirection, Int> =
        MethodStringName1<BoneTwistDisperser3D, SkeletonModifier3D.BoneDirection, Int>("get_end_bone_direction")

    @JvmField
    public val setTwistFromRestName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, Boolean> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, Boolean>("set_twist_from_rest")

    @JvmField
    public val isTwistFromRestName: MethodStringName1<BoneTwistDisperser3D, Boolean, Int> =
        MethodStringName1<BoneTwistDisperser3D, Boolean, Int>("is_twist_from_rest")

    @JvmField
    public val setTwistFromName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, Quaternion> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, Quaternion>("set_twist_from")

    @JvmField
    public val getTwistFromName: MethodStringName1<BoneTwistDisperser3D, Quaternion, Int> =
        MethodStringName1<BoneTwistDisperser3D, Quaternion, Int>("get_twist_from")

    @JvmField
    public val setDisperseModeName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, DisperseMode>
        = MethodStringName2<BoneTwistDisperser3D, Unit, Int, DisperseMode>("set_disperse_mode")

    @JvmField
    public val getDisperseModeName: MethodStringName1<BoneTwistDisperser3D, DisperseMode, Int> =
        MethodStringName1<BoneTwistDisperser3D, DisperseMode, Int>("get_disperse_mode")

    @JvmField
    public val setWeightPositionName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, Float> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, Float>("set_weight_position")

    @JvmField
    public val getWeightPositionName: MethodStringName1<BoneTwistDisperser3D, Float, Int> =
        MethodStringName1<BoneTwistDisperser3D, Float, Int>("get_weight_position")

    @JvmField
    public val setDampingCurveName: MethodStringName2<BoneTwistDisperser3D, Unit, Int, Curve?> =
        MethodStringName2<BoneTwistDisperser3D, Unit, Int, Curve?>("set_damping_curve")

    @JvmField
    public val getDampingCurveName: MethodStringName1<BoneTwistDisperser3D, Curve?, Int> =
        MethodStringName1<BoneTwistDisperser3D, Curve?, Int>("get_damping_curve")

    @JvmField
    public val getJointBoneNameName: MethodStringName2<BoneTwistDisperser3D, String, Int, Int> =
        MethodStringName2<BoneTwistDisperser3D, String, Int, Int>("get_joint_bone_name")

    @JvmField
    public val getJointBoneName: MethodStringName2<BoneTwistDisperser3D, Int, Int, Int> =
        MethodStringName2<BoneTwistDisperser3D, Int, Int, Int>("get_joint_bone")

    @JvmField
    public val getJointTwistAmountName: MethodStringName2<BoneTwistDisperser3D, Float, Int, Int> =
        MethodStringName2<BoneTwistDisperser3D, Float, Int, Int>("get_joint_twist_amount")

    @JvmField
    public val setJointTwistAmountName:
        MethodStringName3<BoneTwistDisperser3D, Unit, Int, Int, Float> =
        MethodStringName3<BoneTwistDisperser3D, Unit, Int, Int, Float>("set_joint_twist_amount")

    @JvmField
    public val getJointCountName: MethodStringName1<BoneTwistDisperser3D, Int, Int> =
        MethodStringName1<BoneTwistDisperser3D, Int, Int>("get_joint_count")
  }

  public object MethodBindings {
    internal val setSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_setting_count", 1286410249)

    internal val getSettingCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_setting_count", 3905245786)

    internal val clearSettingsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "clear_settings", 3218959716)

    internal val setMutableBoneAxesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_mutable_bone_axes", 2586408642)

    internal val areBoneAxesMutablePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "are_bone_axes_mutable", 36873697)

    internal val setRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_root_bone_name", 501894301)

    internal val getRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_root_bone_name", 844755477)

    internal val setRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_root_bone", 3937882851)

    internal val getRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_root_bone", 923996154)

    internal val setEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_end_bone_name", 501894301)

    internal val getEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_end_bone_name", 844755477)

    internal val setEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_end_bone", 3937882851)

    internal val getEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_end_bone", 923996154)

    internal val getReferenceBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_reference_bone_name", 844755477)

    internal val getReferenceBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_reference_bone", 923996154)

    internal val setExtendEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_extend_end_bone", 300928843)

    internal val isEndBoneExtendedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "is_end_bone_extended", 1116898809)

    internal val setEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_end_bone_direction", 2838484201)

    internal val getEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_end_bone_direction", 1843036459)

    internal val setTwistFromRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_twist_from_rest", 300928843)

    internal val isTwistFromRestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "is_twist_from_rest", 1116898809)

    internal val setTwistFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_twist_from", 2823819782)

    internal val getTwistFromPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_twist_from", 476865136)

    internal val setDisperseModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_disperse_mode", 2954194337)

    internal val getDisperseModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_disperse_mode", 1326397005)

    internal val setWeightPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_weight_position", 1602489585)

    internal val getWeightPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_weight_position", 2339986948)

    internal val setDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_damping_curve", 1447180063)

    internal val getDampingCurvePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_damping_curve", 747537754)

    internal val getJointBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_joint_bone_name", 1391810591)

    internal val getJointBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_joint_bone", 3175239445)

    internal val getJointTwistAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_joint_twist_amount", 3085491603)

    internal val setJointTwistAmountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "set_joint_twist_amount", 3506521499)

    internal val getJointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneTwistDisperser3D", "get_joint_count", 923996154)
  }
}
