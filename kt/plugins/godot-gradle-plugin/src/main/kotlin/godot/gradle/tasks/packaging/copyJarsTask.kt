package godot.gradle.tasks

import godot.gradle.tasks.registrar_generation.requireConfiguredGodotProjectDirectory
import godot.tools.common.constants.Paths
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskProvider
import java.io.File

private fun Project.godotJvmDestinationDir(): File =
    requireConfiguredGodotProjectDirectory().resolve(Paths.GODOT_JVM_DIR)

private fun Project.libsDir(): File =
    layout.buildDirectory.asFile.get().resolve("libs")

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
            destinationDir = godotJvmDestinationDir()
        }
    }
}

fun Project.createCopyDesktopJarsTask(
    packageBootstrapJarTask: TaskProvider<out Task>,
    packageMainJarTask: TaskProvider<out Task>,
): TaskProvider<Copy> {
    return registerCopyTask(
        name = "copyDesktopJars",
        description = "Internal task! Copies the desktop jars into the Godot-JVM output directory.",
        dependsOnTasks = listOf(packageBootstrapJarTask, packageMainJarTask),
    ) { libsDir ->
        from(File(libsDir, "godot-bootstrap.jar"))
        from(File(libsDir, "main.jar"))
    }
}

fun Project.createCopyAndroidArtifactsTask(
    createBootstrapDexJarTask: TaskProvider<out Task>,
    packageMainDexJarTask: TaskProvider<out Task>,
): TaskProvider<Copy> {
    return registerCopyTask(
        name = "copyAndroidArtifacts",
        description = "Internal task! Copies the Android dex artifacts into the Godot-JVM output directory.",
        dependsOnTasks = listOf(createBootstrapDexJarTask, packageMainDexJarTask),
    ) { libsDir ->
        from(File(libsDir, "godot-bootstrap-dex.jar"))
        from(File(libsDir, "main-dex.jar"))
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
            listOf(
                File(libsDir, "usercode.dll"),
                File(libsDir, "usercode.so"),
                File(libsDir, "usercode.dylib"),
            ).filter(File::exists)
        })
    }
}

fun Project.createCopyIOSArtifactsTask(
    createIOSTask: TaskProvider<out Task>,
): TaskProvider<Copy> {
    return tasks.register("copyIOSArtifacts", Copy::class.java) {
        with(it) {
            group = "godot-jvm-internal"
            description =
                "Internal task! Copies the iOS static library and bundled iOS JDK files into the Godot-JVM output directory."

            dependsOn(createIOSTask)

            val libsDir = libsDir()
            val iosLibsDir = libsDir.resolve("ios")
            from(iosLibsDir) {
                include("usercode.a", "ios-jdk/**")
            }
            destinationDir = godotJvmDestinationDir().resolve("ios")
        }
    }
}
