package godot.intellij.plugin.project

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiModifier
import godot.annotation.Script
import org.jetbrains.kotlin.asJava.classes.KtLightClass
import org.jetbrains.kotlin.idea.base.psi.classIdIfNonLocal
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.psiUtil.isAbstract
import org.jetbrains.kotlin.scripting.resolve.classId
import kotlin.reflect.KClass

val PsiClass.isAbstract: Boolean
    get() = when (this) {
        is KtClass -> isAbstract()
        else -> isInterface || modifierList?.hasModifierProperty(PsiModifier.ABSTRACT) ?: false
    }

fun PsiClass.anyFunctionHasAnnotation(annotation: KClass<*>) = this
    .methods
    .filterIsInstance<PsiMethod>()
    .any { declaration ->
        declaration.getAnnotation(annotation.qualifiedName!!) != null
    }

fun PsiClass.anyPropertyHasAnnotation(annotation: KClass<*>) = when (this) {
    is KtLightClass -> (this.kotlinOrigin as? KtClass)?.getProperties()
        ?.any { property -> property.findAnnotation(annotation.classId) != null } == true

    else -> this
        .fields
        .any { declaration ->
            declaration.getAnnotation(annotation.qualifiedName!!) != null
        }
}

val PsiClass.isRegistered: Boolean
    get() = getAnnotation(Script::class.qualifiedName!!) != null


fun PsiClass.isOrInheritsType(classId: ClassId): Boolean {
    return this.classIdIfNonLocal == classId || superTypes.any { superType -> superType.resolve()?.isOrInheritsType(classId) == true }
}


