package godot.intellij.plugin.quickfix

import com.intellij.lang.java.JavaLanguage
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiModifierListOwner
import org.jetbrains.kotlin.asJava.elements.KtLightElement
import org.jetbrains.kotlin.idea.util.addAnnotation
import org.jetbrains.kotlin.psi.KtModifierListOwner
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

/** Annotates the Kotlin, Java or Scala declaration that [element] is or names. */
internal fun annotateDeclaration(element: PsiElement, annotation: KClass<out Annotation>) {
    val declaration = element.takeIf { it is KtModifierListOwner || it is PsiModifierListOwner } ?: element.parent
    val owner = (declaration as? KtLightElement<*, *>)?.kotlinOrigin ?: declaration
    when {
        owner is KtModifierListOwner -> owner.addAnnotation(annotation.classId)
        owner !is PsiModifierListOwner -> return
        owner.language == JavaLanguage.INSTANCE -> owner.modifierList?.addAnnotation(annotation.qualifiedName!!)
        else -> {
            // Scala's PSI inserts the annotation followed by a blank line, which separates it from the declaration it annotates.
            val documentManager = PsiDocumentManager.getInstance(owner.project)
            val document = documentManager.getDocument(owner.containingFile) ?: return
            val start = owner.textRange.startOffset
            val indent = document.getText(TextRange(document.getLineStartOffset(document.getLineNumber(start)), start))
            document.insertString(start, "@${annotation.qualifiedName}\n$indent")
            documentManager.commitDocument(document)
        }
    }
}
