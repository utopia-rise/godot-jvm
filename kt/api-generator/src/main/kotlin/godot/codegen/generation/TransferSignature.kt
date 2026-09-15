package godot.codegen.generation

import com.squareup.kotlinpoet.MemberName

/**
 * The argument shape of an engine method as seen by the shared buffer: one converter per fixed argument, plus whether
 * a variadic `Any?` tail follows. Every distinct shape gets one generated writer, named after the converters so that
 * overload resolution never has to disambiguate `Any?` from a concrete type.
 */
data class TransferSignature(val converters: List<MemberName>, val isVararg: Boolean) {
    val writerName = buildString {
        append("writeMethodArguments")
        if (converters.isEmpty() && !isVararg) append("0")
        for (converter in converters) append('_').append(converter.simpleName.removePrefix("_"))
        if (isVararg) append("_VARARG")
    }

    companion object {
        fun readerName(converter: MemberName) = "readReturnValue_" + converter.simpleName.removePrefix("_")
    }
}
