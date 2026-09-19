package godot.codegen.generation

import com.squareup.kotlinpoet.MemberName
import godot.codegen.constants.VariantConverter

data class TransferSignature(
    val converters: List<MemberName>,
    val isVararg: Boolean,
    val returnConverter: MemberName,
    val isRefCountedReturn: Boolean,
) {
    /** A ptrcall reads the arguments where the buffer holds them, so every type has to be in native layout there. */
    val isVariantCall: Boolean = isVararg
        || !VariantConverter.isPtrCallReturn(returnConverter)
        || converters.any { !VariantConverter.isPtrCallArgument(it) }

    val returnsValue: Boolean = returnConverter != VariantConverter.NIL

    val name: String = buildString {
        append(if (isVariantCall) "callMethod" else "callPtrMethod")
        if (converters.isEmpty() && !isVararg) append('0')
        for (converter in converters) append('_').append(converter.simpleName.removePrefix("_"))
        if (isVararg) append("_VARARG")
        if (returnsValue) {
            append("_ret_").append(returnConverter.simpleName.removePrefix("_"))
            if (isRefCountedReturn) append("_REF")
        }
    }
}
