package godot.gradle.tasks.registrar_generation

import godot.gradle.projectExt.godotJvmExtension
import godot.tools.common.constants.FileExtensions
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import java.io.File

private const val godotProjectFileName = "project.godot"
internal data class ExistingRegistrationFileIndexRegistrar(
    val registrationFileName: String,
    val relativePath: String,
)

internal data class GeneratedRegistrationFile(
    val registrationFileName: String,
    val relativePath: String,
    val file: File,
)

@CacheableTask
abstract class ClassGraphIndexExistingRegistrationFilesTask : DefaultTask() {

    @get:Input
    abstract val godotProjectDirPath: Property<String>

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val existingRegistrationFiles: ConfigurableFileCollection

    @get:OutputFile
    abstract val existingRegistrationFilesIndexFile: RegularFileProperty

    @TaskAction
    fun index() {
        val godotProjectDir = File(godotProjectDirPath.get())
        val indexEntriesByFileName = linkedMapOf<String, ExistingRegistrationFileIndexRegistrar>()

        existingRegistrationFiles.files
            .asSequence()
            .filter(File::isFile)
            .sortedBy { it.relativeTo(godotProjectDir).invariantSeparatorsPath }
            .forEach { registrationFile ->
                val registrationFileName = registrationFile.nameWithoutExtension
                val indexRegistrar = ExistingRegistrationFileIndexRegistrar(
                    registrationFileName = registrationFileName,
                    relativePath = registrationFile.relativeTo(godotProjectDir).invariantSeparatorsPath
                )
                val previousValue = indexEntriesByFileName.putIfAbsent(registrationFileName, indexRegistrar)
                if (previousValue != null) {
                    logger.warn(
                        "Multiple existing registration files share basename $registrationFileName. " +
                            "Keeping ${previousValue.relativePath} and ignoring ${indexRegistrar.relativePath}."
                    )
                }
            }

        val indexEntries = indexEntriesByFileName.values
            .sortedWith(compareBy(ExistingRegistrationFileIndexRegistrar::registrationFileName, ExistingRegistrationFileIndexRegistrar::relativePath))
            .toList()

        val indexFile = existingRegistrationFilesIndexFile.get().asFile
        indexFile.parentFile.mkdirs()
        indexFile.writeText(
            indexEntries.joinToString(separator = "\n", postfix = if (indexEntries.isNotEmpty()) "\n" else "") { registrar ->
                "${registrar.registrationFileName}\t${registrar.relativePath}"
            }
        )
    }
}

internal fun Project.requireConfiguredGodotProjectDirectory(): File {
    val configuredDir = godotJvmExtension.godotProjectDirectory.orNull?.asFile ?: projectDir
    val projectFile = configuredDir.resolve(godotProjectFileName)
    if (!projectFile.isFile) {
        throw GradleException(
            "No $godotProjectFileName file was found in the configured Godot project directory: ${configuredDir.absolutePath}. " +
                "Set godot.godotProjectDirectory to the directory that contains $godotProjectFileName."
        )
    }
    return configuredDir
}

internal fun Project.godotRegistrationFileTree(rootDir: File) = fileTree(rootDir).matching { patternFilterable ->
    patternFilterable.include("**/*.${FileExtensions.GodotJvm.registrationFile}")
    patternFilterable.exclude("build/**")
    patternFilterable.exclude("android/**")
    patternFilterable.exclude(".*/**")
    patternFilterable.exclude("**/.*/**")
}

internal fun readExistingRegistrationFileIndex(indexFile: File): List<ExistingRegistrationFileIndexRegistrar> {
    if (!indexFile.isFile) {
        return emptyList()
    }

    return indexFile.readLines()
        .asSequence()
        .filter { it.isNotBlank() }
        .mapNotNull { line ->
            val separatorIndex = line.indexOf('\t')
            if (separatorIndex <= 0 || separatorIndex == line.lastIndex) {
                null
            } else {
                ExistingRegistrationFileIndexRegistrar(
                    registrationFileName = line.substring(0, separatorIndex),
                    relativePath = line.substring(separatorIndex + 1)
                )
            }
        }
        .toList()
}

internal fun readGeneratedRegistrationFiles(generatedRoot: File, logger: org.gradle.api.logging.Logger): Map<String, GeneratedRegistrationFile> {
    val generatedFilesByFileName = linkedMapOf<String, GeneratedRegistrationFile>()

    generatedRoot
        .walkTopDown()
        .filter { it.isFile && it.extension == FileExtensions.GodotJvm.registrationFile }
        .sortedBy { it.relativeTo(generatedRoot).invariantSeparatorsPath }
        .forEach { generatedFile ->
            val registrationFileName = generatedFile.nameWithoutExtension
            val generatedRegistrationFile = GeneratedRegistrationFile(
                registrationFileName = registrationFileName,
                relativePath = generatedFile.relativeTo(generatedRoot).invariantSeparatorsPath,
                file = generatedFile
            )
            val previousValue = generatedFilesByFileName.putIfAbsent(registrationFileName, generatedRegistrationFile)
            if (previousValue != null) {
                logger.warn(
                    "Multiple generated registration files share basename $registrationFileName. " +
                        "Keeping ${previousValue.file.absolutePath} and ignoring ${generatedFile.absolutePath}."
                )
            }
        }

    return generatedFilesByFileName
}

fun Project.registrarGenerationIndexExistingRegistrationFilesTask(): TaskProvider<ClassGraphIndexExistingRegistrationFilesTask> {
    val godotProjectDir = requireConfiguredGodotProjectDirectory()
    val registrationFileTree = godotRegistrationFileTree(godotProjectDir)

    return tasks.register(
        "registrarGenerationIndexExistingRegistrationFiles",
        ClassGraphIndexExistingRegistrationFilesTask::class.java
    ) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Indexes existing .gdj files across the Godot project."
        task.godotProjectDirPath.convention(godotProjectDir.absolutePath)
        task.existingRegistrationFiles.from(registrationFileTree)
        task.existingRegistrationFilesIndexFile.convention(
            layout.buildDirectory.file("intermediates/registrar-generation/existing-registration-files.idx")
        )
    }
}
