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
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.MethodStringName6
import godot.core.PackedVector3Array
import godot.core.Projection
import godot.core.Signal1
import godot.core.StringName
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.asCachedStringName
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_VECTOR3_ARRAY
import godot.readReturnValue_PROJECTION
import godot.readReturnValue_STRING_NAME
import godot.readReturnValue_TRANSFORM3D
import godot.readReturnValue_VECTOR2
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_DOUBLE_DOUBLE_DOUBLE
import godot.writeMethodArguments_LONG_TRANSFORM3D
import godot.writeMethodArguments_STRING_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE
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

/**
 * This class needs to be implemented to make an AR or VR platform available to Godot and these
 * should be implemented as C++ modules or GDExtension modules. Part of the interface is exposed to
 * GDScript so you can detect, enable and configure an AR or VR platform.
 *
 * Interfaces should be written in such a way that simply enabling them will give us a working
 * setup. You can query the available interfaces through [XRServer].
 */
@GodotBaseType
public open class XRInterface internal constructor() : RefCounted() {
  /**
   * Emitted when the play area is changed. This can be a result of the player resetting the
   * boundary or entering a new play area, the player changing the play area mode, the world scale
   * changing or the player resetting their headset orientation.
   */
  public val playAreaChanged: Signal1<Long> by Signal1

  /**
   * `true` if this is the primary interface.
   */
  public final inline var interfaceIsPrimary: Boolean
    @JvmName("interfaceIsPrimaryProperty")
    get() = isPrimary()
    @JvmName("interfaceIsPrimaryProperty")
    set(`value`) {
      setPrimary(value)
    }

  /**
   * The play area mode for this interface.
   */
  public final inline val xrPlayAreaMode: PlayAreaMode
    @JvmName("xrPlayAreaModeProperty")
    get() = getPlayAreaMode()

  /**
   * Specify how XR should blend in the environment. This is specific to certain AR and passthrough
   * devices where camera images are blended in by the XR compositor.
   */
  public final inline val environmentBlendMode: EnvironmentBlendMode
    @JvmName("environmentBlendModeProperty")
    get() = getEnvironmentBlendMode()

