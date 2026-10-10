package godot.intellij.plugin.quickfix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.project.Project
import godot.annotation.Script
import godot.intellij.plugin.GodotPluginBundle

class ClassNotRegisteredQuickFix : LocalQuickFix {
    override fun getFamilyName(): String = GodotPluginBundle.message("quickFix.class.notRegistered.familyName")

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) = annotateDeclaration(descriptor.psiElement, Script::class)
}
