@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr
import godot.core.PackedVector2Array

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedVector3Array : PackedArray<PackedVector3Array, Vector3> {

    override val bridge = Bridge

    //INTERNALS
    internal constructor(_handle: VoidPtr) {
        this.ptr = _handle
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR3_ARRAY)
    }

    //CONSTRUCTOR
    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR3_ARRAY)
    }

    /**
     * Constructs a [PackedVector3Array] as a copy of the given [PackedVector3Array].
     */
    constructor(from: PackedVector3Array) {
        TransferContext.writeArguments(1) {
            VariantParser.PACKED_VECTOR3_ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR3_ARRAY)
    }

    /**
     * Constructs a new [PackedVector3Array] by converting a [VariantArray]<[Vector3]>.
     */
    constructor(from: VariantArray<Vector3>) {
        TransferContext.writeArguments(1) {
            VariantParser.ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR3_ARRAY)
    }

    /**
     * Constructs a new [PackedVector3Array] from an existing Kotlin [Array<Vector3>].
     */
    constructor(from: Array<Vector3>) : this(from.toPackedVector3FloatArray())

    /**
     * Constructs a new [PackedVector3Array] from an existing Kotlin [Collection<Vector3>].
     */
    constructor(from: Collection<Vector3>) : this(from.toPackedVector3FloatArray())

    private constructor(from: FloatArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_VECTOR3_ARRAY)
    }

    override fun toString(): String {
        return "PoolVector3Array(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedVector3Array) {
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

    fun toVector3Array(): Array<Vector3> {
        val floatArray = Bridge.engine_convert_to_jvm(ptr)
        return Array<Vector3>(floatArray.size / 3) { vectorIndex ->
            val floatIndex = vectorIndex * 3
            Vector3(
                floatArray[floatIndex],
                floatArray[floatIndex + 1],
                floatArray[floatIndex + 2]
            )
        }
    }

    @Suppress("LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_VECTOR3_ARRAY
        override val elementVariantType = VariantParser.VECTOR3

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
 * Convert a [Array<Vector3>] into a Godot [PackedVector3Array], this call is optimised for a large amount of data.
 */
fun Array<Vector3>.toPackedVector3Array() = PackedVector3Array(this)


/**
 * Convert a [Collection<Vector3>] into a Godot [PackedVector3Array], this call is optimised for a large amount of data.
 */
fun Collection<Vector3>.toPackedVector3Array() = PackedVector3Array(this)

private fun Array<Vector3>.toPackedVector3FloatArray(): FloatArray =
    FloatArray(size * 3).also { floatArray ->
        forEachIndexed { index, vector ->
            val floatIndex = index * 3
            floatArray[floatIndex] = vector.x.toFloat()
            floatArray[floatIndex + 1] = vector.y.toFloat()
            floatArray[floatIndex + 2] = vector.z.toFloat()
        }
    }

private fun Collection<Vector3>.toPackedVector3FloatArray(): FloatArray =
    FloatArray(size * 3).also { floatArray ->
        forEachIndexed { index, vector ->
            val floatIndex = index * 3
            floatArray[floatIndex] = vector.x.toFloat()
            floatArray[floatIndex + 1] = vector.y.toFloat()
            floatArray[floatIndex + 2] = vector.z.toFloat()
        }
    }
