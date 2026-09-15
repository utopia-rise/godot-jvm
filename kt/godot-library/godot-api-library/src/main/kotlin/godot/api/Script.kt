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
import godot.core.StringName
import godot.core.VariantArray
import godot.core.asCachedStringName
import godot.readReturnValue_ANY
import godot.readReturnValue_ARRAY
import godot.readReturnValue_BOOL
import godot.readReturnValue_DICTIONARY
import godot.readReturnValue_LONG
import godot.readReturnValue_OBJECT
import godot.readReturnValue_STRING
import godot.readReturnValue_STRING_NAME
import godot.writeMethodArguments0
import godot.writeMethodArguments_BOOL
import godot.writeMethodArguments_OBJECT
import godot.writeMethodArguments_STRING
import godot.writeMethodArguments_STRING_NAME
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmField
import kotlin.jvm.JvmName
import kotlin.jvm.JvmOverloads

/**
 * A class stored as a resource. A script extends the functionality of all objects that instantiate
 * it.
 *
 * This is the base class for all scripts and should not be used directly. Trying to create a new
 * script with this class will result in an error.
 *
 * The `new` method of a script subclass creates a new instance. [Object.setScript] extends an
 * existing object, if that object's class matches one of the script's base classes.
 */
@GodotBaseType
public open class Script internal constructor() : Resource() {
  /**
   * The script source code or an empty string if source code is not available. When set, does not
   * reload the class implementation automatically.
   */
  public final inline var sourceCode: String
    @JvmName("sourceCodeProperty")
    get() = getSourceCode()
    @JvmName("sourceCodeProperty")
    set(`value`) {
      setSourceCode(value)
    }

  public override fun new(scriptPtr: VoidPtr): Unit {
    createNativeObject(642, scriptPtr)
  }

  /**
   * Returns `true` if the script can be instantiated.
   */
  public final fun canInstantiate(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.canInstantiatePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the script contains non-empty source code.
   *
   * **Note:** If a script does not have source code, this does not mean that it is invalid or
   * unusable. For example, a [GDScript] that was exported with binary tokenization has no source code,
   * but still behaves as expected and could be instantiated. This can be checked with
   * [canInstantiate].
   */
  public final fun hasSourceCode(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.hasSourceCodePtr)
    return TransferContext.readReturnValue_BOOL()
  }

