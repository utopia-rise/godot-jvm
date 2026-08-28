package godot.intellij.plugin.action

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiClassType
import com.intellij.psi.PsiMethod
import com.intellij.psi.PsiPrimitiveType
import com.intellij.psi.PsiType
import godot.annotation.Register
import godot.annotation.Script
import godot.intellij.plugin.registration.RegistrationMode

class NewGodotScriptRequest(
    val className: String,
    val packageName: String,
    val language: GodotScriptLanguage,
    val baseClass: PsiClass,
    val lifecycleMethods: List<PsiMethod>,
    val registrationMode: RegistrationMode
)

/**
 * Builds the source of a new Godot script. Emitted annotations follow the registration mode:
 * [RegistrationMode.Automatic] needs none, [RegistrationMode.Inferred] needs the class annotation, and
 * [RegistrationMode.Explicit] additionally needs every lifecycle override to be registered.
 */
object GodotScriptGenerator {
    private const val INDENT = "    "

    fun generate(request: NewGodotScriptRequest): String {
        val imports = sortedSetOf(request.baseClass.qualifiedName!!)
        val body = StringBuilder()
        val registersOverrides = request.registrationMode == RegistrationMode.Explicit

        if (request.registrationMode != RegistrationMode.Automatic) {
            imports.add(Script::class.qualifiedName!!)
            body.appendLine("@${Script::class.simpleName}")
        }

        val baseClassName = request.baseClass.name!!
        body.appendLine(
            when (request.language) {
                GodotScriptLanguage.KOTLIN -> "class ${request.className} : $baseClassName() {"
                GodotScriptLanguage.JAVA -> "public class ${request.className} extends $baseClassName {"
                GodotScriptLanguage.SCALA -> "class ${request.className} extends $baseClassName {"
            }
        )

        request.lifecycleMethods.forEachIndexed { index, method ->
            if (index > 0) body.appendLine()
            if (registersOverrides) {
                imports.add(Register::class.qualifiedName!!)
                body.appendLine("$INDENT@${Register::class.simpleName}")
            }
            body.appendLine(INDENT + method.declaration(request.language, imports))
            body.appendLine("$INDENT}")
        }

        body.appendLine("}")

        val statementEnd = if (request.language == GodotScriptLanguage.JAVA) ";" else ""
        return buildString {
            if (request.packageName.isNotEmpty()) {
                appendLine("package ${request.packageName}$statementEnd")
                appendLine()
            }
            imports
                .filter { import -> import.substringBeforeLast('.', "") != request.packageName }
                .forEach { import -> appendLine("import $import$statementEnd") }
            if (isNotEmpty()) appendLine()
            append(body)
        }
    }

    private fun PsiMethod.declaration(language: GodotScriptLanguage, imports: MutableSet<String>): String {
        val parameters = parameterList.parameters.joinToString(", ") { parameter ->
            val type = parameter.type.render(language, imports)
            when (language) {
                GodotScriptLanguage.JAVA -> "$type ${parameter.name}"
                else -> "${parameter.name}: $type"
            }
        }

        return when (language) {
            GodotScriptLanguage.KOTLIN -> "override fun $name($parameters) {"
            GodotScriptLanguage.JAVA -> "@Override\n${INDENT}public void $name($parameters) {"
            GodotScriptLanguage.SCALA -> "override def $name($parameters): Unit = {"
        }
    }

    private fun PsiType.render(language: GodotScriptLanguage, imports: MutableSet<String>): String = when {
        language == GodotScriptLanguage.JAVA || this !is PsiPrimitiveType -> {
            (this as? PsiClassType)?.resolve()?.let { resolved ->
                resolved.qualifiedName?.let(imports::add)
                resolved.name
            } ?: presentableText
        }

        // Every JVM primitive maps to its capitalized name on the Kotlin and Scala side, except `int`.
        name == "int" -> "Int"
        else -> name.replaceFirstChar(Char::uppercase)
    }
}
