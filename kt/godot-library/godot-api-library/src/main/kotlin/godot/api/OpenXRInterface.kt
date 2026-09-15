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
import godot.core.Quaternion
import godot.core.Signal0
import godot.core.Signal1
import godot.core.Signal3
import godot.core.VariantArray
import godot.core.Vector3
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DOUBLE
import godot.readReturnValue_LONG
import godot.readReturnValue_QUATERNION
import godot.readReturnValue_VECTOR3
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_DOUBLE
import godot.writeMethodArguments_LONG
import godot.writeMethodArguments_LONG_LONG
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_BOOL
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Float
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName

public infix fun Long.or(other: OpenXRInterface.HandJointFlags): Long = this.or(other.flag)

public infix fun Long.xor(other: OpenXRInterface.HandJointFlags): Long = this.xor(other.flag)

public infix fun Long.and(other: OpenXRInterface.HandJointFlags): Long = this.and(other.flag)

/**
 * The OpenXR interface allows Godot to interact with OpenXR runtimes and make it possible to create
 * XR experiences and games.
 *
 * Due to the needs of OpenXR this interface works slightly different than other plugin based XR
 * interfaces. It needs to be initialized when Godot starts. You need to enable OpenXR, settings for
 * this can be found in your games project settings under the XR heading. You do need to mark a
 * viewport for use with XR in order for Godot to know which render result should be output to the
 * headset.
 */
@GodotBaseType
public open class OpenXRInterface : XRInterface() {
  /**
   * Informs our OpenXR session has been started.
   */
  public val sessionBegun: Signal0 by Signal0

  /**
   * Informs our OpenXR session is stopping.
   */
  public val sessionStopping: Signal0 by Signal0

  /**
   * Informs our OpenXR session has been synchronized.
   */
  public val sessionSynchronized: Signal0 by Signal0

  /**
   * Informs our OpenXR session now has focus, for example output is sent to the HMD and we're
   * receiving XR input.
   */
  public val sessionFocussed: Signal0 by Signal0

  /**
   * Informs our OpenXR session is now visible, for example output is sent to the HMD but we don't
   * receive XR input.
   */
  public val sessionVisible: Signal0 by Signal0

  /**
   * Informs our OpenXR session is in the process of being lost.
   */
  public val sessionLossPending: Signal0 by Signal0

  /**
   * Informs our OpenXR instance is exiting.
   */
  public val instanceExiting: Signal0 by Signal0

  /**
   * Informs the user queued a recenter of the player position.
   */
  public val poseRecentered: Signal0 by Signal0

  /**
   * Informs the user the HMD refresh rate has changed.
   *
   * **Note:** Only emitted if XR runtime supports the refresh rate extension.
   */
  public val refreshRateChanged: Signal1<Double> by Signal1

  /**
   * Informs the device CPU performance level has changed in the specified subdomain.
   */
  public val cpuLevelChanged: Signal3<Long, Long, Long> by Signal3

  /**
   * Informs the device GPU performance level has changed in the specified subdomain.
   */
  public val gpuLevelChanged: Signal3<Long, Long, Long> by Signal3

  /**
   * Signal emitted when the user presence value changes.
   *
   * **Note:** This signal will not be emitted during application startup and application shutdown.
   * Developers should assume user presence is gained on startup and lost on shutdown.
   */
  public val userPresenceChanged: Signal1<Boolean> by Signal1

  /**
   * The display refresh rate for the current HMD. Only functional if this feature is supported by
   * the OpenXR runtime and after the interface has been initialized.
   */
  public final inline var displayRefreshRate: Float
    @JvmName("displayRefreshRateProperty")
    get() = getDisplayRefreshRate()
    @JvmName("displayRefreshRateProperty")
    set(`value`) {
      setDisplayRefreshRate(value)
    }

  /**
   * The render size multiplier for the current HMD. Must be set before the interface has been
   * initialized.
   */
  public final inline var renderTargetSizeMultiplier: Double
    @JvmName("renderTargetSizeMultiplierProperty")
    get() = getRenderTargetSizeMultiplier()
    @JvmName("renderTargetSizeMultiplierProperty")
    set(`value`) {
      setRenderTargetSizeMultiplier(value)
    }

