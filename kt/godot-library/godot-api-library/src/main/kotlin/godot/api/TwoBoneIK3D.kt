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
import godot.core.Vector3
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_STRING
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_NODE_PATH
import godot.writeMethodArguments_LONG_STRING
import godot.writeMethodArguments_LONG_VECTOR3
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This [IKModifier3D] requires a pole target. It provides deterministic results by constructing a
 * plane from each joint and pole target and finding the intersection of two circles (disks in 3D).
 *
 * This IK can handle twist by setting the pole direction. If there are more than one bone between
 * each set bone, their rotations are ignored, and the straight line connecting the root-middle and
 * middle-end joints are treated as virtual bones.
 *
 * **Note:** All the methods in this class take an `index` parameter. This parameter specifies which
 * setting list entry to return if the IK has multiple entries (e.g.
 * `settings/<index>/root_bone_name`).
 */
@GodotBaseType
public open class TwoBoneIK3D : IKModifier3D() {
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
    createNativeObject(777, scriptPtr)
  }

  /**
   * Sets the target node that the end bone is trying to reach.
   */
  public final fun setTargetNode(index: Int, targetNode: NodePath): Unit {
    TransferContext.writeMethodArguments_LONG_NODE_PATH(ptr, objectID.id, index.toLong(), targetNode)
    TransferContext.callPtrMethod(MethodBindings.setTargetNodePtr, 0)
  }

  /**
   * Returns the target node that the end bone is trying to reach.
   */
  public final fun getTargetNode(index: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getTargetNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the pole target node that constructs a plane which the joints are all on and the pole is
   * trying to direct.
   */
  public final fun setPoleNode(index: Int, poleNode: NodePath): Unit {
    TransferContext.writeMethodArguments_LONG_NODE_PATH(ptr, objectID.id, index.toLong(), poleNode)
    TransferContext.callPtrMethod(MethodBindings.setPoleNodePtr, 0)
  }

  /**
   * Returns the pole target node that constructs a plane which the joints are all on and the pole
   * is trying to direct.
   */
  public final fun getPoleNode(index: Int): NodePath {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getPoleNodePtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  /**
   * Sets the root bone name.
   */
  public final fun setRootBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, index.toLong(), boneName)
    TransferContext.callMethod(MethodBindings.setRootBoneNamePtr)
  }

  /**
   * Returns the root bone name.
   */
  public final fun getRootBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getRootBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the root bone index.
   */
  public final fun setRootBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), bone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setRootBonePtr, 0)
  }

  /**
   * Returns the root bone index.
   */
  public final fun getRootBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getRootBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the middle bone name.
   *
   * **Note:** The middle bone must be a child of the root bone.
   */
  public final fun setMiddleBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, index.toLong(), boneName)
    TransferContext.callMethod(MethodBindings.setMiddleBoneNamePtr)
  }

  /**
   * Returns the middle bone name.
   */
  public final fun getMiddleBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getMiddleBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the middle bone index.
   */
  public final fun setMiddleBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), bone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setMiddleBonePtr, 0)
  }

  /**
   * Returns the middle bone index.
   */
  public final fun getMiddleBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getMiddleBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Sets the pole direction.
   *
   * The pole is on the middle bone and will direct to the pole target.
   *
   * The rotation axis is a vector that is orthogonal to this and the forward vector.
   *
   * **Note:** The pole direction and the forward vector shouldn't be colinear to avoid unintended
   * rotation.
   */
  public final fun setPoleDirection(index: Int, direction: SkeletonModifier3D.SecondaryDirection):
      Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), direction.value)
    TransferContext.callPtrMethod(MethodBindings.setPoleDirectionPtr, 0)
  }

  /**
   * Returns the pole direction.
   */
  public final fun getPoleDirection(index: Int): SkeletonModifier3D.SecondaryDirection {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPoleDirectionPtr, 2)
    return SkeletonModifier3D.SecondaryDirection.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the pole direction vector.
   *
   * This vector is normalized by an internal process.
   *
   * If the vector length is `0`, it is considered synonymous with
   * [SkeletonModifier3D.SECONDARY_DIRECTION_NONE].
   */
  public final fun setPoleDirectionVector(index: Int, vector: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, index.toLong(), vector)
    TransferContext.callPtrMethod(MethodBindings.setPoleDirectionVectorPtr, 0)
  }

  /**
   * Returns the pole direction vector.
   *
   * If [getPoleDirection] is [SkeletonModifier3D.SECONDARY_DIRECTION_NONE], this method returns
   * `Vector3(0, 0, 0)`.
   */
  public final fun getPoleDirectionVector(index: Int): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getPoleDirectionVectorPtr, 9)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the end bone name.
   *
   * **Note:** The end bone must be a child of the middle bone.
   */
  public final fun setEndBoneName(index: Int, boneName: String): Unit {
    TransferContext.writeMethodArguments_LONG_STRING(ptr, objectID.id, index.toLong(), boneName)
    TransferContext.callMethod(MethodBindings.setEndBoneNamePtr)
  }

  /**
   * Returns the end bone name.
   */
  public final fun getEndBoneName(index: Int): String {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callMethod(MethodBindings.getEndBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Sets the end bone index.
   */
  public final fun setEndBone(index: Int, bone: Int): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), bone.toLong())
    TransferContext.callPtrMethod(MethodBindings.setEndBonePtr, 0)
  }

  /**
   * Returns the end bone index.
   */
  public final fun getEndBone(index: Int): Int {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getEndBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * If [enabled] is `true`, the end bone is extended from the middle bone as a virtual bone.
   */
  public final fun setUseVirtualEnd(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, index.toLong(), enabled)
    TransferContext.callPtrMethod(MethodBindings.setUseVirtualEndPtr, 0)
  }

  /**
   * Returns `true` if the end bone is extended from the middle bone as a virtual bone.
   */
  public final fun isUsingVirtualEnd(index: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.isUsingVirtualEndPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * If [enabled] is `true`, the end bone is extended to have a tail.
   */
  public final fun setExtendEndBone(index: Int, enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, index.toLong(), enabled)
    TransferContext.callPtrMethod(MethodBindings.setExtendEndBonePtr, 0)
  }

  /**
   * Returns `true` if the end bone is extended to have a tail.
   */
  public final fun isEndBoneExtended(index: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.isEndBoneExtendedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the end bone tail direction when [isEndBoneExtended] is `true`.
   */
  public final fun setEndBoneDirection(index: Int, boneDirection: SkeletonModifier3D.BoneDirection):
      Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, index.toLong(), boneDirection.value)
    TransferContext.callPtrMethod(MethodBindings.setEndBoneDirectionPtr, 0)
  }

  /**
   * Returns the end bone's tail direction when [isEndBoneExtended] is `true`.
   */
  public final fun getEndBoneDirection(index: Int): SkeletonModifier3D.BoneDirection {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getEndBoneDirectionPtr, 2)
    return SkeletonModifier3D.BoneDirection.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the end bone tail length when [isEndBoneExtended] is `true`.
   */
  public final fun setEndBoneLength(index: Int, length: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, index.toLong(), length.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setEndBoneLengthPtr, 0)
  }

  /**
   * Returns the end bone tail length of the bone chain when [isEndBoneExtended] is `true`.
   */
  public final fun getEndBoneLength(index: Int): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, index.toLong())
    TransferContext.callPtrMethod(MethodBindings.getEndBoneLengthPtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the target node that the end bone is trying to reach.
   */
  public final fun setTargetNode(index: Int, targetNode: String) =
      setTargetNode(index, targetNode.asCachedNodePath())

  /**
   * Sets the pole target node that constructs a plane which the joints are all on and the pole is
   * trying to direct.
   */
  public final fun setPoleNode(index: Int, poleNode: String) =
      setPoleNode(index, poleNode.asCachedNodePath())

  public companion object {
    @JvmField
    public val setTargetNodeName: MethodStringName2<TwoBoneIK3D, Unit, Int, NodePath> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, NodePath>("set_target_node")

    @JvmField
    public val getTargetNodeName: MethodStringName1<TwoBoneIK3D, NodePath, Int> =
        MethodStringName1<TwoBoneIK3D, NodePath, Int>("get_target_node")

    @JvmField
    public val setPoleNodeName: MethodStringName2<TwoBoneIK3D, Unit, Int, NodePath> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, NodePath>("set_pole_node")

    @JvmField
    public val getPoleNodeName: MethodStringName1<TwoBoneIK3D, NodePath, Int> =
        MethodStringName1<TwoBoneIK3D, NodePath, Int>("get_pole_node")

    @JvmField
    public val setRootBoneNameName: MethodStringName2<TwoBoneIK3D, Unit, Int, String> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, String>("set_root_bone_name")

    @JvmField
    public val getRootBoneNameName: MethodStringName1<TwoBoneIK3D, String, Int> =
        MethodStringName1<TwoBoneIK3D, String, Int>("get_root_bone_name")

    @JvmField
    public val setRootBoneName: MethodStringName2<TwoBoneIK3D, Unit, Int, Int> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, Int>("set_root_bone")

    @JvmField
    public val getRootBoneName: MethodStringName1<TwoBoneIK3D, Int, Int> =
        MethodStringName1<TwoBoneIK3D, Int, Int>("get_root_bone")

    @JvmField
    public val setMiddleBoneNameName: MethodStringName2<TwoBoneIK3D, Unit, Int, String> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, String>("set_middle_bone_name")

    @JvmField
    public val getMiddleBoneNameName: MethodStringName1<TwoBoneIK3D, String, Int> =
        MethodStringName1<TwoBoneIK3D, String, Int>("get_middle_bone_name")

    @JvmField
    public val setMiddleBoneName: MethodStringName2<TwoBoneIK3D, Unit, Int, Int> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, Int>("set_middle_bone")

    @JvmField
    public val getMiddleBoneName: MethodStringName1<TwoBoneIK3D, Int, Int> =
        MethodStringName1<TwoBoneIK3D, Int, Int>("get_middle_bone")

    @JvmField
    public val setPoleDirectionName:
        MethodStringName2<TwoBoneIK3D, Unit, Int, SkeletonModifier3D.SecondaryDirection> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, SkeletonModifier3D.SecondaryDirection>("set_pole_direction")

    @JvmField
    public val getPoleDirectionName:
        MethodStringName1<TwoBoneIK3D, SkeletonModifier3D.SecondaryDirection, Int> =
        MethodStringName1<TwoBoneIK3D, SkeletonModifier3D.SecondaryDirection, Int>("get_pole_direction")

    @JvmField
    public val setPoleDirectionVectorName: MethodStringName2<TwoBoneIK3D, Unit, Int, Vector3> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, Vector3>("set_pole_direction_vector")

    @JvmField
    public val getPoleDirectionVectorName: MethodStringName1<TwoBoneIK3D, Vector3, Int> =
        MethodStringName1<TwoBoneIK3D, Vector3, Int>("get_pole_direction_vector")

    @JvmField
    public val setEndBoneNameName: MethodStringName2<TwoBoneIK3D, Unit, Int, String> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, String>("set_end_bone_name")

    @JvmField
    public val getEndBoneNameName: MethodStringName1<TwoBoneIK3D, String, Int> =
        MethodStringName1<TwoBoneIK3D, String, Int>("get_end_bone_name")

    @JvmField
    public val setEndBoneName: MethodStringName2<TwoBoneIK3D, Unit, Int, Int> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, Int>("set_end_bone")

    @JvmField
    public val getEndBoneName: MethodStringName1<TwoBoneIK3D, Int, Int> =
        MethodStringName1<TwoBoneIK3D, Int, Int>("get_end_bone")

    @JvmField
    public val setUseVirtualEndName: MethodStringName2<TwoBoneIK3D, Unit, Int, Boolean> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, Boolean>("set_use_virtual_end")

    @JvmField
    public val isUsingVirtualEndName: MethodStringName1<TwoBoneIK3D, Boolean, Int> =
        MethodStringName1<TwoBoneIK3D, Boolean, Int>("is_using_virtual_end")

    @JvmField
    public val setExtendEndBoneName: MethodStringName2<TwoBoneIK3D, Unit, Int, Boolean> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, Boolean>("set_extend_end_bone")

    @JvmField
    public val isEndBoneExtendedName: MethodStringName1<TwoBoneIK3D, Boolean, Int> =
        MethodStringName1<TwoBoneIK3D, Boolean, Int>("is_end_bone_extended")

    @JvmField
    public val setEndBoneDirectionName:
        MethodStringName2<TwoBoneIK3D, Unit, Int, SkeletonModifier3D.BoneDirection> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, SkeletonModifier3D.BoneDirection>("set_end_bone_direction")

    @JvmField
    public val getEndBoneDirectionName:
        MethodStringName1<TwoBoneIK3D, SkeletonModifier3D.BoneDirection, Int> =
        MethodStringName1<TwoBoneIK3D, SkeletonModifier3D.BoneDirection, Int>("get_end_bone_direction")

    @JvmField
    public val setEndBoneLengthName: MethodStringName2<TwoBoneIK3D, Unit, Int, Float> =
        MethodStringName2<TwoBoneIK3D, Unit, Int, Float>("set_end_bone_length")

    @JvmField
    public val getEndBoneLengthName: MethodStringName1<TwoBoneIK3D, Float, Int> =
        MethodStringName1<TwoBoneIK3D, Float, Int>("get_end_bone_length")
  }

  public object MethodBindings {
    internal val setTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_target_node", 2761262315)

    internal val getTargetNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_target_node", 408788394)

    internal val setPoleNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_pole_node", 2761262315)

    internal val getPoleNodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_pole_node", 408788394)

    internal val setRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_root_bone_name", 501894301)

    internal val getRootBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_root_bone_name", 844755477)

    internal val setRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_root_bone", 3937882851)

    internal val getRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_root_bone", 923996154)

    internal val setMiddleBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_middle_bone_name", 501894301)

    internal val getMiddleBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_middle_bone_name", 844755477)

    internal val setMiddleBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_middle_bone", 3937882851)

    internal val getMiddleBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_middle_bone", 923996154)

    internal val setPoleDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_pole_direction", 258741388)

    internal val getPoleDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_pole_direction", 377522128)

    internal val setPoleDirectionVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_pole_direction_vector", 1530502735)

    internal val getPoleDirectionVectorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_pole_direction_vector", 711720468)

    internal val setEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_end_bone_name", 501894301)

    internal val getEndBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_end_bone_name", 844755477)

    internal val setEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_end_bone", 3937882851)

    internal val getEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_end_bone", 923996154)

    internal val setUseVirtualEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_use_virtual_end", 300928843)

    internal val isUsingVirtualEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "is_using_virtual_end", 1116898809)

    internal val setExtendEndBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_extend_end_bone", 300928843)

    internal val isEndBoneExtendedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "is_end_bone_extended", 1116898809)

    internal val setEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_end_bone_direction", 2838484201)

    internal val getEndBoneDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_end_bone_direction", 1843036459)

    internal val setEndBoneLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "set_end_bone_length", 1602489585)

    internal val getEndBoneLengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("TwoBoneIK3D", "get_end_bone_length", 2339986948)
  }
}
