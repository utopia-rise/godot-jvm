package godot.gradle.tasks.api

import godot.codegen.generateApiOnlyFrom
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class GenerateCustomApiSourcesTask : DefaultTask() {
    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val sourceJson: RegularFileProperty

    @get:OutputDirectory
    abstract val apiOutputDir: DirectoryProperty

    @TaskAction
    fun generate() {
        val apiOutput = apiOutputDir.get().asFile.also { it.deleteRecursively() }
        generateApiOnlyFrom(sourceJson.get().asFile, apiOutput)
    }
}
