package godot.intellij.plugin.highlighting

import godot.intellij.plugin.inspection.CodeInsightFixtureTestBase
import godot.intellij.plugin.registration.RegistrationMode
import godot.intellij.plugin.registration.RegistrationSettings

class RegistrationHighlightingTest : CodeInsightFixtureTestBase() {
    fun testHighlightColorsResolveToVisibleBackgrounds() {
        val backgrounds = RegistrationHighlight.entries.map { highlight ->
            highlight.textAttributes.backgroundColor
        }

        assertTrue(backgrounds.all { color -> color.alpha == 255 })
        assertEquals(RegistrationHighlight.entries.size, backgrounds.toSet().size)
    }

    fun testHighlightingIsEnabledByDefault() =
        assertTrue(RegistrationSettings.SettingsState().registrationHighlightsEnabled)

    fun testKotlinExplicit() = assertHighlights("HighlightFixture.kt", kotlinSource, RegistrationMode.Explicit, 2, 8, 3)

    fun testKotlinInferred() = assertHighlights("HighlightFixture.kt", kotlinSource, RegistrationMode.Inferred, 2, 5, 6)

    fun testKotlinAutomatic() = assertHighlights("HighlightFixture.kt", kotlinSource, RegistrationMode.Automatic, 2, 0, 11)

    fun testJavaExplicit() = assertHighlights("HighlightFixture.java", javaSource, RegistrationMode.Explicit, 2, 8, 3)

    fun testJavaInferred() = assertHighlights("HighlightFixture.java", javaSource, RegistrationMode.Inferred, 2, 5, 6)

    fun testJavaAutomatic() = assertHighlights("HighlightFixture.java", javaSource, RegistrationMode.Automatic, 2, 0, 11)

    fun testScalaExplicit() = assertHighlights("HighlightFixture.scala", scalaSource, RegistrationMode.Explicit, 2, 8, 3)

    fun testScalaInferred() = assertHighlights("HighlightFixture.scala", scalaSource, RegistrationMode.Inferred, 2, 5, 6)

    fun testScalaAutomatic() = assertHighlights("HighlightFixture.scala", scalaSource, RegistrationMode.Automatic, 2, 0, 11)

    fun testKotlinHighlightingCanBeDisabled() =
        assertEmpty(highlightSource("DisabledHighlightFixture.kt", kotlinSource, RegistrationMode.Inferred, false))

    fun testJavaHighlightingCanBeDisabled() =
        assertEmpty(highlightSource("HighlightFixture.java", javaSource, RegistrationMode.Inferred, false))

    fun testScalaHighlightingCanBeDisabled() =
        assertEmpty(highlightSource("DisabledHighlightFixture.scala", scalaSource, RegistrationMode.Inferred, false))

    fun testKotlinHighlightsOnlyDeclarationSignatures() =
        assertSignatureHighlights(
            "KotlinSignatureFixture.kt",
            """
                package godot.highlight

                import godot.annotation.Register
                import godot.annotation.Script
                import godot.annotation.Visible
                import godot.api.Node

                @Script
                class KotlinSignatureFixture : Node() {
                    @Visible
                    var health: Int = 100

                    @Register
                    fun heal(amount: Int) { health += amount }
                }
            """,
            "class KotlinSignatureFixture : Node()",
            "var health: Int",
            "fun heal(amount: Int)"
        )

    fun testJavaHighlightsOnlyDeclarationSignatures() =
        assertSignatureHighlights(
            "JavaSignatureFixture.java",
            """
                package godot.highlight;

                import godot.annotation.Register;
                import godot.annotation.Script;
                import godot.annotation.Visible;
                import godot.api.Node;

                @Script
                public class JavaSignatureFixture extends Node {
                    @Visible
                    public int health = 100;

                    @Register
                    public void heal(int amount) { health += amount; }
                }
            """,
            "public class JavaSignatureFixture extends Node",
            "public int health",
            "public void heal(int amount)"
        )

