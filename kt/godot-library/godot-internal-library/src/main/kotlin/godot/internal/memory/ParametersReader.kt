package godot.internal.memory

import godot.common.interop.VariantConverter

open class ParametersReader {
    val paramsArray: Array<Any?>
        get() = ThreadContext.paramsArray

    inline fun withParameters(types: Array<out VariantConverter<*>>, code: () -> Unit) {
        VariantBuffer.transfer.readArgs(types, paramsArray)
        code()
        paramsArray.fill(null, 0, types.size)
    }

    inline fun <R> withParametersReturn(
        types: Array<out VariantConverter<*>>,
        code: () -> R
    ): Any? {
        VariantBuffer.transfer.readArgs(types, paramsArray)
        val ret = code()
        paramsArray.fill(null, 0, types.size)
        return ret
    }
}
