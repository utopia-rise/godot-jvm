package godot.annotation.processor.classgraph.shape

import godot.annotation.processor.classgraph.extensions.isSignalTypeDescriptor
import godot.annotation.processor.classgraph.extensions.rawDescriptor
import godot.annotation.processor.classgraph.extensions.returnRawDescriptor
import godot.registration.model.RegisteredPropertyBindingKind
import io.github.classgraph.AnnotationInfo
import io.github.classgraph.BaseTypeSignature
import io.github.classgraph.ClassInfo
import io.github.classgraph.ClassMemberInfo
import io.github.classgraph.FieldInfo
import io.github.classgraph.MethodInfo
import io.github.classgraph.MethodParameterInfo

interface AnnotationHolder {
    val annotations: List<AnnotationInfo>
}

/**
 * `isCandidate` marks what registration may reach whatever the mode: a public class that is not an object, a public
 * instance member. The mode decides what a candidate registers as.
 */
data class LogicalClassShape(
    val classInfo: ClassInfo,
    override val annotations: List<AnnotationInfo>,
    val signals: List<LogicalSignal>,
    val properties: List<LogicalProperty>,
    val methods: List<LogicalMethod>,
) : AnnotationHolder {
    val isCandidate: Boolean =
        classInfo.isPublic && classInfo.declaredFieldInfo.orEmpty().none { field -> field.isStatic && field.name == "INSTANCE" }
    val accessorMethods: Set<MethodInfo> = properties.flatMapTo(mutableSetOf()) { property -> listOfNotNull(property.getter, property.setter) }
}

data class LogicalSignal(
    val name: String,
    override val annotations: List<AnnotationInfo>,
    val fieldInfo: FieldInfo? = null,
    val getter: MethodInfo? = null,
) : AnnotationHolder {
    val isCandidate: Boolean = (getter ?: fieldInfo)?.isPublicInstance == true
}

data class LogicalProperty(
    val name: String,
    override val annotations: List<AnnotationInfo>,
    val fieldInfo: FieldInfo? = null,
    val getter: MethodInfo? = null,
    val setter: MethodInfo? = null,
    val isLateinit: Boolean = false,
) : AnnotationHolder {
    val isCandidate: Boolean = listOfNotNull(getter, setter).ifEmpty { listOfNotNull(fieldInfo) }.let { members ->
        members.isNotEmpty() && members.all { member -> member.isPublicInstance }
    }
}

data class LogicalMethod(
    val methodInfo: MethodInfo,
    override val annotations: List<AnnotationInfo>,
) : AnnotationHolder {
    val isCandidate: Boolean = methodInfo.isPublicInstance
}

private val ClassMemberInfo.isPublicInstance: Boolean
    get() = isPublic && !isStatic

class LanguageNotIdentified(classInfo: ClassInfo) : IllegalStateException(
    "Could not identify JVM source language for ${classInfo.name}"
)

abstract class JvmLanguage {
    fun shapeOf(classInfo: ClassInfo): LogicalClassShape {
        val candidateFields = filterFields(classInfo.declaredFieldInfo.orEmpty(), classInfo).toMutableSet()
        val candidateMethods = filterMethods(classInfo.declaredMethodInfo.orEmpty(), classInfo).toMutableSet()
        val index = ClassShapeIndex(
            methodsByName = classInfo.declaredMethodInfo.orEmpty().groupBy(MethodInfo::getName),
        )
        val accessors = indexAccessors(classInfo, candidateMethods)

        val signals = identifySignals(classInfo, candidateFields, candidateMethods, accessors, index)
        val properties = identifyProperties(classInfo, candidateFields, candidateMethods, accessors, index)
        val methods = candidateMethods.map { methodInfo ->
            LogicalMethod(
                methodInfo = methodInfo,
                annotations = methodInfo.annotationInfo,
            )
        }

        return LogicalClassShape(
            classInfo = classInfo,
            annotations = classInfo.annotationInfo,
            signals = signals,
            properties = properties,
            methods = methods,
        )
    }

