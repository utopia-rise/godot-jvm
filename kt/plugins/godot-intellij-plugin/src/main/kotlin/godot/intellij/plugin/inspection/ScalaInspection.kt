package godot.intellij.plugin.inspection

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import godot.intellij.plugin.analysis.jvm.GodotScriptAnalyzer
import godot.intellij.plugin.analysis.jvm.RegisterMethodAnalyzer
import godot.intellij.plugin.analysis.registerProblems
import godot.intellij.plugin.analysis.withPhysicalAnchor

class ScalaInspection : GodotInspection() {
    override fun getDisplayName(): String = "Scala registration checks"

    override fun checkElement(element: PsiElement, holder: ProblemsHolder, isOnTheFly: Boolean) {
        when (element) {
            is PsiClass -> holder.registerProblems(GodotScriptAnalyzer.analyze(element).withPhysicalAnchor(element))
            is PsiMethod -> holder.registerProblems(RegisterMethodAnalyzer.analyze(element.javaView()).withPhysicalAnchor(element))
        }
    }

    // Scala function PSI reports `Object` as its Java return type; the class's Java-view wrapper carries the real one.
    private fun PsiMethod.javaView(): PsiMethod = containingClass?.methods?.firstOrNull { method ->
        method !== this && method.name == name && method.parameterList.parametersCount == parameterList.parametersCount
    } ?: this
}
