package godot.intellij.plugin.project

import com.intellij.psi.PsiField
import com.intellij.psi.PsiModifier
import godot.core.KtObject
import org.jetbrains.kotlin.analysis.api.analyze
import org.jetbrains.kotlin.analysis.api.symbols.KaClassSymbol
import org.jetbrains.kotlin.analysis.api.symbols.KaCallableSymbol
import org.jetbrains.kotlin.analysis.api.types.KaType
import org.jetbrains.kotlin.analysis.api.types.symbol
import org.jetbrains.kotlin.name.ClassId
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.asJava.toLightClass
import org.jetbrains.kotlin.asJava.toLightElements
import org.jetbrains.kotlin.asJava.toLightMethods
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.scripting.resolve.classId

fun KtDeclaration.fqName(): String? {
    val declaration = this
    return analyze(this) {
        val symbol = declaration.symbol as? KaCallableSymbol ?: return@analyze null
        symbol.returnType.symbol?.classId?.asFqNameString()
    }
}

inline fun <T> KtDeclaration.withType(crossinline block: org.jetbrains.kotlin.analysis.api.KaSession.(KaType) -> T): T {
    val declaration = this
    return analyze(this) {
        val symbol = declaration.symbol as? KaCallableSymbol
            ?: error("Expected callable declaration, got ${declaration::class.simpleName}")
        block(symbol.returnType)
    }
}

fun KtDeclaration.isNullable(): Boolean = withType { declarationType -> declarationType.isMarkedNullable }

fun KtClass.isOrInheritsType(classId: ClassId): Boolean {
    val declaration = this
    return analyze(this) {
        val type = (declaration.symbol as? KaClassSymbol)?.defaultType ?: return@analyze false
        type.isClassType(classId) || type.allSupertypes.any { superType -> superType.isClassType(classId) }
    }
}

fun KtClass.isGodotScriptCandidate(): Boolean = isOrInheritsType(KtObject::class.classId)

fun KtClass.isPublicOnJvm(): Boolean = toLightClass()?.hasModifierProperty(PsiModifier.PUBLIC) == true

fun KtProperty.isRegistrableOnJvm(): Boolean {
    val accessors = toLightMethods()
    return if (accessors.isNotEmpty()) {
        accessors.all { it.hasModifierProperty(PsiModifier.PUBLIC) }
    } else {
        toLightElements().any { (it as? PsiField)?.hasModifierProperty(PsiModifier.PUBLIC) == true }
    }
}
