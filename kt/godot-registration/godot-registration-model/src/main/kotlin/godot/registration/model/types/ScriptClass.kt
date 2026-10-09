package godot.registration.model.types

import godot.registration.model.RegisteredConstructor
import godot.registration.model.RegisteredFunction
import godot.registration.model.RegisteredProperty
import godot.registration.model.RegisteredSignal

data class ScriptClassConfiguration(
    val isTool: Boolean = false,
)

class ScriptClass(
    override val fqName: String,
    val customName: String?,
    val sourceProjectName: String,
    val sourceFileName: String,
    var isRegistered: Boolean = true,
    val isAbstract: Boolean = false,
    val isGeneric: Boolean = false,
    val isTool: Boolean = false,
    override var parent: GodotClass? = null,
    override var interfaces: List<ScriptInterface> = emptyList(),
    var constructors: List<RegisteredConstructor> = emptyList(),
    override var signals: List<RegisteredSignal> = emptyList(),
    override var properties: List<RegisteredProperty> = emptyList(),
    override var functions: List<RegisteredFunction> = emptyList(),
) : SourceClass(fqName, TypeKind.GODOT_CLASS), ScriptFamily, GodotClass {
    constructor(
        fqName: String,
        customName: String?,
        sourceProjectName: String,
        sourceFileName: String,
        configuration: ScriptClassConfiguration,
        isRegistered: Boolean = true,
        isAbstract: Boolean = false,
        isGeneric: Boolean = false,
        parent: GodotClass? = null,
        interfaces: List<ScriptInterface> = emptyList(),
        constructors: List<RegisteredConstructor> = emptyList(),
        signals: List<RegisteredSignal> = emptyList(),
        properties: List<RegisteredProperty> = emptyList(),
        functions: List<RegisteredFunction> = emptyList(),
    ) : this(
        fqName = fqName,
        customName = customName,
        sourceProjectName = sourceProjectName,
        sourceFileName = sourceFileName,
        isRegistered = isRegistered,
        isAbstract = isAbstract,
        isGeneric = isGeneric,
        isTool = configuration.isTool,
        parent = parent,
        interfaces = interfaces,
        constructors = constructors,
        signals = signals,
        properties = properties,
        functions = functions,
    )
}
