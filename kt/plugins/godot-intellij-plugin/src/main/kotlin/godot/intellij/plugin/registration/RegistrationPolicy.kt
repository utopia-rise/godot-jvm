package godot.intellij.plugin.registration

import com.intellij.openapi.components.service
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifierListOwner
import godot.annotation.Emit
import godot.annotation.Export
import godot.annotation.Notification
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.core.KtObject
import godot.core.Signal
import godot.intellij.plugin.project.isOrInheritsType
import godot.intellij.plugin.project.inherits
import godot.intellij.plugin.project.isMappableProperty
import godot.intellij.plugin.project.jvmType
import godot.tools.common.constants.lifecycleFunctions
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtPrimaryConstructor
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.containingClass
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

object RegistrationPolicy {
    fun requiresClassAnnotation(element: KtAnnotated): Boolean =
        element.mode != RegistrationMode.Automatic

    fun requiresClassAnnotation(element: PsiModifierListOwner): Boolean =
        element.mode != RegistrationMode.Automatic

    fun requiresGodotOverrideAnnotation(element: PsiModifierListOwner): Boolean =
        element.mode == RegistrationMode.Explicit

    fun requiresInheritedRegistrationAnnotation(element: KtAnnotated): Boolean =
        element.mode != RegistrationMode.Automatic

    fun isGodotScriptCandidate(klass: KtClass): Boolean =
        klass.isOrInheritsType(KtObject::class.classId)

    fun isGodotScriptCandidate(klass: PsiClass): Boolean =
        klass.isOrInheritsType(KtObject::class.classId)

    fun registersClass(klass: KtClass): Boolean = when (klass.mode) {
        RegistrationMode.Explicit -> klass.hasDirectAnnotation(Script::class)
        RegistrationMode.Inferred -> klass.hasEffectiveAnnotation(Script::class)
        RegistrationMode.Automatic -> isGodotScriptCandidate(klass)
    }

    fun registersClass(klass: PsiClass): Boolean = when (klass.mode) {
        RegistrationMode.Explicit -> klass.hasDirectAnnotation(Script::class)
        RegistrationMode.Inferred -> klass.hasEffectiveAnnotation(Script::class)
        RegistrationMode.Automatic -> isGodotScriptCandidate(klass)
    }

    fun registersProperty(property: KtProperty): Boolean = when (property.mode) {
        RegistrationMode.Explicit -> property.hasDirectAnnotation(Visible::class)
        RegistrationMode.Inferred -> property.hasEffectiveAnnotation(Visible::class)
        RegistrationMode.Automatic ->
            property.containingClass()?.let(::registersClass) == true &&
                property.jvmType()?.isMappableProperty() == true
    }

    fun registersProperty(field: PsiField): Boolean = when (field.mode) {
        RegistrationMode.Explicit -> field.hasDirectAnnotation(Visible::class)
        RegistrationMode.Inferred -> field.hasEffectiveAnnotation(Visible::class)
        RegistrationMode.Automatic -> field.containingClass?.let(::registersClass) == true
    }

    fun registersProperty(
        property: PsiMember,
        owner: PsiClass,
        isCompatible: Boolean
    ): Boolean = when (property.mode) {
        RegistrationMode.Explicit -> property.hasDirectAnnotation(Visible::class)
        RegistrationMode.Inferred -> property.hasEffectiveAnnotation(Visible::class)
        RegistrationMode.Automatic -> registersClass(owner) && isCompatible
    }

    fun registersSignal(property: KtProperty): Boolean = when (property.mode) {
        RegistrationMode.Explicit -> property.hasDirectAnnotation(Emit::class)
        RegistrationMode.Inferred ->
            property.hasEffectiveAnnotation(Emit::class) ||
                (
                    property.containingClass()?.let(::registersClass) == true &&
                        property.isOrInheritsType(Signal::class.classId)
                    )

        RegistrationMode.Automatic ->
            property.containingClass()?.let(::registersClass) == true &&
                property.isOrInheritsType(Signal::class.classId)
    }

    fun registersSignal(field: PsiField): Boolean = when (field.mode) {
        RegistrationMode.Explicit -> field.hasDirectAnnotation(Emit::class)
        RegistrationMode.Inferred ->
            field.hasEffectiveAnnotation(Emit::class) ||
                (
                    field.containingClass?.let(::registersClass) == true &&
                        field.type.inherits(Signal::class.classId)
                    )

        RegistrationMode.Automatic ->
            field.containingClass?.let(::registersClass) == true &&
                field.type.inherits(Signal::class.classId)
    }

    fun registersSignal(
        property: PsiMember,
        owner: PsiClass,
        isSignal: Boolean
    ): Boolean = when (property.mode) {
        RegistrationMode.Explicit -> property.hasDirectAnnotation(Emit::class)
        RegistrationMode.Inferred ->
            property.hasEffectiveAnnotation(Emit::class) ||
                (registersClass(owner) && isSignal)

        RegistrationMode.Automatic -> registersClass(owner) && isSignal
    }

