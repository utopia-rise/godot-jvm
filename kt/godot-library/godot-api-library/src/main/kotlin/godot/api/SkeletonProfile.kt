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
import godot.core.Signal0
import godot.core.StringName
import godot.core.Transform3D
import godot.core.Vector2
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING_NAME
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_BOOL
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_OBJECT
import godot.writeMethodArguments_LONG_STRING_NAME
import godot.writeMethodArguments_LONG_TRANSFORM3D
import godot.writeMethodArguments_LONG_VECTOR2
import godot.writeMethodArguments_STRING_NAME
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This resource is used in [EditorScenePostImport]. Some parameters are referring to bones in
 * [Skeleton3D], [Skin], [Animation], and some other nodes are rewritten based on the parameters of
 * [SkeletonProfile].
 *
 * **Note:** These parameters need to be set only when creating a custom profile. In
 * [SkeletonProfileHumanoid], they are defined internally as read-only values.
 */
@GodotBaseType
public open class SkeletonProfile : Resource() {
  /**
   * This signal is emitted when change the value in profile. This is used to update key name in the
   * [BoneMap] and to redraw the [BoneMap] editor.
   *
   * **Note:** This signal is not connected directly to editor to simplify the reference, instead it
   * is passed on to editor through the [BoneMap].
   */
  public val profileUpdated: Signal0 by Signal0

  /**
   * A bone name that will be used as the root bone in [AnimationTree]. This should be the bone of
   * the parent of hips that exists at the world origin.
   */
  public final inline var rootBone: StringName
    @JvmName("rootBoneProperty")
    get() = getRootBone()
    @JvmName("rootBoneProperty")
    set(`value`) {
      setRootBone(value)
    }

  /**
   * A bone name which will use model's height as the coefficient for normalization. For example,
   * [SkeletonProfileHumanoid] defines it as `Hips`.
   */
  public final inline var scaleBaseBone: StringName
    @JvmName("scaleBaseBoneProperty")
    get() = getScaleBaseBone()
    @JvmName("scaleBaseBoneProperty")
    set(`value`) {
      setScaleBaseBone(value)
    }

  /**
   * The amount of groups of bones in retargeting section's [BoneMap] editor. For example,
   * [SkeletonProfileHumanoid] has 4 groups.
   *
   * This property exists to separate the bone list into several sections in the editor.
   */
  public final inline var groupSize: Int
    @JvmName("groupSizeProperty")
    get() = getGroupSize()
    @JvmName("groupSizeProperty")
    set(`value`) {
      setGroupSize(value)
    }

  /**
   * The amount of bones in retargeting section's [BoneMap] editor. For example,
   * [SkeletonProfileHumanoid] has 56 bones.
   *
   * The size of elements in [BoneMap] updates when changing this property in it's assigned
   * [SkeletonProfile].
   */
  public final inline var boneSize: Int
    @JvmName("boneSizeProperty")
    get() = getBoneSize()
    @JvmName("boneSizeProperty")
    set(`value`) {
      setBoneSize(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(677, scriptPtr)
  }

  public final fun setRootBone(boneName: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, boneName)
    TransferContext.callPtrMethod(MethodBindings.setRootBonePtr, 0)
  }

  public final fun getRootBone(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRootBonePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setScaleBaseBone(boneName: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, boneName)
    TransferContext.callPtrMethod(MethodBindings.setScaleBaseBonePtr, 0)
  }

  public final fun getScaleBaseBone(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScaleBaseBonePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setGroupSize(size: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, size.toLong())
    TransferContext.callPtrMethod(MethodBindings.setGroupSizePtr, 0)
  }

