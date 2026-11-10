package godot.gradle.tasks.ios

import godot.gradle.GodotExtension
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction

abstract class WriteIOSGraalConfigsTask : DefaultTask() {
    @get:OutputDirectory
    abstract val graalDirectory: DirectoryProperty

    @get:Input
    abstract val resourcePaths: ListProperty<String>

    @TaskAction
    fun writeIOSGraalConfigs() {
        val graalDir = graalDirectory.get().asFile
        for (resourcePath in resourcePaths.get()) {
            val destination = graalDir.resolve(resourcePath)
            destination.parentFile.mkdirs()
            requireNotNull(GodotExtension::class.java.getResourceAsStream(resourcePath)).use { input -> destination.outputStream().use(input::copyTo) }
        }
    }
}
