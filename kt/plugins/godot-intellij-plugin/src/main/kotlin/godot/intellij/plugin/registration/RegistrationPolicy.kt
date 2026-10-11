package godot.intellij.plugin.registration

import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.components.service
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiModifierListOwner
import com.intellij.psi.PsiTypes
import godot.annotation.Emit
import godot.annotation.Export
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
import godot.intellij.plugin.project.jvmType
import godot.intellij.plugin.project.overridesGodotBaseMethod
import org.jetbrains.kotlin.asJava.toLightClass
import org.jetbrains.kotlin.asJava.toLightElements
import org.jetbrains.kotlin.asJava.toLightMethods
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.containingClassOrObject
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

val PsiElement.registrationPolicy: RegistrationPolicy
    get() = RegistrationPolicy.of(project.service<RegistrationSettings>().state.mode)

/**
 * Decides what a declaration registers as, the way the build does. Every mode reads the same annotations,
 * meta-annotations included; the mode only sets the annotation assumed on a candidate (a public class, a public
 * instance member) that has none written. A written annotation replaces that default.
 */
class RegistrationPolicy private constructor(private val mode: RegistrationMode) {
    val reportsMissingRegistration: Boolean get() = mode != RegistrationMode.Automatic

    fun hasAnnotation(element: KtAnnotated, annotation: KClass<out Annotation>): Boolean = element.hasAnnotation(annotation)

    fun hasAnnotation(element: PsiModifierListOwner, annotation: KClass<out Annotation>): Boolean = element.hasAnnotation(annotation)

    fun isCandidate(klass: KtClass): Boolean = klass.toLightClass()?.hasModifierProperty(PsiModifier.PUBLIC) == true

    // A Scala `private` class still compiles to a public JVM class, which is what the processor reads.
    fun isCandidate(klass: PsiClass): Boolean = klass.language.id == "Scala" || klass.hasModifierProperty(PsiModifier.PUBLIC)

    fun isCandidate(property: KtProperty): Boolean {
        val accessors = property.toLightMethods()
        return if (accessors.isNotEmpty()) accessors.all(::isCandidate)
        else property.toLightElements().any { it is PsiField && isCandidate(it) }
    }

    // Scala members never report PUBLIC, so the check lists what excludes a member instead.
    fun isCandidate(member: PsiMember): Boolean = excludingModifiers.none(member::hasModifierProperty)

    fun registersClass(klass: KtClass): Boolean =
        hasAnnotation(klass, Script::class) || mode == RegistrationMode.Automatic && isCandidate(klass) && klass.isGodotScriptCandidate()

    fun registersClass(klass: PsiClass): Boolean =
        hasAnnotation(klass, Script::class) || mode == RegistrationMode.Automatic && isCandidate(klass) && klass.isGodotScriptCandidate()

    fun registersProperty(property: KtProperty): Boolean =
        hasAnnotation(property, Visible::class) ||
            mode == RegistrationMode.Automatic &&
            isCandidate(property) &&
            (property.containingClassOrObject as? KtClass)?.let(::registersClass) == true &&
            property.jvmType()?.let { it.isMappableProperty() && !it.inherits(Signal::class.classId) } == true

    fun registersProperty(property: PsiMember, ownerRegistered: Boolean, isCompatible: Boolean): Boolean =
        hasAnnotation(property, Visible::class) || mode == RegistrationMode.Automatic && ownerRegistered && isCandidate(property) && isCompatible

    fun exportsProperty(property: KtProperty): Boolean =
        hasAnnotation(property, Export::class) || mode == RegistrationMode.Automatic && !hasAnnotation(property, Visible::class)

    fun registersSignal(property: KtProperty): Boolean =
        hasAnnotation(property, Emit::class) ||
            mode != RegistrationMode.Explicit &&
            isCandidate(property) &&
            (property.containingClassOrObject as? KtClass)?.let(::registersClass) == true &&
            property.isOrInheritsType(Signal::class.classId)

    fun registersSignal(property: PsiMember, ownerRegistered: Boolean, isSignal: Boolean): Boolean =
        hasAnnotation(property, Emit::class) || mode != RegistrationMode.Explicit && ownerRegistered && isCandidate(property) && isSignal

    fun registersFunction(function: KtNamedFunction): Boolean =
        hasAnnotation(function, Register::class) || function.toLightMethods().any(::assumesRegistered)

    fun registersFunction(method: PsiMethod): Boolean = hasAnnotation(method, Register::class) || assumesRegistered(method)

    private fun assumesRegistered(method: PsiMethod): Boolean =
        !method.isConstructor &&
            isCandidate(method) &&
            when (mode) {
                RegistrationMode.Explicit -> false
                RegistrationMode.Inferred -> method.overridesGodotBaseMethod()
                RegistrationMode.Automatic ->
                    method.containingClass?.let(::registersClass) == true &&
                        !method.isJavaPropertyAccessor() &&
                        method.parameterList.parameters.all { it.type.isMappableArgument() } &&
                        method.returnType?.isMappableReturnType() != false
            }

    companion object {
        private val excludingModifiers = listOf(PsiModifier.PRIVATE, PsiModifier.PROTECTED, PsiModifier.PACKAGE_LOCAL, PsiModifier.STATIC)
        private val policies = RegistrationMode.entries.associateWith(::RegistrationPolicy)

        fun of(mode: RegistrationMode): RegistrationPolicy = policies.getValue(mode)
    }
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
