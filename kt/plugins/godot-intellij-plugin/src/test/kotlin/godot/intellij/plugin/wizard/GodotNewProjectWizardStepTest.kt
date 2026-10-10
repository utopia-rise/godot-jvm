package godot.intellij.plugin.wizard

import com.intellij.ide.util.projectWizard.WizardContext
import com.intellij.ide.wizard.NewProjectWizardBaseStep
import com.intellij.ide.wizard.RootNewProjectWizardStep
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import java.io.File

class GodotNewProjectWizardStepTest : BasePlatformTestCase() {
    fun testModuleIsCreatedInItsOwnDirectoryAndIncludedInTheBuild() {
        val projectDir = File(project.basePath!!)
        val settingsFile = File(projectDir, "settings.gradle.kts")
        projectDir.mkdirs()
        settingsFile.writeText("rootProject.name = \"root\"\n")
        try {
            val baseStep = NewProjectWizardBaseStep(RootNewProjectWizardStep(WizardContext(project, testRootDisposable)))
            baseStep.name = "game"
            baseStep.path = File(projectDir, "modules").path

            GodotNewProjectWizardStep(baseStep).setupProject(project)

            val moduleDir = File(projectDir, "modules/game")
            assertTrue(File(moduleDir, "build.gradle.kts").isFile)
            assertFalse("The module belongs to the parent Godot project", File(moduleDir, "project.godot").exists())
            assertTrue(settingsFile.readText(), settingsFile.readText().endsWith("include(\":modules:game\")"))
            moduleDir.walkBottomUp().forEach { file -> assertTrue("$file is still open", file.delete()) }
        } finally {
            projectDir.deleteRecursively()
        }
    }
}
