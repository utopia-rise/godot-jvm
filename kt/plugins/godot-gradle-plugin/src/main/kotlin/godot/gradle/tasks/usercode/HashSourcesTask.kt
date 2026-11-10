package godot.gradle.tasks.usercode

import godot.gradle.tasks.project.isInside
import godot.gradle.tasks.project.shadowingGdIgnore
import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import java.io.File
import java.security.MessageDigest

@CacheableTask
abstract class HashSourcesTask : DefaultTask() {
    @get:InputFiles
    @get:PathSensitive(PathSensitivity.ABSOLUTE)
    abstract val sourceFiles: ConfigurableFileCollection

    @get:Input
    abstract val sourceRootPaths: ListProperty<String>

    @get:Input
    abstract val godotProjectDirPath: Property<String>

    @get:OutputFile
    abstract val sourceHashesFile: RegularFileProperty

    @TaskAction
    fun hash() {
        val godotProjectDir = File(godotProjectDirPath.get())
        val roots = sourceRootPaths.get()
            .map(::File)
            .filter { root -> root.isInside(godotProjectDir) && root.shadowingGdIgnore(godotProjectDir) == null }
        val sources = sourceFiles.files
            .filter { sourceFile -> roots.any(sourceFile::isInside) }
            .associate { sourceFile ->
                val hash = MessageDigest.getInstance("MD5").digest(sourceFile.readBytes())
                sourceFile.resPath(godotProjectDir) to hash.joinToString("") { byte -> "%02x".format(byte) }
            }
            .toSortedMap()

        val rootEntries = roots.map { root -> "\"${root.resPath(godotProjectDir)}/\"" }.sorted().joinToString(", ")
        val sourceEntries = sources.entries.joinToString(",\n") { (path, hash) -> """        "$path": "$hash"""" }
        sourceHashesFile.get().asFile.writeText("{\n    \"roots\": [$rootEntries],\n    \"sources\": {\n$sourceEntries\n    }\n}\n")
    }

    private fun File.resPath(godotProjectDir: File): String =
        "res://${relativeTo(godotProjectDir).invariantSeparatorsPath}".replace("\\", "\\\\").replace("\"", "\\\"")
}