  /**
   * The foveation level, from `0` (off) to `3` (high). The interface must be initialized before
   * this is accessible.
   */
  public final inline var foveationLevel: Int
    @JvmName("foveationLevelProperty")
    get() = getFoveationLevel()
    @JvmName("foveationLevelProperty")
    set(`value`) {
      setFoveationLevel(value)
    }

  /**
   * If `true`, enables dynamic foveation adjustment. The interface must be initialized before this
   * is accessible. If enabled, foveation will automatically be adjusted between low and
   * [foveationLevel].
   */
  public final inline var foveationDynamic: Boolean
    @JvmName("foveationDynamicProperty")
    get() = getFoveationDynamic()
    @JvmName("foveationDynamicProperty")
    set(`value`) {
      setFoveationDynamic(value)
    }

  /**
   * If `true`, enables subsampled images with foveation, which can provide a performance boost on
   * Vulkan.
   */
  public final inline var foveationWithSubsampledImages: Boolean
    @JvmName("foveationWithSubsampledImagesProperty")
    get() = getFoveationWithSubsampledImages()
    @JvmName("foveationWithSubsampledImagesProperty")
    set(`value`) {
      setFoveationWithSubsampledImages(value)
    }

  /**
   * The minimum radius around the focal point where full quality is guaranteed if VRS is used as a
   * percentage of screen size.
   *
   * **Note:** Mobile and Forward+ renderers only. Requires [Viewport.vrsMode] to be set to
   * [Viewport.VRS_XR].
   */
  public final inline var vrsMinRadius: Float
    @JvmName("vrsMinRadiusProperty")
    get() = getVrsMinRadius()
    @JvmName("vrsMinRadiusProperty")
    set(`value`) {
      setVrsMinRadius(value)
    }

