package godot.intellij.plugin.analysis.kotlin.reference

import godot.core.Callable
import godot.core.KtObject
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.project.isOrInheritsType
import godot.intellij.plugin.quickfix.TargetFunctionNotRegisteredQuickFix
import godot.intellij.plugin.registration.registrationPolicy
import godot.tools.common.constants.godotApiPackage
import godot.tools.common.constants.objectCallableFunctions
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtCallableReferenceExpression
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.psiUtil.containingClass
import org.jetbrains.kotlin.psi.psiUtil.isExtensionDeclaration
import org.jetbrains.kotlin.psi.psiUtil.parents
import org.jetbrains.kotlin.scripting.resolve.classId

object CallFunctionReferenceAnalyzer {
    fun analyze(element: KtCallableReferenceExpression): List<GodotProblem> {
        val parentCalls = element.parents.filterIsInstance<KtCallExpression>().toList()
        val isMethodCallableArgument = (parentCalls.firstOrNull()?.calleeExpression as? KtNameReferenceExpression)
            ?.text.orEmpty().startsWith("methodCallable")
        val relevantParent = parentCalls
            .firstOrNull { call ->
                val name = (call.calleeExpression as? KtNameReferenceExpression)?.text
                objectCallableFunctions.any { it == name }
            }
        val callReference = relevantParent?.calleeExpression as? KtNameReferenceExpression
        val containingClass = (callReference?.mainReference?.resolve() as? KtNamedFunction)?.containingClass()
        if (
            isMethodCallableArgument ||
            (
                relevantParent != null &&
                    objectCallableFunctions.any { it == callReference?.text } &&
                    isGodotFunction(containingClass, callReference)
                )
        ) {
            val targetFunction = element
                .callableReference
                .mainReference
                .resolve() as? KtNamedFunction

            if (targetFunction != null && !targetFunction.registrationPolicy.registersFunction(targetFunction)) {
                return listOf(
                    GodotProblem(
                        GodotPluginBundle.message("problem.general.calledFunctionNotRegistered"),
                        element,
                        arrayOf(TargetFunctionNotRegisteredQuickFix())
                    )
                )
            }
        }

        return emptyList()
    }

    private fun isGodotFunction(containingClass: KtClass?, callReference: KtNameReferenceExpression?) =
        containingClass?.isOrInheritsType(KtObject::class.classId) == true ||
            containingClass?.isOrInheritsType(Callable::class.classId) == true ||
            containingClass?.fqName?.asString()?.startsWith("godot.core.Callable") == true ||
            isGodotExtensionFunction(callReference)

    private fun isGodotExtensionFunction(callReference: KtNameReferenceExpression?): Boolean {
        return (callReference?.mainReference?.resolve() as? KtNamedFunction)?.isExtensionDeclaration() == true &&
            (callReference.mainReference.resolve() as? KtNamedFunction)?.fqName?.asString() == godotApiPackage + ".${callReference.text}"
    }
}

