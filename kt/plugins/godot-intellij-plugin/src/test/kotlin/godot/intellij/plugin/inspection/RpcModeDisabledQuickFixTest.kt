package godot.intellij.plugin.inspection

import com.intellij.openapi.components.service
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class RpcModeDisabledQuickFixTest : CodeInsightFixtureTestBase() {
    fun testPositionalRpcMode() = assertQuickFix("@Rpc(RpcMode.DISABLED, Sync.SYNC)", "@Rpc(RpcMode.AUTHORITY, Sync.SYNC)")

    fun testNamedRpcMode() = assertQuickFix(
        "@Rpc(sync = Sync.SYNC, rpcMode = RpcMode.DISABLED)",
        "@Rpc(sync = Sync.SYNC, rpcMode = RpcMode.AUTHORITY)"
    )

    private fun assertQuickFix(annotation: String, expected: String) {
        myFixture.configureByText(
            "Fixture.kt",
            """
                import godot.annotation.Register
                import godot.annotation.Rpc
                import godot.annotation.RpcMode
                import godot.annotation.Script
                import godot.annotation.Sync
                import godot.api.Node

                @Script
                class Fixture : Node() {
                    @Register
                    override fun _ready() {
                        rpc(::target)
                    }

                    $annotation
                    @Register
                    fun target() {
                    }
                }
            """.trimIndent()
        )
        project.service<RegistrationSettings>().state.mode = RegistrationMode.Explicit
        myFixture.enableInspections(KotlinInspection())
        myFixture.doHighlighting()
        val familyName = GodotPluginBundle.message("quickFix.function.connectedFunctionsRpcAnnotationHasRpcModeDisabled.familyName")
        myFixture.launchAction(myFixture.getAllQuickFixes().first { it.familyName == familyName })

        assertTrue(myFixture.file.text, myFixture.file.text.contains(expected))
        assertEmpty(myFixture.file.text, myFixture.doHighlighting().filter { it.severity.name == "ERROR" })
    }
}
