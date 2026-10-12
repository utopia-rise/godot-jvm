package godot.codegen.models.traits

import com.squareup.kotlinpoet.ANY
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.DOUBLE
import com.squareup.kotlinpoet.LONG
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.UNIT
import godot.codegen.constants.Core
import godot.codegen.constants.TypeIdentifier
import godot.codegen.constants.VariantConverter
import godot.tools.common.constants.godotApiPackage
import godot.tools.common.constants.godotCorePackage

enum class Nature {
    VOID,
    PRIMITIVE,
    CORE,
    TYPED_ARRAY,
    CLASS,
    ENUM,
    BITFIELD,
    NATIVE,
    UNGENERATED_CLASS
}


interface TypeGenerationTrait {
    val identifier: String
    val nature: Nature
    val className: ClassName

    fun getVariantConverter(): MemberName = when {
        isVoid() -> VariantConverter.NIL
        isEnum() -> VariantConverter.LONG
        isBitField() -> VariantConverter.LONG
        identifier == TypeIdentifier.BOOL.name -> VariantConverter.BOOL
        identifier == TypeIdentifier.INT.name -> VariantConverter.LONG
        identifier == TypeIdentifier.FLOAT.name -> VariantConverter.DOUBLE
        identifier == TypeIdentifier.NODE_PATH.name -> VariantConverter.NODE_PATH
        identifier == TypeIdentifier.STRING_NAME.name -> VariantConverter.STRING_NAME
        identifier == TypeIdentifier.RID.name -> VariantConverter.RID
        identifier == TypeIdentifier.ARRAY.name || isTypedArray() -> VariantConverter.ARRAY
        identifier == TypeIdentifier.PACKED_BYTE_ARRAY.name -> VariantConverter.PACKED_BYTE_ARRAY
        identifier == TypeIdentifier.PACKED_INT32_ARRAY.name -> VariantConverter.PACKED_INT_32_ARRAY
        identifier == TypeIdentifier.PACKED_INT64_ARRAY.name -> VariantConverter.PACKED_INT_64_ARRAY
        identifier == TypeIdentifier.PACKED_FLOAT32_ARRAY.name -> VariantConverter.PACKED_FLOAT_32_ARRAY
        identifier == TypeIdentifier.PACKED_FLOAT64_ARRAY.name -> VariantConverter.PACKED_FLOAT_64_ARRAY
        identifier == TypeIdentifier.PACKED_STRING_ARRAY.name -> VariantConverter.PACKED_STRING_ARRAY
        identifier == TypeIdentifier.PACKED_VECTOR2_ARRAY.name -> VariantConverter.PACKED_VECTOR2_ARRAY
        identifier == TypeIdentifier.PACKED_VECTOR3_ARRAY.name -> VariantConverter.PACKED_VECTOR3_ARRAY
        identifier == TypeIdentifier.PACKED_VECTOR4_ARRAY.name -> VariantConverter.PACKED_VECTOR4_ARRAY
        identifier == TypeIdentifier.PACKED_COLOR_ARRAY.name -> VariantConverter.PACKED_COLOR_ARRAY
        identifier == TypeIdentifier.VARIANT.name -> VariantConverter.ANY
        isCoreType() || isPrimitive() -> VariantConverter.parse(identifier)
        else -> VariantConverter.OBJECT
    }

    fun isVoid() = nature == Nature.VOID
    fun isCoreType() = nature == Nature.CORE || nature == Nature.TYPED_ARRAY
    fun isPrimitive() = nature == Nature.PRIMITIVE
    fun isLocalCopyCoreTypes() = TypeIdentifier.localCopies.contains(identifier)
    fun isLocalIndexedCopyCoreTypes() = TypeIdentifier.indexedLocalCopies.contains(identifier)
    fun isEnum() = nature == Nature.ENUM
    fun isBitField() = nature == Nature.BITFIELD
    fun isTypedArray() = nature == Nature.TYPED_ARRAY
    fun isObjectSubClass() = nature == Nature.CLASS
    fun isNullable() = isObjectSubClass() || identifier == TypeIdentifier.VARIANT.name
    fun isNativeType() = nature == Nature.NATIVE
    fun isUngeneratedClass() = nature == Nature.UNGENERATED_CLASS
}

