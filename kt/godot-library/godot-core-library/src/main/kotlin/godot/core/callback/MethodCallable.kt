@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.api.Object
import godot.core.Callable.Bridge
import godot.internal.memory.MemoryManager

open class MethodCallable internal constructor(
    protected val target: Object,
    protected val methodName: StringName,
    protected var boundArgs: Array<out Any?> = emptyArray()
) : Callable {

    constructor(target: Object, methodName: StringName) : this(target, methodName, emptyArray())

    override fun getBoundArguments() = boundArgs.toList()
    override fun getBoundArgumentCount() = boundArgs.size
    override fun getMethod() = methodName
    override fun getObject() = target
    override fun getObjectId() = target.objectID
    override fun isCustom() = false
    override fun isNull() = false
    override fun isStandard() = true
    override fun isValid() = MemoryManager.isInstanceValid(target) && target.hasMethod(methodName)
    override fun rpc(vararg args: Any?) = toNativeCallable().rpc(*args)
    override fun rpcId(peerId: Long, vararg args: Any?) = toNativeCallable().rpcId(peerId, *args)
    override fun unbind(argCount: Int) = toNativeCallable().unbind(argCount)
    override fun bindUnsafe(vararg args: Any?) = MethodCallable(target, methodName, arrayOf<Any?>(*args, *boundArgs))
    override fun callUnsafe(vararg args: Any?) = target.call(methodName, *args, *boundArgs)
    override fun callDeferredUnsafe(vararg args: Any?) {
        target.callDeferred(methodName, *args, *boundArgs)
    }

    override fun toNativeCallable(): VariantCallable {
        // We pass all params using jni as we're often in a context of sending parameters to cpp, so we should not rewind buffer.
        val ptr = Bridge.engine_call_constructor_object_string_name(target.ptr, methodName.ptr)
        val unbound = VariantCallable(ptr)
        if (boundArgs.isNotEmpty()) {
            return unbound.bindUnsafe(*boundArgs)
        }
        return unbound
    }

    companion object {
        @JvmStatic
        fun createUnsafe(target: Object, methodName: String) = MethodCallable(target, methodName.toGodotName())
    }
}
