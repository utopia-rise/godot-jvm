package godot.intellij.plugin.analysis.kotlin.reference

import com.intellij.codeInspection.LocalQuickFix
import godot.annotation.Rpc
import godot.annotation.RpcMode
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.quickfix.TargetFunctionHasNoRpcAnnotationQuickFix
import godot.intellij.plugin.quickfix.TargetFunctionNotRegisteredQuickFix
import godot.intellij.plugin.quickfix.TargetFunctionsRpcAnnotationHasRpcModeDisabled
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.kotlin.idea.base.psi.kotlinFqName
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtCallableReferenceExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.psiUtil.getChildrenOfType
import org.jetbrains.kotlin.psi.psiUtil.getStrictParentOfType
import org.jetbrains.kotlin.scripting.resolve.classId

object FunctionReferenceTargetAnalyzer {
    private val calledByName = (0..16).map { "godot.core.methodCallable$it" }.toSet() + "godot.extension.connectMethod"
    private val calledByRpc = setOf("godot.api.Node.rpc", "godot.api.Node.rpcId")

    private val notRegisteredQuickFix by lazy { TargetFunctionNotRegisteredQuickFix() }
    private val noRpcAnnotationQuickFix by lazy { TargetFunctionHasNoRpcAnnotationQuickFix() }
    private val rpcModeDisabledQuickFix by lazy { TargetFunctionsRpcAnnotationHasRpcModeDisabled() }

    fun analyze(element: KtCallableReferenceExpression): List<GodotProblem> {
        val call = (element.parent as? KtValueArgument)?.getStrictParentOfType<KtCallExpression>() ?: return emptyList()
        val calledFunction = ((call.calleeExpression as? KtNameReferenceExpression)?.mainReference?.resolve() as? KtNamedFunction)
            ?.fqName
            ?.asString()
        val isRpc = calledFunction in calledByRpc
        if (!isRpc && calledFunction !in calledByName) return emptyList()

        val target = element.callableReference.mainReference.resolve() as? KtNamedFunction ?: return emptyList()
        if (!target.registrationPolicy.registersFunction(target)) {
            return problem(element, "problem.function.reference.notRegistered", notRegisteredQuickFix)
        }
        if (!isRpc) return emptyList()

        val rpcAnnotation = target.findAnnotation(Rpc::class.classId)
            ?: return problem(element, "problem.rpc.calledFunctionHasNoRpcAnnotation", noRpcAnnotationQuickFix)
        val arguments = rpcAnnotation.valueArgumentList?.arguments
        val rpcMode = arguments?.firstOrNull { it.isNamed() && it.getArgumentName()?.text == "rpcMode" }
            ?: arguments?.firstOrNull { !it.isNamed() }
        val isDisabled = rpcMode
            ?.getArgumentExpression()
            ?.getChildrenOfType<KtNameReferenceExpression>()
            ?.lastOrNull()
            ?.mainReference
            ?.resolve()
            ?.kotlinFqName
            ?.asString() == "${RpcMode::class.qualifiedName}.${RpcMode.DISABLED.name}"
        return if (isDisabled) problem(element, "problem.rpc.calledFunctionNotAccessible", rpcModeDisabledQuickFix) else emptyList()
    }

    private fun problem(element: KtCallableReferenceExpression, key: String, quickFix: LocalQuickFix) =
        listOf(GodotProblem(GodotPluginBundle.message(key), element, arrayOf(quickFix)))
}