    private fun indexAccessors(classInfo: ClassInfo, methods: Collection<MethodInfo>): Accessors {
        val getters = linkedMapOf<String, MethodInfo>()
        val setters = linkedMapOf<String, MethodInfo>()

        for (methodInfo in methods) {
            for (candidate in propertyAccessorsOf(methodInfo, classInfo)) {
                when (candidate) {
                    is PropertyAccessor.Getter -> getters.putIfAbsent(candidate.propertyName, methodInfo)
                    is PropertyAccessor.Setter -> setters.putIfAbsent(candidate.propertyName, methodInfo)
                }
            }
        }

        return Accessors(getters = getters, setters = setters)
    }

    private fun identifySignals(
        classInfo: ClassInfo,
        candidateFields: MutableSet<FieldInfo>,
        candidateMethods: MutableSet<MethodInfo>,
        accessors: Accessors,
        index: ClassShapeIndex,
    ): List<LogicalSignal> {
        val signals = mutableListOf<LogicalSignal>()
        val fieldNames = candidateFields.mapTo(mutableSetOf()) { fieldInfo -> logicalFieldName(fieldInfo) }

        for (fieldInfo in candidateFields.toList()) {
            val signalName = logicalFieldName(fieldInfo)
            val getter = accessors.getters[signalName]
            val signalTypeDescriptor = getter?.returnRawDescriptor() ?: fieldInfo.rawDescriptor()
            if (!signalTypeDescriptor.isSignalTypeDescriptor()) {
                continue
            }

            signals += LogicalSignal(
                name = signalName,
                annotations = signalAnnotationsOf(fieldInfo, classInfo, index),
                fieldInfo = fieldInfo,
                getter = getter,
            )
            candidateFields.remove(fieldInfo)
            getter?.let(candidateMethods::remove)
        }

        for ((signalName, getter) in accessors.getters) {
            if (signalName in fieldNames || getter !in candidateMethods) {
                continue
            }
            if (!getter.returnRawDescriptor().isSignalTypeDescriptor()) {
                continue
            }

            signals += LogicalSignal(
                name = signalName,
                annotations = signalAnnotationsOf(signalName, getter, classInfo, index),
                getter = getter,
            )
            candidateMethods.remove(getter)
        }

        return signals
    }

    private fun identifyProperties(
        classInfo: ClassInfo,
        candidateFields: MutableSet<FieldInfo>,
        candidateMethods: MutableSet<MethodInfo>,
        accessors: Accessors,
        index: ClassShapeIndex,
    ): List<LogicalProperty> {
        val properties = mutableListOf<LogicalProperty>()
        val fieldNames = candidateFields.mapTo(mutableSetOf()) { fieldInfo -> logicalFieldName(fieldInfo) }

        for (fieldInfo in candidateFields.toList()) {
            val propertyName = logicalFieldName(fieldInfo)
            val getter = accessors.getters[propertyName]?.takeIf { methodInfo -> methodInfo in candidateMethods }
            val setter = accessors.setters[propertyName]?.takeIf { methodInfo -> methodInfo in candidateMethods }

            properties += LogicalProperty(
                name = propertyName,
                annotations = propertyAnnotationsOf(fieldInfo, getter, setter, classInfo, index),
                fieldInfo = fieldInfo,
                getter = getter,
                setter = setter,
                isLateinit = isLateinitProperty(fieldInfo, getter, setter, classInfo, index),
            )

            candidateFields.remove(fieldInfo)
        }

        for ((propertyName, getter) in accessors.getters) {
            if (propertyName in fieldNames || getter !in candidateMethods) {
                continue
            }
            val setter = accessors.setters[propertyName]?.takeIf { methodInfo -> methodInfo in candidateMethods }

            properties += LogicalProperty(
                name = propertyName,
                annotations = propertyAnnotationsOf(null, getter, setter, classInfo, index),
                getter = getter,
                setter = setter,
                isLateinit = isLateinitProperty(null, getter, setter, classInfo, index),
            )
        }

        return properties
    }

    protected open fun propertyAnnotationsOf(
        fieldInfo: FieldInfo?,
        getter: MethodInfo?,
        setter: MethodInfo?,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): List<AnnotationInfo> = buildList {
        fieldInfo?.let { addAll(it.annotationInfo) }
        getter?.let { addAll(it.annotationInfo) }
        setter?.let { addAll(it.annotationInfo) }
    }.distinctBy(AnnotationInfo::toString)

