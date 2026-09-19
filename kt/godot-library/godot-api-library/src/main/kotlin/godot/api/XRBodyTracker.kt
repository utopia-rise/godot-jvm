// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_LONG
import godot.callPtrMethod_LONG_LONG
import godot.callPtrMethod_LONG_TRANSFORM3D
import godot.callPtrMethod_LONG_ret_LONG
import godot.callPtrMethod_LONG_ret_TRANSFORM3D
import godot.common.interop.VoidPtr
import godot.core.BitFieldBase
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Transform3D
import kotlin.Boolean
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

public infix fun Long.or(other: XRBodyTracker.BodyFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: XRBodyTracker.BodyFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: XRBodyTracker.BodyFlags): Long = this.and(other.flag)

public infix fun Long.or(other: XRBodyTracker.JointFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: XRBodyTracker.JointFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: XRBodyTracker.JointFlags): Long = this.and(other.flag)

/**
 * A body tracking system will create an instance of this object and add it to the [XRServer]. This
 * tracking system will then obtain skeleton data, convert it to the Godot Humanoid skeleton and store
 * this data on the [XRBodyTracker] object.
 *
 * Use [XRBodyModifier3D] to animate a body mesh using body tracking data.
 */
@GodotBaseType
public open class XRBodyTracker : XRPositionalTracker() {
  /**
   * If `true`, the body tracking data is valid.
   */
  public final inline var hasTrackingData: Boolean
    @JvmName("hasTrackingDataProperty")
    get() = getHasTrackingData()
    @JvmName("hasTrackingDataProperty")
    set(`value`) {
      setHasTrackingData(value)
    }

  /**
   * The type of body tracking data captured.
   */
  public final inline var bodyFlags: BodyFlags
    @JvmName("bodyFlagsProperty")
    get() = getBodyFlags()
    @JvmName("bodyFlagsProperty")
    set(`value`) {
      setBodyFlags(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(938, scriptPtr)
  }

  public final fun setHasTrackingData(hasData: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setHasTrackingDataPtr, hasData)
  }

  public final fun getHasTrackingData(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.getHasTrackingDataPtr)

