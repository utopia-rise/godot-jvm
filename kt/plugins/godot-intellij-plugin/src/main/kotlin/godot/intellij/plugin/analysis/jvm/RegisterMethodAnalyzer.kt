package godot.intellij.plugin.analysis.jvm

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import godot.common.constants.Constraints
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.registration.RegistrationPolicy
import godot.tools.common.constants.lifecycleFunctions

object RegisterMethodAnalyzer {
    fun analyze(method: PsiMethod): List<GodotProblem> {
        return buildList {
            if (
                method.containingClass?.let(RegistrationPolicy::registersClass) == true &&
                RegistrationPolicy.requiresGodotOverrideAnnotation(method) &&
                lifecycleFunctions.any { it == method.name } &&
                !RegistrationPolicy.registersFunction(method)
            ) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.function.notificationFunctionNotRegistered"),
                        method.nameIdentifier ?: method.navigationElement
                    )
                )
            }

            if (RegistrationPolicy.registersFunction(method)) {
                addAll(GenericRegistrationAnalyzer.analyze(method))
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
            }
        }
    }

    private fun physicalAnchor(vararg candidates: PsiElement?): PsiElement {
        return candidates.firstOrNull { candidate -> candidate?.isPhysical == true }
            ?: candidates.firstOrNull { candidate -> candidate?.isValid == true }
            ?: candidates.first()
            ?: throw IllegalStateException("Expected at least one anchor candidate")
    }
}


