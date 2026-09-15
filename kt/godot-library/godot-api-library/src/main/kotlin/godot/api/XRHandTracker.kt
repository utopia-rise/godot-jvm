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
import godot.core.MethodStringName2
import godot.core.Transform3D
import godot.core.Vector3
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_LONG_TRANSFORM3D
import godot.writeMethodArguments_LONG_VECTOR3
import kotlin.Boolean
import kotlin.Float
import kotlin.Long
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

public infix fun Long.or(other: XRHandTracker.HandJointFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: XRHandTracker.HandJointFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: XRHandTracker.HandJointFlags): Long = this.and(other.flag)

/**
 * A hand tracking system will create an instance of this object and add it to the [XRServer]. This
 * tracking system will then obtain skeleton data, convert it to the Godot Humanoid hand skeleton and
 * store this data on the [XRHandTracker] object.
 *
 * Use [XRHandModifier3D] to animate a hand mesh using hand tracking data.
 */
@GodotBaseType
public open class XRHandTracker : XRPositionalTracker() {
  /**
   * If `true`, the hand tracking data is valid.
   */
  public final inline var hasTrackingData: Boolean
    @JvmName("hasTrackingDataProperty")
    get() = getHasTrackingData()
    @JvmName("hasTrackingDataProperty")
    set(`value`) {
      setHasTrackingData(value)
    }

  /**
   * The source of the hand tracking data.
   */
  public final inline var handTrackingSource: HandTrackingSource
    @JvmName("handTrackingSourceProperty")
    get() = getHandTrackingSource()
    @JvmName("handTrackingSourceProperty")
    set(`value`) {
      setHandTrackingSource(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(945, scriptPtr)
  }

  public final fun setHasTrackingData(hasData: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, hasData)
    TransferContext.callMethod(MethodBindings.setHasTrackingDataPtr)
  }

