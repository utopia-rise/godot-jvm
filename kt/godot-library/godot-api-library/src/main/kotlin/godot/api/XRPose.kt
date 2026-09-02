// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.CoreTypeHelper
import godot.`annotation`.CoreTypeLocalCopy
import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.common.interop.VoidPtr
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.TRANSFORM3D
import godot.core.VariantParser.VECTOR3
import godot.core.Vector3
import godot.core.asCachedStringName
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * XR runtimes often identify multiple locations on devices such as controllers that are spatially
 * tracked.
 *
 * Orientation, location, linear velocity and angular velocity are all provided for each pose by the
 * XR runtime. This object contains this state of a pose.
 */
@GodotBaseType
public open class XRPose : RefCounted() {
  /**
   * If `true` our tracking data is up to date. If `false` we're no longer receiving new tracking
   * data and our state is whatever that last valid state was.
   */
  public final inline var hasTrackingData: Boolean
    @JvmName("hasTrackingDataProperty")
    get() = getHasTrackingData()
    @JvmName("hasTrackingDataProperty")
    set(`value`) {
      setHasTrackingData(value)
    }

  /**
   * The name of this pose. Usually, this name is derived from an action map set up by the user.
   * Godot also suggests some pose names that [XRInterface] objects are expected to implement:
   *
   * - `root` is the root location, often used for tracked objects that do not have further nodes.
   *
   * - `aim` is the tip of a controller with its orientation pointing outwards, often used for
   * raycasts.
   *
   * - `grip` is the location where the user grips the controller.
   *
   * - `skeleton` is the root location for a hand mesh, when using hand tracking and an animated
   * skeleton is supplied by the XR runtime.
   */
  public final inline var name: StringName
    @JvmName("nameProperty")
    get() = getName()
    @JvmName("nameProperty")
    set(`value`) {
      setName(value)
    }

  /**
   * The transform containing the original and transform as reported by the XR runtime.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var transform: Transform3D
    @JvmName("transformProperty")
    get() = getTransform()
    @JvmName("transformProperty")
    set(`value`) {
      setTransform(value)
    }

  /**
   * The linear velocity of this pose.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var linearVelocity: Vector3
    @JvmName("linearVelocityProperty")
    get() = getLinearVelocity()
    @JvmName("linearVelocityProperty")
    set(`value`) {
      setLinearVelocity(value)
    }

  /**
   * The angular velocity for this pose.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  public final inline var angularVelocity: Vector3
    @JvmName("angularVelocityProperty")
    get() = getAngularVelocity()
    @JvmName("angularVelocityProperty")
    set(`value`) {
      setAngularVelocity(value)
    }

  /**
   * The tracking confidence for this pose, provides insight on how accurate the spatial positioning
   * of this record is.
   */
  public final inline var trackingConfidence: TrackingConfidence
    @JvmName("trackingConfidenceProperty")
    get() = getTrackingConfidence()
    @JvmName("trackingConfidenceProperty")
    set(`value`) {
      setTrackingConfidence(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(950, scriptPtr)
  }

  /**
   * This is a helper function for [transform] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = xrpose.transform
   * //Your changes
   * xrpose.transform = myCoreType
   * ``````
   *
   * The transform containing the original and transform as reported by the XR runtime.
   */
  @CoreTypeHelper
  public final fun transformMutate(block: Transform3D.() -> Unit): Transform3D = transform.apply {
     block(this)
     transform = this
  }

  /**
   * This is a helper function for [linearVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = xrpose.linearVelocity
   * //Your changes
   * xrpose.linearVelocity = myCoreType
   * ``````
   *
   * The linear velocity of this pose.
   */
  @CoreTypeHelper
  public final fun linearVelocityMutate(block: Vector3.() -> Unit): Vector3 = linearVelocity.apply {
     block(this)
     linearVelocity = this
  }

  /**
   * This is a helper function for [angularVelocity] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = xrpose.angularVelocity
   * //Your changes
   * xrpose.angularVelocity = myCoreType
   * ``````
   *
   * The angular velocity for this pose.
   */
  @CoreTypeHelper
  public final fun angularVelocityMutate(block: Vector3.() -> Unit): Vector3 =
      angularVelocity.apply {
     block(this)
     angularVelocity = this
  }

  public final fun setHasTrackingData(hasTrackingData: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to hasTrackingData)
    TransferContext.callMethod(MethodBindings.setHasTrackingDataPtr)
  }