  public final fun getSourceCode(): String {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getSourceCodePtr)
    return TransferContext.readReturnValue_STRING()
  }

  public final fun setSourceCode(source: String): Unit {
    TransferContext.writeMethodArguments_STRING(ptr, objectID.id, source)
    TransferContext.callMethod(MethodBindings.setSourceCodePtr)
  }

  /**
   * Reloads the script's class implementation. Returns an error code.
   */
  @JvmOverloads
  public final fun reload(keepState: Boolean = false): Error {
    TransferContext.writeMethodArguments_BOOL(ptr, objectID.id, keepState)
    TransferContext.callMethod(MethodBindings.reloadPtr)
    return Error.from(TransferContext.readReturnValue_LONG())
  }

  /**
   * Returns the script directly inherited by this script.
   */
  public final fun getBaseScript(): Script? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getBaseScriptPtr)
    return (TransferContext.readReturnValue_OBJECT() as Script?)
  }

  /**
   * Returns the script's base type.
   */
  public final fun getInstanceBaseType(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getInstanceBaseTypePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns the class name associated with the script, if there is one. Returns an empty string
   * otherwise.
   *
   * To give the script a global name, you can use the `class_name` keyword in GDScript and the
   * `[GlobalClass]` attribute in C#.
   *
   * ```gdscript
   * //gdscript
   * class_name MyNode
   * extends Node
   * ```
   *
   * ```csharp
   * //csharp
   * using Godot;
   *
   * [GlobalClass]
   * public partial class MyNode : Node
   * {
   * }
   * ```
   */
  public final fun getGlobalName(): StringName {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getGlobalNamePtr)
    return TransferContext.readReturnValue_STRING_NAME()
  }

  /**
   * Returns `true` if the script, or a base class, defines a method with the given name.
   */
  public final fun hasScriptMethod(methodName: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, methodName)
    TransferContext.callMethod(MethodBindings.hasScriptMethodPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the script, or a base class, defines a signal with the given name.
   */
  public final fun hasScriptSignal(signalName: StringName): Boolean {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, signalName)
    TransferContext.callMethod(MethodBindings.hasScriptSignalPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns the list of properties in this [Script].
   *
   * **Note:** The dictionaries returned by this method are formatted identically to those returned
   * by [Object.getPropertyList].
   */
  public final fun getScriptPropertyList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScriptPropertyListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns the list of methods in this [Script].
   *
   * **Note:** The dictionaries returned by this method are formatted identically to those returned
   * by [Object.getMethodList].
   */
  public final fun getScriptMethodList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScriptMethodListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns the list of signals defined in this [Script].
   *
   * **Note:** The dictionaries returned by this method are formatted identically to those returned
   * by [Object.getSignalList].
   */
  public final fun getScriptSignalList(): VariantArray<Dictionary<Any?, Any?>> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScriptSignalListPtr)
    return (TransferContext.readReturnValue_ARRAY() as VariantArray<Dictionary<Any?, Any?>>)
  }

  /**
   * Returns a dictionary containing constant names and their values.
   */
  public final fun getScriptConstantMap(): Dictionary<Any?, Any?> {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getScriptConstantMapPtr)
    return (TransferContext.readReturnValue_DICTIONARY() as Dictionary<Any?, Any?>)
  }

  /**
   * Returns the default value of the specified property.
   */
  public final fun getPropertyDefaultValue(`property`: StringName): Any? {
    TransferContext.writeMethodArguments_STRING_NAME(ptr, objectID.id, property)
    TransferContext.callMethod(MethodBindings.getPropertyDefaultValuePtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns `true` if the script is a tool script. A tool script can run in the editor.
   */
  public final fun isTool(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isToolPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the script is an abstract script. An abstract script does not have a
   * constructor and cannot be instantiated.
   */
  public final fun isAbstract(): Boolean {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.isAbstractPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns a [Dictionary] mapping method names to their RPC configuration defined by this script.
   */
  public final fun getRpcConfig(): Any? {
    TransferContext.writeMethodArguments0(ptr, objectID.id)
    TransferContext.callMethod(MethodBindings.getRpcConfigPtr)
    return TransferContext.readReturnValue_ANY()
  }

  /**
   * Returns `true` if [baseObject] is an instance of this script.
   */
  public final fun instanceHas(baseObject: Object?): Boolean {
    TransferContext.writeMethodArguments_OBJECT(ptr, objectID.id, baseObject)
    TransferContext.callMethod(MethodBindings.instanceHasPtr)
    return TransferContext.readReturnValue_BOOL()
  }

  /**
   * Returns `true` if the script, or a base class, defines a method with the given name.
   */
  public final fun hasScriptMethod(methodName: String): Boolean =
      hasScriptMethod(methodName.asCachedStringName())

  /**
   * Returns `true` if the script, or a base class, defines a signal with the given name.
   */
  public final fun hasScriptSignal(signalName: String): Boolean =
      hasScriptSignal(signalName.asCachedStringName())

  /**
   * Returns the default value of the specified property.
   */
  public final fun getPropertyDefaultValue(`property`: String): Any? =
      getPropertyDefaultValue(property.asCachedStringName())

  public companion object {
    @JvmField
    public val canInstantiateName: MethodStringName0<Script, Boolean> =
        MethodStringName0<Script, Boolean>("can_instantiate")

    @JvmField
    public val hasSourceCodeName: MethodStringName0<Script, Boolean> =
        MethodStringName0<Script, Boolean>("has_source_code")

    @JvmField
    public val getSourceCodeName: MethodStringName0<Script, String> =
        MethodStringName0<Script, String>("get_source_code")

    @JvmField
    public val setSourceCodeName: MethodStringName1<Script, Unit, String> =
        MethodStringName1<Script, Unit, String>("set_source_code")

    @JvmField
    public val reloadName: MethodStringName1<Script, Error, Boolean> =
        MethodStringName1<Script, Error, Boolean>("reload")

    @JvmField
    public val getBaseScriptName: MethodStringName0<Script, Script?> =
        MethodStringName0<Script, Script?>("get_base_script")

    @JvmField
    public val getInstanceBaseTypeName: MethodStringName0<Script, StringName> =
        MethodStringName0<Script, StringName>("get_instance_base_type")

    @JvmField
    public val getGlobalNameName: MethodStringName0<Script, StringName> =
        MethodStringName0<Script, StringName>("get_global_name")

    @JvmField
    public val hasScriptMethodName: MethodStringName1<Script, Boolean, StringName> =
        MethodStringName1<Script, Boolean, StringName>("has_script_method")

    @JvmField
    public val hasScriptSignalName: MethodStringName1<Script, Boolean, StringName> =
        MethodStringName1<Script, Boolean, StringName>("has_script_signal")

    @JvmField
    public val getScriptPropertyListName:
        MethodStringName0<Script, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<Script, VariantArray<Dictionary<Any?, Any?>>>("get_script_property_list")

    @JvmField
    public val getScriptMethodListName:
        MethodStringName0<Script, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<Script, VariantArray<Dictionary<Any?, Any?>>>("get_script_method_list")

    @JvmField
    public val getScriptSignalListName:
        MethodStringName0<Script, VariantArray<Dictionary<Any?, Any?>>> =
        MethodStringName0<Script, VariantArray<Dictionary<Any?, Any?>>>("get_script_signal_list")

    @JvmField
    public val getScriptConstantMapName: MethodStringName0<Script, Dictionary<Any?, Any?>> =
        MethodStringName0<Script, Dictionary<Any?, Any?>>("get_script_constant_map")

    @JvmField
    public val getPropertyDefaultValueName: MethodStringName1<Script, Any?, StringName> =
        MethodStringName1<Script, Any?, StringName>("get_property_default_value")

    @JvmField
    public val isToolName: MethodStringName0<Script, Boolean> =
        MethodStringName0<Script, Boolean>("is_tool")

    @JvmField
    public val isAbstractName: MethodStringName0<Script, Boolean> =
        MethodStringName0<Script, Boolean>("is_abstract")

    @JvmField
    public val getRpcConfigName: MethodStringName0<Script, Any?> =
        MethodStringName0<Script, Any?>("get_rpc_config")

    @JvmField
    public val instanceHasName: MethodStringName1<Script, Boolean, Object?> =
        MethodStringName1<Script, Boolean, Object?>("instance_has")
  }

  public object MethodBindings {
    internal val canInstantiatePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "can_instantiate", 36873697)

    internal val hasSourceCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "has_source_code", 36873697)

    internal val getSourceCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_source_code", 201670096)

    internal val setSourceCodePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "set_source_code", 83702148)

    internal val reloadPtr: VoidPtr = TypeManager.getMethodBindPtr("Script", "reload", 1633102583)

    internal val getBaseScriptPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_base_script", 278624046)

    internal val getInstanceBaseTypePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_instance_base_type", 2002593661)

    internal val getGlobalNamePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_global_name", 2002593661)

    internal val hasScriptMethodPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "has_script_method", 2619796661)

    internal val hasScriptSignalPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "has_script_signal", 2619796661)

    internal val getScriptPropertyListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_script_property_list", 2915620761)

    internal val getScriptMethodListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_script_method_list", 2915620761)

    internal val getScriptSignalListPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_script_signal_list", 2915620761)

    internal val getScriptConstantMapPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_script_constant_map", 2382534195)

    internal val getPropertyDefaultValuePtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_property_default_value", 2138907829)

    internal val isToolPtr: VoidPtr = TypeManager.getMethodBindPtr("Script", "is_tool", 36873697)

    internal val isAbstractPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "is_abstract", 36873697)

    internal val getRpcConfigPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "get_rpc_config", 1214101251)

    internal val instanceHasPtr: VoidPtr =
        TypeManager.getMethodBindPtr("Script", "instance_has", 397768994)
  }
}
