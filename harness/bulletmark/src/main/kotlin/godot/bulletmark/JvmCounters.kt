package godot.bulletmark

import java.lang.management.ManagementFactory

/**
 * Counts every call the engine makes into the scene's scripts: physics steps, signal handlers, draws, deferred calls
 * and timer lambdas. The game is deterministic, so two runs with the same settings make exactly the same calls, and
 * the count per frame is the number of times the engine entered the JVM for the scene's sake.
 */
object ScriptCalls {
    @JvmField
    var count = 0L
}

/**
 * The JVM's own counters, read at the start and the end of the measured frames. They barely vary between runs of a
 * build, so they confirm an allocation or a call-count change from a single run, where frame times need several.
 *
 * Reading them needs the `java.management` module, which a jlink runtime made for an export may leave out; the
 * snapshot then says so instead of failing the run.
 */
object JvmCounters {
    fun snapshot(): Map<String, Long> = try {
        val collectors = ManagementFactory.getGarbageCollectorMXBeans()
        val threads = ManagementFactory.getThreadMXBean() as? com.sun.management.ThreadMXBean
        mapOf(
            "available" to 1L,
            // The main thread only: it runs every script call, and other threads' allocations are not the scene's.
            "allocated_bytes" to (threads?.getThreadAllocatedBytes(Thread.currentThread().id) ?: -1L),
            "gc_count" to collectors.sumOf { it.collectionCount.coerceAtLeast(0L) },
            "gc_time_ms" to collectors.sumOf { it.collectionTime.coerceAtLeast(0L) },
            "jit_time_ms" to (ManagementFactory.getCompilationMXBean()?.totalCompilationTime ?: -1L),
            "script_calls" to ScriptCalls.count,
        )
    } catch (missing: LinkageError) {
        mapOf("available" to 0L, "script_calls" to ScriptCalls.count)
    }

    fun collectorNames(): String = try {
        ManagementFactory.getGarbageCollectorMXBeans().joinToString(", ") { it.name }
    } catch (missing: LinkageError) {
        "unavailable"
    }
}
