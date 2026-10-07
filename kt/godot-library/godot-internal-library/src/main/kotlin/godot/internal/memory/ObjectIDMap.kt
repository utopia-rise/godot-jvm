package godot.internal.memory

import godot.common.interop.ObjectID
import godot.internal.memory.binding.Binding

/**
 * Bindings stored at the engine's own slot index, read without a lock and written under one the caller holds.
 *
 * An [ObjectID] is a slot index plus a validator, and the engine keeps at most one live object per slot, so the index
 * addresses storage directly: no hash, no probing, no tombstones, and a removal is a plain null. A slot handed out
 * again carries a new validator, so the stored binding's own id is what confirms a hit.
 *
 * The index is split in two, a directory of pages, so only the ranges the JVM actually reaches cost anything. The
 * engine's slot numbering climbs with every object it has ever held at once, while a project's wrappers usually sit
 * in a few clusters of it; a flat array would pay for the whole range, this pays for the clusters.
 *
 * Either level can be replaced while a reader walks it, and a reader may then read a slot as absent. That is why a
 * miss has to be confirmed under the write lock before a wrapper is created for it.
 */
internal class ObjectIDMap {
    @PublishedApi
    @Volatile
    internal var directory = arrayOfNulls<Array<Binding?>>(INITIAL_PAGES)

    operator fun get(id: ObjectID): Binding? {
        val directory = directory
        val page = id.index ushr PAGE_BITS
        if (page >= directory.size) return null
        val entry = directory[page]?.get(id.index and PAGE_MASK) ?: return null
        return if (entry.objectID == id) entry else null
    }

    /** Stores [binding] at its slot and returns what that slot held for the same id, if anything. */
    fun put(binding: Binding): Binding? {
        val id = binding.objectID
        val page = pageFor(id.index)
        val slot = id.index and PAGE_MASK
        val previous = page[slot]
        page[slot] = binding
        return if (previous != null && previous.objectID == id) previous else null
    }

    fun remove(id: ObjectID): Binding? {
        val page = pageOrNull(id.index) ?: return null
        val slot = id.index and PAGE_MASK
        val entry = page[slot] ?: return null
        if (entry.objectID != id) return null
        page[slot] = null
        return entry
    }

    /** Removes [binding] only if it is the one stored at its slot. */
    fun remove(binding: Binding): Boolean {
        val index = binding.objectID.index
        val page = pageOrNull(index) ?: return false
        val slot = index and PAGE_MASK
        if (page[slot] !== binding) return false
        page[slot] = null
        return true
    }

    inline fun forEach(action: (Binding) -> Unit) {
        for (page in directory) {
            if (page == null) continue
            for (entry in page) {
                if (entry != null) action(entry)
            }
        }
    }

    fun clear() {
        directory = arrayOfNulls(INITIAL_PAGES)
    }

    private fun pageOrNull(index: Int): Array<Binding?>? {
        val directory = directory
        val page = index ushr PAGE_BITS
        return if (page >= directory.size) null else directory[page]
    }

    /** The page holding [index], allocating it and widening the directory to reach it if either is missing. */
    private fun pageFor(index: Int): Array<Binding?> {
        val page = index ushr PAGE_BITS
        var directory = directory
        if (page >= directory.size) {
            var pages = directory.size
            while (pages <= page) pages *= 2
            directory = directory.copyOf(pages)
            this.directory = directory
        }
        return directory[page] ?: arrayOfNulls<Binding>(PAGE_SIZE).also { directory[page] = it }
    }

    @PublishedApi
    internal companion object {
        /** A thousand slots a page, four kilobytes with compressed pointers. */
        const val PAGE_BITS = 10
        const val PAGE_SIZE = 1 shl PAGE_BITS
        const val PAGE_MASK = PAGE_SIZE - 1
        const val INITIAL_PAGES = 16
    }
}
