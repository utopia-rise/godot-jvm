package godot.intellij.plugin.analysis.kotlin

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiEnumConstant
import godot.annotation.Export
import godot.annotation.Storage
import godot.annotation.Visible
import godot.core.KtObject
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
import godot.intellij.plugin.quickfix.PropertyMakePublicQuickFix
import godot.intellij.plugin.quickfix.PropertyNotRegisteredQuickFix
import godot.intellij.plugin.quickfix.PropertyRemoveExportAnnotationQuickFix
import godot.intellij.plugin.project.isRegistrableOnJvm
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.kotlin.asJava.toLightElements
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.scripting.resolve.classId
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstance

object VisibleAnalyzer {
    private const val MAX_ENUM_ENTRIES_FOR_BIT_FLAG = 32
    private val registerQuickFix = PropertyNotRegisteredQuickFix()
    private val exportNotRegisteredQuickFixes = arrayOf(registerQuickFix, PropertyRemoveExportAnnotationQuickFix())
    private val storageNotRegisteredQuickFixes = arrayOf(registerQuickFix)
    private val makePublicQuickFixes = arrayOf(PropertyMakePublicQuickFix())

    fun analyze(property: KtProperty): List<GodotProblem> = buildList {
        val policy = property.registrationPolicy
        val nameAnchor = property.nameIdentifier ?: property.navigationElement
        val valueAnchor = property.initializer?.psiOrParent ?: nameAnchor
        fun report(key: String, anchor: PsiElement = nameAnchor) = add(GodotProblem(GodotPluginBundle.message(key), anchor))

        if (!property.isRegistrableOnJvm()) {
            if (policy.hasAnnotation(property, Visible::class)) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.property.notPublic"),
                        nameAnchor,
                        makePublicQuickFixes,
                        ProblemHighlightType.WARNING
                    )
                )
            }
            return@buildList
        }

        val isRegistered = policy.registersProperty(property)
        if (policy.hasAnnotation(property, Export::class) && !isRegistered) {
            add(GodotProblem(GodotPluginBundle.message("problem.property.export.notRegistered"), nameAnchor, exportNotRegisteredQuickFixes))
        }
        if (policy.hasAnnotation(property, Storage::class) && !isRegistered) {
            add(GodotProblem(GodotPluginBundle.message("problem.property.storage.notRegistered"), nameAnchor, storageNotRegisteredQuickFixes))
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
        if ((type.isCoreType() || type.isGodotPrimitive()) && property.hasModifier(KtTokens.LATEINIT_KEYWORD)) {
            report("problem.property.lateinit.coreType")
        }
        if (property.isNullable() && !type.inherits(KtObject::class.classId) && !type.equalsToText("java.lang.Object")) {
            report("problem.property.nullable")
        }
    }
}
