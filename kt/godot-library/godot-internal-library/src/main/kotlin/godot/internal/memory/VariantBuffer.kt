package godot.internal.memory

import godot.common.constants.Constraints
import godot.common.interop.VariantConverter
import godot.common.interop.VoidPtr
import kotlincompile.definitions.GodotJvmBuildConfig
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * The buffer every exchange but a ptrcall goes through: bridges, checked engine calls, and calls from the engine into
 * JVM code.
 *
 * This object is the side that knows about threads, and the JNI surface C++ binds to: it asks for [buffer] once per
 * thread and lays its own cursor over the same memory. [Transfer] is the side that holds the bytes and knows nothing
 * about either, mirroring `VariantBuffer::Transfer` on the native side.
 */
object VariantBuffer {
    private const val HEADER_SIZE = 24
    private const val VALUE_OVERHEAD = 24
    private const val LARGEST_INLINE_VALUE = 80

    private val threadTransfer = ThreadLocal.withInitial { Transfer() }

    /** The calling thread's transfer, which is what every exchange is made through. */
    val transfer: Transfer
        get() = threadTransfer.get()

    /** Where this thread's exchange lives. Asked for by the native side, once per thread; nothing else needs it. */
    val buffer: ByteBuffer
        get() = transfer.buffer

    /**
     * The one exchange the buffer holds. Every exchange starts by rewinding, because the buffer holds one call at a
     * time and both sides copy its values out before anything else can use it.
     *
     * It is sized for [Constraints.MAX_FUNCTION_ARG_COUNT] values of the largest kind, a String at
     * [LongStringQueue.stringMaxSize], behind a caller pointer, its ObjectID and the argument count.
     */
    class Transfer internal constructor() {
        @PublishedApi
        internal val buffer: ByteBuffer = run {
            val perValue = (LongStringQueue.stringMaxSize + VALUE_OVERHEAD).coerceAtLeast(LARGEST_INLINE_VALUE)
            val size = (perValue * Constraints.MAX_FUNCTION_ARG_COUNT + HEADER_SIZE + 7) and 7.inv()
            ByteBuffer.allocateDirect(size).order(ByteOrder.LITTLE_ENDIAN)
        }

        inline fun writeArgs(argumentCount: Int, write: ByteBuffer.() -> Unit) {
            val buffer = buffer
            buffer.rewind()
            buffer.putInt(argumentCount)
            buffer.write()
        }

        inline fun <T> callBridge(argumentCount: Int, returns: VariantConverter<T>, call: ByteBuffer.() -> Unit): T {
            val buffer = buffer
            buffer.rewind()
            buffer.putInt(argumentCount)
            buffer.call()
            return returns.toKotlin(buffer.rewind())
        }

        inline fun <T> callBridge(returns: VariantConverter<T>, call: () -> Unit): T {
            val buffer = buffer
            call()
            return returns.toKotlin(buffer.rewind())
        }

        fun open(callerPtr: VoidPtr, callerId: Long, argumentCount: Int): ByteBuffer = buffer.also {
            it.rewind()
            it.putLong(callerPtr)
            it.putLong(callerId)
            it.putInt(argumentCount)
        }

        fun readSetterArg(variantConverter: VariantConverter<*>) = buffer.let {
            it.rewind()
            val argsSize = it.getInt()
            if (GodotJvmBuildConfig.DEBUG) {
                require(argsSize == 1) {
                    "Expecting 1 parameter, but got $argsSize instead."
                }
            }
            variantConverter.toKotlin(it)
        }

        fun readArgs(variantConverters: Array<out VariantConverter<*>>, returnArray: Array<Any?>) = buffer.let {
            it.rewind()
            val argsSize = it.getInt()
            if (GodotJvmBuildConfig.DEBUG) {
                val argumentCount = variantConverters.size
                require(argsSize == argumentCount) {
                    "Expecting $argumentCount parameter(s), but got $argsSize instead."
                }
            }
            for (i in 0 until argsSize) {
                returnArray[i] = variantConverters[i].toKotlin(it)
            }
        }

        fun writeRet(value: Any?, type: VariantConverter<*>) = buffer.let {
            it.rewind()
            type.toGodot(it, value)
        }

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
    }
}
