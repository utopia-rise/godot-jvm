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
import godot.core.MethodStringName5
import godot.core.Signal1
import godot.core.StringName
import godot.core.asCachedStringName
import godot.readReturnValue_BOOL
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_STRING_DOUBLE_DOUBLE_DOUBLE_DOUBLE
import godot.writeMethodArguments_STRING_NAME
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * This node can be bound to a specific pose of an [XRPositionalTracker] and will automatically have
 * its [Node3D.transform] updated by the [XRServer]. Nodes of this type must be added as children of
 * the [XROrigin3D] node.
 */
@GodotBaseType
public open class XRNode3D : Node3D() {
  /**
   * Emitted when the [tracker] starts or stops receiving updated tracking data for the [pose] being
   * tracked. The [tracking] argument indicates whether the tracker is getting updated tracking data.
   */
  public val trackingChanged: Signal1<Boolean> by Signal1

  /**
   * The name of the tracker we're bound to. Which trackers are available is not known during design
   * time.
   *
   * Godot defines a number of standard trackers such as `left_hand` and `right_hand` but others may
   * be configured within a given [XRInterface].
   */
  public final inline var tracker: StringName
    @JvmName("trackerProperty")
    get() = getTracker()
    @JvmName("trackerProperty")
    set(`value`) {
      setTracker(value)
    }

  /**
   * The name of the pose we're bound to. Which poses a tracker supports is not known during design
   * time.
   *
   * Godot defines number of standard pose names such as `aim` and `grip` but other may be
   * configured within a given [XRInterface].
   */
  public final inline var pose: StringName
    @JvmName("poseProperty")
    get() = getPoseName()
    @JvmName("poseProperty")
    set(`value`) {
      setPoseName(value)
    }

  /**
   * Enables showing the node when tracking starts, and hiding the node when tracking is lost.
   */
  public final inline var showWhenTracked: Boolean
    @JvmName("showWhenTrackedProperty")
    get() = getShowWhenTracked()
    @JvmName("showWhenTrackedProperty")
    set(`value`) {
      setShowWhenTracked(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(948, scriptPtr)
  }

  public final fun setTracker(trackerName: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, trackerName)
    TransferContext.callPtrMethod(MethodBindings.setTrackerPtr, 0)
  }

  public final fun getTracker(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackerPtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setPoseName(pose: StringName): Unit {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, pose)
    TransferContext.callPtrMethod(MethodBindings.setPoseNamePtr, 0)
  }

  public final fun getPoseName(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPoseNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  public final fun setShowWhenTracked(show: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, show)
    TransferContext.callPtrMethod(MethodBindings.setShowWhenTrackedPtr, 0)
  }

  public final fun getShowWhenTracked(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getShowWhenTrackedPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the [tracker] has been registered and the [pose] is being tracked.
   */
  public final fun getIsActive(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getIsActivePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the [tracker] has current tracking data for the [pose] being tracked.
   */
  public final fun getHasTrackingData(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getHasTrackingDataPtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the [XRPose] containing the current state of the pose being tracked. This gives access
   * to additional properties of this pose.
   */
  public final fun getPose(): XRPose? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getPosePtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as XRPose?)
  }

  /**
   * Triggers a haptic pulse on a device associated with this interface.
   *
   * [actionName] is the name of the action for this pulse.
   *
   * [frequency] is the frequency of the pulse, set to `0.0` to have the system use a default
   * frequency.
   *
   * [amplitude] is the amplitude of the pulse between `0.0` and `1.0`.
   *
   * [durationSec] is the duration of the pulse in seconds.
   *
   * [delaySec] is a delay in seconds before the pulse is given.
   */
  public final fun triggerHapticPulse(
    actionName: String,
    frequency: Double,
    amplitude: Double,
    durationSec: Double,
    delaySec: Double,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_DOUBLE_DOUBLE_DOUBLE_DOUBLE(ptr, objectID.id, actionName, frequency, amplitude, durationSec, delaySec)
    TransferContext.callMethod(MethodBindings.triggerHapticPulsePtr)
  }

  public final fun setTracker(trackerName: String) = setTracker(trackerName.asCachedStringName())

  public final fun setPoseName(pose: String) = setPoseName(pose.asCachedStringName())

  public companion object {
    @JvmField
    public val setTrackerName: MethodStringName1<XRNode3D, Unit, StringName> =
        MethodStringName1<XRNode3D, Unit, StringName>("set_tracker")

    @JvmField
    public val getTrackerName: MethodStringName0<XRNode3D, StringName> =
        MethodStringName0<XRNode3D, StringName>("get_tracker")

    @JvmField
    public val setPoseNameName: MethodStringName1<XRNode3D, Unit, StringName> =
        MethodStringName1<XRNode3D, Unit, StringName>("set_pose_name")

    @JvmField
    public val getPoseNameName: MethodStringName0<XRNode3D, StringName> =
        MethodStringName0<XRNode3D, StringName>("get_pose_name")

    @JvmField
    public val setShowWhenTrackedName: MethodStringName1<XRNode3D, Unit, Boolean> =
        MethodStringName1<XRNode3D, Unit, Boolean>("set_show_when_tracked")

    @JvmField
    public val getShowWhenTrackedName: MethodStringName0<XRNode3D, Boolean> =
        MethodStringName0<XRNode3D, Boolean>("get_show_when_tracked")

    @JvmField
    public val getIsActiveName: MethodStringName0<XRNode3D, Boolean> =
        MethodStringName0<XRNode3D, Boolean>("get_is_active")

    @JvmField
    public val getHasTrackingDataName: MethodStringName0<XRNode3D, Boolean> =
        MethodStringName0<XRNode3D, Boolean>("get_has_tracking_data")

    @JvmField
    public val getPoseName: MethodStringName0<XRNode3D, XRPose?> =
        MethodStringName0<XRNode3D, XRPose?>("get_pose")

    @JvmField
    public val triggerHapticPulseName:
        MethodStringName5<XRNode3D, Unit, String, Double, Double, Double, Double> =
        MethodStringName5<XRNode3D, Unit, String, Double, Double, Double, Double>("trigger_haptic_pulse")
  }

  public object MethodBindings {
    internal val setTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "set_tracker", 3304788590)

    internal val getTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "get_tracker", 2002593661)

    internal val setPoseNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "set_pose_name", 3304788590)

    internal val getPoseNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "get_pose_name", 2002593661)

    internal val setShowWhenTrackedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "set_show_when_tracked", 2586408642)

    internal val getShowWhenTrackedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "get_show_when_tracked", 36873697)

    internal val getIsActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "get_is_active", 36873697)

    internal val getHasTrackingDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "get_has_tracking_data", 36873697)

    internal val getPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "get_pose", 2806551826)

    internal val triggerHapticPulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRNode3D", "trigger_haptic_pulse", 508576839)
  }
}
