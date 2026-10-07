package godot.codegen.models.enriched

import com.squareup.kotlinpoet.ClassName
import godot.codegen.models.Enum
import godot.codegen.models.traits.DocumentedGenerationTrait
import godot.codegen.models.traits.Nature
import godot.codegen.models.traits.TypeGenerationTrait
import godot.codegen.workarounds.sanitizeApiType
import godot.common.extensions.isValidKotlinIdentifier
import godot.common.extensions.removePrefixWords
import godot.common.extensions.removeSuffixWords
import godot.common.extensions.removeWords
import godot.common.extensions.toUpperSnakeCase
import godot.tools.common.constants.godotApiPackage
import godot.tools.common.constants.godotCorePackage

enum class EnumScope {
    GLOBAL,
    BUILTIN,
    CLASS
}

class EnrichedEnum(model: Enum, val scope: EnumScope, owner: String? = null) : TypeGenerationTrait {
    val simpleName = model.name.sanitizeApiType()
    private val path = listOfNotNull(owner, simpleName)

    override val identifier = path.joinToString(".")
    override val nature = if (model.isBitField) Nature.BITFIELD else Nature.ENUM
    override val className = ClassName(if (scope == EnumScope.CLASS) godotApiPackage else godotCorePackage, path)

    val values = model.values.map {
        EnrichedEnumValue(
            it.name,
            simpleName,
            it.value,
            it.description ?: ""
        )
    }
}

class EnrichedEnumValue(valueName: String, ownerName: String, val value: Long, override var description: String?) : DocumentedGenerationTrait {
    val name = run {
        val uppercaseName = ownerName.toUpperSnakeCase()
        val prefixRemoved = valueName
            .removePrefixWords(uppercaseName)
            .removePrefix("_")
            .takeIf { it.isValidKotlinIdentifier() }
            ?: valueName

        val suffixRemoved = prefixRemoved
            .removeSuffixWords(uppercaseName)
            .removePrefix("_")
            .takeIf { it.isValidKotlinIdentifier() }
            ?: prefixRemoved

        suffixRemoved
            .removeWords(uppercaseName)
            .takeIf { it.isValidKotlinIdentifier() }
            ?: suffixRemoved
    }
}

fun List<Enum>.toEnriched(scope: EnumScope, owner: String? = null) = map { EnrichedEnum(it, scope, owner) }
