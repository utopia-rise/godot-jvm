@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedFloat32Array : PackedArray<PackedFloat32Array, Float> {
    override val bridge = Bridge

    //INTERNALS
    internal constructor(_handle: VoidPtr) {
        this.ptr = _handle
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_32_ARRAY)
    }

    //CONSTRUCTOR
    /**
     * Constructs an empty [PackedFloat32Array].
     */
    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_32_ARRAY)
    }

    /**
     * Constructs a [PackedFloat32Array] as a copy of the given [PackedFloat32Array].
     */
    constructor(from: PackedFloat32Array) {
        TransferContext.writeArguments(1) {
            VariantParser.PACKED_FLOAT_32_ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_32_ARRAY)
    }

    /**
     * Constructs a new [PackedFloat32Array] by converting a [VariantArray]<[Float]>.
     */
    constructor(from: VariantArray<Float>) {
        TransferContext.writeArguments(1) {
            VariantParser.ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_32_ARRAY)
    }

    /**
     * Constructs a new [PackedFloat32Array] from an existing Kotlin [FloatArray] or Java float[].
     */
    constructor(from: FloatArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_FLOAT_32_ARRAY)
    }

    /**
     * Constructs a new [PackedFloat32Array] from an existing Kotlin [Array<Float>].
     */
    constructor(from: Array<Float>) : this(from.toFloatArray())

    /**
     * Constructs a new [PackedFloat32Array] from an existing Kotlin [Collection<Float>].
     */
    constructor(from: Collection<Float>) : this(from.toFloatArray())

    override fun toString(): String {
        return "PackedFloat32Array(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedFloat32Array) {
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

    fun toFloatArray(): FloatArray = Bridge.engine_convert_to_jvm(ptr)

    @Suppress("LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_FLOAT_32_ARRAY
        override val elementVariantType = VariantCaster.FLOAT

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

        external fun engine_convert_to_godot(array: FloatArray): VoidPtr
        external fun engine_convert_to_jvm(_handle: VoidPtr): FloatArray
    }
}

/**
 * Convert a [FloatArray] into a Godot [PackedFloat32Array], this call is optimised for a large amount of data.
 */
fun FloatArray.toPackedFloat32Array() = PackedFloat32Array(this)

/**
 * Convert a [Array<Float>] into a Godot [PackedFloat32Array], this call is optimised for a large amount of data.
 */
fun Array<Float>.toPackedFloat32Array() = PackedFloat32Array(this)

/**
 * Convert a [Collection<Float>] into a Godot [PackedFloat32Array], this call is optimised for a large amount of data.
 */
fun Collection<Float>.toPackedFloat32Array() = PackedFloat32Array(this)

private fun Array<Float>.toFloatArray(): FloatArray =
    FloatArray(size).also { floatArray ->
        forEachIndexed { index, float ->
            floatArray[index] = float
        }
    }

private fun Collection<Float>.toFloatArray(): FloatArray =
    FloatArray(size).also { floatArray ->
        forEachIndexed { index, float ->
            floatArray[index] = float
        }
    }
