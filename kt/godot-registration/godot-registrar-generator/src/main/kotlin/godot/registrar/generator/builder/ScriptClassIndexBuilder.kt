package godot.registrar.generator.builder

import godot.registrar.generator.Settings
import godot.registrar.generator.ext.baseGodotClassName
import godot.registrar.generator.ext.getRegisteredName
import godot.registrar.generator.ext.registeredSupertypes
import godot.registration.model.types.ScriptClass
import java.io.File

/**
 * Writes the registered name and the global class base of every registered class, keyed by fully qualified name. The
 * base is the nearest registered parent, otherwise the Godot base class, as in Godot's global class cache.
 */
class ScriptClassIndexBuilder(
    private val settings: Settings,
    private val outputFile: File,
) {
    fun generate(registeredClasses: List<ScriptClass>) {
        // Registered names, fully qualified names and Godot class names are identifiers, so nothing needs escaping.
        val entries = registeredClasses
            .sortedBy { registeredClass -> registeredClass.fqName }
            .joinToString(",\n") { registeredClass ->
                val base = registeredClass.registeredSupertypes().firstOrNull()?.getRegisteredName(settings)
                    ?: registeredClass.baseGodotClassName()
                """    "${registeredClass.fqName}": {"name": "${registeredClass.getRegisteredName(settings)}", "base": "$base"}"""
            }
        outputFile.parentFile?.mkdirs()
        outputFile.writeText("{\n$entries\n}\n")
    }
}
