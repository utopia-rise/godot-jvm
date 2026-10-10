package godot.intellij.plugin.inspection

import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import godot.intellij.plugin.analysis.jvm.GodotScriptAnalyzer
import godot.intellij.plugin.analysis.jvm.RegisterMethodAnalyzer
import godot.intellij.plugin.analysis.kotlin.EmitAnalyzer
import godot.intellij.plugin.analysis.kotlin.PropertyHintAnalyzer
import godot.intellij.plugin.analysis.kotlin.RegisterAnalyzer
import godot.intellij.plugin.analysis.kotlin.RpcAnnotationAnalyzer
import godot.intellij.plugin.analysis.kotlin.VisibleAnalyzer
import godot.intellij.plugin.analysis.kotlin.reference.FunctionReferenceTargetAnalyzer
import godot.intellij.plugin.analysis.registerProblems
import godot.intellij.plugin.analysis.withPhysicalAnchor
import org.jetbrains.kotlin.asJava.toLightMethods
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtCallableReferenceExpression
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty

class KotlinInspection : GodotInspection() {
    override fun getDisplayName(): String = "Kotlin registration checks"

    override fun checkElement(element: PsiElement, holder: ProblemsHolder, isOnTheFly: Boolean) {
        if (element is KtAnnotated) {
            holder.registerProblems(RpcAnnotationAnalyzer.analyze(element))
        }

        when (element) {
            is KtClass -> {
                holder.registerProblems(GodotScriptAnalyzer.analyze(element).withPhysicalAnchor(element))
            }

            is KtProperty -> {
                holder.registerProblems(VisibleAnalyzer.analyze(element))
                holder.registerProblems(PropertyHintAnalyzer.analyze(element))
                holder.registerProblems(EmitAnalyzer.analyze(element))
            }

            is KtNamedFunction -> {
                element.toLightMethods().forEach { lightMethod ->
                    holder.registerProblems(RegisterMethodAnalyzer.analyze(lightMethod).withPhysicalAnchor(element))
                }
                holder.registerProblems(RegisterAnalyzer.analyze(element))
            }

            is KtCallableReferenceExpression -> {
                holder.registerProblems(FunctionReferenceTargetAnalyzer.analyze(element))
            }

        }
    }
}

