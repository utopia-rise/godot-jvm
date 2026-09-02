package godot.gradle.tasks

import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.tasks.registrar_generation.ClassGraphIndexExistingRegistrationFilesTask
import godot.gradle.tasks.registrar_generation.readExistingRegistrationFileIndex
import godot.gradle.tasks.registrar_generation.readGeneratedRegistrationFiles
import godot.gradle.tasks.registrar_generation.requireConfiguredGodotProjectDirectory
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.OutputFiles
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import java.io.File

@CacheableTask
abstract class ClassGraphUpdateRegistrationFilesTask : DefaultTask() {

    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val generatedRegistrationFilesRootDir: DirectoryProperty

    @get:Input
    abstract val godotProjectDirPath: Property<String>

    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val existingRegistrationFilesIndexFile: RegularFileProperty

    @get:OutputDirectory
    abstract val registrationFilesOutputDir: DirectoryProperty

    @get:OutputFiles
    abstract val synchronizedRegistrationFiles: ConfigurableFileCollection

    @TaskAction
    fun update() {
        val generatedRoot = generatedRegistrationFilesRootDir.get().asFile
        val godotProjectDir = File(godotProjectDirPath.get())
        val existingRegistrationFileIndex = readExistingRegistrationFileIndex(existingRegistrationFilesIndexFile.get().asFile)
        val generatedFilesByFileName = readGeneratedRegistrationFiles(generatedRoot, logger)
        val targetRoot = registrationFilesOutputDir.get().asFile
        val matchedFileNames = mutableSetOf<String>()
        val candidateEmptyDirs = mutableSetOf<File>()

        targetRoot.mkdirs()

        existingRegistrationFileIndex.forEach { indexRegistrar ->
            val existingFile = godotProjectDir.resolve(indexRegistrar.relativePath)
            val generatedFile = generatedFilesByFileName[indexRegistrar.registrationFileName]

            if (generatedFile != null) {
                matchedFileNames.add(indexRegistrar.registrationFileName)
                existingFile.parentFile.mkdirs()
                generatedFile.file.copyTo(existingFile, overwrite = true)
            } else if (existingFile.exists()) {
                if (!existingFile.delete()) {
                    logger.warn("Could not delete obsolete registration file. You need to delete it manually! ${existingFile.absolutePath}")
                } else {
                    existingFile.parentFile?.let(candidateEmptyDirs::add)
                }
            }
        }

        generatedFilesByFileName.values
            .asSequence()
            .filter { generatedFile -> generatedFile.registrationFileName !in matchedFileNames }
            .forEach { generatedFile ->
                val targetFile = targetRoot.resolve(generatedFile.relativePath)
                targetFile.parentFile.mkdirs()
                generatedFile.file.copyTo(targetFile, overwrite = true)
            }

        candidateEmptyDirs
            .flatMap { dir -> generateSequence(dir) { currentDir -> currentDir.parentFile?.takeIf { parent -> parent.startsWith(targetRoot) } } }
            .distinct()
            .sortedByDescending { it.invariantSeparatorsPath.length }
            .filter { it.startsWith(targetRoot) && it != targetRoot }
            .forEach { emptyDir ->
                if (emptyDir.isDirectory && emptyDir.listFiles()?.isEmpty() == true && !emptyDir.delete()) {
                    logger.warn("Could not delete seemingly empty registration directory! ${emptyDir.absolutePath}")
                }
            }
    }
}

fun Project.registrarGenerationSyncRegistrationFilesTask(
    generateRegistrarFilesTask: TaskProvider<ClassGraphGenerateRegistrarFilesTask>,
    indexExistingRegistrationFilesTask: TaskProvider<ClassGraphIndexExistingRegistrationFilesTask>,
): TaskProvider<ClassGraphUpdateRegistrationFilesTask> {
    val godotProjectDir = requireConfiguredGodotProjectDirectory()
    val registrationFilesOutputDirPath = (
        godotJvmExtension
            .registrationFilesDirectory
            .orNull
            ?.asFile
            ?: projectDir.resolve("gdj")
        )
        .relativeTo(projectDir)
        .path
        .replace(File.separator, "/")
        .removePrefix("/")
        .removeSuffix("/")
    val registrationFilesOutputDir = layout.projectDirectory.dir(registrationFilesOutputDirPath)

    return tasks.register(
        "registrarGenerationSyncRegistrationFiles",
        ClassGraphUpdateRegistrationFilesTask::class.java
    ) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Synchronizes staged generated .gdj files into the Godot project."
        task.dependsOn(generateRegistrarFilesTask)
        task.dependsOn(indexExistingRegistrationFilesTask)
        task.generatedRegistrationFilesRootDir.convention(
            generateRegistrarFilesTask.flatMap { it.generatedRegistrationFilesRootDir }
        )
        task.godotProjectDirPath.convention(godotProjectDir.absolutePath)
        task.existingRegistrationFilesIndexFile.convention(
            indexExistingRegistrationFilesTask.flatMap { it.existingRegistrationFilesIndexFile }
        )
        task.registrationFilesOutputDir.convention(registrationFilesOutputDir)
        task.synchronizedRegistrationFiles.from(providers.provider {
            val generatedRoot = generateRegistrarFilesTask.get().generatedRegistrationFilesRootDir.get().asFile
            val generatedFilesByFileName = readGeneratedRegistrationFiles(generatedRoot, logger)
            val existingRegistrationFileIndex = readExistingRegistrationFileIndex(
                indexExistingRegistrationFilesTask.get().existingRegistrationFilesIndexFile.get().asFile
            )
            val matchedFileNames = mutableSetOf<String>()
            val synchronizedFiles = mutableListOf<File>()
            val targetRoot = registrationFilesOutputDir.asFile

            existingRegistrationFileIndex.forEach { indexRegistrar ->
                if (generatedFilesByFileName.containsKey(indexRegistrar.registrationFileName)) {
                    matchedFileNames.add(indexRegistrar.registrationFileName)
                    synchronizedFiles.add(godotProjectDir.resolve(indexRegistrar.relativePath))
                }
            }

            generatedFilesByFileName.values
                .asSequence()
                .filter { generatedFile -> generatedFile.registrationFileName !in matchedFileNames }
                .mapTo(synchronizedFiles) { generatedFile ->
                    targetRoot.resolve(generatedFile.relativePath)
                }

            synchronizedFiles
        })
    }
}
