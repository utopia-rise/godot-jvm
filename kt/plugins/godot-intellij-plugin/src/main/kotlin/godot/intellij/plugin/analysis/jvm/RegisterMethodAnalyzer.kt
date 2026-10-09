package godot.intellij.plugin.analysis.jvm

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import godot.common.constants.Constraints
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.project.isMappableArgument
import godot.intellij.plugin.project.isMappableReturnType
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
            }
        }
    }

    private fun checkSignatureTypes(method: PsiMethod): List<GodotProblem> = buildList {
        val nameAnchor = physicalAnchor(method.nameIdentifier, method.navigationElement)
        method.parameterList.parameters.filterNot { it.type.isMappableArgument() }.forEach { parameter ->
            val message = GodotPluginBundle.message("problem.function.unsupportedParameterType", parameter.name, parameter.type.presentableText)
            add(GodotProblem(message, physicalAnchor(parameter.typeElement, parameter, nameAnchor)))
        }
        method.returnType?.takeUnless { it.isMappableReturnType() }?.let { returnType ->
            val message = GodotPluginBundle.message("problem.function.unsupportedReturnType", returnType.presentableText)
            add(GodotProblem(message, physicalAnchor(method.returnTypeElement, nameAnchor)))
        }
    }

    private fun physicalAnchor(vararg candidates: PsiElement?): PsiElement {
        return candidates.firstOrNull { candidate -> candidate?.isPhysical == true }
            ?: candidates.firstOrNull { candidate -> candidate?.isValid == true }
            ?: candidates.first()
            ?: throw IllegalStateException("Expected at least one anchor candidate")
    }
}


