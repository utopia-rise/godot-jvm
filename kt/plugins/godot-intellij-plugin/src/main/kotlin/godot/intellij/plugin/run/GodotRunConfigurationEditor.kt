package godot.intellij.plugin.run

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ui.configuration.SdkComboBox
import com.intellij.openapi.roots.ui.configuration.SdkComboBoxModel
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.dsl.builder.columns
import com.intellij.ui.dsl.builder.panel
import godot.intellij.plugin.GodotPluginBundle
import javax.swing.JComponent

class GodotRunConfigurationEditor(project: Project) : SettingsEditor<GodotRunConfiguration>() {
    private val executableField = TextFieldWithBrowseButton().apply {
        addBrowseFolderListener(
            project,
            FileChooserDescriptorFactory
                .createSingleFileOrFolderDescriptor()
                .withTitle(GodotPluginBundle.message("run.configuration.executable.browseDialogTitle"))
        )
    }

    // Lists the project SDK, every JDK the IDE knows, and the JDKs detected on this machine.
    private val jdkComboBox = SdkComboBox(SdkComboBoxModel.createProjectJdkComboBoxModel(project, this))
    private val projectSdkItem = jdkComboBox.showProjectSdkItem()

    private val launchEditorCheckBox = JBCheckBox(GodotPluginBundle.message("run.configuration.launchEditor"))

    override fun createEditor(): JComponent = panel {
        row(GodotPluginBundle.message("run.configuration.executable")) {
            cell(executableField).columns(EXECUTABLE_FIELD_COLUMNS)
        }
        row(GodotPluginBundle.message("run.configuration.jdk")) {
            cell(jdkComboBox)
        }
        row {
            cell(launchEditorCheckBox)
        }
    }

    override fun resetEditorFrom(configuration: GodotRunConfiguration) {
        executableField.text = configuration.godotExecutablePath
        if (configuration.jdkName.isEmpty()) {
            jdkComboBox.selectedItem = projectSdkItem
        } else {
            jdkComboBox.setSelectedSdk(configuration.jdkName)
        }
        launchEditorCheckBox.isSelected = configuration.launchEditor
    }

    override fun applyEditorTo(configuration: GodotRunConfiguration) {
        configuration.godotExecutablePath = executableField.text.trim()
        configuration.jdkName = jdkComboBox.getSelectedSdk()?.name.orEmpty()
        configuration.launchEditor = launchEditorCheckBox.isSelected
    }

    private companion object {
        private const val EXECUTABLE_FIELD_COLUMNS = 40
    }
}
