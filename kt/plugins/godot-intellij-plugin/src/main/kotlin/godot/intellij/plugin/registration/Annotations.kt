package godot.intellij.plugin.registration

import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiAnnotation
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifierListOwner
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtPrimaryConstructor
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

private fun KtAnnotated.hasDirectAnnotation(annotation: KClass<out Annotation>): Boolean =
    findAnnotation(annotation.classId) != null

internal fun KtAnnotated.hasAnnotation(annotation: KClass<out Annotation>, includeMetaAnnotations: Boolean): Boolean {
    if (hasDirectAnnotation(annotation)) return true
    if (!includeMetaAnnotations) return false
    val visited = HashSet<String>()
    return annotationEntries.any { entry -> entry.hasMetaAnnotation(annotation, visited) }
}

internal fun PsiModifierListOwner.hasAnnotation(annotation: KClass<out Annotation>, includeMetaAnnotations: Boolean): Boolean {
    if (hasAnnotation(annotation.qualifiedName!!)) return true
    if (!includeMetaAnnotations) return false
    val visited = HashSet<String>()
    return annotations.any { entry -> entry.annotationClass()?.hasAnnotation(annotation, visited) == true }
}

private fun KtClass.hasAnnotation(annotation: KClass<out Annotation>, visited: MutableSet<String>): Boolean {
    val className = fqName?.asString() ?: return false
    if (!visited.add(className)) return false
    if (hasDirectAnnotation(annotation)) return true
    return annotationEntries.any { entry -> entry.hasMetaAnnotation(annotation, visited) }
}

private fun KtAnnotationEntry.hasMetaAnnotation(annotation: KClass<out Annotation>, visited: MutableSet<String>): Boolean =
    when (val annotationClass = calleeExpression?.constructorReferenceExpression?.mainReference?.resolve()) {
        is KtClass -> annotationClass.hasAnnotation(annotation, visited)
        is KtPrimaryConstructor -> (annotationClass.parent as? KtClass)?.hasAnnotation(annotation, visited) == true
        is PsiClass -> annotationClass.hasAnnotation(annotation, visited)
        is PsiMethod -> annotationClass.containingClass?.hasAnnotation(annotation, visited) == true
        else -> false
    }

private fun PsiClass.hasAnnotation(annotation: KClass<out Annotation>, visited: MutableSet<String>): Boolean {
    val className = qualifiedName ?: return false
    if (!visited.add(className)) return false
    if (hasAnnotation(annotation.qualifiedName!!)) return true
    return annotations.any { entry -> entry.annotationClass()?.hasAnnotation(annotation, visited) == true }
}

// Annotations of Kotlin light elements do not resolve their type, so fall back to a lookup by name.
private fun PsiAnnotation.annotationClass(): PsiClass? =
    resolveAnnotationType() ?: qualifiedName?.let { name -> JavaPsiFacade.getInstance(project).findClass(name, resolveScope) }
