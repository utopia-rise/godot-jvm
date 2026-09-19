// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.`internal`.memory.TransferContext
import godot.`internal`.reflection.TypeManager
import godot.callMethod0_ret_STRING
import godot.callMethod_STRING
import godot.callMethod_STRING_LONG
import godot.callMethod_STRING_PACKED_STRING_ARRAY_LONG_PACKED_BYTE_ARRAY_ret_LONG
import godot.callMethod_STRING_PACKED_STRING_ARRAY_LONG_STRING_ret_LONG
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_DOUBLE
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod_BOOL
import godot.callPtrMethod_DOUBLE
import godot.callPtrMethod_LONG
import godot.callPtrMethod_OBJECT
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.GodotEnum
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.PackedByteArray
import godot.core.PackedStringArray
import godot.core.Signal4
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A node with the ability to send HTTP requests. Uses [HTTPClient] internally.
 *
 * Can be used to make HTTP requests, i.e. download or upload files or web content via HTTP.
 *
 * **Warning:** See the notes and warnings on [HTTPClient] for limitations, especially regarding TLS
 * security.
 *
 * **Note:** When exporting to Android, make sure to enable the `INTERNET` permission in the Android
 * export preset before exporting the project or using one-click deploy. Otherwise, network
 * communication of any kind will be blocked by Android.
 *
 * **Example:** Contact a REST API and print one of its returned fields:
 *
 * ```gdscript
 * //gdscript
 * func _ready():
 * 	# Create an HTTP request node and connect its completion signal.
 * 	var http_request = HTTPRequest.new()
 * 	add_child(http_request)
 * 	http_request.request_completed.connect(self._http_request_completed)
 *
 * 	# Perform a GET request. The URL below returns JSON as of writing.
 * 	var error = http_request.request("https://httpbin.org/get")
 * 	if error != OK:
 * 		push_error("An error occurred in the HTTP request.")
 *
 * 	# Perform a POST request. The URL below returns JSON as of writing.
 * 	# Note: Don't make simultaneous requests using a single HTTPRequest node.
 * 	# The snippet below is provided for reference only.
 * 	var body = JSON.stringify({"name": "Godette"})
 * 	error = http_request.request("https://httpbin.org/post", [], HTTPClient.METHOD_POST, body)
 * 	if error != OK:
 * 		push_error("An error occurred in the HTTP request.")
 *
 * # Called when the HTTP request is completed.
 * func _http_request_completed(result, response_code, headers, body):
 * 	var json = JSON.new()
 * 	json.parse(body.get_string_from_utf8())
 * 	var response = json.get_data()
 *
 * 	# Will print the user agent string used by the HTTPRequest node (as recognized by httpbin.org).
 * 	print(response.headers["User-Agent"])
 * ```
 *
 * ```csharp
 * //csharp
 * public override void _Ready()
 * {
 * 	// Create an HTTP request node and connect its completion signal.
 * 	var httpRequest = new HttpRequest();
 * 	AddChild(httpRequest);
 * 	httpRequest.RequestCompleted += HttpRequestCompleted;
 *
 * 	// Perform a GET request. The URL below returns JSON as of writing.
 * 	Error error = httpRequest.Request("https://httpbin.org/get");
 * 	if (error != Error.Ok)
 * 	{
 * 		GD.PushError("An error occurred in the HTTP request.");
 * 	}
 *
 * 	// Perform a POST request. The URL below returns JSON as of writing.
 * 	// Note: Don't make simultaneous requests using a single HTTPRequest node.
 * 	// The snippet below is provided for reference only.
 * 	string body = Json.Stringify(new Godot.Collections.Dictionary
 * 	{
 * 		{ "name", "Godette" }
 * 	});
 * 	error = httpRequest.Request("https://httpbin.org/post", null, HttpClient.Method.Post, body);
 * 	if (error != Error.Ok)
 * 	{
 * 		GD.PushError("An error occurred in the HTTP request.");
 * 	}
 * }
 *
 * // Called when the HTTP request is completed.
 * private void HttpRequestCompleted(long result, long responseCode, string[] headers, byte[] body)
 * {
 * 	var json = new Json();
 * 	json.Parse(body.GetStringFromUtf8());
 * 	var response = json.GetData().AsGodotDictionary();
 *
 * 	// Will print the user agent string used by the HTTPRequest node (as recognized by httpbin.org).
 * 	GD.Print((response["headers"].AsGodotDictionary())["User-Agent"]);
 * }
 * ```
 *
 * **Example:** Load an image using [HTTPRequest] and display it:
 *
 * ```gdscript
 * //gdscript
 * func _ready():
 * 	# Create an HTTP request node and connect its completion signal.
 * 	var http_request = HTTPRequest.new()
 * 	add_child(http_request)
 * 	http_request.request_completed.connect(self._http_request_completed)
 *
 * 	# Perform the HTTP request. The URL below returns a PNG image as of writing.
 * 	var error = http_request.request("https://placehold.co/512.png")
 * 	if error != OK:
 * 		push_error("An error occurred in the HTTP request.")
 *
 * # Called when the HTTP request is completed.
 * func _http_request_completed(result, response_code, headers, body):
 * 	if result != HTTPRequest.RESULT_SUCCESS:
 * 		push_error("Image couldn't be downloaded. Try a different image.")
 *
 * 	var image = Image.new()
 * 	var error = image.load_png_from_buffer(body)
 * 	if error != OK:
 * 		push_error("Couldn't load the image.")
 *
 * 	var texture = ImageTexture.create_from_image(image)
 *
 * 	# Display the image in a TextureRect node.
 * 	var texture_rect = TextureRect.new()
 * 	add_child(texture_rect)
 * 	texture_rect.texture = texture
 * ```
 *
 * ```csharp
 * //csharp
 * public override void _Ready()
 * {
 * 	// Create an HTTP request node and connect its completion signal.
 * 	var httpRequest = new HttpRequest();
 * 	AddChild(httpRequest);
 * 	httpRequest.RequestCompleted += HttpRequestCompleted;
 *
 * 	// Perform the HTTP request. The URL below returns a PNG image as of writing.
 * 	Error error = httpRequest.Request("https://placehold.co/512.png");
 * 	if (error != Error.Ok)
 * 	{
 * 		GD.PushError("An error occurred in the HTTP request.");
 * 	}
 * }
 *
 * // Called when the HTTP request is completed.
 * private void HttpRequestCompleted(long result, long responseCode, string[] headers, byte[] body)
 * {
 * 	if (result != (long)HttpRequest.Result.Success)
 * 	{
 * 		GD.PushError("Image couldn't be downloaded. Try a different image.");
 * 	}
 * 	var image = new Image();
 * 	Error error = image.LoadPngFromBuffer(body);
 * 	if (error != Error.Ok)
 * 	{
 * 		GD.PushError("Couldn't load the image.");
 * 	}
 *
 * 	var texture = ImageTexture.CreateFromImage(image);
 *
 * 	// Display the image in a TextureRect node.
 * 	var textureRect = new TextureRect();
 * 	AddChild(textureRect);
 * 	textureRect.Texture = texture;
 * }
 * ```
 *
 * **Note:** [HTTPRequest] nodes will automatically handle decompression of response bodies. An
 * `Accept-Encoding` header will be automatically added to each of your requests, unless one is already
 * specified. Any response with a `Content-Encoding: gzip` header will automatically be decompressed
 * and delivered to you as uncompressed bytes.
 */
