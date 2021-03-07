@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.util.IndexedIterator
import godot.util.VoidPtr

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PoolVector3Array : NativeCoreType, Iterable<Vector3> {

    //PROPERTIES
    val size: Int
        get() {
		    Bridge.engine_call_size(_handle)
			return TransferContext.readReturnValue(VariantType.JVM_INT) as Int
		}

    //CONSTRUCTOR
    constructor() {
        _handle = Bridge.engine_call_constructor()
        GarbageCollector.registerNativeCoreType(this, VariantType.POOL_VECTOR3_ARRAY)
    }

    internal constructor(_handle: VoidPtr) {
        this._handle = _handle
        GarbageCollector.registerNativeCoreType(this, VariantType.POOL_VECTOR3_ARRAY)
    }


    //POOL ARRAY API SHARED
    /**
     * Appends an element at the end of the array (alias of push_back).
     */
    fun append(vector3: Vector3) {
        TransferContext.writeArguments(VariantType.VECTOR3 to vector3)
        Bridge.engine_call_append(_handle)
    }


    /**
     * Appends a PoolVector3Array at the end of this array.
     */
    fun appendArray(array: PoolVector3Array) {
        TransferContext.writeArguments(VariantType.POOL_VECTOR3_ARRAY to array)
        Bridge.engine_call_appendArray(_handle)
    }

    /**
     * Returns true if the array is empty.
     */
    fun empty(): Boolean {
        Bridge.engine_call_empty(_handle)
        return TransferContext.readReturnValue(VariantType.BOOL) as Boolean
    }

    /**
     *  Retrieve the element at the given index.
     */
    operator fun get(idx: Int): Vector3 {
        TransferContext.writeArguments(VariantType.JVM_INT to idx)
        Bridge.engine_call_get(_handle)
        return TransferContext.readReturnValue(VariantType.VECTOR3) as Vector3
    }

    /**
     * Inserts a new element at a given position in the array.
     * The position must be valid, or at the end of the array (idx == size()).
     */
    fun insert(idx: Int, data: Vector3) {
        TransferContext.writeArguments(VariantType.JVM_INT to idx, VariantType.VECTOR3 to data)
        Bridge.engine_call_insert(_handle)
    }

    /**
     * Reverses the order of the elements in the array.
     */
    fun invert() {
        Bridge.engine_call_invert(_handle)
    }

    /**
     * Appends a value to the array.
     */
    fun pushBack(data: Vector3) {
        TransferContext.writeArguments(VariantType.VECTOR3 to data)
        Bridge.engine_call_pushback(_handle)
    }

    /**
     * Removes an element from the array by index.
     */
    fun remove(idx: Int) {
        TransferContext.writeArguments(VariantType.JVM_INT to idx)
        Bridge.engine_call_remove(_handle)
    }

    /**
     * Sets the size of the array. If the array is grown, reserves elements at the end of the array.
     * If the array is shrunk, truncates the array to the new size.
     */
    fun resize(size: Int) {
        TransferContext.writeArguments(VariantType.JVM_INT to size)
        Bridge.engine_call_resize(_handle)
    }

    /**
     * Changes the integer at the given index.
     */
    operator fun set(idx: Int, data: Vector3) {
        TransferContext.writeArguments(VariantType.JVM_INT to idx, VariantType.VECTOR3 to data)
        Bridge.engine_call_set(_handle)
    }


    //UTILITIES
    operator fun plus(other: Vector3) {
        this.append(other)
    }

    operator fun plus(other: PoolVector3Array) {
        this.appendArray(other)
    }

    override fun toString(): String {
        return "PoolVector3Array(${size})"
    }

    override fun iterator(): Iterator<Vector3> {
        return IndexedIterator(this::size, this::get, this::remove)
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PoolVector3Array) {
            val list1 = this.toList()
            val list2 = other.toList()
            list1 == list2
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return hashCode()
    }



    @Suppress("FunctionName")
    private object Bridge {
        external fun engine_call_constructor(): VoidPtr

        external fun engine_call_append(_handle: VoidPtr)
        external fun engine_call_appendArray(_handle: VoidPtr)
        external fun engine_call_empty(_handle: VoidPtr)
        external fun engine_call_get(_handle: VoidPtr)
        external fun engine_call_insert(_handle: VoidPtr)
        external fun engine_call_invert(_handle: VoidPtr)
        external fun engine_call_pushback(_handle: VoidPtr)
        external fun engine_call_remove(_handle: VoidPtr)
        external fun engine_call_resize(_handle: VoidPtr)
        external fun engine_call_set(_handle: VoidPtr)
		external fun engine_call_size(_handle: VoidPtr)
    }
}
