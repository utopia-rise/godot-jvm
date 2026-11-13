package godot.gradle.tasks.registration

import godot.gradle.projectExt.BuildType
import godot.gradle.projectExt.godotJvmExtension
import godot.gradle.projectExt.kotlinJvmExtension
import godot.gradle.projectExt.requireConfiguredGodotProjectDirectory
import godot.gradle.projectExt.sourceSet
import godot.tools.common.constants.FileExtensions
import godot.tools.common.constants.Paths
import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Jar

class RegistrationTasks(
    val registrarJar: TaskProvider<Jar>,
    val syncRegistrationFiles: TaskProvider<out Task>?,
)

fun Project.registerRegistrationTasks(fastBuild: Boolean): RegistrationTasks {
    val debugSourceSet = sourceSet(BuildType.DEBUG)

    val generate = tasks.register("generateRegistrars", GenerateRegistrarsTask::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Scans the debug classes and generates registrar sources and staged .gdj files."
        task.userCodeClassPathRoots.from(debugSourceSet.output.classesDirs)
        task.runtimeClassPathFiles.from(debugSourceSet.compileClasspath)
        task.runtimeClassPathFiles.from(debugSourceSet.output.classesDirs)
        task.registeredNameMode.set(godotJvmExtension.registration.nameMode)
        task.projectName.set(project.name.replace(" ", "_"))
        task.registrationFileLayoutMode.set(godotJvmExtension.registration.gdjFilesLayoutMode)
        task.registrationFileIndentation.set(godotJvmExtension.registration.gdjFilesIndentation)
        task.disableGdj.set(godotJvmExtension.registration.disableGdj)
        task.annotationProcessingMode.set(godotJvmExtension.registration.annotationProcessingMode)
        task.generatedSourceRootDir.set(layout.buildDirectory.dir("generated/registrar-generation"))
        task.generatedRegistrationFilesRootDir.set(layout.buildDirectory.dir("generated/registrar-generation/registration"))
        task.onlyIf { !fastBuild }
    }

    val syncRegistrationFiles = if (godotJvmExtension.registration.disableGdj.get()) null else registerRegistrationFileSync(generate, fastBuild)

    val compilation = kotlinJvmExtension.target.compilations.create("registrars") { compilation ->
        compilation.defaultSourceSet {
            kotlin.srcDir(generate.flatMap { task -> task.generatedSourceRootDir.dir("main/kotlin") })
        }
        val mainCompilation = kotlinJvmExtension.target.compilations.getByName("main")
        compilation.compileDependencyFiles += mainCompilation.compileDependencyFiles
        compilation.compileDependencyFiles += mainCompilation.output.allOutputs
        compilation.runtimeDependencyFiles += mainCompilation.runtimeDependencyFiles
    }

    val registrarJar = tasks.register("packageRegistrarJar", Jar::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Compiles the generated registrars into one jar shared by both build types."
        task.archiveBaseName.set("registrar-generation")
        task.archiveVersion.set("")
        task.archiveClassifier.set("")
        task.from(compilation.output.allOutputs)
        task.from(generate.flatMap { generateTask -> generateTask.generatedSourceRootDir.dir("resources") })
        task.onlyIf { !fastBuild }
    }

    return RegistrationTasks(registrarJar, syncRegistrationFiles)
}

private fun Project.registerRegistrationFileSync(
    generate: TaskProvider<GenerateRegistrarsTask>,
    fastBuild: Boolean,
): TaskProvider<SyncGdjFilesTask> {
    val godotProjectDir = requireConfiguredGodotProjectDirectory()
    val index = tasks.register("indexGdjFiles", IndexGdjFilesTask::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Indexes existing .gdj files across the Godot project."
        task.godotProjectDirPath.set(godotProjectDir.absolutePath)
        task.existingRegistrationFiles.from(
            fileTree(godotProjectDir).matching { pattern ->
                pattern.include("**/*.${FileExtensions.GodotJvm.registrationFile}")
                pattern.exclude("build/**", "${Paths.GODOT_JVM_DIR}/**", "android/**", ".*/**", "**/.*/**")
            }
        )
        task.existingRegistrationFilesIndexFile.set(layout.buildDirectory.file("intermediates/registrar-generation/existing-registration-files.idx"))
        task.onlyIf { !fastBuild }
    }

    return tasks.register("syncGdjFiles", SyncGdjFilesTask::class.java) { task ->
        task.group = "godot-jvm-internal"
        task.description = "Synchronizes staged generated .gdj files into the Godot project."
        task.dependsOn(generate, index)
        task.generatedRegistrationFilesRootDir.set(generate.flatMap(GenerateRegistrarsTask::generatedRegistrationFilesRootDir))
        task.godotProjectDirPath.set(godotProjectDir.absolutePath)
        task.existingRegistrationFilesIndexFile.set(index.flatMap(IndexGdjFilesTask::existingRegistrationFilesIndexFile))
        task.gdjFilesOutputDir.set(godotJvmExtension.registration.gdjFilesDirectory)
        task.onlyIf { !fastBuild }
    }
}
