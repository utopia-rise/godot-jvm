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
        Bridge.engine_call_bind(ptr)
        return TransferContext.readReturnValue(VariantParser.CALLABLE) as VariantCallable
    }

    override fun callUnsafe(vararg args: Any?): Any? {
        TransferContext.writeArguments(args.size) {
            for (arg in args) VariantCaster.ANY.toGodot(arg)
        }
        Bridge.engine_call_call(ptr)
        return TransferContext.readReturnValue(VariantCaster.ANY)
    }

    override fun callDeferredUnsafe(vararg args: Any?) {
        TransferContext.writeArguments(args.size) {
            for (arg in args) VariantCaster.ANY.toGodot(arg)
        }
        Bridge.engine_call_call_deferred(ptr)
    }

    override fun getBoundArguments(): VariantArray<Any?> {
        Bridge.engine_call_get_bound_arguments(ptr)
        @Suppress("UNCHECKED_CAST")
        return TransferContext.readReturnValue(VariantParser.ARRAY) as VariantArray<Any?>
    }

    override fun getBoundArgumentCount(): Int {
        Bridge.engine_call_get_bound_arguments_count(ptr)
        return VariantParser.LONG.read(TransferContext.beginReturnValueRead()).toInt()
    }

    override fun getMethod(): StringName {
        Bridge.engine_call_get_method(ptr)
        return TransferContext.readReturnValue(VariantParser.STRING_NAME) as StringName
    }

    override fun hashCode(): Int {
        Bridge.engine_call_hash(ptr)
        return VariantParser.LONG.read(TransferContext.beginReturnValueRead()).toInt()
    }

    override fun getObject(): GodotObject {
        Bridge.engine_call_get_object(ptr)
        return TransferContext.readReturnValue(VariantParser.OBJECT) as GodotObject
    }

    override fun getObjectId(): ObjectID {
        Bridge.engine_call_get_object_id(ptr)
        return ObjectID(VariantParser.LONG.read(TransferContext.beginReturnValueRead()))
    }

    override fun isCustom(): Boolean {
        Bridge.engine_call_is_custom(ptr)
        return VariantParser.BOOL.read(TransferContext.beginReturnValueRead())
    }

    override fun isNull(): Boolean {
        Bridge.engine_call_is_null(ptr)
        return VariantParser.BOOL.read(TransferContext.beginReturnValueRead())
    }

    override fun isStandard(): Boolean {
        Bridge.engine_call_is_standard(ptr)
        return VariantParser.BOOL.read(TransferContext.beginReturnValueRead())
    }

    override fun isValid(): Boolean {
        Bridge.engine_call_is_valid(ptr)
        return VariantParser.BOOL.read(TransferContext.beginReturnValueRead())
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
        TransferContext.writeArguments(1) {
            VariantParser.LONG.write(argCount.toLong())
        }
        Bridge.engine_call_unbind(ptr)
        return TransferContext.readReturnValue(VariantParser.CALLABLE) as VariantCallable
    }

    override fun toNativeCallable() = this

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is VariantCallable) return false
        if (getObject() != other.getObject() || getMethod() != other.getMethod()) return false
        return true
    }
}
