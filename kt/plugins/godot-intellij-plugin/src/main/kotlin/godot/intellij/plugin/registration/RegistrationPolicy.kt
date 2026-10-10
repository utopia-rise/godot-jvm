package godot.intellij.plugin.registration

import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.components.service
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiModifierListOwner
import com.intellij.psi.PsiTypes
import godot.annotation.Emit
import godot.annotation.Export
import godot.annotation.Notification
import godot.annotation.Register
import godot.annotation.Script
import godot.annotation.Visible
import godot.core.Signal
import godot.intellij.plugin.project.inherits
import godot.intellij.plugin.project.isGodotScriptCandidate
import godot.intellij.plugin.project.isMappableArgument
import godot.intellij.plugin.project.isMappableProperty
import godot.intellij.plugin.project.isMappableReturnType
import godot.intellij.plugin.project.isOrInheritsType
import godot.intellij.plugin.project.isPublicOnJvm
import godot.intellij.plugin.project.isRegistrableOnJvm
import godot.intellij.plugin.project.jvmType
import godot.intellij.plugin.project.overridesGodotBaseMethod
import org.jetbrains.kotlin.asJava.toLightMethods
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.containingClassOrObject
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

val PsiElement.registrationPolicy: RegistrationPolicy
    get() = when (project.service<RegistrationSettings>().state.mode) {
        RegistrationMode.Explicit -> ExplicitRegistrationPolicy
        RegistrationMode.Inferred -> InferredRegistrationPolicy
        RegistrationMode.Automatic -> AutomaticRegistrationPolicy
    }

sealed interface RegistrationPolicy {
    val reportsMissingRegistration: Boolean get() = true
    val includesMetaAnnotations: Boolean get() = true

    fun hasAnnotation(element: KtAnnotated, annotation: KClass<out Annotation>): Boolean =
        element.hasAnnotation(annotation, includesMetaAnnotations)

    fun hasAnnotation(element: PsiModifierListOwner, annotation: KClass<out Annotation>): Boolean =
        element.hasAnnotation(annotation, includesMetaAnnotations)

    fun registersClass(klass: KtClass): Boolean = klass.isPublicOnJvm() && hasAnnotation(klass, Script::class)

    fun registersClass(klass: PsiClass): Boolean = klass.isPublicOnJvm() && hasAnnotation(klass, Script::class)

    fun registersProperty(property: KtProperty): Boolean =
        property.isRegistrableOnJvm() && hasAnnotation(property, Visible::class)

    fun registersProperty(property: PsiMember, ownerRegistered: Boolean, isCompatible: Boolean): Boolean =
        hasAnnotation(property, Visible::class)

    fun exportsProperty(property: KtProperty): Boolean = hasAnnotation(property, Export::class)

    fun registersSignal(property: KtProperty): Boolean = hasAnnotation(property, Emit::class)

    fun registersSignal(property: PsiMember, ownerRegistered: Boolean, isSignal: Boolean): Boolean =
        hasAnnotation(property, Emit::class)

    fun registersFunction(function: KtNamedFunction): Boolean =
        hasAnnotation(function, Register::class) || hasAnnotation(function, Notification::class)

    fun registersFunction(method: PsiMethod): Boolean =
        hasAnnotation(method, Register::class) || hasAnnotation(method, Notification::class)
}

private object ExplicitRegistrationPolicy : RegistrationPolicy {
    override val includesMetaAnnotations: Boolean get() = false
}

private object InferredRegistrationPolicy : RegistrationPolicy {
    override fun registersSignal(property: KtProperty): Boolean =
        hasAnnotation(property, Emit::class) ||
            (property.containingClassOrObject as? KtClass)?.let(::registersClass) == true && property.isOrInheritsType(Signal::class.classId)

    override fun registersSignal(property: PsiMember, ownerRegistered: Boolean, isSignal: Boolean): Boolean =
        hasAnnotation(property, Emit::class) || ownerRegistered && isSignal

    override fun registersFunction(function: KtNamedFunction): Boolean =
        hasAnnotation(function, Register::class) || function.toLightMethods().any(PsiMethod::overridesGodotBaseMethod)

    override fun registersFunction(method: PsiMethod): Boolean =
        hasAnnotation(method, Register::class) || method.overridesGodotBaseMethod()
}

private object AutomaticRegistrationPolicy : RegistrationPolicy {
    override val reportsMissingRegistration: Boolean get() = false

    override fun registersClass(klass: KtClass): Boolean = klass.isPublicOnJvm() && klass.isGodotScriptCandidate()

    override fun registersClass(klass: PsiClass): Boolean = klass.isPublicOnJvm() && klass.isGodotScriptCandidate()

    override fun registersProperty(property: KtProperty): Boolean =
        property.isRegistrableOnJvm() &&
            (property.containingClassOrObject as? KtClass)?.let(::registersClass) == true &&
            (
                hasAnnotation(property, Visible::class) ||
                    property.jvmType()?.let { it.isMappableProperty() && !it.inherits(Signal::class.classId) } == true
                )

    override fun registersProperty(property: PsiMember, ownerRegistered: Boolean, isCompatible: Boolean): Boolean =
        ownerRegistered && isCompatible

    override fun exportsProperty(property: KtProperty): Boolean =
        !hasAnnotation(property, Visible::class) || hasAnnotation(property, Export::class)

    override fun registersSignal(property: KtProperty): Boolean =
        (property.containingClassOrObject as? KtClass)?.let(::registersClass) == true &&
            property.isOrInheritsType(Signal::class.classId) &&
            (hasAnnotation(property, Emit::class) || property.isRegistrableOnJvm())

    override fun registersSignal(property: PsiMember, ownerRegistered: Boolean, isSignal: Boolean): Boolean =
        ownerRegistered &&
            isSignal &&
            (hasAnnotation(property, Emit::class) || property.hasModifierProperty(PsiModifier.PUBLIC))

    override fun registersFunction(function: KtNamedFunction): Boolean =
        function.toLightMethods().any(::registersFunction)

    override fun registersFunction(method: PsiMethod): Boolean =
        method.containingClass?.let(::registersClass) == true &&
            !method.isConstructor &&
            (
                hasAnnotation(method, Register::class) ||
                    method.hasModifierProperty(PsiModifier.PUBLIC) &&
                    !method.isJavaPropertyAccessor() &&
                    method.parameterList.parameters.all { it.type.isMappableArgument() } &&
                    method.returnType?.isMappableReturnType() != false
                )
}

// The build reads JavaBean accessors as the property they belong to, so they only become functions with `@Register`.
private fun PsiMethod.isJavaPropertyAccessor(): Boolean {
    if (language != JavaLanguage.INSTANCE) return false
    val owner = containingClass ?: return false
    val returnsValue = returnType != PsiTypes.voidType()
    return when {
        parameterList.isEmpty && returnsValue ->
            name.length > 3 && name.startsWith("get") ||
                name.length > 2 && name.startsWith("is") && returnType?.canonicalText in setOf("boolean", "java.lang.Boolean")
        parameterList.parametersCount == 1 && !returnsValue && name.length > 3 && name.startsWith("set") -> {
            val suffix = name.removePrefix("set")
            owner.findFieldByName(suffix.replaceFirstChar(Char::lowercaseChar), false) != null ||
                (owner.findMethodsByName("get$suffix", false) + owner.findMethodsByName("is$suffix", false)).any { getter ->
                    getter.parameterList.isEmpty && getter.returnType != PsiTypes.voidType()
                }
        }
        else -> false
    }
}
