package godot.intellij.plugin.quickfix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.project.Project
import godot.annotation.Rpc
import godot.annotation.RpcMode
import godot.intellij.plugin.GodotPluginBundle
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.psi.KtCallableReferenceExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.scripting.resolve.classId

class TargetFunctionsRpcAnnotationHasRpcModeDisabled : LocalQuickFix {
    override fun getFamilyName(): String = GodotPluginBundle.message("quickFix.function.connectedFunctionsRpcAnnotationHasRpcModeDisabled.familyName")

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val ktNamedFunction = (descriptor.psiElement as? KtCallableReferenceExpression)
            ?.callableReference
            ?.mainReference
            ?.resolve() as? KtNamedFunction

        val rpcAnnotationArguments = ktNamedFunction
            ?.findAnnotation(Rpc::class.classId)
            ?.valueArgumentList
            ?.arguments

        val rpcModeValueArgument = rpcAnnotationArguments
            ?.firstOrNull { it.isNamed() && it.getArgumentName()?.text == "rpcMode" }
            ?: rpcAnnotationArguments?.getOrNull(0)

        (rpcModeValueArgument?.getArgumentExpression() as? KtDotQualifiedExpression)
            ?.selectorExpression
            ?.replace(KtPsiFactory(project).createExpression(RpcMode.AUTHORITY.name))
    }
}
