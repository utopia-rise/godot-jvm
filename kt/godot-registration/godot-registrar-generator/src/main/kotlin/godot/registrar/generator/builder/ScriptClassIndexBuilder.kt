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
    fun generate(registeredClasses: List<ScriptClass>, sourceHashes: Map<String, String>) {
        // Registered names, fully qualified names and Godot class names are identifiers, so nothing needs escaping.
        val classes = registeredClasses
            .sortedBy { registeredClass -> registeredClass.fqName }
            .joinToString(",\n") { registeredClass ->
                val base = registeredClass.registeredSupertypes().firstOrNull()?.getRegisteredName(settings)
                    ?: registeredClass.baseGodotClassName()
                """        "${registeredClass.fqName}": {"name": "${registeredClass.getRegisteredName(settings)}", "base": "$base"}"""
            }
        val sources = sourceHashes.toSortedMap().entries.joinToString(",\n") { (path, hash) ->
            """        "${path.replace("\\", "\\\\").replace("\"", "\\\"")}": "$hash""""
        }
        outputFile.parentFile?.mkdirs()
        outputFile.writeText("{\n    \"classes\": {\n$classes\n    },\n    \"sources\": {\n$sources\n    }\n}\n")
    }
}
