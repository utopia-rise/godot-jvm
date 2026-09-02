package godot.gradle.tasks.graal

import godot.gradle.GodotExtension
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider
import org.jetbrains.kotlin.gradle.internal.ensureParentDirsCreated
import java.io.InputStream

fun Project.copyDefaultGraalJniConfigTask(): TaskProvider<out Task> {
    val resourcePath = "godot-jvm-graal-jni-config.json"
    val outputFile = layout.buildDirectory.file("graal/$resourcePath")

    return tasks.register("createDefaultGraalJniConfig") {
        with(it) {
            group = "godot-jvm"
            description =
                "Checks if the default jni config for graalVM native image is present and creates it if it's not"

            outputs.file(outputFile)

            doLast {
                val resource = GodotExtension::class.java.getResource(resourcePath)?.content
                require(resource is InputStream)

                val destinationFile = outputFile.get().asFile
                destinationFile.ensureParentDirsCreated()
                if (destinationFile.exists()) {
                    destinationFile.delete()
                }
                destinationFile.createNewFile()
                resource.copyTo(destinationFile.outputStream())
            }
        }
    }
}
