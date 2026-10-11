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
import godot.core.StringName
import godot.core.VariantArray
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.NotImplementedError
import kotlin.String
import kotlin.Suppress
import kotlin.Unit

@GodotBaseType
public abstract class ScriptExtension : Script() {
  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(644, scriptPtr)
  }

  public abstract fun _editorCanReloadFromFile(): Boolean

  public abstract fun _canInstantiate(): Boolean

  public abstract fun _getBaseScript(): Script?

  public abstract fun _getGlobalName(): StringName

  public abstract fun _inheritsScript(script: Script?): Boolean

  public abstract fun _getInstanceBaseType(): StringName

  public abstract fun _hasSourceCode(): Boolean

  public abstract fun _getSourceCode(): String

  public abstract fun _setSourceCode(code: String): Unit

  public abstract fun _reload(keepState: Boolean): Error

  public abstract fun _getDocClassName(): StringName

  public abstract fun _getDocumentation(): VariantArray<Dictionary<Any?, Any?>>

  public open fun _getClassIconPath(): String {
    throw NotImplementedError("ScriptExtension::_getClassIconPath is not implemented.")
  }

  public abstract fun _hasMethod(method: StringName): Boolean

  public abstract fun _hasStaticMethod(method: StringName): Boolean

  /**
   * Return the expected argument count for the given [method], or `null` if it can't be determined
   * (which will then fall back to the default behavior).
   */
  public open fun _getScriptMethodArgumentCount(method: StringName): Any? {
    throw NotImplementedError("ScriptExtension::_getScriptMethodArgumentCount is not implemented.")
  }

  public abstract fun _getMethodInfo(method: StringName): Dictionary<Any?, Any?>

  public abstract fun _isTool(): Boolean

  public abstract fun _isValid(): Boolean

  /**
   * Returns `true` if the script is an abstract script. Abstract scripts cannot be instantiated
   * directly, instead other scripts should inherit them. Abstract scripts will be either unselectable
   * or hidden in the Create New Node dialog (unselectable if there are non-abstract classes inheriting
   * it, otherwise hidden).
   */
  public open fun _isAbstract(): Boolean {
    throw NotImplementedError("ScriptExtension::_isAbstract is not implemented.")
  }

  public abstract fun _getLanguage(): ScriptLanguage?

  public abstract fun _hasScriptSignal(signal: StringName): Boolean

  public abstract fun _getScriptSignalList(): VariantArray<Dictionary<Any?, Any?>>

  public abstract fun _hasPropertyDefaultValue(`property`: StringName): Boolean

  public abstract fun _getPropertyDefaultValue(`property`: StringName): Any?

  public abstract fun _updateExports(): Unit

  public abstract fun _getScriptMethodList(): VariantArray<Dictionary<Any?, Any?>>

  public abstract fun _getScriptPropertyList(): VariantArray<Dictionary<Any?, Any?>>

  public abstract fun _getMemberLine(member: StringName): Int

  public abstract fun _getConstants(): Dictionary<Any?, Any?>

  public abstract fun _getMembers(): VariantArray<StringName>

  public abstract fun _isPlaceholderFallbackEnabled(): Boolean

  public abstract fun _getRpcConfig(): Any?

  public open fun _instanceHas(`object`: Object?): Boolean {
    throw NotImplementedError("ScriptExtension::_instanceHas is not implemented.")
  }

  public companion object

  public object MethodBindings
}

@GodotBaseType
internal class ScriptExtensionDummy : ScriptExtension() {
  public override fun _editorCanReloadFromFile(): Boolean {
    throw NotImplementedError("ScriptExtension::_editorCanReloadFromFile is only implemented by non-JVM code.")
  }

  public override fun _canInstantiate(): Boolean {
    throw NotImplementedError("ScriptExtension::_canInstantiate is only implemented by non-JVM code.")
  }

  public override fun _getBaseScript(): Script? {
    throw NotImplementedError("ScriptExtension::_getBaseScript is only implemented by non-JVM code.")
  }

  public override fun _getGlobalName(): StringName {
    throw NotImplementedError("ScriptExtension::_getGlobalName is only implemented by non-JVM code.")
  }

