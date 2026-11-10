package godot.gradle.tasks.copy

import org.gradle.api.Project
import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider
import java.io.File

fun Project.registerCopyIntoGodotProject(
    name: String,
    description: String,
    vararg files: Pair<Provider<RegularFile>, File>,
): TaskProvider<CopyIntoGodotProjectTask> = tasks.register(name, CopyIntoGodotProjectTask::class.java) { task ->
    task.group = "godot-jvm-internal"
    task.description = description
    for ((source, target) in files) {
        task.files += objects.newInstance(GodotProjectFile::class.java).also { file ->
            file.source.set(source)
            file.target.set(target)
        }
    }
}

fun Project.registerSyncIntoGodotProject(
    name: String,
    description: String,
    source: Any,
    target: File,
): TaskProvider<SyncIntoGodotProjectTask> = tasks.register(name, SyncIntoGodotProjectTask::class.java) { task ->
    task.group = "godot-jvm-internal"
    task.description = description
    task.sources.from(source)
    task.targetDirectory.set(target)
}
