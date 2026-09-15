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
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal2
import godot.core.VariantArray
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

/**
 * WebXR is an open standard that allows creating VR and AR applications that run in the web
 * browser.
 *
 * As such, this interface is only available when running in Web exports.
 *
 * WebXR supports a wide range of devices, from the very capable (like Valve Index, HTC Vive, Oculus
 * Rift and Quest) down to the much less capable (like Google Cardboard, Oculus Go, GearVR, or plain
 * smartphones).
 *
 * Since WebXR is based on JavaScript, it makes extensive use of callbacks, which means that
 * [WebXRInterface] is forced to use signals, where other XR interfaces would instead use functions
 * that return a result immediately. This makes [WebXRInterface] quite a bit more complicated to
 * initialize than other XR interfaces.
 *
 * Here's the minimum code required to start an immersive VR session:
 *
 * ```
 * extends Node3D
 *
 * var webxr_interface
 * var vr_supported = false
 *
 * func _ready():
 * 	# We assume this node has a button as a child.
 * 	# This button is for the user to consent to entering immersive VR mode.
 * 	$Button.pressed.connect(self._on_button_pressed)
 *
 * 	webxr_interface = XRServer.find_interface("WebXR")
 * 	if webxr_interface:
 * 		# WebXR uses a lot of asynchronous callbacks, so we connect to various
 * 		# signals in order to receive them.
 * 		webxr_interface.session_supported.connect(self._webxr_session_supported)
 * 		webxr_interface.session_started.connect(self._webxr_session_started)
 * 		webxr_interface.session_ended.connect(self._webxr_session_ended)
 * 		webxr_interface.session_failed.connect(self._webxr_session_failed)
 *
 * 		# This returns immediately - our _webxr_session_supported() method
 * 		# (which we connected to the "session_supported" signal above) will
 * 		# be called sometime later to let us know if it's supported or not.
 * 		webxr_interface.is_session_supported("immersive-vr")
 *
 * func _webxr_session_supported(session_mode, supported):
 * 	if session_mode == 'immersive-vr':
 * 		vr_supported = supported
 *
 * func _on_button_pressed():
 * 	if not vr_supported:
 * 		OS.alert("Your browser doesn't support VR")
 * 		return
 *
 * 	# We want an immersive VR session, as opposed to AR ('immersive-ar') or a
 * 	# simple 3DoF viewer ('viewer').
 * 	webxr_interface.session_mode = 'immersive-vr'
 * 	# 'bounded-floor' is room scale, 'local-floor' is a standing or sitting
 * 	# experience (it puts you 1.6m above the ground if you have 3DoF headset),
 * 	# whereas as 'local' puts you down at the XROrigin.
 * 	# This list means it'll first try to request 'bounded-floor', then
 * 	# fallback on 'local-floor' and ultimately 'local', if nothing else is
 * 	# supported.
 * 	webxr_interface.requested_reference_space_types = 'bounded-floor, local-floor, local'
 * 	# In order to use 'local-floor' or 'bounded-floor' we must also
 * 	# mark the features as required or optional. By including 'hand-tracking'
 * 	# as an optional feature, it will be enabled if supported.
 * 	webxr_interface.required_features = 'local-floor'
 * 	webxr_interface.optional_features = 'bounded-floor, hand-tracking'
 *
 * 	# This will return false if we're unable to even request the session,
 * 	# however, it can still fail asynchronously later in the process, so we
 * 	# only know if it's really succeeded or failed when our
 * 	# _webxr_session_started() or _webxr_session_failed() methods are called.
 * 	if not webxr_interface.initialize():
 * 		OS.alert("Failed to initialize")
 * 		return
 *
 * func _webxr_session_started():
 * 	$Button.visible = false
 * 	# This tells Godot to start rendering to the headset.
 * 	get_viewport().use_xr = true
 * 	# This will be the reference space type you ultimately got, out of the
 * 	# types that you requested above. This is useful if you want the game to
 * 	# work a little differently in 'bounded-floor' versus 'local-floor'.
 * 	print("Reference space type: ", webxr_interface.reference_space_type)
 * 	# This will be the list of features that were successfully enabled
 * 	# (except on browsers that don't support this property).
 * 	print("Enabled features: ", webxr_interface.enabled_features)
 *
 * func _webxr_session_ended():
 * 	$Button.visible = true
 * 	# If the user exits immersive mode, then we tell Godot to render to the web
 * 	# page again.
 * 	get_viewport().use_xr = false
 *
 * func _webxr_session_failed(message):
 * 	OS.alert("Failed to initialize: " + message)
 * ```
 *
 * There are a couple ways to handle "controller" input:
 *
 * - Using [XRController3D] nodes and their [signal XRController3D.button_pressed] and [signal
 * XRController3D.button_released] signals. This is how controllers are typically handled in XR apps in
 * Godot, however, this will only work with advanced VR controllers like the Oculus Touch or Index
 * controllers, for example.
 *
 * - Using the [signal select], [signal squeeze] and related signals. This method will work for both
 * advanced VR controllers, and non-traditional input sources like a tap on the screen, a spoken voice
 * command or a button press on the device itself.
 *
 * You can use both methods to allow your game or app to support a wider or narrower set of devices
 * and input methods, or to allow more advanced interactions with more advanced devices.
 */
