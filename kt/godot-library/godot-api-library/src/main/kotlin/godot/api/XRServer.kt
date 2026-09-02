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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal2
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DICTIONARY
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.STRING
import godot.core.VariantParser.STRING_NAME
import godot.core.VariantParser.TRANSFORM3D
import godot.core.asCachedStringName
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmStatic

/**
 * The AR/VR server is the heart of our Advanced and Virtual Reality solution and handles all the
 * processing.
 */
@GodotBaseType
public object XRServer : Object() {
  @JvmField
  public val getWorldScaleName: MethodStringName0<XRServer, Double> =
      MethodStringName0<XRServer, Double>("get_world_scale")

  @JvmField
  public val setWorldScaleName: MethodStringName1<XRServer, Unit, Double> =
      MethodStringName1<XRServer, Unit, Double>("set_world_scale")

  @JvmField
  public val getWorldOriginName: MethodStringName0<XRServer, Transform3D> =
      MethodStringName0<XRServer, Transform3D>("get_world_origin")

  @JvmField
  public val setWorldOriginName: MethodStringName1<XRServer, Unit, Transform3D> =
      MethodStringName1<XRServer, Unit, Transform3D>("set_world_origin")

  @JvmField
  public val getReferenceFrameName: MethodStringName0<XRServer, Transform3D> =
      MethodStringName0<XRServer, Transform3D>("get_reference_frame")

  @JvmField
  public val clearReferenceFrameName: MethodStringName0<XRServer, Unit> =
      MethodStringName0<XRServer, Unit>("clear_reference_frame")

  @JvmField
  public val centerOnHmdName: MethodStringName2<XRServer, Unit, RotationMode, Boolean> =
      MethodStringName2<XRServer, Unit, RotationMode, Boolean>("center_on_hmd")

  @JvmField
  public val getHmdTransformName: MethodStringName0<XRServer, Transform3D> =
      MethodStringName0<XRServer, Transform3D>("get_hmd_transform")

  @JvmField
  public val setCameraLockedToOriginName: MethodStringName1<XRServer, Unit, Boolean> =
      MethodStringName1<XRServer, Unit, Boolean>("set_camera_locked_to_origin")

  @JvmField
  public val isCameraLockedToOriginName: MethodStringName0<XRServer, Boolean> =
      MethodStringName0<XRServer, Boolean>("is_camera_locked_to_origin")

  @JvmField
  public val addInterfaceName: MethodStringName1<XRServer, Unit, XRInterface?> =
      MethodStringName1<XRServer, Unit, XRInterface?>("add_interface")

  @JvmField
  public val getInterfaceCountName: MethodStringName0<XRServer, Int> =
      MethodStringName0<XRServer, Int>("get_interface_count")

  @JvmField
  public val removeInterfaceName: MethodStringName1<XRServer, Unit, XRInterface?> =
      MethodStringName1<XRServer, Unit, XRInterface?>("remove_interface")

  @JvmField
  public val getInterfaceName: MethodStringName1<XRServer, XRInterface?, Int> =
      MethodStringName1<XRServer, XRInterface?, Int>("get_interface")

  @JvmField
  public val getInterfacesName: MethodStringName0<XRServer, VariantArray<Dictionary<Any?, Any?>>> =
      MethodStringName0<XRServer, VariantArray<Dictionary<Any?, Any?>>>("get_interfaces")

  @JvmField
  public val findInterfaceName: MethodStringName1<XRServer, XRInterface?, String> =
      MethodStringName1<XRServer, XRInterface?, String>("find_interface")

  @JvmField
  public val addTrackerName: MethodStringName1<XRServer, Unit, XRTracker?> =
      MethodStringName1<XRServer, Unit, XRTracker?>("add_tracker")

  @JvmField
  public val removeTrackerName: MethodStringName1<XRServer, Unit, XRTracker?> =
      MethodStringName1<XRServer, Unit, XRTracker?>("remove_tracker")

  @JvmField
  public val getTrackersName: MethodStringName1<XRServer, Dictionary<Any?, Any?>, Int> =
      MethodStringName1<XRServer, Dictionary<Any?, Any?>, Int>("get_trackers")

  @JvmField
  public val getTrackerName: MethodStringName1<XRServer, XRTracker?, StringName> =
      MethodStringName1<XRServer, XRTracker?, StringName>("get_tracker")

  @JvmField
  public val getPrimaryInterfaceName: MethodStringName0<XRServer, XRInterface?> =
      MethodStringName0<XRServer, XRInterface?>("get_primary_interface")

  @JvmField
  public val setPrimaryInterfaceName: MethodStringName1<XRServer, Unit, XRInterface?> =
      MethodStringName1<XRServer, Unit, XRInterface?>("set_primary_interface")

