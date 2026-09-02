package godot.intellij.plugin.run

import com.intellij.execution.Executor
import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RuntimeConfigurationError
import com.intellij.execution.process.KillableColoredProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.process.ProcessTerminatedListener
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.util.io.FileUtil
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.project.godotRoot
import org.jdom.Element
import java.io.File

/**
 * Runs the Godot editor or the game of the current Godot project with a chosen JDK, so the JVM used by Godot does not
 * depend on machine wide settings.
 */
class GodotRunConfiguration(
    project: Project,
    factory: ConfigurationFactory,
    name: String
) : RunConfigurationBase<Element>(project, factory, name) {
    var godotExecutablePath: String = ""

    /** Name of a JDK known to the IDE. Empty means the project SDK. */
    var jdkName: String = ""
    var launchEditor: Boolean = true

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> = GodotRunConfigurationEditor(project)

    override fun checkConfiguration() {
        if (project.godotRoot == null) {
            throw RuntimeConfigurationError(GodotPluginBundle.message("run.configuration.error.noGodotProject"))
        }
        if (godotExecutablePath.isBlank()) {
            throw RuntimeConfigurationError(GodotPluginBundle.message("run.configuration.error.missingExecutable"))
        }
        if (!File(godotExecutablePath).exists()) {
            throw RuntimeConfigurationError(GodotPluginBundle.message("run.configuration.error.unknownExecutable"))
        }
        if (resolveJdkHome() == null) {
            throw RuntimeConfigurationError(GodotPluginBundle.message("run.configuration.error.unknownJdk"))
        }
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState =
        object : CommandLineState(environment) {
            override fun startProcess(): ProcessHandler {
                val godotRootDir = checkNotNull(project.godotRoot) { "Checked in checkConfiguration" }.godotRootDir
                return KillableColoredProcessHandler(buildCommandLine(godotRootDir, resolveJdkHome()))
                    .also(ProcessTerminatedListener::attach)
            }
        }

    fun buildCommandLine(godotRootDir: File, jdkHome: String?): GeneralCommandLine {
        val commandLine = GeneralCommandLine(godotExecutablePath)
            .withWorkDirectory(godotRootDir)
            .withParameters("--path", godotRootDir.absolutePath)

        if (launchEditor) {
            commandLine.addParameter("--editor")
        }

        if (jdkHome != null) {
            // Takes priority over the embedded JRE and the environment. Godot works with system independent paths.
            commandLine.addParameter("--jvm-path=${FileUtil.toSystemIndependentName(jdkHome)}")

            // Not needed to load the JVM, but tools Godot starts itself, such as Gradle, pick their JDK up from here.
            commandLine.withEnvironment("JAVA_HOME", jdkHome)
        }

        return commandLine
    }

    fun resolveJdkHome(): String? = when {
        jdkName.isEmpty() -> ProjectRootManager.getInstance(project).projectSdk?.homePath
        else -> ProjectJdkTable.getInstance().findJdk(jdkName)?.homePath
    }

    override fun writeExternal(element: Element) {
        super.writeExternal(element)
        element.setAttribute("godotExecutablePath", godotExecutablePath)
        element.setAttribute("jdkName", jdkName)
        element.setAttribute("launchEditor", launchEditor.toString())
    }

    override fun readExternal(element: Element) {
        super.readExternal(element)
        godotExecutablePath = element.getAttributeValue("godotExecutablePath").orEmpty()
        jdkName = element.getAttributeValue("jdkName").orEmpty()
        launchEditor = element.getAttributeValue("launchEditor")?.toBoolean() != false
    }
}