@GodotBaseType
public open class WebXRInterface internal constructor() : XRInterface() {
  /**
   * Emitted by [isSessionSupported] to indicate if the given [sessionMode] is supported or not.
   */
  public val sessionSupported: Signal2<String, Boolean> by Signal2

  /**
   * Emitted by [XRInterface.initialize] if the session is successfully started.
   *
   * At this point, it's safe to do `get_viewport().use_xr = true` to instruct Godot to start
   * rendering to the XR device.
   */
  public val sessionStarted: Signal0 by Signal0

  /**
   * Emitted when the user ends the WebXR session (which can be done using UI from the browser or
   * device).
   *
   * At this point, you should do `get_viewport().use_xr = false` to instruct Godot to resume
   * rendering to the screen.
   */
  public val sessionEnded: Signal0 by Signal0

  /**
   * Emitted by [XRInterface.initialize] if the session fails to start.
   *
   * [message] may optionally contain an error message from WebXR, or an empty string if no message
   * is available.
   */
  public val sessionFailed: Signal1<String> by Signal1

  /**
   * Emitted when one of the input source has started its "primary action".
   *
   * Use [getInputSourceTracker] and [getInputSourceTargetRayMode] to get more information about the
   * input source.
   */
  public val selectstart: Signal1<Long> by Signal1

  /**
   * Emitted after one of the input sources has finished its "primary action".
   *
   * Use [getInputSourceTracker] and [getInputSourceTargetRayMode] to get more information about the
   * input source.
   */
  public val select: Signal1<Long> by Signal1

  /**
   * Emitted when one of the input sources has finished its "primary action".
   *
   * Use [getInputSourceTracker] and [getInputSourceTargetRayMode] to get more information about the
   * input source.
   */
  public val selectend: Signal1<Long> by Signal1

  /**
   * Emitted when one of the input sources has started its "primary squeeze action".
   *
   * Use [getInputSourceTracker] and [getInputSourceTargetRayMode] to get more information about the
   * input source.
   */
  public val squeezestart: Signal1<Long> by Signal1

  /**
   * Emitted after one of the input sources has finished its "primary squeeze action".
   *
   * Use [getInputSourceTracker] and [getInputSourceTargetRayMode] to get more information about the
   * input source.
   */
  public val squeeze: Signal1<Long> by Signal1

  /**
   * Emitted when one of the input sources has finished its "primary squeeze action".
   *
   * Use [getInputSourceTracker] and [getInputSourceTargetRayMode] to get more information about the
   * input source.
   */
  public val squeezeend: Signal1<Long> by Signal1

  /**
   * Emitted when [visibilityState] has changed.
   */
  public val visibilityStateChanged: Signal0 by Signal0

  /**
   * Emitted to indicate that the reference space has been reset or reconfigured.
   *
   * When (or whether) this is emitted depends on the user's browser or device, but may include when
   * the user has changed the dimensions of their play space (which you may be able to access via
   * [XRInterface.getPlayArea]) or pressed/held a button to recenter their position.
   *
   * See [url=https://developer.mozilla.org/en-US/docs/Web/API/XRReferenceSpace/reset_event]WebXR's
   * XRReferenceSpace reset event[/url] for more information.
   */
  public val referenceSpaceReset: Signal0 by Signal0

  /**
   * Emitted after the display's refresh rate has changed.
   */
  public val displayRefreshRateChanged: Signal0 by Signal0

  /**
   * The session mode used by [XRInterface.initialize] when setting up the WebXR session.
   *
   * This doesn't have any effect on the interface when already initialized.
   *
   * Possible values come from
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRSessionMode]WebXR's XRSessionMode[/url],
   * including: `"immersive-vr"`, `"immersive-ar"`, and `"inline"`.
   */
  public final inline var sessionMode: String
    @JvmName("sessionModeProperty")
    get() = getSessionMode()
    @JvmName("sessionModeProperty")
    set(`value`) {
      setSessionMode(value)
    }

