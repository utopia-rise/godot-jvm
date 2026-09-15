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
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.NodePath
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_NODE_PATH
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * A [SkeletonModifier3D] for aligning bones along a [Path3D]. The smoothness of the fitting depends
 * on the [Curve3D.bakeInterval].
 *
 * If you want the [Path3D] to attach to a specific bone, it is recommended to place a
 * [ModifierBoneTarget3D] before the [SplineIK3D] in the [SkeletonModifier3D] list (children of the
 * [Skeleton3D]), and then place a [Path3D] as the [ModifierBoneTarget3D]'s child.
 *
 * Bone twist is determined based on the [Curve3D.getPointTilt].
 *
 * If the root bone joint and the start point of the [Curve3D] are separated, it assumes that there
 * is a linear line segment between them. This means that the vector pointing toward the start point of
 * the [Curve3D] takes precedence over the shortest intersection point along the [Curve3D].
 *
 * If the end bone joint exceeds the path length, it is bent as close as possible to the end point
 * of the [Curve3D].
 *
 * **Note:** All the methods in this class take an `index` parameter. This parameter specifies which
 * setting list entry to return if the IK has multiple entries (e.g.
 * `settings/<index>/root_bone_name`).
 */
@GodotBaseType
public open class SplineIK3D : ChainIK3D() {
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
    createNativeObject(690, scriptPtr)
  }

  /**
   * Sets the node path of the [Path3D] which is describing the path.
   */
  public final fun setPath3d(index: Int, path3d: NodePath): Unit {
    TransferContext.writeMethodArguments_LONG_NODE_PATH(ptr, objectID.id, index.toLong(), path3d)
    TransferContext.callPtrMethod(MethodBindings.setPath3dPtr, 0)
  }

  /**
   * Returns the node path of the [Path3D] which is describing the path.
   */
  public final fun getPath3d(index: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getPath3dPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets if the tilt property of the [Curve3D] should affect the bone twist.
   */
  public final fun setTiltEnabled(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, index.toLong(), enabled)
    TransferContext.callPtrMethod(MethodBindings.setTiltEnabledPtr, 0)
  }

  /**
   * Returns if the tilt property of the [Curve3D] affects the bone twist.
   */
  public final fun isTiltEnabled(index: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.isTiltEnabledPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * If [size] is greater than `0`, the tilt is interpolated between [size] start bones from the
   * start point of the [Curve3D] when they are apart.
   *
   * If [size] is equal `0`, the tilts between the root bone head and the start point of the
   * [Curve3D] are unified with a tilt of the start point of the [Curve3D].
   *
   * If [size] is less than `0`, the tilts between the root bone and the start point of the
   * [Curve3D] are `0.0`.
   */
  public final fun setTiltFadeIn(index: Int, size: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), size.toLong())
    TransferContext.callPtrMethod(MethodBindings.setTiltFadeInPtr, 0)
  }

  /**
   * Returns the tilt interpolation method used between the root bone and the start point of the
   * [Curve3D] when they are apart. See also [setTiltFadeIn].
   */
  public final fun getTiltFadeIn(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTiltFadeInPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * If [size] is greater than `0`, the tilt is interpolated between [size] end bones from the end
   * point of the [Curve3D] when they are apart.
   *
   * If [size] is equal `0`, the tilts between the end bone tail and the end point of the [Curve3D]
   * are unified with a tilt of the end point of the [Curve3D].
   *
   * If [size] is less than `0`, the tilts between the end bone and the end point of the [Curve3D]
   * are `0.0`.
   */
  public final fun setTiltFadeOut(index: Int, size: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), size.toLong())
    TransferContext.callPtrMethod(MethodBindings.setTiltFadeOutPtr, 0)
  }

  /**
   * Returns the tilt interpolation method used between the end bone and the end point of the
   * [Curve3D] when they are apart. See also [setTiltFadeOut].
   */
  public final fun getTiltFadeOut(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTiltFadeOutPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the node path of the [Path3D] which is describing the path.
   */
  public final fun setPath3d(index: Int, path3d: String) =
      setPath3d(index, path3d.asCachedNodePath())

  public companion object {
    @JvmField
    public val setPath3dName: MethodStringName2<SplineIK3D, Unit, Int, NodePath> =
        MethodStringName2<SplineIK3D, Unit, Int, NodePath>("set_path_3d")

    @JvmField
    public val getPath3dName: MethodStringName1<SplineIK3D, NodePath, Int> =
        MethodStringName1<SplineIK3D, NodePath, Int>("get_path_3d")

    @JvmField
    public val setTiltEnabledName: MethodStringName2<SplineIK3D, Unit, Int, Boolean> =
        MethodStringName2<SplineIK3D, Unit, Int, Boolean>("set_tilt_enabled")

    @JvmField
    public val isTiltEnabledName: MethodStringName1<SplineIK3D, Boolean, Int> =
        MethodStringName1<SplineIK3D, Boolean, Int>("is_tilt_enabled")

    @JvmField
    public val setTiltFadeInName: MethodStringName2<SplineIK3D, Unit, Int, Int> =
        MethodStringName2<SplineIK3D, Unit, Int, Int>("set_tilt_fade_in")

    @JvmField
    public val getTiltFadeInName: MethodStringName1<SplineIK3D, Int, Int> =
        MethodStringName1<SplineIK3D, Int, Int>("get_tilt_fade_in")

    @JvmField
    public val setTiltFadeOutName: MethodStringName2<SplineIK3D, Unit, Int, Int> =
        MethodStringName2<SplineIK3D, Unit, Int, Int>("set_tilt_fade_out")

    @JvmField
    public val getTiltFadeOutName: MethodStringName1<SplineIK3D, Int, Int> =
        MethodStringName1<SplineIK3D, Int, Int>("get_tilt_fade_out")
  }

  public object MethodBindings {
    internal val setPath3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "set_path_3d", 2761262315)

    internal val getPath3dPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "get_path_3d", 408788394)

    internal val setTiltEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "set_tilt_enabled", 300928843)

    internal val isTiltEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "is_tilt_enabled", 1116898809)

    internal val setTiltFadeInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "set_tilt_fade_in", 3937882851)

    internal val getTiltFadeInPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "get_tilt_fade_in", 923996154)

    internal val setTiltFadeOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "set_tilt_fade_out", 3937882851)

    internal val getTiltFadeOutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SplineIK3D", "get_tilt_fade_out", 923996154)
  }
}
