package godot.core

import godot.api.Object
import godot.common.interop.ObjectID
import godot.common.interop.VariantConverter
import godot.common.interop.nullptr
import godot.common.util.toRealT
import godot.internal.memory.LongStringQueue
import java.nio.ByteBuffer

private var ByteBuffer.bool: Boolean
    get() = int == 1
    set(value) {
        putInt(if (value) 1 else 0)
    }

private var ByteBuffer.vector2: Vector2
    get() = Vector2(float.toRealT(), float.toRealT())
    set(value) {
        putFloat(value.x.toFloat())
        putFloat(value.y.toFloat())
    }

private var ByteBuffer.vector2i: Vector2i
    get() = Vector2i(int, int)
    set(value) {
        putInt(value.x)
        putInt(value.y)
    }

private var ByteBuffer.vector3: Vector3
    get() = Vector3(float.toRealT(), float.toRealT(), float.toRealT())
    set(value) {
        putFloat(value.x.toFloat())
        putFloat(value.y.toFloat())
        putFloat(value.z.toFloat())
    }

private var ByteBuffer.vector3i: Vector3i
    get() = Vector3i(int, int, int)
    set(value) {
        putInt(value.x)
        putInt(value.y)
        putInt(value.z)
    }

private var ByteBuffer.vector4: Vector4
    get() = Vector4(float.toRealT(), float.toRealT(), float.toRealT(), float.toRealT())
    set(value) {
        putFloat(value.x.toFloat())
        putFloat(value.y.toFloat())
        putFloat(value.z.toFloat())
        putFloat(value.w.toFloat())
    }

private var ByteBuffer.vector4i: Vector4i
    get() = Vector4i(int, int, int, int)
    set(value) {
        putInt(value.x)
        putInt(value.y)
        putInt(value.z)
        putInt(value.w)
    }

private var ByteBuffer.basis: Basis
    get() = Basis().also {
        it._x = vector3
        it._y = vector3
        it._z = vector3
    }
    set(value) {
        vector3 = value._x
        vector3 = value._y
        vector3 = value._z
    }

private var ByteBuffer.stringName: StringName
    get() = StringName(long)
    set(value) {
        toGodotNativeCoreType<StringName>(this, value)
    }

private var ByteBuffer.obj: KtObject?
    get() {
        val constructorIndex = int
        val ptr = long
        val id = long

        if (ptr == nullptr) {
            return null
        }

        return KtObject.getOrCreate(ptr, ObjectID(id), constructorIndex)
    }
    set(value) {
        putLong(value?.ptr ?: nullptr)
    }

private var ByteBuffer.variantType: Int
    get() = int
    set(value) {
        putInt(value)
    }

/**
 * The raw codec of every Godot Variant type, one object per [id]. Sealed rather than an enum so each entry can carry
 * the JVM type it produces.
 */
