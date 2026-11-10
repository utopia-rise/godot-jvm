package godot.gradle.tasks.graal

import godot.gradle.GodotExtension
import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

@CacheableTask
abstract class WriteGraalJniConfigTask : DefaultTask() {
    @get:Input
    abstract val resourcePath: Property<String>

    @get:OutputFile
    abstract val configFile: RegularFileProperty

    @TaskAction
    fun create() {
        val resource = requireNotNull(GodotExtension::class.java.getResourceAsStream(resourcePath.get()))
        val destination = configFile.get().asFile
        destination.parentFile.mkdirs()
        resource.use { input -> destination.outputStream().use(input::copyTo) }
    }
}
