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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

public infix fun Long.or(other: CopyTransformModifier3D.TransformFlag): Long = this.or(other.flag)

public infix fun Long.xor(other: CopyTransformModifier3D.TransformFlag): Long = this.xor(other.flag)

public infix fun Long.and(other: CopyTransformModifier3D.TransformFlag): Long = this.and(other.flag)

public infix fun Long.or(other: CopyTransformModifier3D.AxisFlag): Long = this.or(other.flag)

public infix fun Long.xor(other: CopyTransformModifier3D.AxisFlag): Long = this.xor(other.flag)

public infix fun Long.and(other: CopyTransformModifier3D.AxisFlag): Long = this.and(other.flag)

/**
 * Apply the copied transform of the bone set by [BoneConstraint3D.setReferenceBone] to the bone set
 * by [BoneConstraint3D.setApplyBone] with processing it with some masks and options.
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
 */
@GodotBaseType
public open class CopyTransformModifier3D : BoneConstraint3D() {
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
    createNativeObject(189, scriptPtr)
  }

  /**
   * Sets the flags to process the transform operations. If the flag is valid, the transform
   * operation is processed.
   *
   * **Note:** If the rotation is valid for only one axis, it respects the roll of the valid axis.
   * If the rotation is valid for two axes, it discards the roll of the invalid axis.
   */
  public final fun setCopyFlags(index: Int, copyFlags: TransformFlag): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to copyFlags.flag)
    TransferContext.callMethod(MethodBindings.setCopyFlagsPtr)
  }

  /**
   * Returns the copy flags of the setting at [index].
   */
  public final fun getCopyFlags(index: Int): TransformFlag {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getCopyFlagsPtr)
    return TransformFlag(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the flags to copy axes. If the flag is valid, the axis is copied.
   */
  public final fun setAxisFlags(index: Int, axisFlags: AxisFlag): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to axisFlags.flag)
    TransferContext.callMethod(MethodBindings.setAxisFlagsPtr)
  }

  /**
   * Returns the axis flags of the setting at [index].
   */
  public final fun getAxisFlags(index: Int): AxisFlag {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getAxisFlagsPtr)
    return AxisFlag(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the flags to inverte axes. If the flag is valid, the axis is copied.
   *
   * **Note:** An inverted scale means an inverse number, not a negative scale. For example,
   * inverting `2.0` means `0.5`.
   *
   * **Note:** An inverted rotation flips the elements of the quaternion. For example, a two-axis
   * inversion will flip the roll of each axis, and a three-axis inversion will flip the final
   * orientation. However, be aware that flipping only one axis may cause unintended rotation by the
   * unflipped axes, due to the characteristics of the quaternion.
   */
  public final fun setInvertFlags(index: Int, axisFlags: AxisFlag): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), LONG to axisFlags.flag)
    TransferContext.callMethod(MethodBindings.setInvertFlagsPtr)
  }

  /**
   * Returns the invert flags of the setting at [index].
   */
  public final fun getInvertFlags(index: Int): AxisFlag {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getInvertFlagsPtr)
    return AxisFlag(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * If sets [enabled] to `true`, the position will be copied.
   */
  public final fun setCopyPosition(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCopyPositionPtr)
  }

  /**
   * Returns `true` if the copy flags has the flag for the position in the setting at [index]. See
   * also [setCopyFlags].
   */
  public final fun isPositionCopying(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isPositionCopyingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the rotation will be copied.
   */
  public final fun setCopyRotation(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCopyRotationPtr)
  }

  /**
   * Returns `true` if the copy flags has the flag for the rotation in the setting at [index]. See
   * also [setCopyFlags].
   */
  public final fun isRotationCopying(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isRotationCopyingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the scale will be copied.
   */
  public final fun setCopyScale(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCopyScalePtr)
  }

  /**
   * Returns `true` if the copy flags has the flag for the scale in the setting at [index]. See also
   * [setCopyFlags].
   */
  public final fun isScaleCopying(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isScaleCopyingPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the X-axis will be copied.
   */
  public final fun setAxisXEnabled(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAxisXEnabledPtr)
  }

  /**
   * Returns `true` if the enable flags has the flag for the X-axis in the setting at [index]. See
   * also [setAxisFlags].
   */
  public final fun isAxisXEnabled(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isAxisXEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the Y-axis will be copied.
   */
  public final fun setAxisYEnabled(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAxisYEnabledPtr)
  }

  /**
   * Returns `true` if the enable flags has the flag for the Y-axis in the setting at [index]. See
   * also [setAxisFlags].
   */
  public final fun isAxisYEnabled(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isAxisYEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the Z-axis will be copied.
   */
  public final fun setAxisZEnabled(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAxisZEnabledPtr)
  }

  /**
   * Returns `true` if the enable flags has the flag for the Z-axis in the setting at [index]. See
   * also [setAxisFlags].
   */
  public final fun isAxisZEnabled(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isAxisZEnabledPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the X-axis will be inverted.
   */
  public final fun setAxisXInverted(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAxisXInvertedPtr)
  }

  /**
   * Returns `true` if the invert flags has the flag for the X-axis in the setting at [index]. See
   * also [setInvertFlags].
   */
  public final fun isAxisXInverted(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isAxisXInvertedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the Y-axis will be inverted.
   */
  public final fun setAxisYInverted(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAxisYInvertedPtr)
  }

  /**
   * Returns `true` if the invert flags has the flag for the Y-axis in the setting at [index]. See
   * also [setInvertFlags].
   */
  public final fun isAxisYInverted(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isAxisYInvertedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * If sets [enabled] to `true`, the Z-axis will be inverted.
   */
  public final fun setAxisZInverted(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAxisZInvertedPtr)
  }

  /**
   * Returns `true` if the invert flags has the flag for the Z-axis in the setting at [index]. See
   * also [setInvertFlags].
   */
  public final fun isAxisZInverted(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isAxisZInvertedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Sets relative option in the setting at [index] to [enabled].
   *
   * If sets [enabled] to `true`, the extracted and applying transform is relative to the rest.
   *
   * If sets [enabled] to `false`, the extracted transform is absolute.
   */
  public final fun setRelative(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setRelativePtr)
  }

  /**
   * Returns `true` if the relative option is enabled in the setting at [index].
   */
  public final fun isRelative(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isRelativePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

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
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong(), BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setAdditivePtr)
  }

  /**
   * Returns `true` if the additive option is enabled in the setting at [index].
   */
  public final fun isAdditive(index: Int): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.isAdditivePtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public class TransformFlag(
    flag: Long,
  ) : BitFieldBase<TransformFlag>(flag) {
    protected override fun wrap(flag: Long): TransformFlag = TransformFlag(flag)

    public companion object {
      /**
       * If set, allows to copy the position.
       */
      @JvmField
      public val POSITION: TransformFlag = TransformFlag(1)

      /**
       * If set, allows to copy the rotation.
       */
      @JvmField
      public val ROTATION: TransformFlag = TransformFlag(2)

      /**
       * If set, allows to copy the scale.
       */
      @JvmField
      public val SCALE: TransformFlag = TransformFlag(4)

      /**
       * If set, allows to copy the position/rotation/scale.
       */
      @JvmField
      public val ALL: TransformFlag = TransformFlag(7)
    }
  }

  public class AxisFlag(
    flag: Long,
  ) : BitFieldBase<AxisFlag>(flag) {
    protected override fun wrap(flag: Long): AxisFlag = AxisFlag(flag)

    public companion object {
      /**
       * If set, allows to process the X-axis.
       */
      @JvmField
      public val X: AxisFlag = AxisFlag(1)

      /**
       * If set, allows to process the Y-axis.
       */
      @JvmField
      public val Y: AxisFlag = AxisFlag(2)

      /**
       * If set, allows to process the Z-axis.
       */
      @JvmField
      public val Z: AxisFlag = AxisFlag(4)

      /**
       * If set, allows to process the all axes.
       */
      @JvmField
      public val ALL: AxisFlag = AxisFlag(7)
    }
  }

  public companion object {
    @JvmField
    public val setCopyFlagsName:
        MethodStringName2<CopyTransformModifier3D, Unit, Int, TransformFlag> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, TransformFlag>("set_copy_flags")

    @JvmField
    public val getCopyFlagsName: MethodStringName1<CopyTransformModifier3D, TransformFlag, Int> =
        MethodStringName1<CopyTransformModifier3D, TransformFlag, Int>("get_copy_flags")

    @JvmField
    public val setAxisFlagsName: MethodStringName2<CopyTransformModifier3D, Unit, Int, AxisFlag> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, AxisFlag>("set_axis_flags")

    @JvmField
    public val getAxisFlagsName: MethodStringName1<CopyTransformModifier3D, AxisFlag, Int> =
        MethodStringName1<CopyTransformModifier3D, AxisFlag, Int>("get_axis_flags")

    @JvmField
    public val setInvertFlagsName: MethodStringName2<CopyTransformModifier3D, Unit, Int, AxisFlag> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, AxisFlag>("set_invert_flags")

    @JvmField
    public val getInvertFlagsName: MethodStringName1<CopyTransformModifier3D, AxisFlag, Int> =
        MethodStringName1<CopyTransformModifier3D, AxisFlag, Int>("get_invert_flags")

    @JvmField
    public val setCopyPositionName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_copy_position")

    @JvmField
    public val isPositionCopyingName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_position_copying")

    @JvmField
    public val setCopyRotationName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_copy_rotation")

    @JvmField
    public val isRotationCopyingName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_rotation_copying")

    @JvmField
    public val setCopyScaleName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_copy_scale")

    @JvmField
    public val isScaleCopyingName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_scale_copying")

    @JvmField
    public val setAxisXEnabledName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_axis_x_enabled")

    @JvmField
    public val isAxisXEnabledName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_axis_x_enabled")

    @JvmField
    public val setAxisYEnabledName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_axis_y_enabled")

    @JvmField
    public val isAxisYEnabledName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_axis_y_enabled")

    @JvmField
    public val setAxisZEnabledName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_axis_z_enabled")

    @JvmField
    public val isAxisZEnabledName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_axis_z_enabled")

    @JvmField
    public val setAxisXInvertedName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>
        = MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_axis_x_inverted")

    @JvmField
    public val isAxisXInvertedName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_axis_x_inverted")

    @JvmField
    public val setAxisYInvertedName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>
        = MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_axis_y_inverted")

    @JvmField
    public val isAxisYInvertedName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_axis_y_inverted")

    @JvmField
    public val setAxisZInvertedName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>
        = MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_axis_z_inverted")

    @JvmField
    public val isAxisZInvertedName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_axis_z_inverted")

    @JvmField
    public val setRelativeName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_relative")

    @JvmField
    public val isRelativeName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_relative")

    @JvmField
    public val setAdditiveName: MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean> =
        MethodStringName2<CopyTransformModifier3D, Unit, Int, Boolean>("set_additive")

    @JvmField
    public val isAdditiveName: MethodStringName1<CopyTransformModifier3D, Boolean, Int> =
        MethodStringName1<CopyTransformModifier3D, Boolean, Int>("is_additive")
  }

  public object MethodBindings {
    internal val setCopyFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_copy_flags", 2252507859)

    internal val getCopyFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "get_copy_flags", 1685185931)

    internal val setAxisFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_axis_flags", 2044211897)

    internal val getAxisFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "get_axis_flags", 992162046)

    internal val setInvertFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_invert_flags", 2044211897)

    internal val getInvertFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "get_invert_flags", 992162046)

    internal val setCopyPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_copy_position", 300928843)

    internal val isPositionCopyingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_position_copying", 1116898809)

    internal val setCopyRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_copy_rotation", 300928843)

    internal val isRotationCopyingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_rotation_copying", 1116898809)

    internal val setCopyScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_copy_scale", 300928843)

    internal val isScaleCopyingPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_scale_copying", 1116898809)

    internal val setAxisXEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_axis_x_enabled", 300928843)

    internal val isAxisXEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_axis_x_enabled", 1116898809)

    internal val setAxisYEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_axis_y_enabled", 300928843)

    internal val isAxisYEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_axis_y_enabled", 1116898809)

    internal val setAxisZEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_axis_z_enabled", 300928843)

    internal val isAxisZEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_axis_z_enabled", 1116898809)

    internal val setAxisXInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_axis_x_inverted", 300928843)

    internal val isAxisXInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_axis_x_inverted", 1116898809)

    internal val setAxisYInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_axis_y_inverted", 300928843)

    internal val isAxisYInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_axis_y_inverted", 1116898809)

    internal val setAxisZInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_axis_z_inverted", 300928843)

    internal val isAxisZInvertedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_axis_z_inverted", 1116898809)

    internal val setRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_relative", 300928843)

    internal val isRelativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_relative", 1116898809)

    internal val setAdditivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "set_additive", 300928843)

    internal val isAdditivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("CopyTransformModifier3D", "is_additive", 1116898809)
  }
}
