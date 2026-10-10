package godot.intellij.plugin.inspection

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.openapi.components.service
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class FunctionNotRegisteredQuickFixTest : CodeInsightFixtureTestBase() {
    fun testKotlinLifecycleOverride() = assertQuickFix(
        "Fixture.kt",
        """
            import godot.annotation.Script
            import godot.api.Node

            @Script
            class Fixture : Node() {
                override fun _ready() {
                }
            }
        """,
        KotlinInspection()
    )

    fun testKotlinOverriddenRegisteredAbstractFunction() = assertQuickFix(
        "Fixture.kt",
        """
            import godot.annotation.Register
            import godot.annotation.Script
            import godot.api.Node

            @Script
            abstract class Base : Node() {
                @Register
                abstract fun attack()
            }

            @Script
            class Fixture : Base() {
                override fun attack() {
                }
            }
        """,
        KotlinInspection()
    )

    fun testJavaLifecycleOverride() = assertQuickFix(
        "Fixture.java",
        """
            import godot.annotation.Script;
            import godot.api.Node;

            @Script
            public class Fixture extends Node {
                @Override
                public void _ready() {
                }
            }
        """,
        JavaInspection()
    )

    fun testScalaLifecycleOverride() = assertQuickFix(
        "Fixture.scala",
        """
            import godot.annotation.Script
            import godot.api.Node

            @Script
            class Fixture extends Node {
              override def _ready(): Unit = {
              }
            }
        """,
        ScalaInspection()
    )

    private fun assertQuickFix(fileName: String, source: String, inspection: LocalInspectionTool) {
        myFixture.configureByText(fileName, source.trimIndent())
        project.service<RegistrationSettings>().state.mode = RegistrationMode.Explicit
        myFixture.enableInspections(inspection)
        myFixture.doHighlighting()
        val familyName = GodotPluginBundle.message("quickFix.function.notificationFunctionNotRegistered.familyName")
        myFixture.launchAction(myFixture.getAllQuickFixes().first { it.familyName == familyName })

        assertEmpty(myFixture.file.text, myFixture.doHighlighting().filter { it.severity.name == "ERROR" })
    }
}
