@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedInt64Array : PackedArray<PackedInt64Array, Long> {

    override val bridge = Bridge

    //INTERNALS
    internal constructor(_handle: VoidPtr) {
        this.ptr = _handle
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_32_ARRAY)
    }

    //CONSTRUCTOR
    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_32_ARRAY)
    }

    /**
     * Constructs a [PackedInt64Array] as a copy of the given [PackedInt64Array].
     */
    constructor(from: PackedInt64Array) {
        TransferContext.writeArguments(1) {
            VariantParser.PACKED_INT_64_ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_64_ARRAY)
    }

    /**
     * Constructs a new [PackedInt64Array] by converting a [VariantArray]<[Long]>.
     */
    constructor(from: VariantArray<Long>) {
        TransferContext.writeArguments(1) {
            VariantParser.ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_64_ARRAY)
    }

    /**
     * Constructs a new [PackedInt64Array] from an existing Kotlin [LongArray] or Java long[].
     */
    constructor(from: LongArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_64_ARRAY)
    }

    /**
     * Constructs a new [PackedInt64Array] from an existing Kotlin [Array<Long>].
     */
    constructor(from: Array<Long>) : this(from.toLongArray())

    /**
     * Constructs a new [PackedInt64Array] from an existing Kotlin [Collection<Long>].
     */
    constructor(from: Collection<Long>) : this(from.toLongArray())

    override fun toString(): String {
        return "PackedInt64Array(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedInt64Array) {
            val list1 = this.toList()
            val list2 = other.toList()
            list1 == list2
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return ptr.hashCode()
    }

    fun toLongArray(): LongArray = Bridge.engine_convert_to_jvm(ptr)

    @Suppress("LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_INT_64_ARRAY
        override val elementVariantType = VariantParser.LONG

        external override fun engine_call_constructor(): VoidPtr
        external override fun engine_call_constructor_packed_array(): VoidPtr
        external override fun engine_call_constructor_array(): VoidPtr

        external override fun engine_call_append(_handle: VoidPtr)
        external override fun engine_call_appendArray(_handle: VoidPtr)
        external override fun engine_call_bsearch(_handle: VoidPtr)
        external override fun engine_call_clear(_handle: VoidPtr)
        external override fun engine_call_count(_handle: VoidPtr)
        external override fun engine_call_duplicate(_handle: VoidPtr)
        external override fun engine_call_fill(_handle: VoidPtr)
        external override fun engine_call_find(_handle: VoidPtr)
        external override fun engine_call_get(_handle: VoidPtr)
        external override fun engine_call_has(_handle: VoidPtr)
        external override fun engine_call_is_empty(_handle: VoidPtr)
        external override fun engine_call_insert(_handle: VoidPtr)
        external override fun engine_call_reverse(_handle: VoidPtr)
        external override fun engine_call_pushback(_handle: VoidPtr)
        external override fun engine_call_remove_at(_handle: VoidPtr)
        external override fun engine_call_resize(_handle: VoidPtr)
        external override fun engine_call_rfind(_handle: VoidPtr)
        external override fun engine_call_set(_handle: VoidPtr)
        external override fun engine_call_size(_handle: VoidPtr)
        external override fun engine_call_slice(_handle: VoidPtr)
        external override fun engine_call_sort(_handle: VoidPtr)
        external override fun engine_call_to_byte_array(_handle: VoidPtr)

        external fun engine_convert_to_godot(array: LongArray): VoidPtr
        external fun engine_convert_to_jvm(_handle: VoidPtr): LongArray
    }
}

/**
 * Convert a [LongArray] into a Godot [PackedInt64Array], this call is optimised for a large amount of data.
 */
fun LongArray.toPackedInt64Array() = PackedInt64Array(this)

/**
 * Convert a [Array<Long>] into a Godot [PackedInt64Array], this call is optimised for a large amount of data.
 */
fun Array<Long>.toPackedInt64Array() = PackedInt64Array(this)

/**
 * Convert a [Collection<Long>] into a Godot [PackedInt64Array], this call is optimised for a large amount of data.
 */
fun Collection<Long>.toPackedInt64Array() = PackedInt64Array(this)

private fun Array<Long>.toLongArray(): LongArray =
    LongArray(size).also { longArray ->
        forEachIndexed { index, long ->
            longArray[index] = long
        }
    }

private fun Collection<Long>.toLongArray(): LongArray =
    LongArray(size).also { longArray ->
        forEachIndexed { index, long ->
            longArray[index] = long
        }
    }
