package godot.gradle.tasks.ios

import godot.gradle.tasks.graal.NativeImageTask
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

abstract class CompileIOSNativeImageTask : NativeImageTask() {
    @get:OutputDirectory
    abstract val iosNativeImageDirectory: DirectoryProperty

    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val iosConfigDirectory: DirectoryProperty

    @get:InputDirectory
    abstract val capCacheDirectory: DirectoryProperty

    @TaskAction
    fun compileIOSNativeImage() {
        val iosGraalConfigDir = iosConfigDirectory.get().asFile.resolve("ios")
        fun configFiles(option: String, vararg files: String) = "$option=" + files.filter(String::isNotEmpty).joinToString(",")

        val shell = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) listOf("cmd", "/c") else emptyList()
        val command = shell + listOf(
            nativeImageExecutable.get(),
            "-cp",
            (gameJars.files + splitDependencyJars.files.sortedBy(File::getName)).joinToString(":") { file -> file.absolutePath },
            "--no-server",
            "-H:+ExitAfterRelocatableImageWrite",
            "-H:+SharedLibrary",
            "-H:TempDirectory=${iosNativeImageDirectory.get().asFile.absolutePath}",
            "-H:Name=${ArtifactNames.NATIVE_IMAGE_BASE_NAME}",
            "-H:+AddAllCharsets",
            "-H:-DeadlockWatchdogExitOnTimeout",
            "-H:DeadlockWatchdogInterval=0",
            "-H:+RemoveSaturatedTypeFlows",
            "-H:-SpawnIsolates",
            "-H:PageSize=16384",
            "-H:EnableURLProtocols=http,https,jar",
            "-H:Log=registerResource:",
            "-Djdk.internal.lambda.eagerlyInitialize=false",
            "-H:+ReportExceptionStackTraces",
            "-Dsvm.targetName=iOS",
            "-Dsvm.targetArch=arm64",
            "-H:+UseCAPCache",
            "-H:CAPCacheDir=${capCacheDirectory.get().asFile.absolutePath}",
            "-H:CompilerBackend=lir",
            "-Dsvm.platform=org.graalvm.nativeimage.Platform\$IOS_AARCH64",
            configFiles(
                "-H:JNIConfigurationFiles",
                defaultJniConfig.get().asFile.absolutePath,
                iosGraalConfigDir.resolve(iosJniConfig).absolutePath,
                additionalJniConfigurationFiles.get(),
            ),
            configFiles("-H:ReflectionConfigurationFiles", iosGraalConfigDir.resolve(iosReflectionConfig).absolutePath, additionalReflectionConfigurationFiles.get()),
            configFiles("-H:ResourceConfigurationFiles", iosGraalConfigDir.resolve(iosResourceConfig).absolutePath, additionalResourceConfigurationFiles.get()),
            "--no-fallback",
            optimizationLevel.get(),
        ) + listOfNotNull("--verbose".takeIf { verbose.get() }, "--strict-image-heap".takeIf { strictImageHeap.get() })
        execute(command)
    }
}