  /**
   * A comma-seperated list of required features used by [XRInterface.initialize] when setting up
   * the WebXR session.
   *
   * If a user's browser or device doesn't support one of the given features, initialization will
   * fail and [signal session_failed] will be emitted.
   *
   * This doesn't have any effect on the interface when already initialized.
   *
   * See the MDN documentation on
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRSystem/requestSession#session_features]WebXR's
   * session features[/url] for a list of possible values.
   */
  public final inline var requiredFeatures: String
    @JvmName("requiredFeaturesProperty")
    get() = getRequiredFeatures()
    @JvmName("requiredFeaturesProperty")
    set(`value`) {
      setRequiredFeatures(value)
    }

  /**
   * A comma-seperated list of optional features used by [XRInterface.initialize] when setting up
   * the WebXR session.
   *
   * If a user's browser or device doesn't support one of the given features, initialization will
   * continue, but you won't be able to use the requested feature.
   *
   * This doesn't have any effect on the interface when already initialized.
   *
   * See the MDN documentation on
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRSystem/requestSession#session_features]WebXR's
   * session features[/url] for a list of possible values.
   */
  public final inline var optionalFeatures: String
    @JvmName("optionalFeaturesProperty")
    get() = getOptionalFeatures()
    @JvmName("optionalFeaturesProperty")
    set(`value`) {
      setOptionalFeatures(value)
    }

  /**
   * A comma-seperated list of reference space types used by [XRInterface.initialize] when setting
   * up the WebXR session.
   *
   * The reference space types are requested in order, and the first one supported by the user's
   * device or browser will be used. The [referenceSpaceType] property contains the reference space
   * type that was ultimately selected.
   *
   * This doesn't have any effect on the interface when already initialized.
   *
   * Possible values come from
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRReferenceSpaceType]WebXR's
   * XRReferenceSpaceType[/url]. If you want to use a particular reference space type, it must be
   * listed in either [requiredFeatures] or [optionalFeatures].
   */
  public final inline var requestedReferenceSpaceTypes: String
    @JvmName("requestedReferenceSpaceTypesProperty")
    get() = getRequestedReferenceSpaceTypes()
    @JvmName("requestedReferenceSpaceTypesProperty")
    set(`value`) {
      setRequestedReferenceSpaceTypes(value)
    }

  /**
   * The reference space type (from the list of requested types set in the
   * [requestedReferenceSpaceTypes] property), that was ultimately used by [XRInterface.initialize]
   * when setting up the WebXR session.
   *
   * Possible values come from
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRReferenceSpaceType]WebXR's
   * XRReferenceSpaceType[/url]. If you want to use a particular reference space type, it must be
   * listed in either [requiredFeatures] or [optionalFeatures].
   */
  public final inline val referenceSpaceType: String
    @JvmName("referenceSpaceTypeProperty")
    get() = getReferenceSpaceType()

  /**
   * A comma-separated list of features that were successfully enabled by [XRInterface.initialize]
   * when setting up the WebXR session.
   *
   * This may include features requested by setting [requiredFeatures] and [optionalFeatures], and
   * will only be available after [signal session_started] has been emitted.
   *
   * **Note:** This may not be support by all web browsers, in which case it will be an empty
   * string.
   */
  public final inline val enabledFeatures: String
    @JvmName("enabledFeaturesProperty")
    get() = getEnabledFeatures()

