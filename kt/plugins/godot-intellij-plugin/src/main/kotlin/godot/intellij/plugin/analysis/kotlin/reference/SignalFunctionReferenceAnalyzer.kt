package godot.intellij.plugin.analysis.kotlin.reference

import com.intellij.psi.util.parentOfType
import godot.core.Signal
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import godot.intellij.plugin.project.isOrInheritsType
import godot.intellij.plugin.quickfix.TargetFunctionNotRegisteredQuickFix
import godot.intellij.plugin.registration.registrationPolicy
import org.jetbrains.kotlin.idea.references.KtSimpleNameReference
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.psi.KtCallableReferenceExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.scripting.resolve.classId
import org.jetbrains.kotlin.utils.addToStdlib.firstIsInstanceOrNull

object SignalFunctionReferenceAnalyzer {
    // signalTest.connect(this, ::testFuncRef)
    fun analyze(element: KtCallableReferenceExpression): List<GodotProblem> {
        val signalElement = element
            .parentOfType<KtDotQualifiedExpression>()
            ?.receiverExpression
            ?.references
            ?.firstIsInstanceOrNull<KtSimpleNameReference>()
            ?.resolve() as? KtProperty

        val isSignal = signalElement?.isOrInheritsType(Signal::class.classId) == true

        if (isSignal) {
            val targetFunction = element
                .callableReference
                .mainReference
                .resolve() as? KtNamedFunction

            if (targetFunction != null && !targetFunction.registrationPolicy.registersFunction(targetFunction)) {
                return listOf(
                    GodotProblem(
                        GodotPluginBundle.message("problem.signal.connection.connectedFunctionNotRegistered"),
                        element,
                        arrayOf(TargetFunctionNotRegisteredQuickFix())
                    )
                )
            }
        }

        return emptyList()
    }
}

