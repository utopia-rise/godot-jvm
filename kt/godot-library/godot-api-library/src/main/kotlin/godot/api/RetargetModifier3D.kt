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
import godot.core.BitFieldBase
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_OBJECT
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

public infix fun Long.or(other: RetargetModifier3D.TransformFlag): Long = this.or(other.flag)

public infix fun Long.xor(other: RetargetModifier3D.TransformFlag): Long = this.xor(other.flag)

public infix fun Long.and(other: RetargetModifier3D.TransformFlag): Long = this.and(other.flag)

/**
 * Retrieves the pose (or global pose) relative to the parent Skeleton's rest in model space and
 * transfers it to the child Skeleton.
 *
 * This modifier rewrites the pose of the child skeleton directly in the parent skeleton's update
 * process. This means that it overwrites the mapped bone pose set in the normal process on the target
 * skeleton. If you want to set the target skeleton bone pose after retargeting, you will need to add a
 * [SkeletonModifier3D] child to the target skeleton and thereby modify the pose.
 *
 * **Note:** When the [useGlobalPose] is enabled, even if it is an unmapped bone, it can cause
 * visual problems because the global pose is applied ignoring the parent bone's pose **if it has
 * mapped bone children**. See also [useGlobalPose].
 */
@GodotBaseType
public open class RetargetModifier3D : SkeletonModifier3D() {
  /**
   * [SkeletonProfile] for retargeting bones with names matching the bone list.
   */
  public final inline var profile: SkeletonProfile?
    @JvmName("profileProperty")
    get() = getProfile()
    @JvmName("profileProperty")
    set(`value`) {
      setProfile(value)
    }

  /**
   * If `false`, in case the target skeleton has fewer bones than the source skeleton, the source
   * bone parent's transform will be ignored.
   *
   * Instead, it is possible to retarget between models with different body shapes, and position,
   * rotation, and scale can be retargeted separately.
   *
   * If `true`, retargeting is performed taking into account global pose.
   *
   * In case the target skeleton has fewer bones than the source skeleton, the source bone parent's
   * transform is taken into account. However, bone length between skeletons must match exactly, if
   * not, the bones will be forced to expand or shrink.
   *
   * This is useful for using dummy bone with length `0` to match postures when retargeting between
   * models with different number of bones.
   */
  public final inline var useGlobalPose: Boolean
    @JvmName("useGlobalPoseProperty")
    get() = isUsingGlobalPose()
    @JvmName("useGlobalPoseProperty")
    set(`value`) {
      setUseGlobalPose(value)
    }

  /**
   * Flags to control the process of the transform elements individually when [useGlobalPose] is
   * disabled.
   */
  public final inline var enable: TransformFlag
    @JvmName("enableProperty")
    get() = getEnableFlags()
    @JvmName("enableProperty")
    set(`value`) {
      setEnableFlags(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(629, scriptPtr)
  }

  public final fun setProfile(profile: SkeletonProfile?): Unit {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, profile)
    TransferContext.callPtrMethod(MethodBindings.setProfilePtr, 0)
  }

