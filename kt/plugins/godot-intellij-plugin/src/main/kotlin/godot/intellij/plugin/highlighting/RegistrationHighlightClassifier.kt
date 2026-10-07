package godot.intellij.plugin.highlighting

import com.intellij.psi.PsiArrayType
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiPrimitiveType
import com.intellij.psi.PsiType
import godot.common.constants.Constraints
import godot.core.BitFieldBase
import godot.core.CoreType
import godot.core.KtObject
import godot.core.Signal
import godot.intellij.plugin.project.isCoreType
import godot.intellij.plugin.project.isOrInheritsType
import godot.intellij.plugin.project.isSupportedJvmType
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
                property.isCoreType() ||
                    property.isSupportedJvmType() ||
                    property.isOrInheritsType(KtObject::class.classId)
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

        val isSignal = (type as? PsiClassType)
            ?.resolve()
            ?.isOrInheritsType(Signal::class.classId) == true
        val signalSelected = RegistrationPolicy.registersSignal(property, owner, isSignal)
        val canRegister = property.hasModifierProperty(PsiModifier.PUBLIC) &&
            if (signalSelected) {
                isImmutable && isSignal
            } else {
                type.isMappable()
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
            parameterList.parameters.all { parameter -> parameter.type.isMappable() } &&
            (returnType?.isMappable() ?: true)

    private fun PsiType.isMappable(): Boolean = when (this) {
        is PsiPrimitiveType -> true
        is PsiArrayType -> componentType.isMappable()
        is PsiClassType -> resolve()?.isMappable() == true
        else -> false
    }

    private fun PsiClass.isMappable(): Boolean =
        qualifiedName in boxedAndUniversalTypes ||
            isEnum ||
            isInterface ||
            isOrInheritsType(KtObject::class.classId) ||
            isOrInheritsType(CoreType::class.classId) ||
            isOrInheritsType(BitFieldBase::class.classId)

    private val boxedAndUniversalTypes = setOf(
        "java.lang.Boolean",
        "java.lang.Byte",
        "java.lang.Character",
        "java.lang.Double",
        "java.lang.Float",
        "java.lang.Integer",
        "java.lang.Long",
        "java.lang.Object",
        "java.lang.Short",
        "java.lang.String",
        "kotlin.Any",
        "kotlin.String"
    )
}
