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
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
import godot.core.MethodStringName4
import godot.core.VariantCaster.ANY
import godot.core.VariantParser.BOOL
import godot.core.VariantParser.LONG
import godot.core.VariantParser.STRING
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * The [JSON] class enables all data types to be converted to and from a JSON string. This is useful
 * for serializing data, e.g. to save to a file or send over the network.
 *
 * [stringify] is used to convert any data type into a JSON string.
 *
 * [parse] is used to convert any existing JSON data into a [Any] that can be used within Godot. If
 * successfully parsed, use [data] to retrieve the [Any], and use [@GlobalScope.typeof] to check if the
 * Variant's type is what you expect. JSON Objects are converted into a [Dictionary], but JSON data can
 * be used to store [VariantArray]s, numbers, [String]s and even just a boolean.
 *
 * ```
 * var data_to_send = ["a", "b", "c"]
 * var json_string = JSON.stringify(data_to_send)
 * # Save data
 * # ...
 * # Retrieve data
 * var json = JSON.new()
 * var error = json.parse(json_string)
 * if error == OK:
 * 	var data_received = json.data
 * 	if typeof(data_received) == TYPE_ARRAY:
 * 		print(data_received) # Prints the array.
 * 	else:
 * 		print("Unexpected data")
 * else:
 * 	print("JSON Parse Error: ", json.get_error_message(), " in ", json_string, " at line ",
 * json.get_error_line())
 * ```
 *
 * Alternatively, you can parse strings using the static [parseString] method, but it doesn't handle
 * errors.
 *
 * ```
 * var data = JSON.parse_string(json_string) # Returns null if parsing failed.
 * ```
 *
 * **Note:** Both parse methods do not fully comply with the JSON specification:
 *
 * - Trailing commas in arrays or objects are ignored, instead of causing a parser error.
 *
 * - New line and tab characters are accepted in string literals, and are treated like their
 * corresponding escape sequences `\n` and `\t`.
 *
 * - Numbers are parsed using [String.toFloat] which is generally more lax than the JSON
 * specification.
 *
 * - Certain errors, such as invalid Unicode sequences, do not cause a parser error. Instead, the
 * string is cleaned up and an error is logged to the console.
 */
