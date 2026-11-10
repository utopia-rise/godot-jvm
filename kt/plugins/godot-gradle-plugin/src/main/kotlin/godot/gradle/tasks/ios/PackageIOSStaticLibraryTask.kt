package godot.gradle.tasks.ios

import godot.tools.common.constants.ArtifactNames
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class PackageIOSStaticLibraryTask : DefaultTask() {
    @get:InputDirectory
    abstract val iosNativeImageDirectory: DirectoryProperty

    @get:OutputFile
    abstract val userCodeArchive: RegularFileProperty

    @TaskAction
    fun packageIOSStaticLibrary() {
        val iosLibDir = iosNativeImageDirectory.get().asFile
        val userCodeObjectPath = iosLibDir.listFiles()
            ?.filter { file -> file.isDirectory && file.name.startsWith("SVM-") }
            ?.maxByOrNull { file -> file.lastModified() }
            ?.resolve("${ArtifactNames.NATIVE_IMAGE_BASE_NAME}.o")
            ?.absolutePath
            ?: error("Could not find generated iOS object file in ${iosLibDir.absolutePath}")

        val command = listOf(
            "ar",
            "-r",
            userCodeArchive.get().asFile.absolutePath,
            userCodeObjectPath,
        )

        logger.quiet(command.joinToString(" "))

        val process = ProcessBuilder(command)
            .directory(iosLibDir)
            .inheritIO()
            .start()

        require(process.waitFor() == 0) {
            "Failed to create the iOS static library"
        }
    }
}
