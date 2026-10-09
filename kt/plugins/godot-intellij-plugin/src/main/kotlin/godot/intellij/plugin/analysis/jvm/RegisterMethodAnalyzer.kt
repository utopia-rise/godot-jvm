package godot.intellij.plugin.analysis.jvm

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiType
import com.intellij.psi.PsiTypes
import godot.annotation.Notification
import godot.common.constants.Constraints
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.project.isMappableArgument
import godot.intellij.plugin.project.isMappableReturnType
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.registration.registrationPolicy
import godot.intellij.plugin.project.overridesGodotBaseMethod
import godot.intellij.plugin.project.typedCallbackBase
import godot.intellij.plugin.quickfix.UseBaseCallbackTypeQuickFix

object RegisterMethodAnalyzer {
    fun analyze(method: PsiMethod): List<GodotProblem> {
        val policy = method.registrationPolicy
        val isRegistered = policy.registersFunction(method)
        return buildList {
            if (
                policy.reportsMissingRegistration &&
                !isRegistered &&
                method.overridesGodotBaseMethod() &&
                method.containingClass?.let(policy::registersClass) == true
            ) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.function.notificationFunctionNotRegistered"),
                        method.nameIdentifier ?: method.navigationElement
                    )
                )
            }

            if (isRegistered) {
                addAll(GenericRegistrationAnalyzer.analyze(method))
                if (method.typeParameters.isEmpty()) {
                    addAll(checkSignatureTypes(method))
                }
                if (method.parameterList.parametersCount > Constraints.MAX_ARGUMENT_COUNT) {
                    add(
                        GodotProblem(
                            GodotPluginBundle.message("problem.function.toManyParams", Constraints.MAX_ARGUMENT_COUNT),
                            physicalAnchor(
                                method.parameterList,
                                method.navigationElement,
                                method.nameIdentifier
                            )
                        )
                    )
                }
                if (policy.hasAnnotation(method, Notification::class)) {
                    addAll(checkNotificationSignature(method))
                }
            }
        }
    }

    private fun checkNotificationSignature(method: PsiMethod): List<GodotProblem> = buildList {
        val nameAnchor = physicalAnchor(method.nameIdentifier, method.navigationElement)
        if (!method.parameterList.isEmpty) {
            val message = GodotPluginBundle.message("problem.function.notificationHasParameters")
            add(GodotProblem(message, physicalAnchor(method.parameterList, nameAnchor)))
        }
        if (method.returnType != PsiTypes.voidType()) {
            val message = GodotPluginBundle.message("problem.function.notificationReturnsValue")
            add(GodotProblem(message, physicalAnchor(method.returnTypeElement, nameAnchor)))
        }
    }

    private fun checkSignatureTypes(method: PsiMethod): List<GodotProblem> = buildList {
        val nameAnchor = physicalAnchor(method.nameIdentifier, method.navigationElement)
        method.parameterList.parameters.filterNot { it.type.isMappableArgument() }.forEach { parameter ->
            val message = GodotPluginBundle.message("problem.function.unsupportedParameterType", parameter.name, parameter.type.presentableText)
            add(GodotProblem(message, physicalAnchor(parameter.typeElement, parameter, nameAnchor), parameter.type.callbackQuickFixes()))
        }
        method.returnType?.takeUnless { it.isMappableReturnType() }?.let { returnType ->
            val message = GodotPluginBundle.message("problem.function.unsupportedReturnType", returnType.presentableText)
            add(GodotProblem(message, physicalAnchor(method.returnTypeElement, nameAnchor), returnType.callbackQuickFixes()))
        }
    }

    private fun PsiType.callbackQuickFixes(): Array<LocalQuickFix> =
        typedCallbackBase()?.let { base -> arrayOf<LocalQuickFix>(UseBaseCallbackTypeQuickFix(presentableText.substringBefore('<'), base)) } ?: emptyArray()

    private fun physicalAnchor(vararg candidates: PsiElement?): PsiElement {
        return candidates.firstOrNull { candidate -> candidate?.isPhysical == true }
            ?: candidates.firstOrNull { candidate -> candidate?.isValid == true }
            ?: candidates.first()
            ?: throw IllegalStateException("Expected at least one anchor candidate")
    }
}


