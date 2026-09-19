// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_CALLABLE_ret_OBJECT_REF
import godot.callMethod_PACKED_BYTE_ARRAY_STRING_STRING
import godot.callMethod_STRING_BOOL_ret_ANY
import godot.callMethod_STRING_VARARG_ret_ANY
import godot.callMethod_STRING_ret_OBJECT_REF
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_OBJECT_ret_BOOL
import godot.callPtrMethod_OBJECT_ret_PACKED_BYTE_ARRAY
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.PackedByteArray
import godot.core.Signal0
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * The JavaScriptBridge singleton is implemented only in the Web export. It's used to access the
 * browser's JavaScript context. This allows interaction with embedding pages or calling third-party
 * JavaScript APIs.
 *
 * **Note:** This singleton can be disabled at build-time to improve security. By default, the
 * JavaScriptBridge singleton is enabled. Official export templates also have the JavaScriptBridge
 * singleton enabled. See
 * [url=$DOCS_URL/engine_details/development/compiling/compiling_for_web.html]Compiling for the
 * Web[/url] in the documentation for more information.
 */
@GodotBaseType
public object JavaScriptBridge : Object() {
  @JvmField
  public val evalName: MethodStringName2<JavaScriptBridge, Any?, String, Boolean> =
      MethodStringName2<JavaScriptBridge, Any?, String, Boolean>("eval")

  @JvmField
  public val getInterfaceName: MethodStringName1<JavaScriptBridge, JavaScriptObject?, String> =
      MethodStringName1<JavaScriptBridge, JavaScriptObject?, String>("get_interface")

  @JvmField
  public val createCallbackName: MethodStringName1<JavaScriptBridge, JavaScriptObject?, Callable> =
      MethodStringName1<JavaScriptBridge, JavaScriptObject?, Callable>("create_callback")

  @JvmField
  public val isJsBufferName: MethodStringName1<JavaScriptBridge, Boolean, JavaScriptObject?> =
      MethodStringName1<JavaScriptBridge, Boolean, JavaScriptObject?>("is_js_buffer")

  @JvmField
  public val jsBufferToPackedByteArrayName:
      MethodStringName1<JavaScriptBridge, PackedByteArray, JavaScriptObject?> =
      MethodStringName1<JavaScriptBridge, PackedByteArray, JavaScriptObject?>("js_buffer_to_packed_byte_array")

  @JvmField
  public val downloadBufferName:
      MethodStringName3<JavaScriptBridge, Unit, PackedByteArray, String, String> =
      MethodStringName3<JavaScriptBridge, Unit, PackedByteArray, String, String>("download_buffer")

  @JvmField
  public val pwaNeedsUpdateName: MethodStringName0<JavaScriptBridge, Boolean> =
      MethodStringName0<JavaScriptBridge, Boolean>("pwa_needs_update")

  @JvmField
  public val pwaUpdateName: MethodStringName0<JavaScriptBridge, Error> =
      MethodStringName0<JavaScriptBridge, Error>("pwa_update")

  @JvmField
  public val forceFsSyncName: MethodStringName0<JavaScriptBridge, Unit> =
      MethodStringName0<JavaScriptBridge, Unit>("force_fs_sync")

  /**
   * Emitted when an update for this progressive web app has been detected but is waiting to be
   * activated because a previous version is active. See [pwaUpdate] to force the update to take place
   * immediately.
   */
  @JvmStatic
  public val pwaUpdateAvailable: Signal0 by Signal0

  public override fun new(scriptPtr: VoidPtr): Unit {
    getSingleton(14)
  }

  /**
   * Execute the string ` as JavaScript code within the browser window. This is a call to the actual
   * global JavaScript function [code skip-lint]eval()`.
   *
   * If [useGlobalExecutionContext] is `true`, the code will be evaluated in the global execution
   * context. Otherwise, it is evaluated in the execution context of a function within the engine's
   * runtime environment.
   */
  @JvmOverloads
  @JvmStatic
  public final fun eval(code: String, useGlobalExecutionContext: Boolean = false): Any? =
      TransferContext.callMethod_STRING_BOOL_ret_ANY(ptr, objectID.id, MethodBindings.evalPtr, code, useGlobalExecutionContext)

