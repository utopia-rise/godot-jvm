package godot.intellij.plugin.analysis.jvm

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMember
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiNameIdentifierOwner
import godot.annotation.Emit
import godot.annotation.Visible
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.registration.RegistrationPolicy
import godot.intellij.plugin.registration.registrationPolicy

object MemberShapeAnalyzer {
    fun analyze(member: PsiMember, anchor: PsiElement = (member as PsiNameIdentifierOwner).nameIdentifier ?: member.navigationElement): List<GodotProblem> {
        val policy = member.registrationPolicy
        val annotated = when (member) {
            is PsiField -> policy.hasAnnotation(member, Visible::class) || policy.hasAnnotation(member, Emit::class)
            is PsiMethod -> policy.registersFunction(member)
            else -> return emptyList()
        }
        if (!annotated) return emptyList()
        return buildList {
            if (!policy.isCandidate(member)) {
                add(warning("problem.member.ignored", anchor))
            }
            if (member is PsiMethod && member.hasOverloadRegistered(policy)) {
                add(warning("problem.function.overloaded", anchor))
            }
        }
    }

    private fun PsiMethod.hasOverloadRegistered(policy: RegistrationPolicy): Boolean {
        val parameterTypes = parameterList.parameters.map { it.type.canonicalText }
        return containingClass?.findMethodsByName(name, false).orEmpty().any { other ->
            other.parameterList.parameters.map { it.type.canonicalText } != parameterTypes && policy.registersFunction(other)
        }
    }

    fun warning(key: String, anchor: PsiElement): GodotProblem =
        GodotProblem(GodotPluginBundle.message(key), anchor, highlightType = ProblemHighlightType.WARNING)
}
