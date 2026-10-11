package godot.intellij.plugin.inspection

import com.intellij.openapi.components.service
import com.intellij.openapi.util.TextRange
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class ScalaInspectionTest : CodeInsightFixtureTestBase() {
    fun testExplicitFixture() {
        val problems = inspectFixture(
            "src/main/scala/godot/inspection/IdeScalaInspectionExplicit.scala",
            ScalaInspection()
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "signal", "Signal1<Integer>")),
            error(GodotPluginBundle.message("problem.function.unsupportedReturnType", "Callable0<Integer>")),
            error(GodotPluginBundle.message("problem.function.notificationHasParameters")),
            warning(GodotPluginBundle.message("problem.member.ignored")),
            warning(GodotPluginBundle.message("problem.function.overloaded"), 2),
            error(GodotPluginBundle.message("problem.function.notificationReturnsValue")),
            error(GodotPluginBundle.message("problem.class.notRegistered.properties")),
            error(GodotPluginBundle.message("problem.class.notRegistered.signals")),
            error(GodotPluginBundle.message("problem.class.notRegistered.functions")),
            error(GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.notificationFunctionNotRegistered"), 2),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "value", "ScalaUnsupportedType"), 2),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "other", "ScalaUnsupportedType")),
            error(GodotPluginBundle.message("problem.function.unsupportedReturnType", "ScalaUnsupportedType"))
        )
    }

    fun testInferredFixture() {
        val problems = inspectFixture(
            "src/main/scala/godot/inspection/IdeScalaInspectionInferred.scala",
            ScalaInspection(),
            RegistrationMode.Inferred
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "signal", "Signal1<Integer>")),
            error(GodotPluginBundle.message("problem.function.unsupportedReturnType", "Callable0<Integer>")),
            error(GodotPluginBundle.message("problem.function.notificationHasParameters")),
            warning(GodotPluginBundle.message("problem.member.ignored")),
            warning(GodotPluginBundle.message("problem.function.overloaded"), 2),
            error(GodotPluginBundle.message("problem.function.notificationReturnsValue")),
            error(GodotPluginBundle.message("problem.class.notRegistered.properties")),
            error(GodotPluginBundle.message("problem.class.notRegistered.signals")),
            error(GodotPluginBundle.message("problem.class.notRegistered.functions")),
            error(GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "value", "ScalaUnsupportedType"), 2),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "other", "ScalaUnsupportedType")),
            error(GodotPluginBundle.message("problem.function.unsupportedReturnType", "ScalaUnsupportedType"))
        )
    }

    fun testAutomaticFixture() {
        val problems = inspectFixture(
            "src/main/scala/godot/inspection/IdeScalaInspectionAutomatic.scala",
            ScalaInspection(),
            RegistrationMode.Automatic
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "signal", "Signal1<Integer>")),
            error(GodotPluginBundle.message("problem.function.unsupportedReturnType", "Callable0<Integer>")),
            error(GodotPluginBundle.message("problem.function.notificationHasParameters")),
            warning(GodotPluginBundle.message("problem.member.ignored")),
            warning(GodotPluginBundle.message("problem.function.overloaded"), 4),
            error(GodotPluginBundle.message("problem.function.notificationReturnsValue")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject")),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "value", "ScalaUnsupportedType"), 2),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "other", "ScalaUnsupportedType")),
            error(GodotPluginBundle.message("problem.function.unsupportedReturnType", "ScalaUnsupportedType"))
        )
    }

    fun testClassProblemsAreReportedOnTheClassName() {
        myFixture.configureByText(
            "Fixture.scala",
            """
                import godot.annotation.Script

                @Script
                class Fixture {
                  def unrelated(): Unit = {
                  }
                }
            """.trimIndent()
        )
        project.service<RegistrationSettings>().state.mode = RegistrationMode.Explicit
        myFixture.enableInspections(ScalaInspection())

        val problem = myFixture.doHighlighting().single { it.description == GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject") }
        assertEquals("Fixture", myFixture.editor.document.getText(TextRange(problem.startOffset, problem.endOffset)))
    }
}
