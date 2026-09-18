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
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_LONG
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING_NAME
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node uses hand tracking data from an [XRHandTracker] to pose the skeleton of a hand mesh.
 *
 * Positioning of hands is performed by creating an [XRNode3D] ancestor of the hand mesh driven by
 * the same [XRHandTracker].
 *
 * The hand tracking position-data is scaled by [Skeleton3D.motionScale] when applied to the
 * skeleton, which can be used to adjust the tracked hand to match the scale of the hand model.
 */
@GodotBaseType
public open class XRHandModifier3D : SkeletonModifier3D() {
  /**
   * The name of the [XRHandTracker] registered with [XRServer] to obtain the hand tracking data
   * from.
   */
  public final inline var handTracker: StringName
    @JvmName("handTrackerProperty")
    get() = getHandTracker()
    @JvmName("handTrackerProperty")
    set(`value`) {
      setHandTracker(value)
    }

  /**
   * Specifies the type of updates to perform on the bones.
   */
  public final inline var boneUpdate: BoneUpdate
    @JvmName("boneUpdateProperty")
    get() = getBoneUpdate()
    @JvmName("boneUpdateProperty")
    set(`value`) {
      setBoneUpdate(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(944, scriptPtr)
  }

  public final fun setHandTracker(trackerName: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, trackerName)
    TransferContext.callPtrMethod(MethodBindings.setHandTrackerPtr, 0)
  }

  public final fun getHandTracker(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHandTrackerPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setBoneUpdate(boneUpdate: BoneUpdate): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneUpdate.value)
    TransferContext.callPtrMethod(MethodBindings.setBoneUpdatePtr, 0)
  }

  public final fun getBoneUpdate(): BoneUpdate {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBoneUpdatePtr, 2)
    return BoneUpdate.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setHandTracker(trackerName: String) =
      setHandTracker(trackerName.asCachedStringName())

  public enum class BoneUpdate(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The skeleton's bones are fully updated (both position and rotation) to match the tracked
     * bones.
     */
    FULL(0),
    /**
     * The skeleton's bones are only rotated to align with the tracked bones, preserving bone
     * length.
     */
    ROTATION_ONLY(1),
    /**
     * Represents the size of the [BoneUpdate] enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): BoneUpdate = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setHandTrackerName: MethodStringName1<XRHandModifier3D, Unit, StringName> =
        MethodStringName1<XRHandModifier3D, Unit, StringName>("set_hand_tracker")

    @JvmField
    public val getHandTrackerName: MethodStringName0<XRHandModifier3D, StringName> =
        MethodStringName0<XRHandModifier3D, StringName>("get_hand_tracker")

    @JvmField
    public val setBoneUpdateName: MethodStringName1<XRHandModifier3D, Unit, BoneUpdate> =
        MethodStringName1<XRHandModifier3D, Unit, BoneUpdate>("set_bone_update")

    @JvmField
    public val getBoneUpdateName: MethodStringName0<XRHandModifier3D, BoneUpdate> =
        MethodStringName0<XRHandModifier3D, BoneUpdate>("get_bone_update")
  }

  public object MethodBindings {
    internal val setHandTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandModifier3D", "set_hand_tracker", 3304788590)

    internal val getHandTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandModifier3D", "get_hand_tracker", 2002593661)

    internal val setBoneUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandModifier3D", "set_bone_update", 3635701455)

    internal val getBoneUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandModifier3D", "get_bone_update", 2873665691)
  }
}
