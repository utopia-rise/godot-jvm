package godot.registration.model.types

import godot.common.util.NaturalT
import godot.common.util.RealT
import godot.core.AABB
import godot.core.Basis
import godot.core.Callable
import godot.core.Color
import godot.core.Dictionary
import godot.core.NodePath
import godot.core.PackedByteArray
import godot.core.PackedColorArray
import godot.core.PackedFloat32Array
import godot.core.PackedFloat64Array
import godot.core.PackedInt32Array
import godot.core.PackedInt64Array
import godot.core.PackedStringArray
import godot.core.PackedVector2Array
import godot.core.PackedVector3Array
import godot.core.PackedVector4Array
import godot.core.Plane
import godot.core.Projection
import godot.core.Quaternion
import godot.core.RID
import godot.core.Rect2
import godot.core.Rect2i
import godot.core.Signal
import godot.core.StringName
import godot.core.Transform2D
import godot.core.Transform3D
import godot.core.VariantArray
import godot.core.Vector2
import godot.core.Vector2i
import godot.core.Vector3
import godot.core.Vector3i
import godot.core.Vector4
import godot.core.Vector4i

const val TYPE_VOID = "void"
const val TYPE_BOOLEAN = "boolean"
const val TYPE_BYTE = "byte"
const val TYPE_SHORT = "short"
const val TYPE_INT = "int"
const val TYPE_LONG = "long"
const val TYPE_FLOAT = "float"
const val TYPE_DOUBLE = "double"

const val TYPE_BOXED_BOOLEAN = "java.lang.Boolean"
const val TYPE_BOXED_BYTE = "java.lang.Byte"
const val TYPE_BOXED_SHORT = "java.lang.Short"
const val TYPE_BOXED_INT = "java.lang.Integer"
const val TYPE_BOXED_LONG = "java.lang.Long"
const val TYPE_BOXED_FLOAT = "java.lang.Float"
const val TYPE_BOXED_DOUBLE = "java.lang.Double"
const val TYPE_JAVA_STRING = "java.lang.String"
const val TYPE_JAVA_OBJECT = "java.lang.Object"

const val TYPE_KOTLIN_UNIT = "kotlin.Unit"
const val TYPE_KOTLIN_ANY = "kotlin.Any"
const val TYPE_KOTLIN_STRING = "kotlin.String"

enum class TypeKind {
    PRIMITIVE,
    CORE_TYPE,
    INTERFACE,
    GODOT_CLASS,
    ENUM,
    BITFIELD,
    COLLECTION,
    OTHER,
}