  /**
   * Indicates if the WebXR session's imagery is visible to the user.
   *
   * Possible values come from
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRVisibilityState]WebXR's
   * XRVisibilityState[/url], including `"hidden"`, `"visible"`, and `"visible-blurred"`.
   */
  public final inline val visibilityState: String
    @JvmName("visibilityStateProperty")
    get() = getVisibilityState()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(926, scriptPtr)
  }

  /**
   * Checks if the given [sessionMode] is supported by the user's browser.
   *
   * Possible values come from
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRSessionMode]WebXR's XRSessionMode[/url],
   * including: `"immersive-vr"`, `"immersive-ar"`, and `"inline"`.
   *
   * This method returns nothing, instead it emits the [signal session_supported] signal with the
   * result.
   */
  public final fun isSessionSupported(sessionMode: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, sessionMode)
    TransferContext.callMethod(MethodBindings.isSessionSupportedPtr)
  }

  public final fun setSessionMode(sessionMode: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, sessionMode)
    TransferContext.callMethod(MethodBindings.setSessionModePtr)
  }

  public final fun getSessionMode(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSessionModePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setRequiredFeatures(requiredFeatures: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, requiredFeatures)
    TransferContext.callMethod(MethodBindings.setRequiredFeaturesPtr)
  }

  public final fun getRequiredFeatures(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRequiredFeaturesPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setOptionalFeatures(optionalFeatures: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, optionalFeatures)
    TransferContext.callMethod(MethodBindings.setOptionalFeaturesPtr)
  }

  public final fun getOptionalFeatures(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOptionalFeaturesPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun getReferenceSpaceType(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getReferenceSpaceTypePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun getEnabledFeatures(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getEnabledFeaturesPtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setRequestedReferenceSpaceTypes(requestedReferenceSpaceTypes: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, requestedReferenceSpaceTypes)
    TransferContext.callMethod(MethodBindings.setRequestedReferenceSpaceTypesPtr)
  }

  public final fun getRequestedReferenceSpaceTypes(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRequestedReferenceSpaceTypesPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns `true` if there is an active input source with the given [inputSourceId].
   */
  public final fun isInputSourceActive(inputSourceId: Int): Boolean {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, inputSourceId.toLong())
    TransferContext.callPtrMethod(MethodBindings.isInputSourceActivePtr, 1)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Gets an [XRControllerTracker] for the given [inputSourceId].
   *
   * In the context of WebXR, an input source can be an advanced VR controller like the Oculus Touch
   * or Index controllers, or even a tap on the screen, a spoken voice command or a button press on the
   * device itself. When a non-traditional input source is used, interpret the position and orientation
   * of the [XRPositionalTracker] as a ray pointing at the object the user wishes to interact with.
   *
   * Use this method to get information about the input source that triggered one of these signals:
   *
   * - [signal selectstart]
   *
   * - [signal select]
   *
   * - [signal selectend]
   *
   * - [signal squeezestart]
   *
   * - [signal squeeze]
   *
   * - [signal squeezestart]
   */
  public final fun getInputSourceTracker(inputSourceId: Int): XRControllerTracker? {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, inputSourceId.toLong())
    TransferContext.callPtrMethod(MethodBindings.getInputSourceTrackerPtr, 39)
    return (TransferContext.readReturnValue_OBJECT() as XRControllerTracker?)
  }

  /**
   * Returns the target ray mode for the given [inputSourceId].
   *
   * This can help interpret the input coming from that input source. See
   * [url=https://developer.mozilla.org/en-US/docs/Web/API/XRInputSource/targetRayMode]XRInputSource.targetRayMode[/url]
   * for more information.
   */
  public final fun getInputSourceTargetRayMode(inputSourceId: Int): TargetRayMode {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, inputSourceId.toLong())
    TransferContext.callPtrMethod(MethodBindings.getInputSourceTargetRayModePtr, 2)
    return TargetRayMode.from(TransferContext.readReturnValue_LONG())
  }

  public final fun getVisibilityState(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVisibilityStatePtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the display refresh rate for the current HMD. Not supported on all HMDs and browsers.
   * It may not report an accurate value until after using [setDisplayRefreshRate].
   */
  public final fun getDisplayRefreshRate(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDisplayRefreshRatePtr, 3)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * Sets the display refresh rate for the current HMD. Not supported on all HMDs and browsers. It
   * won't take effect right away until after [signal display_refresh_rate_changed] is emitted.
   */
  public final fun setDisplayRefreshRate(refreshRate: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, refreshRate.toDouble())
    TransferContext.callPtrMethod(MethodBindings.setDisplayRefreshRatePtr, 0)
  }

  /**
   * Returns display refresh rates supported by the current HMD. Only returned if this feature is
   * supported by the web browser and after the interface has been initialized.
   */
  public final fun getAvailableDisplayRefreshRates(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAvailableDisplayRefreshRatesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  public enum class TargetRayMode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * We don't know the target ray mode.
     */
    UNKNOWN(0),
    /**
     * Target ray originates at the viewer's eyes and points in the direction they are looking.
     */
    GAZE(1),
    /**
     * Target ray from a handheld pointer, most likely a VR touch controller.
     */
    TRACKED_POINTER(2),
    /**
     * Target ray from touch screen, mouse or other tactile input device.
     */
    SCREEN(3),
    ;

    public companion object {
      public fun from(`value`: Long): TargetRayMode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val isSessionSupportedName: MethodStringName1<WebXRInterface, Unit, String> =
        MethodStringName1<WebXRInterface, Unit, String>("is_session_supported")

    @JvmField
    public val setSessionModeName: MethodStringName1<WebXRInterface, Unit, String> =
        MethodStringName1<WebXRInterface, Unit, String>("set_session_mode")

    @JvmField
    public val getSessionModeName: MethodStringName0<WebXRInterface, String> =
        MethodStringName0<WebXRInterface, String>("get_session_mode")

    @JvmField
    public val setRequiredFeaturesName: MethodStringName1<WebXRInterface, Unit, String> =
        MethodStringName1<WebXRInterface, Unit, String>("set_required_features")

    @JvmField
    public val getRequiredFeaturesName: MethodStringName0<WebXRInterface, String> =
        MethodStringName0<WebXRInterface, String>("get_required_features")

    @JvmField
    public val setOptionalFeaturesName: MethodStringName1<WebXRInterface, Unit, String> =
        MethodStringName1<WebXRInterface, Unit, String>("set_optional_features")

    @JvmField
    public val getOptionalFeaturesName: MethodStringName0<WebXRInterface, String> =
        MethodStringName0<WebXRInterface, String>("get_optional_features")

    @JvmField
    public val getReferenceSpaceTypeName: MethodStringName0<WebXRInterface, String> =
        MethodStringName0<WebXRInterface, String>("get_reference_space_type")

    @JvmField
    public val getEnabledFeaturesName: MethodStringName0<WebXRInterface, String> =
        MethodStringName0<WebXRInterface, String>("get_enabled_features")

    @JvmField
    public val setRequestedReferenceSpaceTypesName: MethodStringName1<WebXRInterface, Unit, String>
        = MethodStringName1<WebXRInterface, Unit, String>("set_requested_reference_space_types")

    @JvmField
    public val getRequestedReferenceSpaceTypesName: MethodStringName0<WebXRInterface, String> =
        MethodStringName0<WebXRInterface, String>("get_requested_reference_space_types")

    @JvmField
    public val isInputSourceActiveName: MethodStringName1<WebXRInterface, Boolean, Int> =
        MethodStringName1<WebXRInterface, Boolean, Int>("is_input_source_active")

    @JvmField
    public val getInputSourceTrackerName:
        MethodStringName1<WebXRInterface, XRControllerTracker?, Int> =
        MethodStringName1<WebXRInterface, XRControllerTracker?, Int>("get_input_source_tracker")

    @JvmField
    public val getInputSourceTargetRayModeName:
        MethodStringName1<WebXRInterface, TargetRayMode, Int> =
        MethodStringName1<WebXRInterface, TargetRayMode, Int>("get_input_source_target_ray_mode")

    @JvmField
    public val getVisibilityStateName: MethodStringName0<WebXRInterface, String> =
        MethodStringName0<WebXRInterface, String>("get_visibility_state")

    @JvmField
    public val getDisplayRefreshRateName: MethodStringName0<WebXRInterface, Float> =
        MethodStringName0<WebXRInterface, Float>("get_display_refresh_rate")

    @JvmField
    public val setDisplayRefreshRateName: MethodStringName1<WebXRInterface, Unit, Float> =
        MethodStringName1<WebXRInterface, Unit, Float>("set_display_refresh_rate")

    @JvmField
    public val getAvailableDisplayRefreshRatesName:
        MethodStringName0<WebXRInterface, VariantArray<Any?>> =
        MethodStringName0<WebXRInterface, VariantArray<Any?>>("get_available_display_refresh_rates")
  }

  public object MethodBindings {
    internal val isSessionSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "is_session_supported", 83702148)

    internal val setSessionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "set_session_mode", 83702148)

    internal val getSessionModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_session_mode", 201670096)

    internal val setRequiredFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "set_required_features", 83702148)

    internal val getRequiredFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_required_features", 201670096)

    internal val setOptionalFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "set_optional_features", 83702148)

    internal val getOptionalFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_optional_features", 201670096)

    internal val getReferenceSpaceTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_reference_space_type", 201670096)

    internal val getEnabledFeaturesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_enabled_features", 201670096)

    internal val setRequestedReferenceSpaceTypesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "set_requested_reference_space_types", 83702148)

    internal val getRequestedReferenceSpaceTypesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_requested_reference_space_types", 201670096)

    internal val isInputSourceActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "is_input_source_active", 1116898809)

    internal val getInputSourceTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_input_source_tracker", 399776966)

    internal val getInputSourceTargetRayModePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_input_source_target_ray_mode", 2852387453)

    internal val getVisibilityStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_visibility_state", 201670096)

    internal val getDisplayRefreshRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_display_refresh_rate", 1740695150)

    internal val setDisplayRefreshRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "set_display_refresh_rate", 373806689)

    internal val getAvailableDisplayRefreshRatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("WebXRInterface", "get_available_display_refresh_rates", 3995934104)
  }
}
