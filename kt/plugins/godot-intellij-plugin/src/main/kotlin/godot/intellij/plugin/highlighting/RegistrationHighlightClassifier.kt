package godot.intellij.plugin.highlighting

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiType
import godot.common.constants.Constraints
import godot.core.Signal
import godot.intellij.plugin.project.inherits
import godot.intellij.plugin.project.isMappableArgument
import godot.intellij.plugin.project.isMappableProperty
import godot.intellij.plugin.project.isMappableReturnType
import godot.intellij.plugin.project.isOrInheritsType
import godot.intellij.plugin.project.jvmType
import godot.intellij.plugin.registration.RegistrationPolicy
import org.jetbrains.kotlin.asJava.toLightMethods
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.psiUtil.containingClass
import org.jetbrains.kotlin.scripting.resolve.classId

object RegistrationHighlightClassifier {
    fun classify(klass: KtClass): RegistrationHighlight? {
        if (!RegistrationPolicy.isGodotScriptCandidate(klass)) return null
        return if (RegistrationPolicy.registersClass(klass)) {
            RegistrationHighlight.REGISTERED
        } else {
            RegistrationHighlight.CANDIDATE
        }
    }

    fun classify(klass: PsiClass): RegistrationHighlight? {
        if (!RegistrationPolicy.isGodotScriptCandidate(klass)) return null
        return if (RegistrationPolicy.registersClass(klass)) {
            RegistrationHighlight.REGISTERED
        } else {
            RegistrationHighlight.CANDIDATE
        }
    }

    fun classify(property: KtProperty): RegistrationHighlight? {
        val owner = property.containingClass() ?: return null
        if (!RegistrationPolicy.isGodotScriptCandidate(owner)) return null

        val signalSelected = RegistrationPolicy.registersSignal(property)
        val canRegister = property.hasPublicJvmMember() &&
            property.typeParameterList == null &&
            if (signalSelected) {
                !property.isVar && property.isOrInheritsType(Signal::class.classId)
            } else {
                property.jvmType()?.isMappableProperty() == true
            }

        return classify(
            canRegister = canRegister,
            isRegistered = RegistrationPolicy.registersClass(owner) &&
                (signalSelected || RegistrationPolicy.registersProperty(property))
        )
    }

    fun classify(function: KtNamedFunction): RegistrationHighlight? {
        val owner = function.containingClass() ?: return null
        if (!RegistrationPolicy.isGodotScriptCandidate(owner)) return null

        return classify(
            canRegister = function.toLightMethods().any { method -> method.canRegister() },
            isRegistered = RegistrationPolicy.registersClass(owner) &&
                RegistrationPolicy.registersFunction(function)
        )
    }

    fun classify(field: PsiField): RegistrationHighlight? {
        val owner = field.containingClass ?: return null
        return classifyJvmProperty(
            property = field,
            owner = owner,
            type = field.type,
            isImmutable = field.hasModifierProperty(PsiModifier.FINAL)
        )
    }

    fun classifyJvmProperty(
        property: PsiMember,
        owner: PsiClass,
        type: PsiType,
        isImmutable: Boolean
    ): RegistrationHighlight? {
        if (!RegistrationPolicy.isGodotScriptCandidate(owner)) return null

        val isSignal = type.inherits(Signal::class.classId)
        val signalSelected = RegistrationPolicy.registersSignal(property, owner, isSignal)
        val canRegister = property.hasModifierProperty(PsiModifier.PUBLIC) &&
            if (signalSelected) {
                isImmutable && isSignal
            } else {
                type.isMappableProperty()
            }

        return classify(
            canRegister = canRegister,
            isRegistered = RegistrationPolicy.registersClass(owner) &&
                (signalSelected || RegistrationPolicy.registersProperty(property, owner, canRegister))
        )
    }

    fun classify(method: PsiMethod): RegistrationHighlight? {
        if (method.isConstructor) return null
        val owner = method.containingClass ?: return null
        if (!RegistrationPolicy.isGodotScriptCandidate(owner)) return null

        return classify(
            canRegister = method.canRegister(),
            isRegistered = RegistrationPolicy.registersClass(owner) &&
                RegistrationPolicy.registersFunction(method)
        )
    }

    private fun classify(
        canRegister: Boolean,
        isRegistered: Boolean
    ): RegistrationHighlight = when {
        !canRegister -> RegistrationHighlight.INELIGIBLE
        isRegistered -> RegistrationHighlight.REGISTERED
        else -> RegistrationHighlight.CANDIDATE
    }

    private fun KtProperty.hasPublicJvmMember(): Boolean =
        !hasModifier(KtTokens.PRIVATE_KEYWORD) &&
            !hasModifier(KtTokens.PROTECTED_KEYWORD) &&
            setter?.let { accessor ->
                !accessor.hasModifier(KtTokens.PRIVATE_KEYWORD) &&
                    !accessor.hasModifier(KtTokens.PROTECTED_KEYWORD)
            } != false

    private fun PsiMethod.canRegister(): Boolean =
        hasModifierProperty(PsiModifier.PUBLIC) &&
            typeParameters.isEmpty() &&
            parameterList.parametersCount <= Constraints.MAX_ARGUMENT_COUNT &&
            parameterList.parameters.all { parameter -> parameter.type.isMappableArgument() } &&
            returnType?.isMappableReturnType() != false
}
