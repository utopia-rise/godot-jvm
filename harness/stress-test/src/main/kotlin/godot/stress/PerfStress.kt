package godot.stress

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Node
import godot.api.Object
import godot.api.RefCounted
import godot.core.dictionaryOf
import godot.core.variantArrayOf
import godot.global.GD

/**
 * A perf test returns the number of operations one call performed; the runner divides the elapsed time by that count.
 *
 * Only a script instance has a JNI reference that is promoted and demoted, so every test about that mechanism uses
 * [Item]. Each of those tests ends on a synchronization, which leaves every item weak again, so the next call performs
 * exactly one promotion and one demotion per item by construction.
 */
@Script
class PerfStress : Object() {
    private val run = TestRun()
    private val held = variantArrayOf<RefCounted>()
    private val scratch = variantArrayOf<RefCounted>()
    private var items = emptyList<Item>()
    private val node = Node()

    override fun _onDestroy() {
        node.free()
    }

    @Register
    fun stressTests() = dictionaryOf(
        "perf_noop" to "unit=us/call",
        "perf_icall" to "",
        "perf_deliver_random" to "",
        "perf_create_ref_counted" to "batch=100",
        "perf_create_item" to "batch=100",
        "perf_create_node" to "batch=100",
        "perf_transition_pair" to "batch=200 unit=us/pair",
        "perf_promote_only" to "batch=200 unit=us/promotion",
        "perf_hot_set_cycles" to "batch=100 frames=8 unit=us/transition",
        "perf_mixed_hot_cold" to "batch=500 frames=8 unit=us/transition",
        "perf_sync_empty" to "unit=us/call",
    )

    @Register
    fun configure(batch: Int, threads: Int, durationMs: Int, frames: Int, seed: Long) {
        run.batch = batch
        run.threads = threads
        run.durationMs = durationMs.toLong()
        run.frames = frames
        run.seed = seed
        held.clear()
        repeat(batch) { held.add(RefCounted()) }
        items = List(batch) { Item() }
        settle()
    }

    /** Calibration: what one call through the runner costs before any work is done. */
    @Register
    fun perfNoop(): Int = 1

    @Register
    fun perfIcall(): Int {
        repeat(run.batch) { node.getInstanceId() }
        return run.batch
    }

    @Register
    fun perfDeliverRandom(): Int {
        var index = 0
        repeat(run.batch) {
            index = (index * 1103515245 + 12345) and 0x7fffffff
            held[index % run.batch]
        }
        return run.batch
    }

    @Register
    fun perfCreateRefCounted(): Int {
        repeat(run.batch) { RefCounted() }
        return run.batch
    }

    @Register
    fun perfCreateItem(): Int {
        repeat(run.batch) { Item() }
        return run.batch
    }

    @Register
    fun perfCreateNode(): Int {
        repeat(run.batch) { Node().free() }
        return run.batch
    }

    /** One promotion and one demotion per item: the reference operations a model changes, end to end. */
    @Register
    fun perfTransitionPair(): Int {
        touchAll()
        scratch.clear()
        GD.syncMemory()
        return items.size
    }

    /** The promotion half alone; the demotion half is left to the untimed settle of the next call. */
    @Register
    fun perfPromoteOnly(): Int {
        touchAll()
        return items.size
    }

    /** The same set touched in every cycle, which is what skipping or sticking a demotion is meant to make cheaper. */
    @Register
    fun perfHotSetCycles(): Int {
        repeat(run.frames) {
            touchAll()
            scratch.clear()
            GD.syncMemory()
        }
        return items.size * run.frames
    }

    /** A tenth of the set is hot, the rest goes quiet after one cycle: a model must not keep the cold part promoted. */
    @Register
    fun perfMixedHotCold(): Int {
        val hot = maxOf(items.size / 10, 1)
        var transitions = 0
        repeat(run.frames) { cycle ->
            val touched = if (cycle == 0) items else items.subList(0, hot)
            for (item in touched) scratch.add(item)
            scratch.clear()
            GD.syncMemory()
            transitions += touched.size
        }
        return transitions
    }

    /** The fixed cost of a synchronization with nothing to do, which every other sync number contains. */
    @Register
    fun perfSyncEmpty(): Int {
        repeat(SYNC_REPEATS) { GD.syncMemory() }
        return SYNC_REPEATS
    }

    private fun touchAll() {
        for (item in items) scratch.add(item)
    }

    private fun settle() {
        scratch.clear()
        Tracked.collect()
        GD.syncMemory()
        GD.syncMemory()
    }

    private companion object {
        const val SYNC_REPEATS = 20
    }
}
