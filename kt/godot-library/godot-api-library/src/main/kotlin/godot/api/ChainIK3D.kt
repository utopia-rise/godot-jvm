// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_LONG_LONG_ret_STRING
import godot.callMethod_LONG_STRING
import godot.callMethod_LONG_ret_STRING
import godot.callPtrMethod_LONG_BOOL
import godot.callPtrMethod_LONG_DOUBLE
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_BOOL
import godot.callPtrMethod_LONG_ret_DOUBLE
import godot.callPtrMethod_LONG_ret_LONG
import godot.common.interop.VoidPtr
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * Base class of [SkeletonModifier3D] that automatically generates a joint list from the bones
 * between the root bone and the end bone.
 *
 * **Note:** All the methods in this class take an `index` parameter. This parameter specifies which
 * setting list entry to return if the IK has multiple entries (e.g.
 * `settings/<index>/root_bone_name`).
 */
@GodotBaseType
public open class ChainIK3D internal constructor() : IKModifier3D() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(151, scriptPtr)
  }

  /**
   * Sets the root bone name of the bone chain.
   */
  public final fun setRootBoneName(index: Int, boneName: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setRootBoneNamePtr, index.toLong(), boneName)
  }

  /**
   * Returns the root bone name of the bone chain.
   */
  public final fun getRootBoneName(index: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getRootBoneNamePtr, index.toLong())

  /**
   * Sets the root bone index of the bone chain.
   */
  public final fun setRootBone(index: Int, bone: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setRootBonePtr, index.toLong(), bone.toLong())
  }

  /**
   * Returns the root bone index of the bone chain.
   */
  public final fun getRootBone(index: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getRootBonePtr, index.toLong()).toInt()

  /**
   * Sets the end bone name of the bone chain.
   *
   * **Note:** The end bone must be the root bone or a child of the root bone. If they are the same,
   * the tail must be extended by [setExtendEndBone] to modify the bone.
   */
  public final fun setEndBoneName(index: Int, boneName: String): Unit {
    TransferContext.callMethod_LONG_STRING(ptr, objectID.id, MethodBindings.setEndBoneNamePtr, index.toLong(), boneName)
  }

  /**
   * Returns the end bone name of the bone chain.
   */
  public final fun getEndBoneName(index: Int): String =
      TransferContext.callMethod_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getEndBoneNamePtr, index.toLong())

  /**
   * Sets the end bone index of the bone chain.
   */
  public final fun setEndBone(index: Int, bone: Int): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setEndBonePtr, index.toLong(), bone.toLong())
  }

  /**
   * Returns the end bone index of the bone chain.
   */
  public final fun getEndBone(index: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getEndBonePtr, index.toLong()).toInt()

  /**
   * If [enabled] is `true`, the end bone is extended to have a tail.
   *
   * The extended tail config is allocated to the last element in the joint list. In other words, if
   * you set [enabled] to `false`, the config of the last element in the joint list has no effect in
   * the simulated result.
   */
  public final fun setExtendEndBone(index: Int, enabled: Boolean): Unit {
    TransferContext.callPtrMethod_LONG_BOOL(ptr, objectID.id, MethodBindings.setExtendEndBonePtr, index.toLong(), enabled)
  }

  /**
   * Returns `true` if the end bone is extended to have a tail.
   */
  public final fun isEndBoneExtended(index: Int): Boolean =
      TransferContext.callPtrMethod_LONG_ret_BOOL(ptr, objectID.id, MethodBindings.isEndBoneExtendedPtr, index.toLong())

  /**
   * Sets the end bone tail direction of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun setEndBoneDirection(index: Int, boneDirection: SkeletonModifier3D.BoneDirection):
      Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setEndBoneDirectionPtr, index.toLong(), boneDirection.value)
  }

  /**
   * Returns the tail direction of the end bone of the bone chain when [isEndBoneExtended] is
   * `true`.
   */
  public final fun getEndBoneDirection(index: Int): SkeletonModifier3D.BoneDirection =
      SkeletonModifier3D.BoneDirection.from(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getEndBoneDirectionPtr, index.toLong()))

  /**
   * Sets the end bone tail length of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun setEndBoneLength(index: Int, length: Float): Unit {
    TransferContext.callPtrMethod_LONG_DOUBLE(ptr, objectID.id, MethodBindings.setEndBoneLengthPtr, index.toLong(), length.toDouble())
  }

  /**
   * Returns the end bone tail length of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun getEndBoneLength(index: Int): Float =
      TransferContext.callPtrMethod_LONG_ret_DOUBLE(ptr, objectID.id, MethodBindings.getEndBoneLengthPtr, index.toLong()).toFloat()

  /**
   * Returns the bone name at [joint] in the bone chain's joint list.
   */
  public final fun getJointBoneName(index: Int, joint: Int): String =
      TransferContext.callMethod_LONG_LONG_ret_STRING(ptr, objectID.id, MethodBindings.getJointBoneNamePtr, index.toLong(), joint.toLong())

  /**
   * Returns the bone index at [joint] in the bone chain's joint list.
   */
  public final fun getJointBone(index: Int, joint: Int): Int =
      TransferContext.callPtrMethod_LONG_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getJointBonePtr, index.toLong(), joint.toLong()).toInt()

  /**
   * Returns the joint count of the bone chain's joint list.
   */
  public final fun getJointCount(index: Int): Int =
      TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getJointCountPtr, index.toLong()).toInt()

  public companion object {
    @JvmField
    public val setRootBoneNameName: MethodStringName2<ChainIK3D, Unit, Int, String> =
        MethodStringName2<ChainIK3D, Unit, Int, String>("set_root_bone_name")

    @JvmField
    public val getRootBoneNameName: MethodStringName1<ChainIK3D, String, Int> =
        MethodStringName1<ChainIK3D, String, Int>("get_root_bone_name")

    @JvmField
    public val setRootBoneName: MethodStringName2<ChainIK3D, Unit, Int, Int> =
        MethodStringName2<ChainIK3D, Unit, Int, Int>("set_root_bone")

    @JvmField
    public val getRootBoneName: MethodStringName1<ChainIK3D, Int, Int> =
        MethodStringName1<ChainIK3D, Int, Int>("get_root_bone")

    @JvmField
    public val setEndBoneNameName: MethodStringName2<ChainIK3D, Unit, Int, String> =
        MethodStringName2<ChainIK3D, Unit, Int, String>("set_end_bone_name")

    @JvmField
    public val getEndBoneNameName: MethodStringName1<ChainIK3D, String, Int> =
        MethodStringName1<ChainIK3D, String, Int>("get_end_bone_name")

    @JvmField
    public val setEndBoneName: MethodStringName2<ChainIK3D, Unit, Int, Int> =
        MethodStringName2<ChainIK3D, Unit, Int, Int>("set_end_bone")

    @JvmField
    public val getEndBoneName: MethodStringName1<ChainIK3D, Int, Int> =
        MethodStringName1<ChainIK3D, Int, Int>("get_end_bone")

    @JvmField
    public val setExtendEndBoneName: MethodStringName2<ChainIK3D, Unit, Int, Boolean> =
        MethodStringName2<ChainIK3D, Unit, Int, Boolean>("set_extend_end_bone")

    @JvmField
    public val isEndBoneExtendedName: MethodStringName1<ChainIK3D, Boolean, Int> =
        MethodStringName1<ChainIK3D, Boolean, Int>("is_end_bone_extended")

    @JvmField
    public val setEndBoneDirectionName:
        MethodStringName2<ChainIK3D, Unit, Int, SkeletonModifier3D.BoneDirection> =
        MethodStringName2<ChainIK3D, Unit, Int, SkeletonModifier3D.BoneDirection>("set_end_bone_direction")

    @JvmField
    public val getEndBoneDirectionName:
        MethodStringName1<ChainIK3D, SkeletonModifier3D.BoneDirection, Int> =
        MethodStringName1<ChainIK3D, SkeletonModifier3D.BoneDirection, Int>("get_end_bone_direction")

    @JvmField
    public val setEndBoneLengthName: MethodStringName2<ChainIK3D, Unit, Int, Float> =
        MethodStringName2<ChainIK3D, Unit, Int, Float>("set_end_bone_length")

    @JvmField
    public val getEndBoneLengthName: MethodStringName1<ChainIK3D, Float, Int> =
        MethodStringName1<ChainIK3D, Float, Int>("get_end_bone_length")

    @JvmField
    public val getJointBoneNameName: MethodStringName2<ChainIK3D, String, Int, Int> =
        MethodStringName2<ChainIK3D, String, Int, Int>("get_joint_bone_name")

    @JvmField
    public val getJointBoneName: MethodStringName2<ChainIK3D, Int, Int, Int> =
        MethodStringName2<ChainIK3D, Int, Int, Int>("get_joint_bone")

    @JvmField
    public val getJointCountName: MethodStringName1<ChainIK3D, Int, Int> =
        MethodStringName1<ChainIK3D, Int, Int>("get_joint_count")
  }

  public object MethodBindings {
    internal val setRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "set_root_bone_name", 501894301)

    internal val getRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_root_bone_name", 844755477)

    internal val setRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "set_root_bone", 3937882851)

    internal val getRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_root_bone", 923996154)

    internal val setEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "set_end_bone_name", 501894301)

    internal val getEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_end_bone_name", 844755477)

    internal val setEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "set_end_bone", 3937882851)

    internal val getEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_end_bone", 923996154)

    internal val setExtendEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "set_extend_end_bone", 300928843)

    internal val isEndBoneExtendedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "is_end_bone_extended", 1116898809)

    internal val setEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "set_end_bone_direction", 2838484201)

    internal val getEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_end_bone_direction", 1843036459)

    internal val setEndBoneLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "set_end_bone_length", 1602489585)

    internal val getEndBoneLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_end_bone_length", 2339986948)

    internal val getJointBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_joint_bone_name", 1391810591)

    internal val getJointBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_joint_bone", 3175239445)

    internal val getJointCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ChainIK3D", "get_joint_count", 923996154)
  }
}
