package godot.internal.memory

import godot.common.interop.NativeWrapper
import godot.common.interop.ObjectID
import godot.common.interop.VoidPtr
import godot.common.interop.nullObjectID
import godot.internal.memory.binding.Binding
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference
import kotlin.random.Random

class ObjectIDMapTest {
    private class Wrapper(override val objectID: ObjectID) : NativeWrapper {
        override val ptr: VoidPtr = objectID.id
    }

    /** An id as the engine issues them: a 24-bit slot index, a nonzero validator, an optional reference bit. */
    private fun id(index: Int, validator: Int = 1, reference: Boolean = false) = ObjectID(
        (validator.toLong() shl 24) or index.toLong() or (if (reference) ObjectID.OBJECTDB_REFERENCE_BIT else 0L)
    )

    private fun binding(id: ObjectID): Binding = Binding.create(Wrapper(id))

    /** Pages actually allocated, which is what the paging is meant to keep small. */
    private fun ObjectIDMap.pages(): Int {
        val field = ObjectIDMap::class.java.getDeclaredField("directory")
        field.isAccessible = true
        return (field.get(this) as Array<*>).count { it != null }
    }

    /** Slots the directory can address, allocated or not. */
    private fun ObjectIDMap.reach(): Int {
        val field = ObjectIDMap::class.java.getDeclaredField("directory")
        field.isAccessible = true
        return (field.get(this) as Array<*>).size * 1024
    }

    private fun ObjectIDMap.toList(): List<Binding> {
        val list = ArrayList<Binding>()
        forEach { list.add(it) }
        return list
    }

    // --- single entry -----------------------------------------------------------------------------------------

    @Test
    fun `an empty map misses everything`() {
        val map = ObjectIDMap()
        assertNull(map[id(0)])
        assertNull(map[id(0xFFFFFF)])
        assertNull(map[nullObjectID])
        assertNull(map[ObjectID(0)])
        assertNull(map.remove(id(3)))
        assertTrue(map.toList().isEmpty())
    }

    @Test
    fun `a stored binding is found by its id and returns its wrapper`() {
        val map = ObjectIDMap()
        val binding = binding(id(42))
        assertNull(map.put(binding))
        assertSame(binding, map[id(42)])
        assertSame(binding.instance, map[id(42)]!!.instance)
    }

    @Test
    fun `putting the same id again replaces and returns the previous binding`() {
        val map = ObjectIDMap()
        val first = binding(id(7))
        val second = binding(id(7))
        map.put(first)
        assertSame(first, map.put(second))
        assertSame(second, map[id(7)])
        assertEquals(listOf(second), map.toList())
    }

    @Test
    fun `remove by id returns the binding and leaves a miss`() {
        val map = ObjectIDMap()
        val binding = binding(id(7))
        map.put(binding)
        assertSame(binding, map.remove(id(7)))
        assertNull(map[id(7)])
        assertNull(map.remove(id(7)))
        assertTrue(map.toList().isEmpty())
    }

    @Test
    fun `remove by binding only removes that exact instance`() {
        val map = ObjectIDMap()
        val stored = binding(id(7))
        val impostor = binding(id(7))
        map.put(stored)
        assertFalse(map.remove(impostor))
        assertSame(stored, map[id(7)])
        assertTrue(map.remove(stored))
        assertNull(map[id(7)])
        assertFalse(map.remove(stored))
    }

    // --- a slot handed out again ------------------------------------------------------------------------------

    @Test
    fun `the same slot with a later validator takes the slot over`() {
        val map = ObjectIDMap()
        val dead = binding(id(5, validator = 1))
        val reused = binding(id(5, validator = 2))
        map.put(dead)
        assertNull(map[id(5, validator = 2)])
        // The engine hands a slot out again only once the old object is gone, so the new binding replaces it and the
        // old id stops resolving.
        assertNull(map.put(reused))
        assertSame(reused, map[id(5, validator = 2)])
        assertNull(map[id(5, validator = 1)])
        assertEquals(listOf(reused), map.toList())
    }

