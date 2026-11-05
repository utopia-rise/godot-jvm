package godot.gradle.tasks.copy

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.Nested
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

abstract class GodotProjectFile {
    @get:InputFile
    @get:PathSensitive(PathSensitivity.NONE)
    abstract val source: RegularFileProperty

    @get:OutputFile
    abstract val target: RegularFileProperty
}

@DisableCachingByDefault(because = "Copying again is cheaper than restoring from the cache, which would also replace the files the editor holds instead of overwriting them in place.")
abstract class CopyIntoGodotProjectTask : DefaultTask() {
    @get:Nested
    val files: MutableList<GodotProjectFile> = mutableListOf()

    @TaskAction
    fun copy() {
        for (file in files) {
            file.source.get().asFile.inputStream().use { input -> file.target.get().asFile.outputStream().use(input::copyTo) }
        }
    }
}
