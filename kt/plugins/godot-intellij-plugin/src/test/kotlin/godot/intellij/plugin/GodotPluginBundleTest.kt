package godot.intellij.plugin

import godot.annotation.Script
import junit.framework.TestCase
import java.util.ResourceBundle

class GodotPluginBundleTest : TestCase() {
    fun testMessagesOnlyNameExistingAnnotations() {
        val bundle = ResourceBundle.getBundle("messages.generalLabels")
        val annotationPackage = Script::class.java.packageName
        bundle.keySet().forEach { key ->
            Regex("""@(\w+)""").findAll(bundle.getString(key)).forEach { match ->
                val annotation = "$annotationPackage.${match.groupValues[1]}"
                assertNotNull("$key names $annotation", runCatching { Class.forName(annotation) }.getOrNull())
            }
        }
    }
}
