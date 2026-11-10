package godot.gradle.tasks.dependencies

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

@DisableCachingByDefault(because = "Writing a few file names is cheaper than a cache lookup.")
abstract class WriteSplitDependencyListTask : DefaultTask() {
    @get:Input
    abstract val jarNames: ListProperty<String>

    @get:OutputFile
    abstract val listFile: RegularFileProperty

    @TaskAction
    fun write() {
        listFile.get().asFile.writeText(jarNames.get().joinToString("") { name -> "$name\n" })
    }
}
