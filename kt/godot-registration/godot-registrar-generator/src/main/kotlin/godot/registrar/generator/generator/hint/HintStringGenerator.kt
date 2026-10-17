package godot.registrar.generator.generator.hint

import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.joinToCode
import godot.core.PropertyHint
import godot.registrar.generator.ext.asEnumName

/**
 * A hint string is kept as pieces until it is written: most are literals, but an enum's entries are only known at
 * runtime, so a container holding one concatenates its pieces into a `+` chain. Adjacent literals fold into one.
 */
data class GeneratedPropertyHint(
    val typeHint: MemberName,
    val hintPieces: List<CodeBlock>,
) {
    constructor(typeHint: PropertyHint, hintString: String) : this(typeHint.asEnumName(), listOf(CodeBlock.of("%S", hintString)))

    constructor(typeHint: PropertyHint, hintString: CodeBlock) : this(typeHint.asEnumName(), listOf(hintString))

    val hintString: CodeBlock
        get() {
            val merged = mutableListOf<CodeBlock>()
            for (piece in hintPieces.filterNot { it.isStringLiteral() && it.toString() == "\"\"" }) {
                val last = merged.lastOrNull()
                if (last != null && last.isStringLiteral() && piece.isStringLiteral()) {
                    val text = last.toString().removeSurrounding("\"") + piece.toString().removeSurrounding("\"")
                    merged[merged.lastIndex] = CodeBlock.of("%S", text)
                } else {
                    merged += piece
                }
            }
            return merged.ifEmpty { listOf(CodeBlock.of("%S", "")) }.joinToCode(" + ")
        }

    private fun CodeBlock.isStringLiteral(): Boolean = toString().let { code ->
        code.length >= 2 && code.first() == '"' && code.last() == '"' && code.count { it == '"' } == 2
    }
}

internal interface HintGenerator {
    fun generate(): GeneratedPropertyHint
}
