package godot.intellij.plugin.inspection

import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode

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
            error(GodotPluginBundle.message("problem.function.notificationReturnsValue")),
            error(GodotPluginBundle.message("problem.class.notRegistered.butHasToolAnnotation")),
            error(GodotPluginBundle.message("problem.class.notRegistered.properties")),
            error(GodotPluginBundle.message("problem.class.notRegistered.signals")),
            error(GodotPluginBundle.message("problem.class.notRegistered.functions")),
            error(GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.notificationFunctionNotRegistered"), 2),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "value", "ScalaUnsupportedType")),
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
            error(GodotPluginBundle.message("problem.function.notificationReturnsValue")),
            error(GodotPluginBundle.message("problem.class.notRegistered.properties")),
            error(GodotPluginBundle.message("problem.class.notRegistered.signals")),
            error(GodotPluginBundle.message("problem.class.notRegistered.functions")),
            error(GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "value", "ScalaUnsupportedType")),
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
            error(GodotPluginBundle.message("problem.function.notificationReturnsValue")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.function.unsupportedParameterType", "value", "ScalaUnsupportedType")),
            error(GodotPluginBundle.message("problem.function.unsupportedReturnType", "ScalaUnsupportedType"))
        )
    }
}
