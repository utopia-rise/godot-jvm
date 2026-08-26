package godot.gradle.tasks.graal.ios

import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.tasks.graal.iosJniConfig
import godot.gradle.tasks.graal.iosReflectionConfig
import godot.gradle.tasks.graal.iosResourceConfig
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

abstract class CreateIOSGraalNativeImageTask : DefaultTask() {
    @get:OutputDirectory
    abstract val iosNativeImageDirectory: DirectoryProperty

    @get:InputDirectory
    abstract val graalDirectory: DirectoryProperty

    @get:InputDirectory
    abstract val capCacheDirectory: DirectoryProperty

    @get:InputFile
    abstract val mainJar: RegularFileProperty

    @get:InputFile
    abstract val bootstrapJar: RegularFileProperty

    @get:Input
    @get:Optional
    abstract val graalVmHomeDirectory: Property<String>

    @get:Input
    abstract val additionalJniConfigurationFiles: Property<String>

    @get:Input
    abstract val additionalReflectionConfigurationFiles: Property<String>

    @get:Input
    abstract val additionalResourceConfigurationFiles: Property<String>

    @get:Input
    abstract val verboseEnabled: Property<Boolean>

    @TaskAction
    fun createIOSGraalNativeImage() {
        val libsDir = mainJar.get().asFile.parentFile
        val iosLibDir = iosNativeImageDirectory.get().asFile
        val graalDir = graalDirectory.get().asFile
        val iosGraalConfigDir = graalDir.resolve("ios")

        val jniConfigurationFilesArgument = buildString {
            append("-H:JNIConfigurationFiles=")
            append(graalDir.resolve("godot-jvm-graal-jni-config.json").absolutePath)
            append(",")
            append(iosGraalConfigDir.resolve(iosJniConfig).absolutePath)
            val additionalFiles = additionalJniConfigurationFiles.get()
            if (additionalFiles.isNotEmpty()) {
                append(",")
                append(additionalFiles)
            }
        }

        val reflectionConfigurationFilesArgument = buildString {
            append("-H:ReflectionConfigurationFiles=")
            append(iosGraalConfigDir.resolve(iosReflectionConfig).absolutePath)
            val additionalFiles = additionalReflectionConfigurationFiles.get()
            if (additionalFiles.isNotEmpty()) {
                append(",")
                append(additionalFiles)
            }
        }

        val resourceConfigurationFilesArgument = buildString {
            append("-H:ResourceConfigurationFiles=")
            append(iosGraalConfigDir.resolve(iosResourceConfig).absolutePath)
            val additionalFiles = additionalResourceConfigurationFiles.get()
            if (additionalFiles.isNotEmpty()) {
                append(",")
                append(additionalFiles)
            }
        }

        val nativeImageExecutable = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
            File(graalVmHomeDirectory.get()).resolve("bin").resolve("native-image.cmd").absolutePath
        } else {
            File(graalVmHomeDirectory.get()).resolve("bin").resolve("native-image").absolutePath
        }

