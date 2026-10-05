package godot.internal.memory

import java.util.concurrent.ConcurrentHashMap

/**
 * Everything the binding keeps per thread, each reachable in one array access.
 *
 * `ThreadLocal` solves a harder problem than this one: it maps many keys per thread and holds each value through a
 * `WeakReference`, so a lookup walks a hash map and pays a reference read. Here a thread has exactly one [Locals], so
 * a lookup is an array access and an identity check, and every value below shares it. Grouping them also means a call
 * needing several pays for one lookup, and that adding another is a field on [Locals] rather than another table.
 *
 * A thread is given a slot by a slice of the top bits of its id multiplied by [multiplier], and which multiplier that
 * is has not been left to chance: it is only ever replaced by one checked to give every live thread a slot of its own,
 * so the steady state has no collisions at all rather than few. The search runs over billions of candidates, so a
 * thread count [SLOT_COUNT] was sized for always finds one.
 *
 * Reads take no lock and need no memory ordering. A slot is a guess; [Locals.thread] is the answer. Any stale, torn or
 * simply wrong read fails that check and falls into [register], so a wrong value can never be used. That is also what
 * makes reindexing safe to do in place: a thread looking up mid-reindex misses and is served from [directory] until
 * its slot is refilled.
 */
internal object ThreadContext {
    /** Setting size to 1024 threads. */
    private const val SLOT_BITS = 10
    private const val SLOT_COUNT = 1 shl SLOT_BITS
    private const val SLOT_SHIFT = 64 - SLOT_BITS

    /** Golden-ratio odd constant, and the step used to walk to the next candidate. Fixed, so a run is reproducible. */
    private const val FIRST_MULTIPLIER = -0x61c8864680b583ebL
    private const val CANDIDATE_STEP = 6364136223846793005L
    private const val MULTIPLIER_ATTEMPTS = 4096

    /** Static and final, which is what keeps it out of a lookup's dependent loads entirely. */
    @JvmField
    val slots = arrayOfNulls<Locals>(SLOT_COUNT)
    private val directory = ConcurrentHashMap<Thread, Locals>()
    private val lock = Any()

    @Volatile
    private var multiplier = FIRST_MULTIPLIER

    @Volatile
    private var version = 0

    /** The stack of unchecked call frames this thread writes its arguments into. */
    @JvmStatic
    val valueStack: ValueBuffer.Stack
        get() = locals().valueStack

    /** Where this thread stages the arguments of a call arriving from the engine. */
    @JvmStatic
    val paramsArray: Array<Any?>
        get() = locals().paramsArray

    /** Where a wrapper being built for an already existing native object picks up its pointer and id. */
    @JvmStatic
    val initConfiguration: InitConfiguration
        get() = locals().initConfiguration

    @JvmStatic
    fun locals(): Locals {
        val thread = Thread.currentThread()
        val locals = slots[((thread.id * multiplier) ushr SLOT_SHIFT).toInt()]
        if (locals != null && locals.thread === thread) {
            return locals
        }
        return register(thread)
    }

    /**
     * Releases what threads that have terminated still own, which is the only way their buffers are reclaimed: the
     * table holds its threads strongly, so nothing here dies on its own.
     *
     * A dead thread can never sit in a live one's slot, since both were checked to be distinct while both were alive.
     * Sweeping is therefore about memory only, never about the correctness of a lookup.
     */
    fun sweepDeadThreads() {
        if (directory.isEmpty()) {
            return
        }
        synchronized(lock) {
            var swept = false
            val threads = directory.keys.iterator()
            while (threads.hasNext()) {
                val thread = threads.next()
                if (thread.isAlive) {
                    continue
                }
                val slot = slotOf(thread.id, multiplier)
                if (slots[slot]?.thread === thread) {
                    slots[slot] = null
                }
                threads.remove()
                swept = true
            }
            if (swept) {
                version++
            }
        }
    }

    /**
     * Only ever reached once per thread, except for a thread [directory] alone can serve. The costly part, searching
     * for a multiplier that separates every live thread, is done on a snapshot outside [lock].
     */
    private fun register(thread: Thread): Locals {
        directory[thread]?.let { return it }

        val locals = Locals(thread)
        while (true) {
            val seenVersion = version
            val slot = slotOf(thread.id, multiplier)
            val occupant = slots[slot]

            if (occupant == null || !occupant.thread.isAlive) {
                synchronized(lock) {
                    if (version == seenVersion) {
                        directory[thread] = locals
                        slots[slot] = locals
                        version = seenVersion + 1
                        return locals
                    }
                }
                continue
            }

            val live = ArrayList(directory.values).apply {
                retainAll { it.thread.isAlive }
                add(locals)
            }
            val found = findMultiplier(LongArray(live.size) { live[it].thread.id })

            synchronized(lock) {
                if (version == seenVersion) {
                    directory[thread] = locals
                    if (found != 0L) {
                        reindex(live, found)
                    }
                    version = seenVersion + 1
                    return locals
                }
            }
        }
    }

    /**
     * Moves every live thread to the slot [found] gives it. Threads looking up while this runs miss and are served
     * from [directory], so the table never has to be consistent midway.
     */
    private fun reindex(live: List<Locals>, found: Long) {
        slots.fill(null)
        multiplier = found
        for (locals in live) {
            slots[slotOf(locals.thread.id, found)] = locals
        }
    }

    /**
     * The first candidate that gives every id a slot of its own, or 0 if none of [MULTIPLIER_ATTEMPTS] does.
     *
     * Candidates are walked deterministically and kept odd so multiplying by one stays a bijection over the id space.
     * Each is checked by stamping the slots it produces into a scratch table, which costs the number of threads rather
     * than the size of the table; the scratch is allocated once for the whole search, so a candidate that fails early
     * costs almost nothing.
     */
    private fun findMultiplier(ids: LongArray): Long {
        val taken = IntArray(SLOT_COUNT)
        var candidate = FIRST_MULTIPLIER
        for (attempt in 1..MULTIPLIER_ATTEMPTS) {
            var separated = true
            for (id in ids) {
                val slot = slotOf(id, candidate)
                if (taken[slot] == attempt) {
                    separated = false
                    break
                }
                taken[slot] = attempt
            }
            if (separated) {
                return candidate
            }
            candidate = candidate * CANDIDATE_STEP or 1L
        }
        return 0L
    }

    private fun slotOf(id: Long, by: Long) = ((id * by) ushr SLOT_SHIFT).toInt()
}
