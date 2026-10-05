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
import godot.callPtrMethod_LONG_DOUBLE
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Vector3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * Apply the copied transform of the bone set by [BoneConstraint3D.setReferenceBone] to the bone set
 * by [BoneConstraint3D.setApplyBone] about the specific axis with remapping it with some options.
 *
 * There are 4 ways to apply the transform, depending on the combination of [setRelative] and
 * [setAdditive].
 *
 * **Relative + Additive:**
 *
 * - Extract reference pose relative to the rest and add it to the apply bone's pose.
 *
 * **Relative + Not Additive:**
 *
 * - Extract reference pose relative to the rest and add it to the apply bone's rest.
 *
 * **Not Relative + Additive:**
 *
 * - Extract reference pose absolutely and add it to the apply bone's pose.
 *
 * **Not Relative + Not Additive:**
 *
 * - Extract reference pose absolutely and the apply bone's pose is replaced with it.
 *
 * **Note:** Relative option is available only in the case [BoneConstraint3D.getReferenceType] is
 * [BoneConstraint3D.REFERENCE_TYPE_BONE]. See also [BoneConstraint3D.ReferenceType].
 *
 * **Note:** If there is a rotation greater than `180` degrees with constrained axes, flipping may
 * occur.
 */
@GodotBaseType
public open class ConvertTransformModifier3D : BoneConstraint3D() {
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
    createNativeObject(186, scriptPtr)
  }

  /**
   * Sets the operation of the remapping destination transform.
   */
  public final fun setApplyTransformMode(index: Int, transformMode: TransformMode): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setApplyTransformModePtr, index.toLong(), transformMode.value)
  }

  /**
   * Returns the operation of the remapping destination transform.
   */
  public final fun getApplyTransformMode(index: Int): TransformMode =
      TransformMode.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getApplyTransformModePtr, index.toLong()))

  /**
   * Sets the axis of the remapping destination transform.
   */
  public final fun setApplyAxis(index: Int, axis: Vector3.Axis): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setApplyAxisPtr, index.toLong(), axis.value)
  }

  /**
   * Returns the axis of the remapping destination transform.
   */
  public final fun getApplyAxis(index: Int): Vector3.Axis =
      Vector3.Axis.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getApplyAxisPtr, index.toLong()))

  /**
   * Sets the minimum value of the remapping destination range.
   */
  public final fun setApplyRangeMin(index: Int, rangeMin: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setApplyRangeMinPtr, index.toLong(), rangeMin.toDouble())
  }

  /**
   * Returns the minimum value of the remapping destination range.
   */
  public final fun getApplyRangeMin(index: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getApplyRangeMinPtr, index.toLong()).toFloat()

  /**
   * Sets the maximum value of the remapping destination range.
   */
  public final fun setApplyRangeMax(index: Int, rangeMax: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setApplyRangeMaxPtr, index.toLong(), rangeMax.toDouble())
  }

  /**
   * Returns the maximum value of the remapping destination range.
   */
  public final fun getApplyRangeMax(index: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getApplyRangeMaxPtr, index.toLong()).toFloat()

  /**
   * Sets the operation of the remapping source transform.
   */
  public final fun setReferenceTransformMode(index: Int, transformMode: TransformMode): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setReferenceTransformModePtr, index.toLong(), transformMode.value)
  }

  /**
   * Returns the operation of the remapping source transform.
   */
  public final fun getReferenceTransformMode(index: Int): TransformMode =
      TransformMode.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getReferenceTransformModePtr, index.toLong()))

  /**
   * Sets the axis of the remapping source transform.
   */
  public final fun setReferenceAxis(index: Int, axis: Vector3.Axis): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setReferenceAxisPtr, index.toLong(), axis.value)
  }

  /**
   * Returns the axis of the remapping source transform.
   */
  public final fun getReferenceAxis(index: Int): Vector3.Axis =
      Vector3.Axis.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getReferenceAxisPtr, index.toLong()))

  /**
   * Sets the minimum value of the remapping source range.
   */
  public final fun setReferenceRangeMin(index: Int, rangeMin: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setReferenceRangeMinPtr, index.toLong(), rangeMin.toDouble())
  }

  /**
   * Returns the minimum value of the remapping source range.
   */
  public final fun getReferenceRangeMin(index: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getReferenceRangeMinPtr, index.toLong()).toFloat()

  /**
   * Sets the maximum value of the remapping source range.
   */
  public final fun setReferenceRangeMax(index: Int, rangeMax: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setReferenceRangeMaxPtr, index.toLong(), rangeMax.toDouble())
  }

  /**
   * Returns the maximum value of the remapping source range.
   */
  public final fun getReferenceRangeMax(index: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getReferenceRangeMaxPtr, index.toLong()).toFloat()

  /**
   * Sets relative option in the setting at [index] to [enabled].
   *
   * If sets [enabled] to `true`, the extracted and applying transform is relative to the rest.
   *
   * If sets [enabled] to `false`, the extracted transform is absolute.
   */
  public final fun setRelative(index: Int, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setRelativePtr, index.toLong(), enabled)
  }

  /**
   * Returns `true` if the relative option is enabled in the setting at [index].
   */
  public final fun isRelative(index: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isRelativePtr, index.toLong())

  /**
   * Sets additive option in the setting at [index] to [enabled]. This mainly affects the process of
   * applying transform to the [BoneConstraint3D.setApplyBone].
   *
   * If sets [enabled] to `true`, the processed transform is added to the pose of the current apply
   * bone.
   *
   * If sets [enabled] to `false`, the pose of the current apply bone is replaced with the processed
   * transform. However, if set [setRelative] to `true`, the transform is relative to rest.
   */
  public final fun setAdditive(index: Int, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setAdditivePtr, index.toLong(), enabled)
  }

  /**
   * Returns `true` if the additive option is enabled in the setting at [index].
   */
  public final fun isAdditive(index: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isAdditivePtr, index.toLong())

  public enum class TransformMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Convert with position. Transfer the difference.
     */
    POSITION(0),
    /**
     * Convert with rotation. The angle is the roll for the specified axis.
     */
    ROTATION(1),
    /**
     * Convert with scale. Transfers the ratio, not the difference.
     */
    SCALE(2),
    ;

    public companion object {
      public fun from(`value`: Long): TransformMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setApplyTransformModeName:
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, TransformMode> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, TransformMode>("set_apply_transform_mode")

    @JvmField
    public val getApplyTransformModeName:
        MethodStringName1<ConvertTransformModifier3D, TransformMode, Int> =
        MethodStringName1<ConvertTransformModifier3D, TransformMode, Int>("get_apply_transform_mode")

    @JvmField
    public val setApplyAxisName:
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Vector3.Axis> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Vector3.Axis>("set_apply_axis")

    @JvmField
    public val getApplyAxisName: MethodStringName1<ConvertTransformModifier3D, Vector3.Axis, Int> =
        MethodStringName1<ConvertTransformModifier3D, Vector3.Axis, Int>("get_apply_axis")

    @JvmField
    public val setApplyRangeMinName: MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float>
        = MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float>("set_apply_range_min")

    @JvmField
    public val getApplyRangeMinName: MethodStringName1<ConvertTransformModifier3D, Float, Int> =
        MethodStringName1<ConvertTransformModifier3D, Float, Int>("get_apply_range_min")

    @JvmField
    public val setApplyRangeMaxName: MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float>
        = MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float>("set_apply_range_max")

    @JvmField
    public val getApplyRangeMaxName: MethodStringName1<ConvertTransformModifier3D, Float, Int> =
        MethodStringName1<ConvertTransformModifier3D, Float, Int>("get_apply_range_max")

    @JvmField
    public val setReferenceTransformModeName:
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, TransformMode> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, TransformMode>("set_reference_transform_mode")

    @JvmField
    public val getReferenceTransformModeName:
        MethodStringName1<ConvertTransformModifier3D, TransformMode, Int> =
        MethodStringName1<ConvertTransformModifier3D, TransformMode, Int>("get_reference_transform_mode")

    @JvmField
    public val setReferenceAxisName:
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Vector3.Axis> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Vector3.Axis>("set_reference_axis")

    @JvmField
    public val getReferenceAxisName:
        MethodStringName1<ConvertTransformModifier3D, Vector3.Axis, Int> =
        MethodStringName1<ConvertTransformModifier3D, Vector3.Axis, Int>("get_reference_axis")

    @JvmField
    public val setReferenceRangeMinName:
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float>("set_reference_range_min")

    @JvmField
    public val getReferenceRangeMinName: MethodStringName1<ConvertTransformModifier3D, Float, Int> =
        MethodStringName1<ConvertTransformModifier3D, Float, Int>("get_reference_range_min")

    @JvmField
    public val setReferenceRangeMaxName:
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Float>("set_reference_range_max")

    @JvmField
    public val getReferenceRangeMaxName: MethodStringName1<ConvertTransformModifier3D, Float, Int> =
        MethodStringName1<ConvertTransformModifier3D, Float, Int>("get_reference_range_max")

    @JvmField
    public val setRelativeName: MethodStringName2<ConvertTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Boolean>("set_relative")

    @JvmField
    public val isRelativeName: MethodStringName1<ConvertTransformModifier3D, Boolean, Int> =
        MethodStringName1<ConvertTransformModifier3D, Boolean, Int>("is_relative")

    @JvmField
    public val setAdditiveName: MethodStringName2<ConvertTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<ConvertTransformModifier3D, Unit, Int, Boolean>("set_additive")

    @JvmField
    public val isAdditiveName: MethodStringName1<ConvertTransformModifier3D, Boolean, Int> =
        MethodStringName1<ConvertTransformModifier3D, Boolean, Int>("is_additive")
  }

  public object MethodBindings {
    internal val setApplyTransformModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_apply_transform_mode", 1386463405)

    internal val getApplyTransformModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_apply_transform_mode", 3234663511)

    internal val setApplyAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_apply_axis", 776736805)

    internal val getApplyAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_apply_axis", 4131134770)

    internal val setApplyRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_apply_range_min", 1602489585)

    internal val getApplyRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_apply_range_min", 2339986948)

    internal val setApplyRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_apply_range_max", 1602489585)

    internal val getApplyRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_apply_range_max", 2339986948)

    internal val setReferenceTransformModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_reference_transform_mode", 1386463405)

    internal val getReferenceTransformModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_reference_transform_mode", 3234663511)

    internal val setReferenceAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_reference_axis", 776736805)

    internal val getReferenceAxisPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_reference_axis", 4131134770)

    internal val setReferenceRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_reference_range_min", 1602489585)

    internal val getReferenceRangeMinPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_reference_range_min", 2339986948)

    internal val setReferenceRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_reference_range_max", 1602489585)

    internal val getReferenceRangeMaxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "get_reference_range_max", 2339986948)

    internal val setRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_relative", 300928843)

    internal val isRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "is_relative", 1116898809)

    internal val setAdditivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "set_additive", 300928843)

    internal val isAdditivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ConvertTransformModifier3D", "is_additive", 1116898809)
  }
}
