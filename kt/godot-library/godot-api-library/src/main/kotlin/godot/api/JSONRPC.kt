// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod_ANY_ANY_ret_DICTIONARY
import godot.callMethod_ANY_BOOL_ret_ANY
import godot.callMethod_LONG_STRING_ANY_ret_DICTIONARY
import godot.callMethod_STRING_ANY_ANY_ret_DICTIONARY
import godot.callMethod_STRING_ANY_ret_DICTIONARY
import godot.callMethod_STRING_CALLABLE
import godot.callMethod_STRING_ret_STRING
import godot.common.interop.VoidPtr
import godot.core.Callable
import godot.core.Dictionary
import godot.core.GodotEnum
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads

/**
 * [url=https://www.jsonrpc.org/]JSON-RPC[/url] is a standard which wraps a method call in a [JSON]
 * object. The object has a particular structure and identifies which method is called, the parameters
 * to that function, and carries an ID to keep track of responses. This class implements that standard
 * on top of [Dictionary]; you will have to convert between a [Dictionary] and [JSON] with other
 * functions.
 */
@GodotBaseType
public open class JSONRPC : Object() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(332, scriptPtr)
  }

  /**
   * Registers a callback for the given method name.
   *
   * - [name]: The name that clients can use to access the callback.
   *
   * - [callback]: The callback which will handle the specified method.
   */
  public final fun setMethod(name: String, callback: Callable): Unit {
    TransferContext.callMethod_STRING_CALLABLE(ptr, objectID.id, MethodBindings.setMethodPtr, name, callback)
  }

  /**
   * Given a Dictionary which takes the form of a JSON-RPC request: unpack the request and run it.
   * Methods are resolved by looking at the field called "method" and looking for an equivalently named
   * function in the JSONRPC object. If one is found that method is called.
   *
   * To add new supported methods extend the JSONRPC class and call [processAction] on your
   * subclass.
   *
   * [action]: The action to be run, as a Dictionary in the form of a JSON-RPC request or
   * notification.
   */
  @JvmOverloads
  public final fun processAction(action: Any?, recurse: Boolean = false): Any? =
      TransferContext.callMethod_ANY_BOOL_ret_ANY(ptr, objectID.id, MethodBindings.processActionPtr, action, recurse)

  public final fun processString(action: String): String =
      TransferContext.callMethod_STRING_ret_STRING(ptr, objectID.id, MethodBindings.processStringPtr, action)

  /**
   * Returns a dictionary in the form of a JSON-RPC request. Requests are sent to a server with the
   * expectation of a response. The ID field is used for the server to specify which exact request it
   * is responding to.
   *
   * - [method]: Name of the method being called.
   *
   * - [params]: An array or dictionary of parameters being passed to the method.
   *
   * - [id]: Uniquely identifies this request. The server is expected to send a response with the
   * same ID.
   */
  public final fun makeRequest(
    method: String,
    params: Any?,
    id: Any?,
  ): Dictionary<Any?, Any?> =
      (TransferContext.callMethod_STRING_ANY_ANY_ret_DICTIONARY(ptr, objectID.id, MethodBindings.makeRequestPtr, method, params, id) as Dictionary<Any?, Any?>)

  /**
   * When a server has received and processed a request, it is expected to send a response. If you
   * did not want a response then you need to have sent a Notification instead.
   *
   * - [result]: The return value of the function which was called.
   *
   * - [id]: The ID of the request this response is targeted to.
   */
  public final fun makeResponse(result: Any?, id: Any?): Dictionary<Any?, Any?> =
      (TransferContext.callMethod_ANY_ANY_ret_DICTIONARY(ptr, objectID.id, MethodBindings.makeResponsePtr, result, id) as Dictionary<Any?, Any?>)

  /**
   * Returns a dictionary in the form of a JSON-RPC notification. Notifications are one-shot
   * messages which do not expect a response.
   *
   * - [method]: Name of the method being called.
   *
   * - [params]: An array or dictionary of parameters being passed to the method.
   */
  public final fun makeNotification(method: String, params: Any?): Dictionary<Any?, Any?> =
      (TransferContext.callMethod_STRING_ANY_ret_DICTIONARY(ptr, objectID.id, MethodBindings.makeNotificationPtr, method, params) as Dictionary<Any?, Any?>)

  /**
   * Creates a response which indicates a previous reply has failed in some way.
   *
   * - [code]: The error code corresponding to what kind of error this is. See the [ErrorCode]
   * constants.
   *
   * - [message]: A custom message about this error.
   *
   * - [id]: The request this error is a response to.
   */
  @JvmOverloads
  public final fun makeResponseError(
    code: Int,
    message: String,
    id: Any? = null,
  ): Dictionary<Any?, Any?> =
      (TransferContext.callMethod_LONG_STRING_ANY_ret_DICTIONARY(ptr, objectID.id, MethodBindings.makeResponseErrorPtr, code.toLong(), message, id) as Dictionary<Any?, Any?>)

  public enum class ErrorCode(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The request could not be parsed as it was not valid by JSON standard ([JSON.parse] failed).
     */
    PARSE_ERROR(-32700),
    /**
     * A method call was requested but the request's format is not valid.
     */
    INVALID_REQUEST(-32600),
    /**
     * A method call was requested but no function of that name existed in the JSONRPC subclass.
     */
    METHOD_NOT_FOUND(-32601),
    /**
     * A method call was requested but the given method parameters are not valid. Not used by the
     * built-in JSONRPC.
     */
    INVALID_PARAMS(-32602),
    /**
     * An internal error occurred while processing the request. Not used by the built-in JSONRPC.
     */
    INTERNAL_ERROR(-32603),
    ;

    public companion object {
      public fun from(`value`: Long): ErrorCode = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val setMethodName: MethodStringName2<JSONRPC, Unit, String, Callable> =
        MethodStringName2<JSONRPC, Unit, String, Callable>("set_method")

    @JvmField
    public val processActionName: MethodStringName2<JSONRPC, Any?, Any?, Boolean> =
        MethodStringName2<JSONRPC, Any?, Any?, Boolean>("process_action")

    @JvmField
    public val processStringName: MethodStringName1<JSONRPC, String, String> =
        MethodStringName1<JSONRPC, String, String>("process_string")

    @JvmField
    public val makeRequestName:
        MethodStringName3<JSONRPC, Dictionary<Any?, Any?>, String, Any?, Any?> =
        MethodStringName3<JSONRPC, Dictionary<Any?, Any?>, String, Any?, Any?>("make_request")

    @JvmField
    public val makeResponseName: MethodStringName2<JSONRPC, Dictionary<Any?, Any?>, Any?, Any?> =
        MethodStringName2<JSONRPC, Dictionary<Any?, Any?>, Any?, Any?>("make_response")

    @JvmField
    public val makeNotificationName:
        MethodStringName2<JSONRPC, Dictionary<Any?, Any?>, String, Any?> =
        MethodStringName2<JSONRPC, Dictionary<Any?, Any?>, String, Any?>("make_notification")

    @JvmField
    public val makeResponseErrorName:
        MethodStringName3<JSONRPC, Dictionary<Any?, Any?>, Int, String, Any?> =
        MethodStringName3<JSONRPC, Dictionary<Any?, Any?>, Int, String, Any?>("make_response_error")
  }

  public object MethodBindings {
    internal val setMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSONRPC", "set_method", 2137474292)

    internal val processActionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSONRPC", "process_action", 2963479484)

    internal val processStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSONRPC", "process_string", 1703090593)

    internal val makeRequestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSONRPC", "make_request", 3423508980)

    internal val makeResponsePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSONRPC", "make_response", 5053918)

    internal val makeNotificationPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSONRPC", "make_notification", 2949127017)

    internal val makeResponseErrorPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSONRPC", "make_response_error", 928596297)
  }
}
