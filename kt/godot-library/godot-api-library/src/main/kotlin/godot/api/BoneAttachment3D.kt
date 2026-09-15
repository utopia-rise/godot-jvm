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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.NodePath
import godot.core.asCachedNodePath
import godot.readReturnValue_BOOL
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import godot.writeMethodArguments_STRING
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node selects a bone in a [Skeleton3D] and attaches to it. This means that the
 * [BoneAttachment3D] node will either dynamically copy or override the 3D transform of the selected
 * bone.
 */
@GodotBaseType
public open class BoneAttachment3D : Node3D() {
  /**
   * The name of the attached bone.
   */
  public final inline var boneName: String
    @JvmName("boneNameProperty")
    get() = getBoneName()
    @JvmName("boneNameProperty")
    set(`value`) {
      setBoneName(value)
    }

  /**
   * The index of the attached bone.
   */
  public final inline var boneIdx: Int
    @JvmName("boneIdxProperty")
    get() = getBoneIdx()
    @JvmName("boneIdxProperty")
    set(`value`) {
      setBoneIdx(value)
    }

  /**
   * Whether the [BoneAttachment3D] node will override the bone pose of the bone it is attached to.
   * When set to `true`, the [BoneAttachment3D] node can change the pose of the bone. When set to
   * `false`, the [BoneAttachment3D] will always be set to the bone's transform.
   *
   * **Note:** This override performs interruptively in the skeleton update process using signals
   * due to the old design. It may cause unintended behavior when used at the same time with
   * [SkeletonModifier3D].
   */
  public final inline var overridePose: Boolean
    @JvmName("overridePoseProperty")
    get() = getOverridePose()
    @JvmName("overridePoseProperty")
    set(`value`) {
      setOverridePose(value)
    }

  /**
   * Whether the [BoneAttachment3D] node will use an external [Skeleton3D] node rather than
   * attempting to use its parent node as the [Skeleton3D]. When set to `true`, the [BoneAttachment3D]
   * node will use the external [Skeleton3D] node set in [externalSkeleton].
   */
  public final inline var useExternalSkeleton: Boolean
    @JvmName("useExternalSkeletonProperty")
    get() = getUseExternalSkeleton()
    @JvmName("useExternalSkeletonProperty")
    set(`value`) {
      setUseExternalSkeleton(value)
    }

