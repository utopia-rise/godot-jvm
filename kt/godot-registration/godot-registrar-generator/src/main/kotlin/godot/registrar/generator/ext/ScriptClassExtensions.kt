package godot.registrar.generator.ext

import godot.common.extensions.convertToSnakeCase
import godot.registrar.generator.GeneratorContext
import godot.registrar.generator.RegisteredNameMode
import godot.registrar.generator.RegistrationFileLayoutMode
import godot.registrar.generator.Settings
import godot.registration.model.RegisteredFunction
import godot.registration.model.RegisteredProperty
import godot.registration.model.RegisteredSignal
import godot.registration.model.types.GodotClass
import godot.registration.model.types.ScriptClass
import godot.registration.model.types.ScriptFamily
import godot.tools.common.constants.FileExtensions

fun ScriptClass.shouldGenerateGdjFile(settings: Settings): Boolean =
    !isAbstract && sourceProjectName != settings.projectName

fun ScriptClass.getRegisteredName(settings: Settings): String {
    val baseRegisteredName = customName
        ?.takeIf { it.isNotBlank() }
        ?: fqName.substringAfterLast(".")

    val rawName = when (settings.registeredNameMode) {
        RegisteredNameMode.SIMPLE_NAME -> baseRegisteredName
        RegisteredNameMode.FQ_NAME -> fqName.substringBeforeLast(".", missingDelimiterValue = "").let { packageName ->
            if (packageName.isBlank()) {
                baseRegisteredName
            } else {
                "$packageName.$baseRegisteredName"
            }
        }

        RegisteredNameMode.PROJECT_PREFIX -> {
            if (sourceProjectName == settings.projectName) {
                baseRegisteredName
            } else {
                "${sourceProjectName}_$baseRegisteredName"
            }
        }
    }

    return rawName.replace('.', '_').replace('-', '_')
}

fun ScriptClass.provideRegistrationFileRelativePath(settings: Settings): String {
    val relativeDir = buildString {
        if (sourceProjectName != settings.projectName) {
            append(sourceProjectName)
        }

        if (settings.registrationFileLayoutMode == RegistrationFileLayoutMode.HIERARCHICAL && fqName.contains(".")) {
            val packagePath = fqName.substringBeforeLast(".").replace(".", "/")
            if (isNotEmpty()) {
                append("/")
            }
            append(packagePath)
        }
    }

    return buildString {
        if (relativeDir.isNotEmpty()) {
            append(relativeDir)
            append("/")
        }
        append(getRegisteredName(settings))
        append(".")
        append(FileExtensions.GodotJvm.registrationFile)
    }
}

fun ScriptClass.baseGodotClassName(): String =
    godotBaseClass
        ?.fqName
        ?.substringAfterLast(".")
        .orEmpty()

fun ScriptClass.inheritsRefCounted(): Boolean =
    generateSequence(this as GodotClass?) { godotClass -> godotClass.parent }
        .any { godotClass -> godotClass.fqName == godot.api.RefCounted::class.java.name }

fun ScriptClass.flattenedHierarchy(context: GeneratorContext): List<ScriptFamily> {
    val accumulator = LinkedHashSet<ScriptFamily>()

    fun visit(node: ScriptFamily) {
        node.interfaces.forEach { iface ->
            if (accumulator.add(iface)) {
                visit(iface)
            }
        }
        if (node is GodotClass) {
            node.parent?.let { parent ->
                if (parent is ScriptFamily && accumulator.add(parent)) {
                    visit(parent)
                }
            }
        }
    }

    visit(this)
    return accumulator.toList()
}

fun ScriptClass.registeredSupertypes(): List<ScriptClass> =
    generateSequence(parent) { godotClass -> godotClass.parent }
        .filterIsInstance<ScriptClass>()
        .filter { scriptClass -> scriptClass.isRegistered }
        .toList()

fun ScriptClass.effectiveSignals(context: GeneratorContext): List<RegisteredSignal> =
    (signals + flattenedHierarchy(context).flatMap { family -> family.signals })
        .distinctBy { signal -> signal.name }

fun ScriptClass.effectiveProperties(context: GeneratorContext): List<RegisteredProperty> =
    (properties + flattenedHierarchy(context).flatMap { family -> family.properties })
        .distinctBy { property -> property.name }

fun ScriptClass.effectiveFunctions(context: GeneratorContext): List<RegisteredFunction> =
    (functions + flattenedHierarchy(context).flatMap { family -> family.functions })
        .distinctBy { function -> function.signatureKey }

fun ScriptClass.effectiveNotifications(context: GeneratorContext): List<String> =
    (functions + flattenedHierarchy(context).flatMap { family -> family.functions })
        .mapNotNull { function ->
            function.notification?.let { notification ->
                "${function.fqName.substringAfterLast(".").trim().convertToSnakeCase()}:$notification"
            }
        }

private val RegisteredFunction.signatureKey: String
    get() = "$name(${parameters.joinToString(",") { parameter -> parameter.type.fqName }})"
