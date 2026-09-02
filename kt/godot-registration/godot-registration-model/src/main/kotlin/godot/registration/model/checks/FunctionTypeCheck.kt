package godot.registration.model.checks

import godot.registration.model.ext.isMappableArgument
import godot.registration.model.ext.isMappableReturnType
import godot.registration.model.ext.unrepresentableGenericArgument
import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

class FunctionTypeCheck(logger: Logger, registeredClasses: List<ScriptClass>) :
    BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        var hasIssue = false
        registeredClasses
            .flatMap { scriptClass -> scriptClass.functions }
            .forEach { registeredFunction ->
                val returnType = registeredFunction.returnType
                if (!returnType.isMappableReturnType()) {
                    hasIssue = true
                    logger.error(
                        "Registered function ${registeredFunction.fqName} returns ${returnType.fqName}, which Godot " +
                            "cannot represent. A registered function can only return Unit, Any, a primitive, a core " +
                            "type, a Godot class, an enum or a bitfield. If you do not need the value on the Godot " +
                            "side, declare the function as returning Unit.",
                        registeredFunction
                    )
                } else {
                    returnType.unrepresentableGenericArgument()?.let { nested ->
                        hasIssue = true
                        logger.error(
                            "Registered function ${registeredFunction.fqName} returns ${returnType.fqName} with " +
                                "element type ${nested.fqName}, which Godot cannot represent.",
                            registeredFunction
                        )
                    }
                }

                registeredFunction.parameters.forEach { parameter ->
                    if (!parameter.type.isMappableArgument()) {
                        hasIssue = true
                        logger.error(
                            "Parameter ${parameter.name} of registered function ${registeredFunction.fqName} is of " +
                                "type ${parameter.type.fqName}, which Godot cannot represent. A registered function " +
                                "parameter can only be Any, a primitive, a core type, a Godot class, an enum or a " +
                                "bitfield. A collection of enums is only supported on a property.",
                            registeredFunction
                        )
                    } else {
                        parameter.type.unrepresentableGenericArgument()?.let { nested ->
                            hasIssue = true
                            logger.error(
                                "Parameter ${parameter.name} of registered function ${registeredFunction.fqName} is " +
                                    "of type ${parameter.type.fqName} with element type ${nested.fqName}, which " +
                                    "Godot cannot represent.",
                                registeredFunction
                            )
                        }
                    }
                }
            }
        return hasIssue
    }
}