sealed class VariantParser<out T>(override val id: Int) : VariantConverter<T> {
    data object NIL : VariantParser<Unit>(0) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = Unit
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {}
    }

    // atomic types
    data object BOOL : VariantParser<Boolean>(1) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.bool
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Boolean)
            buffer.bool = any
        }
    }
    data object LONG : VariantParser<Long>(2) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.long
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Long)
            buffer.putLong(any)
        }
    }
    data object DOUBLE : VariantParser<Double>(3) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.double
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Double)
            buffer.putDouble(any)
        }
    }
    data object STRING : VariantParser<String>(4) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): String {
            val isLong = buffer.bool
            return if (isLong) {
                LongStringQueue.pollString()
            } else {
                /**
                 *  A CString is read from the buffer, they all end with a 0 character except if the String is empty
                 *  "" has a size of 0, but "a" has a size of 2.
                 *  We only read the buffer if the size is superior to 0.
                 *  When it's the case, we create a string without the last 0 character.
                 */
                val stringSize = buffer.int
                if (stringSize == 0) {
                    String()
                } else {
                    val charArray = ByteArray(stringSize)
                    buffer.get(charArray, 0, stringSize)
                    String(charArray, 0, stringSize - 1, Charsets.UTF_8)
                }
            }
        }

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is String)
            val stringBytes = any.encodeToByteArray()
            if (stringBytes.size > LongStringQueue.stringMaxSize) {
                buffer.bool = true
                LongStringQueue.sendStringToCPP(any)
            } else {
                buffer.bool = false
                buffer.putInt(stringBytes.size)
                buffer.put(stringBytes)
            }
        }
    }

    // math types
    data object VECTOR2 : VariantParser<Vector2>(5) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.vector2
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Vector2)
            buffer.vector2 = any
        }
    }
    data object VECTOR2I : VariantParser<Vector2i>(6) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.vector2i
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Vector2i)
            buffer.vector2i = any
        }
    }
    data object RECT2 : VariantParser<Rect2>(7) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = Rect2(
            buffer.vector2,
            buffer.vector2
        )

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Rect2)
            buffer.vector2 = any._position
            buffer.vector2 = any._size
        }
    }
    data object RECT2I : VariantParser<Rect2i>(8) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = Rect2i(
            buffer.vector2i,
            buffer.vector2i
        )

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Rect2i)
            buffer.vector2i = any._position
            buffer.vector2i = any._size
        }
    }
    data object VECTOR3 : VariantParser<Vector3>(9) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.vector3
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Vector3)
            buffer.vector3 = any
        }
    }
    data object VECTOR3I : VariantParser<Vector3i>(10) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.vector3i
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Vector3i)
            buffer.vector3i = any
        }
    }
    data object TRANSFORM2D : VariantParser<Transform2D>(11) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): Transform2D {
            val x = buffer.vector2
            val y = buffer.vector2
            val origin = buffer.vector2
            return Transform2D(x, y, origin)
        }

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Transform2D)
            buffer.vector2 = any._x
            buffer.vector2 = any._y
            buffer.vector2 = any.origin
        }
    }
    data object VECTOR4 : VariantParser<Vector4>(12) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.vector4
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Vector4)
            buffer.vector4 = any
        }
    }
    data object VECTOR4I : VariantParser<Vector4i>(13) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.vector4i
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Vector4i)
            buffer.vector4i = any
        }
    }
    data object PLANE : VariantParser<Plane>(14) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): Plane {
            val normal = buffer.vector3
            val d = buffer.float.toRealT()
            return Plane(normal, d)
        }

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Plane)
            buffer.vector3 = any._normal
            buffer.putFloat(any.d.toFloat())
        }
    }
    data object QUATERNION : VariantParser<Quaternion>(15) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): Quaternion {
            val x = buffer.float.toRealT()
            val y = buffer.float.toRealT()
            val z = buffer.float.toRealT()
            val w = buffer.float.toRealT()

            return Quaternion(x, y, z, w)
        }

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Quaternion)
            buffer.putFloat(any.x.toFloat())
            buffer.putFloat(any.y.toFloat())
            buffer.putFloat(any.z.toFloat())
            buffer.putFloat(any.w.toFloat())
        }
    }
    data object AABB : VariantParser<godot.core.AABB>(16) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): godot.core.AABB {
            val position = buffer.vector3
            val size = buffer.vector3
            return godot.core.AABB(position, size)
        }

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is godot.core.AABB)
            buffer.vector3 = any._position
            buffer.vector3 = any._size
        }
    }
    data object BASIS : VariantParser<Basis>(17) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.basis
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Basis)
            buffer.basis = any
        }
    }
    data object TRANSFORM3D : VariantParser<Transform3D>(18) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): Transform3D {
            val basis = buffer.basis
            val origin = buffer.vector3
            return Transform3D(basis, origin)
        }

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Transform3D)
            buffer.basis = any._basis
            buffer.vector3 = any._origin
        }
    }
    data object PROJECTION : VariantParser<Projection>(19) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = Projection(
            buffer.vector4,
            buffer.vector4,
            buffer.vector4,
            buffer.vector4
        )

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Projection)
            buffer.vector4 = any._x
            buffer.vector4 = any._y
            buffer.vector4 = any._z
            buffer.vector4 = any._w
        }
    }

    // misc types
    data object COLOR : VariantParser<Color>(20) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = Color(buffer.float, buffer.float, buffer.float, buffer.float)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Color)
            buffer.putFloat(any.r.toFloat())
            buffer.putFloat(any.g.toFloat())
            buffer.putFloat(any.b.toFloat())
            buffer.putFloat(any.a.toFloat())
        }
    }
    data object STRING_NAME : VariantParser<StringName>(21) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.stringName
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is StringName)
            buffer.stringName = any
        }
    }
    data object NODE_PATH : VariantParser<NodePath>(22) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = NodePath(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) = toGodotNativeCoreType<NodePath>(buffer, any)
    }
    data object _RID : VariantParser<RID>(23) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = RID(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is RID)
            buffer.putLong(any.id)
        }
    }
    data object OBJECT : VariantParser<KtObject?>(24) {
        override fun toKotlin(buffer: ByteBuffer): KtObject? {
            val idInBuffer = buffer.variantType
            // Godot can sometimes send null pointer as NIL variant, so we need to test for that case.
            if (idInBuffer == NIL.id) {
                return null
            }
            checkType(idInBuffer)
            return toUnsafeKotlin(buffer)
        }

        override fun toUnsafeKotlin(buffer: ByteBuffer) = buffer.obj
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is KtObject?)
            buffer.obj = any
        }
    }
    data object CALLABLE : VariantParser<VariantCallable>(25) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = VariantCallable(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Callable)
            // Be careful that ::toNativeCallable doesn't itself use the shared buffer.
            buffer.putLong(any.toNativeCallable().ptr)
        }
    }
    data object SIGNAL : VariantParser<Signal>(26) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): Signal {
            val obj = buffer.obj
            val name = buffer.stringName
            require(obj is Object)
            return Signal(obj, name)
        }

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) {
            require(any is Signal)
            buffer.obj = any.godotObject
            buffer.stringName = any.name
        }
    }
    data object DICTIONARY : VariantParser<Dictionary<*, *>>(27) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): Dictionary<*, *> = Dictionary<Any?, Any?>(buffer.long)

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<Dictionary<Any, Any?>>(buffer, any)
    }
    data object ARRAY : VariantParser<VariantArray<*>>(28) {
        override fun toUnsafeKotlin(buffer: ByteBuffer): VariantArray<*> = VariantArray<Any?>(buffer.long)

        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<VariantArray<Any?>>(buffer, any)
    }

    // PackedArray
    data object PACKED_BYTE_ARRAY : VariantParser<PackedByteArray>(29) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedByteArray(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) = toGodotNativeCoreType<PackedByteArray>(buffer, any)
    }
    data object PACKED_INT_32_ARRAY : VariantParser<PackedInt32Array>(30) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedInt32Array(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) = toGodotNativeCoreType<PackedInt32Array>(buffer, any)
    }
    data object PACKED_INT_64_ARRAY : VariantParser<PackedInt64Array>(31) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedInt64Array(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) = toGodotNativeCoreType<PackedInt64Array>(buffer, any)
    }
    data object PACKED_FLOAT_32_ARRAY : VariantParser<PackedFloat32Array>(32) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedFloat32Array(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<PackedFloat32Array>(buffer, any)
    }
    data object PACKED_FLOAT_64_ARRAY : VariantParser<PackedFloat64Array>(33) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedFloat64Array(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<PackedFloat64Array>(buffer, any)
    }
    data object PACKED_STRING_ARRAY : VariantParser<PackedStringArray>(34) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedStringArray(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<PackedStringArray>(buffer, any)
    }
    data object PACKED_VECTOR2_ARRAY : VariantParser<PackedVector2Array>(35) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedVector2Array(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<PackedVector2Array>(buffer, any)
    }
    data object PACKED_VECTOR3_ARRAY : VariantParser<PackedVector3Array>(36) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedVector3Array(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<PackedVector3Array>(buffer, any)
    }
    data object PACKED_COLOR_ARRAY : VariantParser<PackedColorArray>(37) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedColorArray(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) = toGodotNativeCoreType<PackedColorArray>(buffer, any)
    }
    data object PACKED_VECTOR4_ARRAY : VariantParser<PackedVector4Array>(38) {
        override fun toUnsafeKotlin(buffer: ByteBuffer) = PackedVector4Array(buffer.long)
        override fun toUnsafeGodot(buffer: ByteBuffer, any: Any?) =
            toGodotNativeCoreType<PackedVector4Array>(buffer, any)
    }

    override fun toKotlin(buffer: ByteBuffer): T {
        checkType(buffer.variantType)
        return toUnsafeKotlin(buffer)
    }

    internal fun checkType(idInBuffer: Int) {
        if (idInBuffer != id) {
            throw TypeCastException(
                "Shared Buffer Error: JVM expected a ${this::class.simpleName} but received a ${from(idInBuffer.toLong())}."
            )
        }
    }

    override fun toGodot(buffer: ByteBuffer, any: Any?) {
        buffer.variantType = id
        toUnsafeGodot(buffer, any)
    }

    abstract fun toUnsafeKotlin(buffer: ByteBuffer): T
    abstract fun toUnsafeGodot(buffer: ByteBuffer, any: Any?)

    companion object {
        /** Every parser indexed by its Variant type id, the order Godot uses on the shared buffer. */
        val entries: Array<VariantParser<*>> = arrayOf(NIL, BOOL, LONG, DOUBLE, STRING, VECTOR2, VECTOR2I, RECT2, RECT2I, VECTOR3, VECTOR3I, TRANSFORM2D, VECTOR4, VECTOR4I, PLANE, QUATERNION, AABB, BASIS, TRANSFORM3D, PROJECTION, COLOR, STRING_NAME, NODE_PATH, _RID, OBJECT, CALLABLE, SIGNAL, DICTIONARY, ARRAY, PACKED_BYTE_ARRAY, PACKED_INT_32_ARRAY, PACKED_INT_64_ARRAY, PACKED_FLOAT_32_ARRAY, PACKED_FLOAT_64_ARRAY, PACKED_STRING_ARRAY, PACKED_VECTOR2_ARRAY, PACKED_VECTOR3_ARRAY, PACKED_COLOR_ARRAY, PACKED_VECTOR4_ARRAY)

        fun from(value: Long) = entries[value.toInt()]
    }
}

