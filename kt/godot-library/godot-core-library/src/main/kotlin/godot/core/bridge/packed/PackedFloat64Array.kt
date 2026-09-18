@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedFloat64Array : PackedArray<PackedFloat64Array, Double> {
    override val bridge = Bridge

    //INTERNALS
    internal constructor(_handle: VoidPtr) {
        this.ptr = _handle
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_64_ARRAY)
    }

    //CONSTRUCTOR
    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_64_ARRAY)
    }

    /**
     * Constructs a [PackedFloat64Array] as a copy of the given [PackedFloat64Array].
     */
    constructor(from: PackedFloat64Array) {
        TransferContext.writeArguments(1) {
            VariantParser.PACKED_FLOAT_64_ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_64_ARRAY)
    }

    /**
     * Constructs a new [PackedFloat64Array] by converting a [VariantArray]<[Double]>.
     */
    constructor(from: VariantArray<Double>) {
        TransferContext.writeArguments(1) {
            VariantParser.ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_64_ARRAY)
    }

    /**
     * Constructs a new [PackedFloat64Array] from an existing Kotlin [DoubleArray] or Java double[].
     */
    constructor(from: DoubleArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_64_ARRAY)
    }

    /**
     * Constructs a new [PackedFloat64Array] from an existing Kotlin [Array<Double>].
     */
    constructor(from: Array<Double>) : this(from.toDoubleArray())

    /**
     * Constructs a new [PackedFloat64Array] from an existing Kotlin [Collection<Double>].
     */
    constructor(from: Collection<Double>) : this(from.toDoubleArray())

    override fun toString(): String {
        return "PackedFloat64Array(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedFloat64Array) {
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

    fun toDoubleArray(): DoubleArray = Bridge.engine_convert_to_jvm(ptr)

    @Suppress("LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_FLOAT_64_ARRAY
        override val elementVariantType = VariantParser.DOUBLE

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

        external fun engine_convert_to_godot(array: DoubleArray): VoidPtr
        external fun engine_convert_to_jvm(_handle: VoidPtr): DoubleArray
    }
}

/**
 * Convert a [DoubleArray] into a Godot [PackedFloat64Array], this call is optimised for a large amount of data.
 */
fun DoubleArray.toPackedFloat64Array() = PackedFloat64Array(this)

/**
 * Convert a [Array<Double>] into a Godot [PackedFloat64Array], this call is optimised for a large amount of data.
 */
fun Array<Double>.toPackedFloat64Array() = PackedFloat64Array(this)

/**
 * Convert a [Collection<Double>] into a Godot [PackedFloat64Array], this call is optimised for a large amount of data.
 */
fun Collection<Double>.toPackedFloat64Array() = PackedFloat64Array(this)

private fun Array<Double>.toDoubleArray(): DoubleArray =
    DoubleArray(size).also { doubleArray ->
        forEachIndexed { index, double ->
            doubleArray[index] = double
        }
    }

private fun Collection<Double>.toDoubleArray(): DoubleArray =
    DoubleArray(size).also { doubleArray ->
        forEachIndexed { index, double ->
            doubleArray[index] = double
        }
    }
