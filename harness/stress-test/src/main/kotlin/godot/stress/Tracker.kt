package godot.stress

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Object
import godot.api.Node
import godot.api.RefCounted
import godot.core.Dictionary
import godot.core.dictionaryOf
import godot.global.GD

@Script
class Tracker : Object() {
    @Register
    fun collect(): Boolean = Tracked.collect()

    @Register
    fun alive(): Int = Tracked.alive()

    @Register
    fun reset() = Tracked.clear()

    /**
     * Touches everything the binding creates lazily on first use, so it exists before any baseline is taken. Without
     * this the first test to reach [GD] pays for its RandomNumberGenerator, which is built on first access and lives
     * for the rest of the process, and the test is charged one object it did not leak.
     */
    @Register
    fun warmUp(): Int {
        GD.isInstanceValid(this)
        GD.randi()
        RefCounted()
        Node().free()
        return 1
    }

    @Register
    fun heapBytes(): Long = Runtime.getRuntime().let { it.totalMemory() - it.freeMemory() }

    @Register
    fun jvmInfo(): Dictionary<String, String> = dictionaryOf(
        "version" to System.getProperty("java.version"),
        "vendor" to System.getProperty("java.vendor"),
        "vm" to System.getProperty("java.vm.name"),
    )

    // Diagnostics for a failed settle: what the memory manager still knows about, read through reflection because
    // none of it is part of the public API.
    @Register
    fun dump(): String {
        val objectDb = field<Map<*, *>>("ObjectDB")
        val wrappers = objectDb.values.groupingBy { binding ->
            val instance = binding!!.javaClass.getMethod("getInstance").invoke(binding)
            instance?.javaClass?.simpleName ?: "collected"
        }.eachCount()
        val previousReport = field<LongArray>("previousReport")
        return "ObjectDB=$wrappers deadBindings=${field<List<*>>("deadBindings").size} " +
            "candidates=${previousReport[1]} links=${field<Map<*, *>>("refCountedLinks").size}"
    }

    private val manager: Any = Class.forName("godot.internal.memory.MemoryManager").getDeclaredField("INSTANCE").get(null)

    @Suppress("UNCHECKED_CAST")
    private fun <T> field(name: String): T =
        manager.javaClass.getDeclaredField(name).apply { isAccessible = true }.get(manager) as T
}
