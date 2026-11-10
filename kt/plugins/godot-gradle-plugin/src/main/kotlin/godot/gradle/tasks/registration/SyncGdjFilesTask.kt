package godot.gradle.tasks.registration

import godot.tools.common.constants.FileExtensions
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class SyncGdjFilesTask : DefaultTask() {
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val generatedRegistrationFilesRootDir: DirectoryProperty

    @get:Input
    abstract val godotProjectDirPath: Property<String>

    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val existingRegistrationFilesIndexFile: RegularFileProperty

    @get:Internal
    abstract val gdjFilesOutputDir: DirectoryProperty

    @TaskAction
    fun update() {
        val generatedRoot = generatedRegistrationFilesRootDir.get().asFile
        val godotProjectDir = File(godotProjectDirPath.get())
        val targetRoot = gdjFilesOutputDir.get().asFile
        val generatedFiles = generatedRoot.walkTopDown()
            .filter { file -> file.isFile && file.extension == FileExtensions.GodotJvm.registrationFile }
            .sortedBy { file -> file.relativeTo(generatedRoot).invariantSeparatorsPath }
            .groupBy(File::nameWithoutExtension)
            .mapValues { (fileName, files) ->
                for (ignored in files.drop(1)) {
                    logger.warn("Multiple generated registration files share basename $fileName. Keeping ${files.first().absolutePath} and ignoring ${ignored.absolutePath}.")
                }
                files.first()
            }
        val matchedFileNames = mutableSetOf<String>()
        val candidateEmptyDirs = mutableSetOf<File>()

        for (line in existingRegistrationFilesIndexFile.get().asFile.readLines()) {
            val fileName = line.substringBefore('\t')
            val existingFile = godotProjectDir.resolve(line.substringAfter('\t'))
            val generatedFile = generatedFiles[fileName]
            if (generatedFile != null) {
                matchedFileNames += fileName
                existingFile.parentFile.mkdirs()
                generatedFile.copyIfChanged(existingFile)
            } else if (existingFile.exists()) {
                if (existingFile.delete()) {
                    candidateEmptyDirs += existingFile.parentFile
                } else {
                    logger.warn("Could not delete obsolete registration file. You need to delete it manually! ${existingFile.absolutePath}")
                }
            }
        }

        for ((fileName, generatedFile) in generatedFiles) {
            if (fileName in matchedFileNames) continue
            val targetFile = targetRoot.resolve(generatedFile.relativeTo(generatedRoot))
            targetFile.parentFile.mkdirs()
            generatedFile.copyIfChanged(targetFile)
        }

        candidateEmptyDirs
            .flatMap { dir -> generateSequence(dir, File::getParentFile).takeWhile { it.startsWith(targetRoot) && it != targetRoot }.toList() }
            .distinct()
            .sortedByDescending { it.invariantSeparatorsPath.length }
            .forEach { emptyDir ->
                if (emptyDir.isDirectory && emptyDir.listFiles()?.isEmpty() == true && !emptyDir.delete()) {
                    logger.warn("Could not delete seemingly empty registration directory! ${emptyDir.absolutePath}")
                }
            }
    }
}

private fun File.copyIfChanged(target: File) {
    if (target.isFile && target.readText().replace("\r\n", "\n") == readText().replace("\r\n", "\n")) return
    copyTo(target, overwrite = true)
}
