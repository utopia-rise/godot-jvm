// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod_LONG_BOOL
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This is a simple version of [LookAtModifier3D] that only allows bone to the reference without
 * advanced options such as angle limitation or time-based interpolation.
 *
 * The feature is simplified, but instead it is implemented with smooth tracking without euler, see
 * [setUseEuler].
 */
@GodotBaseType
public open class AimModifier3D : BoneConstraint3D() {
  /**
   * The number of settings in the modifier.
   */
  public final inline var settingCount: Int
    @JvmName("settingCountProperty")
    get() = getSettingCount()
    @JvmName("settingCountProperty")
    set(`value`) {
      setSettingCount(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(6, scriptPtr)
  }

  /**
   * Sets the forward axis of the bone.
   */
  public final fun setForwardAxis(index: Int, axis: SkeletonModifier3D.BoneAxis): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setForwardAxisPtr, index.toLong(), axis.value)
  }

  /**
   * Returns the forward axis of the bone.
   */
  public final fun getForwardAxis(index: Int): SkeletonModifier3D.BoneAxis =
      SkeletonModifier3D.BoneAxis.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getForwardAxisPtr, index.toLong()))

  /**
   * If sets [enabled] to `true`, it provides rotation with using euler.
   *
   * If sets [enabled] to `false`, it provides rotation with using rotation by arc generated from
   * the forward axis vector and the vector toward the reference.
   */
  public final fun setUseEuler(index: Int, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setUseEulerPtr, index.toLong(), enabled)
  }

  /**
   * Returns `true` if it provides rotation with using euler.
   */
  public final fun isUsingEuler(index: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isUsingEulerPtr, index.toLong())

  /**
   * Sets the axis of the first rotation. It is enabled only if [isUsingEuler] is `true`.
   */
  public final fun setPrimaryRotationAxis(index: Int, axis: Vector3.Axis): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setPrimaryRotationAxisPtr, index.toLong(), axis.value)
  }

  /**
   * Returns the axis of the first rotation. It is enabled only if [isUsingEuler] is `true`.
   */
  public final fun getPrimaryRotationAxis(index: Int): Vector3.Axis =
      Vector3.Axis.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getPrimaryRotationAxisPtr, index.toLong()))

  /**
   * If sets [enabled] to `true`, it provides rotation by two axes. It is enabled only if
   * [isUsingEuler] is `true`.
   */
  public final fun setUseSecondaryRotation(index: Int, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setUseSecondaryRotationPtr, index.toLong(), enabled)
  }

  /**
   * Returns `true` if it provides rotation by two axes. It is enabled only if [isUsingEuler] is
   * `true`.
   */
  public final fun isUsingSecondaryRotation(index: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isUsingSecondaryRotationPtr, index.toLong())

  /**
   * Sets relative option in the setting at [index] to [enabled].
   *
   * If sets [enabled] to `true`, the rotation is applied relative to the pose.
   *
   * If sets [enabled] to `false`, the rotation is applied relative to the rest. It means to replace
   * the current pose with the [AimModifier3D]'s result.
   */
  public final fun setRelative(index: Int, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setRelativePtr, index.toLong(), enabled)
  }

  /**
   * Returns `true` if the relative option is enabled in the setting at [index].
   */
  public final fun isRelative(index: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isRelativePtr, index.toLong())

  public companion object {
    @JvmField
    public val setForwardAxisName:
        MethodStringName2<AimModifier3D, Unit, Int, SkeletonModifier3D.BoneAxis> =
        MethodStringName2<AimModifier3D, Unit, Int, SkeletonModifier3D.BoneAxis>("set_forward_axis")

    @JvmField
    public val getForwardAxisName:
        MethodStringName1<AimModifier3D, SkeletonModifier3D.BoneAxis, Int> =
        MethodStringName1<AimModifier3D, SkeletonModifier3D.BoneAxis, Int>("get_forward_axis")

    @JvmField
    public val setUseEulerName: MethodStringName2<AimModifier3D, Unit, Int, Boolean> =
        MethodStringName2<AimModifier3D, Unit, Int, Boolean>("set_use_euler")

    @JvmField
    public val isUsingEulerName: MethodStringName1<AimModifier3D, Boolean, Int> =
        MethodStringName1<AimModifier3D, Boolean, Int>("is_using_euler")

    @JvmField
    public val setPrimaryRotationAxisName: MethodStringName2<AimModifier3D, Unit, Int, Vector3.Axis>
        = MethodStringName2<AimModifier3D, Unit, Int, Vector3.Axis>("set_primary_rotation_axis")

    @JvmField
    public val getPrimaryRotationAxisName: MethodStringName1<AimModifier3D, Vector3.Axis, Int> =
        MethodStringName1<AimModifier3D, Vector3.Axis, Int>("get_primary_rotation_axis")

    @JvmField
    public val setUseSecondaryRotationName: MethodStringName2<AimModifier3D, Unit, Int, Boolean> =
        MethodStringName2<AimModifier3D, Unit, Int, Boolean>("set_use_secondary_rotation")

    @JvmField
    public val isUsingSecondaryRotationName: MethodStringName1<AimModifier3D, Boolean, Int> =
        MethodStringName1<AimModifier3D, Boolean, Int>("is_using_secondary_rotation")

    @JvmField
    public val setRelativeName: MethodStringName2<AimModifier3D, Unit, Int, Boolean> =
        MethodStringName2<AimModifier3D, Unit, Int, Boolean>("set_relative")

    @JvmField
    public val isRelativeName: MethodStringName1<AimModifier3D, Boolean, Int> =
        MethodStringName1<AimModifier3D, Boolean, Int>("is_relative")
  }

  public object MethodBindings {
    internal val setForwardAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "set_forward_axis", 2496831085)

    internal val getForwardAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "get_forward_axis", 3949866735)

    internal val setUseEulerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "set_use_euler", 300928843)

    internal val isUsingEulerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "is_using_euler", 1116898809)

    internal val setPrimaryRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "set_primary_rotation_axis", 776736805)

    internal val getPrimaryRotationAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "get_primary_rotation_axis", 4131134770)

    internal val setUseSecondaryRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "set_use_secondary_rotation", 300928843)

    internal val isUsingSecondaryRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "is_using_secondary_rotation", 1116898809)

    internal val setRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "set_relative", 300928843)

    internal val isRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("AimModifier3D", "is_relative", 1116898809)
  }
}
