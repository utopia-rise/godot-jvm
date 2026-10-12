package godot.registrar.generator

import godot.registration.model.logging.Logger
import godot.registration.model.types.ScriptClass

data class GeneratorContext(
    val settings: Settings,
    val logger: Logger,
    val registeredClassesByFqName: Map<String, ScriptClass>,
)