    @Test
    fun `a stale id neither reads nor removes the binding that took its slot`() {
        val map = ObjectIDMap()
        val live = binding(id(5, validator = 9))
        map.put(live)
        assertNull(map[id(5, validator = 8)])
        assertNull(map.remove(id(5, validator = 8)))
        assertFalse(map.remove(binding(id(5, validator = 8))))
        assertSame(live, map[id(5, validator = 9)])
    }

    @Test
    fun `the reference bit is part of the id`() {
        val map = ObjectIDMap()
        val plain = binding(id(5))
        map.put(plain)
        assertNull(map[id(5, reference = true)])
        assertSame(plain, map[id(5)])
    }

    @Test
    fun `the extreme slot indices and validators are ordinary keys`() {
        val map = ObjectIDMap()
        // Distinct slots: the engine never has two live objects on one, and the array stores one binding per slot.
        val ids = listOf(
            id(0),
            id(1, validator = 2),
            id(0x8000, validator = Int.MAX_VALUE),
            id(0xFFFE, validator = Int.MAX_VALUE, reference = true),
            id(0xFFFF),
        )
        val bindings = ids.map { binding(it) }
        bindings.forEach { map.put(it) }
        ids.zip(bindings).forEach { (id, binding) -> assertSame(binding, map[id]) }
    }

    @Test
    fun `the null id and the zero id never match a stored entry`() {
        val map = ObjectIDMap()
        for (i in 0 until 64) map.put(binding(id(i)))
        for (i in 0 until 64 step 2) map.remove(id(i))
        assertNull(map[nullObjectID])
        assertNull(map[ObjectID(0)])
        assertNull(map.remove(nullObjectID))
        assertNull(map.remove(ObjectID(0)))
    }

    // --- growth -----------------------------------------------------------------------------------------------

    @Test
    fun `the directory widens to reach a high slot index and keeps what it held`() {
        val map = ObjectIDMap()
        val low = binding(id(3))
        map.put(low)
        val high = binding(id(100_000))
        map.put(high)
        assertTrue(map.reach() > 100_000)
        assertSame(low, map[id(3)])
        assertSame(high, map[id(100_000)])
        assertEquals(2, map.toList().size)
    }

    @Test
    fun `two distant slots cost two pages rather than the range between them`() {
        val map = ObjectIDMap()
        map.put(binding(id(3)))
        map.put(binding(id(1_000_000)))
        assertEquals(2, map.pages())
    }

    @Test
    fun `a dense run costs one page per thousand slots`() {
        val map = ObjectIDMap()
        for (i in 0 until 4_096) map.put(binding(id(i)))
        assertEquals(4, map.pages())
    }

    @Test
    fun `a slot index past the end reads and removes as a miss rather than failing`() {
        val map = ObjectIDMap()
        map.put(binding(id(1)))
        assertNull(map[id(1_000_000)])
        assertNull(map.remove(id(1_000_000)))
        assertFalse(map.remove(binding(id(1_000_000))))
        assertEquals(1, map.pages())
    }

    @Test
    fun `dense ids are all reachable`() {
        val map = ObjectIDMap()
        val count = 100_000
        val bindings = (0 until count).map { binding(id(it)) }
        bindings.forEach { assertNull(map.put(it)) }
        for (i in 0 until count) {
            assertSame(bindings[i], map[id(i)])
            assertNull(map[id(i, validator = 2)])
        }
        assertEquals(count, map.toList().size)
    }

    @Test
    fun `strided ids including a power of two are all reachable`() {
        for (stride in intArrayOf(2, 7, 16, 20, 1024)) {
            val map = ObjectIDMap()
            val count = 5_000
            val bindings = (0 until count).map { binding(id(it * stride)) }
            bindings.forEach { map.put(it) }
            for (i in 0 until count) assertSame("stride $stride", bindings[i], map[bindings[i].objectID])
        }
    }

    @Test
    fun `slots handed out again over and over do not allocate more pages`() {
        val map = ObjectIDMap()
        val population = 1_000
        val bindings = Array(population) { binding(id(it)) }
        bindings.forEach { map.put(it) }
        val pages = map.pages()
        var validator = 2
        for (round in 0 until 1_000) {
            for (i in 0 until population) {
                assertTrue(map.remove(bindings[i]))
                bindings[i] = binding(id(i, validator))
                assertNull(map.put(bindings[i]))
            }
            validator++
        }
        assertEquals(pages, map.pages())
        for (i in 0 until population) assertSame(bindings[i], map[bindings[i].objectID])
        assertEquals(population, map.toList().size)
    }

