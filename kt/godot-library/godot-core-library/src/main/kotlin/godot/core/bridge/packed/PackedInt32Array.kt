@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedInt32Array : PackedArray<PackedInt32Array, Int> {

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
     * Constructs a [PackedInt32Array] as a copy of the given [PackedInt32Array].
     */
    constructor(from: PackedInt32Array) {
        TransferContext.writeArguments(1) {
            VariantParser.PACKED_INT_32_ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_32_ARRAY)
    }

    /**
     * Constructs a new [PackedInt32Array] by converting a [VariantArray]<[Int]>.
     */
    constructor(from: VariantArray<Int>) {
        TransferContext.writeArguments(1) {
            VariantParser.ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_32_ARRAY)
    }

    /**
     * Constructs a new [PackedInt32Array] from an existing Kotlin [IntArray] or Java int[].
     */
    constructor(from: IntArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_INT_32_ARRAY)
    }

    /**
     * Constructs a new [PackedInt32Array] from an existing Kotlin [Array<Int>].
     */
    constructor(from: Array<Int>) : this(from.toIntArray())

    /**
     * Constructs a new [PackedInt32Array] from an existing Kotlin [Collection<Int>].
     */
    constructor(from: Collection<Int>) : this(from.toIntArray())

    override fun toString(): String {
        return "PackedInt32Array(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedInt32Array) {
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

    fun toIntArray(): IntArray = Bridge.engine_convert_to_jvm(ptr)

    @Suppress("LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_INT_32_ARRAY
        override val elementVariantType = VariantCaster.INT

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

        external fun engine_convert_to_godot(array: IntArray): VoidPtr
        external fun engine_convert_to_jvm(_handle: VoidPtr): IntArray
    }
}

/**
 * Convert a [IntArray] into a Godot [PackedInt32Array], this call is optimised for a large amount of data.
 */
fun IntArray.toPackedInt32Array() = PackedInt32Array(this)

/**
 * Convert a [Array<Int>] into a Godot [PackedInt32Array], this call is optimised for a large amount of data.
 */
fun Array<Int>.toPackedInt32Array() = PackedInt32Array(this)

/**
 * Convert a [Collection<Int>] into a Godot [PackedInt32Array], this call is optimised for a large amount of data.
 */
fun Collection<Int>.toPackedInt32Array() = PackedInt32Array(this)

private fun Array<Int>.toIntArray(): IntArray =
    IntArray(size).also { intArray ->
        forEachIndexed { index, int ->
            intArray[index] = int
        }
    }

private fun Collection<Int>.toIntArray(): IntArray =
    IntArray(size).also { intArray ->
        forEachIndexed { index, int ->
            intArray[index] = int
        }
    }
