package godot.intellij.plugin.quickfix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager
import godot.intellij.plugin.GodotPluginBundle

// The anchor is the declaration in Kotlin and Scala and the type element in Java, so the typed name is located by text.
class UseBaseCallbackTypeQuickFix(private val typedName: String, private val baseFqName: String) : LocalQuickFix {
    override fun getFamilyName(): String = GodotPluginBundle.message("quickFix.type.useBaseCallback.familyName")

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val element = descriptor.psiElement ?: return
        val document = PsiDocumentManager.getInstance(project).getDocument(element.containingFile) ?: return
        val range = element.textRange
        val text = document.getText(range)
        val match = Regex("""\b${Regex.escape(typedName)}\s*[<\[]""").find(text) ?: return
        var depth = 0
        var end = match.range.last
        while (end < text.length) {
            when (text[end]) {
                '<', '[' -> depth++
                '>', ']' -> depth--
            }
            if (depth == 0) break
            end++
        }
        if (depth != 0) return
        document.replaceString(range.startOffset + match.range.first, range.startOffset + end + 1, baseFqName)
    }
}
