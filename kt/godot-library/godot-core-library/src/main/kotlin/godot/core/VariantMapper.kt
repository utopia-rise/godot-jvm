package godot.core

import godot.common.interop.VariantConverter
import godot.common.util.isNullable
import kotlin.reflect.KClass

private val coreVariantMappings: Map<Class<*>, VariantConverter<*>> = mapOf(
    Unit::class.java to VariantParser.NIL,
    Void::class.java to VariantParser.NIL,
    Void.TYPE to VariantParser.NIL,
    Any::class.java to VariantCaster.ANY,
    BitField::class.java to VariantCaster.BITFIELD,
    Boolean::class.java to VariantParser.BOOL,
    Boolean::class.javaObjectType to VariantParser.BOOL,
    Byte::class.java to VariantCaster.BYTE,
    Byte::class.javaObjectType to VariantCaster.BYTE,
    Short::class.java to VariantCaster.SHORT,
    Short::class.javaObjectType to VariantCaster.SHORT,
    Char::class.java to VariantCaster.CHAR,
    Char::class.javaObjectType to VariantCaster.CHAR,
    Int::class.java to VariantCaster.INT,
    Int::class.javaObjectType to VariantCaster.INT,
    Long::class.java to VariantParser.LONG,
    Long::class.javaObjectType to VariantParser.LONG,
    Float::class.java to VariantCaster.FLOAT,
    Float::class.javaObjectType to VariantCaster.FLOAT,
    Double::class.java to VariantParser.DOUBLE,
    Double::class.javaObjectType to VariantParser.DOUBLE,
    String::class.java to VariantParser.STRING,
    AABB::class.java to VariantParser.AABB,
    Basis::class.java to VariantParser.BASIS,
    Color::class.java to VariantParser.COLOR,
    StringName::class.java to VariantParser.STRING_NAME,
    Dictionary::class.java to VariantCaster.TYPED_DICTIONARY(VariantCaster.ANY, VariantCaster.ANY),
    VariantArray::class.java to VariantCaster.TYPED_ARRAY(VariantCaster.ANY),
    Plane::class.java to VariantParser.PLANE,
    NodePath::class.java to VariantParser.NODE_PATH,
    Quaternion::class.java to VariantParser.QUATERNION,
    Rect2::class.java to VariantParser.RECT2,
    Rect2i::class.java to VariantParser.RECT2I,
    RID::class.java to VariantParser._RID,
    Transform3D::class.java to VariantParser.TRANSFORM3D,
    Transform2D::class.java to VariantParser.TRANSFORM2D,
    Vector2::class.java to VariantParser.VECTOR2,
    Vector2i::class.java to VariantParser.VECTOR2I,
    Vector3::class.java to VariantParser.VECTOR3,
    Vector3i::class.java to VariantParser.VECTOR3I,
    Vector4::class.java to VariantParser.VECTOR4,
    Vector4i::class.java to VariantParser.VECTOR4I,
    Projection::class.java to VariantParser.PROJECTION,
    VariantCallable::class.java to VariantParser.CALLABLE,
    MethodCallable::class.java to VariantParser.CALLABLE,
    MethodCallable0::class.java to VariantParser.CALLABLE,
    MethodCallable1::class.java to VariantParser.CALLABLE,
    MethodCallable2::class.java to VariantParser.CALLABLE,
    MethodCallable3::class.java to VariantParser.CALLABLE,
    MethodCallable4::class.java to VariantParser.CALLABLE,
    MethodCallable5::class.java to VariantParser.CALLABLE,
    MethodCallable6::class.java to VariantParser.CALLABLE,
    MethodCallable7::class.java to VariantParser.CALLABLE,
    MethodCallable8::class.java to VariantParser.CALLABLE,
    MethodCallable9::class.java to VariantParser.CALLABLE,
    MethodCallable10::class.java to VariantParser.CALLABLE,
    MethodCallable11::class.java to VariantParser.CALLABLE,
    MethodCallable12::class.java to VariantParser.CALLABLE,
    MethodCallable13::class.java to VariantParser.CALLABLE,
    MethodCallable14::class.java to VariantParser.CALLABLE,
    MethodCallable15::class.java to VariantParser.CALLABLE,
    MethodCallable16::class.java to VariantParser.CALLABLE,
    LambdaCallable::class.java to VariantParser.CALLABLE,
    LambdaCallable0::class.java to VariantParser.CALLABLE,
    LambdaCallable1::class.java to VariantParser.CALLABLE,
    LambdaCallable2::class.java to VariantParser.CALLABLE,
    LambdaCallable3::class.java to VariantParser.CALLABLE,
    LambdaCallable4::class.java to VariantParser.CALLABLE,
    LambdaCallable5::class.java to VariantParser.CALLABLE,
    LambdaCallable6::class.java to VariantParser.CALLABLE,
    LambdaCallable7::class.java to VariantParser.CALLABLE,
    LambdaCallable8::class.java to VariantParser.CALLABLE,
    LambdaCallable9::class.java to VariantParser.CALLABLE,
    LambdaCallable10::class.java to VariantParser.CALLABLE,
    LambdaCallable11::class.java to VariantParser.CALLABLE,
    LambdaCallable12::class.java to VariantParser.CALLABLE,
    LambdaCallable13::class.java to VariantParser.CALLABLE,
    LambdaCallable14::class.java to VariantParser.CALLABLE,
    LambdaCallable15::class.java to VariantParser.CALLABLE,
    LambdaCallable16::class.java to VariantParser.CALLABLE,
    Signal::class.java to VariantParser.SIGNAL,
    Signal0::class.java to VariantParser.SIGNAL,
    Signal1::class.java to VariantParser.SIGNAL,
    Signal2::class.java to VariantParser.SIGNAL,
    Signal3::class.java to VariantParser.SIGNAL,
    Signal4::class.java to VariantParser.SIGNAL,
    Signal5::class.java to VariantParser.SIGNAL,
    Signal6::class.java to VariantParser.SIGNAL,
    Signal7::class.java to VariantParser.SIGNAL,
    Signal8::class.java to VariantParser.SIGNAL,
    Signal9::class.java to VariantParser.SIGNAL,
    Signal10::class.java to VariantParser.SIGNAL,
    Signal11::class.java to VariantParser.SIGNAL,
    Signal12::class.java to VariantParser.SIGNAL,
    Signal13::class.java to VariantParser.SIGNAL,
    Signal14::class.java to VariantParser.SIGNAL,
    Signal15::class.java to VariantParser.SIGNAL,
    Signal16::class.java to VariantParser.SIGNAL,
    PackedByteArray::class.java to VariantParser.PACKED_BYTE_ARRAY,
    PackedColorArray::class.java to VariantParser.PACKED_COLOR_ARRAY,
    PackedInt32Array::class.java to VariantParser.PACKED_INT_32_ARRAY,
    PackedInt64Array::class.java to VariantParser.PACKED_INT_64_ARRAY,
    PackedFloat32Array::class.java to VariantParser.PACKED_FLOAT_32_ARRAY,
    PackedFloat64Array::class.java to VariantParser.PACKED_FLOAT_64_ARRAY,
    PackedStringArray::class.java to VariantParser.PACKED_STRING_ARRAY,
    PackedVector2Array::class.java to VariantParser.PACKED_VECTOR2_ARRAY,
    PackedVector3Array::class.java to VariantParser.PACKED_VECTOR3_ARRAY,
    PackedVector4Array::class.java to VariantParser.PACKED_VECTOR4_ARRAY,
)

@PublishedApi
internal val variantMapper = HashMap<Class<*>, VariantConverter<*>>().apply { putAll(coreVariantMappings) }

fun clearVariantMappings() {
    variantMapper.clear()
    variantMapper.putAll(coreVariantMappings)
}

fun addVariantMapping(clazz: KClass<*>, parser: VariantConverter<*>) {
    variantMapper[clazz.javaObjectType] = parser
}

inline fun <reified T> getVariantConverter() = getVariantConverter(T::class.java)

fun getVariantConverter(clazz: Class<*>): VariantConverter<*>? =
    variantMapper[clazz] ?: if (clazz.isEnum) enumConverter(clazz) else null

@Suppress("UNCHECKED_CAST")
private fun <E : Enum<E>> enumConverter(clazz: Class<*>) = VariantCaster.ENUM(clazz.enumConstants as Array<E>)

inline fun <reified T> hasInvalidNullability(): Boolean =
    isNullable<T>() && T::class.java != Any::class.java && !KtObject::class.java.isAssignableFrom(T::class.java)
