@file:Suppress("NOTHING_TO_INLINE")

package godot.annotation.processor.classgraph.policy

import godot.annotation.Emit
import godot.annotation.Export
import godot.annotation.Notification
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.annotation.processor.classgraph.AnnotationProcessingMode
import godot.annotation.processor.classgraph.ProcessorContext
import godot.annotation.processor.classgraph.extensions.isMappable
import godot.annotation.processor.classgraph.extensions.isMappablePropertyType
import godot.annotation.processor.classgraph.extensions.isMappableType
import godot.annotation.processor.classgraph.extensions.metaAnnotations
import godot.annotation.processor.classgraph.extensions.overridesGodotBaseMethod
import godot.annotation.processor.classgraph.extensions.rawDescriptor
import godot.annotation.processor.classgraph.extensions.returnRawDescriptor
import godot.annotation.processor.classgraph.extensions.withMetaAnnotations
import godot.annotation.processor.classgraph.shape.AnnotationHolder
import godot.annotation.processor.classgraph.shape.LogicalClassShape
import godot.annotation.processor.classgraph.shape.LogicalMethod
import godot.annotation.processor.classgraph.shape.LogicalProperty
import godot.annotation.processor.classgraph.shape.LogicalSignal
import io.github.classgraph.AnnotationInfo
import io.github.classgraph.ClassInfo
import kotlin.reflect.KClass

class RegistrationPolicy(
    context: ProcessorContext,
) : RegistrationPolicyMode by RegistrationPolicyMode.of(context)

private interface RegistrationPolicyMode {
    val context: ProcessorContext

    fun hasAnnotation(holder: AnnotationHolder, annotationClass: KClass<out Annotation>): Boolean =
        resolvedAnnotations(holder).any { annotation -> annotation.name == annotationClass.java.name }

    fun findAnnotation(holder: AnnotationHolder, annotationClass: KClass<out Annotation>): AnnotationInfo? =
        resolvedAnnotations(holder).firstOrNull { annotation -> annotation.name == annotationClass.java.name }

    fun selectClass(shape: LogicalClassShape): Boolean
    fun selectProperty(property: LogicalProperty): Boolean
    fun selectSignal(signal: LogicalSignal): Boolean
    fun selectMethod(method: LogicalMethod, owner: ClassInfo): Boolean
    fun isPropertyExported(property: LogicalProperty): Boolean

    fun resolvedAnnotations(holder: AnnotationHolder): List<AnnotationInfo>

    companion object {
        fun of(context: ProcessorContext): RegistrationPolicyMode =
            when (context.settings.annotationProcessingMode) {
                AnnotationProcessingMode.Explicit -> ExplicitRegistrationPolicy(context)
                AnnotationProcessingMode.Inferred -> InferredRegistrationPolicy(context)
                AnnotationProcessingMode.Automatic -> AutomaticRegistrationPolicy(context)
            }
    }
}

private class ExplicitRegistrationPolicy(
    override val context: ProcessorContext,
) : RegistrationPolicyMode {
    override fun resolvedAnnotations(holder: AnnotationHolder): List<AnnotationInfo> = holder.annotations.toList()

    override fun selectClass(shape: LogicalClassShape): Boolean = hasAnnotation(shape, Script::class)

    override fun selectProperty(property: LogicalProperty): Boolean = hasAnnotation(property, Visible::class)

    override fun selectSignal(signal: LogicalSignal): Boolean = hasAnnotation(signal, Emit::class)

    override fun selectMethod(method: LogicalMethod, owner: ClassInfo): Boolean =
        hasAnnotation(method, Register::class) ||
            hasAnnotation(method, Notification::class)

    override fun isPropertyExported(property: LogicalProperty): Boolean = hasAnnotation(property, Export::class)
}

private class InferredRegistrationPolicy(
    override val context: ProcessorContext,
) : RegistrationPolicyMode {
    override fun resolvedAnnotations(holder: AnnotationHolder): List<AnnotationInfo> =
        holder.annotations.withMetaAnnotations { annotation ->
            context.getOrPutAnnotationChain(annotation) {
                annotation.metaAnnotations()
            }
        }

    override fun selectClass(shape: LogicalClassShape): Boolean = hasAnnotation(shape, Script::class)

    override fun selectProperty(property: LogicalProperty): Boolean = hasAnnotation(property, Visible::class)

    override fun selectSignal(signal: LogicalSignal): Boolean = true

    override fun selectMethod(method: LogicalMethod, owner: ClassInfo): Boolean =
        hasAnnotation(method, Register::class) ||
            (method.methodInfo.overridesGodotBaseMethod(owner) && method.methodInfo.isMappable(context))

    override fun isPropertyExported(property: LogicalProperty): Boolean = hasAnnotation(property, Export::class)
}

private class AutomaticRegistrationPolicy(
    override val context: ProcessorContext,
) : RegistrationPolicyMode {
    override fun resolvedAnnotations(holder: AnnotationHolder): List<AnnotationInfo> =
        holder.annotations.withMetaAnnotations { annotation ->
            context.getOrPutAnnotationChain(annotation) {
                annotation.metaAnnotations()
            }
        }

    override fun selectClass(shape: LogicalClassShape): Boolean = shape.classInfo.isPublic

    override fun selectProperty(property: LogicalProperty): Boolean {
        if (!property.isPublic) {
            return false
        }
        val rawDescriptor = property.getter?.returnRawDescriptor()
            ?: property.fieldInfo?.rawDescriptor()
            ?: return false
        return rawDescriptor.isMappablePropertyType(context)
    }

    override fun selectSignal(signal: LogicalSignal): Boolean = signal.isPublic

    override fun selectMethod(method: LogicalMethod, owner: ClassInfo): Boolean =
        method.methodInfo.isMappable(context)

    override fun isPropertyExported(property: LogicalProperty): Boolean = true
}

private val LogicalProperty.isPublic: Boolean
    get() = getter?.isPublic ?: fieldInfo?.isPublic ?: false

private val LogicalSignal.isPublic: Boolean
    get() = getter?.isPublic ?: fieldInfo?.isPublic ?: false
