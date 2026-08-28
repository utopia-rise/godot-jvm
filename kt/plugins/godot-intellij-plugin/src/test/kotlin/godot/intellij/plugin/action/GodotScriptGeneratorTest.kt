package godot.intellij.plugin.action

import com.intellij.psi.JavaPsiFacade
import com.intellij.psi.search.GlobalSearchScope
import godot.intellij.plugin.inspection.CodeInsightFixtureTestBase
import godot.intellij.plugin.registration.RegistrationMode

class GodotScriptGeneratorTest : CodeInsightFixtureTestBase() {
    fun testKotlinExplicit() {
        assertEquals(
            """
            package com.game

            import godot.annotation.Register
            import godot.annotation.Script
            import godot.api.Node

            @Script
            class MyScript : Node() {
                @Register
                override fun _ready() {
                }

                @Register
                override fun _process(delta: Double) {
                }
            }

            """.trimIndent(),
            generate(GodotScriptLanguage.KOTLIN, RegistrationMode.Explicit, "_ready", "_process")
        )
    }

    fun testJavaInferred() {
        assertEquals(
            """
            package com.game;

            import godot.annotation.Script;
            import godot.api.Node;

            @Script
            public class MyScript extends Node {
                @Override
                public void _ready() {
                }
            }

            """.trimIndent(),
            generate(GodotScriptLanguage.JAVA, RegistrationMode.Inferred, "_ready")
        )
    }

    fun testScalaAutomatic() {
        assertEquals(
            """
            package com.game

            import godot.api.Node

            class MyScript extends Node {
                override def _ready(): Unit = {
                }
            }

            """.trimIndent(),
            generate(GodotScriptLanguage.SCALA, RegistrationMode.Automatic, "_ready")
        )
    }

    fun testWithoutLifecycleFunctions() {
        assertEquals(
            """
            package com.game

            import godot.annotation.Script
            import godot.api.Node

            @Script
            class MyScript : Node() {
            }

            """.trimIndent(),
            generate(GodotScriptLanguage.KOTLIN, RegistrationMode.Inferred)
        )
    }

    private fun generate(
        language: GodotScriptLanguage,
        mode: RegistrationMode,
        vararg lifecycleFunctions: String
    ): String {
        val baseClass = requireNotNull(
            JavaPsiFacade.getInstance(project).findClass("godot.api.Node", GlobalSearchScope.allScope(project))
        )

        return GodotScriptGenerator.generate(
            NewGodotScriptRequest(
                className = "MyScript",
                packageName = "com.game",
                language = language,
                baseClass = baseClass,
                lifecycleMethods = lifecycleFunctions.map { lifecycleFunction ->
                    baseClass.findMethodsByName(lifecycleFunction, true).first()
                },
                registrationMode = mode
            )
        )
    }
}