fun ClassName.Companion.from(type: TypeGenerationTrait) = when {
    type.isVoid() -> UNIT
    type.identifier == TypeIdentifier.SIGNAL.name -> Core.signal
    type.identifier.startsWith(TypeIdentifier.SIGNAL.name) -> Core.signal(type.identifier.removePrefix("Signal").toInt())
    type.isEnum() || type.isBitField() -> {
        val containerAndEnum = type.identifier.split('.')
        val enumPackage = if (containerAndEnum.size == 1 || TypeIdentifier.core.contains(containerAndEnum[0])) {
            godotCorePackage
        } else {
            godotApiPackage
        }
        ClassName(enumPackage, containerAndEnum)
    }

    type.identifier == TypeIdentifier.BOOL.name -> BOOLEAN
    type.identifier == TypeIdentifier.INT.name -> LONG
    type.identifier == TypeIdentifier.FLOAT.name -> DOUBLE
    type.identifier == TypeIdentifier.STRING.name -> STRING
    type.identifier == TypeIdentifier.VARIANT.name -> ANY
    type.identifier == TypeIdentifier.CALLABLE.name -> Core.callable
    type.identifier == TypeIdentifier.ARRAY.name || type.isTypedArray() -> Core.variantArray
    type.identifier == TypeIdentifier.DICTIONARY.name -> Core.dictionary
    type.isCoreType() -> ClassName(godotCorePackage, type.identifier)
    else -> ClassName(godotApiPackage, type.identifier)
}

fun TypeName.Companion.from(type: TypeGenerationTrait, genericParameters: List<TypeName> = emptyList(), isNullable: Boolean? = null): TypeName {
    val className = type.className

    return when {
        type.identifier != TypeIdentifier.SIGNAL.name && type.identifier.startsWith("Signal") && !type.identifier.endsWith("0") -> {
            val nonNullableGenericParameters = genericParameters.map { it.copy(nullable = false) }
            className.parameterizedBy(nonNullableGenericParameters)
        }

        type.isTypedArray() -> {
            val genericType = type.identifier.removePrefix("${TypeIdentifier.TYPED_ARRAY.name}::")
            val subType = GenerationType(genericType)
            className.parameterizedBy(from(subType).copy(nullable = false))
        }

        type.identifier == TypeIdentifier.ARRAY.name -> className.parameterizedBy(ANY.copy(nullable = true))
        type.identifier == TypeIdentifier.DICTIONARY.name -> className.parameterizedBy(ANY.copy(nullable = true), ANY.copy(nullable = true))
        else -> className
    }.copy(nullable = isNullable ?: type.isNullable())
}

const val enumPrefix = "enum::"
const val bitfieldPrefix = "bitfield::"
const val ungeneratedClassPrefix = "ungenerated::"

class GenerationType(rawIdentifier: String) : TypeGenerationTrait {
    override val identifier = sanitizeIdentifier(rawIdentifier)
    override val nature = getNature(rawIdentifier)
    override val className = ClassName.from(this)

    private fun sanitizeIdentifier(identifier: String): String {
        return identifier.removePrefix(enumPrefix).removePrefix(bitfieldPrefix).removePrefix(ungeneratedClassPrefix)
    }

    private fun getNature(identifier: String) = when {
        identifier == "void" -> Nature.VOID
        TypeIdentifier.primitives.any { it == identifier } -> Nature.PRIMITIVE
        identifier.startsWith("Signal") -> Nature.CORE
        TypeIdentifier.core.any { it == identifier } -> Nature.CORE
        identifier.startsWith(enumPrefix) -> Nature.ENUM
        identifier.startsWith(bitfieldPrefix) -> Nature.BITFIELD
        identifier.startsWith(ungeneratedClassPrefix) -> Nature.UNGENERATED_CLASS
        identifier.startsWith(TypeIdentifier.TYPED_ARRAY.name) -> Nature.TYPED_ARRAY
        identifier.contains("*") -> Nature.NATIVE
        else -> Nature.CLASS
    }
}
