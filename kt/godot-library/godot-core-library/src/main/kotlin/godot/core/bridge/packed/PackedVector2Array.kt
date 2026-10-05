@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedVector2Array : PackedArray<PackedVector2Array, Vector2> {

    override val bridge = Bridge

    //INTERNALS
    internal constructor(@Suppress("LocalVariableName") _handle: VoidPtr) {
        this.ptr = _handle
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR2_ARRAY)
    }

    //CONSTRUCTOR
    constructor() {
        ptr = bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR2_ARRAY)
    }

    /**
     * Constructs a [PackedVector2Array] as a copy of the given [PackedVector2Array].
     */
    constructor(from: PackedVector2Array) {
        TransferContext.writeArguments(1) {
            VariantParser.PACKED_VECTOR2_ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR2_ARRAY)
    }

    /**
     * Constructs a new [PackedVector2Array] by converting a [VariantArray]<[Vector2]>.
     */
    constructor(from: VariantArray<Vector2>) {
        TransferContext.writeArguments(1) {
            VariantParser.ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR2_ARRAY)
    }

    /**
     * Constructs a new [PackedVector2Array] from an existing Kotlin [Array<Vector2>].
     */
    constructor(from: Array<Vector2>) : this(from.toPackedVector2FloatArray())

    /**
     * Constructs a new [PackedVector2Array] from an existing Kotlin [Collection<Vector2>].
     */
    constructor(from: Collection<Vector2>) : this(from.toPackedVector2FloatArray())

    private constructor(from: FloatArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR2_ARRAY)
    }

    override fun toString(): String {
        return "PoolVector2Array(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedVector2Array) {
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

    fun toVector2Array(): Array<Vector2> {
        val floatArray = Bridge.engine_convert_to_jvm(ptr)
        return Array<Vector2>(floatArray.size / 2) { vectorIndex ->
            val floatIndex = vectorIndex * 2
            Vector2(
                floatArray[floatIndex],
                floatArray[floatIndex + 1]
            )
        }
    }

    @Suppress("LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_VECTOR2_ARRAY
        override val elementVariantType = VariantParser.VECTOR2

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
 * Convert a [Array<Vector2>] into a Godot [PackedVector2Array], this call is optimised for a large amount of data.
 */
fun Array<Vector2>.toPackedVector2Array() = PackedVector2Array(this)


/**
 * Convert a [Collection<Vector2>] into a Godot [PackedVector2Array], this call is optimised for a large amount of data.
 */
fun Collection<Vector2>.toPackedVector2Array() = PackedVector2Array(this)

private fun Array<Vector2>.toPackedVector2FloatArray(): FloatArray =
    FloatArray(size * 2).also { floatArray ->
        forEachIndexed { index, vector ->
            val floatIndex = index * 2
            floatArray[floatIndex] = vector.x.toFloat()
            floatArray[floatIndex + 1] = vector.y.toFloat()
        }
    }

private fun Collection<Vector2>.toPackedVector2FloatArray(): FloatArray =
    FloatArray(size * 2).also { floatArray ->
        forEachIndexed { index, vector ->
            val floatIndex = index * 2
            floatArray[floatIndex] = vector.x.toFloat()
            floatArray[floatIndex + 1] = vector.y.toFloat()
        }
    }
