package godot.registrar.generator.generator.hint

import com.squareup.kotlinpoet.CodeBlock
import godot.core.PropertyHint as GodotPropertyHint

internal class StaticHintGenerator(
    private val typeHint: GodotPropertyHint,
    private val hintString: CodeBlock,
) : HintGenerator {
    constructor(typeHint: GodotPropertyHint, hintString: String) : this(typeHint, CodeBlock.of("%S", hintString))

    override fun generate(): GeneratedPropertyHint = GeneratedPropertyHint(typeHint, hintString)
}

internal class HintStringOverride(
    private val delegate: HintGenerator,
    private val hintString: String,
) : HintGenerator {
    override fun generate(): GeneratedPropertyHint = delegate.generate().copy(hintPieces = listOf(CodeBlock.of("%S", hintString)))
}
