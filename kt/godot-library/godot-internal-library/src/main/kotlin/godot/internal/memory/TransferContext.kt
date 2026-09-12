package godot.internal.memory

import godot.common.constants.Constraints
import godot.common.interop.VariantConverter
import godot.common.interop.VoidPtr
import godot.common.util.threadLocal
import kotlincompile.definitions.GodotJvmBuildConfig
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

object TransferContext {
    private val bufferSize: Int
        get() {
            /**
             * String is the largest type you can send in a buffer, so the buffer size has to be proportional to it.
             * We add +12 to the size because we need 3 extra integers (4 bytes each): The VariantType, the long/short check and the size
             * Finally we add another +4 because the buffer starts with the number of arguments sent.
             * Method calls additionally need +16 for the caller pointer and ObjectID.
             * In case, the size of the String become smaller than any other types, we force a value of at least 68 bytes.
             * 68 bytes is the size of the second largest CoreType: Projection (64 for the data, 4 for the VariantType)
             */
            return (LongStringQueue.stringMaxSize + 12).coerceAtLeast(68) * Constraints.MAX_FUNCTION_ARG_COUNT + 4 + 16
        }

    @PublishedApi
    internal val buffer by threadLocal<ByteBuffer> {
        val buf = ByteBuffer.allocateDirect(bufferSize)
        buf.order(ByteOrder.LITTLE_ENDIAN)
        buf
    }

    fun writeArguments(vararg values: Pair<VariantConverter<*>, Any?>) = buffer.let {
        it.rewind()
        it.putInt(values.size)
        for (value in values) {
            value.first.toGodot(it, value.second)
        }
    }

    fun writeMethodArguments(callerPtr: VoidPtr, callerId: Long, vararg values: Pair<VariantConverter<*>, Any?>) = buffer.let {
        it.rewind()
        it.putLong(callerPtr)
        it.putLong(callerId)
        it.putInt(values.size)
        for (value in values) {
            value.first.toGodot(it, value.second)
        }
    }

    fun readSetterArgument(variantConverter: VariantConverter<*>) = buffer.let {
        it.rewind()
        val argsSize = it.getInt()
        if (GodotJvmBuildConfig.DEBUG) {
            require(argsSize == 1) {
                "Expecting 1 parameter, but got $argsSize instead."
            }
        }
        variantConverter.toKotlin(it)
    }

    fun readArguments(variantConverters: Array<out VariantConverter<*>>, returnArray: Array<Any?>) = buffer.let {
        it.rewind()
        val argsSize = it.getInt()
        if (GodotJvmBuildConfig.DEBUG) {
            val argumentCount = variantConverters.size
            require(argsSize == argumentCount) {
                "Expecting $argumentCount parameter(s), but got $argsSize instead."
            }
        }
        // Assume that variantTypes and areNullable have the same size and that returnArray is big enough
        for (i in 0 until argsSize) {
            returnArray[i] = variantConverters[i].toKotlin(it)
        }
    }

    fun writeReturnValue(value: Any?, type: VariantConverter<*>) = buffer.let {
        it.rewind()
        type.toGodot(it, value)
    }

    fun readReturnValue(type: VariantConverter<*>) = buffer.let {
        it.rewind()
        type.toKotlin(it)
    }

    fun callMethod(methodPtr: VoidPtr) = icall(methodPtr)

    @ExperimentalContracts
    inline fun unsafeRead(block: (ByteBuffer) -> Unit) {
        contract {
            callsInPlace(block, InvocationKind.EXACTLY_ONCE)
        }
        buffer.let {
            it.rewind()
            block(it)
        }
    }

    private external fun icall(methodPtr: VoidPtr)
}
