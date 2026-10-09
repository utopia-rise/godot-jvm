package godot.intellij.plugin.analysis.kotlin

import godot.annotation.Emit
import godot.core.Signal
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.analysis.jvm.GenericRegistrationAnalyzer
import godot.intellij.plugin.project.inherits
import godot.intellij.plugin.project.isMappableArgument
import godot.intellij.plugin.project.jvmType
import godot.intellij.plugin.project.typeArguments
import godot.intellij.plugin.quickfix.EmitMutabilityQuickFix
import godot.intellij.plugin.registration.RegistrationPolicy
import godot.intellij.plugin.registration.RegistrationPolicy.hasEffectiveAnnotation
import org.jetbrains.kotlin.asJava.toLightElements
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.scripting.resolve.classId
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstance

object EmitAnalyzer {
    private val mutabilityQuickFix = EmitMutabilityQuickFix()

    fun analyze(property: KtProperty): List<GodotProblem> {
        if (
            !RegistrationPolicy.registersSignal(property) &&
            !property.hasEffectiveAnnotation(Emit::class)
        ) {
            return emptyList()
        }

        return buildList {
            addAll(GenericRegistrationAnalyzer.analyze(property.toLightElements().firstIsInstance()))
            if (property.isVar) {
                add(
                    GodotProblem(
                        GodotPluginBundle.message("problem.signal.mutability"),
                        property.valOrVarKeyword,
                        arrayOf(mutabilityQuickFix)
                    )
                )
            }
            val type = property.jvmType()
            val typeAnchor = property.typeReference ?: property.delegateExpression ?: property.initializer
                ?: property.nameIdentifier ?: property.navigationElement
            if (type?.inherits(Signal::class.classId) != true) {
                add(GodotProblem(GodotPluginBundle.message("problem.signal.wrongType"), typeAnchor))
                return@buildList
            }
            type.typeArguments.filterNot { it.isMappableArgument() }.forEach { argumentType ->
                val message = GodotPluginBundle.message("problem.signal.unsupportedArgumentType", argumentType.presentableText)
                add(GodotProblem(message, typeAnchor))
            }
        }
    }
}

