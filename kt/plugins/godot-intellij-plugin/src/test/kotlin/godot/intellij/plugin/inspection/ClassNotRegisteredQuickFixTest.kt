package godot.intellij.plugin.inspection

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.openapi.components.service
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class ClassNotRegisteredQuickFixTest : CodeInsightFixtureTestBase() {
    fun testKotlinClassWithRegisteredMembers() = assertQuickFix(
        "Fixture.kt",
        """
            import godot.annotation.Visible
            import godot.api.Node

            class Fixture : Node() {
                @Visible
                var registered = 1
            }
        """,
        KotlinInspection()
    )

    private fun assertQuickFix(fileName: String, source: String, inspection: LocalInspectionTool) {
        myFixture.configureByText(fileName, source.trimIndent())
        project.service<RegistrationSettings>().state.mode = RegistrationMode.Explicit
        myFixture.enableInspections(inspection)
        myFixture.doHighlighting()
        val familyName = GodotPluginBundle.message("quickFix.class.notRegistered.familyName")
        myFixture.launchAction(myFixture.getAllQuickFixes().first { it.familyName == familyName })

        val highlights = myFixture.doHighlighting()
        assertEmpty(myFixture.file.text, highlights.filter { it.severity.name == "ERROR" })
        assertTrue(myFixture.file.text, myFixture.file.text.contains("Script"))
    }
}