  public final fun getHasTrackingData(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHasTrackingDataPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  public final fun setName(name: StringName): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to name)
    TransferContext.callMethod(MethodBindings.setNamePtr)
  }

  public final fun getName(): StringName {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNamePtr)
    return (TransferContext.readReturnValue(STRING_NAME) as StringName)
  }

  public final fun setTransform(transform: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to transform)
    TransferContext.callMethod(MethodBindings.setTransformPtr)
  }

  public final fun getTransform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Returns the [transform] with world scale and our reference frame applied. This is the transform
   * used to position [XRNode3D] objects.
   */
  public final fun getAdjustedTransform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAdjustedTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  public final fun setLinearVelocity(velocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to velocity)
    TransferContext.callMethod(MethodBindings.setLinearVelocityPtr)
  }

  public final fun getLinearVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLinearVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setAngularVelocity(velocity: Vector3): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR3 to velocity)
    TransferContext.callMethod(MethodBindings.setAngularVelocityPtr)
  }

  public final fun getAngularVelocity(): Vector3 {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAngularVelocityPtr)
    return (TransferContext.readReturnValue(VECTOR3) as Vector3)
  }

  public final fun setTrackingConfidence(trackingConfidence: TrackingConfidence): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackingConfidence.value)
    TransferContext.callMethod(MethodBindings.setTrackingConfidencePtr)
  }

  public final fun getTrackingConfidence(): TrackingConfidence {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackingConfidencePtr)
    return TrackingConfidence.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun setName(name: String) = setName(name.asCachedStringName())

  public enum class TrackingConfidence(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No tracking information is available for this pose.
     */
    XR_NONE(0),
    /**
     * Tracking information may be inaccurate or estimated. For example, with inside out tracking
     * this would indicate a controller may be (partially) obscured.
     */
    XR_LOW(1),
    /**
     * Tracking information is considered accurate and up to date.
     */
    XR_HIGH(2),
    ;

    public companion object {
      public fun from(`value`: Long): TrackingConfidence = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setHasTrackingDataName: MethodStringName1<XRPose, Unit, Boolean> =
        MethodStringName1<XRPose, Unit, Boolean>("set_has_tracking_data")

    @JvmField
    public val getHasTrackingDataName: MethodStringName0<XRPose, Boolean> =
        MethodStringName0<XRPose, Boolean>("get_has_tracking_data")

    @JvmField
    public val setNameName: MethodStringName1<XRPose, Unit, StringName> =
        MethodStringName1<XRPose, Unit, StringName>("set_name")

    @JvmField
    public val getNameName: MethodStringName0<XRPose, StringName> =
        MethodStringName0<XRPose, StringName>("get_name")

    @JvmField
    public val setTransformName: MethodStringName1<XRPose, Unit, Transform3D> =
        MethodStringName1<XRPose, Unit, Transform3D>("set_transform")

    @JvmField
    public val getTransformName: MethodStringName0<XRPose, Transform3D> =
        MethodStringName0<XRPose, Transform3D>("get_transform")

    @JvmField
    public val getAdjustedTransformName: MethodStringName0<XRPose, Transform3D> =
        MethodStringName0<XRPose, Transform3D>("get_adjusted_transform")

    @JvmField
    public val setLinearVelocityName: MethodStringName1<XRPose, Unit, Vector3> =
        MethodStringName1<XRPose, Unit, Vector3>("set_linear_velocity")

    @JvmField
    public val getLinearVelocityName: MethodStringName0<XRPose, Vector3> =
        MethodStringName0<XRPose, Vector3>("get_linear_velocity")

    @JvmField
    public val setAngularVelocityName: MethodStringName1<XRPose, Unit, Vector3> =
        MethodStringName1<XRPose, Unit, Vector3>("set_angular_velocity")

    @JvmField
    public val getAngularVelocityName: MethodStringName0<XRPose, Vector3> =
        MethodStringName0<XRPose, Vector3>("get_angular_velocity")

    @JvmField
    public val setTrackingConfidenceName: MethodStringName1<XRPose, Unit, TrackingConfidence> =
        MethodStringName1<XRPose, Unit, TrackingConfidence>("set_tracking_confidence")

    @JvmField
    public val getTrackingConfidenceName: MethodStringName0<XRPose, TrackingConfidence> =
        MethodStringName0<XRPose, TrackingConfidence>("get_tracking_confidence")
  }

  public object MethodBindings {
    internal val setHasTrackingDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "set_has_tracking_data", 2586408642)

    internal val getHasTrackingDataPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "get_has_tracking_data", 36873697)

    internal val setNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "set_name", 3304788590)

    internal val getNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "get_name", 2002593661)

    internal val setTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "set_transform", 2952846383)

    internal val getTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "get_transform", 3229777777)

    internal val getAdjustedTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "get_adjusted_transform", 3229777777)

    internal val setLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "set_linear_velocity", 3460891852)

    internal val getLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "get_linear_velocity", 3360562783)

    internal val setAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "set_angular_velocity", 3460891852)

    internal val getAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "get_angular_velocity", 3360562783)

    internal val setTrackingConfidencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "set_tracking_confidence", 4171656666)

    internal val getTrackingConfidencePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRPose", "get_tracking_confidence", 2064923680)
  }
}
