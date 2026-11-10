package godot.gradle.tasks.project

import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class CheckIgnoredScriptSourcesTask : DefaultTask() {
    @get:Input
    abstract val godotProjectDirPath: Property<String>

    @get:Input
    abstract val sourceRootPaths: ListProperty<String>

    @TaskAction
    fun check() {
        val godotProjectDir = File(godotProjectDirPath.get())

        for (sourceRoot in sourceRootPaths.get().map(::File)) {
            if (!sourceRoot.isDirectory || !sourceRoot.isInside(godotProjectDir)) continue
            val gdIgnore = sourceRoot.shadowingGdIgnore(godotProjectDir) ?: continue
            logger.warn(
                "Godot ignores source root ${sourceRoot.relativeTo(godotProjectDir).invariantSeparatorsPath} " +
                    "because ${gdIgnore.relativeTo(godotProjectDir).invariantSeparatorsPath} shadows it. " +
                    "Scenes cannot load @Script classes from this directory. Remove the .gdignore file."
            )
        }
    }
}

fun File.isInside(directory: File): Boolean =
    toPath().toAbsolutePath().normalize().startsWith(directory.toPath().toAbsolutePath().normalize())

fun File.shadowingGdIgnore(godotProjectDir: File): File? =
    generateSequence(this) { directory -> directory.parentFile.takeIf { directory != godotProjectDir } }
        .map { directory -> directory.resolve(".gdignore") }
        .firstOrNull(File::isFile)
