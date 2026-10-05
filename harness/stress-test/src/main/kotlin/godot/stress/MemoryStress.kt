package godot.stress

import godot.annotation.Register
import godot.annotation.Script
import godot.api.Image
import godot.api.Node
import godot.api.Object
import godot.api.RefCounted
import godot.api.ResourceLoader
import godot.api.Script as GodotScript
import godot.core.Dictionary
import godot.core.NodePath
import godot.core.PackedByteArray
import godot.core.PackedInt32Array
import godot.core.PackedStringArray
import godot.core.PackedVector3Array
import godot.core.StringName
import godot.core.methodCallable0
import godot.core.dictionaryOf
import godot.core.variantArrayOf
import godot.global.GD
import kotlin.random.Random

/**
 * Every test is stepped once per frame with the frame index and returns true when done. The runner then expects
 * everything the test created to be released again.
 */
@Script
class MemoryStress : Object() {
    private val run = TestRun()
    private val itemScript = ResourceLoader.load("res://src/main/kotlin/godot/stress/Item.kt") as GodotScript
    private val emitter = Emitter()
    private val held = variantArrayOf<RefCounted>()
    private val scratch = variantArrayOf<RefCounted>()
    private val slots = arrayOfNulls<RefCounted>(256)
    private var random = Random(run.seed)
    private var nodes = emptyList<Node>()
    private var survivor: RefCounted? = null

    @Register
    fun stressTests() = dictionaryOf(
        "memory_create_drop" to "",
        "memory_release_latency" to "batch=200 settle=8",
        "memory_weak_only_bouncer" to "batch=200 frames=10",
        "memory_promote_after_collection" to "batch=1",
        "memory_godot_array_holds" to "",
        "memory_godot_new_hands_to_jvm" to "",
        "memory_script_attach_detach" to "",
        "memory_script_replacement_link" to "batch=1",
        "memory_zombie_callable" to "",
        "memory_resources" to "",
        "memory_native_core_types" to "leftover=0",
        "memory_burst" to "batch=100000 settle=3000",
        "memory_redeliver_pending" to "",
        "memory_refcount_ledger" to "batch=1",
        "memory_object_freed_while_held" to "",
        "memory_engine_side_destruction" to "batch=200",
        "memory_fuzz" to "fuzz frames=120 batch=200",
    )

    @Register
    fun configure(batch: Int, threads: Int, durationMs: Int, frames: Int, seed: Long) {
        run.batch = batch
        run.threads = threads
        run.durationMs = durationMs.toLong()
        run.frames = frames
        run.seed = seed
        random = Random(seed)
    }

    override fun _onDestroy() {
        emitter.free()
    }

    @Register
    fun memoryCreateDrop(frame: Int): Boolean {
        repeat(run.batch) {
            Tracked.track(RefCounted())
            Item()
        }
        return true
    }

    // Every reference is dropped in one frame, so the release must complete inside the tight settle this test declares.
    @Register
    fun memoryReleaseLatency(frame: Int): Boolean = when (frame) {
        0 -> {
            repeat(run.batch) { held.add(Item()) }
            false
        }
        1 -> {
            held.clear()
            true
        }
        else -> false
    }

    // The script instances are anchored by Godot alone, so a reference wrongly left weak loses them and the state check
    // fails instead of passing by luck.
    @Register
    fun memoryWeakOnlyBouncer(frame: Int): Boolean {
        if (frame == 0) {
            repeat(run.batch) { held.add(Item()) }
            return false
        }
        if (frame > run.frames) {
            held.clear()
            return true
        }
        Tracked.collect()
        for (i in 0 until run.batch) {
            val item = held[i]
            scratch.add(item)
            check(item.call("poke") == frame.toLong()) { "item $i lost its state at frame $frame" }
        }
        scratch.clear()
        return false
    }

    // Godot takes a reference again after the JVM instance was collected, which is the one case promotion cannot serve.
    @Register
    fun memoryPromoteAfterCollection(frame: Int): Boolean = when (frame) {
        0 -> {
            held.add(Item())
            false
        }
        in 1..4 -> {
            Tracked.collect()
            false
        }
        5 -> {
            val item = held[0]
            scratch.add(item)
            check(GD.isInstanceValid(item)) { "the object died while a Godot Array held it" }
            check(item.getReferenceCount() >= 2) { "the reference Godot took was not counted" }
            scratch.clear()
            held.clear()
            true
        }
        else -> false
    }

    @Register
    fun memoryGodotArrayHolds(frame: Int): Boolean = when (frame) {
        0 -> {
            repeat(run.batch) { held.add(Item()) }
            false
        }
        4 -> {
            // The array is the only owner left, so every element must still be the same live instance.
            for (i in 0 until run.batch) {
                val item = held[i] as Item
                check(GD.isInstanceValid(item)) { "item $i died while a Godot Array held it" }
                check(item.poke() == 1) { "item $i lost its state across the round trip" }
            }
            false
        }
        5 -> {
            held.clear()
            true
        }
        else -> false
    }

    @Register
    fun memoryGodotNewHandsToJvm(frame: Int): Boolean {
        repeat(run.batch) { itemScript.call("new") }
        return true
    }

    @Register
    fun memoryScriptAttachDetach(frame: Int): Boolean = when (frame) {
        0 -> {
            repeat(run.batch) { held.add(Tracked.track(RefCounted())) }
            false
        }
        1 -> {
            for (i in 0 until run.batch) held[i].setScript(itemScript)
            false
        }
        2 -> {
            for (i in 0 until run.batch) check(held[i].call("poke") == 1L) { "script $i is not answering after attach" }
            false
        }
        3 -> {
            for (i in 0 until run.batch) held[i].setScript(null)
            false
        }
        4 -> {
            for (i in 0 until run.batch) check(!held[i].hasMethod("poke")) { "script $i survived its removal" }
            held.clear()
            true
        }
        else -> false
    }

