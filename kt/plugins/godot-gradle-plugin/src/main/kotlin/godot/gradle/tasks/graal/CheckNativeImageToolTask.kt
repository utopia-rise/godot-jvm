package godot.gradle.tasks.graal

import godot.gradle.exception.GraalNativeImageToolNotFountException
import godot.gradle.ext.executableFileOrNull
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

abstract class CheckNativeImageToolTask : DefaultTask() {
    @get:Input
    @get:Optional
    abstract val nativeImageExecutable: Property<String>

    @TaskAction
    fun checkNativeImageTool() {
        val nativeImageExecutable = resolveNativeImageExecutable()
        val command = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
            listOf("cmd", "/c", nativeImageExecutable.absolutePath, "--version")
        } else {
            listOf(nativeImageExecutable.absolutePath, "--version")
        }

        val process = try {
            ProcessBuilder(command)
                .redirectErrorStream(true)
                .start()
        } catch (e: Throwable) {
            throw GraalNativeImageToolNotFountException("could not run ${nativeImageExecutable.absolutePath}: ${e.message}")
        }

        val exitCode = process.waitFor()
        if (exitCode != 0) {
            throw GraalNativeImageToolNotFountException("${nativeImageExecutable.absolutePath} exists but did not run successfully with --version")
        }
    }

    private fun resolveNativeImageExecutable(): File {
        val configuredPath = nativeImageExecutable.orNull?.trim()
            ?: throw GraalNativeImageToolNotFountException("native-image path is not configured")

        if (configuredPath.isEmpty()) {
            throw GraalNativeImageToolNotFountException("native-image path is blank")
        }

        val configuredFile = File(configuredPath)
        return configuredFile.executableFileOrNull()
            ?: throw GraalNativeImageToolNotFountException("${configuredFile.absolutePath} is not an executable file")
    }
}
