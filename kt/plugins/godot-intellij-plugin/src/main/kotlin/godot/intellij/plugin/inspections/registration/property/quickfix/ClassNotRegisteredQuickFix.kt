package godot.intellij.plugin.inspections.registration.property.quickfix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.project.Project
import godot.annotation.RegisterClass
import org.jetbrains.kotlin.idea.util.addAnnotation
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtModifierList
import org.jetbrains.kotlin.psi.KtModifierListOwner
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.resolve.ImportPath

class ClassNotRegisteredQuickFix : LocalQuickFix {
    override fun getFamilyName(): String {
        return "Add @RegisterClass annotation"
    }

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val ktClass = if (descriptor.psiElement is KtClass) {
            descriptor.psiElement
        } else {
            descriptor.psiElement.parent
        }

        ktClass
            .let { it as? KtModifierListOwner }
            ?.addAnnotation(FqName(RegisterClass::class.java.canonicalName))
    }
}