@GodotBaseType
public open class HTTPRequest : Node() {
  /**
   * Emitted when a request is completed.
   */
  public val requestCompleted: Signal4<Long, Long, PackedStringArray, PackedByteArray> by Signal4

  /**
   * The file to download into. Will output any received file into it.
   */
  public final inline var downloadFile: String
    @JvmName("downloadFileProperty")
    get() = getDownloadFile()
    @JvmName("downloadFileProperty")
    set(`value`) {
      setDownloadFile(value)
    }

  /**
   * The size of the buffer used and maximum bytes to read per iteration. See
   * [HTTPClient.readChunkSize].
   *
   * Set this to a lower value (e.g. 4096 for 4 KiB) when downloading small files to decrease memory
   * usage at the cost of download speeds.
   */
  public final inline var downloadChunkSize: Int
    @JvmName("downloadChunkSizeProperty")
    get() = getDownloadChunkSize()
    @JvmName("downloadChunkSizeProperty")
    set(`value`) {
      setDownloadChunkSize(value)
    }

  /**
   * If `true`, multithreading is used to improve performance.
   */
  public final inline var useThreads: Boolean
    @JvmName("useThreadsProperty")
    get() = isUsingThreads()
    @JvmName("useThreadsProperty")
    set(`value`) {
      setUseThreads(value)
    }

