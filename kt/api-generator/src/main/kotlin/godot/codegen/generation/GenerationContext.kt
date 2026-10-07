package godot.codegen.generation

import com.squareup.kotlinpoet.MemberName
import godot.codegen.constants.API
import godot.codegen.constants.VariantConverter
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

    val nativeStructureMap = HashMap<String, EnrichedNativeStructure>()

    val enumMap = mutableMapOf<String, EnrichedEnum>()
    val globalEnums = mutableListOf<EnrichedEnum>()
    val classMap = mutableMapOf<String, EnrichedClass>()
    val classList = mutableListOf<EnrichedClass>()

    val methodSignatures = LinkedHashSet<TransferSignature>()

    /**
     * Variant::TYPE_MAX, one past the last Variant ordinal and so never a real type tag. A ptrcall announces it in
     * place of the OBJECT ordinal when the method returns a Ref<T>, mirroring REF_COUNTED_RETURN in cpp/jvm/memory/variant_type.h
     * on the native side, which is defined as VARIANT_MAX too. Taken from api.json so both sides move together.
     */
    val refCountedReturnType: Int = api.globalEnums
        .first { it.name == "Variant.Type" }.values
        .first { it.name == "TYPE_MAX" }.value.toInt()
        .also {
            require(it == VariantConverter.variantOrdinalCount) {
                "api.json declares $it Variant types but the generator knows ${VariantConverter.variantOrdinalCount}"
            }
        }


    fun isRefCounted(className: String): Boolean {
        var clazz = classMap[className]
        while (clazz != null) {
            if (clazz.identifier == API.refCounted.simpleName) return true
            clazz = clazz.parent
        }
        return false
    }

    fun getNextEngineClassIndex() = nextEngineClassIndex++
    fun getNextSingletonIndex(): Int {
        nextEngineClassIndex++
        return nextSingletonIndex++
    }

    fun generateEnumDefaultValue(type: GenerationType, value: Long): String {
        val enrichedEnum = enumMap[type.identifier] ?: throw NoMatchingEnumFound(type.identifier)

        val enumValue = enrichedEnum.values.firstOrNull { it.value == value }
        return if (enumValue != null) {
            enrichedEnum.identifier + "." + enumValue.name
        } else {
            enrichedEnum.identifier + "(" + value + ")"
        }
    }
}
