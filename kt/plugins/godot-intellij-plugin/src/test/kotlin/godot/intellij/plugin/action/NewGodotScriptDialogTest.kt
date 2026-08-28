package godot.intellij.plugin.action

import com.intellij.openapi.util.Disposer
import godot.intellij.plugin.inspection.CodeInsightFixtureTestBase

class NewGodotScriptDialogTest : CodeInsightFixtureTestBase() {
    fun testSelectedLanguageIsUsed() {
        val directory = myFixture
            .addFileToProject("src/main/kotlin/com/game/Existing.kt", "package com.game")
            .containingDirectory

        GodotScriptLanguage.available.forEach { language ->
            val dialog = NewGodotScriptDialog(project, directory, "com.game")
            try {
                dialog.nameField.text = "MyScript"
                dialog.languageComboBox.item = language

                val request = dialog.buildRequest()
                assertEquals(language, request.language)

                val source = GodotScriptGenerator.generate(request)
                val expectedDeclaration = when (language) {
                    GodotScriptLanguage.KOTLIN -> "class MyScript : Node()"
                    GodotScriptLanguage.JAVA -> "public class MyScript extends Node"
                    GodotScriptLanguage.SCALA -> "class MyScript extends Node"
                }
                assertTrue("$language generated:\n$source", source.contains(expectedDeclaration))
            } finally {
                Disposer.dispose(dialog.disposable)
            }
        }
    }

    fun testBaseClassIsResolvedFromItsSimpleName() {
        val directory = myFixture
            .addFileToProject("src/main/java/com/game/Existing.java", "package com.game;")
            .containingDirectory
        val dialog = NewGodotScriptDialog(project, directory, "com.game")
        try {
            dialog.nameField.text = "MyScript"

            assertEquals(GodotScriptLanguage.JAVA, dialog.languageComboBox.item)
            val request = dialog.buildRequest()
            assertEquals("godot.api.Node", request.baseClass.qualifiedName)
            assertTrue(GodotScriptGenerator.generate(request).contains("import godot.api.Node;"))
        } finally {
            Disposer.dispose(dialog.disposable)
        }
    }
}
