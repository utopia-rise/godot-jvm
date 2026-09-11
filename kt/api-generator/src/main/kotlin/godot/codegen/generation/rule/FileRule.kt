package godot.codegen.generation.rule

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.MemberName
import godot.codegen.generation.GenerationContext
import godot.codegen.generation.task.AbstractClassDummyTask
import godot.codegen.generation.task.ApiTask
import godot.codegen.generation.task.EnrichedClassTask
import godot.codegen.generation.task.EnrichedEnumTask
import godot.codegen.generation.task.FileTask
import godot.codegen.models.enriched.EnrichedClass
import godot.codegen.models.enriched.EnrichedEnum
import godot.codegen.models.traits.GenerationType
import godot.common.extensions.convertToCamelCase
import godot.tools.common.constants.GENERATED_COMMENT
import godot.tools.common.constants.godotCorePackage

class FileRule : GodotApiRule<FileTask>() {
    override fun apply(task: FileTask, context: GenerationContext) {
        val type = task.type
        if (type is EnrichedClass) {
            task.classes += EnrichedClassTask(type)
            if (type.isAbstract) {
                task.abstractDummyClasses += AbstractClassDummyTask(type)
            }
        } else if (type is EnrichedEnum) {
            task.enums += EnrichedEnumTask(type)
        }
    }
}

class HeaderCommentRule() : GodotApiRule<FileTask>() {
    override fun apply(task: FileTask, context: GenerationContext) {
        task.builder.addFileComment(GENERATED_COMMENT)
    }
}

class ImportRule() : GodotApiRule<FileTask>() {
    override fun apply(task: FileTask, context: GenerationContext) = configure(task.builder) {
        for (clazz in task.classes) {
            for (importTarget in clazz.clazz.additionalImports) {
                when (importTarget) {
                    is ClassName -> addImport(importTarget.packageName, importTarget.simpleName)
                    is MemberName -> addImport(importTarget.packageName, importTarget.simpleName)
                }
            }
        }
    }
}

class WarningRule() : GodotApiRule<FileTask>() {
    override fun apply(task: FileTask, context: GenerationContext) = configure(task.builder) {
        addAnnotation(
            AnnotationSpec.builder(Suppress::class)
                .addMember(
                    "\"PackageDirectoryMismatch\", \"unused\", \"FunctionName\", \"RedundantModalityModifier\", " +
                        "\"UNCHECKED_CAST\", \"JoinDeclarationAndAssignment\", \"USELESS_CAST\", \"RemoveRedundantQualifierName\", " +
                        "\"NOTHING_TO_INLINE\", \"NON_FINAL_MEMBER_IN_OBJECT\", \"RedundantVisibilityModifier\", " +
                        "\"RedundantUnitReturnType\", \"MemberVisibilityCanBePrivate\""
                )
                .build()
        )
    }
}

class StaticRule : GodotApiRule<FileTask>() {
    override fun apply(task: FileTask, context: GenerationContext) = configure(task.builder) {
        for (classTask in task.classes) {
            for (method in classTask.enrichedStaticMethods) {
                method.builder.addAnnotation(JvmStatic::class)
            }

            val clazz = classTask.clazz
            if (clazz.isSingleton) {
                for (method in classTask.methods) {
                    method.builder.addAnnotation(JvmStatic::class)
                }
                for (property in classTask.properties) {
                    property.builder.addAnnotation(JvmStatic::class)
                }
            }
        }
    }
}

private const val constantTitle = "constant"

class DocumentationRule : GodotApiRule<ApiTask>() {
    data class TypeBlock(val regex: Regex) {
        constructor(name: String) :
            this(Regex("""\[($name\s)(\S+)(])"""))
    }

    private val typeToSanitize = arrayOf(
        TypeBlock("member"),
        TypeBlock("method"),
        TypeBlock("enum"),
        TypeBlock(constantTitle),
        TypeBlock("param")
    )

    data class TagBlock(val output: String, val regex: Regex) {
        constructor(input: String, output: String) :
            this(
                output,
                Regex("""(\[$input])((?:(?!\[/$input]|\[$input]).)*)(\[/$input])""")
            )
    }

    private val tagsToSanitize = arrayOf(
        TagBlock("code", "`"),
        TagBlock("i", "*"),
        TagBlock("b", "**")
    )

    data class CodeBlock(val input: String, val named: Boolean)

