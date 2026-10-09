package godot.intellij.plugin.inspection

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.openapi.components.service
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class UseBaseCallbackTypeQuickFixTest : CodeInsightFixtureTestBase() {
    fun testKotlin() = assertQuickFix(
        "Fixture.kt",
        """
            import godot.annotation.Emit
            import godot.annotation.Register
            import godot.annotation.Script
            import godot.api.Node
            import godot.core.Callable0
            import godot.core.Signal1
            import godot.core.signal1

            @Script
            class Fixture : Node() {
                @Emit
                val typed by signal1<Callable0<Int>>()

                @Register
                fun typed(signal: Signal1<Int>): Callable0<Int>? = null
            }
        """,
        KotlinInspection(),
        "signal1<godot.core.Callable>()",
        "signal: godot.core.Signal)",
        ": godot.core.Callable? = null"
    )

    fun testJava() = assertQuickFix(
        "Fixture.java",
        """
            import godot.annotation.Register;
            import godot.annotation.Script;
            import godot.api.Node;
            import godot.core.Callable0;
            import godot.core.Signal1;

            @Script
            public class Fixture extends Node {
                @Register
                public Callable0<Integer> typed(Signal1<Integer> signal) {
                    return null;
                }
            }
        """,
        JavaInspection(),
        "public godot.core.Callable typed(godot.core.Signal signal)"
    )

    fun testScala() = assertQuickFix(
        "Fixture.scala",
        """
            import godot.annotation.{Register, Script}
            import godot.api.Node
            import godot.core.{Callable0, Signal1}

            @Script
            class Fixture extends Node {
              @Register
              def typed(signal: Signal1[Integer]): Callable0[Integer] = null
            }
        """,
        ScalaInspection(),
        "def typed(signal: godot.core.Signal): godot.core.Callable = null"
    )

    private fun assertQuickFix(fileName: String, source: String, inspection: LocalInspectionTool, vararg expected: String) {
        myFixture.configureByText(fileName, source.trimIndent())
        project.service<RegistrationSettings>().state.mode = RegistrationMode.Explicit
        myFixture.enableInspections(inspection)
        val familyName = GodotPluginBundle.message("quickFix.type.useBaseCallback.familyName")
        var applied = 0
        while (true) {
            myFixture.doHighlighting()
            val fix = myFixture.getAllQuickFixes().firstOrNull { it.familyName == familyName } ?: break
            myFixture.launchAction(fix)
            applied++
        }
        assertEquals(expected.size, applied)
        expected.forEach { fragment -> assertTrue(fragment, myFixture.file.text.contains(fragment)) }
    }
}
