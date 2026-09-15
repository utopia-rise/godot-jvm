package godot.codegen.generation

import com.squareup.kotlinpoet.MemberName
import godot.codegen.constants.TypeIdentifier
import godot.codegen.exceptions.NoMatchingEnumFound
import godot.codegen.models.ApiDescription
import godot.codegen.models.enriched.EnrichedClass
import godot.codegen.models.enriched.EnrichedEnum
import godot.codegen.models.enriched.EnrichedNativeStructure
import godot.codegen.models.traits.GenerationType

class GenerationContext(
    val api: ApiDescription,
) {
    private var nextEngineClassIndex = 0
    private var nextSingletonIndex = 0

    val coreTypeMap = mutableMapOf<String, List<EnrichedEnum>>()
    val nativeStructureMap = HashMap<String, EnrichedNativeStructure>()

    val globalEnumMap = mutableMapOf<String, EnrichedEnum>()
    val globalEnumList = mutableListOf<EnrichedEnum>()
    val classMap = mutableMapOf<String, EnrichedClass>()
    val classList = mutableListOf<EnrichedClass>()

    val methodSignatures = LinkedHashSet<TransferSignature>()
    val returnConverters = LinkedHashSet<MemberName>()


    fun getNextEngineClassIndex() = nextEngineClassIndex++
    fun getNextSingletonIndex(): Int {
        nextEngineClassIndex++
        return nextSingletonIndex++
    }

    fun generateEnumDefaultValue(type: GenerationType, value: Long): String {
        val simpleNames = type.className.simpleNames
        val className: String
        val enrichedEnum = if (simpleNames.size > 1) {
            className = simpleNames[0]
            if (TypeIdentifier.core.contains(className)) {
                coreTypeMap[className] ?: listOf()
            } else {
                classMap[className]!!.enums
            }.firstOrNull {
                it.identifier == type.identifier
            } ?: throw NoMatchingEnumFound(type.identifier)
        } else {
            globalEnumMap[type.identifier]!!
        }

        val enumValue = enrichedEnum.values.firstOrNull { it.value == value }
        return if (enumValue != null) {
            enrichedEnum.identifier + "." + enumValue.name
        } else {
            enrichedEnum.identifier + "(" + value + ")"
        }
    }
}
