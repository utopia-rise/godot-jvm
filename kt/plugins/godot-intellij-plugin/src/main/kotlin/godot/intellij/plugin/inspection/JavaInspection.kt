package godot.intellij.plugin.inspection

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import godot.intellij.plugin.analysis.jvm.GodotScriptAnalyzer
import godot.intellij.plugin.analysis.jvm.MemberShapeAnalyzer
import godot.intellij.plugin.analysis.jvm.RegisterMethodAnalyzer
import godot.intellij.plugin.analysis.registerProblems

class JavaInspection : GodotInspection() {
    override fun getDisplayName(): String = "Java registration checks"

    override fun checkElement(element: PsiElement, holder: ProblemsHolder, isOnTheFly: Boolean) {
        when (element) {
            is PsiClass -> holder.registerProblems(GodotScriptAnalyzer.analyze(element))
            is PsiField -> holder.registerProblems(MemberShapeAnalyzer.analyze(element))
            is PsiMethod -> {
                holder.registerProblems(MemberShapeAnalyzer.analyze(element))
                holder.registerProblems(RegisterMethodAnalyzer.analyze(element))
            }
        }
    }
}

