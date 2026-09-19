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
import godot.callMethod_STRING_BOOL_ret_LONG
import godot.callMethod_STRING_BOOL_ret_OBJECT_REF
import godot.callMethod_STRING_LONG_LONG_ret_ARRAY
import godot.callMethod_STRING_LONG_LONG_ret_OBJECT_REF
import godot.callMethod_STRING_STRING_BOOL_LONG_LONG_ret_STRING
import godot.callPtrMethod0
import godot.callPtrMethod0_ret_BOOL
import godot.callPtrMethod0_ret_LONG
import godot.callPtrMethod0_ret_PACKED_STRING_ARRAY
import godot.common.interop.VoidPtr
import godot.core.Error
import godot.core.MethodStringName0
import godot.core.MethodStringName2
import godot.core.MethodStringName3
import godot.core.MethodStringName5
import godot.core.PackedStringArray
import godot.core.VariantArray
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic

/**
 * A regular expression (or regex) is a compact language that can be used to recognize strings that
 * follow a specific pattern, such as URLs, email addresses, complete sentences, etc. For example, a
 * regex of `ab[0-9]` would find any string that is `ab` followed by any number from `0` to `9`. For a
 * more in-depth look, you can easily find various tutorials and detailed explanations on the Internet.
 *
 * To begin, the RegEx object needs to be compiled with the search pattern using [compile] before it
 * can be used. Alternatively, the static method [createFromString] can be used to create and compile a
 * RegEx object in a single method call.
 *
 * ```
 * var regex = RegEx.new()
 * regex.compile("\\w-(\\d+)")
 * # Shorthand to create and compile a regex (used in the examples below):
 * var regex2 = RegEx.create_from_string("\\w-(\\d+)")
 * ```
 *
 * The search pattern must be escaped first for GDScript before it is escaped for the expression.
 * For example, `compile("\\d+")` would be read by RegEx as `\d+`. Similarly,
 * `compile("\"(?:\\\\.|[^\"])*\"")` would be read as `"(?:\\.|[^"])*"`. In GDScript, you can also use
 * raw string literals (r-strings). For example, `compile(r'"(?:\\.|[^"])*"')` would be read the same.
 *
 * Using [search], you can find the pattern within the given text. If a pattern is found,
 * [RegExMatch] is returned and you can retrieve details of the results using methods such as
 * [RegExMatch.getString] and [RegExMatch.getStart].
 *
 * ```
 * var regex = RegEx.create_from_string("\\w-(\\d+)")
 * var result = regex.search("abc n-0123")
 * if result:
 * 	print(result.get_string()) # Prints "n-0123"
 * ```
 *
 * The results of capturing groups `()` can be retrieved by passing the group number to the various
 * methods in [RegExMatch]. Group 0 is the default and will always refer to the entire pattern. In the
 * above example, calling `result.get_string(1)` would give you `0123`.
 *
 * This version of RegEx also supports named capturing groups, and the names can be used to retrieve
 * the results. If two or more groups have the same name, the name would only refer to the first one
 * with a match.
 *
 * ```
 * var regex = RegEx.create_from_string("d(?<digit>[0-9]+)|x(?<digit>[0-9a-f]+)")
 * var result = regex.search("the number is x2f")
 * if result:
 * 	print(result.get_string("digit")) # Prints "2f"
 * ```
 *
 * If you need to process multiple results, [searchAll] generates a list of all non-overlapping
 * results. This can be combined with a `for` loop for convenience.
 *
 * ```
 * # Prints "01 03 0 3f 42"
 * for result in regex.search_all("d01, d03, d0c, x3f and x42"):
 * 	print(result.get_string("digit"))
 * ```
 *
 * **Example:** Split a string using a RegEx:
 *
 * ```
 * var regex = RegEx.create_from_string("\\S+") # Negated whitespace character class.
 * var results = []
 * for result in regex.search_all("One  Two \n\tThree"):
 * 	results.push_back(result.get_string())
 * print(results) # Prints ["One", "Two", "Three"]
 * ```
 *
 * **Note:** Godot's regex implementation is based on the [url=https://www.pcre.org/]PCRE2[/url]
 * library. You can view the full pattern reference
 * [url=https://www.pcre.org/current/doc/html/pcre2pattern.html]here[/url].
 *
 * **Tip:** You can use [url=https://regexr.com/]Regexr[/url] to test regular expressions online.
 */
