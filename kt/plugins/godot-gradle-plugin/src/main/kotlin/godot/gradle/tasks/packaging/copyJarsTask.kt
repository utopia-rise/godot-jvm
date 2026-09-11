package godot.gradle.tasks

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.tasks.registrar_generation.requireConfiguredGodotProjectDirectory
import godot.gradle.projectExt.GODOT_SINGLE_CONFIGURATION
import godot.gradle.projectExt.variantDirectoryName
import godot.tools.common.constants.ArtifactNames
import godot.tools.common.constants.Paths
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.CopySpec
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskProvider
import java.io.File

private fun Project.godotJvmDestinationDir(): File =
    requireConfiguredGodotProjectDirectory().resolve(Paths.GODOT_JVM_DIR)

private fun Project.godotJvmVariantDestinationDir(): File =
    godotJvmDestinationDir().resolve(variantDirectoryName)

private fun Project.libsDir(): File =
    layout.buildDirectory.asFile.get().resolve("libs").resolve(variantDirectoryName)

private fun Project.registerCopyTask(
    name: String,
    description: String,
    dependsOnTasks: List<TaskProvider<out Task>>,
    configureSources: Copy.(File) -> Unit,
): TaskProvider<Copy> {
    return tasks.register(name, Copy::class.java) {
        with(it) {
            group = "godot-jvm-internal"
            this.description = description

            dependsOn(dependsOnTasks)

            val libsDir = libsDir()
            configureSources(libsDir)
            destinationDir = godotJvmVariantDestinationDir()
        }
    }
}

fun Project.createCopyDesktopJarsTask(
    gameJarTasks: List<TaskProvider<ShadowJar>>,
): TaskProvider<Copy> {
    return registerCopyTask(
        name = "copyDesktopJars",
        description = "Internal task! Copies the desktop jars of this variant into the Godot-JVM output directory.",
        dependsOnTasks = gameJarTasks,
    ) {
        from(gameJarTasks)
        from(
            configurations.getByName(GODOT_SINGLE_CONFIGURATION).filter { it.extension == "jar" },
            Action<CopySpec> { it.into(Paths.EXTERNAL_JARS_DIR) },
        )
    }
}

fun Project.createCopyAndroidArtifactsTask(
    dexTasks: List<TaskProvider<out Task>>,
): TaskProvider<Copy> {
    return registerCopyTask(
        name = "copyAndroidArtifacts",
        description = "Internal task! Copies the Android dex artifacts of this variant into the Godot-JVM output directory.",
        dependsOnTasks = dexTasks,
    ) {
        from(dexTasks)
    }
}

fun Project.createCopyGraalArtifactsTask(
    createGraalNativeImageTask: TaskProvider<out Task>,
): TaskProvider<Copy> {
    return registerCopyTask(
        name = "copyGraalArtifacts",
        description = "Internal task! Copies the GraalVM native-image outputs into the Godot-JVM output directory.",
        dependsOnTasks = listOf(createGraalNativeImageTask),
    ) { libsDir ->
        from(provider {
            listOf("dll", "so", "dylib")
                .map { extension -> File(libsDir, "${ArtifactNames.NATIVE_IMAGE_BASE_NAME}.$extension") }
                .filter(File::exists)
        })
    }
}

fun Project.createCopyIOSArtifactsTask(
    createIOSTask: TaskProvider<out Task>,
): TaskProvider<Copy> {
    return registerCopyTask(
        name = "copyIOSArtifacts",
        description = "Internal task! Copies the iOS static library of this variant into the Godot-JVM output directory.",
        dependsOnTasks = listOf(createIOSTask),
    ) { libsDir ->
        from(File(libsDir, ArtifactNames.IOS_STATIC_LIBRARY))
    }
}

fun Project.createCopyIOSJdkTask(
    downloadIOSGraalToolchainTask: TaskProvider<out Task>,
): TaskProvider<Copy> {
    return tasks.register("copyIOSJdk", Copy::class.java) {
        with(it) {
            group = "godot-jvm-internal"
            description = "Internal task! Copies the bundled iOS JDK files into the Godot-JVM output directory."

            dependsOn(downloadIOSGraalToolchainTask)

            from(layout.buildDirectory.dir("libs/${Paths.IOS_DIR}/${Paths.IOS_JDK_DIR}"))
            destinationDir = godotJvmDestinationDir().resolve(Paths.IOS_DIR).resolve(Paths.IOS_JDK_DIR)
        }
    }
}
