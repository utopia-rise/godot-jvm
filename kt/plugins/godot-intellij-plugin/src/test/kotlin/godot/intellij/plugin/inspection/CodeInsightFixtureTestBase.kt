package godot.intellij.plugin.inspection

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.service
import com.intellij.openapi.projectRoots.JavaSdk
import com.intellij.openapi.projectRoots.ProjectJdkTable
import com.intellij.openapi.roots.ModuleRootModificationUtil
import com.intellij.openapi.vfs.newvfs.impl.VfsRootAccess
import com.intellij.testFramework.PsiTestUtil
import com.intellij.testFramework.fixtures.BasePlatformTestCase
import com.intellij.util.PathUtil
import godot.annotation.Script
import godot.api.Node
import godot.common.interop.NativeWrapper
import godot.core.KtObject
import godot.global.GD
import godot.intellij.plugin.highlighting.RegistrationHighlight
import godot.intellij.plugin.project.isInGodotRoot
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings
import java.io.File

abstract class CodeInsightFixtureTestBase : BasePlatformTestCase() {
    override fun setUp() {
        super.setUp()
        myFixture.addFileToProject("project.godot", "[application]\nconfig/name=\"Inspection Test\"")
        val jdk = JavaSdk.getInstance().createJdk("inspection-test-jdk", System.getProperty("java.home"))
        ApplicationManager.getApplication().runWriteAction {
            ProjectJdkTable.getInstance().addJdk(jdk, testRootDisposable)
        }
        ModuleRootModificationUtil.setModuleSdk(module, jdk)

        val libraryClasses = listOf(
            Unit::class.java,
            Script::class.java,
            NativeWrapper::class.java,
            KtObject::class.java,
            Node::class.java,
            GD::class.java,
            Class.forName("godot.extension.SignalConnectors")
        )
        libraryClasses
            .map(PathUtil::getJarPathForClass)
            .distinct()
            .forEachIndexed { index, path ->
                val library = File(path)
                VfsRootAccess.allowRootAccess(testRootDisposable, library.parent)
                PsiTestUtil.addLibrary(module, "godot-test-$index", library.parent, library.name)
            }
    }

    override fun getTestDataPath(): String =
        System.getProperty("godot.intellij.fixture.root")

    protected fun inspectFixture(
        fixturePath: String,
        inspection: LocalInspectionTool,
        mode: RegistrationMode = RegistrationMode.Explicit
    ): List<HighlightInfo> {
        val file = myFixture.copyFileToProject(fixturePath, fixturePath)
        myFixture.configureFromExistingVirtualFile(file)
        return inspectConfiguredFile(inspection, mode)
    }

    protected fun highlightSource(
        fileName: String,
        source: String,
        mode: RegistrationMode,
        highlightsEnabled: Boolean = true
    ): List<RegistrationHighlight> =
        registrationHighlightInfos(fileName, source, mode, highlightsEnabled).mapNotNull { highlight ->
            RegistrationHighlight.entries.firstOrNull { registrationHighlight ->
                highlight.forcedTextAttributes?.backgroundColor ==
                    registrationHighlight.textAttributes.backgroundColor
            }
        }

    protected fun registrationHighlightInfos(
        fileName: String,
        source: String,
        mode: RegistrationMode,
        highlightsEnabled: Boolean = true
    ): List<HighlightInfo> {
        // Automatic mode invokes K2 analysis, which is forbidden during the fixture's PSI write action.
        // Apply the requested mode after the source file has been created.
        project.service<RegistrationSettings>().state.mode = RegistrationMode.Inferred
        val file = myFixture.addFileToProject(fileName, source)
        myFixture.configureFromExistingVirtualFile(file.virtualFile)
        project.service<RegistrationSettings>().state.apply {
            this.mode = mode
            registrationHighlightsEnabled = highlightsEnabled
        }
        assertTrue(file.virtualFile.isInGodotRoot(project))

        val highlights = myFixture.doHighlighting()
        val compilerErrors = highlights.filter { highlight ->
            highlight.inspectionToolId == null &&
                highlight.severity.name == "ERROR" &&
                highlight.description != null
        }
        assertEmpty("Fixture has compiler errors", compilerErrors)

        val registrationColors = RegistrationHighlight.entries
            .mapTo(mutableSetOf()) { highlight -> highlight.textAttributes.backgroundColor }
        return highlights.filter { highlight ->
            highlight.forcedTextAttributes?.backgroundColor in registrationColors
        }
    }

    private fun inspectConfiguredFile(
        inspection: LocalInspectionTool,
        mode: RegistrationMode
    ): List<HighlightInfo> {
        project.service<RegistrationSettings>().state.mode = mode
        myFixture.enableInspections(inspection)
        val file = myFixture.file.virtualFile
        assertTrue(file.isInGodotRoot(project))

        val highlights = myFixture.doHighlighting()
        val compilerErrors = highlights.filter { highlight ->
            highlight.inspectionToolId == null &&
                highlight.severity.name == "ERROR" &&
                highlight.description != null
        }
        assertEmpty("Fixture has compiler errors", compilerErrors)

        return highlights.filter { highlight -> highlight.inspectionToolId == inspection.shortName }
    }

    protected fun assertProblems(
        actual: List<HighlightInfo>,
        vararg expected: ExpectedProblem
    ) {
        val actualProblems = actual
            .map { highlight ->
                ExpectedProblem(
                    severity = highlight.severity.name,
                    message = highlight.description ?: "",
                    count = 1
                )
            }
            .groupingBy { problem -> problem.copy(count = 1) }
            .eachCount()
            .map { (problem, count) -> problem.copy(count = count) }
            .sortedWith(compareBy(ExpectedProblem::severity, ExpectedProblem::message))

        assertEquals(
            expected.sortedWith(compareBy(ExpectedProblem::severity, ExpectedProblem::message)),
            actualProblems
        )
    }

    protected data class ExpectedProblem(
        val severity: String,
        val message: String,
        val count: Int = 1
    )

    protected fun error(message: String, count: Int = 1): ExpectedProblem =
        ExpectedProblem("ERROR", message, count)

    protected fun warning(message: String, count: Int = 1): ExpectedProblem =
        ExpectedProblem("WARNING", message, count)

    protected fun weakWarning(message: String, count: Int = 1): ExpectedProblem =
        ExpectedProblem("WEAK WARNING", message, count)
}