  public final fun getProfile(): SkeletonProfile? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getProfilePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as SkeletonProfile?)
  }

  public final fun setUseGlobalPose(useGlobalPose: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, useGlobalPose)
    TransferContext.callPtrMethod(MethodBindings.setUseGlobalPosePtr, 0)
  }

  public final fun isUsingGlobalPose(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isUsingGlobalPosePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setEnableFlags(enableFlags: TransformFlag): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, enableFlags.flag)
    TransferContext.callPtrMethod(MethodBindings.setEnableFlagsPtr, 0)
  }

  public final fun getEnableFlags(): TransformFlag {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getEnableFlagsPtr, 2)
    return TransformFlag(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets [TRANSFORM_FLAG_POSITION] into [enable].
   */
  public final fun setPositionEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setPositionEnabledPtr, 0)
  }

  /**
   * Returns `true` if [enable] has [TRANSFORM_FLAG_POSITION].
   */
  public final fun isPositionEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isPositionEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets [TRANSFORM_FLAG_ROTATION] into [enable].
   */
  public final fun setRotationEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setRotationEnabledPtr, 0)
  }

  /**
   * Returns `true` if [enable] has [TRANSFORM_FLAG_ROTATION].
   */
  public final fun isRotationEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isRotationEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets [TRANSFORM_FLAG_SCALE] into [enable].
   */
  public final fun setScaleEnabled(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callPtrMethod(MethodBindings.setScaleEnabledPtr, 0)
  }

  /**
   * Returns `true` if [enable] has [TRANSFORM_FLAG_SCALE].
   */
  public final fun isScaleEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.isScaleEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  public class TransformFlag(
    flag: Long,
  ) : BitFieldBase<TransformFlag>(flag) {
    protected override fun wrap(flag: Long): TransformFlag = TransformFlag(flag)

    public companion object {
      /**
       * If set, allows to retarget the position.
       */
      @JvmField
      public val POSITION: TransformFlag = TransformFlag(1)

      /**
       * If set, allows to retarget the rotation.
       */
      @JvmField
      public val ROTATION: TransformFlag = TransformFlag(2)

      /**
       * If set, allows to retarget the scale.
       */
      @JvmField
      public val SCALE: TransformFlag = TransformFlag(4)

      /**
       * If set, allows to retarget the position/rotation/scale.
       */
      @JvmField
      public val ALL: TransformFlag = TransformFlag(7)
    }
  }

  public companion object {
    @JvmField
    public val setProfileName: MethodStringName1<RetargetModifier3D, Unit, SkeletonProfile?> =
        MethodStringName1<RetargetModifier3D, Unit, SkeletonProfile?>("set_profile")

    @JvmField
    public val getProfileName: MethodStringName0<RetargetModifier3D, SkeletonProfile?> =
        MethodStringName0<RetargetModifier3D, SkeletonProfile?>("get_profile")

    @JvmField
    public val setUseGlobalPoseName: MethodStringName1<RetargetModifier3D, Unit, Boolean> =
        MethodStringName1<RetargetModifier3D, Unit, Boolean>("set_use_global_pose")

    @JvmField
    public val isUsingGlobalPoseName: MethodStringName0<RetargetModifier3D, Boolean> =
        MethodStringName0<RetargetModifier3D, Boolean>("is_using_global_pose")

    @JvmField
    public val setEnableFlagsName: MethodStringName1<RetargetModifier3D, Unit, TransformFlag> =
        MethodStringName1<RetargetModifier3D, Unit, TransformFlag>("set_enable_flags")

    @JvmField
    public val getEnableFlagsName: MethodStringName0<RetargetModifier3D, TransformFlag> =
        MethodStringName0<RetargetModifier3D, TransformFlag>("get_enable_flags")

    @JvmField
    public val setPositionEnabledName: MethodStringName1<RetargetModifier3D, Unit, Boolean> =
        MethodStringName1<RetargetModifier3D, Unit, Boolean>("set_position_enabled")

    @JvmField
    public val isPositionEnabledName: MethodStringName0<RetargetModifier3D, Boolean> =
        MethodStringName0<RetargetModifier3D, Boolean>("is_position_enabled")

    @JvmField
    public val setRotationEnabledName: MethodStringName1<RetargetModifier3D, Unit, Boolean> =
        MethodStringName1<RetargetModifier3D, Unit, Boolean>("set_rotation_enabled")

    @JvmField
    public val isRotationEnabledName: MethodStringName0<RetargetModifier3D, Boolean> =
        MethodStringName0<RetargetModifier3D, Boolean>("is_rotation_enabled")

    @JvmField
    public val setScaleEnabledName: MethodStringName1<RetargetModifier3D, Unit, Boolean> =
        MethodStringName1<RetargetModifier3D, Unit, Boolean>("set_scale_enabled")

    @JvmField
    public val isScaleEnabledName: MethodStringName0<RetargetModifier3D, Boolean> =
        MethodStringName0<RetargetModifier3D, Boolean>("is_scale_enabled")
  }

  public object MethodBindings {
    internal val setProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "set_profile", 3870374136)

    internal val getProfilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "get_profile", 4291782652)

    internal val setUseGlobalPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "set_use_global_pose", 2586408642)

    internal val isUsingGlobalPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "is_using_global_pose", 36873697)

    internal val setEnableFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "set_enable_flags", 2687954213)

    internal val getEnableFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "get_enable_flags", 358995420)

    internal val setPositionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "set_position_enabled", 2586408642)

    internal val isPositionEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "is_position_enabled", 36873697)

    internal val setRotationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "set_rotation_enabled", 2586408642)

    internal val isRotationEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "is_rotation_enabled", 36873697)

    internal val setScaleEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "set_scale_enabled", 2586408642)

    internal val isScaleEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RetargetModifier3D", "is_scale_enabled", 36873697)
  }
}
