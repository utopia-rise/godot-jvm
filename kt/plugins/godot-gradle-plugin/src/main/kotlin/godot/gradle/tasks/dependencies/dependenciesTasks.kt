package godot.gradle.tasks.dependencies

import godot.gradle.projectExt.GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION
import godot.gradle.projectExt.godotJvmDirectory
import godot.gradle.tasks.copy.registerSyncIntoGodotProject
import godot.tools.common.constants.ArtifactNames
import godot.tools.common.constants.Paths
import org.gradle.api.Project
import org.gradle.api.file.FileCollection
import org.gradle.api.provider.Provider
import godot.gradle.tasks.copy.SyncIntoGodotProjectTask
import org.gradle.api.tasks.TaskProvider
import java.io.File

fun Project.splitDependencyJars(): FileCollection =
    configurations.getByName(GODOT_SPLIT_RUNTIME_CLASSPATH_CONFIGURATION).filter { file -> file.extension == "jar" }

fun Project.splitDependencyClassPath(): Provider<String> {
    val jars = splitDependencyJars()
    return provider {
        jars.files
            .sortedBy { file -> file.name }
            .joinToString(" ") { file -> "../${Paths.DEPENDENCIES_DIR}/${file.name}" }
    }
}

fun Project.registerSplitDependencySync(): TaskProvider<SyncIntoGodotProjectTask> {
    val jars = splitDependencyJars()
    val writeList = tasks.register("writeSplitDependencyList", WriteSplitDependencyListTask::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Lists the split dependency jars that exports pack."
        task.jarNames.set(provider { jars.files.map(File::getName).sorted() })
        task.listFile.set(layout.buildDirectory.file("generated/split-dependencies/${ArtifactNames.SPLIT_DEPENDENCY_LIST}"))
    }
    return registerSyncIntoGodotProject(
        name = "syncSplitDependencies",
        description = "Syncs the split dependency jars, shared by both build types, and their list into the Godot project.",
        source = files(jars, writeList.flatMap(WriteSplitDependencyListTask::listFile)),
        target = godotJvmDirectory().resolve(Paths.DEPENDENCIES_DIR),
    )
}
