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
import godot.core.MethodStringName0
import godot.core.MethodStringName1
import godot.core.MethodStringName2
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
import kotlin.jvm.JvmOverloads

/**
 * [ScriptBacktrace] holds an already captured backtrace of a specific script language, such as
 * GDScript or C#, which are captured using [Engine.captureScriptBacktraces].
 *
 * See [ProjectSettings.debug/settings/gdscript/alwaysTrackCallStacks] and
 * [ProjectSettings.debug/settings/gdscript/alwaysTrackLocalVariables] for ways of controlling the
 * contents of this class.
 */
@GodotBaseType
public open class ScriptBacktrace : RefCounted() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(643, scriptPtr)
  }

  /**
   * Returns the name of the script language that this backtrace was captured from.
   */
  public final fun getLanguageName(): String {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getLanguageNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns `true` if the backtrace has no stack frames.
   */
  public final fun isEmpty(): Boolean {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isEmptyPtr)
    return (TransferContext.readReturnValue(BOOL) as Boolean)
  }

  /**
   * Returns the number of stack frames in the backtrace.
   */
  public final fun getFrameCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getFrameCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the name of the function called at the stack frame at the specified index.
   */
  public final fun getFrameFunction(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getFrameFunctionPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the file name of the call site represented by the stack frame at the specified index.
   */
  public final fun getFrameFile(index: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getFrameFilePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the line number of the call site represented by the stack frame at the specified index.
   */
  public final fun getFrameLine(index: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to index.toLong())
    TransferContext.callMethod(MethodBindings.getFrameLinePtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the number of global variables (e.g. autoload singletons) in the backtrace.
   *
   * **Note:** This will be non-zero only if the `include_variables` parameter was `true` when
   * capturing the backtrace with [Engine.captureScriptBacktraces].
   */
  public final fun getGlobalVariableCount(): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalVariableCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the name of the global variable at the specified index.
   */
  public final fun getGlobalVariableName(variableIndex: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to variableIndex.toLong())
    TransferContext.callMethod(MethodBindings.getGlobalVariableNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the value of the global variable at the specified index.
   *
   * **Warning:** With GDScript backtraces, the returned [Any] will be the variable's actual value,
   * including any object references. This means that storing the returned [Any] will prevent any such
   * object from being deallocated, so it's generally recommended not to do so.
   */
  public final fun getGlobalVariableValue(variableIndex: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to variableIndex.toLong())
    TransferContext.callMethod(MethodBindings.getGlobalVariableValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the number of local variables in the stack frame at the specified index.
   *
   * **Note:** This will be non-zero only if the `include_variables` parameter was `true` when
   * capturing the backtrace with [Engine.captureScriptBacktraces].
   */
  public final fun getLocalVariableCount(frameIndex: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frameIndex.toLong())
    TransferContext.callMethod(MethodBindings.getLocalVariableCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the name of the local variable at the specified [variableIndex] in the stack frame at
   * the specified [frameIndex].
   */
  public final fun getLocalVariableName(frameIndex: Int, variableIndex: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frameIndex.toLong(), LONG to variableIndex.toLong())
    TransferContext.callMethod(MethodBindings.getLocalVariableNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the value of the local variable at the specified [variableIndex] in the stack frame at
   * the specified [frameIndex].
   *
   * **Warning:** With GDScript backtraces, the returned [Any] will be the variable's actual value,
   * including any object references. This means that storing the returned [Any] will prevent any such
   * object from being deallocated, so it's generally recommended not to do so.
   */
  public final fun getLocalVariableValue(frameIndex: Int, variableIndex: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frameIndex.toLong(), LONG to variableIndex.toLong())
    TransferContext.callMethod(MethodBindings.getLocalVariableValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Returns the number of member variables in the stack frame at the specified index.
   *
   * **Note:** This will be non-zero only if the `include_variables` parameter was `true` when
   * capturing the backtrace with [Engine.captureScriptBacktraces].
   */
  public final fun getMemberVariableCount(frameIndex: Int): Int {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frameIndex.toLong())
    TransferContext.callMethod(MethodBindings.getMemberVariableCountPtr)
    return (TransferContext.readReturnValue(LONG) as Long).toInt()
  }

  /**
   * Returns the name of the member variable at the specified [variableIndex] in the stack frame at
   * the specified [frameIndex].
   */
  public final fun getMemberVariableName(frameIndex: Int, variableIndex: Int): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frameIndex.toLong(), LONG to variableIndex.toLong())
    TransferContext.callMethod(MethodBindings.getMemberVariableNamePtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  /**
   * Returns the value of the member variable at the specified [variableIndex] in the stack frame at
   * the specified [frameIndex].
   *
   * **Warning:** With GDScript backtraces, the returned [Any] will be the variable's actual value,
   * including any object references. This means that storing the returned [Any] will prevent any such
   * object from being deallocated, so it's generally recommended not to do so.
   */
  public final fun getMemberVariableValue(frameIndex: Int, variableIndex: Int): Any? {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to frameIndex.toLong(), LONG to variableIndex.toLong())
    TransferContext.callMethod(MethodBindings.getMemberVariableValuePtr)
    return (TransferContext.readReturnValue(ANY) as Any?)
  }

  /**
   * Converts the backtrace to a [String], where the entire string will be indented by [indentAll]
   * number of spaces, and the individual stack frames will be additionally indented by [indentFrames]
   * number of spaces.
   *
   * **Note:** Calling [Object.toString] on a [ScriptBacktrace] will produce the same output as
   * calling [format] with all parameters left at their default values.
   */
  @JvmOverloads
  public final fun format(indentAll: Int = 0, indentFrames: Int = 4): String {
    TransferContext.writeMethodArguments(ptr, objectID.id, LONG to indentAll.toLong(), LONG to indentFrames.toLong())
    TransferContext.callMethod(MethodBindings.formatPtr)
    return (TransferContext.readReturnValue(STRING) as String)
  }

  public companion object {
    @JvmField
    public val getLanguageNameName: MethodStringName0<ScriptBacktrace, String> =
        MethodStringName0<ScriptBacktrace, String>("get_language_name")

    @JvmField
    public val isEmptyName: MethodStringName0<ScriptBacktrace, Boolean> =
        MethodStringName0<ScriptBacktrace, Boolean>("is_empty")

    @JvmField
    public val getFrameCountName: MethodStringName0<ScriptBacktrace, Int> =
        MethodStringName0<ScriptBacktrace, Int>("get_frame_count")

    @JvmField
    public val getFrameFunctionName: MethodStringName1<ScriptBacktrace, String, Int> =
        MethodStringName1<ScriptBacktrace, String, Int>("get_frame_function")

    @JvmField
    public val getFrameFileName: MethodStringName1<ScriptBacktrace, String, Int> =
        MethodStringName1<ScriptBacktrace, String, Int>("get_frame_file")

    @JvmField
    public val getFrameLineName: MethodStringName1<ScriptBacktrace, Int, Int> =
        MethodStringName1<ScriptBacktrace, Int, Int>("get_frame_line")

    @JvmField
    public val getGlobalVariableCountName: MethodStringName0<ScriptBacktrace, Int> =
        MethodStringName0<ScriptBacktrace, Int>("get_global_variable_count")

    @JvmField
    public val getGlobalVariableNameName: MethodStringName1<ScriptBacktrace, String, Int> =
        MethodStringName1<ScriptBacktrace, String, Int>("get_global_variable_name")

    @JvmField
    public val getGlobalVariableValueName: MethodStringName1<ScriptBacktrace, Any?, Int> =
        MethodStringName1<ScriptBacktrace, Any?, Int>("get_global_variable_value")

    @JvmField
    public val getLocalVariableCountName: MethodStringName1<ScriptBacktrace, Int, Int> =
        MethodStringName1<ScriptBacktrace, Int, Int>("get_local_variable_count")

    @JvmField
    public val getLocalVariableNameName: MethodStringName2<ScriptBacktrace, String, Int, Int> =
        MethodStringName2<ScriptBacktrace, String, Int, Int>("get_local_variable_name")

    @JvmField
    public val getLocalVariableValueName: MethodStringName2<ScriptBacktrace, Any?, Int, Int> =
        MethodStringName2<ScriptBacktrace, Any?, Int, Int>("get_local_variable_value")

    @JvmField
    public val getMemberVariableCountName: MethodStringName1<ScriptBacktrace, Int, Int> =
        MethodStringName1<ScriptBacktrace, Int, Int>("get_member_variable_count")

    @JvmField
    public val getMemberVariableNameName: MethodStringName2<ScriptBacktrace, String, Int, Int> =
        MethodStringName2<ScriptBacktrace, String, Int, Int>("get_member_variable_name")

    @JvmField
    public val getMemberVariableValueName: MethodStringName2<ScriptBacktrace, Any?, Int, Int> =
        MethodStringName2<ScriptBacktrace, Any?, Int, Int>("get_member_variable_value")

    @JvmField
    public val formatName: MethodStringName2<ScriptBacktrace, String, Int, Int> =
        MethodStringName2<ScriptBacktrace, String, Int, Int>("format")
  }

  public object MethodBindings {
    internal val getLanguageNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_language_name", 201670096)

    internal val isEmptyPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "is_empty", 36873697)

    internal val getFrameCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_frame_count", 3905245786)

    internal val getFrameFunctionPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_frame_function", 844755477)

    internal val getFrameFilePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_frame_file", 844755477)

    internal val getFrameLinePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_frame_line", 923996154)

    internal val getGlobalVariableCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_global_variable_count", 3905245786)

    internal val getGlobalVariableNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_global_variable_name", 844755477)

    internal val getGlobalVariableValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_global_variable_value", 4227898402)

    internal val getLocalVariableCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_local_variable_count", 923996154)

    internal val getLocalVariableNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_local_variable_name", 1391810591)

    internal val getLocalVariableValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_local_variable_value", 678354945)

    internal val getMemberVariableCountPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_member_variable_count", 923996154)

    internal val getMemberVariableNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_member_variable_name", 1391810591)

    internal val getMemberVariableValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "get_member_variable_value", 678354945)

    internal val formatPtr: VoidPtr =
        TypeManager.getMethodBindPtr("ScriptBacktrace", "format", 3464456933)
  }
}
