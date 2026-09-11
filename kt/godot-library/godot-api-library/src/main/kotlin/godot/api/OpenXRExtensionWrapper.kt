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
import godot.core.Callable
import godot.core.Dictionary
import godot.core.MethodStringName0
import godot.core.PackedStringArray
import godot.core.RID
import godot.core.VariantArray
import godot.core.VariantParser.OBJECT
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField

/**
 * [OpenXRExtensionWrapper] allows implementing OpenXR extensions with GDExtension. The extension
 * should be registered with [registerExtensionWrapper].
 *
 * When [OpenXRInterface] is initialized as the primary interface and any [Viewport] has
 * [Viewport.useXr] set to `true`, OpenXR will become involved in Godot's rendering process. If
 * [ProjectSettings.rendering/driver/threads/threadModel] is set to "Separate", Godot's renderer will
 * run on its own thread, and special care must be taken in all [OpenXRExtensionWrapper]s in order to
 * prevent crashes or unexpected behavior. Some virtual methods will be called on the render thread,
 * and any data they access should not be directly written to on the main thread. This is to prevent
 * two potential issues:
 *
 * 1. Changes intended for the next frame, taking effect on the current frame. When using the
 * "Separate" thread model, the main thread will immediately start working on the next frame while the
 * render thread may still be rendering the current frame. If the main thread changes anything used by
 * the render thread directly, the change could end up being used one frame earlier than intended.
 *
 * 2. Reading and writing to the same data at the same time from different threads can lead to the
 * render thread using data in an invalid state.
 *
 * In most cases, the solution is to use [RenderingServer.callOnRenderThread] to schedule
 * [Callable]s to write to any data used on the render thread. When using the "Separate" thread model,
 * these [Callable]s will run after the renderer finishes the current frame and before it starts
 * rendering the next frame. When not using this mode, they'll run immediately, so it's recommended to
 * always use [RenderingServer.callOnRenderThread] in these cases, which will allow your code to do the
 * right thing regardless of the thread model.
 *
 * Any virtual methods that run on the render thread will be noted below.
 */
