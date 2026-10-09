package godot.registration.model.checks

import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

class GenericClassCheck(logger: Logger, registeredClasses: List<ScriptClass>) : BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        val genericClasses = registeredClasses.filter(ScriptClass::isGeneric)
        genericClasses.forEach { scriptClass ->
            logger.error("Registered class ${scriptClass.fqName} cannot be generic.", scriptClass)
        }
        return genericClasses.isNotEmpty()
    }
}
