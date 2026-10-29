package godot.gradle.tasks

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import godot.gradle.tasks.registrar_generation.requireConfiguredGodotProjectDirectory
import godot.gradle.projectExt.GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION
import godot.gradle.projectExt.variantDirectoryName
import godot.tools.common.constants.ArtifactNames
import godot.tools.common.constants.Paths
import org.gradle.api.Project
import org.gradle.api.Task
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
    destination: File = godotJvmVariantDestinationDir(),
    cleanBeforeCopy: Boolean = false,
    configureSources: Copy.(File) -> Unit,
): TaskProvider<Copy> {
    return tasks.register(name, Copy::class.java) {
        with(it) {
            group = "godot-jvm-internal"
            this.description = description

            dependsOn(dependsOnTasks)

            val libsDir = libsDir()
            configureSources(libsDir)
            destinationDir = destination
            if (cleanBeforeCopy) {
                doFirst { destination.deleteRecursively() }
            }
        }
    }
}

// One copy task per artifact, so Gradle skips the copy of a reused artifact: the editor reloads every rewritten jar,
// and a reloaded bootstrap jar asks for an editor restart.
private fun Project.registerArtifactCopyTasks(
    artifactTasksByName: Map<String, TaskProvider<out Task>>,
): List<TaskProvider<Copy>> = artifactTasksByName.map { (artifactName, artifactTask) ->
    registerCopyTask(
        name = "copy$artifactName",
        description = "Internal task! Copies the output of ${artifactTask.name} into the Godot-JVM output directory.",
        dependsOnTasks = listOf(artifactTask),
    ) {
        from(artifactTask)
    }
}

private fun Project.registerCopyGroupTask(
    name: String,
    description: String,
    copyTasks: List<TaskProvider<out Task>>,
): TaskProvider<Task> = tasks.register(name) { task ->
    task.group = "godot-jvm-internal"
    task.description = description
    task.dependsOn(copyTasks)
}

fun Project.createCopyDesktopJarsTask(
    gameJarTasksByJarName: Map<String, TaskProvider<ShadowJar>>,
    generateRegistrarFilesTask: TaskProvider<ClassGraphGenerateRegistrarFilesTask>,
): TaskProvider<Task> {
    // Shared by both variants: the editor reads it when the debug jars are missing, so a release build writes it too.
    val copyScriptClassIndexTask = registerCopyTask(
        name = "copyScriptClassIndex",
        description = "Internal task! Copies the script class index into the Godot-JVM output directory.",
        dependsOnTasks = emptyList(),
        destination = godotJvmDestinationDir(),
    ) {
        from(generateRegistrarFilesTask.flatMap { task -> task.scriptClassIndexFile })
    }
    // Emptied first, as only this task writes there: the jar of a dependency the project dropped would stay and ship.
    val copySplitDependenciesTask = registerCopyTask(
        name = "copySplitDependencies",
        description = "Internal task! Copies the split dependency jars into the Godot-JVM output directory.",
        dependsOnTasks = emptyList(),
        destination = godotJvmVariantDestinationDir().resolve(Paths.DEPENDENCIES_DIR),
        cleanBeforeCopy = true,
    ) {
        from(configurations.getByName(GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION).filter { it.extension == "jar" })
    }
    return registerCopyGroupTask(
        name = "copyDesktopJars",
        description = "Internal task! Copies the desktop jars of this variant and the script class index into the Godot-JVM output directory.",
        copyTasks = registerArtifactCopyTasks(gameJarTasksByJarName) + copySplitDependenciesTask + copyScriptClassIndexTask,
    )
}

fun Project.createCopyAndroidArtifactsTask(
    gameDexJarTasksByJarName: Map<String, TaskProvider<out Task>>,
): TaskProvider<Task> {
    return registerCopyGroupTask(
        name = "copyAndroidArtifacts",
        description = "Internal task! Copies the Android dex artifacts of this variant into the Godot-JVM output directory.",
        copyTasks = registerArtifactCopyTasks(gameDexJarTasksByJarName),
    )
}

fun Project.createCopyGraalArtifactsTask(
    createGraalNativeImageTask: TaskProvider<out Task>,
): TaskProvider<Copy> {
    return registerCopyTask(
        name = "copyGraalArtifacts",
        description = "Internal task! Copies the GraalVM native-image outputs into the Godot-JVM output directory.",
        dependsOnTasks = listOf(createGraalNativeImageTask),
    ) {
        from(createGraalNativeImageTask)
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
