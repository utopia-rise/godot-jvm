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

public infix fun Long.or(other: XRBodyModifier3D.BodyUpdate): Long = this.or(other.flag)

public infix fun Long.xor(other: XRBodyModifier3D.BodyUpdate): Long = this.xor(other.flag)

public infix fun Long.and(other: XRBodyModifier3D.BodyUpdate): Long = this.and(other.flag)

/**
 * This node uses body tracking data from an [XRBodyTracker] to pose the skeleton of a body mesh.
 *
 * Positioning of the body is performed by creating an [XRNode3D] ancestor of the body mesh driven
 * by the same [XRBodyTracker].
 *
 * The body tracking position-data is scaled by [Skeleton3D.motionScale] when applied to the
 * skeleton, which can be used to adjust the tracked body to match the scale of the body model.
 */
@GodotBaseType
public open class XRBodyModifier3D : SkeletonModifier3D() {
  /**
   * The name of the [XRBodyTracker] registered with [XRServer] to obtain the body tracking data
   * from.
   */
  public final inline var bodyTracker: StringName
    @JvmName("bodyTrackerProperty")
    get() = getBodyTracker()
    @JvmName("bodyTrackerProperty")
    set(`value`) {
      setBodyTracker(value)
    }

  /**
   * Specifies the body parts to update.
   */
  public final inline var bodyUpdate: BodyUpdate
    @JvmName("bodyUpdateProperty")
    get() = getBodyUpdate()
    @JvmName("bodyUpdateProperty")
    set(`value`) {
      setBodyUpdate(value)
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
    createNativeObject(937, scriptPtr)
  }

  public final fun setBodyTracker(trackerName: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, trackerName)
    TransferContext.callPtrMethod(MethodBindings.setBodyTrackerPtr, 0)
  }

  public final fun getBodyTracker(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBodyTrackerPtr, 21)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setBodyUpdate(bodyUpdate: BodyUpdate): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, bodyUpdate.flag)
    TransferContext.callPtrMethod(MethodBindings.setBodyUpdatePtr, 0)
  }

  public final fun getBodyUpdate(): BodyUpdate {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getBodyUpdatePtr, 2)
    return BodyUpdate(TransferContext.readReturnValue_LONG())
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

  public final fun setBodyTracker(trackerName: String) =
      setBodyTracker(trackerName.asCachedStringName())

  public class BodyUpdate(
    flag: Long,
  ) : BitFieldBase<BodyUpdate>(flag) {
    protected override fun wrap(flag: Long): BodyUpdate = BodyUpdate(flag)

    public companion object {
      /**
       * The skeleton's upper body joints are updated.
       */
      @JvmField
      public val UPPER_BODY: BodyUpdate = BodyUpdate(1)

      /**
       * The skeleton's lower body joints are updated.
       */
      @JvmField
      public val LOWER_BODY: BodyUpdate = BodyUpdate(2)

      /**
       * The skeleton's hand joints are updated.
       */
      @JvmField
      public val HANDS: BodyUpdate = BodyUpdate(4)
    }
  }

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
    public val setBodyTrackerName: MethodStringName1<XRBodyModifier3D, Unit, StringName> =
        MethodStringName1<XRBodyModifier3D, Unit, StringName>("set_body_tracker")

    @JvmField
    public val getBodyTrackerName: MethodStringName0<XRBodyModifier3D, StringName> =
        MethodStringName0<XRBodyModifier3D, StringName>("get_body_tracker")

    @JvmField
    public val setBodyUpdateName: MethodStringName1<XRBodyModifier3D, Unit, BodyUpdate> =
        MethodStringName1<XRBodyModifier3D, Unit, BodyUpdate>("set_body_update")

    @JvmField
    public val getBodyUpdateName: MethodStringName0<XRBodyModifier3D, BodyUpdate> =
        MethodStringName0<XRBodyModifier3D, BodyUpdate>("get_body_update")

    @JvmField
    public val setBoneUpdateName: MethodStringName1<XRBodyModifier3D, Unit, BoneUpdate> =
        MethodStringName1<XRBodyModifier3D, Unit, BoneUpdate>("set_bone_update")

    @JvmField
    public val getBoneUpdateName: MethodStringName0<XRBodyModifier3D, BoneUpdate> =
        MethodStringName0<XRBodyModifier3D, BoneUpdate>("get_bone_update")
  }

  public object MethodBindings {
    internal val setBodyTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyModifier3D", "set_body_tracker", 3304788590)

    internal val getBodyTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyModifier3D", "get_body_tracker", 2002593661)

    internal val setBodyUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyModifier3D", "set_body_update", 2211199417)

    internal val getBodyUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyModifier3D", "get_body_update", 2642335328)

    internal val setBoneUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyModifier3D", "set_bone_update", 3356796943)

    internal val getBoneUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyModifier3D", "get_bone_update", 1309305964)
  }
}