    // --- iteration and reset ----------------------------------------------------------------------------------

    @Test
    fun `forEach visits every live binding once`() {
        val map = ObjectIDMap()
        val kept = (0 until 500).map { binding(id(it)) }
        val removed = (500 until 1_000).map { binding(id(it)) }
        (kept + removed).forEach { map.put(it) }
        removed.forEach { map.remove(it.objectID) }
        val visited = map.toList()
        assertEquals(kept.size, visited.size)
        assertEquals(kept.toSet(), visited.toSet())
    }

    @Test
    fun `clear empties the map and returns it to its initial capacity`() {
        val map = ObjectIDMap()
        val bindings = (0 until 10_000).map { binding(id(it)) }
        bindings.forEach { map.put(it) }
        map.clear()
        assertEquals(0, map.pages())
        assertTrue(map.toList().isEmpty())
        bindings.forEach { assertNull(map[it.objectID]) }
        assertNull(map.put(bindings[0]))
        assertSame(bindings[0], map[bindings[0].objectID])
    }

    // --- against a reference model ----------------------------------------------------------------------------

    @Test
    fun `random operations agree with a model keyed on the slot`() {
        val random = Random(20260919)
        val map = ObjectIDMap()
        // The engine keeps one live object per slot, so the model is keyed on the slot and an insert evicts it.
        val model = HashMap<Int, Binding>()
        val ids = (0 until 4_096).map { id(it % 1_024, validator = 1 + it / 1_024) }
        repeat(500_000) {
            val id = ids[random.nextInt(ids.size)]
            when (random.nextInt(5)) {
                0, 1 -> {
                    val binding = binding(id)
                    val previous = model.put(id.index, binding)
                    assertSame(if (previous?.objectID == id) previous else null, map.put(binding))
                }
                2 -> {
                    val stored = model[id.index]
                    val expected = if (stored?.objectID == id) stored else null
                    if (expected != null) model.remove(id.index)
                    assertSame(expected, map.remove(id))
                }
                3 -> {
                    val stored = model[id.index]
                    val candidate = if (stored != null && random.nextBoolean()) stored else binding(id)
                    val hit = stored != null && stored === candidate
                    if (hit) model.remove(id.index)
                    assertEquals(hit, map.remove(candidate))
                }
                else -> {
                    val stored = model[id.index]
                    assertSame(if (stored?.objectID == id) stored else null, map[id])
                }
            }
        }
        assertEquals(model.values.toSet(), map.toList().toSet())
    }

    // --- lock-free readers ------------------------------------------------------------------------------------

    @Test
    fun `readers racing a writer never receive a binding with another id`() {
        val map = ObjectIDMap()
        val population = 2_048
        val bindings = Array(population) { binding(id(it)) }
        bindings.forEach { map.put(it) }

        val stop = AtomicBoolean(false)
        val failure = AtomicReference<Throwable>()
        val started = CountDownLatch(4)
        val readers = (0 until 4).map { seed ->
            Thread {
                val random = Random(seed)
                started.countDown()
                try {
                    while (!stop.get()) {
                        val wanted = bindings[random.nextInt(population)].objectID
                        val found = map[wanted]
                        // A stale read may miss; it may never answer with a binding for another id.
                        if (found != null) assertEquals(wanted, found.objectID)
                    }
                } catch (t: Throwable) {
                    failure.set(t)
                }
            }.apply { start() }
        }
        started.await()

        // Single writer, as the Kotlin MemoryManager's lock guarantees: removals, reinserts and a growth.
        var validator = 2
        repeat(200) { round ->
            for (i in 0 until population) {
                if (round % 2 == 0) {
                    map.remove(bindings[i])
                } else {
                    bindings[i] = binding(id(i, validator))
                    map.put(bindings[i])
                }
            }
            if (round % 2 == 1) validator++
        }
        map.put(binding(id(500_000)))
        stop.set(true)
        readers.forEach { it.join() }
        failure.get()?.let { throw it }

        for (i in 0 until population) assertSame(bindings[i], map[bindings[i].objectID])
    }
}
