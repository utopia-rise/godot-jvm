@file:Suppress("UNCHECKED_CAST", "PackageDirectoryMismatch", "unused")

package godot.core

import godot.common.interop.ObjectID
import godot.common.interop.VariantConverter
import godot.core.Callable.Bridge
import godot.internal.logging.GodotLogging
import godot.internal.memory.ParametersReader
import godot.internal.memory.TransferContext

open class LambdaCallable<R> internal constructor(
    protected val container: LambdaContainer<R>,
    protected var boundArgs: Array<out Any?> = emptyArray()
) : Callable {

    override fun getBoundArguments() = boundArgs.toList()
    override fun getBoundArgumentCount() = boundArgs.size
    override fun getMethod() = StringName()
    override fun getObject() = null
    override fun getObjectId() = ObjectID(0)
    override fun isCustom() = true
    override fun isNull() = false
    override fun isStandard() = false
    override fun isValid() = true
    override fun rpc(vararg args: Any?) = throw UnsupportedOperationException("Can't make a RPC call from a LambdaCallable")
    override fun rpcId(peerId: Long, vararg args: Any?) = throw UnsupportedOperationException("Can't make a RPC call from a LambdaCallable")
    override fun unbind(argCount: Int) = toNativeCallable().unbind(argCount)
    override fun bindUnsafe(vararg args: Any?) = LambdaCallable<R>(container, arrayOf<Any?>(*args, *boundArgs))
    override fun callUnsafe(vararg args: Any?) = container.invokeUnsafe(*args, *boundArgs)
    override fun callDeferredUnsafe(vararg args: Any?) {
        val ptr = Bridge.engine_call_constructor_lambda_callable(container, container.returnConverter.id, hashCode())
        // We could use the [toVariantCallable] function, but we want to avoid 1 additional JNI calls in case we have bound arguments.
        VariantCallable(ptr).callDeferredUnsafe(*args, *boundArgs)
    }

    /**
     * Get rid of the lambda contained in this Callable, this instance won't be usable anymore after calling it.
     * Custom Callable can create reference cycles between Godot and the JVM which can make part of your objects unable to be freed by the Garbage Collector.
     * This method is a last resort that can allow you to break a cycle caused by the Callable keeping its captured instance alive when itself is kept alive by the C++ side.
     */
    fun invalidate() = container.invalidate()
    override fun toNativeCallable(): VariantCallable {
        // We pass all params using jni as we're often in a context of sending parameters to cpp, so we should not rewind buffer.
        val ptr = Bridge.engine_call_constructor_lambda_callable(container, container.returnConverter.id, hashCode())
        val unbound = VariantCallable(ptr)
        if (boundArgs.isNotEmpty()) {
            return unbound.bindUnsafe(*boundArgs)
        }
        return unbound
    }
}

abstract class LambdaContainer<R>(
    val returnConverter: VariantConverter<*>,
    val typeConverters: Array<out VariantConverter<*>>,
    var function: Function<R>?
) {
    var cancelFunction: (() -> Unit)? = null
    fun cancel() {
        cancelFunction?.invoke()
    }

    fun setAsCancellable(signal: Signal, block: () -> Unit) {
        cancelFunction = block
        TransferContext.writeArguments(VariantParser.SIGNAL to signal)
        Bridge.engine_call_constructor_cancellable(this, this.returnConverter.id, hashCode())
    }

    abstract fun invokeUnsafe(vararg args: Any?): R

    fun invoke() = withParameters(typeConverters) {
        try {
            invokeUnsafe(*paramsArray)
        } catch (t: Throwable) {
            GodotLogging.error("Error calling a JVM custom Callable from Godot:\n" + t.stackTraceToString())
        }
    }

    fun invokeWithReturn(): Any? = withParametersReturn(typeConverters) {
        val ret: Any? = null
        try {
            val ret = invokeUnsafe(*paramsArray)
            TransferContext.writeReturnValue(ret, returnConverter)
        } catch (t: Throwable) {
            GodotLogging.error("Error calling a JVM custom Callable from Godot:\n" + t.stackTraceToString())
            TransferContext.writeReturnValue(null, VariantParser.NIL)
        }
        ret
    }

    fun invalidate(): Unit {
        function = null
    }

    internal companion object : ParametersReader()
}

class InvalidJvmLambdaException : Exception("This LambdaCallable has been invalidated, it shouldn't be called. Make sure to disconnect it from any signals")
