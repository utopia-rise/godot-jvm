package godot.annotation.processor.classgraph.extensions

import godot.annotation.GodotBaseType
import godot.annotation.processor.classgraph.ProcessorContext
import godot.annotation.processor.classgraph.ProcessorSettings
import godot.annotation.processor.classgraph.constants.BIT_FIELD
import godot.annotation.processor.classgraph.constants.BIT_FIELD_BASE
import godot.annotation.processor.classgraph.constants.CORE_TYPE_FQ_NAME
import godot.annotation.processor.classgraph.constants.GODOT_NODE_FQ_NAME
import godot.annotation.processor.classgraph.constants.GODOT_RESOURCE_FQ_NAME
import godot.annotation.processor.classgraph.constants.JAVA_COLLECTION_FQ_NAME
import godot.registration.model.types.TYPE_JAVA_OBJECT
import godot.registration.model.types.Type
import io.github.classgraph.ClassInfo
import io.github.classgraph.MethodInfo

fun ClassInfo.isGodotCompatibleClass(): Boolean =
    hasAnnotation(GodotBaseType::class.java.name) ||
        superclasses.any { superclass -> superclass.hasAnnotation(GodotBaseType::class.java.name) }

fun ClassInfo.directSuperInterfaces(): List<ClassInfo> {
    val inheritedFromSuperclass = (superclass?.interfaces ?: emptyList()).toSet()
    val own = interfaces.filterNot { iface -> iface in inheritedFromSuperclass }
    return own.filter { candidate -> own.none { other -> other != candidate && candidate in other.interfaces } }
}

fun MethodInfo.isMappable(context: ProcessorContext): Boolean =
    parameterInfo.all { parameter -> parameter.typeDescriptor.toString().isMappableType(context) } &&
        typeDescriptor.resultType.toString().isMappableType(context)

val ClassInfo.enumEntryCount: Int
    get() = fieldInfo.count { field -> field.isEnum }

fun ClassInfo.sourceProjectName(settings: ProcessorSettings): String {
    val classpathElementFile = try {
        classpathElementFile?.canonicalFile
    } catch (_: IllegalArgumentException) {
        null
    }

    if (classpathElementFile in settings.userCodeClassPathRoots) {
        return settings.projectName
    }

    val classpathElementName = classpathElementFile
        ?.nameWithoutExtension
        ?.takeIf { name -> name.isNotBlank() }
        ?: classpathElementFile
            ?.name
            ?.takeIf { name -> name.isNotBlank() }

    return classpathElementName
        ?.replace(" ", "_")
        ?: settings.projectName
}

fun MethodInfo.overridesGodotBaseMethod(owner: ClassInfo): Boolean =
    owner.superclasses
        .filter { superclass -> superclass.hasAnnotation(GodotBaseType::class.java.name) }
        .any { superclass ->
            superclass.methodInfo.any { superMethod -> superMethod.methodSignature == methodSignature }
        }

fun ClassInfo.superMethodSignatures(): Set<String> {
    val signatures = mutableSetOf<String>()
    for (superclass in superclasses) {
        signatures += superclass.hierarchyMethodSignatures()
    }
    return signatures
}

fun String.isMappableType(context: ProcessorContext): Boolean =
    isMappable(context, storableGodotClassesOnly = false)

fun String.isMappablePropertyType(context: ProcessorContext): Boolean =
    isMappable(context, storableGodotClassesOnly = true) || isEnumCollectionDescriptor(context)

private fun String.isMappable(context: ProcessorContext, storableGodotClassesOnly: Boolean): Boolean {
    val rawDescriptor = substringBefore("<")
    if (Type.findPrimitiveType(rawDescriptor) != null) {
        return true
    }
    if (Type.findCoreType(rawDescriptor) != null) {
        return true
    }
    if (rawDescriptor == TYPE_JAVA_OBJECT) {
        return true
    }
    val classInfo = context.getClassInfoOrNull(rawDescriptor) ?: return false
    val godotClassIsSelectable = classInfo.isStandardClass &&
        classInfo.isGodotCompatibleClass() &&
        (!storableGodotClassesOnly || classInfo.isProcessorNodeOrResource)

    return classInfo.isEnum ||
        godotClassIsSelectable ||
        classInfo.isProcessorCoreType ||
        classInfo.isProcessorBitField
}

private fun String.isEnumCollectionDescriptor(context: ProcessorContext): Boolean {
    val classInfo = context.getClassInfoOrNull(substringBefore("<")) ?: return false
    if (!classInfo.isProcessorCollection) {
        return false
    }
    val elementDescriptor = substringAfter("<", "").substringBeforeLast(">", "").substringBefore(",")
    return context.getClassInfoOrNull(elementDescriptor.substringBefore("<"))?.isEnum == true
}

fun ClassInfo.hierarchyMethodSignatures(): Set<String> {
    val signatures = mutableSetOf<String>()
    for (method in methodInfo) {
        signatures += method.methodSignature
    }
    for (superclass in superclasses) {
        signatures += superclass.hierarchyMethodSignatures()
    }
    return signatures
}

internal val ClassInfo.isProcessorCoreType: Boolean
    get() = name == CORE_TYPE_FQ_NAME ||
        superclasses.any { superclass -> superclass.name == CORE_TYPE_FQ_NAME } ||
        interfaces.any { iface -> iface.name == CORE_TYPE_FQ_NAME }

internal val ClassInfo.isProcessorBitField: Boolean
    get() = name == BIT_FIELD ||
        superclasses.any { superclass -> superclass.name == BIT_FIELD } ||
        name == BIT_FIELD_BASE ||
        superclasses.any { superclass -> superclass.name == BIT_FIELD_BASE }

internal val ClassInfo.isProcessorCollection: Boolean
    get() = name == JAVA_COLLECTION_FQ_NAME ||
        implementsInterface(JAVA_COLLECTION_FQ_NAME) ||
        runCatching { Collection::class.java.isAssignableFrom(Class.forName(name)) }.getOrDefault(false)

internal val ClassInfo.isProcessorNodeOrResource: Boolean
    get() = extendsSuperclass(GODOT_NODE_FQ_NAME) || extendsSuperclass(GODOT_RESOURCE_FQ_NAME)
