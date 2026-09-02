package godot.gradle.tasks.graal

import godot.gradle.exception.GraalNativeImageToolNotFountException
import godot.gradle.ext.executableFileOrNull
import godot.gradle.ext.resolveExecutable
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

abstract class CheckNativeImageToolAccessibleTask : DefaultTask() {
    @get:Input
    @get:Optional
    abstract val nativeImageExecutable: Property<String>

    @TaskAction
    fun checkNativeImageToolAccessible() {
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

fun Project.checkNativeImageToolAccessibleTask(): TaskProvider<out Task> {
    val nativeImageExecutablePath = godotJvmExtension.graalVmHomeDirectory.map { graalVmHomeDirectory ->
        if (graalVmHomeDirectory.isBlank()) {
            return@map ""
        }
        val executableName = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
            "native-image.cmd"
        } else {
            "native-image"
        }
        File(graalVmHomeDirectory).resolveExecutable(executableName).absolutePath
    }

    return tasks.register("checkNativeImageToolAccessible", CheckNativeImageToolAccessibleTask::class.java) {
        with(it) {
            group = "godot-jvm"
            description =
                "Checks if the GraalVM native image tool is accessible and executable. Needed for GraalVM native-image builds only"

            nativeImageExecutable.set(nativeImageExecutablePath)
        }
    }
}
