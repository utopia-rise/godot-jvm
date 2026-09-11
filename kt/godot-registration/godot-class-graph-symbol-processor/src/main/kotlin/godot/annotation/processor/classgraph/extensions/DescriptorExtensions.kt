package godot.annotation.processor.classgraph.extensions

import io.github.classgraph.ClassInfo
import io.github.classgraph.ClassMemberInfo
import io.github.classgraph.ClassRefTypeSignature
import io.github.classgraph.FieldInfo
import io.github.classgraph.MethodInfo
import io.github.classgraph.MethodParameterInfo
import io.github.classgraph.TypeArgument
import io.github.classgraph.TypeSignature
import godot.registration.model.types.TYPE_KOTLIN_ANY

val ClassMemberInfo.fqName: String
    get() = "${classInfo.name}$$name"

val ClassMemberInfo.registrationFqName: String
    get() = fqName.toRegistrationFqName()

val ClassInfo.registrationFqName: String
    get() = name.toRegistrationFqName()

val MethodInfo.methodSignature: String
    get() = "$name:$typeDescriptor"

fun TypeSignature.toStringWithoutAnnotations(): String {
    if (typeAnnotationInfo == null) return toString()

    var result = toString()
    typeAnnotationInfo.forEach {
        result = result.removePrefix(it.toString())
    }
    return result.trim()
}

fun MethodParameterInfo.rawDescriptor(): String =
    typeDescriptor.toStringWithoutAnnotations()

fun MethodParameterInfo.typeArguments(): List<TypeArgument> =
    (typeSignature as? ClassRefTypeSignature)?.typeArguments ?: emptyList()

fun FieldInfo.rawDescriptor(): String =
    typeDescriptor.toStringWithoutAnnotations()

fun FieldInfo.typeArguments(): List<TypeArgument> =
    (typeSignature as? ClassRefTypeSignature)?.typeArguments ?: emptyList()

fun MethodInfo.returnRawDescriptor(): String =
    typeDescriptor.resultType.toStringWithoutAnnotations()

fun MethodInfo.returnTypeArguments(): List<TypeArgument> =
    (typeSignature?.resultType as? ClassRefTypeSignature)?.typeArguments ?: emptyList()

fun TypeArgument.rawDescriptor(): String =
    typeSignature?.toStringWithoutAnnotations() ?: TYPE_KOTLIN_ANY // A generic wildcard has a null value so we fallback to Any.

fun TypeArgument.typeArguments(): List<TypeArgument> =
    (typeSignature as? ClassRefTypeSignature)?.typeArguments ?: emptyList()

fun String.isSignalTypeDescriptor(): Boolean {
    val rawDescriptor = substringBefore("<")
    if (rawDescriptor == "godot.core.Signal") {
        return true
    }
    if (!rawDescriptor.startsWith("godot.core.Signal")) {
        return false
    }
    if (rawDescriptor.length == "godot.core.Signal".length) {
        return true
    }
    for (index in "godot.core.Signal".length until rawDescriptor.length) {
        if (!rawDescriptor[index].isDigit()) {
            return false
        }
    }
    return true
}

private fun String.toRegistrationFqName(): String =
    replace("$", ".")
