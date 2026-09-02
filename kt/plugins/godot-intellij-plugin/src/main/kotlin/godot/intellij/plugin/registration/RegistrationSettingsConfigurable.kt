package godot.intellij.plugin.registration

import com.intellij.codeInsight.daemon.DaemonCodeAnalyzer
import com.intellij.openapi.components.service
import com.intellij.openapi.options.Configurable
import com.intellij.openapi.project.Project
import com.intellij.ui.dsl.builder.panel
import godot.intellij.plugin.GodotJvmProjectService
import javax.swing.JCheckBox
import javax.swing.JComboBox
import javax.swing.JComponent

class RegistrationSettingsConfigurable(
    private val project: Project
) : Configurable {
    private val mode = JComboBox(RegistrationMode.entries.toTypedArray())
    private val registrationHighlights = JCheckBox("Show registration highlights")

    override fun getDisplayName(): String = "Godot-JVM"

    override fun createComponent(): JComponent =
        panel {
            row("Annotation processing mode:") {
                cell(mode)
            }
            row {
                cell(registrationHighlights)
            }
        }

    override fun isModified(): Boolean {
        val state = project.service<RegistrationSettings>().state
        return mode.selectedItem != state.mode ||
            registrationHighlights.isSelected != state.registrationHighlightsEnabled
    }

    override fun apply() {
        val settings = project.service<RegistrationSettings>()
        val selectedMode = mode.selectedItem as RegistrationMode
        val modeChanged = settings.state.mode != selectedMode
        val highlightsChanged =
            settings.state.registrationHighlightsEnabled != registrationHighlights.isSelected
        if (!modeChanged && !highlightsChanged) return

        settings.state.mode = selectedMode
        settings.state.registrationHighlightsEnabled = registrationHighlights.isSelected
        if (modeChanged) {
            project.service<GodotJvmProjectService>().refreshRegistrationIndex()
        }
        DaemonCodeAnalyzer.getInstance(project).settingsChanged()
    }

    override fun reset() {
        val state = project.service<RegistrationSettings>().state
        mode.selectedItem = state.mode
        registrationHighlights.isSelected = state.registrationHighlightsEnabled
    }
}