  /**
   * On an AR interface, `true` if anchor detection is enabled.
   */
  public final inline var arIsAnchorDetectionEnabled: Boolean
    @JvmName("arIsAnchorDetectionEnabledProperty")
    get() = getAnchorDetectionIsEnabled()
    @JvmName("arIsAnchorDetectionEnabledProperty")
    set(`value`) {
      setAnchorDetectionIsEnabled(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(946, scriptPtr)
  }

  /**
   * Returns the name of this interface (`"OpenXR"`, `"OpenVR"`, `"OpenHMD"`, `"ARKit"`, etc.).
   */
  public final fun getName(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns a combination of [Capabilities] flags providing information about the capabilities of
   * this interface.
   */
  public final fun getCapabilities(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCapabilitiesPtr)
    return TransferContext.readReturnValue_LONG()
  }

  public final fun isPrimary(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPrimaryPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setPrimary(primary: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, primary)
    TransferContext.callMethod(MethodBindings.setPrimaryPtr)
  }

  /**
   * Returns `true` if this interface has been initialized.
   */
  public final fun isInitialized(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isInitializedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Call this to initialize this interface. The first interface that is initialized is identified
   * as the primary interface and it will be used for rendering output.
   *
   * After initializing the interface you want to use you then need to enable the AR/VR mode of a
   * viewport and rendering should commence.
   *
   * **Note:** You must enable the XR mode on the main viewport for any device that uses the main
   * output of Godot, such as for mobile VR.
   *
   * If you do this for a platform that handles its own output (such as OpenVR) Godot will show just
   * one eye without distortion on screen. Alternatively, you can add a separate viewport node to your
   * scene and enable AR/VR on that viewport. It will be used to output to the HMD, leaving you free to
   * do anything you like in the main window, such as using a separate camera as a spectator camera or
   * rendering something completely different.
   *
   * While currently not used, you can activate additional interfaces. You may wish to do this if
   * you want to track controllers from other platforms. However, at this point in time only one
   * interface can render to an HMD.
   */
  public final fun initialize(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.initializePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Turns the interface off.
   */
  public final fun uninitialize(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.uninitializePtr)
  }

  /**
   * Returns a [Dictionary] with extra system info. Interfaces are expected to return
   * `XRRuntimeName` and `XRRuntimeVersion` providing info about the used XR runtime. Additional
   * entries may be provided specific to an interface.
   *
   * **Note:**This information may only be available after [initialize] was successfully called.
   */
  public final fun getSystemInfo(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSystemInfoPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * If supported, returns the status of our tracking. This will allow you to provide feedback to
   * the user whether there are issues with positional tracking.
   */
  public final fun getTrackingStatus(): TrackingStatus {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getTrackingStatusPtr)
    return TrackingStatus.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the resolution at which we should render our intermediate results before things like
   * lens distortion are applied by the VR platform.
   */
  public final fun getRenderTargetSize(): Vector2 {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderTargetSizePtr)
    return TransferContext.readReturnValue_VECTOR2()
  }

  /**
   * Returns the number of views that need to be rendered for this device. 1 for Monoscopic, 2 for
   * Stereoscopic.
   */
  public final fun getViewCount(): Long {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getViewCountPtr)
    return TransferContext.readReturnValue_LONG()
  }

  /**
   * Triggers a haptic pulse on a device associated with this interface.
   *
   * [actionName] is the name of the action for this pulse.
   *
   * [trackerName] is optional and can be used to direct the pulse to a specific device provided
   * that device is bound to this haptic.
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
    trackerName: StringName,
    frequency: Double,
    amplitude: Double,
    durationSec: Double,
    delaySec: Double,
  ): Unit {
    TransferContext.writeMethodArguments_STRING_STRING_NAME_DOUBLE_DOUBLE_DOUBLE_DOUBLE(ptr, objectID.id, actionName, trackerName, frequency, amplitude, durationSec, delaySec)
    TransferContext.callMethod(MethodBindings.triggerHapticPulsePtr)
  }

  /**
   * Call this to find out if a given play area mode is supported by this interface.
   */
  public final fun supportsPlayAreaMode(mode: PlayAreaMode): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.supportsPlayAreaModePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getPlayAreaMode(): PlayAreaMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlayAreaModePtr)
    return PlayAreaMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Sets the active play area mode, will return `false` if the mode can't be used with this
   * interface.
   *
   * **Note:** Changing this after the interface has already been initialized can be jarring for the
   * player, so it's recommended to recenter on the HMD with [XRServer.centerOnHmd] (if switching to
   * [XRInterface.XR_PLAY_AREA_STAGE]) or make the switch during a scene change.
   */
  public final fun setPlayAreaMode(mode: PlayAreaMode): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setPlayAreaModePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns an array of vectors that represent the physical play area mapped to the virtual space
   * around the [XROrigin3D] point. The points form a convex polygon that can be used to react to or
   * visualize the play area. This returns an empty array if this feature is not supported or if the
   * information is not yet available.
   */
  public final fun getPlayArea(): PackedVector3Array {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlayAreaPtr)
    return TransferContext.readReturnValue_PACKED_VECTOR3_ARRAY()
  }

  public final fun getAnchorDetectionIsEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAnchorDetectionIsEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setAnchorDetectionIsEnabled(enable: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enable)
    TransferContext.callMethod(MethodBindings.setAnchorDetectionIsEnabledPtr)
  }

  /**
   * If this is an AR interface that requires displaying a camera feed as the background, this
   * method returns the feed ID in the [CameraServer] for this interface.
   */
  public final fun getCameraFeedId(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getCameraFeedIdPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns `true` if this interface supports passthrough.
   */
  public final fun isPassthroughSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPassthroughSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if passthrough is enabled.
   */
  public final fun isPassthroughEnabled(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isPassthroughEnabledPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Starts passthrough, will return `false` if passthrough couldn't be started.
   *
   * **Note:** The viewport used for XR must have a transparent background, otherwise passthrough
   * may not properly render.
   */
  public final fun startPassthrough(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.startPassthroughPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Stops passthrough.
   */
  public final fun stopPassthrough(): Unit {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.stopPassthroughPtr)
  }

  /**
   * Returns the transform for a view/eye.
   *
   * [view] is the view/eye index.
   *
   * [camTransform] is the transform that maps device coordinates to scene coordinates, typically
   * the [Node3D.globalTransform] of the current XROrigin3D.
   */
  public final fun getTransformForView(view: Long, camTransform: Transform3D): Transform3D {
    TransferContext.writeMethodArguments_LONG_TRANSFORM3D(ptr, objectID.id, view, camTransform)
    TransferContext.callMethod(MethodBindings.getTransformForViewPtr)
    return TransferContext.readReturnValue_TRANSFORM3D()
  }

  /**
   * Returns the projection matrix for a view/eye.
   */
  public final fun getProjectionForView(
    view: Long,
    aspect: Double,
    near: Double,
    far: Double,
  ): Projection {
    TransferContext.writeMethodArguments_LONG_DOUBLE_DOUBLE_DOUBLE(ptr, objectID.id, view, aspect, near, far)
    TransferContext.callMethod(MethodBindings.getProjectionForViewPtr)
    return TransferContext.readReturnValue_PROJECTION()
  }

  /**
   * Returns the an array of supported environment blend modes, see
   * [XRInterface.EnvironmentBlendMode].
   */
  public final fun getSupportedEnvironmentBlendModes(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportedEnvironmentBlendModesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Sets the active environment blend mode.
   *
   * [mode] is the environment blend mode starting with the next frame.
   *
   * **Note:** Not all runtimes support all environment blend modes, so it is important to check
   * this at startup. For example:
   *
   * ```
   * func _ready():
   * 	var xr_interface = XRServer.find_interface("OpenXR")
   * 	if xr_interface and xr_interface.is_initialized():
   * 		var vp = get_viewport()
   * 		vp.use_xr = true
   * 		var acceptable_modes = [XRInterface.XR_ENV_BLEND_MODE_OPAQUE,
   * XRInterface.XR_ENV_BLEND_MODE_ADDITIVE]
   * 		var modes = xr_interface.get_supported_environment_blend_modes()
   * 		for mode in acceptable_modes:
   * 			if mode in modes:
   * 				xr_interface.set_environment_blend_mode(mode)
   * 				break
   * ```
   */
  public final fun setEnvironmentBlendMode(mode: EnvironmentBlendMode): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, mode.value)
    TransferContext.callMethod(MethodBindings.setEnvironmentBlendModePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getEnvironmentBlendMode(): EnvironmentBlendMode {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnvironmentBlendModePtr)
    return EnvironmentBlendMode.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Triggers a haptic pulse on a device associated with this interface.
   *
   * [actionName] is the name of the action for this pulse.
   *
   * [trackerName] is optional and can be used to direct the pulse to a specific device provided
   * that device is bound to this haptic.
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
    trackerName: String,
    frequency: Double,
    amplitude: Double,
    durationSec: Double,
    delaySec: Double,
  ) =
      triggerHapticPulse(actionName, trackerName.asCachedStringName(), frequency, amplitude, durationSec, delaySec)

  public enum class Capabilities(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * No XR capabilities.
     */
    XR_NONE(0),
    /**
     * This interface can work with normal rendering output (non-HMD based AR).
     */
    XR_MONO(1),
    /**
     * This interface supports stereoscopic rendering.
     */
    XR_STEREO(2),
    /**
     * This interface supports quad rendering (not yet supported by Godot).
     */
    XR_QUAD(4),
    /**
     * This interface supports VR.
     */
    XR_VR(8),
    /**
     * This interface supports AR (video background and real world tracking).
     */
    XR_AR(16),
    /**
     * This interface outputs to an external device. If the main viewport is used, the on screen
     * output is an unmodified buffer of either the left or right eye (stretched if the viewport size
     * is not changed to the same aspect ratio of [getRenderTargetSize]). Using a separate viewport
     * node frees up the main viewport for other purposes.
     */
    XR_EXTERNAL(32),
    ;

    public companion object {
      public fun from(`value`: Long): Capabilities = entries.single { it.`value` == `value` }
    }
  }

  public enum class TrackingStatus(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Tracking is behaving as expected.
     */
    XR_NORMAL_TRACKING(0),
    /**
     * Tracking is hindered by excessive motion (the player is moving faster than tracking can keep
     * up).
     */
    XR_EXCESSIVE_MOTION(1),
    /**
     * Tracking is hindered by insufficient features, it's too dark (for camera-based tracking),
     * player is blocked, etc.
     */
    XR_INSUFFICIENT_FEATURES(2),
    /**
     * We don't know the status of the tracking or this interface does not provide feedback.
     */
    XR_UNKNOWN_TRACKING(3),
    /**
     * Tracking is not functional (camera not plugged in or obscured, lighthouses turned off, etc.).
     */
    XR_NOT_TRACKING(4),
    ;

    public companion object {
      public fun from(`value`: Long): TrackingStatus = entries.single { it.`value` == `value` }
    }
  }

  public enum class PlayAreaMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Play area mode not set or not available.
     */
    XR_PLAY_AREA_UNKNOWN(0),
    /**
     * Play area only supports orientation tracking, no positional tracking, area will center around
     * player.
     */
    XR_PLAY_AREA_3DOF(1),
    /**
     * Player is in seated position, limited positional tracking, fixed guardian around player.
     */
    XR_PLAY_AREA_SITTING(2),
    /**
     * Player is free to move around, full positional tracking.
     */
    XR_PLAY_AREA_ROOMSCALE(3),
    /**
     * Same as [XR_PLAY_AREA_ROOMSCALE] but origin point is fixed to the center of the physical
     * space. In this mode, system-level recentering may be disabled, requiring the use of
     * [XRServer.centerOnHmd].
     */
    XR_PLAY_AREA_STAGE(4),
    /**
     * Custom play area set by a GDExtension.
     */
    XR_PLAY_AREA_CUSTOM(2147483647),
    ;

    public companion object {
      public fun from(`value`: Long): PlayAreaMode = entries.single { it.`value` == `value` }
    }
  }

  public enum class EnvironmentBlendMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Opaque blend mode. This is typically used for VR devices.
     */
    XR_ENV_BLEND_MODE_OPAQUE(0),
    /**
     * Additive blend mode. This is typically used for AR devices or VR devices with passthrough.
     */
    XR_ENV_BLEND_MODE_ADDITIVE(1),
    /**
     * Alpha blend mode. This is typically used for AR or VR devices with passthrough capabilities.
     * The alpha channel controls how much of the passthrough is visible. Alpha of 0.0 means the
     * passthrough is visible and this pixel works in ADDITIVE mode. Alpha of 1.0 means that the
     * passthrough is not visible and this pixel works in OPAQUE mode.
     */
    XR_ENV_BLEND_MODE_ALPHA_BLEND(2),
    ;

    public companion object {
      public fun from(`value`: Long): EnvironmentBlendMode =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class VRSTextureFormat(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The texture format is the same as returned by [XRVRS.makeVrsTexture].
     */
    XR_UNIFIED(0),
    /**
     * The texture format is the same as expected by the Vulkan `VK_KHR_fragment_shading_rate`
     * extension.
     */
    XR_FRAGMENT_SHADING_RATE(1),
    /**
     * The texture format is the same as expected by the Vulkan `VK_EXT_fragment_density_map`
     * extension.
     */
    XR_FRAGMENT_DENSITY_MAP(2),
    ;

    public companion object {
      public fun from(`value`: Long): VRSTextureFormat = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getNameName: MethodStringName0<XRInterface, StringName> =
        MethodStringName0<XRInterface, StringName>("get_name")

    @JvmField
    public val getCapabilitiesName: MethodStringName0<XRInterface, Long> =
        MethodStringName0<XRInterface, Long>("get_capabilities")

    @JvmField
    public val isPrimaryName: MethodStringName0<XRInterface, Boolean> =
        MethodStringName0<XRInterface, Boolean>("is_primary")

    @JvmField
    public val setPrimaryName: MethodStringName1<XRInterface, Unit, Boolean> =
        MethodStringName1<XRInterface, Unit, Boolean>("set_primary")

    @JvmField
    public val isInitializedName: MethodStringName0<XRInterface, Boolean> =
        MethodStringName0<XRInterface, Boolean>("is_initialized")

    @JvmField
    public val initializeName: MethodStringName0<XRInterface, Boolean> =
        MethodStringName0<XRInterface, Boolean>("initialize")

    @JvmField
    public val uninitializeName: MethodStringName0<XRInterface, Unit> =
        MethodStringName0<XRInterface, Unit>("uninitialize")

    @JvmField
    public val getSystemInfoName: MethodStringName0<XRInterface, Dictionary<Any?, Any?>> =
        MethodStringName0<XRInterface, Dictionary<Any?, Any?>>("get_system_info")

    @JvmField
    public val getTrackingStatusName: MethodStringName0<XRInterface, TrackingStatus> =
        MethodStringName0<XRInterface, TrackingStatus>("get_tracking_status")

    @JvmField
    public val getRenderTargetSizeName: MethodStringName0<XRInterface, Vector2> =
        MethodStringName0<XRInterface, Vector2>("get_render_target_size")

    @JvmField
    public val getViewCountName: MethodStringName0<XRInterface, Long> =
        MethodStringName0<XRInterface, Long>("get_view_count")

    @JvmField
    public val triggerHapticPulseName:
        MethodStringName6<XRInterface, Unit, String, StringName, Double, Double, Double, Double> =
        MethodStringName6<XRInterface, Unit, String, StringName, Double, Double, Double, Double>("trigger_haptic_pulse")

    @JvmField
    public val supportsPlayAreaModeName: MethodStringName1<XRInterface, Boolean, PlayAreaMode> =
        MethodStringName1<XRInterface, Boolean, PlayAreaMode>("supports_play_area_mode")

    @JvmField
    public val getPlayAreaModeName: MethodStringName0<XRInterface, PlayAreaMode> =
        MethodStringName0<XRInterface, PlayAreaMode>("get_play_area_mode")

    @JvmField
    public val setPlayAreaModeName: MethodStringName1<XRInterface, Boolean, PlayAreaMode> =
        MethodStringName1<XRInterface, Boolean, PlayAreaMode>("set_play_area_mode")

    @JvmField
    public val getPlayAreaName: MethodStringName0<XRInterface, PackedVector3Array> =
        MethodStringName0<XRInterface, PackedVector3Array>("get_play_area")

    @JvmField
    public val getAnchorDetectionIsEnabledName: MethodStringName0<XRInterface, Boolean> =
        MethodStringName0<XRInterface, Boolean>("get_anchor_detection_is_enabled")

    @JvmField
    public val setAnchorDetectionIsEnabledName: MethodStringName1<XRInterface, Unit, Boolean> =
        MethodStringName1<XRInterface, Unit, Boolean>("set_anchor_detection_is_enabled")

    @JvmField
    public val getCameraFeedIdName: MethodStringName0<XRInterface, Int> =
        MethodStringName0<XRInterface, Int>("get_camera_feed_id")

    @JvmField
    public val isPassthroughSupportedName: MethodStringName0<XRInterface, Boolean> =
        MethodStringName0<XRInterface, Boolean>("is_passthrough_supported")

    @JvmField
    public val isPassthroughEnabledName: MethodStringName0<XRInterface, Boolean> =
        MethodStringName0<XRInterface, Boolean>("is_passthrough_enabled")

    @JvmField
    public val startPassthroughName: MethodStringName0<XRInterface, Boolean> =
        MethodStringName0<XRInterface, Boolean>("start_passthrough")

    @JvmField
    public val stopPassthroughName: MethodStringName0<XRInterface, Unit> =
        MethodStringName0<XRInterface, Unit>("stop_passthrough")

    @JvmField
    public val getTransformForViewName:
        MethodStringName2<XRInterface, Transform3D, Long, Transform3D> =
        MethodStringName2<XRInterface, Transform3D, Long, Transform3D>("get_transform_for_view")

    @JvmField
    public val getProjectionForViewName:
        MethodStringName4<XRInterface, Projection, Long, Double, Double, Double> =
        MethodStringName4<XRInterface, Projection, Long, Double, Double, Double>("get_projection_for_view")

    @JvmField
    public val getSupportedEnvironmentBlendModesName:
        MethodStringName0<XRInterface, VariantArray<Any?>> =
        MethodStringName0<XRInterface, VariantArray<Any?>>("get_supported_environment_blend_modes")

    @JvmField
    public val setEnvironmentBlendModeName:
        MethodStringName1<XRInterface, Boolean, EnvironmentBlendMode> =
        MethodStringName1<XRInterface, Boolean, EnvironmentBlendMode>("set_environment_blend_mode")

    @JvmField
    public val getEnvironmentBlendModeName: MethodStringName0<XRInterface, EnvironmentBlendMode> =
        MethodStringName0<XRInterface, EnvironmentBlendMode>("get_environment_blend_mode")
  }

  public object MethodBindings {
    internal val getNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_name", 2002593661)

    internal val getCapabilitiesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_capabilities", 3905245786)

    internal val isPrimaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "is_primary", 2240911060)

    internal val setPrimaryPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "set_primary", 2586408642)

    internal val isInitializedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "is_initialized", 36873697)

    internal val initializePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "initialize", 2240911060)

    internal val uninitializePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "uninitialize", 3218959716)

    internal val getSystemInfoPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_system_info", 2382534195)

    internal val getTrackingStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_tracking_status", 167423259)

    internal val getRenderTargetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_render_target_size", 1497962370)

    internal val getViewCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_view_count", 2455072627)

    internal val triggerHapticPulsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "trigger_haptic_pulse", 3752640163)

    internal val supportsPlayAreaModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "supports_play_area_mode", 3429955281)

    internal val getPlayAreaModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_play_area_mode", 1615132885)

    internal val setPlayAreaModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "set_play_area_mode", 3429955281)

    internal val getPlayAreaPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_play_area", 497664490)

    internal val getAnchorDetectionIsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_anchor_detection_is_enabled", 36873697)

    internal val setAnchorDetectionIsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "set_anchor_detection_is_enabled", 2586408642)

    internal val getCameraFeedIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_camera_feed_id", 2455072627)

    internal val isPassthroughSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "is_passthrough_supported", 2240911060)

    internal val isPassthroughEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "is_passthrough_enabled", 2240911060)

    internal val startPassthroughPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "start_passthrough", 2240911060)

    internal val stopPassthroughPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "stop_passthrough", 3218959716)

    internal val getTransformForViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_transform_for_view", 518934792)

    internal val getProjectionForViewPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_projection_for_view", 3766090294)

    internal val getSupportedEnvironmentBlendModesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_supported_environment_blend_modes", 2915620761)

    internal val setEnvironmentBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "set_environment_blend_mode", 551152418)

    internal val getEnvironmentBlendModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterface", "get_environment_blend_mode", 1984334071)
  }
}
