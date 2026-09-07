package godot.annotation.processor.classgraph.shape

import godot.annotation.processor.classgraph.extensions.returnRawDescriptor
import godot.registration.model.RegisteredPropertyBindingKind
import godot.registration.model.types.TYPE_VOID
import io.github.classgraph.AnnotationInfo
import io.github.classgraph.ClassInfo
import io.github.classgraph.FieldInfo
import io.github.classgraph.MethodInfo

class KotlinJvmLanguage : JvmLanguage() {
    /** Kotlin classes are identified from the original source file extension emitted in class debug metadata. */
    override fun supports(classInfo: ClassInfo): Boolean = classInfo.sourceFile?.endsWith(".kt") == true

    /** Removes Kotlin compiler-generated storage fields that do not represent user-visible properties. */
    override fun filterFields(fields: List<FieldInfo>, classInfo: ClassInfo): List<FieldInfo> =
        fields.filterNot { fieldInfo ->
            fieldInfo.name == $$$"$$delegatedProperties" ||
                fieldInfo.name.startsWith($$$"$$delegate_") ||
                fieldInfo.name == "Companion" ||
                fieldInfo.name == "INSTANCE"
        }

    /** Kotlin delegated properties use a `$delegate` storage field suffix. */
    override fun logicalFieldName(fieldInfo: FieldInfo): String =
        fieldInfo.name.removeSuffix(DELEGATE_SUFFIX)

    /** Removes Kotlin synthetic helpers such as default stubs, access bridges, and inline/value-class support methods. */
    override fun filterMethods(methods: List<MethodInfo>, classInfo: ClassInfo): List<MethodInfo> =
        super.filterMethods(methods, classInfo).filterNot { methodInfo ->
            val name = methodInfo.name
            name.endsWith($$"$annotations") ||
                name.endsWith($$"$default") ||
                name.startsWith("access$") ||
                name.endsWith("-impl") ||
                name == "box-impl" ||
                name == "unbox-impl"
        }

    /** Reconstructs property accessors from Kotlin conventions, including `isFoo` boolean properties. */
    override fun propertyAccessorsOf(methodInfo: MethodInfo, classInfo: ClassInfo): List<PropertyAccessor> = when {
        methodInfo.parameterInfo.isEmpty() && methodInfo.returnRawDescriptor() != TYPE_VOID ->
            when {
                methodInfo.name.startsWith("get") && methodInfo.name.length > 3 ->
                    listOf(PropertyAccessor.Getter(propertyName(methodInfo.name.removePrefix("get"), classInfo)))

                methodInfo.name.startsWith("is") && methodInfo.name.length > 2 ->
                    listOf(PropertyAccessor.Getter(methodInfo.name))

                else -> emptyList()
            }

        methodInfo.parameterInfo.size == 1 &&
            methodInfo.returnRawDescriptor() == TYPE_VOID &&
            methodInfo.name.startsWith("set") &&
            methodInfo.name.length > 3 ->
            methodInfo.name.removePrefix("set").let { suffix ->
                listOf(
                    PropertyAccessor.Setter(propertyName(suffix, classInfo)),
                    PropertyAccessor.Setter("is$suffix"),
                )
            }

        else -> emptyList()
    }

    override fun propertyBindingFor(property: LogicalProperty): RegisteredPropertyBindingKind =
        RegisteredPropertyBindingKind.PROPERTY_REFERENCE

    /** Kotlin may place property annotations on synthetic `$annotations` methods rather than the backing field. */
    override fun signalAnnotationsOf(
        fieldInfo: FieldInfo,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): List<AnnotationInfo> =
        fieldInfo.annotationInfo
            .union(kotlinSyntheticPropertyAnnotations(fieldInfo, index))
            .distinct()
            .toList()

    /** Getter-only signals still need synthetic property annotations merged in to preserve source-level annotations. */
    override fun signalAnnotationsOf(
        propertyName: String,
        getter: MethodInfo,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): List<AnnotationInfo> =
        getter.annotationInfo
            .union(kotlinSyntheticPropertyAnnotations(propertyName, index))
            .distinct()
            .toList()

    /** Property annotations can be split across the field, accessors, and Kotlin synthetic annotation carrier methods. */
    override fun propertyAnnotationsOf(
        fieldInfo: FieldInfo?,
        getter: MethodInfo?,
        setter: MethodInfo?,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): List<AnnotationInfo> = buildList {
        fieldInfo?.let {
            addAll(it.annotationInfo)
            addAll(kotlinSyntheticPropertyAnnotations(it, index))
        }
        getter?.let {
            addAll(it.annotationInfo)
            addAll(kotlinSyntheticPropertyAnnotations(it, index))
        }
        setter?.let { addAll(it.annotationInfo) }
    }.distinctBy(AnnotationInfo::toString)

    override fun isLateinitProperty(
        fieldInfo: FieldInfo?,
        getter: MethodInfo?,
        setter: MethodInfo?,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): Boolean =
        propertyAnnotationsOf(fieldInfo, getter, setter, classInfo, index)
            .any { annotation -> annotation.name == KOTLIN_LATEINIT }

    private fun kotlinSyntheticPropertyAnnotations(fieldInfo: FieldInfo, index: ClassShapeIndex): Collection<AnnotationInfo> {
        val methodName = $$"$${getterName(logicalFieldName(fieldInfo))}$annotations"
        return index.methodsByName[methodName]?.firstOrNull()?.annotationInfo ?: emptyList()
    }

    private fun kotlinSyntheticPropertyAnnotations(propertyName: String, index: ClassShapeIndex): Collection<AnnotationInfo> {
        val methodName = $$"$${getterName(propertyName)}$annotations"
        return index.methodsByName[methodName]?.firstOrNull()?.annotationInfo ?: emptyList()
    }

    private fun kotlinSyntheticPropertyAnnotations(getter: MethodInfo, index: ClassShapeIndex): Collection<AnnotationInfo> {
        val methodName = getter.name + "$" + "annotations"
        return index.methodsByName[methodName]?.firstOrNull()?.annotationInfo ?: emptyList()
    }

    private fun propertyName(accessorSuffix: String, classInfo: ClassInfo): String =
        accessorSuffix.takeIf { propertyName ->
            classInfo.declaredFieldInfo.orEmpty().any { fieldInfo -> logicalFieldName(fieldInfo) == propertyName }
        } ?: accessorSuffix.decapitalized()
}

private const val DELEGATE_SUFFIX = "$" + "delegate"
private const val KOTLIN_LATEINIT = "kotlin.Lateinit"

private fun getterName(propertyName: String): String =
    if (propertyName.startsWith("is") && propertyName.length > 2 && propertyName[2].isUpperCase()) {
        propertyName
    } else {
        "get${propertyName.capitalized()}"
    }

private fun String.decapitalized(): String =
    replaceFirstChar(Char::lowercaseChar)

private fun String.capitalized(): String =
    replaceFirstChar { char -> if (char.isLowerCase()) char.titlecase() else char.toString() }