  /**
   * The [NodePath] to the external [Skeleton3D] node.
   */
  public final inline var externalSkeleton: NodePath
    @JvmName("externalSkeletonProperty")
    get() = getExternalSkeleton()
    @JvmName("externalSkeletonProperty")
    set(`value`) {
      setExternalSkeleton(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(110, scriptPtr)
  }

  /**
   * Returns the parent or external [Skeleton3D] node if it exists, otherwise returns `null`.
   */
  public final fun getSkeleton(): Skeleton3D? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonPtr)
    return (TransferContext.readReturnValue_OBJECT() as Skeleton3D?)
  }

  public final fun setBoneName(boneName: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, boneName)
    TransferContext.callMethod(MethodBindings.setBoneNamePtr)
  }

  public final fun getBoneName(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneNamePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setBoneIdx(boneIdx: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneIdx.toLong())
    TransferContext.callMethod(MethodBindings.setBoneIdxPtr)
  }

  public final fun getBoneIdx(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneIdxPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * A function that is called automatically when the [Skeleton3D] is updated. This function is
   * where the [BoneAttachment3D] node updates its position so it is correctly bound when it is *not*
   * set to override the bone pose.
   */
  public final fun onSkeletonUpdate(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.onSkeletonUpdatePtr)
  }

  public final fun setOverridePose(overridePose: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, overridePose)
    TransferContext.callMethod(MethodBindings.setOverridePosePtr)
  }

  public final fun getOverridePose(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOverridePosePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setUseExternalSkeleton(useExternalSkeleton: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, useExternalSkeleton)
    TransferContext.callMethod(MethodBindings.setUseExternalSkeletonPtr)
  }

  public final fun getUseExternalSkeleton(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getUseExternalSkeletonPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setExternalSkeleton(externalSkeleton: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, externalSkeleton)
    TransferContext.callMethod(MethodBindings.setExternalSkeletonPtr)
  }

  public final fun getExternalSkeleton(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getExternalSkeletonPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setExternalSkeleton(externalSkeleton: String) =
      setExternalSkeleton(externalSkeleton.asCachedNodePath())

  public companion object {
    @JvmField
    public val getSkeletonName: MethodStringName0<BoneAttachment3D, Skeleton3D?> =
        MethodStringName0<BoneAttachment3D, Skeleton3D?>("get_skeleton")

    @JvmField
    public val setBoneNameName: MethodStringName1<BoneAttachment3D, Unit, String> =
        MethodStringName1<BoneAttachment3D, Unit, String>("set_bone_name")

    @JvmField
    public val getBoneNameName: MethodStringName0<BoneAttachment3D, String> =
        MethodStringName0<BoneAttachment3D, String>("get_bone_name")

    @JvmField
    public val setBoneIdxName: MethodStringName1<BoneAttachment3D, Unit, Int> =
        MethodStringName1<BoneAttachment3D, Unit, Int>("set_bone_idx")

    @JvmField
    public val getBoneIdxName: MethodStringName0<BoneAttachment3D, Int> =
        MethodStringName0<BoneAttachment3D, Int>("get_bone_idx")

    @JvmField
    public val onSkeletonUpdateName: MethodStringName0<BoneAttachment3D, Unit> =
        MethodStringName0<BoneAttachment3D, Unit>("on_skeleton_update")

    @JvmField
    public val setOverridePoseName: MethodStringName1<BoneAttachment3D, Unit, Boolean> =
        MethodStringName1<BoneAttachment3D, Unit, Boolean>("set_override_pose")

    @JvmField
    public val getOverridePoseName: MethodStringName0<BoneAttachment3D, Boolean> =
        MethodStringName0<BoneAttachment3D, Boolean>("get_override_pose")

    @JvmField
    public val setUseExternalSkeletonName: MethodStringName1<BoneAttachment3D, Unit, Boolean> =
        MethodStringName1<BoneAttachment3D, Unit, Boolean>("set_use_external_skeleton")

    @JvmField
    public val getUseExternalSkeletonName: MethodStringName0<BoneAttachment3D, Boolean> =
        MethodStringName0<BoneAttachment3D, Boolean>("get_use_external_skeleton")

    @JvmField
    public val setExternalSkeletonName: MethodStringName1<BoneAttachment3D, Unit, NodePath> =
        MethodStringName1<BoneAttachment3D, Unit, NodePath>("set_external_skeleton")

    @JvmField
    public val getExternalSkeletonName: MethodStringName0<BoneAttachment3D, NodePath> =
        MethodStringName0<BoneAttachment3D, NodePath>("get_external_skeleton")
  }

  public object MethodBindings {
    internal val getSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "get_skeleton", 1814733083)

    internal val setBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "set_bone_name", 83702148)

    internal val getBoneNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "get_bone_name", 201670096)

    internal val setBoneIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "set_bone_idx", 1286410249)

    internal val getBoneIdxPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "get_bone_idx", 3905245786)

    internal val onSkeletonUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "on_skeleton_update", 3218959716)

    internal val setOverridePosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "set_override_pose", 2586408642)

    internal val getOverridePosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "get_override_pose", 36873697)

    internal val setUseExternalSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "set_use_external_skeleton", 2586408642)

    internal val getUseExternalSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "get_use_external_skeleton", 36873697)

    internal val setExternalSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "set_external_skeleton", 1348162250)

    internal val getExternalSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("BoneAttachment3D", "get_external_skeleton", 4075236667)
  }
}
