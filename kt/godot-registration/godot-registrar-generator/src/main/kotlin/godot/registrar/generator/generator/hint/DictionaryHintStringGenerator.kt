package godot.registrar.generator.generator.hint

import godot.registration.model.RegisteredProperty
import godot.core.PropertyHint as GodotPropertyHint

internal class DictionaryHintStringGenerator(
    private val keyHintString: String?,
    private val valueHintString: String?,
    private val isUntyped: Boolean = false,
) : HintGenerator {
    constructor(
        registeredProperty: RegisteredProperty,
        keyHintString: String?,
        valueHintString: String?,
    ) : this(
        keyHintString = keyHintString,
        valueHintString = valueHintString,
        isUntyped = registeredProperty.type.genericArguments.firstOrNull()?.fqName == Any::class.qualifiedName,
    )

    fun getHintString(): String {
        if (isUntyped) {
            return ""
        }

        val subHintString = listOfNotNull(
            keyHintString,
            valueHintString,
        ).joinToString(";")

        return subHintString
    }

    override fun generate(): GeneratedPropertyHint = GeneratedPropertyHint(GodotPropertyHint.TYPE_STRING, getHintString())
}