    private val languages = arrayOf(
        CodeBlock("gdscript", true),
        CodeBlock("csharp", true),
        CodeBlock("codeblock", false),
    )
    private val codeBlockRegex = Regex("""```[\s\S]*?```""")
    private val annotationRegex = Regex("""\[annotation @\w+\.(@\w+)]""")
    private val referenceRegex = Regex("""\[(\w+)(?:\.\w+)?]""")
    private val typeReferences = mapOf(
        "[int]" to "[Long]",
        "[float]" to "[Double]",
        "[bool]" to "[Boolean]",
        "[Variant]" to "[Any]",
        "[Array]" to "[VariantArray]",
    )
    private val doubleSkipRegex = Regex("(?<!\n)\n(?!\n)")

    override fun apply(task: ApiTask, context: GenerationContext) {
        val enumValues = context
            .globalEnumList
            .flatMap { it.values }

        val classes = context.classList
        val members = classes.flatMap { it.methods + it.properties + it.constants + it.signals }
        val innerEnumValue = classes.flatMap { it.enums }.flatMap { it.values }

        val allDocumented = enumValues + classes + members + innerEnumValue

        allDocumented.forEach {
            it.description = sanitize(it.description)
        }

        for (clazz in classes) {
            if (clazz.className.packageName == godotCorePackage) continue
            val documentation = (listOf(clazz) + clazz.methods + clazz.properties + clazz.constants + clazz.signals)
                .joinToString(" ") { it.description ?: "" }
            for (match in referenceRegex.findAll(documentation)) {
                val className = GenerationType(match.groupValues[1]).className
                if (className.packageName == godotCorePackage) {
                    clazz.additionalImports.add(className)
                }
            }
        }
    }

    private fun sanitize(documentation: String?): String {
        if (documentation.isNullOrEmpty()) {
            return ""
        }

        var unicodeString = documentation
            .replace("/*", "&#47;*")
            .replace("%", "&#37;")
            .replace("*/", "*&#92;")
            .replace(System.lineSeparator(), "\n")
            .replace(annotationRegex, "`$1`")

        for ((godotType, kotlinType) in typeReferences) {
            unicodeString = unicodeString.replace(godotType, kotlinType)
        }

        for ((regex) in typeToSanitize) {
            var matchResult = unicodeString.let { regex.find(it) }
            while (matchResult != null) {
                val titleRange = matchResult.groups[1]!!.range
                val contentRange = matchResult.groups[2]!!.range
                val content = with(unicodeString.substring(contentRange)) {
                    if (unicodeString.substring(titleRange).startsWith(constantTitle)) {
                        return@with this
                    }
                    convertToCamelCase()
                }
                unicodeString = unicodeString
                    .replaceRange(contentRange, content)
                    .removeRange(titleRange)
                matchResult = unicodeString.let { regex.find(it) }
            }
        }

        for ((output, regex) in tagsToSanitize) {
            var matchResult = unicodeString.let { regex.find(it) }
            while (matchResult != null) {
                val endTagRange = matchResult.groups[3]!!.range
                val beginTagRange = matchResult.groups[1]!!.range
                unicodeString = unicodeString
                    .replaceRange(endTagRange, output)
                    .replaceRange(beginTagRange, output)
                matchResult = unicodeString.let { regex.find(it) }
            }
        }

        unicodeString = unicodeString
            .replace("[codeblocks]", "")
            .replace("[/codeblocks]", "")

        for ((language, named) in languages) {
            unicodeString = unicodeString
                .replace("[$language]", "```${if (named) "$language\n//$language" else ""}")
                .replace("[/$language]", "```")
        }

        // Split the document into parts outside the code blocks
        val parts = codeBlockRegex.split(unicodeString)
        // Find all code blocks to reinsert later
        val codeBlocks = codeBlockRegex.findAll(unicodeString).map { it.value }.iterator()
        val sanitized = StringBuilder()
        parts.forEachIndexed { _, part ->
            // Replace single newlines with double newlines in non-code parts.
            // This regex finds newline characters that are not already doubled.
            sanitized.append(
                part.replace(doubleSkipRegex, "\n\n")
            )
            // If there's a corresponding code block, reinsert it unchanged.
            if (codeBlocks.hasNext()) {
                sanitized.append(codeBlocks.next())
            }
        }
        unicodeString = sanitized.toString()

        return unicodeString
    }
}