  public override fun _inheritsScript(script: Script?): Boolean {
    throw NotImplementedError("ScriptExtension::_inheritsScript is only implemented by non-JVM code.")
  }

  public override fun _getInstanceBaseType(): StringName {
    throw NotImplementedError("ScriptExtension::_getInstanceBaseType is only implemented by non-JVM code.")
  }

  public override fun _hasSourceCode(): Boolean {
    throw NotImplementedError("ScriptExtension::_hasSourceCode is only implemented by non-JVM code.")
  }

  public override fun _getSourceCode(): String {
    throw NotImplementedError("ScriptExtension::_getSourceCode is only implemented by non-JVM code.")
  }

  public override fun _setSourceCode(code: String): Unit {
    throw NotImplementedError("ScriptExtension::_setSourceCode is only implemented by non-JVM code.")
  }

  public override fun _reload(keepState: Boolean): Error {
    throw NotImplementedError("ScriptExtension::_reload is only implemented by non-JVM code.")
  }

  public override fun _getDocClassName(): StringName {
    throw NotImplementedError("ScriptExtension::_getDocClassName is only implemented by non-JVM code.")
  }

  public override fun _getDocumentation(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptExtension::_getDocumentation is only implemented by non-JVM code.")
  }

  public override fun _hasMethod(method: StringName): Boolean {
    throw NotImplementedError("ScriptExtension::_hasMethod is only implemented by non-JVM code.")
  }

  public override fun _hasStaticMethod(method: StringName): Boolean {
    throw NotImplementedError("ScriptExtension::_hasStaticMethod is only implemented by non-JVM code.")
  }

  public override fun _getMethodInfo(method: StringName): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptExtension::_getMethodInfo is only implemented by non-JVM code.")
  }

  public override fun _isTool(): Boolean {
    throw NotImplementedError("ScriptExtension::_isTool is only implemented by non-JVM code.")
  }

  public override fun _isValid(): Boolean {
    throw NotImplementedError("ScriptExtension::_isValid is only implemented by non-JVM code.")
  }

  public override fun _getLanguage(): ScriptLanguage? {
    throw NotImplementedError("ScriptExtension::_getLanguage is only implemented by non-JVM code.")
  }

  public override fun _hasScriptSignal(signal: StringName): Boolean {
    throw NotImplementedError("ScriptExtension::_hasScriptSignal is only implemented by non-JVM code.")
  }

  public override fun _getScriptSignalList(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptExtension::_getScriptSignalList is only implemented by non-JVM code.")
  }

  public override fun _hasPropertyDefaultValue(`property`: StringName): Boolean {
    throw NotImplementedError("ScriptExtension::_hasPropertyDefaultValue is only implemented by non-JVM code.")
  }

  public override fun _getPropertyDefaultValue(`property`: StringName): Any? {
    throw NotImplementedError("ScriptExtension::_getPropertyDefaultValue is only implemented by non-JVM code.")
  }

  public override fun _updateExports(): Unit {
    throw NotImplementedError("ScriptExtension::_updateExports is only implemented by non-JVM code.")
  }

  public override fun _getScriptMethodList(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptExtension::_getScriptMethodList is only implemented by non-JVM code.")
  }

  public override fun _getScriptPropertyList(): VariantArray<Dictionary<Any?, Any?>> {
    throw NotImplementedError("ScriptExtension::_getScriptPropertyList is only implemented by non-JVM code.")
  }

  public override fun _getMemberLine(member: StringName): Int {
    throw NotImplementedError("ScriptExtension::_getMemberLine is only implemented by non-JVM code.")
  }

  public override fun _getConstants(): Dictionary<Any?, Any?> {
    throw NotImplementedError("ScriptExtension::_getConstants is only implemented by non-JVM code.")
  }

  public override fun _getMembers(): VariantArray<StringName> {
    throw NotImplementedError("ScriptExtension::_getMembers is only implemented by non-JVM code.")
  }

  public override fun _isPlaceholderFallbackEnabled(): Boolean {
    throw NotImplementedError("ScriptExtension::_isPlaceholderFallbackEnabled is only implemented by non-JVM code.")
  }

  public override fun _getRpcConfig(): Any? {
    throw NotImplementedError("ScriptExtension::_getRpcConfig is only implemented by non-JVM code.")
  }
}
