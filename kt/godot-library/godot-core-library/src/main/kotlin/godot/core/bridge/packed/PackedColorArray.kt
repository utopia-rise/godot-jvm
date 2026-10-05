@file:Suppress("PackageDirectoryMismatch")

package godot.core

import godot.internal.memory.MemoryManager
import godot.internal.memory.TransferContext
import godot.common.interop.VoidPtr

@Suppress("MemberVisibilityCanBePrivate", "unused")
class PackedColorArray : PackedArray<PackedColorArray, Color> {

    override val bridge = Bridge

    // INTERNALS
    internal constructor(_handle: VoidPtr) {
        this.ptr = _handle
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_COLOR_ARRAY)
    }

    //CONSTRUCTOR
    constructor() {
        ptr = Bridge.engine_call_constructor()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_COLOR_ARRAY)
    }

    /**
     * Constructs a [PackedColorArray] as a copy of the given [PackedColorArray].
     */
    constructor(from: PackedColorArray) {
        TransferContext.writeArguments(1) {
            VariantParser.PACKED_COLOR_ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_packed_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_COLOR_ARRAY)
    }

    /**
     * Constructs a new [PackedColorArray] by converting a [VariantArray]<[Color]>.
     */
    constructor(from: VariantArray<Color>) {
        TransferContext.writeArguments(1) {
            VariantParser.ARRAY.toGodot(from)
        }
        ptr = Bridge.engine_call_constructor_array()
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_COLOR_ARRAY)
    }

    /**
     * Constructs a new [PackedColorArray] from an existing Kotlin [Array<Color>].
     */
    constructor(from: Array<Color>) : this(from.toPackedColorFloatArray())

    /**
     * Constructs a new [PackedColorArray] from an existing Kotlin [Collection<Color>].
     */
    constructor(from: Collection<Color>) : this(from.toPackedColorFloatArray())

    private constructor(from: FloatArray) {
        ptr = Bridge.engine_convert_to_godot(from)
        MemoryManager.registerNativeCoreType(this, VariantParser.PACKED_COLOR_ARRAY)
    }

    override fun toString(): String {
        return "PackedColorArray(${size})"
    }

    /**
     * WARNING: no equals function is available in the Gdnative API for this Coretype.
     * This methods implementation works but is not the fastest one.
     */
    override fun equals(other: Any?): Boolean {
        return if (other is PackedColorArray) {
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

    fun toColorArray(): Array<Color> {
        val floatArray = Bridge.engine_convert_to_jvm(ptr)
        return Array<Color>(floatArray.size / 4) { colorIndex ->
            val floatIndex = colorIndex * 4
            Color(
                floatArray[floatIndex],
                floatArray[floatIndex + 1],
                floatArray[floatIndex + 2],
                floatArray[floatIndex + 3]
            )
        }
    }

    @Suppress("LocalVariableName")
    internal object Bridge : PackedArrayBridge {
        override val packedArrayVariantType = VariantParser.PACKED_COLOR_ARRAY
        override val elementVariantType = VariantParser.COLOR

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
 * Convert a [Array<Color>] into a Godot [PackedColorArray], this call is optimised for a large amount of data.
 */
fun Array<Color>.toPackedColorArray() = PackedColorArray(this)

/**
 * Convert a [Collection<Color>] into a Godot [PackedColorArray], this call is optimised for a large amount of data.
 */
fun Collection<Color>.toPackedColorArray() = PackedColorArray(this)

private fun Array<Color>.toPackedColorFloatArray(): FloatArray =
    FloatArray(size * 4).also { floatArray ->
        forEachIndexed { index, color ->
            val floatIndex = index * 4
            floatArray[floatIndex] = color.r.toFloat()
            floatArray[floatIndex + 1] = color.g.toFloat()
            floatArray[floatIndex + 2] = color.b.toFloat()
            floatArray[floatIndex + 3] = color.a.toFloat()
        }
    }

private fun Collection<Color>.toPackedColorFloatArray(): FloatArray =
    FloatArray(size * 4).also { floatArray ->
        forEachIndexed { index, color ->
            val floatIndex = index * 4
            floatArray[floatIndex] = color.r.toFloat()
            floatArray[floatIndex + 1] = color.g.toFloat()
            floatArray[floatIndex + 2] = color.b.toFloat()
            floatArray[floatIndex + 3] = color.a.toFloat()
        }
    }
