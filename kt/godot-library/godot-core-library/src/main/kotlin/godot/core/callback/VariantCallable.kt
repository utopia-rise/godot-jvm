@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.common.interop.ObjectID
import godot.common.interop.VoidPtr
import godot.core.Callable.Bridge
import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import kotlin.reflect.KCallable

class VariantCallable : NativeCoreType, Callable {

    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.CALLABLE)
    }

    constructor(callable: VariantCallable) {
        TransferContext.writeArguments(1) {
            VariantParser.CALLABLE.toGodot(callable)
        }
        ptr = Bridge.engine_call_copy_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.CALLABLE)
    }

    internal constructor(handle: VoidPtr) {
        this.ptr = handle
        MemoryManager.registerNativeCoreType(this, VariantParser.CALLABLE)
    }

    override fun bindUnsafe(vararg args: Any?): VariantCallable {
        TransferContext.writeArguments(args.size) {
            for (arg in args) VariantCaster.ANY.toGodot(arg)
        }
        return TransferContext.callBridge(VariantParser.CALLABLE) { Bridge.engine_call_bind(ptr) } as VariantCallable
    }

    override fun callUnsafe(vararg args: Any?): Any? {
        TransferContext.writeArguments(args.size) {
            for (arg in args) VariantCaster.ANY.toGodot(arg)
        }
        return TransferContext.callBridge(VariantCaster.ANY) { Bridge.engine_call_call(ptr) }
    }

    override fun callDeferredUnsafe(vararg args: Any?) {
        TransferContext.writeArguments(args.size) {
            for (arg in args) VariantCaster.ANY.toGodot(arg)
        }
        Bridge.engine_call_call_deferred(ptr)
    }

    override fun getBoundArguments(): VariantArray<Any?> {
        @Suppress("UNCHECKED_CAST")
        return TransferContext.callBridge(VariantParser.ARRAY) {
            Bridge.engine_call_get_bound_arguments(ptr)
        } as VariantArray<Any?>
    }

    override fun getBoundArgumentCount(): Int {
        return TransferContext.callBridge(VariantParser.LONG) { Bridge.engine_call_get_bound_arguments_count(ptr) }.toInt()
    }

    override fun getMethod(): StringName {
        return TransferContext.callBridge(VariantParser.STRING_NAME) { Bridge.engine_call_get_method(ptr) } as StringName
    }

    override fun hashCode(): Int {
        return TransferContext.callBridge(VariantParser.LONG) { Bridge.engine_call_hash(ptr) }.toInt()
    }

    override fun getObject(): GodotObject {
        return TransferContext.callBridge(VariantParser.OBJECT) { Bridge.engine_call_get_object(ptr) } as GodotObject
    }

    override fun getObjectId(): ObjectID {
        return ObjectID(TransferContext.callBridge(VariantParser.LONG) { Bridge.engine_call_get_object_id(ptr) })
    }

    override fun isCustom(): Boolean {
        return TransferContext.callBridge(VariantParser.BOOL) { Bridge.engine_call_is_custom(ptr) }
    }

    override fun isNull(): Boolean {
        return TransferContext.callBridge(VariantParser.BOOL) { Bridge.engine_call_is_null(ptr) }
    }

    override fun isStandard(): Boolean {
        return TransferContext.callBridge(VariantParser.BOOL) { Bridge.engine_call_is_standard(ptr) }
    }

    override fun isValid(): Boolean {
        return TransferContext.callBridge(VariantParser.BOOL) { Bridge.engine_call_is_valid(ptr) }
    }

    override fun rpc(vararg args: Any?) {
        TransferContext.writeArguments(args.size) {
            for (arg in args) VariantCaster.ANY.toGodot(arg)
        }
        Bridge.engine_call_rpc(ptr)
    }

    override fun rpcId(peerId: Long, vararg args: Any?) {
        TransferContext.writeArguments(args.size + 1) {
            VariantParser.LONG.write(peerId)
            for (arg in args) VariantCaster.ANY.toGodot(arg)
        }
        Bridge.engine_call_rpc_id(ptr)
    }

    override fun unbind(argCount: Int): VariantCallable {
        return TransferContext.callBridge(1, VariantParser.CALLABLE) {
            VariantParser.LONG.write(argCount.toLong())
            Bridge.engine_call_unbind(ptr)
        } as VariantCallable
    }

    override fun toNativeCallable() = this

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is VariantCallable) return false
        if (getObject() != other.getObject() || getMethod() != other.getMethod()) return false
        return true
    }
}
