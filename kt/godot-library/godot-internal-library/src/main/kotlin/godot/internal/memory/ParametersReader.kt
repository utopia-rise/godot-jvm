package godot.internal.memory

import godot.common.constants.Constraints
import godot.common.interop.VariantConverter
import godot.common.util.threadLocal

open class ParametersReader {
    val paramsArray by threadLocal {
        Array<Any?>(Constraints.MAX_FUNCTION_ARG_COUNT) {
            null
        }
    }

    inline fun withParameters(types: Array<out VariantConverter<*>>, code: () -> Unit) {
        TransferContext.readArguments(types, paramsArray)
        code()
        paramsArray.fill(null, 0, types.size)
    }

    inline fun <R> withParametersReturn(
        types: Array<out VariantConverter<*>>,
        code: () -> R
    ): Any? {
        TransferContext.readArguments(types, paramsArray)
        val ret = code()
        paramsArray.fill(null, 0, types.size)
        return ret
    }
}