        val command = mutableListOf<String>().apply {
            if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) {
                add("cmd")
                add("/c")
            }
        }.apply {
            add(nativeImageExecutable)
            addAll(listOf(
            "-cp",
            "${bootstrapJar.get().asFile.absolutePath}:${mainJar.get().asFile.absolutePath}",
            "--no-server",
            "-H:+ExitAfterRelocatableImageWrite",
            "-H:+SharedLibrary",
            "-H:TempDirectory=${iosLibDir.absolutePath}",
            "-H:Name=usercode",
            "-H:+AddAllCharsets",
            "-H:-DeadlockWatchdogExitOnTimeout",
            "-H:DeadlockWatchdogInterval=0",
            "-H:+RemoveSaturatedTypeFlows",
            "-H:-SpawnIsolates",
            "-H:PageSize=16384",
            "-H:EnableURLProtocols=http,https,jar",
            "-H:+PrintAnalysisCallTree",
            "-H:Log=registerResource:",
            "-Djdk.internal.lambda.eagerlyInitialize=false",
            "-H:+ReportExceptionStackTraces",
            "-Dsvm.targetName=iOS",
            "-Dsvm.targetArch=arm64",
            "-H:+UseCAPCache",
            "-H:CAPCacheDir=${capCacheDirectory.get().asFile.absolutePath}",
            "-H:CompilerBackend=lir",
            "-Dsvm.platform=org.graalvm.nativeimage.Platform\$IOS_AARCH64",
            jniConfigurationFilesArgument,
            reflectionConfigurationFilesArgument,
            resourceConfigurationFilesArgument,
            "--no-fallback",
            ))
        }

        if (verboseEnabled.get()) {
            command.add("--verbose")
        }

        println(command.joinToString(" "))

        val process = ProcessBuilder(command)
            .directory(libsDir)
            .inheritIO()
            .start()

        require(process.waitFor() == 0) {
            "Failed to create the iOS Graal native image"
        }
    }
}

fun Project.createIOSGraalNativeImageTask(
    checkNativeImageToolAccessibleTask: TaskProvider<out Task>,
    copyDefaultGraalIOSConfigsTask: TaskProvider<out Task>,
    downloadIOSGraalToolchainTask: TaskProvider<out DownloadIOSGraalToolchainTask>,
    packageMainJarTask: TaskProvider<out Task>,
    packageBootstrapJarTask: TaskProvider<out Task>
): TaskProvider<out Task> {
    val libsDirectory = layout.buildDirectory.dir("libs")
    val iosNativeImageDirectory = layout.buildDirectory.dir("libs/ios/native-image")
    val graalDirectory = layout.buildDirectory.dir("graal")
    val graalVmHomeDirectory = godotJvmExtension.graalVmHomeDirectory
    val isVerboseEnabled = godotJvmExtension.isGraalNativeImageVerboseEnabled
    val projectBaseDir = projectDir
    val additionalJniConfigurationFiles = godotJvmExtension.additionalGraalJniConfigurationFiles.map { configFiles ->
        configFiles.joinToString(",") { configFile ->
            projectBaseDir.resolve("graal").resolve(configFile).absolutePath
        }
    }
    val additionalReflectionConfigurationFiles = godotJvmExtension
        .additionalGraalReflectionConfigurationFiles
        .map { configFiles -> configFiles.joinToString(",") }
    val additionalResourceConfigurationFiles = godotJvmExtension
        .additionalGraalResourceConfigurationFiles
        .map { configFiles -> configFiles.joinToString(",") }

    return tasks.register("createIOSGraalNativeImage", CreateIOSGraalNativeImageTask::class.java) {
        with(it) {
            group = "godot-jvm-internal"
            description = "INTERNAL TASK ! Converts main.jar and bootstrap.jar into a GraalVM ios native image."

            dependsOn(
                checkNativeImageToolAccessibleTask,
                copyDefaultGraalIOSConfigsTask,
                downloadIOSGraalToolchainTask,
                packageMainJarTask,
                packageBootstrapJarTask
            )

            this.iosNativeImageDirectory.set(iosNativeImageDirectory)
            this.graalDirectory.set(graalDirectory)
            this.capCacheDirectory.set(
                downloadIOSGraalToolchainTask.flatMap { task -> task.capCacheDirectory }
            )
            this.mainJar.set(libsDirectory.map { directory -> directory.file("main.jar") })
            this.bootstrapJar.set(libsDirectory.map { directory -> directory.file("godot-bootstrap.jar") })
            this.graalVmHomeDirectory.set(graalVmHomeDirectory)
            this.additionalJniConfigurationFiles.set(additionalJniConfigurationFiles)
            this.additionalReflectionConfigurationFiles.set(additionalReflectionConfigurationFiles)
            this.additionalResourceConfigurationFiles.set(additionalResourceConfigurationFiles)
            this.verboseEnabled.set(isVerboseEnabled)
        }
    }
}
