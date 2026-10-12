@file:Suppress("UNCHECKED_CAST")

package godot.registration

import godot.common.interop.VariantConverter
import godot.core.KtObject
import godot.core.VariantParser
import godot.internal.logging.GodotLogging
import godot.internal.memory.ParametersReader
import godot.internal.memory.VariantBuffer

data class KtFunctionInfo(
    val name: String,
    val _arguments: List<KtPropertyInfo>,
    val returnVal: KtPropertyInfo,
    val rpcConfig: KtRpcConfig
) {
    val arguments: Array<KtPropertyInfo>
        get() = _arguments.toTypedArray()
}

data class KtRpcConfig(
    val rpcModeId: Int,
    val rpcCallLocal: Boolean,
    val rpcTransferModeId: Int,
    val rpcChannel: Int
)

class KtFunction<T : KtObject, R : Any?>(
    val functionInfo: KtFunctionInfo,
    private val function: (T, Array<Any?>) -> R,
) {
    private val variantConverter: VariantConverter<*> = functionInfo.returnVal._type
    private val types: Array<VariantConverter<*>> = functionInfo.arguments.map { it._type }.toTypedArray()

    fun invoke(instance: T) {
        try {
            withParameters(types) { function(instance, paramsArray) }
        } catch (t: Throwable) {
            GodotLogging.error("Error calling JVM method ${functionInfo.name} of script $instance from Godot:\n" + t.stackTraceToString())
        }
    }

    fun invokeWithReturn(instance: T): Any? {
        var ret: Any? = Unit
        try {
            ret = withParametersReturn(types) { function(instance, paramsArray) }
            VariantBuffer.transfer.writeRet(ret, variantConverter)
        } catch (t: Throwable) {
            GodotLogging.error("Error calling JVM method ${functionInfo.name} of script $instance from Godot:\n" + t.stackTraceToString())
            VariantBuffer.transfer.writeRet(null, VariantParser.NIL)
        }
        return ret
    }

    internal companion object : ParametersReader()
}
