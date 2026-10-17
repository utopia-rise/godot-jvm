package godot.registrar.generator.generator.hint

import com.squareup.kotlinpoet.CodeBlock
import godot.registrar.generator.ext.asEnumName
import godot.registration.model.RegisteredProperty
import godot.core.PropertyHint as GodotPropertyHint

internal class DictionaryHintStringGenerator(
    private val key: HintGenerator?,
    private val value: HintGenerator?,
    private val isUntyped: Boolean = false,
) : HintGenerator {
    constructor(
        registeredProperty: RegisteredProperty,
        key: HintGenerator?,
        value: HintGenerator?,
    ) : this(
        key = key,
        value = value,
        isUntyped = registeredProperty.type.genericArguments.firstOrNull()?.fqName == Any::class.qualifiedName,
    )

    override fun generate(): GeneratedPropertyHint {
        if (isUntyped) {
            return GeneratedPropertyHint(GodotPropertyHint.TYPE_STRING, "")
        }
        val pieces = listOfNotNull(key, value)
            .map { element -> element.generate().hintPieces }
            .reduceOrNull { joined, element -> joined + CodeBlock.of("%S", ";") + element }
            .orEmpty()
        return GeneratedPropertyHint(GodotPropertyHint.TYPE_STRING.asEnumName(), pieces)
    }
}
