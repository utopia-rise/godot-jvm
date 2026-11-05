package godot.gradle.tasks.android

import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

abstract class DexUserCodeTask : D8Task() {
    @get:InputFile
    abstract val userCodeJar: RegularFileProperty

    @get:InputFile
    abstract val bootstrapJar: RegularFileProperty

    // Dexed into the bootstrap dex jar, so only resolved against here.
    @get:InputFiles
    abstract val splitDependencyJars: ConfigurableFileCollection

    @get:OutputFile
    abstract val mainDexRulesFile: RegularFileProperty

    @get:OutputDirectory
    abstract val dexOutputDirectory: DirectoryProperty

    @TaskAction
    fun dexUserCode() {
        val outputDirectory = dexOutputDirectory.get().asFile
        outputDirectory.deleteRecursively()
        outputDirectory.mkdirs()
        val classpathJars = listOf(bootstrapJar.get().asFile) + splitDependencyJars.files.sortedBy { file -> file.name }
        runD8(
            listOf(userCodeJar.get().asFile.absolutePath) + classpathJars.flatMap { file -> listOf("--classpath", file.absolutePath) },
            outputDirectory,
            mainDexRulesFile.get().asFile,
            outputDirectory,
            "the main dex file",
        )
    }
}
