// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_OBJECT_REF
import godot.callPtrMethod0_ret_RID
import godot.callPtrMethod_DOUBLE_LONG
import godot.callPtrMethod_LONG_TRANSFORM2D_DOUBLE_BOOL
import godot.callPtrMethod_LONG_ret_OBJECT
import godot.callPtrMethod_LONG_ret_TRANSFORM2D
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.RID
import godot.core.Signal0
import godot.core.Transform2D
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [Skeleton2D] parents a hierarchy of [Bone2D] nodes. It holds a reference to each [Bone2D]'s rest
 * pose and acts as a single point of access to its bones.
 *
 * To set up different types of inverse kinematics for the given Skeleton2D, a
 * [SkeletonModificationStack2D] should be created. The inverse kinematics be applied by increasing
 * [SkeletonModificationStack2D.modificationCount] and creating the desired number of modifications.
 */
@GodotBaseType
public open class Skeleton2D : Node2D() {
  /**
   * Emitted when the [Bone2D] setup attached to this skeletons changes. This is primarily used
   * internally within the skeleton.
   */
  public val boneSetupChanged: Signal0 by Signal0

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(664, scriptPtr)
  }

  /**
   * Returns the number of [Bone2D] nodes in the node hierarchy parented by Skeleton2D.
   */
  public final fun getBoneCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBoneCountPtr).toInt()

  /**
   * Returns a [Bone2D] from the node hierarchy parented by Skeleton2D. The object to return is
   * identified by the parameter [idx]. Bones are indexed by descending the node hierarchy from top to
   * bottom, adding the children of each branch before moving to the next sibling.
   */
  public final fun getBone(idx: Int): Bone2D? =
      (TransferContext.callPtrMethod_LONG_ret_OBJECT(ptr, objectID.id, MethodBindings.getBonePtr, idx.toLong()) as Bone2D?)

  /**
   * Returns the [RID] of a Skeleton2D instance.
   */
  public final fun getSkeleton(): RID =
      TransferContext.callPtrMethod0_ret_RID(ptr, objectID.id, MethodBindings.getSkeletonPtr)

  /**
   * Sets the [SkeletonModificationStack2D] attached to this skeleton.
   */
  public final fun setModificationStack(modificationStack: SkeletonModificationStack2D?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setModificationStackPtr, modificationStack)
  }

  /**
   * Returns the [SkeletonModificationStack2D] attached to this skeleton, if one exists.
   */
  public final fun getModificationStack(): SkeletonModificationStack2D? =
      (TransferContext.callPtrMethod0_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getModificationStackPtr) as SkeletonModificationStack2D?)

  /**
   * Executes all the modifications on the [SkeletonModificationStack2D], if the Skeleton2D has one
   * assigned.
   */
  public final fun executeModifications(delta: Float, executionMode: Int): Unit {
    TransferContext.callPtrMethod_DOUBLE_LONG(ptr, objectID.id, MethodBindings.executeModificationsPtr, delta.toDouble(), executionMode.toLong())
  }

  /**
   * Sets the local pose transform, [overridePose], for the bone at [boneIdx].
   *
   * [strength] is the interpolation strength that will be used when applying the pose, and
   * [persistent] determines if the applied pose will remain.
   *
   * **Note:** The pose transform needs to be a local transform relative to the [Bone2D] node at
   * [boneIdx]!
   */
  public final fun setBoneLocalPoseOverride(
    boneIdx: Int,
    overridePose: Transform2D,
    strength: Float,
    persistent: Boolean,
  ): Unit {
    TransferContext.callPtrMethod_LONG_TRANSFORM2D_DOUBLE_BOOL(ptr, objectID.id, MethodBindings.setBoneLocalPoseOverridePtr, boneIdx.toLong(), overridePose, strength.toDouble(), persistent)
  }

  /**
   * Returns the local pose override transform for [boneIdx].
   */
  public final fun getBoneLocalPoseOverride(boneIdx: Int): Transform2D =
      TransferContext.callPtrMethod_LONG_ret_TRANSFORM2D(ptr, objectID.id, MethodBindings.getBoneLocalPoseOverridePtr, boneIdx.toLong())

  public companion object {
    @JvmField
    public val getBoneCountName: MethodStringName0<Skeleton2D, Int> =
        MethodStringName0<Skeleton2D, Int>("get_bone_count")

    @JvmField
    public val getBoneName: MethodStringName1<Skeleton2D, Bone2D?, Int> =
        MethodStringName1<Skeleton2D, Bone2D?, Int>("get_bone")

    @JvmField
    public val getSkeletonName: MethodStringName0<Skeleton2D, RID> =
        MethodStringName0<Skeleton2D, RID>("get_skeleton")

    @JvmField
    public val setModificationStackName:
        MethodStringName1<Skeleton2D, Unit, SkeletonModificationStack2D?> =
        MethodStringName1<Skeleton2D, Unit, SkeletonModificationStack2D?>("set_modification_stack")

    @JvmField
    public val getModificationStackName: MethodStringName0<Skeleton2D, SkeletonModificationStack2D?>
        = MethodStringName0<Skeleton2D, SkeletonModificationStack2D?>("get_modification_stack")

    @JvmField
    public val executeModificationsName: MethodStringName2<Skeleton2D, Unit, Float, Int> =
        MethodStringName2<Skeleton2D, Unit, Float, Int>("execute_modifications")

    @JvmField
    public val setBoneLocalPoseOverrideName:
        MethodStringName4<Skeleton2D, Unit, Int, Transform2D, Float, Boolean> =
        MethodStringName4<Skeleton2D, Unit, Int, Transform2D, Float, Boolean>("set_bone_local_pose_override")

    @JvmField
    public val getBoneLocalPoseOverrideName: MethodStringName1<Skeleton2D, Transform2D, Int> =
        MethodStringName1<Skeleton2D, Transform2D, Int>("get_bone_local_pose_override")
  }

  public object MethodBindings {
    internal val getBoneCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "get_bone_count", 3905245786)

    internal val getBonePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "get_bone", 2556267111)

    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "get_skeleton", 2944877500)

    internal val setModificationStackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "set_modification_stack", 3907307132)

    internal val getModificationStackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "get_modification_stack", 2107508396)

    internal val executeModificationsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "execute_modifications", 1005356550)

    internal val setBoneLocalPoseOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "set_bone_local_pose_override", 555457532)

    internal val getBoneLocalPoseOverridePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Skeleton2D", "get_bone_local_pose_override", 2995540667)
  }
}