/** Converters layered on a [VariantParser]: the same Variant type on the buffer, a different JVM type on this side. */
sealed class VariantCaster<out T>(val coreVariant: VariantParser<*>) : VariantConverter<T> {
    override val id by coreVariant::id

    sealed class VariantSimpleCaster<out T>(coreVariant: VariantParser<*>) : VariantCaster<T>(coreVariant) {
        override fun toKotlin(buffer: ByteBuffer) = toKotlinCast(coreVariant.toKotlin(buffer))
        override fun toGodot(buffer: ByteBuffer, any: Any?) = coreVariant.toGodot(buffer, toGodotCast(any))

        abstract fun toKotlinCast(any: Any?): T
        abstract fun toGodotCast(any: Any?): Any?
    }

    data object BYTE : VariantSimpleCaster<Byte>(VariantParser.LONG) {
        override fun toKotlinCast(any: Any?) = (any as Long).toByte()
        override fun toGodotCast(any: Any?) = (any as Byte).toLong()
    }

    data object INT : VariantSimpleCaster<Int>(VariantParser.LONG) {
        override fun toKotlinCast(any: Any?) = (any as Long).toInt()
        override fun toGodotCast(any: Any?) = (any as Int).toLong()
    }

    class ENUM<ENUM_TYPE : Enum<ENUM_TYPE>>(private val entries: Array<ENUM_TYPE>) : VariantSimpleCaster<ENUM_TYPE>(VariantParser.LONG) {
        private val entryMap: Map<Long, ENUM_TYPE> = entries.associateBy { it.godotValue }

