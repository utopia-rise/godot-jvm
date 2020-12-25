package godot.intellij.plugin.inspections.registration.property.quickfix

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.notification.Notifications
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.NotNullLazyValue
import godot.annotation.RegisterSignal
import org.jetbrains.kotlin.idea.util.addAnnotation
import org.jetbrains.kotlin.name.FqName
import org.jetbrains.kotlin.psi.KtModifierListOwner
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPsiFactory
import org.jetbrains.kotlin.psi.createDeclarationByPattern
import org.jetbrains.kotlin.psi.psiUtil.containingClass
import org.jetbrains.kotlin.resolve.ImportPath

class RegisterSignalInitializerQuickFix : LocalQuickFix {
    override fun getFamilyName(): String {
        return "Use \"by signal\" delegate"
    }

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val factory = KtPsiFactory(project)
        val propertyPsi = descriptor.psiElement.parent

        val newProperty = factory.createProperty((propertyPsi as KtProperty).name!!, null, false)
        val delegate = factory.createPropertyDelegate(factory.createExpression("signal()"))
        val property = propertyPsi.replace(newProperty)
        property.add(delegate)

        (property as KtModifierListOwner).addAnnotation(FqName(RegisterSignal::class.java.canonicalName))

        val baseImportPath = "godot.signals"
        val importDirective = factory.createImportDirective(ImportPath(FqName("$baseImportPath.signal"), false))
        val imports = property.containingKtFile.importList


        val fileAlreadyContainsImport = imports
            ?.imports
            ?.firstOrNull {
                it.importPath?.fqName?.asString() == baseImportPath && it.isAllUnder
                    || it.importPath?.fqName?.asString() == importDirective.importedFqName?.asString()
            } != null

        if (!fileAlreadyContainsImport) {
            imports?.psiOrParent?.add(importDirective)
        }
    }
}