    fun testScalaHighlightsOnlyDeclarationSignatures() =
        assertSignatureHighlights(
            "ScalaSignatureFixture.scala",
            """
                package godot.highlight

                import godot.annotation.{Register, Script, Visible}
                import godot.api.Node

                @Script
                class ScalaSignatureFixture extends Node {
                  @Visible
                  var health: Int = 100

                  @Register
                  def heal(amount: Int): Unit = { health += amount }
                }
            """,
            "class ScalaSignatureFixture extends Node",
            "var health: Int",
            "def heal(amount: Int): Unit"
        )

    private fun assertHighlights(
        fileName: String,
        source: String,
        mode: RegistrationMode,
        ineligible: Int,
        candidate: Int,
        registered: Int
    ) {
        val highlights = highlightSource(fileName, source, mode)
        assertEquals(ineligible, highlights.count { it == RegistrationHighlight.INELIGIBLE })
        assertEquals(candidate, highlights.count { it == RegistrationHighlight.CANDIDATE })
        assertEquals(registered, highlights.count { it == RegistrationHighlight.REGISTERED })
    }

    private fun assertSignatureHighlights(
        fileName: String,
        source: String,
        vararg expectedSignatures: String
    ) {
        val normalizedSource = source.trimIndent()
        val signatures = registrationHighlightInfos(fileName, normalizedSource, RegistrationMode.Explicit)
            .map { highlight -> normalizedSource.substring(highlight.startOffset, highlight.endOffset) }
            .sorted()

        assertEquals(expectedSignatures.sorted(), signatures)
    }

    private companion object {
        val kotlinSource = """
            package godot.highlight

            import godot.annotation.Export
            import godot.annotation.Register
            import godot.annotation.Rpc
            import godot.annotation.Script
            import godot.annotation.Tool
            import godot.annotation.Visible
            import godot.api.Node

            class Plain {
                val ignored = 1
                fun ignored() = Unit
            }

            class Candidate : Node() {
                val eligible = 1
                val ineligible = Plain()
                fun eligibleFunction(value: Int) = Unit
                fun ineligibleFunction(value: Plain) = Unit
            }

            @Tool
            class MetaRegistered : Node() {
                @Export
                val metaProperty = 1

                @Rpc
                fun metaFunction() = Unit
            }

            @Script
            class DirectRegistered : Node() {
                @Visible
                val selected = 1
                val unselected = 1

                @Register
                fun selectedFunction() = Unit
                fun unselectedFunction() = Unit
            }
        """.trimIndent()

        val javaSource = """
            package godot.highlight;

            import godot.annotation.Export;
            import godot.annotation.Register;
            import godot.annotation.Rpc;
            import godot.annotation.Script;
            import godot.annotation.Tool;
            import godot.annotation.Visible;
            import godot.api.Node;

            public class HighlightFixture {
                public static class Plain {
                    public int ignored = 1;
                    public void ignored() {}
                }

                public static class Candidate extends Node {
                    public int eligible = 1;
                    public Plain ineligible = new Plain();
                    public void eligibleFunction(int value) {}
                    public void ineligibleFunction(Plain value) {}
                }

                @Tool
                public static class MetaRegistered extends Node {
                    @Export
                    public int metaProperty = 1;

                    @Rpc
                    public void metaFunction() {}
                }

                @Script
                public static class DirectRegistered extends Node {
                    @Visible
                    public int selected = 1;
                    public int unselected = 1;

                    @Register
                    public void selectedFunction() {}
                    public void unselectedFunction() {}
                }
            }
        """.trimIndent()

        val scalaSource = """
            package godot.highlight

            import godot.annotation.{Export, Register, Rpc, Script, Tool, Visible}
            import godot.api.Node

            class Plain {
              val ignoredProperty: Int = 1
              def ignoredFunction(): Unit = {}
            }

            class Candidate extends Node {
              val eligible: Int = 1
              val ineligible: Plain = new Plain()
              def eligibleFunction(value: Int): Unit = {}
              def ineligibleFunction(value: Plain): Unit = {}
            }

            @Tool
            class MetaRegistered extends Node {
              @Export
              val metaProperty: Int = 1

              @Rpc
              def metaFunction(): Unit = {}
            }

            @Script
            class DirectRegistered extends Node {
              @Visible
              val selected: Int = 1
              val unselected: Int = 1

              @Register
              def selectedFunction(): Unit = {}
              def unselectedFunction(): Unit = {}
            }
        """.trimIndent()
    }
}
