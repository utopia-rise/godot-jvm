package godot.intellij.plugin.run

import godot.intellij.plugin.inspection.CodeInsightFixtureTestBase
import java.io.File

class GodotRunConfigurationTest : CodeInsightFixtureTestBase() {
    fun testCommandLineRunsTheEditorOfTheGodotProject() {
        val commandLine = configuration().buildCommandLine(GODOT_ROOT, null)

        assertEquals(GODOT_EXECUTABLE, commandLine.exePath)
        assertEquals(GODOT_ROOT, commandLine.workDirectory)
        assertEquals(listOf("--path", GODOT_ROOT.absolutePath, "--editor"), commandLine.parametersList.parameters)
    }

    fun testGameIsRunWithoutTheEditorParameter() {
        val commandLine = configuration()
            .apply { launchEditor = false }
            .buildCommandLine(GODOT_ROOT, null)

        assertEquals(listOf("--path", GODOT_ROOT.absolutePath), commandLine.parametersList.parameters)
    }

    fun testSelectedJdkIsForcedOnGodot() {
        val jdkHome = File(System.getProperty("java.home"))
        val commandLine = configuration().buildCommandLine(GODOT_ROOT, jdkHome.absolutePath)

        assertEquals(
            listOf(
                "--path",
                GODOT_ROOT.absolutePath,
                "--editor",
                "--jvm-path=${jdkHome.absolutePath.replace('\\', '/')}"
            ),
            commandLine.parametersList.parameters
        )
        assertEquals(jdkHome.absolutePath, commandLine.environment["JAVA_HOME"])
        assertNull("PATH must be left alone", commandLine.environment["PATH"])
    }

    private fun configuration(): GodotRunConfiguration {
        val factory = GodotRunConfigurationType().configurationFactories.single()
        return (factory.createTemplateConfiguration(project) as GodotRunConfiguration)
            .apply { godotExecutablePath = GODOT_EXECUTABLE }
    }

    private companion object {
        private val GODOT_ROOT = File("build/godot-run-configuration-test").absoluteFile
        private val GODOT_EXECUTABLE = File(GODOT_ROOT, "godot.editor.exe").absolutePath
    }
}
