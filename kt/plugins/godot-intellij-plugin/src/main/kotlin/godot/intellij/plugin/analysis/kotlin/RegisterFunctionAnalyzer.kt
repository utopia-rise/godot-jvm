package godot.intellij.plugin.analysis.kotlin

import godot.annotation.Register
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.quickfix.FunctionNotRegisteredQuickFix
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.kotlin.analysis.api.analyze
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.containingClass
import org.jetbrains.kotlin.scripting.resolve.classId

object RegisterAnalyzer {
    private val functionNotRegisteredQuickFix = FunctionNotRegisteredQuickFix()

    fun analyze(function: KtNamedFunction): List<GodotProblem> {
        return buildList {
            if (overriddenRegisteredAbstractFunctionNotRegistered(function)) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.function.overriddenAbstractFunctionNotRegistered"),
                        function.nameIdentifier ?: function.navigationElement,
                        arrayOf(functionNotRegisteredQuickFix)
                    )
                )
            }
        }
    }

    private fun overriddenRegisteredAbstractFunctionNotRegistered(element: KtNamedFunction): Boolean {
        val policy = element.registrationPolicy
        return policy.reportsMissingRegistration &&
            !policy.registersFunction(element) &&
            element.containingClass()?.let(policy::registersClass) == true &&
            analyze(element) {
                element.symbol.allOverriddenSymbols.any { it.annotations.contains(Register::class.classId) }
            }
    }
}


