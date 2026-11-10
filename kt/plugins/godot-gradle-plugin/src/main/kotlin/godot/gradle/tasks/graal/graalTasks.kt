package godot.gradle.tasks.graal

import godot.gradle.ext.resolveExecutable
import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.projectExt.libsDirectory
import godot.gradle.tasks.copy.CopyIntoGodotProjectTask
import godot.gradle.tasks.copy.registerCopyIntoGodotProject
import godot.gradle.tasks.dependencies.splitDependencyJars
import godot.tools.common.constants.ArtifactNames
import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider
import org.gradle.nativeplatform.platform.internal.DefaultNativePlatform
import java.io.File

class GraalTools(
    val checkNativeImageTool: TaskProvider<CheckNativeImageToolTask>,
    val writeGraalJniConfig: TaskProvider<WriteGraalJniConfigTask>,
)

fun Project.registerGraalTools(): GraalTools {
    val nativeImageExecutable = if (DefaultNativePlatform.getCurrentOperatingSystem().isWindows) "native-image.cmd" else "native-image"
    val checkNativeImageTool = tasks.register("checkNativeImageTool", CheckNativeImageToolTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Checks if the GraalVM native image tool is accessible and executable. Needed for GraalVM native-image builds only"
        task.nativeImageExecutable.set(godotJvmExtension.graal.homeDirectory.map { home ->
            if (home.isBlank()) "" else File(home).resolveExecutable(nativeImageExecutable).absolutePath
        })
    }
    val writeGraalJniConfig = tasks.register("writeGraalJniConfig", WriteGraalJniConfigTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Writes the JNI configuration Godot-JVM itself needs in a GraalVM native image."
        task.resourcePath.set(DEFAULT_JNI_CONFIG)
        task.configFile.set(layout.buildDirectory.file("graal/$DEFAULT_JNI_CONFIG"))
    }
    return GraalTools(checkNativeImageTool, writeGraalJniConfig)
}

const val DEFAULT_JNI_CONFIG = "godot-jvm-graal-jni-config.json"

fun Project.configureNativeImage(task: NativeImageTask, buildType: BuildType, gameJars: List<Provider<RegularFile>>, tools: GraalTools) {
    val graal = godotJvmExtension.graal
    val graalDirectory = projectDir.resolve("graal")
    task.dependsOn(tools.checkNativeImageTool)
    task.gameJars.from(gameJars)
    task.splitDependencyJars.from(splitDependencyJars())
    task.defaultJniConfig.set(tools.writeGraalJniConfig.flatMap(WriteGraalJniConfigTask::configFile))
    task.workingDirectory.set(libsDirectory(buildType))
    task.nativeImageExecutable.set(tools.checkNativeImageTool.flatMap(CheckNativeImageToolTask::nativeImageExecutable))
    task.verbose.set(graal.verbose)
    task.strictImageHeap.set(graal.strictImageHeapEnabled)
    task.optimizationLevel.set(if (buildType == BuildType.RELEASE) "-O2" else "-Ob")
    task.additionalJniConfigurationFiles.set(graal.additionalJniConfigurationFiles.map { files -> files.joinToString(",") { file -> graalDirectory.resolve(file).absolutePath } })
    task.additionalReflectionConfigurationFiles.set(graal.additionalReflectionConfigurationFiles.map { files -> files.joinToString(",") })
    task.additionalResourceConfigurationFiles.set(graal.additionalResourceConfigurationFiles.map { files -> files.joinToString(",") })
}

fun Project.registerGraalTasks(
    buildType: BuildType,
    gameJars: List<Provider<RegularFile>>,
    tools: GraalTools,
): TaskProvider<CopyIntoGodotProjectTask> {
    val extension = when {
        DefaultNativePlatform.getCurrentOperatingSystem().isWindows -> "dll"
        DefaultNativePlatform.getCurrentOperatingSystem().isMacOsX -> "dylib"
        else -> "so"
    }
    val sharedLibraryName = "${ArtifactNames.NATIVE_IMAGE_BASE_NAME}.$extension"
    val nativeImage = tasks.register(buildType.named("compileNativeImage"), CompileNativeImageTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Converts the packaged jars into a GraalVM native image."
        configureNativeImage(task, buildType, gameJars, tools)
        task.sharedLibrary.set(libsDirectory(buildType).map { directory -> directory.file(sharedLibraryName) })
        task.windowsDeveloperVcVarsPath.set(godotJvmExtension.graal.windowsDeveloperVcVarsPath.orElse(""))
    }
    return registerCopyIntoGodotProject(
        name = buildType.named("copyNativeImage"),
        description = "Copies the GraalVM native image of this build type into the Godot project.",
        nativeImage.flatMap(CompileNativeImageTask::sharedLibrary) to
            godotJvmDirectory().resolve(buildType.id).resolve(sharedLibraryName),
    )
}
