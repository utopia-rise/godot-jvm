package godot.gradle.tasks.registration

import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import java.io.File

@CacheableTask
abstract class IndexGdjFilesTask : DefaultTask() {
    @get:Input
    abstract val godotProjectDirPath: Property<String>

    @get:InputFiles
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val existingRegistrationFiles: ConfigurableFileCollection

    @get:OutputFile
    abstract val existingRegistrationFilesIndexFile: RegularFileProperty

    @TaskAction
    fun index() {
        val godotProjectDir = File(godotProjectDirPath.get())
        val pathsByFileName = existingRegistrationFiles.files
            .map { file -> file.relativeTo(godotProjectDir).invariantSeparatorsPath }
            .sorted()
            .groupBy { path -> path.substringAfterLast('/').substringBeforeLast('.') }
            .toSortedMap()
        for ((fileName, paths) in pathsByFileName) {
            for (ignored in paths.drop(1)) {
                logger.warn("Multiple existing registration files share basename $fileName. Keeping ${paths.first()} and ignoring $ignored.")
            }
        }
        existingRegistrationFilesIndexFile.get().asFile.writeText(
            pathsByFileName.entries.joinToString("") { (fileName, paths) -> "$fileName\t${paths.first()}\n" }
        )
    }
}