  /**
   * If `true`, this header will be added to each request: `Accept-Encoding: gzip, deflate` telling
   * servers that it's okay to compress response bodies.
   *
   * Any Response body declaring a `Content-Encoding` of either `gzip` or `deflate` will then be
   * automatically decompressed, and the uncompressed bytes will be delivered via [signal
   * request_completed].
   *
   * If the user has specified their own `Accept-Encoding` header, then no header will be added
   * regardless of [acceptGzip].
   *
   * If `false` no header will be added, and no decompression will be performed on response bodies.
   * The raw bytes of the response body will be returned via [signal request_completed].
   */
  public final inline var acceptGzip: Boolean
    @JvmName("acceptGzipProperty")
    get() = isAcceptingGzip()
    @JvmName("acceptGzipProperty")
    set(`value`) {
      setAcceptGzip(value)
    }

  /**
   * Maximum allowed size for response bodies. If the response body is compressed, this will be used
   * as the maximum allowed size for the decompressed body.
   */
  public final inline var bodySizeLimit: Int
    @JvmName("bodySizeLimitProperty")
    get() = getBodySizeLimit()
    @JvmName("bodySizeLimitProperty")
    set(`value`) {
      setBodySizeLimit(value)
    }

  /**
   * Maximum number of allowed redirects.
   */
  public final inline var maxRedirects: Int
    @JvmName("maxRedirectsProperty")
    get() = getMaxRedirects()
    @JvmName("maxRedirectsProperty")
    set(`value`) {
      setMaxRedirects(value)
    }

  /**
   * The duration to wait before a request times out, in seconds (independent of
   * [Engine.timeScale]). If [timeout] is set to `0.0`, the request will never time out.
   *
   * For simple requests, such as communication with a REST API, it is recommended to set [timeout]
   * to a value suitable for the server response time (commonly between `1.0` and `10.0`). This will
   * help prevent unwanted timeouts caused by variation in response times while still allowing the
   * application to detect when a request has timed out. For larger requests such as file downloads, it
   * is recommended to set [timeout] to `0.0`, disabling the timeout functionality. This will help
   * prevent large transfers from failing due to exceeding the timeout value.
   */
  public final inline var timeout: Double
    @JvmName("timeoutProperty")
    get() = getTimeout()
    @JvmName("timeoutProperty")
    set(`value`) {
      setTimeout(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(292, scriptPtr)
  }

  /**
   * Creates request on the underlying [HTTPClient]. If there is no configuration errors, it tries
   * to connect using [HTTPClient.connectToHost] and passes parameters onto [HTTPClient.request].
   *
   * Returns [OK] if request is successfully created. (Does not imply that the server has
   * responded), [ERR_UNCONFIGURED] if not in the tree, [ERR_BUSY] if still processing previous
   * request, [ERR_INVALID_PARAMETER] if given string is not a valid URL format, or [ERR_CANT_CONNECT]
   * if not using thread and the [HTTPClient] cannot connect to host.
   *
   * **Note:** When [method] is [HTTPClient.METHOD_GET], the payload sent via [requestData] might be
   * ignored by the server or even cause the server to reject the request (check
   * [url=https://datatracker.ietf.org/doc/html/rfc7231#section-4.3.1]RFC 7231 section 4.3.1[/url] for
   * more details). As a workaround, you can send data as a query string in the URL (see
   * [String.uriEncode] for an example).
   *
   * **Note:** It's recommended to use transport encryption (TLS) and to avoid sending sensitive
   * information (such as login credentials) in HTTP GET URL parameters. Consider using HTTP POST
   * requests or HTTP headers for such information instead.
   */
  @JvmOverloads
  public final fun request(
    url: String,
    customHeaders: PackedStringArray = PackedStringArray(),
    method: HTTPClient.Method = HTTPClient.Method.GET,
    requestData: String = "",
  ): Error =
      Error.from(TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_LONG_STRING_ret_LONG(ptr, objectID.id, MethodBindings.requestPtr, url, customHeaders, method.value, requestData))

  /**
   * Creates request on the underlying [HTTPClient] using a raw array of bytes for the request body.
   * If there is no configuration errors, it tries to connect using [HTTPClient.connectToHost] and
   * passes parameters onto [HTTPClient.request].
   *
   * Returns [OK] if request is successfully created. (Does not imply that the server has
   * responded), [ERR_UNCONFIGURED] if not in the tree, [ERR_BUSY] if still processing previous
   * request, [ERR_INVALID_PARAMETER] if given string is not a valid URL format, or [ERR_CANT_CONNECT]
   * if not using thread and the [HTTPClient] cannot connect to host.
   */
  @JvmOverloads
  public final fun requestRaw(
    url: String,
    customHeaders: PackedStringArray = PackedStringArray(),
    method: HTTPClient.Method = HTTPClient.Method.GET,
    requestDataRaw: PackedByteArray = PackedByteArray(),
  ): Error =
      Error.from(TransferContext.callMethod_STRING_PACKED_STRING_ARRAY_LONG_PACKED_BYTE_ARRAY_ret_LONG(ptr, objectID.id, MethodBindings.requestRawPtr, url, customHeaders, method.value, requestDataRaw))

  /**
   * Cancels the current request.
   */
  public final fun cancelRequest(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.cancelRequestPtr)
  }