@GodotBaseType
public open class JSON : Resource() {
  /**
   * Contains the parsed JSON data in [Any] form.
   */
  public final inline var `data`: Any?
    @JvmName("dataProperty")
    get() = getData()
    @JvmName("dataProperty")
    set(`value`) {
      setData(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(333, scriptPtr)
  }

  /**
   * Attempts to parse the [jsonText] provided.
   *
   * Returns an [Error]. If the parse was successful, it returns [OK] and the result can be
   * retrieved using [data]. If unsuccessful, use [getErrorLine] and [getErrorMessage] to identify the
   * source of the failure.
   *
   * Non-static variant of [parseString], if you want custom error handling.
   *
   * The optional [keepText] argument instructs the parser to keep a copy of the original text. This
   * text can be obtained later by using the [getParsedText] function and is used when saving the
   * resource (instead of generating new text from [data]).
   */
  @JvmOverloads
  public final fun parse(jsonText: String, keepText: Boolean = false): Error {
    TransferContext.writeMethodArguments(ptr, objectID.id, STRING to jsonText, BOOL to keepText)
    TransferContext.callMethod(MethodBindings.parsePtr)
    return Error.from(TransferContext.readReturnValue(LONG) as Long)
  }

  public final fun getData(): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getDataPtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  public final fun setData(`data`: Any?): Unit {
    TransferContext.writeMethodArguments(ptr, objectID.id, ANY to data)
    TransferContext.callMethod(MethodBindings.setDataPtr)
  }

  /**
   * Return the text parsed by [parse] (requires passing `keep_text` to [parse]).
   */
  public final fun getParsedText(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getParsedTextPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `0` if the last call to [parse] was successful, or the line number where the parse
   * failed.
   */
  public final fun getErrorLine(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getErrorLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns an empty string if the last call to [parse] was successful, or the error message if it
   * failed.
   */
  public final fun getErrorMessage(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getErrorMessagePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public companion object {
    @JvmField
    public val stringifyName: MethodStringName4<JSON, String, Any?, String, Boolean, Boolean> =
        MethodStringName4<JSON, String, Any?, String, Boolean, Boolean>("stringify")

    @JvmField
    public val parseStringName: MethodStringName1<JSON, Any?, String> =
        MethodStringName1<JSON, Any?, String>("parse_string")

    @JvmField
    public val parseName: MethodStringName2<JSON, Error, String, Boolean> =
        MethodStringName2<JSON, Error, String, Boolean>("parse")

    @JvmField
    public val getDataName: MethodStringName0<JSON, Any?> =
        MethodStringName0<JSON, Any?>("get_data")

    @JvmField
    public val setDataName: MethodStringName1<JSON, Unit, Any?> =
        MethodStringName1<JSON, Unit, Any?>("set_data")

    @JvmField
    public val getParsedTextName: MethodStringName0<JSON, String> =
        MethodStringName0<JSON, String>("get_parsed_text")

    @JvmField
    public val getErrorLineName: MethodStringName0<JSON, Int> =
        MethodStringName0<JSON, Int>("get_error_line")

    @JvmField
    public val getErrorMessageName: MethodStringName0<JSON, String> =
        MethodStringName0<JSON, String>("get_error_message")

    @JvmField
    public val fromNativeName: MethodStringName2<JSON, Any?, Any?, Boolean> =
        MethodStringName2<JSON, Any?, Any?, Boolean>("from_native")

    @JvmField
    public val toNativeName: MethodStringName2<JSON, Any?, Any?, Boolean> =
        MethodStringName2<JSON, Any?, Any?, Boolean>("to_native")

    /**
     * Converts a [Any] var to JSON text and returns the result. Useful for serializing data to
     * store or send over the network.
     *
     * **Note:** The JSON specification does not define integer or float types, but only a *number*
     * type. Therefore, converting a Variant to JSON text will convert all numerical values to [Double]
     * types.
     *
     * **Note:** If [fullPrecision] is `true`, when stringifying floats, the unreliable digits are
     * stringified in addition to the reliable digits to guarantee exact decoding.
     *
     * The [indent] parameter controls if and how something is indented; its contents will be used
     * where there should be an indent in the output. Even spaces like `"   "` will work. `\t` and `\n`
     * can also be used for a tab indent, or to make a newline for each indent respectively.
     *
     * **Warning:** Non-finite numbers are not supported in JSON. Any occurrences of [@GDScript.INF]
     * will be replaced with `1e99999`, and negative [@GDScript.INF] will be replaced with `-1e99999`,
     * but they will be interpreted correctly as infinity by most JSON parsers. [@GDScript.NAN] will be
     * replaced with `null`, and it will not be interpreted as NaN in JSON parsers. If you expect
     * non-finite numbers, consider passing your data through [fromNative] first.
     *
     * **Example output:**
     *
     * ```
     * ## JSON.stringify(my_dictionary)
     * {"name":"my_dictionary","version":"1.0.0","entities":[{"name":"entity_0","value":"value_0"},{"name":"entity_1","value":"value_1"}]}
     *
     * ## JSON.stringify(my_dictionary, "\t")
     * {
     * 	"name": "my_dictionary",
     * 	"version": "1.0.0",
     * 	"entities": [
     * 		{
     * 			"name": "entity_0",
     * 			"value": "value_0"
     * 		},
     * 		{
     * 			"name": "entity_1",
     * 			"value": "value_1"
     * 		}
     * 	]
     * }
     *
     * ## JSON.stringify(my_dictionary, "...")
     * {
     * ..."name": "my_dictionary",
     * ..."version": "1.0.0",
     * ..."entities": [
     * ......{
     * ........."name": "entity_0",
     * ........."value": "value_0"
     * ......},
     * ......{
     * ........."name": "entity_1",
     * ........."value": "value_1"
     * ......}
     * ...]
     * }
     * ```
     */
    @JvmOverloads
    @JvmStatic
    public final fun stringify(
      `data`: Any?,
      indent: String = "",
      sortKeys: Boolean = true,
      fullPrecision: Boolean = false,
    ): String {
      TransferContext.writeMethodArguments(0L, 0L, ANY to data, STRING to indent, BOOL to sortKeys, BOOL to fullPrecision)
      TransferContext.callMethod(MethodBindings.stringifyPtr)
      return (TransferContext.readReturnValue(STRING) as String)
    }

    /**
     * Attempts to parse the [jsonString] provided and returns the parsed data. Returns `null` if
     * parse failed.
     */
    @JvmStatic
    public final fun parseString(jsonString: String): Any? {
      TransferContext.writeMethodArguments(0L, 0L, STRING to jsonString)
      TransferContext.callMethod(MethodBindings.parseStringPtr)
      return (TransferContext.readReturnValue(ANY) as Any?)
    }

    /**
     * Converts a native engine type to a JSON-compliant value.
     *
     * By default, objects are ignored for security reasons, unless [fullObjects] is `true`.
     *
     * You can convert a native value to a JSON string like this:
     *
     * ```
     * func encode_data(value, full_objects = false):
     * 	return JSON.stringify(JSON.from_native(value, full_objects))
     * ```
     */
    @JvmOverloads
    @JvmStatic
    public final fun fromNative(variant: Any?, fullObjects: Boolean = false): Any? {
      TransferContext.writeMethodArguments(0L, 0L, ANY to variant, BOOL to fullObjects)
      TransferContext.callMethod(MethodBindings.fromNativePtr)
      return (TransferContext.readReturnValue(ANY) as Any?)
    }

    /**
     * Converts a JSON-compliant value that was created with [fromNative] back to native engine
     * types.
     *
     * By default, objects are ignored for security reasons, unless [allowObjects] is `true`.
     *
     * You can convert a JSON string back to a native value like this:
     *
     * ```
     * func decode_data(string, allow_objects = false):
     * 	return JSON.to_native(JSON.parse_string(string), allow_objects)
     * ```
     */
    @JvmOverloads
    @JvmStatic
    public final fun toNative(json: Any?, allowObjects: Boolean = false): Any? {
      TransferContext.writeMethodArguments(0L, 0L, ANY to json, BOOL to allowObjects)
      TransferContext.callMethod(MethodBindings.toNativePtr)
      return (TransferContext.readReturnValue(ANY) as Any?)
    }
  }

  public object MethodBindings {
    internal val stringifyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSON", "stringify", 462733549)

    internal val parseStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSON", "parse_string", 309047738)

    internal val parsePtr: VoidPtr = TypeManager.getMethodBindPtr("JSON", "parse", 885841341)

    internal val getDataPtr: VoidPtr = TypeManager.getMethodBindPtr("JSON", "get_data", 1214101251)

    internal val setDataPtr: VoidPtr = TypeManager.getMethodBindPtr("JSON", "set_data", 1114965689)

    internal val getParsedTextPtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSON", "get_parsed_text", 201670096)

    internal val getErrorLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSON", "get_error_line", 3905245786)

    internal val getErrorMessagePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSON", "get_error_message", 201670096)

    internal val fromNativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSON", "from_native", 2963479484)

    internal val toNativePtr: VoidPtr =
        TypeManager.getMethodBindPtr("JSON", "to_native", 2963479484)
  }
}
