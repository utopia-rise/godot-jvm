package godot.core

import godot.common.interop.NativeWrapper

/**
 * The slice of Godot's `Object` API that the core library relies on for signals and callables.
 * The generated `godot.api.Object` implements it, which keeps the generated api out of this module.
 */
interface GodotObject : NativeWrapper {
    fun hasMethod(method: StringName): Boolean
    fun call(method: StringName, vararg args: Any?): Any?
    fun callDeferred(method: StringName, vararg args: Any?): Any?

    fun hasSignal(signal: StringName): Boolean
    fun emitSignal(signal: StringName, vararg args: Any?): Error
    fun connect(signal: StringName, callable: Callable, flags: ConnectFlags = ConnectFlags.DEFAULT): Error
    fun disconnect(signal: StringName, callable: Callable)
    fun isConnected(signal: StringName, callable: Callable): Boolean
    fun hasConnections(signal: StringName): Boolean
    fun getSignalConnectionList(signal: StringName): VariantArray<Dictionary<Any?, Any?>>
}