  /**
   * The strength used to calculate the VRS density map. The greater this value, the more noticeable
   * VRS is. This improves performance at the cost of quality.
   *
   * **Note:** Mobile and Forward+ renderers only. Requires [Viewport.vrsMode] to be set to
   * [Viewport.VRS_XR].
   */
  public final inline var vrsStrength: Float
    @JvmName("vrsStrengthProperty")
    get() = getVrsStrength()
    @JvmName("vrsStrengthProperty")
    set(`value`) {
      setVrsStrength(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(462, scriptPtr)
  }

  /**
   * Returns the current state of our OpenXR session.
   */
  public final fun getSessionState(): SessionState {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSessionStatePtr)
    return SessionState.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns `true` if OpenXR's user presence extension is supported and enabled.
   *
   * **Note:** This only returns a valid value after OpenXR has been initialized.
   */
  public final fun isUserPresenceSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUserPresenceSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if system has detected the presence of a user in the XR experience.
   */
  public final fun isUserPresent(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isUserPresentPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getDisplayRefreshRate(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDisplayRefreshRatePtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setDisplayRefreshRate(refreshRate: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, refreshRate.toDouble())
    TransferContext.callMethod(MethodBindings.setDisplayRefreshRatePtr)
  }

  public final fun getRenderTargetSizeMultiplier(): Double {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderTargetSizeMultiplierPtr)
    return TransferContext.readReturnValue_DOUBLE()
  }

  public final fun setRenderTargetSizeMultiplier(multiplier: Double): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, multiplier)
    TransferContext.callMethod(MethodBindings.setRenderTargetSizeMultiplierPtr)
  }

  /**
   * Returns `true` if OpenXR's foveation extension is supported. The interface must be initialized
   * before this returns a valid value.
   *
   * **Note:** When using the Vulkan rendering driver, [Viewport.vrsMode] must be set to
   * [Viewport.VRS_XR] to support foveation.
   */
  public final fun isFoveationSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isFoveationSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getFoveationLevel(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFoveationLevelPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun setFoveationLevel(foveationLevel: Int): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, foveationLevel.toLong())
    TransferContext.callMethod(MethodBindings.setFoveationLevelPtr)
  }

  public final fun getFoveationDynamic(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFoveationDynamicPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setFoveationDynamic(foveationDynamic: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, foveationDynamic)
    TransferContext.callMethod(MethodBindings.setFoveationDynamicPtr)
  }

  public final fun getFoveationWithSubsampledImages(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFoveationWithSubsampledImagesPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun setFoveationWithSubsampledImages(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, enabled)
    TransferContext.callMethod(MethodBindings.setFoveationWithSubsampledImagesPtr)
  }

  /**
   * Returns `true` if the given action set is active.
   */
  public final fun isActionSetActive(name: String): Boolean {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.isActionSetActivePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Sets the given action set as active or inactive.
   */
  public final fun setActionSetActive(name: String, active: Boolean): Unit {
    TransferContext.writeMethodArguments_STRING_BOOL(ptr, objectID.id, name, active)
    TransferContext.callMethod(MethodBindings.setActionSetActivePtr)
  }

  /**
   * Returns a list of action sets registered with Godot (loaded from the action map at runtime).
   */
  public final fun getActionSets(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getActionSetsPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * Returns a list of display refresh rates supported by the current HMD. Only returned if this
   * feature is supported by the OpenXR runtime and after the interface has been initialized.
   */
  public final fun getAvailableDisplayRefreshRates(): VariantArray<Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getAvailableDisplayRefreshRatesPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Any?>)
  }

  /**
   * If handtracking is enabled and motion range is supported, sets the currently configured motion
   * range for [hand] to [motionRange].
   */
  public final fun setMotionRange(hand: Hand, motionRange: HandMotionRange): Unit {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, hand.value, motionRange.value)
    TransferContext.callMethod(MethodBindings.setMotionRangePtr)
  }

  /**
   * If handtracking is enabled and motion range is supported, gets the currently configured motion
   * range for [hand].
   */
  public final fun getMotionRange(hand: Hand): HandMotionRange {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, hand.value)
    TransferContext.callMethod(MethodBindings.getMotionRangePtr)
    return HandMotionRange.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * If handtracking is enabled and hand tracking source is supported, gets the source of the hand
   * tracking data for [hand].
   */
  public final fun getHandTrackingSource(hand: Hand): HandTrackedSource {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, hand.value)
    TransferContext.callMethod(MethodBindings.getHandTrackingSourcePtr)
    return HandTrackedSource.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * If handtracking is enabled, returns flags that inform us of the validity of the tracking data.
   */
  public final fun getHandJointFlags(hand: Hand, joint: HandJoints): HandJointFlags {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, hand.value, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointFlagsPtr)
    return HandJointFlags(TransferContext.readReturnValue_LONG())
  }

  /**
   * If handtracking is enabled, returns the rotation of a joint ([joint]) of a hand ([hand]) as
   * provided by OpenXR.
   */
  public final fun getHandJointRotation(hand: Hand, joint: HandJoints): Quaternion {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, hand.value, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointRotationPtr)
    return TransferContext.readReturnValue_QUATERNION()
  }

  /**
   * If handtracking is enabled, returns the position of a joint ([joint]) of a hand ([hand]) as
   * provided by OpenXR. This is relative to [XROrigin3D] without worldscale applied!
   */
  public final fun getHandJointPosition(hand: Hand, joint: HandJoints): Vector3 {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, hand.value, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointPositionPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * If handtracking is enabled, returns the radius of a joint ([joint]) of a hand ([hand]) as
   * provided by OpenXR. This is without worldscale applied!
   */
  public final fun getHandJointRadius(hand: Hand, joint: HandJoints): Float {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, hand.value, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointRadiusPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  /**
   * If handtracking is enabled, returns the linear velocity of a joint ([joint]) of a hand ([hand])
   * as provided by OpenXR. This is relative to [XROrigin3D] without worldscale applied!
   */
  public final fun getHandJointLinearVelocity(hand: Hand, joint: HandJoints): Vector3 {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, hand.value, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointLinearVelocityPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * If handtracking is enabled, returns the angular velocity of a joint ([joint]) of a hand
   * ([hand]) as provided by OpenXR. This is relative to [XROrigin3D]!
   */
  public final fun getHandJointAngularVelocity(hand: Hand, joint: HandJoints): Vector3 {
    TransferContext.writeMethodArguments_LONG_LONG(ptr, objectID.id, hand.value, joint.value)
    TransferContext.callMethod(MethodBindings.getHandJointAngularVelocityPtr)
    return TransferContext.readReturnValue_VECTOR3()
  }

  /**
   * Returns `true` if OpenXR's hand tracking is supported and enabled.
   *
   * **Note:** This only returns a valid value after OpenXR has been initialized.
   */
  public final fun isHandTrackingSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHandTrackingSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if OpenXR's hand interaction profile is supported and enabled.
   *
   * **Note:** This only returns a valid value after OpenXR has been initialized.
   */
  public final fun isHandInteractionSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isHandInteractionSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the capabilities of the eye gaze interaction extension.
   *
   * **Note:** This only returns a valid value after OpenXR has been initialized.
   */
  public final fun isEyeGazeInteractionSupported(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEyeGazeInteractionSupportedPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getVrsMinRadius(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVrsMinRadiusPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setVrsMinRadius(radius: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, radius.toDouble())
    TransferContext.callMethod(MethodBindings.setVrsMinRadiusPtr)
  }

  public final fun getVrsStrength(): Float {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getVrsStrengthPtr)
    return TransferContext.readReturnValue_DOUBLE().toFloat()
  }

  public final fun setVrsStrength(strength: Float): Unit {
    TransferContext.writeMethodArguments_DOUBLE(ptr, objectID.id, strength.toDouble())
    TransferContext.callMethod(MethodBindings.setVrsStrengthPtr)
  }

  /**
   * Sets the CPU performance level of the OpenXR device.
   */
  public final fun setCpuLevel(level: PerfSettingsLevel): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, level.value)
    TransferContext.callMethod(MethodBindings.setCpuLevelPtr)
  }

  /**
   * Sets the GPU performance level of the OpenXR device.
   */
  public final fun setGpuLevel(level: PerfSettingsLevel): Unit {
    TransferContext.writeMethodArguments_LONG(ptr, objectID.id, level.value)
    TransferContext.callMethod(MethodBindings.setGpuLevelPtr)
  }

  public enum class SessionState(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The state of the session is unknown, we haven't tried setting up OpenXR yet.
     */
    UNKNOWN(0),
    /**
     * The initial state after the OpenXR session is created or after the session is destroyed.
     */
    IDLE(1),
    /**
     * OpenXR is ready to begin our session. [signal session_begun] is emitted when we change to
     * this state.
     */
    READY(2),
    /**
     * The application has synched its frame loop with the runtime but we're not rendering anything.
     * [signal session_synchronized] is emitted when we change to this state.
     */
    SYNCHRONIZED(3),
    /**
     * The application has synched its frame loop with the runtime and we're rendering output to the
     * user, however we receive no user input. [signal session_visible] is emitted when we change to
     * this state.
     *
     * **Note:** This is the current state just before we get the focused state, whenever the user
     * opens a system menu, switches to another application, or takes off their headset.
     */
    VISIBLE(4),
    /**
     * The application has synched its frame loop with the runtime, we're rendering output to the
     * user and we're receiving XR input. [signal session_focussed] is emitted when we change to this
     * state.
     *
     * **Note:** This is the state OpenXR will be in when the user can fully interact with your
     * game.
     */
    FOCUSED(5),
    /**
     * Our session is being stopped. [signal session_stopping] is emitted when we change to this
     * state.
     */
    STOPPING(6),
    /**
     * The session is about to be lost. [signal session_loss_pending] is emitted when we change to
     * this state.
     */
    LOSS_PENDING(7),
    /**
     * The OpenXR instance is about to be destroyed and we're exiting. [signal instance_exiting] is
     * emitted when we change to this state.
     */
    EXITING(8),
    ;

    public companion object {
      public fun from(`value`: Long): SessionState = entries.single { it.`value` == `value` }
    }
  }

  public enum class Hand(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Left hand.
     */
    LEFT(0),
    /**
     * Right hand.
     */
    RIGHT(1),
    /**
     * Maximum value for the hand enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): Hand = entries.single { it.`value` == `value` }
    }
  }

  public enum class HandMotionRange(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Full hand range, if user closes their hands, we make a full fist.
     */
    UNOBSTRUCTED(0),
    /**
     * Conform to controller, if user closes their hands, the tracked data conforms to the shape of
     * the controller.
     */
    CONFORM_TO_CONTROLLER(1),
    /**
     * Maximum value for the motion range enum.
     */
    MAX(2),
    ;

    public companion object {
      public fun from(`value`: Long): HandMotionRange = entries.single { it.`value` == `value` }
    }
  }

  public enum class HandTrackedSource(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The source of hand tracking data is unknown (the extension is likely unsupported).
     */
    UNKNOWN(0),
    /**
     * The source of hand tracking is unobstructed, this means that an accurate method of hand
     * tracking is used, e.g. optical hand tracking, data gloves, etc.
     */
    UNOBSTRUCTED(1),
    /**
     * The source of hand tracking is a controller, bone positions are inferred from controller
     * inputs.
     */
    CONTROLLER(2),
    /**
     * Represents the size of the [HandTrackedSource] enum.
     */
    MAX(3),
    ;

    public companion object {
      public fun from(`value`: Long): HandTrackedSource = entries.single { it.`value` == `value` }
    }
  }

  public enum class HandJoints(
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
     * Thumb proximal joint.
     */
    THUMB_PROXIMAL(3),
    /**
     * Thumb distal joint.
     */
    THUMB_DISTAL(4),
    /**
     * Thumb tip joint.
     */
    THUMB_TIP(5),
    /**
     * Index finger metacarpal joint.
     */
    INDEX_METACARPAL(6),
    /**
     * Index finger phalanx proximal joint.
     */
    INDEX_PROXIMAL(7),
    /**
     * Index finger phalanx intermediate joint.
     */
    INDEX_INTERMEDIATE(8),
    /**
     * Index finger phalanx distal joint.
     */
    INDEX_DISTAL(9),
    /**
     * Index finger tip joint.
     */
    INDEX_TIP(10),
    /**
     * Middle finger metacarpal joint.
     */
    MIDDLE_METACARPAL(11),
    /**
     * Middle finger phalanx proximal joint.
     */
    MIDDLE_PROXIMAL(12),
    /**
     * Middle finger phalanx intermediate joint.
     */
    MIDDLE_INTERMEDIATE(13),
    /**
     * Middle finger phalanx distal joint.
     */
    MIDDLE_DISTAL(14),
    /**
     * Middle finger tip joint.
     */
    MIDDLE_TIP(15),
    /**
     * Ring finger metacarpal joint.
     */
    RING_METACARPAL(16),
    /**
     * Ring finger phalanx proximal joint.
     */
    RING_PROXIMAL(17),
    /**
     * Ring finger phalanx intermediate joint.
     */
    RING_INTERMEDIATE(18),
    /**
     * Ring finger phalanx distal joint.
     */
    RING_DISTAL(19),
    /**
     * Ring finger tip joint.
     */
    RING_TIP(20),
    /**
     * Pinky finger metacarpal joint.
     */
    LITTLE_METACARPAL(21),
    /**
     * Pinky finger phalanx proximal joint.
     */
    LITTLE_PROXIMAL(22),
    /**
     * Pinky finger phalanx intermediate joint.
     */
    LITTLE_INTERMEDIATE(23),
    /**
     * Pinky finger phalanx distal joint.
     */
    LITTLE_DISTAL(24),
    /**
     * Pinky finger tip joint.
     */
    LITTLE_TIP(25),
    /**
     * Represents the size of the [HandJoints] enum.
     */
    MAX(26),
    ;

    public companion object {
      public fun from(`value`: Long): HandJoints = entries.single { it.`value` == `value` }
    }
  }

  public enum class PerfSettingsLevel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The application has entered a non-XR section (head-locked / static screen), during which
     * power savings are to be prioritized.
     */
    POWER_SAVINGS(0),
    /**
     * The application has entered a low and stable complexity section, during which reducing power
     * is more important than occasional late rendering frames.
     */
    SUSTAINED_LOW(1),
    /**
     * The application has entered a high or dynamic complexity section, during which the XR Runtime
     * strives for consistent XR compositing and frame rendering within a thermally sustainable range.
     */
    SUSTAINED_HIGH(2),
    /**
     * The application has entered a section with very high complexity, during which the XR Runtime
     * is allowed to step up beyond the thermally sustainable range.
     */
    BOOST(3),
    ;

    public companion object {
      public fun from(`value`: Long): PerfSettingsLevel = entries.single { it.`value` == `value` }
    }
  }

  public enum class PerfSettingsSubDomain(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The compositing performance within the runtime has reached a new level.
     */
    COMPOSITING(0),
    /**
     * The application rendering performance has reached a new level.
     */
    RENDERING(1),
    /**
     * The temperature of the device has reached a new level.
     */
    THERMAL(2),
    ;

    public companion object {
      public fun from(`value`: Long): PerfSettingsSubDomain =
          entries.single { it.`value` == `value` }
    }
  }

  public enum class PerfSettingsNotificationLevel(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The sub-domain has reached a level where no further actions other than currently applied are
     * necessary.
     */
    NORMAL(0),
    /**
     * The sub-domain has reached an early warning level where the application should start
     * proactive mitigation actions.
     */
    WARNING(1),
    /**
     * The sub-domain has reached a critical level where the application should start drastic
     * mitigation actions.
     */
    IMPAIRED(2),
    ;

    public companion object {
      public fun from(`value`: Long): PerfSettingsNotificationLevel =
          entries.single { it.`value` == `value` }
    }
  }

  public class HandJointFlags(
    flag: Long,
  ) : BitFieldBase<HandJointFlags>(flag) {
    protected override fun wrap(flag: Long): HandJointFlags = HandJointFlags(flag)

    public companion object {
      /**
       * No flags are set.
       */
      @JvmField
      public val NONE: HandJointFlags = HandJointFlags(0)

      /**
       * If set, the orientation data is valid, otherwise, the orientation data is unreliable and
       * should not be used.
       */
      @JvmField
      public val ORIENTATION_VALID: HandJointFlags = HandJointFlags(1)

      /**
       * If set, the orientation data comes from tracking data, otherwise, the orientation data
       * contains predicted data.
       */
      @JvmField
      public val ORIENTATION_TRACKED: HandJointFlags = HandJointFlags(2)

      /**
       * If set, the positional data is valid, otherwise, the positional data is unreliable and
       * should not be used.
       */
      @JvmField
      public val POSITION_VALID: HandJointFlags = HandJointFlags(4)

      /**
       * If set, the positional data comes from tracking data, otherwise, the positional data
       * contains predicted data.
       */
      @JvmField
      public val POSITION_TRACKED: HandJointFlags = HandJointFlags(8)

      /**
       * If set, our linear velocity data is valid, otherwise, the linear velocity data is
       * unreliable and should not be used.
       */
      @JvmField
      public val LINEAR_VELOCITY_VALID: HandJointFlags = HandJointFlags(16)

      /**
       * If set, our angular velocity data is valid, otherwise, the angular velocity data is
       * unreliable and should not be used.
       */
      @JvmField
      public val ANGULAR_VELOCITY_VALID: HandJointFlags = HandJointFlags(32)
    }
  }

  public companion object {
    @JvmField
    public val getSessionStateName: MethodStringName0<OpenXRInterface, SessionState> =
        MethodStringName0<OpenXRInterface, SessionState>("get_session_state")

    @JvmField
    public val isUserPresenceSupportedName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("is_user_presence_supported")

    @JvmField
    public val isUserPresentName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("is_user_present")

    @JvmField
    public val getDisplayRefreshRateName: MethodStringName0<OpenXRInterface, Float> =
        MethodStringName0<OpenXRInterface, Float>("get_display_refresh_rate")

    @JvmField
    public val setDisplayRefreshRateName: MethodStringName1<OpenXRInterface, Unit, Float> =
        MethodStringName1<OpenXRInterface, Unit, Float>("set_display_refresh_rate")

    @JvmField
    public val getRenderTargetSizeMultiplierName: MethodStringName0<OpenXRInterface, Double> =
        MethodStringName0<OpenXRInterface, Double>("get_render_target_size_multiplier")

    @JvmField
    public val setRenderTargetSizeMultiplierName: MethodStringName1<OpenXRInterface, Unit, Double> =
        MethodStringName1<OpenXRInterface, Unit, Double>("set_render_target_size_multiplier")

    @JvmField
    public val isFoveationSupportedName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("is_foveation_supported")

    @JvmField
    public val getFoveationLevelName: MethodStringName0<OpenXRInterface, Int> =
        MethodStringName0<OpenXRInterface, Int>("get_foveation_level")

    @JvmField
    public val setFoveationLevelName: MethodStringName1<OpenXRInterface, Unit, Int> =
        MethodStringName1<OpenXRInterface, Unit, Int>("set_foveation_level")

    @JvmField
    public val getFoveationDynamicName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("get_foveation_dynamic")

    @JvmField
    public val setFoveationDynamicName: MethodStringName1<OpenXRInterface, Unit, Boolean> =
        MethodStringName1<OpenXRInterface, Unit, Boolean>("set_foveation_dynamic")

    @JvmField
    public val getFoveationWithSubsampledImagesName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("get_foveation_with_subsampled_images")

    @JvmField
    public val setFoveationWithSubsampledImagesName:
        MethodStringName1<OpenXRInterface, Unit, Boolean> =
        MethodStringName1<OpenXRInterface, Unit, Boolean>("set_foveation_with_subsampled_images")

    @JvmField
    public val isActionSetActiveName: MethodStringName1<OpenXRInterface, Boolean, String> =
        MethodStringName1<OpenXRInterface, Boolean, String>("is_action_set_active")

    @JvmField
    public val setActionSetActiveName: MethodStringName2<OpenXRInterface, Unit, String, Boolean> =
        MethodStringName2<OpenXRInterface, Unit, String, Boolean>("set_action_set_active")

    @JvmField
    public val getActionSetsName: MethodStringName0<OpenXRInterface, VariantArray<Any?>> =
        MethodStringName0<OpenXRInterface, VariantArray<Any?>>("get_action_sets")

    @JvmField
    public val getAvailableDisplayRefreshRatesName:
        MethodStringName0<OpenXRInterface, VariantArray<Any?>> =
        MethodStringName0<OpenXRInterface, VariantArray<Any?>>("get_available_display_refresh_rates")

    @JvmField
    public val setMotionRangeName: MethodStringName2<OpenXRInterface, Unit, Hand, HandMotionRange> =
        MethodStringName2<OpenXRInterface, Unit, Hand, HandMotionRange>("set_motion_range")

    @JvmField
    public val getMotionRangeName: MethodStringName1<OpenXRInterface, HandMotionRange, Hand> =
        MethodStringName1<OpenXRInterface, HandMotionRange, Hand>("get_motion_range")

    @JvmField
    public val getHandTrackingSourceName:
        MethodStringName1<OpenXRInterface, HandTrackedSource, Hand> =
        MethodStringName1<OpenXRInterface, HandTrackedSource, Hand>("get_hand_tracking_source")

    @JvmField
    public val getHandJointFlagsName:
        MethodStringName2<OpenXRInterface, HandJointFlags, Hand, HandJoints> =
        MethodStringName2<OpenXRInterface, HandJointFlags, Hand, HandJoints>("get_hand_joint_flags")

    @JvmField
    public val getHandJointRotationName:
        MethodStringName2<OpenXRInterface, Quaternion, Hand, HandJoints> =
        MethodStringName2<OpenXRInterface, Quaternion, Hand, HandJoints>("get_hand_joint_rotation")

    @JvmField
    public val getHandJointPositionName:
        MethodStringName2<OpenXRInterface, Vector3, Hand, HandJoints> =
        MethodStringName2<OpenXRInterface, Vector3, Hand, HandJoints>("get_hand_joint_position")

    @JvmField
    public val getHandJointRadiusName: MethodStringName2<OpenXRInterface, Float, Hand, HandJoints> =
        MethodStringName2<OpenXRInterface, Float, Hand, HandJoints>("get_hand_joint_radius")

    @JvmField
    public val getHandJointLinearVelocityName:
        MethodStringName2<OpenXRInterface, Vector3, Hand, HandJoints> =
        MethodStringName2<OpenXRInterface, Vector3, Hand, HandJoints>("get_hand_joint_linear_velocity")

    @JvmField
    public val getHandJointAngularVelocityName:
        MethodStringName2<OpenXRInterface, Vector3, Hand, HandJoints> =
        MethodStringName2<OpenXRInterface, Vector3, Hand, HandJoints>("get_hand_joint_angular_velocity")

    @JvmField
    public val isHandTrackingSupportedName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("is_hand_tracking_supported")

    @JvmField
    public val isHandInteractionSupportedName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("is_hand_interaction_supported")

    @JvmField
    public val isEyeGazeInteractionSupportedName: MethodStringName0<OpenXRInterface, Boolean> =
        MethodStringName0<OpenXRInterface, Boolean>("is_eye_gaze_interaction_supported")

    @JvmField
    public val getVrsMinRadiusName: MethodStringName0<OpenXRInterface, Float> =
        MethodStringName0<OpenXRInterface, Float>("get_vrs_min_radius")

    @JvmField
    public val setVrsMinRadiusName: MethodStringName1<OpenXRInterface, Unit, Float> =
        MethodStringName1<OpenXRInterface, Unit, Float>("set_vrs_min_radius")

    @JvmField
    public val getVrsStrengthName: MethodStringName0<OpenXRInterface, Float> =
        MethodStringName0<OpenXRInterface, Float>("get_vrs_strength")

    @JvmField
    public val setVrsStrengthName: MethodStringName1<OpenXRInterface, Unit, Float> =
        MethodStringName1<OpenXRInterface, Unit, Float>("set_vrs_strength")

    @JvmField
    public val setCpuLevelName: MethodStringName1<OpenXRInterface, Unit, PerfSettingsLevel> =
        MethodStringName1<OpenXRInterface, Unit, PerfSettingsLevel>("set_cpu_level")

    @JvmField
    public val setGpuLevelName: MethodStringName1<OpenXRInterface, Unit, PerfSettingsLevel> =
        MethodStringName1<OpenXRInterface, Unit, PerfSettingsLevel>("set_gpu_level")
  }

  public object MethodBindings {
    internal val getSessionStatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_session_state", 896364779)

    internal val isUserPresenceSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_user_presence_supported", 36873697)

    internal val isUserPresentPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_user_present", 36873697)

    internal val getDisplayRefreshRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_display_refresh_rate", 1740695150)

    internal val setDisplayRefreshRatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_display_refresh_rate", 373806689)

    internal val getRenderTargetSizeMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_render_target_size_multiplier", 1740695150)

    internal val setRenderTargetSizeMultiplierPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_render_target_size_multiplier", 373806689)

    internal val isFoveationSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_foveation_supported", 36873697)

    internal val getFoveationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_foveation_level", 3905245786)

    internal val setFoveationLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_foveation_level", 1286410249)

    internal val getFoveationDynamicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_foveation_dynamic", 36873697)

    internal val setFoveationDynamicPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_foveation_dynamic", 2586408642)

    internal val getFoveationWithSubsampledImagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_foveation_with_subsampled_images", 36873697)

    internal val setFoveationWithSubsampledImagesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_foveation_with_subsampled_images", 2586408642)

    internal val isActionSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_action_set_active", 3927539163)

    internal val setActionSetActivePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_action_set_active", 2678287736)

    internal val getActionSetsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_action_sets", 3995934104)

    internal val getAvailableDisplayRefreshRatesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_available_display_refresh_rates", 3995934104)

    internal val setMotionRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_motion_range", 855158159)

    internal val getMotionRangePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_motion_range", 3955838114)

    internal val getHandTrackingSourcePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_tracking_source", 4092421202)

    internal val getHandJointFlagsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_flags", 720567706)

    internal val getHandJointRotationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_rotation", 1974618321)

    internal val getHandJointPositionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_position", 3529194242)

    internal val getHandJointRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_radius", 901522724)

    internal val getHandJointLinearVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_linear_velocity", 3529194242)

    internal val getHandJointAngularVelocityPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_hand_joint_angular_velocity", 3529194242)

    internal val isHandTrackingSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_hand_tracking_supported", 2240911060)

    internal val isHandInteractionSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_hand_interaction_supported", 36873697)

    internal val isEyeGazeInteractionSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "is_eye_gaze_interaction_supported", 2240911060)

    internal val getVrsMinRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_vrs_min_radius", 1740695150)

    internal val setVrsMinRadiusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_vrs_min_radius", 373806689)

    internal val getVrsStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "get_vrs_strength", 1740695150)

    internal val setVrsStrengthPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_vrs_strength", 373806689)

    internal val setCpuLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_cpu_level", 2940842095)

    internal val setGpuLevelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRInterface", "set_gpu_level", 2940842095)
  }
}
