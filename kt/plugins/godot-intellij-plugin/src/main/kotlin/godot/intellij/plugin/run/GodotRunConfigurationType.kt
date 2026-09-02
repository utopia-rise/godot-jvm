package godot.intellij.plugin.run

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import com.intellij.openapi.util.NotNullLazyValue
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.project.godotRoot

class GodotRunConfigurationType : ConfigurationTypeBase(
    ID,
    GodotPluginBundle.message("run.configuration.name"),
    GodotPluginBundle.message("run.configuration.description"),
    NotNullLazyValue.createValue { IconLoader.getIcon("/pluginIcon_small.svg", GodotRunConfigurationType::class.java) }
) {
    init {
        addFactory(GodotRunConfigurationFactory(this))
    }

    companion object {
        const val ID = "GodotJvmRunConfiguration"
    }
}

class GodotRunConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {
    override fun getId(): String = GodotRunConfigurationType.ID

    override fun createTemplateConfiguration(project: Project): RunConfiguration =
        GodotRunConfiguration(project, this, GodotPluginBundle.message("run.configuration.name"))

    /** The configuration only makes sense for projects that contain a Godot project. */
    override fun isApplicable(project: Project): Boolean = project.godotRoot != null
}
