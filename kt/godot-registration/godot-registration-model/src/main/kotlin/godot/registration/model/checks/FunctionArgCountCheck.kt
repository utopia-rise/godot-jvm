package godot.registration.model.checks

import godot.common.constants.Constraints
import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

class FunctionArgCountCheck(logger: Logger, registeredClasses: List<ScriptClass>) :
    BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        var hasIssues = false
        registeredClasses
            .flatMap { it.functions }
            .forEach { registeredFunction ->
                if (registeredFunction.parameters.size > Constraints.MAX_ARGUMENT_COUNT) {
                    logger.error(
                        "RegisteredFunction ${registeredFunction.fqName} has more than ${Constraints.MAX_ARGUMENT_COUNT} arguments. More than that is currently not supported. If you need more, either wrap them in a wrapper object or pass a VariantArray containing your values.",
                        registeredFunction
                    )
                    hasIssues = true
                }
            }

        return hasIssues
    }
}