  /**
   * Emitted when the reference frame transform changes.
   */
  @JvmStatic
  public val referenceFrameChanged: Signal0 by Signal0

  /**
   * Emitted when a new interface has been added.
   */
  @JvmStatic
  public val interfaceAdded: Signal1<StringName> by Signal1

  /**
   * Emitted when an interface is removed.
   */
  @JvmStatic
  public val interfaceRemoved: Signal1<StringName> by Signal1

  /**
   * Emitted when a new tracker has been added. If you don't use a fixed number of controllers or if
   * you're using [XRAnchor3D]s for an AR solution, it is important to react to this signal to add the
   * appropriate [XRController3D] or [XRAnchor3D] nodes related to this new tracker.
   */
  @JvmStatic
  public val trackerAdded: Signal2<StringName, Long> by Signal2

  /**
   * Emitted when an existing tracker has been updated. This can happen if the user switches
   * controllers.
   */
  @JvmStatic
  public val trackerUpdated: Signal2<StringName, Long> by Signal2

  /**
   * Emitted when a tracker is removed. You should remove any [XRController3D] or [XRAnchor3D]
   * points if applicable. This is not mandatory, the nodes simply become inactive and will be made
   * active again when a new tracker becomes available (i.e. a new controller is switched on that takes
   * the place of the previous one).
   */
  @JvmStatic
  public val trackerRemoved: Signal2<StringName, Long> by Signal2

  /**
   * Emitted when the world origin transform changes.
   */
  @JvmStatic
  public val worldOriginChanged: Signal0 by Signal0

  /**
   * The scale of the game world compared to the real world. By default, most AR/VR platforms assume
   * that 1 game unit corresponds to 1 real world meter.
   */
  @JvmStatic
  public final inline var worldScale: Double
    @JvmName("worldScaleProperty")
    get() = getWorldScale()
    @JvmName("worldScaleProperty")
    set(`value`) {
      setWorldScale(value)
    }

  /**
   * The current origin of our tracking space in the virtual world. This is used by the renderer to
   * properly position the camera with new tracking data.
   *
   * **Note:** This property is managed by the current [XROrigin3D] node. It is exposed for access
   * from GDExtensions.
   *
   * **Warning:**
   * Be careful when trying to modify a local
   * [copy](https://godot-jvm.dev/en/stable/user-guide/api-differences/#core-types) obtained from this
   * getter.
   * Mutating it alone won't have any effect on the actual property, it has to be reassigned again
   * afterward.
   */
  @CoreTypeLocalCopy
  @JvmStatic
  public final inline var worldOrigin: Transform3D
    @JvmName("worldOriginProperty")
    get() = getWorldOrigin()
    @JvmName("worldOriginProperty")
    set(`value`) {
      setWorldOrigin(value)
    }

  /**
   * If set to `true`, the scene will be rendered as if the camera is locked to the [XROrigin3D].
   *
   * **Note:** This doesn't provide a very comfortable experience for users. This setting exists for
   * doing benchmarking or automated testing, where you want to control what is rendered via code.
   */
  @JvmStatic
  public final inline var cameraLockedToOrigin: Boolean
    @JvmName("cameraLockedToOriginProperty")
    get() = isCameraLockedToOrigin()
    @JvmName("cameraLockedToOriginProperty")
    set(`value`) {
      setCameraLockedToOrigin(value)
    }

  /**
   * The primary [XRInterface] currently bound to the [XRServer].
   */
  @JvmStatic
  public final inline var primaryInterface: XRInterface?
    @JvmName("primaryInterfaceProperty")
    get() = getPrimaryInterface()
    @JvmName("primaryInterfaceProperty")
    set(`value`) {
      setPrimaryInterface(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(38)
  }

  /**
   * This is a helper function for [worldOrigin] to make dealing with local copies easier.
   * Allow to directly modify the local copy of the property and assign it back to the Object.
   *
   * Prefer that over writing:
   * ``````
   * val myCoreType = xrserver.worldOrigin
   * //Your changes
   * xrserver.worldOrigin = myCoreType
   * ``````
   *
   * The current origin of our tracking space in the virtual world. This is used by the renderer to
   * properly position the camera with new tracking data.
   *
   * **Note:** This property is managed by the current [XROrigin3D] node. It is exposed for access
   * from GDExtensions.
   */
  @CoreTypeHelper
  public final fun worldOriginMutate(block: Transform3D.() -> Unit): Transform3D =
      worldOrigin.apply {
     block(this)
     worldOrigin = this
  }

  @JvmStatic
  public final fun getWorldScale(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWorldScalePtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  @JvmStatic
  public final fun setWorldScale(scale: Double): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, DOUBLE to scale)
    TransferContext.callMethod(MethodBindings.setWorldScalePtr)
  }

