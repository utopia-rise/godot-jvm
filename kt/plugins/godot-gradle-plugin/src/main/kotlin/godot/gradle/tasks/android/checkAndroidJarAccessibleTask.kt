package godot.gradle.tasks.android

import godot.gradle.exception.AndroidCompileSdkNotFoundException
import godot.gradle.projectExt.godotJvmExtension
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import java.io.File

abstract class CheckAndroidJarAccessibleTask : DefaultTask() {
    @get:Input
    @get:Optional
    abstract val androidCompileSdkDirectory: Property<String>

    @TaskAction
    fun checkAndroidJarAccessible() {
        val androidSdkDir = resolveAndroidCompileSdkDirectory()
        val androidJar = androidSdkDir.resolve("android.jar")

        when {
            !androidJar.isFile -> {
                val content = androidSdkDir.listFiles()
                    ?.joinToString { it.name }
                    ?: "<unable to list directory>"
                throw AndroidCompileSdkNotFoundException(
                    "${androidSdkDir.absolutePath} does not contain android.jar. Found files: $content"
                )
            }
        }
    }

    private fun resolveAndroidCompileSdkDirectory(): File {
        val configuredPath = androidCompileSdkDirectory.orNull?.trim()
            ?: throw AndroidCompileSdkNotFoundException("android compile SDK directory is not configured")

        if (configuredPath.isEmpty()) {
            throw AndroidCompileSdkNotFoundException("android compile SDK directory is blank")
        }

        val configuredFile = File(configuredPath)
        if (!configuredFile.exists()) {
            throw AndroidCompileSdkNotFoundException("${configuredFile.absolutePath} does not exist")
        }
        if (!configuredFile.isDirectory) {
            throw AndroidCompileSdkNotFoundException("${configuredFile.absolutePath} is not a directory")
        }
        return configuredFile
    }
}

fun Project.checkAndroidJarAccessibleTask(): TaskProvider<out Task> {
    val androidCompileSdkDirectory = godotJvmExtension.android.compileSdkDirectory

    return tasks.register("checkAndroidJarAccessible", CheckAndroidJarAccessibleTask::class.java) {
        with(it) {
            group = "godot-jvm"
            description =
                "Checks if android.jar is present in the configured compileSdkDirectory. Needed for Android builds only"

            this.androidCompileSdkDirectory.set(androidCompileSdkDirectory)
        }
    }
}
