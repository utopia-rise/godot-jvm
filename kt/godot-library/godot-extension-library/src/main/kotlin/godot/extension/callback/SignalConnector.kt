@file:Suppress("PackageDirectoryMismatch", "unused")

package godot.extension

import godot.core.ConnectFlags
import godot.core.Callable
import godot.core.Signal
import godot.core.Error

class SignalConnector internal constructor(
    private val signal: Signal,
    private val callable: Callable,
) {
    fun connect(flags: ConnectFlags = ConnectFlags.DEFAULT): Error = signal.connectUnsafe(callable, flags)
    fun disconnect(): Unit = signal.disconnectUnsafe(callable)
    fun isConnected(): Boolean = signal.isConnected(callable)
    fun isValid(): Boolean = signal.isValid() && callable.isValid()

    companion object {
        @JvmStatic
        fun createUnsafe(signal: Signal, callable: Callable,) = SignalConnector(signal, callable)
    }
}
