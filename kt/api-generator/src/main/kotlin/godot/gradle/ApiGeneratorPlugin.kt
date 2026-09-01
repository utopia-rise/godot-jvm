package godot.gradle

import godot.codegen.generateApiFrom
import godot.codegen.generateCoroutine
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction

open class ApiGeneratorPluginExtension(objects: ObjectFactory) {
    var sourceJson = objects.fileProperty()
    var coreOutputDir = objects.directoryProperty()
    var apiOutputDir = objects.directoryProperty()
    var extensionOutputDir = objects.directoryProperty()
    var coroutineOutputDir = objects.directoryProperty()
}

@CacheableTask
abstract class GenerateAPI : DefaultTask() {
    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    val sourceJson = project.objects.fileProperty()

    @get:OutputDirectory
    val coreOutputDir = project.objects.directoryProperty()

    @get:OutputDirectory
    val apiOutputDir = project.objects.directoryProperty()

    @get:OutputDirectory
    val extensionOutputDir = project.objects.directoryProperty()

    @get:OutputDirectory
    val coroutineOutputDir = project.objects.directoryProperty()

    @TaskAction
    fun execute() {
        val coreOutput = coreOutputDir.get().asFile
        coreOutput.deleteRecursively()

        val apiOutput = apiOutputDir.get().asFile
        apiOutput.deleteRecursively()

        val extensionOutput = extensionOutputDir.get().asFile
        extensionOutput.deleteRecursively()

        generateApiFrom(
            sourceJson.get().asFile,
            coreOutput,
            apiOutput,
            extensionOutput
        )

        val coroutineOutput = coroutineOutputDir.get().asFile
        coroutineOutput.deleteRecursively()
        generateCoroutine(coroutineOutput)
    }
}

class ApiGeneratorPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val extension = project.extensions.create("apiGenerator", ApiGeneratorPluginExtension::class.java)
        project.tasks.register("generateAPI", GenerateAPI::class.java) { task ->
            task.sourceJson.set(extension.sourceJson)
            task.coreOutputDir.set(extension.coreOutputDir)
            task.apiOutputDir.set(extension.apiOutputDir)
            task.extensionOutputDir.set(extension.extensionOutputDir)
            task.coroutineOutputDir.set(extension.coroutineOutputDir)

            task.group = "godot-jvm"
            task.description = "Generate Godot's classes from its api."
        }
    }
}
