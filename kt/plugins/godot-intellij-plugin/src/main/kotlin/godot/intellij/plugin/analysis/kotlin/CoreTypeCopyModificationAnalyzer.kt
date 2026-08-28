package godot.intellij.plugin.analysis.kotlin

import com.intellij.psi.PsiModifierListOwner
import godot.annotation.CoreTypeHelper
import godot.annotation.CoreTypeLocalCopy
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.analysis.GodotProblem
import org.jetbrains.kotlin.idea.references.mainReference
import org.jetbrains.kotlin.idea.util.findAnnotation
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtBinaryExpression
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtNameReferenceExpression
import org.jetbrains.kotlin.psi.KtQualifiedExpression
import org.jetbrains.kotlin.scripting.resolve.classId

/**
 * Detects the conservative subset of copy-mutation mistakes we care about:
 * either assignment chains or helper-call chains where an intermediate property
 * getter is marked with `@CoreTypeLocalCopy`.
 *
 * Flow:
 * 1. enter through either [analyzeAssignment] or [analyzeHelperCall]
 * 2. only inspect ordinary dot-qualified chains such as `a.b.c = ...` or `a.b.c { ... }`
 * 3. flatten the relevant chain into its name segments
 * 4. ignore the final segment, because it is either the actual assignment target
 *    or the helper call being intentionally invoked
 * 5. if any intermediate segment resolves to a `@CoreTypeLocalCopy` property,
 *    report it as "you are mutating a copy"
 *
 * This intentionally prefers false negatives over false positives.
 */
object CoreTypeCopyModificationAnalyzer {
    fun analyzeAssignment(expression: KtBinaryExpression): List<GodotProblem> {
        // Only assignment-like operations can mutate a nested copy in the way we
        // want to prevent. Everything else is out of scope for this inspection.
        if (!KtTokens.ALL_ASSIGNMENTS.contains(expression.operationToken)) {
            return emptyList()
        }

        // Stay conservative: only reason about straightforward qualified chains
        // like `transform.basis.x.x = 1.0`.
        val left = expression.left as? KtQualifiedExpression ?: return emptyList()

        // We only care about intermediate accesses. The last segment is the
        // target being assigned, while earlier segments are getter hops.
        val offendingAccess = findOffendingAccess(collectAccessChain(left)) ?: return emptyList()

        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.general.modificationOfCoreTypeCopy"),
                offendingAccess
            )
        )
    }

    fun analyzeHelperCall(expression: KtCallExpression): List<GodotProblem> {
        // Helper calls are only interesting when the called function is one of the
        // generated mutation helpers. Regular calls stay out of scope.
        if (!expression.resolvesToCoreTypeHelper()) {
            return emptyList()
        }

        // Only handle helper calls used as the selector of a simple qualified chain,
        // such as `transform.basis.x { ... }`.
        val qualifiedCall = expression.parent as? KtQualifiedExpression ?: return emptyList()
        val offendingAccess = findOffendingAccess(collectAccessChain(qualifiedCall)) ?: return emptyList()

        return listOf(
            GodotProblem(
                GodotPluginBundle.message("problem.general.modificationOfCoreTypeCopy"),
                offendingAccess
            )
        )
    }

    private fun findOffendingAccess(accessChain: List<KtNameReferenceExpression>): KtNameReferenceExpression? {
        return accessChain
            .dropLast(1)
            .firstOrNull { access -> access.resolvesToCoreTypeLocalCopy() }
    }

    // Flattens `a.b.c` into `[a, b, c]` so the caller can inspect each getter hop
    // independently. If the shape is more complex than a simple name chain, we
    // return an empty list and deliberately skip it.
    private fun collectAccessChain(expression: KtExpression): List<KtNameReferenceExpression> = when (expression) {
        is KtQualifiedExpression -> collectAccessChain(expression.receiverExpression) +
            listOfNotNull(
                expression.selectorExpression as? KtNameReferenceExpression
                    ?: (expression.selectorExpression as? KtCallExpression)?.calleeExpression as? KtNameReferenceExpression
            )

        is KtNameReferenceExpression -> listOf(expression)
        else -> emptyList()
    }

    // Resolves one access segment and checks whether it points at a property that
    // is explicitly marked as returning a local copy.
    private fun KtNameReferenceExpression.resolvesToCoreTypeLocalCopy(): Boolean {
        return when (val resolvedElement = mainReference.resolve()) {
            is KtAnnotated -> resolvedElement.findAnnotation(CoreTypeLocalCopy::class.classId) != null
            is PsiModifierListOwner -> resolvedElement.hasAnnotation(CoreTypeLocalCopy::class.qualifiedName!!)
            else -> false
        }
    }

    // The helper form is only valid when the last accessed function is explicitly
    // marked as a core-type mutation helper.
    private fun KtCallExpression.resolvesToCoreTypeHelper(): Boolean {
        val callee = calleeExpression as? KtNameReferenceExpression ?: return false
        return when (val resolvedElement = callee.mainReference.resolve()) {
            is KtAnnotated -> resolvedElement.findAnnotation(CoreTypeHelper::class.classId) != null
            is PsiModifierListOwner -> resolvedElement.hasAnnotation(CoreTypeHelper::class.qualifiedName!!)
            else -> false
        }
    }
}
