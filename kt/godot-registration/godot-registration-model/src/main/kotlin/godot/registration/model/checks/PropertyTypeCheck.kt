package godot.registration.model.checks

import godot.registration.model.ext.isMappableProperty
import godot.registration.model.ext.unrepresentableGenericArgument
import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

class PropertyTypeCheck(logger: Logger, registeredClasses: List<ScriptClass>) : BaseCheck(logger, registeredClasses) {
    override fun execute(): Boolean {
        var hasIssue = false
        registeredClasses
            .flatMap { it.properties }
            .forEach { exportedProperty ->
                val type = exportedProperty.type

                if (!type.isMappableProperty()) {
                    hasIssue = true
                    logger.error(
                        "Registered property can only be Any, a primitive, a core type, a node, a resource, an " +
                            "enum, a bitfield or a List of enums",
                        exportedProperty
                    )
                } else if (type.unrepresentableGenericArgument() != null) {
                    hasIssue = true
                    logger.error(
                        "Registered property is of type ${type.fqName} with element type " +
                            "${type.unrepresentableGenericArgument()?.fqName}, which Godot cannot represent",
                        exportedProperty
                    )
                }
            }
        return hasIssue
    }
}
