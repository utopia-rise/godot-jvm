package godot.intellij.plugin.quickfix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiModifierListOwner
import com.intellij.psi.util.parentOfType
import godot.intellij.plugin.GodotPluginBundle
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtClass

class ClassMakePublicQuickFix : LocalQuickFix {
    override fun getFamilyName(): String = GodotPluginBundle.message("quickFix.class.makePublic.familyName")

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val element = descriptor.psiElement
        val ktClass = element as? KtClass ?: element.parentOfType<KtClass>()
        if (ktClass != null) {
            ktClass.removeModifier(KtTokens.PRIVATE_KEYWORD)
            ktClass.removeModifier(KtTokens.PROTECTED_KEYWORD)
            return
        }
        val owner = element as? PsiModifierListOwner ?: element.parentOfType<PsiModifierListOwner>()
        owner?.modifierList?.setModifierProperty(PsiModifier.PUBLIC, true)
    }
}
