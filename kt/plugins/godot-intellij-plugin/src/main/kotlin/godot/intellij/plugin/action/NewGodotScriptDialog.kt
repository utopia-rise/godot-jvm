package godot.intellij.plugin.action

import com.intellij.ide.util.TreeClassChooserFactory
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.ComboBox
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.openapi.ui.ValidationInfo
import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.PsiClass
import com.intellij.psi.PsiDirectory
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiNameHelper
import com.intellij.psi.search.PsiShortNamesCache
import com.intellij.psi.util.InheritanceUtil
import com.intellij.ui.DocumentAdapter
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBTextField
import com.intellij.ui.dsl.builder.columns
import com.intellij.ui.dsl.builder.panel
import godot.core.KtObject
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationSettings
import godot.tools.common.constants.godotApiPackage
import godot.tools.common.constants.lifecycleFunctions
import javax.swing.JComponent
import javax.swing.event.DocumentEvent

class NewGodotScriptDialog(
    private val project: Project,
    private val directory: PsiDirectory,
    private val packageName: String
) : DialogWrapper(project) {
    internal val nameField = JBTextField()
    internal val languageComboBox = ComboBox(GodotScriptLanguage.available.toTypedArray())
        .apply { item = directory.sourceRootLanguage() }
    private val baseClassField = TextFieldWithBrowseButton().apply { text = DEFAULT_BASE_CLASS }
    private val lifecycleCheckBoxes = lifecycleFunctions.associateWith { lifecycleFunction ->
        JBCheckBox(lifecycleFunction, lifecycleFunction == "_ready")
    }

    init {
        title = GodotPluginBundle.message("action.newScript.dialog.title")
        baseClassField.addActionListener { chooseBaseClass() }
        baseClassField.textField.document.addDocumentListener(object : DocumentAdapter() {
            override fun textChanged(e: DocumentEvent) = updateLifecycleCheckBoxes()
        })
        init()
        updateLifecycleCheckBoxes()
    }

    override fun getPreferredFocusedComponent(): JComponent = nameField

    override fun createCenterPanel(): JComponent = panel {
        row(GodotPluginBundle.message("action.newScript.dialog.name")) {
            cell(nameField).columns(FIELD_COLUMNS)
        }
        row(GodotPluginBundle.message("action.newScript.dialog.language")) {
            cell(languageComboBox)
        }
        row(GodotPluginBundle.message("action.newScript.dialog.baseClass")) {
            cell(baseClassField).columns(FIELD_COLUMNS)
        }
        group(GodotPluginBundle.message("action.newScript.dialog.lifecycleFunctions")) {
            lifecycleCheckBoxes.values.forEach { checkBox ->
                row { cell(checkBox) }
            }
        }
    }

    override fun doValidate(): ValidationInfo? {
        val className = nameField.text.trim()
        if (!PsiNameHelper.getInstance(project).isIdentifier(className)) {
            return ValidationInfo(GodotPluginBundle.message("action.newScript.dialog.error.invalidName"), nameField)
        }

        if (directory.findFile("$className.${languageComboBox.item.fileExtension}") != null) {
            return ValidationInfo(GodotPluginBundle.message("action.newScript.dialog.error.fileExists"), nameField)
        }

        val baseClass = resolveBaseClass()
            ?: return ValidationInfo(GodotPluginBundle.message("action.newScript.dialog.error.unresolvedBaseClass"), baseClassField)

        if (!isGodotType(baseClass)) {
            return ValidationInfo(GodotPluginBundle.message("action.newScript.dialog.error.notAGodotType"), baseClassField)
        }

        return null
    }

    fun buildRequest(): NewGodotScriptRequest {
        val baseClass = requireNotNull(resolveBaseClass()) { "Base class has to be resolvable at this point" }
        return NewGodotScriptRequest(
            className = nameField.text.trim(),
            packageName = packageName,
            language = languageComboBox.item,
            baseClass = baseClass,
            lifecycleMethods = lifecycleCheckBoxes
                .filterValues { checkBox -> checkBox.isEnabled && checkBox.isSelected }
                .keys
                .mapNotNull { lifecycleFunction -> baseClass.lifecycleMethod(lifecycleFunction) },
            registrationMode = project.service<RegistrationSettings>().state.mode
        )
    }

    private fun chooseBaseClass() {
        val godotObject = findClass(KtObject::class.qualifiedName!!) ?: return
        val chooser = TreeClassChooserFactory
            .getInstance(project)
            .createInheritanceClassChooser(
                GodotPluginBundle.message("action.newScript.dialog.baseClass.chooserTitle"),
                directory.resolveScope,
                godotObject,
                resolveBaseClass()
            )
        chooser.showDialog()
        chooser.selected?.name?.let(baseClassField::setText)
    }

    /** Only lifecycle functions the selected base class actually provides can be overridden. */
    private fun updateLifecycleCheckBoxes() {
        val baseClass = resolveBaseClass()
        lifecycleCheckBoxes.forEach { (lifecycleFunction, checkBox) ->
            checkBox.isEnabled = baseClass?.lifecycleMethod(lifecycleFunction) != null
            if (!checkBox.isEnabled) checkBox.isSelected = false
        }
    }

    private fun PsiClass.lifecycleMethod(lifecycleFunction: String): PsiMethod? =
        findMethodsByName(lifecycleFunction, true).firstOrNull()

    /** Godot types are picked by their simple name, but a qualified name stays valid for anything ambiguous. */
    private fun resolveBaseClass(): PsiClass? {
        val name = baseClassField.text.trim()
        findClass(name)?.let { return it }

        val godotTypes = PsiShortNamesCache
            .getInstance(project)
            .getClassesByName(name, directory.resolveScope)
            .filter(::isGodotType)
        return godotTypes.firstOrNull { godotType -> godotType.qualifiedName?.startsWith("$godotApiPackage.") == true }
            ?: godotTypes.firstOrNull()
    }

    private fun findClass(qualifiedName: String): PsiClass? = qualifiedName
        .takeIf(String::isNotEmpty)
        ?.let { JavaPsiFacade.getInstance(project).findClass(it, directory.resolveScope) }

    private fun isGodotType(psiClass: PsiClass): Boolean =
        InheritanceUtil.isInheritor(psiClass, KtObject::class.qualifiedName!!)

    /** Godot-JVM projects keep one source root per language, so the right-clicked directory picks the default. */
    private fun PsiDirectory.sourceRootLanguage(): GodotScriptLanguage {
        val path = virtualFile.path.split('/')
        return GodotScriptLanguage.available.firstOrNull { language ->
            language.name.lowercase() in path
        } ?: GodotScriptLanguage.KOTLIN
    }

    private companion object {
        private const val FIELD_COLUMNS = 30
        private const val DEFAULT_BASE_CLASS = "Node"
    }
}
