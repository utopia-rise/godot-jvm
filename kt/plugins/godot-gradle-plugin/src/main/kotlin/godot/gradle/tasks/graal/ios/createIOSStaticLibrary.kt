package godot.gradle.tasks.graal.ios

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider

abstract class CreateIOSStaticLibraryTask : DefaultTask() {
    @get:InputDirectory
    abstract val iosNativeImageDirectory: DirectoryProperty

    @get:OutputFile
    abstract val userCodeArchive: RegularFileProperty

    @TaskAction
    fun createIOSStaticLibrary() {
        val iosLibDir = iosNativeImageDirectory.get().asFile
        val userCodeObjectPath = iosLibDir.listFiles()
            ?.filter { file -> file.isDirectory && file.name.startsWith("SVM-") }
            ?.maxByOrNull { file -> file.lastModified() }
            ?.resolve("usercode.o")
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

fun Project.createIOSStaticLibraryTask(
    downloadIOSGraalToolchainTask: TaskProvider<out Task>,
    createIOSGraalNativeImageTask: TaskProvider<out Task>
): TaskProvider<out Task> = tasks.register("createIOSStaticLibrary", CreateIOSStaticLibraryTask::class.java) {
    with(it) {
        group = "godot-jvm"
        description = "Pack usercode.o in a static library."

        dependsOn(
            downloadIOSGraalToolchainTask,
            createIOSGraalNativeImageTask
        )

        iosNativeImageDirectory.set(layout.buildDirectory.dir("libs/ios/native-image"))
        userCodeArchive.set(layout.buildDirectory.file("libs/ios/usercode.a"))
    }
}
