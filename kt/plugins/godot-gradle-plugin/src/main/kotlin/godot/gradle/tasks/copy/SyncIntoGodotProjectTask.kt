package godot.gradle.tasks.copy

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault
import java.io.File

@DisableCachingByDefault(because = "Copying again is cheaper than restoring from the cache, which would also replace the files the editor holds instead of overwriting them in place.")
abstract class SyncIntoGodotProjectTask : DefaultTask() {
    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val sources: ConfigurableFileCollection

    @get:OutputDirectory
    abstract val targetDirectory: DirectoryProperty

    @TaskAction
    fun sync() {
        val target = targetDirectory.get().asFile
        val copied = mutableSetOf<String>()
        sources.asFileTree.visit { details ->
            val destination = target.resolve(details.relativePath.pathString)
            if (details.isDirectory) {
                destination.mkdirs()
            } else {
                details.file.inputStream().use { input -> destination.outputStream().use(input::copyTo) }
            }
            copied += details.relativePath.pathString
        }
        target.walkBottomUp()
            .filter { file -> file != target && file.relativeTo(target).invariantSeparatorsPath !in copied }
            .forEach(File::delete)
    }
}
