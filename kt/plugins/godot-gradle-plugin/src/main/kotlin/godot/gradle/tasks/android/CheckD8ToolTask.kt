package godot.gradle.tasks.android

import godot.gradle.exception.D8ToolNotFoundException
import godot.gradle.ext.executableFileOrNull
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

abstract class CheckD8ToolTask : DefaultTask() {
    @get:Input
    @get:Optional
    abstract val d8ToolPath: Property<String>

    @TaskAction
    fun checkD8Tool() {
        val configuredPath = d8ToolPath.orNull?.trim()
            ?: throw D8ToolNotFoundException("d8 tool path is not configured")
        if (configuredPath.isEmpty()) {
            throw D8ToolNotFoundException("d8 tool path is blank")
        }
        val d8Tool = File(configuredPath).executableFileOrNull()
            ?: throw D8ToolNotFoundException("${File(configuredPath).absolutePath} is not an executable file")
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
}
