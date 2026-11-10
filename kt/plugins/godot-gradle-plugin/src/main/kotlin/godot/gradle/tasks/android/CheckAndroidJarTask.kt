package godot.gradle.tasks.android

import godot.gradle.exception.AndroidCompileSdkNotFoundException
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class CheckAndroidJarTask : DefaultTask() {
    @get:Input
    @get:Optional
    abstract val androidCompileSdkDirectory: Property<String>

    @TaskAction
    fun checkAndroidJar() {
        val configuredPath = androidCompileSdkDirectory.orNull?.trim()
            ?: throw AndroidCompileSdkNotFoundException("android compile SDK directory is not configured")
        if (configuredPath.isEmpty()) {
            throw AndroidCompileSdkNotFoundException("android compile SDK directory is blank")
        }
        val androidSdkDir = File(configuredPath)
        if (!androidSdkDir.exists()) {
            throw AndroidCompileSdkNotFoundException("${androidSdkDir.absolutePath} does not exist")
        }
        if (!androidSdkDir.isDirectory) {
            throw AndroidCompileSdkNotFoundException("${androidSdkDir.absolutePath} is not a directory")
        }
        if (!androidSdkDir.resolve("android.jar").isFile) {
            val content = androidSdkDir.listFiles()?.joinToString { it.name } ?: "<unable to list directory>"
            throw AndroidCompileSdkNotFoundException("${androidSdkDir.absolutePath} does not contain android.jar. Found files: $content")
        }
    }
}
