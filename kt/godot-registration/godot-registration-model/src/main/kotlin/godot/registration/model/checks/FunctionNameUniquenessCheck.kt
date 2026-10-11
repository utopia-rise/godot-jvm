package godot.registration.model.checks

import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

class FunctionNameUniquenessCheck(logger: Logger, registeredClasses: List<ScriptClass>) : BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        var hasIssue = false
        registeredClasses.forEach { scriptClass ->
            scriptClass.functions
                .groupBy { function -> function.name }
                .values
                .filter { overloads -> overloads.size > 1 }
                .forEach { overloads ->
                    hasIssue = true
                    logger.error(
                        "Function ${overloads.first().fqName} is registered with several overloads. Godot calls a function by its name.",
                        overloads.first()
                    )
                }
        }
        return hasIssue
    }
}