    // The wrapper that predates the script must keep the new script instance reachable, so state survives a collection.
    @Register
    fun memoryScriptReplacementLink(frame: Int): Boolean = when (frame) {
        0 -> {
            survivor = RefCounted()
            survivor!!.setScript(itemScript)
            survivor!!.call("poke")
            false
        }
        in 1..4 -> {
            Tracked.collect()
            false
        }
        5 -> {
            check(survivor!!.call("poke") == 2L) { "the script instance behind the original wrapper was replaced" }
            survivor = null
            true
        }
        else -> false
    }

    // Items are dropped right after connecting, so Godot keeps calling them while their JVM instance may already be
    // collected, until the release frees them and the connections go with it.
    @Register
    fun memoryZombieCallable(frame: Int): Boolean = when (frame) {
        0 -> {
            repeat(run.batch) { emitter.tick.connect(methodCallable0(Item(), Item::onTick)) }
            check(emitter.getSignalConnectionList("tick").size == run.batch) { "connections were not established" }
            false
        }
        in 1..3 -> {
            Tracked.collect()
            emitter.tick.emit()
            false
        }
        else -> true
    }

    @Register
    fun memoryResources(frame: Int): Boolean {
        repeat(run.batch) {
            Payload()
            Tracked.track(Image())
        }
        return true
    }

    @Register
    fun memoryNativeCoreTypes(frame: Int): Boolean {
        repeat(run.batch) {
            Dictionary<String, Int>()
            NodePath("some/node/path")
            StringName("some_name")
            PackedByteArray()
            PackedInt32Array()
            PackedStringArray()
            PackedVector3Array()
            variantArrayOf(1, 2, 3)
        }
        return true
    }

    @Register
    fun memoryBurst(frame: Int): Boolean {
        repeat(run.batch) { Tracked.track(RefCounted()) }
        return true
    }

    // Each frame collects the previous wrappers, then fetches the same objects again while their release is pending.
    @Register
    fun memoryRedeliverPending(frame: Int): Boolean = when (frame) {
        0 -> {
            repeat(run.batch) { held.add(Tracked.track(RefCounted())) }
            false
        }
        in 1..4 -> {
            Tracked.collect()
            for (i in 0 until run.batch) {
                val wrapper = Tracked.track(held[i])
                check(wrapper.getReferenceCount() == 2) { "re-delivery changed the reference count of object $i" }
            }
            false
        }
        5 -> {
            held.clear()
            true
        }
        else -> false
    }

    // Godot holds one reference through the array, the JVM holds the other through its wrapper.
    @Register
    fun memoryRefcountLedger(frame: Int): Boolean = when (frame) {
        0 -> {
            survivor = RefCounted()
            check(survivor!!.getReferenceCount() == 1) { "a fresh JVM object should hold exactly one reference" }
            held.add(survivor!!)
            check(survivor!!.getReferenceCount() == 2) { "storing in a Godot Array should add one reference" }
            survivor = null
            false
        }
        in 1..6 -> {
            Tracked.collect()
            false
        }
        7 -> {
            val wrapper = held[0]
            check(GD.isInstanceValid(wrapper)) { "the object died while the Godot Array still held it" }
            check(wrapper.getReferenceCount() == 2) { "the JVM released its reference too early or too late" }
            held.clear()
            true
        }
        else -> false
    }

    @Register
    fun memoryObjectFreedWhileHeld(frame: Int): Boolean = when (frame) {
        0 -> {
            nodes = List(run.batch) { Tracked.track(Node()) }
            for (i in 0 until run.batch step 2) nodes[i].free()
            false
        }
        1 -> {
            for (i in 0 until run.batch) {
                val expected = i % 2 == 1
                check(GD.isInstanceValid(nodes[i]) == expected) { "node $i validity should be $expected" }
                if (expected) nodes[i].free()
            }
            nodes = emptyList()
            true
        }
        else -> false
    }

    // Godot destroys these, not the JVM: the wrappers must follow without the JVM freeing anything itself.
    @Register
    fun memoryEngineSideDestruction(frame: Int): Boolean = when (frame) {
        0 -> {
            val root = Tracked.track(Node())
            repeat(run.batch) { root.addChild(Tracked.track(Node())) }
            nodes = listOf(root)
            false
        }
        1 -> {
            val root = nodes[0]
            nodes = emptyList()
            root.free()
            false
        }
        else -> true
    }

    @Register
    fun memoryFuzz(frame: Int): Boolean {
        if (frame >= run.frames) {
            slots.fill(null)
            held.clear()
            return true
        }
        repeat(run.batch) {
            val slot = random.nextInt(slots.size)
            when (random.nextInt(8)) {
                0 -> slots[slot] = Item()
                1 -> slots[slot] = Tracked.track(RefCounted())
                2 -> slots[slot]?.let { held.add(it) }
                3 -> if (held.isNotEmpty()) held.removeAt(random.nextInt(held.size))
                4 -> slots[slot]?.takeIf { it.getScript() == null }?.setScript(itemScript)
                5 -> slots[slot]?.setScript(null)
                6 -> slots[slot] = null
                7 -> if (held.isNotEmpty()) Tracked.track(held[random.nextInt(held.size)]).getReferenceCount()
            }
        }
        return false
    }
}
