package godot.intellij.plugin.quickfix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDocumentManager
import godot.intellij.plugin.GodotPluginBundle

// The problem anchor differs per language (a type element, a name identifier or the whole declaration), so the typed
// name is located by text in the nearest enclosing element that contains it.
class UseBaseCallbackTypeQuickFix(private val typedName: String, private val baseFqName: String) : LocalQuickFix {
    override fun getFamilyName(): String = GodotPluginBundle.message("quickFix.type.useBaseCallback.familyName")

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        var element = descriptor.psiElement ?: return
        val document = PsiDocumentManager.getInstance(project).getDocument(element.containingFile) ?: return
        val pattern = Regex("""\b${Regex.escape(typedName)}\s*[<\[]""")
        var match = pattern.find(element.text)
        while (match == null) {
            element = element.parent ?: return
            match = pattern.find(element.text)
        }
        val text = element.text
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
        val start = element.textRange.startOffset
        document.replaceString(start + match.range.first, start + end + 1, baseFqName)
        PsiDocumentManager.getInstance(project).commitDocument(document)
    }
}
