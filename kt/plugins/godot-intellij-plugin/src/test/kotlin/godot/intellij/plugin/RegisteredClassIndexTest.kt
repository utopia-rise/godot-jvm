package godot.intellij.plugin

import com.intellij.openapi.application.impl.NonBlockingReadActionImpl
import com.intellij.openapi.components.service
import com.intellij.psi.PsiDocumentManager
import godot.intellij.plugin.inspection.CodeInsightFixtureTestBase
import godot.intellij.plugin.project.registeredClassNameCache
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class RegisteredClassIndexTest : CodeInsightFixtureTestBase() {
    fun testTypingRegistersTheClassAgainInEveryMode() {
        for (mode in RegistrationMode.entries) {
            project.service<RegistrationSettings>().state.mode = RegistrationMode.Inferred
            val file = myFixture.addFileToProject(
                "src/main/kotlin/${mode.name.lowercase()}/Typing.kt",
                """
                package ${mode.name.lowercase()}

                import godot.annotation.Script
                import godot.api.Node

                @Script
                class Typing : Node() {
                    var speed = 1
                }
                """.trimIndent()
            )
            myFixture.configureFromExistingVirtualFile(file.virtualFile)
            project.service<RegistrationSettings>().state.mode = mode

            myFixture.editor.caretModel.moveToOffset(myFixture.editor.document.text.indexOf("var speed"))
            myFixture.type("val other = 2\n    ")
            PsiDocumentManager.getInstance(project).commitAllDocuments()
            NonBlockingReadActionImpl.waitForAsyncTaskCompletion()

            assertNotNull(
                "$mode: the edited class should be registered again",
                module.registeredClassNameCache.getContainerByFqName("${mode.name.lowercase()}.Typing")
            )
        }
    }
}
