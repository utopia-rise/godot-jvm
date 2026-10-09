// THIS FILE IS GENERATED! DO NOT EDIT IT MANUALLY!
@file:Suppress("PackageDirectoryMismatch", "unused", "FunctionName", "RedundantModalityModifier",
    "UNCHECKED_CAST", "JoinDeclarationAndAssignment", "USELESS_CAST",
    "RemoveRedundantQualifierName", "NOTHING_TO_INLINE", "NON_FINAL_MEMBER_IN_OBJECT",
    "RedundantVisibilityModifier", "RedundantUnitReturnType", "MemberVisibilityCanBePrivate")

package godot.api

import godot.`annotation`.GodotBaseType
import godot.common.interop.VoidPtr
import godot.core.Dictionary
import godot.core.Error
import godot.core.GodotEnum
import godot.core.PackedStringArray
import godot.core.StringName
import godot.core.VariantArray
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public abstract class ScriptLanguageExtension : ScriptLanguage() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(646, scriptPtr)
  }

  public abstract fun _getName(): String

  public abstract fun _init(): Unit

  public abstract fun _getType(): String

  public abstract fun _getExtension(): String

  public abstract fun _finish(): Unit

  public abstract fun _getReservedWords(): PackedStringArray

  public abstract fun _isControlFlowKeyword(keyword: String): Boolean

  public abstract fun _getCommentDelimiters(): PackedStringArray

  public open fun _getDocCommentDelimiters(): PackedStringArray {
    throw NotImplementedError("ScriptLanguageExtension::_getDocCommentDelimiters is not implemented.")
  }

  public abstract fun _getStringDelimiters(): PackedStringArray

  public abstract fun _makeTemplate(
    template: String,
    className: String,
    baseClassName: String,
  ): Script?

  public abstract fun _getBuiltInTemplates(`object`: StringName):
      VariantArray<Dictionary<Any?, Any?>>

  public abstract fun _isUsingTemplates(): Boolean

  public abstract fun _validate(
    script: String,
    path: String,
    validateFunctions: Boolean,
    validateErrors: Boolean,
    validateWarnings: Boolean,
    validateSafeLines: Boolean,
  ): Dictionary<Any?, Any?>

  public abstract fun _validatePath(path: String): String

  public open fun _createScript(): Object? {
    throw NotImplementedError("ScriptLanguageExtension::_createScript is not implemented.")
  }

  public open fun _hasNamedClasses(): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_hasNamedClasses is not implemented.")
  }

  public abstract fun _supportsBuiltinMode(): Boolean

  public abstract fun _supportsDocumentation(): Boolean

  public abstract fun _canInheritFromFile(): Boolean

  /**
   * Returns the line where the function is defined in the code, or `-1` if the function is not
   * present.
   */
  public abstract fun _findFunction(function: String, code: String): Int

  public abstract fun _makeFunction(
    className: String,
    functionName: String,
    functionArgs: PackedStringArray,
  ): String

  public abstract fun _canMakeFunction(): Boolean

  public abstract fun _openInExternalEditor(
    script: Script?,
    line: Int,
    column: Int,
  ): Error

  public abstract fun _overridesExternalEditor(): Boolean

  public open fun _preferredFileNameCasing(): ScriptLanguage.ScriptNameCasing {
    throw NotImplementedError("ScriptLanguageExtension::_preferredFileNameCasing is not implemented.")
  }

  public abstract fun _completeCode(
    code: String,
    path: String,
    owner: Object?,
  ): Dictionary<Any?, Any?>

  public abstract fun _lookupCode(
    code: String,
    symbol: String,
    path: String,
    owner: Object?,
  ): Dictionary<Any?, Any?>

  public abstract fun _autoIndentCode(
    code: String,
    fromLine: Int,
    toLine: Int,
  ): String

  public abstract fun _addGlobalConstant(name: StringName, `value`: Any?): Unit

  public abstract fun _addNamedGlobalConstant(name: StringName, `value`: Any?): Unit

  public abstract fun _removeNamedGlobalConstant(name: StringName): Unit

  public abstract fun _threadEnter(): Unit

  public abstract fun _threadExit(): Unit

  public abstract fun _debugGetError(): String

  public abstract fun _debugGetStackLevelCount(): Int

  public abstract fun _debugGetStackLevelLine(level: Int): Int

  public abstract fun _debugGetStackLevelFunction(level: Int): String

  /**
   * Returns the source associated with a given debug stack position.
   */
  public abstract fun _debugGetStackLevelSource(level: Int): String

  public abstract fun _debugGetStackLevelLocals(
    level: Int,
    maxSubitems: Int,
    maxDepth: Int,
  ): Dictionary<Any?, Any?>

  public abstract fun _debugGetStackLevelMembers(
    level: Int,
    maxSubitems: Int,
    maxDepth: Int,
  ): Dictionary<Any?, Any?>

  public abstract fun _debugGetGlobals(maxSubitems: Int, maxDepth: Int): Dictionary<Any?, Any?>

  public abstract fun _debugParseStackLevelExpression(
    level: Int,
    expression: String,
    maxSubitems: Int,
    maxDepth: Int,
  ): String

  public abstract fun _debugGetCurrentStackInfo(): VariantArray<Dictionary<Any?, Any?>>

  public abstract fun _reloadAllScripts(): Unit

  /**
   * Reloads all [scripts] from disk and the specifics of how that happens is
   * [ScriptLanguageExtension] specific.
   */
  public abstract fun _reloadScripts(scripts: VariantArray<Any?>, softReload: Boolean): Unit

  /**
   * Reloads the given [script] from disk and the specifics of how that happens is
   * [ScriptLanguageExtension] specific.
   */
  public abstract fun _reloadToolScript(script: Script?, softReload: Boolean): Unit

  public abstract fun _getRecognizedExtensions(): PackedStringArray

  public abstract fun _getPublicFunctions(): VariantArray<Dictionary<Any?, Any?>>

  public abstract fun _getPublicConstants(): Dictionary<Any?, Any?>

  public abstract fun _getPublicAnnotations(): VariantArray<Dictionary<Any?, Any?>>

  public abstract fun _profilingStart(): Unit

  public abstract fun _profilingStop(): Unit

  public abstract fun _profilingSetSaveNativeCalls(enable: Boolean): Unit

  public abstract fun _frame(): Unit

  public abstract fun _handlesGlobalClassType(type: String): Boolean

  public abstract fun _getGlobalClassName(path: String): Dictionary<Any?, Any?>

  public enum class LookupResultType(
    public override val `value`: Long,
  ) : GodotEnum {
    SCRIPT_LOCATION(0),
    CLASS(1),
    CLASS_CONSTANT(2),
    CLASS_PROPERTY(3),
    CLASS_METHOD(4),
    CLASS_SIGNAL(5),
    CLASS_ENUM(6),
    CLASS_TBD_GLOBALSCOPE(7),
    CLASS_ANNOTATION(8),
    LOCAL_CONSTANT(9),
    LOCAL_VARIABLE(10),
    MAX(11),
    ;

    public companion object {
      public fun from(`value`: Long): LookupResultType = entries.first { it.`value` == `value` }
    }
  }

  public enum class CodeCompletionLocation(
    public override val `value`: Long,
  ) : GodotEnum {
    /**
     * The option is local to the location of the code completion query - e.g. a local variable.
     * Subsequent value of location represent options from the outer class, the exact value represent
     * how far they are (in terms of inner classes).
     */
    LOCATION_LOCAL(0),
    /**
     * The option is from the containing class or a parent class, relative to the location of the
     * code completion query. Perform a bitwise OR with the class depth (e.g. `0` for the local class,
     * `1` for the parent, `2` for the grandparent, etc.) to store the depth of an option in the class
     * or a parent class.
     */
    LOCATION_PARENT_MASK(256),
    /**
     * The option is from user code which is not local and not in a derived class (e.g. Autoload
     * Singletons).
     */
    LOCATION_OTHER_USER_CODE(512),
    /**
     * The option is from other engine code, not covered by the other enum constants - e.g. built-in
     * classes.
     */
    LOCATION_OTHER(1024),
    ;

    public companion object {
      public fun from(`value`: Long): CodeCompletionLocation =
          entries.first { it.`value` == `value` }
    }
  }

  public enum class CodeCompletionKind(
    public override val `value`: Long,
  ) : GodotEnum {
    CLASS(0),
    FUNCTION(1),
    SIGNAL(2),
    VARIABLE(3),
    MEMBER(4),
    ENUM(5),
    CONSTANT(6),
    NODE_PATH(7),
    FILE_PATH(8),
    PLAIN_TEXT(9),
    KEYWORD(10),
    MAX(11),
    ;

    public companion object {
      public fun from(`value`: Long): CodeCompletionKind = entries.first { it.`value` == `value` }
    }
  }

  public companion object

  public object MethodBindings
}