    protected open fun isLateinitProperty(
        fieldInfo: FieldInfo?,
        getter: MethodInfo?,
        setter: MethodInfo?,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): Boolean = false

    /**
     * Returns true when this language knows how to interpret the compiled shape of [classInfo].
     *
     * The shared entry point uses this to pick exactly one language adapter for a class before
     * building its [LogicalClassShape].
     */
    abstract fun supports(classInfo: ClassInfo): Boolean

    /** Applies language-specific field filtering before signal and property reconstruction begins. */
    protected open fun filterFields(fields: List<FieldInfo>, classInfo: ClassInfo): List<FieldInfo> = fields

    /** Returns the source-level property name represented by a JVM field in this language. */
    protected open fun logicalFieldName(fieldInfo: FieldInfo): String = fieldInfo.name

    /**
     * Applies generic JVM cleanup and then language-specific method filtering before accessors,
     * signals, and callable methods are reconstructed.
     */
    protected open fun filterMethods(methods: List<MethodInfo>, classInfo: ClassInfo): List<MethodInfo> =
        methods.filterNot { methodInfo ->
            methodInfo.isConstructor ||
                methodInfo.name == "<clinit>" ||
                methodInfo.isBridge ||
                (methodInfo.isSynthetic && methodInfo.annotationInfo.isEmpty())
        }

    /** Classifies a method as one or more source-level property accessors for this language. */
    protected abstract fun propertyAccessorsOf(methodInfo: MethodInfo, classInfo: ClassInfo): List<PropertyAccessor>

    /** Chooses how generated Kotlin should reference this logical property. */
    /** Whether the generated call passes the parameter as nullable. Java and Scala record no nullability, so every reference type is. */
    open fun isNullable(parameterInfo: MethodParameterInfo): Boolean =
        parameterInfo.typeSignatureOrTypeDescriptor !is BaseTypeSignature

    open fun propertyBindingFor(property: LogicalProperty): RegisteredPropertyBindingKind =
        if (property.getter != null || property.setter != null) {
            RegisteredPropertyBindingKind.ACCESSOR_METHODS
        } else {
            RegisteredPropertyBindingKind.PROPERTY_REFERENCE
        }

    /**
     * Resolves the effective annotations for a signal represented by a backing field.
     *
     * Languages may store signal annotations directly on the field or in auxiliary generated
     * members. The shared builder uses the result when creating a [LogicalSignal].
     */
    protected open fun signalAnnotationsOf(
        fieldInfo: FieldInfo,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): List<AnnotationInfo> = fieldInfo.annotationInfo

    /**
     * Resolves the effective annotations for a signal represented only by a getter-like method.
     *
     * This is used for languages where a logical signal may exist without a visible backing field.
     */
    protected open fun signalAnnotationsOf(
        propertyName: String,
        getter: MethodInfo,
        classInfo: ClassInfo,
        index: ClassShapeIndex,
    ): List<AnnotationInfo> = getter.annotationInfo

    private data class Accessors(
        val getters: Map<String, MethodInfo>,
        val setters: Map<String, MethodInfo>,
    )

    protected sealed interface PropertyAccessor {
        val propertyName: String

        data class Getter(override val propertyName: String) : PropertyAccessor
        data class Setter(override val propertyName: String) : PropertyAccessor
    }

    protected data class ClassShapeIndex(
        val methodsByName: Map<String, List<MethodInfo>>,
    )

    companion object {
        private val languages: List<JvmLanguage> = listOf(
            KotlinJvmLanguage(),
            ScalaJvmLanguage(),
            JavaJvmLanguage(),
        )

        fun forClassOrNull(classInfo: ClassInfo): JvmLanguage? =
            languages.firstOrNull { language -> language.supports(classInfo) }

        fun forClass(classInfo: ClassInfo): JvmLanguage =
            forClassOrNull(classInfo) ?: throw LanguageNotIdentified(classInfo)
    }
}
