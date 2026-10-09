package godot.intellij.plugin.project

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiPrimitiveType
import com.intellij.psi.PsiType
import com.intellij.psi.PsiTypes
import com.intellij.psi.PsiWildcardType
import godot.core.Callable
import godot.core.CoreType
import godot.core.Dictionary
import godot.core.KtObject
import godot.core.Signal
import godot.core.VariantArray
import org.jetbrains.kotlin.asJava.toLightElements
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.scripting.resolve.classId

private val boxedPrimitiveNames = setOf(
    "java.lang.Boolean", "java.lang.Byte", "java.lang.Character", "java.lang.Short", "java.lang.Integer",
    "java.lang.Long", "java.lang.Float", "java.lang.Double", "java.lang.String", "kotlin.String"
)
private val variantNames = setOf("java.lang.Object", "kotlin.Any")
private val godotContainerNames = setOf(VariantArray::class.qualifiedName, Dictionary::class.qualifiedName)
private val storableGodotClassIds = listOf("godot.api.Node", "godot.api.Resource").map { ClassId.topLevel(FqName(it)) }

fun KtDeclaration.jvmType(): PsiType? = toLightElements().firstNotNullOfOrNull { element ->
    (element as? PsiMethod)?.takeIf { it.parameterList.isEmpty }?.returnType ?: (element as? PsiField)?.type
}

fun KtDeclaration.isOrInheritsType(classId: ClassId): Boolean = jvmType()?.inherits(classId) == true

fun PsiType.inherits(classId: ClassId): Boolean = (this as? PsiClassType)?.resolve()?.isOrInheritsType(classId) == true

val PsiType.typeArguments: List<PsiType> get() = (this as? PsiClassType)?.parameters.orEmpty().toList()

fun PsiType.isGodotPrimitive(): Boolean =
    this is PsiPrimitiveType && this != PsiTypes.voidType() || className() in boxedPrimitiveNames

fun PsiType.isCoreType(): Boolean = inherits(CoreType::class.classId)

fun PsiType.isBitField(): Boolean = className() == "godot.core.BitField"

fun PsiType.isMappableArgument(): Boolean = when (this) {
    is PsiWildcardType -> bound?.isMappableArgument() != false
    is PsiClassType -> resolve() != null &&
        (
            className() in variantNames || isGodotPrimitive() || isCoreType() && typedCallbackBase() == null || isBitField() || isEnum() ||
                inherits(KtObject::class.classId)
            ) &&
        (className() !in godotContainerNames || typeArguments.all { it.isMappableArgument() })

    else -> isGodotPrimitive()
}

/** The base type a typed callable or signal must be declared as in a registered signature, or null for any other type. */
fun PsiType.typedCallbackBase(): String? = listOf(Callable::class, Signal::class)
    .firstOrNull { base -> inherits(base.classId) && className() != base.qualifiedName }
    ?.qualifiedName

fun PsiType.isMappableReturnType(): Boolean = this == PsiTypes.voidType() || isMappableArgument()

fun PsiType.isMappableProperty(): Boolean =
    if (inherits(KtObject::class.classId)) {
        storableGodotClassIds.any(::inherits)
    } else {
        isMappableArgument() || typedCallbackBase() != null || className() == "java.util.List" && typeArguments.firstOrNull()?.isEnum() == true
    }

private fun PsiType.isEnum(): Boolean = ((if (this is PsiWildcardType) bound else this) as? PsiClassType)?.resolve()?.isEnum == true

fun PsiType.className(): String? = (this as? PsiClassType)?.resolve()?.qualifiedName
