package godot.codegen.models.enriched

import com.squareup.kotlinpoet.TypeName
import godot.codegen.exceptions.TooManySignalArgument
import godot.codegen.models.Signal
import godot.codegen.models.traits.DocumentedGenerationTrait
import godot.codegen.models.traits.GenerationType
import godot.codegen.models.traits.HasTypeGenerationTrait
import godot.codegen.models.traits.from
import godot.codegen.workarounds.sanitizeApiType
import godot.common.constants.Constraints
import godot.common.extensions.convertToCamelCase

class EnrichedSignal(model: Signal) : HasTypeGenerationTrait, DocumentedGenerationTrait {
    override val type = GenerationType("Signal${model.arguments?.size ?: 0}")
    var argumentTypes = model.arguments?.map { GenerationType(it.type.sanitizeApiType()) } ?: listOf()
    override val genericParameters
        get() = argumentTypes.map { TypeName.from(it) }
    override var description = model.description

    val name = model.name.convertToCamelCase()

    init {
        if ((model.arguments?.size ?: 0) > Constraints.MAX_SIGNAL_ARG_COUNT) {
            throw TooManySignalArgument(model)
        }
    }
}

fun List<Signal>.toEnriched() = map { EnrichedSignal(it) }
