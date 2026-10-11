package godot.intellij.plugin.inspection

import com.intellij.codeInsight.daemon.impl.HighlightInfo
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.openapi.components.service
import com.intellij.psi.PsiDocumentManager
import godot.intellij.plugin.GodotPluginBundle
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class EditingInspectionTest : CodeInsightFixtureTestBase() {
    fun testKotlinWarningsFollowTheEditsInEveryMode() {
        for (mode in RegistrationMode.entries) {
            project.service<RegistrationSettings>().state.mode = RegistrationMode.Inferred
            val file = myFixture.addFileToProject(
                "src/main/kotlin/${mode.name.lowercase()}/Edited.kt",
                """
                package ${mode.name.lowercase()}

                import godot.annotation.Register
                import godot.annotation.Script
                import godot.api.Node

                @Script
                class Edited : Node() {
                    fun helper() {
                    }
                }
                """.trimIndent()
            )
            myFixture.configureFromExistingVirtualFile(file.virtualFile)
            project.service<RegistrationSettings>().state.mode = mode
            myFixture.enableInspections(KotlinInspection())
            assertEmpty("$mode: nothing to report before editing", memberProblems())

            myFixture.editor.caretModel.moveToOffset(myFixture.editor.document.text.indexOf("fun helper"))
            myFixture.type("@Register\n    private ")
            assertEquals("$mode: a private registered function is reported while typing", 1, memberProblems().size)

            replace("private ", "")
            assertEmpty("$mode: the warning goes away once the function is public", memberProblems())

            replace("fun helper()", "fun Node.helper()")
            assertEquals(
                "$mode: an extension function is reported",
                listOf(GodotPluginBundle.message("problem.function.extension")),
                memberProblems().map { it.description }
            )
        }
    }

    fun testJavaWarningsFollowTheEdits() {
        project.service<RegistrationSettings>().state.mode = RegistrationMode.Inferred
        val file = myFixture.addFileToProject(
            "src/main/java/edited/EditedJava.java",
            """
            package edited;

            import godot.annotation.Export;
            import godot.annotation.Script;
            import godot.api.Node;

            @Script
            public class EditedJava extends Node {
                public int speed = 1;
            }
            """.trimIndent()
        )
        myFixture.configureFromExistingVirtualFile(file.virtualFile)
        myFixture.enableInspections(JavaInspection())
        assertEmpty(memberProblems())

        myFixture.editor.caretModel.moveToOffset(myFixture.editor.document.text.indexOf("public int speed"))
        myFixture.type("@Export\n    static ")
        assertEquals("a static exported field is reported while typing", 1, memberProblems().size)

        replace("static ", "")
        assertEmpty("the warning goes away once the field is an instance field", memberProblems())
    }

    private fun replace(old: String, new: String) {
        val document = myFixture.editor.document
        WriteCommandAction.runWriteCommandAction(project) {
            val start = document.text.indexOf(old)
            document.replaceString(start, start + old.length, new)
        }
        PsiDocumentManager.getInstance(project).commitAllDocuments()
    }

    private fun memberProblems(): List<HighlightInfo> {
        val messages = setOf(
            GodotPluginBundle.message("problem.member.ignored"),
            GodotPluginBundle.message("problem.function.extension"),
            GodotPluginBundle.message("problem.function.overloaded")
        )
        return myFixture.doHighlighting().filter { highlight -> highlight.description in messages }
    }
}