  @JvmStatic
  public final fun getWorldOrigin(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getWorldOriginPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  @JvmStatic
  public final fun setWorldOrigin(worldOrigin: Transform3D): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, TRANSFORM3D to worldOrigin)
    TransferContext.callMethod(MethodBindings.setWorldOriginPtr)
  }

  /**
   * Returns the reference frame transform. Mostly used internally and exposed for GDExtension build
   * interfaces.
   */
  @JvmStatic
  public final fun getReferenceFrame(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReferenceFramePtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  /**
   * Clears the reference frame that was set by previous calls to [centerOnHmd].
   */
  @JvmStatic
  public final fun clearReferenceFrame(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.clearReferenceFramePtr)
  }

  /**
   * This is an important function to understand correctly. AR and VR platforms all handle
   * positioning slightly differently.
   *
   * For platforms that do not offer spatial tracking, our origin point `(0, 0, 0)` is the location
   * of our HMD, but you have little control over the direction the player is facing in the real world.
   *
   * For platforms that do offer spatial tracking, our origin point depends very much on the system.
   * For OpenVR, our origin point is usually the center of the tracking space, on the ground. For other
   * platforms, it's often the location of the tracking camera.
   *
   * This method allows you to center your tracker on the location of the HMD. It will take the
   * current location of the HMD and use that to adjust all your tracking data; in essence, realigning
   * the real world to your player's current position in the game world.
   *
   * For this method to produce usable results, tracking information must be available. This often
   * takes a few frames after starting your game.
   *
   * You should call this method after a few seconds have passed. For example, when the user
   * requests a realignment of the display holding a designated button on a controller for a short
   * period of time, or when implementing a teleport mechanism.
   */
  @JvmStatic
  public final fun centerOnHmd(rotationMode: RotationMode, keepHeight: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to rotationMode.value, BOOL to keepHeight)
    TransferContext.callMethod(MethodBindings.centerOnHmdPtr)
  }

  /**
   * Returns the primary interface's transformation.
   */
  @JvmStatic
  public final fun getHmdTransform(): Transform3D {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getHmdTransformPtr)
    return (TransferContext.readReturnValue(TRANSFORM3D) as Transform3D)
  }

  @JvmStatic
  public final fun setCameraLockedToOrigin(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setCameraLockedToOriginPtr)
  }

  @JvmStatic
  public final fun isCameraLockedToOrigin(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isCameraLockedToOriginPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Registers an [XRInterface] object.
   */
  @JvmStatic
  public final fun addInterface(`interface`: XRInterface?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to `interface`)
    TransferContext.callMethod(MethodBindings.addInterfacePtr)
  }

  /**
   * Returns the number of interfaces currently registered with the AR/VR server. If your project
   * supports multiple AR/VR platforms, you can look through the available interface, and either
   * present the user with a selection or simply try to initialize each interface and use the first one
   * that returns `true`.
   */
  @JvmStatic
  public final fun getInterfaceCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInterfaceCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Removes this [interface].
   */
  @JvmStatic
  public final fun removeInterface(`interface`: XRInterface?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to `interface`)
    TransferContext.callMethod(MethodBindings.removeInterfacePtr)
  }

  /**
   * Returns the interface registered at the given [idx] index in the list of interfaces.
   */
  @JvmStatic
  public final fun getInterface(idx: Int): XRInterface? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to idx.toLong())
    TransferContext.callMethod(MethodBindings.getInterfacePtr)
    return (TransferContext.readReturnValue(OBJECT) as XRInterface?)
  }

  /**
   * Returns a list of available interfaces the ID and name of each interface.
   */
  @JvmStatic
  public final fun getInterfaces(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInterfacesPtr)
    return (TransferContext.readReturnValue(ARRAY) as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Finds an interface by its [name]. For example, if your project uses capabilities of an AR/VR
   * platform, you can find the interface for that platform by name and initialize it.
   */
  @JvmStatic
  public final fun findInterface(name: String): XRInterface? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.findInterfacePtr)
    return (TransferContext.readReturnValue(OBJECT) as XRInterface?)
  }

  /**
   * Registers a new [XRTracker] that tracks a physical object.
   */
  @JvmStatic
  public final fun addTracker(tracker: XRTracker?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to tracker)
    TransferContext.callMethod(MethodBindings.addTrackerPtr)
  }

  /**
   * Removes this [tracker].
   */
  @JvmStatic
  public final fun removeTracker(tracker: XRTracker?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to tracker)
    TransferContext.callMethod(MethodBindings.removeTrackerPtr)
  }

  /**
   * Returns a dictionary of trackers for [trackerTypes].
   */
  @JvmStatic
  public final fun getTrackers(trackerTypes: Int): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to trackerTypes.toLong())
    TransferContext.callMethod(MethodBindings.getTrackersPtr)
    return (TransferContext.readReturnValue(DICTIONARY) as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the positional tracker with the given [trackerName].
   */
  @JvmStatic
  public final fun getTracker(trackerName: StringName): XRTracker? {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING_NAME to trackerName)
    TransferContext.callMethod(MethodBindings.getTrackerPtr)
    return (TransferContext.readReturnValue(OBJECT) as XRTracker?)
  }

  @JvmStatic
  public final fun getPrimaryInterface(): XRInterface? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPrimaryInterfacePtr)
    return (TransferContext.readReturnValue(OBJECT) as XRInterface?)
  }

  @JvmStatic
  public final fun setPrimaryInterface(`interface`: XRInterface?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to `interface`)
    TransferContext.callMethod(MethodBindings.setPrimaryInterfacePtr)
  }

  /**
   * Returns the positional tracker with the given [trackerName].
   */
  @JvmStatic
  public final fun getTracker(trackerName: String): XRTracker? =
      getTracker(trackerName.asCachedStringName())

  public enum class TrackerType(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The tracker tracks the location of the player's head. This is usually a location centered
     * between the player's eyes. Note that for handheld AR devices this can be the current location of
     * the device.
     */
    HEAD(1),
    /**
     * The tracker tracks the location of a controller.
     */
    CONTROLLER(2),
    /**
     * The tracker tracks the location of a base station.
     */
    BASESTATION(4),
    /**
     * The tracker tracks the location and size of an AR anchor.
     */
    ANCHOR(8),
    /**
     * The tracker tracks the location and joints of a hand.
     */
    HAND(16),
    /**
     * The tracker tracks the location and joints of a body.
     */
    BODY(32),
    /**
     * The tracker tracks the expressions of a face.
     */
    FACE(64),
    /**
     * Used internally to filter trackers of any known type.
     */
    ANY_KNOWN(127),
    /**
     * Used internally if we haven't set the tracker type yet.
     */
    UNKNOWN(128),
    /**
     * Used internally to select all trackers.
     */
    ANY(255),
    ;

    public companion object {
      public fun from(`value`: Long): TrackerType = entries.single { it.`value` == `value` }
    }
  }

  public enum class RotationMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Fully reset the orientation of the HMD. Regardless of what direction the user is looking to
     * in the real world. The user will look dead ahead in the virtual world.
     */
    RESET_FULL_ROTATION(0),
    /**
     * Resets the orientation but keeps the tilt of the device. So if we're looking down, we keep
     * looking down but heading will be reset.
     */
    RESET_BUT_KEEP_TILT(1),
    /**
     * Does not reset the orientation of the HMD, only the position of the player gets centered.
     */
    DONT_RESET_ROTATION(2),
    ;

    public companion object {
      public fun from(`value`: Long): RotationMode = entries.single { it.`value` == `value` }
    }
  }

  public object MethodBindings {
    internal val getWorldScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_world_scale", 1740695150)

    internal val setWorldScalePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "set_world_scale", 373806689)

    internal val getWorldOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_world_origin", 3229777777)

    internal val setWorldOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "set_world_origin", 2952846383)

    internal val getReferenceFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_reference_frame", 3229777777)

    internal val clearReferenceFramePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "clear_reference_frame", 3218959716)

    internal val centerOnHmdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "center_on_hmd", 1450904707)

    internal val getHmdTransformPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_hmd_transform", 4183770049)

    internal val setCameraLockedToOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "set_camera_locked_to_origin", 2586408642)

    internal val isCameraLockedToOriginPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "is_camera_locked_to_origin", 36873697)

    internal val addInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "add_interface", 1898711491)

    internal val getInterfaceCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_interface_count", 3905245786)

    internal val removeInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "remove_interface", 1898711491)

    internal val getInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_interface", 4237347919)

    internal val getInterfacesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_interfaces", 3995934104)

    internal val findInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "find_interface", 1395192955)

    internal val addTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "add_tracker", 684804553)

    internal val removeTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "remove_tracker", 684804553)

    internal val getTrackersPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_trackers", 3554694381)

    internal val getTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_tracker", 147382240)

    internal val getPrimaryInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "get_primary_interface", 2143545064)

    internal val setPrimaryInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRServer", "set_primary_interface", 1898711491)
  }
}
