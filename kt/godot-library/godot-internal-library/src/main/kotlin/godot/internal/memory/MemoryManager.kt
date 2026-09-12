@file:Suppress("unused")

package godot.internal.memory

import godot.common.interop.NativeWrapper
import godot.common.interop.ObjectID
import godot.common.interop.NativePointer
import godot.common.interop.VariantConverter
import godot.common.interop.VoidPtr
import godot.internal.memory.binding.Binding
import godot.internal.memory.binding.NativeCoreBinding
import godot.internal.memory.binding.RefCountedBinding
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.read
import kotlin.concurrent.write
import kotlin.math.max
import kotlin.math.roundToInt

object MemoryManager {

    /** With those constants, the manager can handle up to 30_000 items at once in the allowed time.
     *  You can compute the number of iterations it takes to process everything with the following formula:
     * ```
     * -(MAX_ITERATION / DECAY_FACTOR) × (
     *     ln(
     *         (MAX_GC_NUMBER × MAX_ITERATION) / (size × DECAY_FACTOR)
     *     ) - 1
     * )
     * ```
     * */
    private object Configuration {
        /** Number of references to decrement each loop on a light load (Doesn't have priority over the ratio).*/
        private const val MAX_GC_NUMBER = 64f

        /** The maximum amount of iteration it should take for a binding to be processed by the Manager in case of heavy load.*/
        private const val MAX_ITERATION = 60f

        /** The processing of queues follows an exponential decay. This number is the result of `ln(0.01)`.
         * It means that 99% of the queue will be processed by the time the max number of iterations is reached.
         */
        private const val DECAY_FACTOR = 4.6051702f

        /**
         * The only variable available is the current size of the queue. We want to make sure everything is processed in time.
         * We can't simply process `1f/MAX_ITERATION` items when under load. Because of the exponential decay, it would take much longer than `MAX_ITERATION`.
         * We increase the ratio enough that 99% of the queue can be processed in the allowed time.
         * In practice when the number of items in the queue becomes small enough, `MAX_GC_NUMBER` will take over and handle the remaining 1% in time.
         * This is a finite approximation of the function ```f(x) = size * exp(-x * DECAY_FACTOR / MAX_ITERATION)```
         */
        fun getNumberOfItemsToProcess(size: Int) = max(MAX_GC_NUMBER, size * (DECAY_FACTOR / MAX_ITERATION))
            .roundToInt()
            .coerceAtMost(size)
    }

    /** Base capacity for caches.*/
    // TODO: Set the initial capacity from the command line.
    const val CACHE_INITIAL_CAPACITY = 512

    /** Base capacity for several binding containers.*/
    private const val BINDING_INITIAL_CAPACITY = 4096

    private val lock = ReentrantReadWriteLock()

    /** Pointers to Godot objects.*/
    private val ObjectDB = HashMap<ObjectID, Binding>(BINDING_INITIAL_CAPACITY)

    /** Pointers to Godot objects.*/
    private val refCountedLinks = HashMap<RefCountedBinding, NativeWrapper>(BINDING_INITIAL_CAPACITY)

    /** List of references to decrement.*/
    private val deadReferences = mutableListOf<RefCountedBinding>()

    /** Pointers to ValuePointer.*/
    private val nativeCoreTypeMap = ConcurrentHashMap<VoidPtr, NativeCoreBinding>(BINDING_INITIAL_CAPACITY)

    /** List of references to decrement.*/
    private val deadNativeCores = mutableListOf<NativeCoreBinding>()

    /** List of cleanup callbacks. When the game closes, they will be called.*/
    private var cleanupCallbacks = mutableListOf<Pair<Boolean, () -> Unit>>()


    fun registerCallback(persistAfterReload: Boolean = false, callback: () -> Unit) {
        cleanupCallbacks.add(persistAfterReload to callback)
    }

    /**
     * The Godot native object has just been created. We can directly add it to ObjectDB because we know the slot is free.
     */
    fun registerNewNativeObject(nativeWrapper: NativeWrapper) = lock.write {
        ObjectDB[nativeWrapper.objectID] = Binding.create(nativeWrapper)
    }

    /**
     * Check if a native object already has a wrapper, if not, we create it.
     */
    fun getInstanceOrCreate(id: ObjectID, constructor: () -> NativeWrapper) = lock.read {
        // We first try to get a match.
        ObjectDB[id]?.instance
    } ?: lock.write {
        // Fallback to creating the wrapper.
        // We check a second time in a write lock in case it got created after the read lock by another thread
        ObjectDB[id]?.instance ?: constructor().also { ObjectDB[id] = Binding.create(it) }
    }

    /**
     * Create a script on top of an existing native object. It's usually called when adding/removing scripts. If RefCounted, we need to link the old and new instance together
     */
    fun registerExistingNativeObject(nativeWrapper: NativeWrapper) = lock.write {
        val objectId = nativeWrapper.objectID
        val oldBinding = ObjectDB.put(objectId, Binding.create(nativeWrapper))

        // If an old binding exist, it means that we added/removed a script and create a link between the 2 bindings.
        if (oldBinding != null && objectId.isReference) {
            refCountedLinks[oldBinding as RefCountedBinding] = nativeWrapper
        }
    }

