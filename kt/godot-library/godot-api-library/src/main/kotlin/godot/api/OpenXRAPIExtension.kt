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
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName7
import godot.core.PackedInt64Array
import godot.core.RID
import godot.core.Rect2i
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.VariantParser.ARRAY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.DOUBLE
import godot.core.VariantParser.LONG
import godot.core.VariantParser.OBJECT
import godot.core.VariantParser.PACKED_INT_64_ARRAY
import godot.core.VariantParser.RECT2I
import godot.core.VariantParser.STRING
import godot.core.VariantParser.VECTOR2I
import godot.core.VariantParser._RID
import godot.core.Vector2i
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmStatic

/**
 * [OpenXRAPIExtension] makes OpenXR available for GDExtension. It provides the OpenXR API to
 * GDExtension through the [getInstanceProcAddr] method, and the OpenXR instance through [getInstance].
 *
 * It also provides methods for querying the status of OpenXR initialization, and helper methods for
 * ease of use of the API with GDExtension.
 */
@GodotBaseType
public open class OpenXRAPIExtension : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(437, scriptPtr)
  }

  /**
   * Returns the version of OpenXR that was initialized. Only valid after the OpenXR instance has
   * been created. See
   * [url=https://registry.khronos.org/OpenXR/specs/1.1/html/xrspec.html#XR_MAKE_VERSION]XR_MAKE_VERSION[/url]
   * for how the version is calculated.
   */
  public final fun getOpenxrVersion(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOpenxrVersionPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrInstance.html]XrInstance[/url]
   * created during the initialization of the OpenXR API.
   */
  public final fun getInstance(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInstancePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the ID of the system, which is an
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrSystemId.html]XrSystemId[/url] cast
   * to an integer.
   */
  public final fun getSystemId(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSystemIdPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the OpenXR session, which is an
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrSession.html]XrSession[/url] cast to
   * an integer.
   */
  public final fun getSession(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSessionPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if the provided
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrResult.html]XrResult[/url] (cast to
   * an integer) is successful. Otherwise returns `false` and prints the
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrResult.html]XrResult[/url] converted
   * to a string, with the specified additional information.
   */
  public final fun xrResult(
    result: Long,
    format: String,
    args: VariantArray<Any?>,
  ): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to result, STRING to format, ARRAY to args)
    TransferContext.callMethod(MethodBindings.xrResultPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the function pointer of the OpenXR function with the specified name, cast to an
   * integer. If the function with the given name does not exist, the method returns `0`.
   *
   * **Note:** `openxr/util.h` contains utility macros for acquiring OpenXR functions, e.g.
   * `GDEXTENSION_INIT_XR_FUNC_V(xrCreateAction)`.
   */
  public final fun getInstanceProcAddr(name: String): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name)
    TransferContext.callMethod(MethodBindings.getInstanceProcAddrPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns an error string for the given
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrResult.html]XrResult[/url].
   */
  public final fun getErrorString(result: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to result)
    TransferContext.callMethod(MethodBindings.getErrorStringPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the name of the specified swapchain format.
   */
  public final fun getSwapchainFormatName(swapchainFormat: Long): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to swapchainFormat)
    TransferContext.callMethod(MethodBindings.getSwapchainFormatNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Set the object name of an OpenXR object, used for debug output. [objectType] must be a valid
   * OpenXR `XrObjectType` enum and [objectHandle] must be a valid OpenXR object handle.
   */
  public final fun setObjectName(
    objectType: Long,
    objectHandle: Long,
    objectName: String,
  ): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to objectType, LONG to objectHandle, STRING to objectName)
    TransferContext.callMethod(MethodBindings.setObjectNamePtr)
  }

  /**
   * Begins a new debug label region, this label will be reported in debug messages for any calls
   * following this until [endDebugLabelRegion] is called. Debug labels can be stacked.
   */
  public final fun beginDebugLabelRegion(labelName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to labelName)
    TransferContext.callMethod(MethodBindings.beginDebugLabelRegionPtr)
  }

  /**
   * Marks the end of a debug label region. Removes the latest debug label region added by calling
   * [beginDebugLabelRegion].
   */
  public final fun endDebugLabelRegion(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.endDebugLabelRegionPtr)
  }

  /**
   * Inserts a debug label, this label is reported in any debug message resulting from the OpenXR
   * calls that follows, until any of [beginDebugLabelRegion], [endDebugLabelRegion], or
   * [insertDebugLabel] is called.
   */
  public final fun insertDebugLabel(labelName: String): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to labelName)
    TransferContext.callMethod(MethodBindings.insertDebugLabelPtr)
  }

  /**
   * Returns the number of views. It is usually two, one for each eye, but may differ with different
   * view configurations.
   */
  public final fun getViewCount(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getViewCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the view configuration type, which is an
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrViewConfigurationType.html]XrViewConfigurationType[/url]
   * cast to an integer.
   */
  public final fun getViewConfiguration(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getViewConfigurationPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if OpenXR is initialized.
   */
  public final fun isInitialized(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isInitializedPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns `true` if OpenXR is running
   * ([url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/xrBeginSession.html]xrBeginSession[/url]
   * was successfully called and the swapchains were created).
   */
  public final fun isRunning(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isRunningPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the play space, which is an
   * [url=https://registry.khronos.org/OpenXR/specs/1.0/man/html/XrSpace.html]XrSpace[/url] cast to an
   * integer.
   */
  public final fun getPlaySpace(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPlaySpacePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the predicted display timing for the current frame.
   */
  public final fun getPredictedDisplayTime(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getPredictedDisplayTimePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the predicted display timing for the next frame.
   */
  public final fun getNextFrameTime(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getNextFrameTimePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns `true` if OpenXR is initialized for rendering with an XR viewport.
   */
  public final fun canRender(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canRenderPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the [RID] corresponding to an `Action` of a matching name, optionally limited to a
   * specified action set.
   */
  public final fun findAction(name: String, actionSet: RID): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to name, _RID to actionSet)
    TransferContext.callMethod(MethodBindings.findActionPtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Returns the corresponding `XrAction` OpenXR handle for the given action RID.
   */
  public final fun actionGetHandle(action: RID): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to action)
    TransferContext.callMethod(MethodBindings.actionGetHandlePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Returns the corresponding `XRHandTrackerEXT` handle for the given hand index value.
   */
  public final fun getHandTracker(handIndex: Int): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to handIndex.toLong())
    TransferContext.callMethod(MethodBindings.getHandTrackerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Registers the given extension as a composition layer provider.
   *
   * **Note:** This cannot be called after the OpenXR session has started. However, it can be called
   * in [OpenXRExtensionWrapper.OnSessionCreated].
   */
  public final fun registerCompositionLayerProvider(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.registerCompositionLayerProviderPtr)
  }

  /**
   * Unregisters the given extension as a composition layer provider.
   *
   * **Note:** This cannot be called while the OpenXR session is still running.
   */
  public final fun unregisterCompositionLayerProvider(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.unregisterCompositionLayerProviderPtr)
  }

  /**
   * Registers the given extension as a provider of additional data structures to projections views.
   *
   * **Note:** This cannot be called after the OpenXR session has started. However, it can be called
   * in [OpenXRExtensionWrapper.OnSessionCreated].
   */
  public final fun registerProjectionViewsExtension(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.registerProjectionViewsExtensionPtr)
  }

  /**
   * Unregisters the given extension as a provider of additional data structures to projections
   * views.
   *
   * **Note:** This cannot be called while the OpenXR session is still running.
   */
  public final fun unregisterProjectionViewsExtension(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.unregisterProjectionViewsExtensionPtr)
  }

  /**
   * Registers the given extension as modifying frame info via the
   * [OpenXRExtensionWrapper.SetFrameWaitInfoAndGetNextPointer],
   * [OpenXRExtensionWrapper.SetViewLocateInfoAndGetNextPointer], or
   * [OpenXRExtensionWrapper.SetFrameEndInfoAndGetNextPointer] virtual methods.
   *
   * **Note:** This cannot be called after the OpenXR session has started. However, it can be called
   * in [OpenXRExtensionWrapper.OnSessionCreated].
   */
  public final fun registerFrameInfoExtension(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.registerFrameInfoExtensionPtr)
  }

  /**
   * Unregisters the given extension as modifying frame info.
   *
   * **Note:** This cannot be called while the OpenXR session is still running.
   */
  public final fun unregisterFrameInfoExtension(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.unregisterFrameInfoExtensionPtr)
  }

  /**
   * Registers the given extension as modifying `XrCompositionLayerProjection` via the
   * [OpenXRExtensionWrapper.SetProjectionLayerAndGetNextPointer] virtual method.
   *
   * **Note:** This cannot be called after the OpenXR session has started. However, it can be called
   * in [OpenXRExtensionWrapper.OnSessionCreated].
   */
  public final fun registerProjectionLayerExtension(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.registerProjectionLayerExtensionPtr)
  }

  /**
   * Unregisters the given extension as modifying `XrCompositionLayerProjection`.
   *
   * **Note:** This cannot be called while the OpenXR session is still running.
   */
  public final fun unregisterProjectionLayerExtension(extension: OpenXRExtensionWrapper?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, OBJECT to extension)
    TransferContext.callMethod(MethodBindings.unregisterProjectionLayerExtensionPtr)
  }

  /**
   * Returns the near boundary value of the camera frustum.
   *
   * **Note:** This is only accessible in the render thread.
   */
  public final fun getRenderStateZNear(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderStateZNearPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Returns the far boundary value of the camera frustum.
   *
   * **Note:** This is only accessible in the render thread.
   */
  public final fun getRenderStateZFar(): Double {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRenderStateZFarPtr)
    return (TransferContext.readReturnValue(DOUBLE) as Double)
  }

  /**
   * Sets the render target of the velocity texture.
   */
  public final fun setVelocityTexture(renderTarget: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to renderTarget)
    TransferContext.callMethod(MethodBindings.setVelocityTexturePtr)
  }

  /**
   * Sets the render target of the velocity depth texture.
   */
  public final fun setVelocityDepthTexture(renderTarget: RID): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, _RID to renderTarget)
    TransferContext.callMethod(MethodBindings.setVelocityDepthTexturePtr)
  }

  /**
   * Sets the target size of the velocity and velocity depth textures.
   */
  public final fun setVelocityTargetSize(targetSize: Vector2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, VECTOR2I to targetSize)
    TransferContext.callMethod(MethodBindings.setVelocityTargetSizePtr)
  }

  /**
   * Returns an array of supported swapchain formats.
   */
  public final fun getSupportedSwapchainFormats(): PackedInt64Array {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSupportedSwapchainFormatsPtr)
    return (TransferContext.readReturnValue(PACKED_INT_64_ARRAY) as PackedInt64Array)
  }

  /**
   * Returns a pointer to a new swapchain created using the provided parameters.
   */
  public final fun openxrSwapchainCreate(
    createFlags: Long,
    usageFlags: Long,
    swapchainFormat: Long,
    width: Long,
    height: Long,
    sampleCount: Long,
    arraySize: Long,
  ): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to createFlags, LONG to usageFlags, LONG to swapchainFormat, LONG to width, LONG to height, LONG to sampleCount, LONG to arraySize)
    TransferContext.callMethod(MethodBindings.openxrSwapchainCreatePtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Destroys the provided swapchain and frees it from memory.
   */
  public final fun openxrSwapchainFree(swapchain: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to swapchain)
    TransferContext.callMethod(MethodBindings.openxrSwapchainFreePtr)
  }

  /**
   * Returns the `XrSwapchain` handle of the provided swapchain.
   */
  public final fun openxrSwapchainGetSwapchain(swapchain: Long): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to swapchain)
    TransferContext.callMethod(MethodBindings.openxrSwapchainGetSwapchainPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Acquires the image of the provided swapchain.
   */
  public final fun openxrSwapchainAcquire(swapchain: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to swapchain)
    TransferContext.callMethod(MethodBindings.openxrSwapchainAcquirePtr)
  }

  /**
   * Returns the RID of the provided swapchain's image.
   */
  public final fun openxrSwapchainGetImage(swapchain: Long): RID {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to swapchain)
    TransferContext.callMethod(MethodBindings.openxrSwapchainGetImagePtr)
    return (TransferContext.readReturnValue(_RID) as RID)
  }

  /**
   * Releases the image of the provided swapchain.
   */
  public final fun openxrSwapchainRelease(swapchain: Long): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to swapchain)
    TransferContext.callMethod(MethodBindings.openxrSwapchainReleasePtr)
  }

  /**
   * Returns a pointer to the render state's `XrCompositionLayerProjection` struct.
   *
   * **Note:** This method should only be called from the rendering thread.
   */
  public final fun getProjectionLayer(): Long {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getProjectionLayerPtr)
    return (TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Sets the render region to [renderRegion], overriding the normal render target's rect.
   */
  public final fun setRenderRegion(renderRegion: Rect2i): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, RECT2I to renderRegion)
    TransferContext.callMethod(MethodBindings.setRenderRegionPtr)
  }

  /**
   * If set to `true`, an OpenXR extension is loaded which is capable of emulating the
   * [XRInterface.XR_ENV_BLEND_MODE_ALPHA_BLEND] blend mode.
   */
  public final fun setEmulateEnvironmentBlendModeAlphaBlend(enabled: Boolean): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, BOOL to enabled)
    TransferContext.callMethod(MethodBindings.setEmulateEnvironmentBlendModeAlphaBlendPtr)
  }

  /**
   * Returns [OpenXRAPIExtension.OpenXRAlphaBlendModeSupport] denoting if
   * [XRInterface.XR_ENV_BLEND_MODE_ALPHA_BLEND] is really supported, emulated or not supported at all.
   */
  public final fun isEnvironmentBlendModeAlphaSupported(): OpenXRAlphaBlendModeSupport {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEnvironmentBlendModeAlphaSupportedPtr)
    return OpenXRAlphaBlendModeSupport.from(TransferContext.readReturnValue(LONG) as Long)
  }

  /**
   * Request the recommended resolution from the OpenXR runtime and update the main swapchain size
   * if it has changed.
   */
  public final fun updateMainSwapchainSize(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.updateMainSwapchainSizePtr)
  }

  public enum class OpenXRAlphaBlendModeSupport(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Means that [XRInterface.XR_ENV_BLEND_MODE_ALPHA_BLEND] isn't supported at all.
     */
    OPENXR_ALPHA_BLEND_MODE_SUPPORT_NONE(0),
    /**
     * Means that [XRInterface.XR_ENV_BLEND_MODE_ALPHA_BLEND] is really supported.
     */
    OPENXR_ALPHA_BLEND_MODE_SUPPORT_REAL(1),
    /**
     * Means that [XRInterface.XR_ENV_BLEND_MODE_ALPHA_BLEND] is emulated.
     */
    OPENXR_ALPHA_BLEND_MODE_SUPPORT_EMULATING(2),
    ;

    public companion object {
      public fun from(`value`: Long): OpenXRAlphaBlendModeSupport =
          entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val getOpenxrVersionName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_openxr_version")

    @JvmField
    public val getInstanceName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_instance")

    @JvmField
    public val getSystemIdName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_system_id")

    @JvmField
    public val getSessionName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_session")

    @JvmField
    public val xrResultName:
        MethodStringName3<OpenXRAPIExtension, Boolean, Long, String, VariantArray<Any?>> =
        MethodStringName3<OpenXRAPIExtension, Boolean, Long, String, VariantArray<Any?>>("xr_result")

    @JvmField
    public val openxrIsEnabledName: MethodStringName1<OpenXRAPIExtension, Boolean, Boolean> =
        MethodStringName1<OpenXRAPIExtension, Boolean, Boolean>("openxr_is_enabled")

    @JvmField
    public val getInstanceProcAddrName: MethodStringName1<OpenXRAPIExtension, Long, String> =
        MethodStringName1<OpenXRAPIExtension, Long, String>("get_instance_proc_addr")

    @JvmField
    public val getErrorStringName: MethodStringName1<OpenXRAPIExtension, String, Long> =
        MethodStringName1<OpenXRAPIExtension, String, Long>("get_error_string")

    @JvmField
    public val getSwapchainFormatNameName: MethodStringName1<OpenXRAPIExtension, String, Long> =
        MethodStringName1<OpenXRAPIExtension, String, Long>("get_swapchain_format_name")

    @JvmField
    public val setObjectNameName: MethodStringName3<OpenXRAPIExtension, Unit, Long, Long, String> =
        MethodStringName3<OpenXRAPIExtension, Unit, Long, Long, String>("set_object_name")

    @JvmField
    public val beginDebugLabelRegionName: MethodStringName1<OpenXRAPIExtension, Unit, String> =
        MethodStringName1<OpenXRAPIExtension, Unit, String>("begin_debug_label_region")

    @JvmField
    public val endDebugLabelRegionName: MethodStringName0<OpenXRAPIExtension, Unit> =
        MethodStringName0<OpenXRAPIExtension, Unit>("end_debug_label_region")

    @JvmField
    public val insertDebugLabelName: MethodStringName1<OpenXRAPIExtension, Unit, String> =
        MethodStringName1<OpenXRAPIExtension, Unit, String>("insert_debug_label")

    @JvmField
    public val getViewCountName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_view_count")

    @JvmField
    public val getViewConfigurationName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_view_configuration")

    @JvmField
    public val isInitializedName: MethodStringName0<OpenXRAPIExtension, Boolean> =
        MethodStringName0<OpenXRAPIExtension, Boolean>("is_initialized")

    @JvmField
    public val isRunningName: MethodStringName0<OpenXRAPIExtension, Boolean> =
        MethodStringName0<OpenXRAPIExtension, Boolean>("is_running")

    @JvmField
    public val getPlaySpaceName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_play_space")

    @JvmField
    public val getPredictedDisplayTimeName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_predicted_display_time")

    @JvmField
    public val getNextFrameTimeName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_next_frame_time")

    @JvmField
    public val canRenderName: MethodStringName0<OpenXRAPIExtension, Boolean> =
        MethodStringName0<OpenXRAPIExtension, Boolean>("can_render")

    @JvmField
    public val findActionName: MethodStringName2<OpenXRAPIExtension, RID, String, RID> =
        MethodStringName2<OpenXRAPIExtension, RID, String, RID>("find_action")

    @JvmField
    public val actionGetHandleName: MethodStringName1<OpenXRAPIExtension, Long, RID> =
        MethodStringName1<OpenXRAPIExtension, Long, RID>("action_get_handle")

    @JvmField
    public val getHandTrackerName: MethodStringName1<OpenXRAPIExtension, Long, Int> =
        MethodStringName1<OpenXRAPIExtension, Long, Int>("get_hand_tracker")

    @JvmField
    public val registerCompositionLayerProviderName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("register_composition_layer_provider")

    @JvmField
    public val unregisterCompositionLayerProviderName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("unregister_composition_layer_provider")

    @JvmField
    public val registerProjectionViewsExtensionName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("register_projection_views_extension")

    @JvmField
    public val unregisterProjectionViewsExtensionName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("unregister_projection_views_extension")

    @JvmField
    public val registerFrameInfoExtensionName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("register_frame_info_extension")

    @JvmField
    public val unregisterFrameInfoExtensionName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("unregister_frame_info_extension")

    @JvmField
    public val registerProjectionLayerExtensionName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("register_projection_layer_extension")

    @JvmField
    public val unregisterProjectionLayerExtensionName:
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?> =
        MethodStringName1<OpenXRAPIExtension, Unit, OpenXRExtensionWrapper?>("unregister_projection_layer_extension")

    @JvmField
    public val getRenderStateZNearName: MethodStringName0<OpenXRAPIExtension, Double> =
        MethodStringName0<OpenXRAPIExtension, Double>("get_render_state_z_near")

    @JvmField
    public val getRenderStateZFarName: MethodStringName0<OpenXRAPIExtension, Double> =
        MethodStringName0<OpenXRAPIExtension, Double>("get_render_state_z_far")

    @JvmField
    public val setVelocityTextureName: MethodStringName1<OpenXRAPIExtension, Unit, RID> =
        MethodStringName1<OpenXRAPIExtension, Unit, RID>("set_velocity_texture")

    @JvmField
    public val setVelocityDepthTextureName: MethodStringName1<OpenXRAPIExtension, Unit, RID> =
        MethodStringName1<OpenXRAPIExtension, Unit, RID>("set_velocity_depth_texture")

    @JvmField
    public val setVelocityTargetSizeName: MethodStringName1<OpenXRAPIExtension, Unit, Vector2i> =
        MethodStringName1<OpenXRAPIExtension, Unit, Vector2i>("set_velocity_target_size")

    @JvmField
    public val getSupportedSwapchainFormatsName:
        MethodStringName0<OpenXRAPIExtension, PackedInt64Array> =
        MethodStringName0<OpenXRAPIExtension, PackedInt64Array>("get_supported_swapchain_formats")

    @JvmField
    public val openxrSwapchainCreateName:
        MethodStringName7<OpenXRAPIExtension, Long, Long, Long, Long, Long, Long, Long, Long> =
        MethodStringName7<OpenXRAPIExtension, Long, Long, Long, Long, Long, Long, Long, Long>("openxr_swapchain_create")

    @JvmField
    public val openxrSwapchainFreeName: MethodStringName1<OpenXRAPIExtension, Unit, Long> =
        MethodStringName1<OpenXRAPIExtension, Unit, Long>("openxr_swapchain_free")

    @JvmField
    public val openxrSwapchainGetSwapchainName: MethodStringName1<OpenXRAPIExtension, Long, Long> =
        MethodStringName1<OpenXRAPIExtension, Long, Long>("openxr_swapchain_get_swapchain")

    @JvmField
    public val openxrSwapchainAcquireName: MethodStringName1<OpenXRAPIExtension, Unit, Long> =
        MethodStringName1<OpenXRAPIExtension, Unit, Long>("openxr_swapchain_acquire")

    @JvmField
    public val openxrSwapchainGetImageName: MethodStringName1<OpenXRAPIExtension, RID, Long> =
        MethodStringName1<OpenXRAPIExtension, RID, Long>("openxr_swapchain_get_image")

    @JvmField
    public val openxrSwapchainReleaseName: MethodStringName1<OpenXRAPIExtension, Unit, Long> =
        MethodStringName1<OpenXRAPIExtension, Unit, Long>("openxr_swapchain_release")

    @JvmField
    public val getProjectionLayerName: MethodStringName0<OpenXRAPIExtension, Long> =
        MethodStringName0<OpenXRAPIExtension, Long>("get_projection_layer")

    @JvmField
    public val setRenderRegionName: MethodStringName1<OpenXRAPIExtension, Unit, Rect2i> =
        MethodStringName1<OpenXRAPIExtension, Unit, Rect2i>("set_render_region")

    @JvmField
    public val setEmulateEnvironmentBlendModeAlphaBlendName:
        MethodStringName1<OpenXRAPIExtension, Unit, Boolean> =
        MethodStringName1<OpenXRAPIExtension, Unit, Boolean>("set_emulate_environment_blend_mode_alpha_blend")

    @JvmField
    public val isEnvironmentBlendModeAlphaSupportedName:
        MethodStringName0<OpenXRAPIExtension, OpenXRAlphaBlendModeSupport> =
        MethodStringName0<OpenXRAPIExtension, OpenXRAlphaBlendModeSupport>("is_environment_blend_mode_alpha_supported")

    @JvmField
    public val updateMainSwapchainSizeName: MethodStringName0<OpenXRAPIExtension, Unit> =
        MethodStringName0<OpenXRAPIExtension, Unit>("update_main_swapchain_size")

    /**
     * Returns `true` if OpenXR is enabled.
     */
    @JvmStatic
    public final fun openxrIsEnabled(checkRunInEditor: Boolean): Boolean {
      TransferContext.writeMethodArguments(0L, 0L, BOOL to checkRunInEditor)
      TransferContext.callMethod(MethodBindings.openxrIsEnabledPtr)
      return (TransferContext.readReturnValue(BOOL) as Boolean)
    }
  }

  public object MethodBindings {
    internal val getOpenxrVersionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_openxr_version", 2455072627)

    internal val getInstancePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_instance", 2455072627)

    internal val getSystemIdPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_system_id", 2455072627)

    internal val getSessionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_session", 2455072627)

    internal val transformFromPosePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "transform_from_pose", 2963875352)

    internal val xrResultPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "xr_result", 3886436197)

    internal val openxrIsEnabledPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "openxr_is_enabled", 2703660260)

    internal val getInstanceProcAddrPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_instance_proc_addr", 1597066294)

    internal val getErrorStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_error_string", 990163283)

    internal val getSwapchainFormatNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_swapchain_format_name", 990163283)

    internal val setObjectNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "set_object_name", 2285447957)

    internal val beginDebugLabelRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "begin_debug_label_region", 83702148)

    internal val endDebugLabelRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "end_debug_label_region", 3218959716)

    internal val insertDebugLabelPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "insert_debug_label", 83702148)

    internal val getViewCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_view_count", 3905245786)

    internal val getViewConfigurationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_view_configuration", 3905245786)

    internal val isInitializedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "is_initialized", 2240911060)

    internal val isRunningPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "is_running", 2240911060)

    internal val setCustomPlaySpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "set_custom_play_space", 1286410249)

    internal val getPlaySpacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_play_space", 2455072627)

    internal val getPredictedDisplayTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_predicted_display_time", 2455072627)

    internal val getNextFrameTimePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_next_frame_time", 2455072627)

    internal val canRenderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "can_render", 2240911060)

    internal val findActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "find_action", 4106179378)

    internal val actionGetHandlePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "action_get_handle", 3917799429)

    internal val getHandTrackerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_hand_tracker", 3744713108)

    internal val registerCompositionLayerProviderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "register_composition_layer_provider", 1477360496)

    internal val unregisterCompositionLayerProviderPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "unregister_composition_layer_provider", 1477360496)

    internal val registerProjectionViewsExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "register_projection_views_extension", 1477360496)

    internal val unregisterProjectionViewsExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "unregister_projection_views_extension", 1477360496)

    internal val registerFrameInfoExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "register_frame_info_extension", 1477360496)

    internal val unregisterFrameInfoExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "unregister_frame_info_extension", 1477360496)

    internal val registerProjectionLayerExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "register_projection_layer_extension", 1477360496)

    internal val unregisterProjectionLayerExtensionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "unregister_projection_layer_extension", 1477360496)

    internal val getRenderStateZNearPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_render_state_z_near", 191475506)

    internal val getRenderStateZFarPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_render_state_z_far", 191475506)

    internal val setVelocityTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "set_velocity_texture", 2722037293)

    internal val setVelocityDepthTexturePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "set_velocity_depth_texture", 2722037293)

    internal val setVelocityTargetSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "set_velocity_target_size", 1130785943)

    internal val getSupportedSwapchainFormatsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_supported_swapchain_formats", 3851388692)

    internal val openxrSwapchainCreatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "openxr_swapchain_create", 2162228999)

    internal val openxrSwapchainFreePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "openxr_swapchain_free", 1286410249)

    internal val openxrSwapchainGetSwapchainPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "openxr_swapchain_get_swapchain", 3744713108)

    internal val openxrSwapchainAcquirePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "openxr_swapchain_acquire", 1286410249)

    internal val openxrSwapchainGetImagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "openxr_swapchain_get_image", 937000113)

    internal val openxrSwapchainReleasePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "openxr_swapchain_release", 1286410249)

    internal val getProjectionLayerPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "get_projection_layer", 2455072627)

    internal val setRenderRegionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "set_render_region", 1763793166)

    internal val setEmulateEnvironmentBlendModeAlphaBlendPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "set_emulate_environment_blend_mode_alpha_blend", 2586408642)

    internal val isEnvironmentBlendModeAlphaSupportedPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "is_environment_blend_mode_alpha_supported", 1579290861)

    internal val updateMainSwapchainSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRAPIExtension", "update_main_swapchain_size", 3218959716)
  }
}
