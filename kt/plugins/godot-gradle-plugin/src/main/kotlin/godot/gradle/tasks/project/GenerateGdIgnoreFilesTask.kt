package godot.gradle.tasks.project

import godot.tools.common.constants.Paths
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

@DisableCachingByDefault(because = "Only creates empty marker files.")
abstract class GenerateGdIgnoreFilesTask : DefaultTask() {
    @get:Internal
    abstract val buildDirectory: DirectoryProperty

    @get:Internal
    abstract val gradleDirectory: DirectoryProperty

    @get:Internal
    abstract val godotJvmDirectory: DirectoryProperty

    @TaskAction
    fun generate() {
        val godotJvm = godotJvmDirectory.get().asFile
        val embeddedJres = godotJvm.listFiles { file -> file.name.startsWith("jre-") }.orEmpty()
        val directories = listOf(buildDirectory.get().asFile, gradleDirectory.get().asFile, godotJvm.resolve(Paths.EDITOR_DIR))
        for (directory in directories + embeddedJres) {
            directory.mkdirs()
            directory.resolve(".gdignore").createNewFile()
        }
    }
}
