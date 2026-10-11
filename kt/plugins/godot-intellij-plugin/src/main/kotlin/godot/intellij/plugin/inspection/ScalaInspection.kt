package godot.intellij.plugin.inspection

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiMethod
import godot.intellij.plugin.analysis.jvm.GodotScriptAnalyzer
import godot.intellij.plugin.analysis.jvm.MemberShapeAnalyzer
import godot.intellij.plugin.analysis.jvm.RegisterMethodAnalyzer
import godot.intellij.plugin.analysis.registerProblems
import godot.intellij.plugin.analysis.withPhysicalAnchor
import godot.annotation.Script
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.plugins.scala.lang.psi.api.toplevel.typedef.ScObject

class ScalaInspection : GodotInspection() {
    override fun getDisplayName(): String = "Scala registration checks"

    override fun checkElement(element: PsiElement, holder: ProblemsHolder, isOnTheFly: Boolean) {
        when (element) {
            // A Scala class's name identifier is a light copy, so the problem goes on the source leaf at its offset.
            is ScObject -> if (element.registrationPolicy.hasAnnotation(element, Script::class)) {
                holder.registerProblems(listOf(MemberShapeAnalyzer.warning("problem.class.object", element.sourceNameLeaf())))
            }
            is PsiClass -> holder.registerProblems(GodotScriptAnalyzer.analyze(element).withPhysicalAnchor(element.sourceNameLeaf()))
            is PsiMethod -> {
                holder.registerProblems(MemberShapeAnalyzer.analyze(element).withPhysicalAnchor(element))
                holder.registerProblems(RegisterMethodAnalyzer.analyze(element.javaView()).withPhysicalAnchor(element))
            }
        }
    }

    private fun PsiClass.sourceNameLeaf(): PsiElement =
        nameIdentifier?.let { identifier -> containingFile.findElementAt(identifier.textOffset) } ?: this

    // Scala function PSI reports `Object` as its Java return type; the class's Java-view wrapper carries the real one.
    private fun PsiMethod.javaView(): PsiMethod = containingClass?.methods?.firstOrNull { method ->
        method !== this && method.name == name && method.parameterTypes() == parameterTypes()
    } ?: this

    private fun PsiMethod.parameterTypes(): List<String> = parameterList.parameters.map { parameter -> parameter.type.canonicalText }
}
