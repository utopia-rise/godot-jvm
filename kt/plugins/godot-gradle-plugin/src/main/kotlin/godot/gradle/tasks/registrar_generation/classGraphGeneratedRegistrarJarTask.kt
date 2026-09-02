package godot.gradle.tasks

import godot.gradle.projectExt.kotlinJvmExtension
import org.gradle.api.Project
import org.gradle.api.file.Directory
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Jar
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinWithJavaCompilation

fun Project.registrarGenerationJarTask(
    generateRegistrarFilesTask: TaskProvider<ClassGraphGenerateRegistrarFilesTask>,
): TaskProvider<Jar> {
    val mainCompilation = kotlinJvmExtension.target.compilations.getByName("main")
    val generatedSourceRootDir = registrarGenerationGeneratedSourceRootDir()
    val generatedRegistrarCompilation = createRegistrarGenerationCompilation(
        mainCompilation = mainCompilation,
        generatedSourceRootDir = generatedSourceRootDir,
        generateRegistrarFilesTask = generateRegistrarFilesTask
    )

    return tasks.register(
        "registrarGenerationJar",
        Jar::class.java
    ) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Compiles generated registrar sources into a reusable jar."

        task.archiveBaseName.set("registrar-generation")
        task.archiveVersion.set("")
        task.archiveClassifier.set("")

        task.dependsOn(generatedRegistrarCompilation.compileTaskProvider)
        task.dependsOn(generateRegistrarFilesTask)

        task.from(generatedRegistrarCompilation.output.allOutputs)
        task.from(generatedSourceRootDir.map { generatedRoot -> generatedRoot.dir("resources") })
    }
}

private fun Project.registrarGenerationGeneratedSourceRootDir(): Provider<Directory> =
    layout.buildDirectory.dir("generated/registrar-generation")

private fun Project.createRegistrarGenerationCompilation(
    mainCompilation: KotlinWithJavaCompilation<*, *>,
    generatedSourceRootDir: Provider<Directory>,
    generateRegistrarFilesTask: TaskProvider<ClassGraphGenerateRegistrarFilesTask>,
): KotlinWithJavaCompilation<*, *> {
    val generatedRegistrarCompilation = kotlinJvmExtension.target.compilations.create("registrarGeneration") { compilation ->
        compilation.defaultSourceSet {
            kotlin.srcDir(generatedSourceRootDir.map { generatedRoot -> generatedRoot.dir("main/kotlin").asFile })
        }

        compilation.compileDependencyFiles += mainCompilation.compileDependencyFiles
        compilation.compileDependencyFiles += mainCompilation.output.allOutputs
        compilation.runtimeDependencyFiles += mainCompilation.runtimeDependencyFiles

        compilation.compileTaskProvider.get().dependsOn(generateRegistrarFilesTask)
        compilation.compileTaskProvider.get().dependsOn(tasks.named("classes"))
    }
    return generatedRegistrarCompilation
}
