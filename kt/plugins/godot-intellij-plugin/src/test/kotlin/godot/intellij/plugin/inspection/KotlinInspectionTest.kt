package godot.intellij.plugin.inspection

import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode

class KotlinInspectionTest : CodeInsightFixtureTestBase() {
    fun testExplicitFixture() {
        val problems = inspectFixture(
            "src/main/kotlin/godot/inspection/IdeKotlinInspectionExplicit.kt",
            KotlinInspection()
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.class.notRegistered.butHasToolAnnotation")),
            error(GodotPluginBundle.message("problem.class.notRegistered.properties")),
            error(GodotPluginBundle.message("problem.class.notRegistered.signals")),
            error(GodotPluginBundle.message("problem.class.notRegistered.functions")),
            error(GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.notificationFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.function.overriddenAbstractFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.property.lateinit.coreType")),
            error(GodotPluginBundle.message("problem.property.nullable")),
            error(GodotPluginBundle.message("problem.property.export.triedToExportUnsupportedType")),
            error(GodotPluginBundle.message("problem.property.registeredEnumListWithVariantArray")),
            error(GodotPluginBundle.message("problem.property.export.notRegistered")),
            error(GodotPluginBundle.message("problem.property.hint.notRegistered"), 11),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Int::class.qualifiedName!!), 2),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Long::class.qualifiedName!!)),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Float::class.qualifiedName!!)),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Double::class.qualifiedName!!)),
            error(
                GodotPluginBundle.message(
                    "problem.property.hint.wrongType",
                    "${Float::class.qualifiedName!!} or ${Double::class.qualifiedName!!}"
                )
            ),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", String::class.qualifiedName!!), 4),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", "godot.core.Color")),
            error(GodotPluginBundle.message("problem.property.hint.toManyEnumEntries")),
            error(GodotPluginBundle.message("problem.signal.mutability")),
            error(GodotPluginBundle.message("problem.signal.wrongType")),
            weakWarning(GodotPluginBundle.message("problem.function.rpcChannelSetWhenTransferTypeIgnoresIt")),
            error(GodotPluginBundle.message("problem.signal.connection.connectedFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.general.calledFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionHasNoRpcAnnotation")),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionNotAccessible"))
        )
    }

    fun testContainerFixture() {
        val problems = inspectFixture(
            "src/main/kotlin/godot/inspection/IdeKotlinInspectionContainers.kt",
            KotlinInspection()
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.general.calledFunctionNotRegistered"))
        )
    }

    fun testCoreTypeCopyFixture() {
        val problems = inspectFixture(
            "src/main/kotlin/godot/inspection/CopyModificationCheckTestClass.kt",
            CoreTypeCopyModificationInspection()
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.general.modificationOfCoreTypeCopy"), 10)
        )
    }

    fun testInferredFixture() {
        val problems = inspectFixture(
            "src/main/kotlin/godot/inspection/IdeKotlinInspectionInferred.kt",
            KotlinInspection(),
            RegistrationMode.Inferred
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.class.notRegistered.properties")),
            error(GodotPluginBundle.message("problem.class.notRegistered.signals")),
            error(GodotPluginBundle.message("problem.class.notRegistered.functions")),
            error(GodotPluginBundle.message("problem.class.inheritance.notInheritingGodotObject")),
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.overriddenAbstractFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.property.lateinit.coreType")),
            error(GodotPluginBundle.message("problem.property.nullable")),
            error(GodotPluginBundle.message("problem.property.export.triedToExportUnsupportedType")),
            error(GodotPluginBundle.message("problem.property.registeredEnumListWithVariantArray")),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Int::class.qualifiedName!!), 2),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Long::class.qualifiedName!!)),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Float::class.qualifiedName!!)),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Double::class.qualifiedName!!)),
            error(
                GodotPluginBundle.message(
                    "problem.property.hint.wrongType",
                    "${Float::class.qualifiedName!!} or ${Double::class.qualifiedName!!}"
                )
            ),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", String::class.qualifiedName!!), 4),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", "godot.core.Color")),
            error(GodotPluginBundle.message("problem.property.hint.toManyEnumEntries")),
            error(GodotPluginBundle.message("problem.signal.mutability")),
            error(GodotPluginBundle.message("problem.signal.wrongType")),
            weakWarning(GodotPluginBundle.message("problem.function.rpcChannelSetWhenTransferTypeIgnoresIt")),
            error(GodotPluginBundle.message("problem.signal.connection.connectedFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.general.calledFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionNotRegistered")),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionHasNoRpcAnnotation")),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionNotAccessible"))
        )
    }

    fun testAutomaticFixture() {
        val problems = inspectFixture(
            "src/main/kotlin/godot/inspection/IdeKotlinInspectionAutomatic.kt",
            KotlinInspection(),
            RegistrationMode.Automatic
        )

        assertProblems(
            problems,
            error(GodotPluginBundle.message("problem.class.nameAlreadyRegistered"), 2),
            error(GodotPluginBundle.message("problem.general.cannotRegisterGenerics"), 2),
            error(GodotPluginBundle.message("problem.function.toManyParams", 16)),
            error(GodotPluginBundle.message("problem.property.lateinit.coreType")),
            error(GodotPluginBundle.message("problem.property.nullable")),
            error(GodotPluginBundle.message("problem.property.registeredEnumListWithVariantArray")),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Int::class.qualifiedName!!), 2),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Long::class.qualifiedName!!)),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Float::class.qualifiedName!!)),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", Double::class.qualifiedName!!)),
            error(
                GodotPluginBundle.message(
                    "problem.property.hint.wrongType",
                    "${Float::class.qualifiedName!!} or ${Double::class.qualifiedName!!}"
                )
            ),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", String::class.qualifiedName!!), 4),
            error(GodotPluginBundle.message("problem.property.hint.wrongType", "godot.core.Color")),
            error(GodotPluginBundle.message("problem.property.hint.toManyEnumEntries")),
            error(GodotPluginBundle.message("problem.signal.mutability")),
            error(GodotPluginBundle.message("problem.signal.wrongType")),
            weakWarning(GodotPluginBundle.message("problem.function.rpcChannelSetWhenTransferTypeIgnoresIt")),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionHasNoRpcAnnotation"), 2),
            error(GodotPluginBundle.message("problem.rpc.calledFunctionNotAccessible"))
        )
    }
}
