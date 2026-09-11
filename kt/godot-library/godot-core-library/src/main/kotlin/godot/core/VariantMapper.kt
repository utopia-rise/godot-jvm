@file:Suppress("NOTHING_TO_INLINE")

package godot.core

import godot.common.interop.VariantConverter
import godot.common.util.isNullable
import kotlin.reflect.KClass
import kotlin.jvm.`internal`.Reflection

@PublishedApi
internal val variantMapper = mutableMapOf(
    Unit::class to VariantParser.NIL,
    Void::class to VariantParser.NIL,
    Any::class to VariantCaster.ANY,
    java.lang.Object::class to VariantCaster.ANY,
    Boolean::class to VariantParser.BOOL,
    Byte::class to VariantCaster.BYTE,
    Int::class to VariantCaster.INT,
    Long::class to VariantParser.LONG,
    Float::class to VariantCaster.FLOAT,
    Double::class to VariantParser.DOUBLE,
    String::class to VariantParser.STRING,
    AABB::class to VariantParser.AABB,
    Basis::class to VariantParser.BASIS,
    Color::class to VariantParser.COLOR,
    StringName::class to VariantParser.STRING_NAME,
    Dictionary::class to VariantCaster.TYPED_DICTIONARY(),
    VariantArray::class to VariantCaster.TYPED_ARRAY(),
    Plane::class to VariantParser.PLANE,
    NodePath::class to VariantParser.NODE_PATH,
    Quaternion::class to VariantParser.QUATERNION,
    Rect2::class to VariantParser.RECT2,
    Rect2i::class to VariantParser.RECT2I,
    RID::class to VariantParser._RID,
    Transform3D::class to VariantParser.TRANSFORM3D,
    Transform2D::class to VariantParser.TRANSFORM2D,
    Vector2::class to VariantParser.VECTOR2,
    Vector2i::class to VariantParser.VECTOR2I,
    Vector3::class to VariantParser.VECTOR3,
    Vector3i::class to VariantParser.VECTOR3I,
    Vector4::class to VariantParser.VECTOR4,
    Vector4i::class to VariantParser.VECTOR4I,
    Projection::class to VariantParser.PROJECTION,
    VariantCallable::class to VariantParser.CALLABLE,
    MethodCallable::class to VariantParser.CALLABLE,
    MethodCallable0::class to VariantParser.CALLABLE,
    MethodCallable1::class to VariantParser.CALLABLE,
    MethodCallable2::class to VariantParser.CALLABLE,
    MethodCallable3::class to VariantParser.CALLABLE,
    MethodCallable4::class to VariantParser.CALLABLE,
    MethodCallable5::class to VariantParser.CALLABLE,
    MethodCallable6::class to VariantParser.CALLABLE,
    MethodCallable7::class to VariantParser.CALLABLE,
    MethodCallable8::class to VariantParser.CALLABLE,
    MethodCallable9::class to VariantParser.CALLABLE,
    MethodCallable10::class to VariantParser.CALLABLE,
    MethodCallable11::class to VariantParser.CALLABLE,
    MethodCallable12::class to VariantParser.CALLABLE,
    MethodCallable13::class to VariantParser.CALLABLE,
    MethodCallable14::class to VariantParser.CALLABLE,
    MethodCallable15::class to VariantParser.CALLABLE,
    MethodCallable16::class to VariantParser.CALLABLE,
    LambdaCallable::class to VariantParser.CALLABLE,
    LambdaCallable0::class to VariantParser.CALLABLE,
    LambdaCallable1::class to VariantParser.CALLABLE,
    LambdaCallable2::class to VariantParser.CALLABLE,
    LambdaCallable3::class to VariantParser.CALLABLE,
    LambdaCallable4::class to VariantParser.CALLABLE,
    LambdaCallable5::class to VariantParser.CALLABLE,
    LambdaCallable6::class to VariantParser.CALLABLE,
    LambdaCallable7::class to VariantParser.CALLABLE,
    LambdaCallable8::class to VariantParser.CALLABLE,
    LambdaCallable9::class to VariantParser.CALLABLE,
    LambdaCallable10::class to VariantParser.CALLABLE,
    LambdaCallable11::class to VariantParser.CALLABLE,
    LambdaCallable12::class to VariantParser.CALLABLE,
    LambdaCallable13::class to VariantParser.CALLABLE,
    LambdaCallable14::class to VariantParser.CALLABLE,
    LambdaCallable15::class to VariantParser.CALLABLE,
    LambdaCallable16::class to VariantParser.CALLABLE,
    Signal::class to VariantParser.SIGNAL,
    Signal0::class to VariantParser.SIGNAL,
    Signal1::class to VariantParser.SIGNAL,
    Signal2::class to VariantParser.SIGNAL,
    Signal3::class to VariantParser.SIGNAL,
    Signal4::class to VariantParser.SIGNAL,
    Signal5::class to VariantParser.SIGNAL,
    Signal6::class to VariantParser.SIGNAL,
    Signal7::class to VariantParser.SIGNAL,
    Signal8::class to VariantParser.SIGNAL,
    Signal9::class to VariantParser.SIGNAL,
    Signal10::class to VariantParser.SIGNAL,
    Signal11::class to VariantParser.SIGNAL,
    Signal12::class to VariantParser.SIGNAL,
    Signal13::class to VariantParser.SIGNAL,
    Signal14::class to VariantParser.SIGNAL,
    Signal15::class to VariantParser.SIGNAL,
    Signal16::class to VariantParser.SIGNAL,
    PackedByteArray::class to VariantParser.PACKED_BYTE_ARRAY,
    PackedColorArray::class to VariantParser.PACKED_COLOR_ARRAY,
    PackedInt32Array::class to VariantParser.PACKED_INT_32_ARRAY,
    PackedInt64Array::class to VariantParser.PACKED_INT_64_ARRAY,
    PackedFloat32Array::class to VariantParser.PACKED_FLOAT_32_ARRAY,
    PackedFloat64Array::class to VariantParser.PACKED_FLOAT_64_ARRAY,
    PackedStringArray::class to VariantParser.PACKED_STRING_ARRAY,
    PackedVector2Array::class to VariantParser.PACKED_VECTOR2_ARRAY,
    PackedVector3Array::class to VariantParser.PACKED_VECTOR3_ARRAY,
    PackedVector4Array::class to VariantParser.PACKED_VECTOR4_ARRAY
)

inline fun <reified T : Any> addVariantMapping(clazz: KClass<out T>, parser: VariantConverter) {
    variantMapper[clazz] = parser
}

inline fun <reified T> getVariantConverter() = variantMapper[T::class]
inline fun getVariantConverter(clazz: KClass<*>) = variantMapper[clazz]
inline fun getVariantConverter(clazz: Class<*>) = variantMapper[Reflection.getOrCreateKotlinClass(clazz)]

@PublishedApi
internal val KtObjectClass = KtObject::class.java

@PublishedApi
internal val nullableVariantWhitelist = hashSetOf(
    Any::class,
    java.lang.Object::class,
)

inline fun <reified T> hasInvalidNullability(): Boolean {
    if (!isNullable<T>()) {
        return false
    }

    if (T::class in nullableVariantWhitelist) {
        return false
    }

    return !KtObjectClass.isAssignableFrom(T::class.java)
}
