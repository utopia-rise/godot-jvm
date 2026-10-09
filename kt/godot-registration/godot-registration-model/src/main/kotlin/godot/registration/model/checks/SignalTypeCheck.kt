package godot.registration.model.checks

import godot.core.Signal
import godot.registration.model.ext.isMappableArgument
import godot.registration.model.ext.unrepresentableGenericArgument
import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

class SignalTypeCheck(logger: Logger, registeredClasses: List<ScriptClass>) : BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        var hasIssue = false
        registeredClasses
            .flatMap { scriptClass -> scriptClass.signals }
            .forEach { registeredSignal ->
                if (!registeredSignal.type.fqName.startsWith(Signal::class.qualifiedName!!)) {
                    hasIssue = true
                    logger.error(
                        "RegisteredSignal is not of type godot.signals.Signal! Resolved type: ${registeredSignal.type.fqName}",
                        registeredSignal
                    )
                    return@forEach
                }

                registeredSignal.parameterTypes.forEachIndexed { index, parameterType ->
                    val parameterName = registeredSignal.parameterNames.getOrNull(index) ?: "p$index"
                    if (!parameterType.isMappableArgument()) {
                        hasIssue = true
                        logger.error(
                            "Argument $parameterName of registered signal ${registeredSignal.name} is of type " +
                                "${parameterType.fqName}, which Godot cannot represent. A signal argument can only " +
                                "be Any, a primitive, a core type, a Godot class, an enum or a bitfield.",
                            registeredSignal
                        )
                    } else {
                        parameterType.unrepresentableGenericArgument()?.let { nested ->
                            hasIssue = true
                            logger.error(
                                "Argument $parameterName of registered signal ${registeredSignal.name} is of type " +
                                    "${parameterType.fqName} with element type ${nested.fqName}, which Godot " +
                                    "cannot represent.",
                                registeredSignal
                            )
                        }
                    }
                }
            }
        return hasIssue
    }
}
