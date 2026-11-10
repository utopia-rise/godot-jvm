package godot.gradle.tasks.graal

import godot.gradle.ext.existingFileOrNull
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import org.gradle.work.DisableCachingByDefault
import java.io.File

@DisableCachingByDefault(because = "Native images depend on the host toolchain, which is not an input.")
abstract class CompileNativeImageTask : NativeImageTask() {
    @get:OutputFile
    abstract val sharedLibrary: RegularFileProperty

    @get:Input
    abstract val windowsDeveloperVcVarsPath: Property<String>

    @TaskAction
    fun compileNativeImage() {
        val windows = DefaultNativePlatform.getCurrentOperatingSystem().isWindows
        val classPath = gameJars.files.toList() + splitDependencyJars.files.sortedBy(File::getName)

        val imageArguments = mutableListOf(
            "-cp",
            classPath.joinToString(File.pathSeparator) { file -> if (windows) "\"${file.absolutePath}\"" else file.absolutePath },
            "--shared",
            "-H:Name=${ArtifactNames.NATIVE_IMAGE_BASE_NAME}",
            "-H:JNIConfigurationFiles=${defaultJniConfig.get().asFile.absolutePath},${additionalJniConfigurationFiles.get()}",
            "--no-fallback",
            optimizationLevel.get(),
        )
        additionalReflectionConfigurationFiles.get().takeIf(String::isNotEmpty)?.let { files -> imageArguments += "-H:ReflectionConfigurationFiles=$files" }
        additionalResourceConfigurationFiles.get().takeIf(String::isNotEmpty)?.let { files -> imageArguments += "-H:ResourceConfigurationFiles=$files" }
        if (verbose.get()) imageArguments += "--verbose"
        if (strictImageHeap.get()) imageArguments += "--strict-image-heap"

        val command = if (windows) {
            val vcVarsPath = windowsDeveloperVcVarsPath.get().trim().takeUnless(String::isEmpty)
                ?: throw IllegalArgumentException(
                    "Windows developer vcvars path is not configured. Set it to the Visual Studio vcvars script before building a GraalVM native image on Windows."
                )
            val vcVarsFile = File(vcVarsPath).existingFileOrNull()
                ?: throw IllegalArgumentException(
                    "The configured Visual Studio vcvars script does not exist or is not a file: ${File(vcVarsPath).absolutePath}"
                )
            listOf("cmd", "/c", "(", vcVarsFile.absolutePath, "&&", nativeImageExecutable.get()) + imageArguments + ")"
        } else {
            listOf(nativeImageExecutable.get()) + imageArguments
        }
        execute(command)
    }
}