        override fun toKotlinCast(any: Any?) = requireNotNull(entryMap[any as Long]) {
            "No enum entry with godotValue $any found in entries: [${entries.joinToString()}]"
        }

        @Suppress("UNCHECKED_CAST")
        override fun toGodotCast(any: Any?) = (any as ENUM_TYPE).godotValue
    }

    data object FLOAT : VariantSimpleCaster<Float>(VariantParser.DOUBLE) {
        override fun toKotlinCast(any: Any?) = (any as Double).toFloat()
        override fun toGodotCast(any: Any?) = (any as Float).toDouble()
    }

    /**
     * The [VariantArray] converter. Godot only knows its own builtin element types (an int array is a `Long` array),
     * so the element type declared by the engine is never trusted: an array coming from Godot gets [elementConverter],
     * the converter the JVM declared for its elements (`Int`, `Byte`, an enum, a nested typed container...).
     * Untyped arrays use [ANY].
     */
    class TYPED_ARRAY<T>(val elementConverter: VariantConverter<T>) : VariantCaster<VariantArray<T>>(VariantParser.ARRAY) {
        override fun toKotlin(buffer: ByteBuffer): VariantArray<T> {
            coreVariant.checkType(buffer.variantType)
            return VariantArray(buffer.long, elementConverter)
        }

        override fun toGodot(buffer: ByteBuffer, any: Any?) = coreVariant.toGodot(buffer, any)
    }

    /** The [Dictionary] converter, see [TYPED_ARRAY]. */
    class TYPED_DICTIONARY<K, V>(val keyConverter: VariantConverter<K>, val valueConverter: VariantConverter<V>) :
        VariantCaster<Dictionary<K, V>>(VariantParser.DICTIONARY) {
        override fun toKotlin(buffer: ByteBuffer): Dictionary<K, V> {
            coreVariant.checkType(buffer.variantType)
            return Dictionary(buffer.long, keyConverter, valueConverter)
        }

        override fun toGodot(buffer: ByteBuffer, any: Any?) = coreVariant.toGodot(buffer, any)
    }

    // It can seem weird for ANY to have a NIL id, which is the opposite concept. But that's how Godot works.
    // Each parameter, property, or return type of Variant type actually uses a PropertyUsageFlag named NIL_IS_VARIANT.
    // https://docs.godotengine.org/en/stable/classes/class_%40globalscope.html#enum-globalscope-propertyusageflags
    data object ANY : VariantCaster<Any?>(VariantParser.NIL) {
        override fun toKotlin(buffer: ByteBuffer): Any? {
            val expectedType = buffer.variantType
            return VariantParser.entries[expectedType].toUnsafeKotlin(buffer)
        }

        override fun toGodot(buffer: ByteBuffer, any: Any?) {
            if (any === null) {
                VariantParser.NIL.toGodot(buffer, null)
            } else {
                val type = getVariantConverter(any::class)
                    ?: throw UnsupportedOperationException("Can't convert type ${any::class} to Variant")
                type.toGodot(buffer, any)
            }
        }
    }
}

private inline fun <reified T : NativeCoreType> toGodotNativeCoreType(buffer: ByteBuffer, any: Any?) {
    require(any is T)
    buffer.putLong(any.ptr)
}

