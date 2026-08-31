package godot.registration.model.checks

import godot.registration.model.ext.signatureTypes
import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass
import godot.registration.model.types.Type
import godot.registration.model.types.TypeKind

class SourceClassCheck(logger: Logger, registeredClasses: List<ScriptClass>) : BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        var hasIssue = false

        registeredClasses.forEach { scriptClass ->
            scriptClass.constructors.forEach { constructor ->
                if (reportUnrepresentable(constructor.parameterTypes, constructor, "constructor parameter")) {
                    hasIssue = true
                }
            }

            scriptClass.signals.forEach { signal ->
                if (reportUnrepresentable(signal.parameterTypes, signal, "signal parameter")) {
                    hasIssue = true
                }
            }
        }

        return hasIssue
    }

    private fun reportUnrepresentable(types: List<Type>, owner: Any, usage: String): Boolean {
        var hasIssue = false
        types
            .flatMap(Type::signatureTypes)
            .filter { type -> type.kind == TypeKind.OTHER }
            .distinctBy(Type::fqName)
            .forEach { type ->
                hasIssue = true
                logger.error(
                    "Registered $usage cannot use unrelated JVM type ${type.fqName}. " +
                        "Only Godot-compatible types can appear in registered signatures.",
                    owner
                )
            }
        return hasIssue
    }
}
