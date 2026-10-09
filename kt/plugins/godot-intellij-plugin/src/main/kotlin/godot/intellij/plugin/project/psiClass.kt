package godot.intellij.plugin.project

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import godot.annotation.GodotBaseType
import godot.core.KtObject
import org.jetbrains.kotlin.idea.base.psi.classIdIfNonLocal
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.scripting.resolve.classId

val PsiClass.isAbstract: Boolean
    get() = isInterface || modifierList?.hasModifierProperty(PsiModifier.ABSTRACT) ?: false

fun PsiClass.isOrInheritsType(classId: ClassId): Boolean {
    return this.classIdIfNonLocal == classId || superTypes.any { superType -> superType.resolve()?.isOrInheritsType(classId) == true }
}

fun PsiClass.isGodotScriptCandidate(): Boolean = isOrInheritsType(KtObject::class.classId)

// A Scala `private` class still compiles to a public JVM class, which is what the processor reads.
fun PsiClass.isPublicOnJvm(): Boolean = language.id == "Scala" || hasModifierProperty(PsiModifier.PUBLIC)

fun PsiMethod.overridesGodotBaseMethod(): Boolean =
    findSuperMethods().any { superMethod -> superMethod.containingClass?.getAnnotation(GodotBaseType::class.qualifiedName!!) != null }