internal class ScriptLanguageExtensionDummy : ScriptLanguageExtension() {
  public override fun _getName(): String {
    throw NotImplementedError("ScriptLanguageExtension::_getName is only implemented by non-JVM code.")
  }

  public override fun _init(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_init is only implemented by non-JVM code.")
  }

  public override fun _getType(): String {
    throw NotImplementedError("ScriptLanguageExtension::_getType is only implemented by non-JVM code.")
  }

  public override fun _getExtension(): String {
    throw NotImplementedError("ScriptLanguageExtension::_getExtension is only implemented by non-JVM code.")
  }

  public override fun _finish(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_finish is only implemented by non-JVM code.")
  }

  public override fun _getReservedWords(): PackedStringArray {
    throw NotImplementedError("ScriptLanguageExtension::_getReservedWords is only implemented by non-JVM code.")
  }

  public override fun _isControlFlowKeyword(keyword: String): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_isControlFlowKeyword is only implemented by non-JVM code.")
  }

  public override fun _getCommentDelimiters(): PackedStringArray {
    throw NotImplementedError("ScriptLanguageExtension::_getCommentDelimiters is only implemented by non-JVM code.")
  }

  public override fun _getStringDelimiters(): PackedStringArray {
    throw NotImplementedError("ScriptLanguageExtension::_getStringDelimiters is only implemented by non-JVM code.")
  }

  public override fun _makeTemplate(
    template: String,
    className: String,
    baseClassName: String,
  ): Script? {
    throw NotImplementedError("ScriptLanguageExtension::_makeTemplate is only implemented by non-JVM code.")
  }

  public override fun _getBuiltInTemplates(`object`: StringName):
      VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptLanguageExtension::_getBuiltInTemplates is only implemented by non-JVM code.")
  }

  public override fun _isUsingTemplates(): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_isUsingTemplates is only implemented by non-JVM code.")
  }

  public override fun _validate(
    script: String,
    path: String,
    validateFunctions: Boolean,
    validateErrors: Boolean,
    validateWarnings: Boolean,
    validateSafeLines: Boolean,
  ): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_validate is only implemented by non-JVM code.")
  }

  public override fun _validatePath(path: String): String {
    throw NotImplementedError("ScriptLanguageExtension::_validatePath is only implemented by non-JVM code.")
  }

  public override fun _supportsBuiltinMode(): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_supportsBuiltinMode is only implemented by non-JVM code.")
  }

  public override fun _supportsDocumentation(): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_supportsDocumentation is only implemented by non-JVM code.")
  }

  public override fun _canInheritFromFile(): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_canInheritFromFile is only implemented by non-JVM code.")
  }

  public override fun _findFunction(function: String, code: String): Int {
    throw NotImplementedError("ScriptLanguageExtension::_findFunction is only implemented by non-JVM code.")
  }

  public override fun _makeFunction(
    className: String,
    functionName: String,
    functionArgs: PackedStringArray,
  ): String {
    throw NotImplementedError("ScriptLanguageExtension::_makeFunction is only implemented by non-JVM code.")
  }

  public override fun _canMakeFunction(): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_canMakeFunction is only implemented by non-JVM code.")
  }

  public override fun _openInExternalEditor(
    script: Script?,
    line: Int,
    column: Int,
  ): Error {
    throw NotImplementedError("ScriptLanguageExtension::_openInExternalEditor is only implemented by non-JVM code.")
  }

  public override fun _overridesExternalEditor(): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_overridesExternalEditor is only implemented by non-JVM code.")
  }

  public override fun _completeCode(
    code: String,
    path: String,
    owner: Object?,
  ): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_completeCode is only implemented by non-JVM code.")
  }

  public override fun _lookupCode(
    code: String,
    symbol: String,
    path: String,
    owner: Object?,
  ): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_lookupCode is only implemented by non-JVM code.")
  }

  public override fun _autoIndentCode(
    code: String,
    fromLine: Int,
    toLine: Int,
  ): String {
    throw NotImplementedError("ScriptLanguageExtension::_autoIndentCode is only implemented by non-JVM code.")
  }

  public override fun _addGlobalConstant(name: StringName, `value`: Any?): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_addGlobalConstant is only implemented by non-JVM code.")
  }

  public override fun _addNamedGlobalConstant(name: StringName, `value`: Any?): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_addNamedGlobalConstant is only implemented by non-JVM code.")
  }

  public override fun _removeNamedGlobalConstant(name: StringName): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_removeNamedGlobalConstant is only implemented by non-JVM code.")
  }

  public override fun _threadEnter(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_threadEnter is only implemented by non-JVM code.")
  }

  public override fun _threadExit(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_threadExit is only implemented by non-JVM code.")
  }

  public override fun _debugGetError(): String {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetError is only implemented by non-JVM code.")
  }

  public override fun _debugGetStackLevelCount(): Int {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetStackLevelCount is only implemented by non-JVM code.")
  }

  public override fun _debugGetStackLevelLine(level: Int): Int {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetStackLevelLine is only implemented by non-JVM code.")
  }

  public override fun _debugGetStackLevelFunction(level: Int): String {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetStackLevelFunction is only implemented by non-JVM code.")
  }

  public override fun _debugGetStackLevelSource(level: Int): String {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetStackLevelSource is only implemented by non-JVM code.")
  }

  public override fun _debugGetStackLevelLocals(
    level: Int,
    maxSubitems: Int,
    maxDepth: Int,
  ): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetStackLevelLocals is only implemented by non-JVM code.")
  }

  public override fun _debugGetStackLevelMembers(
    level: Int,
    maxSubitems: Int,
    maxDepth: Int,
  ): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetStackLevelMembers is only implemented by non-JVM code.")
  }

  public override fun _debugGetGlobals(maxSubitems: Int, maxDepth: Int): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetGlobals is only implemented by non-JVM code.")
  }

  public override fun _debugParseStackLevelExpression(
    level: Int,
    expression: String,
    maxSubitems: Int,
    maxDepth: Int,
  ): String {
    throw NotImplementedError("ScriptLanguageExtension::_debugParseStackLevelExpression is only implemented by non-JVM code.")
  }

  public override fun _debugGetCurrentStackInfo(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptLanguageExtension::_debugGetCurrentStackInfo is only implemented by non-JVM code.")
  }

  public override fun _reloadAllScripts(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_reloadAllScripts is only implemented by non-JVM code.")
  }

  public override fun _reloadScripts(scripts: VariantArray<Any?>, softReload: Boolean): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_reloadScripts is only implemented by non-JVM code.")
  }

  public override fun _reloadToolScript(script: Script?, softReload: Boolean): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_reloadToolScript is only implemented by non-JVM code.")
  }

  public override fun _getRecognizedExtensions(): PackedStringArray {
    throw NotImplementedError("ScriptLanguageExtension::_getRecognizedExtensions is only implemented by non-JVM code.")
  }

  public override fun _getPublicFunctions(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptLanguageExtension::_getPublicFunctions is only implemented by non-JVM code.")
  }

  public override fun _getPublicConstants(): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_getPublicConstants is only implemented by non-JVM code.")
  }

  public override fun _getPublicAnnotations(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptLanguageExtension::_getPublicAnnotations is only implemented by non-JVM code.")
  }

  public override fun _profilingStart(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_profilingStart is only implemented by non-JVM code.")
  }

  public override fun _profilingStop(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_profilingStop is only implemented by non-JVM code.")
  }

  public override fun _profilingSetSaveNativeCalls(enable: Boolean): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_profilingSetSaveNativeCalls is only implemented by non-JVM code.")
  }

  public override fun _frame(): Unit {
    throw NotImplementedError("ScriptLanguageExtension::_frame is only implemented by non-JVM code.")
  }

  public override fun _handlesGlobalClassType(type: String): Boolean {
    throw NotImplementedError("ScriptLanguageExtension::_handlesGlobalClassType is only implemented by non-JVM code.")
  }

  public override fun _getGlobalClassName(path: String): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptLanguageExtension::_getGlobalClassName is only implemented by non-JVM code.")
  }
}