  public final fun getGroupSize(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGroupSizePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the name of the group at [groupIdx] that will be the drawing group in the [BoneMap]
   * editor.
   */
  public final fun getGroupName(groupIdx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, groupIdx.toLong())
    TransferContext.callMethod(MethodBindings.getGroupNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Sets the name of the group at [groupIdx] that will be the drawing group in the [BoneMap]
   * editor.
   */
  public final fun setGroupName(groupIdx: Int, groupName: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, groupIdx.toLong(), groupName)
    TransferContext.callPtrMethod(MethodBindings.setGroupNamePtr, 0)
  }

  /**
   * Returns the texture of the group at [groupIdx] that will be the drawing group background image
   * in the [BoneMap] editor.
   */
  public final fun getTexture(groupIdx: Int): Texture2D? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, groupIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTexturePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as Texture2D?)
  }

  /**
   * Sets the texture of the group at [groupIdx] that will be the drawing group background image in
   * the [BoneMap] editor.
   */
  public final fun setTexture(groupIdx: Int, texture: Texture2D?): Unit {
    TransferContext.writeMethodArguments_LONG_OBJECT(ptr, objectID.id, groupIdx.toLong(), texture)
    TransferContext.callPtrMethod(MethodBindings.setTexturePtr, 0)
  }

  public final fun setBoneSize(size: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, size.toLong())
    TransferContext.callPtrMethod(MethodBindings.setBoneSizePtr, 0)
  }

  public final fun getBoneSize(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBoneSizePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the bone index that matches [boneName] as its name.
   */
  public final fun findBone(boneName: StringName): Int {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, boneName)
    TransferContext.callPtrMethod(MethodBindings.findBonePtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the name of the bone at [boneIdx] that will be the key name in the [BoneMap].
   *
   * In the retargeting process, the returned bone name is the bone name of the target skeleton.
   */
  public final fun getBoneName(boneIdx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Sets the name of the bone at [boneIdx] that will be the key name in the [BoneMap].
   *
   * In the retargeting process, the setting bone name is the bone name of the target skeleton.
   */
  public final fun setBoneName(boneIdx: Int, boneName: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, boneIdx.toLong(), boneName)
    TransferContext.callPtrMethod(MethodBindings.setBoneNamePtr, 0)
  }

  /**
   * Returns the name of the bone which is the parent to the bone at [boneIdx]. The result is empty
   * if the bone has no parent.
   */
  public final fun getBoneParent(boneIdx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneParentPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Sets the bone with name [boneParent] as the parent of the bone at [boneIdx]. If an empty string
   * is passed, then the bone has no parent.
   */
  public final fun setBoneParent(boneIdx: Int, boneParent: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, boneIdx.toLong(), boneParent)
    TransferContext.callPtrMethod(MethodBindings.setBoneParentPtr, 0)
  }

  /**
   * Returns the tail direction of the bone at [boneIdx].
   */
  public final fun getTailDirection(boneIdx: Int): TailDirection {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getTailDirectionPtr, 2)
    return TailDirection.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the tail direction of the bone at [boneIdx].
   *
   * **Note:** This only specifies the method of calculation. The actual coordinates required should
   * be stored in an external skeleton, so the calculation itself needs to be done externally.
   */
  public final fun setTailDirection(boneIdx: Int, tailDirection: TailDirection): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, boneIdx.toLong(), tailDirection.value)
    TransferContext.callPtrMethod(MethodBindings.setTailDirectionPtr, 0)
  }

  /**
   * Returns the name of the bone which is the tail of the bone at [boneIdx].
   */
  public final fun getBoneTail(boneIdx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getBoneTailPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Sets the bone with name [boneTail] as the tail of the bone at [boneIdx].
   */
  public final fun setBoneTail(boneIdx: Int, boneTail: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, boneIdx.toLong(), boneTail)
    TransferContext.callPtrMethod(MethodBindings.setBoneTailPtr, 0)
  }

  /**
   * Returns the reference pose transform for bone [boneIdx].
   */
  public final fun getReferencePose(boneIdx: Int): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getReferencePosePtr, 18)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Sets the reference pose transform for bone [boneIdx].
   */
  public final fun setReferencePose(boneIdx: Int, boneName: Transform3D): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, boneIdx.toLong(), boneName)
    TransferContext.callPtrMethod(MethodBindings.setReferencePosePtr, 0)
  }

  /**
   * Returns the offset of the bone at [boneIdx] that will be the button position in the [BoneMap]
   * editor.
   *
   * This is the offset with origin at the top left corner of the square.
   */
  public final fun getHandleOffset(boneIdx: Int): Vector2 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.getHandleOffsetPtr, 5)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Sets the offset of the bone at [boneIdx] that will be the button position in the [BoneMap]
   * editor.
   *
   * This is the offset with origin at the top left corner of the square.
   */
  public final fun setHandleOffset(boneIdx: Int, handleOffset: Vector2): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR2(ptr, objectID.id, boneIdx.toLong(), handleOffset)
    TransferContext.callPtrMethod(MethodBindings.setHandleOffsetPtr, 0)
  }

  /**
   * Returns the group of the bone at [boneIdx].
   */
  public final fun getGroup(boneIdx: Int): StringName {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.getGroupPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Sets the group of the bone at [boneIdx].
   */
  public final fun setGroup(boneIdx: Int, group: StringName): Unit {
    TransferContext.writeMethodArguments_LONG_STRING_NAME(ptr, objectID.id, boneIdx.toLong(), group)
    TransferContext.callPtrMethod(MethodBindings.setGroupPtr, 0)
  }

  /**
   * Returns whether the bone at [boneIdx] is required for retargeting.
   *
   * This value is used by the bone map editor. If this method returns `true`, and no bone is
   * assigned, the handle color will be red on the bone map editor.
   */
  public final fun isRequired(boneIdx: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callPtrMethod(MethodBindings.isRequiredPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the required status for bone [boneIdx] to [required].
   */
  public final fun setRequired(boneIdx: Int, required: Boolean): Unit {
    TransferContext.writeMethodArguments_LONG_BOOL(ptr, objectID.id, boneIdx.toLong(), required)
    TransferContext.callPtrMethod(MethodBindings.setRequiredPtr, 0)
  }

  public final fun setRootBone(boneName: String) = setRootBone(boneName.asCachedStringName())

  public final fun setScaleBaseBone(boneName: String) =
      setScaleBaseBone(boneName.asCachedStringName())

  /**
   * Sets the name of the group at [groupIdx] that will be the drawing group in the [BoneMap]
   * editor.
   */
  public final fun setGroupName(groupIdx: Int, groupName: String) =
      setGroupName(groupIdx, groupName.asCachedStringName())

  /**
   * Returns the bone index that matches [boneName] as its name.
   */
  public final fun findBone(boneName: String): Int = findBone(boneName.asCachedStringName())

  /**
   * Sets the name of the bone at [boneIdx] that will be the key name in the [BoneMap].
   *
   * In the retargeting process, the setting bone name is the bone name of the target skeleton.
   */
  public final fun setBoneName(boneIdx: Int, boneName: String) =
      setBoneName(boneIdx, boneName.asCachedStringName())

  /**
   * Sets the bone with name [boneParent] as the parent of the bone at [boneIdx]. If an empty string
   * is passed, then the bone has no parent.
   */
  public final fun setBoneParent(boneIdx: Int, boneParent: String) =
      setBoneParent(boneIdx, boneParent.asCachedStringName())

  /**
   * Sets the bone with name [boneTail] as the tail of the bone at [boneIdx].
   */
  public final fun setBoneTail(boneIdx: Int, boneTail: String) =
      setBoneTail(boneIdx, boneTail.asCachedStringName())

  /**
   * Sets the group of the bone at [boneIdx].
   */
  public final fun setGroup(boneIdx: Int, group: String) =
      setGroup(boneIdx, group.asCachedStringName())

  public enum class TailDirection(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Direction to the average coordinates of bone children.
     */
    AVERAGE_CHILDREN(0),
    /**
     * Direction to the coordinates of specified bone child.
     */
    SPECIFIC_CHILD(1),
    /**
     * Direction is not calculated.
     */
    END(2),
    ;

    public companion object {
      public fun from(`value`: Long): TailDirection = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setRootBoneName: MethodStringName1<SkeletonProfile, Unit, StringName> =
        MethodStringName1<SkeletonProfile, Unit, StringName>("set_root_bone")

    @JvmField
    public val getRootBoneName: MethodStringName0<SkeletonProfile, StringName> =
        MethodStringName0<SkeletonProfile, StringName>("get_root_bone")

    @JvmField
    public val setScaleBaseBoneName: MethodStringName1<SkeletonProfile, Unit, StringName> =
        MethodStringName1<SkeletonProfile, Unit, StringName>("set_scale_base_bone")

    @JvmField
    public val getScaleBaseBoneName: MethodStringName0<SkeletonProfile, StringName> =
        MethodStringName0<SkeletonProfile, StringName>("get_scale_base_bone")

    @JvmField
    public val setGroupSizeName: MethodStringName1<SkeletonProfile, Unit, Int> =
        MethodStringName1<SkeletonProfile, Unit, Int>("set_group_size")

    @JvmField
    public val getGroupSizeName: MethodStringName0<SkeletonProfile, Int> =
        MethodStringName0<SkeletonProfile, Int>("get_group_size")

    @JvmField
    public val getGroupNameName: MethodStringName1<SkeletonProfile, StringName, Int> =
        MethodStringName1<SkeletonProfile, StringName, Int>("get_group_name")

    @JvmField
    public val setGroupNameName: MethodStringName2<SkeletonProfile, Unit, Int, StringName> =
        MethodStringName2<SkeletonProfile, Unit, Int, StringName>("set_group_name")

    @JvmField
    public val getTextureName: MethodStringName1<SkeletonProfile, Texture2D?, Int> =
        MethodStringName1<SkeletonProfile, Texture2D?, Int>("get_texture")

    @JvmField
    public val setTextureName: MethodStringName2<SkeletonProfile, Unit, Int, Texture2D?> =
        MethodStringName2<SkeletonProfile, Unit, Int, Texture2D?>("set_texture")

    @JvmField
    public val setBoneSizeName: MethodStringName1<SkeletonProfile, Unit, Int> =
        MethodStringName1<SkeletonProfile, Unit, Int>("set_bone_size")

    @JvmField
    public val getBoneSizeName: MethodStringName0<SkeletonProfile, Int> =
        MethodStringName0<SkeletonProfile, Int>("get_bone_size")

    @JvmField
    public val findBoneName: MethodStringName1<SkeletonProfile, Int, StringName> =
        MethodStringName1<SkeletonProfile, Int, StringName>("find_bone")

    @JvmField
    public val getBoneNameName: MethodStringName1<SkeletonProfile, StringName, Int> =
        MethodStringName1<SkeletonProfile, StringName, Int>("get_bone_name")

    @JvmField
    public val setBoneNameName: MethodStringName2<SkeletonProfile, Unit, Int, StringName> =
        MethodStringName2<SkeletonProfile, Unit, Int, StringName>("set_bone_name")

    @JvmField
    public val getBoneParentName: MethodStringName1<SkeletonProfile, StringName, Int> =
        MethodStringName1<SkeletonProfile, StringName, Int>("get_bone_parent")

    @JvmField
    public val setBoneParentName: MethodStringName2<SkeletonProfile, Unit, Int, StringName> =
        MethodStringName2<SkeletonProfile, Unit, Int, StringName>("set_bone_parent")

    @JvmField
    public val getTailDirectionName: MethodStringName1<SkeletonProfile, TailDirection, Int> =
        MethodStringName1<SkeletonProfile, TailDirection, Int>("get_tail_direction")

    @JvmField
    public val setTailDirectionName: MethodStringName2<SkeletonProfile, Unit, Int, TailDirection> =
        MethodStringName2<SkeletonProfile, Unit, Int, TailDirection>("set_tail_direction")

    @JvmField
    public val getBoneTailName: MethodStringName1<SkeletonProfile, StringName, Int> =
        MethodStringName1<SkeletonProfile, StringName, Int>("get_bone_tail")

    @JvmField
    public val setBoneTailName: MethodStringName2<SkeletonProfile, Unit, Int, StringName> =
        MethodStringName2<SkeletonProfile, Unit, Int, StringName>("set_bone_tail")

    @JvmField
    public val getReferencePoseName: MethodStringName1<SkeletonProfile, Transform3D, Int> =
        MethodStringName1<SkeletonProfile, Transform3D, Int>("get_reference_pose")

    @JvmField
    public val setReferencePoseName: MethodStringName2<SkeletonProfile, Unit, Int, Transform3D> =
        MethodStringName2<SkeletonProfile, Unit, Int, Transform3D>("set_reference_pose")

    @JvmField
    public val getHandleOffsetName: MethodStringName1<SkeletonProfile, Vector2, Int> =
        MethodStringName1<SkeletonProfile, Vector2, Int>("get_handle_offset")

    @JvmField
    public val setHandleOffsetName: MethodStringName2<SkeletonProfile, Unit, Int, Vector2> =
        MethodStringName2<SkeletonProfile, Unit, Int, Vector2>("set_handle_offset")

    @JvmField
    public val getGroupName: MethodStringName1<SkeletonProfile, StringName, Int> =
        MethodStringName1<SkeletonProfile, StringName, Int>("get_group")

    @JvmField
    public val setGroupName: MethodStringName2<SkeletonProfile, Unit, Int, StringName> =
        MethodStringName2<SkeletonProfile, Unit, Int, StringName>("set_group")

    @JvmField
    public val isRequiredName: MethodStringName1<SkeletonProfile, Boolean, Int> =
        MethodStringName1<SkeletonProfile, Boolean, Int>("is_required")

    @JvmField
    public val setRequiredName: MethodStringName2<SkeletonProfile, Unit, Int, Boolean> =
        MethodStringName2<SkeletonProfile, Unit, Int, Boolean>("set_required")
  }

  public object MethodBindings {
    internal val setRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_root_bone", 3304788590)

    internal val getRootBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_root_bone", 2737447660)

    internal val setScaleBaseBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_scale_base_bone", 3304788590)

    internal val getScaleBaseBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_scale_base_bone", 2737447660)

    internal val setGroupSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_group_size", 1286410249)

    internal val getGroupSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_group_size", 2455072627)

    internal val getGroupNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_group_name", 659327637)

    internal val setGroupNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_group_name", 3780747571)

    internal val getTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_texture", 3536238170)

    internal val setTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_texture", 666127730)

    internal val setBoneSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_bone_size", 1286410249)

    internal val getBoneSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_bone_size", 2455072627)

    internal val findBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "find_bone", 2458036349)

    internal val getBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_bone_name", 659327637)

    internal val setBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_bone_name", 3780747571)

    internal val getBoneParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_bone_parent", 659327637)

    internal val setBoneParentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_bone_parent", 3780747571)

    internal val getTailDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_tail_direction", 2675997574)

    internal val setTailDirectionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_tail_direction", 1231951015)

    internal val getBoneTailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_bone_tail", 659327637)

    internal val setBoneTailPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_bone_tail", 3780747571)

    internal val getReferencePosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_reference_pose", 1965739696)

    internal val setReferencePosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_reference_pose", 3616898986)

    internal val getHandleOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_handle_offset", 2299179447)

    internal val setHandleOffsetPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_handle_offset", 163021252)

    internal val getGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "get_group", 659327637)

    internal val setGroupPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_group", 3780747571)

    internal val isRequiredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "is_required", 1116898809)

    internal val setRequiredPtr: VoidPtr =
        TypeManager.getMethodBindPtr("SkeletonProfile", "set_required", 300928843)
  }
}