open class Type(
    open val fqName: String,
    open val kind: TypeKind,
    open val isNullable: Boolean,
    open val genericArguments: List<Type> = emptyList(),
) {
    val name: String
        get() = fqName.substringAfterLast(".")

    val containingPackage: String
        get() = if (fqName.contains(".")) {
            fqName.substringBeforeLast(".")
        } else ""

    override fun hashCode(): Int {
        return fqName.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return other is Type && fqName == other.fqName
    }

    fun with(
        isNullable: Boolean = this.isNullable,
        genericArguments: List<Type> = this.genericArguments,
    ): Type = if (isNullable == this.isNullable && genericArguments == this.genericArguments) {
        this
    } else {
        Type(
            fqName = fqName,
            kind = kind,
            isNullable = isNullable,
            genericArguments = genericArguments,
        )
    }

    companion object {
        private fun knownType(
            fqName: String,
            kind: TypeKind,
        ) = Type(
            fqName = fqName,
            kind = kind,
            isNullable = false,
        )

        private fun isAssignableTo(fqName: String, target: Class<*>): Boolean = runCatching {
            target.isAssignableFrom(Class.forName(fqName))
        }.getOrDefault(false)

        val nilType = knownType(TYPE_VOID, TypeKind.PRIMITIVE)
        val booleanType = knownType(TYPE_BOOLEAN, TypeKind.PRIMITIVE)
        val byteType = knownType(TYPE_BYTE, TypeKind.PRIMITIVE)
        val shortType = knownType(TYPE_SHORT, TypeKind.PRIMITIVE)
        val intType = knownType(TYPE_INT, TypeKind.PRIMITIVE)
        val naturalType = knownType(NaturalT::class.qualifiedName!!, TypeKind.PRIMITIVE)
        val longType = knownType(TYPE_LONG, TypeKind.PRIMITIVE)
        val floatType = knownType(TYPE_FLOAT, TypeKind.PRIMITIVE)
        val realType = knownType(RealT::class.qualifiedName!!, TypeKind.PRIMITIVE)
        val doubleType = knownType(TYPE_DOUBLE, TypeKind.PRIMITIVE)
        val stringType = knownType(TYPE_KOTLIN_STRING, TypeKind.PRIMITIVE)

        val vector2Type = knownType(Vector2::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val vector2iType = knownType(Vector2i::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val rect2Type = knownType(Rect2::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val rect2iType = knownType(Rect2i::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val vector3Type = knownType(Vector3::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val vector3iType = knownType(Vector3i::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val transform2DType = knownType(Transform2D::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val vector4Type = knownType(Vector4::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val vector4iType = knownType(Vector4i::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val planeType = knownType(Plane::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val quaternionType = knownType(Quaternion::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val aabbType = knownType(AABB::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val basisType = knownType(Basis::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val transform3DType = knownType(Transform3D::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val projectionType = knownType(Projection::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val colorType = knownType(Color::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val stringNameType = knownType(StringName::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val nodePathType = knownType(NodePath::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val ridType = knownType(RID::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val callableType = knownType(Callable::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val signalType = knownType(Signal::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val dictionaryType = knownType(Dictionary::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val variantArrayType = knownType(VariantArray::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedByteArrayType = knownType(PackedByteArray::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedInt32ArrayType = knownType(PackedInt32Array::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedInt64ArrayType = knownType(PackedInt64Array::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedFloat32ArrayType = knownType(PackedFloat32Array::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedFloat64ArrayType = knownType(PackedFloat64Array::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedStringArrayType = knownType(PackedStringArray::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedVector2ArrayType = knownType(PackedVector2Array::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedVector3ArrayType = knownType(PackedVector3Array::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedColorArrayType = knownType(PackedColorArray::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val packedVector4ArrayType = knownType(PackedVector4Array::class.qualifiedName!!, TypeKind.CORE_TYPE)
        val anyType = knownType(TYPE_KOTLIN_ANY, TypeKind.CORE_TYPE)

        private val primitiveTypesByFqName = buildMap {
            put(TYPE_VOID, nilType)
            put(TYPE_KOTLIN_UNIT, nilType)
            put(TYPE_BOOLEAN, booleanType)
            put(TYPE_BOXED_BOOLEAN, booleanType)
            put(TYPE_BYTE, byteType)
            put(TYPE_BOXED_BYTE, byteType)
            put(TYPE_SHORT, shortType)
            put(TYPE_BOXED_SHORT, shortType)
            put(TYPE_INT, intType)
            put(TYPE_BOXED_INT, intType)
            put(naturalType.fqName, naturalType)
            put(TYPE_LONG, longType)
            put(TYPE_BOXED_LONG, longType)
            put(TYPE_FLOAT, floatType)
            put(TYPE_BOXED_FLOAT, floatType)
            put(realType.fqName, realType)
            put(TYPE_DOUBLE, doubleType)
            put(TYPE_BOXED_DOUBLE, doubleType)
            put(TYPE_KOTLIN_STRING, stringType)
            put(TYPE_JAVA_STRING, stringType)
        }

        private val coreTypesByFqName = buildMap {
            put(TYPE_JAVA_OBJECT, anyType)
            put(TYPE_KOTLIN_ANY, anyType)
            put(vector2Type.fqName, vector2Type)
            put(vector2iType.fqName, vector2iType)
            put(rect2Type.fqName, rect2Type)
            put(rect2iType.fqName, rect2iType)
            put(vector3Type.fqName, vector3Type)
            put(vector3iType.fqName, vector3iType)
            put(transform2DType.fqName, transform2DType)
            put(vector4Type.fqName, vector4Type)
            put(vector4iType.fqName, vector4iType)
            put(planeType.fqName, planeType)
            put(quaternionType.fqName, quaternionType)
            put(aabbType.fqName, aabbType)
            put(basisType.fqName, basisType)
            put(transform3DType.fqName, transform3DType)
            put(projectionType.fqName, projectionType)
            put(colorType.fqName, colorType)
            put(stringNameType.fqName, stringNameType)
            put(nodePathType.fqName, nodePathType)
            put(ridType.fqName, ridType)
            put(callableType.fqName, callableType)
            put(signalType.fqName, signalType)
            put(dictionaryType.fqName, dictionaryType)
            put(variantArrayType.fqName, variantArrayType)
            put(packedByteArrayType.fqName, packedByteArrayType)
            put(packedInt32ArrayType.fqName, packedInt32ArrayType)
            put(packedInt64ArrayType.fqName, packedInt64ArrayType)
            put(packedFloat32ArrayType.fqName, packedFloat32ArrayType)
            put(packedFloat64ArrayType.fqName, packedFloat64ArrayType)
            put(packedStringArrayType.fqName, packedStringArrayType)
            put(packedVector2ArrayType.fqName, packedVector2ArrayType)
            put(packedVector3ArrayType.fqName, packedVector3ArrayType)
            put(packedColorArrayType.fqName, packedColorArrayType)
            put(packedVector4ArrayType.fqName, packedVector4ArrayType)
        }

        fun findPrimitiveType(
            fqName: String,
            isNullable: Boolean = false,
            genericArguments: List<Type> = emptyList(),
        ): Type? = primitiveTypesByFqName[fqName]?.with(
            isNullable = isNullable,
            genericArguments = genericArguments,
        )

        fun findCoreType(
            fqName: String,
            isNullable: Boolean = false,
            genericArguments: List<Type> = emptyList(),
        ): Type? {
            val base = coreTypesByFqName[fqName]
                ?: when {
                    isAssignableTo(fqName, Callable::class.java) -> knownType(fqName, TypeKind.CORE_TYPE)
                    isAssignableTo(fqName, Signal::class.java) -> knownType(fqName, TypeKind.CORE_TYPE)
                    else -> null
                }

            return base?.with(isNullable = isNullable, genericArguments = genericArguments)
        }

        fun getPrimitiveType(
            fqName: String,
            isNullable: Boolean = false,
            genericArguments: List<Type> = emptyList(),
        ): Type = requireNotNull(findPrimitiveType(fqName, isNullable, genericArguments)) {
            "$fqName is not a primitive type"
        }

        fun getCoreType(
            fqName: String,
            isNullable: Boolean = false,
            genericArguments: List<Type> = emptyList(),
        ): Type = requireNotNull(findCoreType(fqName, isNullable, genericArguments)) {
            "$fqName is not a core type"
        }

        fun getEnum(
            fqName: String,
            isNullable: Boolean = false,
            genericArguments: List<Type> = emptyList(),
        ): Type = knownType(
            fqName = fqName,
            kind = TypeKind.ENUM,
        ).with(isNullable = isNullable, genericArguments = genericArguments)

        fun getCollection(
            fqName: String,
            isNullable: Boolean = false,
            genericArguments: List<Type> = emptyList(),
        ): Type = knownType(
            fqName = fqName,
            kind = TypeKind.COLLECTION,
        ).with(isNullable = isNullable, genericArguments = genericArguments)

        fun getBitField(
            fqName: String,
            isNullable: Boolean = false,
            genericArguments: List<Type> = emptyList(),
        ): Type = knownType(
            fqName = fqName,
            kind = TypeKind.BITFIELD,
        ).with(isNullable = isNullable, genericArguments = genericArguments)
    }
}
