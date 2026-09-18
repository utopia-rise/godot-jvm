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
import godot.core.PackedStringArray
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.readReturnValue_PACKED_STRING_ARRAY
import godot.readReturnValue_STRING
import godot.writeMethodArguments0
import godot.writeMethodArguments_ANY
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * Contains the results of a single [RegEx] match returned by [RegEx.search] and [RegEx.searchAll].
 * It can be used to find the position and range of the match and its capturing groups, and it can
 * extract its substring for you.
 */
@GodotBaseType
public open class RegExMatch : RefCounted() {
  /**
   * The source string used with the search pattern to find this matching result.
   */
  public final inline val subject: String
    @JvmName("subjectProperty")
    get() = getSubject()

  /**
   * A dictionary of named groups and its corresponding group number. Only groups that were matched
   * are included. If multiple groups have the same name, that name would refer to the first matching
   * one.
   */
  public final inline val names: Dictionary<Any?, Any?>
    @JvmName("namesProperty")
    get() = getNames()

  /**
   * An [VariantArray] of the match and its capturing groups.
   */
  public final inline val strings: PackedStringArray
    @JvmName("stringsProperty")
    get() = getStrings()

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(606, scriptPtr)
  }

  public final fun getSubject(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSubjectPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the number of capturing groups.
   */
  public final fun getGroupCount(): Int {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getGroupCountPtr, 2)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public final fun getNames(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getNamesPtr, 27)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  public final fun getStrings(): PackedStringArray {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callPtrMethod(MethodBindings.getStringsPtr, 34)
    return TransferContext.readReturnValue_PACKED_STRING_ARRAY()
  }

  /**
   * Returns the substring of the match from the source string. Capturing groups can be retrieved by
   * providing its group number as an integer or its string name (if it's a named group). The default
   * value of 0 refers to the whole pattern.
   *
   * Returns an empty string if the group did not match or doesn't exist.
   */
  @JvmOverloads
  public final fun getString(name: Any? = 0): String {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.getStringPtr)
    return TransferContext.readReturnValue_STRING()
  }

  /**
   * Returns the starting position of the match within the source string. The starting position of
   * capturing groups can be retrieved by providing its group number as an integer or its string name
   * (if it's a named group). The default value of 0 refers to the whole pattern.
   *
   * Returns -1 if the group did not match or doesn't exist.
   */
  @JvmOverloads
  public final fun getStart(name: Any? = 0): Int {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.getStartPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  /**
   * Returns the end position of the match within the source string. The end position of capturing
   * groups can be retrieved by providing its group number as an integer or its string name (if it's a
   * named group). The default value of 0 refers to the whole pattern.
   *
   * Returns -1 if the group did not match or doesn't exist.
   */
  @JvmOverloads
  public final fun getEnd(name: Any? = 0): Int {
    TransferContext.writeMethodArguments_ANY(ptr, objectID.id, name)
    TransferContext.callMethod(MethodBindings.getEndPtr)
    return TransferContext.readReturnValue_LONG().toInt()
  }

  public companion object {
    @JvmField
    public val getSubjectName: MethodStringName0<RegExMatch, String> =
        MethodStringName0<RegExMatch, String>("get_subject")

    @JvmField
    public val getGroupCountName: MethodStringName0<RegExMatch, Int> =
        MethodStringName0<RegExMatch, Int>("get_group_count")

    @JvmField
    public val getNamesName: MethodStringName0<RegExMatch, Dictionary<Any?, Any?>> =
        MethodStringName0<RegExMatch, Dictionary<Any?, Any?>>("get_names")

    @JvmField
    public val getStringsName: MethodStringName0<RegExMatch, PackedStringArray> =
        MethodStringName0<RegExMatch, PackedStringArray>("get_strings")

    @JvmField
    public val getStringName: MethodStringName1<RegExMatch, String, Any?> =
        MethodStringName1<RegExMatch, String, Any?>("get_string")

    @JvmField
    public val getStartName: MethodStringName1<RegExMatch, Int, Any?> =
        MethodStringName1<RegExMatch, Int, Any?>("get_start")

    @JvmField
    public val getEndName: MethodStringName1<RegExMatch, Int, Any?> =
        MethodStringName1<RegExMatch, Int, Any?>("get_end")
  }

  public object MethodBindings {
    internal val getSubjectPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegExMatch", "get_subject", 201670096)

    internal val getGroupCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegExMatch", "get_group_count", 3905245786)

    internal val getNamesPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegExMatch", "get_names", 3102165223)

    internal val getStringsPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegExMatch", "get_strings", 1139954409)

    internal val getStringPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegExMatch", "get_string", 687115856)

    internal val getStartPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegExMatch", "get_start", 490464691)

    internal val getEndPtr: VoidPtr =
        TypeManager.getMethodBindPtr("RegExMatch", "get_end", 490464691)
  }
}
