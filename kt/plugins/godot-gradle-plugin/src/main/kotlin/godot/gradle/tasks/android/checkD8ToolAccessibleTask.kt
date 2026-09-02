package godot.gradle.tasks.android

import godot.gradle.exception.D8ToolNotFoundException
import godot.gradle.ext.executableFileOrNull
import godot.gradle.projectExt.godotJvmExtension
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

abstract class CheckD8ToolAccessibleTask : DefaultTask() {
    @get:Input
    @get:Optional
    abstract val d8ToolPath: Property<String>

    @TaskAction
    fun checkD8ToolAccessible() {
        val d8Tool = resolveD8Tool()
        val command = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
            listOf("cmd", "/c", d8Tool.absolutePath, "--version")
        } else {
            listOf(d8Tool.absolutePath, "--version")
        }

        val process = try {
            ProcessBuilder(command)
                .redirectErrorStream(true)
                .start()
        } catch (e: Throwable) {
            throw D8ToolNotFoundException("could not run ${d8Tool.absolutePath}: ${e.message}")
        }

        if (process.waitFor() != 0) {
            throw D8ToolNotFoundException("${d8Tool.absolutePath} exists but did not run successfully with --version")
        }
    }

    private fun resolveD8Tool(): File {
        val configuredPath = d8ToolPath.orNull?.trim()
            ?: throw D8ToolNotFoundException("d8 tool path is not configured")

        if (configuredPath.isEmpty()) {
            throw D8ToolNotFoundException("d8 tool path is blank")
        }

        val configuredFile = File(configuredPath)
        return configuredFile.executableFileOrNull()
            ?: throw D8ToolNotFoundException("${configuredFile.absolutePath} is not an executable file")
    }
}

fun Project.checkD8ToolAccessibleTask(): TaskProvider<out Task> {
    val d8ToolPath = godotJvmExtension.android.d8ToolPath

    return tasks.register("checkD8ToolAccessible", CheckD8ToolAccessibleTask::class.java) {
        with(it) {
            group = "godot-jvm"
            description = "Checks if the d8 tool is accessible and executable. Needed for android builds only"

            this.d8ToolPath.set(d8ToolPath)
        }
    }
}
