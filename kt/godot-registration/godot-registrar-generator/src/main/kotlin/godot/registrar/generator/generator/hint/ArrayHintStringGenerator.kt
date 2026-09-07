package godot.registrar.generator.generator.hint

import godot.core.VariantParser
import godot.registrar.generator.ext.getAsVariantTypeOrdinal
import godot.registration.model.RegisteredProperty
import godot.core.PropertyHint as GodotPropertyHint

internal class ArrayHintStringGenerator(
    private val elementHintString: String?,
    private val prefix: String = "",
    private val isUntyped: Boolean = false,
) : HintGenerator {
    constructor(
        registeredProperty: RegisteredProperty,
        elementHintString: String?,
    ) : this(
        elementHintString = elementHintString,
        prefix = propertyPrefix(registeredProperty),
        isUntyped = isUntypedProperty(registeredProperty),
    )

    fun getHintString(): String = if (isUntyped) "" else "$prefix${elementHintString.orEmpty()}"

    override fun generate(): GeneratedPropertyHint = GeneratedPropertyHint(GodotPropertyHint.TYPE_STRING, getHintString())

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