    fun registersFunction(function: KtNamedFunction): Boolean = when (function.mode) {
        RegistrationMode.Explicit ->
            function.hasDirectAnnotation(Register::class) ||
                function.hasDirectAnnotation(Notification::class)

        RegistrationMode.Inferred ->
            function.hasEffectiveAnnotation(Register::class) ||
                function.isGodotLifecycleOverride()

        RegistrationMode.Automatic -> function.containingClass()?.let(::registersClass) == true
    }

    fun registersFunction(method: PsiMethod): Boolean = when (method.mode) {
        RegistrationMode.Explicit ->
            method.hasDirectAnnotation(Register::class) ||
                method.hasDirectAnnotation(Notification::class)

        RegistrationMode.Inferred ->
            method.hasEffectiveAnnotation(Register::class) ||
                method.isGodotLifecycleOverride()

        RegistrationMode.Automatic -> method.containingClass?.let(::registersClass) == true
    }

    fun exportsProperty(property: KtProperty): Boolean = when (property.mode) {
        RegistrationMode.Explicit -> property.hasDirectAnnotation(Export::class)
        RegistrationMode.Inferred -> property.hasEffectiveAnnotation(Export::class)
        RegistrationMode.Automatic -> registersProperty(property) &&
            (!property.hasEffectiveAnnotation(Visible::class) || property.hasEffectiveAnnotation(Export::class))
    }

    fun KtAnnotated.hasEffectiveAnnotation(annotation: KClass<out Annotation>): Boolean =
        hasAnnotation(annotation, includeMetaAnnotations = mode != RegistrationMode.Explicit)

    fun PsiModifierListOwner.hasEffectiveAnnotation(annotation: KClass<out Annotation>): Boolean =
        hasAnnotation(annotation, includeMetaAnnotations = mode != RegistrationMode.Explicit)

    private fun KtAnnotated.hasDirectAnnotation(annotation: KClass<out Annotation>): Boolean =
        findAnnotation(annotation.classId) != null

    private fun PsiModifierListOwner.hasDirectAnnotation(annotation: KClass<out Annotation>): Boolean =
        getAnnotation(annotation.qualifiedName!!) != null

    private fun KtAnnotated.hasAnnotation(
        annotation: KClass<out Annotation>,
        includeMetaAnnotations: Boolean
    ): Boolean {
        if (hasDirectAnnotation(annotation)) return true
        if (!includeMetaAnnotations) return false

        return annotationEntries.any { entry ->
            entry.hasMetaAnnotation(annotation, mutableSetOf())
        }
    }

    private fun KtClass.hasAnnotation(
        annotation: KClass<out Annotation>,
        visited: MutableSet<String>
    ): Boolean {
        val className = fqName?.asString() ?: return false
        if (!visited.add(className)) return false
        if (hasDirectAnnotation(annotation)) return true

        return annotationEntries.any { entry ->
            entry.hasMetaAnnotation(annotation, visited)
        }
    }

    private fun KtAnnotationEntry.hasMetaAnnotation(
        annotation: KClass<out Annotation>,
        visited: MutableSet<String>
    ): Boolean = when (val annotationClass = calleeExpression
        ?.constructorReferenceExpression
        ?.mainReference
        ?.resolve()) {
        is KtClass -> annotationClass.hasAnnotation(annotation, visited)
        is KtPrimaryConstructor ->
            (annotationClass.parent as? KtClass)?.hasAnnotation(annotation, visited) == true

        is PsiClass -> annotationClass.hasAnnotation(annotation, visited)
        is PsiMethod -> annotationClass.containingClass?.hasAnnotation(annotation, visited) == true
        else -> false
    }

    private fun PsiModifierListOwner.hasAnnotation(
        annotation: KClass<out Annotation>,
        includeMetaAnnotations: Boolean
    ): Boolean {
        if (hasDirectAnnotation(annotation)) return true
        if (!includeMetaAnnotations) return false

        return annotations.any { entry ->
            entry.resolveAnnotationType()?.hasAnnotation(annotation, mutableSetOf()) == true
        }
    }

    private fun PsiClass.hasAnnotation(
        annotation: KClass<out Annotation>,
        visited: MutableSet<String>
    ): Boolean {
        val className = qualifiedName ?: return false
        if (!visited.add(className)) return false
        if (hasDirectAnnotation(annotation)) return true

        return annotations.any { entry ->
            entry.resolveAnnotationType()?.hasAnnotation(annotation, visited) == true
        }
    }

    private val PsiModifierListOwner.annotations: Array<out PsiAnnotation>
        get() = modifierList?.annotations.orEmpty()

    private val KtAnnotated.mode: RegistrationMode
        get() = project.service<RegistrationSettings>().state.mode

    private val PsiModifierListOwner.mode: RegistrationMode
        get() = project.service<RegistrationSettings>().state.mode

    private fun KtNamedFunction.isGodotLifecycleOverride(): Boolean =
        lifecycleFunctions.any { lifecycleFunction -> lifecycleFunction == name } &&
            containingClass()?.isOrInheritsType(KtObject::class.classId) == true

    private fun PsiMethod.isGodotLifecycleOverride(): Boolean =
        lifecycleFunctions.any { lifecycleFunction -> lifecycleFunction == name } &&
            containingClass?.isOrInheritsType(KtObject::class.classId) == true
}
