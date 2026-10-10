package godot.intellij.plugin.action

import com.intellij.openapi.util.Disposer
import godot.intellij.plugin.GodotPluginBundle
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

    fun testBaseClassesTheScriptCannotExtendAreRejected() {
        val directory = myFixture
            .addFileToProject(
                "src/main/kotlin/com/game/Bases.kt",
                """
                    package com.game

                    import godot.api.Node

                    abstract class AbstractMembersBase : Node() {
                        abstract fun attack()
                    }

                    abstract class AbstractBase : Node()

                    class FinalScript : Node()

                    open class InternalConstructorBase internal constructor() : Node()
                """.trimIndent()
            )
            .containingDirectory
        val notExtensible = GodotPluginBundle.message("action.newScript.dialog.error.notExtensible")
        val abstractMembers = GodotPluginBundle.message("action.newScript.dialog.error.abstractMembers")
        val dialog = NewGodotScriptDialog(project, directory, "com.game")
        try {
            dialog.nameField.text = "MyScript"
            mapOf(
                "Input" to notExtensible,
                "CanvasItem" to notExtensible,
                "com.game.FinalScript" to notExtensible,
                "com.game.AbstractMembersBase" to abstractMembers,
                "Node" to null,
                "Control" to null,
                "CharacterBody3D" to null,
                "Resource" to null,
                "RefCounted" to null,
                "com.game.AbstractBase" to null,
                "com.game.InternalConstructorBase" to null
            ).forEach { (baseClass, expected) ->
                dialog.baseClassField.text = baseClass
                assertEquals(baseClass, expected, dialog.doValidate()?.message)
            }
        } finally {
            Disposer.dispose(dialog.disposable)
        }
    }
}
