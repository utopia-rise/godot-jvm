package godot.gradle.tasks.graal.ios

import godot.gradle.GodotExtension
import godot.gradle.tasks.graal.iosJniConfig
import godot.gradle.tasks.graal.iosReflectionConfig
import godot.gradle.tasks.graal.iosResourceConfig
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.provider.ListProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.jetbrains.kotlin.gradle.internal.ensureParentDirsCreated
import java.io.InputStream

abstract class CopyDefaultGraalIOSConfigsTask : DefaultTask() {
    @get:OutputDirectory
    abstract val graalDirectory: DirectoryProperty

    @get:Input
    abstract val resourcePaths: ListProperty<String>

    @TaskAction
    fun copyDefaultGraalIOSConfigs() {
        val graalDir = graalDirectory.get().asFile
        resourcePaths.get().forEach { resourcePath ->
            val resource = GodotExtension::class.java.getResource(resourcePath)?.content
            require(resource is InputStream)

            val destinationFile = graalDir.resolve(resourcePath)
            destinationFile.ensureParentDirsCreated()
            if (destinationFile.exists()) {
                destinationFile.delete()
            }
            destinationFile.createNewFile()
            resource.copyTo(destinationFile.outputStream())
        }
    }
}

fun Project.copyDefaultGraalIOSConfigsTask(
    checkPresenceOfDefaultGraalJniConfigTask: TaskProvider<out Task>,
): TaskProvider<out Task> {
    val resourcePaths = listOf(
        "ios/$iosJniConfig",
        "ios/$iosReflectionConfig",
        "ios/$iosResourceConfig",
    )

    return tasks.register("copyDefaultGraalIOSJniConfig", CopyDefaultGraalIOSConfigsTask::class.java) {
        with(it) {
            group = "godot-jvm"
            description =
                "Checks if the default configs for ios graalVM native image are present and creates them if they're not"

            dependsOn(checkPresenceOfDefaultGraalJniConfigTask)

            graalDirectory.set(layout.buildDirectory.dir("graal"))
            this.resourcePaths.set(resourcePaths)
        }
    }
}
