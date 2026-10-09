package godot.intellij.plugin.analysis.kotlin

import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiEnumConstant
import godot.annotation.Export
import godot.core.VariantArray
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.analysis.jvm.GenericRegistrationAnalyzer
import godot.intellij.plugin.project.inherits
import godot.intellij.plugin.project.isBitField
import godot.intellij.plugin.project.isCoreType
import godot.intellij.plugin.project.isGodotPrimitive
import godot.intellij.plugin.project.isMappableProperty
import godot.intellij.plugin.project.isNullable
import godot.intellij.plugin.project.jvmType
import godot.intellij.plugin.project.typeArguments
import godot.intellij.plugin.quickfix.PropertyNotRegisteredQuickFix
import godot.intellij.plugin.quickfix.PropertyRemoveExportAnnotationQuickFix
import godot.intellij.plugin.registration.RegistrationPolicy
import godot.intellij.plugin.registration.RegistrationPolicy.hasEffectiveAnnotation
import org.jetbrains.kotlin.asJava.toLightElements
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.scripting.resolve.classId
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstance

object VisibleAnalyzer {
    private const val MAX_ENUM_ENTRIES_FOR_BIT_FLAG = 32
    private val notRegisteredQuickFixes = arrayOf(PropertyNotRegisteredQuickFix(), PropertyRemoveExportAnnotationQuickFix())

    fun analyze(property: KtProperty): List<GodotProblem> = buildList {
        val nameAnchor = property.nameIdentifier ?: property.navigationElement
        val valueAnchor = property.initializer?.psiOrParent ?: nameAnchor
        fun report(key: String, anchor: PsiElement = nameAnchor) = add(GodotProblem(GodotPluginBundle.message(key), anchor))

        val isRegistered = RegistrationPolicy.registersProperty(property)
        if (property.hasEffectiveAnnotation(Export::class) && !isRegistered) {
            add(GodotProblem(GodotPluginBundle.message("problem.property.export.notRegistered"), nameAnchor, notRegisteredQuickFixes))
        }
        if (!isRegistered) return@buildList

        addAll(GenericRegistrationAnalyzer.analyze(property.toLightElements().firstIsInstance()))
        val type = property.jvmType() ?: return@buildList
        val elementClass = (type.typeArguments.firstOrNull() as? PsiClassType)?.resolve()
        if (type.inherits(VariantArray::class.classId) && elementClass?.isEnum == true) {
            report("problem.property.registeredEnumListWithVariantArray", valueAnchor)
        }
        if (!type.isMappableProperty()) {
            report("problem.property.export.triedToExportUnsupportedType")
        }
        if (type.isBitField() && elementClass?.fields.orEmpty().count { it is PsiEnumConstant } > MAX_ENUM_ENTRIES_FOR_BIT_FLAG) {
            report("problem.property.hint.toManyEnumEntries", valueAnchor)
        }
        if (type.isCoreType() || type.isGodotPrimitive()) {
            if (property.hasModifier(KtTokens.LATEINIT_KEYWORD)) report("problem.property.lateinit.coreType")
            if (property.isNullable()) report("problem.property.nullable")
        }
    }
}
