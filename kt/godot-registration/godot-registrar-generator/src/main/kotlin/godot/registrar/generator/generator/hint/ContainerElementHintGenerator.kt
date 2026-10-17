package godot.registrar.generator.generator.hint

import com.squareup.kotlinpoet.CodeBlock
import godot.registrar.generator.ext.asEnumName
import godot.registrar.generator.ext.getAsVariantTypeOrdinal
import godot.registration.model.types.Type
import godot.core.PropertyHint as GodotPropertyHint

/** An element of a typed container: its own hint, written as `ordinal[/hint]:hintString` inside the container's. */
internal class ContainerElementHintGenerator(
    private val type: Type,
    private val element: HintGenerator,
) : HintGenerator {
    override fun generate(): GeneratedPropertyHint {
        val hint = element.generate()
        val prefix = if (hint.typeHint == GodotPropertyHint.NONE.asEnumName()) {
            "${type.getAsVariantTypeOrdinal()}:"
        } else {
            "${type.getAsVariantTypeOrdinal()}/${GodotPropertyHint.valueOf(hint.typeHint.simpleName).value}:"
        }
        return GeneratedPropertyHint(GodotPropertyHint.TYPE_STRING.asEnumName(), listOf(CodeBlock.of("%S", prefix)) + hint.hintPieces)
    }
}
