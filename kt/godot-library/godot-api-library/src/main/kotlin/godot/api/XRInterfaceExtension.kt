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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName11
import godot.core.PackedFloat64Array
import godot.core.PackedStringArray
import godot.core.PackedVector3Array
import godot.core.RID
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.StringName
import godot.core.Transform3D
import godot.core.Vector2
import godot.readReturnValue_RID
import godot.writeMethodArguments0
import godot.writeMethodArguments_RID
import godot.writeMethodArguments_RID_RECT2_RECT2I_BOOL_LONG_BOOL_VECTOR2_DOUBLE_DOUBLE_DOUBLE_DOUBLE
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * External XR interface plugins should inherit from this class.
 */
@GodotBaseType
public open class XRInterfaceExtension : XRInterface() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(947, scriptPtr)
  }

  /**
   * Returns the name of this interface.
   */
  public open fun _getName(): StringName {
    throw NotImplementedError("XRInterfaceExtension::_getName is not implemented.")
  }

  /**
   * Returns the capabilities of this interface.
   */
  public open fun _getCapabilities(): Long {
    throw NotImplementedError("XRInterfaceExtension::_getCapabilities is not implemented.")
  }

  /**
   * Returns `true` if this interface has been initialized.
   */
  public open fun _isInitialized(): Boolean {
    throw NotImplementedError("XRInterfaceExtension::_isInitialized is not implemented.")
  }

  /**
   * Initializes the interface, returns `true` on success.
   */
  public open fun _initialize(): Boolean {
    throw NotImplementedError("XRInterfaceExtension::_initialize is not implemented.")
  }

  /**
   * Uninitialize the interface.
   */
  public open fun _uninitialize(): Unit {
    throw NotImplementedError("XRInterfaceExtension::_uninitialize is not implemented.")
  }

  /**
   * Returns a [Dictionary] with system information related to this interface.
   */
  public open fun _getSystemInfo(): Dictionary<Any?, Any?> {
    throw NotImplementedError("XRInterfaceExtension::_getSystemInfo is not implemented.")
  }

  /**
   * Returns `true` if this interface supports this play area mode.
   */
  public open fun _supportsPlayAreaMode(mode: XRInterface.PlayAreaMode): Boolean {
    throw NotImplementedError("XRInterfaceExtension::_supportsPlayAreaMode is not implemented.")
  }

  /**
   * Returns the play area mode that sets up our play area.
   */
  public open fun _getPlayAreaMode(): XRInterface.PlayAreaMode {
    throw NotImplementedError("XRInterfaceExtension::_getPlayAreaMode is not implemented.")
  }

  /**
   * Set the play area mode for this interface.
   */
  public open fun _setPlayAreaMode(mode: XRInterface.PlayAreaMode): Boolean {
    throw NotImplementedError("XRInterfaceExtension::_setPlayAreaMode is not implemented.")
  }

  /**
   * Returns a [PackedVector3Array] that represents the play areas boundaries (if applicable).
   */
  public open fun _getPlayArea(): PackedVector3Array {
    throw NotImplementedError("XRInterfaceExtension::_getPlayArea is not implemented.")
  }

  /**
   * Returns the size of our render target for this interface, this overrides the size of the
   * [Viewport] marked as the xr viewport.
   */
  public open fun _getRenderTargetSize(): Vector2 {
    throw NotImplementedError("XRInterfaceExtension::_getRenderTargetSize is not implemented.")
  }

  /**
   * Returns the number of views this interface requires, 1 for mono, 2 for stereoscopic.
   */
  public open fun _getViewCount(): Long {
    throw NotImplementedError("XRInterfaceExtension::_getViewCount is not implemented.")
  }

  /**
   * Returns the [Transform3D] that positions the [XRCamera3D] in the world.
   */
  public open fun _getCameraTransform(): Transform3D {
    throw NotImplementedError("XRInterfaceExtension::_getCameraTransform is not implemented.")
  }

  /**
   * Returns a [Transform3D] for a given view.
   */
  public open fun _getTransformForView(view: Long, camTransform: Transform3D): Transform3D {
    throw NotImplementedError("XRInterfaceExtension::_getTransformForView is not implemented.")
  }

  /**
   * Returns the projection matrix for the given view as a [PackedFloat64Array].
   */
  public open fun _getProjectionForView(
    view: Long,
    aspect: Double,
    zNear: Double,
    zFar: Double,
  ): PackedFloat64Array {
    throw NotImplementedError("XRInterfaceExtension::_getProjectionForView is not implemented.")
  }

  public open fun _getVrsTexture(): RID {
    throw NotImplementedError("XRInterfaceExtension::_getVrsTexture is not implemented.")
  }

  /**
   * Returns the format of the texture returned by [_getVrsTexture].
   */
  public open fun _getVrsTextureFormat(): XRInterface.VRSTextureFormat {
    throw NotImplementedError("XRInterfaceExtension::_getVrsTextureFormat is not implemented.")
  }

  /**
   * Called if this [XRInterfaceExtension] is active before our physics and game process is called.
   * Most XR interfaces will update its [XRPositionalTracker]s at this point in time.
   */
  public open fun _process(): Unit {
    throw NotImplementedError("XRInterfaceExtension::_process is not implemented.")
  }

  /**
   * Called if this [XRInterfaceExtension] is active before rendering starts. Most XR interfaces
   * will sync tracking at this point in time.
   */
  public open fun _preRender(): Unit {
    throw NotImplementedError("XRInterfaceExtension::_preRender is not implemented.")
  }

  /**
   * Called if this is our primary [XRInterfaceExtension] before we start processing a [Viewport]
   * for every active XR [Viewport], returns `true` if that viewport should be rendered. An XR
   * interface may return `false` if the user has taken off their headset and we can pause rendering.
   */
  public open fun _preDrawViewport(renderTarget: RID): Boolean {
    throw NotImplementedError("XRInterfaceExtension::_preDrawViewport is not implemented.")
  }

  /**
   * Called after the XR [Viewport] draw logic has completed.
   */
  public open fun _postDrawViewport(renderTarget: RID, screenRect: Rect2): Unit {
    throw NotImplementedError("XRInterfaceExtension::_postDrawViewport is not implemented.")
  }

  /**
   * Called if interface is active and queues have been submitted.
   */
  public open fun _endFrame(): Unit {
    throw NotImplementedError("XRInterfaceExtension::_endFrame is not implemented.")
  }

  /**
   * Returns a [PackedStringArray] with tracker names configured by this interface. Note that user
   * configuration can override this list.
   */
  public open fun _getSuggestedTrackerNames(): PackedStringArray {
    throw NotImplementedError("XRInterfaceExtension::_getSuggestedTrackerNames is not implemented.")
  }

  /**
   * Returns a [PackedStringArray] with pose names configured by this interface. Note that user
   * configuration can override this list.
   */
  public open fun _getSuggestedPoseNames(trackerName: StringName): PackedStringArray {
    throw NotImplementedError("XRInterfaceExtension::_getSuggestedPoseNames is not implemented.")
  }

  /**
   * Returns the current status of our tracking.
   */
  public open fun _getTrackingStatus(): XRInterface.TrackingStatus {
    throw NotImplementedError("XRInterfaceExtension::_getTrackingStatus is not implemented.")
  }

  /**
   * Triggers a haptic pulse to be emitted on the specified tracker.
   */
  public open fun _triggerHapticPulse(
    actionName: String,
    trackerName: StringName,
    frequency: Double,
    amplitude: Double,
    durationSec: Double,
    delaySec: Double,
  ): Unit {
    throw NotImplementedError("XRInterfaceExtension::_triggerHapticPulse is not implemented.")
  }

  /**
   * Return `true` if anchor detection is enabled for this interface.
   */
  public open fun _getAnchorDetectionIsEnabled(): Boolean {
    throw NotImplementedError("XRInterfaceExtension::_getAnchorDetectionIsEnabled is not implemented.")
  }

  /**
   * Enables anchor detection on this interface if supported.
   */
  public open fun _setAnchorDetectionIsEnabled(enabled: Boolean): Unit {
    throw NotImplementedError("XRInterfaceExtension::_setAnchorDetectionIsEnabled is not implemented.")
  }

  /**
   * Returns the camera feed ID for the [CameraFeed] registered with the [CameraServer] that should
   * be presented as the background on an AR capable device (if applicable).
   */
  public open fun _getCameraFeedId(): Int {
    throw NotImplementedError("XRInterfaceExtension::_getCameraFeedId is not implemented.")
  }

  /**
   * Return color texture into which to render (if applicable).
   */
  public open fun _getColorTexture(): RID {
    throw NotImplementedError("XRInterfaceExtension::_getColorTexture is not implemented.")
  }

  /**
   * Return depth texture into which to render (if applicable).
   */
  public open fun _getDepthTexture(): RID {
    throw NotImplementedError("XRInterfaceExtension::_getDepthTexture is not implemented.")
  }

  /**
   * Return velocity texture into which to render (if applicable).
   */
  public open fun _getVelocityTexture(): RID {
    throw NotImplementedError("XRInterfaceExtension::_getVelocityTexture is not implemented.")
  }

  public final fun getColorTexture(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getColorTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun getDepthTexture(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getDepthTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public final fun getVelocityTexture(): RID {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getVelocityTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  /**
   * Blits our render results to screen optionally applying lens distortion. This can only be called
   * while processing `_commit_views`.
   */
  public final fun addBlit(
    renderTarget: RID,
    srcRect: Rect2,
    dstRect: Rect2i,
    useLayer: Boolean,
    layer: Long,
    applyLensDistortion: Boolean,
    eyeCenter: Vector2,
    k1: Double,
    k2: Double,
    upscale: Double,
    aspectRatio: Double,
  ): Unit {
    TransferContext.writeMethodArguments_RID_RECT2_RECT2I_BOOL_LONG_BOOL_VECTOR2_DOUBLE_DOUBLE_DOUBLE_DOUBLE(ptr, objectID.id, renderTarget, srcRect, dstRect, useLayer, layer, applyLensDistortion, eyeCenter, k1, k2, upscale, aspectRatio)
    TransferContext.callPtrMethod(MethodBindings.addBlitPtr, 0)
  }

  /**
   * Returns a valid [RID] for a texture to which we should render the current frame if supported by
   * the interface.
   */
  public final fun getRenderTargetTexture(renderTarget: RID): RID {
    TransferContext.writeMethodArguments_RID(ptr, objectID.id, renderTarget)
    TransferContext.callPtrMethod(MethodBindings.getRenderTargetTexturePtr, 23)
    return TransferContext.readReturnValue_RID()
  }

  public companion object {
    @JvmField
    public val getColorTextureName: MethodStringName0<XRInterfaceExtension, RID> =
        MethodStringName0<XRInterfaceExtension, RID>("get_color_texture")

    @JvmField
    public val getDepthTextureName: MethodStringName0<XRInterfaceExtension, RID> =
        MethodStringName0<XRInterfaceExtension, RID>("get_depth_texture")

    @JvmField
    public val getVelocityTextureName: MethodStringName0<XRInterfaceExtension, RID> =
        MethodStringName0<XRInterfaceExtension, RID>("get_velocity_texture")

    @JvmField
    public val addBlitName:
        MethodStringName11<XRInterfaceExtension, Unit, RID, Rect2, Rect2i, Boolean, Long, Boolean, Vector2, Double, Double, Double, Double>
        =
        MethodStringName11<XRInterfaceExtension, Unit, RID, Rect2, Rect2i, Boolean, Long, Boolean, Vector2, Double, Double, Double, Double>("add_blit")

    @JvmField
    public val getRenderTargetTextureName: MethodStringName1<XRInterfaceExtension, RID, RID> =
        MethodStringName1<XRInterfaceExtension, RID, RID>("get_render_target_texture")
  }

  public object MethodBindings {
    internal val getColorTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterfaceExtension", "get_color_texture", 529393457)

    internal val getDepthTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterfaceExtension", "get_depth_texture", 529393457)

    internal val getVelocityTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterfaceExtension", "get_velocity_texture", 529393457)

    internal val addBlitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterfaceExtension", "add_blit", 258596971)

    internal val getRenderTargetTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("XRInterfaceExtension", "get_render_target_texture", 41030802)
  }
}
