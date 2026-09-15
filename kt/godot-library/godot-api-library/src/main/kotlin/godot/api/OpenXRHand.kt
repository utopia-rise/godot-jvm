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
import godot.core.NodePath
import godot.core.asCachedNodePath
import godot.readReturnValue_LONG
import godot.readReturnValue_NODE_PATH
import godot.writeMethodArguments0
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_NODE_PATH
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node enables OpenXR's hand tracking functionality. The node should be a child node of an
 * [XROrigin3D] node, tracking will update its position to the player's tracked hand Palm joint
 * location (the center of the middle finger's metacarpal bone). This node also updates the skeleton of
 * a properly skinned hand or avatar model.
 *
 * If the skeleton is a hand (one of the hand bones is the root node of the skeleton), then the
 * skeleton will be placed relative to the hand palm location and the hand mesh and skeleton should be
 * children of the OpenXRHand node.
 *
 * If the hand bones are part of a full skeleton, then the root of the hand will keep its location
 * with the assumption that IK is used to position the hand and arm.
 *
 * By default the skeleton hand bones are repositioned to match the size of the tracked hand. To
 * preserve the modeled bone sizes change [boneUpdate] to apply rotation only.
 */
@GodotBaseType
public open class OpenXRHand : Node3D() {
  /**
   * Specifies whether this node tracks the left or right hand of the player.
   */
  public final inline var hand: Hands
    @JvmName("handProperty")
    get() = getHand()
    @JvmName("handProperty")
    set(`value`) {
      setHand(value)
    }

  /**
   * Set the motion range (if supported) limiting the hand motion.
   */
  public final inline var motionRange: MotionRange
    @JvmName("motionRangeProperty")
    get() = getMotionRange()
    @JvmName("motionRangeProperty")
    set(`value`) {
      setMotionRange(value)
    }

  /**
   * Set a [Skeleton3D] node for which the pose positions will be updated.
   */
  public final inline var handSkeleton: NodePath
    @JvmName("handSkeletonProperty")
    get() = getHandSkeleton()
    @JvmName("handSkeletonProperty")
    set(`value`) {
      setHandSkeleton(value)
    }

  /**
   * Set the type of skeleton rig the [handSkeleton] is compliant with.
   */
  public final inline var skeletonRig: SkeletonRig
    @JvmName("skeletonRigProperty")
    get() = getSkeletonRig()
    @JvmName("skeletonRigProperty")
    set(`value`) {
      setSkeletonRig(value)
    }

  /**
   * Specify the type of updates to perform on the bone.
   */
  public final inline var boneUpdate: BoneUpdate
    @JvmName("boneUpdateProperty")
    get() = getBoneUpdate()
    @JvmName("boneUpdateProperty")
    set(`value`) {
      setBoneUpdate(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(455, scriptPtr)
  }

  public final fun setHand(hand: Hands): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, hand.value)
    TransferContext.callMethod(MethodBindings.setHandPtr)
  }

  public final fun getHand(): Hands {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHandPtr)
    return Hands.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setHandSkeleton(handSkeleton: NodePath): Unit {
    TransferContext.writeMethodArguments_NODE_PATH(ptr, objectID.id, handSkeleton)
    TransferContext.callMethod(MethodBindings.setHandSkeletonPtr)
  }

  public final fun getHandSkeleton(): NodePath {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHandSkeletonPtr)
    return TransferContext.readReturnValue_NODE_PATH()
  }

  public final fun setMotionRange(motionRange: MotionRange): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, motionRange.value)
    TransferContext.callMethod(MethodBindings.setMotionRangePtr)
  }

  public final fun getMotionRange(): MotionRange {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getMotionRangePtr)
    return MotionRange.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setSkeletonRig(skeletonRig: SkeletonRig): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, skeletonRig.value)
    TransferContext.callMethod(MethodBindings.setSkeletonRigPtr)
  }

  public final fun getSkeletonRig(): SkeletonRig {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSkeletonRigPtr)
    return SkeletonRig.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setBoneUpdate(boneUpdate: BoneUpdate): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, boneUpdate.value)
    TransferContext.callMethod(MethodBindings.setBoneUpdatePtr)
  }

  public final fun getBoneUpdate(): BoneUpdate {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBoneUpdatePtr)
    return BoneUpdate.from(TransferContext.readReturnValue_LONG())
  }

  public final fun setHandSkeleton(handSkeleton: String) =
      setHandSkeleton(handSkeleton.asCachedNodePath())

  public enum class Hands(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Tracking the player's left hand.
     */
    LEFT(0),
    /**
     * Tracking the player's right hand.
     */
    RIGHT(1),
    /**
     * Maximum supported hands.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): Hands = entries.single { it.`value` == `value` }
    }
  }

  public enum class MotionRange(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * When player grips, hand skeleton will form a full fist.
     */
    UNOBSTRUCTED(0),
    /**
     * When player grips, hand skeleton conforms to the controller the player is holding.
     */
    CONFORM_TO_CONTROLLER(1),
    /**
     * Maximum supported motion ranges.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): MotionRange = entries.single { it.`value` == `value` }
    }
  }

  public enum class SkeletonRig(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * An OpenXR compliant skeleton.
     */
    OPENXR(0),
    /**
     * A [SkeletonProfileHumanoid] compliant skeleton.
     */
    HUMANOID(1),
    /**
     * Maximum supported hands.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): SkeletonRig = entries.single { it.`value` == `value` }
    }
  }

  public enum class BoneUpdate(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The skeletons bones are fully updated (both position and rotation) to match the tracked
     * bones.
     */
    FULL(0),
    /**
     * The skeletons bones are only rotated to align with the tracked bones, preserving bone length.
     */
    ROTATION_ONLY(1),
    /**
     * Maximum supported bone update mode.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): BoneUpdate = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setHandName: MethodStringName1<OpenXRHand, Unit, Hands> =
        MethodStringName1<OpenXRHand, Unit, Hands>("set_hand")

    @JvmField
    public val getHandName: MethodStringName0<OpenXRHand, Hands> =
        MethodStringName0<OpenXRHand, Hands>("get_hand")

    @JvmField
    public val setHandSkeletonName: MethodStringName1<OpenXRHand, Unit, NodePath> =
        MethodStringName1<OpenXRHand, Unit, NodePath>("set_hand_skeleton")

    @JvmField
    public val getHandSkeletonName: MethodStringName0<OpenXRHand, NodePath> =
        MethodStringName0<OpenXRHand, NodePath>("get_hand_skeleton")

    @JvmField
    public val setMotionRangeName: MethodStringName1<OpenXRHand, Unit, MotionRange> =
        MethodStringName1<OpenXRHand, Unit, MotionRange>("set_motion_range")

    @JvmField
    public val getMotionRangeName: MethodStringName0<OpenXRHand, MotionRange> =
        MethodStringName0<OpenXRHand, MotionRange>("get_motion_range")

    @JvmField
    public val setSkeletonRigName: MethodStringName1<OpenXRHand, Unit, SkeletonRig> =
        MethodStringName1<OpenXRHand, Unit, SkeletonRig>("set_skeleton_rig")

    @JvmField
    public val getSkeletonRigName: MethodStringName0<OpenXRHand, SkeletonRig> =
        MethodStringName0<OpenXRHand, SkeletonRig>("get_skeleton_rig")

    @JvmField
    public val setBoneUpdateName: MethodStringName1<OpenXRHand, Unit, BoneUpdate> =
        MethodStringName1<OpenXRHand, Unit, BoneUpdate>("set_bone_update")

    @JvmField
    public val getBoneUpdateName: MethodStringName0<OpenXRHand, BoneUpdate> =
        MethodStringName0<OpenXRHand, BoneUpdate>("get_bone_update")
  }

  public object MethodBindings {
    internal val setHandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "set_hand", 1849328560)

    internal val getHandPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "get_hand", 2850644561)

    internal val setHandSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "set_hand_skeleton", 1348162250)

    internal val getHandSkeletonPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "get_hand_skeleton", 4075236667)

    internal val setMotionRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "set_motion_range", 3326516003)

    internal val getMotionRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "get_motion_range", 2191822314)

    internal val setSkeletonRigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "set_skeleton_rig", 1528072213)

    internal val getSkeletonRigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "get_skeleton_rig", 968409338)

    internal val setBoneUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "set_bone_update", 3144625444)

    internal val getBoneUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRHand", "get_bone_update", 1310695248)
  }
}
