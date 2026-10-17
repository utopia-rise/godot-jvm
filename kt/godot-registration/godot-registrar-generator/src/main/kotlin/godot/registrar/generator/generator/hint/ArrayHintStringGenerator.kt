package godot.registrar.generator.generator.hint

import com.squareup.kotlinpoet.CodeBlock
import godot.core.VariantParser
import godot.registrar.generator.ext.asEnumName
import godot.registrar.generator.ext.getAsVariantTypeOrdinal
import godot.registration.model.RegisteredProperty
import godot.core.PropertyHint as GodotPropertyHint

internal class ArrayHintStringGenerator(
    private val element: HintGenerator?,
    private val prefix: String = "",
    private val isUntyped: Boolean = false,
) : HintGenerator {
    constructor(
        registeredProperty: RegisteredProperty,
        element: HintGenerator?,
    ) : this(
        element = element,
        prefix = propertyPrefix(registeredProperty),
        isUntyped = isUntypedProperty(registeredProperty),
    )

    override fun generate(): GeneratedPropertyHint {
        if (isUntyped) {
            return GeneratedPropertyHint(GodotPropertyHint.TYPE_STRING, "")
        }
        val pieces = listOf(CodeBlock.of("%S", prefix)) + element?.generate()?.hintPieces.orEmpty()
        return GeneratedPropertyHint(GodotPropertyHint.TYPE_STRING.asEnumName(), pieces)
    }

    companion object {
        private fun propertyPrefix(registeredProperty: RegisteredProperty): String {
            val elementType = registeredProperty.type.genericArguments.firstOrNull()
            if (elementType != null) {
                return ""
            }

            val compatibleListType = registeredProperty.type.getAsVariantTypeOrdinal()
            return if (compatibleListType != VariantParser.ARRAY.id) {
                ":$compatibleListType"
            } else {
                ""
            }
        }

        private fun isUntypedProperty(registeredProperty: RegisteredProperty): Boolean =
            registeredProperty.type.genericArguments.firstOrNull()?.fqName == Any::class.qualifiedName
    }
}
