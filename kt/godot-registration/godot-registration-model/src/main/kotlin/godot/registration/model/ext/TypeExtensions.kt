package godot.registration.model.ext

import godot.common.util.NaturalT
import godot.common.util.RealT
import godot.core.Dictionary
import godot.core.VariantArray
import godot.registration.model.types.GodotClass
import godot.registration.model.types.TYPE_BOOLEAN
import godot.registration.model.types.TYPE_BYTE
import godot.registration.model.types.TYPE_DOUBLE
import godot.registration.model.types.TYPE_FLOAT
import godot.registration.model.types.TYPE_INT
import godot.registration.model.types.TYPE_JAVA_OBJECT
import godot.registration.model.types.TYPE_KOTLIN_ANY
import godot.registration.model.types.TYPE_KOTLIN_STRING
import godot.registration.model.types.TYPE_LONG
import godot.registration.model.types.TYPE_SHORT
import godot.registration.model.types.Type
import godot.registration.model.types.TypeKind

fun Type.isCoreType(): Boolean = kind == TypeKind.CORE_TYPE

fun Type.isNodeType(): Boolean {
    return (this as? GodotClass)?.isOrInherits(godot.api.Node::class.java.name) == true
}

fun Type.isEnum(): Boolean = kind == TypeKind.ENUM

fun Type.isBitField(): Boolean = kind == TypeKind.BITFIELD

fun Type.isResource(): Boolean =
    (this as? GodotClass)?.isOrInherits(godot.api.Resource::class.java.name) == true

private fun GodotClass.isOrInherits(targetFqName: String): Boolean {
    var current: GodotClass? = this
    while (current != null) {
        if (current.fqName == targetFqName) {
            return true
        }
        current = current.parent
    }
    return false
}

fun Type.isGodotPrimitive(): Boolean = when (fqName) {
    TYPE_INT,
    NaturalT::class.qualifiedName,
    TYPE_LONG,
    TYPE_FLOAT,
    RealT::class.qualifiedName,
    TYPE_DOUBLE,
    TYPE_BOOLEAN,
    TYPE_BYTE,
    TYPE_SHORT,
    TYPE_KOTLIN_STRING -> true

    else -> false
}

fun Type.isGodotClass(): Boolean = kind == TypeKind.GODOT_CLASS

fun Type.isNil(): Boolean = this == Type.nilType

fun Type.isVariant(): Boolean = fqName == TYPE_KOTLIN_ANY || fqName == TYPE_JAVA_OBJECT

fun Type.isCollection(): Boolean = kind == TypeKind.COLLECTION

fun Type.isEnumRelated(includeCollection: Boolean): Boolean = isEnum()
    || isBitField()
    || (includeCollection && isCollection() && genericArguments.firstOrNull()?.isEnum() == true)

fun Type.isMappableArgument(): Boolean = isVariant()
    || isGodotPrimitive()
    || isCoreType()
    || isGodotClass()
    || isEnumRelated(includeCollection = false)

fun Type.isMappableReturnType(): Boolean = isNil() || isMappableArgument()

fun Type.isMappableProperty(): Boolean = isVariant()
    || isGodotPrimitive()
    || isCoreType()
    || isNodeType()
    || isResource()
    || isEnumRelated(includeCollection = true)

fun Type.carriesGodotVisibleGenericArguments(): Boolean = isCollection()
    || fqName == VariantArray::class.qualifiedName
    || fqName == Dictionary::class.qualifiedName

fun Type.signatureTypes(): List<Type> = listOf(this) + if (carriesGodotVisibleGenericArguments()) {
    genericArguments.flatMap(Type::signatureTypes)
} else {
    emptyList()
}

fun Type.unrepresentableGenericArgument(): Type? = genericArguments
    .takeIf { carriesGodotVisibleGenericArguments() }
    ?.asSequence()
    ?.flatMap { argument -> argument.signatureTypes().asSequence() }
    ?.firstOrNull { nested -> !nested.isMappableArgument() }
