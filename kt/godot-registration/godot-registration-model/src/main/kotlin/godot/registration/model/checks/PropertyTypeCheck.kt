package godot.registration.model.checks

import godot.registration.model.ext.isBitField
import godot.registration.model.ext.isEnum
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
                            "enum, a bitfield or a collection of enums",
                        exportedProperty
                    )
                } else if (type.unrepresentableGenericArgument() != null) {
                    hasIssue = true
                    logger.error(
                        "Registered property is of type ${type.fqName} with element type " +
                            "${type.unrepresentableGenericArgument()?.fqName}, which Godot cannot represent",
                        exportedProperty
                    )
                } else if (type.isBitField() && type.genericArguments.firstOrNull()?.isEnum() != true) {
                    hasIssue = true
                    logger.error(
                        "A bitfield property must be a BitField<E> where E is an enum. " +
                            "Engine bitfields cannot be exported directly; wrap your enum in BitField<…>.",
                        exportedProperty
                    )
                }
            }
        return hasIssue
    }
}