    /**
     * Directly remove the object from the ObjectDB, the caller has now the responsibility of deleting the object itself.
     */
    fun deleteObject(id: Long): Unit = lock.write {
        ObjectDB.remove(ObjectID(id))
    }

    fun isInstanceValid(ktObject: NativeWrapper) = checkInstance(ktObject.ptr, ktObject.objectID.id)

    fun registerNativeCoreType(nativeCoreType: NativePointer, variantType: VariantConverter<*>) {
        val rawPtr = nativeCoreType.ptr
        nativeCoreTypeMap[rawPtr] = NativeCoreBinding(nativeCoreType, variantType)
    }

    private fun syncMemory(freedObjects: LongArray): LongArray {
        removeNativeCoreTypes()
        removeDeadObjects(freedObjects)
        return getDeadReferences()
    }

    /**
     * Remove the now dead native Object from the JVM ObjectDB.
     */
    private fun removeDeadObjects(freedObjects: LongArray) = lock.write {
        for (id in freedObjects) {
            val objectID = ObjectID(id)
            ObjectDB.remove(objectID)
        }
    }

    /**
     * Get a LongArray containing a collection of dead references that have to be decremented on the native side.
     * The GC happening in waves, not everything is processed at once, we process the dead references over several frames when necessary.
     */
    private fun getDeadReferences(): LongArray {
        // Pool all dead references first, so we can know the amount of work to do.
        while (true) {
            val ref = ((Binding.queue.poll() ?: break) as RefCountedBinding)
            deadReferences.add(ref)
        }

        val numberToDecrement = Configuration.getNumberOfItemsToProcess(deadReferences.size)
        val sublist = deadReferences.subList(0, numberToDecrement)

        val deadArray = lock.write {
            sublist.filter {
                val objectID = it.objectID
                val otherRef = ObjectDB[objectID]

                /** This part requires caution. We have to make sure it's safe to decrement the counter of this instance.
                 * Everything is under the assumption that all objects during the execution of the engine have a unique ObjectID, which is an assumption Godot uses as well.

                Note that the state of the binding in the ObjectDB at this point in time can be several things:
                - Present with its weak reference still valid.
                - Present but its weak reference got GCed.
                - Not present

                Here the different interpretations we can have:
                - If the dead binding is the same (===) as the one in the ObjectDB, it means it hasn't been replaced yet and is safe to decrement.
                - If the binding is not in the objectDB, it means it has been queued or deleted already, we don't need to queue it again.
                it can happen if 2 or more wrappers for the same RefCounted are created and GCed between 2 memory syncs.
                - If the binding in the objectDB is a different one, it means the wrapper has been replaced (the previous one died, but Godot sent to the JVM again), we don't queue it.

                Only the identity test is necessary because that the only case that allows for decrement, all others possibilities don't pass.
                 **/
                val decrement = it === otherRef
                if (decrement) {
                    ObjectDB.remove(objectID)
                } else {
                    // The binding is not in the ObjectDB, it can because it's a Twin of a more recent wrapper. In this case, we remove the link.
                    refCountedLinks.remove(it)
                }
                decrement
            }
        }
            .map { it.objectID.id }
            .toLongArray()

        sublist.clear()
        return deadArray
    }

    /**
     * Remove dead [NativePointer] from native memory.
     * The GC happening in waves, not everything is processed at once, we process the dead native cores over several frames when necessary.
     */
    private fun removeNativeCoreTypes() {
        // Pool all dead native cores first, so we can know the amount of work to do.
        while (true) {
            val ref = ((NativeCoreBinding.queue.poll() ?: break) as NativeCoreBinding)
            deadNativeCores.add(ref)
        }

        val numberToDecrement = Configuration.getNumberOfItemsToProcess(deadNativeCores.size)
        val pointerArray = LongArray(numberToDecrement)
        val variantTypeArray = IntArray(numberToDecrement)

        deadNativeCores
            .subList(0, numberToDecrement)
            .onEachIndexed { index, binding ->
                pointerArray[index] = binding.ptr
                variantTypeArray[index] = binding.variantType.id
                nativeCoreTypeMap.remove(binding.ptr)
            }.clear()

        unrefNativeCoreTypes(pointerArray, variantTypeArray)
    }

    fun cleanUp() {
        for ((_, callback) in cleanupCallbacks) {
            callback.invoke()
        }
        cleanupCallbacks = cleanupCallbacks.filter { it.first }.toMutableList() // One shot are not kept to avoid keeping dead classes after reloading.

        // Get through all remaining [Objects] instances and remove their bindings
        for (objectID in ObjectDB.keys) {
            releaseBinding(objectID.id)
        }
        ObjectDB.clear()

        val size = nativeCoreTypeMap.size
        if (size > 0) {
            val pointerArray = LongArray(size)
            val variantTypeArray = IntArray(size)

            nativeCoreTypeMap
                .values
                .onEachIndexed { index, binding ->
                    pointerArray[index] = binding.ptr
                    variantTypeArray[index] = binding.variantType.id
                }.clear()

            unrefNativeCoreTypes(pointerArray, variantTypeArray)
        }

        nativeCoreTypeMap.clear()
    }

    external fun checkInstance(ptr: VoidPtr, instanceId: Long): Boolean
    external fun releaseBinding(instanceId: Long)
    external fun unrefNativeCoreTypes(pointerArray: LongArray, variantTypeArray: IntArray)
    external fun querySync()
}
