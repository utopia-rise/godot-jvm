package godot.registration.model.checks

import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

class RejectedDeclarationCheck(logger: Logger, registeredClasses: List<ScriptClass>) : BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        var hasIssue = false
        registeredClasses.forEach { scriptClass ->
            scriptClass.rejectedDeclarations.forEach { reason ->
                hasIssue = true
                logger.error(reason)
            }
        }
        return hasIssue
    }
}
