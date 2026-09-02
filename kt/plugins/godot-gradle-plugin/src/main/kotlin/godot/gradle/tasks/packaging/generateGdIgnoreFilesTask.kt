package godot.gradle.tasks

import godot.gradle.tasks.registrar_generation.requireConfiguredGodotProjectDirectory
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider
import java.io.File

fun Project.generateGdIgnoreFilesTask(): TaskProvider<Task> {
    val projectDir = layout.projectDirectory.asFile
    val godotProjectDir = provider { requireConfiguredGodotProjectDirectory() }
    val buildDirProvider = layout.buildDirectory.asFile

    return tasks.register("generateGdIgnoreFiles") {
        with(it) {
            group = "godot-jvm"
            description = "Generates .gdignore files to hide gradle files, kotlin build files and jre files from the godot editor."

            doFirst {
                val buildDir = buildDirProvider.get()
                val godotJvmDir = godotProjectDir.get().resolve("jvm")

                val guaranteedTargetDirs = sequenceOf(
                    buildDir,
                    projectDir.resolve("gradle"),
                )
                val existingTargetDirs = godotJvmDir
                    .listFiles()
                    ?.asSequence()
                    ?.filter { it.name.startsWith("jre-") }
                    ?: emptySequence()

                (guaranteedTargetDirs + existingTargetDirs).forEach { dirToIgnore ->
                    ensureGdIgnoreFile(dirToIgnore)
                }
            }
        }
    }
}

private fun ensureGdIgnoreFile(dirToIgnore: File) {
    dirToIgnore.mkdirs()
    dirToIgnore.resolve(".gdignore").createNewFile()
}
