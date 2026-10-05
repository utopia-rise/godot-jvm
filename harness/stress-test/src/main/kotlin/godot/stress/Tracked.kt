package godot.stress

import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference
import java.util.concurrent.ConcurrentLinkedQueue

object Tracked {
    private val references = ConcurrentLinkedQueue<WeakReference<Any>>()

    fun <T : Any> track(instance: T): T {
        references.add(WeakReference(instance))
        return instance
    }

    // refersTo(), not get(): handing out a strong reference here would keep the last wrapper examined alive.
    fun alive(): Int {
        references.removeIf { it.refersTo(null) }
        return references.size
    }

    fun clear() = references.clear()

    // System.gc() is a hint and reference processing is asynchronous, so a bare call proves nothing. Enqueuing a probe
    // and waiting for it back is the one signal that a collection ran and its references were processed.
    fun collect(timeoutMs: Long = 200L): Boolean {
        WeakReference(Any(), probes)
        System.gc()
        return probes.remove(timeoutMs) != null
    }

    private val probes = ReferenceQueue<Any>()
}