  /**
   * Returns an interface to a JavaScript object that can be used by scripts. The [interface] must
   * be a valid property of the JavaScript `window`. The callback must accept a single [VariantArray]
   * argument, which will contain the JavaScript `arguments`. See [JavaScriptObject] for usage.
   */
  @JvmStatic
  public final fun getInterface(`interface`: String): JavaScriptObject? =
      (TransferContext.callMethod_STRING_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.getInterfacePtr, `interface`) as JavaScriptObject?)

  /**
   * Creates a reference to a [Callable] that can be used as a callback by JavaScript. The reference
   * must be kept until the callback happens, or it won't be called at all. See [JavaScriptObject] for
   * usage.
   *
   * **Note:** The callback function must take exactly one [VariantArray] argument, which is going
   * to be the JavaScript
   * [url=https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/arguments]arguments
   * object[/url] converted to an array.
   */
  @JvmStatic
  public final fun createCallback(callable: Callable): JavaScriptObject? =
      (TransferContext.callMethod_CALLABLE_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.createCallbackPtr, callable) as JavaScriptObject?)

  /**
   * Returns `true` if the given [javascriptObject] is of type
   * [url=https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/ArrayBuffer]ArrayBuffer[/url],
   * [url=https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/DataView]DataView[/url],
   * or one of the many
   * [url=https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/TypedArray]typed
   * array objects[/url].
   */
  @JvmStatic
  public final fun isJsBuffer(javascriptObject: JavaScriptObject?): Boolean =
      TransferContext.callPtrMethod_OBJECT_ret_BOOL(ptr, objectID.id, MethodBindings.isJsBufferPtr, javascriptObject)

  /**
   * Returns a copy of [javascriptBuffer]'s contents as a [PackedByteArray]. See also [isJsBuffer].
   */
  @JvmStatic
  public final fun jsBufferToPackedByteArray(javascriptBuffer: JavaScriptObject?): PackedByteArray =
      TransferContext.callPtrMethod_OBJECT_ret_PACKED_BYTE_ARRAY(ptr, objectID.id, MethodBindings.jsBufferToPackedByteArrayPtr, javascriptBuffer)

  /**
   * Creates a new JavaScript object using the `new` constructor. The [object] must a valid property
   * of the JavaScript `window`. See [JavaScriptObject] for usage.
   */
  @JvmStatic
  public final fun createObject(`object`: String, vararg args: Any?): Any? =
      TransferContext.callMethod_STRING_VARARG_ret_ANY(ptr, objectID.id, MethodBindings.createObjectPtr, `object`, args)

  /**
   * Prompts the user to download a file containing the specified [buffer]. The file will have the
   * given [name] and [mime] type.
   *
   * **Note:** The browser may override the [url=https://en.wikipedia.org/wiki/Media_type]MIME
   * type[/url] provided based on the file [name]'s extension.
   *
   * **Note:** Browsers might block the download if [downloadBuffer] is not being called from a user
   * interaction (e.g. button click).
   *
   * **Note:** Browsers might ask the user for permission or block the download if multiple download
   * requests are made in a quick succession.
   */
  @JvmOverloads
  @JvmStatic
  public final fun downloadBuffer(
    buffer: PackedByteArray,
    name: String,
    mime: String = "application/octet-stream",
  ): Unit {
    TransferContext.callMethod_PACKED_BYTE_ARRAY_STRING_STRING(ptr, objectID.id, MethodBindings.downloadBufferPtr, buffer, name, mime)
  }

  /**
   * Returns `true` if a new version of the progressive web app is waiting to be activated.
   *
   * **Note:** Only relevant when exported as a Progressive Web App.
   */
  @JvmStatic
  public final fun pwaNeedsUpdate(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.pwaNeedsUpdatePtr)

  /**
   * Performs the live update of the progressive web app. Forcing the new version to be installed
   * and the page to be reloaded.
   *
   * **Note:** Your application will be **reloaded in all browser tabs**.
   *
   * **Note:** Only relevant when exported as a Progressive Web App and [pwaNeedsUpdate] returns
   * `true`.
   */
  @JvmStatic
  public final fun pwaUpdate(): Error =
      Error.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.pwaUpdatePtr))

  /**
   * Force synchronization of the persistent file system (when enabled).
   *
   * **Note:** This is only useful for modules or extensions that can't use [FileAccess] to write
   * files.
   */
  @JvmStatic
  public final fun forceFsSync(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.forceFsSyncPtr)
  }

  public object MethodBindings {
    internal val evalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "eval", 218087648)

    internal val getInterfacePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "get_interface", 1355533281)

    internal val createCallbackPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "create_callback", 422818440)

    internal val isJsBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "is_js_buffer", 821968997)

    internal val jsBufferToPackedByteArrayPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "js_buffer_to_packed_byte_array", 64409880)

    internal val createObjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "create_object", 3093893586)

    internal val downloadBufferPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "download_buffer", 3352272093)

    internal val pwaNeedsUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "pwa_needs_update", 36873697)

    internal val pwaUpdatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "pwa_update", 166280745)

    internal val forceFsSyncPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JavaScriptBridge", "force_fs_sync", 3218959716)
  }
}