  public final fun getHasTrackingData(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHasTrackingDataPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setHandTrackingSource(source: HandTrackingSource): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, source.value)
    TransferContext.callMethod(MethodBindings.setHandTrackingSourcePtr)
  }

  public final fun getHandTrackingSource(): HandTrackingSource {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHandTrackingSourcePtr)
    return HandTrackingSource.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets flags about the validity of the tracking data for the given hand joint.
   */
  public final fun setHandJointFlags(joint: HandJoint, flags: HandJointFlags): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, joint.value, flags.flag)
    TransferContext.callMethod(MethodBindings.setHandJointFlagsPtr)
  }

  /**
   * Returns flags about the validity of the tracking data for the given hand joint.
   */
  public final fun getHandJointFlags(joint: HandJoint): HandJointFlags {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointFlagsPtr)
    return HandJointFlags(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the transform for the given hand joint.
   */
  public final fun setHandJointTransform(joint: HandJoint, transform: Transform3D): Unit {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, joint.value, transform)
    TransferContext.callMethod(MethodBindings.setHandJointTransformPtr)
  }

  /**
   * Returns the transform for the given hand joint.
   */
  public final fun getHandJointTransform(joint: HandJoint): Transform3D {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointTransformPtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Sets the radius of the given hand joint.
   */
  public final fun setHandJointRadius(joint: HandJoint, radius: Float): Unit {
    TransferContext.writeMethodArguments_LONG_DOUBLE(ptr, objectID.id, joint.value, radius.toDouble())
    TransferContext.callMethod(MethodBindings.setHandJointRadiusPtr)
  }

  /**
   * Returns the radius of the given hand joint.
   */
  public final fun getHandJointRadius(joint: HandJoint): Float {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointRadiusPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the linear velocity for the given hand joint.
   */
  public final fun setHandJointLinearVelocity(joint: HandJoint, linearVelocity: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, joint.value, linearVelocity)
    TransferContext.callMethod(MethodBindings.setHandJointLinearVelocityPtr)
  }

  /**
   * Returns the linear velocity for the given hand joint.
   */
  public final fun getHandJointLinearVelocity(joint: HandJoint): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointLinearVelocityPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Sets the angular velocity for the given hand joint.
   */
  public final fun setHandJointAngularVelocity(joint: HandJoint, angularVelocity: Vector3): Unit {
    TransferContext.writeMethodArguments_LONG_VECTOR3(ptr, objectID.id, joint.value, angularVelocity)
    TransferContext.callMethod(MethodBindings.setHandJointAngularVelocityPtr)
  }

  /**
   * Returns the angular velocity for the given hand joint.
   */
  public final fun getHandJointAngularVelocity(joint: HandJoint): Vector3 {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointAngularVelocityPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  public enum class HandTrackingSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The source of hand tracking data is unknown.
     */
    UNKNOWN(0),
    /**
     * The source of hand tracking data is unobstructed, meaning that an accurate method of hand
     * tracking is used. These include optical hand tracking, data gloves, etc.
     */
    UNOBSTRUCTED(1),
    /**
     * The source of hand tracking data is a controller, meaning that joint positions are inferred
     * from controller inputs.
     */
    CONTROLLER(2),
    /**
     * No hand tracking data is tracked, this either means the hand is obscured, the controller is
     * turned off, or tracking is not supported for the current input type.
     */
    NOT_TRACKED(3),
    /**
     * Represents the size of the [HandTrackingSource] enum.
     */
    MAX(4),
    ;

    public companion object {
      public fun from(`value`: Long): HandTrackingSource = entries.single { it.`value` == `value` }
    }
  }

  public enum class HandJoint(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Palm joint.
     */
    PALM(0),
    /**
     * Wrist joint.
     */
    WRIST(1),
    /**
     * Thumb metacarpal joint.
     */
    THUMB_METACARPAL(2),
    /**
     * Thumb phalanx proximal joint.
     */
    THUMB_PHALANX_PROXIMAL(3),
    /**
     * Thumb phalanx distal joint.
     */
    THUMB_PHALANX_DISTAL(4),
    /**
     * Thumb tip joint.
     */
    THUMB_TIP(5),
    /**
     * Index finger metacarpal joint.
     */
    INDEX_FINGER_METACARPAL(6),
    /**
     * Index finger phalanx proximal joint.
     */
    INDEX_FINGER_PHALANX_PROXIMAL(7),
    /**
     * Index finger phalanx intermediate joint.
     */
    INDEX_FINGER_PHALANX_INTERMEDIATE(8),
    /**
     * Index finger phalanx distal joint.
     */
    INDEX_FINGER_PHALANX_DISTAL(9),
    /**
     * Index finger tip joint.
     */
    INDEX_FINGER_TIP(10),
    /**
     * Middle finger metacarpal joint.
     */
    MIDDLE_FINGER_METACARPAL(11),
    /**
     * Middle finger phalanx proximal joint.
     */
    MIDDLE_FINGER_PHALANX_PROXIMAL(12),
    /**
     * Middle finger phalanx intermediate joint.
     */
    MIDDLE_FINGER_PHALANX_INTERMEDIATE(13),
    /**
     * Middle finger phalanx distal joint.
     */
    MIDDLE_FINGER_PHALANX_DISTAL(14),
    /**
     * Middle finger tip joint.
     */
    MIDDLE_FINGER_TIP(15),
    /**
     * Ring finger metacarpal joint.
     */
    RING_FINGER_METACARPAL(16),
    /**
     * Ring finger phalanx proximal joint.
     */
    RING_FINGER_PHALANX_PROXIMAL(17),
    /**
     * Ring finger phalanx intermediate joint.
     */
    RING_FINGER_PHALANX_INTERMEDIATE(18),
    /**
     * Ring finger phalanx distal joint.
     */
    RING_FINGER_PHALANX_DISTAL(19),
    /**
     * Ring finger tip joint.
     */
    RING_FINGER_TIP(20),
    /**
     * Pinky finger metacarpal joint.
     */
    PINKY_FINGER_METACARPAL(21),
    /**
     * Pinky finger phalanx proximal joint.
     */
    PINKY_FINGER_PHALANX_PROXIMAL(22),
    /**
     * Pinky finger phalanx intermediate joint.
     */
    PINKY_FINGER_PHALANX_INTERMEDIATE(23),
    /**
     * Pinky finger phalanx distal joint.
     */
    PINKY_FINGER_PHALANX_DISTAL(24),
    /**
     * Pinky finger tip joint.
     */
    PINKY_FINGER_TIP(25),
    /**
     * Represents the size of the [HandJoint] enum.
     */
    MAX(26),
    ;

    public companion object {
      public fun from(`value`: Long): HandJoint = entries.single { it.`value` == `value` }
    }
  }

  public class HandJointFlags(
    flag: Long,
  ) : BitFieldBase<HandJointFlags>(flag) {
    protected override fun wrap(flag: Long): HandJointFlags = HandJointFlags(flag)

    public companion object {
      /**
       * The hand joint's orientation data is valid.
       */
      @JvmField
      public val ORIENTATION_VALID: HandJointFlags = HandJointFlags(1)

      /**
       * The hand joint's orientation is actively tracked. May not be set if tracking has been
       * temporarily lost.
       */
      @JvmField
      public val ORIENTATION_TRACKED: HandJointFlags = HandJointFlags(2)

      /**
       * The hand joint's position data is valid.
       */
      @JvmField
      public val POSITION_VALID: HandJointFlags = HandJointFlags(4)

      /**
       * The hand joint's position is actively tracked. May not be set if tracking has been
       * temporarily lost.
       */
      @JvmField
      public val POSITION_TRACKED: HandJointFlags = HandJointFlags(8)

      /**
       * The hand joint's linear velocity data is valid.
       */
      @JvmField
      public val LINEAR_VELOCITY_VALID: HandJointFlags = HandJointFlags(16)

      /**
       * The hand joint's angular velocity data is valid.
       */
      @JvmField
      public val ANGULAR_VELOCITY_VALID: HandJointFlags = HandJointFlags(32)
    }
  }

  public companion object {
    @JvmField
    public val setHasTrackingDataName: MethodStringName1<XRHandTracker, Unit, Boolean> =
        MethodStringName1<XRHandTracker, Unit, Boolean>("set_has_tracking_data")

    @JvmField
    public val getHasTrackingDataName: MethodStringName0<XRHandTracker, Boolean> =
        MethodStringName0<XRHandTracker, Boolean>("get_has_tracking_data")

    @JvmField
    public val setHandTrackingSourceName: MethodStringName1<XRHandTracker, Unit, HandTrackingSource>
        = MethodStringName1<XRHandTracker, Unit, HandTrackingSource>("set_hand_tracking_source")

    @JvmField
    public val getHandTrackingSourceName: MethodStringName0<XRHandTracker, HandTrackingSource> =
        MethodStringName0<XRHandTracker, HandTrackingSource>("get_hand_tracking_source")

    @JvmField
    public val setHandJointFlagsName:
        MethodStringName2<XRHandTracker, Unit, HandJoint, HandJointFlags> =
        MethodStringName2<XRHandTracker, Unit, HandJoint, HandJointFlags>("set_hand_joint_flags")

    @JvmField
    public val getHandJointFlagsName: MethodStringName1<XRHandTracker, HandJointFlags, HandJoint> =
        MethodStringName1<XRHandTracker, HandJointFlags, HandJoint>("get_hand_joint_flags")

    @JvmField
    public val setHandJointTransformName:
        MethodStringName2<XRHandTracker, Unit, HandJoint, Transform3D> =
        MethodStringName2<XRHandTracker, Unit, HandJoint, Transform3D>("set_hand_joint_transform")

    @JvmField
    public val getHandJointTransformName: MethodStringName1<XRHandTracker, Transform3D, HandJoint> =
        MethodStringName1<XRHandTracker, Transform3D, HandJoint>("get_hand_joint_transform")

    @JvmField
    public val setHandJointRadiusName: MethodStringName2<XRHandTracker, Unit, HandJoint, Float> =
        MethodStringName2<XRHandTracker, Unit, HandJoint, Float>("set_hand_joint_radius")

    @JvmField
    public val getHandJointRadiusName: MethodStringName1<XRHandTracker, Float, HandJoint> =
        MethodStringName1<XRHandTracker, Float, HandJoint>("get_hand_joint_radius")

    @JvmField
    public val setHandJointLinearVelocityName:
        MethodStringName2<XRHandTracker, Unit, HandJoint, Vector3> =
        MethodStringName2<XRHandTracker, Unit, HandJoint, Vector3>("set_hand_joint_linear_velocity")

    @JvmField
    public val getHandJointLinearVelocityName: MethodStringName1<XRHandTracker, Vector3, HandJoint>
        = MethodStringName1<XRHandTracker, Vector3, HandJoint>("get_hand_joint_linear_velocity")

    @JvmField
    public val setHandJointAngularVelocityName:
        MethodStringName2<XRHandTracker, Unit, HandJoint, Vector3> =
        MethodStringName2<XRHandTracker, Unit, HandJoint, Vector3>("set_hand_joint_angular_velocity")

    @JvmField
    public val getHandJointAngularVelocityName: MethodStringName1<XRHandTracker, Vector3, HandJoint>
        = MethodStringName1<XRHandTracker, Vector3, HandJoint>("get_hand_joint_angular_velocity")
  }

  public object MethodBindings {
    internal val setHasTrackingDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "set_has_tracking_data", 2586408642)

    internal val getHasTrackingDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "get_has_tracking_data", 36873697)

    internal val setHandTrackingSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "set_hand_tracking_source", 2958308861)

    internal val getHandTrackingSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "get_hand_tracking_source", 2475045250)

    internal val setHandJointFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "set_hand_joint_flags", 3028437365)

    internal val getHandJointFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "get_hand_joint_flags", 1730972401)

    internal val setHandJointTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "set_hand_joint_transform", 2529959613)

    internal val getHandJointTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "get_hand_joint_transform", 1090840196)

    internal val setHandJointRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "set_hand_joint_radius", 2723659615)

    internal val getHandJointRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "get_hand_joint_radius", 3400025734)

    internal val setHandJointLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "set_hand_joint_linear_velocity", 1978646737)

    internal val getHandJointLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "get_hand_joint_linear_velocity", 547240792)

    internal val setHandJointAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "set_hand_joint_angular_velocity", 1978646737)

    internal val getHandJointAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRHandTracker", "get_hand_joint_angular_velocity", 547240792)
  }
}