  /**
   * Sets the [TLSOptions] to be used when connecting to an HTTPS server. See [TLSOptions.client].
   */
  public final fun setTlsOptions(clientOptions: TLSOptions?): Unit {
    TransferContext.callPtrMethod_OBJECT(ptr, objectID.id, MethodBindings.setTlsOptionsPtr, clientOptions)
  }

  /**
   * Returns the current status of the underlying [HTTPClient].
   */
  public final fun getHttpClientStatus(): HTTPClient.Status =
      HTTPClient.Status.from(TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getHttpClientStatusPtr))

  public final fun setUseThreads(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setUseThreadsPtr, enable)
  }

  public final fun isUsingThreads(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isUsingThreadsPtr)

  public final fun setAcceptGzip(enable: Boolean): Unit {
    TransferContext.callPtrMethod_BOOL(ptr, objectID.id, MethodBindings.setAcceptGzipPtr, enable)
  }

  public final fun isAcceptingGzip(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isAcceptingGzipPtr)

  public final fun setBodySizeLimit(bytes: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setBodySizeLimitPtr, bytes.toLong())
  }

  public final fun getBodySizeLimit(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBodySizeLimitPtr).toInt()

  public final fun setMaxRedirects(amount: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setMaxRedirectsPtr, amount.toLong())
  }

  public final fun getMaxRedirects(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getMaxRedirectsPtr).toInt()

  public final fun setDownloadFile(path: String): Unit {
    TransferContext.callMethod_STRING(ptr, objectID.id, MethodBindings.setDownloadFilePtr, path)
  }

  public final fun getDownloadFile(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getDownloadFilePtr)

  /**
   * Returns the number of bytes this HTTPRequest downloaded.
   */
  public final fun getDownloadedBytes(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDownloadedBytesPtr).toInt()

  /**
   * Returns the response body length.
   *
   * **Note:** Some Web servers may not send a body length. In this case, the value returned will be
   * `-1`. If using chunked transfer encoding, the body length will also be `-1`.
   */
  public final fun getBodySize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getBodySizePtr).toInt()

  public final fun setTimeout(timeout: Double): Unit {
    TransferContext.callPtrMethod_DOUBLE(ptr, objectID.id, MethodBindings.setTimeoutPtr, timeout)
  }

  public final fun getTimeout(): Double =
      TransferContext.callPtrMethod0_ret_DOUBLE(ptr, objectID.id, MethodBindings.getTimeoutPtr)

  public final fun setDownloadChunkSize(chunkSize: Int): Unit {
    TransferContext.callPtrMethod_LONG(ptr, objectID.id, MethodBindings.setDownloadChunkSizePtr, chunkSize.toLong())
  }

  public final fun getDownloadChunkSize(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getDownloadChunkSizePtr).toInt()

  /**
   * Sets the proxy server for HTTP requests.
   *
   * The proxy server is unset if [host] is empty or [port] is -1.
   */
  public final fun setHttpProxy(host: String, port: Int): Unit {
    TransferContext.callMethod_STRING_LONG(ptr, objectID.id, MethodBindings.setHttpProxyPtr, host, port.toLong())
  }

  /**
   * Sets the proxy server for HTTPS requests.
   *
   * The proxy server is unset if [host] is empty or [port] is -1.
   */
  public final fun setHttpsProxy(host: String, port: Int): Unit {
    TransferContext.callMethod_STRING_LONG(ptr, objectID.id, MethodBindings.setHttpsProxyPtr, host, port.toLong())
  }

  public enum class Result(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * Request successful.
     */
    SUCCESS(0),
    /**
     * Request failed due to a mismatch between the expected and actual chunked body size during
     * transfer. Possible causes include network errors, server misconfiguration, or issues with
     * chunked encoding.
     */
    CHUNKED_BODY_SIZE_MISMATCH(1),
    /**
     * Request failed while connecting.
     */
    CANT_CONNECT(2),
    /**
     * Request failed while resolving.
     */
    CANT_RESOLVE(3),
    /**
     * Request failed due to connection (read/write) error.
     */
    CONNECTION_ERROR(4),
    /**
     * Request failed on TLS handshake.
     */
    TLS_HANDSHAKE_ERROR(5),
    /**
     * Request does not have a response (yet).
     */
    NO_RESPONSE(6),
    /**
     * Request exceeded its maximum size limit, see [bodySizeLimit].
     */
    BODY_SIZE_LIMIT_EXCEEDED(7),
    /**
     * Request failed due to an error while decompressing the response body. Possible causes include
     * unsupported or incorrect compression format, corrupted data, or incomplete transfer.
     */
    BODY_DECOMPRESS_FAILED(8),
    /**
     * Request failed (currently unused).
     */
    REQUEST_FAILED(9),
    /**
     * HTTPRequest couldn't open the download file.
     */
    DOWNLOAD_FILE_CANT_OPEN(10),
    /**
     * HTTPRequest couldn't write to the download file.
     */
    DOWNLOAD_FILE_WRITE_ERROR(11),
    /**
     * Request reached its maximum redirect limit, see [maxRedirects].
     */
    REDIRECT_LIMIT_REACHED(12),
    /**
     * Request failed due to a timeout. If you expect requests to take a long time, try increasing
     * the value of [timeout] or setting it to `0.0` to remove the timeout completely.
     */
    TIMEOUT(13),
    ;

    public companion object {
      public fun from(`value`: Long): Result = entries.single { it.`value` == `value` }
    }
  }

  public companion object {
    @JvmField
    public val requestName:
        MethodStringName4<HTTPRequest, Error, String, PackedStringArray, HTTPClient.Method, String>
        =
        MethodStringName4<HTTPRequest, Error, String, PackedStringArray, HTTPClient.Method, String>("request")

    @JvmField
    public val requestRawName:
        MethodStringName4<HTTPRequest, Error, String, PackedStringArray, HTTPClient.Method, PackedByteArray>
        =
        MethodStringName4<HTTPRequest, Error, String, PackedStringArray, HTTPClient.Method, PackedByteArray>("request_raw")

    @JvmField
    public val cancelRequestName: MethodStringName0<HTTPRequest, Unit> =
        MethodStringName0<HTTPRequest, Unit>("cancel_request")

    @JvmField
    public val setTlsOptionsName: MethodStringName1<HTTPRequest, Unit, TLSOptions?> =
        MethodStringName1<HTTPRequest, Unit, TLSOptions?>("set_tls_options")

    @JvmField
    public val getHttpClientStatusName: MethodStringName0<HTTPRequest, HTTPClient.Status> =
        MethodStringName0<HTTPRequest, HTTPClient.Status>("get_http_client_status")

    @JvmField
    public val setUseThreadsName: MethodStringName1<HTTPRequest, Unit, Boolean> =
        MethodStringName1<HTTPRequest, Unit, Boolean>("set_use_threads")

    @JvmField
    public val isUsingThreadsName: MethodStringName0<HTTPRequest, Boolean> =
        MethodStringName0<HTTPRequest, Boolean>("is_using_threads")

    @JvmField
    public val setAcceptGzipName: MethodStringName1<HTTPRequest, Unit, Boolean> =
        MethodStringName1<HTTPRequest, Unit, Boolean>("set_accept_gzip")

    @JvmField
    public val isAcceptingGzipName: MethodStringName0<HTTPRequest, Boolean> =
        MethodStringName0<HTTPRequest, Boolean>("is_accepting_gzip")

    @JvmField
    public val setBodySizeLimitName: MethodStringName1<HTTPRequest, Unit, Int> =
        MethodStringName1<HTTPRequest, Unit, Int>("set_body_size_limit")

    @JvmField
    public val getBodySizeLimitName: MethodStringName0<HTTPRequest, Int> =
        MethodStringName0<HTTPRequest, Int>("get_body_size_limit")

    @JvmField
    public val setMaxRedirectsName: MethodStringName1<HTTPRequest, Unit, Int> =
        MethodStringName1<HTTPRequest, Unit, Int>("set_max_redirects")

    @JvmField
    public val getMaxRedirectsName: MethodStringName0<HTTPRequest, Int> =
        MethodStringName0<HTTPRequest, Int>("get_max_redirects")

    @JvmField
    public val setDownloadFileName: MethodStringName1<HTTPRequest, Unit, String> =
        MethodStringName1<HTTPRequest, Unit, String>("set_download_file")

    @JvmField
    public val getDownloadFileName: MethodStringName0<HTTPRequest, String> =
        MethodStringName0<HTTPRequest, String>("get_download_file")

    @JvmField
    public val getDownloadedBytesName: MethodStringName0<HTTPRequest, Int> =
        MethodStringName0<HTTPRequest, Int>("get_downloaded_bytes")

    @JvmField
    public val getBodySizeName: MethodStringName0<HTTPRequest, Int> =
        MethodStringName0<HTTPRequest, Int>("get_body_size")

    @JvmField
    public val setTimeoutName: MethodStringName1<HTTPRequest, Unit, Double> =
        MethodStringName1<HTTPRequest, Unit, Double>("set_timeout")

    @JvmField
    public val getTimeoutName: MethodStringName0<HTTPRequest, Double> =
        MethodStringName0<HTTPRequest, Double>("get_timeout")

    @JvmField
    public val setDownloadChunkSizeName: MethodStringName1<HTTPRequest, Unit, Int> =
        MethodStringName1<HTTPRequest, Unit, Int>("set_download_chunk_size")

    @JvmField
    public val getDownloadChunkSizeName: MethodStringName0<HTTPRequest, Int> =
        MethodStringName0<HTTPRequest, Int>("get_download_chunk_size")

    @JvmField
    public val setHttpProxyName: MethodStringName2<HTTPRequest, Unit, String, Int> =
        MethodStringName2<HTTPRequest, Unit, String, Int>("set_http_proxy")

    @JvmField
    public val setHttpsProxyName: MethodStringName2<HTTPRequest, Unit, String, Int> =
        MethodStringName2<HTTPRequest, Unit, String, Int>("set_https_proxy")
  }

  public object MethodBindings {
    internal val requestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "request", 3215244323)

    internal val requestRawPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "request_raw", 2714829993)

    internal val cancelRequestPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "cancel_request", 3218959716)

    internal val setTlsOptionsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_tls_options", 2210231844)

    internal val getHttpClientStatusPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_http_client_status", 1426656811)

    internal val setUseThreadsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_use_threads", 2586408642)

    internal val isUsingThreadsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "is_using_threads", 36873697)

    internal val setAcceptGzipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_accept_gzip", 2586408642)

    internal val isAcceptingGzipPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "is_accepting_gzip", 36873697)

    internal val setBodySizeLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_body_size_limit", 1286410249)

    internal val getBodySizeLimitPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_body_size_limit", 3905245786)

    internal val setMaxRedirectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_max_redirects", 1286410249)

    internal val getMaxRedirectsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_max_redirects", 3905245786)

    internal val setDownloadFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_download_file", 83702148)

    internal val getDownloadFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_download_file", 201670096)

    internal val getDownloadedBytesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_downloaded_bytes", 3905245786)

    internal val getBodySizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_body_size", 3905245786)

    internal val setTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_timeout", 373806689)

    internal val getTimeoutPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_timeout", 191475506)

    internal val setDownloadChunkSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_download_chunk_size", 1286410249)

    internal val getDownloadChunkSizePtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "get_download_chunk_size", 3905245786)

    internal val setHttpProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_http_proxy", 2956805083)

    internal val setHttpsProxyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("HTTPRequest", "set_https_proxy", 2956805083)
  }
}
