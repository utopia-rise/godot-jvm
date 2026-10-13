package godot.gradle.tasks.custom_api

import godot.codegen.generateApiOnlyFrom
import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.projectExt.godotLibraryDependency
import godot.gradle.projectExt.kotlinJvmExtension
import godot.gradle.projectExt.resolvedKotlinBuildVersion
import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.CacheableTask
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Jar

@CacheableTask
abstract class GenerateCustomGodotApiTask : DefaultTask() {
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

fun Project.customApiJarTask(): TaskProvider<Jar> {
    val generatedRoot = layout.buildDirectory.dir("generated/custom-godot-api")
    val generateTask = tasks.register("generateCustomGodotApi", GenerateCustomGodotApiTask::class.java) { task ->
        task.group = "godot-jvm"
        task.description = "Generates custom Godot bindings from the configured API JSON."
        task.sourceJson.set(godotJvmExtension.apiJsonFile)
        task.apiOutputDir.set(generatedRoot.map { it.dir("api") })
    }

    val compilation = kotlinJvmExtension.target.compilations.create("customGodotApi") { compilation ->
        compilation.defaultSourceSet {
            kotlin.srcDir(generatedRoot.map { it.dir("api").asFile })
        }
        compilation.compileTaskProvider.get().dependsOn(generateTask)
    }
    dependencies.add("customGodotApiImplementation", "org.jetbrains.kotlin:kotlin-stdlib:${resolvedKotlinBuildVersion()}")
    dependencies.add("customGodotApiImplementation", godotLibraryDependency("internal"))
    dependencies.add("customGodotApiImplementation", godotLibraryDependency("core"))

    return tasks.register("customGodotApiJar", Jar::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Compiles the generated custom Godot bindings into a reusable jar."
        task.archiveBaseName.set("godot-custom-api")
        task.archiveVersion.set("")
        task.archiveClassifier.set("")
        task.dependsOn(compilation.compileTaskProvider)
        task.from(compilation.output.allOutputs) { spec ->
            spec.include("godot/api/**", "godot/RegisterEngineTypes*", "godot/MethodCalls*", "META-INF/**")
        }
    }.also { customApiJar ->
        dependencies.add("compileOnly", files(customApiJar.flatMap(Jar::getArchiveFile)))
    }
}
