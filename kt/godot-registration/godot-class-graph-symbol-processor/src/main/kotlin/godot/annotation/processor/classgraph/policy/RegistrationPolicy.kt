package godot.annotation.processor.classgraph.policy

import godot.annotation.Emit
import godot.annotation.Export
import godot.annotation.Notification
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Storage
import godot.annotation.Visible
import godot.annotation.processor.classgraph.AnnotationProcessingMode
import godot.annotation.processor.classgraph.ProcessorContext
import godot.annotation.processor.classgraph.extensions.isMappable
import godot.annotation.processor.classgraph.extensions.isMappablePropertyType
import godot.annotation.processor.classgraph.extensions.metaAnnotations
import godot.annotation.processor.classgraph.extensions.overridesGodotBaseMethod
import godot.annotation.processor.classgraph.extensions.rawDescriptor
import godot.annotation.processor.classgraph.extensions.returnRawDescriptor
import godot.annotation.processor.classgraph.extensions.returnTypeArguments
import godot.annotation.processor.classgraph.extensions.typeArguments
import godot.annotation.processor.classgraph.extensions.withMetaAnnotations
import godot.annotation.processor.classgraph.shape.AnnotationHolder
import godot.annotation.processor.classgraph.shape.LogicalClassShape
import godot.annotation.processor.classgraph.shape.LogicalMethod
import godot.annotation.processor.classgraph.shape.LogicalProperty
import godot.annotation.processor.classgraph.shape.LogicalSignal
import godot.registration.model.PropertyExposure
import io.github.classgraph.AnnotationInfo
import io.github.classgraph.ClassInfo
import kotlin.reflect.KClass

/**
 * Decides what a declaration registers as. Every mode reads the same annotations, meta-annotations included; the mode
 * only sets the annotation assumed on a candidate that has none written. A written annotation replaces that default,
 * and selects even a declaration that is not a candidate, which the model then rejects.
 *
 * An accessor-shaped method is read as its property: it registers as a function only with `@Register`, and the
 * property steps aside for it unless `@Visible` is written too.
 */
class RegistrationPolicy(private val context: ProcessorContext) {
    private val mode = context.settings.annotationProcessingMode

    fun hasAnnotation(holder: AnnotationHolder, annotationClass: KClass<out Annotation>): Boolean =
        findAnnotation(holder, annotationClass) != null

    fun findAnnotation(holder: AnnotationHolder, annotationClass: KClass<out Annotation>): AnnotationInfo? =
        findAnnotation(holder.annotations, annotationClass)

    private fun findAnnotation(annotations: Collection<AnnotationInfo>, annotationClass: KClass<out Annotation>): AnnotationInfo? =
        annotations
            .withMetaAnnotations { annotation -> context.getOrPutAnnotationChain(annotation) { annotation.metaAnnotations() } }
            .firstOrNull { annotation -> annotation.name == annotationClass.java.name }

    fun selectClass(shape: LogicalClassShape): Boolean =
        hasAnnotation(shape, Script::class) || mode == AnnotationProcessingMode.Automatic && shape.isCandidate

    fun selectProperty(property: LogicalProperty): Boolean =
        hasAnnotation(property, Visible::class) ||
            mode == AnnotationProcessingMode.Automatic &&
            property.isCandidate &&
            property.isMappable() &&
            listOfNotNull(property.getter, property.setter).none { accessor -> findAnnotation(accessor.annotationInfo, Register::class) != null }

    fun selectSignal(signal: LogicalSignal): Boolean =
        hasAnnotation(signal, Emit::class) || mode != AnnotationProcessingMode.Explicit && signal.isCandidate

    fun selectMethod(method: LogicalMethod, owner: ClassInfo, isAccessor: Boolean): Boolean =
        hasAnnotation(method, Register::class) ||
            !isAccessor && hasAnnotation(method, Notification::class) ||
            !isAccessor &&
            method.isCandidate &&
            method.methodInfo.isMappable(context) &&
            when (mode) {
                AnnotationProcessingMode.Explicit -> false
                AnnotationProcessingMode.Inferred -> method.methodInfo.overridesGodotBaseMethod(owner)
                AnnotationProcessingMode.Automatic -> true
            }

    fun propertyExposure(property: LogicalProperty): PropertyExposure = when {
        hasAnnotation(property, Export::class) -> PropertyExposure.EXPORT
        hasAnnotation(property, Storage::class) -> PropertyExposure.STORAGE
        hasAnnotation(property, Visible::class) -> PropertyExposure.VISIBLE
        else -> PropertyExposure.EXPORT
    }

    private fun LogicalProperty.isMappable(): Boolean {
        val rawDescriptor = getter?.returnRawDescriptor() ?: fieldInfo?.rawDescriptor() ?: return false
        val typeArguments = getter?.returnTypeArguments() ?: fieldInfo?.typeArguments().orEmpty()
        return rawDescriptor.isMappablePropertyType(context, typeArguments)
    }
}
