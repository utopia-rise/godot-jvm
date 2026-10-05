package godot.stress

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Object
import godot.api.RefCounted
import godot.api.ResourceLoader
import godot.api.Script as GodotScript
import godot.api.WorkerThreadPool
import godot.core.asCallable
import godot.core.dictionaryOf
import godot.core.variantArrayOf
import godot.global.GD
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

/**
 * Frame 0 sets up and starts the workers, later frames do the main thread's share, and the test returns true once the
 * workers have run for their duration and stopped. Godot's scene tree is not thread-safe, so workers only touch
 * RefCounted objects, and only the main thread attaches or detaches scripts.
 */
@Script
class RaceStress : Object() {
    private val run = TestRun()
    private val itemScript = ResourceLoader.load("res://src/main/kotlin/godot/stress/Item.kt") as GodotScript
    private val shared = variantArrayOf<RefCounted>()
    private var scratch = emptyList<godot.core.VariantArray<RefCounted>>()
    private var pools = emptyList<Array<RefCounted?>>()
    private var items = emptyList<Item>()
    private var workers = emptyList<Thread>()
    private val running = AtomicBoolean(false)
    private val workerFailures = AtomicInteger()
    private var startedAt = 0L

    @Register
    fun stressTests() = dictionaryOf(
        "race_deliver_across_threads" to "",
        "race_first_delivery_contended" to "",
        "race_refcount_scripts" to "batch=100",
        "race_deferred_calls_to_zombies" to "",
        "race_worker_pool" to "",
        "race_fuzz" to "fuzz",
    )

    @Register
    fun configure(batch: Int, threads: Int, durationMs: Int, frames: Int, seed: Long) {
        run.batch = batch
        run.threads = threads
        run.durationMs = durationMs.toLong()
        run.frames = frames
        run.seed = seed
        scratch = List(threads) { variantArrayOf<RefCounted>() }
        pools = List(threads) { arrayOfNulls<RefCounted>(64) }
    }

    @Register
    fun raceDeliverAcrossThreads(frame: Int): Boolean = race(
        frame,
        setup = { repeat(run.batch) { shared.add(Tracked.track(RefCounted())) } },
        work = { _, random -> Tracked.track(shared[random.nextInt(run.batch)]) },
        mainWork = { for (i in 0 until run.batch) Tracked.track(shared[i]) },
        teardown = {
            for (i in 0 until run.batch) {
                check(shared[i].getReferenceCount() >= 1) { "object $i lost its references while shared" }
            }
            shared.clear()
        },
    )

    // Every worker asks for the same never-delivered objects at once, so the wrapper for an id must be created once.
    @Register
    fun raceFirstDeliveryContended(frame: Int): Boolean = race(
        frame,
        setup = { repeat(run.batch) { shared.add(RefCounted()) } },
        work = { thread, random ->
            val index = random.nextInt(run.batch)
            pools[thread][index % pools[thread].size] = shared[index]
        },
        mainWork = {
            for (i in 0 until run.batch) {
                check(shared[i] === shared[i]) { "object $i resolved to two different wrappers" }
            }
        },
        teardown = {
            for (pool in pools) pool.fill(null)
            shared.clear()
        },
    )

    // Workers make the count of JVM-owned script instances go 1 -> 2 -> 1 while the main thread demotes at frame end.
    @Register
    fun raceRefcountScripts(frame: Int): Boolean = race(
        frame,
        setup = { items = List(run.batch) { Item() } },
        work = { thread, random ->
            scratch[thread].add(items[random.nextInt(items.size)])
            scratch[thread].clear()
        },
        mainWork = { for (item in items) item.poke() },
        teardown = {
            check(items.all { GD.isInstanceValid(it) }) { "a script instance died while referenced" }
            items = emptyList()
        },
    )

    // Workers produce collectable script instances while the main thread queues a bounded number of deferred calls to
    // fresh ones: Godot's message queue is finite, so the producer has to be the frame, not the threads.
    @Register
    fun raceDeferredCallsToZombies(frame: Int): Boolean = race(
        frame,
        setup = {},
        work = { _, _ -> Tracked.track(Item()) },
        mainWork = { repeat(run.batch / 10) { Item().callDeferred("poke") } },
        teardown = {},
    )

    // Deliveries originate from Godot's own worker threads here, so the native side attaches them to the JVM itself.
    @Register
    fun raceWorkerPool(frame: Int): Boolean {
        if (frame == 0) {
            repeat(run.batch) { shared.add(Tracked.track(RefCounted())) }
            startedAt = System.currentTimeMillis()
        }
        if (System.currentTimeMillis() - startedAt >= run.durationMs) {
            shared.clear()
            return true
        }
        val group = WorkerThreadPool.addGroupTask({ index: Int ->
            Tracked.track(shared[index % run.batch])
            Item().poke()
        }.asCallable(), run.batch)
        WorkerThreadPool.waitForGroupTaskCompletion(group)
        return false
    }

    @Register
    fun raceFuzz(frame: Int): Boolean = race(
        frame,
        setup = { repeat(run.batch) { shared.add(Tracked.track(RefCounted())) } },
        work = { thread, random ->
            val own = pools[thread]
            val slot = random.nextInt(own.size)
            when (random.nextInt(6)) {
                0 -> own[slot] = Item()
                1 -> own[slot] = Tracked.track(RefCounted())
                2 -> own[slot]?.let { scratch[thread].add(it); scratch[thread].clear() }
                3 -> own[slot] = null
                4 -> Tracked.track(shared[random.nextInt(run.batch)])
                5 -> shared[random.nextInt(run.batch)].let { scratch[thread].add(it); scratch[thread].clear() }
            }
        },
        mainWork = {
            for (i in 0 until run.batch step 10) {
                val target = Tracked.track(shared[i])
                if (target.getScript() == null) target.setScript(itemScript) else target.setScript(null)
            }
        },
        teardown = {
            for (i in 0 until run.batch) shared[i].setScript(null)
            for (pool in pools) pool.fill(null)
            shared.clear()
        },
    )

    private fun race(
        frame: Int,
        setup: () -> Unit,
        work: (thread: Int, random: Random) -> Unit,
        mainWork: () -> Unit,
        teardown: () -> Unit,
    ): Boolean {
        if (frame == 0) {
            setup()
            start(work)
            return false
        }
        mainWork()
        if (System.currentTimeMillis() - startedAt < run.durationMs) return false
        stop()
        teardown()
        return true
    }

    private fun start(work: (thread: Int, random: Random) -> Unit) {
        running.set(true)
        startedAt = System.currentTimeMillis()
        workers = List(run.threads) { thread ->
            Thread {
                val random = Random(run.seed + thread)
                try {
                    while (running.get()) work(thread, random)
                } catch (t: Throwable) {
                    workerFailures.incrementAndGet()
                    GD.pushError("worker $thread failed: $t")
                }
            }.apply { start() }
        }
    }

    private fun stop() {
        running.set(false)
        workers.forEach(Thread::join)
        check(workerFailures.getAndSet(0) == 0) { "workers reported failures" }
    }
}
