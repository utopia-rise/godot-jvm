package godot.codegen.models.enriched


import com.squareup.kotlinpoet.ClassName
import godot.codegen.models.Argument
import godot.codegen.models.traits.GenerationType
import godot.codegen.models.traits.MetaGenerationTrait
import godot.codegen.models.traits.WithDefaultValueTrait
import godot.codegen.workarounds.sanitizeApiType
import godot.common.extensions.convertToCamelCase
import godot.common.extensions.escapeKotlinReservedNames

class EnrichedArgument(model: Argument) : MetaGenerationTrait, WithDefaultValueTrait {
    val name = model.name.convertToCamelCase().escapeKotlinReservedNames()
    override var type = GenerationType(model.type.sanitizeApiType())
    override val genericParameters = emptyList<ClassName>()
    override val defaultValue = model.defaultValue
    override val meta: String? = model.meta

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is EnrichedArgument) return false
        return name == other.name && type == other.type && meta == other.meta
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + (meta?.hashCode() ?: 0)
        return result
    }
}

fun List<Argument>.toEnriched() = map { EnrichedArgument(it) }
fun Argument.toEnriched() = EnrichedArgument(this)