  public final fun setBodyFlags(flags: BodyFlags): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBodyFlagsPtr, flags.flag)
  }

  public final fun getBodyFlags(): BodyFlags =
      BodyFlags(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBodyFlagsPtr))

  /**
   * Sets flags about the validity of the tracking data for the given body joint.
   */
  public final fun setJointFlags(joint: Joint, flags: JointFlags): Unit {
    TransferContext.callPtrMethod_LONG_LONG(ptr, objectID.id, MethodBindings.setJointFlagsPtr, joint.value, flags.flag)
  }

  /**
   * Returns flags about the validity of the tracking data for the given body joint.
   */
  public final fun getJointFlags(joint: Joint): JointFlags =
      JointFlags(TransferContext.callPtrMethod_LONG_ret_LONG(ptr, objectID.id, MethodBindings.getJointFlagsPtr, joint.value))

  /**
   * Sets the transform for the given body joint.
   */
  public final fun setJointTransform(joint: Joint, transform: Transform3D): Unit {
    TransferContext.callPtrMethod_LONG_TRANSFORM3D(ptr, objectID.id, MethodBindings.setJointTransformPtr, joint.value, transform)
  }

  /**
   * Returns the transform for the given body joint.
   */
  public final fun getJointTransform(joint: Joint): Transform3D =
      TransferContext.callPtrMethod_LONG_ret_TRANSFORM3D(ptr, objectID.id, MethodBindings.getJointTransformPtr, joint.value)

  public class BodyFlags(
    flag: Long,
  ) : BitFieldBase<BodyFlags>(flag) {
    protected override fun wrap(flag: Long): BodyFlags = BodyFlags(flag)

    public companion object {
      /**
       * Upper body tracking supported.
       */
      @JvmField
      public val UPPER_BODY_SUPPORTED: BodyFlags = BodyFlags(1)

      /**
       * Lower body tracking supported.
       */
      @JvmField
      public val LOWER_BODY_SUPPORTED: BodyFlags = BodyFlags(2)

      /**
       * Hand tracking supported.
       */
      @JvmField
      public val HANDS_SUPPORTED: BodyFlags = BodyFlags(4)
    }
  }

  public enum class Joint(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Root joint.
     */
    ROOT(0),
    /**
     * Hips joint.
     */
    HIPS(1),
    /**
     * Spine joint.
     */
    SPINE(2),
    /**
     * Chest joint.
     */
    CHEST(3),
    /**
     * Upper chest joint.
     */
    UPPER_CHEST(4),
    /**
     * Neck joint.
     */
    NECK(5),
    /**
     * Head joint.
     */
    HEAD(6),
    /**
     * Head tip joint.
     */
    HEAD_TIP(7),
    /**
     * Left shoulder joint.
     */
    LEFT_SHOULDER(8),
    /**
     * Left upper arm joint.
     */
    LEFT_UPPER_ARM(9),
    /**
     * Left lower arm joint.
     */
    LEFT_LOWER_ARM(10),
    /**
     * Right shoulder joint.
     */
    RIGHT_SHOULDER(11),
    /**
     * Right upper arm joint.
     */
    RIGHT_UPPER_ARM(12),
    /**
     * Right lower arm joint.
     */
    RIGHT_LOWER_ARM(13),
    /**
     * Left upper leg joint.
     */
    LEFT_UPPER_LEG(14),
    /**
     * Left lower leg joint.
     */
    LEFT_LOWER_LEG(15),
    /**
     * Left foot joint.
     */
    LEFT_FOOT(16),
    /**
     * Left toes joint.
     */
    LEFT_TOES(17),
    /**
     * Right upper leg joint.
     */
    RIGHT_UPPER_LEG(18),
    /**
     * Right lower leg joint.
     */
    RIGHT_LOWER_LEG(19),
    /**
     * Right foot joint.
     */
    RIGHT_FOOT(20),
    /**
     * Right toes joint.
     */
    RIGHT_TOES(21),
    /**
     * Left hand joint.
     */
    LEFT_HAND(22),
    /**
     * Left palm joint.
     */
    LEFT_PALM(23),
    /**
     * Left wrist joint.
     */
    LEFT_WRIST(24),
    /**
     * Left thumb metacarpal joint.
     */
    LEFT_THUMB_METACARPAL(25),
    /**
     * Left thumb phalanx proximal joint.
     */
    LEFT_THUMB_PHALANX_PROXIMAL(26),
    /**
     * Left thumb phalanx distal joint.
     */
    LEFT_THUMB_PHALANX_DISTAL(27),
    /**
     * Left thumb tip joint.
     */
    LEFT_THUMB_TIP(28),
    /**
     * Left index finger metacarpal joint.
     */
    LEFT_INDEX_FINGER_METACARPAL(29),
    /**
     * Left index finger phalanx proximal joint.
     */
    LEFT_INDEX_FINGER_PHALANX_PROXIMAL(30),
    /**
     * Left index finger phalanx intermediate joint.
     */
    LEFT_INDEX_FINGER_PHALANX_INTERMEDIATE(31),
    /**
     * Left index finger phalanx distal joint.
     */
    LEFT_INDEX_FINGER_PHALANX_DISTAL(32),
    /**
     * Left index finger tip joint.
     */
    LEFT_INDEX_FINGER_TIP(33),
    /**
     * Left middle finger metacarpal joint.
     */
    LEFT_MIDDLE_FINGER_METACARPAL(34),
    /**
     * Left middle finger phalanx proximal joint.
     */
    LEFT_MIDDLE_FINGER_PHALANX_PROXIMAL(35),
    /**
     * Left middle finger phalanx intermediate joint.
     */
    LEFT_MIDDLE_FINGER_PHALANX_INTERMEDIATE(36),
    /**
     * Left middle finger phalanx distal joint.
     */
    LEFT_MIDDLE_FINGER_PHALANX_DISTAL(37),
    /**
     * Left middle finger tip joint.
     */
    LEFT_MIDDLE_FINGER_TIP(38),
    /**
     * Left ring finger metacarpal joint.
     */
    LEFT_RING_FINGER_METACARPAL(39),
    /**
     * Left ring finger phalanx proximal joint.
     */
    LEFT_RING_FINGER_PHALANX_PROXIMAL(40),
    /**
     * Left ring finger phalanx intermediate joint.
     */
    LEFT_RING_FINGER_PHALANX_INTERMEDIATE(41),
    /**
     * Left ring finger phalanx distal joint.
     */
    LEFT_RING_FINGER_PHALANX_DISTAL(42),
    /**
     * Left ring finger tip joint.
     */
    LEFT_RING_FINGER_TIP(43),
    /**
     * Left pinky finger metacarpal joint.
     */
    LEFT_PINKY_FINGER_METACARPAL(44),
    /**
     * Left pinky finger phalanx proximal joint.
     */
    LEFT_PINKY_FINGER_PHALANX_PROXIMAL(45),
    /**
     * Left pinky finger phalanx intermediate joint.
     */
    LEFT_PINKY_FINGER_PHALANX_INTERMEDIATE(46),
    /**
     * Left pinky finger phalanx distal joint.
     */
    LEFT_PINKY_FINGER_PHALANX_DISTAL(47),
    /**
     * Left pinky finger tip joint.
     */
    LEFT_PINKY_FINGER_TIP(48),
    /**
     * Right hand joint.
     */
    RIGHT_HAND(49),
    /**
     * Right palm joint.
     */
    RIGHT_PALM(50),
    /**
     * Right wrist joint.
     */
    RIGHT_WRIST(51),
    /**
     * Right thumb metacarpal joint.
     */
    RIGHT_THUMB_METACARPAL(52),
    /**
     * Right thumb phalanx proximal joint.
     */
    RIGHT_THUMB_PHALANX_PROXIMAL(53),
    /**
     * Right thumb phalanx distal joint.
     */
    RIGHT_THUMB_PHALANX_DISTAL(54),
    /**
     * Right thumb tip joint.
     */
    RIGHT_THUMB_TIP(55),
    /**
     * Right index finger metacarpal joint.
     */
    RIGHT_INDEX_FINGER_METACARPAL(56),
    /**
     * Right index finger phalanx proximal joint.
     */
    RIGHT_INDEX_FINGER_PHALANX_PROXIMAL(57),
    /**
     * Right index finger phalanx intermediate joint.
     */
    RIGHT_INDEX_FINGER_PHALANX_INTERMEDIATE(58),
    /**
     * Right index finger phalanx distal joint.
     */
    RIGHT_INDEX_FINGER_PHALANX_DISTAL(59),
    /**
     * Right index finger tip joint.
     */
    RIGHT_INDEX_FINGER_TIP(60),
    /**
     * Right middle finger metacarpal joint.
     */
    RIGHT_MIDDLE_FINGER_METACARPAL(61),
    /**
     * Right middle finger phalanx proximal joint.
     */
    RIGHT_MIDDLE_FINGER_PHALANX_PROXIMAL(62),
    /**
     * Right middle finger phalanx intermediate joint.
     */
    RIGHT_MIDDLE_FINGER_PHALANX_INTERMEDIATE(63),
    /**
     * Right middle finger phalanx distal joint.
     */
    RIGHT_MIDDLE_FINGER_PHALANX_DISTAL(64),
    /**
     * Right middle finger tip joint.
     */
    RIGHT_MIDDLE_FINGER_TIP(65),
    /**
     * Right ring finger metacarpal joint.
     */
    RIGHT_RING_FINGER_METACARPAL(66),
    /**
     * Right ring finger phalanx proximal joint.
     */
    RIGHT_RING_FINGER_PHALANX_PROXIMAL(67),
    /**
     * Right ring finger phalanx intermediate joint.
     */
    RIGHT_RING_FINGER_PHALANX_INTERMEDIATE(68),
    /**
     * Right ring finger phalanx distal joint.
     */
    RIGHT_RING_FINGER_PHALANX_DISTAL(69),
    /**
     * Right ring finger tip joint.
     */
    RIGHT_RING_FINGER_TIP(70),
    /**
     * Right pinky finger metacarpal joint.
     */
    RIGHT_PINKY_FINGER_METACARPAL(71),
    /**
     * Right pinky finger phalanx proximal joint.
     */
    RIGHT_PINKY_FINGER_PHALANX_PROXIMAL(72),
    /**
     * Right pinky finger phalanx intermediate joint.
     */
    RIGHT_PINKY_FINGER_PHALANX_INTERMEDIATE(73),
    /**
     * Right pinky finger phalanx distal joint.
     */
    RIGHT_PINKY_FINGER_PHALANX_DISTAL(74),
    /**
     * Right pinky finger tip joint.
     */
    RIGHT_PINKY_FINGER_TIP(75),
    /**
     * Lower chest joint.
     */
    LOWER_CHEST(76),
    /**
     * Left scapula joint.
     */
    LEFT_SCAPULA(77),
    /**
     * Left wrist twist joint.
     */
    LEFT_WRIST_TWIST(78),
    /**
     * Right scapula joint.
     */
    RIGHT_SCAPULA(79),
    /**
     * Right wrist twist joint.
     */
    RIGHT_WRIST_TWIST(80),
    /**
     * Left foot twist joint.
     */
    LEFT_FOOT_TWIST(81),
    /**
     * Left heel joint.
     */
    LEFT_HEEL(82),
    /**
     * Left middle foot joint.
     */
    LEFT_MIDDLE_FOOT(83),
    /**
     * Right foot twist joint.
     */
    RIGHT_FOOT_TWIST(84),
    /**
     * Right heel joint.
     */
    RIGHT_HEEL(85),
    /**
     * Right middle foot joint.
     */
    RIGHT_MIDDLE_FOOT(86),
    /**
     * Represents the size of the [Joint] enum.
     */
    MAX(87),
    ;

    public companion object {
      public fun from(`value`: Long): Joint = entries.single { it.`value` == `value` }
    }
  }

  public class JointFlags(
    flag: Long,
  ) : BitFieldBase<JointFlags>(flag) {
    protected override fun wrap(flag: Long): JointFlags = JointFlags(flag)

    public companion object {
      /**
       * The joint's orientation data is valid.
       */
      @JvmField
      public val ORIENTATION_VALID: JointFlags = JointFlags(1)

      /**
       * The joint's orientation is actively tracked. May not be set if tracking has been
       * temporarily lost.
       */
      @JvmField
      public val ORIENTATION_TRACKED: JointFlags = JointFlags(2)

      /**
       * The joint's position data is valid.
       */
      @JvmField
      public val POSITION_VALID: JointFlags = JointFlags(4)

      /**
       * The joint's position is actively tracked. May not be set if tracking has been temporarily
       * lost.
       */
      @JvmField
      public val POSITION_TRACKED: JointFlags = JointFlags(8)
    }
  }

  public companion object {
    @JvmField
    public val setHasTrackingDataName: MethodStringName1<XRBodyTracker, Unit, Boolean> =
        MethodStringName1<XRBodyTracker, Unit, Boolean>("set_has_tracking_data")

    @JvmField
    public val getHasTrackingDataName: MethodStringName0<XRBodyTracker, Boolean> =
        MethodStringName0<XRBodyTracker, Boolean>("get_has_tracking_data")

    @JvmField
    public val setBodyFlagsName: MethodStringName1<XRBodyTracker, Unit, BodyFlags> =
        MethodStringName1<XRBodyTracker, Unit, BodyFlags>("set_body_flags")

    @JvmField
    public val getBodyFlagsName: MethodStringName0<XRBodyTracker, BodyFlags> =
        MethodStringName0<XRBodyTracker, BodyFlags>("get_body_flags")

    @JvmField
    public val setJointFlagsName: MethodStringName2<XRBodyTracker, Unit, Joint, JointFlags> =
        MethodStringName2<XRBodyTracker, Unit, Joint, JointFlags>("set_joint_flags")

    @JvmField
    public val getJointFlagsName: MethodStringName1<XRBodyTracker, JointFlags, Joint> =
        MethodStringName1<XRBodyTracker, JointFlags, Joint>("get_joint_flags")

    @JvmField
    public val setJointTransformName: MethodStringName2<XRBodyTracker, Unit, Joint, Transform3D> =
        MethodStringName2<XRBodyTracker, Unit, Joint, Transform3D>("set_joint_transform")

    @JvmField
    public val getJointTransformName: MethodStringName1<XRBodyTracker, Transform3D, Joint> =
        MethodStringName1<XRBodyTracker, Transform3D, Joint>("get_joint_transform")
  }

  public object MethodBindings {
    internal val setHasTrackingDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "set_has_tracking_data", 2586408642)

    internal val getHasTrackingDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "get_has_tracking_data", 36873697)

    internal val setBodyFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "set_body_flags", 2103235750)

    internal val getBodyFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "get_body_flags", 3543166366)

    internal val setJointFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "set_joint_flags", 592144999)

    internal val getJointFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "get_joint_flags", 1030162609)

    internal val setJointTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "set_joint_transform", 2635424328)

    internal val getJointTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRBodyTracker", "get_joint_transform", 3474811534)
  }
}