@GodotBaseType
public open class RegEx : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(605, scriptPtr)
  }

  /**
   * This method resets the state of the object, as if it was freshly created. Namely, it unassigns
   * the regular expression of this object.
   */
  public final fun clear(): Unit {
    TransferContext.callPtrMethod0(ptr, objectID.id, MethodBindings.clearPtr)
  }

  /**
   * Compiles and assign the search pattern to use. Returns [OK] if the compilation is successful.
   * If compilation fails, returns [FAILED] and when [showError] is `true`, details are printed to
   * standard output.
   */
  @JvmOverloads
  public final fun compile(pattern: String, showError: Boolean = true): Error =
      Error.from(TransferContext.callMethod_STRING_BOOL_ret_LONG(ptr, objectID.id, MethodBindings.compilePtr, pattern, showError))

  /**
   * Searches the text for the compiled pattern. Returns a [RegExMatch] container of the first
   * matching result if found, otherwise `null`.
   *
   * The region to search within can be specified with [offset] and [end]. This is useful when
   * searching for another match in the same [subject] by calling this method again after a previous
   * success. Note that setting these parameters differs from passing over a shortened string. For
   * example, the start anchor `^` is not affected by [offset], and the character before [offset] will
   * be checked for the word boundary `\b`.
   */
  @JvmOverloads
  public final fun search(
    subject: String,
    offset: Int = 0,
    end: Int = -1,
  ): RegExMatch? =
      (TransferContext.callMethod_STRING_LONG_LONG_ret_OBJECT_REF(ptr, objectID.id, MethodBindings.searchPtr, subject, offset.toLong(), end.toLong()) as RegExMatch?)

  /**
   * Searches the text for the compiled pattern. Returns an array of [RegExMatch] containers for
   * each non-overlapping result. If no results were found, an empty array is returned instead.
   *
   * The region to search within can be specified with [offset] and [end]. This is useful when
   * searching for another match in the same [subject] by calling this method again after a previous
   * success. Note that setting these parameters differs from passing over a shortened string. For
   * example, the start anchor `^` is not affected by [offset], and the character before [offset] will
   * be checked for the word boundary `\b`.
   */
  @JvmOverloads
  public final fun searchAll(
    subject: String,
    offset: Int = 0,
    end: Int = -1,
  ): VariantArray<RegExMatch> =
      (TransferContext.callMethod_STRING_LONG_LONG_ret_ARRAY(ptr, objectID.id, MethodBindings.searchAllPtr, subject, offset.toLong(), end.toLong()) as VariantArray<RegExMatch>)

  /**
   * Searches the text for the compiled pattern and replaces it with the specified string. Escapes
   * and backreferences such as `$1` and `$name` are expanded and resolved. By default, only the first
   * instance is replaced, but it can be changed for all instances (global replacement).
   *
   * The region to search within can be specified with [offset] and [end]. This is useful when
   * searching for another match in the same [subject] by calling this method again after a previous
   * success. Note that setting these parameters differs from passing over a shortened string. For
   * example, the start anchor `^` is not affected by [offset], and the character before [offset] will
   * be checked for the word boundary `\b`.
   */
  @JvmOverloads
  public final fun sub(
    subject: String,
    replacement: String,
    all: Boolean = false,
    offset: Int = 0,
    end: Int = -1,
  ): String =
      TransferContext.callMethod_STRING_STRING_BOOL_LONG_LONG_ret_STRING(ptr, objectID.id, MethodBindings.subPtr, subject, replacement, all, offset.toLong(), end.toLong())

  /**
   * Returns whether this object has a valid search pattern assigned.
   */
  public final fun isValid(): Boolean =
      TransferContext.callPtrMethod0_ret_BOOL(ptr, objectID.id, MethodBindings.isValidPtr)

  /**
   * Returns the original search pattern that was compiled.
   */
  public final fun getPattern(): String =
      TransferContext.callMethod0_ret_STRING(ptr, objectID.id, MethodBindings.getPatternPtr)

  /**
   * Returns the number of capturing groups in compiled pattern.
   */
  public final fun getGroupCount(): Int =
      TransferContext.callPtrMethod0_ret_LONG(ptr, objectID.id, MethodBindings.getGroupCountPtr).toInt()

  /**
   * Returns an array of names of named capturing groups in the compiled pattern. They are ordered
   * by appearance.
   */
  public final fun getNames(): PackedStringArray =
      TransferContext.callPtrMethod0_ret_PACKED_STRING_ARRAY(ptr, objectID.id, MethodBindings.getNamesPtr)

  public companion object {
    @JvmField
    public val createFromStringName: MethodStringName2<RegEx, RegEx?, String, Boolean> =
        MethodStringName2<RegEx, RegEx?, String, Boolean>("create_from_string")

    @JvmField
    public val clearName: MethodStringName0<RegEx, Unit> = MethodStringName0<RegEx, Unit>("clear")

    @JvmField
    public val compileName: MethodStringName2<RegEx, Error, String, Boolean> =
        MethodStringName2<RegEx, Error, String, Boolean>("compile")

    @JvmField
    public val searchName: MethodStringName3<RegEx, RegExMatch?, String, Int, Int> =
        MethodStringName3<RegEx, RegExMatch?, String, Int, Int>("search")

    @JvmField
    public val searchAllName: MethodStringName3<RegEx, VariantArray<RegExMatch>, String, Int, Int> =
        MethodStringName3<RegEx, VariantArray<RegExMatch>, String, Int, Int>("search_all")

    @JvmField
    public val subName: MethodStringName5<RegEx, String, String, String, Boolean, Int, Int> =
        MethodStringName5<RegEx, String, String, String, Boolean, Int, Int>("sub")

    @JvmField
    public val isValidName: MethodStringName0<RegEx, Boolean> =
        MethodStringName0<RegEx, Boolean>("is_valid")

    @JvmField
    public val getPatternName: MethodStringName0<RegEx, String> =
        MethodStringName0<RegEx, String>("get_pattern")

    @JvmField
    public val getGroupCountName: MethodStringName0<RegEx, Int> =
        MethodStringName0<RegEx, Int>("get_group_count")

    @JvmField
    public val getNamesName: MethodStringName0<RegEx, PackedStringArray> =
        MethodStringName0<RegEx, PackedStringArray>("get_names")

    /**
     * Creates and compiles a new [RegEx] object. See also [compile].
     */
    @JvmOverloads
    @JvmStatic
    public final fun createFromString(pattern: String, showError: Boolean = true): RegEx? =
        (TransferContext.callMethod_STRING_BOOL_ret_OBJECT_REF(0L, 0L, MethodBindings.createFromStringPtr, pattern, showError) as RegEx?)
  }

  public object MethodBindings {
    internal val createFromStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegEx", "create_from_string", 4249111514)

    internal val clearPtr: VoidPtr = TypeManager.getMethodBindPtr("RegEx", "clear", 3218959716)

    internal val compilePtr: VoidPtr = TypeManager.getMethodBindPtr("RegEx", "compile", 3565188097)

    internal val searchPtr: VoidPtr = TypeManager.getMethodBindPtr("RegEx", "search", 3365977994)

    internal val searchAllPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegEx", "search_all", 849021363)

    internal val subPtr: VoidPtr = TypeManager.getMethodBindPtr("RegEx", "sub", 54019702)

    internal val isValidPtr: VoidPtr = TypeManager.getMethodBindPtr("RegEx", "is_valid", 36873697)

    internal val getPatternPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegEx", "get_pattern", 201670096)

    internal val getGroupCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegEx", "get_group_count", 3905245786)

    internal val getNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegEx", "get_names", 1139954409)
  }
}