@GodotBaseType
public open class OpenXRExtensionWrapper : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(451, scriptPtr)
  }

  /**
   * Returns a [Dictionary] of OpenXR extensions related to this extension. [xrVersion] specifies
   * the OpenXR version we're instantiating. This will be zero if the editor requests this list to flag
   * supported features. The [Dictionary] should contain the name of the extension, mapped to a `bool
   * *` cast to an integer:
   *
   * - If the `bool *` is a `nullptr` this extension is mandatory.
   *
   * - If the `bool *` points to a boolean, the boolean will be updated to `true` if the extension
   * is enabled.
   */
  public open fun _getRequestedExtensions(xrVersion: Long): Dictionary<Any?, Any?> {
    throw NotImplementedError("OpenXRExtensionWrapper::_getRequestedExtensions is not implemented.")
  }

  /**
   * Called before [_setViewConfigurationAndGetNextPointer] to allow the extension to reserve data
   * for the given number of views.
   */
  public open fun _prepareViewConfiguration(viewCount: Int): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_prepareViewConfiguration is not implemented.")
  }

  /**
   * Called to allow an extension to print additional information about its view configuration, if
   * applicable. This will only be called if verbose output is enabled.
   */
  public open fun _printViewConfigurationInfo(view: Int): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_printViewConfigurationInfo is not implemented.")
  }

  /**
   * Returns the number of composition layers this extension wrapper provides via
   * [_getCompositionLayer].
   *
   * This will only be called if the extension previously registered itself with
   * [OpenXRAPIExtension.registerCompositionLayerProvider].
   *
   * **Note:** This virtual method will be called on the render thread. Additionally, the data it
   * returns will be used shortly after this method is called, so it needs to remain valid until the
   * next time [_onPreRender] runs.
   */
  public open fun _getCompositionLayerCount(): Int {
    throw NotImplementedError("OpenXRExtensionWrapper::_getCompositionLayerCount is not implemented.")
  }

  /**
   * Returns a pointer to an `XrCompositionLayerBaseHeader` struct to provide the given composition
   * layer.
   *
   * This will only be called if the extension previously registered itself with
   * [OpenXRAPIExtension.registerCompositionLayerProvider].
   *
   * **Note:** This virtual method will be called on the render thread. Additionally, the data it
   * returns will be used shortly after this method is called, so it needs to remain valid until the
   * next time [_onPreRender] runs.
   */
  public open fun _getCompositionLayer(index: Int): Long {
    throw NotImplementedError("OpenXRExtensionWrapper::_getCompositionLayer is not implemented.")
  }

  /**
   * Returns an integer that will be used to sort the given composition layer provided via
   * [_getCompositionLayer]. Lower numbers will move the layer to the front of the list, and higher
   * numbers to the end. The default projection layer has an order of `0`, so layers provided by this
   * method should probably be above or below (but not exactly) `0`.
   *
   * This will only be called if the extension previously registered itself with
   * [OpenXRAPIExtension.registerCompositionLayerProvider].
   *
   * **Note:** This virtual method will be called on the render thread. Additionally, the data it
   * returns will be used shortly after this method is called, so it needs to remain valid until the
   * next time [_onPreRender] runs.
   */
  public open fun _getCompositionLayerOrder(index: Int): Int {
    throw NotImplementedError("OpenXRExtensionWrapper::_getCompositionLayerOrder is not implemented.")
  }

  /**
   * Returns a [PackedStringArray] of positional tracker names that are used within the extension
   * wrapper.
   */
  public open fun _getSuggestedTrackerNames(): PackedStringArray {
    throw NotImplementedError("OpenXRExtensionWrapper::_getSuggestedTrackerNames is not implemented.")
  }

  /**
   * Allows extensions to register additional controller metadata. This function is called even when
   * the OpenXR API is not constructed as the metadata needs to be available to the editor.
   *
   * Extensions should also provide metadata regardless of whether they are supported on the host
   * system. The controller data is used to setup action maps for users who may have access to the
   * relevant hardware.
   */
  public open
      fun _onRegisterMetadata(interactionProfileMetadata: OpenXRInteractionProfileMetadata?): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onRegisterMetadata is not implemented.")
  }

  /**
   * Called before the OpenXR instance is created.
   *
   * **Note:** This virtual method will be called on the main thread, however, it will be called
   * *before* OpenXR becomes involved in rendering, so it is safe to write to data that will be used by
   * the render thread.
   */
  public open fun _onBeforeInstanceCreated(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onBeforeInstanceCreated is not implemented.")
  }

  /**
   * Called right after the OpenXR instance is created.
   *
   * **Note:** This virtual method will be called on the main thread, however, it will be called
   * *before* OpenXR becomes involved in rendering, so it is safe to write to data that will be used by
   * the render thread.
   */
  public open fun _onInstanceCreated(instance: Long): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onInstanceCreated is not implemented.")
  }

  /**
   * Called right before the OpenXR instance is destroyed.
   *
   * **Note:** This virtual method will be called on the main thread, however, it will be called
   * *after* OpenXR is done being involved in rendering, so it is safe to write to data that was used
   * by the render thread.
   */
  public open fun _onInstanceDestroyed(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onInstanceDestroyed is not implemented.")
  }

  /**
   * Called right after the OpenXR session is created.
   *
   * **Note:** This virtual method will be called on the main thread, however, it will be called
   * *before* OpenXR becomes involved in rendering, so it is safe to write to data that will be used by
   * the render thread.
   */
  public open fun _onSessionCreated(session: Long): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onSessionCreated is not implemented.")
  }

  /**
   * Called as part of the OpenXR process handling. This happens right before general and physics
   * processing steps of the main loop. During this step controller data is queried and made available
   * to game logic.
   */
  public open fun _onProcess(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onProcess is not implemented.")
  }

  /**
   * Called when OpenXR has performed its action sync.
   */
  public open fun _onSyncActions(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onSyncActions is not implemented.")
  }

  /**
   * Called right before the XR viewports begin their rendering step.
   *
   * **Note:** This virtual method will be called on the render thread.
   */
  public open fun _onPreRender(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onPreRender is not implemented.")
  }

  /**
   * Called right after the main swapchains are (re)created.
   *
   * **Note:** This virtual method will be called on the render thread.
   */
  public open fun _onMainSwapchainsCreated(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onMainSwapchainsCreated is not implemented.")
  }

  /**
   * Called right before the given viewport is rendered.
   *
   * **Note:** This virtual method will be called on the render thread.
   */
  public open fun _onPreDrawViewport(viewport: RID): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onPreDrawViewport is not implemented.")
  }

  /**
   * Called right after the given viewport is rendered.
   *
   * **Note:** The draw commands might only be queued at this point, not executed.
   *
   * **Note:** This virtual method will be called on the render thread.
   */
  public open fun _onPostDrawViewport(viewport: RID): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onPostDrawViewport is not implemented.")
  }

  /**
   * Called right before the OpenXR session is destroyed.
   *
   * **Note:** This virtual method will be called on the main thread, however, it will be called
   * *after* OpenXR is done being involved in rendering, so it is safe to write to data that was used
   * by the render thread.
   */
  public open fun _onSessionDestroyed(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onSessionDestroyed is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to idle.
   */
  public open fun _onStateIdle(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateIdle is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to ready. This means OpenXR is ready to set up
   * the session.
   */
  public open fun _onStateReady(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateReady is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to synchronized. OpenXR also returns to this
   * state when the application loses focus.
   */
  public open fun _onStateSynchronized(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateSynchronized is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to visible. This means OpenXR is now ready to
   * receive frames.
   */
  public open fun _onStateVisible(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateVisible is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to focused. This state is the active state when
   * the game runs.
   */
  public open fun _onStateFocused(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateFocused is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to stopping.
   */
  public open fun _onStateStopping(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateStopping is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to loss pending.
   */
  public open fun _onStateLossPending(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateLossPending is not implemented.")
  }

  /**
   * Called when the OpenXR session state is changed to exiting.
   */
  public open fun _onStateExiting(): Unit {
    throw NotImplementedError("OpenXRExtensionWrapper::_onStateExiting is not implemented.")
  }

  /**
   * Gets an array of [Dictionary]s that represent properties, just like [Object.GetPropertyList],
   * that will be added to [OpenXRCompositionLayer] nodes.
   *
   * **Note:** This virtual method will be called on the render thread.
   */
  public open fun _getViewportCompositionLayerExtensionProperties():
      VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("OpenXRExtensionWrapper::_getViewportCompositionLayerExtensionProperties is not implemented.")
  }

  /**
   * Gets a [Dictionary] containing the default values for the properties returned by
   * [_getViewportCompositionLayerExtensionProperties].
   */
  public open fun _getViewportCompositionLayerExtensionPropertyDefaults(): Dictionary<Any?, Any?> {
    throw NotImplementedError("OpenXRExtensionWrapper::_getViewportCompositionLayerExtensionPropertyDefaults is not implemented.")
  }

  /**
   * Returns the created [OpenXRAPIExtension], which can be used to access the OpenXR API.
   */
  public final fun getOpenxrApi(): OpenXRAPIExtension? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getOpenxrApiPtr)
    return (TransferContext.readReturnValue(OBJECT) as OpenXRAPIExtension?)
  }

  /**
   * Registers the extension. This should happen at core module initialization level.
   *
   * **Note:** This cannot be called once OpenXR has been initialized.
   */
  public final fun registerExtensionWrapper(): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.registerExtensionWrapperPtr)
  }

  public companion object {
    @JvmField
    public val getOpenxrApiName: MethodStringName0<OpenXRExtensionWrapper, OpenXRAPIExtension?> =
        MethodStringName0<OpenXRExtensionWrapper, OpenXRAPIExtension?>("get_openxr_api")

    @JvmField
    public val registerExtensionWrapperName: MethodStringName0<OpenXRExtensionWrapper, Unit> =
        MethodStringName0<OpenXRExtensionWrapper, Unit>("register_extension_wrapper")
  }

  public object MethodBindings {
    internal val getOpenxrApiPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRExtensionWrapper", "get_openxr_api", 1637791613)

    internal val registerExtensionWrapperPtr: VoidPtr =
        TypeManager.getMethodBindPtr("OpenXRExtensionWrapper", "register_extension_wrapper", 3218959716)
  }
}
